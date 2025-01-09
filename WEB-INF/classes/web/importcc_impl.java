package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importcc_impl extends GXWebComponent
{
   public importcc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importcc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importcc_impl.class ));
   }

   public importcc_impl( int remoteHandle ,
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
      cmbImpLiqTipoConCod = new HTMLChoice();
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
      nRC_GXsfl_41 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_41"))) ;
      nGXsfl_41_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_41_idx"))) ;
      sGXsfl_41_idx = httpContext.GetPar( "sGXsfl_41_idx") ;
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
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
      AV85Pgmname = httpContext.GetPar( "Pgmname") ;
      AV59TFiconoUpdate = httpContext.GetPar( "TFiconoUpdate") ;
      AV60TFiconoUpdateOperator = (short)(GXutil.lval( httpContext.GetPar( "TFiconoUpdateOperator"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV78TFImpLiqTipoConCod_Sels);
      AV63TFImpLiqConExtCodYDescrip = httpContext.GetPar( "TFImpLiqConExtCodYDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV64TFImpLiqConExtCodYDescrip_Sels);
      AV80TFImpLiqAfipCodMasDesc = httpContext.GetPar( "TFImpLiqAfipCodMasDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV81TFImpLiqAfipCodMasDesc_Sels);
      AV66TFImpLiqConSisCodYDescrip = httpContext.GetPar( "TFImpLiqConSisCodYDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV67TFImpLiqConSisCodYDescrip_Sels);
      AV16OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV17OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa8B2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( " importacion_conceptos", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importcc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10EmpCod,4,0))}, new String[] {"CliCod","EmpCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV85Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_41", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_41, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV50GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV51GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV52GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV48DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV48DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV10EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV85Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV85Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFICONOUPDATE", GXutil.rtrim( AV59TFiconoUpdate));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFICONOUPDATEOPERATOR", GXutil.ltrim( localUtil.ntoc( AV60TFiconoUpdateOperator, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQTIPOCONCOD_SELS", AV78TFImpLiqTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQTIPOCONCOD_SELS", AV78TFImpLiqTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQCONEXTCODYDESCRIP", AV63TFImpLiqConExtCodYDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQCONEXTCODYDESCRIP_SELS", AV64TFImpLiqConExtCodYDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQCONEXTCODYDESCRIP_SELS", AV64TFImpLiqConExtCodYDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQAFIPCODMASDESC", AV80TFImpLiqAfipCodMasDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQAFIPCODMASDESC_SELS", AV81TFImpLiqAfipCodMasDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQAFIPCODMASDESC_SELS", AV81TFImpLiqAfipCodMasDesc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFIMPLIQCONSISCODYDESCRIP", AV66TFImpLiqConSisCodYDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFIMPLIQCONSISCODYDESCRIP_SELS", AV67TFImpLiqConSisCodYDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFIMPLIQCONSISCODYDESCRIP_SELS", AV67TFImpLiqConSisCodYDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPLIQCONEXTCOD", GXutil.rtrim( A89ImpLiqConExtCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV69CliCod_Selected, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD_SELECTED", GXutil.ltrim( localUtil.ntoc( AV70EmpCod_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPLIQSEC_SELECTED", GXutil.ltrim( localUtil.ntoc( AV71ImpLiqSec_Selected, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPLIQCONEXTCOD_SELECTED", GXutil.rtrim( AV72ImpLiqConExtCod_Selected));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Fixedfilters", GXutil.rtrim( Ddo_grid_Fixedfilters));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedfixedfilter", GXutil.rtrim( Ddo_grid_Selectedfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_gridcolumnsselector_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Title", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Title", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Width", GXutil.rtrim( Importexcel_modal_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Title", GXutil.rtrim( Importexcel_modal_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Confirmtype", GXutil.rtrim( Importexcel_modal_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPORTEXCEL_MODAL_Bodytype", GXutil.rtrim( Importexcel_modal_Bodytype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Popoversingrid", GXutil.rtrim( Grid_empowerer_Popoversingrid));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Result", GXutil.rtrim( Dvelop_confirmpanel_btneliminartodos_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result", GXutil.rtrim( Dvelop_confirmpanel_eliminar_Result));
   }

   public void renderHtmlCloseForm8B2( )
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
      return "ImportCC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " importacion_conceptos", "") ;
   }

   public void wb8B0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importcc");
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
         web.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table1_15_8B2( true) ;
      }
      else
      {
         wb_table1_15_8B2( false) ;
      }
      return  ;
   }

   public void wb_table1_15_8B2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled btn btn-default" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportexcel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 41, 2, 0)+","+"null"+");", bttBtnimportexcel_Caption, bttBtnimportexcel_Jsonclick, 7, httpContext.getMessage( "WWP_ImportExcelTooltip", ""), "", StyleString, ClassString, bttBtnimportexcel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e118b1_client"+"'", TempTags, "", 2, "HLP_ImportCC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "hidden-xs" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneditcolumns_Internalname, "gx.evt.setGridEvt("+GXutil.str( 41, 2, 0)+","+"null"+");", httpContext.getMessage( "Columnas", ""), bttBtneditcolumns_Jsonclick, 0, httpContext.getMessage( "WWP_EditColumnsTooltip", ""), "", StyleString, ClassString, 1, 0, "standard", "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportCC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 displayNone", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneliminartodos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 41, 2, 0)+","+"null"+");", httpContext.getMessage( "Eliminar todos", ""), bttBtneliminartodos_Jsonclick, 5, httpContext.getMessage( "Eliminar todos", ""), "", StyleString, ClassString, bttBtneliminartodos_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOELIMINARTODOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ImportCC.htm");
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
         startgridcontrol41( ) ;
      }
      if ( wbEnd == 41 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_41 = (int)(nGXsfl_41_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV50GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV51GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV52GridAppliedFilters);
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
         ucPopover_iconoupdate.setProperty("IsGridItem", Popover_iconoupdate_Isgriditem);
         ucPopover_iconoupdate.setProperty("PopoverWidth", Popover_iconoupdate_Popoverwidth);
         ucPopover_iconoupdate.render(context, "dvelop.wwppopover", Popover_iconoupdate_Internalname, sPrefix+"POPOVER_ICONOUPDATEContainer");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("Fixable", Ddo_grid_Fixable);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("FixedFilters", Ddo_grid_Fixedfilters);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV48DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV48DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, sPrefix+"DDO_GRIDCOLUMNSSELECTORContainer");
         wb_table2_63_8B2( true) ;
      }
      else
      {
         wb_table2_63_8B2( false) ;
      }
      return  ;
   }

   public void wb_table2_63_8B2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table3_68_8B2( true) ;
      }
      else
      {
         wb_table3_68_8B2( false) ;
      }
      return  ;
   }

   public void wb_table3_68_8B2e( boolean wbgen )
   {
      if ( wbgen )
      {
         wb_table4_73_8B2( true) ;
      }
      else
      {
         wb_table4_73_8B2( false) ;
      }
      return  ;
   }

   public void wb_table4_73_8B2e( boolean wbgen )
   {
      if ( wbgen )
      {
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.setProperty("PopoversInGrid", Grid_empowerer_Popoversingrid);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0080"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0080"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_41_Refreshing )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0080"+"");
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
      if ( wbEnd == 41 )
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

   public void start8B2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( " importacion_conceptos", ""), (short)(0)) ;
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
            strup8B0( ) ;
         }
      }
   }

   public void ws8B2( )
   {
      start8B2( ) ;
      evt8B2( ) ;
   }

   public void evt8B2( )
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
                              strup8B0( ) ;
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
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e128B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e138B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e148B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e158B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e168B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "IMPORTEXCEL_MODAL.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e178B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOELIMINARTODOS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoEliminarTodos' */
                                 e188B2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup8B0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavEliminar_Internalname ;
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
                              strup8B0( ) ;
                           }
                           nGXsfl_41_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_412( ) ;
                           AV68Eliminar = httpContext.cgiGet( edtavEliminar_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminar_Internalname, AV68Eliminar);
                           AV61iconoUpdateWithTags = httpContext.cgiGet( edtavIconoupdatewithtags_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
                           AV57iconoUpdate = httpContext.cgiGet( edtavIconoupdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdate_Internalname, AV57iconoUpdate);
                           A88ImpLiqSec = (short)(localUtil.ctol( httpContext.cgiGet( edtImpLiqSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbImpLiqTipoConCod.setName( cmbImpLiqTipoConCod.getInternalname() );
                           cmbImpLiqTipoConCod.setValue( httpContext.cgiGet( cmbImpLiqTipoConCod.getInternalname()) );
                           A911ImpLiqTipoConCod = httpContext.cgiGet( cmbImpLiqTipoConCod.getInternalname()) ;
                           A701ImpLiqConExtCodYDescrip = httpContext.cgiGet( edtImpLiqConExtCodYDescrip_Internalname) ;
                           A912ImpLiqAfipCodMasDesc = httpContext.cgiGet( edtImpLiqAfipCodMasDesc_Internalname) ;
                           A702ImpLiqConSisCodYDescrip = httpContext.cgiGet( edtImpLiqConSisCodYDescrip_Internalname) ;
                           A659ImpLiqConError = httpContext.cgiGet( edtImpLiqConError_Internalname) ;
                           A660ImpLiqConWarning = httpContext.cgiGet( edtImpLiqConWarning_Internalname) ;
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
                                       GX_FocusControl = edtavEliminar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e198B2 ();
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
                                       GX_FocusControl = edtavEliminar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e208B2 ();
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
                                       GX_FocusControl = edtavEliminar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e218B2 ();
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
                                       GX_FocusControl = edtavEliminar_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e228B2 ();
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
                                    strup8B0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavEliminar_Internalname ;
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
                     if ( nCmpId == 80 )
                     {
                        OldWwpaux_wc = httpContext.cgiGet( sPrefix+"W0080") ;
                        if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                        {
                           WebComp_Wwpaux_wc = WebUtils.getWebComponent(getClass(), "web." + OldWwpaux_wc + "_impl", remoteHandle, context);
                           WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                        }
                        if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                        {
                           WebComp_Wwpaux_wc.componentprocess(sPrefix+"W0080", "", sEvt);
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

   public void we8B2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm8B2( ) ;
         }
      }
   }

   public void pa8B2( )
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
      subsflControlProps_412( ) ;
      while ( nGXsfl_41_idx <= nRC_GXsfl_41 )
      {
         sendrow_412( ) ;
         nGXsfl_41_idx = ((subGrid_Islastpage==1)&&(nGXsfl_41_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_412( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV9CliCod ,
                                 short AV10EmpCod ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV85Pgmname ,
                                 String AV59TFiconoUpdate ,
                                 short AV60TFiconoUpdateOperator ,
                                 GXSimpleCollection<String> AV78TFImpLiqTipoConCod_Sels ,
                                 String AV63TFImpLiqConExtCodYDescrip ,
                                 GXSimpleCollection<String> AV64TFImpLiqConExtCodYDescrip_Sels ,
                                 String AV80TFImpLiqAfipCodMasDesc ,
                                 GXSimpleCollection<String> AV81TFImpLiqAfipCodMasDesc_Sels ,
                                 String AV66TFImpLiqConSisCodYDescrip ,
                                 GXSimpleCollection<String> AV67TFImpLiqConSisCodYDescrip_Sels ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e208B2 ();
      GRID_nCurrentRecord = 0 ;
      rf8B2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQCONERROR", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( A659ImpLiqConError, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPLIQCONERROR", A659ImpLiqConError);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQCONWARNING", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( A660ImpLiqConWarning, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"IMPLIQCONWARNING", A660ImpLiqConWarning);
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
      rf8B2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV85Pgmname = "ImportCC" ;
      Gx_err = (short)(0) ;
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void rf8B2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(41) ;
      /* Execute user event: Refresh */
      e208B2 ();
      nGXsfl_41_idx = 1 ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_412( ) ;
      bGXsfl_41_Refreshing = true ;
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
         subsflControlProps_412( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A911ImpLiqTipoConCod ,
                                              AV88Importccds_3_tfimpliqtipoconcod_sels ,
                                              A701ImpLiqConExtCodYDescrip ,
                                              AV90Importccds_5_tfimpliqconextcodydescrip_sels ,
                                              A912ImpLiqAfipCodMasDesc ,
                                              AV92Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                              A702ImpLiqConSisCodYDescrip ,
                                              AV94Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                              Short.valueOf(AV87Importccds_2_tficonoupdateoperator) ,
                                              Integer.valueOf(AV88Importccds_3_tfimpliqtipoconcod_sels.size()) ,
                                              Integer.valueOf(AV90Importccds_5_tfimpliqconextcodydescrip_sels.size()) ,
                                              AV89Importccds_4_tfimpliqconextcodydescrip ,
                                              Integer.valueOf(AV92Importccds_7_tfimpliqafipcodmasdesc_sels.size()) ,
                                              AV91Importccds_6_tfimpliqafipcodmasdesc ,
                                              Integer.valueOf(AV94Importccds_9_tfimpliqconsiscodydescrip_sels.size()) ,
                                              AV93Importccds_8_tfimpliqconsiscodydescrip ,
                                              A659ImpLiqConError ,
                                              A660ImpLiqConWarning ,
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              Integer.valueOf(AV9CliCod) ,
                                              Short.valueOf(AV10EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV89Importccds_4_tfimpliqconextcodydescrip = GXutil.concat( GXutil.rtrim( AV89Importccds_4_tfimpliqconextcodydescrip), "%", "") ;
         lV91Importccds_6_tfimpliqafipcodmasdesc = GXutil.concat( GXutil.rtrim( AV91Importccds_6_tfimpliqafipcodmasdesc), "%", "") ;
         lV93Importccds_8_tfimpliqconsiscodydescrip = GXutil.concat( GXutil.rtrim( AV93Importccds_8_tfimpliqconsiscodydescrip), "%", "") ;
         /* Using cursor H008B2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), lV89Importccds_4_tfimpliqconextcodydescrip, lV91Importccds_6_tfimpliqafipcodmasdesc, lV93Importccds_8_tfimpliqconsiscodydescrip, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_41_idx = 1 ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_412( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A89ImpLiqConExtCod = H008B2_A89ImpLiqConExtCod[0] ;
            A660ImpLiqConWarning = H008B2_A660ImpLiqConWarning[0] ;
            A659ImpLiqConError = H008B2_A659ImpLiqConError[0] ;
            A702ImpLiqConSisCodYDescrip = H008B2_A702ImpLiqConSisCodYDescrip[0] ;
            A912ImpLiqAfipCodMasDesc = H008B2_A912ImpLiqAfipCodMasDesc[0] ;
            A701ImpLiqConExtCodYDescrip = H008B2_A701ImpLiqConExtCodYDescrip[0] ;
            A911ImpLiqTipoConCod = H008B2_A911ImpLiqTipoConCod[0] ;
            A1EmpCod = H008B2_A1EmpCod[0] ;
            A3CliCod = H008B2_A3CliCod[0] ;
            A88ImpLiqSec = H008B2_A88ImpLiqSec[0] ;
            e218B2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(41) ;
         wb8B0( ) ;
      }
      bGXsfl_41_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes8B2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV85Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV85Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD"+"_"+sGXsfl_41_idx, getSecureSignedToken( sPrefix+sGXsfl_41_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD"+"_"+sGXsfl_41_idx, getSecureSignedToken( sPrefix+sGXsfl_41_idx, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQSEC"+"_"+sGXsfl_41_idx, getSecureSignedToken( sPrefix+sGXsfl_41_idx, localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQCONERROR"+"_"+sGXsfl_41_idx, getSecureSignedToken( sPrefix+sGXsfl_41_idx, GXutil.rtrim( localUtil.format( A659ImpLiqConError, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_IMPLIQCONWARNING"+"_"+sGXsfl_41_idx, getSecureSignedToken( sPrefix+sGXsfl_41_idx, GXutil.rtrim( localUtil.format( A660ImpLiqConWarning, ""))));
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
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A911ImpLiqTipoConCod ,
                                           AV88Importccds_3_tfimpliqtipoconcod_sels ,
                                           A701ImpLiqConExtCodYDescrip ,
                                           AV90Importccds_5_tfimpliqconextcodydescrip_sels ,
                                           A912ImpLiqAfipCodMasDesc ,
                                           AV92Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                           A702ImpLiqConSisCodYDescrip ,
                                           AV94Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                           Short.valueOf(AV87Importccds_2_tficonoupdateoperator) ,
                                           Integer.valueOf(AV88Importccds_3_tfimpliqtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV90Importccds_5_tfimpliqconextcodydescrip_sels.size()) ,
                                           AV89Importccds_4_tfimpliqconextcodydescrip ,
                                           Integer.valueOf(AV92Importccds_7_tfimpliqafipcodmasdesc_sels.size()) ,
                                           AV91Importccds_6_tfimpliqafipcodmasdesc ,
                                           Integer.valueOf(AV94Importccds_9_tfimpliqconsiscodydescrip_sels.size()) ,
                                           AV93Importccds_8_tfimpliqconsiscodydescrip ,
                                           A659ImpLiqConError ,
                                           A660ImpLiqConWarning ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV89Importccds_4_tfimpliqconextcodydescrip = GXutil.concat( GXutil.rtrim( AV89Importccds_4_tfimpliqconextcodydescrip), "%", "") ;
      lV91Importccds_6_tfimpliqafipcodmasdesc = GXutil.concat( GXutil.rtrim( AV91Importccds_6_tfimpliqafipcodmasdesc), "%", "") ;
      lV93Importccds_8_tfimpliqconsiscodydescrip = GXutil.concat( GXutil.rtrim( AV93Importccds_8_tfimpliqconsiscodydescrip), "%", "") ;
      /* Using cursor H008B3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), lV89Importccds_4_tfimpliqconextcodydescrip, lV91Importccds_6_tfimpliqafipcodmasdesc, lV93Importccds_8_tfimpliqconsiscodydescrip});
      GRID_nRecordCount = H008B3_AGRID_nRecordCount[0] ;
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
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV85Pgmname = "ImportCC" ;
      Gx_err = (short)(0) ;
      edtavEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminar_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup8B0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e198B2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV48DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vEXTRAPARMS"), AV8ExtraParms);
         /* Read saved values. */
         nRC_GXsfl_41 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_41"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV50GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV51GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV52GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV10EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( sPrefix+"DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( sPrefix+"DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( sPrefix+"DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( sPrefix+"DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistproc") ;
         Ddo_grid_Fixedfilters = httpContext.cgiGet( sPrefix+"DDO_GRID_Fixedfilters") ;
         Ddo_grid_Selectedfixedfilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedfixedfilter") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_gridcolumnsselector_Titlecontrolidtoreplace = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Titlecontrolidtoreplace") ;
         Dvelop_confirmpanel_btneliminartodos_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Title") ;
         Dvelop_confirmpanel_btneliminartodos_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmationtext") ;
         Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Nobuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Yesbuttonposition") ;
         Dvelop_confirmpanel_btneliminartodos_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS_Confirmtype") ;
         Dvelop_confirmpanel_eliminar_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Title") ;
         Dvelop_confirmpanel_eliminar_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmationtext") ;
         Dvelop_confirmpanel_eliminar_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_eliminar_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_eliminar_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Confirmtype") ;
         Importexcel_modal_Width = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Width") ;
         Importexcel_modal_Title = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Title") ;
         Importexcel_modal_Confirmtype = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Confirmtype") ;
         Importexcel_modal_Bodytype = httpContext.cgiGet( sPrefix+"IMPORTEXCEL_MODAL_Bodytype") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hascolumnsselector")) ;
         Grid_empowerer_Popoversingrid = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Popoversingrid") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Selectedcolumnfixedfilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumnfixedfilter") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_get") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Dvelop_confirmpanel_eliminar_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR_Result") ;
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
      e198B2 ();
      if (returnInSub) return;
   }

   public void e198B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Popover_iconoupdate_Gridinternalname = subGrid_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "GridInternalName", Popover_iconoupdate_Gridinternalname);
      Popover_iconoupdate_Iteminternalname = edtavIconoupdatewithtags_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "ItemInternalName", Popover_iconoupdate_Iteminternalname);
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV48DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV48DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = bttBtneditcolumns_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "TitleControlIdToReplace", Ddo_gridcolumnsselector_Titlecontrolidtoreplace);
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e208B2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_boolean3 = AV76conceptosHay ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.hayimpliqcon(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, (short)(1), GXv_boolean4) ;
      importcc_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV76conceptosHay = GXt_boolean3 ;
      divGridtablewithpaginationbar_Visible = (AV76conceptosHay ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divGridtablewithpaginationbar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divGridtablewithpaginationbar_Visible), 5, 0), true);
      bttBtnimportexcel_Caption = httpContext.getMessage( "IMPORTAR ARCHIVO DE CONCEPTOS AFIP EXTERNO", "") ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnimportexcel_Internalname, "Caption", bttBtnimportexcel_Caption, true);
      bttBtneliminartodos_Visible = (AV76conceptosHay ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtneliminartodos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtneliminartodos_Visible), 5, 0), true);
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("ImportCCColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("ImportCCColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S162 ();
         if (returnInSub) return;
      }
      edtavIconoupdatewithtags_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Visible), 5, 0), !bGXsfl_41_Refreshing);
      cmbImpLiqTipoConCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbImpLiqTipoConCod.getVisible(), 5, 0), !bGXsfl_41_Refreshing);
      edtImpLiqConExtCodYDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtImpLiqConExtCodYDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConExtCodYDescrip_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtImpLiqAfipCodMasDesc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtImpLiqAfipCodMasDesc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqAfipCodMasDesc_Visible), 5, 0), !bGXsfl_41_Refreshing);
      edtImpLiqConSisCodYDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtImpLiqConSisCodYDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpLiqConSisCodYDescrip_Visible), 5, 0), !bGXsfl_41_Refreshing);
      AV50GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50GridCurrentPage), 10, 0));
      AV51GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51GridPageCount), 10, 0));
      GXt_char6 = AV52GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV85Pgmname, GXv_char7) ;
      importcc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV52GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52GridAppliedFilters", AV52GridAppliedFilters);
      AV86Importccds_1_tficonoupdate = AV59TFiconoUpdate ;
      AV87Importccds_2_tficonoupdateoperator = AV60TFiconoUpdateOperator ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = AV78TFImpLiqTipoConCod_Sels ;
      AV89Importccds_4_tfimpliqconextcodydescrip = AV63TFImpLiqConExtCodYDescrip ;
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = AV64TFImpLiqConExtCodYDescrip_Sels ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = AV80TFImpLiqAfipCodMasDesc ;
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = AV81TFImpLiqAfipCodMasDesc_Sels ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = AV66TFImpLiqConSisCodYDescrip ;
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = AV67TFImpLiqConSisCodYDescrip_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV21ColumnsSelector", AV21ColumnsSelector);
   }

   public void e128B2( )
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
         AV49PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV49PageToGo) ;
      }
   }

   public void e138B2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e148B2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "iconoUpdate") == 0 )
         {
            if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "1") == 0 )
            {
               AV60TFiconoUpdateOperator = (short)(1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFiconoUpdateOperator), 4, 0));
               AV59TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFiconoUpdate", AV59TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "2") == 0 )
            {
               AV60TFiconoUpdateOperator = (short)(2) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFiconoUpdateOperator), 4, 0));
               AV59TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFiconoUpdate", AV59TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "3") == 0 )
            {
               AV60TFiconoUpdateOperator = (short)(3) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFiconoUpdateOperator), 4, 0));
               AV59TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TFiconoUpdate", AV59TFiconoUpdate);
            }
            else
            {
               AV60TFiconoUpdateOperator = (short)(0) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFiconoUpdateOperator), 4, 0));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqTipoConCod") == 0 )
         {
            AV77TFImpLiqTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77TFImpLiqTipoConCod_SelsJson", AV77TFImpLiqTipoConCod_SelsJson);
            AV78TFImpLiqTipoConCod_Sels.fromJSonString(AV77TFImpLiqTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqConExtCodYDescrip") == 0 )
         {
            AV63TFImpLiqConExtCodYDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63TFImpLiqConExtCodYDescrip", AV63TFImpLiqConExtCodYDescrip);
            AV62TFImpLiqConExtCodYDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62TFImpLiqConExtCodYDescrip_SelsJson", AV62TFImpLiqConExtCodYDescrip_SelsJson);
            AV64TFImpLiqConExtCodYDescrip_Sels.fromJSonString(AV62TFImpLiqConExtCodYDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqAfipCodMasDesc") == 0 )
         {
            AV80TFImpLiqAfipCodMasDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80TFImpLiqAfipCodMasDesc", AV80TFImpLiqAfipCodMasDesc);
            AV79TFImpLiqAfipCodMasDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79TFImpLiqAfipCodMasDesc_SelsJson", AV79TFImpLiqAfipCodMasDesc_SelsJson);
            AV81TFImpLiqAfipCodMasDesc_Sels.fromJSonString(AV79TFImpLiqAfipCodMasDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ImpLiqConSisCodYDescrip") == 0 )
         {
            AV66TFImpLiqConSisCodYDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFImpLiqConSisCodYDescrip", AV66TFImpLiqConSisCodYDescrip);
            AV65TFImpLiqConSisCodYDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFImpLiqConSisCodYDescrip_SelsJson", AV65TFImpLiqConSisCodYDescrip_SelsJson);
            AV67TFImpLiqConSisCodYDescrip_Sels.fromJSonString(AV65TFImpLiqConSisCodYDescrip_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV78TFImpLiqTipoConCod_Sels", AV78TFImpLiqTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV64TFImpLiqConExtCodYDescrip_Sels", AV64TFImpLiqConExtCodYDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV81TFImpLiqAfipCodMasDesc_Sels", AV81TFImpLiqAfipCodMasDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV67TFImpLiqConSisCodYDescrip_Sels", AV67TFImpLiqConSisCodYDescrip_Sels);
   }

   private void e218B2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV68Eliminar = "<i class=\"fas fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavEliminar_Internalname, AV68Eliminar);
      AV57iconoUpdate = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdate_Internalname, AV57iconoUpdate);
      AV61iconoUpdateWithTags = AV57iconoUpdate ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
      if ( (GXutil.strcmp("", A659ImpLiqConError)==0) && ! (GXutil.strcmp("", A660ImpLiqConWarning)==0) )
      {
         AV61iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconWarning FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Warnings", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
      }
      if ( ! (GXutil.strcmp("", A659ImpLiqConError)==0) )
      {
         AV61iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconDanger FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Errores", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
      }
      if ( (GXutil.strcmp("", A659ImpLiqConError)==0) && (GXutil.strcmp("", A660ImpLiqConWarning)==0) )
      {
         AV61iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconSuccess FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Validado OK", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
      }
      AV61iconoUpdateWithTags += "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
      edtavIconoupdatewithtags_Link = formatLink("web.importacion_conceptos", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A88ImpLiqSec,4,0)),GXutil.URLEncode(GXutil.rtrim(A89ImpLiqConExtCod))}, new String[] {"Mode","CliCod","EmpCod","ImpLiqSec","ImpLiqConExtCod"})  ;
      if ( (GXutil.strcmp("", A660ImpLiqConWarning)==0) && (GXutil.strcmp("", A659ImpLiqConError)==0) )
      {
         AV61iconoUpdateWithTags = GXutil.strReplace( AV61iconoUpdateWithTags, "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV61iconoUpdateWithTags);
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(41) ;
      }
      sendrow_412( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_41_Refreshing )
      {
         httpContext.doAjaxLoad(41, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e158B2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "ImportCCColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV21ColumnsSelector", AV21ColumnsSelector);
   }

   public void e188B2( )
   {
      /* 'DoEliminarTodos' Routine */
      returnInSub = false ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "eliminar ", ""), httpContext.getMessage( "todos los registros de Conceptos Externos / AFIP", ""), GXv_char7) ;
      importcc_impl.this.GXt_char6 = GXv_char7[0] ;
      Dvelop_confirmpanel_btneliminartodos_Confirmationtext = GXt_char6 ;
      ucDvelop_confirmpanel_btneliminartodos.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_btneliminartodos_Internalname, "ConfirmationText", Dvelop_confirmpanel_btneliminartodos_Confirmationtext);
      this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_BTNELIMINARTODOSContainer", "Confirm", "", new Object[] {});
      /*  Sending Event outputs  */
   }

   public void e228B2( )
   {
      /* Eliminar_Click Routine */
      returnInSub = false ;
      GXv_boolean4[0] = AV74detalleHay ;
      new web.hayimpliqdet(remoteHandle, context).execute( A3CliCod, A1EmpCod, A88ImpLiqSec, GXv_boolean4) ;
      importcc_impl.this.AV74detalleHay = GXv_boolean4[0] ;
      if ( ! AV74detalleHay )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Antes de poder eliminar conceptos no usados debe importar las Liquidaciones desde el archivo de LSD", "")) ;
      }
      else
      {
         GXv_char7[0] = A89ImpLiqConExtCod ;
         GXv_boolean4[0] = AV75errorHay ;
         new web.validareliminacionimpconcepto(remoteHandle, context).execute( A3CliCod, A1EmpCod, A88ImpLiqSec, GXv_char7, GXv_boolean4) ;
         importcc_impl.this.A89ImpLiqConExtCod = GXv_char7[0] ;
         importcc_impl.this.AV75errorHay = GXv_boolean4[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89ImpLiqConExtCod", A89ImpLiqConExtCod);
         if ( AV75errorHay )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Eliminación no permitida porque existe importación de liquidación de LSD y el concepto no tiene relacionado un concepto del sistema.", "")) ;
         }
         else
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new web.mensajeconfirmaciondefault(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "eliminar", ""), httpContext.getMessage( "registro de concepto externo / AFIP", ""), GXv_char7) ;
            importcc_impl.this.GXt_char6 = GXv_char7[0] ;
            Dvelop_confirmpanel_eliminar_Confirmationtext = GXt_char6 ;
            ucDvelop_confirmpanel_eliminar.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_eliminar_Internalname, "ConfirmationText", Dvelop_confirmpanel_eliminar_Confirmationtext);
            AV69CliCod_Selected = A3CliCod ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69CliCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69CliCod_Selected), 6, 0));
            AV70EmpCod_Selected = A1EmpCod ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70EmpCod_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70EmpCod_Selected), 4, 0));
            AV71ImpLiqSec_Selected = A88ImpLiqSec ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71ImpLiqSec_Selected", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71ImpLiqSec_Selected), 4, 0));
            AV72ImpLiqConExtCod_Selected = A89ImpLiqConExtCod ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72ImpLiqConExtCod_Selected", AV72ImpLiqConExtCod_Selected);
            this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_ELIMINARContainer", "Confirm", "", new Object[] {});
         }
      }
      /*  Sending Event outputs  */
   }

   public void e168B2( )
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
         gxgrgrid_refresh( subGrid_Rows, AV9CliCod, AV10EmpCod, AV21ColumnsSelector, AV85Pgmname, AV59TFiconoUpdate, AV60TFiconoUpdateOperator, AV78TFImpLiqTipoConCod_Sels, AV63TFImpLiqConExtCodYDescrip, AV64TFImpLiqConExtCodYDescrip_Sels, AV80TFImpLiqAfipCodMasDesc, AV81TFImpLiqAfipCodMasDesc_Sels, AV66TFImpLiqConSisCodYDescrip, AV67TFImpLiqConSisCodYDescrip_Sels, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV21ColumnsSelector", AV21ColumnsSelector);
   }

   public void e178B2( )
   {
      /* Importexcel_modal_Close Routine */
      returnInSub = false ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV21ColumnsSelector", AV21ColumnsSelector);
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV16OrderedBy, 4, 0))+":"+(AV17OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV21ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "&iconoUpdate", "", "Estado", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ImpLiqTipoConCod", "", "Tipo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ImpLiqConExtCodYDescrip", "", "Concepto Externo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ImpLiqAfipCodMasDesc", "", "Concepto AFIP", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ImpLiqConSisCodYDescrip", "", "Concepto Sistema", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV20UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "ImportCCColumnsSelector", GXv_char7) ;
      importcc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV20UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV56TempBoolean ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SaveFilterAs", GXv_boolean4) ;
      importcc_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV56TempBoolean = GXt_boolean3 ;
      if ( ! ( AV56TempBoolean ) )
      {
         bttBtnimportexcel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnimportexcel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportexcel_Visible), 5, 0), true);
      }
   }

   public void S172( )
   {
      /* 'DO ELIMINAR' Routine */
      returnInSub = false ;
      new web.eliminarimportacionconceptos(remoteHandle, context).execute( AV69CliCod_Selected, AV70EmpCod_Selected, AV71ImpLiqSec_Selected, AV72ImpLiqConExtCod_Selected) ;
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue(AV85Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV85Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV23Session.getValue(AV85Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV95GXV1 = 1 ;
      while ( AV95GXV1 <= AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV95GXV1));
         if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV60TFiconoUpdateOperator = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFiconoUpdateOperator), 4, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQTIPOCONCOD_SEL") == 0 )
         {
            AV77TFImpLiqTipoConCod_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77TFImpLiqTipoConCod_SelsJson", AV77TFImpLiqTipoConCod_SelsJson);
            AV78TFImpLiqTipoConCod_Sels.fromJSonString(AV77TFImpLiqTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONEXTCODYDESCRIP") == 0 )
         {
            AV63TFImpLiqConExtCodYDescrip = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63TFImpLiqConExtCodYDescrip", AV63TFImpLiqConExtCodYDescrip);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONEXTCODYDESCRIP_SEL") == 0 )
         {
            AV62TFImpLiqConExtCodYDescrip_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62TFImpLiqConExtCodYDescrip_SelsJson", AV62TFImpLiqConExtCodYDescrip_SelsJson);
            AV64TFImpLiqConExtCodYDescrip_Sels.fromJSonString(AV62TFImpLiqConExtCodYDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQAFIPCODMASDESC") == 0 )
         {
            AV80TFImpLiqAfipCodMasDesc = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80TFImpLiqAfipCodMasDesc", AV80TFImpLiqAfipCodMasDesc);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQAFIPCODMASDESC_SEL") == 0 )
         {
            AV79TFImpLiqAfipCodMasDesc_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79TFImpLiqAfipCodMasDesc_SelsJson", AV79TFImpLiqAfipCodMasDesc_SelsJson);
            AV81TFImpLiqAfipCodMasDesc_Sels.fromJSonString(AV79TFImpLiqAfipCodMasDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONSISCODYDESCRIP") == 0 )
         {
            AV66TFImpLiqConSisCodYDescrip = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFImpLiqConSisCodYDescrip", AV66TFImpLiqConSisCodYDescrip);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQCONSISCODYDESCRIP_SEL") == 0 )
         {
            AV65TFImpLiqConSisCodYDescrip_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFImpLiqConSisCodYDescrip_SelsJson", AV65TFImpLiqConSisCodYDescrip_SelsJson);
            AV67TFImpLiqConSisCodYDescrip_Sels.fromJSonString(AV65TFImpLiqConSisCodYDescrip_SelsJson, null);
         }
         AV95GXV1 = (int)(AV95GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV78TFImpLiqTipoConCod_Sels.size()==0), AV77TFImpLiqTipoConCod_SelsJson, GXv_char7) ;
      importcc_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV64TFImpLiqConExtCodYDescrip_Sels.size()==0), AV62TFImpLiqConExtCodYDescrip_SelsJson, GXv_char11) ;
      importcc_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV81TFImpLiqAfipCodMasDesc_Sels.size()==0), AV79TFImpLiqAfipCodMasDesc_SelsJson, GXv_char13) ;
      importcc_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV67TFImpLiqConSisCodYDescrip_Sels.size()==0), AV65TFImpLiqConSisCodYDescrip_SelsJson, GXv_char15) ;
      importcc_impl.this.GXt_char14 = GXv_char15[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char6+"|"+GXt_char10+"|"+GXt_char12+"|"+GXt_char14 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV63TFImpLiqConExtCodYDescrip)==0), AV63TFImpLiqConExtCodYDescrip, GXv_char15) ;
      importcc_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV80TFImpLiqAfipCodMasDesc)==0), AV80TFImpLiqAfipCodMasDesc, GXv_char13) ;
      importcc_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV66TFImpLiqConSisCodYDescrip)==0), AV66TFImpLiqConSisCodYDescrip, GXv_char11) ;
      importcc_impl.this.GXt_char10 = GXv_char11[0] ;
      Ddo_grid_Filteredtext_set = "||"+GXt_char14+"|"+GXt_char12+"|"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Selectedfixedfilter = ((AV60TFiconoUpdateOperator!=1) ? "" : "1")+((AV60TFiconoUpdateOperator!=2) ? "" : "2")+((AV60TFiconoUpdateOperator!=3) ? "" : "3")+"||||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedFixedFilter", Ddo_grid_Selectedfixedfilter);
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
      AV14GridState.fromxml(AV23Session.getValue(AV85Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState16[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFICONOUPDATE", httpContext.getMessage( "Estado", ""), !((GXutil.strcmp("", AV59TFiconoUpdate)==0)&&(0==AV60TFiconoUpdateOperator)), AV60TFiconoUpdateOperator, AV59TFiconoUpdate, "") ;
      AV14GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFIMPLIQTIPOCONCOD_SEL", httpContext.getMessage( "Tipo", ""), !(AV78TFImpLiqTipoConCod_Sels.size()==0), (short)(0), AV78TFImpLiqTipoConCod_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFIMPLIQCONEXTCODYDESCRIP", httpContext.getMessage( "Concepto Externo", ""), !(GXutil.strcmp("", AV63TFImpLiqConExtCodYDescrip)==0), (short)(0), AV63TFImpLiqConExtCodYDescrip, "", !(AV64TFImpLiqConExtCodYDescrip_Sels.size()==0), AV64TFImpLiqConExtCodYDescrip_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFIMPLIQAFIPCODMASDESC", httpContext.getMessage( "Concepto AFIP", ""), !(GXutil.strcmp("", AV80TFImpLiqAfipCodMasDesc)==0), (short)(0), AV80TFImpLiqAfipCodMasDesc, "", !(AV81TFImpLiqAfipCodMasDesc_Sels.size()==0), AV81TFImpLiqAfipCodMasDesc_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState16[0] ;
      GXv_SdtWWPGridState16[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState16, "TFIMPLIQCONSISCODYDESCRIP", httpContext.getMessage( "Concepto Sistema", ""), !(GXutil.strcmp("", AV66TFImpLiqConSisCodYDescrip)==0), (short)(0), AV66TFImpLiqConSisCodYDescrip, "", !(AV67TFImpLiqConSisCodYDescrip_Sels.size()==0), AV67TFImpLiqConSisCodYDescrip_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState16[0] ;
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
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV85Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV85Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "importacion_conceptos" );
      AV23Session.setValue("TrnContext", AV12TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void wb_table4_73_8B2( boolean wbgen )
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
         wb_table4_73_8B2e( true) ;
      }
      else
      {
         wb_table4_73_8B2e( false) ;
      }
   }

   public void wb_table3_68_8B2( boolean wbgen )
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
         wb_table3_68_8B2e( true) ;
      }
      else
      {
         wb_table3_68_8B2e( false) ;
      }
   }

   public void wb_table2_63_8B2( boolean wbgen )
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
         wb_table2_63_8B2e( true) ;
      }
      else
      {
         wb_table2_63_8B2e( false) ;
      }
   }

   public void wb_table1_15_8B2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total: ", ""), "", "", lblTotaltext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_ImportCC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, httpContext.getMessage( " X registros", ""), "", "", lblCouttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", 1, 1, 0, (short)(0), "HLP_ImportCC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_15_8B2e( true) ;
      }
      else
      {
         wb_table1_15_8B2e( false) ;
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
      pa8B2( ) ;
      ws8B2( ) ;
      we8B2( ) ;
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
      pa8B2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importcc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa8B2( ) ;
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
      pa8B2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws8B2( ) ;
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
      ws8B2( ) ;
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
      we8B2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202012483", true, true);
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
      httpContext.AddJavascriptSource("importcc.js", "?202412202012483", false, true);
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

   public void subsflControlProps_412( )
   {
      edtavEliminar_Internalname = sPrefix+"vELIMINAR_"+sGXsfl_41_idx ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS_"+sGXsfl_41_idx ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE_"+sGXsfl_41_idx ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC_"+sGXsfl_41_idx ;
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_41_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_41_idx ;
      cmbImpLiqTipoConCod.setInternalname( sPrefix+"IMPLIQTIPOCONCOD_"+sGXsfl_41_idx );
      edtImpLiqConExtCodYDescrip_Internalname = sPrefix+"IMPLIQCONEXTCODYDESCRIP_"+sGXsfl_41_idx ;
      edtImpLiqAfipCodMasDesc_Internalname = sPrefix+"IMPLIQAFIPCODMASDESC_"+sGXsfl_41_idx ;
      edtImpLiqConSisCodYDescrip_Internalname = sPrefix+"IMPLIQCONSISCODYDESCRIP_"+sGXsfl_41_idx ;
      edtImpLiqConError_Internalname = sPrefix+"IMPLIQCONERROR_"+sGXsfl_41_idx ;
      edtImpLiqConWarning_Internalname = sPrefix+"IMPLIQCONWARNING_"+sGXsfl_41_idx ;
   }

   public void subsflControlProps_fel_412( )
   {
      edtavEliminar_Internalname = sPrefix+"vELIMINAR_"+sGXsfl_41_fel_idx ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS_"+sGXsfl_41_fel_idx ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE_"+sGXsfl_41_fel_idx ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC_"+sGXsfl_41_fel_idx ;
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_41_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_41_fel_idx ;
      cmbImpLiqTipoConCod.setInternalname( sPrefix+"IMPLIQTIPOCONCOD_"+sGXsfl_41_fel_idx );
      edtImpLiqConExtCodYDescrip_Internalname = sPrefix+"IMPLIQCONEXTCODYDESCRIP_"+sGXsfl_41_fel_idx ;
      edtImpLiqAfipCodMasDesc_Internalname = sPrefix+"IMPLIQAFIPCODMASDESC_"+sGXsfl_41_fel_idx ;
      edtImpLiqConSisCodYDescrip_Internalname = sPrefix+"IMPLIQCONSISCODYDESCRIP_"+sGXsfl_41_fel_idx ;
      edtImpLiqConError_Internalname = sPrefix+"IMPLIQCONERROR_"+sGXsfl_41_fel_idx ;
      edtImpLiqConWarning_Internalname = sPrefix+"IMPLIQCONWARNING_"+sGXsfl_41_fel_idx ;
   }

   public void sendrow_412( )
   {
      subsflControlProps_412( ) ;
      wb8B0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_41_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_41_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_41_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'"+sPrefix+"',false,'"+sGXsfl_41_idx+"',41)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminar_Internalname,GXutil.rtrim( AV68Eliminar),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEliminar_Enabled!=0)&&(edtavEliminar_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,42);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVELIMINAR.CLICK."+sGXsfl_41_idx+"'","","","","",edtavEliminar_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavEliminar_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavIconoupdatewithtags_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 43,'"+sPrefix+"',false,'"+sGXsfl_41_idx+"',41)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdatewithtags_Internalname,AV61iconoUpdateWithTags,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,43);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavIconoupdatewithtags_Link,"","","",edtavIconoupdatewithtags_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavIconoupdatewithtags_Visible),Integer.valueOf(edtavIconoupdatewithtags_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 44,'"+sPrefix+"',false,'"+sGXsfl_41_idx+"',41)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdate_Internalname,GXutil.rtrim( AV57iconoUpdate),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,44);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+"e238b2_client"+"'","","","","",edtavIconoupdate_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavIconoupdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqSec_Internalname,GXutil.ltrim( localUtil.ntoc( A88ImpLiqSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A88ImpLiqSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbImpLiqTipoConCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbImpLiqTipoConCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "IMPLIQTIPOCONCOD_" + sGXsfl_41_idx ;
            cmbImpLiqTipoConCod.setName( GXCCtl );
            cmbImpLiqTipoConCod.setWebtags( "" );
            cmbImpLiqTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
            cmbImpLiqTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
            cmbImpLiqTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
            cmbImpLiqTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
            if ( cmbImpLiqTipoConCod.getItemCount() > 0 )
            {
               A911ImpLiqTipoConCod = cmbImpLiqTipoConCod.getValidValue(A911ImpLiqTipoConCod) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbImpLiqTipoConCod,cmbImpLiqTipoConCod.getInternalname(),GXutil.rtrim( A911ImpLiqTipoConCod),Integer.valueOf(1),cmbImpLiqTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbImpLiqTipoConCod.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbImpLiqTipoConCod.setValue( GXutil.rtrim( A911ImpLiqTipoConCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbImpLiqTipoConCod.getInternalname(), "Values", cmbImpLiqTipoConCod.ToJavascriptSource(), !bGXsfl_41_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtImpLiqConExtCodYDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqConExtCodYDescrip_Internalname,A701ImpLiqConExtCodYDescrip,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqConExtCodYDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtImpLiqConExtCodYDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtImpLiqAfipCodMasDesc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqAfipCodMasDesc_Internalname,A912ImpLiqAfipCodMasDesc,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqAfipCodMasDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtImpLiqAfipCodMasDesc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtImpLiqConSisCodYDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqConSisCodYDescrip_Internalname,A702ImpLiqConSisCodYDescrip,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqConSisCodYDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtImpLiqConSisCodYDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqConError_Internalname,A659ImpLiqConError,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqConError_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"error","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpLiqConWarning_Internalname,A660ImpLiqConWarning,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtImpLiqConWarning_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"error","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes8B2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_41_idx = ((subGrid_Islastpage==1)&&(nGXsfl_41_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_412( ) ;
      }
      /* End function sendrow_412 */
   }

   public void startgridcontrol41( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"41\">") ;
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
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavIconoupdatewithtags_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbImpLiqTipoConCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtImpLiqConExtCodYDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto Externo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtImpLiqAfipCodMasDesc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto AFIP", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtImpLiqConSisCodYDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto Sistema", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV68Eliminar));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminar_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV61iconoUpdateWithTags);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdatewithtags_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavIconoupdatewithtags_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavIconoupdatewithtags_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV57iconoUpdate));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdate_Enabled, (byte)(5), (byte)(0), ".", "")));
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A911ImpLiqTipoConCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbImpLiqTipoConCod.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A701ImpLiqConExtCodYDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtImpLiqConExtCodYDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A912ImpLiqAfipCodMasDesc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtImpLiqAfipCodMasDesc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A702ImpLiqConSisCodYDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtImpLiqConSisCodYDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A659ImpLiqConError);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A660ImpLiqConWarning);
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
      bttBtnimportexcel_Internalname = sPrefix+"BTNIMPORTEXCEL" ;
      bttBtneditcolumns_Internalname = sPrefix+"BTNEDITCOLUMNS" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      bttBtneliminartodos_Internalname = sPrefix+"BTNELIMINARTODOS" ;
      edtavEliminar_Internalname = sPrefix+"vELIMINAR" ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS" ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE" ;
      edtImpLiqSec_Internalname = sPrefix+"IMPLIQSEC" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      cmbImpLiqTipoConCod.setInternalname( sPrefix+"IMPLIQTIPOCONCOD" );
      edtImpLiqConExtCodYDescrip_Internalname = sPrefix+"IMPLIQCONEXTCODYDESCRIP" ;
      edtImpLiqAfipCodMasDesc_Internalname = sPrefix+"IMPLIQAFIPCODMASDESC" ;
      edtImpLiqConSisCodYDescrip_Internalname = sPrefix+"IMPLIQCONSISCODYDESCRIP" ;
      edtImpLiqConError_Internalname = sPrefix+"IMPLIQCONERROR" ;
      edtImpLiqConWarning_Internalname = sPrefix+"IMPLIQCONWARNING" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Popover_iconoupdate_Internalname = sPrefix+"POPOVER_ICONOUPDATE" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      Ddo_gridcolumnsselector_Internalname = sPrefix+"DDO_GRIDCOLUMNSSELECTOR" ;
      Dvelop_confirmpanel_btneliminartodos_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_BTNELIMINARTODOS" ;
      tblTabledvelop_confirmpanel_btneliminartodos_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_BTNELIMINARTODOS" ;
      Dvelop_confirmpanel_eliminar_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_ELIMINAR" ;
      tblTabledvelop_confirmpanel_eliminar_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_ELIMINAR" ;
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
      edtImpLiqConWarning_Jsonclick = "" ;
      edtImpLiqConError_Jsonclick = "" ;
      edtImpLiqConSisCodYDescrip_Jsonclick = "" ;
      edtImpLiqAfipCodMasDesc_Jsonclick = "" ;
      edtImpLiqConExtCodYDescrip_Jsonclick = "" ;
      cmbImpLiqTipoConCod.setJsonclick( "" );
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtImpLiqSec_Jsonclick = "" ;
      edtavIconoupdate_Jsonclick = "" ;
      edtavIconoupdate_Visible = 0 ;
      edtavIconoupdate_Enabled = 1 ;
      edtavIconoupdatewithtags_Jsonclick = "" ;
      edtavIconoupdatewithtags_Link = "" ;
      edtavIconoupdatewithtags_Enabled = 1 ;
      edtavEliminar_Jsonclick = "" ;
      edtavEliminar_Visible = -1 ;
      edtavEliminar_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtImpLiqConSisCodYDescrip_Visible = -1 ;
      edtImpLiqAfipCodMasDesc_Visible = -1 ;
      edtImpLiqConExtCodYDescrip_Visible = -1 ;
      cmbImpLiqTipoConCod.setVisible( -1 );
      edtavIconoupdatewithtags_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      divGridtablewithpaginationbar_Visible = 1 ;
      bttBtneliminartodos_Visible = 1 ;
      bttBtnimportexcel_Caption = httpContext.getMessage( "Importar archivo de conceptos AFIP externo", "") ;
      bttBtnimportexcel_Visible = 1 ;
      Grid_empowerer_Popoversingrid = "Popover_iconoUpdate" ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Importexcel_modal_Bodytype = "WebComponent" ;
      Importexcel_modal_Confirmtype = "" ;
      Importexcel_modal_Title = httpContext.getMessage( "Importar archivo", "") ;
      Importexcel_modal_Width = "400" ;
      Dvelop_confirmpanel_eliminar_Confirmtype = "1" ;
      Dvelop_confirmpanel_eliminar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_eliminar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_eliminar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_eliminar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_eliminar_Confirmationtext = "" ;
      Dvelop_confirmpanel_eliminar_Title = httpContext.getMessage( "Eliminar", "") ;
      Dvelop_confirmpanel_btneliminartodos_Confirmtype = "1" ;
      Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_btneliminartodos_Confirmationtext = "" ;
      Dvelop_confirmpanel_btneliminartodos_Title = "" ;
      Ddo_gridcolumnsselector_Titlecontrolidtoreplace = "" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector hidden-xs" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Ddo_grid_Fixedfilters = "1:Con Warnings:fa fa-circle FontColorIconWarning FontColorIconSmall ConditionalFormattingFilterIcon,2:Con Errores:fa fa-circle FontColorIconDanger FontColorIconSmall ConditionalFormattingFilterIcon,3:Validados OK:fa fa-circle FontColorIconSuccess FontColorIconSmall ConditionalFormattingFilterIcon||||" ;
      Ddo_grid_Datalistproc = "ImportCCGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|REM_ARG:Remunerativo,NRE_ARG:No Remunerativo,DES_ARG:Retención,CAL_ARG:Cálculo|||" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|T" ;
      Ddo_grid_Datalisttype = "|FixedValues|Dynamic|Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T|T|T" ;
      Ddo_grid_Filtertype = "||Character|Character|Character" ;
      Ddo_grid_Includefilter = "||T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|2|3|4|5" ;
      Ddo_grid_Columnids = "1:iconoUpdate|6:ImpLiqTipoConCod|7:ImpLiqConExtCodYDescrip|8:ImpLiqAfipCodMasDesc|9:ImpLiqConSisCodYDescrip" ;
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
      GXCCtl = "IMPLIQTIPOCONCOD_" + sGXsfl_41_idx ;
      cmbImpLiqTipoConCod.setName( GXCCtl );
      cmbImpLiqTipoConCod.setWebtags( "" );
      cmbImpLiqTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbImpLiqTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbImpLiqTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbImpLiqTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbImpLiqTipoConCod.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Caption'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'cmbImpLiqTipoConCod'},{av:'edtImpLiqConExtCodYDescrip_Visible',ctrl:'IMPLIQCONEXTCODYDESCRIP',prop:'Visible'},{av:'edtImpLiqAfipCodMasDesc_Visible',ctrl:'IMPLIQAFIPCODMASDESC',prop:'Visible'},{av:'edtImpLiqConSisCodYDescrip_Visible',ctrl:'IMPLIQCONSISCODYDESCRIP',prop:'Visible'},{av:'AV50GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV51GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e128B2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e138B2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e148B2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Selectedcolumnfixedfilter',ctrl:'DDO_GRID',prop:'SelectedColumnFixedFilter'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV77TFImpLiqTipoConCod_SelsJson',fld:'vTFIMPLIQTIPOCONCOD_SELSJSON',pic:''},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV62TFImpLiqConExtCodYDescrip_SelsJson',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELSJSON',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV79TFImpLiqAfipCodMasDesc_SelsJson',fld:'vTFIMPLIQAFIPCODMASDESC_SELSJSON',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV65TFImpLiqConSisCodYDescrip_SelsJson',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELSJSON',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e218B2',iparms:[{av:'A659ImpLiqConError',fld:'IMPLIQCONERROR',pic:'',hsh:true},{av:'A660ImpLiqConWarning',fld:'IMPLIQCONWARNING',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'A89ImpLiqConExtCod',fld:'IMPLIQCONEXTCOD',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV68Eliminar',fld:'vELIMINAR',pic:''},{av:'AV57iconoUpdate',fld:'vICONOUPDATE',pic:''},{av:'AV61iconoUpdateWithTags',fld:'vICONOUPDATEWITHTAGS',pic:''},{av:'edtavIconoupdatewithtags_Link',ctrl:'vICONOUPDATEWITHTAGS',prop:'Link'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e158B2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Caption'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'cmbImpLiqTipoConCod'},{av:'edtImpLiqConExtCodYDescrip_Visible',ctrl:'IMPLIQCONEXTCODYDESCRIP',prop:'Visible'},{av:'edtImpLiqAfipCodMasDesc_Visible',ctrl:'IMPLIQAFIPCODMASDESC',prop:'Visible'},{av:'edtImpLiqConSisCodYDescrip_Visible',ctrl:'IMPLIQCONSISCODYDESCRIP',prop:'Visible'},{av:'AV50GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV51GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("'DOELIMINARTODOS'","{handler:'e188B2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DOELIMINARTODOS'",",oparms:[{av:'Dvelop_confirmpanel_btneliminartodos_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_BTNELIMINARTODOS',prop:'ConfirmationText'}]}");
      setEventMetadata("VELIMINAR.CLICK","{handler:'e228B2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A88ImpLiqSec',fld:'IMPLIQSEC',pic:'ZZZ9',hsh:true},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("VELIMINAR.CLICK",",oparms:[{av:'A89ImpLiqConExtCod',fld:'IMPLIQCONEXTCOD',pic:''},{av:'Dvelop_confirmpanel_eliminar_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'ConfirmationText'},{av:'AV69CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV70EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV71ImpLiqSec_Selected',fld:'vIMPLIQSEC_SELECTED',pic:'ZZZ9'},{av:'AV72ImpLiqConExtCod_Selected',fld:'vIMPLIQCONEXTCOD_SELECTED',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE","{handler:'e168B2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Dvelop_confirmpanel_eliminar_Result',ctrl:'DVELOP_CONFIRMPANEL_ELIMINAR',prop:'Result'},{av:'AV69CliCod_Selected',fld:'vCLICOD_SELECTED',pic:'ZZZZZ9'},{av:'AV70EmpCod_Selected',fld:'vEMPCOD_SELECTED',pic:'ZZZ9'},{av:'AV71ImpLiqSec_Selected',fld:'vIMPLIQSEC_SELECTED',pic:'ZZZ9'},{av:'AV72ImpLiqConExtCod_Selected',fld:'vIMPLIQCONEXTCOD_SELECTED',pic:''}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ELIMINAR.CLOSE",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Caption'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'cmbImpLiqTipoConCod'},{av:'edtImpLiqConExtCodYDescrip_Visible',ctrl:'IMPLIQCONEXTCODYDESCRIP',prop:'Visible'},{av:'edtImpLiqAfipCodMasDesc_Visible',ctrl:'IMPLIQAFIPCODMASDESC',prop:'Visible'},{av:'edtImpLiqConSisCodYDescrip_Visible',ctrl:'IMPLIQCONSISCODYDESCRIP',prop:'Visible'},{av:'AV50GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV51GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("'DOIMPORTEXCEL'","{handler:'e118B1',iparms:[]");
      setEventMetadata("'DOIMPORTEXCEL'",",oparms:[]}");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE","{handler:'e178B2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV10EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV85Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV59TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV60TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV78TFImpLiqTipoConCod_Sels',fld:'vTFIMPLIQTIPOCONCOD_SELS',pic:''},{av:'AV63TFImpLiqConExtCodYDescrip',fld:'vTFIMPLIQCONEXTCODYDESCRIP',pic:''},{av:'AV64TFImpLiqConExtCodYDescrip_Sels',fld:'vTFIMPLIQCONEXTCODYDESCRIP_SELS',pic:''},{av:'AV80TFImpLiqAfipCodMasDesc',fld:'vTFIMPLIQAFIPCODMASDESC',pic:''},{av:'AV81TFImpLiqAfipCodMasDesc_Sels',fld:'vTFIMPLIQAFIPCODMASDESC_SELS',pic:''},{av:'AV66TFImpLiqConSisCodYDescrip',fld:'vTFIMPLIQCONSISCODYDESCRIP',pic:''},{av:'AV67TFImpLiqConSisCodYDescrip_Sels',fld:'vTFIMPLIQCONSISCODYDESCRIP_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'}]");
      setEventMetadata("IMPORTEXCEL_MODAL.CLOSE",",oparms:[{av:'divGridtablewithpaginationbar_Visible',ctrl:'GRIDTABLEWITHPAGINATIONBAR',prop:'Visible'},{ctrl:'BTNIMPORTEXCEL',prop:'Caption'},{ctrl:'BTNELIMINARTODOS',prop:'Visible'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtavIconoupdatewithtags_Visible',ctrl:'vICONOUPDATEWITHTAGS',prop:'Visible'},{av:'cmbImpLiqTipoConCod'},{av:'edtImpLiqConExtCodYDescrip_Visible',ctrl:'IMPLIQCONEXTCODYDESCRIP',prop:'Visible'},{av:'edtImpLiqAfipCodMasDesc_Visible',ctrl:'IMPLIQAFIPCODMASDESC',prop:'Visible'},{av:'edtImpLiqConSisCodYDescrip_Visible',ctrl:'IMPLIQCONSISCODYDESCRIP',prop:'Visible'},{av:'AV50GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV51GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV52GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTEXCEL',prop:'Visible'}]}");
      setEventMetadata("VICONOUPDATE.CLICK","{handler:'e238B2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A659ImpLiqConError',fld:'IMPLIQCONERROR',pic:'',hsh:true},{av:'A660ImpLiqConWarning',fld:'IMPLIQCONWARNING',pic:'',hsh:true}]");
      setEventMetadata("VICONOUPDATE.CLICK",",oparms:[{ctrl:'WWPAUX_WC'}]}");
      setEventMetadata("NULL","{handler:'valid_Impliqconwarning',iparms:[]");
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
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Selectedcolumnfixedfilter = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Dvelop_confirmpanel_btneliminartodos_Result = "" ;
      Dvelop_confirmpanel_eliminar_Result = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV85Pgmname = "" ;
      AV59TFiconoUpdate = "" ;
      AV78TFImpLiqTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFImpLiqConExtCodYDescrip = "" ;
      AV64TFImpLiqConExtCodYDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFImpLiqAfipCodMasDesc = "" ;
      AV81TFImpLiqAfipCodMasDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66TFImpLiqConSisCodYDescrip = "" ;
      AV67TFImpLiqConSisCodYDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV52GridAppliedFilters = "" ;
      AV48DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      A89ImpLiqConExtCod = "" ;
      AV72ImpLiqConExtCod_Selected = "" ;
      AV8ExtraParms = new GXSimpleCollection<String>(String.class, "internal", "");
      Popover_iconoupdate_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_grid_Selectedfixedfilter = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnimportexcel_Jsonclick = "" ;
      bttBtneditcolumns_Jsonclick = "" ;
      bttBtneliminartodos_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucPopover_iconoupdate = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV68Eliminar = "" ;
      AV61iconoUpdateWithTags = "" ;
      AV57iconoUpdate = "" ;
      A911ImpLiqTipoConCod = "" ;
      A701ImpLiqConExtCodYDescrip = "" ;
      A912ImpLiqAfipCodMasDesc = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A659ImpLiqConError = "" ;
      A660ImpLiqConWarning = "" ;
      AV88Importccds_3_tfimpliqtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90Importccds_5_tfimpliqconextcodydescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV92Importccds_7_tfimpliqafipcodmasdesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94Importccds_9_tfimpliqconsiscodydescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV89Importccds_4_tfimpliqconextcodydescrip = "" ;
      lV91Importccds_6_tfimpliqafipcodmasdesc = "" ;
      lV93Importccds_8_tfimpliqconsiscodydescrip = "" ;
      AV89Importccds_4_tfimpliqconextcodydescrip = "" ;
      AV91Importccds_6_tfimpliqafipcodmasdesc = "" ;
      AV93Importccds_8_tfimpliqconsiscodydescrip = "" ;
      H008B2_A89ImpLiqConExtCod = new String[] {""} ;
      H008B2_A660ImpLiqConWarning = new String[] {""} ;
      H008B2_A659ImpLiqConError = new String[] {""} ;
      H008B2_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      H008B2_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      H008B2_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      H008B2_A911ImpLiqTipoConCod = new String[] {""} ;
      H008B2_A1EmpCod = new short[1] ;
      H008B2_A3CliCod = new int[1] ;
      H008B2_A88ImpLiqSec = new short[1] ;
      AV86Importccds_1_tficonoupdate = "" ;
      H008B3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      AV77TFImpLiqTipoConCod_SelsJson = "" ;
      AV62TFImpLiqConExtCodYDescrip_SelsJson = "" ;
      AV79TFImpLiqAfipCodMasDesc_SelsJson = "" ;
      AV65TFImpLiqConSisCodYDescrip_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      ucDvelop_confirmpanel_btneliminartodos = new com.genexus.webpanels.GXUserControl();
      ucDvelop_confirmpanel_eliminar = new com.genexus.webpanels.GXUserControl();
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char13 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXv_SdtWWPGridState16 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      ucImportexcel_modal = new com.genexus.webpanels.GXUserControl();
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV9CliCod = "" ;
      sCtrlAV10EmpCod = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importcc__default(),
         new Object[] {
             new Object[] {
            H008B2_A89ImpLiqConExtCod, H008B2_A660ImpLiqConWarning, H008B2_A659ImpLiqConError, H008B2_A702ImpLiqConSisCodYDescrip, H008B2_A912ImpLiqAfipCodMasDesc, H008B2_A701ImpLiqConExtCodYDescrip, H008B2_A911ImpLiqTipoConCod, H008B2_A1EmpCod, H008B2_A3CliCod, H008B2_A88ImpLiqSec
            }
            , new Object[] {
            H008B3_AGRID_nRecordCount
            }
         }
      );
      AV85Pgmname = "ImportCC" ;
      /* GeneXus formulas. */
      AV85Pgmname = "ImportCC" ;
      Gx_err = (short)(0) ;
      edtavEliminar_Enabled = 0 ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      edtavIconoupdate_Enabled = 0 ;
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
   private short AV60TFiconoUpdateOperator ;
   private short AV16OrderedBy ;
   private short AV70EmpCod_Selected ;
   private short AV71ImpLiqSec_Selected ;
   private short wbEnd ;
   private short wbStart ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV87Importccds_2_tficonoupdateoperator ;
   private int wcpOAV9CliCod ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_41 ;
   private int AV9CliCod ;
   private int nGXsfl_41_idx=1 ;
   private int AV69CliCod_Selected ;
   private int Gridpaginationbar_Pagestoshow ;
   private int Popover_iconoupdate_Popoverwidth ;
   private int bttBtnimportexcel_Visible ;
   private int bttBtneliminartodos_Visible ;
   private int divGridtablewithpaginationbar_Visible ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavEliminar_Enabled ;
   private int edtavIconoupdatewithtags_Enabled ;
   private int edtavIconoupdate_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV88Importccds_3_tfimpliqtipoconcod_sels_size ;
   private int AV90Importccds_5_tfimpliqconextcodydescrip_sels_size ;
   private int AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size ;
   private int AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size ;
   private int edtavIconoupdatewithtags_Visible ;
   private int edtImpLiqConExtCodYDescrip_Visible ;
   private int edtImpLiqAfipCodMasDesc_Visible ;
   private int edtImpLiqConSisCodYDescrip_Visible ;
   private int AV49PageToGo ;
   private int AV95GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavEliminar_Visible ;
   private int edtavIconoupdate_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV50GridCurrentPage ;
   private long AV51GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Selectedcolumnfixedfilter ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Dvelop_confirmpanel_btneliminartodos_Result ;
   private String Dvelop_confirmpanel_eliminar_Result ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_41_idx="0001" ;
   private String AV85Pgmname ;
   private String AV59TFiconoUpdate ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A89ImpLiqConExtCod ;
   private String AV72ImpLiqConExtCod_Selected ;
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
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Fixable ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Fixedfilters ;
   private String Ddo_grid_Selectedfixedfilter ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_gridcolumnsselector_Titlecontrolidtoreplace ;
   private String Dvelop_confirmpanel_btneliminartodos_Title ;
   private String Dvelop_confirmpanel_btneliminartodos_Confirmationtext ;
   private String Dvelop_confirmpanel_btneliminartodos_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Nobuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_btneliminartodos_Yesbuttonposition ;
   private String Dvelop_confirmpanel_btneliminartodos_Confirmtype ;
   private String Dvelop_confirmpanel_eliminar_Title ;
   private String Dvelop_confirmpanel_eliminar_Confirmationtext ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_eliminar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_eliminar_Confirmtype ;
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
   private String bttBtnimportexcel_Internalname ;
   private String bttBtnimportexcel_Caption ;
   private String bttBtnimportexcel_Jsonclick ;
   private String bttBtneditcolumns_Internalname ;
   private String bttBtneditcolumns_Jsonclick ;
   private String bttBtneliminartodos_Internalname ;
   private String bttBtneliminartodos_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Popover_iconoupdate_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavEliminar_Internalname ;
   private String AV68Eliminar ;
   private String edtavIconoupdatewithtags_Internalname ;
   private String AV57iconoUpdate ;
   private String edtavIconoupdate_Internalname ;
   private String edtImpLiqSec_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String A911ImpLiqTipoConCod ;
   private String edtImpLiqConExtCodYDescrip_Internalname ;
   private String edtImpLiqAfipCodMasDesc_Internalname ;
   private String edtImpLiqConSisCodYDescrip_Internalname ;
   private String edtImpLiqConError_Internalname ;
   private String edtImpLiqConWarning_Internalname ;
   private String scmdbuf ;
   private String AV86Importccds_1_tficonoupdate ;
   private String edtavIconoupdatewithtags_Link ;
   private String Dvelop_confirmpanel_btneliminartodos_Internalname ;
   private String Dvelop_confirmpanel_eliminar_Internalname ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char12 ;
   private String GXv_char13[] ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String tblTableimportexcel_modal_Internalname ;
   private String Importexcel_modal_Internalname ;
   private String tblTabledvelop_confirmpanel_eliminar_Internalname ;
   private String tblTabledvelop_confirmpanel_btneliminartodos_Internalname ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Jsonclick ;
   private String sCtrlAV9CliCod ;
   private String sCtrlAV10EmpCod ;
   private String sGXsfl_41_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavEliminar_Jsonclick ;
   private String edtavIconoupdatewithtags_Jsonclick ;
   private String edtavIconoupdate_Jsonclick ;
   private String edtImpLiqSec_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String GXCCtl ;
   private String edtImpLiqConExtCodYDescrip_Jsonclick ;
   private String edtImpLiqAfipCodMasDesc_Jsonclick ;
   private String edtImpLiqConSisCodYDescrip_Jsonclick ;
   private String edtImpLiqConError_Jsonclick ;
   private String edtImpLiqConWarning_Jsonclick ;
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
   private boolean Grid_empowerer_Hascolumnsselector ;
   private boolean wbLoad ;
   private boolean bGXsfl_41_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV76conceptosHay ;
   private boolean AV74detalleHay ;
   private boolean AV75errorHay ;
   private boolean AV56TempBoolean ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private String AV19ColumnsSelectorXML ;
   private String AV77TFImpLiqTipoConCod_SelsJson ;
   private String AV62TFImpLiqConExtCodYDescrip_SelsJson ;
   private String AV79TFImpLiqAfipCodMasDesc_SelsJson ;
   private String AV65TFImpLiqConSisCodYDescrip_SelsJson ;
   private String AV20UserCustomValue ;
   private String AV63TFImpLiqConExtCodYDescrip ;
   private String AV80TFImpLiqAfipCodMasDesc ;
   private String AV66TFImpLiqConSisCodYDescrip ;
   private String AV52GridAppliedFilters ;
   private String AV61iconoUpdateWithTags ;
   private String A701ImpLiqConExtCodYDescrip ;
   private String A912ImpLiqAfipCodMasDesc ;
   private String A702ImpLiqConSisCodYDescrip ;
   private String A659ImpLiqConError ;
   private String A660ImpLiqConWarning ;
   private String lV89Importccds_4_tfimpliqconextcodydescrip ;
   private String lV91Importccds_6_tfimpliqafipcodmasdesc ;
   private String lV93Importccds_8_tfimpliqconsiscodydescrip ;
   private String AV89Importccds_4_tfimpliqconextcodydescrip ;
   private String AV91Importccds_6_tfimpliqafipcodmasdesc ;
   private String AV93Importccds_8_tfimpliqconsiscodydescrip ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucPopover_iconoupdate ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_btneliminartodos ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_eliminar ;
   private com.genexus.webpanels.GXUserControl ucImportexcel_modal ;
   private GXSimpleCollection<String> AV88Importccds_3_tfimpliqtipoconcod_sels ;
   private GXSimpleCollection<String> AV90Importccds_5_tfimpliqconextcodydescrip_sels ;
   private GXSimpleCollection<String> AV92Importccds_7_tfimpliqafipcodmasdesc_sels ;
   private GXSimpleCollection<String> AV94Importccds_9_tfimpliqconsiscodydescrip_sels ;
   private HTMLChoice cmbImpLiqTipoConCod ;
   private IDataStoreProvider pr_default ;
   private String[] H008B2_A89ImpLiqConExtCod ;
   private String[] H008B2_A660ImpLiqConWarning ;
   private String[] H008B2_A659ImpLiqConError ;
   private String[] H008B2_A702ImpLiqConSisCodYDescrip ;
   private String[] H008B2_A912ImpLiqAfipCodMasDesc ;
   private String[] H008B2_A701ImpLiqConExtCodYDescrip ;
   private String[] H008B2_A911ImpLiqTipoConCod ;
   private short[] H008B2_A1EmpCod ;
   private int[] H008B2_A3CliCod ;
   private short[] H008B2_A88ImpLiqSec ;
   private long[] H008B3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV78TFImpLiqTipoConCod_Sels ;
   private GXSimpleCollection<String> AV64TFImpLiqConExtCodYDescrip_Sels ;
   private GXSimpleCollection<String> AV81TFImpLiqAfipCodMasDesc_Sels ;
   private GXSimpleCollection<String> AV67TFImpLiqConSisCodYDescrip_Sels ;
   private GXSimpleCollection<String> AV8ExtraParms ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState16[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV15GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV48DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class importcc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H008B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A911ImpLiqTipoConCod ,
                                          GXSimpleCollection<String> AV88Importccds_3_tfimpliqtipoconcod_sels ,
                                          String A701ImpLiqConExtCodYDescrip ,
                                          GXSimpleCollection<String> AV90Importccds_5_tfimpliqconextcodydescrip_sels ,
                                          String A912ImpLiqAfipCodMasDesc ,
                                          GXSimpleCollection<String> AV92Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                          String A702ImpLiqConSisCodYDescrip ,
                                          GXSimpleCollection<String> AV94Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                          short AV87Importccds_2_tficonoupdateoperator ,
                                          int AV88Importccds_3_tfimpliqtipoconcod_sels_size ,
                                          int AV90Importccds_5_tfimpliqconextcodydescrip_sels_size ,
                                          String AV89Importccds_4_tfimpliqconextcodydescrip ,
                                          int AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size ,
                                          String AV91Importccds_6_tfimpliqafipcodmasdesc ,
                                          int AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size ,
                                          String AV93Importccds_8_tfimpliqconsiscodydescrip ,
                                          String A659ImpLiqConError ,
                                          String A660ImpLiqConWarning ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[8];
      Object[] GXv_Object18 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ImpLiqConExtCod, ImpLiqConWarning, ImpLiqConError, ImpLiqConSisCodYDescrip, ImpLiqAfipCodMasDesc, ImpLiqConExtCodYDescrip, ImpLiqTipoConCod, EmpCod, CliCod, ImpLiqSec" ;
      sFromString = " FROM importacion_conceptos" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV87Importccds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and Not (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV87Importccds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqConError))=0))");
      }
      if ( AV87Importccds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV88Importccds_3_tfimpliqtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV88Importccds_3_tfimpliqtipoconcod_sels, "ImpLiqTipoConCod IN (", ")")+")");
      }
      if ( ( AV90Importccds_5_tfimpliqconextcodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV89Importccds_4_tfimpliqconextcodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConExtCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV90Importccds_5_tfimpliqconextcodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Importccds_5_tfimpliqconextcodydescrip_sels, "ImpLiqConExtCodYDescrip IN (", ")")+")");
      }
      if ( ( AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV91Importccds_6_tfimpliqafipcodmasdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqAfipCodMasDesc) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Importccds_7_tfimpliqafipcodmasdesc_sels, "ImpLiqAfipCodMasDesc IN (", ")")+")");
      }
      if ( ( AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93Importccds_8_tfimpliqconsiscodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConSisCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94Importccds_9_tfimpliqconsiscodydescrip_sels, "ImpLiqConSisCodYDescrip IN (", ")")+")");
      }
      if ( AV16OrderedBy == 1 )
      {
         sOrderString += " ORDER BY ImpLiqConError DESC, ImpLiqConExtCod, CliCod, EmpCod, ImpLiqSec" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqTipoConCod DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqConExtCodYDescrip, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqConExtCodYDescrip DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqAfipCodMasDesc, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqAfipCodMasDesc DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY ImpLiqConSisCodYDescrip, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY ImpLiqConSisCodYDescrip DESC, CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_H008B3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A911ImpLiqTipoConCod ,
                                          GXSimpleCollection<String> AV88Importccds_3_tfimpliqtipoconcod_sels ,
                                          String A701ImpLiqConExtCodYDescrip ,
                                          GXSimpleCollection<String> AV90Importccds_5_tfimpliqconextcodydescrip_sels ,
                                          String A912ImpLiqAfipCodMasDesc ,
                                          GXSimpleCollection<String> AV92Importccds_7_tfimpliqafipcodmasdesc_sels ,
                                          String A702ImpLiqConSisCodYDescrip ,
                                          GXSimpleCollection<String> AV94Importccds_9_tfimpliqconsiscodydescrip_sels ,
                                          short AV87Importccds_2_tficonoupdateoperator ,
                                          int AV88Importccds_3_tfimpliqtipoconcod_sels_size ,
                                          int AV90Importccds_5_tfimpliqconextcodydescrip_sels_size ,
                                          String AV89Importccds_4_tfimpliqconextcodydescrip ,
                                          int AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size ,
                                          String AV91Importccds_6_tfimpliqafipcodmasdesc ,
                                          int AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size ,
                                          String AV93Importccds_8_tfimpliqconsiscodydescrip ,
                                          String A659ImpLiqConError ,
                                          String A660ImpLiqConWarning ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[5];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM importacion_conceptos" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( AV87Importccds_2_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and Not (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV87Importccds_2_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqConError))=0))");
      }
      if ( AV87Importccds_2_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqConError))=0) and (char_length(trim(trailing ' ' from ImpLiqConWarning))=0))");
      }
      if ( AV88Importccds_3_tfimpliqtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV88Importccds_3_tfimpliqtipoconcod_sels, "ImpLiqTipoConCod IN (", ")")+")");
      }
      if ( ( AV90Importccds_5_tfimpliqconextcodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV89Importccds_4_tfimpliqconextcodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConExtCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( AV90Importccds_5_tfimpliqconextcodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Importccds_5_tfimpliqconextcodydescrip_sels, "ImpLiqConExtCodYDescrip IN (", ")")+")");
      }
      if ( ( AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV91Importccds_6_tfimpliqafipcodmasdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqAfipCodMasDesc) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV92Importccds_7_tfimpliqafipcodmasdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV92Importccds_7_tfimpliqafipcodmasdesc_sels, "ImpLiqAfipCodMasDesc IN (", ")")+")");
      }
      if ( ( AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93Importccds_8_tfimpliqconsiscodydescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqConSisCodYDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV94Importccds_9_tfimpliqconsiscodydescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94Importccds_9_tfimpliqconsiscodydescrip_sels, "ImpLiqConSisCodYDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV16OrderedBy == 1 )
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
                  return conditional_H008B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() );
            case 1 :
                  return conditional_H008B3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H008B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H008B3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
      }
   }

}

