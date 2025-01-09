package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg2lsd_reg4wc_impl extends GXWebComponent
{
   public lsd_reg2lsd_reg4wc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg2lsd_reg4wc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg2lsd_reg4wc_impl.class ));
   }

   public lsd_reg2lsd_reg4wc_impl( int remoteHandle ,
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
               AV10LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LSDSec), 8, 0));
               AV11LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LSD2Sec), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10LSDSec),Integer.valueOf(AV11LSD2Sec)});
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
      nRC_GXsfl_26 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_26"))) ;
      nGXsfl_26_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_26_idx"))) ;
      sGXsfl_26_idx = httpContext.GetPar( "sGXsfl_26_idx") ;
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
      AV10LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
      AV11LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
      AV83Pgmname = httpContext.GetPar( "Pgmname") ;
      AV17OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV18OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV31TFLSD4CodigoObraSocial_63_6 = httpContext.GetPar( "TFLSD4CodigoObraSocial_63_6") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32TFLSD4CodigoObraSocial_63_6_Sels);
      AV33TFLSD4CantidadAdherentes_69_2 = (byte)(GXutil.lval( httpContext.GetPar( "TFLSD4CantidadAdherentes_69_2"))) ;
      AV34TFLSD4CantidadAdherentes_69_2_To = (byte)(GXutil.lval( httpContext.GetPar( "TFLSD4CantidadAdherentes_69_2_To"))) ;
      AV35TFLSD4AporteAdicionalOS_71_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4AporteAdicionalOS_71_15"), ".") ;
      AV36TFLSD4AporteAdicionalOS_71_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4AporteAdicionalOS_71_15_To"), ".") ;
      AV37TFLSD4ContribucionAdicionalOS_86_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4ContribucionAdicionalOS_86_15"), ".") ;
      AV38TFLSD4ContribucionAdicionalOS_86_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4ContribucionAdicionalOS_86_15_To"), ".") ;
      AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15"), ".") ;
      AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To"), ".") ;
      AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseCalculoDiferencialOSyFSR_116_15"), ".") ;
      AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To"), ".") ;
      AV43TFLSD4BaseCalculoDiferencialLRT_131_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseCalculoDiferencialLRT_131_15"), ".") ;
      AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseCalculoDiferencialLRT_131_15_To"), ".") ;
      AV45TFLSD4RemuneracionMaternidadANSeS_146_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4RemuneracionMaternidadANSeS_146_15"), ".") ;
      AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4RemuneracionMaternidadANSeS_146_15_To"), ".") ;
      AV47TFLSD4RemuneracionBruta_161_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4RemuneracionBruta_161_15"), ".") ;
      AV48TFLSD4RemuneracionBruta_161_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4RemuneracionBruta_161_15_To"), ".") ;
      AV49TFLSD4BaseImponible1_176_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible1_176_15"), ".") ;
      AV50TFLSD4BaseImponible1_176_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible1_176_15_To"), ".") ;
      AV51TFLSD4BaseImponible2_191_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible2_191_15"), ".") ;
      AV52TFLSD4BaseImponible2_191_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible2_191_15_To"), ".") ;
      AV53TFLSD4BaseImponible3_206_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible3_206_15"), ".") ;
      AV54TFLSD4BaseImponible3_206_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible3_206_15_To"), ".") ;
      AV55TFLSD4BaseImponible4_221_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible4_221_15"), ".") ;
      AV56TFLSD4BaseImponible4_221_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible4_221_15_To"), ".") ;
      AV57TFLSD4BaseImponible5_236_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible5_236_15"), ".") ;
      AV58TFLSD4BaseImponible5_236_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible5_236_15_To"), ".") ;
      AV59TFLSD4BaseImponible6_251_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible6_251_15"), ".") ;
      AV60TFLSD4BaseImponible6_251_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible6_251_15_To"), ".") ;
      AV61TFLSD4BaseImponible7_266_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible7_266_15"), ".") ;
      AV62TFLSD4BaseImponible7_266_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible7_266_15_To"), ".") ;
      AV63TFLSD4BaseImponible8_281_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible8_281_15"), ".") ;
      AV64TFLSD4BaseImponible8_281_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible8_281_15_To"), ".") ;
      AV65TFLSD4BaseImponible9_296_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible9_296_15"), ".") ;
      AV66TFLSD4BaseImponible9_296_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible9_296_15_To"), ".") ;
      AV67TFLSD4BaseDifApoSegSoc_311_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseDifApoSegSoc_311_15"), ".") ;
      AV68TFLSD4BaseDifApoSegSoc_311_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseDifApoSegSoc_311_15_To"), ".") ;
      AV69TFLSD4BaseDifContSegSoc_326_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseDifContSegSoc_326_15"), ".") ;
      AV70TFLSD4BaseDifContSegSoc_326_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseDifContSegSoc_326_15_To"), ".") ;
      AV71TFLSD4BaseImponible10_341_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible10_341_15"), ".") ;
      AV72TFLSD4BaseImponible10_341_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4BaseImponible10_341_15_To"), ".") ;
      AV73TFLSD4ImporteADetraer_356_15 = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4ImporteADetraer_356_15"), ".") ;
      AV74TFLSD4ImporteADetraer_356_15_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLSD4ImporteADetraer_356_15_To"), ".") ;
      AV27IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV28IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
      A1657LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LSDSec, AV11LSD2Sec, AV83Pgmname, AV17OrderedBy, AV18OrderedDsc, AV31TFLSD4CodigoObraSocial_63_6, AV32TFLSD4CodigoObraSocial_63_6_Sels, AV33TFLSD4CantidadAdherentes_69_2, AV34TFLSD4CantidadAdherentes_69_2_To, AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, AV27IsAuthorized_Update, AV28IsAuthorized_Delete, A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paHP2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "LSD_reg2 LSD_reg4 WC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg2lsd_reg4wc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LSD2Sec,8,0))}, new String[] {"CliCod","EmpCod","LSDSec","LSD2Sec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV28IsAuthorized_Delete));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"LSD_reg2LSD_reg4WC");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
      forbiddenHiddens.add("LSDSec", localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9"));
      forbiddenHiddens.add("LSD2Sec", localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("lsd_reg2lsd_reg4wc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_26", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_26, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV23GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV24GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV25GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV20DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV20DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10LSDSec", GXutil.ltrim( localUtil.ntoc( wcpOAV10LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11LSD2Sec", GXutil.ltrim( localUtil.ntoc( wcpOAV11LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV83Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV17OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV18OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4CODIGOOBRASOCIAL_63_6", GXutil.rtrim( AV31TFLSD4CodigoObraSocial_63_6));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLSD4CODIGOOBRASOCIAL_63_6_SELS", AV32TFLSD4CodigoObraSocial_63_6_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLSD4CODIGOOBRASOCIAL_63_6_SELS", AV32TFLSD4CodigoObraSocial_63_6_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4CANTIDADADHERENTES_69_2", GXutil.ltrim( localUtil.ntoc( AV33TFLSD4CantidadAdherentes_69_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4CANTIDADADHERENTES_69_2_TO", GXutil.ltrim( localUtil.ntoc( AV34TFLSD4CantidadAdherentes_69_2_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4APORTEADICIONALOS_71_15", GXutil.ltrim( localUtil.ntoc( AV35TFLSD4AporteAdicionalOS_71_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4APORTEADICIONALOS_71_15_TO", GXutil.ltrim( localUtil.ntoc( AV36TFLSD4AporteAdicionalOS_71_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4CONTRIBUCIONADICIONALOS_86_15", GXutil.ltrim( localUtil.ntoc( AV37TFLSD4ContribucionAdicionalOS_86_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4CONTRIBUCIONADICIONALOS_86_15_TO", GXutil.ltrim( localUtil.ntoc( AV38TFLSD4ContribucionAdicionalOS_86_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15", GXutil.ltrim( localUtil.ntoc( AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15_TO", GXutil.ltrim( localUtil.ntoc( AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15", GXutil.ltrim( localUtil.ntoc( AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15_TO", GXutil.ltrim( localUtil.ntoc( AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASECALCULODIFERENCIALLRT_131_15", GXutil.ltrim( localUtil.ntoc( AV43TFLSD4BaseCalculoDiferencialLRT_131_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASECALCULODIFERENCIALLRT_131_15_TO", GXutil.ltrim( localUtil.ntoc( AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4REMUNERACIONMATERNIDADANSES_146_15", GXutil.ltrim( localUtil.ntoc( AV45TFLSD4RemuneracionMaternidadANSeS_146_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4REMUNERACIONMATERNIDADANSES_146_15_TO", GXutil.ltrim( localUtil.ntoc( AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4REMUNERACIONBRUTA_161_15", GXutil.ltrim( localUtil.ntoc( AV47TFLSD4RemuneracionBruta_161_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4REMUNERACIONBRUTA_161_15_TO", GXutil.ltrim( localUtil.ntoc( AV48TFLSD4RemuneracionBruta_161_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE1_176_15", GXutil.ltrim( localUtil.ntoc( AV49TFLSD4BaseImponible1_176_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE1_176_15_TO", GXutil.ltrim( localUtil.ntoc( AV50TFLSD4BaseImponible1_176_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE2_191_15", GXutil.ltrim( localUtil.ntoc( AV51TFLSD4BaseImponible2_191_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE2_191_15_TO", GXutil.ltrim( localUtil.ntoc( AV52TFLSD4BaseImponible2_191_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE3_206_15", GXutil.ltrim( localUtil.ntoc( AV53TFLSD4BaseImponible3_206_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE3_206_15_TO", GXutil.ltrim( localUtil.ntoc( AV54TFLSD4BaseImponible3_206_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE4_221_15", GXutil.ltrim( localUtil.ntoc( AV55TFLSD4BaseImponible4_221_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE4_221_15_TO", GXutil.ltrim( localUtil.ntoc( AV56TFLSD4BaseImponible4_221_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE5_236_15", GXutil.ltrim( localUtil.ntoc( AV57TFLSD4BaseImponible5_236_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE5_236_15_TO", GXutil.ltrim( localUtil.ntoc( AV58TFLSD4BaseImponible5_236_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE6_251_15", GXutil.ltrim( localUtil.ntoc( AV59TFLSD4BaseImponible6_251_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE6_251_15_TO", GXutil.ltrim( localUtil.ntoc( AV60TFLSD4BaseImponible6_251_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE7_266_15", GXutil.ltrim( localUtil.ntoc( AV61TFLSD4BaseImponible7_266_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE7_266_15_TO", GXutil.ltrim( localUtil.ntoc( AV62TFLSD4BaseImponible7_266_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE8_281_15", GXutil.ltrim( localUtil.ntoc( AV63TFLSD4BaseImponible8_281_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE8_281_15_TO", GXutil.ltrim( localUtil.ntoc( AV64TFLSD4BaseImponible8_281_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE9_296_15", GXutil.ltrim( localUtil.ntoc( AV65TFLSD4BaseImponible9_296_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE9_296_15_TO", GXutil.ltrim( localUtil.ntoc( AV66TFLSD4BaseImponible9_296_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEDIFAPOSEGSOC_311_15", GXutil.ltrim( localUtil.ntoc( AV67TFLSD4BaseDifApoSegSoc_311_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEDIFAPOSEGSOC_311_15_TO", GXutil.ltrim( localUtil.ntoc( AV68TFLSD4BaseDifApoSegSoc_311_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEDIFCONTSEGSOC_326_15", GXutil.ltrim( localUtil.ntoc( AV69TFLSD4BaseDifContSegSoc_326_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEDIFCONTSEGSOC_326_15_TO", GXutil.ltrim( localUtil.ntoc( AV70TFLSD4BaseDifContSegSoc_326_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE10_341_15", GXutil.ltrim( localUtil.ntoc( AV71TFLSD4BaseImponible10_341_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4BASEIMPONIBLE10_341_15_TO", GXutil.ltrim( localUtil.ntoc( AV72TFLSD4BaseImponible10_341_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4IMPORTEADETRAER_356_15", GXutil.ltrim( localUtil.ntoc( AV73TFLSD4ImporteADetraer_356_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLSD4IMPORTEADETRAER_356_15_TO", GXutil.ltrim( localUtil.ntoc( AV74TFLSD4ImporteADetraer_356_15_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLSDSEC", GXutil.ltrim( localUtil.ntoc( AV10LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLSD2SEC", GXutil.ltrim( localUtil.ntoc( AV11LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV27IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV28IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV28IsAuthorized_Delete));
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

   public void renderHtmlCloseFormHP2( )
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
      return "LSD_reg2LSD_reg4WC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "LSD_reg2 LSD_reg4 WC", "") ;
   }

   public void wbHP0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.lsd_reg2lsd_reg4wc");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 26, 2, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOINSERT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg2LSD_reg4WC.htm");
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
         startgridcontrol26( ) ;
      }
      if ( wbEnd == 26 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_26 = (int)(nGXsfl_26_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV23GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV24GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV25GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV20DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2LSD_reg4WC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LSD_reg2LSD_reg4WC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSDSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSDSec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSDSec_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2LSD_reg4WC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2Sec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSD2Sec_Visible, 0, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2LSD_reg4WC.htm");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 26 )
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

   public void startHP2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "LSD_reg2 LSD_reg4 WC", ""), (short)(0)) ;
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
            strupHP0( ) ;
         }
      }
   }

   public void wsHP2( )
   {
      startHP2( ) ;
      evtHP2( ) ;
   }

   public void evtHP2( )
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
                              strupHP0( ) ;
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
                              strupHP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11HP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12HP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13HP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoInsert' */
                                 e14HP2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupHP0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
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
                              strupHP0( ) ;
                           }
                           nGXsfl_26_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_262( ) ;
                           A1674LSD4Sec = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD4Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1675LSD4CUIL_3_11 = localUtil.ctol( httpContext.cgiGet( edtLSD4CUIL_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A1676LSD4Conyuge_14_1 = httpContext.cgiGet( edtLSD4Conyuge_14_1_Internalname) ;
                           A1677LSD4CantidadHijos_15_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadHijos_15_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1678LSD4MarcaCCT_17_1 = httpContext.cgiGet( edtLSD4MarcaCCT_17_1_Internalname) ;
                           A1679LSD4MarcaSCVO_18_1 = httpContext.cgiGet( edtLSD4MarcaSCVO_18_1_Internalname) ;
                           A1680LSD4MarcaReduccion_19_1 = httpContext.cgiGet( edtLSD4MarcaReduccion_19_1_Internalname) ;
                           A1681LSD4TipoEmpresa_20_1 = httpContext.cgiGet( edtLSD4TipoEmpresa_20_1_Internalname) ;
                           A1682LSD4TipoOperacion_21_1 = httpContext.cgiGet( edtLSD4TipoOperacion_21_1_Internalname) ;
                           A1683LSD4CodigoSituacion_22_2 = httpContext.cgiGet( edtLSD4CodigoSituacion_22_2_Internalname) ;
                           A1684LSD4CodigoCondicion_24_2 = httpContext.cgiGet( edtLSD4CodigoCondicion_24_2_Internalname) ;
                           A1685LSD4CodigoActividad_26_3 = httpContext.cgiGet( edtLSD4CodigoActividad_26_3_Internalname) ;
                           A1686LSD4CodigoModalidadContratacio = httpContext.cgiGet( edtLSD4CodigoModalidadContratacio_Internalname) ;
                           A1687LSD4CodigoSiniestrado_32_2 = httpContext.cgiGet( edtLSD4CodigoSiniestrado_32_2_Internalname) ;
                           A1688LSD4CodigoLocalidad_34_2 = httpContext.cgiGet( edtLSD4CodigoLocalidad_34_2_Internalname) ;
                           A1689LSD4SituacionRevista1_36_2 = httpContext.cgiGet( edtLSD4SituacionRevista1_36_2_Internalname) ;
                           A1690LSD4DiaInicioSituacionRevista1 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista1_Internalname) ;
                           A1691LSD4SituacionRevista2_40_2 = httpContext.cgiGet( edtLSD4SituacionRevista2_40_2_Internalname) ;
                           A1692LSD4DiaInicioSituacionRevista2 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista2_Internalname) ;
                           A1693LSD4SituacionRevista3_44_2 = httpContext.cgiGet( edtLSD4SituacionRevista3_44_2_Internalname) ;
                           A1694LSD4DiaInicioSituacionRevista3 = httpContext.cgiGet( edtLSD4DiaInicioSituacionRevista3_Internalname) ;
                           A1695LSD4CantidadDiasTrabajados_48_ = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadDiasTrabajados_48__Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1696LSD4HorasTrabajadas_50_3 = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD4HorasTrabajadas_50_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1697LSD4PorcentajeAporteAdicionalS = localUtil.ctond( httpContext.cgiGet( edtLSD4PorcentajeAporteAdicionalS_Internalname)) ;
                           A1698LSD4ContribucionTareaDiferenci = localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionTareaDiferenci_Internalname)) ;
                           A1699LSD4CodigoObraSocial_63_6 = httpContext.cgiGet( edtLSD4CodigoObraSocial_63_6_Internalname) ;
                           A1700LSD4CantidadAdherentes_69_2 = (byte)(localUtil.ctol( httpContext.cgiGet( edtLSD4CantidadAdherentes_69_2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1701LSD4AporteAdicionalOS_71_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4AporteAdicionalOS_71_15_Internalname)) ;
                           A1702LSD4ContribucionAdicionalOS_86 = localUtil.ctond( httpContext.cgiGet( edtLSD4ContribucionAdicionalOS_86_Internalname)) ;
                           A1703LSD4BaseCalculoDiferencialApor = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialApor_Internalname)) ;
                           A1704LSD4BaseCalculoDiferencialOSyF = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialOSyF_Internalname)) ;
                           A1705LSD4BaseCalculoDiferencialLRT_ = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseCalculoDiferencialLRT__Internalname)) ;
                           A1706LSD4RemuneracionMaternidadANSe = localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionMaternidadANSe_Internalname)) ;
                           A1707LSD4RemuneracionBruta_161_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4RemuneracionBruta_161_15_Internalname)) ;
                           A1708LSD4BaseImponible1_176_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible1_176_15_Internalname)) ;
                           A1709LSD4BaseImponible2_191_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible2_191_15_Internalname)) ;
                           A1710LSD4BaseImponible3_206_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible3_206_15_Internalname)) ;
                           A1711LSD4BaseImponible4_221_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible4_221_15_Internalname)) ;
                           A1712LSD4BaseImponible5_236_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible5_236_15_Internalname)) ;
                           A1713LSD4BaseImponible6_251_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible6_251_15_Internalname)) ;
                           A1714LSD4BaseImponible7_266_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible7_266_15_Internalname)) ;
                           A1715LSD4BaseImponible8_281_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible8_281_15_Internalname)) ;
                           A1716LSD4BaseImponible9_296_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible9_296_15_Internalname)) ;
                           A1717LSD4BaseDifApoSegSoc_311_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifApoSegSoc_311_15_Internalname)) ;
                           A1718LSD4BaseDifContSegSoc_326_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseDifContSegSoc_326_15_Internalname)) ;
                           A1719LSD4BaseImponible10_341_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4BaseImponible10_341_15_Internalname)) ;
                           A1720LSD4ImporteADetraer_356_15 = localUtil.ctond( httpContext.cgiGet( edtLSD4ImporteADetraer_356_15_Internalname)) ;
                           AV75VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV75VerSVG);
                           AV76ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavModificarsvg_Internalname, AV76ModificarSVG);
                           AV77EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminarsvg_Internalname, AV77EliminarSVG);
                           AV78Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV78Update);
                           AV79Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV79Delete);
                           AV80Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV80Display);
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
                                       /* Execute user event: Start */
                                       e15HP2 ();
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
                                       /* Execute user event: Refresh */
                                       e16HP2 ();
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
                                       e17HP2 ();
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
                                    strupHP0( ) ;
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

   public void weHP2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormHP2( ) ;
         }
      }
   }

   public void paHP2( )
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
      subsflControlProps_262( ) ;
      while ( nGXsfl_26_idx <= nRC_GXsfl_26 )
      {
         sendrow_262( ) ;
         nGXsfl_26_idx = ((subGrid_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV8CliCod ,
                                 short AV9EmpCod ,
                                 int AV10LSDSec ,
                                 int AV11LSD2Sec ,
                                 String AV83Pgmname ,
                                 short AV17OrderedBy ,
                                 boolean AV18OrderedDsc ,
                                 String AV31TFLSD4CodigoObraSocial_63_6 ,
                                 GXSimpleCollection<String> AV32TFLSD4CodigoObraSocial_63_6_Sels ,
                                 byte AV33TFLSD4CantidadAdherentes_69_2 ,
                                 byte AV34TFLSD4CantidadAdherentes_69_2_To ,
                                 java.math.BigDecimal AV35TFLSD4AporteAdicionalOS_71_15 ,
                                 java.math.BigDecimal AV36TFLSD4AporteAdicionalOS_71_15_To ,
                                 java.math.BigDecimal AV37TFLSD4ContribucionAdicionalOS_86_15 ,
                                 java.math.BigDecimal AV38TFLSD4ContribucionAdicionalOS_86_15_To ,
                                 java.math.BigDecimal AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                 java.math.BigDecimal AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                 java.math.BigDecimal AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                 java.math.BigDecimal AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                 java.math.BigDecimal AV43TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                 java.math.BigDecimal AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                 java.math.BigDecimal AV45TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                 java.math.BigDecimal AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                 java.math.BigDecimal AV47TFLSD4RemuneracionBruta_161_15 ,
                                 java.math.BigDecimal AV48TFLSD4RemuneracionBruta_161_15_To ,
                                 java.math.BigDecimal AV49TFLSD4BaseImponible1_176_15 ,
                                 java.math.BigDecimal AV50TFLSD4BaseImponible1_176_15_To ,
                                 java.math.BigDecimal AV51TFLSD4BaseImponible2_191_15 ,
                                 java.math.BigDecimal AV52TFLSD4BaseImponible2_191_15_To ,
                                 java.math.BigDecimal AV53TFLSD4BaseImponible3_206_15 ,
                                 java.math.BigDecimal AV54TFLSD4BaseImponible3_206_15_To ,
                                 java.math.BigDecimal AV55TFLSD4BaseImponible4_221_15 ,
                                 java.math.BigDecimal AV56TFLSD4BaseImponible4_221_15_To ,
                                 java.math.BigDecimal AV57TFLSD4BaseImponible5_236_15 ,
                                 java.math.BigDecimal AV58TFLSD4BaseImponible5_236_15_To ,
                                 java.math.BigDecimal AV59TFLSD4BaseImponible6_251_15 ,
                                 java.math.BigDecimal AV60TFLSD4BaseImponible6_251_15_To ,
                                 java.math.BigDecimal AV61TFLSD4BaseImponible7_266_15 ,
                                 java.math.BigDecimal AV62TFLSD4BaseImponible7_266_15_To ,
                                 java.math.BigDecimal AV63TFLSD4BaseImponible8_281_15 ,
                                 java.math.BigDecimal AV64TFLSD4BaseImponible8_281_15_To ,
                                 java.math.BigDecimal AV65TFLSD4BaseImponible9_296_15 ,
                                 java.math.BigDecimal AV66TFLSD4BaseImponible9_296_15_To ,
                                 java.math.BigDecimal AV67TFLSD4BaseDifApoSegSoc_311_15 ,
                                 java.math.BigDecimal AV68TFLSD4BaseDifApoSegSoc_311_15_To ,
                                 java.math.BigDecimal AV69TFLSD4BaseDifContSegSoc_326_15 ,
                                 java.math.BigDecimal AV70TFLSD4BaseDifContSegSoc_326_15_To ,
                                 java.math.BigDecimal AV71TFLSD4BaseImponible10_341_15 ,
                                 java.math.BigDecimal AV72TFLSD4BaseImponible10_341_15_To ,
                                 java.math.BigDecimal AV73TFLSD4ImporteADetraer_356_15 ,
                                 java.math.BigDecimal AV74TFLSD4ImporteADetraer_356_15_To ,
                                 boolean AV27IsAuthorized_Update ,
                                 boolean AV28IsAuthorized_Delete ,
                                 int A3CliCod ,
                                 short A1EmpCod ,
                                 int A1649LSDSec ,
                                 int A1657LSD2Sec ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16HP2 ();
      GRID_nCurrentRecord = 0 ;
      rfHP2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"LSD_reg2LSD_reg4WC");
      forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
      forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
      forbiddenHiddens.add("LSDSec", localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9"));
      forbiddenHiddens.add("LSD2Sec", localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("lsd_reg2lsd_reg4wc:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LSD4SEC", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1674LSD4Sec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LSD4SEC", GXutil.ltrim( localUtil.ntoc( A1674LSD4Sec, (byte)(4), (byte)(0), ".", "")));
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
      rfHP2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV83Pgmname = "LSD_reg2LSD_reg4WC" ;
      Gx_err = (short)(0) ;
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_26_Refreshing);
   }

   public void rfHP2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(26) ;
      /* Execute user event: Refresh */
      e16HP2 ();
      nGXsfl_26_idx = 1 ;
      sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_262( ) ;
      bGXsfl_26_Refreshing = true ;
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
         subsflControlProps_262( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A1699LSD4CodigoObraSocial_63_6 ,
                                              AV32TFLSD4CodigoObraSocial_63_6_Sels ,
                                              Integer.valueOf(AV32TFLSD4CodigoObraSocial_63_6_Sels.size()) ,
                                              AV31TFLSD4CodigoObraSocial_63_6 ,
                                              Byte.valueOf(AV33TFLSD4CantidadAdherentes_69_2) ,
                                              Byte.valueOf(AV34TFLSD4CantidadAdherentes_69_2_To) ,
                                              AV35TFLSD4AporteAdicionalOS_71_15 ,
                                              AV36TFLSD4AporteAdicionalOS_71_15_To ,
                                              AV37TFLSD4ContribucionAdicionalOS_86_15 ,
                                              AV38TFLSD4ContribucionAdicionalOS_86_15_To ,
                                              AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                              AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                              AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                              AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                              AV43TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                              AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                              AV45TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                              AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                              AV47TFLSD4RemuneracionBruta_161_15 ,
                                              AV48TFLSD4RemuneracionBruta_161_15_To ,
                                              AV49TFLSD4BaseImponible1_176_15 ,
                                              AV50TFLSD4BaseImponible1_176_15_To ,
                                              AV51TFLSD4BaseImponible2_191_15 ,
                                              AV52TFLSD4BaseImponible2_191_15_To ,
                                              AV53TFLSD4BaseImponible3_206_15 ,
                                              AV54TFLSD4BaseImponible3_206_15_To ,
                                              AV55TFLSD4BaseImponible4_221_15 ,
                                              AV56TFLSD4BaseImponible4_221_15_To ,
                                              AV57TFLSD4BaseImponible5_236_15 ,
                                              AV58TFLSD4BaseImponible5_236_15_To ,
                                              AV59TFLSD4BaseImponible6_251_15 ,
                                              AV60TFLSD4BaseImponible6_251_15_To ,
                                              AV61TFLSD4BaseImponible7_266_15 ,
                                              AV62TFLSD4BaseImponible7_266_15_To ,
                                              AV63TFLSD4BaseImponible8_281_15 ,
                                              AV64TFLSD4BaseImponible8_281_15_To ,
                                              AV65TFLSD4BaseImponible9_296_15 ,
                                              AV66TFLSD4BaseImponible9_296_15_To ,
                                              AV67TFLSD4BaseDifApoSegSoc_311_15 ,
                                              AV68TFLSD4BaseDifApoSegSoc_311_15_To ,
                                              AV69TFLSD4BaseDifContSegSoc_326_15 ,
                                              AV70TFLSD4BaseDifContSegSoc_326_15_To ,
                                              AV71TFLSD4BaseImponible10_341_15 ,
                                              AV72TFLSD4BaseImponible10_341_15_To ,
                                              AV73TFLSD4ImporteADetraer_356_15 ,
                                              AV74TFLSD4ImporteADetraer_356_15_To ,
                                              Byte.valueOf(A1700LSD4CantidadAdherentes_69_2) ,
                                              A1701LSD4AporteAdicionalOS_71_15 ,
                                              A1702LSD4ContribucionAdicionalOS_86 ,
                                              A1703LSD4BaseCalculoDiferencialApor ,
                                              A1704LSD4BaseCalculoDiferencialOSyF ,
                                              A1705LSD4BaseCalculoDiferencialLRT_ ,
                                              A1706LSD4RemuneracionMaternidadANSe ,
                                              A1707LSD4RemuneracionBruta_161_15 ,
                                              A1708LSD4BaseImponible1_176_15 ,
                                              A1709LSD4BaseImponible2_191_15 ,
                                              A1710LSD4BaseImponible3_206_15 ,
                                              A1711LSD4BaseImponible4_221_15 ,
                                              A1712LSD4BaseImponible5_236_15 ,
                                              A1713LSD4BaseImponible6_251_15 ,
                                              A1714LSD4BaseImponible7_266_15 ,
                                              A1715LSD4BaseImponible8_281_15 ,
                                              A1716LSD4BaseImponible9_296_15 ,
                                              A1717LSD4BaseDifApoSegSoc_311_15 ,
                                              A1718LSD4BaseDifContSegSoc_326_15 ,
                                              A1719LSD4BaseImponible10_341_15 ,
                                              A1720LSD4ImporteADetraer_356_15 ,
                                              Short.valueOf(AV17OrderedBy) ,
                                              Boolean.valueOf(AV18OrderedDsc) ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Integer.valueOf(AV10LSDSec) ,
                                              Integer.valueOf(AV11LSD2Sec) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A1649LSDSec) ,
                                              Integer.valueOf(A1657LSD2Sec) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV31TFLSD4CodigoObraSocial_63_6 = GXutil.padr( GXutil.rtrim( AV31TFLSD4CodigoObraSocial_63_6), 6, "%") ;
         /* Using cursor H00HP2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LSDSec), Integer.valueOf(AV11LSD2Sec), lV31TFLSD4CodigoObraSocial_63_6, Byte.valueOf(AV33TFLSD4CantidadAdherentes_69_2), Byte.valueOf(AV34TFLSD4CantidadAdherentes_69_2_To), AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_26_idx = 1 ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H00HP2_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = H00HP2_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = H00HP2_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = H00HP2_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            A1720LSD4ImporteADetraer_356_15 = H00HP2_A1720LSD4ImporteADetraer_356_15[0] ;
            A1719LSD4BaseImponible10_341_15 = H00HP2_A1719LSD4BaseImponible10_341_15[0] ;
            A1718LSD4BaseDifContSegSoc_326_15 = H00HP2_A1718LSD4BaseDifContSegSoc_326_15[0] ;
            A1717LSD4BaseDifApoSegSoc_311_15 = H00HP2_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
            A1716LSD4BaseImponible9_296_15 = H00HP2_A1716LSD4BaseImponible9_296_15[0] ;
            A1715LSD4BaseImponible8_281_15 = H00HP2_A1715LSD4BaseImponible8_281_15[0] ;
            A1714LSD4BaseImponible7_266_15 = H00HP2_A1714LSD4BaseImponible7_266_15[0] ;
            A1713LSD4BaseImponible6_251_15 = H00HP2_A1713LSD4BaseImponible6_251_15[0] ;
            A1712LSD4BaseImponible5_236_15 = H00HP2_A1712LSD4BaseImponible5_236_15[0] ;
            A1711LSD4BaseImponible4_221_15 = H00HP2_A1711LSD4BaseImponible4_221_15[0] ;
            A1710LSD4BaseImponible3_206_15 = H00HP2_A1710LSD4BaseImponible3_206_15[0] ;
            A1709LSD4BaseImponible2_191_15 = H00HP2_A1709LSD4BaseImponible2_191_15[0] ;
            A1708LSD4BaseImponible1_176_15 = H00HP2_A1708LSD4BaseImponible1_176_15[0] ;
            A1707LSD4RemuneracionBruta_161_15 = H00HP2_A1707LSD4RemuneracionBruta_161_15[0] ;
            A1706LSD4RemuneracionMaternidadANSe = H00HP2_A1706LSD4RemuneracionMaternidadANSe[0] ;
            A1705LSD4BaseCalculoDiferencialLRT_ = H00HP2_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
            A1704LSD4BaseCalculoDiferencialOSyF = H00HP2_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
            A1703LSD4BaseCalculoDiferencialApor = H00HP2_A1703LSD4BaseCalculoDiferencialApor[0] ;
            A1702LSD4ContribucionAdicionalOS_86 = H00HP2_A1702LSD4ContribucionAdicionalOS_86[0] ;
            A1701LSD4AporteAdicionalOS_71_15 = H00HP2_A1701LSD4AporteAdicionalOS_71_15[0] ;
            A1700LSD4CantidadAdherentes_69_2 = H00HP2_A1700LSD4CantidadAdherentes_69_2[0] ;
            A1699LSD4CodigoObraSocial_63_6 = H00HP2_A1699LSD4CodigoObraSocial_63_6[0] ;
            A1698LSD4ContribucionTareaDiferenci = H00HP2_A1698LSD4ContribucionTareaDiferenci[0] ;
            A1697LSD4PorcentajeAporteAdicionalS = H00HP2_A1697LSD4PorcentajeAporteAdicionalS[0] ;
            A1696LSD4HorasTrabajadas_50_3 = H00HP2_A1696LSD4HorasTrabajadas_50_3[0] ;
            A1695LSD4CantidadDiasTrabajados_48_ = H00HP2_A1695LSD4CantidadDiasTrabajados_48_[0] ;
            A1694LSD4DiaInicioSituacionRevista3 = H00HP2_A1694LSD4DiaInicioSituacionRevista3[0] ;
            A1693LSD4SituacionRevista3_44_2 = H00HP2_A1693LSD4SituacionRevista3_44_2[0] ;
            A1692LSD4DiaInicioSituacionRevista2 = H00HP2_A1692LSD4DiaInicioSituacionRevista2[0] ;
            A1691LSD4SituacionRevista2_40_2 = H00HP2_A1691LSD4SituacionRevista2_40_2[0] ;
            A1690LSD4DiaInicioSituacionRevista1 = H00HP2_A1690LSD4DiaInicioSituacionRevista1[0] ;
            A1689LSD4SituacionRevista1_36_2 = H00HP2_A1689LSD4SituacionRevista1_36_2[0] ;
            A1688LSD4CodigoLocalidad_34_2 = H00HP2_A1688LSD4CodigoLocalidad_34_2[0] ;
            A1687LSD4CodigoSiniestrado_32_2 = H00HP2_A1687LSD4CodigoSiniestrado_32_2[0] ;
            A1686LSD4CodigoModalidadContratacio = H00HP2_A1686LSD4CodigoModalidadContratacio[0] ;
            A1685LSD4CodigoActividad_26_3 = H00HP2_A1685LSD4CodigoActividad_26_3[0] ;
            A1684LSD4CodigoCondicion_24_2 = H00HP2_A1684LSD4CodigoCondicion_24_2[0] ;
            A1683LSD4CodigoSituacion_22_2 = H00HP2_A1683LSD4CodigoSituacion_22_2[0] ;
            A1682LSD4TipoOperacion_21_1 = H00HP2_A1682LSD4TipoOperacion_21_1[0] ;
            A1681LSD4TipoEmpresa_20_1 = H00HP2_A1681LSD4TipoEmpresa_20_1[0] ;
            A1680LSD4MarcaReduccion_19_1 = H00HP2_A1680LSD4MarcaReduccion_19_1[0] ;
            A1679LSD4MarcaSCVO_18_1 = H00HP2_A1679LSD4MarcaSCVO_18_1[0] ;
            A1678LSD4MarcaCCT_17_1 = H00HP2_A1678LSD4MarcaCCT_17_1[0] ;
            A1677LSD4CantidadHijos_15_2 = H00HP2_A1677LSD4CantidadHijos_15_2[0] ;
            A1676LSD4Conyuge_14_1 = H00HP2_A1676LSD4Conyuge_14_1[0] ;
            A1675LSD4CUIL_3_11 = H00HP2_A1675LSD4CUIL_3_11[0] ;
            A1674LSD4Sec = H00HP2_A1674LSD4Sec[0] ;
            e17HP2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(26) ;
         wbHP0( ) ;
      }
      bGXsfl_26_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesHP2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV83Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83Pgmname, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_UPDATE", AV27IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_DELETE", AV28IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV28IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_LSD4SEC"+"_"+sGXsfl_26_idx, getSecureSignedToken( sPrefix+sGXsfl_26_idx, localUtil.format( DecimalUtil.doubleToDec(A1674LSD4Sec), "ZZZ9")));
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
                                           A1699LSD4CodigoObraSocial_63_6 ,
                                           AV32TFLSD4CodigoObraSocial_63_6_Sels ,
                                           Integer.valueOf(AV32TFLSD4CodigoObraSocial_63_6_Sels.size()) ,
                                           AV31TFLSD4CodigoObraSocial_63_6 ,
                                           Byte.valueOf(AV33TFLSD4CantidadAdherentes_69_2) ,
                                           Byte.valueOf(AV34TFLSD4CantidadAdherentes_69_2_To) ,
                                           AV35TFLSD4AporteAdicionalOS_71_15 ,
                                           AV36TFLSD4AporteAdicionalOS_71_15_To ,
                                           AV37TFLSD4ContribucionAdicionalOS_86_15 ,
                                           AV38TFLSD4ContribucionAdicionalOS_86_15_To ,
                                           AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                           AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                           AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                           AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                           AV43TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                           AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                           AV45TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                           AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                           AV47TFLSD4RemuneracionBruta_161_15 ,
                                           AV48TFLSD4RemuneracionBruta_161_15_To ,
                                           AV49TFLSD4BaseImponible1_176_15 ,
                                           AV50TFLSD4BaseImponible1_176_15_To ,
                                           AV51TFLSD4BaseImponible2_191_15 ,
                                           AV52TFLSD4BaseImponible2_191_15_To ,
                                           AV53TFLSD4BaseImponible3_206_15 ,
                                           AV54TFLSD4BaseImponible3_206_15_To ,
                                           AV55TFLSD4BaseImponible4_221_15 ,
                                           AV56TFLSD4BaseImponible4_221_15_To ,
                                           AV57TFLSD4BaseImponible5_236_15 ,
                                           AV58TFLSD4BaseImponible5_236_15_To ,
                                           AV59TFLSD4BaseImponible6_251_15 ,
                                           AV60TFLSD4BaseImponible6_251_15_To ,
                                           AV61TFLSD4BaseImponible7_266_15 ,
                                           AV62TFLSD4BaseImponible7_266_15_To ,
                                           AV63TFLSD4BaseImponible8_281_15 ,
                                           AV64TFLSD4BaseImponible8_281_15_To ,
                                           AV65TFLSD4BaseImponible9_296_15 ,
                                           AV66TFLSD4BaseImponible9_296_15_To ,
                                           AV67TFLSD4BaseDifApoSegSoc_311_15 ,
                                           AV68TFLSD4BaseDifApoSegSoc_311_15_To ,
                                           AV69TFLSD4BaseDifContSegSoc_326_15 ,
                                           AV70TFLSD4BaseDifContSegSoc_326_15_To ,
                                           AV71TFLSD4BaseImponible10_341_15 ,
                                           AV72TFLSD4BaseImponible10_341_15_To ,
                                           AV73TFLSD4ImporteADetraer_356_15 ,
                                           AV74TFLSD4ImporteADetraer_356_15_To ,
                                           Byte.valueOf(A1700LSD4CantidadAdherentes_69_2) ,
                                           A1701LSD4AporteAdicionalOS_71_15 ,
                                           A1702LSD4ContribucionAdicionalOS_86 ,
                                           A1703LSD4BaseCalculoDiferencialApor ,
                                           A1704LSD4BaseCalculoDiferencialOSyF ,
                                           A1705LSD4BaseCalculoDiferencialLRT_ ,
                                           A1706LSD4RemuneracionMaternidadANSe ,
                                           A1707LSD4RemuneracionBruta_161_15 ,
                                           A1708LSD4BaseImponible1_176_15 ,
                                           A1709LSD4BaseImponible2_191_15 ,
                                           A1710LSD4BaseImponible3_206_15 ,
                                           A1711LSD4BaseImponible4_221_15 ,
                                           A1712LSD4BaseImponible5_236_15 ,
                                           A1713LSD4BaseImponible6_251_15 ,
                                           A1714LSD4BaseImponible7_266_15 ,
                                           A1715LSD4BaseImponible8_281_15 ,
                                           A1716LSD4BaseImponible9_296_15 ,
                                           A1717LSD4BaseDifApoSegSoc_311_15 ,
                                           A1718LSD4BaseDifContSegSoc_326_15 ,
                                           A1719LSD4BaseImponible10_341_15 ,
                                           A1720LSD4ImporteADetraer_356_15 ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LSDSec) ,
                                           Integer.valueOf(AV11LSD2Sec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A1649LSDSec) ,
                                           Integer.valueOf(A1657LSD2Sec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV31TFLSD4CodigoObraSocial_63_6 = GXutil.padr( GXutil.rtrim( AV31TFLSD4CodigoObraSocial_63_6), 6, "%") ;
      /* Using cursor H00HP3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LSDSec), Integer.valueOf(AV11LSD2Sec), lV31TFLSD4CodigoObraSocial_63_6, Byte.valueOf(AV33TFLSD4CantidadAdherentes_69_2), Byte.valueOf(AV34TFLSD4CantidadAdherentes_69_2_To), AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To});
      GRID_nRecordCount = H00HP3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LSDSec, AV11LSD2Sec, AV83Pgmname, AV17OrderedBy, AV18OrderedDsc, AV31TFLSD4CodigoObraSocial_63_6, AV32TFLSD4CodigoObraSocial_63_6_Sels, AV33TFLSD4CantidadAdherentes_69_2, AV34TFLSD4CantidadAdherentes_69_2_To, AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, AV27IsAuthorized_Update, AV28IsAuthorized_Delete, A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LSDSec, AV11LSD2Sec, AV83Pgmname, AV17OrderedBy, AV18OrderedDsc, AV31TFLSD4CodigoObraSocial_63_6, AV32TFLSD4CodigoObraSocial_63_6_Sels, AV33TFLSD4CantidadAdherentes_69_2, AV34TFLSD4CantidadAdherentes_69_2_To, AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, AV27IsAuthorized_Update, AV28IsAuthorized_Delete, A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LSDSec, AV11LSD2Sec, AV83Pgmname, AV17OrderedBy, AV18OrderedDsc, AV31TFLSD4CodigoObraSocial_63_6, AV32TFLSD4CodigoObraSocial_63_6_Sels, AV33TFLSD4CantidadAdherentes_69_2, AV34TFLSD4CantidadAdherentes_69_2_To, AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, AV27IsAuthorized_Update, AV28IsAuthorized_Delete, A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LSDSec, AV11LSD2Sec, AV83Pgmname, AV17OrderedBy, AV18OrderedDsc, AV31TFLSD4CodigoObraSocial_63_6, AV32TFLSD4CodigoObraSocial_63_6_Sels, AV33TFLSD4CantidadAdherentes_69_2, AV34TFLSD4CantidadAdherentes_69_2_To, AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, AV27IsAuthorized_Update, AV28IsAuthorized_Delete, A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LSDSec, AV11LSD2Sec, AV83Pgmname, AV17OrderedBy, AV18OrderedDsc, AV31TFLSD4CodigoObraSocial_63_6, AV32TFLSD4CodigoObraSocial_63_6_Sels, AV33TFLSD4CantidadAdherentes_69_2, AV34TFLSD4CantidadAdherentes_69_2_To, AV35TFLSD4AporteAdicionalOS_71_15, AV36TFLSD4AporteAdicionalOS_71_15_To, AV37TFLSD4ContribucionAdicionalOS_86_15, AV38TFLSD4ContribucionAdicionalOS_86_15_To, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV43TFLSD4BaseCalculoDiferencialLRT_131_15, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV45TFLSD4RemuneracionMaternidadANSeS_146_15, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV47TFLSD4RemuneracionBruta_161_15, AV48TFLSD4RemuneracionBruta_161_15_To, AV49TFLSD4BaseImponible1_176_15, AV50TFLSD4BaseImponible1_176_15_To, AV51TFLSD4BaseImponible2_191_15, AV52TFLSD4BaseImponible2_191_15_To, AV53TFLSD4BaseImponible3_206_15, AV54TFLSD4BaseImponible3_206_15_To, AV55TFLSD4BaseImponible4_221_15, AV56TFLSD4BaseImponible4_221_15_To, AV57TFLSD4BaseImponible5_236_15, AV58TFLSD4BaseImponible5_236_15_To, AV59TFLSD4BaseImponible6_251_15, AV60TFLSD4BaseImponible6_251_15_To, AV61TFLSD4BaseImponible7_266_15, AV62TFLSD4BaseImponible7_266_15_To, AV63TFLSD4BaseImponible8_281_15, AV64TFLSD4BaseImponible8_281_15_To, AV65TFLSD4BaseImponible9_296_15, AV66TFLSD4BaseImponible9_296_15_To, AV67TFLSD4BaseDifApoSegSoc_311_15, AV68TFLSD4BaseDifApoSegSoc_311_15_To, AV69TFLSD4BaseDifContSegSoc_326_15, AV70TFLSD4BaseDifContSegSoc_326_15_To, AV71TFLSD4BaseImponible10_341_15, AV72TFLSD4BaseImponible10_341_15_To, AV73TFLSD4ImporteADetraer_356_15, AV74TFLSD4ImporteADetraer_356_15_To, AV27IsAuthorized_Update, AV28IsAuthorized_Delete, A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV83Pgmname = "LSD_reg2LSD_reg4WC" ;
      Gx_err = (short)(0) ;
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupHP0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15HP2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV20DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_26 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_26"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV23GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV24GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV25GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV11LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11LSD2Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"LSD_reg2LSD_reg4WC");
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         forbiddenHiddens.add("CliCod", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"));
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
         A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         forbiddenHiddens.add("LSDSec", localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9"));
         A1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         forbiddenHiddens.add("LSD2Sec", localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("lsd_reg2lsd_reg4wc:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e15HP2 ();
      if (returnInSub) return;
   }

   public void e15HP2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLSDSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSDSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Visible), 5, 0), true);
      edtLSD2Sec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLSD2Sec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Visible), 5, 0), true);
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV20DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV20DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e16HP2( )
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
      lsd_reg2lsd_reg4wc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      AV23GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GridCurrentPage), 10, 0));
      AV24GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridPageCount), 10, 0));
      GXt_char6 = AV25GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV83Pgmname, GXv_char7) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV25GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25GridAppliedFilters", AV25GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e11HP2( )
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
         AV22PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV22PageToGo) ;
      }
   }

   public void e12HP2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13HP2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4CodigoObraSocial_63_6") == 0 )
         {
            AV31TFLSD4CodigoObraSocial_63_6 = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLSD4CodigoObraSocial_63_6", AV31TFLSD4CodigoObraSocial_63_6);
            AV30TFLSD4CodigoObraSocial_63_6_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLSD4CodigoObraSocial_63_6_SelsJson", AV30TFLSD4CodigoObraSocial_63_6_SelsJson);
            AV32TFLSD4CodigoObraSocial_63_6_Sels.fromJSonString(AV30TFLSD4CodigoObraSocial_63_6_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4CantidadAdherentes_69_2") == 0 )
         {
            AV33TFLSD4CantidadAdherentes_69_2 = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFLSD4CantidadAdherentes_69_2), 2, 0));
            AV34TFLSD4CantidadAdherentes_69_2_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFLSD4CantidadAdherentes_69_2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFLSD4CantidadAdherentes_69_2_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4AporteAdicionalOS_71_15") == 0 )
         {
            AV35TFLSD4AporteAdicionalOS_71_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( AV35TFLSD4AporteAdicionalOS_71_15, 16, 2));
            AV36TFLSD4AporteAdicionalOS_71_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLSD4AporteAdicionalOS_71_15_To", GXutil.ltrimstr( AV36TFLSD4AporteAdicionalOS_71_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4ContribucionAdicionalOS_86_15") == 0 )
         {
            AV37TFLSD4ContribucionAdicionalOS_86_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLSD4ContribucionAdicionalOS_86_15", GXutil.ltrimstr( AV37TFLSD4ContribucionAdicionalOS_86_15, 16, 2));
            AV38TFLSD4ContribucionAdicionalOS_86_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLSD4ContribucionAdicionalOS_86_15_To", GXutil.ltrimstr( AV38TFLSD4ContribucionAdicionalOS_86_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseCalculoDiferencialAportesOSyFSR_101_15") == 0 )
         {
            AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15", GXutil.ltrimstr( AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, 16, 2));
            AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To", GXutil.ltrimstr( AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseCalculoDiferencialOSyFSR_116_15") == 0 )
         {
            AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15", GXutil.ltrimstr( AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, 16, 2));
            AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To", GXutil.ltrimstr( AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseCalculoDiferencialLRT_131_15") == 0 )
         {
            AV43TFLSD4BaseCalculoDiferencialLRT_131_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFLSD4BaseCalculoDiferencialLRT_131_15", GXutil.ltrimstr( AV43TFLSD4BaseCalculoDiferencialLRT_131_15, 16, 2));
            AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To", GXutil.ltrimstr( AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4RemuneracionMaternidadANSeS_146_15") == 0 )
         {
            AV45TFLSD4RemuneracionMaternidadANSeS_146_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFLSD4RemuneracionMaternidadANSeS_146_15", GXutil.ltrimstr( AV45TFLSD4RemuneracionMaternidadANSeS_146_15, 16, 2));
            AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To", GXutil.ltrimstr( AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4RemuneracionBruta_161_15") == 0 )
         {
            AV47TFLSD4RemuneracionBruta_161_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TFLSD4RemuneracionBruta_161_15", GXutil.ltrimstr( AV47TFLSD4RemuneracionBruta_161_15, 16, 2));
            AV48TFLSD4RemuneracionBruta_161_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TFLSD4RemuneracionBruta_161_15_To", GXutil.ltrimstr( AV48TFLSD4RemuneracionBruta_161_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible1_176_15") == 0 )
         {
            AV49TFLSD4BaseImponible1_176_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49TFLSD4BaseImponible1_176_15", GXutil.ltrimstr( AV49TFLSD4BaseImponible1_176_15, 16, 2));
            AV50TFLSD4BaseImponible1_176_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50TFLSD4BaseImponible1_176_15_To", GXutil.ltrimstr( AV50TFLSD4BaseImponible1_176_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible2_191_15") == 0 )
         {
            AV51TFLSD4BaseImponible2_191_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TFLSD4BaseImponible2_191_15", GXutil.ltrimstr( AV51TFLSD4BaseImponible2_191_15, 16, 2));
            AV52TFLSD4BaseImponible2_191_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TFLSD4BaseImponible2_191_15_To", GXutil.ltrimstr( AV52TFLSD4BaseImponible2_191_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible3_206_15") == 0 )
         {
            AV53TFLSD4BaseImponible3_206_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TFLSD4BaseImponible3_206_15", GXutil.ltrimstr( AV53TFLSD4BaseImponible3_206_15, 16, 2));
            AV54TFLSD4BaseImponible3_206_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TFLSD4BaseImponible3_206_15_To", GXutil.ltrimstr( AV54TFLSD4BaseImponible3_206_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible4_221_15") == 0 )
         {
            AV55TFLSD4BaseImponible4_221_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFLSD4BaseImponible4_221_15", GXutil.ltrimstr( AV55TFLSD4BaseImponible4_221_15, 16, 2));
            AV56TFLSD4BaseImponible4_221_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLSD4BaseImponible4_221_15_To", GXutil.ltrimstr( AV56TFLSD4BaseImponible4_221_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible5_236_15") == 0 )
         {
            AV57TFLSD4BaseImponible5_236_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLSD4BaseImponible5_236_15", GXutil.ltrimstr( AV57TFLSD4BaseImponible5_236_15, 16, 2));
            AV58TFLSD4BaseImponible5_236_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLSD4BaseImponible5_236_15_To", GXutil.ltrimstr( AV58TFLSD4BaseImponible5_236_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible6_251_15") == 0 )
         {
            AV59TFLSD4BaseImponible6_251_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFLSD4BaseImponible6_251_15", GXutil.ltrimstr( AV59TFLSD4BaseImponible6_251_15, 16, 2));
            AV60TFLSD4BaseImponible6_251_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFLSD4BaseImponible6_251_15_To", GXutil.ltrimstr( AV60TFLSD4BaseImponible6_251_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible7_266_15") == 0 )
         {
            AV61TFLSD4BaseImponible7_266_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TFLSD4BaseImponible7_266_15", GXutil.ltrimstr( AV61TFLSD4BaseImponible7_266_15, 16, 2));
            AV62TFLSD4BaseImponible7_266_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62TFLSD4BaseImponible7_266_15_To", GXutil.ltrimstr( AV62TFLSD4BaseImponible7_266_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible8_281_15") == 0 )
         {
            AV63TFLSD4BaseImponible8_281_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63TFLSD4BaseImponible8_281_15", GXutil.ltrimstr( AV63TFLSD4BaseImponible8_281_15, 16, 2));
            AV64TFLSD4BaseImponible8_281_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64TFLSD4BaseImponible8_281_15_To", GXutil.ltrimstr( AV64TFLSD4BaseImponible8_281_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible9_296_15") == 0 )
         {
            AV65TFLSD4BaseImponible9_296_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFLSD4BaseImponible9_296_15", GXutil.ltrimstr( AV65TFLSD4BaseImponible9_296_15, 16, 2));
            AV66TFLSD4BaseImponible9_296_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFLSD4BaseImponible9_296_15_To", GXutil.ltrimstr( AV66TFLSD4BaseImponible9_296_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseDifApoSegSoc_311_15") == 0 )
         {
            AV67TFLSD4BaseDifApoSegSoc_311_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFLSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( AV67TFLSD4BaseDifApoSegSoc_311_15, 16, 2));
            AV68TFLSD4BaseDifApoSegSoc_311_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFLSD4BaseDifApoSegSoc_311_15_To", GXutil.ltrimstr( AV68TFLSD4BaseDifApoSegSoc_311_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseDifContSegSoc_326_15") == 0 )
         {
            AV69TFLSD4BaseDifContSegSoc_326_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TFLSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( AV69TFLSD4BaseDifContSegSoc_326_15, 16, 2));
            AV70TFLSD4BaseDifContSegSoc_326_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70TFLSD4BaseDifContSegSoc_326_15_To", GXutil.ltrimstr( AV70TFLSD4BaseDifContSegSoc_326_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4BaseImponible10_341_15") == 0 )
         {
            AV71TFLSD4BaseImponible10_341_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71TFLSD4BaseImponible10_341_15", GXutil.ltrimstr( AV71TFLSD4BaseImponible10_341_15, 16, 2));
            AV72TFLSD4BaseImponible10_341_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72TFLSD4BaseImponible10_341_15_To", GXutil.ltrimstr( AV72TFLSD4BaseImponible10_341_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LSD4ImporteADetraer_356_15") == 0 )
         {
            AV73TFLSD4ImporteADetraer_356_15 = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TFLSD4ImporteADetraer_356_15", GXutil.ltrimstr( AV73TFLSD4ImporteADetraer_356_15, 16, 2));
            AV74TFLSD4ImporteADetraer_356_15_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TFLSD4ImporteADetraer_356_15_To", GXutil.ltrimstr( AV74TFLSD4ImporteADetraer_356_15_To, 16, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV32TFLSD4CodigoObraSocial_63_6_Sels", AV32TFLSD4CodigoObraSocial_63_6_Sels);
   }

   private void e17HP2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV78Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavUpdate_Internalname, AV78Update);
      if ( AV27IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.lsd_reg4", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1657LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1674LSD4Sec,4,0))}, new String[] {"Mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec"})  ;
      }
      AV79Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDelete_Internalname, AV79Delete);
      if ( AV28IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.lsd_reg4", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1657LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1674LSD4Sec,4,0))}, new String[] {"Mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec"})  ;
      }
      AV80Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDisplay_Internalname, AV80Display);
      edtavDisplay_Link = formatLink("web.lsd_reg4view", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A1649LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1657LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A1674LSD4Sec,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char6 = AV75VerSVG ;
      GXv_char7[0] = GXt_char6 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV75VerSVG = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavVersvg_Internalname, AV75VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char6 = AV76ModificarSVG ;
      GXv_char7[0] = GXt_char6 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV76ModificarSVG = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavModificarsvg_Internalname, AV76ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char6 = AV77EliminarSVG ;
      GXv_char7[0] = GXt_char6 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV77EliminarSVG = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminarsvg_Internalname, AV77EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(26) ;
      }
      sendrow_262( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_26_Refreshing )
      {
         httpContext.doAjaxLoad(26, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e14HP2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.lsd_reg4", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD4Sec"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV17OrderedBy, 4, 0))+":"+(AV18OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean8 = AV27IsAuthorized_Update ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Update", GXv_boolean9) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV27IsAuthorized_Update = GXt_boolean8 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27IsAuthorized_Update", AV27IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( sPrefix, AV27IsAuthorized_Update));
      if ( ! ( AV27IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_26_Refreshing);
      }
      GXt_boolean8 = AV28IsAuthorized_Delete ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Delete", GXv_boolean9) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV28IsAuthorized_Delete = GXt_boolean8 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28IsAuthorized_Delete", AV28IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( sPrefix, AV28IsAuthorized_Delete));
      if ( ! ( AV28IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_26_Refreshing);
      }
      GXt_boolean8 = AV29TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4_Insert", GXv_boolean9) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV29TempBoolean = GXt_boolean8 ;
      if ( ! ( AV29TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue(AV83Pgmname+"GridState"), "") == 0 )
      {
         AV15GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV83Pgmname+"GridState"), null, null);
      }
      else
      {
         AV15GridState.fromxml(AV19Session.getValue(AV83Pgmname+"GridState"), null, null);
      }
      AV17OrderedBy = AV15GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
      AV18OrderedDsc = AV15GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18OrderedDsc", AV18OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV84GXV1 = 1 ;
      while ( AV84GXV1 <= AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV84GXV1));
         if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CODIGOOBRASOCIAL_63_6") == 0 )
         {
            AV31TFLSD4CodigoObraSocial_63_6 = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLSD4CodigoObraSocial_63_6", AV31TFLSD4CodigoObraSocial_63_6);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CODIGOOBRASOCIAL_63_6_SEL") == 0 )
         {
            AV30TFLSD4CodigoObraSocial_63_6_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFLSD4CodigoObraSocial_63_6_SelsJson", AV30TFLSD4CodigoObraSocial_63_6_SelsJson);
            AV32TFLSD4CodigoObraSocial_63_6_Sels.fromJSonString(AV30TFLSD4CodigoObraSocial_63_6_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CANTIDADADHERENTES_69_2") == 0 )
         {
            AV33TFLSD4CantidadAdherentes_69_2 = (byte)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFLSD4CantidadAdherentes_69_2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFLSD4CantidadAdherentes_69_2), 2, 0));
            AV34TFLSD4CantidadAdherentes_69_2_To = (byte)(GXutil.lval( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFLSD4CantidadAdherentes_69_2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFLSD4CantidadAdherentes_69_2_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4APORTEADICIONALOS_71_15") == 0 )
         {
            AV35TFLSD4AporteAdicionalOS_71_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFLSD4AporteAdicionalOS_71_15", GXutil.ltrimstr( AV35TFLSD4AporteAdicionalOS_71_15, 16, 2));
            AV36TFLSD4AporteAdicionalOS_71_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLSD4AporteAdicionalOS_71_15_To", GXutil.ltrimstr( AV36TFLSD4AporteAdicionalOS_71_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CONTRIBUCIONADICIONALOS_86_15") == 0 )
         {
            AV37TFLSD4ContribucionAdicionalOS_86_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLSD4ContribucionAdicionalOS_86_15", GXutil.ltrimstr( AV37TFLSD4ContribucionAdicionalOS_86_15, 16, 2));
            AV38TFLSD4ContribucionAdicionalOS_86_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFLSD4ContribucionAdicionalOS_86_15_To", GXutil.ltrimstr( AV38TFLSD4ContribucionAdicionalOS_86_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15") == 0 )
         {
            AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15", GXutil.ltrimstr( AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, 16, 2));
            AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To", GXutil.ltrimstr( AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASECALCULODIFERENCIALOSYFSR_116_15") == 0 )
         {
            AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15", GXutil.ltrimstr( AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, 16, 2));
            AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To", GXutil.ltrimstr( AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASECALCULODIFERENCIALLRT_131_15") == 0 )
         {
            AV43TFLSD4BaseCalculoDiferencialLRT_131_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFLSD4BaseCalculoDiferencialLRT_131_15", GXutil.ltrimstr( AV43TFLSD4BaseCalculoDiferencialLRT_131_15, 16, 2));
            AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To", GXutil.ltrimstr( AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4REMUNERACIONMATERNIDADANSES_146_15") == 0 )
         {
            AV45TFLSD4RemuneracionMaternidadANSeS_146_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFLSD4RemuneracionMaternidadANSeS_146_15", GXutil.ltrimstr( AV45TFLSD4RemuneracionMaternidadANSeS_146_15, 16, 2));
            AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To", GXutil.ltrimstr( AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4REMUNERACIONBRUTA_161_15") == 0 )
         {
            AV47TFLSD4RemuneracionBruta_161_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TFLSD4RemuneracionBruta_161_15", GXutil.ltrimstr( AV47TFLSD4RemuneracionBruta_161_15, 16, 2));
            AV48TFLSD4RemuneracionBruta_161_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TFLSD4RemuneracionBruta_161_15_To", GXutil.ltrimstr( AV48TFLSD4RemuneracionBruta_161_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE1_176_15") == 0 )
         {
            AV49TFLSD4BaseImponible1_176_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49TFLSD4BaseImponible1_176_15", GXutil.ltrimstr( AV49TFLSD4BaseImponible1_176_15, 16, 2));
            AV50TFLSD4BaseImponible1_176_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50TFLSD4BaseImponible1_176_15_To", GXutil.ltrimstr( AV50TFLSD4BaseImponible1_176_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE2_191_15") == 0 )
         {
            AV51TFLSD4BaseImponible2_191_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TFLSD4BaseImponible2_191_15", GXutil.ltrimstr( AV51TFLSD4BaseImponible2_191_15, 16, 2));
            AV52TFLSD4BaseImponible2_191_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TFLSD4BaseImponible2_191_15_To", GXutil.ltrimstr( AV52TFLSD4BaseImponible2_191_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE3_206_15") == 0 )
         {
            AV53TFLSD4BaseImponible3_206_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TFLSD4BaseImponible3_206_15", GXutil.ltrimstr( AV53TFLSD4BaseImponible3_206_15, 16, 2));
            AV54TFLSD4BaseImponible3_206_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TFLSD4BaseImponible3_206_15_To", GXutil.ltrimstr( AV54TFLSD4BaseImponible3_206_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE4_221_15") == 0 )
         {
            AV55TFLSD4BaseImponible4_221_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TFLSD4BaseImponible4_221_15", GXutil.ltrimstr( AV55TFLSD4BaseImponible4_221_15, 16, 2));
            AV56TFLSD4BaseImponible4_221_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TFLSD4BaseImponible4_221_15_To", GXutil.ltrimstr( AV56TFLSD4BaseImponible4_221_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE5_236_15") == 0 )
         {
            AV57TFLSD4BaseImponible5_236_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TFLSD4BaseImponible5_236_15", GXutil.ltrimstr( AV57TFLSD4BaseImponible5_236_15, 16, 2));
            AV58TFLSD4BaseImponible5_236_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TFLSD4BaseImponible5_236_15_To", GXutil.ltrimstr( AV58TFLSD4BaseImponible5_236_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE6_251_15") == 0 )
         {
            AV59TFLSD4BaseImponible6_251_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFLSD4BaseImponible6_251_15", GXutil.ltrimstr( AV59TFLSD4BaseImponible6_251_15, 16, 2));
            AV60TFLSD4BaseImponible6_251_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFLSD4BaseImponible6_251_15_To", GXutil.ltrimstr( AV60TFLSD4BaseImponible6_251_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE7_266_15") == 0 )
         {
            AV61TFLSD4BaseImponible7_266_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TFLSD4BaseImponible7_266_15", GXutil.ltrimstr( AV61TFLSD4BaseImponible7_266_15, 16, 2));
            AV62TFLSD4BaseImponible7_266_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62TFLSD4BaseImponible7_266_15_To", GXutil.ltrimstr( AV62TFLSD4BaseImponible7_266_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE8_281_15") == 0 )
         {
            AV63TFLSD4BaseImponible8_281_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63TFLSD4BaseImponible8_281_15", GXutil.ltrimstr( AV63TFLSD4BaseImponible8_281_15, 16, 2));
            AV64TFLSD4BaseImponible8_281_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64TFLSD4BaseImponible8_281_15_To", GXutil.ltrimstr( AV64TFLSD4BaseImponible8_281_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE9_296_15") == 0 )
         {
            AV65TFLSD4BaseImponible9_296_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFLSD4BaseImponible9_296_15", GXutil.ltrimstr( AV65TFLSD4BaseImponible9_296_15, 16, 2));
            AV66TFLSD4BaseImponible9_296_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFLSD4BaseImponible9_296_15_To", GXutil.ltrimstr( AV66TFLSD4BaseImponible9_296_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEDIFAPOSEGSOC_311_15") == 0 )
         {
            AV67TFLSD4BaseDifApoSegSoc_311_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFLSD4BaseDifApoSegSoc_311_15", GXutil.ltrimstr( AV67TFLSD4BaseDifApoSegSoc_311_15, 16, 2));
            AV68TFLSD4BaseDifApoSegSoc_311_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFLSD4BaseDifApoSegSoc_311_15_To", GXutil.ltrimstr( AV68TFLSD4BaseDifApoSegSoc_311_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEDIFCONTSEGSOC_326_15") == 0 )
         {
            AV69TFLSD4BaseDifContSegSoc_326_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TFLSD4BaseDifContSegSoc_326_15", GXutil.ltrimstr( AV69TFLSD4BaseDifContSegSoc_326_15, 16, 2));
            AV70TFLSD4BaseDifContSegSoc_326_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70TFLSD4BaseDifContSegSoc_326_15_To", GXutil.ltrimstr( AV70TFLSD4BaseDifContSegSoc_326_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE10_341_15") == 0 )
         {
            AV71TFLSD4BaseImponible10_341_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71TFLSD4BaseImponible10_341_15", GXutil.ltrimstr( AV71TFLSD4BaseImponible10_341_15, 16, 2));
            AV72TFLSD4BaseImponible10_341_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72TFLSD4BaseImponible10_341_15_To", GXutil.ltrimstr( AV72TFLSD4BaseImponible10_341_15_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4IMPORTEADETRAER_356_15") == 0 )
         {
            AV73TFLSD4ImporteADetraer_356_15 = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73TFLSD4ImporteADetraer_356_15", GXutil.ltrimstr( AV73TFLSD4ImporteADetraer_356_15, 16, 2));
            AV74TFLSD4ImporteADetraer_356_15_To = CommonUtil.decimalVal( AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74TFLSD4ImporteADetraer_356_15_To", GXutil.ltrimstr( AV74TFLSD4ImporteADetraer_356_15_To, 16, 2));
         }
         AV84GXV1 = (int)(AV84GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV32TFLSD4CodigoObraSocial_63_6_Sels.size()==0), AV30TFLSD4CodigoObraSocial_63_6_SelsJson, GXv_char7) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Selectedvalue_set = "|||||||||||||||||||||||||"+GXt_char6+"|||||||||||||||||||||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFLSD4CodigoObraSocial_63_6)==0), AV31TFLSD4CodigoObraSocial_63_6, GXv_char7) ;
      lsd_reg2lsd_reg4wc_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = "|||||||||||||||||||||||||"+GXt_char6+"|"+((0==AV33TFLSD4CantidadAdherentes_69_2) ? "" : GXutil.str( AV33TFLSD4CantidadAdherentes_69_2, 2, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLSD4AporteAdicionalOS_71_15)==0) ? "" : GXutil.str( AV35TFLSD4AporteAdicionalOS_71_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLSD4ContribucionAdicionalOS_86_15)==0) ? "" : GXutil.str( AV37TFLSD4ContribucionAdicionalOS_86_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15)==0) ? "" : GXutil.str( AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15)==0) ? "" : GXutil.str( AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLSD4BaseCalculoDiferencialLRT_131_15)==0) ? "" : GXutil.str( AV43TFLSD4BaseCalculoDiferencialLRT_131_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFLSD4RemuneracionMaternidadANSeS_146_15)==0) ? "" : GXutil.str( AV45TFLSD4RemuneracionMaternidadANSeS_146_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFLSD4RemuneracionBruta_161_15)==0) ? "" : GXutil.str( AV47TFLSD4RemuneracionBruta_161_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFLSD4BaseImponible1_176_15)==0) ? "" : GXutil.str( AV49TFLSD4BaseImponible1_176_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLSD4BaseImponible2_191_15)==0) ? "" : GXutil.str( AV51TFLSD4BaseImponible2_191_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLSD4BaseImponible3_206_15)==0) ? "" : GXutil.str( AV53TFLSD4BaseImponible3_206_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLSD4BaseImponible4_221_15)==0) ? "" : GXutil.str( AV55TFLSD4BaseImponible4_221_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLSD4BaseImponible5_236_15)==0) ? "" : GXutil.str( AV57TFLSD4BaseImponible5_236_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLSD4BaseImponible6_251_15)==0) ? "" : GXutil.str( AV59TFLSD4BaseImponible6_251_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLSD4BaseImponible7_266_15)==0) ? "" : GXutil.str( AV61TFLSD4BaseImponible7_266_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLSD4BaseImponible8_281_15)==0) ? "" : GXutil.str( AV63TFLSD4BaseImponible8_281_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLSD4BaseImponible9_296_15)==0) ? "" : GXutil.str( AV65TFLSD4BaseImponible9_296_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLSD4BaseDifApoSegSoc_311_15)==0) ? "" : GXutil.str( AV67TFLSD4BaseDifApoSegSoc_311_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFLSD4BaseDifContSegSoc_326_15)==0) ? "" : GXutil.str( AV69TFLSD4BaseDifContSegSoc_326_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLSD4BaseImponible10_341_15)==0) ? "" : GXutil.str( AV71TFLSD4BaseImponible10_341_15, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLSD4ImporteADetraer_356_15)==0) ? "" : GXutil.str( AV73TFLSD4ImporteADetraer_356_15, 16, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||||||||||||||||||||||"+((0==AV34TFLSD4CantidadAdherentes_69_2_To) ? "" : GXutil.str( AV34TFLSD4CantidadAdherentes_69_2_To, 2, 0))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLSD4AporteAdicionalOS_71_15_To)==0) ? "" : GXutil.str( AV36TFLSD4AporteAdicionalOS_71_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLSD4ContribucionAdicionalOS_86_15_To)==0) ? "" : GXutil.str( AV38TFLSD4ContribucionAdicionalOS_86_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To)==0) ? "" : GXutil.str( AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To)==0) ? "" : GXutil.str( AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To)==0) ? "" : GXutil.str( AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To)==0) ? "" : GXutil.str( AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFLSD4RemuneracionBruta_161_15_To)==0) ? "" : GXutil.str( AV48TFLSD4RemuneracionBruta_161_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLSD4BaseImponible1_176_15_To)==0) ? "" : GXutil.str( AV50TFLSD4BaseImponible1_176_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLSD4BaseImponible2_191_15_To)==0) ? "" : GXutil.str( AV52TFLSD4BaseImponible2_191_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLSD4BaseImponible3_206_15_To)==0) ? "" : GXutil.str( AV54TFLSD4BaseImponible3_206_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLSD4BaseImponible4_221_15_To)==0) ? "" : GXutil.str( AV56TFLSD4BaseImponible4_221_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLSD4BaseImponible5_236_15_To)==0) ? "" : GXutil.str( AV58TFLSD4BaseImponible5_236_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLSD4BaseImponible6_251_15_To)==0) ? "" : GXutil.str( AV60TFLSD4BaseImponible6_251_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLSD4BaseImponible7_266_15_To)==0) ? "" : GXutil.str( AV62TFLSD4BaseImponible7_266_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLSD4BaseImponible8_281_15_To)==0) ? "" : GXutil.str( AV64TFLSD4BaseImponible8_281_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLSD4BaseImponible9_296_15_To)==0) ? "" : GXutil.str( AV66TFLSD4BaseImponible9_296_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLSD4BaseDifApoSegSoc_311_15_To)==0) ? "" : GXutil.str( AV68TFLSD4BaseDifApoSegSoc_311_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLSD4BaseDifContSegSoc_326_15_To)==0) ? "" : GXutil.str( AV70TFLSD4BaseDifContSegSoc_326_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLSD4BaseImponible10_341_15_To)==0) ? "" : GXutil.str( AV72TFLSD4BaseImponible10_341_15_To, 16, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV74TFLSD4ImporteADetraer_356_15_To)==0) ? "" : GXutil.str( AV74TFLSD4ImporteADetraer_356_15_To, 16, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV15GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV15GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV15GridState.fromxml(AV19Session.getValue(AV83Pgmname+"GridState"), null, null);
      AV15GridState.setgxTv_SdtWWPGridState_Orderedby( AV17OrderedBy );
      AV15GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV18OrderedDsc );
      AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4CODIGOOBRASOCIAL_63_6", httpContext.getMessage( "Obra social", ""), !(GXutil.strcmp("", AV31TFLSD4CodigoObraSocial_63_6)==0), (short)(0), AV31TFLSD4CodigoObraSocial_63_6, "", !(AV32TFLSD4CodigoObraSocial_63_6_Sels.size()==0), AV32TFLSD4CodigoObraSocial_63_6_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4CANTIDADADHERENTES_69_2", httpContext.getMessage( "Adherentes", ""), !((0==AV33TFLSD4CantidadAdherentes_69_2)&&(0==AV34TFLSD4CantidadAdherentes_69_2_To)), (short)(0), GXutil.trim( GXutil.str( AV33TFLSD4CantidadAdherentes_69_2, 2, 0)), GXutil.trim( GXutil.str( AV34TFLSD4CantidadAdherentes_69_2_To, 2, 0))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4APORTEADICIONALOS_71_15", httpContext.getMessage( "Apo. adic. OS", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLSD4AporteAdicionalOS_71_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLSD4AporteAdicionalOS_71_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV35TFLSD4AporteAdicionalOS_71_15, 16, 2)), GXutil.trim( GXutil.str( AV36TFLSD4AporteAdicionalOS_71_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4CONTRIBUCIONADICIONALOS_86_15", httpContext.getMessage( "Contr. adic. OS", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLSD4ContribucionAdicionalOS_86_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLSD4ContribucionAdicionalOS_86_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV37TFLSD4ContribucionAdicionalOS_86_15, 16, 2)), GXutil.trim( GXutil.str( AV38TFLSD4ContribucionAdicionalOS_86_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15", httpContext.getMessage( "Base calc. dif. apo. OS y FSR", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, 16, 2)), GXutil.trim( GXutil.str( AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASECALCULODIFERENCIALOSYFSR_116_15", httpContext.getMessage( "Base calc. Dif. OS y FSR", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15, 16, 2)), GXutil.trim( GXutil.str( AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASECALCULODIFERENCIALLRT_131_15", httpContext.getMessage( "Base calc. dif. LRT", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLSD4BaseCalculoDiferencialLRT_131_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV43TFLSD4BaseCalculoDiferencialLRT_131_15, 16, 2)), GXutil.trim( GXutil.str( AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4REMUNERACIONMATERNIDADANSES_146_15", httpContext.getMessage( "Maternidad", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFLSD4RemuneracionMaternidadANSeS_146_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV45TFLSD4RemuneracionMaternidadANSeS_146_15, 16, 2)), GXutil.trim( GXutil.str( AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4REMUNERACIONBRUTA_161_15", httpContext.getMessage( "Bruto", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFLSD4RemuneracionBruta_161_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFLSD4RemuneracionBruta_161_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV47TFLSD4RemuneracionBruta_161_15, 16, 2)), GXutil.trim( GXutil.str( AV48TFLSD4RemuneracionBruta_161_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE1_176_15", httpContext.getMessage( "Base imp. 1", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFLSD4BaseImponible1_176_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLSD4BaseImponible1_176_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV49TFLSD4BaseImponible1_176_15, 16, 2)), GXutil.trim( GXutil.str( AV50TFLSD4BaseImponible1_176_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE2_191_15", httpContext.getMessage( "Base imp. 2", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLSD4BaseImponible2_191_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLSD4BaseImponible2_191_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV51TFLSD4BaseImponible2_191_15, 16, 2)), GXutil.trim( GXutil.str( AV52TFLSD4BaseImponible2_191_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE3_206_15", httpContext.getMessage( "Base imp. 3", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLSD4BaseImponible3_206_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLSD4BaseImponible3_206_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV53TFLSD4BaseImponible3_206_15, 16, 2)), GXutil.trim( GXutil.str( AV54TFLSD4BaseImponible3_206_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE4_221_15", httpContext.getMessage( "Base imp. 4", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLSD4BaseImponible4_221_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLSD4BaseImponible4_221_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV55TFLSD4BaseImponible4_221_15, 16, 2)), GXutil.trim( GXutil.str( AV56TFLSD4BaseImponible4_221_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE5_236_15", httpContext.getMessage( "Base imp. 5", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLSD4BaseImponible5_236_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLSD4BaseImponible5_236_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV57TFLSD4BaseImponible5_236_15, 16, 2)), GXutil.trim( GXutil.str( AV58TFLSD4BaseImponible5_236_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE6_251_15", httpContext.getMessage( "Base imp. 6", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLSD4BaseImponible6_251_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLSD4BaseImponible6_251_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV59TFLSD4BaseImponible6_251_15, 16, 2)), GXutil.trim( GXutil.str( AV60TFLSD4BaseImponible6_251_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE7_266_15", httpContext.getMessage( "Base imp. 7", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLSD4BaseImponible7_266_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLSD4BaseImponible7_266_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV61TFLSD4BaseImponible7_266_15, 16, 2)), GXutil.trim( GXutil.str( AV62TFLSD4BaseImponible7_266_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE8_281_15", httpContext.getMessage( "Base imp. 8", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLSD4BaseImponible8_281_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLSD4BaseImponible8_281_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV63TFLSD4BaseImponible8_281_15, 16, 2)), GXutil.trim( GXutil.str( AV64TFLSD4BaseImponible8_281_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE9_296_15", httpContext.getMessage( "Base imp. 9", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLSD4BaseImponible9_296_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLSD4BaseImponible9_296_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV65TFLSD4BaseImponible9_296_15, 16, 2)), GXutil.trim( GXutil.str( AV66TFLSD4BaseImponible9_296_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEDIFAPOSEGSOC_311_15", httpContext.getMessage( "Base dif. apo. SS", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLSD4BaseDifApoSegSoc_311_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLSD4BaseDifApoSegSoc_311_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV67TFLSD4BaseDifApoSegSoc_311_15, 16, 2)), GXutil.trim( GXutil.str( AV68TFLSD4BaseDifApoSegSoc_311_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEDIFCONTSEGSOC_326_15", httpContext.getMessage( "Base dif. cont. SS", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFLSD4BaseDifContSegSoc_326_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLSD4BaseDifContSegSoc_326_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV69TFLSD4BaseDifContSegSoc_326_15, 16, 2)), GXutil.trim( GXutil.str( AV70TFLSD4BaseDifContSegSoc_326_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4BASEIMPONIBLE10_341_15", httpContext.getMessage( "Base imp. 10", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLSD4BaseImponible10_341_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLSD4BaseImponible10_341_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV71TFLSD4BaseImponible10_341_15, 16, 2)), GXutil.trim( GXutil.str( AV72TFLSD4BaseImponible10_341_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLSD4IMPORTEADETRAER_356_15", httpContext.getMessage( "Importe a detraer", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLSD4ImporteADetraer_356_15)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV74TFLSD4ImporteADetraer_356_15_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV73TFLSD4ImporteADetraer_356_15, 16, 2)), GXutil.trim( GXutil.str( AV74TFLSD4ImporteADetraer_356_15_To, 16, 2))) ;
      AV15GridState = GXv_SdtWWPGridState10[0] ;
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
      if ( ! (0==AV10LSDSec) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LSDSEC" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV10LSDSec, 8, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      if ( ! (0==AV11LSD2Sec) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LSD2SEC" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV11LSD2Sec, 8, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      AV15GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV83Pgmname+"GridState", AV15GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV13TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV83Pgmname );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV12HTTPRequest.getScriptName()+"?"+AV12HTTPRequest.getQuerystring() );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LSD_reg4" );
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LSDSec" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV10LSDSec, 8, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LSD2Sec" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV11LSD2Sec, 8, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV19Session.setValue("TrnContext", AV13TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      AV10LSDSec = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LSDSec), 8, 0));
      AV11LSD2Sec = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LSD2Sec), 8, 0));
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
      paHP2( ) ;
      wsHP2( ) ;
      weHP2( ) ;
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
      sCtrlAV10LSDSec = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV11LSD2Sec = (String)getParm(obj,3,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paHP2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "lsd_reg2lsd_reg4wc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paHP2( ) ;
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
         AV10LSDSec = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LSDSec), 8, 0));
         AV11LSD2Sec = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LSD2Sec), 8, 0));
      }
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10LSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV11LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11LSD2Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( AV10LSDSec != wcpOAV10LSDSec ) || ( AV11LSD2Sec != wcpOAV11LSD2Sec ) ) )
      {
         setjustcreated();
      }
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV10LSDSec = AV10LSDSec ;
      wcpOAV11LSD2Sec = AV11LSD2Sec ;
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
      sCtrlAV10LSDSec = httpContext.cgiGet( sPrefix+"AV10LSDSec_CTRL") ;
      if ( GXutil.len( sCtrlAV10LSDSec) > 0 )
      {
         AV10LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV10LSDSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LSDSec), 8, 0));
      }
      else
      {
         AV10LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV10LSDSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV11LSD2Sec = httpContext.cgiGet( sPrefix+"AV11LSD2Sec_CTRL") ;
      if ( GXutil.len( sCtrlAV11LSD2Sec) > 0 )
      {
         AV11LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV11LSD2Sec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LSD2Sec), 8, 0));
      }
      else
      {
         AV11LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV11LSD2Sec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paHP2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsHP2( ) ;
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
      wsHP2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LSDSec_PARM", GXutil.ltrim( localUtil.ntoc( AV10LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10LSDSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LSDSec_CTRL", GXutil.rtrim( sCtrlAV10LSDSec));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11LSD2Sec_PARM", GXutil.ltrim( localUtil.ntoc( AV11LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11LSD2Sec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11LSD2Sec_CTRL", GXutil.rtrim( sCtrlAV11LSD2Sec));
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
      weHP2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020261993", true, true);
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
      httpContext.AddJavascriptSource("lsd_reg2lsd_reg4wc.js", "?2024122020261993", false, true);
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

   public void subsflControlProps_262( )
   {
      edtLSD4Sec_Internalname = sPrefix+"LSD4SEC_"+sGXsfl_26_idx ;
      edtLSD4CUIL_3_11_Internalname = sPrefix+"LSD4CUIL_3_11_"+sGXsfl_26_idx ;
      edtLSD4Conyuge_14_1_Internalname = sPrefix+"LSD4CONYUGE_14_1_"+sGXsfl_26_idx ;
      edtLSD4CantidadHijos_15_2_Internalname = sPrefix+"LSD4CANTIDADHIJOS_15_2_"+sGXsfl_26_idx ;
      edtLSD4MarcaCCT_17_1_Internalname = sPrefix+"LSD4MARCACCT_17_1_"+sGXsfl_26_idx ;
      edtLSD4MarcaSCVO_18_1_Internalname = sPrefix+"LSD4MARCASCVO_18_1_"+sGXsfl_26_idx ;
      edtLSD4MarcaReduccion_19_1_Internalname = sPrefix+"LSD4MARCAREDUCCION_19_1_"+sGXsfl_26_idx ;
      edtLSD4TipoEmpresa_20_1_Internalname = sPrefix+"LSD4TIPOEMPRESA_20_1_"+sGXsfl_26_idx ;
      edtLSD4TipoOperacion_21_1_Internalname = sPrefix+"LSD4TIPOOPERACION_21_1_"+sGXsfl_26_idx ;
      edtLSD4CodigoSituacion_22_2_Internalname = sPrefix+"LSD4CODIGOSITUACION_22_2_"+sGXsfl_26_idx ;
      edtLSD4CodigoCondicion_24_2_Internalname = sPrefix+"LSD4CODIGOCONDICION_24_2_"+sGXsfl_26_idx ;
      edtLSD4CodigoActividad_26_3_Internalname = sPrefix+"LSD4CODIGOACTIVIDAD_26_3_"+sGXsfl_26_idx ;
      edtLSD4CodigoModalidadContratacio_Internalname = sPrefix+"LSD4CODIGOMODALIDADCONTRATACIO_"+sGXsfl_26_idx ;
      edtLSD4CodigoSiniestrado_32_2_Internalname = sPrefix+"LSD4CODIGOSINIESTRADO_32_2_"+sGXsfl_26_idx ;
      edtLSD4CodigoLocalidad_34_2_Internalname = sPrefix+"LSD4CODIGOLOCALIDAD_34_2_"+sGXsfl_26_idx ;
      edtLSD4SituacionRevista1_36_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA1_36_2_"+sGXsfl_26_idx ;
      edtLSD4DiaInicioSituacionRevista1_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA1_"+sGXsfl_26_idx ;
      edtLSD4SituacionRevista2_40_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA2_40_2_"+sGXsfl_26_idx ;
      edtLSD4DiaInicioSituacionRevista2_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA2_"+sGXsfl_26_idx ;
      edtLSD4SituacionRevista3_44_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA3_44_2_"+sGXsfl_26_idx ;
      edtLSD4DiaInicioSituacionRevista3_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA3_"+sGXsfl_26_idx ;
      edtLSD4CantidadDiasTrabajados_48__Internalname = sPrefix+"LSD4CANTIDADDIASTRABAJADOS_48__"+sGXsfl_26_idx ;
      edtLSD4HorasTrabajadas_50_3_Internalname = sPrefix+"LSD4HORASTRABAJADAS_50_3_"+sGXsfl_26_idx ;
      edtLSD4PorcentajeAporteAdicionalS_Internalname = sPrefix+"LSD4PORCENTAJEAPORTEADICIONALS_"+sGXsfl_26_idx ;
      edtLSD4ContribucionTareaDiferenci_Internalname = sPrefix+"LSD4CONTRIBUCIONTAREADIFERENCI_"+sGXsfl_26_idx ;
      edtLSD4CodigoObraSocial_63_6_Internalname = sPrefix+"LSD4CODIGOOBRASOCIAL_63_6_"+sGXsfl_26_idx ;
      edtLSD4CantidadAdherentes_69_2_Internalname = sPrefix+"LSD4CANTIDADADHERENTES_69_2_"+sGXsfl_26_idx ;
      edtLSD4AporteAdicionalOS_71_15_Internalname = sPrefix+"LSD4APORTEADICIONALOS_71_15_"+sGXsfl_26_idx ;
      edtLSD4ContribucionAdicionalOS_86_Internalname = sPrefix+"LSD4CONTRIBUCIONADICIONALOS_86_"+sGXsfl_26_idx ;
      edtLSD4BaseCalculoDiferencialApor_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALAPOR_"+sGXsfl_26_idx ;
      edtLSD4BaseCalculoDiferencialOSyF_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALOSYF_"+sGXsfl_26_idx ;
      edtLSD4BaseCalculoDiferencialLRT__Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALLRT__"+sGXsfl_26_idx ;
      edtLSD4RemuneracionMaternidadANSe_Internalname = sPrefix+"LSD4REMUNERACIONMATERNIDADANSE_"+sGXsfl_26_idx ;
      edtLSD4RemuneracionBruta_161_15_Internalname = sPrefix+"LSD4REMUNERACIONBRUTA_161_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible1_176_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE1_176_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible2_191_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE2_191_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible3_206_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE3_206_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible4_221_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE4_221_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible5_236_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE5_236_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible6_251_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE6_251_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible7_266_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE7_266_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible8_281_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE8_281_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible9_296_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE9_296_15_"+sGXsfl_26_idx ;
      edtLSD4BaseDifApoSegSoc_311_15_Internalname = sPrefix+"LSD4BASEDIFAPOSEGSOC_311_15_"+sGXsfl_26_idx ;
      edtLSD4BaseDifContSegSoc_326_15_Internalname = sPrefix+"LSD4BASEDIFCONTSEGSOC_326_15_"+sGXsfl_26_idx ;
      edtLSD4BaseImponible10_341_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE10_341_15_"+sGXsfl_26_idx ;
      edtLSD4ImporteADetraer_356_15_Internalname = sPrefix+"LSD4IMPORTEADETRAER_356_15_"+sGXsfl_26_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_26_idx ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG_"+sGXsfl_26_idx ;
      edtavEliminarsvg_Internalname = sPrefix+"vELIMINARSVG_"+sGXsfl_26_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_26_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_26_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_26_idx ;
   }

   public void subsflControlProps_fel_262( )
   {
      edtLSD4Sec_Internalname = sPrefix+"LSD4SEC_"+sGXsfl_26_fel_idx ;
      edtLSD4CUIL_3_11_Internalname = sPrefix+"LSD4CUIL_3_11_"+sGXsfl_26_fel_idx ;
      edtLSD4Conyuge_14_1_Internalname = sPrefix+"LSD4CONYUGE_14_1_"+sGXsfl_26_fel_idx ;
      edtLSD4CantidadHijos_15_2_Internalname = sPrefix+"LSD4CANTIDADHIJOS_15_2_"+sGXsfl_26_fel_idx ;
      edtLSD4MarcaCCT_17_1_Internalname = sPrefix+"LSD4MARCACCT_17_1_"+sGXsfl_26_fel_idx ;
      edtLSD4MarcaSCVO_18_1_Internalname = sPrefix+"LSD4MARCASCVO_18_1_"+sGXsfl_26_fel_idx ;
      edtLSD4MarcaReduccion_19_1_Internalname = sPrefix+"LSD4MARCAREDUCCION_19_1_"+sGXsfl_26_fel_idx ;
      edtLSD4TipoEmpresa_20_1_Internalname = sPrefix+"LSD4TIPOEMPRESA_20_1_"+sGXsfl_26_fel_idx ;
      edtLSD4TipoOperacion_21_1_Internalname = sPrefix+"LSD4TIPOOPERACION_21_1_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoSituacion_22_2_Internalname = sPrefix+"LSD4CODIGOSITUACION_22_2_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoCondicion_24_2_Internalname = sPrefix+"LSD4CODIGOCONDICION_24_2_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoActividad_26_3_Internalname = sPrefix+"LSD4CODIGOACTIVIDAD_26_3_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoModalidadContratacio_Internalname = sPrefix+"LSD4CODIGOMODALIDADCONTRATACIO_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoSiniestrado_32_2_Internalname = sPrefix+"LSD4CODIGOSINIESTRADO_32_2_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoLocalidad_34_2_Internalname = sPrefix+"LSD4CODIGOLOCALIDAD_34_2_"+sGXsfl_26_fel_idx ;
      edtLSD4SituacionRevista1_36_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA1_36_2_"+sGXsfl_26_fel_idx ;
      edtLSD4DiaInicioSituacionRevista1_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA1_"+sGXsfl_26_fel_idx ;
      edtLSD4SituacionRevista2_40_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA2_40_2_"+sGXsfl_26_fel_idx ;
      edtLSD4DiaInicioSituacionRevista2_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA2_"+sGXsfl_26_fel_idx ;
      edtLSD4SituacionRevista3_44_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA3_44_2_"+sGXsfl_26_fel_idx ;
      edtLSD4DiaInicioSituacionRevista3_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA3_"+sGXsfl_26_fel_idx ;
      edtLSD4CantidadDiasTrabajados_48__Internalname = sPrefix+"LSD4CANTIDADDIASTRABAJADOS_48__"+sGXsfl_26_fel_idx ;
      edtLSD4HorasTrabajadas_50_3_Internalname = sPrefix+"LSD4HORASTRABAJADAS_50_3_"+sGXsfl_26_fel_idx ;
      edtLSD4PorcentajeAporteAdicionalS_Internalname = sPrefix+"LSD4PORCENTAJEAPORTEADICIONALS_"+sGXsfl_26_fel_idx ;
      edtLSD4ContribucionTareaDiferenci_Internalname = sPrefix+"LSD4CONTRIBUCIONTAREADIFERENCI_"+sGXsfl_26_fel_idx ;
      edtLSD4CodigoObraSocial_63_6_Internalname = sPrefix+"LSD4CODIGOOBRASOCIAL_63_6_"+sGXsfl_26_fel_idx ;
      edtLSD4CantidadAdherentes_69_2_Internalname = sPrefix+"LSD4CANTIDADADHERENTES_69_2_"+sGXsfl_26_fel_idx ;
      edtLSD4AporteAdicionalOS_71_15_Internalname = sPrefix+"LSD4APORTEADICIONALOS_71_15_"+sGXsfl_26_fel_idx ;
      edtLSD4ContribucionAdicionalOS_86_Internalname = sPrefix+"LSD4CONTRIBUCIONADICIONALOS_86_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseCalculoDiferencialApor_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALAPOR_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseCalculoDiferencialOSyF_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALOSYF_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseCalculoDiferencialLRT__Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALLRT__"+sGXsfl_26_fel_idx ;
      edtLSD4RemuneracionMaternidadANSe_Internalname = sPrefix+"LSD4REMUNERACIONMATERNIDADANSE_"+sGXsfl_26_fel_idx ;
      edtLSD4RemuneracionBruta_161_15_Internalname = sPrefix+"LSD4REMUNERACIONBRUTA_161_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible1_176_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE1_176_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible2_191_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE2_191_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible3_206_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE3_206_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible4_221_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE4_221_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible5_236_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE5_236_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible6_251_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE6_251_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible7_266_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE7_266_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible8_281_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE8_281_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible9_296_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE9_296_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseDifApoSegSoc_311_15_Internalname = sPrefix+"LSD4BASEDIFAPOSEGSOC_311_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseDifContSegSoc_326_15_Internalname = sPrefix+"LSD4BASEDIFCONTSEGSOC_326_15_"+sGXsfl_26_fel_idx ;
      edtLSD4BaseImponible10_341_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE10_341_15_"+sGXsfl_26_fel_idx ;
      edtLSD4ImporteADetraer_356_15_Internalname = sPrefix+"LSD4IMPORTEADETRAER_356_15_"+sGXsfl_26_fel_idx ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG_"+sGXsfl_26_fel_idx ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG_"+sGXsfl_26_fel_idx ;
      edtavEliminarsvg_Internalname = sPrefix+"vELIMINARSVG_"+sGXsfl_26_fel_idx ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE_"+sGXsfl_26_fel_idx ;
      edtavDelete_Internalname = sPrefix+"vDELETE_"+sGXsfl_26_fel_idx ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY_"+sGXsfl_26_fel_idx ;
   }

   public void sendrow_262( )
   {
      subsflControlProps_262( ) ;
      wbHP0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_26_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_26_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_26_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4Sec_Internalname,GXutil.ltrim( localUtil.ntoc( A1674LSD4Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1674LSD4Sec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4Sec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CUIL_3_11_Internalname,GXutil.ltrim( localUtil.ntoc( A1675LSD4CUIL_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1675LSD4CUIL_3_11), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CUIL_3_11_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4Conyuge_14_1_Internalname,GXutil.rtrim( A1676LSD4Conyuge_14_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4Conyuge_14_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CantidadHijos_15_2_Internalname,GXutil.ltrim( localUtil.ntoc( A1677LSD4CantidadHijos_15_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1677LSD4CantidadHijos_15_2), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CantidadHijos_15_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4MarcaCCT_17_1_Internalname,GXutil.rtrim( A1678LSD4MarcaCCT_17_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4MarcaCCT_17_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4MarcaSCVO_18_1_Internalname,GXutil.rtrim( A1679LSD4MarcaSCVO_18_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4MarcaSCVO_18_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4MarcaReduccion_19_1_Internalname,GXutil.rtrim( A1680LSD4MarcaReduccion_19_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4MarcaReduccion_19_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4TipoEmpresa_20_1_Internalname,GXutil.rtrim( A1681LSD4TipoEmpresa_20_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4TipoEmpresa_20_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4TipoOperacion_21_1_Internalname,GXutil.rtrim( A1682LSD4TipoOperacion_21_1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4TipoOperacion_21_1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoSituacion_22_2_Internalname,GXutil.rtrim( A1683LSD4CodigoSituacion_22_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoSituacion_22_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoCondicion_24_2_Internalname,GXutil.rtrim( A1684LSD4CodigoCondicion_24_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoCondicion_24_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoActividad_26_3_Internalname,GXutil.rtrim( A1685LSD4CodigoActividad_26_3),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoActividad_26_3_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoModalidadContratacio_Internalname,GXutil.rtrim( A1686LSD4CodigoModalidadContratacio),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoModalidadContratacio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoSiniestrado_32_2_Internalname,GXutil.rtrim( A1687LSD4CodigoSiniestrado_32_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoSiniestrado_32_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoLocalidad_34_2_Internalname,GXutil.rtrim( A1688LSD4CodigoLocalidad_34_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoLocalidad_34_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4SituacionRevista1_36_2_Internalname,GXutil.rtrim( A1689LSD4SituacionRevista1_36_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4SituacionRevista1_36_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4DiaInicioSituacionRevista1_Internalname,GXutil.rtrim( A1690LSD4DiaInicioSituacionRevista1),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4DiaInicioSituacionRevista1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4SituacionRevista2_40_2_Internalname,GXutil.rtrim( A1691LSD4SituacionRevista2_40_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4SituacionRevista2_40_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4DiaInicioSituacionRevista2_Internalname,GXutil.rtrim( A1692LSD4DiaInicioSituacionRevista2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4DiaInicioSituacionRevista2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4SituacionRevista3_44_2_Internalname,GXutil.rtrim( A1693LSD4SituacionRevista3_44_2),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4SituacionRevista3_44_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4DiaInicioSituacionRevista3_Internalname,GXutil.rtrim( A1694LSD4DiaInicioSituacionRevista3),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4DiaInicioSituacionRevista3_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CantidadDiasTrabajados_48__Internalname,GXutil.ltrim( localUtil.ntoc( A1695LSD4CantidadDiasTrabajados_48_, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1695LSD4CantidadDiasTrabajados_48_), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CantidadDiasTrabajados_48__Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4HorasTrabajadas_50_3_Internalname,GXutil.ltrim( localUtil.ntoc( A1696LSD4HorasTrabajadas_50_3, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1696LSD4HorasTrabajadas_50_3), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4HorasTrabajadas_50_3_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4PorcentajeAporteAdicionalS_Internalname,GXutil.ltrim( localUtil.ntoc( A1697LSD4PorcentajeAporteAdicionalS, (byte)(8), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1697LSD4PorcentajeAporteAdicionalS, "ZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4PorcentajeAporteAdicionalS_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4ContribucionTareaDiferenci_Internalname,GXutil.ltrim( localUtil.ntoc( A1698LSD4ContribucionTareaDiferenci, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1698LSD4ContribucionTareaDiferenci, "ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4ContribucionTareaDiferenci_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CodigoObraSocial_63_6_Internalname,GXutil.rtrim( A1699LSD4CodigoObraSocial_63_6),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CodigoObraSocial_63_6_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4CantidadAdherentes_69_2_Internalname,GXutil.ltrim( localUtil.ntoc( A1700LSD4CantidadAdherentes_69_2, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1700LSD4CantidadAdherentes_69_2), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4CantidadAdherentes_69_2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4AporteAdicionalOS_71_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1701LSD4AporteAdicionalOS_71_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1701LSD4AporteAdicionalOS_71_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4AporteAdicionalOS_71_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4ContribucionAdicionalOS_86_Internalname,GXutil.ltrim( localUtil.ntoc( A1702LSD4ContribucionAdicionalOS_86, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1702LSD4ContribucionAdicionalOS_86, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4ContribucionAdicionalOS_86_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseCalculoDiferencialApor_Internalname,GXutil.ltrim( localUtil.ntoc( A1703LSD4BaseCalculoDiferencialApor, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1703LSD4BaseCalculoDiferencialApor, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseCalculoDiferencialApor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseCalculoDiferencialOSyF_Internalname,GXutil.ltrim( localUtil.ntoc( A1704LSD4BaseCalculoDiferencialOSyF, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1704LSD4BaseCalculoDiferencialOSyF, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseCalculoDiferencialOSyF_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseCalculoDiferencialLRT__Internalname,GXutil.ltrim( localUtil.ntoc( A1705LSD4BaseCalculoDiferencialLRT_, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1705LSD4BaseCalculoDiferencialLRT_, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseCalculoDiferencialLRT__Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4RemuneracionMaternidadANSe_Internalname,GXutil.ltrim( localUtil.ntoc( A1706LSD4RemuneracionMaternidadANSe, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1706LSD4RemuneracionMaternidadANSe, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4RemuneracionMaternidadANSe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4RemuneracionBruta_161_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1707LSD4RemuneracionBruta_161_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1707LSD4RemuneracionBruta_161_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4RemuneracionBruta_161_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible1_176_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1708LSD4BaseImponible1_176_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1708LSD4BaseImponible1_176_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible1_176_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible2_191_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1709LSD4BaseImponible2_191_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1709LSD4BaseImponible2_191_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible2_191_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible3_206_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1710LSD4BaseImponible3_206_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1710LSD4BaseImponible3_206_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible3_206_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible4_221_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1711LSD4BaseImponible4_221_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1711LSD4BaseImponible4_221_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible4_221_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible5_236_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1712LSD4BaseImponible5_236_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1712LSD4BaseImponible5_236_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible5_236_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible6_251_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1713LSD4BaseImponible6_251_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1713LSD4BaseImponible6_251_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible6_251_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible7_266_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1714LSD4BaseImponible7_266_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1714LSD4BaseImponible7_266_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible7_266_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible8_281_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1715LSD4BaseImponible8_281_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1715LSD4BaseImponible8_281_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible8_281_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible9_296_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1716LSD4BaseImponible9_296_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1716LSD4BaseImponible9_296_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible9_296_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseDifApoSegSoc_311_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1717LSD4BaseDifApoSegSoc_311_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1717LSD4BaseDifApoSegSoc_311_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseDifApoSegSoc_311_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseDifContSegSoc_326_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1718LSD4BaseDifContSegSoc_326_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1718LSD4BaseDifContSegSoc_326_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseDifContSegSoc_326_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4BaseImponible10_341_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1719LSD4BaseImponible10_341_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1719LSD4BaseImponible10_341_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4BaseImponible10_341_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLSD4ImporteADetraer_356_15_Internalname,GXutil.ltrim( localUtil.ntoc( A1720LSD4ImporteADetraer_356_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1720LSD4ImporteADetraer_356_15, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLSD4ImporteADetraer_356_15_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV75VerSVG),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(-1),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV76ModificarSVG),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(-1),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV77EliminarSVG),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV78Update),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV79Delete),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV80Display),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesHP2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_26_idx = ((subGrid_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      /* End function sendrow_262 */
   }

   public void startgridcontrol26( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"26\">") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Conyuge", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Hijos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "En convenio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "SCVO", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Reducc.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Empl.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo Ope.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Situación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Condición", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Actividad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Modalidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Siniestrado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Zona", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sit. 1", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sit. 1 ini.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sit. 2", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sit. 2 ini.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sit. 3", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sit. 3 ini.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días trab.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Horas trab.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Porc. adic. SS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contr. tarea dif.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obra social", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Adherentes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Apo. adic. OS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Contr. adic. OS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base calc. dif. apo. OS y FSR", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base calc. Dif. OS y FSR", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base calc. dif. LRT", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Maternidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Bruto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 1", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 2", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 3", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 4", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 5", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 6", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 7", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 8", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 9", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base dif. apo. SS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base dif. cont. SS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Base imp. 10", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe a detraer", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1674LSD4Sec, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1675LSD4CUIL_3_11, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1676LSD4Conyuge_14_1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1677LSD4CantidadHijos_15_2, (byte)(2), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1678LSD4MarcaCCT_17_1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1679LSD4MarcaSCVO_18_1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1680LSD4MarcaReduccion_19_1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1681LSD4TipoEmpresa_20_1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1682LSD4TipoOperacion_21_1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1683LSD4CodigoSituacion_22_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1684LSD4CodigoCondicion_24_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1685LSD4CodigoActividad_26_3));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1686LSD4CodigoModalidadContratacio));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1687LSD4CodigoSiniestrado_32_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1688LSD4CodigoLocalidad_34_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1689LSD4SituacionRevista1_36_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1690LSD4DiaInicioSituacionRevista1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1691LSD4SituacionRevista2_40_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1692LSD4DiaInicioSituacionRevista2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1693LSD4SituacionRevista3_44_2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1694LSD4DiaInicioSituacionRevista3));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1695LSD4CantidadDiasTrabajados_48_, (byte)(2), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1696LSD4HorasTrabajadas_50_3, (byte)(3), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1697LSD4PorcentajeAporteAdicionalS, (byte)(8), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1698LSD4ContribucionTareaDiferenci, (byte)(6), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1699LSD4CodigoObraSocial_63_6));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1700LSD4CantidadAdherentes_69_2, (byte)(2), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1701LSD4AporteAdicionalOS_71_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1702LSD4ContribucionAdicionalOS_86, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1703LSD4BaseCalculoDiferencialApor, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1704LSD4BaseCalculoDiferencialOSyF, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1705LSD4BaseCalculoDiferencialLRT_, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1706LSD4RemuneracionMaternidadANSe, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1707LSD4RemuneracionBruta_161_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1708LSD4BaseImponible1_176_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1709LSD4BaseImponible2_191_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1710LSD4BaseImponible3_206_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1711LSD4BaseImponible4_221_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1712LSD4BaseImponible5_236_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1713LSD4BaseImponible6_251_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1714LSD4BaseImponible7_266_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1715LSD4BaseImponible8_281_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1716LSD4BaseImponible9_296_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1717LSD4BaseDifApoSegSoc_311_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1718LSD4BaseDifContSegSoc_326_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1719LSD4BaseImponible10_341_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1720LSD4ImporteADetraer_356_15, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV75VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV76ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV77EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV78Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV79Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV80Display));
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
      bttBtninsert_Internalname = sPrefix+"BTNINSERT" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      edtLSD4Sec_Internalname = sPrefix+"LSD4SEC" ;
      edtLSD4CUIL_3_11_Internalname = sPrefix+"LSD4CUIL_3_11" ;
      edtLSD4Conyuge_14_1_Internalname = sPrefix+"LSD4CONYUGE_14_1" ;
      edtLSD4CantidadHijos_15_2_Internalname = sPrefix+"LSD4CANTIDADHIJOS_15_2" ;
      edtLSD4MarcaCCT_17_1_Internalname = sPrefix+"LSD4MARCACCT_17_1" ;
      edtLSD4MarcaSCVO_18_1_Internalname = sPrefix+"LSD4MARCASCVO_18_1" ;
      edtLSD4MarcaReduccion_19_1_Internalname = sPrefix+"LSD4MARCAREDUCCION_19_1" ;
      edtLSD4TipoEmpresa_20_1_Internalname = sPrefix+"LSD4TIPOEMPRESA_20_1" ;
      edtLSD4TipoOperacion_21_1_Internalname = sPrefix+"LSD4TIPOOPERACION_21_1" ;
      edtLSD4CodigoSituacion_22_2_Internalname = sPrefix+"LSD4CODIGOSITUACION_22_2" ;
      edtLSD4CodigoCondicion_24_2_Internalname = sPrefix+"LSD4CODIGOCONDICION_24_2" ;
      edtLSD4CodigoActividad_26_3_Internalname = sPrefix+"LSD4CODIGOACTIVIDAD_26_3" ;
      edtLSD4CodigoModalidadContratacio_Internalname = sPrefix+"LSD4CODIGOMODALIDADCONTRATACIO" ;
      edtLSD4CodigoSiniestrado_32_2_Internalname = sPrefix+"LSD4CODIGOSINIESTRADO_32_2" ;
      edtLSD4CodigoLocalidad_34_2_Internalname = sPrefix+"LSD4CODIGOLOCALIDAD_34_2" ;
      edtLSD4SituacionRevista1_36_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA1_36_2" ;
      edtLSD4DiaInicioSituacionRevista1_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA1" ;
      edtLSD4SituacionRevista2_40_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA2_40_2" ;
      edtLSD4DiaInicioSituacionRevista2_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA2" ;
      edtLSD4SituacionRevista3_44_2_Internalname = sPrefix+"LSD4SITUACIONREVISTA3_44_2" ;
      edtLSD4DiaInicioSituacionRevista3_Internalname = sPrefix+"LSD4DIAINICIOSITUACIONREVISTA3" ;
      edtLSD4CantidadDiasTrabajados_48__Internalname = sPrefix+"LSD4CANTIDADDIASTRABAJADOS_48_" ;
      edtLSD4HorasTrabajadas_50_3_Internalname = sPrefix+"LSD4HORASTRABAJADAS_50_3" ;
      edtLSD4PorcentajeAporteAdicionalS_Internalname = sPrefix+"LSD4PORCENTAJEAPORTEADICIONALS" ;
      edtLSD4ContribucionTareaDiferenci_Internalname = sPrefix+"LSD4CONTRIBUCIONTAREADIFERENCI" ;
      edtLSD4CodigoObraSocial_63_6_Internalname = sPrefix+"LSD4CODIGOOBRASOCIAL_63_6" ;
      edtLSD4CantidadAdherentes_69_2_Internalname = sPrefix+"LSD4CANTIDADADHERENTES_69_2" ;
      edtLSD4AporteAdicionalOS_71_15_Internalname = sPrefix+"LSD4APORTEADICIONALOS_71_15" ;
      edtLSD4ContribucionAdicionalOS_86_Internalname = sPrefix+"LSD4CONTRIBUCIONADICIONALOS_86" ;
      edtLSD4BaseCalculoDiferencialApor_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALAPOR" ;
      edtLSD4BaseCalculoDiferencialOSyF_Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALOSYF" ;
      edtLSD4BaseCalculoDiferencialLRT__Internalname = sPrefix+"LSD4BASECALCULODIFERENCIALLRT_" ;
      edtLSD4RemuneracionMaternidadANSe_Internalname = sPrefix+"LSD4REMUNERACIONMATERNIDADANSE" ;
      edtLSD4RemuneracionBruta_161_15_Internalname = sPrefix+"LSD4REMUNERACIONBRUTA_161_15" ;
      edtLSD4BaseImponible1_176_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE1_176_15" ;
      edtLSD4BaseImponible2_191_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE2_191_15" ;
      edtLSD4BaseImponible3_206_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE3_206_15" ;
      edtLSD4BaseImponible4_221_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE4_221_15" ;
      edtLSD4BaseImponible5_236_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE5_236_15" ;
      edtLSD4BaseImponible6_251_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE6_251_15" ;
      edtLSD4BaseImponible7_266_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE7_266_15" ;
      edtLSD4BaseImponible8_281_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE8_281_15" ;
      edtLSD4BaseImponible9_296_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE9_296_15" ;
      edtLSD4BaseDifApoSegSoc_311_15_Internalname = sPrefix+"LSD4BASEDIFAPOSEGSOC_311_15" ;
      edtLSD4BaseDifContSegSoc_326_15_Internalname = sPrefix+"LSD4BASEDIFCONTSEGSOC_326_15" ;
      edtLSD4BaseImponible10_341_15_Internalname = sPrefix+"LSD4BASEIMPONIBLE10_341_15" ;
      edtLSD4ImporteADetraer_356_15_Internalname = sPrefix+"LSD4IMPORTEADETRAER_356_15" ;
      edtavVersvg_Internalname = sPrefix+"vVERSVG" ;
      edtavModificarsvg_Internalname = sPrefix+"vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = sPrefix+"vELIMINARSVG" ;
      edtavUpdate_Internalname = sPrefix+"vUPDATE" ;
      edtavDelete_Internalname = sPrefix+"vDELETE" ;
      edtavDisplay_Internalname = sPrefix+"vDISPLAY" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLSDSec_Internalname = sPrefix+"LSDSEC" ;
      edtLSD2Sec_Internalname = sPrefix+"LSD2SEC" ;
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
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtavEliminarsvg_Jsonclick = "" ;
      edtavEliminarsvg_Link = "" ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavEliminarsvg_Format = (short)(0) ;
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 0 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtLSD4ImporteADetraer_356_15_Jsonclick = "" ;
      edtLSD4BaseImponible10_341_15_Jsonclick = "" ;
      edtLSD4BaseDifContSegSoc_326_15_Jsonclick = "" ;
      edtLSD4BaseDifApoSegSoc_311_15_Jsonclick = "" ;
      edtLSD4BaseImponible9_296_15_Jsonclick = "" ;
      edtLSD4BaseImponible8_281_15_Jsonclick = "" ;
      edtLSD4BaseImponible7_266_15_Jsonclick = "" ;
      edtLSD4BaseImponible6_251_15_Jsonclick = "" ;
      edtLSD4BaseImponible5_236_15_Jsonclick = "" ;
      edtLSD4BaseImponible4_221_15_Jsonclick = "" ;
      edtLSD4BaseImponible3_206_15_Jsonclick = "" ;
      edtLSD4BaseImponible2_191_15_Jsonclick = "" ;
      edtLSD4BaseImponible1_176_15_Jsonclick = "" ;
      edtLSD4RemuneracionBruta_161_15_Jsonclick = "" ;
      edtLSD4RemuneracionMaternidadANSe_Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialLRT__Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialOSyF_Jsonclick = "" ;
      edtLSD4BaseCalculoDiferencialApor_Jsonclick = "" ;
      edtLSD4ContribucionAdicionalOS_86_Jsonclick = "" ;
      edtLSD4AporteAdicionalOS_71_15_Jsonclick = "" ;
      edtLSD4CantidadAdherentes_69_2_Jsonclick = "" ;
      edtLSD4CodigoObraSocial_63_6_Jsonclick = "" ;
      edtLSD4ContribucionTareaDiferenci_Jsonclick = "" ;
      edtLSD4PorcentajeAporteAdicionalS_Jsonclick = "" ;
      edtLSD4HorasTrabajadas_50_3_Jsonclick = "" ;
      edtLSD4CantidadDiasTrabajados_48__Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista3_Jsonclick = "" ;
      edtLSD4SituacionRevista3_44_2_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista2_Jsonclick = "" ;
      edtLSD4SituacionRevista2_40_2_Jsonclick = "" ;
      edtLSD4DiaInicioSituacionRevista1_Jsonclick = "" ;
      edtLSD4SituacionRevista1_36_2_Jsonclick = "" ;
      edtLSD4CodigoLocalidad_34_2_Jsonclick = "" ;
      edtLSD4CodigoSiniestrado_32_2_Jsonclick = "" ;
      edtLSD4CodigoModalidadContratacio_Jsonclick = "" ;
      edtLSD4CodigoActividad_26_3_Jsonclick = "" ;
      edtLSD4CodigoCondicion_24_2_Jsonclick = "" ;
      edtLSD4CodigoSituacion_22_2_Jsonclick = "" ;
      edtLSD4TipoOperacion_21_1_Jsonclick = "" ;
      edtLSD4TipoEmpresa_20_1_Jsonclick = "" ;
      edtLSD4MarcaReduccion_19_1_Jsonclick = "" ;
      edtLSD4MarcaSCVO_18_1_Jsonclick = "" ;
      edtLSD4MarcaCCT_17_1_Jsonclick = "" ;
      edtLSD4CantidadHijos_15_2_Jsonclick = "" ;
      edtLSD4Conyuge_14_1_Jsonclick = "" ;
      edtLSD4CUIL_3_11_Jsonclick = "" ;
      edtLSD4Sec_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      subGrid_Sortable = (byte)(0) ;
      edtLSD2Sec_Jsonclick = "" ;
      edtLSD2Sec_Visible = 1 ;
      edtLSDSec_Jsonclick = "" ;
      edtLSDSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "||||||||||||||||||||||||||2.0|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2|16.2" ;
      Ddo_grid_Datalistproc = "LSD_reg2LSD_reg4WCGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "|||||||||||||||||||||||||T|||||||||||||||||||||" ;
      Ddo_grid_Datalisttype = "|||||||||||||||||||||||||Dynamic|||||||||||||||||||||" ;
      Ddo_grid_Includedatalist = "|||||||||||||||||||||||||T|||||||||||||||||||||" ;
      Ddo_grid_Filterisrange = "||||||||||||||||||||||||||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Filtertype = "|||||||||||||||||||||||||Character|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric" ;
      Ddo_grid_Includefilter = "|||||||||||||||||||||||||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47" ;
      Ddo_grid_Columnids = "0:LSD4Sec|1:LSD4CUIL_3_11|2:LSD4Conyuge_14_1|3:LSD4CantidadHijos_15_2|4:LSD4MarcaCCT_17_1|5:LSD4MarcaSCVO_18_1|6:LSD4MarcaReduccion_19_1|7:LSD4TipoEmpresa_20_1|8:LSD4TipoOperacion_21_1|9:LSD4CodigoSituacion_22_2|10:LSD4CodigoCondicion_24_2|11:LSD4CodigoActividad_26_3|12:LSD4CodigoModalidadContratacion_29_3|13:LSD4CodigoSiniestrado_32_2|14:LSD4CodigoLocalidad_34_2|15:LSD4SituacionRevista1_36_2|16:LSD4DiaInicioSituacionRevista1_38_2|17:LSD4SituacionRevista2_40_2|18:LSD4DiaInicioSituacionRevista2_42_2|19:LSD4SituacionRevista3_44_2|20:LSD4DiaInicioSituacionRevista3_46_2|21:LSD4CantidadDiasTrabajados_48_2|22:LSD4HorasTrabajadas_50_3|23:LSD4PorcentajeAporteAdicionalSS_53_5|24:LSD4ContribucionTareaDiferencial_58_5|25:LSD4CodigoObraSocial_63_6|26:LSD4CantidadAdherentes_69_2|27:LSD4AporteAdicionalOS_71_15|28:LSD4ContribucionAdicionalOS_86_15|29:LSD4BaseCalculoDiferencialAportesOSyFSR_101_15|30:LSD4BaseCalculoDiferencialOSyFSR_116_15|31:LSD4BaseCalculoDiferencialLRT_131_15|32:LSD4RemuneracionMaternidadANSeS_146_15|33:LSD4RemuneracionBruta_161_15|34:LSD4BaseImponible1_176_15|35:LSD4BaseImponible2_191_15|36:LSD4BaseImponible3_206_15|37:LSD4BaseImponible4_221_15|38:LSD4BaseImponible5_236_15|39:LSD4BaseImponible6_251_15|40:LSD4BaseImponible7_266_15|41:LSD4BaseImponible8_281_15|42:LSD4BaseImponible9_296_15|43:LSD4BaseDifApoSegSoc_311_15|44:LSD4BaseDifContSegSoc_326_15|45:LSD4BaseImponible10_341_15|46:LSD4ImporteADetraer_356_15" ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9'},{av:'AV11LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9'},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV31TFLSD4CodigoObraSocial_63_6',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6',pic:''},{av:'AV32TFLSD4CodigoObraSocial_63_6_Sels',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6_SELS',pic:''},{av:'AV33TFLSD4CantidadAdherentes_69_2',fld:'vTFLSD4CANTIDADADHERENTES_69_2',pic:'Z9'},{av:'AV34TFLSD4CantidadAdherentes_69_2_To',fld:'vTFLSD4CANTIDADADHERENTES_69_2_TO',pic:'Z9'},{av:'AV35TFLSD4AporteAdicionalOS_71_15',fld:'vTFLSD4APORTEADICIONALOS_71_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV36TFLSD4AporteAdicionalOS_71_15_To',fld:'vTFLSD4APORTEADICIONALOS_71_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV37TFLSD4ContribucionAdicionalOS_86_15',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV38TFLSD4ContribucionAdicionalOS_86_15_To',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV43TFLSD4BaseCalculoDiferencialLRT_131_15',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV45TFLSD4RemuneracionMaternidadANSeS_146_15',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV47TFLSD4RemuneracionBruta_161_15',fld:'vTFLSD4REMUNERACIONBRUTA_161_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV48TFLSD4RemuneracionBruta_161_15_To',fld:'vTFLSD4REMUNERACIONBRUTA_161_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV49TFLSD4BaseImponible1_176_15',fld:'vTFLSD4BASEIMPONIBLE1_176_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV50TFLSD4BaseImponible1_176_15_To',fld:'vTFLSD4BASEIMPONIBLE1_176_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV51TFLSD4BaseImponible2_191_15',fld:'vTFLSD4BASEIMPONIBLE2_191_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV52TFLSD4BaseImponible2_191_15_To',fld:'vTFLSD4BASEIMPONIBLE2_191_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV53TFLSD4BaseImponible3_206_15',fld:'vTFLSD4BASEIMPONIBLE3_206_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV54TFLSD4BaseImponible3_206_15_To',fld:'vTFLSD4BASEIMPONIBLE3_206_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV55TFLSD4BaseImponible4_221_15',fld:'vTFLSD4BASEIMPONIBLE4_221_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV56TFLSD4BaseImponible4_221_15_To',fld:'vTFLSD4BASEIMPONIBLE4_221_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV57TFLSD4BaseImponible5_236_15',fld:'vTFLSD4BASEIMPONIBLE5_236_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV58TFLSD4BaseImponible5_236_15_To',fld:'vTFLSD4BASEIMPONIBLE5_236_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV59TFLSD4BaseImponible6_251_15',fld:'vTFLSD4BASEIMPONIBLE6_251_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV60TFLSD4BaseImponible6_251_15_To',fld:'vTFLSD4BASEIMPONIBLE6_251_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV61TFLSD4BaseImponible7_266_15',fld:'vTFLSD4BASEIMPONIBLE7_266_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV62TFLSD4BaseImponible7_266_15_To',fld:'vTFLSD4BASEIMPONIBLE7_266_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV63TFLSD4BaseImponible8_281_15',fld:'vTFLSD4BASEIMPONIBLE8_281_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV64TFLSD4BaseImponible8_281_15_To',fld:'vTFLSD4BASEIMPONIBLE8_281_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV65TFLSD4BaseImponible9_296_15',fld:'vTFLSD4BASEIMPONIBLE9_296_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV66TFLSD4BaseImponible9_296_15_To',fld:'vTFLSD4BASEIMPONIBLE9_296_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV67TFLSD4BaseDifApoSegSoc_311_15',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV68TFLSD4BaseDifApoSegSoc_311_15_To',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV69TFLSD4BaseDifContSegSoc_326_15',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV70TFLSD4BaseDifContSegSoc_326_15_To',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV71TFLSD4BaseImponible10_341_15',fld:'vTFLSD4BASEIMPONIBLE10_341_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV72TFLSD4BaseImponible10_341_15_To',fld:'vTFLSD4BASEIMPONIBLE10_341_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV73TFLSD4ImporteADetraer_356_15',fld:'vTFLSD4IMPORTEADETRAER_356_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV74TFLSD4ImporteADetraer_356_15_To',fld:'vTFLSD4IMPORTEADETRAER_356_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV28IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV23GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV24GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV25GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV28IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11HP2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9'},{av:'AV11LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9'},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV31TFLSD4CodigoObraSocial_63_6',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6',pic:''},{av:'AV32TFLSD4CodigoObraSocial_63_6_Sels',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6_SELS',pic:''},{av:'AV33TFLSD4CantidadAdherentes_69_2',fld:'vTFLSD4CANTIDADADHERENTES_69_2',pic:'Z9'},{av:'AV34TFLSD4CantidadAdherentes_69_2_To',fld:'vTFLSD4CANTIDADADHERENTES_69_2_TO',pic:'Z9'},{av:'AV35TFLSD4AporteAdicionalOS_71_15',fld:'vTFLSD4APORTEADICIONALOS_71_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV36TFLSD4AporteAdicionalOS_71_15_To',fld:'vTFLSD4APORTEADICIONALOS_71_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV37TFLSD4ContribucionAdicionalOS_86_15',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV38TFLSD4ContribucionAdicionalOS_86_15_To',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV43TFLSD4BaseCalculoDiferencialLRT_131_15',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV45TFLSD4RemuneracionMaternidadANSeS_146_15',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV47TFLSD4RemuneracionBruta_161_15',fld:'vTFLSD4REMUNERACIONBRUTA_161_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV48TFLSD4RemuneracionBruta_161_15_To',fld:'vTFLSD4REMUNERACIONBRUTA_161_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV49TFLSD4BaseImponible1_176_15',fld:'vTFLSD4BASEIMPONIBLE1_176_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV50TFLSD4BaseImponible1_176_15_To',fld:'vTFLSD4BASEIMPONIBLE1_176_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV51TFLSD4BaseImponible2_191_15',fld:'vTFLSD4BASEIMPONIBLE2_191_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV52TFLSD4BaseImponible2_191_15_To',fld:'vTFLSD4BASEIMPONIBLE2_191_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV53TFLSD4BaseImponible3_206_15',fld:'vTFLSD4BASEIMPONIBLE3_206_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV54TFLSD4BaseImponible3_206_15_To',fld:'vTFLSD4BASEIMPONIBLE3_206_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV55TFLSD4BaseImponible4_221_15',fld:'vTFLSD4BASEIMPONIBLE4_221_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV56TFLSD4BaseImponible4_221_15_To',fld:'vTFLSD4BASEIMPONIBLE4_221_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV57TFLSD4BaseImponible5_236_15',fld:'vTFLSD4BASEIMPONIBLE5_236_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV58TFLSD4BaseImponible5_236_15_To',fld:'vTFLSD4BASEIMPONIBLE5_236_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV59TFLSD4BaseImponible6_251_15',fld:'vTFLSD4BASEIMPONIBLE6_251_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV60TFLSD4BaseImponible6_251_15_To',fld:'vTFLSD4BASEIMPONIBLE6_251_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV61TFLSD4BaseImponible7_266_15',fld:'vTFLSD4BASEIMPONIBLE7_266_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV62TFLSD4BaseImponible7_266_15_To',fld:'vTFLSD4BASEIMPONIBLE7_266_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV63TFLSD4BaseImponible8_281_15',fld:'vTFLSD4BASEIMPONIBLE8_281_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV64TFLSD4BaseImponible8_281_15_To',fld:'vTFLSD4BASEIMPONIBLE8_281_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV65TFLSD4BaseImponible9_296_15',fld:'vTFLSD4BASEIMPONIBLE9_296_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV66TFLSD4BaseImponible9_296_15_To',fld:'vTFLSD4BASEIMPONIBLE9_296_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV67TFLSD4BaseDifApoSegSoc_311_15',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV68TFLSD4BaseDifApoSegSoc_311_15_To',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV69TFLSD4BaseDifContSegSoc_326_15',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV70TFLSD4BaseDifContSegSoc_326_15_To',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV71TFLSD4BaseImponible10_341_15',fld:'vTFLSD4BASEIMPONIBLE10_341_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV72TFLSD4BaseImponible10_341_15_To',fld:'vTFLSD4BASEIMPONIBLE10_341_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV73TFLSD4ImporteADetraer_356_15',fld:'vTFLSD4IMPORTEADETRAER_356_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV74TFLSD4ImporteADetraer_356_15_To',fld:'vTFLSD4IMPORTEADETRAER_356_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV28IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12HP2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9'},{av:'AV11LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9'},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV31TFLSD4CodigoObraSocial_63_6',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6',pic:''},{av:'AV32TFLSD4CodigoObraSocial_63_6_Sels',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6_SELS',pic:''},{av:'AV33TFLSD4CantidadAdherentes_69_2',fld:'vTFLSD4CANTIDADADHERENTES_69_2',pic:'Z9'},{av:'AV34TFLSD4CantidadAdherentes_69_2_To',fld:'vTFLSD4CANTIDADADHERENTES_69_2_TO',pic:'Z9'},{av:'AV35TFLSD4AporteAdicionalOS_71_15',fld:'vTFLSD4APORTEADICIONALOS_71_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV36TFLSD4AporteAdicionalOS_71_15_To',fld:'vTFLSD4APORTEADICIONALOS_71_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV37TFLSD4ContribucionAdicionalOS_86_15',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV38TFLSD4ContribucionAdicionalOS_86_15_To',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV43TFLSD4BaseCalculoDiferencialLRT_131_15',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV45TFLSD4RemuneracionMaternidadANSeS_146_15',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV47TFLSD4RemuneracionBruta_161_15',fld:'vTFLSD4REMUNERACIONBRUTA_161_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV48TFLSD4RemuneracionBruta_161_15_To',fld:'vTFLSD4REMUNERACIONBRUTA_161_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV49TFLSD4BaseImponible1_176_15',fld:'vTFLSD4BASEIMPONIBLE1_176_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV50TFLSD4BaseImponible1_176_15_To',fld:'vTFLSD4BASEIMPONIBLE1_176_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV51TFLSD4BaseImponible2_191_15',fld:'vTFLSD4BASEIMPONIBLE2_191_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV52TFLSD4BaseImponible2_191_15_To',fld:'vTFLSD4BASEIMPONIBLE2_191_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV53TFLSD4BaseImponible3_206_15',fld:'vTFLSD4BASEIMPONIBLE3_206_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV54TFLSD4BaseImponible3_206_15_To',fld:'vTFLSD4BASEIMPONIBLE3_206_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV55TFLSD4BaseImponible4_221_15',fld:'vTFLSD4BASEIMPONIBLE4_221_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV56TFLSD4BaseImponible4_221_15_To',fld:'vTFLSD4BASEIMPONIBLE4_221_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV57TFLSD4BaseImponible5_236_15',fld:'vTFLSD4BASEIMPONIBLE5_236_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV58TFLSD4BaseImponible5_236_15_To',fld:'vTFLSD4BASEIMPONIBLE5_236_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV59TFLSD4BaseImponible6_251_15',fld:'vTFLSD4BASEIMPONIBLE6_251_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV60TFLSD4BaseImponible6_251_15_To',fld:'vTFLSD4BASEIMPONIBLE6_251_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV61TFLSD4BaseImponible7_266_15',fld:'vTFLSD4BASEIMPONIBLE7_266_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV62TFLSD4BaseImponible7_266_15_To',fld:'vTFLSD4BASEIMPONIBLE7_266_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV63TFLSD4BaseImponible8_281_15',fld:'vTFLSD4BASEIMPONIBLE8_281_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV64TFLSD4BaseImponible8_281_15_To',fld:'vTFLSD4BASEIMPONIBLE8_281_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV65TFLSD4BaseImponible9_296_15',fld:'vTFLSD4BASEIMPONIBLE9_296_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV66TFLSD4BaseImponible9_296_15_To',fld:'vTFLSD4BASEIMPONIBLE9_296_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV67TFLSD4BaseDifApoSegSoc_311_15',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV68TFLSD4BaseDifApoSegSoc_311_15_To',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV69TFLSD4BaseDifContSegSoc_326_15',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV70TFLSD4BaseDifContSegSoc_326_15_To',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV71TFLSD4BaseImponible10_341_15',fld:'vTFLSD4BASEIMPONIBLE10_341_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV72TFLSD4BaseImponible10_341_15_To',fld:'vTFLSD4BASEIMPONIBLE10_341_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV73TFLSD4ImporteADetraer_356_15',fld:'vTFLSD4IMPORTEADETRAER_356_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV74TFLSD4ImporteADetraer_356_15_To',fld:'vTFLSD4IMPORTEADETRAER_356_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV28IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13HP2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9'},{av:'AV11LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9'},{av:'AV83Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV31TFLSD4CodigoObraSocial_63_6',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6',pic:''},{av:'AV32TFLSD4CodigoObraSocial_63_6_Sels',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6_SELS',pic:''},{av:'AV33TFLSD4CantidadAdherentes_69_2',fld:'vTFLSD4CANTIDADADHERENTES_69_2',pic:'Z9'},{av:'AV34TFLSD4CantidadAdherentes_69_2_To',fld:'vTFLSD4CANTIDADADHERENTES_69_2_TO',pic:'Z9'},{av:'AV35TFLSD4AporteAdicionalOS_71_15',fld:'vTFLSD4APORTEADICIONALOS_71_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV36TFLSD4AporteAdicionalOS_71_15_To',fld:'vTFLSD4APORTEADICIONALOS_71_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV37TFLSD4ContribucionAdicionalOS_86_15',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV38TFLSD4ContribucionAdicionalOS_86_15_To',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV43TFLSD4BaseCalculoDiferencialLRT_131_15',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV45TFLSD4RemuneracionMaternidadANSeS_146_15',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV47TFLSD4RemuneracionBruta_161_15',fld:'vTFLSD4REMUNERACIONBRUTA_161_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV48TFLSD4RemuneracionBruta_161_15_To',fld:'vTFLSD4REMUNERACIONBRUTA_161_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV49TFLSD4BaseImponible1_176_15',fld:'vTFLSD4BASEIMPONIBLE1_176_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV50TFLSD4BaseImponible1_176_15_To',fld:'vTFLSD4BASEIMPONIBLE1_176_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV51TFLSD4BaseImponible2_191_15',fld:'vTFLSD4BASEIMPONIBLE2_191_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV52TFLSD4BaseImponible2_191_15_To',fld:'vTFLSD4BASEIMPONIBLE2_191_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV53TFLSD4BaseImponible3_206_15',fld:'vTFLSD4BASEIMPONIBLE3_206_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV54TFLSD4BaseImponible3_206_15_To',fld:'vTFLSD4BASEIMPONIBLE3_206_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV55TFLSD4BaseImponible4_221_15',fld:'vTFLSD4BASEIMPONIBLE4_221_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV56TFLSD4BaseImponible4_221_15_To',fld:'vTFLSD4BASEIMPONIBLE4_221_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV57TFLSD4BaseImponible5_236_15',fld:'vTFLSD4BASEIMPONIBLE5_236_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV58TFLSD4BaseImponible5_236_15_To',fld:'vTFLSD4BASEIMPONIBLE5_236_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV59TFLSD4BaseImponible6_251_15',fld:'vTFLSD4BASEIMPONIBLE6_251_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV60TFLSD4BaseImponible6_251_15_To',fld:'vTFLSD4BASEIMPONIBLE6_251_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV61TFLSD4BaseImponible7_266_15',fld:'vTFLSD4BASEIMPONIBLE7_266_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV62TFLSD4BaseImponible7_266_15_To',fld:'vTFLSD4BASEIMPONIBLE7_266_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV63TFLSD4BaseImponible8_281_15',fld:'vTFLSD4BASEIMPONIBLE8_281_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV64TFLSD4BaseImponible8_281_15_To',fld:'vTFLSD4BASEIMPONIBLE8_281_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV65TFLSD4BaseImponible9_296_15',fld:'vTFLSD4BASEIMPONIBLE9_296_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV66TFLSD4BaseImponible9_296_15_To',fld:'vTFLSD4BASEIMPONIBLE9_296_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV67TFLSD4BaseDifApoSegSoc_311_15',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV68TFLSD4BaseDifApoSegSoc_311_15_To',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV69TFLSD4BaseDifContSegSoc_326_15',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV70TFLSD4BaseDifContSegSoc_326_15_To',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV71TFLSD4BaseImponible10_341_15',fld:'vTFLSD4BASEIMPONIBLE10_341_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV72TFLSD4BaseImponible10_341_15_To',fld:'vTFLSD4BASEIMPONIBLE10_341_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV73TFLSD4ImporteADetraer_356_15',fld:'vTFLSD4IMPORTEADETRAER_356_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV74TFLSD4ImporteADetraer_356_15_To',fld:'vTFLSD4IMPORTEADETRAER_356_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV28IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV73TFLSD4ImporteADetraer_356_15',fld:'vTFLSD4IMPORTEADETRAER_356_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV74TFLSD4ImporteADetraer_356_15_To',fld:'vTFLSD4IMPORTEADETRAER_356_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV71TFLSD4BaseImponible10_341_15',fld:'vTFLSD4BASEIMPONIBLE10_341_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV72TFLSD4BaseImponible10_341_15_To',fld:'vTFLSD4BASEIMPONIBLE10_341_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV69TFLSD4BaseDifContSegSoc_326_15',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV70TFLSD4BaseDifContSegSoc_326_15_To',fld:'vTFLSD4BASEDIFCONTSEGSOC_326_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV67TFLSD4BaseDifApoSegSoc_311_15',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV68TFLSD4BaseDifApoSegSoc_311_15_To',fld:'vTFLSD4BASEDIFAPOSEGSOC_311_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV65TFLSD4BaseImponible9_296_15',fld:'vTFLSD4BASEIMPONIBLE9_296_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV66TFLSD4BaseImponible9_296_15_To',fld:'vTFLSD4BASEIMPONIBLE9_296_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV63TFLSD4BaseImponible8_281_15',fld:'vTFLSD4BASEIMPONIBLE8_281_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV64TFLSD4BaseImponible8_281_15_To',fld:'vTFLSD4BASEIMPONIBLE8_281_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV61TFLSD4BaseImponible7_266_15',fld:'vTFLSD4BASEIMPONIBLE7_266_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV62TFLSD4BaseImponible7_266_15_To',fld:'vTFLSD4BASEIMPONIBLE7_266_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV59TFLSD4BaseImponible6_251_15',fld:'vTFLSD4BASEIMPONIBLE6_251_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV60TFLSD4BaseImponible6_251_15_To',fld:'vTFLSD4BASEIMPONIBLE6_251_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV57TFLSD4BaseImponible5_236_15',fld:'vTFLSD4BASEIMPONIBLE5_236_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV58TFLSD4BaseImponible5_236_15_To',fld:'vTFLSD4BASEIMPONIBLE5_236_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV55TFLSD4BaseImponible4_221_15',fld:'vTFLSD4BASEIMPONIBLE4_221_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV56TFLSD4BaseImponible4_221_15_To',fld:'vTFLSD4BASEIMPONIBLE4_221_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV53TFLSD4BaseImponible3_206_15',fld:'vTFLSD4BASEIMPONIBLE3_206_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV54TFLSD4BaseImponible3_206_15_To',fld:'vTFLSD4BASEIMPONIBLE3_206_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV51TFLSD4BaseImponible2_191_15',fld:'vTFLSD4BASEIMPONIBLE2_191_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV52TFLSD4BaseImponible2_191_15_To',fld:'vTFLSD4BASEIMPONIBLE2_191_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV49TFLSD4BaseImponible1_176_15',fld:'vTFLSD4BASEIMPONIBLE1_176_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV50TFLSD4BaseImponible1_176_15_To',fld:'vTFLSD4BASEIMPONIBLE1_176_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV47TFLSD4RemuneracionBruta_161_15',fld:'vTFLSD4REMUNERACIONBRUTA_161_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV48TFLSD4RemuneracionBruta_161_15_To',fld:'vTFLSD4REMUNERACIONBRUTA_161_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV45TFLSD4RemuneracionMaternidadANSeS_146_15',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To',fld:'vTFLSD4REMUNERACIONMATERNIDADANSES_146_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV43TFLSD4BaseCalculoDiferencialLRT_131_15',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALLRT_131_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALOSYFSR_116_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To',fld:'vTFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV37TFLSD4ContribucionAdicionalOS_86_15',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV38TFLSD4ContribucionAdicionalOS_86_15_To',fld:'vTFLSD4CONTRIBUCIONADICIONALOS_86_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV35TFLSD4AporteAdicionalOS_71_15',fld:'vTFLSD4APORTEADICIONALOS_71_15',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV36TFLSD4AporteAdicionalOS_71_15_To',fld:'vTFLSD4APORTEADICIONALOS_71_15_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV33TFLSD4CantidadAdherentes_69_2',fld:'vTFLSD4CANTIDADADHERENTES_69_2',pic:'Z9'},{av:'AV34TFLSD4CantidadAdherentes_69_2_To',fld:'vTFLSD4CANTIDADADHERENTES_69_2_TO',pic:'Z9'},{av:'AV31TFLSD4CodigoObraSocial_63_6',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6',pic:''},{av:'AV30TFLSD4CodigoObraSocial_63_6_SelsJson',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6_SELSJSON',pic:''},{av:'AV32TFLSD4CodigoObraSocial_63_6_Sels',fld:'vTFLSD4CODIGOOBRASOCIAL_63_6_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17HP2',iparms:[{av:'AV27IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'},{av:'A1674LSD4Sec',fld:'LSD4SEC',pic:'ZZZ9',hsh:true},{av:'AV28IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV78Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV79Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV80Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV75VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV76ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV77EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("'DOINSERT'","{handler:'e14HP2',iparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9'},{av:'AV11LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9'},{av:'A1674LSD4Sec',fld:'LSD4SEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
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
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV83Pgmname = "" ;
      AV31TFLSD4CodigoObraSocial_63_6 = "" ;
      AV32TFLSD4CodigoObraSocial_63_6_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFLSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      AV36TFLSD4AporteAdicionalOS_71_15_To = DecimalUtil.ZERO ;
      AV37TFLSD4ContribucionAdicionalOS_86_15 = DecimalUtil.ZERO ;
      AV38TFLSD4ContribucionAdicionalOS_86_15_To = DecimalUtil.ZERO ;
      AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 = DecimalUtil.ZERO ;
      AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To = DecimalUtil.ZERO ;
      AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 = DecimalUtil.ZERO ;
      AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To = DecimalUtil.ZERO ;
      AV43TFLSD4BaseCalculoDiferencialLRT_131_15 = DecimalUtil.ZERO ;
      AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To = DecimalUtil.ZERO ;
      AV45TFLSD4RemuneracionMaternidadANSeS_146_15 = DecimalUtil.ZERO ;
      AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To = DecimalUtil.ZERO ;
      AV47TFLSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      AV48TFLSD4RemuneracionBruta_161_15_To = DecimalUtil.ZERO ;
      AV49TFLSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      AV50TFLSD4BaseImponible1_176_15_To = DecimalUtil.ZERO ;
      AV51TFLSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      AV52TFLSD4BaseImponible2_191_15_To = DecimalUtil.ZERO ;
      AV53TFLSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      AV54TFLSD4BaseImponible3_206_15_To = DecimalUtil.ZERO ;
      AV55TFLSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      AV56TFLSD4BaseImponible4_221_15_To = DecimalUtil.ZERO ;
      AV57TFLSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      AV58TFLSD4BaseImponible5_236_15_To = DecimalUtil.ZERO ;
      AV59TFLSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      AV60TFLSD4BaseImponible6_251_15_To = DecimalUtil.ZERO ;
      AV61TFLSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      AV62TFLSD4BaseImponible7_266_15_To = DecimalUtil.ZERO ;
      AV63TFLSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      AV64TFLSD4BaseImponible8_281_15_To = DecimalUtil.ZERO ;
      AV65TFLSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      AV66TFLSD4BaseImponible9_296_15_To = DecimalUtil.ZERO ;
      AV67TFLSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      AV68TFLSD4BaseDifApoSegSoc_311_15_To = DecimalUtil.ZERO ;
      AV69TFLSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      AV70TFLSD4BaseDifContSegSoc_326_15_To = DecimalUtil.ZERO ;
      AV71TFLSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      AV72TFLSD4BaseImponible10_341_15_To = DecimalUtil.ZERO ;
      AV73TFLSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      AV74TFLSD4ImporteADetraer_356_15_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV25GridAppliedFilters = "" ;
      AV20DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
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
      bttBtninsert_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1676LSD4Conyuge_14_1 = "" ;
      A1678LSD4MarcaCCT_17_1 = "" ;
      A1679LSD4MarcaSCVO_18_1 = "" ;
      A1680LSD4MarcaReduccion_19_1 = "" ;
      A1681LSD4TipoEmpresa_20_1 = "" ;
      A1682LSD4TipoOperacion_21_1 = "" ;
      A1683LSD4CodigoSituacion_22_2 = "" ;
      A1684LSD4CodigoCondicion_24_2 = "" ;
      A1685LSD4CodigoActividad_26_3 = "" ;
      A1686LSD4CodigoModalidadContratacio = "" ;
      A1687LSD4CodigoSiniestrado_32_2 = "" ;
      A1688LSD4CodigoLocalidad_34_2 = "" ;
      A1689LSD4SituacionRevista1_36_2 = "" ;
      A1690LSD4DiaInicioSituacionRevista1 = "" ;
      A1691LSD4SituacionRevista2_40_2 = "" ;
      A1692LSD4DiaInicioSituacionRevista2 = "" ;
      A1693LSD4SituacionRevista3_44_2 = "" ;
      A1694LSD4DiaInicioSituacionRevista3 = "" ;
      A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      AV75VerSVG = "" ;
      AV76ModificarSVG = "" ;
      AV77EliminarSVG = "" ;
      AV78Update = "" ;
      AV79Delete = "" ;
      AV80Display = "" ;
      scmdbuf = "" ;
      lV31TFLSD4CodigoObraSocial_63_6 = "" ;
      H00HP2_A3CliCod = new int[1] ;
      H00HP2_A1EmpCod = new short[1] ;
      H00HP2_A1649LSDSec = new int[1] ;
      H00HP2_A1657LSD2Sec = new int[1] ;
      H00HP2_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      H00HP2_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      H00HP2_A1698LSD4ContribucionTareaDiferenci = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1697LSD4PorcentajeAporteAdicionalS = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00HP2_A1696LSD4HorasTrabajadas_50_3 = new short[1] ;
      H00HP2_A1695LSD4CantidadDiasTrabajados_48_ = new byte[1] ;
      H00HP2_A1694LSD4DiaInicioSituacionRevista3 = new String[] {""} ;
      H00HP2_A1693LSD4SituacionRevista3_44_2 = new String[] {""} ;
      H00HP2_A1692LSD4DiaInicioSituacionRevista2 = new String[] {""} ;
      H00HP2_A1691LSD4SituacionRevista2_40_2 = new String[] {""} ;
      H00HP2_A1690LSD4DiaInicioSituacionRevista1 = new String[] {""} ;
      H00HP2_A1689LSD4SituacionRevista1_36_2 = new String[] {""} ;
      H00HP2_A1688LSD4CodigoLocalidad_34_2 = new String[] {""} ;
      H00HP2_A1687LSD4CodigoSiniestrado_32_2 = new String[] {""} ;
      H00HP2_A1686LSD4CodigoModalidadContratacio = new String[] {""} ;
      H00HP2_A1685LSD4CodigoActividad_26_3 = new String[] {""} ;
      H00HP2_A1684LSD4CodigoCondicion_24_2 = new String[] {""} ;
      H00HP2_A1683LSD4CodigoSituacion_22_2 = new String[] {""} ;
      H00HP2_A1682LSD4TipoOperacion_21_1 = new String[] {""} ;
      H00HP2_A1681LSD4TipoEmpresa_20_1 = new String[] {""} ;
      H00HP2_A1680LSD4MarcaReduccion_19_1 = new String[] {""} ;
      H00HP2_A1679LSD4MarcaSCVO_18_1 = new String[] {""} ;
      H00HP2_A1678LSD4MarcaCCT_17_1 = new String[] {""} ;
      H00HP2_A1677LSD4CantidadHijos_15_2 = new byte[1] ;
      H00HP2_A1676LSD4Conyuge_14_1 = new String[] {""} ;
      H00HP2_A1675LSD4CUIL_3_11 = new long[1] ;
      H00HP2_A1674LSD4Sec = new short[1] ;
      H00HP3_AGRID_nRecordCount = new long[1] ;
      hsh = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30TFLSD4CodigoObraSocial_63_6_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_boolean9 = new boolean[1] ;
      AV19Session = httpContext.getWebSession();
      AV15GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV16GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState10 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12HTTPRequest = httpContext.getHttpRequest();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV10LSDSec = "" ;
      sCtrlAV11LSD2Sec = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg2lsd_reg4wc__default(),
         new Object[] {
             new Object[] {
            H00HP2_A3CliCod, H00HP2_A1EmpCod, H00HP2_A1649LSDSec, H00HP2_A1657LSD2Sec, H00HP2_A1720LSD4ImporteADetraer_356_15, H00HP2_A1719LSD4BaseImponible10_341_15, H00HP2_A1718LSD4BaseDifContSegSoc_326_15, H00HP2_A1717LSD4BaseDifApoSegSoc_311_15, H00HP2_A1716LSD4BaseImponible9_296_15, H00HP2_A1715LSD4BaseImponible8_281_15,
            H00HP2_A1714LSD4BaseImponible7_266_15, H00HP2_A1713LSD4BaseImponible6_251_15, H00HP2_A1712LSD4BaseImponible5_236_15, H00HP2_A1711LSD4BaseImponible4_221_15, H00HP2_A1710LSD4BaseImponible3_206_15, H00HP2_A1709LSD4BaseImponible2_191_15, H00HP2_A1708LSD4BaseImponible1_176_15, H00HP2_A1707LSD4RemuneracionBruta_161_15, H00HP2_A1706LSD4RemuneracionMaternidadANSe, H00HP2_A1705LSD4BaseCalculoDiferencialLRT_,
            H00HP2_A1704LSD4BaseCalculoDiferencialOSyF, H00HP2_A1703LSD4BaseCalculoDiferencialApor, H00HP2_A1702LSD4ContribucionAdicionalOS_86, H00HP2_A1701LSD4AporteAdicionalOS_71_15, H00HP2_A1700LSD4CantidadAdherentes_69_2, H00HP2_A1699LSD4CodigoObraSocial_63_6, H00HP2_A1698LSD4ContribucionTareaDiferenci, H00HP2_A1697LSD4PorcentajeAporteAdicionalS, H00HP2_A1696LSD4HorasTrabajadas_50_3, H00HP2_A1695LSD4CantidadDiasTrabajados_48_,
            H00HP2_A1694LSD4DiaInicioSituacionRevista3, H00HP2_A1693LSD4SituacionRevista3_44_2, H00HP2_A1692LSD4DiaInicioSituacionRevista2, H00HP2_A1691LSD4SituacionRevista2_40_2, H00HP2_A1690LSD4DiaInicioSituacionRevista1, H00HP2_A1689LSD4SituacionRevista1_36_2, H00HP2_A1688LSD4CodigoLocalidad_34_2, H00HP2_A1687LSD4CodigoSiniestrado_32_2, H00HP2_A1686LSD4CodigoModalidadContratacio, H00HP2_A1685LSD4CodigoActividad_26_3,
            H00HP2_A1684LSD4CodigoCondicion_24_2, H00HP2_A1683LSD4CodigoSituacion_22_2, H00HP2_A1682LSD4TipoOperacion_21_1, H00HP2_A1681LSD4TipoEmpresa_20_1, H00HP2_A1680LSD4MarcaReduccion_19_1, H00HP2_A1679LSD4MarcaSCVO_18_1, H00HP2_A1678LSD4MarcaCCT_17_1, H00HP2_A1677LSD4CantidadHijos_15_2, H00HP2_A1676LSD4Conyuge_14_1, H00HP2_A1675LSD4CUIL_3_11,
            H00HP2_A1674LSD4Sec
            }
            , new Object[] {
            H00HP3_AGRID_nRecordCount
            }
         }
      );
      AV83Pgmname = "LSD_reg2LSD_reg4WC" ;
      /* GeneXus formulas. */
      AV83Pgmname = "LSD_reg2LSD_reg4WC" ;
      Gx_err = (short)(0) ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV33TFLSD4CantidadAdherentes_69_2 ;
   private byte AV34TFLSD4CantidadAdherentes_69_2_To ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A1677LSD4CantidadHijos_15_2 ;
   private byte A1695LSD4CantidadDiasTrabajados_48_ ;
   private byte A1700LSD4CantidadAdherentes_69_2 ;
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
   private short AV17OrderedBy ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1674LSD4Sec ;
   private short A1696LSD4HorasTrabajadas_50_3 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int wcpOAV8CliCod ;
   private int wcpOAV10LSDSec ;
   private int wcpOAV11LSD2Sec ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_26 ;
   private int AV8CliCod ;
   private int AV10LSDSec ;
   private int AV11LSD2Sec ;
   private int nGXsfl_26_idx=1 ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1657LSD2Sec ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninsert_Visible ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtLSDSec_Visible ;
   private int edtLSD2Sec_Visible ;
   private int subGrid_Islastpage ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV32TFLSD4CodigoObraSocial_63_6_Sels_size ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV22PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int AV84GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV23GridCurrentPage ;
   private long AV24GridPageCount ;
   private long A1675LSD4CUIL_3_11 ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV35TFLSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal AV36TFLSD4AporteAdicionalOS_71_15_To ;
   private java.math.BigDecimal AV37TFLSD4ContribucionAdicionalOS_86_15 ;
   private java.math.BigDecimal AV38TFLSD4ContribucionAdicionalOS_86_15_To ;
   private java.math.BigDecimal AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ;
   private java.math.BigDecimal AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ;
   private java.math.BigDecimal AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ;
   private java.math.BigDecimal AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ;
   private java.math.BigDecimal AV43TFLSD4BaseCalculoDiferencialLRT_131_15 ;
   private java.math.BigDecimal AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To ;
   private java.math.BigDecimal AV45TFLSD4RemuneracionMaternidadANSeS_146_15 ;
   private java.math.BigDecimal AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To ;
   private java.math.BigDecimal AV47TFLSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal AV48TFLSD4RemuneracionBruta_161_15_To ;
   private java.math.BigDecimal AV49TFLSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal AV50TFLSD4BaseImponible1_176_15_To ;
   private java.math.BigDecimal AV51TFLSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal AV52TFLSD4BaseImponible2_191_15_To ;
   private java.math.BigDecimal AV53TFLSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal AV54TFLSD4BaseImponible3_206_15_To ;
   private java.math.BigDecimal AV55TFLSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal AV56TFLSD4BaseImponible4_221_15_To ;
   private java.math.BigDecimal AV57TFLSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal AV58TFLSD4BaseImponible5_236_15_To ;
   private java.math.BigDecimal AV59TFLSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal AV60TFLSD4BaseImponible6_251_15_To ;
   private java.math.BigDecimal AV61TFLSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal AV62TFLSD4BaseImponible7_266_15_To ;
   private java.math.BigDecimal AV63TFLSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal AV64TFLSD4BaseImponible8_281_15_To ;
   private java.math.BigDecimal AV65TFLSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal AV66TFLSD4BaseImponible9_296_15_To ;
   private java.math.BigDecimal AV67TFLSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal AV68TFLSD4BaseDifApoSegSoc_311_15_To ;
   private java.math.BigDecimal AV69TFLSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal AV70TFLSD4BaseDifContSegSoc_326_15_To ;
   private java.math.BigDecimal AV71TFLSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal AV72TFLSD4BaseImponible10_341_15_To ;
   private java.math.BigDecimal AV73TFLSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal AV74TFLSD4ImporteADetraer_356_15_To ;
   private java.math.BigDecimal A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ;
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
   private String sGXsfl_26_idx="0001" ;
   private String AV83Pgmname ;
   private String AV31TFLSD4CodigoObraSocial_63_6 ;
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
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String bttBtninsert_Internalname ;
   private String bttBtninsert_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLSDSec_Internalname ;
   private String edtLSDSec_Jsonclick ;
   private String edtLSD2Sec_Internalname ;
   private String edtLSD2Sec_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtLSD4Sec_Internalname ;
   private String edtLSD4CUIL_3_11_Internalname ;
   private String A1676LSD4Conyuge_14_1 ;
   private String edtLSD4Conyuge_14_1_Internalname ;
   private String edtLSD4CantidadHijos_15_2_Internalname ;
   private String A1678LSD4MarcaCCT_17_1 ;
   private String edtLSD4MarcaCCT_17_1_Internalname ;
   private String A1679LSD4MarcaSCVO_18_1 ;
   private String edtLSD4MarcaSCVO_18_1_Internalname ;
   private String A1680LSD4MarcaReduccion_19_1 ;
   private String edtLSD4MarcaReduccion_19_1_Internalname ;
   private String A1681LSD4TipoEmpresa_20_1 ;
   private String edtLSD4TipoEmpresa_20_1_Internalname ;
   private String A1682LSD4TipoOperacion_21_1 ;
   private String edtLSD4TipoOperacion_21_1_Internalname ;
   private String A1683LSD4CodigoSituacion_22_2 ;
   private String edtLSD4CodigoSituacion_22_2_Internalname ;
   private String A1684LSD4CodigoCondicion_24_2 ;
   private String edtLSD4CodigoCondicion_24_2_Internalname ;
   private String A1685LSD4CodigoActividad_26_3 ;
   private String edtLSD4CodigoActividad_26_3_Internalname ;
   private String A1686LSD4CodigoModalidadContratacio ;
   private String edtLSD4CodigoModalidadContratacio_Internalname ;
   private String A1687LSD4CodigoSiniestrado_32_2 ;
   private String edtLSD4CodigoSiniestrado_32_2_Internalname ;
   private String A1688LSD4CodigoLocalidad_34_2 ;
   private String edtLSD4CodigoLocalidad_34_2_Internalname ;
   private String A1689LSD4SituacionRevista1_36_2 ;
   private String edtLSD4SituacionRevista1_36_2_Internalname ;
   private String A1690LSD4DiaInicioSituacionRevista1 ;
   private String edtLSD4DiaInicioSituacionRevista1_Internalname ;
   private String A1691LSD4SituacionRevista2_40_2 ;
   private String edtLSD4SituacionRevista2_40_2_Internalname ;
   private String A1692LSD4DiaInicioSituacionRevista2 ;
   private String edtLSD4DiaInicioSituacionRevista2_Internalname ;
   private String A1693LSD4SituacionRevista3_44_2 ;
   private String edtLSD4SituacionRevista3_44_2_Internalname ;
   private String A1694LSD4DiaInicioSituacionRevista3 ;
   private String edtLSD4DiaInicioSituacionRevista3_Internalname ;
   private String edtLSD4CantidadDiasTrabajados_48__Internalname ;
   private String edtLSD4HorasTrabajadas_50_3_Internalname ;
   private String edtLSD4PorcentajeAporteAdicionalS_Internalname ;
   private String edtLSD4ContribucionTareaDiferenci_Internalname ;
   private String A1699LSD4CodigoObraSocial_63_6 ;
   private String edtLSD4CodigoObraSocial_63_6_Internalname ;
   private String edtLSD4CantidadAdherentes_69_2_Internalname ;
   private String edtLSD4AporteAdicionalOS_71_15_Internalname ;
   private String edtLSD4ContribucionAdicionalOS_86_Internalname ;
   private String edtLSD4BaseCalculoDiferencialApor_Internalname ;
   private String edtLSD4BaseCalculoDiferencialOSyF_Internalname ;
   private String edtLSD4BaseCalculoDiferencialLRT__Internalname ;
   private String edtLSD4RemuneracionMaternidadANSe_Internalname ;
   private String edtLSD4RemuneracionBruta_161_15_Internalname ;
   private String edtLSD4BaseImponible1_176_15_Internalname ;
   private String edtLSD4BaseImponible2_191_15_Internalname ;
   private String edtLSD4BaseImponible3_206_15_Internalname ;
   private String edtLSD4BaseImponible4_221_15_Internalname ;
   private String edtLSD4BaseImponible5_236_15_Internalname ;
   private String edtLSD4BaseImponible6_251_15_Internalname ;
   private String edtLSD4BaseImponible7_266_15_Internalname ;
   private String edtLSD4BaseImponible8_281_15_Internalname ;
   private String edtLSD4BaseImponible9_296_15_Internalname ;
   private String edtLSD4BaseDifApoSegSoc_311_15_Internalname ;
   private String edtLSD4BaseDifContSegSoc_326_15_Internalname ;
   private String edtLSD4BaseImponible10_341_15_Internalname ;
   private String edtLSD4ImporteADetraer_356_15_Internalname ;
   private String AV75VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV76ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV77EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String AV78Update ;
   private String edtavUpdate_Internalname ;
   private String AV79Delete ;
   private String edtavDelete_Internalname ;
   private String AV80Display ;
   private String edtavDisplay_Internalname ;
   private String scmdbuf ;
   private String lV31TFLSD4CodigoObraSocial_63_6 ;
   private String hsh ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV10LSDSec ;
   private String sCtrlAV11LSD2Sec ;
   private String sGXsfl_26_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtLSD4Sec_Jsonclick ;
   private String edtLSD4CUIL_3_11_Jsonclick ;
   private String edtLSD4Conyuge_14_1_Jsonclick ;
   private String edtLSD4CantidadHijos_15_2_Jsonclick ;
   private String edtLSD4MarcaCCT_17_1_Jsonclick ;
   private String edtLSD4MarcaSCVO_18_1_Jsonclick ;
   private String edtLSD4MarcaReduccion_19_1_Jsonclick ;
   private String edtLSD4TipoEmpresa_20_1_Jsonclick ;
   private String edtLSD4TipoOperacion_21_1_Jsonclick ;
   private String edtLSD4CodigoSituacion_22_2_Jsonclick ;
   private String edtLSD4CodigoCondicion_24_2_Jsonclick ;
   private String edtLSD4CodigoActividad_26_3_Jsonclick ;
   private String edtLSD4CodigoModalidadContratacio_Jsonclick ;
   private String edtLSD4CodigoSiniestrado_32_2_Jsonclick ;
   private String edtLSD4CodigoLocalidad_34_2_Jsonclick ;
   private String edtLSD4SituacionRevista1_36_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista1_Jsonclick ;
   private String edtLSD4SituacionRevista2_40_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista2_Jsonclick ;
   private String edtLSD4SituacionRevista3_44_2_Jsonclick ;
   private String edtLSD4DiaInicioSituacionRevista3_Jsonclick ;
   private String edtLSD4CantidadDiasTrabajados_48__Jsonclick ;
   private String edtLSD4HorasTrabajadas_50_3_Jsonclick ;
   private String edtLSD4PorcentajeAporteAdicionalS_Jsonclick ;
   private String edtLSD4ContribucionTareaDiferenci_Jsonclick ;
   private String edtLSD4CodigoObraSocial_63_6_Jsonclick ;
   private String edtLSD4CantidadAdherentes_69_2_Jsonclick ;
   private String edtLSD4AporteAdicionalOS_71_15_Jsonclick ;
   private String edtLSD4ContribucionAdicionalOS_86_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialApor_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialOSyF_Jsonclick ;
   private String edtLSD4BaseCalculoDiferencialLRT__Jsonclick ;
   private String edtLSD4RemuneracionMaternidadANSe_Jsonclick ;
   private String edtLSD4RemuneracionBruta_161_15_Jsonclick ;
   private String edtLSD4BaseImponible1_176_15_Jsonclick ;
   private String edtLSD4BaseImponible2_191_15_Jsonclick ;
   private String edtLSD4BaseImponible3_206_15_Jsonclick ;
   private String edtLSD4BaseImponible4_221_15_Jsonclick ;
   private String edtLSD4BaseImponible5_236_15_Jsonclick ;
   private String edtLSD4BaseImponible6_251_15_Jsonclick ;
   private String edtLSD4BaseImponible7_266_15_Jsonclick ;
   private String edtLSD4BaseImponible8_281_15_Jsonclick ;
   private String edtLSD4BaseImponible9_296_15_Jsonclick ;
   private String edtLSD4BaseDifApoSegSoc_311_15_Jsonclick ;
   private String edtLSD4BaseDifContSegSoc_326_15_Jsonclick ;
   private String edtLSD4BaseImponible10_341_15_Jsonclick ;
   private String edtLSD4ImporteADetraer_356_15_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV18OrderedDsc ;
   private boolean AV27IsAuthorized_Update ;
   private boolean AV28IsAuthorized_Delete ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_26_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV29TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV30TFLSD4CodigoObraSocial_63_6_SelsJson ;
   private String AV25GridAppliedFilters ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV12HTTPRequest ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private int[] H00HP2_A3CliCod ;
   private short[] H00HP2_A1EmpCod ;
   private int[] H00HP2_A1649LSDSec ;
   private int[] H00HP2_A1657LSD2Sec ;
   private java.math.BigDecimal[] H00HP2_A1720LSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal[] H00HP2_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] H00HP2_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] H00HP2_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] H00HP2_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] H00HP2_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] H00HP2_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] H00HP2_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] H00HP2_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] H00HP2_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] H00HP2_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] H00HP2_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] H00HP2_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] H00HP2_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] H00HP2_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] H00HP2_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] H00HP2_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] H00HP2_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] H00HP2_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] H00HP2_A1701LSD4AporteAdicionalOS_71_15 ;
   private byte[] H00HP2_A1700LSD4CantidadAdherentes_69_2 ;
   private String[] H00HP2_A1699LSD4CodigoObraSocial_63_6 ;
   private java.math.BigDecimal[] H00HP2_A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal[] H00HP2_A1697LSD4PorcentajeAporteAdicionalS ;
   private short[] H00HP2_A1696LSD4HorasTrabajadas_50_3 ;
   private byte[] H00HP2_A1695LSD4CantidadDiasTrabajados_48_ ;
   private String[] H00HP2_A1694LSD4DiaInicioSituacionRevista3 ;
   private String[] H00HP2_A1693LSD4SituacionRevista3_44_2 ;
   private String[] H00HP2_A1692LSD4DiaInicioSituacionRevista2 ;
   private String[] H00HP2_A1691LSD4SituacionRevista2_40_2 ;
   private String[] H00HP2_A1690LSD4DiaInicioSituacionRevista1 ;
   private String[] H00HP2_A1689LSD4SituacionRevista1_36_2 ;
   private String[] H00HP2_A1688LSD4CodigoLocalidad_34_2 ;
   private String[] H00HP2_A1687LSD4CodigoSiniestrado_32_2 ;
   private String[] H00HP2_A1686LSD4CodigoModalidadContratacio ;
   private String[] H00HP2_A1685LSD4CodigoActividad_26_3 ;
   private String[] H00HP2_A1684LSD4CodigoCondicion_24_2 ;
   private String[] H00HP2_A1683LSD4CodigoSituacion_22_2 ;
   private String[] H00HP2_A1682LSD4TipoOperacion_21_1 ;
   private String[] H00HP2_A1681LSD4TipoEmpresa_20_1 ;
   private String[] H00HP2_A1680LSD4MarcaReduccion_19_1 ;
   private String[] H00HP2_A1679LSD4MarcaSCVO_18_1 ;
   private String[] H00HP2_A1678LSD4MarcaCCT_17_1 ;
   private byte[] H00HP2_A1677LSD4CantidadHijos_15_2 ;
   private String[] H00HP2_A1676LSD4Conyuge_14_1 ;
   private long[] H00HP2_A1675LSD4CUIL_3_11 ;
   private short[] H00HP2_A1674LSD4Sec ;
   private long[] H00HP3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV32TFLSD4CodigoObraSocial_63_6_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV15GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState10[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV16GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV20DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class lsd_reg2lsd_reg4wc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00HP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1699LSD4CodigoObraSocial_63_6 ,
                                          GXSimpleCollection<String> AV32TFLSD4CodigoObraSocial_63_6_Sels ,
                                          int AV32TFLSD4CodigoObraSocial_63_6_Sels_size ,
                                          String AV31TFLSD4CodigoObraSocial_63_6 ,
                                          byte AV33TFLSD4CantidadAdherentes_69_2 ,
                                          byte AV34TFLSD4CantidadAdherentes_69_2_To ,
                                          java.math.BigDecimal AV35TFLSD4AporteAdicionalOS_71_15 ,
                                          java.math.BigDecimal AV36TFLSD4AporteAdicionalOS_71_15_To ,
                                          java.math.BigDecimal AV37TFLSD4ContribucionAdicionalOS_86_15 ,
                                          java.math.BigDecimal AV38TFLSD4ContribucionAdicionalOS_86_15_To ,
                                          java.math.BigDecimal AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                          java.math.BigDecimal AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                          java.math.BigDecimal AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                          java.math.BigDecimal AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                          java.math.BigDecimal AV43TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                          java.math.BigDecimal AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                          java.math.BigDecimal AV45TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                          java.math.BigDecimal AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                          java.math.BigDecimal AV47TFLSD4RemuneracionBruta_161_15 ,
                                          java.math.BigDecimal AV48TFLSD4RemuneracionBruta_161_15_To ,
                                          java.math.BigDecimal AV49TFLSD4BaseImponible1_176_15 ,
                                          java.math.BigDecimal AV50TFLSD4BaseImponible1_176_15_To ,
                                          java.math.BigDecimal AV51TFLSD4BaseImponible2_191_15 ,
                                          java.math.BigDecimal AV52TFLSD4BaseImponible2_191_15_To ,
                                          java.math.BigDecimal AV53TFLSD4BaseImponible3_206_15 ,
                                          java.math.BigDecimal AV54TFLSD4BaseImponible3_206_15_To ,
                                          java.math.BigDecimal AV55TFLSD4BaseImponible4_221_15 ,
                                          java.math.BigDecimal AV56TFLSD4BaseImponible4_221_15_To ,
                                          java.math.BigDecimal AV57TFLSD4BaseImponible5_236_15 ,
                                          java.math.BigDecimal AV58TFLSD4BaseImponible5_236_15_To ,
                                          java.math.BigDecimal AV59TFLSD4BaseImponible6_251_15 ,
                                          java.math.BigDecimal AV60TFLSD4BaseImponible6_251_15_To ,
                                          java.math.BigDecimal AV61TFLSD4BaseImponible7_266_15 ,
                                          java.math.BigDecimal AV62TFLSD4BaseImponible7_266_15_To ,
                                          java.math.BigDecimal AV63TFLSD4BaseImponible8_281_15 ,
                                          java.math.BigDecimal AV64TFLSD4BaseImponible8_281_15_To ,
                                          java.math.BigDecimal AV65TFLSD4BaseImponible9_296_15 ,
                                          java.math.BigDecimal AV66TFLSD4BaseImponible9_296_15_To ,
                                          java.math.BigDecimal AV67TFLSD4BaseDifApoSegSoc_311_15 ,
                                          java.math.BigDecimal AV68TFLSD4BaseDifApoSegSoc_311_15_To ,
                                          java.math.BigDecimal AV69TFLSD4BaseDifContSegSoc_326_15 ,
                                          java.math.BigDecimal AV70TFLSD4BaseDifContSegSoc_326_15_To ,
                                          java.math.BigDecimal AV71TFLSD4BaseImponible10_341_15 ,
                                          java.math.BigDecimal AV72TFLSD4BaseImponible10_341_15_To ,
                                          java.math.BigDecimal AV73TFLSD4ImporteADetraer_356_15 ,
                                          java.math.BigDecimal AV74TFLSD4ImporteADetraer_356_15_To ,
                                          byte A1700LSD4CantidadAdherentes_69_2 ,
                                          java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ,
                                          java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ,
                                          java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ,
                                          java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ,
                                          java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ,
                                          java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ,
                                          java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ,
                                          java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ,
                                          java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ,
                                          java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ,
                                          java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ,
                                          java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ,
                                          java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ,
                                          java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ,
                                          java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ,
                                          java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ,
                                          java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ,
                                          java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ,
                                          java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ,
                                          java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LSDSec ,
                                          int AV11LSD2Sec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1649LSDSec ,
                                          int A1657LSD2Sec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[50];
      Object[] GXv_Object12 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CliCod, EmpCod, LSDSec, LSD2Sec, LSD4ImporteADetraer_356_15, LSD4BaseImponible10_341_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseImponible9_296_15," ;
      sSelectString += " LSD4BaseImponible8_281_15, LSD4BaseImponible7_266_15, LSD4BaseImponible6_251_15, LSD4BaseImponible5_236_15, LSD4BaseImponible4_221_15, LSD4BaseImponible3_206_15," ;
      sSelectString += " LSD4BaseImponible2_191_15, LSD4BaseImponible1_176_15, LSD4RemuneracionBruta_161_15, LSD4RemuneracionMaternidadANSe, LSD4BaseCalculoDiferencialLRT_, LSD4BaseCalculoDiferencialOSyF," ;
      sSelectString += " LSD4BaseCalculoDiferencialApor, LSD4ContribucionAdicionalOS_86, LSD4AporteAdicionalOS_71_15, LSD4CantidadAdherentes_69_2, LSD4CodigoObraSocial_63_6, LSD4ContribucionTareaDiferenci," ;
      sSelectString += " LSD4PorcentajeAporteAdicionalS, LSD4HorasTrabajadas_50_3, LSD4CantidadDiasTrabajados_48_, LSD4DiaInicioSituacionRevista3, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista2," ;
      sSelectString += " LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista1_36_2, LSD4CodigoLocalidad_34_2, LSD4CodigoSiniestrado_32_2, LSD4CodigoModalidadContratacio," ;
      sSelectString += " LSD4CodigoActividad_26_3, LSD4CodigoCondicion_24_2, LSD4CodigoSituacion_22_2, LSD4TipoOperacion_21_1, LSD4TipoEmpresa_20_1, LSD4MarcaReduccion_19_1, LSD4MarcaSCVO_18_1," ;
      sSelectString += " LSD4MarcaCCT_17_1, LSD4CantidadHijos_15_2, LSD4Conyuge_14_1, LSD4CUIL_3_11, LSD4Sec" ;
      sFromString = " FROM LSD_reg4" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ?)");
      if ( ( AV32TFLSD4CodigoObraSocial_63_6_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFLSD4CodigoObraSocial_63_6)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD4CodigoObraSocial_63_6) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV32TFLSD4CodigoObraSocial_63_6_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLSD4CodigoObraSocial_63_6_Sels, "LSD4CodigoObraSocial_63_6 IN (", ")")+")");
      }
      if ( ! (0==AV33TFLSD4CantidadAdherentes_69_2) )
      {
         addWhere(sWhereString, "(LSD4CantidadAdherentes_69_2 >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV34TFLSD4CantidadAdherentes_69_2_To) )
      {
         addWhere(sWhereString, "(LSD4CantidadAdherentes_69_2 <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLSD4AporteAdicionalOS_71_15)==0) )
      {
         addWhere(sWhereString, "(LSD4AporteAdicionalOS_71_15 >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLSD4AporteAdicionalOS_71_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4AporteAdicionalOS_71_15 <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLSD4ContribucionAdicionalOS_86_15)==0) )
      {
         addWhere(sWhereString, "(LSD4ContribucionAdicionalOS_86 >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLSD4ContribucionAdicionalOS_86_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4ContribucionAdicionalOS_86 <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialApor >= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialApor <= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialOSyF >= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialOSyF <= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLSD4BaseCalculoDiferencialLRT_131_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialLRT_ >= ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialLRT_ <= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFLSD4RemuneracionMaternidadANSeS_146_15)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionMaternidadANSe >= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionMaternidadANSe <= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFLSD4RemuneracionBruta_161_15)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionBruta_161_15 >= ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFLSD4RemuneracionBruta_161_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionBruta_161_15 <= ?)");
      }
      else
      {
         GXv_int11[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFLSD4BaseImponible1_176_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible1_176_15 >= ?)");
      }
      else
      {
         GXv_int11[21] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLSD4BaseImponible1_176_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible1_176_15 <= ?)");
      }
      else
      {
         GXv_int11[22] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLSD4BaseImponible2_191_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible2_191_15 >= ?)");
      }
      else
      {
         GXv_int11[23] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLSD4BaseImponible2_191_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible2_191_15 <= ?)");
      }
      else
      {
         GXv_int11[24] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLSD4BaseImponible3_206_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible3_206_15 >= ?)");
      }
      else
      {
         GXv_int11[25] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLSD4BaseImponible3_206_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible3_206_15 <= ?)");
      }
      else
      {
         GXv_int11[26] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLSD4BaseImponible4_221_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible4_221_15 >= ?)");
      }
      else
      {
         GXv_int11[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLSD4BaseImponible4_221_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible4_221_15 <= ?)");
      }
      else
      {
         GXv_int11[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLSD4BaseImponible5_236_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible5_236_15 >= ?)");
      }
      else
      {
         GXv_int11[29] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLSD4BaseImponible5_236_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible5_236_15 <= ?)");
      }
      else
      {
         GXv_int11[30] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLSD4BaseImponible6_251_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible6_251_15 >= ?)");
      }
      else
      {
         GXv_int11[31] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLSD4BaseImponible6_251_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible6_251_15 <= ?)");
      }
      else
      {
         GXv_int11[32] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLSD4BaseImponible7_266_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible7_266_15 >= ?)");
      }
      else
      {
         GXv_int11[33] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLSD4BaseImponible7_266_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible7_266_15 <= ?)");
      }
      else
      {
         GXv_int11[34] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLSD4BaseImponible8_281_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible8_281_15 >= ?)");
      }
      else
      {
         GXv_int11[35] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLSD4BaseImponible8_281_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible8_281_15 <= ?)");
      }
      else
      {
         GXv_int11[36] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLSD4BaseImponible9_296_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible9_296_15 >= ?)");
      }
      else
      {
         GXv_int11[37] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLSD4BaseImponible9_296_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible9_296_15 <= ?)");
      }
      else
      {
         GXv_int11[38] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLSD4BaseDifApoSegSoc_311_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifApoSegSoc_311_15 >= ?)");
      }
      else
      {
         GXv_int11[39] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLSD4BaseDifApoSegSoc_311_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifApoSegSoc_311_15 <= ?)");
      }
      else
      {
         GXv_int11[40] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFLSD4BaseDifContSegSoc_326_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifContSegSoc_326_15 >= ?)");
      }
      else
      {
         GXv_int11[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLSD4BaseDifContSegSoc_326_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifContSegSoc_326_15 <= ?)");
      }
      else
      {
         GXv_int11[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLSD4BaseImponible10_341_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible10_341_15 >= ?)");
      }
      else
      {
         GXv_int11[43] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLSD4BaseImponible10_341_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible10_341_15 <= ?)");
      }
      else
      {
         GXv_int11[44] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLSD4ImporteADetraer_356_15)==0) )
      {
         addWhere(sWhereString, "(LSD4ImporteADetraer_356_15 >= ?)");
      }
      else
      {
         GXv_int11[45] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74TFLSD4ImporteADetraer_356_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4ImporteADetraer_356_15 <= ?)");
      }
      else
      {
         GXv_int11[46] = (byte)(1) ;
      }
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4Sec DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CUIL_3_11, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CUIL_3_11 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Conyuge_14_1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4Conyuge_14_1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CantidadHijos_15_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CantidadHijos_15_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4MarcaCCT_17_1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4MarcaCCT_17_1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4MarcaSCVO_18_1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4MarcaSCVO_18_1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4MarcaReduccion_19_1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4MarcaReduccion_19_1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4TipoEmpresa_20_1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4TipoEmpresa_20_1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4TipoOperacion_21_1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4TipoOperacion_21_1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoSituacion_22_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoSituacion_22_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoCondicion_24_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoCondicion_24_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoActividad_26_3, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoActividad_26_3 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoModalidadContratacio, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoModalidadContratacio DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoSiniestrado_32_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoSiniestrado_32_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoLocalidad_34_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoLocalidad_34_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4SituacionRevista1_36_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4SituacionRevista1_36_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4DiaInicioSituacionRevista1, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4DiaInicioSituacionRevista1 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4SituacionRevista2_40_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4SituacionRevista2_40_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4DiaInicioSituacionRevista2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4DiaInicioSituacionRevista2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4SituacionRevista3_44_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4SituacionRevista3_44_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4DiaInicioSituacionRevista3, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4DiaInicioSituacionRevista3 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CantidadDiasTrabajados_48_, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CantidadDiasTrabajados_48_ DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4HorasTrabajadas_50_3, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4HorasTrabajadas_50_3 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4PorcentajeAporteAdicionalS, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4PorcentajeAporteAdicionalS DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4ContribucionTareaDiferenci, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4ContribucionTareaDiferenci DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 26 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoObraSocial_63_6, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 26 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CodigoObraSocial_63_6 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 27 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CantidadAdherentes_69_2, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 27 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4CantidadAdherentes_69_2 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 28 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4AporteAdicionalOS_71_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 28 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4AporteAdicionalOS_71_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 29 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4ContribucionAdicionalOS_86, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 29 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4ContribucionAdicionalOS_86 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 30 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseCalculoDiferencialApor, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 30 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseCalculoDiferencialApor DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 31 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseCalculoDiferencialOSyF, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 31 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseCalculoDiferencialOSyF DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 32 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseCalculoDiferencialLRT_, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 32 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseCalculoDiferencialLRT_ DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 33 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4RemuneracionMaternidadANSe, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 33 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4RemuneracionMaternidadANSe DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 34 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4RemuneracionBruta_161_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 34 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4RemuneracionBruta_161_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 35 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible1_176_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 35 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible1_176_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 36 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible2_191_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 36 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible2_191_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 37 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible3_206_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 37 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible3_206_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 38 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible4_221_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 38 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible4_221_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 39 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible5_236_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 39 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible5_236_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 40 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible6_251_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 40 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible6_251_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 41 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible7_266_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 41 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible7_266_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 42 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible8_281_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 42 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible8_281_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 43 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible9_296_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 43 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible9_296_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 44 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseDifApoSegSoc_311_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 44 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseDifApoSegSoc_311_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 45 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseDifContSegSoc_326_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 45 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseDifContSegSoc_326_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 46 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4BaseImponible10_341_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 46 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4BaseImponible10_341_15 DESC, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 47 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4ImporteADetraer_356_15, LSD4Sec" ;
      }
      else if ( ( AV17OrderedBy == 47 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD4ImporteADetraer_356_15 DESC, LSD4Sec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_H00HP3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1699LSD4CodigoObraSocial_63_6 ,
                                          GXSimpleCollection<String> AV32TFLSD4CodigoObraSocial_63_6_Sels ,
                                          int AV32TFLSD4CodigoObraSocial_63_6_Sels_size ,
                                          String AV31TFLSD4CodigoObraSocial_63_6 ,
                                          byte AV33TFLSD4CantidadAdherentes_69_2 ,
                                          byte AV34TFLSD4CantidadAdherentes_69_2_To ,
                                          java.math.BigDecimal AV35TFLSD4AporteAdicionalOS_71_15 ,
                                          java.math.BigDecimal AV36TFLSD4AporteAdicionalOS_71_15_To ,
                                          java.math.BigDecimal AV37TFLSD4ContribucionAdicionalOS_86_15 ,
                                          java.math.BigDecimal AV38TFLSD4ContribucionAdicionalOS_86_15_To ,
                                          java.math.BigDecimal AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                          java.math.BigDecimal AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                          java.math.BigDecimal AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                          java.math.BigDecimal AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                          java.math.BigDecimal AV43TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                          java.math.BigDecimal AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                          java.math.BigDecimal AV45TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                          java.math.BigDecimal AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                          java.math.BigDecimal AV47TFLSD4RemuneracionBruta_161_15 ,
                                          java.math.BigDecimal AV48TFLSD4RemuneracionBruta_161_15_To ,
                                          java.math.BigDecimal AV49TFLSD4BaseImponible1_176_15 ,
                                          java.math.BigDecimal AV50TFLSD4BaseImponible1_176_15_To ,
                                          java.math.BigDecimal AV51TFLSD4BaseImponible2_191_15 ,
                                          java.math.BigDecimal AV52TFLSD4BaseImponible2_191_15_To ,
                                          java.math.BigDecimal AV53TFLSD4BaseImponible3_206_15 ,
                                          java.math.BigDecimal AV54TFLSD4BaseImponible3_206_15_To ,
                                          java.math.BigDecimal AV55TFLSD4BaseImponible4_221_15 ,
                                          java.math.BigDecimal AV56TFLSD4BaseImponible4_221_15_To ,
                                          java.math.BigDecimal AV57TFLSD4BaseImponible5_236_15 ,
                                          java.math.BigDecimal AV58TFLSD4BaseImponible5_236_15_To ,
                                          java.math.BigDecimal AV59TFLSD4BaseImponible6_251_15 ,
                                          java.math.BigDecimal AV60TFLSD4BaseImponible6_251_15_To ,
                                          java.math.BigDecimal AV61TFLSD4BaseImponible7_266_15 ,
                                          java.math.BigDecimal AV62TFLSD4BaseImponible7_266_15_To ,
                                          java.math.BigDecimal AV63TFLSD4BaseImponible8_281_15 ,
                                          java.math.BigDecimal AV64TFLSD4BaseImponible8_281_15_To ,
                                          java.math.BigDecimal AV65TFLSD4BaseImponible9_296_15 ,
                                          java.math.BigDecimal AV66TFLSD4BaseImponible9_296_15_To ,
                                          java.math.BigDecimal AV67TFLSD4BaseDifApoSegSoc_311_15 ,
                                          java.math.BigDecimal AV68TFLSD4BaseDifApoSegSoc_311_15_To ,
                                          java.math.BigDecimal AV69TFLSD4BaseDifContSegSoc_326_15 ,
                                          java.math.BigDecimal AV70TFLSD4BaseDifContSegSoc_326_15_To ,
                                          java.math.BigDecimal AV71TFLSD4BaseImponible10_341_15 ,
                                          java.math.BigDecimal AV72TFLSD4BaseImponible10_341_15_To ,
                                          java.math.BigDecimal AV73TFLSD4ImporteADetraer_356_15 ,
                                          java.math.BigDecimal AV74TFLSD4ImporteADetraer_356_15_To ,
                                          byte A1700LSD4CantidadAdherentes_69_2 ,
                                          java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ,
                                          java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ,
                                          java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ,
                                          java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ,
                                          java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ,
                                          java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ,
                                          java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ,
                                          java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ,
                                          java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ,
                                          java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ,
                                          java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ,
                                          java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ,
                                          java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ,
                                          java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ,
                                          java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ,
                                          java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ,
                                          java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ,
                                          java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ,
                                          java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ,
                                          java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LSDSec ,
                                          int AV11LSD2Sec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1649LSDSec ,
                                          int A1657LSD2Sec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[47];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LSD_reg4" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ?)");
      if ( ( AV32TFLSD4CodigoObraSocial_63_6_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFLSD4CodigoObraSocial_63_6)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD4CodigoObraSocial_63_6) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV32TFLSD4CodigoObraSocial_63_6_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLSD4CodigoObraSocial_63_6_Sels, "LSD4CodigoObraSocial_63_6 IN (", ")")+")");
      }
      if ( ! (0==AV33TFLSD4CantidadAdherentes_69_2) )
      {
         addWhere(sWhereString, "(LSD4CantidadAdherentes_69_2 >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (0==AV34TFLSD4CantidadAdherentes_69_2_To) )
      {
         addWhere(sWhereString, "(LSD4CantidadAdherentes_69_2 <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLSD4AporteAdicionalOS_71_15)==0) )
      {
         addWhere(sWhereString, "(LSD4AporteAdicionalOS_71_15 >= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLSD4AporteAdicionalOS_71_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4AporteAdicionalOS_71_15 <= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLSD4ContribucionAdicionalOS_86_15)==0) )
      {
         addWhere(sWhereString, "(LSD4ContribucionAdicionalOS_86 >= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLSD4ContribucionAdicionalOS_86_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4ContribucionAdicionalOS_86 <= ?)");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialApor >= ?)");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialApor <= ?)");
      }
      else
      {
         GXv_int14[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLSD4BaseCalculoDiferencialOSyFSR_116_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialOSyF >= ?)");
      }
      else
      {
         GXv_int14[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialOSyF <= ?)");
      }
      else
      {
         GXv_int14[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLSD4BaseCalculoDiferencialLRT_131_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialLRT_ >= ?)");
      }
      else
      {
         GXv_int14[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFLSD4BaseCalculoDiferencialLRT_131_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialLRT_ <= ?)");
      }
      else
      {
         GXv_int14[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFLSD4RemuneracionMaternidadANSeS_146_15)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionMaternidadANSe >= ?)");
      }
      else
      {
         GXv_int14[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFLSD4RemuneracionMaternidadANSeS_146_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionMaternidadANSe <= ?)");
      }
      else
      {
         GXv_int14[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFLSD4RemuneracionBruta_161_15)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionBruta_161_15 >= ?)");
      }
      else
      {
         GXv_int14[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFLSD4RemuneracionBruta_161_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionBruta_161_15 <= ?)");
      }
      else
      {
         GXv_int14[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFLSD4BaseImponible1_176_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible1_176_15 >= ?)");
      }
      else
      {
         GXv_int14[21] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLSD4BaseImponible1_176_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible1_176_15 <= ?)");
      }
      else
      {
         GXv_int14[22] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLSD4BaseImponible2_191_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible2_191_15 >= ?)");
      }
      else
      {
         GXv_int14[23] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLSD4BaseImponible2_191_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible2_191_15 <= ?)");
      }
      else
      {
         GXv_int14[24] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLSD4BaseImponible3_206_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible3_206_15 >= ?)");
      }
      else
      {
         GXv_int14[25] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLSD4BaseImponible3_206_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible3_206_15 <= ?)");
      }
      else
      {
         GXv_int14[26] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLSD4BaseImponible4_221_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible4_221_15 >= ?)");
      }
      else
      {
         GXv_int14[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLSD4BaseImponible4_221_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible4_221_15 <= ?)");
      }
      else
      {
         GXv_int14[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57TFLSD4BaseImponible5_236_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible5_236_15 >= ?)");
      }
      else
      {
         GXv_int14[29] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58TFLSD4BaseImponible5_236_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible5_236_15 <= ?)");
      }
      else
      {
         GXv_int14[30] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59TFLSD4BaseImponible6_251_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible6_251_15 >= ?)");
      }
      else
      {
         GXv_int14[31] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV60TFLSD4BaseImponible6_251_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible6_251_15 <= ?)");
      }
      else
      {
         GXv_int14[32] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV61TFLSD4BaseImponible7_266_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible7_266_15 >= ?)");
      }
      else
      {
         GXv_int14[33] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLSD4BaseImponible7_266_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible7_266_15 <= ?)");
      }
      else
      {
         GXv_int14[34] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLSD4BaseImponible8_281_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible8_281_15 >= ?)");
      }
      else
      {
         GXv_int14[35] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLSD4BaseImponible8_281_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible8_281_15 <= ?)");
      }
      else
      {
         GXv_int14[36] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLSD4BaseImponible9_296_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible9_296_15 >= ?)");
      }
      else
      {
         GXv_int14[37] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLSD4BaseImponible9_296_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible9_296_15 <= ?)");
      }
      else
      {
         GXv_int14[38] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLSD4BaseDifApoSegSoc_311_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifApoSegSoc_311_15 >= ?)");
      }
      else
      {
         GXv_int14[39] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68TFLSD4BaseDifApoSegSoc_311_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifApoSegSoc_311_15 <= ?)");
      }
      else
      {
         GXv_int14[40] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69TFLSD4BaseDifContSegSoc_326_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifContSegSoc_326_15 >= ?)");
      }
      else
      {
         GXv_int14[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70TFLSD4BaseDifContSegSoc_326_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifContSegSoc_326_15 <= ?)");
      }
      else
      {
         GXv_int14[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71TFLSD4BaseImponible10_341_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible10_341_15 >= ?)");
      }
      else
      {
         GXv_int14[43] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72TFLSD4BaseImponible10_341_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible10_341_15 <= ?)");
      }
      else
      {
         GXv_int14[44] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73TFLSD4ImporteADetraer_356_15)==0) )
      {
         addWhere(sWhereString, "(LSD4ImporteADetraer_356_15 >= ?)");
      }
      else
      {
         GXv_int14[45] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74TFLSD4ImporteADetraer_356_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4ImporteADetraer_356_15 <= ?)");
      }
      else
      {
         GXv_int14[46] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
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
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 26 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 26 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 27 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 27 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 28 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 28 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 29 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 29 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 30 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 30 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 31 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 31 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 32 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 32 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 33 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 33 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 34 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 34 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 35 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 35 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 36 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 36 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 37 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 37 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 38 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 38 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 39 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 39 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 40 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 40 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 41 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 41 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 42 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 42 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 43 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 43 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 44 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 44 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 45 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 45 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 46 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 46 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 47 ) && ! AV18OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV17OrderedBy == 47 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_H00HP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).byteValue() , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Number) dynConstraints[46]).byteValue() , (java.math.BigDecimal)dynConstraints[47] , (java.math.BigDecimal)dynConstraints[48] , (java.math.BigDecimal)dynConstraints[49] , (java.math.BigDecimal)dynConstraints[50] , (java.math.BigDecimal)dynConstraints[51] , (java.math.BigDecimal)dynConstraints[52] , (java.math.BigDecimal)dynConstraints[53] , (java.math.BigDecimal)dynConstraints[54] , (java.math.BigDecimal)dynConstraints[55] , (java.math.BigDecimal)dynConstraints[56] , (java.math.BigDecimal)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , (java.math.BigDecimal)dynConstraints[63] , (java.math.BigDecimal)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , ((Number) dynConstraints[67]).shortValue() , ((Boolean) dynConstraints[68]).booleanValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).shortValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).shortValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() );
            case 1 :
                  return conditional_H00HP3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).byteValue() , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Number) dynConstraints[46]).byteValue() , (java.math.BigDecimal)dynConstraints[47] , (java.math.BigDecimal)dynConstraints[48] , (java.math.BigDecimal)dynConstraints[49] , (java.math.BigDecimal)dynConstraints[50] , (java.math.BigDecimal)dynConstraints[51] , (java.math.BigDecimal)dynConstraints[52] , (java.math.BigDecimal)dynConstraints[53] , (java.math.BigDecimal)dynConstraints[54] , (java.math.BigDecimal)dynConstraints[55] , (java.math.BigDecimal)dynConstraints[56] , (java.math.BigDecimal)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , (java.math.BigDecimal)dynConstraints[63] , (java.math.BigDecimal)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , ((Number) dynConstraints[67]).shortValue() , ((Boolean) dynConstraints[68]).booleanValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).shortValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).shortValue() , ((Number) dynConstraints[75]).intValue() , ((Number) dynConstraints[76]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00HP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00HP3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((byte[]) buf[24])[0] = rslt.getByte(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 6);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               ((byte[]) buf[29])[0] = rslt.getByte(30);
               ((String[]) buf[30])[0] = rslt.getString(31, 2);
               ((String[]) buf[31])[0] = rslt.getString(32, 2);
               ((String[]) buf[32])[0] = rslt.getString(33, 2);
               ((String[]) buf[33])[0] = rslt.getString(34, 2);
               ((String[]) buf[34])[0] = rslt.getString(35, 2);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getString(37, 2);
               ((String[]) buf[37])[0] = rslt.getString(38, 2);
               ((String[]) buf[38])[0] = rslt.getString(39, 3);
               ((String[]) buf[39])[0] = rslt.getString(40, 3);
               ((String[]) buf[40])[0] = rslt.getString(41, 2);
               ((String[]) buf[41])[0] = rslt.getString(42, 2);
               ((String[]) buf[42])[0] = rslt.getString(43, 1);
               ((String[]) buf[43])[0] = rslt.getString(44, 1);
               ((String[]) buf[44])[0] = rslt.getString(45, 1);
               ((String[]) buf[45])[0] = rslt.getString(46, 1);
               ((String[]) buf[46])[0] = rslt.getString(47, 1);
               ((byte[]) buf[47])[0] = rslt.getByte(48);
               ((String[]) buf[48])[0] = rslt.getString(49, 1);
               ((long[]) buf[49])[0] = rslt.getLong(50);
               ((short[]) buf[50])[0] = rslt.getShort(51);
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
                  stmt.setInt(sIdx, ((Number) parms[50]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[51]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[52]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[53]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[54], 6);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[55]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[56]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[57], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[60], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[61], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[62], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[63], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[64], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[65], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[66], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[67], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[68], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[69], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[70], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[71], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[72], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[73], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[74], 2);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[75], 2);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[76], 2);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[77], 2);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[78], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[79], 2);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[80], 2);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[81], 2);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[82], 2);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[83], 2);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[84], 2);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[85], 2);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[86], 2);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[87], 2);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[88], 2);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[89], 2);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[90], 2);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[91], 2);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[92], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[93], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[94], 2);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[95], 2);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[96], 2);
               }
               if ( ((Number) parms[47]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[97]).intValue());
               }
               if ( ((Number) parms[48]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[98]).intValue());
               }
               if ( ((Number) parms[49]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[99]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[49]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[50]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[51], 6);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[52]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[53]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[54], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[55], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[56], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[57], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[60], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[61], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[62], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[63], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[64], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[65], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[66], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[67], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[68], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[69], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[70], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[71], 2);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[72], 2);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[73], 2);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[74], 2);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[75], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[76], 2);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[77], 2);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[78], 2);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[79], 2);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[80], 2);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[81], 2);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[82], 2);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[83], 2);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[84], 2);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[85], 2);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[86], 2);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[87], 2);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[88], 2);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[89], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[90], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[91], 2);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[92], 2);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[93], 2);
               }
               return;
      }
   }

}

