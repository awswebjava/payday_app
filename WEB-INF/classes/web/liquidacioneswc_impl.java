package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacioneswc_impl extends GXWebComponent
{
   public liquidacioneswc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacioneswc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacioneswc_impl.class ));
   }

   public liquidacioneswc_impl( int remoteHandle ,
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
      dynTLiqCod = new HTMLChoice();
      cmbLiqClase = new HTMLChoice();
      cmbLiqModTra = new HTMLChoice();
      cmbLiqFrecPag = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
               AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               AV11LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV11LegNumero)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"TLIQCOD") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlatliqcodK02( ) ;
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
               gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
      nRC_GXsfl_22 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_22"))) ;
      nGXsfl_22_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_22_idx"))) ;
      sGXsfl_22_idx = httpContext.GetPar( "sGXsfl_22_idx") ;
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
      AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV11LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV26ColumnsSelector);
      AV87Pgmname = httpContext.GetPar( "Pgmname") ;
      AV17OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV18OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV29TFLiqNro = (int)(GXutil.lval( httpContext.GetPar( "TFLiqNro"))) ;
      AV30TFLiqNro_To = (int)(GXutil.lval( httpContext.GetPar( "TFLiqNro_To"))) ;
      AV31TFLiqFecha = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecha")) ;
      AV32TFLiqFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecha_To")) ;
      AV37TFLiqPerPalabra = httpContext.GetPar( "TFLiqPerPalabra") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38TFLiqPerPalabra_Sels);
      AV40TFLiqNombre = httpContext.GetPar( "TFLiqNombre") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV41TFLiqNombre_Sels);
      AV42TFLiqFecPago = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecPago")) ;
      AV43TFLiqFecPago_To = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecPago_To")) ;
      AV48TFTLiqCod = httpContext.GetPar( "TFTLiqCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV49TFTLiqCod_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV82TFLiqModTra_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV84TFLiqFrecPag_Sels);
      AV52TFLiqLegImpBasico = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpBasico"), ".") ;
      AV53TFLiqLegImpBasico_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpBasico_To"), ".") ;
      AV54TFLiqLegImpTotBruto = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruto"), ".") ;
      AV55TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruto_To"), ".") ;
      AV56TFLiqLegImpTotBruProm = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruProm"), ".") ;
      AV57TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruProm_To"), ".") ;
      AV58TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruSinSAC"), ".") ;
      AV59TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotBruSinSAC_To"), ".") ;
      AV60TFLiqLegImpTotRetGan = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotRetGan"), ".") ;
      AV61TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqLegImpTotRetGan_To"), ".") ;
      AV73TotLiqLegImpTotBruto = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqLegImpTotBruto"), ".") ;
      AV75TotLiqLegImpTotDescu = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqLegImpTotDescu"), ".") ;
      AV77TotLiqLegImpTotRetGan = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqLegImpTotRetGan"), ".") ;
      AV79TotLiqLegImpTotal = CommonUtil.decimalVal( httpContext.GetPar( "TotLiqLegImpTotal"), ".") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV11LegNumero, AV26ColumnsSelector, AV87Pgmname, AV17OrderedBy, AV18OrderedDsc, AV29TFLiqNro, AV30TFLiqNro_To, AV31TFLiqFecha, AV32TFLiqFecha_To, AV37TFLiqPerPalabra, AV38TFLiqPerPalabra_Sels, AV40TFLiqNombre, AV41TFLiqNombre_Sels, AV42TFLiqFecPago, AV43TFLiqFecPago_To, AV48TFTLiqCod, AV49TFTLiqCod_Sels, AV82TFLiqModTra_Sels, AV84TFLiqFrecPag_Sels, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, AV73TotLiqLegImpTotBruto, AV75TotLiqLegImpTotDescu, AV77TotLiqLegImpTotRetGan, AV79TotLiqLegImpTotal, A3CliCod, A6LegNumero, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paK02( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "liquidaciones WC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacioneswc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LegNumero,8,0))}, new String[] {"CliCod","EmpCod","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTBRUTO", getSecureSignedToken( sPrefix, localUtil.format( AV73TotLiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTDESCU", getSecureSignedToken( sPrefix, localUtil.format( AV75TotLiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTRETGAN", getSecureSignedToken( sPrefix, localUtil.format( AV77TotLiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTAL", getSecureSignedToken( sPrefix, localUtil.format( AV79TotLiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"liquidacionesWC");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      forbiddenHiddens.add("LegNumero", localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("liquidacioneswc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_22", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_22, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV66GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV67GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV68GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV62DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV62DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLUMNSSELECTOR", AV26ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLUMNSSELECTOR", AV26ColumnsSelector);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECHAAUXDATE", localUtil.dtoc( AV33DDO_LiqFechaAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECHAAUXDATETO", localUtil.dtoc( AV34DDO_LiqFechaAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECPAGOAUXDATE", localUtil.dtoc( AV44DDO_LiqFecPagoAuxDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDDO_LIQFECPAGOAUXDATETO", localUtil.dtoc( AV45DDO_LiqFecPagoAuxDateTo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV11LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV87Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV17OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV18OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNRO", GXutil.ltrim( localUtil.ntoc( AV29TFLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNRO_TO", GXutil.ltrim( localUtil.ntoc( AV30TFLiqNro_To, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECHA", localUtil.dtoc( AV31TFLiqFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECHA_TO", localUtil.dtoc( AV32TFLiqFecha_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQPERPALABRA", GXutil.rtrim( AV37TFLiqPerPalabra));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQPERPALABRA_SELS", AV38TFLiqPerPalabra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQPERPALABRA_SELS", AV38TFLiqPerPalabra_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQNOMBRE", AV40TFLiqNombre);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQNOMBRE_SELS", AV41TFLiqNombre_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQNOMBRE_SELS", AV41TFLiqNombre_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECPAGO", localUtil.dtoc( AV42TFLiqFecPago, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQFECPAGO_TO", localUtil.dtoc( AV43TFLiqFecPago_To, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFTLIQCOD", AV48TFTLiqCod);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFTLIQCOD_SELS", AV49TFTLiqCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFTLIQCOD_SELS", AV49TFTLiqCod_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQMODTRA_SELS", AV82TFLiqModTra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQMODTRA_SELS", AV82TFLiqModTra_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLIQFRECPAG_SELS", AV84TFLiqFrecPag_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLIQFRECPAG_SELS", AV84TFLiqFrecPag_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPBASICO", GXutil.ltrim( localUtil.ntoc( AV52TFLiqLegImpBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPBASICO_TO", GXutil.ltrim( localUtil.ntoc( AV53TFLiqLegImpBasico_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUTO", GXutil.ltrim( localUtil.ntoc( AV54TFLiqLegImpTotBruto, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUTO_TO", GXutil.ltrim( localUtil.ntoc( AV55TFLiqLegImpTotBruto_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUPROM", GXutil.ltrim( localUtil.ntoc( AV56TFLiqLegImpTotBruProm, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUPROM_TO", GXutil.ltrim( localUtil.ntoc( AV57TFLiqLegImpTotBruProm_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUSINSAC", GXutil.ltrim( localUtil.ntoc( AV58TFLiqLegImpTotBruSinSAC, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTBRUSINSAC_TO", GXutil.ltrim( localUtil.ntoc( AV59TFLiqLegImpTotBruSinSAC_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTRETGAN", GXutil.ltrim( localUtil.ntoc( AV60TFLiqLegImpTotRetGan, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLIQLEGIMPTOTRETGAN_TO", GXutil.ltrim( localUtil.ntoc( AV61TFLiqLegImpTotRetGan_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV11LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TLIQDESC", A340TliqDesc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTBRUTO", GXutil.ltrim( localUtil.ntoc( AV73TotLiqLegImpTotBruto, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTBRUTO", getSecureSignedToken( sPrefix, localUtil.format( AV73TotLiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTDESCU", GXutil.ltrim( localUtil.ntoc( AV75TotLiqLegImpTotDescu, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTDESCU", getSecureSignedToken( sPrefix, localUtil.format( AV75TotLiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTRETGAN", GXutil.ltrim( localUtil.ntoc( AV77TotLiqLegImpTotRetGan, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTRETGAN", getSecureSignedToken( sPrefix, localUtil.format( AV77TotLiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTAL", GXutil.ltrim( localUtil.ntoc( AV79TotLiqLegImpTotal, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTAL", getSecureSignedToken( sPrefix, localUtil.format( AV79TotLiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_gridcolumnsselector_Titlecontrolidtoreplace));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
   }

   public void renderHtmlCloseFormK02( )
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
      return "liquidacionesWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "liquidaciones WC", "") ;
   }

   public void wbK00( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.liquidacioneswc");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_6_K02( true) ;
      }
      else
      {
         wb_table1_6_K02( false) ;
      }
      return  ;
   }

   public void wb_table1_6_K02e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV62DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_liquidacionesWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtLegNumero_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_liquidacionesWC.htm");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV62DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV26ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, sPrefix+"DDO_GRIDCOLUMNSSELECTORContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'" + sPrefix + "',false,'" + sGXsfl_22_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqfechaauxdatetext_Internalname, AV35DDO_LiqFechaAuxDateText, GXutil.rtrim( localUtil.format( AV35DDO_LiqFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_liquidacionesWC.htm");
         /* User Defined Control */
         ucTfliqfecha_rangepicker.setProperty("Start Date", AV33DDO_LiqFechaAuxDate);
         ucTfliqfecha_rangepicker.setProperty("End Date", AV34DDO_LiqFechaAuxDateTo);
         ucTfliqfecha_rangepicker.render(context, "wwp.daterangepicker", Tfliqfecha_rangepicker_Internalname, sPrefix+"TFLIQFECHA_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqfecpagoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'" + sPrefix + "',false,'" + sGXsfl_22_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqfecpagoauxdatetext_Internalname, AV46DDO_LiqFecPagoAuxDateText, GXutil.rtrim( localUtil.format( AV46DDO_LiqFecPagoAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqfecpagoauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_liquidacionesWC.htm");
         /* User Defined Control */
         ucTfliqfecpago_rangepicker.setProperty("Start Date", AV44DDO_LiqFecPagoAuxDate);
         ucTfliqfecpago_rangepicker.setProperty("End Date", AV45DDO_LiqFecPagoAuxDateTo);
         ucTfliqfecpago_rangepicker.render(context, "wwp.daterangepicker", Tfliqfecpago_rangepicker_Internalname, sPrefix+"TFLIQFECPAGO_RANGEPICKERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 22 )
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

   public void startK02( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "liquidaciones WC", ""), (short)(0)) ;
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
            strupK00( ) ;
         }
      }
   }

   public void wsK02( )
   {
      startK02( ) ;
      evtK02( ) ;
   }

   public void evtK02( )
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
                              strupK00( ) ;
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
                              strupK00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11K02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupK00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12K02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupK00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13K02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupK00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14K02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupK00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoExport' */
                                 e15K02 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupK00( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavTotvalueliqlegimptotbruto_Internalname ;
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
                              strupK00( ) ;
                           }
                           nGXsfl_22_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_222( ) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A98LiqFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecha_Internalname), 0)) ;
                           A513LiqPerSinDia = httpContext.cgiGet( edtLiqPerSinDia_Internalname) ;
                           A748LiqPerPalabra = httpContext.cgiGet( edtLiqPerPalabra_Internalname) ;
                           A874LiqNombre = httpContext.cgiGet( edtLiqNombre_Internalname) ;
                           A280LiqFecPago = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecPago_Internalname), 0)) ;
                           dynTLiqCod.setName( dynTLiqCod.getInternalname() );
                           dynTLiqCod.setValue( httpContext.cgiGet( dynTLiqCod.getInternalname()) );
                           A32TLiqCod = httpContext.cgiGet( dynTLiqCod.getInternalname()) ;
                           n32TLiqCod = false ;
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
                           A760LiqLegImpBasico = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpBasico_Internalname)) ;
                           A498LiqLegImpTotBruto = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotBruto_Internalname)) ;
                           A758LiqLegImpTotBruProm = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotBruProm_Internalname)) ;
                           A759LiqLegImpTotBruSinSAC = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotBruSinSAC_Internalname)) ;
                           A579LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotDescu_Internalname)) ;
                           AV20LiqLegImpTotDescu = localUtil.ctond( httpContext.cgiGet( edtavLiqlegimptotdescu_Internalname)) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimptotdescu_Internalname, GXutil.ltrimstr( AV20LiqLegImpTotDescu, 14, 2));
                           A757LiqLegImpTotRetGan = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotRetGan_Internalname)) ;
                           A281LiqLegImpTotal = localUtil.ctond( httpContext.cgiGet( edtLiqLegImpTotal_Internalname)) ;
                           AV21ErrorLiqLeg = httpContext.cgiGet( edtavErrorliqleg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavErrorliqleg_Internalname, AV21ErrorLiqLeg);
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
                                       GX_FocusControl = edtavTotvalueliqlegimptotbruto_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e16K02 ();
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
                                       GX_FocusControl = edtavTotvalueliqlegimptotbruto_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e17K02 ();
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
                                       GX_FocusControl = edtavTotvalueliqlegimptotbruto_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e18K02 ();
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
                                    strupK00( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavTotvalueliqlegimptotbruto_Internalname ;
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

   public void weK02( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormK02( ) ;
         }
      }
   }

   public void paK02( )
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
            GX_FocusControl = edtavTotvalueliqlegimptotbruto_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlatliqcodK02( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlatliqcod_dataK02( ) ;
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

   public void gxatliqcod_htmlK02( )
   {
      String gxdynajaxvalue;
      gxdlatliqcod_dataK02( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynTLiqCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynTLiqCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlatliqcod_dataK02( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "Todos", ""));
      /* Using cursor H00K02 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00K02_A32TLiqCod[0]));
         gxdynajaxctrldescr.add(H00K02_A340TliqDesc[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_222( ) ;
      while ( nGXsfl_22_idx <= nRC_GXsfl_22 )
      {
         sendrow_222( ) ;
         nGXsfl_22_idx = ((subGrid_Islastpage==1)&&(nGXsfl_22_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_22_idx+1) ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV8CliCod ,
                                 short AV9EmpCod ,
                                 int AV11LegNumero ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ,
                                 String AV87Pgmname ,
                                 short AV17OrderedBy ,
                                 boolean AV18OrderedDsc ,
                                 int AV29TFLiqNro ,
                                 int AV30TFLiqNro_To ,
                                 java.util.Date AV31TFLiqFecha ,
                                 java.util.Date AV32TFLiqFecha_To ,
                                 String AV37TFLiqPerPalabra ,
                                 GXSimpleCollection<String> AV38TFLiqPerPalabra_Sels ,
                                 String AV40TFLiqNombre ,
                                 GXSimpleCollection<String> AV41TFLiqNombre_Sels ,
                                 java.util.Date AV42TFLiqFecPago ,
                                 java.util.Date AV43TFLiqFecPago_To ,
                                 String AV48TFTLiqCod ,
                                 GXSimpleCollection<String> AV49TFTLiqCod_Sels ,
                                 GXSimpleCollection<String> AV82TFLiqModTra_Sels ,
                                 GXSimpleCollection<Byte> AV84TFLiqFrecPag_Sels ,
                                 java.math.BigDecimal AV52TFLiqLegImpBasico ,
                                 java.math.BigDecimal AV53TFLiqLegImpBasico_To ,
                                 java.math.BigDecimal AV54TFLiqLegImpTotBruto ,
                                 java.math.BigDecimal AV55TFLiqLegImpTotBruto_To ,
                                 java.math.BigDecimal AV56TFLiqLegImpTotBruProm ,
                                 java.math.BigDecimal AV57TFLiqLegImpTotBruProm_To ,
                                 java.math.BigDecimal AV58TFLiqLegImpTotBruSinSAC ,
                                 java.math.BigDecimal AV59TFLiqLegImpTotBruSinSAC_To ,
                                 java.math.BigDecimal AV60TFLiqLegImpTotRetGan ,
                                 java.math.BigDecimal AV61TFLiqLegImpTotRetGan_To ,
                                 java.math.BigDecimal AV73TotLiqLegImpTotBruto ,
                                 java.math.BigDecimal AV75TotLiqLegImpTotDescu ,
                                 java.math.BigDecimal AV77TotLiqLegImpTotRetGan ,
                                 java.math.BigDecimal AV79TotLiqLegImpTotal ,
                                 int A3CliCod ,
                                 int A6LegNumero ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e17K02 ();
      GRID_nCurrentRecord = 0 ;
      rfK02( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"liquidacionesWC");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      forbiddenHiddens.add("LegNumero", localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("liquidacioneswc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfK02( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV87Pgmname = "liquidacionesWC" ;
      Gx_err = (short)(0) ;
      edtavLiqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Enabled), 5, 0), !bGXsfl_22_Refreshing);
      edtavErrorliqleg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavErrorliqleg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavErrorliqleg_Enabled), 5, 0), !bGXsfl_22_Refreshing);
      edtavTotvalueliqlegimptotbruto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotbruto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotbruto_Enabled), 5, 0), true);
      edtavTotvalueliqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotdescu_Enabled), 5, 0), true);
      edtavTotvalueliqlegimptotretgan_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotretgan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotretgan_Enabled), 5, 0), true);
      edtavTotvalueliqlegimptotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotal_Enabled), 5, 0), true);
   }

   public void rfK02( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(22) ;
      /* Execute user event: Refresh */
      e17K02 ();
      nGXsfl_22_idx = 1 ;
      sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_222( ) ;
      bGXsfl_22_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithTotalizer GridWithPaginationBar WorkWith");
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
         subsflControlProps_222( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              A748LiqPerPalabra ,
                                              AV38TFLiqPerPalabra_Sels ,
                                              A874LiqNombre ,
                                              AV41TFLiqNombre_Sels ,
                                              A32TLiqCod ,
                                              AV49TFTLiqCod_Sels ,
                                              A2409LiqModTra ,
                                              AV82TFLiqModTra_Sels ,
                                              Byte.valueOf(A2414LiqFrecPag) ,
                                              AV84TFLiqFrecPag_Sels ,
                                              Integer.valueOf(AV29TFLiqNro) ,
                                              Integer.valueOf(AV30TFLiqNro_To) ,
                                              AV31TFLiqFecha ,
                                              AV32TFLiqFecha_To ,
                                              Integer.valueOf(AV38TFLiqPerPalabra_Sels.size()) ,
                                              AV37TFLiqPerPalabra ,
                                              Integer.valueOf(AV41TFLiqNombre_Sels.size()) ,
                                              AV40TFLiqNombre ,
                                              AV42TFLiqFecPago ,
                                              AV43TFLiqFecPago_To ,
                                              Integer.valueOf(AV49TFTLiqCod_Sels.size()) ,
                                              AV48TFTLiqCod ,
                                              Integer.valueOf(AV82TFLiqModTra_Sels.size()) ,
                                              Integer.valueOf(AV84TFLiqFrecPag_Sels.size()) ,
                                              AV52TFLiqLegImpBasico ,
                                              AV53TFLiqLegImpBasico_To ,
                                              AV54TFLiqLegImpTotBruto ,
                                              AV55TFLiqLegImpTotBruto_To ,
                                              AV56TFLiqLegImpTotBruProm ,
                                              AV57TFLiqLegImpTotBruProm_To ,
                                              AV58TFLiqLegImpTotBruSinSAC ,
                                              AV59TFLiqLegImpTotBruSinSAC_To ,
                                              AV60TFLiqLegImpTotRetGan ,
                                              AV61TFLiqLegImpTotRetGan_To ,
                                              Integer.valueOf(A31LiqNro) ,
                                              A98LiqFecha ,
                                              A280LiqFecPago ,
                                              A340TliqDesc ,
                                              A760LiqLegImpBasico ,
                                              A498LiqLegImpTotBruto ,
                                              A758LiqLegImpTotBruProm ,
                                              A759LiqLegImpTotBruSinSAC ,
                                              A757LiqLegImpTotRetGan ,
                                              Short.valueOf(AV17OrderedBy) ,
                                              Boolean.valueOf(AV18OrderedDsc) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              Integer.valueOf(AV11LegNumero) ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV37TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV37TFLiqPerPalabra), 20, "%") ;
         lV40TFLiqNombre = GXutil.concat( GXutil.rtrim( AV40TFLiqNombre), "%", "") ;
         lV48TFTLiqCod = GXutil.concat( GXutil.rtrim( AV48TFTLiqCod), "%", "") ;
         /* Using cursor H00K03 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LegNumero), Integer.valueOf(AV29TFLiqNro), Integer.valueOf(AV30TFLiqNro_To), AV31TFLiqFecha, AV32TFLiqFecha_To, lV37TFLiqPerPalabra, lV40TFLiqNombre, AV42TFLiqFecPago, AV43TFLiqFecPago_To, lV48TFTLiqCod, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_22_idx = 1 ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
         while ( ( (pr_default.getStatus(1) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A340TliqDesc = H00K03_A340TliqDesc[0] ;
            A3CliCod = H00K03_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A6LegNumero = H00K03_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            A281LiqLegImpTotal = H00K03_A281LiqLegImpTotal[0] ;
            A757LiqLegImpTotRetGan = H00K03_A757LiqLegImpTotRetGan[0] ;
            A579LiqLegImpTotDescu = H00K03_A579LiqLegImpTotDescu[0] ;
            A759LiqLegImpTotBruSinSAC = H00K03_A759LiqLegImpTotBruSinSAC[0] ;
            A758LiqLegImpTotBruProm = H00K03_A758LiqLegImpTotBruProm[0] ;
            A498LiqLegImpTotBruto = H00K03_A498LiqLegImpTotBruto[0] ;
            A760LiqLegImpBasico = H00K03_A760LiqLegImpBasico[0] ;
            A2414LiqFrecPag = H00K03_A2414LiqFrecPag[0] ;
            A2409LiqModTra = H00K03_A2409LiqModTra[0] ;
            A268LiqClase = H00K03_A268LiqClase[0] ;
            n268LiqClase = H00K03_n268LiqClase[0] ;
            A32TLiqCod = H00K03_A32TLiqCod[0] ;
            n32TLiqCod = H00K03_n32TLiqCod[0] ;
            A280LiqFecPago = H00K03_A280LiqFecPago[0] ;
            A874LiqNombre = H00K03_A874LiqNombre[0] ;
            A748LiqPerPalabra = H00K03_A748LiqPerPalabra[0] ;
            A513LiqPerSinDia = H00K03_A513LiqPerSinDia[0] ;
            A98LiqFecha = H00K03_A98LiqFecha[0] ;
            A31LiqNro = H00K03_A31LiqNro[0] ;
            A1EmpCod = H00K03_A1EmpCod[0] ;
            A340TliqDesc = H00K03_A340TliqDesc[0] ;
            A2414LiqFrecPag = H00K03_A2414LiqFrecPag[0] ;
            A2409LiqModTra = H00K03_A2409LiqModTra[0] ;
            A268LiqClase = H00K03_A268LiqClase[0] ;
            n268LiqClase = H00K03_n268LiqClase[0] ;
            A280LiqFecPago = H00K03_A280LiqFecPago[0] ;
            A874LiqNombre = H00K03_A874LiqNombre[0] ;
            A748LiqPerPalabra = H00K03_A748LiqPerPalabra[0] ;
            A513LiqPerSinDia = H00K03_A513LiqPerSinDia[0] ;
            A98LiqFecha = H00K03_A98LiqFecha[0] ;
            e18K02 ();
            pr_default.readNext(1);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(1) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(1);
         wbEnd = (short)(22) ;
         wbK00( ) ;
      }
      bGXsfl_22_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesK02( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV87Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTBRUTO", GXutil.ltrim( localUtil.ntoc( AV73TotLiqLegImpTotBruto, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTBRUTO", getSecureSignedToken( sPrefix, localUtil.format( AV73TotLiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTDESCU", GXutil.ltrim( localUtil.ntoc( AV75TotLiqLegImpTotDescu, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTDESCU", getSecureSignedToken( sPrefix, localUtil.format( AV75TotLiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTRETGAN", GXutil.ltrim( localUtil.ntoc( AV77TotLiqLegImpTotRetGan, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTRETGAN", getSecureSignedToken( sPrefix, localUtil.format( AV77TotLiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTOTLIQLEGIMPTOTAL", GXutil.ltrim( localUtil.ntoc( AV79TotLiqLegImpTotal, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTAL", getSecureSignedToken( sPrefix, localUtil.format( AV79TotLiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")));
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
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV38TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV41TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV49TFTLiqCod_Sels ,
                                           A2409LiqModTra ,
                                           AV82TFLiqModTra_Sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV84TFLiqFrecPag_Sels ,
                                           Integer.valueOf(AV29TFLiqNro) ,
                                           Integer.valueOf(AV30TFLiqNro_To) ,
                                           AV31TFLiqFecha ,
                                           AV32TFLiqFecha_To ,
                                           Integer.valueOf(AV38TFLiqPerPalabra_Sels.size()) ,
                                           AV37TFLiqPerPalabra ,
                                           Integer.valueOf(AV41TFLiqNombre_Sels.size()) ,
                                           AV40TFLiqNombre ,
                                           AV42TFLiqFecPago ,
                                           AV43TFLiqFecPago_To ,
                                           Integer.valueOf(AV49TFTLiqCod_Sels.size()) ,
                                           AV48TFTLiqCod ,
                                           Integer.valueOf(AV82TFLiqModTra_Sels.size()) ,
                                           Integer.valueOf(AV84TFLiqFrecPag_Sels.size()) ,
                                           AV52TFLiqLegImpBasico ,
                                           AV53TFLiqLegImpBasico_To ,
                                           AV54TFLiqLegImpTotBruto ,
                                           AV55TFLiqLegImpTotBruto_To ,
                                           AV56TFLiqLegImpTotBruProm ,
                                           AV57TFLiqLegImpTotBruProm_To ,
                                           AV58TFLiqLegImpTotBruSinSAC ,
                                           AV59TFLiqLegImpTotBruSinSAC_To ,
                                           AV60TFLiqLegImpTotRetGan ,
                                           AV61TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV11LegNumero) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV37TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV37TFLiqPerPalabra), 20, "%") ;
      lV40TFLiqNombre = GXutil.concat( GXutil.rtrim( AV40TFLiqNombre), "%", "") ;
      lV48TFTLiqCod = GXutil.concat( GXutil.rtrim( AV48TFTLiqCod), "%", "") ;
      /* Using cursor H00K04 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LegNumero), Integer.valueOf(AV29TFLiqNro), Integer.valueOf(AV30TFLiqNro_To), AV31TFLiqFecha, AV32TFLiqFecha_To, lV37TFLiqPerPalabra, lV40TFLiqNombre, AV42TFLiqFecPago, AV43TFLiqFecPago_To, lV48TFTLiqCod, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To});
      GRID_nRecordCount = H00K04_AGRID_nRecordCount[0] ;
      pr_default.close(2);
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV11LegNumero, AV26ColumnsSelector, AV87Pgmname, AV17OrderedBy, AV18OrderedDsc, AV29TFLiqNro, AV30TFLiqNro_To, AV31TFLiqFecha, AV32TFLiqFecha_To, AV37TFLiqPerPalabra, AV38TFLiqPerPalabra_Sels, AV40TFLiqNombre, AV41TFLiqNombre_Sels, AV42TFLiqFecPago, AV43TFLiqFecPago_To, AV48TFTLiqCod, AV49TFTLiqCod_Sels, AV82TFLiqModTra_Sels, AV84TFLiqFrecPag_Sels, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, AV73TotLiqLegImpTotBruto, AV75TotLiqLegImpTotDescu, AV77TotLiqLegImpTotRetGan, AV79TotLiqLegImpTotal, A3CliCod, A6LegNumero, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV11LegNumero, AV26ColumnsSelector, AV87Pgmname, AV17OrderedBy, AV18OrderedDsc, AV29TFLiqNro, AV30TFLiqNro_To, AV31TFLiqFecha, AV32TFLiqFecha_To, AV37TFLiqPerPalabra, AV38TFLiqPerPalabra_Sels, AV40TFLiqNombre, AV41TFLiqNombre_Sels, AV42TFLiqFecPago, AV43TFLiqFecPago_To, AV48TFTLiqCod, AV49TFTLiqCod_Sels, AV82TFLiqModTra_Sels, AV84TFLiqFrecPag_Sels, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, AV73TotLiqLegImpTotBruto, AV75TotLiqLegImpTotDescu, AV77TotLiqLegImpTotRetGan, AV79TotLiqLegImpTotal, A3CliCod, A6LegNumero, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV11LegNumero, AV26ColumnsSelector, AV87Pgmname, AV17OrderedBy, AV18OrderedDsc, AV29TFLiqNro, AV30TFLiqNro_To, AV31TFLiqFecha, AV32TFLiqFecha_To, AV37TFLiqPerPalabra, AV38TFLiqPerPalabra_Sels, AV40TFLiqNombre, AV41TFLiqNombre_Sels, AV42TFLiqFecPago, AV43TFLiqFecPago_To, AV48TFTLiqCod, AV49TFTLiqCod_Sels, AV82TFLiqModTra_Sels, AV84TFLiqFrecPag_Sels, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, AV73TotLiqLegImpTotBruto, AV75TotLiqLegImpTotDescu, AV77TotLiqLegImpTotRetGan, AV79TotLiqLegImpTotal, A3CliCod, A6LegNumero, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV11LegNumero, AV26ColumnsSelector, AV87Pgmname, AV17OrderedBy, AV18OrderedDsc, AV29TFLiqNro, AV30TFLiqNro_To, AV31TFLiqFecha, AV32TFLiqFecha_To, AV37TFLiqPerPalabra, AV38TFLiqPerPalabra_Sels, AV40TFLiqNombre, AV41TFLiqNombre_Sels, AV42TFLiqFecPago, AV43TFLiqFecPago_To, AV48TFTLiqCod, AV49TFTLiqCod_Sels, AV82TFLiqModTra_Sels, AV84TFLiqFrecPag_Sels, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, AV73TotLiqLegImpTotBruto, AV75TotLiqLegImpTotDescu, AV77TotLiqLegImpTotRetGan, AV79TotLiqLegImpTotal, A3CliCod, A6LegNumero, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV11LegNumero, AV26ColumnsSelector, AV87Pgmname, AV17OrderedBy, AV18OrderedDsc, AV29TFLiqNro, AV30TFLiqNro_To, AV31TFLiqFecha, AV32TFLiqFecha_To, AV37TFLiqPerPalabra, AV38TFLiqPerPalabra_Sels, AV40TFLiqNombre, AV41TFLiqNombre_Sels, AV42TFLiqFecPago, AV43TFLiqFecPago_To, AV48TFTLiqCod, AV49TFTLiqCod_Sels, AV82TFLiqModTra_Sels, AV84TFLiqFrecPag_Sels, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To, AV73TotLiqLegImpTotBruto, AV75TotLiqLegImpTotDescu, AV77TotLiqLegImpTotRetGan, AV79TotLiqLegImpTotal, A3CliCod, A6LegNumero, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV87Pgmname = "liquidacionesWC" ;
      Gx_err = (short)(0) ;
      edtavLiqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Enabled), 5, 0), !bGXsfl_22_Refreshing);
      edtavErrorliqleg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavErrorliqleg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavErrorliqleg_Enabled), 5, 0), !bGXsfl_22_Refreshing);
      edtavTotvalueliqlegimptotbruto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotbruto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotbruto_Enabled), 5, 0), true);
      edtavTotvalueliqlegimptotdescu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotdescu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotdescu_Enabled), 5, 0), true);
      edtavTotvalueliqlegimptotretgan_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotretgan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotretgan_Enabled), 5, 0), true);
      edtavTotvalueliqlegimptotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueliqlegimptotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueliqlegimptotal_Enabled), 5, 0), true);
      gxatliqcod_htmlK02( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strupK00( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e16K02 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV62DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCOLUMNSSELECTOR"), AV26ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_22 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_22"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV66GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV67GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV68GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         AV33DDO_LiqFechaAuxDate = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECHAAUXDATE"), 0) ;
         AV34DDO_LiqFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECHAAUXDATETO"), 0) ;
         AV44DDO_LiqFecPagoAuxDate = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECPAGOAUXDATE"), 0) ;
         AV45DDO_LiqFecPagoAuxDateTo = localUtil.ctod( httpContext.cgiGet( sPrefix+"vDDO_LIQFECPAGOAUXDATETO"), 0) ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV11LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_gridcolumnsselector_Titlecontrolidtoreplace = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace") ;
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
         /* Read variables values. */
         AV74TotValueLiqLegImpTotBruto = httpContext.cgiGet( edtavTotvalueliqlegimptotbruto_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TotValueLiqLegImpTotBruto", AV74TotValueLiqLegImpTotBruto);
         AV76TotValueLiqLegImpTotDescu = httpContext.cgiGet( edtavTotvalueliqlegimptotdescu_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76TotValueLiqLegImpTotDescu", AV76TotValueLiqLegImpTotDescu);
         AV78TotValueLiqLegImpTotRetGan = httpContext.cgiGet( edtavTotvalueliqlegimptotretgan_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78TotValueLiqLegImpTotRetGan", AV78TotValueLiqLegImpTotRetGan);
         AV80TotValueLiqLegImpTotal = httpContext.cgiGet( edtavTotvalueliqlegimptotal_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80TotValueLiqLegImpTotal", AV80TotValueLiqLegImpTotal);
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         AV35DDO_LiqFechaAuxDateText = httpContext.cgiGet( edtavDdo_liqfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35DDO_LiqFechaAuxDateText", AV35DDO_LiqFechaAuxDateText);
         AV46DDO_LiqFecPagoAuxDateText = httpContext.cgiGet( edtavDdo_liqfecpagoauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46DDO_LiqFecPagoAuxDateText", AV46DDO_LiqFecPagoAuxDateText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"liquidacionesWC");
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
         A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         forbiddenHiddens.add("LegNumero", localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("liquidacioneswc:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
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
      e16K02 ();
      if (returnInSub) return;
   }

   public void e16K02( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      liquidacioneswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      this.executeUsercontrolMethod(sPrefix, false, "TFLIQFECPAGO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_liqfecpagoauxdatetext_Internalname});
      this.executeUsercontrolMethod(sPrefix, false, "TFLIQFECHA_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_liqfechaauxdatetext_Internalname});
      subGrid_Rows = 12 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Visible), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV17OrderedBy < 1 )
      {
         AV17OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV62DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV62DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e17K02( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      liquidacioneswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV28Session.getValue("liquidacionesWCColumnsSelector"), "") != 0 )
      {
         AV24ColumnsSelectorXML = AV28Session.getValue("liquidacionesWCColumnsSelector") ;
         AV26ColumnsSelector.fromxml(AV24ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S152 ();
         if (returnInSub) return;
      }
      edtLiqNro_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqFecha_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecha_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqPerPalabra_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqPerPalabra_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqPerPalabra_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqNombre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNombre_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqFecPago_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqFecPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecPago_Visible), 5, 0), !bGXsfl_22_Refreshing);
      dynTLiqCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTLiqCod.getInternalname(), "Visible", GXutil.ltrimstr( dynTLiqCod.getVisible(), 5, 0), !bGXsfl_22_Refreshing);
      cmbLiqModTra.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqModTra.getInternalname(), "Visible", GXutil.ltrimstr( cmbLiqModTra.getVisible(), 5, 0), !bGXsfl_22_Refreshing);
      cmbLiqFrecPag.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqFrecPag.getInternalname(), "Visible", GXutil.ltrimstr( cmbLiqFrecPag.getVisible(), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqLegImpBasico_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpBasico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpBasico_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqLegImpTotBruto_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotBruto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotBruto_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqLegImpTotBruProm_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotBruProm_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotBruProm_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqLegImpTotBruSinSAC_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotBruSinSAC_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotBruSinSAC_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtavLiqlegimptotdescu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqlegimptotdescu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqlegimptotdescu_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqLegImpTotRetGan_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotRetGan_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotRetGan_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtLiqLegImpTotal_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLiqLegImpTotal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqLegImpTotal_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtavErrorliqleg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV26ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavErrorliqleg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavErrorliqleg_Visible), 5, 0), !bGXsfl_22_Refreshing);
      /* Execute user subroutine: 'INITIALIZETOTALIZERS' */
      S162 ();
      if (returnInSub) return;
      AV66GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66GridCurrentPage), 10, 0));
      AV67GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67GridPageCount), 10, 0));
      GXt_char6 = AV68GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV87Pgmname, GXv_char7) ;
      liquidacioneswc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV68GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68GridAppliedFilters", AV68GridAppliedFilters);
      /* Execute user subroutine: 'CALCULATETOTALIZERS' */
      S172 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV26ColumnsSelector", AV26ColumnsSelector);
   }

   public void e11K02( )
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
         AV65PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV65PageToGo) ;
      }
   }

   public void e12K02( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13K02( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV17OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
         AV18OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18OrderedDsc", AV18OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqNro") == 0 )
         {
            AV29TFLiqNro = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFLiqNro), 8, 0));
            AV30TFLiqNro_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFLiqNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFecha") == 0 )
         {
            AV31TFLiqFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLiqFecha", localUtil.format(AV31TFLiqFecha, "99/99/9999"));
            AV32TFLiqFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLiqFecha_To", localUtil.format(AV32TFLiqFecha_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqPerPalabra") == 0 )
         {
            AV37TFLiqPerPalabra = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLiqPerPalabra", AV37TFLiqPerPalabra);
            AV36TFLiqPerPalabra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLiqPerPalabra_SelsJson", AV36TFLiqPerPalabra_SelsJson);
            AV38TFLiqPerPalabra_Sels.fromJSonString(AV36TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqNombre") == 0 )
         {
            AV40TFLiqNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLiqNombre", AV40TFLiqNombre);
            AV39TFLiqNombre_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLiqNombre_SelsJson", AV39TFLiqNombre_SelsJson);
            AV41TFLiqNombre_Sels.fromJSonString(AV39TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFecPago") == 0 )
         {
            AV42TFLiqFecPago = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFLiqFecPago", localUtil.format(AV42TFLiqFecPago, "99/99/9999"));
            AV43TFLiqFecPago_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFLiqFecPago_To", localUtil.format(AV43TFLiqFecPago_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TLiqCod") == 0 )
         {
            AV48TFTLiqCod = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TFTLiqCod", AV48TFTLiqCod);
            AV47TFTLiqCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TFTLiqCod_SelsJson", AV47TFTLiqCod_SelsJson);
            AV49TFTLiqCod_Sels.fromJSonString(AV47TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqModTra") == 0 )
         {
            AV81TFLiqModTra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81TFLiqModTra_SelsJson", AV81TFLiqModTra_SelsJson);
            AV82TFLiqModTra_Sels.fromJSonString(AV81TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFrecPag") == 0 )
         {
            AV83TFLiqFrecPag_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83TFLiqFrecPag_SelsJson", AV83TFLiqFrecPag_SelsJson);
            AV84TFLiqFrecPag_Sels.fromJSonString(GXutil.strReplace( AV83TFLiqFrecPag_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpBasico") == 0 )
         {
            AV52TFLiqLegImpBasico = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TFLiqLegImpBasico", GXutil.ltrimstr( AV52TFLiqLegImpBasico, 14, 2));
            AV53TFLiqLegImpBasico_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TFLiqLegImpBasico_To", GXutil.ltrimstr( AV53TFLiqLegImpBasico_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotBruto") == 0 )
         {
            AV54TFLiqLegImpTotBruto = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TFLiqLegImpTotBruto", GXutil.ltrimstr( AV54TFLiqLegImpTotBruto, 14, 2));
            AV55TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFLiqLegImpTotBruto_To", GXutil.ltrimstr( AV55TFLiqLegImpTotBruto_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotBruProm") == 0 )
         {
            AV56TFLiqLegImpTotBruProm = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLiqLegImpTotBruProm", GXutil.ltrimstr( AV56TFLiqLegImpTotBruProm, 14, 2));
            AV57TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLiqLegImpTotBruProm_To", GXutil.ltrimstr( AV57TFLiqLegImpTotBruProm_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotBruSinSAC") == 0 )
         {
            AV58TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLiqLegImpTotBruSinSAC", GXutil.ltrimstr( AV58TFLiqLegImpTotBruSinSAC, 14, 2));
            AV59TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFLiqLegImpTotBruSinSAC_To", GXutil.ltrimstr( AV59TFLiqLegImpTotBruSinSAC_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqLegImpTotRetGan") == 0 )
         {
            AV60TFLiqLegImpTotRetGan = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFLiqLegImpTotRetGan", GXutil.ltrimstr( AV60TFLiqLegImpTotRetGan, 14, 2));
            AV61TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TFLiqLegImpTotRetGan_To", GXutil.ltrimstr( AV61TFLiqLegImpTotRetGan_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV84TFLiqFrecPag_Sels", AV84TFLiqFrecPag_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV82TFLiqModTra_Sels", AV82TFLiqModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV49TFTLiqCod_Sels", AV49TFTLiqCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV41TFLiqNombre_Sels", AV41TFLiqNombre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV38TFLiqPerPalabra_Sels", AV38TFLiqPerPalabra_Sels);
   }

   private void e18K02( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV20LiqLegImpTotDescu = A579LiqLegImpTotDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimptotdescu_Internalname, GXutil.ltrimstr( AV20LiqLegImpTotDescu, 14, 2));
      GXt_char6 = AV21ErrorLiqLeg ;
      GXv_char7[0] = GXt_char6 ;
      new web.liqleggeterror(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, GXv_char7) ;
      liquidacioneswc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV21ErrorLiqLeg = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavErrorliqleg_Internalname, AV21ErrorLiqLeg);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(22) ;
      }
      sendrow_222( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_22_Refreshing )
      {
         httpContext.doAjaxLoad(22, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e14K02( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV24ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV26ColumnsSelector.fromJSonString(AV24ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "liquidacionesWCColumnsSelector", ((GXutil.strcmp("", AV24ColumnsSelectorXML)==0) ? "" : AV26ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV26ColumnsSelector", AV26ColumnsSelector);
   }

   public void e15K02( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV22ExcelFilename ;
      GXv_char8[0] = AV23ErrorMessage ;
      new web.liquidacioneswcexport(remoteHandle, context).execute( GXv_char7, GXv_char8) ;
      liquidacioneswc_impl.this.AV22ExcelFilename = GXv_char7[0] ;
      liquidacioneswc_impl.this.AV23ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV22ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV22ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV23ErrorMessage);
      }
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV17OrderedBy, 4, 0))+":"+(AV18OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV26ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNro", "", "Número", false, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecha", "", "Fecha de Liq.", false, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqPerPalabra", "", "Periodo", false, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqNombre", "", "Liquidación", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFecPago", "", "Fecha de Pago", false, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "TLiqCod", "", "Tipo", false, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqModTra", "", "Modo de trabajo", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqFrecPag", "", "Frecuencia de pago", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpBasico", "", "Básico", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruto", "", "Bruto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruProm", "", "Bruto Prom. sin SAC", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotBruSinSAC", "", "Bruto sin SAC", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&LiqLegImpTotDescu", "", "Descuentos", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotRetGan", "", "Imp. Ganancias (Ret/Dev)", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "LiqLegImpTotal", "", "Neto", true, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXv_SdtWWPColumnsSelector9[0] = AV26ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, "&ErrorLiqLeg", "", "Error", false, "") ;
      AV26ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      GXt_char6 = AV25UserCustomValue ;
      GXv_char8[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "liquidacionesWCColumnsSelector", GXv_char8) ;
      liquidacioneswc_impl.this.GXt_char6 = GXv_char8[0] ;
      AV25UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV25UserCustomValue)==0) ) )
      {
         AV27ColumnsSelectorAux.fromxml(AV25UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector9[0] = AV27ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector10[0] = AV26ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector9, GXv_SdtWWPColumnsSelector10) ;
         AV27ColumnsSelectorAux = GXv_SdtWWPColumnsSelector9[0] ;
         AV26ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue(AV87Pgmname+"GridState"), "") == 0 )
      {
         AV15GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV87Pgmname+"GridState"), null, null);
      }
      else
      {
         AV15GridState.fromxml(AV28Session.getValue(AV87Pgmname+"GridState"), null, null);
      }
      AV17OrderedBy = AV15GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
      AV18OrderedDsc = AV15GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18OrderedDsc", AV18OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV88GXV1 = 1 ;
      while ( AV88GXV1 <= AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV88GXV1));
         if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV29TFLiqNro = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29TFLiqNro), 8, 0));
            AV30TFLiqNro_To = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLiqNro_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFLiqNro_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV31TFLiqFecha = localUtil.ctod( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLiqFecha", localUtil.format(AV31TFLiqFecha, "99/99/9999"));
            AV32TFLiqFecha_To = localUtil.ctod( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLiqFecha_To", localUtil.format(AV32TFLiqFecha_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV37TFLiqPerPalabra = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLiqPerPalabra", AV37TFLiqPerPalabra);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV36TFLiqPerPalabra_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLiqPerPalabra_SelsJson", AV36TFLiqPerPalabra_SelsJson);
            AV38TFLiqPerPalabra_Sels.fromJSonString(AV36TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV40TFLiqNombre = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLiqNombre", AV40TFLiqNombre);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV39TFLiqNombre_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLiqNombre_SelsJson", AV39TFLiqNombre_SelsJson);
            AV41TFLiqNombre_Sels.fromJSonString(AV39TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV42TFLiqFecPago = localUtil.ctod( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFLiqFecPago", localUtil.format(AV42TFLiqFecPago, "99/99/9999"));
            AV43TFLiqFecPago_To = localUtil.ctod( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFLiqFecPago_To", localUtil.format(AV43TFLiqFecPago_To, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV48TFTLiqCod = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TFTLiqCod", AV48TFTLiqCod);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV47TFTLiqCod_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TFTLiqCod_SelsJson", AV47TFTLiqCod_SelsJson);
            AV49TFTLiqCod_Sels.fromJSonString(AV47TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQMODTRA_SEL") == 0 )
         {
            AV81TFLiqModTra_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81TFLiqModTra_SelsJson", AV81TFLiqModTra_SelsJson);
            AV82TFLiqModTra_Sels.fromJSonString(AV81TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFRECPAG_SEL") == 0 )
         {
            AV83TFLiqFrecPag_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83TFLiqFrecPag_SelsJson", AV83TFLiqFrecPag_SelsJson);
            AV84TFLiqFrecPag_Sels.fromJSonString(AV83TFLiqFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV52TFLiqLegImpBasico = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TFLiqLegImpBasico", GXutil.ltrimstr( AV52TFLiqLegImpBasico, 14, 2));
            AV53TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TFLiqLegImpBasico_To", GXutil.ltrimstr( AV53TFLiqLegImpBasico_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV54TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TFLiqLegImpTotBruto", GXutil.ltrimstr( AV54TFLiqLegImpTotBruto, 14, 2));
            AV55TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFLiqLegImpTotBruto_To", GXutil.ltrimstr( AV55TFLiqLegImpTotBruto_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUPROM") == 0 )
         {
            AV56TFLiqLegImpTotBruProm = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLiqLegImpTotBruProm", GXutil.ltrimstr( AV56TFLiqLegImpTotBruProm, 14, 2));
            AV57TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLiqLegImpTotBruProm_To", GXutil.ltrimstr( AV57TFLiqLegImpTotBruProm_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV58TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLiqLegImpTotBruSinSAC", GXutil.ltrimstr( AV58TFLiqLegImpTotBruSinSAC, 14, 2));
            AV59TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFLiqLegImpTotBruSinSAC_To", GXutil.ltrimstr( AV59TFLiqLegImpTotBruSinSAC_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV60TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFLiqLegImpTotRetGan", GXutil.ltrimstr( AV60TFLiqLegImpTotRetGan, 14, 2));
            AV61TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TFLiqLegImpTotRetGan_To", GXutil.ltrimstr( AV61TFLiqLegImpTotRetGan_To, 14, 2));
         }
         AV88GXV1 = (int)(AV88GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char8[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV38TFLiqPerPalabra_Sels.size()==0), AV36TFLiqPerPalabra_SelsJson, GXv_char8) ;
      liquidacioneswc_impl.this.GXt_char6 = GXv_char8[0] ;
      GXt_char11 = "" ;
      GXv_char7[0] = GXt_char11 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV41TFLiqNombre_Sels.size()==0), AV39TFLiqNombre_SelsJson, GXv_char7) ;
      liquidacioneswc_impl.this.GXt_char11 = GXv_char7[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV49TFTLiqCod_Sels.size()==0), AV47TFTLiqCod_SelsJson, GXv_char13) ;
      liquidacioneswc_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV82TFLiqModTra_Sels.size()==0), AV81TFLiqModTra_SelsJson, GXv_char15) ;
      liquidacioneswc_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Selectedvalue_set = "||"+GXt_char6+"|"+GXt_char11+"||"+GXt_char12+"|"+GXt_char14+"|"+((AV84TFLiqFrecPag_Sels.size()==0) ? "" : AV83TFLiqFrecPag_SelsJson)+"||||||||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFLiqPerPalabra)==0), AV37TFLiqPerPalabra, GXv_char15) ;
      liquidacioneswc_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV40TFLiqNombre)==0), AV40TFLiqNombre, GXv_char13) ;
      liquidacioneswc_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char11 = "" ;
      GXv_char8[0] = GXt_char11 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV48TFTLiqCod)==0), AV48TFTLiqCod, GXv_char8) ;
      liquidacioneswc_impl.this.GXt_char11 = GXv_char8[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV29TFLiqNro) ? "" : GXutil.str( AV29TFLiqNro, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqFecha)) ? "" : localUtil.dtoc( AV31TFLiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char14+"|"+GXt_char12+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecPago)) ? "" : localUtil.dtoc( AV42TFLiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char11+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpBasico)==0) ? "" : GXutil.str( AV52TFLiqLegImpBasico, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpTotBruto)==0) ? "" : GXutil.str( AV54TFLiqLegImpTotBruto, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLiqLegImpTotBruProm)==0) ? "" : GXutil.str( AV56TFLiqLegImpTotBruProm, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruSinSAC)==0) ? "" : GXutil.str( AV58TFLiqLegImpTotBruSinSAC, 14, 2))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotRetGan)==0) ? "" : GXutil.str( AV60TFLiqLegImpTotRetGan, 14, 2))+"||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV30TFLiqNro_To) ? "" : GXutil.str( AV30TFLiqNro_To, 8, 0))+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqFecha_To)) ? "" : localUtil.dtoc( AV32TFLiqFecha_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecPago_To)) ? "" : localUtil.dtoc( AV43TFLiqFecPago_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpBasico_To)==0) ? "" : GXutil.str( AV53TFLiqLegImpBasico_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpTotBruto_To)==0) ? "" : GXutil.str( AV55TFLiqLegImpTotBruto_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm_To)==0) ? "" : GXutil.str( AV57TFLiqLegImpTotBruProm_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruSinSAC_To)==0) ? "" : GXutil.str( AV59TFLiqLegImpTotBruSinSAC_To, 14, 2))+"||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLiqLegImpTotRetGan_To)==0) ? "" : GXutil.str( AV61TFLiqLegImpTotRetGan_To, 14, 2))+"||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV15GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV15GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV15GridState.fromxml(AV28Session.getValue(AV87Pgmname+"GridState"), null, null);
      AV15GridState.setgxTv_SdtWWPGridState_Orderedby( AV17OrderedBy );
      AV15GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV18OrderedDsc );
      AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQNRO", httpContext.getMessage( "Número", ""), !((0==AV29TFLiqNro)&&(0==AV30TFLiqNro_To)), (short)(0), GXutil.trim( GXutil.str( AV29TFLiqNro, 8, 0)), GXutil.trim( GXutil.str( AV30TFLiqNro_To, 8, 0))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQFECHA", httpContext.getMessage( "Fecha de Liq.", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV31TFLiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV32TFLiqFecha_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQPERPALABRA", httpContext.getMessage( "Periodo", ""), !(GXutil.strcmp("", AV37TFLiqPerPalabra)==0), (short)(0), AV37TFLiqPerPalabra, "", !(AV38TFLiqPerPalabra_Sels.size()==0), AV38TFLiqPerPalabra_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQNOMBRE", httpContext.getMessage( "Liquidación", ""), !(GXutil.strcmp("", AV40TFLiqNombre)==0), (short)(0), AV40TFLiqNombre, "", !(AV41TFLiqNombre_Sels.size()==0), AV41TFLiqNombre_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQFECPAGO", httpContext.getMessage( "Fecha de Pago", ""), !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecPago))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecPago_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV42TFLiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), GXutil.trim( localUtil.dtoc( AV43TFLiqFecPago_To, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFTLIQCOD", httpContext.getMessage( "Tipo", ""), !(GXutil.strcmp("", AV48TFTLiqCod)==0), (short)(0), AV48TFTLiqCod, "", !(AV49TFTLiqCod_Sels.size()==0), AV49TFTLiqCod_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQMODTRA_SEL", httpContext.getMessage( "Modo de trabajo", ""), !(AV82TFLiqModTra_Sels.size()==0), (short)(0), AV82TFLiqModTra_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQFRECPAG_SEL", httpContext.getMessage( "Frecuencia de pago", ""), !(AV84TFLiqFrecPag_Sels.size()==0), (short)(0), AV84TFLiqFrecPag_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQLEGIMPBASICO", httpContext.getMessage( "Básico", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpBasico)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpBasico_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV52TFLiqLegImpBasico, 14, 2)), GXutil.trim( GXutil.str( AV53TFLiqLegImpBasico_To, 14, 2))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQLEGIMPTOTBRUTO", httpContext.getMessage( "Bruto", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpTotBruto)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpTotBruto_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV54TFLiqLegImpTotBruto, 14, 2)), GXutil.trim( GXutil.str( AV55TFLiqLegImpTotBruto_To, 14, 2))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQLEGIMPTOTBRUPROM", httpContext.getMessage( "Bruto Prom. sin SAC", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLiqLegImpTotBruProm)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV56TFLiqLegImpTotBruProm, 14, 2)), GXutil.trim( GXutil.str( AV57TFLiqLegImpTotBruProm_To, 14, 2))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQLEGIMPTOTBRUSINSAC", httpContext.getMessage( "Bruto sin SAC", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruSinSAC)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruSinSAC_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV58TFLiqLegImpTotBruSinSAC, 14, 2)), GXutil.trim( GXutil.str( AV59TFLiqLegImpTotBruSinSAC_To, 14, 2))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFLIQLEGIMPTOTRETGAN", httpContext.getMessage( "Imp. Ganancias (Ret/Dev)", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotRetGan)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLiqLegImpTotRetGan_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV60TFLiqLegImpTotRetGan, 14, 2)), GXutil.trim( GXutil.str( AV61TFLiqLegImpTotRetGan_To, 14, 2))) ;
      AV15GridState = GXv_SdtWWPGridState16[0] ;
      if ( ! (0==AV8CliCod) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV8CliCod, 6, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      if ( ! (0==AV9EmpCod) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV9EmpCod, 4, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      if ( ! (0==AV11LegNumero) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LEGNUMERO" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV11LegNumero, 8, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      AV15GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV15GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV13TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV87Pgmname );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV12HTTPRequest.getScriptName()+"?"+AV12HTTPRequest.getQuerystring() );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LiquidacionLegajo" );
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LegNumero" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV11LegNumero, 8, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV28Session.setValue("TrnContext", AV13TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S162( )
   {
      /* 'INITIALIZETOTALIZERS' Routine */
      returnInSub = false ;
      AV73TotLiqLegImpTotBruto = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TotLiqLegImpTotBruto", GXutil.ltrimstr( AV73TotLiqLegImpTotBruto, 18, 2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTBRUTO", getSecureSignedToken( sPrefix, localUtil.format( AV73TotLiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      AV75TotLiqLegImpTotDescu = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75TotLiqLegImpTotDescu", GXutil.ltrimstr( AV75TotLiqLegImpTotDescu, 18, 2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTDESCU", getSecureSignedToken( sPrefix, localUtil.format( AV75TotLiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      AV77TotLiqLegImpTotRetGan = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77TotLiqLegImpTotRetGan", GXutil.ltrimstr( AV77TotLiqLegImpTotRetGan, 18, 2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTRETGAN", getSecureSignedToken( sPrefix, localUtil.format( AV77TotLiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      AV79TotLiqLegImpTotal = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79TotLiqLegImpTotal", GXutil.ltrimstr( AV79TotLiqLegImpTotal, 18, 2));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTAL", getSecureSignedToken( sPrefix, localUtil.format( AV79TotLiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")));
   }

   public void S172( )
   {
      /* 'CALCULATETOTALIZERS' Routine */
      returnInSub = false ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV38TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV41TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV49TFTLiqCod_Sels ,
                                           A2409LiqModTra ,
                                           AV82TFLiqModTra_Sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV84TFLiqFrecPag_Sels ,
                                           Integer.valueOf(AV29TFLiqNro) ,
                                           Integer.valueOf(AV30TFLiqNro_To) ,
                                           AV31TFLiqFecha ,
                                           AV32TFLiqFecha_To ,
                                           Integer.valueOf(AV38TFLiqPerPalabra_Sels.size()) ,
                                           AV37TFLiqPerPalabra ,
                                           Integer.valueOf(AV41TFLiqNombre_Sels.size()) ,
                                           AV40TFLiqNombre ,
                                           AV42TFLiqFecPago ,
                                           AV43TFLiqFecPago_To ,
                                           Integer.valueOf(AV49TFTLiqCod_Sels.size()) ,
                                           AV48TFTLiqCod ,
                                           Integer.valueOf(AV82TFLiqModTra_Sels.size()) ,
                                           Integer.valueOf(AV84TFLiqFrecPag_Sels.size()) ,
                                           AV52TFLiqLegImpBasico ,
                                           AV53TFLiqLegImpBasico_To ,
                                           AV54TFLiqLegImpTotBruto ,
                                           AV55TFLiqLegImpTotBruto_To ,
                                           AV56TFLiqLegImpTotBruProm ,
                                           AV57TFLiqLegImpTotBruProm_To ,
                                           AV58TFLiqLegImpTotBruSinSAC ,
                                           AV59TFLiqLegImpTotBruSinSAC_To ,
                                           AV60TFLiqLegImpTotRetGan ,
                                           AV61TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV11LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV37TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV37TFLiqPerPalabra), 20, "%") ;
      lV40TFLiqNombre = GXutil.concat( GXutil.rtrim( AV40TFLiqNombre), "%", "") ;
      lV48TFTLiqCod = GXutil.concat( GXutil.rtrim( AV48TFTLiqCod), "%", "") ;
      /* Using cursor H00K05 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LegNumero), Integer.valueOf(AV29TFLiqNro), Integer.valueOf(AV30TFLiqNro_To), AV31TFLiqFecha, AV32TFLiqFecha_To, lV37TFLiqPerPalabra, lV40TFLiqNombre, AV42TFLiqFecPago, AV43TFLiqFecPago_To, lV48TFTLiqCod, AV52TFLiqLegImpBasico, AV53TFLiqLegImpBasico_To, AV54TFLiqLegImpTotBruto, AV55TFLiqLegImpTotBruto_To, AV56TFLiqLegImpTotBruProm, AV57TFLiqLegImpTotBruProm_To, AV58TFLiqLegImpTotBruSinSAC, AV59TFLiqLegImpTotBruSinSAC_To, AV60TFLiqLegImpTotRetGan, AV61TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A757LiqLegImpTotRetGan = H00K05_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = H00K05_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = H00K05_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = H00K05_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = H00K05_A760LiqLegImpBasico[0] ;
         A2414LiqFrecPag = H00K05_A2414LiqFrecPag[0] ;
         A2409LiqModTra = H00K05_A2409LiqModTra[0] ;
         A32TLiqCod = H00K05_A32TLiqCod[0] ;
         n32TLiqCod = H00K05_n32TLiqCod[0] ;
         A340TliqDesc = H00K05_A340TliqDesc[0] ;
         A280LiqFecPago = H00K05_A280LiqFecPago[0] ;
         A874LiqNombre = H00K05_A874LiqNombre[0] ;
         A748LiqPerPalabra = H00K05_A748LiqPerPalabra[0] ;
         A98LiqFecha = H00K05_A98LiqFecha[0] ;
         A31LiqNro = H00K05_A31LiqNro[0] ;
         A6LegNumero = H00K05_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A1EmpCod = H00K05_A1EmpCod[0] ;
         A3CliCod = H00K05_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A579LiqLegImpTotDescu = H00K05_A579LiqLegImpTotDescu[0] ;
         A281LiqLegImpTotal = H00K05_A281LiqLegImpTotal[0] ;
         A2414LiqFrecPag = H00K05_A2414LiqFrecPag[0] ;
         A2409LiqModTra = H00K05_A2409LiqModTra[0] ;
         A280LiqFecPago = H00K05_A280LiqFecPago[0] ;
         A874LiqNombre = H00K05_A874LiqNombre[0] ;
         A748LiqPerPalabra = H00K05_A748LiqPerPalabra[0] ;
         A98LiqFecha = H00K05_A98LiqFecha[0] ;
         A340TliqDesc = H00K05_A340TliqDesc[0] ;
         AV73TotLiqLegImpTotBruto = A498LiqLegImpTotBruto.add(AV73TotLiqLegImpTotBruto) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TotLiqLegImpTotBruto", GXutil.ltrimstr( AV73TotLiqLegImpTotBruto, 18, 2));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTBRUTO", getSecureSignedToken( sPrefix, localUtil.format( AV73TotLiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")));
         AV20LiqLegImpTotDescu = A579LiqLegImpTotDescu.multiply(DecimalUtil.doubleToDec(-1)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavLiqlegimptotdescu_Internalname, GXutil.ltrimstr( AV20LiqLegImpTotDescu, 14, 2));
         AV75TotLiqLegImpTotDescu = AV20LiqLegImpTotDescu.add(AV75TotLiqLegImpTotDescu) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75TotLiqLegImpTotDescu", GXutil.ltrimstr( AV75TotLiqLegImpTotDescu, 18, 2));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTDESCU", getSecureSignedToken( sPrefix, localUtil.format( AV75TotLiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")));
         AV77TotLiqLegImpTotRetGan = A757LiqLegImpTotRetGan.add(AV77TotLiqLegImpTotRetGan) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77TotLiqLegImpTotRetGan", GXutil.ltrimstr( AV77TotLiqLegImpTotRetGan, 18, 2));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTRETGAN", getSecureSignedToken( sPrefix, localUtil.format( AV77TotLiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")));
         AV79TotLiqLegImpTotal = A281LiqLegImpTotal.add(AV79TotLiqLegImpTotal) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79TotLiqLegImpTotal", GXutil.ltrimstr( AV79TotLiqLegImpTotal, 18, 2));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTOTLIQLEGIMPTOTAL", getSecureSignedToken( sPrefix, localUtil.format( AV79TotLiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")));
         pr_default.readNext(3);
      }
      pr_default.close(3);
      AV74TotValueLiqLegImpTotBruto = localUtil.format( AV73TotLiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TotValueLiqLegImpTotBruto", AV74TotValueLiqLegImpTotBruto);
      AV76TotValueLiqLegImpTotDescu = localUtil.format( AV75TotLiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76TotValueLiqLegImpTotDescu", AV76TotValueLiqLegImpTotDescu);
      AV78TotValueLiqLegImpTotRetGan = localUtil.format( AV77TotLiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78TotValueLiqLegImpTotRetGan", AV78TotValueLiqLegImpTotRetGan);
      AV80TotValueLiqLegImpTotal = localUtil.format( AV79TotLiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80TotValueLiqLegImpTotal", AV80TotValueLiqLegImpTotal);
   }

   public void wb_table1_6_K02( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupColoredActions", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Active images/pictures */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Image" + " " + ((GXutil.strcmp(imgBtnexport_gximage, "")==0) ? "GX_Image_(none)_Class" : "GX_Image_"+imgBtnexport_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = "(none)" ;
         web.GxWebStd.gx_bitmap( httpContext, imgBtnexport_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", httpContext.getMessage( "WWP_ExportTooltip", ""), 0, 0, 0, "px", 0, "px", 0, 0, 5, imgBtnexport_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOEXPORT\\'."+"'", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" "+TempTags, "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_liquidacionesWC.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 22, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_EditColumnsCaption", ""), bttBtneditcolumns_Jsonclick, 0, httpContext.getMessage( "WWP_EditColumnsTooltip", ""), "", StyleString, ClassString, 1, 0, "standard", "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_liquidacionesWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid GridNoBorderCell GridFixedColumnBorders HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol22( ) ;
      }
      if ( wbEnd == 22 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_22 = (int)(nGXsfl_22_idx-1) ;
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row Invisible", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_45_K02( true) ;
      }
      else
      {
         wb_table2_45_K02( false) ;
      }
      return  ;
   }

   public void wb_table2_45_K02e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         ucGridpaginationbar.setProperty("CurrentPage", AV66GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV67GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV68GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_6_K02e( true) ;
      }
      else
      {
         wb_table1_6_K02e( false) ;
      }
   }

   public void wb_table2_45_K02( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblGridtabletotalizer_Internalname, tblGridtabletotalizer_Internalname, "", "TableTotalizerAl", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTotvalueliqlegimptotbruto_Internalname, httpContext.getMessage( "Tot Value Liq Leg Imp Tot Bruto", ""), "gx-form-item AttributeTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'" + sPrefix + "',false,'" + sGXsfl_22_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueliqlegimptotbruto_Internalname, AV74TotValueLiqLegImpTotBruto, GXutil.rtrim( localUtil.format( AV74TotValueLiqLegImpTotBruto, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueliqlegimptotbruto_Jsonclick, 0, "AttributeTotalizer", "", "", "", "", 1, edtavTotvalueliqlegimptotbruto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_liquidacionesWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTotvalueliqlegimptotdescu_Internalname, httpContext.getMessage( "Tot Value Liq Leg Imp Tot Descu", ""), "gx-form-item AttributeTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'" + sPrefix + "',false,'" + sGXsfl_22_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueliqlegimptotdescu_Internalname, AV76TotValueLiqLegImpTotDescu, GXutil.rtrim( localUtil.format( AV76TotValueLiqLegImpTotDescu, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueliqlegimptotdescu_Jsonclick, 0, "AttributeTotalizer", "", "", "", "", 1, edtavTotvalueliqlegimptotdescu_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_liquidacionesWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTotvalueliqlegimptotretgan_Internalname, httpContext.getMessage( "Tot Value Liq Leg Imp Tot Ret Gan", ""), "gx-form-item AttributeTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'" + sPrefix + "',false,'" + sGXsfl_22_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueliqlegimptotretgan_Internalname, AV78TotValueLiqLegImpTotRetGan, GXutil.rtrim( localUtil.format( AV78TotValueLiqLegImpTotRetGan, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueliqlegimptotretgan_Jsonclick, 0, "AttributeTotalizer", "", "", "", "", 1, edtavTotvalueliqlegimptotretgan_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_liquidacionesWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTotvalueliqlegimptotal_Internalname, httpContext.getMessage( "Tot Value Liq Leg Imp Total", ""), "gx-form-item AttributeTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'" + sGXsfl_22_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueliqlegimptotal_Internalname, AV80TotValueLiqLegImpTotal, GXutil.rtrim( localUtil.format( AV80TotValueLiqLegImpTotal, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueliqlegimptotal_Jsonclick, 0, "AttributeTotalizer", "", "", "", "", 1, edtavTotvalueliqlegimptotal_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_liquidacionesWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_45_K02e( true) ;
      }
      else
      {
         wb_table2_45_K02e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      AV11LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegNumero), 8, 0));
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
      paK02( ) ;
      wsK02( ) ;
      weK02( ) ;
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
      sCtrlAV8CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV9EmpCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV11LegNumero = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paK02( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "liquidacioneswc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paK02( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
         AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
         AV11LegNumero = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegNumero), 8, 0));
      }
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV11LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( AV11LegNumero != wcpOAV11LegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV11LegNumero = AV11LegNumero ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
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
      sCtrlAV11LegNumero = httpContext.cgiGet( sPrefix+"AV11LegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV11LegNumero) > 0 )
      {
         AV11LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV11LegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LegNumero), 8, 0));
      }
      else
      {
         AV11LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV11LegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paK02( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsK02( ) ;
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
      wsK02( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11LegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV11LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11LegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11LegNumero_CTRL", GXutil.rtrim( sCtrlAV11LegNumero));
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
      weK02( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025188284925", true, true);
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
      httpContext.AddJavascriptSource("liquidacioneswc.js", "?2025188284925", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_222( )
   {
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_22_idx ;
      edtLiqNro_Internalname = sPrefix+"LIQNRO_"+sGXsfl_22_idx ;
      edtLiqFecha_Internalname = sPrefix+"LIQFECHA_"+sGXsfl_22_idx ;
      edtLiqPerSinDia_Internalname = sPrefix+"LIQPERSINDIA_"+sGXsfl_22_idx ;
      edtLiqPerPalabra_Internalname = sPrefix+"LIQPERPALABRA_"+sGXsfl_22_idx ;
      edtLiqNombre_Internalname = sPrefix+"LIQNOMBRE_"+sGXsfl_22_idx ;
      edtLiqFecPago_Internalname = sPrefix+"LIQFECPAGO_"+sGXsfl_22_idx ;
      dynTLiqCod.setInternalname( sPrefix+"TLIQCOD_"+sGXsfl_22_idx );
      cmbLiqClase.setInternalname( sPrefix+"LIQCLASE_"+sGXsfl_22_idx );
      cmbLiqModTra.setInternalname( sPrefix+"LIQMODTRA_"+sGXsfl_22_idx );
      cmbLiqFrecPag.setInternalname( sPrefix+"LIQFRECPAG_"+sGXsfl_22_idx );
      edtLiqLegImpBasico_Internalname = sPrefix+"LIQLEGIMPBASICO_"+sGXsfl_22_idx ;
      edtLiqLegImpTotBruto_Internalname = sPrefix+"LIQLEGIMPTOTBRUTO_"+sGXsfl_22_idx ;
      edtLiqLegImpTotBruProm_Internalname = sPrefix+"LIQLEGIMPTOTBRUPROM_"+sGXsfl_22_idx ;
      edtLiqLegImpTotBruSinSAC_Internalname = sPrefix+"LIQLEGIMPTOTBRUSINSAC_"+sGXsfl_22_idx ;
      edtLiqLegImpTotDescu_Internalname = sPrefix+"LIQLEGIMPTOTDESCU_"+sGXsfl_22_idx ;
      edtavLiqlegimptotdescu_Internalname = sPrefix+"vLIQLEGIMPTOTDESCU_"+sGXsfl_22_idx ;
      edtLiqLegImpTotRetGan_Internalname = sPrefix+"LIQLEGIMPTOTRETGAN_"+sGXsfl_22_idx ;
      edtLiqLegImpTotal_Internalname = sPrefix+"LIQLEGIMPTOTAL_"+sGXsfl_22_idx ;
      edtavErrorliqleg_Internalname = sPrefix+"vERRORLIQLEG_"+sGXsfl_22_idx ;
   }

   public void subsflControlProps_fel_222( )
   {
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_22_fel_idx ;
      edtLiqNro_Internalname = sPrefix+"LIQNRO_"+sGXsfl_22_fel_idx ;
      edtLiqFecha_Internalname = sPrefix+"LIQFECHA_"+sGXsfl_22_fel_idx ;
      edtLiqPerSinDia_Internalname = sPrefix+"LIQPERSINDIA_"+sGXsfl_22_fel_idx ;
      edtLiqPerPalabra_Internalname = sPrefix+"LIQPERPALABRA_"+sGXsfl_22_fel_idx ;
      edtLiqNombre_Internalname = sPrefix+"LIQNOMBRE_"+sGXsfl_22_fel_idx ;
      edtLiqFecPago_Internalname = sPrefix+"LIQFECPAGO_"+sGXsfl_22_fel_idx ;
      dynTLiqCod.setInternalname( sPrefix+"TLIQCOD_"+sGXsfl_22_fel_idx );
      cmbLiqClase.setInternalname( sPrefix+"LIQCLASE_"+sGXsfl_22_fel_idx );
      cmbLiqModTra.setInternalname( sPrefix+"LIQMODTRA_"+sGXsfl_22_fel_idx );
      cmbLiqFrecPag.setInternalname( sPrefix+"LIQFRECPAG_"+sGXsfl_22_fel_idx );
      edtLiqLegImpBasico_Internalname = sPrefix+"LIQLEGIMPBASICO_"+sGXsfl_22_fel_idx ;
      edtLiqLegImpTotBruto_Internalname = sPrefix+"LIQLEGIMPTOTBRUTO_"+sGXsfl_22_fel_idx ;
      edtLiqLegImpTotBruProm_Internalname = sPrefix+"LIQLEGIMPTOTBRUPROM_"+sGXsfl_22_fel_idx ;
      edtLiqLegImpTotBruSinSAC_Internalname = sPrefix+"LIQLEGIMPTOTBRUSINSAC_"+sGXsfl_22_fel_idx ;
      edtLiqLegImpTotDescu_Internalname = sPrefix+"LIQLEGIMPTOTDESCU_"+sGXsfl_22_fel_idx ;
      edtavLiqlegimptotdescu_Internalname = sPrefix+"vLIQLEGIMPTOTDESCU_"+sGXsfl_22_fel_idx ;
      edtLiqLegImpTotRetGan_Internalname = sPrefix+"LIQLEGIMPTOTRETGAN_"+sGXsfl_22_fel_idx ;
      edtLiqLegImpTotal_Internalname = sPrefix+"LIQLEGIMPTOTAL_"+sGXsfl_22_fel_idx ;
      edtavErrorliqleg_Internalname = sPrefix+"vERRORLIQLEG_"+sGXsfl_22_fel_idx ;
   }

   public void sendrow_222( )
   {
      subsflControlProps_222( ) ;
      wbK00( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_22_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_22_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"GridWithTotalizer GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_22_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqNro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNro_Internalname,GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqNro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqFecha_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqFecha_Internalname,localUtil.format(A98LiqFecha, "99/99/9999"),localUtil.format( A98LiqFecha, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqFecha_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqPerSinDia_Internalname,GXutil.rtrim( A513LiqPerSinDia),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqPerSinDia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqPerPalabra_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqPerPalabra_Internalname,GXutil.rtrim( A748LiqPerPalabra),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqPerPalabra_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqPerPalabra_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNombre_Internalname,A874LiqNombre,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqFecPago_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqFecPago_Internalname,localUtil.format(A280LiqFecPago, "99/99/9999"),localUtil.format( A280LiqFecPago, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqFecPago_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqFecPago_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         gxatliqcod_htmlK02( ) ;
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((dynTLiqCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( dynTLiqCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "TLIQCOD_" + sGXsfl_22_idx ;
            dynTLiqCod.setName( GXCCtl );
            dynTLiqCod.setWebtags( "" );
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynTLiqCod,dynTLiqCod.getInternalname(),GXutil.rtrim( A32TLiqCod),Integer.valueOf(1),dynTLiqCod.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(dynTLiqCod.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         dynTLiqCod.setValue( GXutil.rtrim( A32TLiqCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynTLiqCod.getInternalname(), "Values", dynTLiqCod.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         GXCCtl = "LIQCLASE_" + sGXsfl_22_idx ;
         cmbLiqClase.setName( GXCCtl );
         cmbLiqClase.setWebtags( "" );
         cmbLiqClase.addItem("0", httpContext.getMessage( "Mensual", ""), (short)(0));
         cmbLiqClase.addItem("1", httpContext.getMessage( "Jornal", ""), (short)(0));
         if ( cmbLiqClase.getItemCount() > 0 )
         {
            A268LiqClase = (byte)(GXutil.lval( cmbLiqClase.getValidValue(GXutil.trim( GXutil.str( A268LiqClase, 1, 0))))) ;
            n268LiqClase = false ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqClase,cmbLiqClase.getInternalname(),GXutil.trim( GXutil.str( A268LiqClase, 1, 0)),Integer.valueOf(1),cmbLiqClase.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqClase.setValue( GXutil.trim( GXutil.str( A268LiqClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqClase.getInternalname(), "Values", cmbLiqClase.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLiqModTra.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LIQMODTRA_" + sGXsfl_22_idx ;
         cmbLiqModTra.setName( GXCCtl );
         cmbLiqModTra.setWebtags( "" );
         cmbLiqModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
         cmbLiqModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
         if ( cmbLiqModTra.getItemCount() > 0 )
         {
            A2409LiqModTra = cmbLiqModTra.getValidValue(A2409LiqModTra) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqModTra,cmbLiqModTra.getInternalname(),GXutil.rtrim( A2409LiqModTra),Integer.valueOf(1),cmbLiqModTra.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLiqModTra.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqModTra.setValue( GXutil.rtrim( A2409LiqModTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqModTra.getInternalname(), "Values", cmbLiqModTra.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLiqFrecPag.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LIQFRECPAG_" + sGXsfl_22_idx ;
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
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLiqFrecPag,cmbLiqFrecPag.getInternalname(),GXutil.trim( GXutil.str( A2414LiqFrecPag, 1, 0)),Integer.valueOf(1),cmbLiqFrecPag.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLiqFrecPag.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLiqFrecPag.setValue( GXutil.trim( GXutil.str( A2414LiqFrecPag, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLiqFrecPag.getInternalname(), "Values", cmbLiqFrecPag.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpBasico_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A760LiqLegImpBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A760LiqLegImpBasico, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpBasico_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotBruto_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotBruto_Internalname,GXutil.ltrim( localUtil.ntoc( A498LiqLegImpTotBruto, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A498LiqLegImpTotBruto, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotBruto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpTotBruto_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotBruProm_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotBruProm_Internalname,GXutil.ltrim( localUtil.ntoc( A758LiqLegImpTotBruProm, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A758LiqLegImpTotBruProm, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotBruProm_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpTotBruProm_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotBruSinSAC_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotBruSinSAC_Internalname,GXutil.ltrim( localUtil.ntoc( A759LiqLegImpTotBruSinSAC, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A759LiqLegImpTotBruSinSAC, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotBruSinSAC_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpTotBruSinSAC_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotDescu_Internalname,GXutil.ltrim( localUtil.ntoc( A579LiqLegImpTotDescu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A579LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotDescu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtavLiqlegimptotdescu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavLiqlegimptotdescu_Internalname,GXutil.ltrim( localUtil.ntoc( AV20LiqLegImpTotDescu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavLiqlegimptotdescu_Enabled!=0) ? localUtil.format( AV20LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV20LiqLegImpTotDescu, "ZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavLiqlegimptotdescu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavLiqlegimptotdescu_Visible),Integer.valueOf(edtavLiqlegimptotdescu_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotRetGan_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotRetGan_Internalname,GXutil.ltrim( localUtil.ntoc( A757LiqLegImpTotRetGan, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A757LiqLegImpTotRetGan, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotRetGan_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqLegImpTotRetGan_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqLegImpTotal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqLegImpTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A281LiqLegImpTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A281LiqLegImpTotal, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLiqLegImpTotal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqLegImpTotal_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavErrorliqleg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavErrorliqleg_Internalname,AV21ErrorLiqLeg,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavErrorliqleg_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavErrorliqleg_Visible),Integer.valueOf(edtavErrorliqleg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesK02( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_22_idx = ((subGrid_Islastpage==1)&&(nGXsfl_22_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_22_idx+1) ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
      }
      /* End function sendrow_222 */
   }

   public void startgridcontrol22( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"22\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithTotalizer GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqNro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Número", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de Liq.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqPerPalabra_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqFecPago_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de Pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((dynTLiqCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLiqModTra.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Modo de trabajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLiqFrecPag.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Frecuencia de pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpBasico_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Básico", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotBruto_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotBruProm_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto Prom. sin SAC", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotBruSinSAC_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto sin SAC", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavLiqlegimptotdescu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descuentos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotRetGan_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp. Ganancias (Ret/Dev)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqLegImpTotal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Neto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavErrorliqleg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Error", "")) ;
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
         GridContainer.AddObjectProperty("Class", "GridWithTotalizer GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", sPrefix);
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqNro_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A98LiqFecha, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqFecha_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A513LiqPerSinDia));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A748LiqPerPalabra));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqPerPalabra_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A874LiqNombre);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqNombre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A280LiqFecPago, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqFecPago_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A32TLiqCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( dynTLiqCod.getVisible(), (byte)(5), (byte)(0), ".", "")));
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A760LiqLegImpBasico, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpBasico_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A498LiqLegImpTotBruto, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotBruto_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A758LiqLegImpTotBruProm, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotBruProm_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A759LiqLegImpTotBruSinSAC, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotBruSinSAC_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A579LiqLegImpTotDescu, (byte)(17), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV20LiqLegImpTotDescu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavLiqlegimptotdescu_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavLiqlegimptotdescu_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A757LiqLegImpTotRetGan, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotRetGan_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A281LiqLegImpTotal, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqLegImpTotal_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV21ErrorLiqLeg);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavErrorliqleg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavErrorliqleg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      imgBtnexport_Internalname = sPrefix+"BTNEXPORT" ;
      bttBtneditcolumns_Internalname = sPrefix+"BTNEDITCOLUMNS" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLiqNro_Internalname = sPrefix+"LIQNRO" ;
      edtLiqFecha_Internalname = sPrefix+"LIQFECHA" ;
      edtLiqPerSinDia_Internalname = sPrefix+"LIQPERSINDIA" ;
      edtLiqPerPalabra_Internalname = sPrefix+"LIQPERPALABRA" ;
      edtLiqNombre_Internalname = sPrefix+"LIQNOMBRE" ;
      edtLiqFecPago_Internalname = sPrefix+"LIQFECPAGO" ;
      dynTLiqCod.setInternalname( sPrefix+"TLIQCOD" );
      cmbLiqClase.setInternalname( sPrefix+"LIQCLASE" );
      cmbLiqModTra.setInternalname( sPrefix+"LIQMODTRA" );
      cmbLiqFrecPag.setInternalname( sPrefix+"LIQFRECPAG" );
      edtLiqLegImpBasico_Internalname = sPrefix+"LIQLEGIMPBASICO" ;
      edtLiqLegImpTotBruto_Internalname = sPrefix+"LIQLEGIMPTOTBRUTO" ;
      edtLiqLegImpTotBruProm_Internalname = sPrefix+"LIQLEGIMPTOTBRUPROM" ;
      edtLiqLegImpTotBruSinSAC_Internalname = sPrefix+"LIQLEGIMPTOTBRUSINSAC" ;
      edtLiqLegImpTotDescu_Internalname = sPrefix+"LIQLEGIMPTOTDESCU" ;
      edtavLiqlegimptotdescu_Internalname = sPrefix+"vLIQLEGIMPTOTDESCU" ;
      edtLiqLegImpTotRetGan_Internalname = sPrefix+"LIQLEGIMPTOTRETGAN" ;
      edtLiqLegImpTotal_Internalname = sPrefix+"LIQLEGIMPTOTAL" ;
      edtavErrorliqleg_Internalname = sPrefix+"vERRORLIQLEG" ;
      edtavTotvalueliqlegimptotbruto_Internalname = sPrefix+"vTOTVALUELIQLEGIMPTOTBRUTO" ;
      edtavTotvalueliqlegimptotdescu_Internalname = sPrefix+"vTOTVALUELIQLEGIMPTOTDESCU" ;
      edtavTotvalueliqlegimptotretgan_Internalname = sPrefix+"vTOTVALUELIQLEGIMPTOTRETGAN" ;
      edtavTotvalueliqlegimptotal_Internalname = sPrefix+"vTOTVALUELIQLEGIMPTOTAL" ;
      tblGridtabletotalizer_Internalname = sPrefix+"GRIDTABLETOTALIZER" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      Ddo_gridcolumnsselector_Internalname = sPrefix+"DDO_GRIDCOLUMNSSELECTOR" ;
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
      edtavErrorliqleg_Jsonclick = "" ;
      edtavErrorliqleg_Enabled = 0 ;
      edtLiqLegImpTotal_Jsonclick = "" ;
      edtLiqLegImpTotRetGan_Jsonclick = "" ;
      edtavLiqlegimptotdescu_Jsonclick = "" ;
      edtavLiqlegimptotdescu_Enabled = 0 ;
      edtLiqLegImpTotDescu_Jsonclick = "" ;
      edtLiqLegImpTotBruSinSAC_Jsonclick = "" ;
      edtLiqLegImpTotBruProm_Jsonclick = "" ;
      edtLiqLegImpTotBruto_Jsonclick = "" ;
      edtLiqLegImpBasico_Jsonclick = "" ;
      cmbLiqFrecPag.setJsonclick( "" );
      cmbLiqModTra.setJsonclick( "" );
      cmbLiqClase.setJsonclick( "" );
      dynTLiqCod.setJsonclick( "" );
      edtLiqFecPago_Jsonclick = "" ;
      edtLiqNombre_Jsonclick = "" ;
      edtLiqPerPalabra_Jsonclick = "" ;
      edtLiqPerSinDia_Jsonclick = "" ;
      edtLiqFecha_Jsonclick = "" ;
      edtLiqNro_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      subGrid_Class = "GridWithTotalizer GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavTotvalueliqlegimptotal_Jsonclick = "" ;
      edtavTotvalueliqlegimptotal_Enabled = 1 ;
      edtavTotvalueliqlegimptotretgan_Jsonclick = "" ;
      edtavTotvalueliqlegimptotretgan_Enabled = 1 ;
      edtavTotvalueliqlegimptotdescu_Jsonclick = "" ;
      edtavTotvalueliqlegimptotdescu_Enabled = 1 ;
      edtavTotvalueliqlegimptotbruto_Jsonclick = "" ;
      edtavTotvalueliqlegimptotbruto_Enabled = 1 ;
      edtavErrorliqleg_Visible = -1 ;
      edtLiqLegImpTotal_Visible = -1 ;
      edtLiqLegImpTotRetGan_Visible = -1 ;
      edtavLiqlegimptotdescu_Visible = -1 ;
      edtLiqLegImpTotBruSinSAC_Visible = -1 ;
      edtLiqLegImpTotBruProm_Visible = -1 ;
      edtLiqLegImpTotBruto_Visible = -1 ;
      edtLiqLegImpBasico_Visible = -1 ;
      cmbLiqFrecPag.setVisible( -1 );
      cmbLiqModTra.setVisible( -1 );
      dynTLiqCod.setVisible( -1 );
      edtLiqFecPago_Visible = -1 ;
      edtLiqNombre_Visible = -1 ;
      edtLiqPerPalabra_Visible = -1 ;
      edtLiqFecha_Visible = -1 ;
      edtLiqNro_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_liqfecpagoauxdatetext_Jsonclick = "" ;
      edtavDdo_liqfechaauxdatetext_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = "" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector hidden-xs" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "WWP_EditColumnsCaption", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Ddo_grid_Format = "8.0||||||||-14.2|-14.2|-14.2|-14.2||-14.2||" ;
      Ddo_grid_Datalistproc = "liquidacionesWCGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||E:Empleado,I:Independiente|1:Mensual,2:Quincenal,3:Semanal,4:Diaria||||||||" ;
      Ddo_grid_Allowmultipleselection = "||T|T||T|T|T||||||||" ;
      Ddo_grid_Datalisttype = "||Dynamic|Dynamic||Dynamic|FixedValues|FixedValues||||||||" ;
      Ddo_grid_Includedatalist = "||T|T||T|T|T||||||||" ;
      Ddo_grid_Filterisrange = "T|P|||P||||T|T|T|T||T||" ;
      Ddo_grid_Filtertype = "Numeric|Date|Character|Character|Date|Character|||Numeric|Numeric|Numeric|Numeric||Numeric||" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|||T|T|T|T||T||" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T|T|T|T|T|T|T|T|T|T|T|T||T|T|" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7|8|9|10|11|12|13||14|15|" ;
      Ddo_grid_Columnids = "1:LiqNro|2:LiqFecha|4:LiqPerPalabra|5:LiqNombre|6:LiqFecPago|7:TLiqCod|9:LiqModTra|10:LiqFrecPag|11:LiqLegImpBasico|12:LiqLegImpTotBruto|13:LiqLegImpTotBruProm|14:LiqLegImpTotBruSinSAC|16:LiqLegImpTotDescu|17:LiqLegImpTotRetGan|18:LiqLegImpTotal|19:ErrorLiqLeg" ;
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
      GXCCtl = "TLIQCOD_" + sGXsfl_22_idx ;
      dynTLiqCod.setName( GXCCtl );
      dynTLiqCod.setWebtags( "" );
      GXCCtl = "LIQCLASE_" + sGXsfl_22_idx ;
      cmbLiqClase.setName( GXCCtl );
      cmbLiqClase.setWebtags( "" );
      cmbLiqClase.addItem("0", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLiqClase.addItem("1", httpContext.getMessage( "Jornal", ""), (short)(0));
      if ( cmbLiqClase.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQMODTRA_" + sGXsfl_22_idx ;
      cmbLiqModTra.setName( GXCCtl );
      cmbLiqModTra.setWebtags( "" );
      cmbLiqModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbLiqModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbLiqModTra.getItemCount() > 0 )
      {
      }
      GXCCtl = "LIQFRECPAG_" + sGXsfl_22_idx ;
      cmbLiqFrecPag.setName( GXCCtl );
      cmbLiqFrecPag.setWebtags( "" );
      cmbLiqFrecPag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLiqFrecPag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbLiqFrecPag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbLiqFrecPag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbLiqFrecPag.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV11LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV30TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV31TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV32TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV37TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV38TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV40TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV41TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV42TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV43TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV48TFTLiqCod',fld:'vTFTLIQCOD',pic:'@!'},{av:'AV49TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV82TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV84TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV52TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV54TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV55TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLiqLegImpTotBruProm',fld:'vTFLIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV57TFLiqLegImpTotBruProm_To',fld:'vTFLIQLEGIMPTOTBRUPROM_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV59TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV60TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A98LiqFecha',fld:'LIQFECHA',pic:''},{av:'A748LiqPerPalabra',fld:'LIQPERPALABRA',pic:''},{av:'A874LiqNombre',fld:'LIQNOMBRE',pic:''},{av:'A280LiqFecPago',fld:'LIQFECPAGO',pic:''},{av:'A340TliqDesc',fld:'TLIQDESC',pic:'@!'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'cmbLiqModTra'},{av:'A2409LiqModTra',fld:'LIQMODTRA',pic:''},{av:'cmbLiqFrecPag'},{av:'A2414LiqFrecPag',fld:'LIQFRECPAG',pic:'9'},{av:'A760LiqLegImpBasico',fld:'LIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A498LiqLegImpTotBruto',fld:'LIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A758LiqLegImpTotBruProm',fld:'LIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A759LiqLegImpTotBruSinSAC',fld:'LIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A757LiqLegImpTotRetGan',fld:'LIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A281LiqLegImpTotal',fld:'LIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'dynTLiqCod'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotBruProm_Visible',ctrl:'LIQLEGIMPTOTBRUPROM',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtavErrorliqleg_Visible',ctrl:'vERRORLIQLEG',prop:'Visible'},{av:'AV66GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV67GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV68GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV20LiqLegImpTotDescu',fld:'vLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV74TotValueLiqLegImpTotBruto',fld:'vTOTVALUELIQLEGIMPTOTBRUTO',pic:''},{av:'AV76TotValueLiqLegImpTotDescu',fld:'vTOTVALUELIQLEGIMPTOTDESCU',pic:''},{av:'AV78TotValueLiqLegImpTotRetGan',fld:'vTOTVALUELIQLEGIMPTOTRETGAN',pic:''},{av:'AV80TotValueLiqLegImpTotal',fld:'vTOTVALUELIQLEGIMPTOTAL',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11K02',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV11LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV30TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV31TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV32TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV37TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV38TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV40TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV41TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV42TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV43TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV48TFTLiqCod',fld:'vTFTLIQCOD',pic:'@!'},{av:'AV49TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV82TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV84TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV52TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV54TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV55TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLiqLegImpTotBruProm',fld:'vTFLIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV57TFLiqLegImpTotBruProm_To',fld:'vTFLIQLEGIMPTOTBRUPROM_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV59TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV60TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12K02',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV11LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV30TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV31TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV32TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV37TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV38TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV40TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV41TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV42TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV43TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV48TFTLiqCod',fld:'vTFTLIQCOD',pic:'@!'},{av:'AV49TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV82TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV84TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV52TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV54TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV55TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLiqLegImpTotBruProm',fld:'vTFLIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV57TFLiqLegImpTotBruProm_To',fld:'vTFLIQLEGIMPTOTBRUPROM_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV59TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV60TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13K02',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV11LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV30TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV31TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV32TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV37TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV38TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV40TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV41TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV42TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV43TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV48TFTLiqCod',fld:'vTFTLIQCOD',pic:'@!'},{av:'AV49TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV82TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV84TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV52TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV54TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV55TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLiqLegImpTotBruProm',fld:'vTFLIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV57TFLiqLegImpTotBruProm_To',fld:'vTFLIQLEGIMPTOTBRUPROM_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV59TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV60TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV60TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV59TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLiqLegImpTotBruProm',fld:'vTFLIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV57TFLiqLegImpTotBruProm_To',fld:'vTFLIQLEGIMPTOTBRUPROM_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV54TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV55TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV52TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqFrecPag_SelsJson',fld:'vTFLIQFRECPAG_SELSJSON',pic:''},{av:'AV84TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV81TFLiqModTra_SelsJson',fld:'vTFLIQMODTRA_SELSJSON',pic:''},{av:'AV82TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV48TFTLiqCod',fld:'vTFTLIQCOD',pic:'@!'},{av:'AV47TFTLiqCod_SelsJson',fld:'vTFTLIQCOD_SELSJSON',pic:''},{av:'AV49TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV42TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV43TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV40TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV39TFLiqNombre_SelsJson',fld:'vTFLIQNOMBRE_SELSJSON',pic:''},{av:'AV41TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV36TFLiqPerPalabra_SelsJson',fld:'vTFLIQPERPALABRA_SELSJSON',pic:''},{av:'AV38TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV31TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV32TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV29TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV30TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e18K02',iparms:[{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV20LiqLegImpTotDescu',fld:'vLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV21ErrorLiqLeg',fld:'vERRORLIQLEG',pic:''}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e14K02',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV11LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV29TFLiqNro',fld:'vTFLIQNRO',pic:'ZZZZZZZ9'},{av:'AV30TFLiqNro_To',fld:'vTFLIQNRO_TO',pic:'ZZZZZZZ9'},{av:'AV31TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV32TFLiqFecha_To',fld:'vTFLIQFECHA_TO',pic:''},{av:'AV37TFLiqPerPalabra',fld:'vTFLIQPERPALABRA',pic:''},{av:'AV38TFLiqPerPalabra_Sels',fld:'vTFLIQPERPALABRA_SELS',pic:''},{av:'AV40TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV41TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV42TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV43TFLiqFecPago_To',fld:'vTFLIQFECPAGO_TO',pic:''},{av:'AV48TFTLiqCod',fld:'vTFTLIQCOD',pic:'@!'},{av:'AV49TFTLiqCod_Sels',fld:'vTFTLIQCOD_SELS',pic:''},{av:'AV82TFLiqModTra_Sels',fld:'vTFLIQMODTRA_SELS',pic:''},{av:'AV84TFLiqFrecPag_Sels',fld:'vTFLIQFRECPAG_SELS',pic:''},{av:'AV52TFLiqLegImpBasico',fld:'vTFLIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV53TFLiqLegImpBasico_To',fld:'vTFLIQLEGIMPBASICO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV54TFLiqLegImpTotBruto',fld:'vTFLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV55TFLiqLegImpTotBruto_To',fld:'vTFLIQLEGIMPTOTBRUTO_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLiqLegImpTotBruProm',fld:'vTFLIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV57TFLiqLegImpTotBruProm_To',fld:'vTFLIQLEGIMPTOTBRUPROM_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV58TFLiqLegImpTotBruSinSAC',fld:'vTFLIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV59TFLiqLegImpTotBruSinSAC_To',fld:'vTFLIQLEGIMPTOTBRUSINSAC_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV60TFLiqLegImpTotRetGan',fld:'vTFLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV61TFLiqLegImpTotRetGan_To',fld:'vTFLIQLEGIMPTOTRETGAN_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A31LiqNro',fld:'LIQNRO',pic:'ZZZZZZZ9'},{av:'A98LiqFecha',fld:'LIQFECHA',pic:''},{av:'A748LiqPerPalabra',fld:'LIQPERPALABRA',pic:''},{av:'A874LiqNombre',fld:'LIQNOMBRE',pic:''},{av:'A280LiqFecPago',fld:'LIQFECPAGO',pic:''},{av:'A340TliqDesc',fld:'TLIQDESC',pic:'@!'},{av:'dynTLiqCod'},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'cmbLiqModTra'},{av:'A2409LiqModTra',fld:'LIQMODTRA',pic:''},{av:'cmbLiqFrecPag'},{av:'A2414LiqFrecPag',fld:'LIQFRECPAG',pic:'9'},{av:'A760LiqLegImpBasico',fld:'LIQLEGIMPBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A498LiqLegImpTotBruto',fld:'LIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A758LiqLegImpTotBruProm',fld:'LIQLEGIMPTOTBRUPROM',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A759LiqLegImpTotBruSinSAC',fld:'LIQLEGIMPTOTBRUSINSAC',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A757LiqLegImpTotRetGan',fld:'LIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A579LiqLegImpTotDescu',fld:'LIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A281LiqLegImpTotal',fld:'LIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV26ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerPalabra_Visible',ctrl:'LIQPERPALABRA',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'dynTLiqCod'},{av:'cmbLiqModTra'},{av:'cmbLiqFrecPag'},{av:'edtLiqLegImpBasico_Visible',ctrl:'LIQLEGIMPBASICO',prop:'Visible'},{av:'edtLiqLegImpTotBruto_Visible',ctrl:'LIQLEGIMPTOTBRUTO',prop:'Visible'},{av:'edtLiqLegImpTotBruProm_Visible',ctrl:'LIQLEGIMPTOTBRUPROM',prop:'Visible'},{av:'edtLiqLegImpTotBruSinSAC_Visible',ctrl:'LIQLEGIMPTOTBRUSINSAC',prop:'Visible'},{av:'edtavLiqlegimptotdescu_Visible',ctrl:'vLIQLEGIMPTOTDESCU',prop:'Visible'},{av:'edtLiqLegImpTotRetGan_Visible',ctrl:'LIQLEGIMPTOTRETGAN',prop:'Visible'},{av:'edtLiqLegImpTotal_Visible',ctrl:'LIQLEGIMPTOTAL',prop:'Visible'},{av:'edtavErrorliqleg_Visible',ctrl:'vERRORLIQLEG',prop:'Visible'},{av:'AV66GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV67GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV68GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73TotLiqLegImpTotBruto',fld:'vTOTLIQLEGIMPTOTBRUTO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV75TotLiqLegImpTotDescu',fld:'vTOTLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV77TotLiqLegImpTotRetGan',fld:'vTOTLIQLEGIMPTOTRETGAN',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV79TotLiqLegImpTotal',fld:'vTOTLIQLEGIMPTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV20LiqLegImpTotDescu',fld:'vLIQLEGIMPTOTDESCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV74TotValueLiqLegImpTotBruto',fld:'vTOTVALUELIQLEGIMPTOTBRUTO',pic:''},{av:'AV76TotValueLiqLegImpTotDescu',fld:'vTOTVALUELIQLEGIMPTOTDESCU',pic:''},{av:'AV78TotValueLiqLegImpTotRetGan',fld:'vTOTVALUELIQLEGIMPTOTRETGAN',pic:''},{av:'AV80TotValueLiqLegImpTotal',fld:'vTOTVALUELIQLEGIMPTOTAL',pic:''}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e15K02',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LIQNRO","{handler:'valid_Liqnro',iparms:[]");
      setEventMetadata("VALID_LIQNRO",",oparms:[]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Errorliqleg',iparms:[]");
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
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV26ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV87Pgmname = "" ;
      AV31TFLiqFecha = GXutil.nullDate() ;
      AV32TFLiqFecha_To = GXutil.nullDate() ;
      AV37TFLiqPerPalabra = "" ;
      AV38TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFLiqNombre = "" ;
      AV41TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFLiqFecPago = GXutil.nullDate() ;
      AV43TFLiqFecPago_To = GXutil.nullDate() ;
      AV48TFTLiqCod = "" ;
      AV49TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV52TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV53TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV54TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV55TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV56TFLiqLegImpTotBruProm = DecimalUtil.ZERO ;
      AV57TFLiqLegImpTotBruProm_To = DecimalUtil.ZERO ;
      AV58TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV59TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV60TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV61TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      AV73TotLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV75TotLiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV77TotLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV79TotLiqLegImpTotal = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV68GridAppliedFilters = "" ;
      AV62DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV33DDO_LiqFechaAuxDate = GXutil.nullDate() ;
      AV34DDO_LiqFechaAuxDateTo = GXutil.nullDate() ;
      AV44DDO_LiqFecPagoAuxDate = GXutil.nullDate() ;
      AV45DDO_LiqFecPagoAuxDateTo = GXutil.nullDate() ;
      A340TliqDesc = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV35DDO_LiqFechaAuxDateText = "" ;
      ucTfliqfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV46DDO_LiqFecPagoAuxDateText = "" ;
      ucTfliqfecpago_rangepicker = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A513LiqPerSinDia = "" ;
      A748LiqPerPalabra = "" ;
      A874LiqNombre = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      A2409LiqModTra = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV20LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      AV21ErrorLiqLeg = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00K02_A3CliCod = new int[1] ;
      H00K02_A32TLiqCod = new String[] {""} ;
      H00K02_n32TLiqCod = new boolean[] {false} ;
      H00K02_A340TliqDesc = new String[] {""} ;
      lV37TFLiqPerPalabra = "" ;
      lV40TFLiqNombre = "" ;
      lV48TFTLiqCod = "" ;
      H00K03_A340TliqDesc = new String[] {""} ;
      H00K03_A3CliCod = new int[1] ;
      H00K03_A6LegNumero = new int[1] ;
      H00K03_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K03_A2414LiqFrecPag = new byte[1] ;
      H00K03_A2409LiqModTra = new String[] {""} ;
      H00K03_A268LiqClase = new byte[1] ;
      H00K03_n268LiqClase = new boolean[] {false} ;
      H00K03_A32TLiqCod = new String[] {""} ;
      H00K03_n32TLiqCod = new boolean[] {false} ;
      H00K03_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      H00K03_A874LiqNombre = new String[] {""} ;
      H00K03_A748LiqPerPalabra = new String[] {""} ;
      H00K03_A513LiqPerSinDia = new String[] {""} ;
      H00K03_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00K03_A31LiqNro = new int[1] ;
      H00K03_A1EmpCod = new short[1] ;
      H00K04_AGRID_nRecordCount = new long[1] ;
      AV74TotValueLiqLegImpTotBruto = "" ;
      AV76TotValueLiqLegImpTotDescu = "" ;
      AV78TotValueLiqLegImpTotRetGan = "" ;
      AV80TotValueLiqLegImpTotal = "" ;
      hsh = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV24ColumnsSelectorXML = "" ;
      AV36TFLiqPerPalabra_SelsJson = "" ;
      AV39TFLiqNombre_SelsJson = "" ;
      AV47TFTLiqCod_SelsJson = "" ;
      AV81TFLiqModTra_SelsJson = "" ;
      AV83TFLiqFrecPag_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV22ExcelFilename = "" ;
      AV23ErrorMessage = "" ;
      AV25UserCustomValue = "" ;
      AV27ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV15GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV16GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char13 = new String[1] ;
      GXt_char11 = "" ;
      GXv_char8 = new String[1] ;
      GXv_SdtWWPGridState16 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12HTTPRequest = httpContext.getHttpRequest();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      H00K05_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K05_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K05_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K05_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K05_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K05_A2414LiqFrecPag = new byte[1] ;
      H00K05_A2409LiqModTra = new String[] {""} ;
      H00K05_A32TLiqCod = new String[] {""} ;
      H00K05_n32TLiqCod = new boolean[] {false} ;
      H00K05_A340TliqDesc = new String[] {""} ;
      H00K05_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      H00K05_A874LiqNombre = new String[] {""} ;
      H00K05_A748LiqPerPalabra = new String[] {""} ;
      H00K05_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00K05_A31LiqNro = new int[1] ;
      H00K05_A6LegNumero = new int[1] ;
      H00K05_A1EmpCod = new short[1] ;
      H00K05_A3CliCod = new int[1] ;
      H00K05_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00K05_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      ClassString = "" ;
      imgBtnexport_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      imgBtnexport_Jsonclick = "" ;
      bttBtneditcolumns_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV11LegNumero = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacioneswc__default(),
         new Object[] {
             new Object[] {
            H00K02_A3CliCod, H00K02_A32TLiqCod, H00K02_A340TliqDesc
            }
            , new Object[] {
            H00K03_A340TliqDesc, H00K03_A3CliCod, H00K03_A6LegNumero, H00K03_A281LiqLegImpTotal, H00K03_A757LiqLegImpTotRetGan, H00K03_A579LiqLegImpTotDescu, H00K03_A759LiqLegImpTotBruSinSAC, H00K03_A758LiqLegImpTotBruProm, H00K03_A498LiqLegImpTotBruto, H00K03_A760LiqLegImpBasico,
            H00K03_A2414LiqFrecPag, H00K03_A2409LiqModTra, H00K03_A268LiqClase, H00K03_n268LiqClase, H00K03_A32TLiqCod, H00K03_n32TLiqCod, H00K03_A280LiqFecPago, H00K03_A874LiqNombre, H00K03_A748LiqPerPalabra, H00K03_A513LiqPerSinDia,
            H00K03_A98LiqFecha, H00K03_A31LiqNro, H00K03_A1EmpCod
            }
            , new Object[] {
            H00K04_AGRID_nRecordCount
            }
            , new Object[] {
            H00K05_A757LiqLegImpTotRetGan, H00K05_A759LiqLegImpTotBruSinSAC, H00K05_A758LiqLegImpTotBruProm, H00K05_A498LiqLegImpTotBruto, H00K05_A760LiqLegImpBasico, H00K05_A2414LiqFrecPag, H00K05_A2409LiqModTra, H00K05_A32TLiqCod, H00K05_n32TLiqCod, H00K05_A340TliqDesc,
            H00K05_A280LiqFecPago, H00K05_A874LiqNombre, H00K05_A748LiqPerPalabra, H00K05_A98LiqFecha, H00K05_A31LiqNro, H00K05_A6LegNumero, H00K05_A1EmpCod, H00K05_A3CliCod, H00K05_A579LiqLegImpTotDescu, H00K05_A281LiqLegImpTotal
            }
         }
      );
      AV87Pgmname = "liquidacionesWC" ;
      /* GeneXus formulas. */
      AV87Pgmname = "liquidacionesWC" ;
      Gx_err = (short)(0) ;
      edtavLiqlegimptotdescu_Enabled = 0 ;
      edtavErrorliqleg_Enabled = 0 ;
      edtavTotvalueliqlegimptotbruto_Enabled = 0 ;
      edtavTotvalueliqlegimptotdescu_Enabled = 0 ;
      edtavTotvalueliqlegimptotretgan_Enabled = 0 ;
      edtavTotvalueliqlegimptotal_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A268LiqClase ;
   private byte A2414LiqFrecPag ;
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
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV9EmpCod ;
   private short AV17OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8CliCod ;
   private int wcpOAV11LegNumero ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_22 ;
   private int AV8CliCod ;
   private int AV11LegNumero ;
   private int nGXsfl_22_idx=1 ;
   private int AV29TFLiqNro ;
   private int AV30TFLiqNro_To ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int Gridpaginationbar_Pagestoshow ;
   private int edtCliCod_Visible ;
   private int edtLegNumero_Visible ;
   private int A31LiqNro ;
   private int gxdynajaxindex ;
   private int subGrid_Islastpage ;
   private int edtavLiqlegimptotdescu_Enabled ;
   private int edtavErrorliqleg_Enabled ;
   private int edtavTotvalueliqlegimptotbruto_Enabled ;
   private int edtavTotvalueliqlegimptotdescu_Enabled ;
   private int edtavTotvalueliqlegimptotretgan_Enabled ;
   private int edtavTotvalueliqlegimptotal_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV38TFLiqPerPalabra_Sels_size ;
   private int AV41TFLiqNombre_Sels_size ;
   private int AV49TFTLiqCod_Sels_size ;
   private int AV82TFLiqModTra_Sels_size ;
   private int AV84TFLiqFrecPag_Sels_size ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtLiqNro_Visible ;
   private int edtLiqFecha_Visible ;
   private int edtLiqPerPalabra_Visible ;
   private int edtLiqNombre_Visible ;
   private int edtLiqFecPago_Visible ;
   private int edtLiqLegImpBasico_Visible ;
   private int edtLiqLegImpTotBruto_Visible ;
   private int edtLiqLegImpTotBruProm_Visible ;
   private int edtLiqLegImpTotBruSinSAC_Visible ;
   private int edtavLiqlegimptotdescu_Visible ;
   private int edtLiqLegImpTotRetGan_Visible ;
   private int edtLiqLegImpTotal_Visible ;
   private int edtavErrorliqleg_Visible ;
   private int AV65PageToGo ;
   private int AV88GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV66GridCurrentPage ;
   private long AV67GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV52TFLiqLegImpBasico ;
   private java.math.BigDecimal AV53TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV54TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV55TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV56TFLiqLegImpTotBruProm ;
   private java.math.BigDecimal AV57TFLiqLegImpTotBruProm_To ;
   private java.math.BigDecimal AV58TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV59TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV60TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV61TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal AV73TotLiqLegImpTotBruto ;
   private java.math.BigDecimal AV75TotLiqLegImpTotDescu ;
   private java.math.BigDecimal AV77TotLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV79TotLiqLegImpTotal ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal AV20LiqLegImpTotDescu ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_22_idx="0001" ;
   private String AV87Pgmname ;
   private String AV37TFLiqPerPalabra ;
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
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_gridcolumnsselector_Titlecontrolidtoreplace ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtLegNumero_Internalname ;
   private String edtLegNumero_Jsonclick ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_liqfechaauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_liqfechaauxdatetext_Internalname ;
   private String edtavDdo_liqfechaauxdatetext_Jsonclick ;
   private String Tfliqfecha_rangepicker_Internalname ;
   private String divDdo_liqfecpagoauxdates_Internalname ;
   private String edtavDdo_liqfecpagoauxdatetext_Internalname ;
   private String edtavDdo_liqfecpagoauxdatetext_Jsonclick ;
   private String Tfliqfecpago_rangepicker_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavTotvalueliqlegimptotbruto_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLiqNro_Internalname ;
   private String edtLiqFecha_Internalname ;
   private String A513LiqPerSinDia ;
   private String edtLiqPerSinDia_Internalname ;
   private String A748LiqPerPalabra ;
   private String edtLiqPerPalabra_Internalname ;
   private String edtLiqNombre_Internalname ;
   private String edtLiqFecPago_Internalname ;
   private String A32TLiqCod ;
   private String A2409LiqModTra ;
   private String edtLiqLegImpBasico_Internalname ;
   private String edtLiqLegImpTotBruto_Internalname ;
   private String edtLiqLegImpTotBruProm_Internalname ;
   private String edtLiqLegImpTotBruSinSAC_Internalname ;
   private String edtLiqLegImpTotDescu_Internalname ;
   private String edtavLiqlegimptotdescu_Internalname ;
   private String edtLiqLegImpTotRetGan_Internalname ;
   private String edtLiqLegImpTotal_Internalname ;
   private String edtavErrorliqleg_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavTotvalueliqlegimptotdescu_Internalname ;
   private String edtavTotvalueliqlegimptotretgan_Internalname ;
   private String edtavTotvalueliqlegimptotal_Internalname ;
   private String lV37TFLiqPerPalabra ;
   private String hsh ;
   private String bttBtneditcolumns_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char12 ;
   private String GXv_char13[] ;
   private String GXt_char11 ;
   private String GXv_char8[] ;
   private String tblUnnamedtable1_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String ClassString ;
   private String imgBtnexport_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgBtnexport_Internalname ;
   private String imgBtnexport_Jsonclick ;
   private String bttBtneditcolumns_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblGridtabletotalizer_Internalname ;
   private String edtavTotvalueliqlegimptotbruto_Jsonclick ;
   private String edtavTotvalueliqlegimptotdescu_Jsonclick ;
   private String edtavTotvalueliqlegimptotretgan_Jsonclick ;
   private String edtavTotvalueliqlegimptotal_Jsonclick ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV11LegNumero ;
   private String sGXsfl_22_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtEmpCod_Jsonclick ;
   private String edtLiqNro_Jsonclick ;
   private String edtLiqFecha_Jsonclick ;
   private String edtLiqPerSinDia_Jsonclick ;
   private String edtLiqPerPalabra_Jsonclick ;
   private String edtLiqNombre_Jsonclick ;
   private String edtLiqFecPago_Jsonclick ;
   private String GXCCtl ;
   private String edtLiqLegImpBasico_Jsonclick ;
   private String edtLiqLegImpTotBruto_Jsonclick ;
   private String edtLiqLegImpTotBruProm_Jsonclick ;
   private String edtLiqLegImpTotBruSinSAC_Jsonclick ;
   private String edtLiqLegImpTotDescu_Jsonclick ;
   private String edtavLiqlegimptotdescu_Jsonclick ;
   private String edtLiqLegImpTotRetGan_Jsonclick ;
   private String edtLiqLegImpTotal_Jsonclick ;
   private String edtavErrorliqleg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV31TFLiqFecha ;
   private java.util.Date AV32TFLiqFecha_To ;
   private java.util.Date AV42TFLiqFecPago ;
   private java.util.Date AV43TFLiqFecPago_To ;
   private java.util.Date AV33DDO_LiqFechaAuxDate ;
   private java.util.Date AV34DDO_LiqFechaAuxDateTo ;
   private java.util.Date AV44DDO_LiqFecPagoAuxDate ;
   private java.util.Date AV45DDO_LiqFecPagoAuxDateTo ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV18OrderedDsc ;
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
   private boolean n32TLiqCod ;
   private boolean n268LiqClase ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_22_Refreshing=false ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV24ColumnsSelectorXML ;
   private String AV36TFLiqPerPalabra_SelsJson ;
   private String AV39TFLiqNombre_SelsJson ;
   private String AV47TFTLiqCod_SelsJson ;
   private String AV81TFLiqModTra_SelsJson ;
   private String AV83TFLiqFrecPag_SelsJson ;
   private String AV25UserCustomValue ;
   private String AV40TFLiqNombre ;
   private String AV48TFTLiqCod ;
   private String AV68GridAppliedFilters ;
   private String A340TliqDesc ;
   private String AV35DDO_LiqFechaAuxDateText ;
   private String AV46DDO_LiqFecPagoAuxDateText ;
   private String A874LiqNombre ;
   private String AV21ErrorLiqLeg ;
   private String lV40TFLiqNombre ;
   private String lV48TFTLiqCod ;
   private String AV74TotValueLiqLegImpTotBruto ;
   private String AV76TotValueLiqLegImpTotDescu ;
   private String AV78TotValueLiqLegImpTotRetGan ;
   private String AV80TotValueLiqLegImpTotal ;
   private String AV22ExcelFilename ;
   private String AV23ErrorMessage ;
   private GXSimpleCollection<Byte> AV84TFLiqFrecPag_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV12HTTPRequest ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfliqfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfliqfecpago_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynTLiqCod ;
   private HTMLChoice cmbLiqClase ;
   private HTMLChoice cmbLiqModTra ;
   private HTMLChoice cmbLiqFrecPag ;
   private IDataStoreProvider pr_default ;
   private int[] H00K02_A3CliCod ;
   private String[] H00K02_A32TLiqCod ;
   private boolean[] H00K02_n32TLiqCod ;
   private String[] H00K02_A340TliqDesc ;
   private String[] H00K03_A340TliqDesc ;
   private int[] H00K03_A3CliCod ;
   private int[] H00K03_A6LegNumero ;
   private java.math.BigDecimal[] H00K03_A281LiqLegImpTotal ;
   private java.math.BigDecimal[] H00K03_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] H00K03_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] H00K03_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] H00K03_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] H00K03_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] H00K03_A760LiqLegImpBasico ;
   private byte[] H00K03_A2414LiqFrecPag ;
   private String[] H00K03_A2409LiqModTra ;
   private byte[] H00K03_A268LiqClase ;
   private boolean[] H00K03_n268LiqClase ;
   private String[] H00K03_A32TLiqCod ;
   private boolean[] H00K03_n32TLiqCod ;
   private java.util.Date[] H00K03_A280LiqFecPago ;
   private String[] H00K03_A874LiqNombre ;
   private String[] H00K03_A748LiqPerPalabra ;
   private String[] H00K03_A513LiqPerSinDia ;
   private java.util.Date[] H00K03_A98LiqFecha ;
   private int[] H00K03_A31LiqNro ;
   private short[] H00K03_A1EmpCod ;
   private long[] H00K04_AGRID_nRecordCount ;
   private java.math.BigDecimal[] H00K05_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] H00K05_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] H00K05_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] H00K05_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] H00K05_A760LiqLegImpBasico ;
   private byte[] H00K05_A2414LiqFrecPag ;
   private String[] H00K05_A2409LiqModTra ;
   private String[] H00K05_A32TLiqCod ;
   private boolean[] H00K05_n32TLiqCod ;
   private String[] H00K05_A340TliqDesc ;
   private java.util.Date[] H00K05_A280LiqFecPago ;
   private String[] H00K05_A874LiqNombre ;
   private String[] H00K05_A748LiqPerPalabra ;
   private java.util.Date[] H00K05_A98LiqFecha ;
   private int[] H00K05_A31LiqNro ;
   private int[] H00K05_A6LegNumero ;
   private short[] H00K05_A1EmpCod ;
   private int[] H00K05_A3CliCod ;
   private java.math.BigDecimal[] H00K05_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] H00K05_A281LiqLegImpTotal ;
   private GXSimpleCollection<String> AV38TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV49TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV82TFLiqModTra_Sels ;
   private GXSimpleCollection<String> AV41TFLiqNombre_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV15GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState16[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV16GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV26ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV27ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV62DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class liquidacioneswc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00K03( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV38TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV41TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV49TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV82TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV84TFLiqFrecPag_Sels ,
                                          int AV29TFLiqNro ,
                                          int AV30TFLiqNro_To ,
                                          java.util.Date AV31TFLiqFecha ,
                                          java.util.Date AV32TFLiqFecha_To ,
                                          int AV38TFLiqPerPalabra_Sels_size ,
                                          String AV37TFLiqPerPalabra ,
                                          int AV41TFLiqNombre_Sels_size ,
                                          String AV40TFLiqNombre ,
                                          java.util.Date AV42TFLiqFecPago ,
                                          java.util.Date AV43TFLiqFecPago_To ,
                                          int AV49TFTLiqCod_Sels_size ,
                                          String AV48TFTLiqCod ,
                                          int AV82TFLiqModTra_Sels_size ,
                                          int AV84TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV52TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV53TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV54TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV55TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV56TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV57TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV58TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV59TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV60TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV61TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int A6LegNumero ,
                                          int AV11LegNumero ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[25];
      Object[] GXv_Object18 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.TliqDesc, T1.CliCod, T1.LegNumero, T1.LiqLegImpTotal, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotDescu, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto," ;
      sSelectString += " T1.LiqLegImpBasico, T3.LiqFrecPag, T3.LiqModTra, T3.LiqClase, T1.TLiqCod, T3.LiqFecPago, T3.LiqNombre, T3.LiqPerPalabra, T3.LiqPerSinDia, T3.LiqFecha, T1.LiqNro," ;
      sSelectString += " T1.EmpCod" ;
      sFromString = " FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod" ;
      sFromString += " AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LegNumero = ?)");
      if ( ! (0==AV29TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( ! (0==AV30TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha >= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha <= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ( AV38TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV37TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( AV38TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqPerPalabra_Sels, "T3.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV41TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( AV41TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( ( AV49TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( AV49TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV82TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLiqModTra_Sels, "T3.LiqModTra IN (", ")")+")");
      }
      if ( AV84TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84TFLiqFrecPag_Sels, "T3.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int17[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int17[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int17[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int17[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int17[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int17[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int17[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int17[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int17[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int17[21] = (byte)(1) ;
      }
      if ( AV17OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqNro DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqFecha, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T3.LiqFecha DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqPerPalabra, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T3.LiqPerPalabra DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqNombre, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T3.LiqNombre DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqFecPago, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T3.LiqFecPago DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.TLiqCod, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.TLiqCod DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqModTra, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T3.LiqModTra DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqFrecPag, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T3.LiqFrecPag DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpBasico, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpBasico DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruto, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruto DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruProm, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruProm DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotBruSinSAC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotBruSinSAC DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotRetGan, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotRetGan DESC, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqLegImpTotal, T1.LiqNro" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LiqLegImpTotal DESC, T1.LiqNro" ;
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

   protected Object[] conditional_H00K04( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV38TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV41TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV49TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV82TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV84TFLiqFrecPag_Sels ,
                                          int AV29TFLiqNro ,
                                          int AV30TFLiqNro_To ,
                                          java.util.Date AV31TFLiqFecha ,
                                          java.util.Date AV32TFLiqFecha_To ,
                                          int AV38TFLiqPerPalabra_Sels_size ,
                                          String AV37TFLiqPerPalabra ,
                                          int AV41TFLiqNombre_Sels_size ,
                                          String AV40TFLiqNombre ,
                                          java.util.Date AV42TFLiqFecPago ,
                                          java.util.Date AV43TFLiqFecPago_To ,
                                          int AV49TFTLiqCod_Sels_size ,
                                          String AV48TFTLiqCod ,
                                          int AV82TFLiqModTra_Sels_size ,
                                          int AV84TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV52TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV53TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV54TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV55TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV56TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV57TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV58TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV59TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV60TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV61TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int A6LegNumero ,
                                          int AV11LegNumero ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[22];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion T3 ON T3.CliCod = T1.CliCod AND T3.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LegNumero = ?)");
      if ( ! (0==AV29TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( ! (0==AV30TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha >= ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha <= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ( AV38TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV37TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( AV38TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqPerPalabra_Sels, "T2.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV41TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( AV41TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqNombre_Sels, "T2.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( ( AV49TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( AV49TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV82TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLiqModTra_Sels, "T2.LiqModTra IN (", ")")+")");
      }
      if ( AV84TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84TFLiqFrecPag_Sels, "T2.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int20[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int20[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int20[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int20[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int20[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int20[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int20[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int20[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int20[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int20[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV17OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
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

   protected Object[] conditional_H00K05( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV38TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV41TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV49TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV82TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV84TFLiqFrecPag_Sels ,
                                          int AV29TFLiqNro ,
                                          int AV30TFLiqNro_To ,
                                          java.util.Date AV31TFLiqFecha ,
                                          java.util.Date AV32TFLiqFecha_To ,
                                          int AV38TFLiqPerPalabra_Sels_size ,
                                          String AV37TFLiqPerPalabra ,
                                          int AV41TFLiqNombre_Sels_size ,
                                          String AV40TFLiqNombre ,
                                          java.util.Date AV42TFLiqFecPago ,
                                          java.util.Date AV43TFLiqFecPago_To ,
                                          int AV49TFTLiqCod_Sels_size ,
                                          String AV48TFTLiqCod ,
                                          int AV82TFLiqModTra_Sels_size ,
                                          int AV84TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV52TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV53TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV54TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV55TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV56TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV57TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV58TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV59TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV60TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV61TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV11LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[22];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico, T2.LiqFrecPag, T2.LiqModTra, T1.TLiqCod," ;
      scmdbuf += " T3.TliqDesc, T2.LiqFecPago, T2.LiqNombre, T2.LiqPerPalabra, T2.LiqFecha, T1.LiqNro, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqLegImpTotDescu, T1.LiqLegImpTotal" ;
      scmdbuf += " FROM ((LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T3" ;
      scmdbuf += " ON T3.CliCod = T1.CliCod AND T3.TLiqCod = T1.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV29TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      if ( ! (0==AV30TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int23[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV31TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha >= ?)");
      }
      else
      {
         GXv_int23[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecha <= ?)");
      }
      else
      {
         GXv_int23[6] = (byte)(1) ;
      }
      if ( ( AV38TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV37TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int23[7] = (byte)(1) ;
      }
      if ( AV38TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqPerPalabra_Sels, "T2.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV41TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int23[8] = (byte)(1) ;
      }
      if ( AV41TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqNombre_Sels, "T2.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV42TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int23[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV43TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T2.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int23[10] = (byte)(1) ;
      }
      if ( ( AV49TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int23[11] = (byte)(1) ;
      }
      if ( AV49TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV82TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82TFLiqModTra_Sels, "T2.LiqModTra IN (", ")")+")");
      }
      if ( AV84TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84TFLiqFrecPag_Sels, "T2.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int23[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int23[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int23[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int23[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int23[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int23[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int23[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int23[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int23[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int23[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_H00K03(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).shortValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() );
            case 2 :
                  return conditional_H00K04(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).shortValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() );
            case 3 :
                  return conditional_H00K05(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() , ((Number) dynConstraints[48]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00K02", "SELECT CliCod, TLiqCod, TliqDesc FROM TipoLiquidacion ORDER BY TliqDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00K03", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00K04", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00K05", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(15);
               ((String[]) buf[17])[0] = rslt.getVarchar(16);
               ((String[]) buf[18])[0] = rslt.getString(17, 20);
               ((String[]) buf[19])[0] = rslt.getString(18, 20);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(19);
               ((int[]) buf[21])[0] = rslt.getInt(20);
               ((short[]) buf[22])[0] = rslt.getShort(21);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 3 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((int[]) buf[14])[0] = rslt.getInt(14);
               ((int[]) buf[15])[0] = rslt.getInt(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(19,2);
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
            case 1 :
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
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[32], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[34]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[35]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
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
            case 2 :
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
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
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
            case 3 :
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
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
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

