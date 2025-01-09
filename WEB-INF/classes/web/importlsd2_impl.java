package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importlsd2_impl extends GXWebComponent
{
   public importlsd2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importlsd2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importlsd2_impl.class ));
   }

   public importlsd2_impl( int remoteHandle ,
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
               AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
               AV10EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV9CliCod),Short.valueOf(AV10EmpCod)});
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
      nRC_GXsfl_39 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_39"))) ;
      nGXsfl_39_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_39_idx"))) ;
      sGXsfl_39_idx = httpContext.GetPar( "sGXsfl_39_idx") ;
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
      AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV10EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV90Pgmname = httpContext.GetPar( "Pgmname") ;
      AV20TFiconoUpdate = httpContext.GetPar( "TFiconoUpdate") ;
      AV21TFiconoUpdateOperator = (short)(GXutil.lval( httpContext.GetPar( "TFiconoUpdateOperator"))) ;
      AV26TFImpLiqDetPer = httpContext.GetPar( "TFImpLiqDetPer") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV27TFImpLiqDetPer_Sels);
      AV29TFImpLiqDetCUIL = httpContext.GetPar( "TFImpLiqDetCUIL") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFImpLiqDetCUIL_Sels);
      AV32TFImpLiqDetLegSis = httpContext.GetPar( "TFImpLiqDetLegSis") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV33TFImpLiqDetLegSis_Sels);
      AV35TFImpLiqDetConCod = httpContext.GetPar( "TFImpLiqDetConCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36TFImpLiqDetConCod_Sels);
      AV82TFImpLiqDetConSisYDes = httpContext.GetPar( "TFImpLiqDetConSisYDes") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV83TFImpLiqDetConSisYDes_Sels);
      AV77TFImpLiqDetCantNum = CommonUtil.decimalVal( httpContext.GetPar( "TFImpLiqDetCantNum"), ".") ;
      AV78TFImpLiqDetCantNum_To = CommonUtil.decimalVal( httpContext.GetPar( "TFImpLiqDetCantNum_To"), ".") ;
      AV79TFImpLiqDetImpNum = CommonUtil.decimalVal( httpContext.GetPar( "TFImpLiqDetImpNum"), ".") ;
      AV80TFImpLiqDetImpNum_To = CommonUtil.decimalVal( httpContext.GetPar( "TFImpLiqDetImpNum_To"), ".") ;
      AV44TFImpLiqDetSigno = httpContext.GetPar( "TFImpLiqDetSigno") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV45TFImpLiqDetSigno_Sels);
      AV16OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV17OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV91Importlsd2ds_1_clicod = (int)(GXutil.lval( httpContext.GetPar( "Importlsd2ds_1_clicod"))) ;
      AV92Importlsd2ds_2_empcod = (short)(GXutil.lval( httpContext.GetPar( "Importlsd2ds_2_empcod"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa8I2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( " importacion_liquidacion_detalle", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importlsd2", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10EmpCod,4,0))}, new String[] {"CliCod","EmpCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV90Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_39", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_39, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV64GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV65GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV66GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV61DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV61DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV90Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV90Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFICONOUPDATE", GXutil.rtrim( AV20TFiconoUpdate));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFICONOUPDATEOPERATOR", GXutil.ltrim( localUtil.ntoc( AV21TFiconoUpdateOperator, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETPER", GXutil.rtrim( AV26TFImpLiqDetPer));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQDETPER_SELS", AV27TFImpLiqDetPer_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQDETPER_SELS", AV27TFImpLiqDetPer_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETCUIL", GXutil.rtrim( AV29TFImpLiqDetCUIL));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQDETCUIL_SELS", AV30TFImpLiqDetCUIL_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQDETCUIL_SELS", AV30TFImpLiqDetCUIL_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETLEGSIS", AV32TFImpLiqDetLegSis);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQDETLEGSIS_SELS", AV33TFImpLiqDetLegSis_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQDETLEGSIS_SELS", AV33TFImpLiqDetLegSis_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETCONCOD", GXutil.rtrim( AV35TFImpLiqDetConCod));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQDETCONCOD_SELS", AV36TFImpLiqDetConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQDETCONCOD_SELS", AV36TFImpLiqDetConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETCONSISYDES", AV82TFImpLiqDetConSisYDes);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQDETCONSISYDES_SELS", AV83TFImpLiqDetConSisYDes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQDETCONSISYDES_SELS", AV83TFImpLiqDetConSisYDes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETCANTNUM", GXutil.ltrim( localUtil.ntoc( AV77TFImpLiqDetCantNum, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETCANTNUM_TO", GXutil.ltrim( localUtil.ntoc( AV78TFImpLiqDetCantNum_To, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETIMPNUM", GXutil.ltrim( localUtil.ntoc( AV79TFImpLiqDetImpNum, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETIMPNUM_TO", GXutil.ltrim( localUtil.ntoc( AV80TFImpLiqDetImpNum_To, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQDETSIGNO", GXutil.rtrim( AV44TFImpLiqDetSigno));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQDETSIGNO_SELS", AV45TFImpLiqDetSigno_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQDETSIGNO_SELS", AV45TFImpLiqDetSigno_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV69CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV70EmpCod_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPLIQSEC_SELECTED", GXutil.ltrim( localUtil.ntoc( AV71ImpLiqSec_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPLIQDETSEC_SELECTED", GXutil.ltrim( localUtil.ntoc( AV72ImpLiqDetSec_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTLSD2DS_1_CLICOD", GXutil.ltrim( localUtil.ntoc( AV91Importlsd2ds_1_clicod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTLSD2DS_2_EMPCOD", GXutil.ltrim( localUtil.ntoc( AV92Importlsd2ds_2_empcod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vEXTRAPARMS", AV8ExtraParms);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vEXTRAPARMS", AV8ExtraParms);
      }
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Gridinternalname", GXutil.rtrim( Popover_iconoupdate_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Iteminternalname", GXutil.rtrim( Popover_iconoupdate_Iteminternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Isgriditem", GXutil.booltostr( Popover_iconoupdate_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Popoverwidth", GXutil.ltrim( localUtil.ntoc( Popover_iconoupdate_Popoverwidth, (byte)(9), (byte)(0), ".", "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Fixedfilters", GXutil.rtrim( Ddo_grid_Fixedfilters));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedfixedfilter", GXutil.rtrim( Ddo_grid_Selectedfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Title", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Width", GXutil.rtrim( Importexcel_modal_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Title", GXutil.rtrim( Importexcel_modal_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Confirmtype", GXutil.rtrim( Importexcel_modal_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Bodytype", GXutil.rtrim( Importexcel_modal_Bodytype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Popoversingrid", GXutil.rtrim( Grid_empowerer_Popoversingrid));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Result));
   }

   public void renderHtmlCloseForm8I2( )
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
         if ( ! ( WebComp_Wwpaux_wc == null ) )
         {
            WebComp_Wwpaux_wc.componentjscripts();
         }
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
      return "ImportLSD2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " importacion_liquidacion_detalle", "") ;
   }

   public void wb8I0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importlsd2");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
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
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table1_15_8I2( true) ;
      }
      else
      {
         wb_table1_15_8I2( false) ;
      }
      return  ;
   }

   public void wb_table1_15_8I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportartodos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 39, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar todos", ""), bttBtnimportartodos_Jsonclick, 5, httpContext.getMessage( "Importar todos", ""), "", StyleString, ClassString, bttBtnimportartodos_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOIMPORTARTODOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportLSD2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneliminartodos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 39, 2, 0)+","+"null"+");", httpContext.getMessage( "Eliminar Todos", ""), bttBtneliminartodos_Jsonclick, 5, httpContext.getMessage( "Eliminar Todos", ""), "", StyleString, ClassString, bttBtneliminartodos_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOELIMINARTODOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportLSD2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupColoredActions", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportexcel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 39, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar archivos de LSD externos", ""), bttBtnimportexcel_Jsonclick, 7, httpContext.getMessage( "WWP_ImportExcelTooltip", ""), "", StyleString, ClassString, bttBtnimportexcel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e118i1_client"+"'", TempTags, "", 2, "HLP_ImportLSD2.htm");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridFixedTitles HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, divGridtablewithpaginationbar_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol39( ) ;
      }
      if ( wbEnd == 39 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_39 = (int)(nGXsfl_39_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV64GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV65GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV66GridAppliedFilters);
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavClicod_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClicod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavClicod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavClicod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavClicod_Visible, edtavClicod_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ImportLSD2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavEmpcod_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpcod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpcod_Internalname, httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavEmpcod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV10EmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpcod_Visible, edtavEmpcod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ImportLSD2.htm");
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
         ucPopover_iconoupdate.setProperty("IsGridItem", Popover_iconoupdate_Isgriditem);
         ucPopover_iconoupdate.setProperty("PopoverWidth", Popover_iconoupdate_Popoverwidth);
         ucPopover_iconoupdate.render(context, "dvelop.wwppopover", Popover_iconoupdate_Internalname, sPrefix+"POPOVER_ICONOUPDATEContainer");
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
         ucDdo_grid.setProperty("FixedFilters", Ddo_grid_Fixedfilters);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV61DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         wb_table2_78_8I2( true) ;
      }
      else
      {
         wb_table2_78_8I2( false) ;
      }
      return  ;
   }

   public void wb_table2_78_8I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table3_83_8I2( true) ;
      }
      else
      {
         wb_table3_83_8I2( false) ;
      }
      return  ;
   }

   public void wb_table3_83_8I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table4_88_8I2( true) ;
      }
      else
      {
         wb_table4_88_8I2( false) ;
      }
      return  ;
   }

   public void wb_table4_88_8I2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("PopoversInGrid", Grid_empowerer_Popoversingrid);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0095"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0095"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_39_Refreshing )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0095"+"");
                  }
                  WebComp_Wwpaux_wc.componentdraw();
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspEndCmp();
                  }
               }
            }
            httpContext.writeText( "</div>") ;
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 39 )
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

   public void start8I2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( " importacion_liquidacion_detalle", ""), (short)(0)) ;
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
            strup8I0( ) ;
         }
      }
   }

   public void ws8I2( )
   {
      start8I2( ) ;
      evt8I2( ) ;
   }

   public void evt8I2( )
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
                              strup8I0( ) ;
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
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e128I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e138I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e148I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e158I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOS.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e168I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "IMPORTEXCEL_MODAL.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e178I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOIMPORTARTODOS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoimportarTodos' */
                                 e188I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOELIMINARTODOS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoEliminarTodos' */
                                 e198I2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavIconoupdatewithtags_Internalname ;
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VELIMINAR.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VELIMINAR.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8I0( ) ;
                           }
                           nGXsfl_39_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_392( ) ;
                           AV62iconoUpdateWithTags = httpContext.cgiGet( edtavIconoupdatewithtags_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV62iconoUpdateWithTags);
                           AV18iconoUpdate = httpContext.cgiGet( edtavIconoupdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdate_Internalname, AV18iconoUpdate);
                           AV67Eliminar = httpContext.cgiGet( edtavEliminar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminar_Internalname, AV67Eliminar);
                           A88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A90ImpLiqDetSec = (short)(localUtil.ctol( httpContext.cgiGet( edtImpLiqDetSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A709ImpLiqDetError = httpContext.cgiGet( edtImpLiqDetError_Internalname) ;
                           A662ImpLiqDetLiqN = httpContext.cgiGet( edtImpLiqDetLiqN_Internalname) ;
                           A661ImpLiqDetPer = httpContext.cgiGet( edtImpLiqDetPer_Internalname) ;
                           A663ImpLiqDetCUIL = httpContext.cgiGet( edtImpLiqDetCUIL_Internalname) ;
                           A712ImpLiqDetLegSis = httpContext.cgiGet( edtImpLiqDetLegSis_Internalname) ;
                           A664ImpLiqDetLegId = httpContext.cgiGet( edtImpLiqDetLegId_Internalname) ;
                           A666ImpLiqDetConCod = httpContext.cgiGet( edtImpLiqDetConCod_Internalname) ;
                           AV84ImpLiqConExtDescrip = httpContext.cgiGet( edtavImpliqconextdescrip_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavImpliqconextdescrip_Internalname, AV84ImpLiqConExtDescrip);
                           A714ImpLiqDetConSisYDes = httpContext.cgiGet( edtImpLiqDetConSisYDes_Internalname) ;
                           A715ImpLiqDetCantNum = localUtil.ctond( httpContext.cgiGet( edtImpLiqDetCantNum_Internalname)) ;
                           A668ImpLiqDetUni = httpContext.cgiGet( edtImpLiqDetUni_Internalname) ;
                           A716ImpLiqDetImpNum = localUtil.ctond( httpContext.cgiGet( edtImpLiqDetImpNum_Internalname)) ;
                           A670ImpLiqDetSigno = httpContext.cgiGet( edtImpLiqDetSigno_Internalname) ;
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
                                       GX_FocusControl = edtavIconoupdatewithtags_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e208I2 ();
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
                                       GX_FocusControl = edtavIconoupdatewithtags_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e218I2 ();
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
                                       GX_FocusControl = edtavIconoupdatewithtags_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e228I2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VELIMINAR.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavIconoupdatewithtags_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e238I2 ();
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
                                    strup8I0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavIconoupdatewithtags_Internalname ;
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 95 )
                     {
                        OldWwpaux_wc = httpContext.cgiGet( sPrefix+"W0095") ;
                        if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                        {
                           WebComp_Wwpaux_wc = WebUtils.getWebComponent(getClass(), "web." + OldWwpaux_wc + "_impl", remoteHandle, context);
                           WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                        }
                        if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                        {
                           WebComp_Wwpaux_wc.componentprocess(sPrefix+"W0095", "", sEvt);
                        }
                        WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we8I2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm8I2( ) ;
         }
      }
   }

   public void pa8I2( )
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
      subsflControlProps_392( ) ;
      while ( nGXsfl_39_idx <= nRC_GXsfl_39 )
      {
         sendrow_392( ) ;
         nGXsfl_39_idx = ((subGrid_Islastpage==1)&&(nGXsfl_39_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_39_idx+1) ;
         sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_392( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV9CliCod ,
                                 short AV10EmpCod ,
                                 String AV90Pgmname ,
                                 String AV20TFiconoUpdate ,
                                 short AV21TFiconoUpdateOperator ,
                                 String AV26TFImpLiqDetPer ,
                                 GXSimpleCollection<String> AV27TFImpLiqDetPer_Sels ,
                                 String AV29TFImpLiqDetCUIL ,
                                 GXSimpleCollection<String> AV30TFImpLiqDetCUIL_Sels ,
                                 String AV32TFImpLiqDetLegSis ,
                                 GXSimpleCollection<String> AV33TFImpLiqDetLegSis_Sels ,
                                 String AV35TFImpLiqDetConCod ,
                                 GXSimpleCollection<String> AV36TFImpLiqDetConCod_Sels ,
                                 String AV82TFImpLiqDetConSisYDes ,
                                 GXSimpleCollection<String> AV83TFImpLiqDetConSisYDes_Sels ,
                                 java.math.BigDecimal AV77TFImpLiqDetCantNum ,
                                 java.math.BigDecimal AV78TFImpLiqDetCantNum_To ,
                                 java.math.BigDecimal AV79TFImpLiqDetImpNum ,
                                 java.math.BigDecimal AV80TFImpLiqDetImpNum_To ,
                                 String AV44TFImpLiqDetSigno ,
                                 GXSimpleCollection<String> AV45TFImpLiqDetSigno_Sels ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 int AV91Importlsd2ds_1_clicod ,
                                 short AV92Importlsd2ds_2_empcod ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e218I2 ();
      GRID_nCurrentRecord = 0 ;
      rf8I2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQSEC", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPLIQSEC", GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQDETSEC", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A90ImpLiqDetSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPLIQDETSEC", GXutil.ltrim( localUtil.ntoc( A90ImpLiqDetSec, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQDETERROR", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( A709ImpLiqDetError, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPLIQDETERROR", A709ImpLiqDetError);
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
      rf8I2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV90Pgmname = "ImportLSD2" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavImpliqconextdescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavImpliqconextdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImpliqconextdescrip_Enabled), 5, 0), !bGXsfl_39_Refreshing);
   }

   public void rf8I2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(39) ;
      /* Execute user event: Refresh */
      e218I2 ();
      nGXsfl_39_idx = 1 ;
      sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_392( ) ;
      bGXsfl_39_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
            {
               WebComp_Wwpaux_wc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_392( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A661ImpLiqDetPer ,
                                              AV96Importlsd2ds_6_tfimpliqdetper_sels ,
                                              A663ImpLiqDetCUIL ,
                                              AV98Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                              A712ImpLiqDetLegSis ,
                                              AV100Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                              A666ImpLiqDetConCod ,
                                              AV102Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                              A714ImpLiqDetConSisYDes ,
                                              AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                              A670ImpLiqDetSigno ,
                                              AV110Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                              Short.valueOf(AV94Importlsd2ds_4_tficonoupdateoperator) ,
                                              Integer.valueOf(AV96Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                              AV95Importlsd2ds_5_tfimpliqdetper ,
                                              Integer.valueOf(AV98Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                              AV97Importlsd2ds_7_tfimpliqdetcuil ,
                                              Integer.valueOf(AV100Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                              AV99Importlsd2ds_9_tfimpliqdetlegsis ,
                                              Integer.valueOf(AV102Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                              AV101Importlsd2ds_11_tfimpliqdetconcod ,
                                              Integer.valueOf(AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                              AV103Importlsd2ds_13_tfimpliqdetconsisydes ,
                                              AV105Importlsd2ds_15_tfimpliqdetcantnum ,
                                              AV106Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                              AV107Importlsd2ds_17_tfimpliqdetimpnum ,
                                              AV108Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                              Integer.valueOf(AV110Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                              AV109Importlsd2ds_19_tfimpliqdetsigno ,
                                              A709ImpLiqDetError ,
                                              A715ImpLiqDetCantNum ,
                                              A716ImpLiqDetImpNum ,
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              Integer.valueOf(AV91Importlsd2ds_1_clicod) ,
                                              Short.valueOf(AV92Importlsd2ds_2_empcod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV95Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV95Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
         lV97Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV97Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
         lV99Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV99Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
         lV101Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV101Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
         lV103Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV103Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
         lV109Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV109Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
         /* Using cursor H008I2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV91Importlsd2ds_1_clicod), Short.valueOf(AV92Importlsd2ds_2_empcod), lV95Importlsd2ds_5_tfimpliqdetper, lV97Importlsd2ds_7_tfimpliqdetcuil, lV99Importlsd2ds_9_tfimpliqdetlegsis, lV101Importlsd2ds_11_tfimpliqdetconcod, lV103Importlsd2ds_13_tfimpliqdetconsisydes, AV105Importlsd2ds_15_tfimpliqdetcantnum, AV106Importlsd2ds_16_tfimpliqdetcantnum_to, AV107Importlsd2ds_17_tfimpliqdetimpnum, AV108Importlsd2ds_18_tfimpliqdetimpnum_to, lV109Importlsd2ds_19_tfimpliqdetsigno, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_39_idx = 1 ;
         sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_392( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A670ImpLiqDetSigno = H008I2_A670ImpLiqDetSigno[0] ;
            A716ImpLiqDetImpNum = H008I2_A716ImpLiqDetImpNum[0] ;
            A668ImpLiqDetUni = H008I2_A668ImpLiqDetUni[0] ;
            A715ImpLiqDetCantNum = H008I2_A715ImpLiqDetCantNum[0] ;
            A714ImpLiqDetConSisYDes = H008I2_A714ImpLiqDetConSisYDes[0] ;
            A666ImpLiqDetConCod = H008I2_A666ImpLiqDetConCod[0] ;
            A664ImpLiqDetLegId = H008I2_A664ImpLiqDetLegId[0] ;
            A712ImpLiqDetLegSis = H008I2_A712ImpLiqDetLegSis[0] ;
            A663ImpLiqDetCUIL = H008I2_A663ImpLiqDetCUIL[0] ;
            A661ImpLiqDetPer = H008I2_A661ImpLiqDetPer[0] ;
            A662ImpLiqDetLiqN = H008I2_A662ImpLiqDetLiqN[0] ;
            A709ImpLiqDetError = H008I2_A709ImpLiqDetError[0] ;
            A90ImpLiqDetSec = H008I2_A90ImpLiqDetSec[0] ;
            A1EmpCod = H008I2_A1EmpCod[0] ;
            A3CliCod = H008I2_A3CliCod[0] ;
            A88ImpLiqSec = H008I2_A88ImpLiqSec[0] ;
            e228I2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(39) ;
         wb8I0( ) ;
      }
      bGXsfl_39_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes8I2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV90Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV90Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD"+"_"+sGXsfl_39_idx, getSecureSignedToken( sPrefix+sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD"+"_"+sGXsfl_39_idx, getSecureSignedToken( sPrefix+sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQSEC"+"_"+sGXsfl_39_idx, getSecureSignedToken( sPrefix+sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQDETSEC"+"_"+sGXsfl_39_idx, getSecureSignedToken( sPrefix+sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(A90ImpLiqDetSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQDETERROR"+"_"+sGXsfl_39_idx, getSecureSignedToken( sPrefix+sGXsfl_39_idx, GXutil.rtrim( localUtil.format( A709ImpLiqDetError, ""))));
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
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV96Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV98Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV100Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV102Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV110Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV94Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV96Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV95Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV98Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV97Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV100Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV99Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV102Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV101Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV103Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV105Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV106Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV107Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV108Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV110Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV109Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           Integer.valueOf(AV91Importlsd2ds_1_clicod) ,
                                           Short.valueOf(AV92Importlsd2ds_2_empcod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV95Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV95Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV97Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV97Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV99Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV99Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV101Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV101Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV103Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV103Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV109Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV109Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor H008I3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV91Importlsd2ds_1_clicod), Short.valueOf(AV92Importlsd2ds_2_empcod), lV95Importlsd2ds_5_tfimpliqdetper, lV97Importlsd2ds_7_tfimpliqdetcuil, lV99Importlsd2ds_9_tfimpliqdetlegsis, lV101Importlsd2ds_11_tfimpliqdetconcod, lV103Importlsd2ds_13_tfimpliqdetconsisydes, AV105Importlsd2ds_15_tfimpliqdetcantnum, AV106Importlsd2ds_16_tfimpliqdetcantnum_to, AV107Importlsd2ds_17_tfimpliqdetimpnum, AV108Importlsd2ds_18_tfimpliqdetimpnum_to, lV109Importlsd2ds_19_tfimpliqdetsigno});
      GRID_nRecordCount = H008I3_AGRID_nRecordCount[0] ;
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
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV90Pgmname = "ImportLSD2" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavImpliqconextdescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavImpliqconextdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImpliqconextdescrip_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup8I0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e208I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV61DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vEXTRAPARMS"), AV8ExtraParms);
         /* Read saved values. */
         nRC_GXsfl_39 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_39"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV64GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV65GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV66GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Popover_iconoupdate_Gridinternalname = httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Gridinternalname") ;
         Popover_iconoupdate_Iteminternalname = httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Iteminternalname") ;
         Popover_iconoupdate_Isgriditem = GXutil.strtobool( httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Isgriditem")) ;
         Popover_iconoupdate_Popoverwidth = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Popoverwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_grid_Fixedfilters = httpContext.cgiGet( sPrefix+"DDO_GRID_Fixedfilters") ;
         Ddo_grid_Format = httpContext.cgiGet( sPrefix+"DDO_GRID_Format") ;
         Ddo_grid_Selectedfixedfilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedfixedfilter") ;
         Dvelop_confirmpanel_eliminar_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Title") ;
         Dvelop_confirmpanel_eliminar_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext") ;
         Dvelop_confirmpanel_eliminar_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminar_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype") ;
         Dvelop_confirmpanel_btneliminartodos_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Title") ;
         Dvelop_confirmpanel_btneliminartodos_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmationtext") ;
         Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Nobuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttonposition") ;
         Dvelop_confirmpanel_btneliminartodos_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmtype") ;
         Importexcel_modal_Width = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Width") ;
         Importexcel_modal_Title = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Title") ;
         Importexcel_modal_Confirmtype = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Confirmtype") ;
         Importexcel_modal_Bodytype = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Bodytype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Popoversingrid = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Popoversingrid") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumnfixedfilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumnfixedfilter") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         Dvelop_confirmpanel_eliminar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result") ;
         Dvelop_confirmpanel_btneliminartodos_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result") ;
         /* Read variables values. */
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
      e208I2 ();
      if (returnInSub) return;
   }

   public void e208I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Popover_iconoupdate_Gridinternalname = subGrid_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "GridInternalName", Popover_iconoupdate_Gridinternalname);
      Popover_iconoupdate_Iteminternalname = edtavIconoupdatewithtags_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "ItemInternalName", Popover_iconoupdate_Iteminternalname);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV16OrderedBy < 1 )
      {
         AV16OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV61DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV61DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      System.out.println( httpContext.getMessage( "hola", "") );
      if ( false )
      {
         new web.revalidarimplsddet(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, (short)(1)) ;
      }
      AV87modoTest = GXutil.boolval( new web.getparametro(remoteHandle, context).executeUdp( AV9CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ))) ;
      bttBtnimportartodos_Visible = (AV87modoTest ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnimportartodos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportartodos_Visible), 5, 0), true);
   }

   public void e218I2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_boolean3 = AV73detalleHay ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.hayimpliqdet(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, (short)(1), GXv_boolean4) ;
      importlsd2_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV73detalleHay = GXt_boolean3 ;
      divGridtablewithpaginationbar_Visible = (AV73detalleHay ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divGridtablewithpaginationbar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divGridtablewithpaginationbar_Visible), 5, 0), true);
      bttBtneliminartodos_Visible = (AV73detalleHay ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtneliminartodos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtneliminartodos_Visible), 5, 0), true);
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      AV64GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV64GridCurrentPage), 10, 0));
      AV65GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65GridPageCount), 10, 0));
      GXt_char6 = AV66GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV90Pgmname, GXv_char7) ;
      importlsd2_impl.this.GXt_char6 = GXv_char7[0] ;
      AV66GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66GridAppliedFilters", AV66GridAppliedFilters);
      AV91Importlsd2ds_1_clicod = AV9CliCod ;
      AV92Importlsd2ds_2_empcod = AV10EmpCod ;
      AV93Importlsd2ds_3_tficonoupdate = AV20TFiconoUpdate ;
      AV94Importlsd2ds_4_tficonoupdateoperator = AV21TFiconoUpdateOperator ;
      AV95Importlsd2ds_5_tfimpliqdetper = AV26TFImpLiqDetPer ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = AV27TFImpLiqDetPer_Sels ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = AV29TFImpLiqDetCUIL ;
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = AV30TFImpLiqDetCUIL_Sels ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = AV32TFImpLiqDetLegSis ;
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = AV33TFImpLiqDetLegSis_Sels ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = AV35TFImpLiqDetConCod ;
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = AV36TFImpLiqDetConCod_Sels ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = AV82TFImpLiqDetConSisYDes ;
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV83TFImpLiqDetConSisYDes_Sels ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = AV77TFImpLiqDetCantNum ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = AV78TFImpLiqDetCantNum_To ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = AV79TFImpLiqDetImpNum ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = AV80TFImpLiqDetImpNum_To ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = AV44TFImpLiqDetSigno ;
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = AV45TFImpLiqDetSigno_Sels ;
      /*  Sending Event outputs  */
   }

   public void e128I2( )
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
         AV63PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV63PageToGo) ;
      }
   }

   public void e138I2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e148I2( )
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
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "iconoUpdate") == 0 )
         {
            if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "1") == 0 )
            {
               AV21TFiconoUpdateOperator = (short)(1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TFiconoUpdateOperator), 4, 0));
               AV20TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TFiconoUpdate", AV20TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "2") == 0 )
            {
               AV21TFiconoUpdateOperator = (short)(2) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TFiconoUpdateOperator), 4, 0));
               AV20TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TFiconoUpdate", AV20TFiconoUpdate);
            }
            else
            {
               AV21TFiconoUpdateOperator = (short)(0) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TFiconoUpdateOperator), 4, 0));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetPer") == 0 )
         {
            AV26TFImpLiqDetPer = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFImpLiqDetPer", AV26TFImpLiqDetPer);
            AV25TFImpLiqDetPer_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFImpLiqDetPer_SelsJson", AV25TFImpLiqDetPer_SelsJson);
            AV27TFImpLiqDetPer_Sels.fromJSonString(AV25TFImpLiqDetPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetCUIL") == 0 )
         {
            AV29TFImpLiqDetCUIL = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFImpLiqDetCUIL", AV29TFImpLiqDetCUIL);
            AV28TFImpLiqDetCUIL_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFImpLiqDetCUIL_SelsJson", AV28TFImpLiqDetCUIL_SelsJson);
            AV30TFImpLiqDetCUIL_Sels.fromJSonString(AV28TFImpLiqDetCUIL_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetLegSis") == 0 )
         {
            AV32TFImpLiqDetLegSis = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFImpLiqDetLegSis", AV32TFImpLiqDetLegSis);
            AV31TFImpLiqDetLegSis_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFImpLiqDetLegSis_SelsJson", AV31TFImpLiqDetLegSis_SelsJson);
            AV33TFImpLiqDetLegSis_Sels.fromJSonString(AV31TFImpLiqDetLegSis_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetConCod") == 0 )
         {
            AV35TFImpLiqDetConCod = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFImpLiqDetConCod", AV35TFImpLiqDetConCod);
            AV34TFImpLiqDetConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFImpLiqDetConCod_SelsJson", AV34TFImpLiqDetConCod_SelsJson);
            AV36TFImpLiqDetConCod_Sels.fromJSonString(AV34TFImpLiqDetConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetConSisYDes") == 0 )
         {
            AV82TFImpLiqDetConSisYDes = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV82TFImpLiqDetConSisYDes", AV82TFImpLiqDetConSisYDes);
            AV81TFImpLiqDetConSisYDes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81TFImpLiqDetConSisYDes_SelsJson", AV81TFImpLiqDetConSisYDes_SelsJson);
            AV83TFImpLiqDetConSisYDes_Sels.fromJSonString(AV81TFImpLiqDetConSisYDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetCantNum") == 0 )
         {
            AV77TFImpLiqDetCantNum = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77TFImpLiqDetCantNum", GXutil.ltrimstr( AV77TFImpLiqDetCantNum, 6, 2));
            AV78TFImpLiqDetCantNum_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78TFImpLiqDetCantNum_To", GXutil.ltrimstr( AV78TFImpLiqDetCantNum_To, 6, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetImpNum") == 0 )
         {
            AV79TFImpLiqDetImpNum = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79TFImpLiqDetImpNum", GXutil.ltrimstr( AV79TFImpLiqDetImpNum, 16, 2));
            AV80TFImpLiqDetImpNum_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80TFImpLiqDetImpNum_To", GXutil.ltrimstr( AV80TFImpLiqDetImpNum_To, 16, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqDetSigno") == 0 )
         {
            AV44TFImpLiqDetSigno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFImpLiqDetSigno", AV44TFImpLiqDetSigno);
            AV43TFImpLiqDetSigno_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFImpLiqDetSigno_SelsJson", AV43TFImpLiqDetSigno_SelsJson);
            AV45TFImpLiqDetSigno_Sels.fromJSonString(AV43TFImpLiqDetSigno_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV45TFImpLiqDetSigno_Sels", AV45TFImpLiqDetSigno_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV83TFImpLiqDetConSisYDes_Sels", AV83TFImpLiqDetConSisYDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV36TFImpLiqDetConCod_Sels", AV36TFImpLiqDetConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV33TFImpLiqDetLegSis_Sels", AV33TFImpLiqDetLegSis_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV30TFImpLiqDetCUIL_Sels", AV30TFImpLiqDetCUIL_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV27TFImpLiqDetPer_Sels", AV27TFImpLiqDetPer_Sels);
   }

   private void e228I2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV67Eliminar = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminar_Internalname, AV67Eliminar);
      AV18iconoUpdate = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdate_Internalname, AV18iconoUpdate);
      GXt_char6 = AV84ImpLiqConExtDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getdescripexternaimportacionafip(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, A88ImpLiqSec, A666ImpLiqDetConCod, GXv_char7) ;
      importlsd2_impl.this.GXt_char6 = GXv_char7[0] ;
      AV84ImpLiqConExtDescrip = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavImpliqconextdescrip_Internalname, AV84ImpLiqConExtDescrip);
      AV62iconoUpdateWithTags = AV18iconoUpdate ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV62iconoUpdateWithTags);
      if ( ! (GXutil.strcmp("", A709ImpLiqDetError)==0) )
      {
         AV62iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconDanger FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Errores", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV62iconoUpdateWithTags);
      }
      if ( (GXutil.strcmp("", A709ImpLiqDetError)==0) )
      {
         AV62iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconSuccess FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Validado OK", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV62iconoUpdateWithTags);
      }
      AV62iconoUpdateWithTags += "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV62iconoUpdateWithTags);
      if ( (GXutil.strcmp("", A709ImpLiqDetError)==0) )
      {
         AV62iconoUpdateWithTags = GXutil.strReplace( AV62iconoUpdateWithTags, "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV62iconoUpdateWithTags);
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(39) ;
      }
      sendrow_392( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_39_Refreshing )
      {
         httpContext.doAjaxLoad(39, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e238I2( )
   {
      /* Eliminar_Click Routine */
      returnInSub = false ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "eliminar", ""), httpContext.getMessage( "Registro de LSD", ""), GXv_char7) ;
      importlsd2_impl.this.GXt_char6 = GXv_char7[0] ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = GXt_char6 ;
      ucDvelop_confirmpanel_eliminar.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_eliminar_Internalname, "ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
      AV69CliCod_Selected = A3CliCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69CliCod_Selected), 6, 0));
      AV70EmpCod_Selected = A1EmpCod ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70EmpCod_Selected), 4, 0));
      AV71ImpLiqSec_Selected = A88ImpLiqSec ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71ImpLiqSec_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71ImpLiqSec_Selected), 4, 0));
      AV72ImpLiqDetSec_Selected = A90ImpLiqDetSec ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72ImpLiqDetSec_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72ImpLiqDetSec_Selected), 4, 0));
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_ELIMINARContainer", "Confirm", "", new Object[] {});
      /*  Sending Event outputs  */
   }

   public void e158I2( )
   {
      /* Dvelop_confirmpanel_eliminar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ELIMINAR' */
         S172 ();
         if (returnInSub) return;
      }
      if ( GXutil.strcmp(Dvelop_confirmpanel_eliminar_Result, "Yes") == 0 )
      {
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      /*  Sending Event outputs  */
   }

   public void e188I2( )
   {
      /* 'DoimportarTodos' Routine */
      returnInSub = false ;
      new web.importartodoslsd_test(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, (short)(1), httpContext.getMessage( "LIQUIDACIONES", "")) ;
   }

   public void e198I2( )
   {
      /* 'DoEliminarTodos' Routine */
      returnInSub = false ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "eliminar", ""), httpContext.getMessage( "Todos los registros de LSD a importar", ""), GXv_char7) ;
      importlsd2_impl.this.GXt_char6 = GXv_char7[0] ;
      Dvelop_confirmpanel_btneliminartodos_Confirmationtext = GXt_char6 ;
      ucDvelop_confirmpanel_btneliminartodos.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_btneliminartodos_Internalname, "ConfirmationText", Dvelop_confirmpanel_btneliminartodos_Confirmationtext);
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer", "Confirm", "", new Object[] {});
      /*  Sending Event outputs  */
   }

   public void e168I2( )
   {
      /* Dvelop_confirmpanel_btneliminartodos_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_btneliminartodos_Result, "Yes") == 0 )
      {
         new web.eliminarimportaciondetalle(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, (short)(1), (short)(0), "") ;
      }
      if ( GXutil.strcmp(Dvelop_confirmpanel_btneliminartodos_Result, "Yes") == 0 )
      {
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV90Pgmname, AV20TFiconoUpdate, AV21TFiconoUpdateOperator, AV26TFImpLiqDetPer, AV27TFImpLiqDetPer_Sels, AV29TFImpLiqDetCUIL, AV30TFImpLiqDetCUIL_Sels, AV32TFImpLiqDetLegSis, AV33TFImpLiqDetLegSis_Sels, AV35TFImpLiqDetConCod, AV36TFImpLiqDetConCod_Sels, AV82TFImpLiqDetConSisYDes, AV83TFImpLiqDetConSisYDes_Sels, AV77TFImpLiqDetCantNum, AV78TFImpLiqDetCantNum_To, AV79TFImpLiqDetImpNum, AV80TFImpLiqDetImpNum_To, AV44TFImpLiqDetSigno, AV45TFImpLiqDetSigno_Sels, AV16OrderedBy, AV17OrderedDsc, AV91Importlsd2ds_1_clicod, AV92Importlsd2ds_2_empcod, sPrefix) ;
      }
      /*  Sending Event outputs  */
   }

   public void e178I2( )
   {
      /* Importexcel_modal_Close Routine */
      returnInSub = false ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV16OrderedBy, 4, 0))+":"+(AV17OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV68TempBoolean ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean4) ;
      importlsd2_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV68TempBoolean = GXt_boolean3 ;
      if ( ! ( AV68TempBoolean ) )
      {
         bttBtnimportexcel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnimportexcel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportexcel_Visible), 5, 0), true);
      }
   }

   public void S172( )
   {
      /* 'DO ELIMINAR' Routine */
      returnInSub = false ;
      new web.eliminarimportaciondetalle(remoteHandle, context).execute( AV69CliCod_Selected, AV70EmpCod_Selected, AV71ImpLiqSec_Selected, AV72ImpLiqDetSec_Selected, "") ;
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue(AV90Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV90Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV19Session.getValue(AV90Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      AV111GXV1 = 1 ;
      while ( AV111GXV1 <= AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV111GXV1));
         if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CLICOD") == 0 )
         {
            AV9CliCod = (int)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "EMPCOD") == 0 )
         {
            AV10EmpCod = (short)(GXutil.lval( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV21TFiconoUpdateOperator = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21TFiconoUpdateOperator), 4, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETPER") == 0 )
         {
            AV26TFImpLiqDetPer = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFImpLiqDetPer", AV26TFImpLiqDetPer);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETPER_SEL") == 0 )
         {
            AV25TFImpLiqDetPer_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFImpLiqDetPer_SelsJson", AV25TFImpLiqDetPer_SelsJson);
            AV27TFImpLiqDetPer_Sels.fromJSonString(AV25TFImpLiqDetPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCUIL") == 0 )
         {
            AV29TFImpLiqDetCUIL = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFImpLiqDetCUIL", AV29TFImpLiqDetCUIL);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCUIL_SEL") == 0 )
         {
            AV28TFImpLiqDetCUIL_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFImpLiqDetCUIL_SelsJson", AV28TFImpLiqDetCUIL_SelsJson);
            AV30TFImpLiqDetCUIL_Sels.fromJSonString(AV28TFImpLiqDetCUIL_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETLEGSIS") == 0 )
         {
            AV32TFImpLiqDetLegSis = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFImpLiqDetLegSis", AV32TFImpLiqDetLegSis);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETLEGSIS_SEL") == 0 )
         {
            AV31TFImpLiqDetLegSis_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFImpLiqDetLegSis_SelsJson", AV31TFImpLiqDetLegSis_SelsJson);
            AV33TFImpLiqDetLegSis_Sels.fromJSonString(AV31TFImpLiqDetLegSis_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONCOD") == 0 )
         {
            AV35TFImpLiqDetConCod = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFImpLiqDetConCod", AV35TFImpLiqDetConCod);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONCOD_SEL") == 0 )
         {
            AV34TFImpLiqDetConCod_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFImpLiqDetConCod_SelsJson", AV34TFImpLiqDetConCod_SelsJson);
            AV36TFImpLiqDetConCod_Sels.fromJSonString(AV34TFImpLiqDetConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONSISYDES") == 0 )
         {
            AV82TFImpLiqDetConSisYDes = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV82TFImpLiqDetConSisYDes", AV82TFImpLiqDetConSisYDes);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONSISYDES_SEL") == 0 )
         {
            AV81TFImpLiqDetConSisYDes_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81TFImpLiqDetConSisYDes_SelsJson", AV81TFImpLiqDetConSisYDes_SelsJson);
            AV83TFImpLiqDetConSisYDes_Sels.fromJSonString(AV81TFImpLiqDetConSisYDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCANTNUM") == 0 )
         {
            AV77TFImpLiqDetCantNum = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77TFImpLiqDetCantNum", GXutil.ltrimstr( AV77TFImpLiqDetCantNum, 6, 2));
            AV78TFImpLiqDetCantNum_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78TFImpLiqDetCantNum_To", GXutil.ltrimstr( AV78TFImpLiqDetCantNum_To, 6, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETIMPNUM") == 0 )
         {
            AV79TFImpLiqDetImpNum = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79TFImpLiqDetImpNum", GXutil.ltrimstr( AV79TFImpLiqDetImpNum, 16, 2));
            AV80TFImpLiqDetImpNum_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80TFImpLiqDetImpNum_To", GXutil.ltrimstr( AV80TFImpLiqDetImpNum_To, 16, 2));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETSIGNO") == 0 )
         {
            AV44TFImpLiqDetSigno = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TFImpLiqDetSigno", AV44TFImpLiqDetSigno);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETSIGNO_SEL") == 0 )
         {
            AV43TFImpLiqDetSigno_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43TFImpLiqDetSigno_SelsJson", AV43TFImpLiqDetSigno_SelsJson);
            AV45TFImpLiqDetSigno_Sels.fromJSonString(AV43TFImpLiqDetSigno_SelsJson, null);
         }
         AV111GXV1 = (int)(AV111GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV27TFImpLiqDetPer_Sels.size()==0), AV25TFImpLiqDetPer_SelsJson, GXv_char7) ;
      importlsd2_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFImpLiqDetCUIL_Sels.size()==0), AV28TFImpLiqDetCUIL_SelsJson, GXv_char9) ;
      importlsd2_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV33TFImpLiqDetLegSis_Sels.size()==0), AV31TFImpLiqDetLegSis_SelsJson, GXv_char11) ;
      importlsd2_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV36TFImpLiqDetConCod_Sels.size()==0), AV34TFImpLiqDetConCod_SelsJson, GXv_char13) ;
      importlsd2_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV83TFImpLiqDetConSisYDes_Sels.size()==0), AV81TFImpLiqDetConSisYDes_SelsJson, GXv_char15) ;
      importlsd2_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV45TFImpLiqDetSigno_Sels.size()==0), AV43TFImpLiqDetSigno_SelsJson, GXv_char17) ;
      importlsd2_impl.this.GXt_char16 = GXv_char17[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|"+GXt_char8+"|"+GXt_char10+"|"+GXt_char12+"|"+GXt_char14+"|||"+GXt_char16 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV26TFImpLiqDetPer)==0), AV26TFImpLiqDetPer, GXv_char17) ;
      importlsd2_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFImpLiqDetCUIL)==0), AV29TFImpLiqDetCUIL, GXv_char15) ;
      importlsd2_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFImpLiqDetLegSis)==0), AV32TFImpLiqDetLegSis, GXv_char13) ;
      importlsd2_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV35TFImpLiqDetConCod)==0), AV35TFImpLiqDetConCod, GXv_char11) ;
      importlsd2_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV82TFImpLiqDetConSisYDes)==0), AV82TFImpLiqDetConSisYDes, GXv_char9) ;
      importlsd2_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV44TFImpLiqDetSigno)==0), AV44TFImpLiqDetSigno, GXv_char7) ;
      importlsd2_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = "|"+GXt_char16+"|"+GXt_char14+"|"+GXt_char12+"|"+GXt_char10+"|"+GXt_char8+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV77TFImpLiqDetCantNum)==0) ? "" : GXutil.str( AV77TFImpLiqDetCantNum, 6, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV79TFImpLiqDetImpNum)==0) ? "" : GXutil.str( AV79TFImpLiqDetImpNum, 16, 2))+"|"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV78TFImpLiqDetCantNum_To)==0) ? "" : GXutil.str( AV78TFImpLiqDetCantNum_To, 6, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFImpLiqDetImpNum_To)==0) ? "" : GXutil.str( AV80TFImpLiqDetImpNum_To, 16, 2))+"|" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      Ddo_grid_Selectedfixedfilter = ((AV21TFiconoUpdateOperator!=1) ? "" : "1")+((AV21TFiconoUpdateOperator!=2) ? "" : "2")+"||||||||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedFixedFilter", Ddo_grid_Selectedfixedfilter);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV14GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV14GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV14GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV14GridState.fromxml(AV19Session.getValue(AV90Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "CLICOD", httpContext.getMessage( "Cli Cod", ""), !(0==AV9CliCod), (short)(0), GXutil.trim( GXutil.str( AV9CliCod, 6, 0)), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "EMPCOD", httpContext.getMessage( "Empresa", ""), !(0==AV10EmpCod), (short)(0), GXutil.trim( GXutil.str( AV10EmpCod, 4, 0)), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFICONOUPDATE", httpContext.getMessage( "Estado", ""), !((GXutil.strcmp("", AV20TFiconoUpdate)==0)&&(0==AV21TFiconoUpdateOperator)), AV21TFiconoUpdateOperator, AV20TFiconoUpdate, "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETPER", httpContext.getMessage( "Periodo", ""), !(GXutil.strcmp("", AV26TFImpLiqDetPer)==0), (short)(0), AV26TFImpLiqDetPer, "", !(AV27TFImpLiqDetPer_Sels.size()==0), AV27TFImpLiqDetPer_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETCUIL", httpContext.getMessage( "CUIL", ""), !(GXutil.strcmp("", AV29TFImpLiqDetCUIL)==0), (short)(0), AV29TFImpLiqDetCUIL, "", !(AV30TFImpLiqDetCUIL_Sels.size()==0), AV30TFImpLiqDetCUIL_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETLEGSIS", httpContext.getMessage( "Legajo", ""), !(GXutil.strcmp("", AV32TFImpLiqDetLegSis)==0), (short)(0), AV32TFImpLiqDetLegSis, "", !(AV33TFImpLiqDetLegSis_Sels.size()==0), AV33TFImpLiqDetLegSis_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETCONCOD", httpContext.getMessage( "Concepto Externo", ""), !(GXutil.strcmp("", AV35TFImpLiqDetConCod)==0), (short)(0), AV35TFImpLiqDetConCod, "", !(AV36TFImpLiqDetConCod_Sels.size()==0), AV36TFImpLiqDetConCod_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETCONSISYDES", httpContext.getMessage( "Concepto Sistema", ""), !(GXutil.strcmp("", AV82TFImpLiqDetConSisYDes)==0), (short)(0), AV82TFImpLiqDetConSisYDes, "", !(AV83TFImpLiqDetConSisYDes_Sels.size()==0), AV83TFImpLiqDetConSisYDes_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETCANTNUM", httpContext.getMessage( "Cantidad", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV77TFImpLiqDetCantNum)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV78TFImpLiqDetCantNum_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV77TFImpLiqDetCantNum, 6, 2)), GXutil.trim( GXutil.str( AV78TFImpLiqDetCantNum_To, 6, 2))) ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETIMPNUM", httpContext.getMessage( "Importe", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV79TFImpLiqDetImpNum)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFImpLiqDetImpNum_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV79TFImpLiqDetImpNum, 16, 2)), GXutil.trim( GXutil.str( AV80TFImpLiqDetImpNum_To, 16, 2))) ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFIMPLIQDETSIGNO", httpContext.getMessage( "Signo", ""), !(GXutil.strcmp("", AV44TFImpLiqDetSigno)==0), (short)(0), AV44TFImpLiqDetSigno, "", !(AV45TFImpLiqDetSigno_Sels.size()==0), AV45TFImpLiqDetSigno_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState18[0] ;
      if ( ! (0==AV9CliCod) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV9CliCod, 6, 0) );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      if ( ! (0==AV10EmpCod) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV10EmpCod, 4, 0) );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      AV14GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV14GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV90Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV90Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "importacion_liquidacion_detalle" );
      AV19Session.setValue("TrnContext", AV12TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue(AV90Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV90Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV19Session.getValue(AV90Pgmname+"GridState"), null, null);
      }
      if ( ! ( false ) )
      {
         edtavClicod_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClicod_Visible), 5, 0), true);
         GXv_SdtWWPGridState18[0] = AV14GridState;
         if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState18, "CLICOD", false) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV14GridState = GXv_SdtWWPGridState18[0] ;
         if ( Cond_result )
         {
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV90Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
         }
      }
      if ( ! ( false ) )
      {
         edtavEmpcod_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEmpcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpcod_Visible), 5, 0), true);
         GXv_SdtWWPGridState18[0] = AV14GridState;
         if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState18, "EMPCOD", false) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV14GridState = GXv_SdtWWPGridState18[0] ;
         if ( Cond_result )
         {
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV90Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
         }
      }
   }

   public void wb_table4_88_8I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTableimportexcel_modal_Internalname, tblTableimportexcel_modal_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucImportexcel_modal.setProperty("Width", Importexcel_modal_Width);
         ucImportexcel_modal.setProperty("Title", Importexcel_modal_Title);
         ucImportexcel_modal.setProperty("ConfirmType", Importexcel_modal_Confirmtype);
         ucImportexcel_modal.setProperty("BodyType", Importexcel_modal_Bodytype);
         ucImportexcel_modal.render(context, "dvelop.gxbootstrap.confirmpanel", Importexcel_modal_Internalname, sPrefix+"IMPORTEXCEL_MODALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"IMPORTEXCEL_MODALContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_88_8I2e( true) ;
      }
      else
      {
         wb_table4_88_8I2e( false) ;
      }
   }

   public void wb_table3_83_8I2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_btneliminartodos_Internalname, tblTabledvelop_confirmpanel_btneliminartodos_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_btneliminartodos.setProperty("Title", Dvelop_confirmpanel_btneliminartodos_Title);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("ConfirmationText", Dvelop_confirmpanel_btneliminartodos_Confirmationtext);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("YesButtonCaption", Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("NoButtonCaption", Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("CancelButtonCaption", Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("YesButtonPosition", Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition);
         ucDvelop_confirmpanel_btneliminartodos.setProperty("ConfirmType", Dvelop_confirmpanel_btneliminartodos_Confirmtype);
         ucDvelop_confirmpanel_btneliminartodos.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_btneliminartodos_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_83_8I2e( true) ;
      }
      else
      {
         wb_table3_83_8I2e( false) ;
      }
   }

   public void wb_table2_78_8I2( boolean wbgen )
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
         wb_table2_78_8I2e( true) ;
      }
      else
      {
         wb_table2_78_8I2e( false) ;
      }
   }

   public void wb_table1_15_8I2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total: ", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_ImportLSD2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, httpContext.getMessage( " X registros", ""), "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", 1, 1, 0, (short)(0), "HLP_ImportLSD2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_15_8I2e( true) ;
      }
      else
      {
         wb_table1_15_8I2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV9CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      AV10EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
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
      pa8I2( ) ;
      ws8I2( ) ;
      we8I2( ) ;
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
      sCtrlAV9CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV10EmpCod = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa8I2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importlsd2", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa8I2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV9CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         AV10EmpCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      }
      wcpOAV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( AV9CliCod != wcpOAV9CliCod ) || ( AV10EmpCod != wcpOAV10EmpCod ) ) )
      {
         setjustcreated();
      }
      wcpOAV9CliCod = AV9CliCod ;
      wcpOAV10EmpCod = AV10EmpCod ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV9CliCod = httpContext.cgiGet( sPrefix+"AV9CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV9CliCod) > 0 )
      {
         AV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV9CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      }
      else
      {
         AV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV9CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV10EmpCod = httpContext.cgiGet( sPrefix+"AV10EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV10EmpCod) > 0 )
      {
         AV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV10EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10EmpCod), 4, 0));
      }
      else
      {
         AV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV10EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa8I2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws8I2( ) ;
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
      ws8I2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV9CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9CliCod_CTRL", GXutil.rtrim( sCtrlAV9CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10EmpCod_CTRL", GXutil.rtrim( sCtrlAV10EmpCod));
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
      we8I2( ) ;
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
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         WebComp_Wwpaux_wc.componentjscripts();
      }
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
         {
            WebComp_Wwpaux_wc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020122195", true, true);
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
      httpContext.AddJavascriptSource("importlsd2.js", "?2024122020122195", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_392( )
   {
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS_"+sGXsfl_39_idx ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE_"+sGXsfl_39_idx ;
      edtavEliminar_Internalname = sPrefix+"vELIMINAR_"+sGXsfl_39_idx ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC_"+sGXsfl_39_idx ;
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_39_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_39_idx ;
      edtImpLiqDetSec_Internalname = sPrefix+"IMPLIQDETSEC_"+sGXsfl_39_idx ;
      edtImpLiqDetError_Internalname = sPrefix+"IMPLIQDETERROR_"+sGXsfl_39_idx ;
      edtImpLiqDetLiqN_Internalname = sPrefix+"IMPLIQDETLIQN_"+sGXsfl_39_idx ;
      edtImpLiqDetPer_Internalname = sPrefix+"IMPLIQDETPER_"+sGXsfl_39_idx ;
      edtImpLiqDetCUIL_Internalname = sPrefix+"IMPLIQDETCUIL_"+sGXsfl_39_idx ;
      edtImpLiqDetLegSis_Internalname = sPrefix+"IMPLIQDETLEGSIS_"+sGXsfl_39_idx ;
      edtImpLiqDetLegId_Internalname = sPrefix+"IMPLIQDETLEGID_"+sGXsfl_39_idx ;
      edtImpLiqDetConCod_Internalname = sPrefix+"IMPLIQDETCONCOD_"+sGXsfl_39_idx ;
      edtavImpliqconextdescrip_Internalname = sPrefix+"vIMPLIQCONEXTDESCRIP_"+sGXsfl_39_idx ;
      edtImpLiqDetConSisYDes_Internalname = sPrefix+"IMPLIQDETCONSISYDES_"+sGXsfl_39_idx ;
      edtImpLiqDetCantNum_Internalname = sPrefix+"IMPLIQDETCANTNUM_"+sGXsfl_39_idx ;
      edtImpLiqDetUni_Internalname = sPrefix+"IMPLIQDETUNI_"+sGXsfl_39_idx ;
      edtImpLiqDetImpNum_Internalname = sPrefix+"IMPLIQDETIMPNUM_"+sGXsfl_39_idx ;
      edtImpLiqDetSigno_Internalname = sPrefix+"IMPLIQDETSIGNO_"+sGXsfl_39_idx ;
   }

   public void subsflControlProps_fel_392( )
   {
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS_"+sGXsfl_39_fel_idx ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE_"+sGXsfl_39_fel_idx ;
      edtavEliminar_Internalname = sPrefix+"vELIMINAR_"+sGXsfl_39_fel_idx ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC_"+sGXsfl_39_fel_idx ;
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_39_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetSec_Internalname = sPrefix+"IMPLIQDETSEC_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetError_Internalname = sPrefix+"IMPLIQDETERROR_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetLiqN_Internalname = sPrefix+"IMPLIQDETLIQN_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetPer_Internalname = sPrefix+"IMPLIQDETPER_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetCUIL_Internalname = sPrefix+"IMPLIQDETCUIL_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetLegSis_Internalname = sPrefix+"IMPLIQDETLEGSIS_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetLegId_Internalname = sPrefix+"IMPLIQDETLEGID_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetConCod_Internalname = sPrefix+"IMPLIQDETCONCOD_"+sGXsfl_39_fel_idx ;
      edtavImpliqconextdescrip_Internalname = sPrefix+"vIMPLIQCONEXTDESCRIP_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetConSisYDes_Internalname = sPrefix+"IMPLIQDETCONSISYDES_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetCantNum_Internalname = sPrefix+"IMPLIQDETCANTNUM_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetUni_Internalname = sPrefix+"IMPLIQDETUNI_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetImpNum_Internalname = sPrefix+"IMPLIQDETIMPNUM_"+sGXsfl_39_fel_idx ;
      edtImpLiqDetSigno_Internalname = sPrefix+"IMPLIQDETSIGNO_"+sGXsfl_39_fel_idx ;
   }

   public void sendrow_392( )
   {
      subsflControlProps_392( ) ;
      wb8I0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_39_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_39_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_39_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 40,'"+sPrefix+"',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdatewithtags_Internalname,AV62iconoUpdateWithTags,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,40);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavIconoupdatewithtags_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavIconoupdatewithtags_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 41,'"+sPrefix+"',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdate_Internalname,GXutil.rtrim( AV18iconoUpdate),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,41);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+"e248i2_client"+"'","","","","",edtavIconoupdate_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavIconoupdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'"+sPrefix+"',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminar_Internalname,GXutil.rtrim( AV67Eliminar),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,42);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVELIMINAR.CLICK."+sGXsfl_39_idx+"'","","","","",edtavEliminar_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqSec_Internalname,GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetSec_Internalname,GXutil.ltrim( localUtil.ntoc( A90ImpLiqDetSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A90ImpLiqDetSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetError_Internalname,A709ImpLiqDetError,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetError_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"error","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetLiqN_Internalname,GXutil.rtrim( A662ImpLiqDetLiqN),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetLiqN_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetPer_Internalname,GXutil.rtrim( A661ImpLiqDetPer),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetPer_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetCUIL_Internalname,GXutil.rtrim( A663ImpLiqDetCUIL),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetLegSis_Internalname,A712ImpLiqDetLegSis,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetLegSis_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetLegId_Internalname,GXutil.rtrim( A664ImpLiqDetLegId),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetLegId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetConCod_Internalname,GXutil.rtrim( A666ImpLiqDetConCod),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetConCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavImpliqconextdescrip_Enabled!=0)&&(edtavImpliqconextdescrip_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 54,'"+sPrefix+"',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavImpliqconextdescrip_Internalname,AV84ImpLiqConExtDescrip,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavImpliqconextdescrip_Enabled!=0)&&(edtavImpliqconextdescrip_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,54);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavImpliqconextdescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavImpliqconextdescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetConSisYDes_Internalname,A714ImpLiqDetConSisYDes,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetConSisYDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetCantNum_Internalname,GXutil.ltrim( localUtil.ntoc( A715ImpLiqDetCantNum, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A715ImpLiqDetCantNum, "ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetCantNum_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetUni_Internalname,GXutil.rtrim( A668ImpLiqDetUni),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetUni_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetImpNum_Internalname,GXutil.ltrim( localUtil.ntoc( A716ImpLiqDetImpNum, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A716ImpLiqDetImpNum, "ZZZZZZZZZZZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetImpNum_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(16),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqDetSigno_Internalname,GXutil.rtrim( A670ImpLiqDetSigno),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqDetSigno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes8I2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_39_idx = ((subGrid_Islastpage==1)&&(nGXsfl_39_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_39_idx+1) ;
         sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_392( ) ;
      }
      /* End function sendrow_392 */
   }

   public void startgridcontrol39( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"39\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp Liq Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cli Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Empresa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp Liq Det Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp Liq Det Error", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro Liq", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp Liq Det Leg Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto Externo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto Sistema", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp Liq Det Uni", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Signo", "")) ;
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
         GridColumn.AddObjectProperty("Value", AV62iconoUpdateWithTags);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdatewithtags_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18iconoUpdate));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV67Eliminar));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A90ImpLiqDetSec, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A709ImpLiqDetError);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A662ImpLiqDetLiqN));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A661ImpLiqDetPer));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A663ImpLiqDetCUIL));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A712ImpLiqDetLegSis);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A664ImpLiqDetLegId));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A666ImpLiqDetConCod));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV84ImpLiqConExtDescrip);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavImpliqconextdescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A714ImpLiqDetConSisYDes);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A715ImpLiqDetCantNum, (byte)(6), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A668ImpLiqDetUni));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A716ImpLiqDetImpNum, (byte)(16), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A670ImpLiqDetSigno));
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
      bttBtnimportartodos_Internalname = sPrefix+"BTNIMPORTARTODOS" ;
      bttBtneliminartodos_Internalname = sPrefix+"BTNELIMINARTODOS" ;
      bttBtnimportexcel_Internalname = sPrefix+"BTNIMPORTEXCEL" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS" ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE" ;
      edtavEliminar_Internalname = sPrefix+"vELIMINAR" ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtImpLiqDetSec_Internalname = sPrefix+"IMPLIQDETSEC" ;
      edtImpLiqDetError_Internalname = sPrefix+"IMPLIQDETERROR" ;
      edtImpLiqDetLiqN_Internalname = sPrefix+"IMPLIQDETLIQN" ;
      edtImpLiqDetPer_Internalname = sPrefix+"IMPLIQDETPER" ;
      edtImpLiqDetCUIL_Internalname = sPrefix+"IMPLIQDETCUIL" ;
      edtImpLiqDetLegSis_Internalname = sPrefix+"IMPLIQDETLEGSIS" ;
      edtImpLiqDetLegId_Internalname = sPrefix+"IMPLIQDETLEGID" ;
      edtImpLiqDetConCod_Internalname = sPrefix+"IMPLIQDETCONCOD" ;
      edtavImpliqconextdescrip_Internalname = sPrefix+"vIMPLIQCONEXTDESCRIP" ;
      edtImpLiqDetConSisYDes_Internalname = sPrefix+"IMPLIQDETCONSISYDES" ;
      edtImpLiqDetCantNum_Internalname = sPrefix+"IMPLIQDETCANTNUM" ;
      edtImpLiqDetUni_Internalname = sPrefix+"IMPLIQDETUNI" ;
      edtImpLiqDetImpNum_Internalname = sPrefix+"IMPLIQDETIMPNUM" ;
      edtImpLiqDetSigno_Internalname = sPrefix+"IMPLIQDETSIGNO" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      edtavClicod_Internalname = sPrefix+"vCLICOD" ;
      edtavEmpcod_Internalname = sPrefix+"vEMPCOD" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Popover_iconoupdate_Internalname = sPrefix+"POPOVER_ICONOUPDATE" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      Dvelop_confirmpanel_eliminar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR" ;
      tblTabledvelop_confirmpanel_eliminar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_ELIMINAR" ;
      Dvelop_confirmpanel_btneliminartodos_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS" ;
      tblTabledvelop_confirmpanel_btneliminartodos_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_BTNELIMINARTODOS" ;
      Importexcel_modal_Internalname = sPrefix+"IMPORTEXCEL_MODAL" ;
      tblTableimportexcel_modal_Internalname = sPrefix+"TABLEIMPORTEXCEL_MODAL" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      divDiv_wwpauxwc_Internalname = sPrefix+"DIV_WWPAUXWC" ;
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
      edtImpLiqDetSigno_Jsonclick = "" ;
      edtImpLiqDetImpNum_Jsonclick = "" ;
      edtImpLiqDetUni_Jsonclick = "" ;
      edtImpLiqDetCantNum_Jsonclick = "" ;
      edtImpLiqDetConSisYDes_Jsonclick = "" ;
      edtavImpliqconextdescrip_Jsonclick = "" ;
      edtavImpliqconextdescrip_Visible = -1 ;
      edtavImpliqconextdescrip_Enabled = 1 ;
      edtImpLiqDetConCod_Jsonclick = "" ;
      edtImpLiqDetLegId_Jsonclick = "" ;
      edtImpLiqDetLegSis_Jsonclick = "" ;
      edtImpLiqDetCUIL_Jsonclick = "" ;
      edtImpLiqDetPer_Jsonclick = "" ;
      edtImpLiqDetLiqN_Jsonclick = "" ;
      edtImpLiqDetError_Jsonclick = "" ;
      edtImpLiqDetSec_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtImpLiqSec_Jsonclick = "" ;
      edtavEliminar_Jsonclick = "" ;
      edtavEliminar_Visible = -1 ;
      edtavEliminar_Enabled = 1 ;
      edtavIconoupdate_Jsonclick = "" ;
      edtavIconoupdate_Visible = 0 ;
      edtavIconoupdate_Enabled = 1 ;
      edtavIconoupdatewithtags_Jsonclick = "" ;
      edtavIconoupdatewithtags_Visible = -1 ;
      edtavIconoupdatewithtags_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Sortable = (byte)(0) ;
      edtavEmpcod_Jsonclick = "" ;
      edtavEmpcod_Enabled = 0 ;
      edtavEmpcod_Visible = 1 ;
      edtavClicod_Jsonclick = "" ;
      edtavClicod_Enabled = 0 ;
      edtavClicod_Visible = 1 ;
      divGridtablewithpaginationbar_Visible = 1 ;
      bttBtnimportexcel_Visible = 1 ;
      bttBtneliminartodos_Visible = 1 ;
      bttBtnimportartodos_Visible = 1 ;
      Grid_empowerer_Popoversingrid = "Popover_iconoUpdate" ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Importexcel_modal_Bodytype = "WebComponent" ;
      Importexcel_modal_Confirmtype = "" ;
      Importexcel_modal_Title = httpContext.getMessage( "Importar archivo", "") ;
      Importexcel_modal_Width = "400" ;
      Dvelop_confirmpanel_btneliminartodos_Confirmtype = "1" ;
      Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_btneliminartodos_Confirmationtext = "" ;
      Dvelop_confirmpanel_btneliminartodos_Title = "" ;
      Dvelop_confirmpanel_eliminar_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = "" ;
      Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "Eliminar", "") ;
      Ddo_grid_Format = "||||||6.2|16.2|" ;
      Ddo_grid_Fixedfilters = "1:Con Errores:fa fa-circle FontColorIconDanger FontColorIconSmall ConditionalFormattingFilterIcon,2:Validados OK:fa fa-circle FontColorIconSuccess FontColorIconSmall ConditionalFormattingFilterIcon||||||||" ;
      Ddo_grid_Datalistproc = "ImportLSD2GetFilterData" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|T|T|||T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|||Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|T|||T" ;
      Ddo_grid_Filterisrange = "||||||T|T|" ;
      Ddo_grid_Filtertype = "|Character|Character|Character|Character|Character|Numeric|Numeric|Character" ;
      Ddo_grid_Includefilter = "|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|1|2|3|4|5|6|7|8" ;
      Ddo_grid_Columnids = "0:iconoUpdate|9:ImpLiqDetPer|10:ImpLiqDetCUIL|11:ImpLiqDetLegSis|13:ImpLiqDetConCod|15:ImpLiqDetConSisYDes|16:ImpLiqDetCantNum|18:ImpLiqDetImpNum|19:ImpLiqDetSigno" ;
      Ddo_grid_Gridinternalname = "" ;
      Popover_iconoupdate_Popoverwidth = 400 ;
      Popover_iconoupdate_Isgriditem = GXutil.toBoolean( -1) ;
      Popover_iconoupdate_Iteminternalname = "" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV64GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV65GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV66GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e128I2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e138I2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e148I2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumnfixedfilter',ctrl:'DDO_GRID',prop:'SelectedColumnFixedFilter'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV43TFImpLiqDetSigno_SelsJson',fld:'vTFIMPLIQDETSIGNO_SELSJSON',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV81TFImpLiqDetConSisYDes_SelsJson',fld:'vTFIMPLIQDETCONSISYDES_SELSJSON',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV34TFImpLiqDetConCod_SelsJson',fld:'vTFIMPLIQDETCONCOD_SELSJSON',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV31TFImpLiqDetLegSis_SelsJson',fld:'vTFIMPLIQDETLEGSIS_SELSJSON',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV28TFImpLiqDetCUIL_SelsJson',fld:'vTFIMPLIQDETCUIL_SELSJSON',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV25TFImpLiqDetPer_SelsJson',fld:'vTFIMPLIQDETPER_SELSJSON',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e228I2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'A666ImpLiqDetConCod',fld:'IMPLIQDETCONCOD',pic:''},{av:'A709ImpLiqDetError',fld:'IMPLIQDETERROR',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV67Eliminar',fld:'vELIMINAR',pic:''},{av:'AV18iconoUpdate',fld:'vICONOUPDATE',pic:''},{av:'AV84ImpLiqConExtDescrip',fld:'vIMPLIQCONEXTDESCRIP',pic:''},{av:'AV62iconoUpdateWithTags',fld:'vICONOUPDATEWITHTAGS',pic:''}]}");
      setEventMetadata("VELIMINAR.CLICK","{handler:'e238I2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'A90ImpLiqDetSec',fld:'IMPLIQDETSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VELIMINAR.CLICK",",oparms:[{av:'Dvelop_confirmpanel_eliminar_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'ConfirmationText'},{av:'AV69CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV70EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV71ImpLiqSec_Selected',fld:'vIMPLIQSEC_SELECTED',pic:'ZZZ9'},{av:'AV72ImpLiqDetSec_Selected',fld:'vIMPLIQDETSEC_SELECTED',pic:'ZZZ9'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE","{handler:'e158I2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'Dvelop_confirmpanel_eliminar_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'Result'},{av:'AV69CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV70EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV71ImpLiqSec_Selected',fld:'vIMPLIQSEC_SELECTED',pic:'ZZZ9'},{av:'AV72ImpLiqDetSec_Selected',fld:'vIMPLIQDETSEC_SELECTED',pic:'ZZZ9'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV64GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV65GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV66GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("'DOIMPORTARTODOS'","{handler:'e188I2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("'DOIMPORTARTODOS'",",oparms:[]}");
      setEventMetadata("'DOELIMINARTODOS'","{handler:'e198I2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOELIMINARTODOS'",",oparms:[{av:'Dvelop_confirmpanel_btneliminartodos_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_BTNELIMINARTODOS',prop:'ConfirmationText'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNELIMINARTODOS.CLOSE","{handler:'e168I2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'},{av:'Dvelop_confirmpanel_btneliminartodos_Result',ctrl:'DVELOP_CONFIRMPANEL_BTNELIMINARTODOS',prop:'Result'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_BTNELIMINARTODOS.CLOSE",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV64GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV65GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV66GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("'DOIMPORTEXCEL'","{handler:'e118I1',iparms:[]");
      setEventMetadata("'DOIMPORTEXCEL'",",oparms:[]}");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE","{handler:'e178I2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV90Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV21TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV26TFImpLiqDetPer',fld:'vTFIMPLIQDETPER',pic:''},{av:'AV27TFImpLiqDetPer_Sels',fld:'vTFIMPLIQDETPER_SELS',pic:''},{av:'AV29TFImpLiqDetCUIL',fld:'vTFIMPLIQDETCUIL',pic:''},{av:'AV30TFImpLiqDetCUIL_Sels',fld:'vTFIMPLIQDETCUIL_SELS',pic:''},{av:'AV32TFImpLiqDetLegSis',fld:'vTFIMPLIQDETLEGSIS',pic:''},{av:'AV33TFImpLiqDetLegSis_Sels',fld:'vTFIMPLIQDETLEGSIS_SELS',pic:''},{av:'AV35TFImpLiqDetConCod',fld:'vTFIMPLIQDETCONCOD',pic:''},{av:'AV36TFImpLiqDetConCod_Sels',fld:'vTFIMPLIQDETCONCOD_SELS',pic:''},{av:'AV82TFImpLiqDetConSisYDes',fld:'vTFIMPLIQDETCONSISYDES',pic:''},{av:'AV83TFImpLiqDetConSisYDes_Sels',fld:'vTFIMPLIQDETCONSISYDES_SELS',pic:''},{av:'AV77TFImpLiqDetCantNum',fld:'vTFIMPLIQDETCANTNUM',pic:'ZZ9.99'},{av:'AV78TFImpLiqDetCantNum_To',fld:'vTFIMPLIQDETCANTNUM_TO',pic:'ZZ9.99'},{av:'AV79TFImpLiqDetImpNum',fld:'vTFIMPLIQDETIMPNUM',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV80TFImpLiqDetImpNum_To',fld:'vTFIMPLIQDETIMPNUM_TO',pic:'ZZZZZZZZZZZZ9.99'},{av:'AV44TFImpLiqDetSigno',fld:'vTFIMPLIQDETSIGNO',pic:''},{av:'AV45TFImpLiqDetSigno_Sels',fld:'vTFIMPLIQDETSIGNO_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV91Importlsd2ds_1_clicod',fld:'vIMPORTLSD2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV92Importlsd2ds_2_empcod',fld:'vIMPORTLSD2DS_2_EMPCOD',pic:'ZZZ9'},{av:'sPrefix'}]");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV64GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV65GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV66GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("VICONOUPDATE.CLICK","{handler:'e248I2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A709ImpLiqDetError',fld:'IMPLIQDETERROR',pic:'',hsh:true}]");
      setEventMetadata("VICONOUPDATE.CLICK",",oparms:[{ctrl:'WWPAUX_WC'}]}");
      setEventMetadata("NULL","{handler:'valid_Impliqdetsigno',iparms:[]");
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
      Ddo_grid_Selectedcolumnfixedfilter = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Dvelop_confirmpanel_eliminar_Result = "" ;
      Dvelop_confirmpanel_btneliminartodos_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV90Pgmname = "" ;
      AV20TFiconoUpdate = "" ;
      AV26TFImpLiqDetPer = "" ;
      AV27TFImpLiqDetPer_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29TFImpLiqDetCUIL = "" ;
      AV30TFImpLiqDetCUIL_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32TFImpLiqDetLegSis = "" ;
      AV33TFImpLiqDetLegSis_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFImpLiqDetConCod = "" ;
      AV36TFImpLiqDetConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82TFImpLiqDetConSisYDes = "" ;
      AV83TFImpLiqDetConSisYDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77TFImpLiqDetCantNum = DecimalUtil.ZERO ;
      AV78TFImpLiqDetCantNum_To = DecimalUtil.ZERO ;
      AV79TFImpLiqDetImpNum = DecimalUtil.ZERO ;
      AV80TFImpLiqDetImpNum_To = DecimalUtil.ZERO ;
      AV44TFImpLiqDetSigno = "" ;
      AV45TFImpLiqDetSigno_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV66GridAppliedFilters = "" ;
      AV61DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV8ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      Popover_iconoupdate_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_grid_Selectedfixedfilter = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnimportartodos_Jsonclick = "" ;
      bttBtneliminartodos_Jsonclick = "" ;
      bttBtnimportexcel_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucPopover_iconoupdate = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV62iconoUpdateWithTags = "" ;
      AV18iconoUpdate = "" ;
      AV67Eliminar = "" ;
      A709ImpLiqDetError = "" ;
      A662ImpLiqDetLiqN = "" ;
      A661ImpLiqDetPer = "" ;
      A663ImpLiqDetCUIL = "" ;
      A712ImpLiqDetLegSis = "" ;
      A664ImpLiqDetLegId = "" ;
      A666ImpLiqDetConCod = "" ;
      AV84ImpLiqConExtDescrip = "" ;
      A714ImpLiqDetConSisYDes = "" ;
      A715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      A668ImpLiqDetUni = "" ;
      A716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      A670ImpLiqDetSigno = "" ;
      AV96Importlsd2ds_6_tfimpliqdetper_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98Importlsd2ds_8_tfimpliqdetcuil_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Importlsd2ds_10_tfimpliqdetlegsis_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV102Importlsd2ds_12_tfimpliqdetconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV110Importlsd2ds_20_tfimpliqdetsigno_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV95Importlsd2ds_5_tfimpliqdetper = "" ;
      lV97Importlsd2ds_7_tfimpliqdetcuil = "" ;
      lV99Importlsd2ds_9_tfimpliqdetlegsis = "" ;
      lV101Importlsd2ds_11_tfimpliqdetconcod = "" ;
      lV103Importlsd2ds_13_tfimpliqdetconsisydes = "" ;
      lV109Importlsd2ds_19_tfimpliqdetsigno = "" ;
      AV95Importlsd2ds_5_tfimpliqdetper = "" ;
      AV97Importlsd2ds_7_tfimpliqdetcuil = "" ;
      AV99Importlsd2ds_9_tfimpliqdetlegsis = "" ;
      AV101Importlsd2ds_11_tfimpliqdetconcod = "" ;
      AV103Importlsd2ds_13_tfimpliqdetconsisydes = "" ;
      AV105Importlsd2ds_15_tfimpliqdetcantnum = DecimalUtil.ZERO ;
      AV106Importlsd2ds_16_tfimpliqdetcantnum_to = DecimalUtil.ZERO ;
      AV107Importlsd2ds_17_tfimpliqdetimpnum = DecimalUtil.ZERO ;
      AV108Importlsd2ds_18_tfimpliqdetimpnum_to = DecimalUtil.ZERO ;
      AV109Importlsd2ds_19_tfimpliqdetsigno = "" ;
      H008I2_A670ImpLiqDetSigno = new String[] {""} ;
      H008I2_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H008I2_A668ImpLiqDetUni = new String[] {""} ;
      H008I2_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H008I2_A714ImpLiqDetConSisYDes = new String[] {""} ;
      H008I2_A666ImpLiqDetConCod = new String[] {""} ;
      H008I2_A664ImpLiqDetLegId = new String[] {""} ;
      H008I2_A712ImpLiqDetLegSis = new String[] {""} ;
      H008I2_A663ImpLiqDetCUIL = new String[] {""} ;
      H008I2_A661ImpLiqDetPer = new String[] {""} ;
      H008I2_A662ImpLiqDetLiqN = new String[] {""} ;
      H008I2_A709ImpLiqDetError = new String[] {""} ;
      H008I2_A90ImpLiqDetSec = new short[1] ;
      H008I2_A1EmpCod = new short[1] ;
      H008I2_A3CliCod = new int[1] ;
      H008I2_A88ImpLiqSec = new short[1] ;
      AV93Importlsd2ds_3_tficonoupdate = "" ;
      H008I3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25TFImpLiqDetPer_SelsJson = "" ;
      AV28TFImpLiqDetCUIL_SelsJson = "" ;
      AV31TFImpLiqDetLegSis_SelsJson = "" ;
      AV34TFImpLiqDetConCod_SelsJson = "" ;
      AV81TFImpLiqDetConSisYDes_SelsJson = "" ;
      AV43TFImpLiqDetSigno_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      ucDvelop_confirmpanel_eliminar = new com.genexus.webpanels.GXUserControl();
      ucDvelop_confirmpanel_btneliminartodos = new com.genexus.webpanels.GXUserControl();
      GXv_boolean4 = new boolean[1] ;
      AV19Session = httpContext.getWebSession();
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char13 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      GXv_SdtWWPGridState18 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      ucImportexcel_modal = new com.genexus.webpanels.GXUserControl();
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV9CliCod = "" ;
      sCtrlAV10EmpCod = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importlsd2__default(),
         new Object[] {
             new Object[] {
            H008I2_A670ImpLiqDetSigno, H008I2_A716ImpLiqDetImpNum, H008I2_A668ImpLiqDetUni, H008I2_A715ImpLiqDetCantNum, H008I2_A714ImpLiqDetConSisYDes, H008I2_A666ImpLiqDetConCod, H008I2_A664ImpLiqDetLegId, H008I2_A712ImpLiqDetLegSis, H008I2_A663ImpLiqDetCUIL, H008I2_A661ImpLiqDetPer,
            H008I2_A662ImpLiqDetLiqN, H008I2_A709ImpLiqDetError, H008I2_A90ImpLiqDetSec, H008I2_A1EmpCod, H008I2_A3CliCod, H008I2_A88ImpLiqSec
            }
            , new Object[] {
            H008I3_AGRID_nRecordCount
            }
         }
      );
      AV90Pgmname = "ImportLSD2" ;
      /* GeneXus formulas. */
      AV90Pgmname = "ImportLSD2" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      edtavIconoupdate_Enabled = 0 ;
      edtavEliminar_Enabled = 0 ;
      edtavImpliqconextdescrip_Enabled = 0 ;
      WebComp_Wwpaux_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
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
   private short wcpOAV10EmpCod ;
   private short AV10EmpCod ;
   private short AV21TFiconoUpdateOperator ;
   private short AV16OrderedBy ;
   private short AV92Importlsd2ds_2_empcod ;
   private short AV70EmpCod_Selected ;
   private short AV71ImpLiqSec_Selected ;
   private short AV72ImpLiqDetSec_Selected ;
   private short wbEnd ;
   private short wbStart ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A90ImpLiqDetSec ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV94Importlsd2ds_4_tficonoupdateoperator ;
   private int wcpOAV9CliCod ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_39 ;
   private int AV9CliCod ;
   private int nGXsfl_39_idx=1 ;
   private int AV91Importlsd2ds_1_clicod ;
   private int AV69CliCod_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int Popover_iconoupdate_Popoverwidth ;
   private int bttBtnimportartodos_Visible ;
   private int bttBtneliminartodos_Visible ;
   private int bttBtnimportexcel_Visible ;
   private int divGridtablewithpaginationbar_Visible ;
   private int edtavClicod_Visible ;
   private int edtavClicod_Enabled ;
   private int edtavEmpcod_Visible ;
   private int edtavEmpcod_Enabled ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavIconoupdatewithtags_Enabled ;
   private int edtavIconoupdate_Enabled ;
   private int edtavEliminar_Enabled ;
   private int edtavImpliqconextdescrip_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV96Importlsd2ds_6_tfimpliqdetper_sels_size ;
   private int AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size ;
   private int AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size ;
   private int AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size ;
   private int AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ;
   private int AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size ;
   private int AV63PageToGo ;
   private int AV111GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavIconoupdatewithtags_Visible ;
   private int edtavIconoupdate_Visible ;
   private int edtavEliminar_Visible ;
   private int edtavImpliqconextdescrip_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV64GridCurrentPage ;
   private long AV65GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV77TFImpLiqDetCantNum ;
   private java.math.BigDecimal AV78TFImpLiqDetCantNum_To ;
   private java.math.BigDecimal AV79TFImpLiqDetImpNum ;
   private java.math.BigDecimal AV80TFImpLiqDetImpNum_To ;
   private java.math.BigDecimal A715ImpLiqDetCantNum ;
   private java.math.BigDecimal A716ImpLiqDetImpNum ;
   private java.math.BigDecimal AV105Importlsd2ds_15_tfimpliqdetcantnum ;
   private java.math.BigDecimal AV106Importlsd2ds_16_tfimpliqdetcantnum_to ;
   private java.math.BigDecimal AV107Importlsd2ds_17_tfimpliqdetimpnum ;
   private java.math.BigDecimal AV108Importlsd2ds_18_tfimpliqdetimpnum_to ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumnfixedfilter ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Dvelop_confirmpanel_eliminar_Result ;
   private String Dvelop_confirmpanel_btneliminartodos_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_39_idx="0001" ;
   private String AV90Pgmname ;
   private String AV20TFiconoUpdate ;
   private String AV26TFImpLiqDetPer ;
   private String AV29TFImpLiqDetCUIL ;
   private String AV35TFImpLiqDetConCod ;
   private String AV44TFImpLiqDetSigno ;
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
   private String Popover_iconoupdate_Gridinternalname ;
   private String Popover_iconoupdate_Iteminternalname ;
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
   private String Ddo_grid_Fixedfilters ;
   private String Ddo_grid_Format ;
   private String Ddo_grid_Selectedfixedfilter ;
   private String Dvelop_confirmpanel_eliminar_Title ;
   private String Dvelop_confirmpanel_eliminar_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminar_Confirmtype ;
   private String Dvelop_confirmpanel_btneliminartodos_Title ;
   private String Dvelop_confirmpanel_btneliminartodos_Confirmationtext ;
   private String Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition ;
   private String Dvelop_confirmpanel_btneliminartodos_Confirmtype ;
   private String Importexcel_modal_Width ;
   private String Importexcel_modal_Title ;
   private String Importexcel_modal_Confirmtype ;
   private String Importexcel_modal_Bodytype ;
   private String Grid_empowerer_Gridinternalname ;
   private String Grid_empowerer_Popoversingrid ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnimportartodos_Internalname ;
   private String bttBtnimportartodos_Jsonclick ;
   private String bttBtneliminartodos_Internalname ;
   private String bttBtneliminartodos_Jsonclick ;
   private String bttBtnimportexcel_Internalname ;
   private String bttBtnimportexcel_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String edtavClicod_Internalname ;
   private String edtavClicod_Jsonclick ;
   private String edtavEmpcod_Internalname ;
   private String edtavEmpcod_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Popover_iconoupdate_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavIconoupdatewithtags_Internalname ;
   private String AV18iconoUpdate ;
   private String edtavIconoupdate_Internalname ;
   private String AV67Eliminar ;
   private String edtavEliminar_Internalname ;
   private String edtImpLiqSec_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtImpLiqDetSec_Internalname ;
   private String edtImpLiqDetError_Internalname ;
   private String A662ImpLiqDetLiqN ;
   private String edtImpLiqDetLiqN_Internalname ;
   private String A661ImpLiqDetPer ;
   private String edtImpLiqDetPer_Internalname ;
   private String A663ImpLiqDetCUIL ;
   private String edtImpLiqDetCUIL_Internalname ;
   private String edtImpLiqDetLegSis_Internalname ;
   private String A664ImpLiqDetLegId ;
   private String edtImpLiqDetLegId_Internalname ;
   private String A666ImpLiqDetConCod ;
   private String edtImpLiqDetConCod_Internalname ;
   private String edtavImpliqconextdescrip_Internalname ;
   private String edtImpLiqDetConSisYDes_Internalname ;
   private String edtImpLiqDetCantNum_Internalname ;
   private String A668ImpLiqDetUni ;
   private String edtImpLiqDetUni_Internalname ;
   private String edtImpLiqDetImpNum_Internalname ;
   private String A670ImpLiqDetSigno ;
   private String edtImpLiqDetSigno_Internalname ;
   private String scmdbuf ;
   private String lV95Importlsd2ds_5_tfimpliqdetper ;
   private String lV97Importlsd2ds_7_tfimpliqdetcuil ;
   private String lV101Importlsd2ds_11_tfimpliqdetconcod ;
   private String lV109Importlsd2ds_19_tfimpliqdetsigno ;
   private String AV95Importlsd2ds_5_tfimpliqdetper ;
   private String AV97Importlsd2ds_7_tfimpliqdetcuil ;
   private String AV101Importlsd2ds_11_tfimpliqdetconcod ;
   private String AV109Importlsd2ds_19_tfimpliqdetsigno ;
   private String AV93Importlsd2ds_3_tficonoupdate ;
   private String Dvelop_confirmpanel_eliminar_Internalname ;
   private String Dvelop_confirmpanel_btneliminartodos_Internalname ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char12 ;
   private String GXv_char13[] ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblTableimportexcel_modal_Internalname ;
   private String Importexcel_modal_Internalname ;
   private String tblTabledvelop_confirmpanel_btneliminartodos_Internalname ;
   private String tblTabledvelop_confirmpanel_eliminar_Internalname ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Jsonclick ;
   private String sCtrlAV9CliCod ;
   private String sCtrlAV10EmpCod ;
   private String sGXsfl_39_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavIconoupdatewithtags_Jsonclick ;
   private String edtavIconoupdate_Jsonclick ;
   private String edtavEliminar_Jsonclick ;
   private String edtImpLiqSec_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtImpLiqDetSec_Jsonclick ;
   private String edtImpLiqDetError_Jsonclick ;
   private String edtImpLiqDetLiqN_Jsonclick ;
   private String edtImpLiqDetPer_Jsonclick ;
   private String edtImpLiqDetCUIL_Jsonclick ;
   private String edtImpLiqDetLegSis_Jsonclick ;
   private String edtImpLiqDetLegId_Jsonclick ;
   private String edtImpLiqDetConCod_Jsonclick ;
   private String edtavImpliqconextdescrip_Jsonclick ;
   private String edtImpLiqDetConSisYDes_Jsonclick ;
   private String edtImpLiqDetCantNum_Jsonclick ;
   private String edtImpLiqDetUni_Jsonclick ;
   private String edtImpLiqDetImpNum_Jsonclick ;
   private String edtImpLiqDetSigno_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17OrderedDsc ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Popover_iconoupdate_Isgriditem ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean bGXsfl_39_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV87modoTest ;
   private boolean gx_refresh_fired ;
   private boolean AV73detalleHay ;
   private boolean AV68TempBoolean ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean Cond_result ;
   private String AV25TFImpLiqDetPer_SelsJson ;
   private String AV28TFImpLiqDetCUIL_SelsJson ;
   private String AV31TFImpLiqDetLegSis_SelsJson ;
   private String AV34TFImpLiqDetConCod_SelsJson ;
   private String AV81TFImpLiqDetConSisYDes_SelsJson ;
   private String AV43TFImpLiqDetSigno_SelsJson ;
   private String AV32TFImpLiqDetLegSis ;
   private String AV82TFImpLiqDetConSisYDes ;
   private String AV66GridAppliedFilters ;
   private String AV62iconoUpdateWithTags ;
   private String A709ImpLiqDetError ;
   private String A712ImpLiqDetLegSis ;
   private String AV84ImpLiqConExtDescrip ;
   private String A714ImpLiqDetConSisYDes ;
   private String lV99Importlsd2ds_9_tfimpliqdetlegsis ;
   private String lV103Importlsd2ds_13_tfimpliqdetconsisydes ;
   private String AV99Importlsd2ds_9_tfimpliqdetlegsis ;
   private String AV103Importlsd2ds_13_tfimpliqdetconsisydes ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV19Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucPopover_iconoupdate ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminar ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_btneliminartodos ;
   private com.genexus.webpanels.GXUserControl ucImportexcel_modal ;
   private GXSimpleCollection<String> AV96Importlsd2ds_6_tfimpliqdetper_sels ;
   private GXSimpleCollection<String> AV98Importlsd2ds_8_tfimpliqdetcuil_sels ;
   private GXSimpleCollection<String> AV102Importlsd2ds_12_tfimpliqdetconcod_sels ;
   private GXSimpleCollection<String> AV110Importlsd2ds_20_tfimpliqdetsigno_sels ;
   private GXSimpleCollection<String> AV100Importlsd2ds_10_tfimpliqdetlegsis_sels ;
   private GXSimpleCollection<String> AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels ;
   private IDataStoreProvider pr_default ;
   private String[] H008I2_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] H008I2_A716ImpLiqDetImpNum ;
   private String[] H008I2_A668ImpLiqDetUni ;
   private java.math.BigDecimal[] H008I2_A715ImpLiqDetCantNum ;
   private String[] H008I2_A714ImpLiqDetConSisYDes ;
   private String[] H008I2_A666ImpLiqDetConCod ;
   private String[] H008I2_A664ImpLiqDetLegId ;
   private String[] H008I2_A712ImpLiqDetLegSis ;
   private String[] H008I2_A663ImpLiqDetCUIL ;
   private String[] H008I2_A661ImpLiqDetPer ;
   private String[] H008I2_A662ImpLiqDetLiqN ;
   private String[] H008I2_A709ImpLiqDetError ;
   private short[] H008I2_A90ImpLiqDetSec ;
   private short[] H008I2_A1EmpCod ;
   private int[] H008I2_A3CliCod ;
   private short[] H008I2_A88ImpLiqSec ;
   private long[] H008I3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV27TFImpLiqDetPer_Sels ;
   private GXSimpleCollection<String> AV30TFImpLiqDetCUIL_Sels ;
   private GXSimpleCollection<String> AV36TFImpLiqDetConCod_Sels ;
   private GXSimpleCollection<String> AV45TFImpLiqDetSigno_Sels ;
   private GXSimpleCollection<String> AV33TFImpLiqDetLegSis_Sels ;
   private GXSimpleCollection<String> AV83TFImpLiqDetConSisYDes_Sels ;
   private GXSimpleCollection<String> AV8ExtraParms ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV15GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV61DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class importlsd2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H008I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV96Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV98Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV100Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV102Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV110Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV94Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV96Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV95Importlsd2ds_5_tfimpliqdetper ,
                                          int AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV97Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV99Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV101Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV103Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV105Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV106Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV107Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV108Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV109Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV91Importlsd2ds_1_clicod ,
                                          short AV92Importlsd2ds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[15];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ImpLiqDetSigno, ImpLiqDetImpNum, ImpLiqDetUni, ImpLiqDetCantNum, ImpLiqDetConSisYDes, ImpLiqDetConCod, ImpLiqDetLegId, ImpLiqDetLegSis, ImpLiqDetCUIL, ImpLiqDetPer," ;
      sSelectString += " ImpLiqDetLiqN, ImpLiqDetError, ImpLiqDetSec, EmpCod, CliCod, ImpLiqSec" ;
      sFromString = " FROM importacion_liquidacion_detalle" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV94Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV94Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV96Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV95Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      if ( AV96Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV97Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      if ( AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      if ( AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int19[5] = (byte)(1) ;
      }
      if ( AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int19[6] = (byte)(1) ;
      }
      if ( AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int19[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int19[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int19[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ( AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      if ( AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetPer, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetPer DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetCUIL, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetCUIL DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetLegSis, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetLegSis DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetConCod, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetConCod DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetConSisYDes, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetConSisYDes DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetCantNum, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetCantNum DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetImpNum, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetImpNum DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqDetSigno, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqDetSigno DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H008I3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV96Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV98Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV100Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV102Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV110Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV94Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV96Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV95Importlsd2ds_5_tfimpliqdetper ,
                                          int AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV97Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV99Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV101Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV103Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV105Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV106Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV107Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV108Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV109Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV91Importlsd2ds_1_clicod ,
                                          short AV92Importlsd2ds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[12];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV94Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV94Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV96Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV95Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int22[2] = (byte)(1) ;
      }
      if ( AV96Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV96Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV97Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( AV98Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( AV100Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( AV102Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV103Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV104Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ( AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( AV110Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
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
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
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
                  return conditional_H008I2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).shortValue() );
            case 1 :
                  return conditional_H008I3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H008I2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H008I3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 11);
               ((String[]) buf[9])[0] = rslt.getString(10, 6);
               ((String[]) buf[10])[0] = rslt.getString(11, 5);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
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
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[26], 1);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
      }
   }

}

