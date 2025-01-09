package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ganancias_prorrateos_impl extends GXWebComponent
{
   public ganancias_prorrateos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ganancias_prorrateos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ganancias_prorrateos_impl.class ));
   }

   public ganancias_prorrateos_impl( int remoteHandle ,
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
      chkLiqLegPrimera = UIFactory.getCheckbox(this);
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
               AV58MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58MenuOpcCod", AV58MenuOpcCod);
               AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV58MenuOpcCod,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LegNumero)});
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
      AV75Pgmname = httpContext.GetPar( "Pgmname") ;
      AV58MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV10LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      AV24TFLiqLegConAnio = (short)(GXutil.lval( httpContext.GetPar( "TFLiqLegConAnio"))) ;
      AV25TFLiqLegConAnio_To = (short)(GXutil.lval( httpContext.GetPar( "TFLiqLegConAnio_To"))) ;
      AV27TFConCodigo = httpContext.GetPar( "TFConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV28TFConCodigo_Sels);
      AV51TFLiqAltaNro = (int)(GXutil.lval( httpContext.GetPar( "TFLiqAltaNro"))) ;
      AV52TFLiqAltaNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFLiqAltaNro_To"))) ;
      AV53TFLiqNuevaNro = (int)(GXutil.lval( httpContext.GetPar( "TFLiqNuevaNro"))) ;
      AV54TFLiqNuevaNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFLiqNuevaNro_To"))) ;
      AV29TFLiqLegConSaldo = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegConSaldo"), ".") ;
      AV30TFLiqLegConSaldo_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegConSaldo_To"), ".") ;
      AV31TFLiqLegConPer = localUtil.parseDateParm( httpContext.GetPar( "TFLiqLegConPer")) ;
      AV32TFLiqLegConPer_To = localUtil.parseDateParm( httpContext.GetPar( "TFLiqLegConPer_To")) ;
      AV36TFLiqLegCodigo = (short)(GXutil.lval( httpContext.GetPar( "TFLiqLegCodigo"))) ;
      AV37TFLiqLegCodigo_To = (short)(GXutil.lval( httpContext.GetPar( "TFLiqLegCodigo_To"))) ;
      AV38TFLiqLegCuota = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegCuota"), ".") ;
      AV39TFLiqLegCuota_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegCuota_To"), ".") ;
      AV40TFLiqLegTotal = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegTotal"), ".") ;
      AV41TFLiqLegTotal_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegTotal_To"), ".") ;
      AV42TFLiqLegTotRecal = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegTotRecal"), ".") ;
      AV43TFLiqLegTotRecal_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegTotRecal_To"), ".") ;
      AV16OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV17OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV76Ganancias_prorrateosds_1_clicod = (int)(GXutil.lval( httpContext.GetPar( "Ganancias_prorrateosds_1_clicod"))) ;
      AV77Ganancias_prorrateosds_2_empcod = (short)(GXutil.lval( httpContext.GetPar( "Ganancias_prorrateosds_2_empcod"))) ;
      AV60WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV75Pgmname, AV58MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqLegConAnio, AV25TFLiqLegConAnio_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV51TFLiqAltaNro, AV52TFLiqAltaNro_To, AV53TFLiqNuevaNro, AV54TFLiqNuevaNro_To, AV29TFLiqLegConSaldo, AV30TFLiqLegConSaldo_To, AV31TFLiqLegConPer, AV32TFLiqLegConPer_To, AV36TFLiqLegCodigo, AV37TFLiqLegCodigo_To, AV38TFLiqLegCuota, AV39TFLiqLegCuota_To, AV40TFLiqLegTotal, AV41TFLiqLegTotal_To, AV42TFLiqLegTotRecal, AV43TFLiqLegTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV76Ganancias_prorrateosds_1_clicod, AV77Ganancias_prorrateosds_2_empcod, AV60WelcomeMessage_NoMostrarMas, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paDP2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Ganancias prorrateo de bonos y saldos de pagos a cuenta", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.ganancias_prorrateos", new String[] {GXutil.URLEncode(GXutil.rtrim(AV58MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LegNumero,8,0))}, new String[] {"MenuOpcCod","CliCod","EmpCod","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_67", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_67, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV46GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV47GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV48GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV44DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV44DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQLEGCONPERAUXDATE", localUtil.dtoc( AV33DDO_LiqLegConPerAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQLEGCONPERAUXDATETO", localUtil.dtoc( AV34DDO_LiqLegConPerAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV58MenuOpcCod", wcpOAV58MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV75Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV58MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV10LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCONANIO", GXutil.ltrim( localUtil.ntoc( AV24TFLiqLegConAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCONANIO_TO", GXutil.ltrim( localUtil.ntoc( AV25TFLiqLegConAnio_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCONCODIGO", GXutil.rtrim( AV27TFConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCONCODIGO_SELS", AV28TFConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCONCODIGO_SELS", AV28TFConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQALTANRO", GXutil.ltrim( localUtil.ntoc( AV51TFLiqAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQALTANRO_TO", GXutil.ltrim( localUtil.ntoc( AV52TFLiqAltaNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNUEVANRO", GXutil.ltrim( localUtil.ntoc( AV53TFLiqNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNUEVANRO_TO", GXutil.ltrim( localUtil.ntoc( AV54TFLiqNuevaNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCONSALDO", GXutil.ltrim( localUtil.ntoc( AV29TFLiqLegConSaldo, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCONSALDO_TO", GXutil.ltrim( localUtil.ntoc( AV30TFLiqLegConSaldo_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCONPER", localUtil.dtoc( AV31TFLiqLegConPer, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCONPER_TO", localUtil.dtoc( AV32TFLiqLegConPer_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCODIGO", GXutil.ltrim( localUtil.ntoc( AV36TFLiqLegCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCODIGO_TO", GXutil.ltrim( localUtil.ntoc( AV37TFLiqLegCodigo_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCUOTA", GXutil.ltrim( localUtil.ntoc( AV38TFLiqLegCuota, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGCUOTA_TO", GXutil.ltrim( localUtil.ntoc( AV39TFLiqLegCuota_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGTOTAL", GXutil.ltrim( localUtil.ntoc( AV40TFLiqLegTotal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGTOTAL_TO", GXutil.ltrim( localUtil.ntoc( AV41TFLiqLegTotal_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGTOTRECAL", GXutil.ltrim( localUtil.ntoc( AV42TFLiqLegTotRecal, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGTOTRECAL_TO", GXutil.ltrim( localUtil.ntoc( AV43TFLiqLegTotRecal_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGANANCIAS_PRORRATEOSDS_1_CLICOD", GXutil.ltrim( localUtil.ntoc( AV76Ganancias_prorrateosds_1_clicod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGANANCIAS_PRORRATEOSDS_2_EMPCOD", GXutil.ltrim( localUtil.ntoc( AV77Ganancias_prorrateosds_2_empcod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
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

   public void renderHtmlCloseFormDP2( )
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
      return "ganancias_prorrateos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Ganancias prorrateo de bonos y saldos de pagos a cuenta", "") ;
   }

   public void wbDP0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.ganancias_prorrateos");
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
         wb_table1_9_DP2( true) ;
      }
      else
      {
         wb_table1_9_DP2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_DP2e( boolean wbgen )
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
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV44DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqlegconperauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'" + sPrefix + "',false,'" + sGXsfl_67_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqlegconperauxdatetext_Internalname, AV35DDO_LiqLegConPerAuxDateText, GXutil.rtrim( localUtil.format( AV35DDO_LiqLegConPerAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqlegconperauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ganancias_prorrateos.htm");
         /* User Defined Control */
         ucTfliqlegconper_rangepicker.setProperty("Start Date", AV33DDO_LiqLegConPerAuxDate);
         ucTfliqlegconper_rangepicker.setProperty("End Date", AV34DDO_LiqLegConPerAuxDateTo);
         ucTfliqlegconper_rangepicker.render(context, "wwp.daterangepicker", Tfliqlegconper_rangepicker_Internalname, sPrefix+"TFLIQLEGCONPER_RANGEPICKERContainer");
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

   public void startDP2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Ganancias prorrateo de bonos y saldos de pagos a cuenta", ""), (short)(0)) ;
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
            strupDP0( ) ;
         }
      }
   }

   public void wsDP2( )
   {
      startDP2( ) ;
      evtDP2( ) ;
   }

   public void evtDP2( )
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
                              strupDP0( ) ;
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
                              strupDP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11DP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12DP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13DP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14DP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupDP0( ) ;
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
                              strupDP0( ) ;
                           }
                           nGXsfl_67_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_672( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A869LiqLegConAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqLegConAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           A1097LiqAltaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqAltaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1098LiqNuevaNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNuevaNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A868LiqLegConSaldo = localUtil.ctond( httpContext.cgiGet( edtLiqLegConSaldo_Internalname)) ;
                           A886LiqLegConPer = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqLegConPer_Internalname), 0)) ;
                           n886LiqLegConPer = false ;
                           A888LiqLegCodigo = (short)(localUtil.ctol( httpContext.cgiGet( edtLiqLegCodigo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n888LiqLegCodigo = false ;
                           A889LiqLegPrimera = GXutil.strtobool( httpContext.cgiGet( chkLiqLegPrimera.getInternalname())) ;
                           A1099LiqLegCuota = localUtil.ctond( httpContext.cgiGet( edtLiqLegCuota_Internalname)) ;
                           A1147LiqLegTotal = localUtil.ctond( httpContext.cgiGet( edtLiqLegTotal_Internalname)) ;
                           A1148LiqLegTotRecal = localUtil.ctond( httpContext.cgiGet( edtLiqLegTotRecal_Internalname)) ;
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
                                       e15DP2 ();
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
                                       e16DP2 ();
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
                                       e17DP2 ();
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
                                    strupDP0( ) ;
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

   public void weDP2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormDP2( ) ;
         }
      }
   }

   public void paDP2( )
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
                                 String AV75Pgmname ,
                                 String AV58MenuOpcCod ,
                                 int AV8CliCod ,
                                 short AV9EmpCod ,
                                 int AV10LegNumero ,
                                 short AV24TFLiqLegConAnio ,
                                 short AV25TFLiqLegConAnio_To ,
                                 String AV27TFConCodigo ,
                                 GXSimpleCollection<String> AV28TFConCodigo_Sels ,
                                 int AV51TFLiqAltaNro ,
                                 int AV52TFLiqAltaNro_To ,
                                 int AV53TFLiqNuevaNro ,
                                 int AV54TFLiqNuevaNro_To ,
                                 java.math.BigDecimal AV29TFLiqLegConSaldo ,
                                 java.math.BigDecimal AV30TFLiqLegConSaldo_To ,
                                 java.util.Date AV31TFLiqLegConPer ,
                                 java.util.Date AV32TFLiqLegConPer_To ,
                                 short AV36TFLiqLegCodigo ,
                                 short AV37TFLiqLegCodigo_To ,
                                 java.math.BigDecimal AV38TFLiqLegCuota ,
                                 java.math.BigDecimal AV39TFLiqLegCuota_To ,
                                 java.math.BigDecimal AV40TFLiqLegTotal ,
                                 java.math.BigDecimal AV41TFLiqLegTotal_To ,
                                 java.math.BigDecimal AV42TFLiqLegTotRecal ,
                                 java.math.BigDecimal AV43TFLiqLegTotRecal_To ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 int AV76Ganancias_prorrateosds_1_clicod ,
                                 short AV77Ganancias_prorrateosds_2_empcod ,
                                 boolean AV60WelcomeMessage_NoMostrarMas ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16DP2 ();
      GRID_nCurrentRecord = 0 ;
      rfDP2( ) ;
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
      AV60WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV60WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60WelcomeMessage_NoMostrarMas", AV60WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfDP2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV75Pgmname = "ganancias_prorrateos" ;
      Gx_err = (short)(0) ;
   }

   public void rfDP2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(67) ;
      /* Execute user event: Refresh */
      e16DP2 ();
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
                                              A26ConCodigo ,
                                              AV82Ganancias_prorrateosds_7_tfconcodigo_sels ,
                                              Short.valueOf(AV79Ganancias_prorrateosds_4_tfliqlegconanio) ,
                                              Short.valueOf(AV80Ganancias_prorrateosds_5_tfliqlegconanio_to) ,
                                              Integer.valueOf(AV82Ganancias_prorrateosds_7_tfconcodigo_sels.size()) ,
                                              AV81Ganancias_prorrateosds_6_tfconcodigo ,
                                              Integer.valueOf(AV83Ganancias_prorrateosds_8_tfliqaltanro) ,
                                              Integer.valueOf(AV84Ganancias_prorrateosds_9_tfliqaltanro_to) ,
                                              Integer.valueOf(AV85Ganancias_prorrateosds_10_tfliqnuevanro) ,
                                              Integer.valueOf(AV86Ganancias_prorrateosds_11_tfliqnuevanro_to) ,
                                              AV87Ganancias_prorrateosds_12_tfliqlegconsaldo ,
                                              AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to ,
                                              AV89Ganancias_prorrateosds_14_tfliqlegconper ,
                                              AV90Ganancias_prorrateosds_15_tfliqlegconper_to ,
                                              Short.valueOf(AV91Ganancias_prorrateosds_16_tfliqlegcodigo) ,
                                              Short.valueOf(AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to) ,
                                              AV93Ganancias_prorrateosds_18_tfliqlegcuota ,
                                              AV94Ganancias_prorrateosds_19_tfliqlegcuota_to ,
                                              AV95Ganancias_prorrateosds_20_tfliqlegtotal ,
                                              AV96Ganancias_prorrateosds_21_tfliqlegtotal_to ,
                                              AV97Ganancias_prorrateosds_22_tfliqlegtotrecal ,
                                              AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to ,
                                              Short.valueOf(A869LiqLegConAnio) ,
                                              Integer.valueOf(A1097LiqAltaNro) ,
                                              Integer.valueOf(A1098LiqNuevaNro) ,
                                              A868LiqLegConSaldo ,
                                              A886LiqLegConPer ,
                                              Short.valueOf(A888LiqLegCodigo) ,
                                              A1099LiqLegCuota ,
                                              A1147LiqLegTotal ,
                                              A1148LiqLegTotRecal ,
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              Integer.valueOf(AV78Ganancias_prorrateosds_3_legnumero) ,
                                              Integer.valueOf(AV76Ganancias_prorrateosds_1_clicod) ,
                                              Short.valueOf(AV77Ganancias_prorrateosds_2_empcod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV81Ganancias_prorrateosds_6_tfconcodigo = GXutil.padr( GXutil.rtrim( AV81Ganancias_prorrateosds_6_tfconcodigo), 10, "%") ;
         /* Using cursor H00DP2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV76Ganancias_prorrateosds_1_clicod), Short.valueOf(AV77Ganancias_prorrateosds_2_empcod), Integer.valueOf(AV78Ganancias_prorrateosds_3_legnumero), Short.valueOf(AV79Ganancias_prorrateosds_4_tfliqlegconanio), Short.valueOf(AV80Ganancias_prorrateosds_5_tfliqlegconanio_to), lV81Ganancias_prorrateosds_6_tfconcodigo, Integer.valueOf(AV83Ganancias_prorrateosds_8_tfliqaltanro), Integer.valueOf(AV84Ganancias_prorrateosds_9_tfliqaltanro_to), Integer.valueOf(AV85Ganancias_prorrateosds_10_tfliqnuevanro), Integer.valueOf(AV86Ganancias_prorrateosds_11_tfliqnuevanro_to), AV87Ganancias_prorrateosds_12_tfliqlegconsaldo, AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to, AV89Ganancias_prorrateosds_14_tfliqlegconper, AV90Ganancias_prorrateosds_15_tfliqlegconper_to, Short.valueOf(AV91Ganancias_prorrateosds_16_tfliqlegcodigo), Short.valueOf(AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to), AV93Ganancias_prorrateosds_18_tfliqlegcuota, AV94Ganancias_prorrateosds_19_tfliqlegcuota_to, AV95Ganancias_prorrateosds_20_tfliqlegtotal, AV96Ganancias_prorrateosds_21_tfliqlegtotal_to, AV97Ganancias_prorrateosds_22_tfliqlegtotrecal, AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_67_idx = 1 ;
         sGXsfl_67_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_67_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_672( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1148LiqLegTotRecal = H00DP2_A1148LiqLegTotRecal[0] ;
            A1147LiqLegTotal = H00DP2_A1147LiqLegTotal[0] ;
            A1099LiqLegCuota = H00DP2_A1099LiqLegCuota[0] ;
            A889LiqLegPrimera = H00DP2_A889LiqLegPrimera[0] ;
            A888LiqLegCodigo = H00DP2_A888LiqLegCodigo[0] ;
            n888LiqLegCodigo = H00DP2_n888LiqLegCodigo[0] ;
            A886LiqLegConPer = H00DP2_A886LiqLegConPer[0] ;
            n886LiqLegConPer = H00DP2_n886LiqLegConPer[0] ;
            A868LiqLegConSaldo = H00DP2_A868LiqLegConSaldo[0] ;
            A1098LiqNuevaNro = H00DP2_A1098LiqNuevaNro[0] ;
            A1097LiqAltaNro = H00DP2_A1097LiqAltaNro[0] ;
            A26ConCodigo = H00DP2_A26ConCodigo[0] ;
            A869LiqLegConAnio = H00DP2_A869LiqLegConAnio[0] ;
            A6LegNumero = H00DP2_A6LegNumero[0] ;
            A1EmpCod = H00DP2_A1EmpCod[0] ;
            A3CliCod = H00DP2_A3CliCod[0] ;
            e17DP2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(67) ;
         wbDP0( ) ;
      }
      bGXsfl_67_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesDP2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV75Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75Pgmname, ""))));
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
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV82Ganancias_prorrateosds_7_tfconcodigo_sels ,
                                           Short.valueOf(AV79Ganancias_prorrateosds_4_tfliqlegconanio) ,
                                           Short.valueOf(AV80Ganancias_prorrateosds_5_tfliqlegconanio_to) ,
                                           Integer.valueOf(AV82Ganancias_prorrateosds_7_tfconcodigo_sels.size()) ,
                                           AV81Ganancias_prorrateosds_6_tfconcodigo ,
                                           Integer.valueOf(AV83Ganancias_prorrateosds_8_tfliqaltanro) ,
                                           Integer.valueOf(AV84Ganancias_prorrateosds_9_tfliqaltanro_to) ,
                                           Integer.valueOf(AV85Ganancias_prorrateosds_10_tfliqnuevanro) ,
                                           Integer.valueOf(AV86Ganancias_prorrateosds_11_tfliqnuevanro_to) ,
                                           AV87Ganancias_prorrateosds_12_tfliqlegconsaldo ,
                                           AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to ,
                                           AV89Ganancias_prorrateosds_14_tfliqlegconper ,
                                           AV90Ganancias_prorrateosds_15_tfliqlegconper_to ,
                                           Short.valueOf(AV91Ganancias_prorrateosds_16_tfliqlegcodigo) ,
                                           Short.valueOf(AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to) ,
                                           AV93Ganancias_prorrateosds_18_tfliqlegcuota ,
                                           AV94Ganancias_prorrateosds_19_tfliqlegcuota_to ,
                                           AV95Ganancias_prorrateosds_20_tfliqlegtotal ,
                                           AV96Ganancias_prorrateosds_21_tfliqlegtotal_to ,
                                           AV97Ganancias_prorrateosds_22_tfliqlegtotrecal ,
                                           AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to ,
                                           Short.valueOf(A869LiqLegConAnio) ,
                                           Integer.valueOf(A1097LiqAltaNro) ,
                                           Integer.valueOf(A1098LiqNuevaNro) ,
                                           A868LiqLegConSaldo ,
                                           A886LiqLegConPer ,
                                           Short.valueOf(A888LiqLegCodigo) ,
                                           A1099LiqLegCuota ,
                                           A1147LiqLegTotal ,
                                           A1148LiqLegTotRecal ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV78Ganancias_prorrateosds_3_legnumero) ,
                                           Integer.valueOf(AV76Ganancias_prorrateosds_1_clicod) ,
                                           Short.valueOf(AV77Ganancias_prorrateosds_2_empcod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV81Ganancias_prorrateosds_6_tfconcodigo = GXutil.padr( GXutil.rtrim( AV81Ganancias_prorrateosds_6_tfconcodigo), 10, "%") ;
      /* Using cursor H00DP3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV76Ganancias_prorrateosds_1_clicod), Short.valueOf(AV77Ganancias_prorrateosds_2_empcod), Integer.valueOf(AV78Ganancias_prorrateosds_3_legnumero), Short.valueOf(AV79Ganancias_prorrateosds_4_tfliqlegconanio), Short.valueOf(AV80Ganancias_prorrateosds_5_tfliqlegconanio_to), lV81Ganancias_prorrateosds_6_tfconcodigo, Integer.valueOf(AV83Ganancias_prorrateosds_8_tfliqaltanro), Integer.valueOf(AV84Ganancias_prorrateosds_9_tfliqaltanro_to), Integer.valueOf(AV85Ganancias_prorrateosds_10_tfliqnuevanro), Integer.valueOf(AV86Ganancias_prorrateosds_11_tfliqnuevanro_to), AV87Ganancias_prorrateosds_12_tfliqlegconsaldo, AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to, AV89Ganancias_prorrateosds_14_tfliqlegconper, AV90Ganancias_prorrateosds_15_tfliqlegconper_to, Short.valueOf(AV91Ganancias_prorrateosds_16_tfliqlegcodigo), Short.valueOf(AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to), AV93Ganancias_prorrateosds_18_tfliqlegcuota, AV94Ganancias_prorrateosds_19_tfliqlegcuota_to, AV95Ganancias_prorrateosds_20_tfliqlegtotal, AV96Ganancias_prorrateosds_21_tfliqlegtotal_to, AV97Ganancias_prorrateosds_22_tfliqlegtotrecal, AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to});
      GRID_nRecordCount = H00DP3_AGRID_nRecordCount[0] ;
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
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV75Pgmname, AV58MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqLegConAnio, AV25TFLiqLegConAnio_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV51TFLiqAltaNro, AV52TFLiqAltaNro_To, AV53TFLiqNuevaNro, AV54TFLiqNuevaNro_To, AV29TFLiqLegConSaldo, AV30TFLiqLegConSaldo_To, AV31TFLiqLegConPer, AV32TFLiqLegConPer_To, AV36TFLiqLegCodigo, AV37TFLiqLegCodigo_To, AV38TFLiqLegCuota, AV39TFLiqLegCuota_To, AV40TFLiqLegTotal, AV41TFLiqLegTotal_To, AV42TFLiqLegTotRecal, AV43TFLiqLegTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV76Ganancias_prorrateosds_1_clicod, AV77Ganancias_prorrateosds_2_empcod, AV60WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV75Pgmname, AV58MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqLegConAnio, AV25TFLiqLegConAnio_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV51TFLiqAltaNro, AV52TFLiqAltaNro_To, AV53TFLiqNuevaNro, AV54TFLiqNuevaNro_To, AV29TFLiqLegConSaldo, AV30TFLiqLegConSaldo_To, AV31TFLiqLegConPer, AV32TFLiqLegConPer_To, AV36TFLiqLegCodigo, AV37TFLiqLegCodigo_To, AV38TFLiqLegCuota, AV39TFLiqLegCuota_To, AV40TFLiqLegTotal, AV41TFLiqLegTotal_To, AV42TFLiqLegTotRecal, AV43TFLiqLegTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV76Ganancias_prorrateosds_1_clicod, AV77Ganancias_prorrateosds_2_empcod, AV60WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV75Pgmname, AV58MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqLegConAnio, AV25TFLiqLegConAnio_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV51TFLiqAltaNro, AV52TFLiqAltaNro_To, AV53TFLiqNuevaNro, AV54TFLiqNuevaNro_To, AV29TFLiqLegConSaldo, AV30TFLiqLegConSaldo_To, AV31TFLiqLegConPer, AV32TFLiqLegConPer_To, AV36TFLiqLegCodigo, AV37TFLiqLegCodigo_To, AV38TFLiqLegCuota, AV39TFLiqLegCuota_To, AV40TFLiqLegTotal, AV41TFLiqLegTotal_To, AV42TFLiqLegTotRecal, AV43TFLiqLegTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV76Ganancias_prorrateosds_1_clicod, AV77Ganancias_prorrateosds_2_empcod, AV60WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV75Pgmname, AV58MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqLegConAnio, AV25TFLiqLegConAnio_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV51TFLiqAltaNro, AV52TFLiqAltaNro_To, AV53TFLiqNuevaNro, AV54TFLiqNuevaNro_To, AV29TFLiqLegConSaldo, AV30TFLiqLegConSaldo_To, AV31TFLiqLegConPer, AV32TFLiqLegConPer_To, AV36TFLiqLegCodigo, AV37TFLiqLegCodigo_To, AV38TFLiqLegCuota, AV39TFLiqLegCuota_To, AV40TFLiqLegTotal, AV41TFLiqLegTotal_To, AV42TFLiqLegTotRecal, AV43TFLiqLegTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV76Ganancias_prorrateosds_1_clicod, AV77Ganancias_prorrateosds_2_empcod, AV60WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV75Pgmname, AV58MenuOpcCod, AV8CliCod, AV9EmpCod, AV10LegNumero, AV24TFLiqLegConAnio, AV25TFLiqLegConAnio_To, AV27TFConCodigo, AV28TFConCodigo_Sels, AV51TFLiqAltaNro, AV52TFLiqAltaNro_To, AV53TFLiqNuevaNro, AV54TFLiqNuevaNro_To, AV29TFLiqLegConSaldo, AV30TFLiqLegConSaldo_To, AV31TFLiqLegConPer, AV32TFLiqLegConPer_To, AV36TFLiqLegCodigo, AV37TFLiqLegCodigo_To, AV38TFLiqLegCuota, AV39TFLiqLegCuota_To, AV40TFLiqLegTotal, AV41TFLiqLegTotal_To, AV42TFLiqLegTotRecal, AV43TFLiqLegTotRecal_To, AV16OrderedBy, AV17OrderedDsc, AV76Ganancias_prorrateosds_1_clicod, AV77Ganancias_prorrateosds_2_empcod, AV60WelcomeMessage_NoMostrarMas, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV75Pgmname = "ganancias_prorrateos" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupDP0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15DP2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV44DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_67 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_67"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV46GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV47GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV48GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         AV33DDO_LiqLegConPerAuxDate = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQLEGCONPERAUXDATE"), 0) ;
         AV34DDO_LiqLegConPerAuxDateTo = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQLEGCONPERAUXDATETO"), 0) ;
         wcpOAV58MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV58MenuOpcCod") ;
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
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( sPrefix+"DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( sPrefix+"DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( sPrefix+"DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( sPrefix+"DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistproc") ;
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
         AV66WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV60WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60WelcomeMessage_NoMostrarMas", AV60WelcomeMessage_NoMostrarMas);
         AV35DDO_LiqLegConPerAuxDateText = httpContext.cgiGet( edtavDdo_liqlegconperauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35DDO_LiqLegConPerAuxDateText", AV35DDO_LiqLegConPerAuxDateText);
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
      e15DP2 ();
      if (returnInSub) return;
   }

   public void e15DP2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV58MenuOpcCod, "", "") ;
      this.executeUsercontrolMethod(sPrefix, false, "TFLIQLEGCONPER_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_liqlegconperauxdatetext_Internalname});
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV44DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV44DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char3[0] = AV61MenuBienveImgURL ;
      GXv_char4[0] = AV63MenuBienveTitulo ;
      GXv_char5[0] = AV64MenuBienveTexto ;
      GXv_boolean6[0] = AV65MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV58MenuOpcCod, GXv_char3, GXv_char4, GXv_char5, GXv_boolean6) ;
      ganancias_prorrateos_impl.this.AV61MenuBienveImgURL = GXv_char3[0] ;
      ganancias_prorrateos_impl.this.AV63MenuBienveTitulo = GXv_char4[0] ;
      ganancias_prorrateos_impl.this.AV64MenuBienveTexto = GXv_char5[0] ;
      ganancias_prorrateos_impl.this.AV65MenuBienveVisible = GXv_boolean6[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV65MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV65MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV63MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV64MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV66WelcomeMessage_Foto = AV61MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV66WelcomeMessage_Foto)==0) ? AV74Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV66WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV66WelcomeMessage_Foto), true);
         AV74Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV61MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV66WelcomeMessage_Foto)==0) ? AV74Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV66WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop(sPrefix, false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV66WelcomeMessage_Foto), true);
      }
      GXt_char7 = "" ;
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char5) ;
      ganancias_prorrateos_impl.this.GXt_char8 = GXv_char5[0] ;
      GXv_char4[0] = GXt_char7 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char8, GXv_char4) ;
      ganancias_prorrateos_impl.this.GXt_char7 = GXv_char4[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
   }

   public void e16DP2( )
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
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV46GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46GridCurrentPage), 10, 0));
      AV47GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47GridPageCount), 10, 0));
      GXt_char8 = AV48GridAppliedFilters ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV75Pgmname, GXv_char5) ;
      ganancias_prorrateos_impl.this.GXt_char8 = GXv_char5[0] ;
      AV48GridAppliedFilters = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48GridAppliedFilters", AV48GridAppliedFilters);
      GXt_char8 = AV71MenuOpcTitulo ;
      GXv_char5[0] = GXt_char8 ;
      new web.gettxtcount(remoteHandle, context).execute( AV58MenuOpcCod, GXv_char5) ;
      ganancias_prorrateos_impl.this.GXt_char8 = GXv_char5[0] ;
      AV71MenuOpcTitulo = GXt_char8 ;
      if ( (GXutil.strcmp("", AV71MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV71MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      AV76Ganancias_prorrateosds_1_clicod = AV8CliCod ;
      AV77Ganancias_prorrateosds_2_empcod = AV9EmpCod ;
      AV78Ganancias_prorrateosds_3_legnumero = AV10LegNumero ;
      AV79Ganancias_prorrateosds_4_tfliqlegconanio = AV24TFLiqLegConAnio ;
      AV80Ganancias_prorrateosds_5_tfliqlegconanio_to = AV25TFLiqLegConAnio_To ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = AV27TFConCodigo ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = AV28TFConCodigo_Sels ;
      AV83Ganancias_prorrateosds_8_tfliqaltanro = AV51TFLiqAltaNro ;
      AV84Ganancias_prorrateosds_9_tfliqaltanro_to = AV52TFLiqAltaNro_To ;
      AV85Ganancias_prorrateosds_10_tfliqnuevanro = AV53TFLiqNuevaNro ;
      AV86Ganancias_prorrateosds_11_tfliqnuevanro_to = AV54TFLiqNuevaNro_To ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = AV29TFLiqLegConSaldo ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV30TFLiqLegConSaldo_To ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = AV31TFLiqLegConPer ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = AV32TFLiqLegConPer_To ;
      AV91Ganancias_prorrateosds_16_tfliqlegcodigo = AV36TFLiqLegCodigo ;
      AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV37TFLiqLegCodigo_To ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = AV38TFLiqLegCuota ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = AV39TFLiqLegCuota_To ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = AV40TFLiqLegTotal ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = AV41TFLiqLegTotal_To ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = AV42TFLiqLegTotRecal ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV43TFLiqLegTotRecal_To ;
      /*  Sending Event outputs  */
   }

   public void e11DP2( )
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
         AV45PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV45PageToGo) ;
      }
   }

   public void e12DP2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13DP2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegConAnio") == 0 )
         {
            AV24TFLiqLegConAnio = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24TFLiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFLiqLegConAnio), 4, 0));
            AV25TFLiqLegConAnio_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLiqLegConAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLiqLegConAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConCodigo") == 0 )
         {
            AV27TFConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFConCodigo", AV27TFConCodigo);
            AV26TFConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFConCodigo_SelsJson", AV26TFConCodigo_SelsJson);
            AV28TFConCodigo_Sels.fromJSonString(AV26TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqAltaNro") == 0 )
         {
            AV51TFLiqAltaNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TFLiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51TFLiqAltaNro), 8, 0));
            AV52TFLiqAltaNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TFLiqAltaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFLiqAltaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqNuevaNro") == 0 )
         {
            AV53TFLiqNuevaNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TFLiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFLiqNuevaNro), 8, 0));
            AV54TFLiqNuevaNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TFLiqNuevaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFLiqNuevaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegConSaldo") == 0 )
         {
            AV29TFLiqLegConSaldo = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLiqLegConSaldo", GXutil.ltrimstr( AV29TFLiqLegConSaldo, 14, 2));
            AV30TFLiqLegConSaldo_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLiqLegConSaldo_To", GXutil.ltrimstr( AV30TFLiqLegConSaldo_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegConPer") == 0 )
         {
            AV31TFLiqLegConPer = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLiqLegConPer", localUtil.format(AV31TFLiqLegConPer, "99/99/9999"));
            AV32TFLiqLegConPer_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLiqLegConPer_To", localUtil.format(AV32TFLiqLegConPer_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegCodigo") == 0 )
         {
            AV36TFLiqLegCodigo = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFLiqLegCodigo), 4, 0));
            AV37TFLiqLegCodigo_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLiqLegCodigo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLiqLegCodigo_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegCuota") == 0 )
         {
            AV38TFLiqLegCuota = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLiqLegCuota", GXutil.ltrimstr( AV38TFLiqLegCuota, 14, 2));
            AV39TFLiqLegCuota_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLiqLegCuota_To", GXutil.ltrimstr( AV39TFLiqLegCuota_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegTotal") == 0 )
         {
            AV40TFLiqLegTotal = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLiqLegTotal", GXutil.ltrimstr( AV40TFLiqLegTotal, 14, 2));
            AV41TFLiqLegTotal_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TFLiqLegTotal_To", GXutil.ltrimstr( AV41TFLiqLegTotal_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegTotRecal") == 0 )
         {
            AV42TFLiqLegTotRecal = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFLiqLegTotRecal", GXutil.ltrimstr( AV42TFLiqLegTotRecal, 14, 2));
            AV43TFLiqLegTotRecal_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFLiqLegTotRecal_To", GXutil.ltrimstr( AV43TFLiqLegTotRecal_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV28TFConCodigo_Sels", AV28TFConCodigo_Sels);
   }

   private void e17DP2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
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
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV16OrderedBy, 4, 0))+":"+(AV17OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue(AV75Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV75Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV23Session.getValue(AV75Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV99GXV1 = 1 ;
      while ( AV99GXV1 <= AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV99GXV1));
         if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCONANIO") == 0 )
         {
            AV24TFLiqLegConAnio = (short)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24TFLiqLegConAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24TFLiqLegConAnio), 4, 0));
            AV25TFLiqLegConAnio_To = (short)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLiqLegConAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLiqLegConAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV27TFConCodigo = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFConCodigo", AV27TFConCodigo);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV26TFConCodigo_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFConCodigo_SelsJson", AV26TFConCodigo_SelsJson);
            AV28TFConCodigo_Sels.fromJSonString(AV26TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQALTANRO") == 0 )
         {
            AV51TFLiqAltaNro = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TFLiqAltaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51TFLiqAltaNro), 8, 0));
            AV52TFLiqAltaNro_To = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TFLiqAltaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFLiqAltaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNUEVANRO") == 0 )
         {
            AV53TFLiqNuevaNro = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TFLiqNuevaNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFLiqNuevaNro), 8, 0));
            AV54TFLiqNuevaNro_To = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TFLiqNuevaNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFLiqNuevaNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCONSALDO") == 0 )
         {
            AV29TFLiqLegConSaldo = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLiqLegConSaldo", GXutil.ltrimstr( AV29TFLiqLegConSaldo, 14, 2));
            AV30TFLiqLegConSaldo_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLiqLegConSaldo_To", GXutil.ltrimstr( AV30TFLiqLegConSaldo_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCONPER") == 0 )
         {
            AV31TFLiqLegConPer = localUtil.ctod( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLiqLegConPer", localUtil.format(AV31TFLiqLegConPer, "99/99/9999"));
            AV32TFLiqLegConPer_To = localUtil.ctod( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLiqLegConPer_To", localUtil.format(AV32TFLiqLegConPer_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCODIGO") == 0 )
         {
            AV36TFLiqLegCodigo = (short)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLiqLegCodigo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFLiqLegCodigo), 4, 0));
            AV37TFLiqLegCodigo_To = (short)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLiqLegCodigo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLiqLegCodigo_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCUOTA") == 0 )
         {
            AV38TFLiqLegCuota = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLiqLegCuota", GXutil.ltrimstr( AV38TFLiqLegCuota, 14, 2));
            AV39TFLiqLegCuota_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLiqLegCuota_To", GXutil.ltrimstr( AV39TFLiqLegCuota_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGTOTAL") == 0 )
         {
            AV40TFLiqLegTotal = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLiqLegTotal", GXutil.ltrimstr( AV40TFLiqLegTotal, 14, 2));
            AV41TFLiqLegTotal_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TFLiqLegTotal_To", GXutil.ltrimstr( AV41TFLiqLegTotal_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGTOTRECAL") == 0 )
         {
            AV42TFLiqLegTotRecal = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFLiqLegTotRecal", GXutil.ltrimstr( AV42TFLiqLegTotRecal, 14, 2));
            AV43TFLiqLegTotRecal_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFLiqLegTotRecal_To", GXutil.ltrimstr( AV43TFLiqLegTotRecal_To, 14, 2));
         }
         AV99GXV1 = (int)(AV99GXV1+1) ;
      }
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV28TFConCodigo_Sels.size()==0), AV26TFConCodigo_SelsJson, GXv_char5) ;
      ganancias_prorrateos_impl.this.GXt_char8 = GXv_char5[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char8+"||||||||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char8 = "" ;
      GXv_char5[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV27TFConCodigo)==0), AV27TFConCodigo, GXv_char5) ;
      ganancias_prorrateos_impl.this.GXt_char8 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV24TFLiqLegConAnio) ? "" : GXutil.str( AV24TFLiqLegConAnio, 4, 0))+"|"+GXt_char8+"|"+((0==AV51TFLiqAltaNro) ? "" : GXutil.str( AV51TFLiqAltaNro, 8, 0))+"|"+((0==AV53TFLiqNuevaNro) ? "" : GXutil.str( AV53TFLiqNuevaNro, 8, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFLiqLegConSaldo)==0) ? "" : GXutil.str( AV29TFLiqLegConSaldo, 14, 2))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqLegConPer)) ? "" : localUtil.dtoc( AV31TFLiqLegConPer, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((0==AV36TFLiqLegCodigo) ? "" : GXutil.str( AV36TFLiqLegCodigo, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLiqLegCuota)==0) ? "" : GXutil.str( AV38TFLiqLegCuota, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLiqLegTotal)==0) ? "" : GXutil.str( AV40TFLiqLegTotal, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLiqLegTotRecal)==0) ? "" : GXutil.str( AV42TFLiqLegTotRecal, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV25TFLiqLegConAnio_To) ? "" : GXutil.str( AV25TFLiqLegConAnio_To, 4, 0))+"||"+((0==AV52TFLiqAltaNro_To) ? "" : GXutil.str( AV52TFLiqAltaNro_To, 8, 0))+"|"+((0==AV54TFLiqNuevaNro_To) ? "" : GXutil.str( AV54TFLiqNuevaNro_To, 8, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFLiqLegConSaldo_To)==0) ? "" : GXutil.str( AV30TFLiqLegConSaldo_To, 14, 2))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqLegConPer_To)) ? "" : localUtil.dtoc( AV32TFLiqLegConPer_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+((0==AV37TFLiqLegCodigo_To) ? "" : GXutil.str( AV37TFLiqLegCodigo_To, 4, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLiqLegCuota_To)==0) ? "" : GXutil.str( AV39TFLiqLegCuota_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLiqLegTotal_To)==0) ? "" : GXutil.str( AV41TFLiqLegTotal_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLiqLegTotRecal_To)==0) ? "" : GXutil.str( AV43TFLiqLegTotRecal_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV14GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV14GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV14GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV14GridState.fromxml(AV23Session.getValue(AV75Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGCONANIO", httpContext.getMessage( "Año", ""), !((0==AV24TFLiqLegConAnio)&&(0==AV25TFLiqLegConAnio_To)), (short)(0), GXutil.trim( GXutil.str( AV24TFLiqLegConAnio, 4, 0)), GXutil.trim( GXutil.str( AV25TFLiqLegConAnio_To, 4, 0))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFCONCODIGO", httpContext.getMessage( "Concepto", ""), !(GXutil.strcmp("", AV27TFConCodigo)==0), (short)(0), AV27TFConCodigo, "", !(AV28TFConCodigo_Sels.size()==0), AV28TFConCodigo_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQALTANRO", httpContext.getMessage( "Liquidación de alta", ""), !((0==AV51TFLiqAltaNro)&&(0==AV52TFLiqAltaNro_To)), (short)(0), GXutil.trim( GXutil.str( AV51TFLiqAltaNro, 8, 0)), GXutil.trim( GXutil.str( AV52TFLiqAltaNro_To, 8, 0))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQNUEVANRO", httpContext.getMessage( "Liquidación act.", ""), !((0==AV53TFLiqNuevaNro)&&(0==AV54TFLiqNuevaNro_To)), (short)(0), GXutil.trim( GXutil.str( AV53TFLiqNuevaNro, 8, 0)), GXutil.trim( GXutil.str( AV54TFLiqNuevaNro_To, 8, 0))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGCONSALDO", httpContext.getMessage( "Saldo", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFLiqLegConSaldo)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFLiqLegConSaldo_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV29TFLiqLegConSaldo, 14, 2)), GXutil.trim( GXutil.str( AV30TFLiqLegConSaldo_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGCONPER", httpContext.getMessage( "Periodo", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqLegConPer))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqLegConPer_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV31TFLiqLegConPer, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV32TFLiqLegConPer_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGCODIGO", httpContext.getMessage( "Código", ""), !((0==AV36TFLiqLegCodigo)&&(0==AV37TFLiqLegCodigo_To)), (short)(0), GXutil.trim( GXutil.str( AV36TFLiqLegCodigo, 4, 0)), GXutil.trim( GXutil.str( AV37TFLiqLegCodigo_To, 4, 0))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGCUOTA", httpContext.getMessage( "Cuota", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLiqLegCuota)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLiqLegCuota_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV38TFLiqLegCuota, 14, 2)), GXutil.trim( GXutil.str( AV39TFLiqLegCuota_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGTOTAL", httpContext.getMessage( "Total", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLiqLegTotal)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLiqLegTotal_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV40TFLiqLegTotal, 14, 2)), GXutil.trim( GXutil.str( AV41TFLiqLegTotal_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQLEGTOTRECAL", httpContext.getMessage( "Total Recalculado", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLiqLegTotRecal)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLiqLegTotRecal_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV42TFLiqLegTotRecal, 14, 2)), GXutil.trim( GXutil.str( AV43TFLiqLegTotRecal_To, 14, 2))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      if ( ! (GXutil.strcmp("", AV58MenuOpcCod)==0) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV58MenuOpcCod );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      if ( ! (0==AV8CliCod) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV8CliCod, 6, 0) );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      if ( ! (0==AV9EmpCod) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV9EmpCod, 4, 0) );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      if ( ! (0==AV10LegNumero) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LEGNUMERO" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV10LegNumero, 8, 0) );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      AV14GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV14GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV75Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV75Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LiqLegConceptoCuenta" );
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

   public void S152( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      GXv_SdtWWPColumnsSelector11[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV8CliCod, GXv_SdtWWPColumnsSelector11) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
   }

   public void e14DP2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV60WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean6[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV58MenuOpcCod, GXv_boolean6) ;
         GXv_char5[0] = AV62textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char5) ;
         ganancias_prorrateos_impl.this.AV62textoNoMostrara = GXv_char5[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV62textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean6[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV58MenuOpcCod, GXv_boolean6) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_DP2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_DP2( true) ;
      }
      else
      {
         wb_table2_12_DP2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_DP2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_DP2e( true) ;
      }
      else
      {
         wb_table1_9_DP2e( false) ;
      }
   }

   public void wb_table2_12_DP2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+"e18dp1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_ganancias_prorrateos.htm");
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
         AV66WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV66WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV74Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV66WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV66WelcomeMessage_Foto)==0) ? AV74Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV66WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV66WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ganancias_prorrateos.htm");
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
         wb_table3_30_DP2( true) ;
      }
      else
      {
         wb_table3_30_DP2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_DP2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_DP2( true) ;
      }
      else
      {
         wb_table4_35_DP2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_DP2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV60WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_ganancias_prorrateos.htm");
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
         wb_table5_54_DP2( true) ;
      }
      else
      {
         wb_table5_54_DP2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_DP2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV46GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV47GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV48GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_DP2e( true) ;
      }
      else
      {
         wb_table2_12_DP2e( false) ;
      }
   }

   public void wb_table5_54_DP2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_ganancias_prorrateos.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_ganancias_prorrateos.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_DP2e( true) ;
      }
      else
      {
         wb_table5_54_DP2e( false) ;
      }
   }

   public void wb_table4_35_DP2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_ganancias_prorrateos.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_DP2e( true) ;
      }
      else
      {
         wb_table4_35_DP2e( false) ;
      }
   }

   public void wb_table3_30_DP2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_ganancias_prorrateos.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_DP2e( true) ;
      }
      else
      {
         wb_table3_30_DP2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV58MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58MenuOpcCod", AV58MenuOpcCod);
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
      paDP2( ) ;
      wsDP2( ) ;
      weDP2( ) ;
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
      sCtrlAV58MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV8CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV9EmpCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV10LegNumero = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paDP2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "ganancias_prorrateos", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paDP2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV58MenuOpcCod = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58MenuOpcCod", AV58MenuOpcCod);
         AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
         AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
         AV10LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LegNumero), 8, 0));
      }
      wcpOAV58MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV58MenuOpcCod") ;
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV58MenuOpcCod, wcpOAV58MenuOpcCod) != 0 ) || ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( AV10LegNumero != wcpOAV10LegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOAV58MenuOpcCod = AV58MenuOpcCod ;
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV10LegNumero = AV10LegNumero ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV58MenuOpcCod = httpContext.cgiGet( sPrefix+"AV58MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV58MenuOpcCod) > 0 )
      {
         AV58MenuOpcCod = httpContext.cgiGet( sCtrlAV58MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58MenuOpcCod", AV58MenuOpcCod);
      }
      else
      {
         AV58MenuOpcCod = httpContext.cgiGet( sPrefix+"AV58MenuOpcCod_PARM") ;
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
      paDP2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsDP2( ) ;
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
      wsDP2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV58MenuOpcCod_PARM", AV58MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV58MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV58MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV58MenuOpcCod));
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
      weDP2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020758", true, true);
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
      httpContext.AddJavascriptSource("ganancias_prorrateos.js", "?2024122020758", false, true);
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
      edtLiqLegConAnio_Internalname = sPrefix+"LIQLEGCONANIO_"+sGXsfl_67_idx ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO_"+sGXsfl_67_idx ;
      edtLiqAltaNro_Internalname = sPrefix+"LIQALTANRO_"+sGXsfl_67_idx ;
      edtLiqNuevaNro_Internalname = sPrefix+"LIQNUEVANRO_"+sGXsfl_67_idx ;
      edtLiqLegConSaldo_Internalname = sPrefix+"LIQLEGCONSALDO_"+sGXsfl_67_idx ;
      edtLiqLegConPer_Internalname = sPrefix+"LIQLEGCONPER_"+sGXsfl_67_idx ;
      edtLiqLegCodigo_Internalname = sPrefix+"LIQLEGCODIGO_"+sGXsfl_67_idx ;
      chkLiqLegPrimera.setInternalname( sPrefix+"LIQLEGPRIMERA_"+sGXsfl_67_idx );
      edtLiqLegCuota_Internalname = sPrefix+"LIQLEGCUOTA_"+sGXsfl_67_idx ;
      edtLiqLegTotal_Internalname = sPrefix+"LIQLEGTOTAL_"+sGXsfl_67_idx ;
      edtLiqLegTotRecal_Internalname = sPrefix+"LIQLEGTOTRECAL_"+sGXsfl_67_idx ;
   }

   public void subsflControlProps_fel_672( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_67_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_67_fel_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_67_fel_idx ;
      edtLiqLegConAnio_Internalname = sPrefix+"LIQLEGCONANIO_"+sGXsfl_67_fel_idx ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO_"+sGXsfl_67_fel_idx ;
      edtLiqAltaNro_Internalname = sPrefix+"LIQALTANRO_"+sGXsfl_67_fel_idx ;
      edtLiqNuevaNro_Internalname = sPrefix+"LIQNUEVANRO_"+sGXsfl_67_fel_idx ;
      edtLiqLegConSaldo_Internalname = sPrefix+"LIQLEGCONSALDO_"+sGXsfl_67_fel_idx ;
      edtLiqLegConPer_Internalname = sPrefix+"LIQLEGCONPER_"+sGXsfl_67_fel_idx ;
      edtLiqLegCodigo_Internalname = sPrefix+"LIQLEGCODIGO_"+sGXsfl_67_fel_idx ;
      chkLiqLegPrimera.setInternalname( sPrefix+"LIQLEGPRIMERA_"+sGXsfl_67_fel_idx );
      edtLiqLegCuota_Internalname = sPrefix+"LIQLEGCUOTA_"+sGXsfl_67_fel_idx ;
      edtLiqLegTotal_Internalname = sPrefix+"LIQLEGTOTAL_"+sGXsfl_67_fel_idx ;
      edtLiqLegTotRecal_Internalname = sPrefix+"LIQLEGTOTRECAL_"+sGXsfl_67_fel_idx ;
   }

   public void sendrow_672( )
   {
      subsflControlProps_672( ) ;
      wbDP0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegConAnio_Internalname,GXutil.ltrim( localUtil.ntoc( A869LiqLegConAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A869LiqLegConAnio), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegConAnio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Anio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqAltaNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1097LiqAltaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1097LiqAltaNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqAltaNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNuevaNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1098LiqNuevaNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1098LiqNuevaNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqNuevaNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegConSaldo_Internalname,GXutil.ltrim( localUtil.ntoc( A868LiqLegConSaldo, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A868LiqLegConSaldo, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegConSaldo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegConPer_Internalname,localUtil.format(A886LiqLegConPer, "99/99/9999"),localUtil.format( A886LiqLegConPer, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegConPer_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegCodigo_Internalname,GXutil.ltrim( localUtil.ntoc( A888LiqLegCodigo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A888LiqLegCodigo), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "LIQLEGPRIMERA_" + sGXsfl_67_idx ;
         chkLiqLegPrimera.setName( GXCCtl );
         chkLiqLegPrimera.setWebtags( "" );
         chkLiqLegPrimera.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkLiqLegPrimera.getInternalname(), "TitleCaption", chkLiqLegPrimera.getCaption(), !bGXsfl_67_Refreshing);
         chkLiqLegPrimera.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkLiqLegPrimera.getInternalname(),GXutil.booltostr( A889LiqLegPrimera),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegCuota_Internalname,GXutil.ltrim( localUtil.ntoc( A1099LiqLegCuota, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1099LiqLegCuota, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegCuota_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A1147LiqLegTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1147LiqLegTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegTotal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegTotRecal_Internalname,GXutil.ltrim( localUtil.ntoc( A1148LiqLegTotRecal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1148LiqLegTotRecal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegTotRecal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(67),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesDP2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidación de alta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidación act.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Saldo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Leg Primera", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cuota", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total Recalculado", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A869LiqLegConAnio, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A26ConCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1097LiqAltaNro, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1098LiqNuevaNro, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A868LiqLegConSaldo, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A886LiqLegConPer, "99/99/9999"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A888LiqLegCodigo, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A889LiqLegPrimera));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1099LiqLegCuota, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1147LiqLegTotal, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1148LiqLegTotRecal, (byte)(17), (byte)(2), ".", "")));
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
      edtLiqLegConAnio_Internalname = sPrefix+"LIQLEGCONANIO" ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
      edtLiqAltaNro_Internalname = sPrefix+"LIQALTANRO" ;
      edtLiqNuevaNro_Internalname = sPrefix+"LIQNUEVANRO" ;
      edtLiqLegConSaldo_Internalname = sPrefix+"LIQLEGCONSALDO" ;
      edtLiqLegConPer_Internalname = sPrefix+"LIQLEGCONPER" ;
      edtLiqLegCodigo_Internalname = sPrefix+"LIQLEGCODIGO" ;
      chkLiqLegPrimera.setInternalname( sPrefix+"LIQLEGPRIMERA" );
      edtLiqLegCuota_Internalname = sPrefix+"LIQLEGCUOTA" ;
      edtLiqLegTotal_Internalname = sPrefix+"LIQLEGTOTAL" ;
      edtLiqLegTotRecal_Internalname = sPrefix+"LIQLEGTOTRECAL" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = sPrefix+"TABLEPADDING" ;
      tblTablemainfix_Internalname = sPrefix+"TABLEMAINFIX" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      edtavDdo_liqlegconperauxdatetext_Internalname = sPrefix+"vDDO_LIQLEGCONPERAUXDATETEXT" ;
      Tfliqlegconper_rangepicker_Internalname = sPrefix+"TFLIQLEGCONPER_RANGEPICKER" ;
      divDdo_liqlegconperauxdates_Internalname = sPrefix+"DDO_LIQLEGCONPERAUXDATES" ;
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
      edtLiqLegTotRecal_Jsonclick = "" ;
      edtLiqLegTotal_Jsonclick = "" ;
      edtLiqLegCuota_Jsonclick = "" ;
      chkLiqLegPrimera.setCaption( "" );
      edtLiqLegCodigo_Jsonclick = "" ;
      edtLiqLegConPer_Jsonclick = "" ;
      edtLiqLegConSaldo_Jsonclick = "" ;
      edtLiqNuevaNro_Jsonclick = "" ;
      edtLiqAltaNro_Jsonclick = "" ;
      edtConCodigo_Jsonclick = "" ;
      edtLiqLegConAnio_Jsonclick = "" ;
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
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_liqlegconperauxdatetext_Jsonclick = "" ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0||8.0|8.0|-14.2||4.0|-14.2|-14.2|-14.2" ;
      Ddo_grid_Datalistproc = "ganancias_prorrateosGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "|T||||||||" ;
      Ddo_grid_Datalisttype = "|Dynamic||||||||" ;
      Ddo_grid_Includedatalist = "|T||||||||" ;
      Ddo_grid_Filterisrange = "T||T|T|T|P|T|T|T|T" ;
      Ddo_grid_Filtertype = "Numeric|Character|Numeric|Numeric|Numeric|Date|Numeric|Numeric|Numeric|Numeric" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10" ;
      Ddo_grid_Columnids = "3:LiqLegConAnio|4:ConCodigo|5:LiqAltaNro|6:LiqNuevaNro|7:LiqLegConSaldo|8:LiqLegConPer|9:LiqLegCodigo|11:LiqLegCuota|12:LiqLegTotal|13:LiqLegTotRecal" ;
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
      GXCCtl = "LIQLEGPRIMERA_" + sGXsfl_67_idx ;
      chkLiqLegPrimera.setName( GXCCtl );
      chkLiqLegPrimera.setWebtags( "" );
      chkLiqLegPrimera.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkLiqLegPrimera.getInternalname(), "TitleCaption", chkLiqLegPrimera.getCaption(), !bGXsfl_67_Refreshing);
      chkLiqLegPrimera.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV76Ganancias_prorrateosds_1_clicod',fld:'vGANANCIAS_PRORRATEOSDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV77Ganancias_prorrateosds_2_empcod',fld:'vGANANCIAS_PRORRATEOSDS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqLegConAnio',fld:'vTFLIQLEGCONANIO',pic:'ZZZ9'},{av:'AV25TFLiqLegConAnio_To',fld:'vTFLIQLEGCONANIO_TO',pic:'ZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV51TFLiqAltaNro',fld:'vTFLIQALTANRO',pic:'ZZZZZZZ9'},{av:'AV52TFLiqAltaNro_To',fld:'vTFLIQALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV53TFLiqNuevaNro',fld:'vTFLIQNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV54TFLiqNuevaNro_To',fld:'vTFLIQNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV29TFLiqLegConSaldo',fld:'vTFLIQLEGCONSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV30TFLiqLegConSaldo_To',fld:'vTFLIQLEGCONSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31TFLiqLegConPer',fld:'vTFLIQLEGCONPER',pic:''},{av:'AV32TFLiqLegConPer_To',fld:'vTFLIQLEGCONPER_TO',pic:''},{av:'AV36TFLiqLegCodigo',fld:'vTFLIQLEGCODIGO',pic:'ZZZ9'},{av:'AV37TFLiqLegCodigo_To',fld:'vTFLIQLEGCODIGO_TO',pic:'ZZZ9'},{av:'AV38TFLiqLegCuota',fld:'vTFLIQLEGCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqLegCuota_To',fld:'vTFLIQLEGCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqLegTotal',fld:'vTFLIQLEGTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41TFLiqLegTotal_To',fld:'vTFLIQLEGTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV42TFLiqLegTotRecal',fld:'vTFLIQLEGTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV43TFLiqLegTotRecal_To',fld:'vTFLIQLEGTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV60WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV46GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV47GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV48GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11DP2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqLegConAnio',fld:'vTFLIQLEGCONANIO',pic:'ZZZ9'},{av:'AV25TFLiqLegConAnio_To',fld:'vTFLIQLEGCONANIO_TO',pic:'ZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV51TFLiqAltaNro',fld:'vTFLIQALTANRO',pic:'ZZZZZZZ9'},{av:'AV52TFLiqAltaNro_To',fld:'vTFLIQALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV53TFLiqNuevaNro',fld:'vTFLIQNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV54TFLiqNuevaNro_To',fld:'vTFLIQNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV29TFLiqLegConSaldo',fld:'vTFLIQLEGCONSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV30TFLiqLegConSaldo_To',fld:'vTFLIQLEGCONSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31TFLiqLegConPer',fld:'vTFLIQLEGCONPER',pic:''},{av:'AV32TFLiqLegConPer_To',fld:'vTFLIQLEGCONPER_TO',pic:''},{av:'AV36TFLiqLegCodigo',fld:'vTFLIQLEGCODIGO',pic:'ZZZ9'},{av:'AV37TFLiqLegCodigo_To',fld:'vTFLIQLEGCODIGO_TO',pic:'ZZZ9'},{av:'AV38TFLiqLegCuota',fld:'vTFLIQLEGCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqLegCuota_To',fld:'vTFLIQLEGCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqLegTotal',fld:'vTFLIQLEGTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41TFLiqLegTotal_To',fld:'vTFLIQLEGTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV42TFLiqLegTotRecal',fld:'vTFLIQLEGTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV43TFLiqLegTotRecal_To',fld:'vTFLIQLEGTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76Ganancias_prorrateosds_1_clicod',fld:'vGANANCIAS_PRORRATEOSDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV77Ganancias_prorrateosds_2_empcod',fld:'vGANANCIAS_PRORRATEOSDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV60WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12DP2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqLegConAnio',fld:'vTFLIQLEGCONANIO',pic:'ZZZ9'},{av:'AV25TFLiqLegConAnio_To',fld:'vTFLIQLEGCONANIO_TO',pic:'ZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV51TFLiqAltaNro',fld:'vTFLIQALTANRO',pic:'ZZZZZZZ9'},{av:'AV52TFLiqAltaNro_To',fld:'vTFLIQALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV53TFLiqNuevaNro',fld:'vTFLIQNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV54TFLiqNuevaNro_To',fld:'vTFLIQNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV29TFLiqLegConSaldo',fld:'vTFLIQLEGCONSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV30TFLiqLegConSaldo_To',fld:'vTFLIQLEGCONSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31TFLiqLegConPer',fld:'vTFLIQLEGCONPER',pic:''},{av:'AV32TFLiqLegConPer_To',fld:'vTFLIQLEGCONPER_TO',pic:''},{av:'AV36TFLiqLegCodigo',fld:'vTFLIQLEGCODIGO',pic:'ZZZ9'},{av:'AV37TFLiqLegCodigo_To',fld:'vTFLIQLEGCODIGO_TO',pic:'ZZZ9'},{av:'AV38TFLiqLegCuota',fld:'vTFLIQLEGCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqLegCuota_To',fld:'vTFLIQLEGCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqLegTotal',fld:'vTFLIQLEGTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41TFLiqLegTotal_To',fld:'vTFLIQLEGTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV42TFLiqLegTotRecal',fld:'vTFLIQLEGTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV43TFLiqLegTotRecal_To',fld:'vTFLIQLEGTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76Ganancias_prorrateosds_1_clicod',fld:'vGANANCIAS_PRORRATEOSDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV77Ganancias_prorrateosds_2_empcod',fld:'vGANANCIAS_PRORRATEOSDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV60WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13DP2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV75Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV24TFLiqLegConAnio',fld:'vTFLIQLEGCONANIO',pic:'ZZZ9'},{av:'AV25TFLiqLegConAnio_To',fld:'vTFLIQLEGCONANIO_TO',pic:'ZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV51TFLiqAltaNro',fld:'vTFLIQALTANRO',pic:'ZZZZZZZ9'},{av:'AV52TFLiqAltaNro_To',fld:'vTFLIQALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV53TFLiqNuevaNro',fld:'vTFLIQNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV54TFLiqNuevaNro_To',fld:'vTFLIQNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV29TFLiqLegConSaldo',fld:'vTFLIQLEGCONSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV30TFLiqLegConSaldo_To',fld:'vTFLIQLEGCONSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31TFLiqLegConPer',fld:'vTFLIQLEGCONPER',pic:''},{av:'AV32TFLiqLegConPer_To',fld:'vTFLIQLEGCONPER_TO',pic:''},{av:'AV36TFLiqLegCodigo',fld:'vTFLIQLEGCODIGO',pic:'ZZZ9'},{av:'AV37TFLiqLegCodigo_To',fld:'vTFLIQLEGCODIGO_TO',pic:'ZZZ9'},{av:'AV38TFLiqLegCuota',fld:'vTFLIQLEGCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqLegCuota_To',fld:'vTFLIQLEGCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqLegTotal',fld:'vTFLIQLEGTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41TFLiqLegTotal_To',fld:'vTFLIQLEGTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV42TFLiqLegTotRecal',fld:'vTFLIQLEGTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV43TFLiqLegTotRecal_To',fld:'vTFLIQLEGTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76Ganancias_prorrateosds_1_clicod',fld:'vGANANCIAS_PRORRATEOSDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV77Ganancias_prorrateosds_2_empcod',fld:'vGANANCIAS_PRORRATEOSDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV60WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV42TFLiqLegTotRecal',fld:'vTFLIQLEGTOTRECAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV43TFLiqLegTotRecal_To',fld:'vTFLIQLEGTOTRECAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLiqLegTotal',fld:'vTFLIQLEGTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41TFLiqLegTotal_To',fld:'vTFLIQLEGTOTAL_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV38TFLiqLegCuota',fld:'vTFLIQLEGCUOTA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV39TFLiqLegCuota_To',fld:'vTFLIQLEGCUOTA_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV36TFLiqLegCodigo',fld:'vTFLIQLEGCODIGO',pic:'ZZZ9'},{av:'AV37TFLiqLegCodigo_To',fld:'vTFLIQLEGCODIGO_TO',pic:'ZZZ9'},{av:'AV31TFLiqLegConPer',fld:'vTFLIQLEGCONPER',pic:''},{av:'AV32TFLiqLegConPer_To',fld:'vTFLIQLEGCONPER_TO',pic:''},{av:'AV29TFLiqLegConSaldo',fld:'vTFLIQLEGCONSALDO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV30TFLiqLegConSaldo_To',fld:'vTFLIQLEGCONSALDO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqNuevaNro',fld:'vTFLIQNUEVANRO',pic:'ZZZZZZZ9'},{av:'AV54TFLiqNuevaNro_To',fld:'vTFLIQNUEVANRO_TO',pic:'ZZZZZZZ9'},{av:'AV51TFLiqAltaNro',fld:'vTFLIQALTANRO',pic:'ZZZZZZZ9'},{av:'AV52TFLiqAltaNro_To',fld:'vTFLIQALTANRO_TO',pic:'ZZZZZZZ9'},{av:'AV27TFConCodigo',fld:'vTFCONCODIGO',pic:''},{av:'AV26TFConCodigo_SelsJson',fld:'vTFCONCODIGO_SELSJSON',pic:''},{av:'AV28TFConCodigo_Sels',fld:'vTFCONCODIGO_SELS',pic:''},{av:'AV24TFLiqLegConAnio',fld:'vTFLIQLEGCONANIO',pic:'ZZZ9'},{av:'AV25TFLiqLegConAnio_To',fld:'vTFLIQLEGCONANIO_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17DP2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e14DP2',iparms:[{av:'AV60WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV58MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e18DP1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'valid_Liqlegtotrecal',iparms:[]");
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
      wcpOAV58MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV58MenuOpcCod = "" ;
      AV75Pgmname = "" ;
      AV27TFConCodigo = "" ;
      AV28TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29TFLiqLegConSaldo = DecimalUtil.ZERO ;
      AV30TFLiqLegConSaldo_To = DecimalUtil.ZERO ;
      AV31TFLiqLegConPer = GXutil.nullDate() ;
      AV32TFLiqLegConPer_To = GXutil.nullDate() ;
      AV38TFLiqLegCuota = DecimalUtil.ZERO ;
      AV39TFLiqLegCuota_To = DecimalUtil.ZERO ;
      AV40TFLiqLegTotal = DecimalUtil.ZERO ;
      AV41TFLiqLegTotal_To = DecimalUtil.ZERO ;
      AV42TFLiqLegTotRecal = DecimalUtil.ZERO ;
      AV43TFLiqLegTotRecal_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV48GridAppliedFilters = "" ;
      AV44DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV33DDO_LiqLegConPerAuxDate = GXutil.nullDate() ;
      AV34DDO_LiqLegConPerAuxDateTo = GXutil.nullDate() ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV35DDO_LiqLegConPerAuxDateText = "" ;
      ucTfliqlegconper_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A26ConCodigo = "" ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      A886LiqLegConPer = GXutil.nullDate() ;
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      A1147LiqLegTotal = DecimalUtil.ZERO ;
      A1148LiqLegTotRecal = DecimalUtil.ZERO ;
      AV82Ganancias_prorrateosds_7_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV81Ganancias_prorrateosds_6_tfconcodigo = "" ;
      AV81Ganancias_prorrateosds_6_tfconcodigo = "" ;
      AV87Ganancias_prorrateosds_12_tfliqlegconsaldo = DecimalUtil.ZERO ;
      AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to = DecimalUtil.ZERO ;
      AV89Ganancias_prorrateosds_14_tfliqlegconper = GXutil.nullDate() ;
      AV90Ganancias_prorrateosds_15_tfliqlegconper_to = GXutil.nullDate() ;
      AV93Ganancias_prorrateosds_18_tfliqlegcuota = DecimalUtil.ZERO ;
      AV94Ganancias_prorrateosds_19_tfliqlegcuota_to = DecimalUtil.ZERO ;
      AV95Ganancias_prorrateosds_20_tfliqlegtotal = DecimalUtil.ZERO ;
      AV96Ganancias_prorrateosds_21_tfliqlegtotal_to = DecimalUtil.ZERO ;
      AV97Ganancias_prorrateosds_22_tfliqlegtotrecal = DecimalUtil.ZERO ;
      AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to = DecimalUtil.ZERO ;
      H00DP2_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DP2_A1147LiqLegTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DP2_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DP2_A889LiqLegPrimera = new boolean[] {false} ;
      H00DP2_A888LiqLegCodigo = new short[1] ;
      H00DP2_n888LiqLegCodigo = new boolean[] {false} ;
      H00DP2_A886LiqLegConPer = new java.util.Date[] {GXutil.nullDate()} ;
      H00DP2_n886LiqLegConPer = new boolean[] {false} ;
      H00DP2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00DP2_A1098LiqNuevaNro = new int[1] ;
      H00DP2_A1097LiqAltaNro = new int[1] ;
      H00DP2_A26ConCodigo = new String[] {""} ;
      H00DP2_A869LiqLegConAnio = new short[1] ;
      H00DP2_A6LegNumero = new int[1] ;
      H00DP2_A1EmpCod = new short[1] ;
      H00DP2_A3CliCod = new int[1] ;
      H00DP3_AGRID_nRecordCount = new long[1] ;
      AV66WelcomeMessage_Foto = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV61MenuBienveImgURL = "" ;
      GXv_char3 = new String[1] ;
      AV63MenuBienveTitulo = "" ;
      AV64MenuBienveTexto = "" ;
      AV74Welcomemessage_foto_GXI = "" ;
      GXt_char7 = "" ;
      GXv_char4 = new String[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext9 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV71MenuOpcTitulo = "" ;
      AV26TFConCodigo_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV23Session = httpContext.getWebSession();
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char8 = "" ;
      GXv_SdtWWPGridState10 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV62textoNoMostrara = "" ;
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
      sCtrlAV58MenuOpcCod = "" ;
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV10LegNumero = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ganancias_prorrateos__default(),
         new Object[] {
             new Object[] {
            H00DP2_A1148LiqLegTotRecal, H00DP2_A1147LiqLegTotal, H00DP2_A1099LiqLegCuota, H00DP2_A889LiqLegPrimera, H00DP2_A888LiqLegCodigo, H00DP2_n888LiqLegCodigo, H00DP2_A886LiqLegConPer, H00DP2_n886LiqLegConPer, H00DP2_A868LiqLegConSaldo, H00DP2_A1098LiqNuevaNro,
            H00DP2_A1097LiqAltaNro, H00DP2_A26ConCodigo, H00DP2_A869LiqLegConAnio, H00DP2_A6LegNumero, H00DP2_A1EmpCod, H00DP2_A3CliCod
            }
            , new Object[] {
            H00DP3_AGRID_nRecordCount
            }
         }
      );
      AV75Pgmname = "ganancias_prorrateos" ;
      /* GeneXus formulas. */
      AV75Pgmname = "ganancias_prorrateos" ;
      Gx_err = (short)(0) ;
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
   private short AV24TFLiqLegConAnio ;
   private short AV25TFLiqLegConAnio_To ;
   private short AV36TFLiqLegCodigo ;
   private short AV37TFLiqLegCodigo_To ;
   private short AV16OrderedBy ;
   private short AV77Ganancias_prorrateosds_2_empcod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A869LiqLegConAnio ;
   private short A888LiqLegCodigo ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV79Ganancias_prorrateosds_4_tfliqlegconanio ;
   private short AV80Ganancias_prorrateosds_5_tfliqlegconanio_to ;
   private short AV91Ganancias_prorrateosds_16_tfliqlegcodigo ;
   private short AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to ;
   private int wcpOAV8CliCod ;
   private int wcpOAV10LegNumero ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_67 ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int nGXsfl_67_idx=1 ;
   private int AV51TFLiqAltaNro ;
   private int AV52TFLiqAltaNro_To ;
   private int AV53TFLiqNuevaNro ;
   private int AV54TFLiqNuevaNro_To ;
   private int AV76Ganancias_prorrateosds_1_clicod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A1097LiqAltaNro ;
   private int A1098LiqNuevaNro ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size ;
   private int AV83Ganancias_prorrateosds_8_tfliqaltanro ;
   private int AV84Ganancias_prorrateosds_9_tfliqaltanro_to ;
   private int AV85Ganancias_prorrateosds_10_tfliqnuevanro ;
   private int AV86Ganancias_prorrateosds_11_tfliqnuevanro_to ;
   private int AV78Ganancias_prorrateosds_3_legnumero ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int lblCouttext_Visible ;
   private int AV45PageToGo ;
   private int AV99GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV46GridCurrentPage ;
   private long AV47GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV29TFLiqLegConSaldo ;
   private java.math.BigDecimal AV30TFLiqLegConSaldo_To ;
   private java.math.BigDecimal AV38TFLiqLegCuota ;
   private java.math.BigDecimal AV39TFLiqLegCuota_To ;
   private java.math.BigDecimal AV40TFLiqLegTotal ;
   private java.math.BigDecimal AV41TFLiqLegTotal_To ;
   private java.math.BigDecimal AV42TFLiqLegTotRecal ;
   private java.math.BigDecimal AV43TFLiqLegTotRecal_To ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private java.math.BigDecimal A1099LiqLegCuota ;
   private java.math.BigDecimal A1147LiqLegTotal ;
   private java.math.BigDecimal A1148LiqLegTotRecal ;
   private java.math.BigDecimal AV87Ganancias_prorrateosds_12_tfliqlegconsaldo ;
   private java.math.BigDecimal AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to ;
   private java.math.BigDecimal AV93Ganancias_prorrateosds_18_tfliqlegcuota ;
   private java.math.BigDecimal AV94Ganancias_prorrateosds_19_tfliqlegcuota_to ;
   private java.math.BigDecimal AV95Ganancias_prorrateosds_20_tfliqlegtotal ;
   private java.math.BigDecimal AV96Ganancias_prorrateosds_21_tfliqlegtotal_to ;
   private java.math.BigDecimal AV97Ganancias_prorrateosds_22_tfliqlegtotrecal ;
   private java.math.BigDecimal AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to ;
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
   private String AV75Pgmname ;
   private String AV27TFConCodigo ;
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
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistproc ;
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
   private String divDdo_liqlegconperauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_liqlegconperauxdatetext_Internalname ;
   private String edtavDdo_liqlegconperauxdatetext_Jsonclick ;
   private String Tfliqlegconper_rangepicker_Internalname ;
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
   private String edtLiqLegConAnio_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String edtLiqAltaNro_Internalname ;
   private String edtLiqNuevaNro_Internalname ;
   private String edtLiqLegConSaldo_Internalname ;
   private String edtLiqLegConPer_Internalname ;
   private String edtLiqLegCodigo_Internalname ;
   private String edtLiqLegCuota_Internalname ;
   private String edtLiqLegTotal_Internalname ;
   private String edtLiqLegTotRecal_Internalname ;
   private String scmdbuf ;
   private String lV81Ganancias_prorrateosds_6_tfconcodigo ;
   private String AV81Ganancias_prorrateosds_6_tfconcodigo ;
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
   private String GXt_char8 ;
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
   private String sCtrlAV58MenuOpcCod ;
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
   private String edtLiqLegConAnio_Jsonclick ;
   private String edtConCodigo_Jsonclick ;
   private String edtLiqAltaNro_Jsonclick ;
   private String edtLiqNuevaNro_Jsonclick ;
   private String edtLiqLegConSaldo_Jsonclick ;
   private String edtLiqLegConPer_Jsonclick ;
   private String edtLiqLegCodigo_Jsonclick ;
   private String GXCCtl ;
   private String edtLiqLegCuota_Jsonclick ;
   private String edtLiqLegTotal_Jsonclick ;
   private String edtLiqLegTotRecal_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV31TFLiqLegConPer ;
   private java.util.Date AV32TFLiqLegConPer_To ;
   private java.util.Date AV33DDO_LiqLegConPerAuxDate ;
   private java.util.Date AV34DDO_LiqLegConPerAuxDateTo ;
   private java.util.Date A886LiqLegConPer ;
   private java.util.Date AV89Ganancias_prorrateosds_14_tfliqlegconper ;
   private java.util.Date AV90Ganancias_prorrateosds_15_tfliqlegconper_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17OrderedDsc ;
   private boolean AV60WelcomeMessage_NoMostrarMas ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n886LiqLegConPer ;
   private boolean n888LiqLegCodigo ;
   private boolean A889LiqLegPrimera ;
   private boolean bGXsfl_67_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV65MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean6[] ;
   private boolean AV66WelcomeMessage_Foto_IsBlob ;
   private String AV64MenuBienveTexto ;
   private String AV26TFConCodigo_SelsJson ;
   private String AV62textoNoMostrara ;
   private String wcpOAV58MenuOpcCod ;
   private String AV58MenuOpcCod ;
   private String AV48GridAppliedFilters ;
   private String AV35DDO_LiqLegConPerAuxDateText ;
   private String AV61MenuBienveImgURL ;
   private String AV63MenuBienveTitulo ;
   private String AV74Welcomemessage_foto_GXI ;
   private String AV71MenuOpcTitulo ;
   private String AV66WelcomeMessage_Foto ;
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
   private com.genexus.webpanels.GXUserControl ucTfliqlegconper_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private GXSimpleCollection<String> AV82Ganancias_prorrateosds_7_tfconcodigo_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkLiqLegPrimera ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H00DP2_A1148LiqLegTotRecal ;
   private java.math.BigDecimal[] H00DP2_A1147LiqLegTotal ;
   private java.math.BigDecimal[] H00DP2_A1099LiqLegCuota ;
   private boolean[] H00DP2_A889LiqLegPrimera ;
   private short[] H00DP2_A888LiqLegCodigo ;
   private boolean[] H00DP2_n888LiqLegCodigo ;
   private java.util.Date[] H00DP2_A886LiqLegConPer ;
   private boolean[] H00DP2_n886LiqLegConPer ;
   private java.math.BigDecimal[] H00DP2_A868LiqLegConSaldo ;
   private int[] H00DP2_A1098LiqNuevaNro ;
   private int[] H00DP2_A1097LiqAltaNro ;
   private String[] H00DP2_A26ConCodigo ;
   private short[] H00DP2_A869LiqLegConAnio ;
   private int[] H00DP2_A6LegNumero ;
   private short[] H00DP2_A1EmpCod ;
   private int[] H00DP2_A3CliCod ;
   private long[] H00DP3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV28TFConCodigo_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext9[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState10[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV15GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV44DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class ganancias_prorrateos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00DP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV82Ganancias_prorrateosds_7_tfconcodigo_sels ,
                                          short AV79Ganancias_prorrateosds_4_tfliqlegconanio ,
                                          short AV80Ganancias_prorrateosds_5_tfliqlegconanio_to ,
                                          int AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size ,
                                          String AV81Ganancias_prorrateosds_6_tfconcodigo ,
                                          int AV83Ganancias_prorrateosds_8_tfliqaltanro ,
                                          int AV84Ganancias_prorrateosds_9_tfliqaltanro_to ,
                                          int AV85Ganancias_prorrateosds_10_tfliqnuevanro ,
                                          int AV86Ganancias_prorrateosds_11_tfliqnuevanro_to ,
                                          java.math.BigDecimal AV87Ganancias_prorrateosds_12_tfliqlegconsaldo ,
                                          java.math.BigDecimal AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to ,
                                          java.util.Date AV89Ganancias_prorrateosds_14_tfliqlegconper ,
                                          java.util.Date AV90Ganancias_prorrateosds_15_tfliqlegconper_to ,
                                          short AV91Ganancias_prorrateosds_16_tfliqlegcodigo ,
                                          short AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to ,
                                          java.math.BigDecimal AV93Ganancias_prorrateosds_18_tfliqlegcuota ,
                                          java.math.BigDecimal AV94Ganancias_prorrateosds_19_tfliqlegcuota_to ,
                                          java.math.BigDecimal AV95Ganancias_prorrateosds_20_tfliqlegtotal ,
                                          java.math.BigDecimal AV96Ganancias_prorrateosds_21_tfliqlegtotal_to ,
                                          java.math.BigDecimal AV97Ganancias_prorrateosds_22_tfliqlegtotrecal ,
                                          java.math.BigDecimal AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to ,
                                          short A869LiqLegConAnio ,
                                          int A1097LiqAltaNro ,
                                          int A1098LiqNuevaNro ,
                                          java.math.BigDecimal A868LiqLegConSaldo ,
                                          java.util.Date A886LiqLegConPer ,
                                          short A888LiqLegCodigo ,
                                          java.math.BigDecimal A1099LiqLegCuota ,
                                          java.math.BigDecimal A1147LiqLegTotal ,
                                          java.math.BigDecimal A1148LiqLegTotRecal ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int A6LegNumero ,
                                          int AV78Ganancias_prorrateosds_3_legnumero ,
                                          int AV76Ganancias_prorrateosds_1_clicod ,
                                          short AV77Ganancias_prorrateosds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[25];
      Object[] GXv_Object13 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " LiqLegTotRecal, LiqLegTotal, LiqLegCuota, LiqLegPrimera, LiqLegCodigo, LiqLegConPer, LiqLegConSaldo, LiqNuevaNro, LiqAltaNro, ConCodigo, LiqLegConAnio, LegNumero," ;
      sSelectString += " EmpCod, CliCod" ;
      sFromString = " FROM LiqLegConceptoCuenta" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegNumero = ?)");
      if ( ! (0==AV79Ganancias_prorrateosds_4_tfliqlegconanio) )
      {
         addWhere(sWhereString, "(LiqLegConAnio >= ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( ! (0==AV80Ganancias_prorrateosds_5_tfliqlegconanio_to) )
      {
         addWhere(sWhereString, "(LiqLegConAnio <= ?)");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( ( AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Ganancias_prorrateosds_6_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Ganancias_prorrateosds_7_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ! (0==AV83Ganancias_prorrateosds_8_tfliqaltanro) )
      {
         addWhere(sWhereString, "(LiqAltaNro >= ?)");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( ! (0==AV84Ganancias_prorrateosds_9_tfliqaltanro_to) )
      {
         addWhere(sWhereString, "(LiqAltaNro <= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! (0==AV85Ganancias_prorrateosds_10_tfliqnuevanro) )
      {
         addWhere(sWhereString, "(LiqNuevaNro >= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ! (0==AV86Ganancias_prorrateosds_11_tfliqnuevanro_to) )
      {
         addWhere(sWhereString, "(LiqNuevaNro <= ?)");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Ganancias_prorrateosds_12_tfliqlegconsaldo)==0) )
      {
         addWhere(sWhereString, "(LiqLegConSaldo >= ?)");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegConSaldo <= ?)");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV89Ganancias_prorrateosds_14_tfliqlegconper)) )
      {
         addWhere(sWhereString, "(LiqLegConPer >= ?)");
      }
      else
      {
         GXv_int12[12] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Ganancias_prorrateosds_15_tfliqlegconper_to)) )
      {
         addWhere(sWhereString, "(LiqLegConPer <= ?)");
      }
      else
      {
         GXv_int12[13] = (byte)(1) ;
      }
      if ( ! (0==AV91Ganancias_prorrateosds_16_tfliqlegcodigo) )
      {
         addWhere(sWhereString, "(LiqLegCodigo >= ?)");
      }
      else
      {
         GXv_int12[14] = (byte)(1) ;
      }
      if ( ! (0==AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to) )
      {
         addWhere(sWhereString, "(LiqLegCodigo <= ?)");
      }
      else
      {
         GXv_int12[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Ganancias_prorrateosds_18_tfliqlegcuota)==0) )
      {
         addWhere(sWhereString, "(LiqLegCuota >= ?)");
      }
      else
      {
         GXv_int12[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Ganancias_prorrateosds_19_tfliqlegcuota_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegCuota <= ?)");
      }
      else
      {
         GXv_int12[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV95Ganancias_prorrateosds_20_tfliqlegtotal)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotal >= ?)");
      }
      else
      {
         GXv_int12[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV96Ganancias_prorrateosds_21_tfliqlegtotal_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotal <= ?)");
      }
      else
      {
         GXv_int12[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV97Ganancias_prorrateosds_22_tfliqlegtotrecal)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotRecal >= ?)");
      }
      else
      {
         GXv_int12[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotRecal <= ?)");
      }
      else
      {
         GXv_int12[21] = (byte)(1) ;
      }
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegConAnio DESC, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, ConCodigo, LiqLegConAnio, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, ConCodigo DESC, LiqLegConAnio, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqAltaNro, LiqLegConAnio, ConCodigo, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqAltaNro DESC, LiqLegConAnio, ConCodigo, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqNuevaNro, LiqLegConAnio, ConCodigo, LiqAltaNro" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqNuevaNro DESC, LiqLegConAnio, ConCodigo, LiqAltaNro" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegConSaldo, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegConSaldo DESC, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegConPer, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegConPer DESC, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegCodigo, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegCodigo DESC, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegCuota, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegCuota DESC, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 9 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegTotal, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 9 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegTotal DESC, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 10 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LegNumero, LiqLegTotRecal, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( ( AV16OrderedBy == 10 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, LiqLegTotRecal DESC, LiqLegConAnio, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_H00DP3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV82Ganancias_prorrateosds_7_tfconcodigo_sels ,
                                          short AV79Ganancias_prorrateosds_4_tfliqlegconanio ,
                                          short AV80Ganancias_prorrateosds_5_tfliqlegconanio_to ,
                                          int AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size ,
                                          String AV81Ganancias_prorrateosds_6_tfconcodigo ,
                                          int AV83Ganancias_prorrateosds_8_tfliqaltanro ,
                                          int AV84Ganancias_prorrateosds_9_tfliqaltanro_to ,
                                          int AV85Ganancias_prorrateosds_10_tfliqnuevanro ,
                                          int AV86Ganancias_prorrateosds_11_tfliqnuevanro_to ,
                                          java.math.BigDecimal AV87Ganancias_prorrateosds_12_tfliqlegconsaldo ,
                                          java.math.BigDecimal AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to ,
                                          java.util.Date AV89Ganancias_prorrateosds_14_tfliqlegconper ,
                                          java.util.Date AV90Ganancias_prorrateosds_15_tfliqlegconper_to ,
                                          short AV91Ganancias_prorrateosds_16_tfliqlegcodigo ,
                                          short AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to ,
                                          java.math.BigDecimal AV93Ganancias_prorrateosds_18_tfliqlegcuota ,
                                          java.math.BigDecimal AV94Ganancias_prorrateosds_19_tfliqlegcuota_to ,
                                          java.math.BigDecimal AV95Ganancias_prorrateosds_20_tfliqlegtotal ,
                                          java.math.BigDecimal AV96Ganancias_prorrateosds_21_tfliqlegtotal_to ,
                                          java.math.BigDecimal AV97Ganancias_prorrateosds_22_tfliqlegtotrecal ,
                                          java.math.BigDecimal AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to ,
                                          short A869LiqLegConAnio ,
                                          int A1097LiqAltaNro ,
                                          int A1098LiqNuevaNro ,
                                          java.math.BigDecimal A868LiqLegConSaldo ,
                                          java.util.Date A886LiqLegConPer ,
                                          short A888LiqLegCodigo ,
                                          java.math.BigDecimal A1099LiqLegCuota ,
                                          java.math.BigDecimal A1147LiqLegTotal ,
                                          java.math.BigDecimal A1148LiqLegTotRecal ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int A6LegNumero ,
                                          int AV78Ganancias_prorrateosds_3_legnumero ,
                                          int AV76Ganancias_prorrateosds_1_clicod ,
                                          short AV77Ganancias_prorrateosds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[22];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LiqLegConceptoCuenta" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegNumero = ?)");
      if ( ! (0==AV79Ganancias_prorrateosds_4_tfliqlegconanio) )
      {
         addWhere(sWhereString, "(LiqLegConAnio >= ?)");
      }
      else
      {
         GXv_int15[3] = (byte)(1) ;
      }
      if ( ! (0==AV80Ganancias_prorrateosds_5_tfliqlegconanio_to) )
      {
         addWhere(sWhereString, "(LiqLegConAnio <= ?)");
      }
      else
      {
         GXv_int15[4] = (byte)(1) ;
      }
      if ( ( AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Ganancias_prorrateosds_6_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( AV82Ganancias_prorrateosds_7_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Ganancias_prorrateosds_7_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ! (0==AV83Ganancias_prorrateosds_8_tfliqaltanro) )
      {
         addWhere(sWhereString, "(LiqAltaNro >= ?)");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      if ( ! (0==AV84Ganancias_prorrateosds_9_tfliqaltanro_to) )
      {
         addWhere(sWhereString, "(LiqAltaNro <= ?)");
      }
      else
      {
         GXv_int15[7] = (byte)(1) ;
      }
      if ( ! (0==AV85Ganancias_prorrateosds_10_tfliqnuevanro) )
      {
         addWhere(sWhereString, "(LiqNuevaNro >= ?)");
      }
      else
      {
         GXv_int15[8] = (byte)(1) ;
      }
      if ( ! (0==AV86Ganancias_prorrateosds_11_tfliqnuevanro_to) )
      {
         addWhere(sWhereString, "(LiqNuevaNro <= ?)");
      }
      else
      {
         GXv_int15[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Ganancias_prorrateosds_12_tfliqlegconsaldo)==0) )
      {
         addWhere(sWhereString, "(LiqLegConSaldo >= ?)");
      }
      else
      {
         GXv_int15[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Ganancias_prorrateosds_13_tfliqlegconsaldo_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegConSaldo <= ?)");
      }
      else
      {
         GXv_int15[11] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV89Ganancias_prorrateosds_14_tfliqlegconper)) )
      {
         addWhere(sWhereString, "(LiqLegConPer >= ?)");
      }
      else
      {
         GXv_int15[12] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV90Ganancias_prorrateosds_15_tfliqlegconper_to)) )
      {
         addWhere(sWhereString, "(LiqLegConPer <= ?)");
      }
      else
      {
         GXv_int15[13] = (byte)(1) ;
      }
      if ( ! (0==AV91Ganancias_prorrateosds_16_tfliqlegcodigo) )
      {
         addWhere(sWhereString, "(LiqLegCodigo >= ?)");
      }
      else
      {
         GXv_int15[14] = (byte)(1) ;
      }
      if ( ! (0==AV92Ganancias_prorrateosds_17_tfliqlegcodigo_to) )
      {
         addWhere(sWhereString, "(LiqLegCodigo <= ?)");
      }
      else
      {
         GXv_int15[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Ganancias_prorrateosds_18_tfliqlegcuota)==0) )
      {
         addWhere(sWhereString, "(LiqLegCuota >= ?)");
      }
      else
      {
         GXv_int15[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Ganancias_prorrateosds_19_tfliqlegcuota_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegCuota <= ?)");
      }
      else
      {
         GXv_int15[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV95Ganancias_prorrateosds_20_tfliqlegtotal)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotal >= ?)");
      }
      else
      {
         GXv_int15[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV96Ganancias_prorrateosds_21_tfliqlegtotal_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotal <= ?)");
      }
      else
      {
         GXv_int15[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV97Ganancias_prorrateosds_22_tfliqlegtotrecal)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotRecal >= ?)");
      }
      else
      {
         GXv_int15[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV98Ganancias_prorrateosds_23_tfliqlegtotrecal_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotRecal <= ?)");
      }
      else
      {
         GXv_int15[21] = (byte)(1) ;
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
      else if ( ( AV16OrderedBy == 8 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 9 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 9 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 10 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 10 ) && ( AV17OrderedDsc ) )
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
                  return conditional_H00DP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() );
            case 1 :
                  return conditional_H00DP3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Boolean) dynConstraints[32]).booleanValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).intValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).intValue() , ((Number) dynConstraints[38]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00DP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00DP3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((int[]) buf[13])[0] = rslt.getInt(12);
               ((short[]) buf[14])[0] = rslt.getShort(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
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
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[30], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[32]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[34]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[37]);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[38]);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[44], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[45], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[46], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[48]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[49]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[34]);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[35]);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               return;
      }
   }

}

