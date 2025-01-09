package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg1ww_impl extends GXWebComponent
{
   public lsd_reg1ww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg1ww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg1ww_impl.class ));
   }

   public lsd_reg1ww_impl( int remoteHandle ,
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
               AV63MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63MenuOpcCod", AV63MenuOpcCod);
               AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
               AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
               AV10parmPeriodo = localUtil.parseDateParm( httpContext.GetPar( "parmPeriodo")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10parmPeriodo", localUtil.format(AV10parmPeriodo, "99/99/99"));
               AV11parmNroLiq = (int)(GXutil.lval( httpContext.GetPar( "parmNroLiq"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11parmNroLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11parmNroLiq), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV63MenuOpcCod,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),AV10parmPeriodo,Integer.valueOf(AV11parmNroLiq)});
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
      nRC_GXsfl_75 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_75"))) ;
      nGXsfl_75_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_75_idx"))) ;
      sGXsfl_75_idx = httpContext.GetPar( "sGXsfl_75_idx") ;
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
      AV10parmPeriodo = localUtil.parseDateParm( httpContext.GetPar( "parmPeriodo")) ;
      AV11parmNroLiq = (int)(GXutil.lval( httpContext.GetPar( "parmNroLiq"))) ;
      AV76ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22ColumnsSelector);
      AV96Pgmname = httpContext.GetPar( "Pgmname") ;
      AV63MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV15GridState);
      AV8CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV9EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV25TFLSD1CuitEmpl_3_11 = GXutil.lval( httpContext.GetPar( "TFLSD1CuitEmpl_3_11")) ;
      AV26TFLSD1CuitEmpl_3_11_To = GXutil.lval( httpContext.GetPar( "TFLSD1CuitEmpl_3_11_To")) ;
      AV28TFLSD1IdentificacionEnvio_14_2 = httpContext.GetPar( "TFLSD1IdentificacionEnvio_14_2") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29TFLSD1IdentificacionEnvio_14_2_Sels);
      AV30TFLSD1periodoLiquidacion_16_6 = (int)(GXutil.lval( httpContext.GetPar( "TFLSD1periodoLiquidacion_16_6"))) ;
      AV31TFLSD1periodoLiquidacion_16_6_To = (int)(GXutil.lval( httpContext.GetPar( "TFLSD1periodoLiquidacion_16_6_To"))) ;
      AV33TFLSD1tipoLiquidacion_22_1 = httpContext.GetPar( "TFLSD1tipoLiquidacion_22_1") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34TFLSD1tipoLiquidacion_22_1_Sels);
      AV35TFLSD1numeroLiquidacion_23_5 = (int)(GXutil.lval( httpContext.GetPar( "TFLSD1numeroLiquidacion_23_5"))) ;
      AV36TFLSD1numeroLiquidacion_23_5_To = (int)(GXutil.lval( httpContext.GetPar( "TFLSD1numeroLiquidacion_23_5_To"))) ;
      AV37TFLSD1diasBase_28_2 = (byte)(GXutil.lval( httpContext.GetPar( "TFLSD1diasBase_28_2"))) ;
      AV38TFLSD1diasBase_28_2_To = (byte)(GXutil.lval( httpContext.GetPar( "TFLSD1diasBase_28_2_To"))) ;
      AV39TFLSD1cantidadRegistrosTipo04_30_6 = (int)(GXutil.lval( httpContext.GetPar( "TFLSD1cantidadRegistrosTipo04_30_6"))) ;
      AV40TFLSD1cantidadRegistrosTipo04_30_6_To = (int)(GXutil.lval( httpContext.GetPar( "TFLSD1cantidadRegistrosTipo04_30_6_To"))) ;
      AV17OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV18OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV47IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV49IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV97Lsd_reg1wwds_1_clicod = (int)(GXutil.lval( httpContext.GetPar( "Lsd_reg1wwds_1_clicod"))) ;
      AV98Lsd_reg1wwds_2_empcod = (short)(GXutil.lval( httpContext.GetPar( "Lsd_reg1wwds_2_empcod"))) ;
      AV56date = localUtil.parseDateParm( httpContext.GetPar( "date")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV10parmPeriodo, AV11parmNroLiq, AV76ManageFiltersExecutionStep, AV22ColumnsSelector, AV96Pgmname, AV63MenuOpcCod, AV15GridState, AV8CliCod, AV9EmpCod, AV25TFLSD1CuitEmpl_3_11, AV26TFLSD1CuitEmpl_3_11_To, AV28TFLSD1IdentificacionEnvio_14_2, AV29TFLSD1IdentificacionEnvio_14_2_Sels, AV30TFLSD1periodoLiquidacion_16_6, AV31TFLSD1periodoLiquidacion_16_6_To, AV33TFLSD1tipoLiquidacion_22_1, AV34TFLSD1tipoLiquidacion_22_1_Sels, AV35TFLSD1numeroLiquidacion_23_5, AV36TFLSD1numeroLiquidacion_23_5_To, AV37TFLSD1diasBase_28_2, AV38TFLSD1diasBase_28_2_To, AV39TFLSD1cantidadRegistrosTipo04_30_6, AV40TFLSD1cantidadRegistrosTipo04_30_6_To, AV17OrderedBy, AV18OrderedDsc, AV47IsAuthorized_Update, AV49IsAuthorized_Delete, AV97Lsd_reg1wwds_1_clicod, AV98Lsd_reg1wwds_2_empcod, AV56date, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paHE2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( " LSD_reg1", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg1ww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV63MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV10parmPeriodo)),GXutil.URLEncode(GXutil.ltrimstr(AV11parmNroLiq,8,0))}, new String[] {"MenuOpcCod","CliCod","EmpCod","parmPeriodo","parmNroLiq"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV96Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV47IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV49IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDATE", getSecureSignedToken( sPrefix, AV56date));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_75", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_75, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV41DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV41DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLUMNSSELECTOR", AV22ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMANAGEFILTERSDATA", AV74ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMANAGEFILTERSDATA", AV74ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV43GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV44GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV45GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV63MenuOpcCod", wcpOAV63MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10parmPeriodo", localUtil.dtoc( wcpOAV10parmPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11parmNroLiq", GXutil.ltrim( localUtil.ntoc( wcpOAV11parmNroLiq, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV76ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV96Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV96Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV63MenuOpcCod);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vGRIDSTATE", AV15GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vGRIDSTATE", AV15GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1CUITEMPL_3_11", GXutil.ltrim( localUtil.ntoc( AV25TFLSD1CuitEmpl_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1CUITEMPL_3_11_TO", GXutil.ltrim( localUtil.ntoc( AV26TFLSD1CuitEmpl_3_11_To, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1IDENTIFICACIONENVIO_14_2", GXutil.rtrim( AV28TFLSD1IdentificacionEnvio_14_2));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLSD1IDENTIFICACIONENVIO_14_2_SELS", AV29TFLSD1IdentificacionEnvio_14_2_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLSD1IDENTIFICACIONENVIO_14_2_SELS", AV29TFLSD1IdentificacionEnvio_14_2_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1PERIODOLIQUIDACION_16_6", GXutil.ltrim( localUtil.ntoc( AV30TFLSD1periodoLiquidacion_16_6, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1PERIODOLIQUIDACION_16_6_TO", GXutil.ltrim( localUtil.ntoc( AV31TFLSD1periodoLiquidacion_16_6_To, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1TIPOLIQUIDACION_22_1", GXutil.rtrim( AV33TFLSD1tipoLiquidacion_22_1));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLSD1TIPOLIQUIDACION_22_1_SELS", AV34TFLSD1tipoLiquidacion_22_1_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLSD1TIPOLIQUIDACION_22_1_SELS", AV34TFLSD1tipoLiquidacion_22_1_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1NUMEROLIQUIDACION_23_5", GXutil.ltrim( localUtil.ntoc( AV35TFLSD1numeroLiquidacion_23_5, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1NUMEROLIQUIDACION_23_5_TO", GXutil.ltrim( localUtil.ntoc( AV36TFLSD1numeroLiquidacion_23_5_To, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1DIASBASE_28_2", GXutil.ltrim( localUtil.ntoc( AV37TFLSD1diasBase_28_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1DIASBASE_28_2_TO", GXutil.ltrim( localUtil.ntoc( AV38TFLSD1diasBase_28_2_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1CANTIDADREGISTROSTIPO04_30_6", GXutil.ltrim( localUtil.ntoc( AV39TFLSD1cantidadRegistrosTipo04_30_6, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO", GXutil.ltrim( localUtil.ntoc( AV40TFLSD1cantidadRegistrosTipo04_30_6_To, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV17OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV18OrderedDsc);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV47IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV47IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV49IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV49IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1IDENTIFICACIONENVIO_14_2_SELSJSON", AV27TFLSD1IdentificacionEnvio_14_2_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD1TIPOLIQUIDACION_22_1_SELSJSON", AV32TFLSD1tipoLiquidacion_22_1_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDATE", localUtil.dtoc( AV56date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDATE", getSecureSignedToken( sPrefix, AV56date));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENSAJETEXTO", AV87mensajeTexto);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLSD_REG1WWDS_1_CLICOD", GXutil.ltrim( localUtil.ntoc( AV97Lsd_reg1wwds_1_clicod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLSD_REG1WWDS_2_EMPCOD", GXutil.ltrim( localUtil.ntoc( AV98Lsd_reg1wwds_2_empcod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
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
   }

   public void renderHtmlCloseFormHE2( )
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
      return "LSD_reg1WW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " LSD_reg1", "") ;
   }

   public void wbHE0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.lsd_reg1ww");
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
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_HE2( true) ;
      }
      else
      {
         wb_table1_9_HE2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_HE2e( boolean wbgen )
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndescargar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 75, 2, 0)+","+"null"+");", httpContext.getMessage( "Descargar", ""), bttBtndescargar_Jsonclick, 5, httpContext.getMessage( "Descargar", ""), "", StyleString, ClassString, bttBtndescargar_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DODESCARGAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg1WW.htm");
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
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV41DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtavParmperiodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavParmperiodo_Internalname, localUtil.format(AV10parmPeriodo, "99/99/99"), localUtil.format( AV10parmPeriodo, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavParmperiodo_Jsonclick, 0, "Attribute", "", "", "", "", edtavParmperiodo_Visible, 0, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Periodo", "right", false, "", "HLP_LSD_reg1WW.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavParmperiodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavParmperiodo_Visible==0)||(0==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LSD_reg1WW.htm");
         httpContext.writeTextNL( "</div>") ;
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavParmnroliq_Internalname, GXutil.ltrim( localUtil.ntoc( AV11parmNroLiq, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV11parmNroLiq), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavParmnroliq_Jsonclick, 0, "Attribute", "", "", "", "", edtavParmnroliq_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg1WW.htm");
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
      if ( wbEnd == 75 )
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

   public void startHE2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( " LSD_reg1", ""), (short)(0)) ;
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
            strupHE0( ) ;
         }
      }
   }

   public void wsHE2( )
   {
      startHE2( ) ;
      evtHE2( ) ;
   }

   public void evtHE2( )
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
                              strupHE0( ) ;
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
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODESCARGAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoDescargar' */
                                 e16HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoExport' */
                                 e17HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.MENSAJELIQUIDACION") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e18HE2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavRegtipo_Internalname ;
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VDOWNLOAD.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VDOWNLOAD.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHE0( ) ;
                           }
                           nGXsfl_75_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_752( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV58RegTipo = httpContext.cgiGet( edtavRegtipo_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavRegtipo_Internalname, AV58RegTipo);
                           A1650LSD1CuitEmpl_3_11 = localUtil.ctol( httpContext.cgiGet( edtLSD1CuitEmpl_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A1651LSD1IdentificacionEnvio_14_2 = httpContext.cgiGet( edtLSD1IdentificacionEnvio_14_2_Internalname) ;
                           A1652LSD1periodoLiquidacion_16_6 = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD1periodoLiquidacion_16_6_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1653LSD1tipoLiquidacion_22_1 = httpContext.cgiGet( edtLSD1tipoLiquidacion_22_1_Internalname) ;
                           A1654LSD1numeroLiquidacion_23_5 = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD1numeroLiquidacion_23_5_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1655LSD1diasBase_28_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD1diasBase_28_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1656LSD1cantidadRegistrosTipo04_30 = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD1cantidadRegistrosTipo04_30_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1733LSD1LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD1LiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1734LSD1LiqPeriodo = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLSD1LiqPeriodo_Internalname), 0)) ;
                           AV46Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV46Update);
                           AV48Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV48Delete);
                           AV62Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV62Display);
                           AV59VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV59VerSVG);
                           AV60ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavModificarsvg_Internalname, AV60ModificarSVG);
                           AV61EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminarsvg_Internalname, AV61EliminarSVG);
                           AV52download = httpContext.cgiGet( edtavDownload_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDownload_Internalname, AV52download);
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
                                       GX_FocusControl = edtavRegtipo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e19HE2 ();
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
                                       GX_FocusControl = edtavRegtipo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e20HE2 ();
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
                                       GX_FocusControl = edtavRegtipo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e21HE2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VDOWNLOAD.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavRegtipo_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e22HE2 ();
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
                                    strupHE0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavRegtipo_Internalname ;
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

   public void weHE2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormHE2( ) ;
         }
      }
   }

   public void paHE2( )
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
            GX_FocusControl = edtavEstadolsddep_Internalname ;
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
      subsflControlProps_752( ) ;
      while ( nGXsfl_75_idx <= nRC_GXsfl_75 )
      {
         sendrow_752( ) ;
         nGXsfl_75_idx = ((subGrid_Islastpage==1)&&(nGXsfl_75_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_75_idx+1) ;
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_752( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 java.util.Date AV10parmPeriodo ,
                                 int AV11parmNroLiq ,
                                 byte AV76ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ,
                                 String AV96Pgmname ,
                                 String AV63MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV15GridState ,
                                 int AV8CliCod ,
                                 short AV9EmpCod ,
                                 long AV25TFLSD1CuitEmpl_3_11 ,
                                 long AV26TFLSD1CuitEmpl_3_11_To ,
                                 String AV28TFLSD1IdentificacionEnvio_14_2 ,
                                 GXSimpleCollection<String> AV29TFLSD1IdentificacionEnvio_14_2_Sels ,
                                 int AV30TFLSD1periodoLiquidacion_16_6 ,
                                 int AV31TFLSD1periodoLiquidacion_16_6_To ,
                                 String AV33TFLSD1tipoLiquidacion_22_1 ,
                                 GXSimpleCollection<String> AV34TFLSD1tipoLiquidacion_22_1_Sels ,
                                 int AV35TFLSD1numeroLiquidacion_23_5 ,
                                 int AV36TFLSD1numeroLiquidacion_23_5_To ,
                                 byte AV37TFLSD1diasBase_28_2 ,
                                 byte AV38TFLSD1diasBase_28_2_To ,
                                 int AV39TFLSD1cantidadRegistrosTipo04_30_6 ,
                                 int AV40TFLSD1cantidadRegistrosTipo04_30_6_To ,
                                 short AV17OrderedBy ,
                                 boolean AV18OrderedDsc ,
                                 boolean AV47IsAuthorized_Update ,
                                 boolean AV49IsAuthorized_Delete ,
                                 int AV97Lsd_reg1wwds_1_clicod ,
                                 short AV98Lsd_reg1wwds_2_empcod ,
                                 java.util.Date AV56date ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20HE2 ();
      GRID_nCurrentRecord = 0 ;
      rfHE2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LSDSEC", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LSDSEC", GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), ".", "")));
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
      rfHE2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV96Pgmname = "LSD_reg1WW" ;
      Gx_err = (short)(0) ;
      edtavEstadolsddep_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadolsddep_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadolsddep_Enabled), 5, 0), true);
      edtavRegtipo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRegtipo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRegtipo_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavDownload_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDownload_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDownload_Enabled), 5, 0), !bGXsfl_75_Refreshing);
   }

   public void rfHE2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(75) ;
      /* Execute user event: Refresh */
      e20HE2 ();
      nGXsfl_75_idx = 1 ;
      sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_752( ) ;
      bGXsfl_75_Refreshing = true ;
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
         subsflControlProps_752( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A1651LSD1IdentificacionEnvio_14_2 ,
                                              AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                              A1653LSD1tipoLiquidacion_22_1 ,
                                              AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                              Long.valueOf(AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11) ,
                                              Long.valueOf(AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) ,
                                              Integer.valueOf(AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels.size()) ,
                                              AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                              Integer.valueOf(AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) ,
                                              Integer.valueOf(AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) ,
                                              Integer.valueOf(AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels.size()) ,
                                              AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                              Integer.valueOf(AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) ,
                                              Integer.valueOf(AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) ,
                                              Byte.valueOf(AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2) ,
                                              Byte.valueOf(AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) ,
                                              Integer.valueOf(AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) ,
                                              Integer.valueOf(AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) ,
                                              Integer.valueOf(AV11parmNroLiq) ,
                                              AV10parmPeriodo ,
                                              Long.valueOf(A1650LSD1CuitEmpl_3_11) ,
                                              Integer.valueOf(A1652LSD1periodoLiquidacion_16_6) ,
                                              Integer.valueOf(A1654LSD1numeroLiquidacion_23_5) ,
                                              Byte.valueOf(A1655LSD1diasBase_28_2) ,
                                              Integer.valueOf(A1656LSD1cantidadRegistrosTipo04_30) ,
                                              Integer.valueOf(A1733LSD1LiqNro) ,
                                              A1734LSD1LiqPeriodo ,
                                              Short.valueOf(AV17OrderedBy) ,
                                              Boolean.valueOf(AV18OrderedDsc) ,
                                              Integer.valueOf(AV97Lsd_reg1wwds_1_clicod) ,
                                              Short.valueOf(AV98Lsd_reg1wwds_2_empcod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.LONG, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.SHORT
                                              }
         });
         lV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = GXutil.padr( GXutil.rtrim( AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2), 2, "%") ;
         lV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = GXutil.padr( GXutil.rtrim( AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1), 1, "%") ;
         /* Using cursor H00HE2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV97Lsd_reg1wwds_1_clicod), Short.valueOf(AV98Lsd_reg1wwds_2_empcod), Long.valueOf(AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11), Long.valueOf(AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to), lV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2, Integer.valueOf(AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6), Integer.valueOf(AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to), lV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1, Integer.valueOf(AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5), Integer.valueOf(AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to), Byte.valueOf(AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2), Byte.valueOf(AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to), Integer.valueOf(AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6), Integer.valueOf(AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to), Integer.valueOf(AV11parmNroLiq), AV10parmPeriodo, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_75_idx = 1 ;
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_752( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1734LSD1LiqPeriodo = H00HE2_A1734LSD1LiqPeriodo[0] ;
            A1733LSD1LiqNro = H00HE2_A1733LSD1LiqNro[0] ;
            A1656LSD1cantidadRegistrosTipo04_30 = H00HE2_A1656LSD1cantidadRegistrosTipo04_30[0] ;
            A1655LSD1diasBase_28_2 = H00HE2_A1655LSD1diasBase_28_2[0] ;
            A1654LSD1numeroLiquidacion_23_5 = H00HE2_A1654LSD1numeroLiquidacion_23_5[0] ;
            A1653LSD1tipoLiquidacion_22_1 = H00HE2_A1653LSD1tipoLiquidacion_22_1[0] ;
            A1652LSD1periodoLiquidacion_16_6 = H00HE2_A1652LSD1periodoLiquidacion_16_6[0] ;
            A1651LSD1IdentificacionEnvio_14_2 = H00HE2_A1651LSD1IdentificacionEnvio_14_2[0] ;
            A1650LSD1CuitEmpl_3_11 = H00HE2_A1650LSD1CuitEmpl_3_11[0] ;
            A1649LSDSec = H00HE2_A1649LSDSec[0] ;
            A1EmpCod = H00HE2_A1EmpCod[0] ;
            A3CliCod = H00HE2_A3CliCod[0] ;
            e21HE2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(75) ;
         wbHE0( ) ;
      }
      bGXsfl_75_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesHE2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV96Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV96Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV47IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV47IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV49IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV49IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LSDSEC"+"_"+sGXsfl_75_idx, getSecureSignedToken( sPrefix+sGXsfl_75_idx, localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDATE", localUtil.dtoc( AV56date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDATE", getSecureSignedToken( sPrefix, AV56date));
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
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1651LSD1IdentificacionEnvio_14_2 ,
                                           AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                           A1653LSD1tipoLiquidacion_22_1 ,
                                           AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                           Long.valueOf(AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11) ,
                                           Long.valueOf(AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) ,
                                           Integer.valueOf(AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels.size()) ,
                                           AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                           Integer.valueOf(AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) ,
                                           Integer.valueOf(AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) ,
                                           Integer.valueOf(AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels.size()) ,
                                           AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                           Integer.valueOf(AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) ,
                                           Integer.valueOf(AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) ,
                                           Byte.valueOf(AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2) ,
                                           Byte.valueOf(AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) ,
                                           Integer.valueOf(AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) ,
                                           Integer.valueOf(AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) ,
                                           Integer.valueOf(AV11parmNroLiq) ,
                                           AV10parmPeriodo ,
                                           Long.valueOf(A1650LSD1CuitEmpl_3_11) ,
                                           Integer.valueOf(A1652LSD1periodoLiquidacion_16_6) ,
                                           Integer.valueOf(A1654LSD1numeroLiquidacion_23_5) ,
                                           Byte.valueOf(A1655LSD1diasBase_28_2) ,
                                           Integer.valueOf(A1656LSD1cantidadRegistrosTipo04_30) ,
                                           Integer.valueOf(A1733LSD1LiqNro) ,
                                           A1734LSD1LiqPeriodo ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(AV97Lsd_reg1wwds_1_clicod) ,
                                           Short.valueOf(AV98Lsd_reg1wwds_2_empcod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.LONG, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = GXutil.padr( GXutil.rtrim( AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2), 2, "%") ;
      lV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = GXutil.padr( GXutil.rtrim( AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1), 1, "%") ;
      /* Using cursor H00HE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV97Lsd_reg1wwds_1_clicod), Short.valueOf(AV98Lsd_reg1wwds_2_empcod), Long.valueOf(AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11), Long.valueOf(AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to), lV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2, Integer.valueOf(AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6), Integer.valueOf(AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to), lV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1, Integer.valueOf(AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5), Integer.valueOf(AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to), Byte.valueOf(AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2), Byte.valueOf(AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to), Integer.valueOf(AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6), Integer.valueOf(AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to), Integer.valueOf(AV11parmNroLiq), AV10parmPeriodo});
      GRID_nRecordCount = H00HE3_AGRID_nRecordCount[0] ;
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
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV10parmPeriodo, AV11parmNroLiq, AV76ManageFiltersExecutionStep, AV22ColumnsSelector, AV96Pgmname, AV63MenuOpcCod, AV15GridState, AV8CliCod, AV9EmpCod, AV25TFLSD1CuitEmpl_3_11, AV26TFLSD1CuitEmpl_3_11_To, AV28TFLSD1IdentificacionEnvio_14_2, AV29TFLSD1IdentificacionEnvio_14_2_Sels, AV30TFLSD1periodoLiquidacion_16_6, AV31TFLSD1periodoLiquidacion_16_6_To, AV33TFLSD1tipoLiquidacion_22_1, AV34TFLSD1tipoLiquidacion_22_1_Sels, AV35TFLSD1numeroLiquidacion_23_5, AV36TFLSD1numeroLiquidacion_23_5_To, AV37TFLSD1diasBase_28_2, AV38TFLSD1diasBase_28_2_To, AV39TFLSD1cantidadRegistrosTipo04_30_6, AV40TFLSD1cantidadRegistrosTipo04_30_6_To, AV17OrderedBy, AV18OrderedDsc, AV47IsAuthorized_Update, AV49IsAuthorized_Delete, AV97Lsd_reg1wwds_1_clicod, AV98Lsd_reg1wwds_2_empcod, AV56date, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV10parmPeriodo, AV11parmNroLiq, AV76ManageFiltersExecutionStep, AV22ColumnsSelector, AV96Pgmname, AV63MenuOpcCod, AV15GridState, AV8CliCod, AV9EmpCod, AV25TFLSD1CuitEmpl_3_11, AV26TFLSD1CuitEmpl_3_11_To, AV28TFLSD1IdentificacionEnvio_14_2, AV29TFLSD1IdentificacionEnvio_14_2_Sels, AV30TFLSD1periodoLiquidacion_16_6, AV31TFLSD1periodoLiquidacion_16_6_To, AV33TFLSD1tipoLiquidacion_22_1, AV34TFLSD1tipoLiquidacion_22_1_Sels, AV35TFLSD1numeroLiquidacion_23_5, AV36TFLSD1numeroLiquidacion_23_5_To, AV37TFLSD1diasBase_28_2, AV38TFLSD1diasBase_28_2_To, AV39TFLSD1cantidadRegistrosTipo04_30_6, AV40TFLSD1cantidadRegistrosTipo04_30_6_To, AV17OrderedBy, AV18OrderedDsc, AV47IsAuthorized_Update, AV49IsAuthorized_Delete, AV97Lsd_reg1wwds_1_clicod, AV98Lsd_reg1wwds_2_empcod, AV56date, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV10parmPeriodo, AV11parmNroLiq, AV76ManageFiltersExecutionStep, AV22ColumnsSelector, AV96Pgmname, AV63MenuOpcCod, AV15GridState, AV8CliCod, AV9EmpCod, AV25TFLSD1CuitEmpl_3_11, AV26TFLSD1CuitEmpl_3_11_To, AV28TFLSD1IdentificacionEnvio_14_2, AV29TFLSD1IdentificacionEnvio_14_2_Sels, AV30TFLSD1periodoLiquidacion_16_6, AV31TFLSD1periodoLiquidacion_16_6_To, AV33TFLSD1tipoLiquidacion_22_1, AV34TFLSD1tipoLiquidacion_22_1_Sels, AV35TFLSD1numeroLiquidacion_23_5, AV36TFLSD1numeroLiquidacion_23_5_To, AV37TFLSD1diasBase_28_2, AV38TFLSD1diasBase_28_2_To, AV39TFLSD1cantidadRegistrosTipo04_30_6, AV40TFLSD1cantidadRegistrosTipo04_30_6_To, AV17OrderedBy, AV18OrderedDsc, AV47IsAuthorized_Update, AV49IsAuthorized_Delete, AV97Lsd_reg1wwds_1_clicod, AV98Lsd_reg1wwds_2_empcod, AV56date, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV10parmPeriodo, AV11parmNroLiq, AV76ManageFiltersExecutionStep, AV22ColumnsSelector, AV96Pgmname, AV63MenuOpcCod, AV15GridState, AV8CliCod, AV9EmpCod, AV25TFLSD1CuitEmpl_3_11, AV26TFLSD1CuitEmpl_3_11_To, AV28TFLSD1IdentificacionEnvio_14_2, AV29TFLSD1IdentificacionEnvio_14_2_Sels, AV30TFLSD1periodoLiquidacion_16_6, AV31TFLSD1periodoLiquidacion_16_6_To, AV33TFLSD1tipoLiquidacion_22_1, AV34TFLSD1tipoLiquidacion_22_1_Sels, AV35TFLSD1numeroLiquidacion_23_5, AV36TFLSD1numeroLiquidacion_23_5_To, AV37TFLSD1diasBase_28_2, AV38TFLSD1diasBase_28_2_To, AV39TFLSD1cantidadRegistrosTipo04_30_6, AV40TFLSD1cantidadRegistrosTipo04_30_6_To, AV17OrderedBy, AV18OrderedDsc, AV47IsAuthorized_Update, AV49IsAuthorized_Delete, AV97Lsd_reg1wwds_1_clicod, AV98Lsd_reg1wwds_2_empcod, AV56date, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV10parmPeriodo, AV11parmNroLiq, AV76ManageFiltersExecutionStep, AV22ColumnsSelector, AV96Pgmname, AV63MenuOpcCod, AV15GridState, AV8CliCod, AV9EmpCod, AV25TFLSD1CuitEmpl_3_11, AV26TFLSD1CuitEmpl_3_11_To, AV28TFLSD1IdentificacionEnvio_14_2, AV29TFLSD1IdentificacionEnvio_14_2_Sels, AV30TFLSD1periodoLiquidacion_16_6, AV31TFLSD1periodoLiquidacion_16_6_To, AV33TFLSD1tipoLiquidacion_22_1, AV34TFLSD1tipoLiquidacion_22_1_Sels, AV35TFLSD1numeroLiquidacion_23_5, AV36TFLSD1numeroLiquidacion_23_5_To, AV37TFLSD1diasBase_28_2, AV38TFLSD1diasBase_28_2_To, AV39TFLSD1cantidadRegistrosTipo04_30_6, AV40TFLSD1cantidadRegistrosTipo04_30_6_To, AV17OrderedBy, AV18OrderedDsc, AV47IsAuthorized_Update, AV49IsAuthorized_Delete, AV97Lsd_reg1wwds_1_clicod, AV98Lsd_reg1wwds_2_empcod, AV56date, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV96Pgmname = "LSD_reg1WW" ;
      Gx_err = (short)(0) ;
      edtavEstadolsddep_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadolsddep_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadolsddep_Enabled), 5, 0), true);
      edtavRegtipo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRegtipo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRegtipo_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavDownload_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDownload_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDownload_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupHE0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19HE2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV41DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCOLUMNSSELECTOR"), AV22ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vMANAGEFILTERSDATA"), AV74ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_75 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_75"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV43GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV44GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV45GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV63MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV63MenuOpcCod") ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10parmPeriodo = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOAV10parmPeriodo"), 0) ;
         wcpOAV11parmNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11parmNroLiq"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_grid_Datalistproc = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistproc") ;
         Ddo_grid_Format = httpContext.cgiGet( sPrefix+"DDO_GRID_Format") ;
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
         /* Read variables values. */
         AV86EstadoLSDDep = httpContext.cgiGet( edtavEstadolsddep_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV86EstadoLSDDep", AV86EstadoLSDDep);
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
      e19HE2 ();
      if (returnInSub) return;
   }

   public void e19HE2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavParmperiodo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavParmperiodo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavParmperiodo_Visible), 5, 0), true);
      edtavParmnroliq_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavParmnroliq_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavParmnroliq_Visible), 5, 0), true);
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      /* Execute user subroutine: 'LOADSAVEDFILTERS' */
      S112 ();
      if (returnInSub) return;
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV17OrderedBy < 1 )
      {
         AV17OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV41DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV41DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      AV85observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV85observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, sPrefix, false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV85observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV85observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, sPrefix, false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      new web.msgdebug_prod(remoteHandle, context).execute( AV96Pgmname, httpContext.getMessage( "&parmPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV10parmPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXv_char3[0] = AV57error ;
      new web.validacioneslibrodigital(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10parmPeriodo, AV11parmNroLiq, GXv_char3) ;
      lsd_reg1ww_impl.this.AV57error = GXv_char3[0] ;
      if ( (GXutil.strcmp("", AV57error)==0) )
      {
         GXv_int4[0] = 0 ;
         new web.genarchivoliquidacionesafip3(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10parmPeriodo, 0, "SJ", AV11parmNroLiq, GXv_int4) ;
      }
      if ( ! (0==AV11parmNroLiq) )
      {
         GXv_int5[0] = AV89LiquidacionEstado ;
         new web.getliqestdeplsd(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11parmNroLiq, GXv_int5) ;
         lsd_reg1ww_impl.this.AV89LiquidacionEstado = GXv_int5[0] ;
      }
      else
      {
         GXv_int5[0] = AV89LiquidacionEstado ;
         new web.getliqestdeplsdperiodo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10parmPeriodo, GXv_int5) ;
         lsd_reg1ww_impl.this.AV89LiquidacionEstado = GXv_int5[0] ;
      }
      AV86EstadoLSDDep = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV89LiquidacionEstado), "")) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV86EstadoLSDDep", AV86EstadoLSDDep);
   }

   public void e20HE2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext6[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext6) ;
      AV6WWPContext = GXv_SdtWWPContext6[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV76ManageFiltersExecutionStep == 1 )
      {
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV76ManageFiltersExecutionStep == 2 )
      {
         AV76ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV24Session.getValue("LSD_reg1WWColumnsSelector"), "") != 0 )
      {
         AV20ColumnsSelectorXML = AV24Session.getValue("LSD_reg1WWColumnsSelector") ;
         AV22ColumnsSelector.fromxml(AV20ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtavRegtipo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRegtipo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRegtipo_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1CuitEmpl_3_11_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1CuitEmpl_3_11_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1CuitEmpl_3_11_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1IdentificacionEnvio_14_2_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1IdentificacionEnvio_14_2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1IdentificacionEnvio_14_2_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1periodoLiquidacion_16_6_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1periodoLiquidacion_16_6_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1periodoLiquidacion_16_6_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1tipoLiquidacion_22_1_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1tipoLiquidacion_22_1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1tipoLiquidacion_22_1_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1numeroLiquidacion_23_5_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1numeroLiquidacion_23_5_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1numeroLiquidacion_23_5_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1diasBase_28_2_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1diasBase_28_2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1diasBase_28_2_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtLSD1cantidadRegistrosTipo04_30_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD1cantidadRegistrosTipo04_30_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD1cantidadRegistrosTipo04_30_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_75_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV22ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_75_Refreshing);
      AV43GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GridCurrentPage), 10, 0));
      AV44GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44GridPageCount), 10, 0));
      GXt_char7 = AV45GridAppliedFilters ;
      GXv_char3[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV96Pgmname, GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
      AV45GridAppliedFilters = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45GridAppliedFilters", AV45GridAppliedFilters);
      GXt_char7 = AV81MenuOpcTitulo ;
      GXv_char3[0] = GXt_char7 ;
      new web.gettxtcount(remoteHandle, context).execute( AV63MenuOpcCod, GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
      AV81MenuOpcTitulo = GXt_char7 ;
      if ( (GXutil.strcmp("", AV81MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV81MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int8[0] = (short)(AV83filterCount) ;
      GXv_char3[0] = AV84filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV15GridState, GXv_int8, GXv_char3) ;
      lsd_reg1ww_impl.this.AV83filterCount = GXv_int8[0] ;
      lsd_reg1ww_impl.this.AV84filtrosTexto = GXv_char3[0] ;
      if ( AV83filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV83filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV84filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV97Lsd_reg1wwds_1_clicod = AV8CliCod ;
      AV98Lsd_reg1wwds_2_empcod = AV9EmpCod ;
      AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV25TFLSD1CuitEmpl_3_11 ;
      AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV26TFLSD1CuitEmpl_3_11_To ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV28TFLSD1IdentificacionEnvio_14_2 ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV30TFLSD1periodoLiquidacion_16_6 ;
      AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV31TFLSD1periodoLiquidacion_16_6_To ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV33TFLSD1tipoLiquidacion_22_1 ;
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV34TFLSD1tipoLiquidacion_22_1_Sels ;
      AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV35TFLSD1numeroLiquidacion_23_5 ;
      AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV36TFLSD1numeroLiquidacion_23_5_To ;
      AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV37TFLSD1diasBase_28_2 ;
      AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV38TFLSD1diasBase_28_2_To ;
      AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV74ManageFiltersData", AV74ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV15GridState", AV15GridState);
   }

   public void e13HE2( )
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

   public void e14HE2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15HE2( )
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
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1CuitEmpl_3_11") == 0 )
         {
            AV25TFLSD1CuitEmpl_3_11 = GXutil.lval( Ddo_grid_Filteredtext_get) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLSD1CuitEmpl_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLSD1CuitEmpl_3_11), 11, 0));
            AV26TFLSD1CuitEmpl_3_11_To = GXutil.lval( Ddo_grid_Filteredtextto_get) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFLSD1CuitEmpl_3_11_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26TFLSD1CuitEmpl_3_11_To), 11, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1IdentificacionEnvio_14_2") == 0 )
         {
            AV28TFLSD1IdentificacionEnvio_14_2 = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFLSD1IdentificacionEnvio_14_2", AV28TFLSD1IdentificacionEnvio_14_2);
            AV27TFLSD1IdentificacionEnvio_14_2_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFLSD1IdentificacionEnvio_14_2_SelsJson", AV27TFLSD1IdentificacionEnvio_14_2_SelsJson);
            AV29TFLSD1IdentificacionEnvio_14_2_Sels.fromJSonString(AV27TFLSD1IdentificacionEnvio_14_2_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1periodoLiquidacion_16_6") == 0 )
         {
            AV30TFLSD1periodoLiquidacion_16_6 = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLSD1periodoLiquidacion_16_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFLSD1periodoLiquidacion_16_6), 6, 0));
            AV31TFLSD1periodoLiquidacion_16_6_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLSD1periodoLiquidacion_16_6_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFLSD1periodoLiquidacion_16_6_To), 6, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1tipoLiquidacion_22_1") == 0 )
         {
            AV33TFLSD1tipoLiquidacion_22_1 = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLSD1tipoLiquidacion_22_1", AV33TFLSD1tipoLiquidacion_22_1);
            AV32TFLSD1tipoLiquidacion_22_1_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLSD1tipoLiquidacion_22_1_SelsJson", AV32TFLSD1tipoLiquidacion_22_1_SelsJson);
            AV34TFLSD1tipoLiquidacion_22_1_Sels.fromJSonString(AV32TFLSD1tipoLiquidacion_22_1_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1numeroLiquidacion_23_5") == 0 )
         {
            AV35TFLSD1numeroLiquidacion_23_5 = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLSD1numeroLiquidacion_23_5", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFLSD1numeroLiquidacion_23_5), 5, 0));
            AV36TFLSD1numeroLiquidacion_23_5_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLSD1numeroLiquidacion_23_5_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFLSD1numeroLiquidacion_23_5_To), 5, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1diasBase_28_2") == 0 )
         {
            AV37TFLSD1diasBase_28_2 = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLSD1diasBase_28_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLSD1diasBase_28_2), 2, 0));
            AV38TFLSD1diasBase_28_2_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLSD1diasBase_28_2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLSD1diasBase_28_2_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD1cantidadRegistrosTipo04_30_6") == 0 )
         {
            AV39TFLSD1cantidadRegistrosTipo04_30_6 = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLSD1cantidadRegistrosTipo04_30_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39TFLSD1cantidadRegistrosTipo04_30_6), 6, 0));
            AV40TFLSD1cantidadRegistrosTipo04_30_6_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLSD1cantidadRegistrosTipo04_30_6_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40TFLSD1cantidadRegistrosTipo04_30_6_To), 6, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV34TFLSD1tipoLiquidacion_22_1_Sels", AV34TFLSD1tipoLiquidacion_22_1_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV29TFLSD1IdentificacionEnvio_14_2_Sels", AV29TFLSD1IdentificacionEnvio_14_2_Sels);
   }

   private void e21HE2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV46Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV46Update);
      if ( AV47IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.lsd_reg1", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0))}, new String[] {"Mode","CliCod","EmpCod","LSDSec"})  ;
      }
      AV48Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV48Delete);
      if ( AV49IsAuthorized_Delete )
      {
         if ( false )
         {
            edtavDelete_Link = formatLink("web.lsd_reg1", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0))}, new String[] {"Mode","CliCod","EmpCod","LSDSec"})  ;
            edtavDelete_Class = "Attribute" ;
         }
         else
         {
            edtavDelete_Link = "" ;
            edtavDelete_Class = "Invisible" ;
         }
      }
      AV62Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV62Display);
      edtavDisplay_Link = formatLink("web.lsd_reg1view", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LSD_reg2", "")))}, new String[] {"CliCod","EmpCod","LSDSec","TabCode"})  ;
      AV52download = "<i class=\"fas fa-download fas fa-download\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDownload_Internalname, AV52download);
      if ( ! (0==AV11parmNroLiq) )
      {
         edtavDownload_Class = "Attribute" ;
      }
      else
      {
         edtavDownload_Class = "Invisible" ;
      }
      AV58RegTipo = "01" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavRegtipo_Internalname, AV58RegTipo);
      edtavVersvg_Format = (short)(1) ;
      GXt_char7 = AV59VerSVG ;
      GXv_char3[0] = GXt_char7 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
      AV59VerSVG = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV59VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char7 = AV60ModificarSVG ;
      GXv_char3[0] = GXt_char7 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
      AV60ModificarSVG = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavModificarsvg_Internalname, AV60ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char7 = AV61EliminarSVG ;
      GXv_char3[0] = GXt_char7 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
      AV61EliminarSVG = GXt_char7 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminarsvg_Internalname, AV61EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(75) ;
      }
      sendrow_752( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_75_Refreshing )
      {
         httpContext.doAjaxLoad(75, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11HE2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV20ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV22ColumnsSelector.fromJSonString(AV20ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "LSD_reg1WWColumnsSelector", ((GXutil.strcmp("", AV20ColumnsSelectorXML)==0) ? "" : AV22ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV74ManageFiltersData", AV74ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV15GridState", AV15GridState);
   }

   public void e12HE2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S182 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("LSD_reg1WWFilters")),GXutil.URLEncode(GXutil.rtrim(AV96Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("LSD_reg1WWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      else
      {
         GXt_char7 = AV75ManageFiltersXml ;
         GXv_char3[0] = GXt_char7 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "LSD_reg1WWFilters", Ddo_managefilters_Activeeventkey, GXv_char3) ;
         lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
         AV75ManageFiltersXml = GXt_char7 ;
         if ( (GXutil.strcmp("", AV75ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV96Pgmname+"GridState", AV75ManageFiltersXml) ;
            AV15GridState.fromxml(AV75ManageFiltersXml, null, null);
            AV17OrderedBy = AV15GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
            AV18OrderedDsc = AV15GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18OrderedDsc", AV18OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S192 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV15GridState", AV15GridState);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV29TFLSD1IdentificacionEnvio_14_2_Sels", AV29TFLSD1IdentificacionEnvio_14_2_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV34TFLSD1tipoLiquidacion_22_1_Sels", AV34TFLSD1tipoLiquidacion_22_1_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV22ColumnsSelector", AV22ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV74ManageFiltersData", AV74ManageFiltersData);
   }

   public void e16HE2( )
   {
      /* 'DoDescargar' Routine */
      returnInSub = false ;
      GXv_char3[0] = AV53archivoAbsolute ;
      GXv_char9[0] = AV54NombreArchivo ;
      new web.bajalsdaarchivo2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, AV10parmPeriodo, 0, GXv_char3, GXv_char9) ;
      lsd_reg1ww_impl.this.AV53archivoAbsolute = GXv_char3[0] ;
      lsd_reg1ww_impl.this.AV54NombreArchivo = GXv_char9[0] ;
      callWebObject(formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV54NombreArchivo)),GXutil.URLEncode(GXutil.rtrim(AV53archivoAbsolute))}, new String[] {"contenttype","filename","filepath"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
   }

   public void e17HE2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV72ExcelFilename ;
      GXv_char3[0] = AV73ErrorMessage ;
      new web.lsd_reg1wwexport(remoteHandle, context).execute( GXv_char9, GXv_char3) ;
      lsd_reg1ww_impl.this.AV72ExcelFilename = GXv_char9[0] ;
      lsd_reg1ww_impl.this.AV73ErrorMessage = GXv_char3[0] ;
      if ( GXutil.strcmp(AV72ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV72ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV73ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV17OrderedBy, 4, 0))+":"+(AV18OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV22ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&RegTipo", "", "Identificador", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1CuitEmpl_3_11", "", "CUIT", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1IdentificacionEnvio_14_2", "", "Identif. envío", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1periodoLiquidacion_16_6", "", "Período", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1tipoLiquidacion_22_1", "", "Tipo de liquidación", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1numeroLiquidacion_23_5", "", "Nro. Liq.", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1diasBase_28_2", "", "Días base", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "LSD1cantidadRegistrosTipo04_30_6", "", "Cantidad de registros tipo 04", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&VerSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXv_SdtWWPColumnsSelector10[0] = AV22ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, "&ModificarSVG", "", "", true, "") ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector10[0] ;
      GXt_char7 = AV21UserCustomValue ;
      GXv_char9[0] = GXt_char7 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LSD_reg1WWColumnsSelector", GXv_char9) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char9[0] ;
      AV21UserCustomValue = GXt_char7 ;
      if ( ! ( (GXutil.strcmp("", AV21UserCustomValue)==0) ) )
      {
         AV23ColumnsSelectorAux.fromxml(AV21UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector10[0] = AV23ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector11[0] = AV22ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector10, GXv_SdtWWPColumnsSelector11) ;
         AV23ColumnsSelectorAux = GXv_SdtWWPColumnsSelector10[0] ;
         AV22ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
      }
      GXv_SdtWWPColumnsSelector11[0] = AV22ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV8CliCod, GXv_SdtWWPColumnsSelector11) ;
      AV22ColumnsSelector = GXv_SdtWWPColumnsSelector11[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( (0==AV11parmNroLiq) ) )
      {
         bttBtndescargar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndescargar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndescargar_Visible), 5, 0), true);
      }
      GXt_boolean12 = AV47IsAuthorized_Update ;
      GXv_boolean13[0] = GXt_boolean12 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg1_Update", GXv_boolean13) ;
      lsd_reg1ww_impl.this.GXt_boolean12 = GXv_boolean13[0] ;
      AV47IsAuthorized_Update = GXt_boolean12 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47IsAuthorized_Update", AV47IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV47IsAuthorized_Update));
      if ( ! ( AV47IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_75_Refreshing);
      }
      GXt_boolean12 = AV49IsAuthorized_Delete ;
      GXv_boolean13[0] = GXt_boolean12 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg1_Delete", GXv_boolean13) ;
      lsd_reg1ww_impl.this.GXt_boolean12 = GXv_boolean13[0] ;
      AV49IsAuthorized_Delete = GXt_boolean12 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49IsAuthorized_Delete", AV49IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV49IsAuthorized_Delete));
      if ( ! ( AV49IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_75_Refreshing);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = AV74ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "LSD_reg1WWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[0] ;
      AV74ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV25TFLSD1CuitEmpl_3_11 = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLSD1CuitEmpl_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLSD1CuitEmpl_3_11), 11, 0));
      AV26TFLSD1CuitEmpl_3_11_To = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFLSD1CuitEmpl_3_11_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26TFLSD1CuitEmpl_3_11_To), 11, 0));
      AV28TFLSD1IdentificacionEnvio_14_2 = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFLSD1IdentificacionEnvio_14_2", AV28TFLSD1IdentificacionEnvio_14_2);
      AV29TFLSD1IdentificacionEnvio_14_2_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30TFLSD1periodoLiquidacion_16_6 = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLSD1periodoLiquidacion_16_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFLSD1periodoLiquidacion_16_6), 6, 0));
      AV31TFLSD1periodoLiquidacion_16_6_To = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLSD1periodoLiquidacion_16_6_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFLSD1periodoLiquidacion_16_6_To), 6, 0));
      AV33TFLSD1tipoLiquidacion_22_1 = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLSD1tipoLiquidacion_22_1", AV33TFLSD1tipoLiquidacion_22_1);
      AV34TFLSD1tipoLiquidacion_22_1_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV35TFLSD1numeroLiquidacion_23_5 = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLSD1numeroLiquidacion_23_5", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFLSD1numeroLiquidacion_23_5), 5, 0));
      AV36TFLSD1numeroLiquidacion_23_5_To = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLSD1numeroLiquidacion_23_5_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFLSD1numeroLiquidacion_23_5_To), 5, 0));
      AV37TFLSD1diasBase_28_2 = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLSD1diasBase_28_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLSD1diasBase_28_2), 2, 0));
      AV38TFLSD1diasBase_28_2_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLSD1diasBase_28_2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLSD1diasBase_28_2_To), 2, 0));
      AV39TFLSD1cantidadRegistrosTipo04_30_6 = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLSD1cantidadRegistrosTipo04_30_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39TFLSD1cantidadRegistrosTipo04_30_6), 6, 0));
      AV40TFLSD1cantidadRegistrosTipo04_30_6_To = 0 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLSD1cantidadRegistrosTipo04_30_6_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40TFLSD1cantidadRegistrosTipo04_30_6_To), 6, 0));
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue(AV96Pgmname+"GridState"), "") == 0 )
      {
         AV15GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV96Pgmname+"GridState"), null, null);
      }
      else
      {
         AV15GridState.fromxml(AV24Session.getValue(AV96Pgmname+"GridState"), null, null);
      }
      AV17OrderedBy = AV15GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
      AV18OrderedDsc = AV15GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18OrderedDsc", AV18OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV15GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV15GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV15GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV113GXV1 = 1 ;
      while ( AV113GXV1 <= AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV113GXV1));
         if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1CUITEMPL_3_11") == 0 )
         {
            AV25TFLSD1CuitEmpl_3_11 = GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFLSD1CuitEmpl_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25TFLSD1CuitEmpl_3_11), 11, 0));
            AV26TFLSD1CuitEmpl_3_11_To = GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFLSD1CuitEmpl_3_11_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26TFLSD1CuitEmpl_3_11_To), 11, 0));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1IDENTIFICACIONENVIO_14_2") == 0 )
         {
            AV28TFLSD1IdentificacionEnvio_14_2 = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFLSD1IdentificacionEnvio_14_2", AV28TFLSD1IdentificacionEnvio_14_2);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1IDENTIFICACIONENVIO_14_2_SEL") == 0 )
         {
            AV27TFLSD1IdentificacionEnvio_14_2_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFLSD1IdentificacionEnvio_14_2_SelsJson", AV27TFLSD1IdentificacionEnvio_14_2_SelsJson);
            AV29TFLSD1IdentificacionEnvio_14_2_Sels.fromJSonString(AV27TFLSD1IdentificacionEnvio_14_2_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1PERIODOLIQUIDACION_16_6") == 0 )
         {
            AV30TFLSD1periodoLiquidacion_16_6 = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLSD1periodoLiquidacion_16_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30TFLSD1periodoLiquidacion_16_6), 6, 0));
            AV31TFLSD1periodoLiquidacion_16_6_To = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLSD1periodoLiquidacion_16_6_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31TFLSD1periodoLiquidacion_16_6_To), 6, 0));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1TIPOLIQUIDACION_22_1") == 0 )
         {
            AV33TFLSD1tipoLiquidacion_22_1 = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLSD1tipoLiquidacion_22_1", AV33TFLSD1tipoLiquidacion_22_1);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1TIPOLIQUIDACION_22_1_SEL") == 0 )
         {
            AV32TFLSD1tipoLiquidacion_22_1_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLSD1tipoLiquidacion_22_1_SelsJson", AV32TFLSD1tipoLiquidacion_22_1_SelsJson);
            AV34TFLSD1tipoLiquidacion_22_1_Sels.fromJSonString(AV32TFLSD1tipoLiquidacion_22_1_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1NUMEROLIQUIDACION_23_5") == 0 )
         {
            AV35TFLSD1numeroLiquidacion_23_5 = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLSD1numeroLiquidacion_23_5", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFLSD1numeroLiquidacion_23_5), 5, 0));
            AV36TFLSD1numeroLiquidacion_23_5_To = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLSD1numeroLiquidacion_23_5_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFLSD1numeroLiquidacion_23_5_To), 5, 0));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1DIASBASE_28_2") == 0 )
         {
            AV37TFLSD1diasBase_28_2 = (byte)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLSD1diasBase_28_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFLSD1diasBase_28_2), 2, 0));
            AV38TFLSD1diasBase_28_2_To = (byte)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLSD1diasBase_28_2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFLSD1diasBase_28_2_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1CANTIDADREGISTROSTIPO04_30_6") == 0 )
         {
            AV39TFLSD1cantidadRegistrosTipo04_30_6 = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLSD1cantidadRegistrosTipo04_30_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39TFLSD1cantidadRegistrosTipo04_30_6), 6, 0));
            AV40TFLSD1cantidadRegistrosTipo04_30_6_To = (int)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLSD1cantidadRegistrosTipo04_30_6_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40TFLSD1cantidadRegistrosTipo04_30_6_To), 6, 0));
         }
         AV113GXV1 = (int)(AV113GXV1+1) ;
      }
      GXt_char7 = "" ;
      GXv_char9[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV29TFLSD1IdentificacionEnvio_14_2_Sels.size()==0), AV27TFLSD1IdentificacionEnvio_14_2_SelsJson, GXv_char9) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char9[0] ;
      GXt_char16 = "" ;
      GXv_char3[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV34TFLSD1tipoLiquidacion_22_1_Sels.size()==0), AV32TFLSD1tipoLiquidacion_22_1_SelsJson, GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char16 = GXv_char3[0] ;
      Ddo_grid_Selectedvalue_set = "||"+GXt_char7+"||"+GXt_char16+"|||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char16 = "" ;
      GXv_char9[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFLSD1IdentificacionEnvio_14_2)==0), AV28TFLSD1IdentificacionEnvio_14_2, GXv_char9) ;
      lsd_reg1ww_impl.this.GXt_char16 = GXv_char9[0] ;
      GXt_char7 = "" ;
      GXv_char3[0] = GXt_char7 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV33TFLSD1tipoLiquidacion_22_1)==0), AV33TFLSD1tipoLiquidacion_22_1, GXv_char3) ;
      lsd_reg1ww_impl.this.GXt_char7 = GXv_char3[0] ;
      Ddo_grid_Filteredtext_set = "|"+((0==AV25TFLSD1CuitEmpl_3_11) ? "" : GXutil.str( AV25TFLSD1CuitEmpl_3_11, 11, 0))+"|"+GXt_char16+"|"+((0==AV30TFLSD1periodoLiquidacion_16_6) ? "" : GXutil.str( AV30TFLSD1periodoLiquidacion_16_6, 6, 0))+"|"+GXt_char7+"|"+((0==AV35TFLSD1numeroLiquidacion_23_5) ? "" : GXutil.str( AV35TFLSD1numeroLiquidacion_23_5, 5, 0))+"|"+((0==AV37TFLSD1diasBase_28_2) ? "" : GXutil.str( AV37TFLSD1diasBase_28_2, 2, 0))+"|"+((0==AV39TFLSD1cantidadRegistrosTipo04_30_6) ? "" : GXutil.str( AV39TFLSD1cantidadRegistrosTipo04_30_6, 6, 0)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+((0==AV26TFLSD1CuitEmpl_3_11_To) ? "" : GXutil.str( AV26TFLSD1CuitEmpl_3_11_To, 11, 0))+"||"+((0==AV31TFLSD1periodoLiquidacion_16_6_To) ? "" : GXutil.str( AV31TFLSD1periodoLiquidacion_16_6_To, 6, 0))+"||"+((0==AV36TFLSD1numeroLiquidacion_23_5_To) ? "" : GXutil.str( AV36TFLSD1numeroLiquidacion_23_5_To, 5, 0))+"|"+((0==AV38TFLSD1diasBase_28_2_To) ? "" : GXutil.str( AV38TFLSD1diasBase_28_2_To, 2, 0))+"|"+((0==AV40TFLSD1cantidadRegistrosTipo04_30_6_To) ? "" : GXutil.str( AV40TFLSD1cantidadRegistrosTipo04_30_6_To, 6, 0)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV15GridState.fromxml(AV24Session.getValue(AV96Pgmname+"GridState"), null, null);
      AV15GridState.setgxTv_SdtWWPGridState_Orderedby( AV17OrderedBy );
      AV15GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV18OrderedDsc );
      AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1CUITEMPL_3_11", httpContext.getMessage( "CUIT", ""), !((0==AV25TFLSD1CuitEmpl_3_11)&&(0==AV26TFLSD1CuitEmpl_3_11_To)), (short)(0), GXutil.trim( GXutil.str( AV25TFLSD1CuitEmpl_3_11, 11, 0)), GXutil.trim( GXutil.str( AV26TFLSD1CuitEmpl_3_11_To, 11, 0))) ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1IDENTIFICACIONENVIO_14_2", httpContext.getMessage( "Identif. envío", ""), !(GXutil.strcmp("", AV28TFLSD1IdentificacionEnvio_14_2)==0), (short)(0), AV28TFLSD1IdentificacionEnvio_14_2, "", !(AV29TFLSD1IdentificacionEnvio_14_2_Sels.size()==0), AV29TFLSD1IdentificacionEnvio_14_2_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1PERIODOLIQUIDACION_16_6", httpContext.getMessage( "Período", ""), !((0==AV30TFLSD1periodoLiquidacion_16_6)&&(0==AV31TFLSD1periodoLiquidacion_16_6_To)), (short)(0), GXutil.trim( GXutil.str( AV30TFLSD1periodoLiquidacion_16_6, 6, 0)), GXutil.trim( GXutil.str( AV31TFLSD1periodoLiquidacion_16_6_To, 6, 0))) ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1TIPOLIQUIDACION_22_1", httpContext.getMessage( "Tipo de liquidación", ""), !(GXutil.strcmp("", AV33TFLSD1tipoLiquidacion_22_1)==0), (short)(0), AV33TFLSD1tipoLiquidacion_22_1, "", !(AV34TFLSD1tipoLiquidacion_22_1_Sels.size()==0), AV34TFLSD1tipoLiquidacion_22_1_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1NUMEROLIQUIDACION_23_5", httpContext.getMessage( "Nro. Liq.", ""), !((0==AV35TFLSD1numeroLiquidacion_23_5)&&(0==AV36TFLSD1numeroLiquidacion_23_5_To)), (short)(0), GXutil.trim( GXutil.str( AV35TFLSD1numeroLiquidacion_23_5, 5, 0)), GXutil.trim( GXutil.str( AV36TFLSD1numeroLiquidacion_23_5_To, 5, 0))) ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1DIASBASE_28_2", httpContext.getMessage( "Días base", ""), !((0==AV37TFLSD1diasBase_28_2)&&(0==AV38TFLSD1diasBase_28_2_To)), (short)(0), GXutil.trim( GXutil.str( AV37TFLSD1diasBase_28_2, 2, 0)), GXutil.trim( GXutil.str( AV38TFLSD1diasBase_28_2_To, 2, 0))) ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      GXv_SdtWWPGridState17[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState17, "TFLSD1CANTIDADREGISTROSTIPO04_30_6", httpContext.getMessage( "Cantidad de registros tipo 04", ""), !((0==AV39TFLSD1cantidadRegistrosTipo04_30_6)&&(0==AV40TFLSD1cantidadRegistrosTipo04_30_6_To)), (short)(0), GXutil.trim( GXutil.str( AV39TFLSD1cantidadRegistrosTipo04_30_6, 6, 0)), GXutil.trim( GXutil.str( AV40TFLSD1cantidadRegistrosTipo04_30_6_To, 6, 0))) ;
      AV15GridState = GXv_SdtWWPGridState17[0] ;
      if ( ! (GXutil.strcmp("", AV63MenuOpcCod)==0) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV63MenuOpcCod );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
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
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10parmPeriodo)) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&PARMPERIODO" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( localUtil.dtoc( AV10parmPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      if ( ! (0==AV11parmNroLiq) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&PARMNROLIQ" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV11parmNroLiq, 8, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      AV15GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV15GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV96Pgmname+"GridState", AV15GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV13TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV96Pgmname );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV12HTTPRequest.getScriptName()+"?"+AV12HTTPRequest.getQuerystring() );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LSD_reg1" );
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV24Session.setValue("TrnContext", AV13TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e22HE2( )
   {
      /* Download_Click Routine */
      returnInSub = false ;
      GXv_char9[0] = AV53archivoAbsolute ;
      GXv_char3[0] = AV54NombreArchivo ;
      new web.bajalsdaarchivo2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A1649LSDSec, AV56date, 0, GXv_char9, GXv_char3) ;
      lsd_reg1ww_impl.this.AV53archivoAbsolute = GXv_char9[0] ;
      lsd_reg1ww_impl.this.AV54NombreArchivo = GXv_char3[0] ;
      callWebObject(formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV54NombreArchivo)),GXutil.URLEncode(GXutil.rtrim(AV53archivoAbsolute))}, new String[] {"contenttype","filename","filepath"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
   }

   public void e18HE2( )
   {
      /* GlobalEvents_Mensajeliquidacion Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV96Pgmname, httpContext.getMessage( "&mensajeTexto ", "")+AV87mensajeTexto) ;
      AV88mensajesNotificacion = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV87mensajeTexto," ")) ;
      if ( AV88mensajesNotificacion.size() == 3 )
      {
         AV89LiquidacionEstado = (byte)(1) ;
         AV90msgNotiEstado = (String)AV88mensajesNotificacion.elementAt(-1+1) ;
         AV91msgNotiPgm = (String)AV88mensajesNotificacion.elementAt(-1+2) ;
         AV92msgNotiLiqNro = (int)(GXutil.lval( (String)AV88mensajesNotificacion.elementAt(-1+3))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV96Pgmname, httpContext.getMessage( "&msgNotiPgm ", "")+AV91msgNotiPgm) ;
         if ( ( GXutil.strcmp(AV91msgNotiPgm, httpContext.getMessage( "DEPENDENCIAS_LSD", "")) == 0 ) || ( GXutil.strcmp(AV91msgNotiPgm, httpContext.getMessage( "GuardaLiquidacion", "")) == 0 ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV96Pgmname, httpContext.getMessage( "&&msgNotiEstado ", "")+AV90msgNotiEstado) ;
            if ( GXutil.strcmp(AV90msgNotiEstado, httpContext.getMessage( "OK", "")) == 0 )
            {
               if ( GXutil.strcmp(AV91msgNotiPgm, httpContext.getMessage( "GuardaLiquidacion", "")) == 0 )
               {
                  AV89LiquidacionEstado = (byte)(1) ;
               }
               else
               {
                  AV89LiquidacionEstado = (byte)(3) ;
               }
            }
            else
            {
               AV89LiquidacionEstado = (byte)(2) ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV96Pgmname, httpContext.getMessage( "&msgNotiLiqNro ", "")+GXutil.str( AV92msgNotiLiqNro, 8, 0)) ;
            AV86EstadoLSDDep = GXutil.trim( httpContext.getMessage( web.gxdomainliquidacionestado.getDescription(httpContext,(byte)AV89LiquidacionEstado), "")) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV86EstadoLSDDep", AV86EstadoLSDDep);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV96Pgmname, httpContext.getMessage( "actualiza a ", "")+AV86EstadoLSDDep) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_HE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_HE2( true) ;
      }
      else
      {
         wb_table2_12_HE2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_HE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_HE2e( true) ;
      }
      else
      {
         wb_table1_9_HE2e( false) ;
      }
   }

   public void wb_table2_12_HE2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablepadding_Internalname, tblTablepadding_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablefiltrospadre_Internalname, 1, 0, "px", 0, "px", "TableFiltrosPadre", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table3_17_HE2( true) ;
      }
      else
      {
         wb_table3_17_HE2( false) ;
      }
      return  ;
   }

   public void wb_table3_17_HE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table4_26_HE2( true) ;
      }
      else
      {
         wb_table4_26_HE2( false) ;
      }
      return  ;
   }

   public void wb_table4_26_HE2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavEstadolsddep_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEstadolsddep_Internalname, httpContext.getMessage( "Estado", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'" + sGXsfl_75_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEstadolsddep_Internalname, GXutil.rtrim( AV86EstadoLSDDep), GXutil.rtrim( localUtil.format( AV86EstadoLSDDep, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEstadolsddep_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEstadolsddep_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg1WW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         startgridcontrol75( ) ;
      }
      if ( wbEnd == 75 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_75 = (int)(nGXsfl_75_idx-1) ;
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
         wb_table2_12_HE2e( true) ;
      }
      else
      {
         wb_table2_12_HE2e( false) ;
      }
   }

   public void wb_table4_26_HE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LSD_reg1WW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LSD_reg1WW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV41DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV22ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, sPrefix+"DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV74ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, sPrefix+"DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 75, 2, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg1WW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_LSD_reg1WW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_LSD_reg1WW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table5_60_HE2( true) ;
      }
      else
      {
         wb_table5_60_HE2( false) ;
      }
      return  ;
   }

   public void wb_table5_60_HE2e( boolean wbgen )
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
         wb_table4_26_HE2e( true) ;
      }
      else
      {
         wb_table4_26_HE2e( false) ;
      }
   }

   public void wb_table5_60_HE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_LSD_reg1WW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_60_HE2e( true) ;
      }
      else
      {
         wb_table5_60_HE2e( false) ;
      }
   }

   public void wb_table3_17_HE2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_LSD_reg1WW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_LSD_reg1WW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_17_HE2e( true) ;
      }
      else
      {
         wb_table3_17_HE2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV63MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63MenuOpcCod", AV63MenuOpcCod);
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      AV10parmPeriodo = (java.util.Date)getParm(obj,3,TypeConstants.DATE) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10parmPeriodo", localUtil.format(AV10parmPeriodo, "99/99/99"));
      AV11parmNroLiq = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11parmNroLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11parmNroLiq), 8, 0));
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
      paHE2( ) ;
      wsHE2( ) ;
      weHE2( ) ;
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
      sCtrlAV63MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV8CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV9EmpCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV10parmPeriodo = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlAV11parmNroLiq = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paHE2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "lsd_reg1ww", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paHE2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV63MenuOpcCod = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63MenuOpcCod", AV63MenuOpcCod);
         AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
         AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
         AV10parmPeriodo = (java.util.Date)getParm(obj,5,TypeConstants.DATE) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10parmPeriodo", localUtil.format(AV10parmPeriodo, "99/99/99"));
         AV11parmNroLiq = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11parmNroLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11parmNroLiq), 8, 0));
      }
      wcpOAV63MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV63MenuOpcCod") ;
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10parmPeriodo = localUtil.ctod( httpContext.cgiGet( sPrefix+"wcpOAV10parmPeriodo"), 0) ;
      wcpOAV11parmNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11parmNroLiq"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV63MenuOpcCod, wcpOAV63MenuOpcCod) != 0 ) || ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || !( GXutil.dateCompare(GXutil.resetTime(AV10parmPeriodo), GXutil.resetTime(wcpOAV10parmPeriodo)) ) || ( AV11parmNroLiq != wcpOAV11parmNroLiq ) ) )
      {
         setjustcreated();
      }
      wcpOAV63MenuOpcCod = AV63MenuOpcCod ;
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV10parmPeriodo = AV10parmPeriodo ;
      wcpOAV11parmNroLiq = AV11parmNroLiq ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV63MenuOpcCod = httpContext.cgiGet( sPrefix+"AV63MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV63MenuOpcCod) > 0 )
      {
         AV63MenuOpcCod = httpContext.cgiGet( sCtrlAV63MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63MenuOpcCod", AV63MenuOpcCod);
      }
      else
      {
         AV63MenuOpcCod = httpContext.cgiGet( sPrefix+"AV63MenuOpcCod_PARM") ;
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
      sCtrlAV10parmPeriodo = httpContext.cgiGet( sPrefix+"AV10parmPeriodo_CTRL") ;
      if ( GXutil.len( sCtrlAV10parmPeriodo) > 0 )
      {
         AV10parmPeriodo = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( sCtrlAV10parmPeriodo), 0)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10parmPeriodo", localUtil.format(AV10parmPeriodo, "99/99/99"));
      }
      else
      {
         AV10parmPeriodo = localUtil.ctod( httpContext.cgiGet( sPrefix+"AV10parmPeriodo_PARM"), 0) ;
      }
      sCtrlAV11parmNroLiq = httpContext.cgiGet( sPrefix+"AV11parmNroLiq_CTRL") ;
      if ( GXutil.len( sCtrlAV11parmNroLiq) > 0 )
      {
         AV11parmNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV11parmNroLiq), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11parmNroLiq", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11parmNroLiq), 8, 0));
      }
      else
      {
         AV11parmNroLiq = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV11parmNroLiq_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paHE2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsHE2( ) ;
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
      wsHE2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV63MenuOpcCod_PARM", AV63MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV63MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV63MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV63MenuOpcCod));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10parmPeriodo_PARM", localUtil.dtoc( AV10parmPeriodo, 0, "/"));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10parmPeriodo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10parmPeriodo_CTRL", GXutil.rtrim( sCtrlAV10parmPeriodo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11parmNroLiq_PARM", GXutil.ltrim( localUtil.ntoc( AV11parmNroLiq, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11parmNroLiq)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11parmNroLiq_CTRL", GXutil.rtrim( sCtrlAV11parmNroLiq));
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
      weHE2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251312373259", true, true);
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
      httpContext.AddJavascriptSource("lsd_reg1ww.js", "?20251312373259", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_752( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_75_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_75_idx ;
      edtLSDSec_Internalname = sPrefix+"LSDSEC_"+sGXsfl_75_idx ;
      edtavRegtipo_Internalname = sPrefix+"vREGTIPO_"+sGXsfl_75_idx ;
      edtLSD1CuitEmpl_3_11_Internalname = sPrefix+"LSD1CUITEMPL_3_11_"+sGXsfl_75_idx ;
      edtLSD1IdentificacionEnvio_14_2_Internalname = sPrefix+"LSD1IDENTIFICACIONENVIO_14_2_"+sGXsfl_75_idx ;
      edtLSD1periodoLiquidacion_16_6_Internalname = sPrefix+"LSD1PERIODOLIQUIDACION_16_6_"+sGXsfl_75_idx ;
      edtLSD1tipoLiquidacion_22_1_Internalname = sPrefix+"LSD1TIPOLIQUIDACION_22_1_"+sGXsfl_75_idx ;
      edtLSD1numeroLiquidacion_23_5_Internalname = sPrefix+"LSD1NUMEROLIQUIDACION_23_5_"+sGXsfl_75_idx ;
      edtLSD1diasBase_28_2_Internalname = sPrefix+"LSD1DIASBASE_28_2_"+sGXsfl_75_idx ;
      edtLSD1cantidadRegistrosTipo04_30_Internalname = sPrefix+"LSD1CANTIDADREGISTROSTIPO04_30_"+sGXsfl_75_idx ;
      edtLSD1LiqNro_Internalname = sPrefix+"LSD1LIQNRO_"+sGXsfl_75_idx ;
      edtLSD1LiqPeriodo_Internalname = sPrefix+"LSD1LIQPERIODO_"+sGXsfl_75_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_75_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_75_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_75_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_75_idx ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG_"+sGXsfl_75_idx ;
      edtavEliminarsvg_Internalname = sPrefix+"vELIMINARSVG_"+sGXsfl_75_idx ;
      edtavDownload_Internalname = sPrefix+"vDOWNLOAD_"+sGXsfl_75_idx ;
   }

   public void subsflControlProps_fel_752( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_75_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_75_fel_idx ;
      edtLSDSec_Internalname = sPrefix+"LSDSEC_"+sGXsfl_75_fel_idx ;
      edtavRegtipo_Internalname = sPrefix+"vREGTIPO_"+sGXsfl_75_fel_idx ;
      edtLSD1CuitEmpl_3_11_Internalname = sPrefix+"LSD1CUITEMPL_3_11_"+sGXsfl_75_fel_idx ;
      edtLSD1IdentificacionEnvio_14_2_Internalname = sPrefix+"LSD1IDENTIFICACIONENVIO_14_2_"+sGXsfl_75_fel_idx ;
      edtLSD1periodoLiquidacion_16_6_Internalname = sPrefix+"LSD1PERIODOLIQUIDACION_16_6_"+sGXsfl_75_fel_idx ;
      edtLSD1tipoLiquidacion_22_1_Internalname = sPrefix+"LSD1TIPOLIQUIDACION_22_1_"+sGXsfl_75_fel_idx ;
      edtLSD1numeroLiquidacion_23_5_Internalname = sPrefix+"LSD1NUMEROLIQUIDACION_23_5_"+sGXsfl_75_fel_idx ;
      edtLSD1diasBase_28_2_Internalname = sPrefix+"LSD1DIASBASE_28_2_"+sGXsfl_75_fel_idx ;
      edtLSD1cantidadRegistrosTipo04_30_Internalname = sPrefix+"LSD1CANTIDADREGISTROSTIPO04_30_"+sGXsfl_75_fel_idx ;
      edtLSD1LiqNro_Internalname = sPrefix+"LSD1LIQNRO_"+sGXsfl_75_fel_idx ;
      edtLSD1LiqPeriodo_Internalname = sPrefix+"LSD1LIQPERIODO_"+sGXsfl_75_fel_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_75_fel_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_75_fel_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_75_fel_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_75_fel_idx ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG_"+sGXsfl_75_fel_idx ;
      edtavEliminarsvg_Internalname = sPrefix+"vELIMINARSVG_"+sGXsfl_75_fel_idx ;
      edtavDownload_Internalname = sPrefix+"vDOWNLOAD_"+sGXsfl_75_fel_idx ;
   }

   public void sendrow_752( )
   {
      subsflControlProps_752( ) ;
      wbHE0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_75_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_75_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_75_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSDSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSDSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavRegtipo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavRegtipo_Enabled!=0)&&(edtavRegtipo_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 79,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavRegtipo_Internalname,GXutil.rtrim( AV58RegTipo),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavRegtipo_Enabled!=0)&&(edtavRegtipo_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,79);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavRegtipo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavRegtipo_Visible),Integer.valueOf(edtavRegtipo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLSD1CuitEmpl_3_11_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1CuitEmpl_3_11_Internalname,GXutil.ltrim( localUtil.ntoc( A1650LSD1CuitEmpl_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1650LSD1CuitEmpl_3_11), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1CuitEmpl_3_11_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1CuitEmpl_3_11_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLSD1IdentificacionEnvio_14_2_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1IdentificacionEnvio_14_2_Internalname,GXutil.rtrim( A1651LSD1IdentificacionEnvio_14_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1IdentificacionEnvio_14_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1IdentificacionEnvio_14_2_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLSD1periodoLiquidacion_16_6_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1periodoLiquidacion_16_6_Internalname,GXutil.ltrim( localUtil.ntoc( A1652LSD1periodoLiquidacion_16_6, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1652LSD1periodoLiquidacion_16_6), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1periodoLiquidacion_16_6_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1periodoLiquidacion_16_6_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLSD1tipoLiquidacion_22_1_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1tipoLiquidacion_22_1_Internalname,GXutil.rtrim( A1653LSD1tipoLiquidacion_22_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1tipoLiquidacion_22_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1tipoLiquidacion_22_1_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLSD1numeroLiquidacion_23_5_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1numeroLiquidacion_23_5_Internalname,GXutil.ltrim( localUtil.ntoc( A1654LSD1numeroLiquidacion_23_5, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1654LSD1numeroLiquidacion_23_5), "ZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1numeroLiquidacion_23_5_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1numeroLiquidacion_23_5_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLSD1diasBase_28_2_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1diasBase_28_2_Internalname,GXutil.ltrim( localUtil.ntoc( A1655LSD1diasBase_28_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1655LSD1diasBase_28_2), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1diasBase_28_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1diasBase_28_2_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLSD1cantidadRegistrosTipo04_30_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1cantidadRegistrosTipo04_30_Internalname,GXutil.ltrim( localUtil.ntoc( A1656LSD1cantidadRegistrosTipo04_30, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1656LSD1cantidadRegistrosTipo04_30), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1cantidadRegistrosTipo04_30_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLSD1cantidadRegistrosTipo04_30_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1LiqNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1733LSD1LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1733LSD1LiqNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1LiqNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD1LiqPeriodo_Internalname,localUtil.format(A1734LSD1LiqPeriodo, "99/99/99"),localUtil.format( A1734LSD1LiqPeriodo, "99/99/99"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD1LiqPeriodo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Periodo","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 89,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV46Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,89);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 90,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = edtavDelete_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV48Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,90);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),edtavDelete_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 91,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV62Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,91);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 92,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV59VerSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavVersvg_Enabled!=0)&&(edtavVersvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,92);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 93,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV60ModificarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavModificarsvg_Enabled!=0)&&(edtavModificarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,93);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 94,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV61EliminarSVG),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminarsvg_Enabled!=0)&&(edtavEliminarsvg_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,94);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDownload_Enabled!=0)&&(edtavDownload_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 95,'"+sPrefix+"',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
         ROClassString = edtavDownload_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDownload_Internalname,GXutil.rtrim( AV52download),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDownload_Enabled!=0)&&(edtavDownload_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,95);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVDOWNLOAD.CLICK."+sGXsfl_75_idx+"'","","","","",edtavDownload_Jsonclick,Integer.valueOf(5),edtavDownload_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDownload_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesHE2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_75_idx = ((subGrid_Islastpage==1)&&(nGXsfl_75_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_75_idx+1) ;
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_752( ) ;
      }
      /* End function sendrow_752 */
   }

   public void startgridcontrol75( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"75\">") ;
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
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavRegtipo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Identificador", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1CuitEmpl_3_11_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIT", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1IdentificacionEnvio_14_2_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Identif. envío", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1periodoLiquidacion_16_6_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Período", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1tipoLiquidacion_22_1_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1numeroLiquidacion_23_5_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro. Liq.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1diasBase_28_2_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días base", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLSD1cantidadRegistrosTipo04_30_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de registros tipo 04", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDelete_Class+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDownload_Class+"\" "+" style=\""+""+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV58RegTipo));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavRegtipo_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavRegtipo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1650LSD1CuitEmpl_3_11, (byte)(11), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1CuitEmpl_3_11_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1651LSD1IdentificacionEnvio_14_2));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1IdentificacionEnvio_14_2_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1652LSD1periodoLiquidacion_16_6, (byte)(6), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1periodoLiquidacion_16_6_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1653LSD1tipoLiquidacion_22_1));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1tipoLiquidacion_22_1_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1654LSD1numeroLiquidacion_23_5, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1numeroLiquidacion_23_5_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1655LSD1diasBase_28_2, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1diasBase_28_2_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1656LSD1cantidadRegistrosTipo04_30, (byte)(6), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLSD1cantidadRegistrosTipo04_30_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1733LSD1LiqNro, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A1734LSD1LiqPeriodo, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV46Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV48Delete));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDelete_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV62Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV59VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV60ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV61EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV52download));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDownload_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDownload_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      lblButtonexport1_textblock_svg_Internalname = sPrefix+"BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = sPrefix+"BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = sPrefix+"BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = sPrefix+"BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = sPrefix+"BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = sPrefix+"BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = sPrefix+"DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = sPrefix+"DDO_MANAGEFILTERS" ;
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
      edtavEstadolsddep_Internalname = sPrefix+"vESTADOLSDDEP" ;
      divTablefiltrospadre_Internalname = sPrefix+"TABLEFILTROSPADRE" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLSDSec_Internalname = sPrefix+"LSDSEC" ;
      edtavRegtipo_Internalname = sPrefix+"vREGTIPO" ;
      edtLSD1CuitEmpl_3_11_Internalname = sPrefix+"LSD1CUITEMPL_3_11" ;
      edtLSD1IdentificacionEnvio_14_2_Internalname = sPrefix+"LSD1IDENTIFICACIONENVIO_14_2" ;
      edtLSD1periodoLiquidacion_16_6_Internalname = sPrefix+"LSD1PERIODOLIQUIDACION_16_6" ;
      edtLSD1tipoLiquidacion_22_1_Internalname = sPrefix+"LSD1TIPOLIQUIDACION_22_1" ;
      edtLSD1numeroLiquidacion_23_5_Internalname = sPrefix+"LSD1NUMEROLIQUIDACION_23_5" ;
      edtLSD1diasBase_28_2_Internalname = sPrefix+"LSD1DIASBASE_28_2" ;
      edtLSD1cantidadRegistrosTipo04_30_Internalname = sPrefix+"LSD1CANTIDADREGISTROSTIPO04_30" ;
      edtLSD1LiqNro_Internalname = sPrefix+"LSD1LIQNRO" ;
      edtLSD1LiqPeriodo_Internalname = sPrefix+"LSD1LIQPERIODO" ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE" ;
      edtavDelete_Internalname = sPrefix+"vDELETE" ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY" ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG" ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = sPrefix+"vELIMINARSVG" ;
      edtavDownload_Internalname = sPrefix+"vDOWNLOAD" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = sPrefix+"TABLEPADDING" ;
      tblTablemainfix_Internalname = sPrefix+"TABLEMAINFIX" ;
      bttBtndescargar_Internalname = sPrefix+"BTNDESCARGAR" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtavParmperiodo_Internalname = sPrefix+"vPARMPERIODO" ;
      edtavParmnroliq_Internalname = sPrefix+"vPARMNROLIQ" ;
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
      edtavDownload_Jsonclick = "" ;
      edtavDownload_Class = "Attribute" ;
      edtavDownload_Visible = -1 ;
      edtavDownload_Enabled = 1 ;
      edtavEliminarsvg_Jsonclick = "" ;
      edtavEliminarsvg_Visible = 0 ;
      edtavEliminarsvg_Link = "" ;
      edtavEliminarsvg_Enabled = 1 ;
      edtavEliminarsvg_Format = (short)(0) ;
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
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 1 ;
      edtavDisplay_Visible = -1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Class = "Attribute" ;
      edtavDelete_Enabled = 1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 1 ;
      edtLSD1LiqPeriodo_Jsonclick = "" ;
      edtLSD1LiqNro_Jsonclick = "" ;
      edtLSD1cantidadRegistrosTipo04_30_Jsonclick = "" ;
      edtLSD1diasBase_28_2_Jsonclick = "" ;
      edtLSD1numeroLiquidacion_23_5_Jsonclick = "" ;
      edtLSD1tipoLiquidacion_22_1_Jsonclick = "" ;
      edtLSD1periodoLiquidacion_16_6_Jsonclick = "" ;
      edtLSD1IdentificacionEnvio_14_2_Jsonclick = "" ;
      edtLSD1CuitEmpl_3_11_Jsonclick = "" ;
      edtavRegtipo_Jsonclick = "" ;
      edtavRegtipo_Enabled = 1 ;
      edtLSDSec_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      edtavEstadolsddep_Jsonclick = "" ;
      edtavEstadolsddep_Enabled = 1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtLSD1cantidadRegistrosTipo04_30_Visible = -1 ;
      edtLSD1diasBase_28_2_Visible = -1 ;
      edtLSD1numeroLiquidacion_23_5_Visible = -1 ;
      edtLSD1tipoLiquidacion_22_1_Visible = -1 ;
      edtLSD1periodoLiquidacion_16_6_Visible = -1 ;
      edtLSD1IdentificacionEnvio_14_2_Visible = -1 ;
      edtLSD1CuitEmpl_3_11_Visible = -1 ;
      edtavRegtipo_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      edtavParmnroliq_Jsonclick = "" ;
      edtavParmnroliq_Visible = 1 ;
      edtavParmperiodo_Jsonclick = "" ;
      edtavParmperiodo_Visible = 1 ;
      bttBtndescargar_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|11.0||6.0||5.0|2.0|6.0" ;
      Ddo_grid_Datalistproc = "LSD_reg1WWGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "||T||T|||" ;
      Ddo_grid_Datalisttype = "||Dynamic||Dynamic|||" ;
      Ddo_grid_Includedatalist = "||T||T|||" ;
      Ddo_grid_Filterisrange = "|T||T||T|T|T" ;
      Ddo_grid_Filtertype = "|Numeric|Character|Numeric|Character|Numeric|Numeric|Numeric" ;
      Ddo_grid_Includefilter = "|T|T|T|T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|2|3|4|5|6|7|8" ;
      Ddo_grid_Columnids = "3:RegTipo|4:LSD1CuitEmpl_3_11|5:LSD1IdentificacionEnvio_14_2|6:LSD1periodoLiquidacion_16_6|7:LSD1tipoLiquidacion_22_1|8:LSD1numeroLiquidacion_23_5|9:LSD1diasBase_28_2|10:LSD1cantidadRegistrosTipo04_30_6" ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV97Lsd_reg1wwds_1_clicod',fld:'vLSD_REG1WWDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV98Lsd_reg1wwds_2_empcod',fld:'vLSD_REG1WWDS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV56date',fld:'vDATE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavRegtipo_Visible',ctrl:'vREGTIPO',prop:'Visible'},{av:'edtLSD1CuitEmpl_3_11_Visible',ctrl:'LSD1CUITEMPL_3_11',prop:'Visible'},{av:'edtLSD1IdentificacionEnvio_14_2_Visible',ctrl:'LSD1IDENTIFICACIONENVIO_14_2',prop:'Visible'},{av:'edtLSD1periodoLiquidacion_16_6_Visible',ctrl:'LSD1PERIODOLIQUIDACION_16_6',prop:'Visible'},{av:'edtLSD1tipoLiquidacion_22_1_Visible',ctrl:'LSD1TIPOLIQUIDACION_22_1',prop:'Visible'},{av:'edtLSD1numeroLiquidacion_23_5_Visible',ctrl:'LSD1NUMEROLIQUIDACION_23_5',prop:'Visible'},{av:'edtLSD1diasBase_28_2_Visible',ctrl:'LSD1DIASBASE_28_2',prop:'Visible'},{av:'edtLSD1cantidadRegistrosTipo04_30_Visible',ctrl:'LSD1CANTIDADREGISTROSTIPO04_30',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNDESCARGAR',prop:'Visible'},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV74ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13HE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV97Lsd_reg1wwds_1_clicod',fld:'vLSD_REG1WWDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV98Lsd_reg1wwds_2_empcod',fld:'vLSD_REG1WWDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV56date',fld:'vDATE',pic:'',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14HE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV97Lsd_reg1wwds_1_clicod',fld:'vLSD_REG1WWDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV98Lsd_reg1wwds_2_empcod',fld:'vLSD_REG1WWDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV56date',fld:'vDATE',pic:'',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15HE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV97Lsd_reg1wwds_1_clicod',fld:'vLSD_REG1WWDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV98Lsd_reg1wwds_2_empcod',fld:'vLSD_REG1WWDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV56date',fld:'vDATE',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV32TFLSD1tipoLiquidacion_22_1_SelsJson',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELSJSON',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV27TFLSD1IdentificacionEnvio_14_2_SelsJson',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELSJSON',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21HE2',iparms:[{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV46Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV48Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtavDelete_Class',ctrl:'vDELETE',prop:'Class'},{av:'AV62Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV52download',fld:'vDOWNLOAD',pic:''},{av:'edtavDownload_Class',ctrl:'vDOWNLOAD',prop:'Class'},{av:'AV58RegTipo',fld:'vREGTIPO',pic:''},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV59VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV60ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV61EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11HE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV97Lsd_reg1wwds_1_clicod',fld:'vLSD_REG1WWDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV98Lsd_reg1wwds_2_empcod',fld:'vLSD_REG1WWDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV56date',fld:'vDATE',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtavRegtipo_Visible',ctrl:'vREGTIPO',prop:'Visible'},{av:'edtLSD1CuitEmpl_3_11_Visible',ctrl:'LSD1CUITEMPL_3_11',prop:'Visible'},{av:'edtLSD1IdentificacionEnvio_14_2_Visible',ctrl:'LSD1IDENTIFICACIONENVIO_14_2',prop:'Visible'},{av:'edtLSD1periodoLiquidacion_16_6_Visible',ctrl:'LSD1PERIODOLIQUIDACION_16_6',prop:'Visible'},{av:'edtLSD1tipoLiquidacion_22_1_Visible',ctrl:'LSD1TIPOLIQUIDACION_22_1',prop:'Visible'},{av:'edtLSD1numeroLiquidacion_23_5_Visible',ctrl:'LSD1NUMEROLIQUIDACION_23_5',prop:'Visible'},{av:'edtLSD1diasBase_28_2_Visible',ctrl:'LSD1DIASBASE_28_2',prop:'Visible'},{av:'edtLSD1cantidadRegistrosTipo04_30_Visible',ctrl:'LSD1CANTIDADREGISTROSTIPO04_30',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNDESCARGAR',prop:'Visible'},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV74ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12HE2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''},{av:'AV11parmNroLiq',fld:'vPARMNROLIQ',pic:'ZZZZZZZ9'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63MenuOpcCod',fld:'vMENUOPCCOD',pic:''},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV97Lsd_reg1wwds_1_clicod',fld:'vLSD_REG1WWDS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV98Lsd_reg1wwds_2_empcod',fld:'vLSD_REG1WWDS_2_EMPCOD',pic:'ZZZ9'},{av:'AV56date',fld:'vDATE',pic:'',hsh:true},{av:'sPrefix'},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV27TFLSD1IdentificacionEnvio_14_2_SelsJson',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELSJSON',pic:''},{av:'AV32TFLSD1tipoLiquidacion_22_1_SelsJson',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV15GridState',fld:'vGRIDSTATE',pic:''},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV25TFLSD1CuitEmpl_3_11',fld:'vTFLSD1CUITEMPL_3_11',pic:'ZZZZZZZZZZ9'},{av:'AV26TFLSD1CuitEmpl_3_11_To',fld:'vTFLSD1CUITEMPL_3_11_TO',pic:'ZZZZZZZZZZ9'},{av:'AV28TFLSD1IdentificacionEnvio_14_2',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2',pic:''},{av:'AV29TFLSD1IdentificacionEnvio_14_2_Sels',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELS',pic:''},{av:'AV30TFLSD1periodoLiquidacion_16_6',fld:'vTFLSD1PERIODOLIQUIDACION_16_6',pic:'ZZZZZ9'},{av:'AV31TFLSD1periodoLiquidacion_16_6_To',fld:'vTFLSD1PERIODOLIQUIDACION_16_6_TO',pic:'ZZZZZ9'},{av:'AV33TFLSD1tipoLiquidacion_22_1',fld:'vTFLSD1TIPOLIQUIDACION_22_1',pic:''},{av:'AV34TFLSD1tipoLiquidacion_22_1_Sels',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELS',pic:''},{av:'AV35TFLSD1numeroLiquidacion_23_5',fld:'vTFLSD1NUMEROLIQUIDACION_23_5',pic:'ZZZZ9'},{av:'AV36TFLSD1numeroLiquidacion_23_5_To',fld:'vTFLSD1NUMEROLIQUIDACION_23_5_TO',pic:'ZZZZ9'},{av:'AV37TFLSD1diasBase_28_2',fld:'vTFLSD1DIASBASE_28_2',pic:'Z9'},{av:'AV38TFLSD1diasBase_28_2_To',fld:'vTFLSD1DIASBASE_28_2_TO',pic:'Z9'},{av:'AV39TFLSD1cantidadRegistrosTipo04_30_6',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6',pic:'ZZZZZ9'},{av:'AV40TFLSD1cantidadRegistrosTipo04_30_6_To',fld:'vTFLSD1CANTIDADREGISTROSTIPO04_30_6_TO',pic:'ZZZZZ9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV32TFLSD1tipoLiquidacion_22_1_SelsJson',fld:'vTFLSD1TIPOLIQUIDACION_22_1_SELSJSON',pic:''},{av:'AV27TFLSD1IdentificacionEnvio_14_2_SelsJson',fld:'vTFLSD1IDENTIFICACIONENVIO_14_2_SELSJSON',pic:''},{av:'AV22ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavRegtipo_Visible',ctrl:'vREGTIPO',prop:'Visible'},{av:'edtLSD1CuitEmpl_3_11_Visible',ctrl:'LSD1CUITEMPL_3_11',prop:'Visible'},{av:'edtLSD1IdentificacionEnvio_14_2_Visible',ctrl:'LSD1IDENTIFICACIONENVIO_14_2',prop:'Visible'},{av:'edtLSD1periodoLiquidacion_16_6_Visible',ctrl:'LSD1PERIODOLIQUIDACION_16_6',prop:'Visible'},{av:'edtLSD1tipoLiquidacion_22_1_Visible',ctrl:'LSD1TIPOLIQUIDACION_22_1',prop:'Visible'},{av:'edtLSD1numeroLiquidacion_23_5_Visible',ctrl:'LSD1NUMEROLIQUIDACION_23_5',prop:'Visible'},{av:'edtLSD1diasBase_28_2_Visible',ctrl:'LSD1DIASBASE_28_2',prop:'Visible'},{av:'edtLSD1cantidadRegistrosTipo04_30_Visible',ctrl:'LSD1CANTIDADREGISTROSTIPO04_30',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV44GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{ctrl:'BTNDESCARGAR',prop:'Visible'},{av:'AV47IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV49IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV74ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DODESCARGAR'","{handler:'e16HE2',iparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10parmPeriodo',fld:'vPARMPERIODO',pic:''}]");
      setEventMetadata("'DODESCARGAR'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17HE2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VDOWNLOAD.CLICK","{handler:'e22HE2',iparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV56date',fld:'vDATE',pic:'',hsh:true}]");
      setEventMetadata("VDOWNLOAD.CLICK",",oparms:[]}");
      setEventMetadata("GLOBALEVENTS.MENSAJELIQUIDACION","{handler:'e18HE2',iparms:[{av:'AV87mensajeTexto',fld:'vMENSAJETEXTO',pic:''},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV96Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GLOBALEVENTS.MENSAJELIQUIDACION",",oparms:[{av:'AV86EstadoLSDDep',fld:'vESTADOLSDDEP',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Download',iparms:[]");
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
      wcpOAV63MenuOpcCod = "" ;
      wcpOAV10parmPeriodo = GXutil.nullDate() ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV63MenuOpcCod = "" ;
      AV10parmPeriodo = GXutil.nullDate() ;
      AV22ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV96Pgmname = "" ;
      AV15GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28TFLSD1IdentificacionEnvio_14_2 = "" ;
      AV29TFLSD1IdentificacionEnvio_14_2_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33TFLSD1tipoLiquidacion_22_1 = "" ;
      AV34TFLSD1tipoLiquidacion_22_1_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56date = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV41DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV74ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV45GridAppliedFilters = "" ;
      AV27TFLSD1IdentificacionEnvio_14_2_SelsJson = "" ;
      AV32TFLSD1tipoLiquidacion_22_1_SelsJson = "" ;
      AV87mensajeTexto = "" ;
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
      bttBtndescargar_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV58RegTipo = "" ;
      A1651LSD1IdentificacionEnvio_14_2 = "" ;
      A1653LSD1tipoLiquidacion_22_1 = "" ;
      A1734LSD1LiqPeriodo = GXutil.nullDate() ;
      AV46Update = "" ;
      AV48Delete = "" ;
      AV62Display = "" ;
      AV59VerSVG = "" ;
      AV60ModificarSVG = "" ;
      AV61EliminarSVG = "" ;
      AV52download = "" ;
      AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = "" ;
      lV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = "" ;
      AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = "" ;
      AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = "" ;
      H00HE2_A1734LSD1LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      H00HE2_A1733LSD1LiqNro = new int[1] ;
      H00HE2_A1656LSD1cantidadRegistrosTipo04_30 = new int[1] ;
      H00HE2_A1655LSD1diasBase_28_2 = new byte[1] ;
      H00HE2_A1654LSD1numeroLiquidacion_23_5 = new int[1] ;
      H00HE2_A1653LSD1tipoLiquidacion_22_1 = new String[] {""} ;
      H00HE2_A1652LSD1periodoLiquidacion_16_6 = new int[1] ;
      H00HE2_A1651LSD1IdentificacionEnvio_14_2 = new String[] {""} ;
      H00HE2_A1650LSD1CuitEmpl_3_11 = new long[1] ;
      H00HE2_A1649LSDSec = new int[1] ;
      H00HE2_A1EmpCod = new short[1] ;
      H00HE2_A3CliCod = new int[1] ;
      H00HE3_AGRID_nRecordCount = new long[1] ;
      AV86EstadoLSDDep = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV85observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV57error = "" ;
      GXv_int4 = new int[1] ;
      GXv_int5 = new byte[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext6 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV20ColumnsSelectorXML = "" ;
      AV81MenuOpcTitulo = "" ;
      GXv_int8 = new short[1] ;
      AV84filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV75ManageFiltersXml = "" ;
      AV53archivoAbsolute = "" ;
      AV54NombreArchivo = "" ;
      AV72ExcelFilename = "" ;
      AV73ErrorMessage = "" ;
      AV21UserCustomValue = "" ;
      AV23ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector10 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector11 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_boolean13 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15 = new GXBaseCollection[1] ;
      AV16GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char16 = "" ;
      GXt_char7 = "" ;
      GXv_SdtWWPGridState17 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12HTTPRequest = httpContext.getHttpRequest();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXv_char9 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV88mensajesNotificacion = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90msgNotiEstado = "" ;
      AV91msgNotiPgm = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV63MenuOpcCod = "" ;
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV10parmPeriodo = "" ;
      sCtrlAV11parmNroLiq = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg1ww__default(),
         new Object[] {
             new Object[] {
            H00HE2_A1734LSD1LiqPeriodo, H00HE2_A1733LSD1LiqNro, H00HE2_A1656LSD1cantidadRegistrosTipo04_30, H00HE2_A1655LSD1diasBase_28_2, H00HE2_A1654LSD1numeroLiquidacion_23_5, H00HE2_A1653LSD1tipoLiquidacion_22_1, H00HE2_A1652LSD1periodoLiquidacion_16_6, H00HE2_A1651LSD1IdentificacionEnvio_14_2, H00HE2_A1650LSD1CuitEmpl_3_11, H00HE2_A1649LSDSec,
            H00HE2_A1EmpCod, H00HE2_A3CliCod
            }
            , new Object[] {
            H00HE3_AGRID_nRecordCount
            }
         }
      );
      AV96Pgmname = "LSD_reg1WW" ;
      /* GeneXus formulas. */
      AV96Pgmname = "LSD_reg1WW" ;
      Gx_err = (short)(0) ;
      edtavEstadolsddep_Enabled = 0 ;
      edtavRegtipo_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavDownload_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV76ManageFiltersExecutionStep ;
   private byte AV37TFLSD1diasBase_28_2 ;
   private byte AV38TFLSD1diasBase_28_2_To ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A1655LSD1diasBase_28_2 ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 ;
   private byte AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ;
   private byte AV89LiquidacionEstado ;
   private byte GXv_int5[] ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wcpOAV9EmpCod ;
   private short AV9EmpCod ;
   private short AV17OrderedBy ;
   private short AV98Lsd_reg1wwds_2_empcod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int8[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int wcpOAV8CliCod ;
   private int wcpOAV11parmNroLiq ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_75 ;
   private int AV8CliCod ;
   private int AV11parmNroLiq ;
   private int nGXsfl_75_idx=1 ;
   private int AV30TFLSD1periodoLiquidacion_16_6 ;
   private int AV31TFLSD1periodoLiquidacion_16_6_To ;
   private int AV35TFLSD1numeroLiquidacion_23_5 ;
   private int AV36TFLSD1numeroLiquidacion_23_5_To ;
   private int AV39TFLSD1cantidadRegistrosTipo04_30_6 ;
   private int AV40TFLSD1cantidadRegistrosTipo04_30_6_To ;
   private int AV97Lsd_reg1wwds_1_clicod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtndescargar_Visible ;
   private int edtavParmperiodo_Visible ;
   private int edtavParmnroliq_Visible ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1652LSD1periodoLiquidacion_16_6 ;
   private int A1654LSD1numeroLiquidacion_23_5 ;
   private int A1656LSD1cantidadRegistrosTipo04_30 ;
   private int A1733LSD1LiqNro ;
   private int subGrid_Islastpage ;
   private int edtavEstadolsddep_Enabled ;
   private int edtavRegtipo_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int edtavDownload_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ;
   private int AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ;
   private int AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ;
   private int AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ;
   private int AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ;
   private int AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ;
   private int AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ;
   private int AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXv_int4[] ;
   private int edtavRegtipo_Visible ;
   private int edtLSD1CuitEmpl_3_11_Visible ;
   private int edtLSD1IdentificacionEnvio_14_2_Visible ;
   private int edtLSD1periodoLiquidacion_16_6_Visible ;
   private int edtLSD1tipoLiquidacion_22_1_Visible ;
   private int edtLSD1numeroLiquidacion_23_5_Visible ;
   private int edtLSD1diasBase_28_2_Visible ;
   private int edtLSD1cantidadRegistrosTipo04_30_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV83filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV42PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int AV113GXV1 ;
   private int AV92msgNotiLiqNro ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavEliminarsvg_Visible ;
   private int edtavDownload_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV25TFLSD1CuitEmpl_3_11 ;
   private long AV26TFLSD1CuitEmpl_3_11_To ;
   private long AV43GridCurrentPage ;
   private long AV44GridPageCount ;
   private long A1650LSD1CuitEmpl_3_11 ;
   private long GRID_nCurrentRecord ;
   private long AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ;
   private long AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_75_idx="0001" ;
   private String AV96Pgmname ;
   private String AV28TFLSD1IdentificacionEnvio_14_2 ;
   private String AV33TFLSD1tipoLiquidacion_22_1 ;
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
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Format ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String bttBtndescargar_Internalname ;
   private String bttBtndescargar_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtavParmperiodo_Internalname ;
   private String edtavParmperiodo_Jsonclick ;
   private String edtavParmnroliq_Internalname ;
   private String edtavParmnroliq_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavRegtipo_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLSDSec_Internalname ;
   private String AV58RegTipo ;
   private String edtLSD1CuitEmpl_3_11_Internalname ;
   private String A1651LSD1IdentificacionEnvio_14_2 ;
   private String edtLSD1IdentificacionEnvio_14_2_Internalname ;
   private String edtLSD1periodoLiquidacion_16_6_Internalname ;
   private String A1653LSD1tipoLiquidacion_22_1 ;
   private String edtLSD1tipoLiquidacion_22_1_Internalname ;
   private String edtLSD1numeroLiquidacion_23_5_Internalname ;
   private String edtLSD1diasBase_28_2_Internalname ;
   private String edtLSD1cantidadRegistrosTipo04_30_Internalname ;
   private String edtLSD1LiqNro_Internalname ;
   private String edtLSD1LiqPeriodo_Internalname ;
   private String AV46Update ;
   private String edtavUpdate_Internalname ;
   private String AV48Delete ;
   private String edtavDelete_Internalname ;
   private String AV62Display ;
   private String edtavDisplay_Internalname ;
   private String AV59VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV60ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV61EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String AV52download ;
   private String edtavDownload_Internalname ;
   private String edtavEstadolsddep_Internalname ;
   private String scmdbuf ;
   private String lV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ;
   private String lV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ;
   private String AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ;
   private String AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ;
   private String AV86EstadoLSDDep ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String AV85observerPalabra ;
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
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDelete_Class ;
   private String edtavDisplay_Link ;
   private String edtavDownload_Class ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String GXt_char16 ;
   private String GXt_char7 ;
   private String GXv_char9[] ;
   private String GXv_char3[] ;
   private String AV90msgNotiEstado ;
   private String AV91msgNotiPgm ;
   private String tblTablemainfix_Internalname ;
   private String tblTablepadding_Internalname ;
   private String divTablefiltrospadre_Internalname ;
   private String edtavEstadolsddep_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
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
   private String sCtrlAV63MenuOpcCod ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV10parmPeriodo ;
   private String sCtrlAV11parmNroLiq ;
   private String sGXsfl_75_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLSDSec_Jsonclick ;
   private String edtavRegtipo_Jsonclick ;
   private String edtLSD1CuitEmpl_3_11_Jsonclick ;
   private String edtLSD1IdentificacionEnvio_14_2_Jsonclick ;
   private String edtLSD1periodoLiquidacion_16_6_Jsonclick ;
   private String edtLSD1tipoLiquidacion_22_1_Jsonclick ;
   private String edtLSD1numeroLiquidacion_23_5_Jsonclick ;
   private String edtLSD1diasBase_28_2_Jsonclick ;
   private String edtLSD1cantidadRegistrosTipo04_30_Jsonclick ;
   private String edtLSD1LiqNro_Jsonclick ;
   private String edtLSD1LiqPeriodo_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String edtavDownload_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date wcpOAV10parmPeriodo ;
   private java.util.Date AV10parmPeriodo ;
   private java.util.Date AV56date ;
   private java.util.Date A1734LSD1LiqPeriodo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV18OrderedDsc ;
   private boolean AV47IsAuthorized_Update ;
   private boolean AV49IsAuthorized_Delete ;
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
   private boolean bGXsfl_75_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean12 ;
   private boolean GXv_boolean13[] ;
   private String AV27TFLSD1IdentificacionEnvio_14_2_SelsJson ;
   private String AV32TFLSD1tipoLiquidacion_22_1_SelsJson ;
   private String AV20ColumnsSelectorXML ;
   private String AV75ManageFiltersXml ;
   private String AV21UserCustomValue ;
   private String wcpOAV63MenuOpcCod ;
   private String AV63MenuOpcCod ;
   private String AV45GridAppliedFilters ;
   private String AV87mensajeTexto ;
   private String AV57error ;
   private String AV81MenuOpcTitulo ;
   private String AV84filtrosTexto ;
   private String AV53archivoAbsolute ;
   private String AV54NombreArchivo ;
   private String AV72ExcelFilename ;
   private String AV73ErrorMessage ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV12HTTPRequest ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ;
   private GXSimpleCollection<String> AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] H00HE2_A1734LSD1LiqPeriodo ;
   private int[] H00HE2_A1733LSD1LiqNro ;
   private int[] H00HE2_A1656LSD1cantidadRegistrosTipo04_30 ;
   private byte[] H00HE2_A1655LSD1diasBase_28_2 ;
   private int[] H00HE2_A1654LSD1numeroLiquidacion_23_5 ;
   private String[] H00HE2_A1653LSD1tipoLiquidacion_22_1 ;
   private int[] H00HE2_A1652LSD1periodoLiquidacion_16_6 ;
   private String[] H00HE2_A1651LSD1IdentificacionEnvio_14_2 ;
   private long[] H00HE2_A1650LSD1CuitEmpl_3_11 ;
   private int[] H00HE2_A1649LSDSec ;
   private short[] H00HE2_A1EmpCod ;
   private int[] H00HE2_A3CliCod ;
   private long[] H00HE3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV29TFLSD1IdentificacionEnvio_14_2_Sels ;
   private GXSimpleCollection<String> AV34TFLSD1tipoLiquidacion_22_1_Sels ;
   private GXSimpleCollection<String> AV88mensajesNotificacion ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV74ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item14 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item15[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV23ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector10[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector11[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV41DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV15GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState17[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV16GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext6[] ;
}

final  class lsd_reg1ww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00HE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1651LSD1IdentificacionEnvio_14_2 ,
                                          GXSimpleCollection<String> AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                          String A1653LSD1tipoLiquidacion_22_1 ,
                                          GXSimpleCollection<String> AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                          long AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ,
                                          long AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ,
                                          int AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ,
                                          String AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                          int AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ,
                                          int AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ,
                                          int AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ,
                                          String AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                          int AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ,
                                          int AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ,
                                          byte AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 ,
                                          byte AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ,
                                          int AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ,
                                          int AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ,
                                          int AV11parmNroLiq ,
                                          java.util.Date AV10parmPeriodo ,
                                          long A1650LSD1CuitEmpl_3_11 ,
                                          int A1652LSD1periodoLiquidacion_16_6 ,
                                          int A1654LSD1numeroLiquidacion_23_5 ,
                                          byte A1655LSD1diasBase_28_2 ,
                                          int A1656LSD1cantidadRegistrosTipo04_30 ,
                                          int A1733LSD1LiqNro ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV97Lsd_reg1wwds_1_clicod ,
                                          short AV98Lsd_reg1wwds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[19];
      Object[] GXv_Object19 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " LSD1LiqPeriodo, LSD1LiqNro, LSD1cantidadRegistrosTipo04_30, LSD1diasBase_28_2, LSD1numeroLiquidacion_23_5, LSD1tipoLiquidacion_22_1, LSD1periodoLiquidacion_16_6," ;
      sSelectString += " LSD1IdentificacionEnvio_14_2, LSD1CuitEmpl_3_11, LSDSec, EmpCod, CliCod" ;
      sFromString = " FROM LSD_reg1" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 >= ?)");
      }
      else
      {
         GXv_int18[2] = (byte)(1) ;
      }
      if ( ! (0==AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 <= ?)");
      }
      else
      {
         GXv_int18[3] = (byte)(1) ;
      }
      if ( ( AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1IdentificacionEnvio_14_2) like LOWER(?))");
      }
      else
      {
         GXv_int18[4] = (byte)(1) ;
      }
      if ( AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels, "LSD1IdentificacionEnvio_14_2 IN (", ")")+")");
      }
      if ( ! (0==AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 >= ?)");
      }
      else
      {
         GXv_int18[5] = (byte)(1) ;
      }
      if ( ! (0==AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 <= ?)");
      }
      else
      {
         GXv_int18[6] = (byte)(1) ;
      }
      if ( ( AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1tipoLiquidacion_22_1) like LOWER(?))");
      }
      else
      {
         GXv_int18[7] = (byte)(1) ;
      }
      if ( AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels, "LSD1tipoLiquidacion_22_1 IN (", ")")+")");
      }
      if ( ! (0==AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 >= ?)");
      }
      else
      {
         GXv_int18[8] = (byte)(1) ;
      }
      if ( ! (0==AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 <= ?)");
      }
      else
      {
         GXv_int18[9] = (byte)(1) ;
      }
      if ( ! (0==AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 >= ?)");
      }
      else
      {
         GXv_int18[10] = (byte)(1) ;
      }
      if ( ! (0==AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 <= ?)");
      }
      else
      {
         GXv_int18[11] = (byte)(1) ;
      }
      if ( ! (0==AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 >= ?)");
      }
      else
      {
         GXv_int18[12] = (byte)(1) ;
      }
      if ( ! (0==AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 <= ?)");
      }
      else
      {
         GXv_int18[13] = (byte)(1) ;
      }
      if ( ! (0==AV11parmNroLiq) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int18[14] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10parmPeriodo)) )
      {
         addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      }
      else
      {
         GXv_int18[15] = (byte)(1) ;
      }
      if ( AV17OrderedBy == 1 )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1CuitEmpl_3_11, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1CuitEmpl_3_11 DESC, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1IdentificacionEnvio_14_2, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1IdentificacionEnvio_14_2 DESC, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1periodoLiquidacion_16_6, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1periodoLiquidacion_16_6 DESC, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1tipoLiquidacion_22_1, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1tipoLiquidacion_22_1 DESC, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1numeroLiquidacion_23_5, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1numeroLiquidacion_23_5 DESC, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1diasBase_28_2, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1diasBase_28_2 DESC, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSD1cantidadRegistrosTipo04_30, LSDSec" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSD1cantidadRegistrosTipo04_30 DESC, LSDSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   protected Object[] conditional_H00HE3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1651LSD1IdentificacionEnvio_14_2 ,
                                          GXSimpleCollection<String> AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                          String A1653LSD1tipoLiquidacion_22_1 ,
                                          GXSimpleCollection<String> AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                          long AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ,
                                          long AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ,
                                          int AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ,
                                          String AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                          int AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ,
                                          int AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ,
                                          int AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ,
                                          String AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                          int AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ,
                                          int AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ,
                                          byte AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2 ,
                                          byte AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ,
                                          int AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ,
                                          int AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ,
                                          int AV11parmNroLiq ,
                                          java.util.Date AV10parmPeriodo ,
                                          long A1650LSD1CuitEmpl_3_11 ,
                                          int A1652LSD1periodoLiquidacion_16_6 ,
                                          int A1654LSD1numeroLiquidacion_23_5 ,
                                          byte A1655LSD1diasBase_28_2 ,
                                          int A1656LSD1cantidadRegistrosTipo04_30 ,
                                          int A1733LSD1LiqNro ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV97Lsd_reg1wwds_1_clicod ,
                                          short AV98Lsd_reg1wwds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[16];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV99Lsd_reg1wwds_3_tflsd1cuitempl_3_11) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 >= ?)");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      if ( ! (0==AV100Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 <= ?)");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( ( AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1IdentificacionEnvio_14_2) like LOWER(?))");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels, "LSD1IdentificacionEnvio_14_2 IN (", ")")+")");
      }
      if ( ! (0==AV103Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 >= ?)");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( ! (0==AV104Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 <= ?)");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( ( AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV105Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1tipoLiquidacion_22_1) like LOWER(?))");
      }
      else
      {
         GXv_int21[7] = (byte)(1) ;
      }
      if ( AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV106Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels, "LSD1tipoLiquidacion_22_1 IN (", ")")+")");
      }
      if ( ! (0==AV107Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 >= ?)");
      }
      else
      {
         GXv_int21[8] = (byte)(1) ;
      }
      if ( ! (0==AV108Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 <= ?)");
      }
      else
      {
         GXv_int21[9] = (byte)(1) ;
      }
      if ( ! (0==AV109Lsd_reg1wwds_13_tflsd1diasbase_28_2) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 >= ?)");
      }
      else
      {
         GXv_int21[10] = (byte)(1) ;
      }
      if ( ! (0==AV110Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 <= ?)");
      }
      else
      {
         GXv_int21[11] = (byte)(1) ;
      }
      if ( ! (0==AV111Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 >= ?)");
      }
      else
      {
         GXv_int21[12] = (byte)(1) ;
      }
      if ( ! (0==AV112Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 <= ?)");
      }
      else
      {
         GXv_int21[13] = (byte)(1) ;
      }
      if ( ! (0==AV11parmNroLiq) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int21[14] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10parmPeriodo)) )
      {
         addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      }
      else
      {
         GXv_int21[15] = (byte)(1) ;
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
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
                  return conditional_H00HE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() );
            case 1 :
                  return conditional_H00HE3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Boolean) dynConstraints[28]).booleanValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00HE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00HE3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
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
                  stmt.setLong(sIdx, ((Number) parms[21]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[22]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[26], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[30]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[32]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[34]);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[36]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[37]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[18]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[19]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               return;
      }
   }

}

