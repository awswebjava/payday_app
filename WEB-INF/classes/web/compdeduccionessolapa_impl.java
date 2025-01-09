package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class compdeduccionessolapa_impl extends GXWebComponent
{
   public compdeduccionessolapa_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public compdeduccionessolapa_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( compdeduccionessolapa_impl.class ));
   }

   public compdeduccionessolapa_impl( int remoteHandle ,
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
      cmbLegDedMes = new HTMLChoice();
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
               AV5CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
               AV13EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
               AV21LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21LegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV5CliCod),Short.valueOf(AV13EmpCod),Integer.valueOf(AV21LegNumero)});
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
      nRC_GXsfl_23 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_23"))) ;
      nGXsfl_23_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_23_idx"))) ;
      sGXsfl_23_idx = httpContext.GetPar( "sGXsfl_23_idx") ;
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
      AV5CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV13EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV21LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      AV51Pgmname = httpContext.GetPar( "Pgmname") ;
      AV22OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV23OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV45TFLegDedAnio = (short)(GXutil.lval( httpContext.GetPar( "TFLegDedAnio"))) ;
      AV46TFLegDedAnio_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegDedAnio_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV48TFLegDedMes_Sels);
      AV29TFLegDedConCodYDesc = httpContext.GetPar( "TFLegDedConCodYDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFLegDedConCodYDesc_Sels);
      AV32TFLegDedDescrip = httpContext.GetPar( "TFLegDedDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV33TFLegDedDescrip_Sels);
      AV39TFLegDedImporte = CommonUtil.decimalVal( httpContext.GetPar( "TFLegDedImporte"), ".") ;
      AV40TFLegDedImporte_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLegDedImporte_To"), ".") ;
      AV44datetime = localUtil.parseDTimeParm( httpContext.GetPar( "datetime")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV5CliCod, AV13EmpCod, AV21LegNumero, AV51Pgmname, AV22OrderedBy, AV23OrderedDsc, AV45TFLegDedAnio, AV46TFLegDedAnio_To, AV48TFLegDedMes_Sels, AV29TFLegDedConCodYDesc, AV30TFLegDedConCodYDesc_Sels, AV32TFLegDedDescrip, AV33TFLegDedDescrip_Sels, AV39TFLegDedImporte, AV40TFLegDedImporte_To, AV44datetime, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa5X2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Comp Deducciones Solapa", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.compdeduccionessolapa", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV5CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV21LegNumero,8,0))}, new String[] {"CliCod","EmpCod","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDATETIME", getSecureSignedToken( sPrefix, localUtil.format( AV44datetime, "99/99/99 99:99")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_23", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_23, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV15GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV16GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV14GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV12DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV12DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV5CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV13EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV13EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV21LegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV21LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV51Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV22OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV23OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGDEDANIO", GXutil.ltrim( localUtil.ntoc( AV45TFLegDedAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGDEDANIO_TO", GXutil.ltrim( localUtil.ntoc( AV46TFLegDedAnio_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLEGDEDMES_SELS", AV48TFLegDedMes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLEGDEDMES_SELS", AV48TFLegDedMes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGDEDCONCODYDESC", AV29TFLegDedConCodYDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLEGDEDCONCODYDESC_SELS", AV30TFLegDedConCodYDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLEGDEDCONCODYDESC_SELS", AV30TFLegDedConCodYDesc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGDEDDESCRIP", AV32TFLegDedDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLEGDEDDESCRIP_SELS", AV33TFLegDedDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLEGDEDDESCRIP_SELS", AV33TFLegDedDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGDEDIMPORTE", GXutil.ltrim( localUtil.ntoc( AV39TFLegDedImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGDEDIMPORTE_TO", GXutil.ltrim( localUtil.ntoc( AV40TFLegDedImporte_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV13EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV21LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDATETIME", localUtil.ttoc( AV44datetime, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDATETIME", getSecureSignedToken( sPrefix, localUtil.format( AV44datetime, "99/99/99 99:99")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
   }

   public void renderHtmlCloseForm5X2( )
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
      return "CompDeduccionesSolapa" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Comp Deducciones Solapa", "") ;
   }

   public void wb5X0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.compdeduccionessolapa");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         wb_table1_6_5X2( true) ;
      }
      else
      {
         wb_table1_6_5X2( false) ;
      }
      return  ;
   }

   public void wb_table1_6_5X2e( boolean wbgen )
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
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV12DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 23 )
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

   public void start5X2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Comp Deducciones Solapa", ""), (short)(0)) ;
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
            strup5X0( ) ;
         }
      }
   }

   public void ws5X2( )
   {
      start5X2( ) ;
      evt5X2( ) ;
   }

   public void evt5X2( )
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
                              strup5X0( ) ;
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
                              strup5X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e115X2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e125X2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e135X2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOIMPORTARSIRADIG'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5X0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoImportarSiradig' */
                                 e145X2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5X0( ) ;
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
                              strup5X0( ) ;
                           }
                           nGXsfl_23_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_232( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A83LegDedSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLegDedSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A556LegDedFchDes = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegDedFchDes_Internalname), 0)) ;
                           A768LegDedAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLegDedAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbLegDedMes.setName( cmbLegDedMes.getInternalname() );
                           cmbLegDedMes.setValue( httpContext.cgiGet( cmbLegDedMes.getInternalname()) );
                           A767LegDedMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegDedMes.getInternalname()))) ;
                           A557LegDedFchHas = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegDedFchHas_Internalname), 0)) ;
                           A84LegDedConCodigo = httpContext.cgiGet( edtLegDedConCodigo_Internalname) ;
                           A570LegDedConCodYDesc = httpContext.cgiGet( edtLegDedConCodYDesc_Internalname) ;
                           A568LegDedDescrip = httpContext.cgiGet( edtLegDedDescrip_Internalname) ;
                           A560LegDedImporte = localUtil.ctond( httpContext.cgiGet( edtLegDedImporte_Internalname)) ;
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
                                       e155X2 ();
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
                                       e165X2 ();
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
                                       e175X2 ();
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
                                    strup5X0( ) ;
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

   public void we5X2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm5X2( ) ;
         }
      }
   }

   public void pa5X2( )
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
      subsflControlProps_232( ) ;
      while ( nGXsfl_23_idx <= nRC_GXsfl_23 )
      {
         sendrow_232( ) ;
         nGXsfl_23_idx = ((subGrid_Islastpage==1)&&(nGXsfl_23_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_23_idx+1) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV5CliCod ,
                                 short AV13EmpCod ,
                                 int AV21LegNumero ,
                                 String AV51Pgmname ,
                                 short AV22OrderedBy ,
                                 boolean AV23OrderedDsc ,
                                 short AV45TFLegDedAnio ,
                                 short AV46TFLegDedAnio_To ,
                                 GXSimpleCollection<Byte> AV48TFLegDedMes_Sels ,
                                 String AV29TFLegDedConCodYDesc ,
                                 GXSimpleCollection<String> AV30TFLegDedConCodYDesc_Sels ,
                                 String AV32TFLegDedDescrip ,
                                 GXSimpleCollection<String> AV33TFLegDedDescrip_Sels ,
                                 java.math.BigDecimal AV39TFLegDedImporte ,
                                 java.math.BigDecimal AV40TFLegDedImporte_To ,
                                 java.util.Date AV44datetime ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e165X2 ();
      GRID_nCurrentRecord = 0 ;
      rf5X2( ) ;
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf5X2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV51Pgmname = "CompDeduccionesSolapa" ;
      Gx_err = (short)(0) ;
   }

   public void rf5X2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(23) ;
      /* Execute user event: Refresh */
      e165X2 ();
      nGXsfl_23_idx = 1 ;
      sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_232( ) ;
      bGXsfl_23_Refreshing = true ;
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
         subsflControlProps_232( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A570LegDedConCodYDesc ,
                                              AV30TFLegDedConCodYDesc_Sels ,
                                              Byte.valueOf(A767LegDedMes) ,
                                              AV48TFLegDedMes_Sels ,
                                              A568LegDedDescrip ,
                                              AV33TFLegDedDescrip_Sels ,
                                              Short.valueOf(AV45TFLegDedAnio) ,
                                              Short.valueOf(AV46TFLegDedAnio_To) ,
                                              Integer.valueOf(AV48TFLegDedMes_Sels.size()) ,
                                              Integer.valueOf(AV30TFLegDedConCodYDesc_Sels.size()) ,
                                              AV29TFLegDedConCodYDesc ,
                                              Integer.valueOf(AV33TFLegDedDescrip_Sels.size()) ,
                                              AV32TFLegDedDescrip ,
                                              AV39TFLegDedImporte ,
                                              AV40TFLegDedImporte_To ,
                                              Short.valueOf(A768LegDedAnio) ,
                                              A84LegDedConCodigo ,
                                              A559LegDedConDescrip ,
                                              A560LegDedImporte ,
                                              Short.valueOf(AV22OrderedBy) ,
                                              Boolean.valueOf(AV23OrderedDsc) ,
                                              Integer.valueOf(AV5CliCod) ,
                                              Short.valueOf(AV13EmpCod) ,
                                              Integer.valueOf(AV21LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         lV29TFLegDedConCodYDesc = GXutil.concat( GXutil.rtrim( AV29TFLegDedConCodYDesc), "%", "") ;
         lV32TFLegDedDescrip = GXutil.concat( GXutil.rtrim( AV32TFLegDedDescrip), "%", "") ;
         /* Using cursor H005X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV21LegNumero), Integer.valueOf(AV30TFLegDedConCodYDesc_Sels.size()), Short.valueOf(AV45TFLegDedAnio), Short.valueOf(AV46TFLegDedAnio_To), lV29TFLegDedConCodYDesc, lV32TFLegDedDescrip, AV39TFLegDedImporte, AV40TFLegDedImporte_To, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_23_idx = 1 ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A560LegDedImporte = H005X2_A560LegDedImporte[0] ;
            A568LegDedDescrip = H005X2_A568LegDedDescrip[0] ;
            A570LegDedConCodYDesc = H005X2_A570LegDedConCodYDesc[0] ;
            A557LegDedFchHas = H005X2_A557LegDedFchHas[0] ;
            A767LegDedMes = H005X2_A767LegDedMes[0] ;
            A768LegDedAnio = H005X2_A768LegDedAnio[0] ;
            A556LegDedFchDes = H005X2_A556LegDedFchDes[0] ;
            A83LegDedSec = H005X2_A83LegDedSec[0] ;
            A6LegNumero = H005X2_A6LegNumero[0] ;
            A1EmpCod = H005X2_A1EmpCod[0] ;
            A3CliCod = H005X2_A3CliCod[0] ;
            A84LegDedConCodigo = H005X2_A84LegDedConCodigo[0] ;
            A559LegDedConDescrip = H005X2_A559LegDedConDescrip[0] ;
            A559LegDedConDescrip = H005X2_A559LegDedConDescrip[0] ;
            e175X2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(23) ;
         wb5X0( ) ;
      }
      bGXsfl_23_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes5X2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV51Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV51Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDATETIME", localUtil.ttoc( AV44datetime, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDATETIME", getSecureSignedToken( sPrefix, localUtil.format( AV44datetime, "99/99/99 99:99")));
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
                                           A570LegDedConCodYDesc ,
                                           AV30TFLegDedConCodYDesc_Sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV48TFLegDedMes_Sels ,
                                           A568LegDedDescrip ,
                                           AV33TFLegDedDescrip_Sels ,
                                           Short.valueOf(AV45TFLegDedAnio) ,
                                           Short.valueOf(AV46TFLegDedAnio_To) ,
                                           Integer.valueOf(AV48TFLegDedMes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegDedConCodYDesc_Sels.size()) ,
                                           AV29TFLegDedConCodYDesc ,
                                           Integer.valueOf(AV33TFLegDedDescrip_Sels.size()) ,
                                           AV32TFLegDedDescrip ,
                                           AV39TFLegDedImporte ,
                                           AV40TFLegDedImporte_To ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Short.valueOf(AV22OrderedBy) ,
                                           Boolean.valueOf(AV23OrderedDsc) ,
                                           Integer.valueOf(AV5CliCod) ,
                                           Short.valueOf(AV13EmpCod) ,
                                           Integer.valueOf(AV21LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV29TFLegDedConCodYDesc = GXutil.concat( GXutil.rtrim( AV29TFLegDedConCodYDesc), "%", "") ;
      lV32TFLegDedDescrip = GXutil.concat( GXutil.rtrim( AV32TFLegDedDescrip), "%", "") ;
      /* Using cursor H005X3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV21LegNumero), Integer.valueOf(AV30TFLegDedConCodYDesc_Sels.size()), Short.valueOf(AV45TFLegDedAnio), Short.valueOf(AV46TFLegDedAnio_To), lV29TFLegDedConCodYDesc, lV32TFLegDedDescrip, AV39TFLegDedImporte, AV40TFLegDedImporte_To});
      GRID_nRecordCount = H005X3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5CliCod, AV13EmpCod, AV21LegNumero, AV51Pgmname, AV22OrderedBy, AV23OrderedDsc, AV45TFLegDedAnio, AV46TFLegDedAnio_To, AV48TFLegDedMes_Sels, AV29TFLegDedConCodYDesc, AV30TFLegDedConCodYDesc_Sels, AV32TFLegDedDescrip, AV33TFLegDedDescrip_Sels, AV39TFLegDedImporte, AV40TFLegDedImporte_To, AV44datetime, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5CliCod, AV13EmpCod, AV21LegNumero, AV51Pgmname, AV22OrderedBy, AV23OrderedDsc, AV45TFLegDedAnio, AV46TFLegDedAnio_To, AV48TFLegDedMes_Sels, AV29TFLegDedConCodYDesc, AV30TFLegDedConCodYDesc_Sels, AV32TFLegDedDescrip, AV33TFLegDedDescrip_Sels, AV39TFLegDedImporte, AV40TFLegDedImporte_To, AV44datetime, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5CliCod, AV13EmpCod, AV21LegNumero, AV51Pgmname, AV22OrderedBy, AV23OrderedDsc, AV45TFLegDedAnio, AV46TFLegDedAnio_To, AV48TFLegDedMes_Sels, AV29TFLegDedConCodYDesc, AV30TFLegDedConCodYDesc_Sels, AV32TFLegDedDescrip, AV33TFLegDedDescrip_Sels, AV39TFLegDedImporte, AV40TFLegDedImporte_To, AV44datetime, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5CliCod, AV13EmpCod, AV21LegNumero, AV51Pgmname, AV22OrderedBy, AV23OrderedDsc, AV45TFLegDedAnio, AV46TFLegDedAnio_To, AV48TFLegDedMes_Sels, AV29TFLegDedConCodYDesc, AV30TFLegDedConCodYDesc_Sels, AV32TFLegDedDescrip, AV33TFLegDedDescrip_Sels, AV39TFLegDedImporte, AV40TFLegDedImporte_To, AV44datetime, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV5CliCod, AV13EmpCod, AV21LegNumero, AV51Pgmname, AV22OrderedBy, AV23OrderedDsc, AV45TFLegDedAnio, AV46TFLegDedAnio_To, AV48TFLegDedMes_Sels, AV29TFLegDedConCodYDesc, AV30TFLegDedConCodYDesc_Sels, AV32TFLegDedDescrip, AV33TFLegDedDescrip_Sels, AV39TFLegDedImporte, AV40TFLegDedImporte_To, AV44datetime, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV51Pgmname = "CompDeduccionesSolapa" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup5X0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e155X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV12DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_23 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_23"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV15GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV16GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV14GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV5CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV5CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV13EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV13EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV21LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV21LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistfixedvalues") ;
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
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Filteredtextto_get") ;
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
      e155X2 ();
      if (returnInSub) return;
   }

   public void e155X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      compdeduccionessolapa_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
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
      if ( AV22OrderedBy < 1 )
      {
         AV22OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV12DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV12DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e165X2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      compdeduccionessolapa_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV43WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV43WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      AV15GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15GridCurrentPage), 10, 0));
      AV16GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16GridPageCount), 10, 0));
      GXt_char6 = AV14GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV51Pgmname, GXv_char7) ;
      compdeduccionessolapa_impl.this.GXt_char6 = GXv_char7[0] ;
      AV14GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14GridAppliedFilters", AV14GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e115X2( )
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
         AV25PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV25PageToGo) ;
      }
   }

   public void e125X2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e135X2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV22OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22OrderedBy), 4, 0));
         AV23OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23OrderedDsc", AV23OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedAnio") == 0 )
         {
            AV45TFLegDedAnio = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFLegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFLegDedAnio), 4, 0));
            AV46TFLegDedAnio_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TFLegDedAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFLegDedAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedMes") == 0 )
         {
            AV47TFLegDedMes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TFLegDedMes_SelsJson", AV47TFLegDedMes_SelsJson);
            AV48TFLegDedMes_Sels.fromJSonString(GXutil.strReplace( AV47TFLegDedMes_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedConCodYDesc") == 0 )
         {
            AV29TFLegDedConCodYDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLegDedConCodYDesc", AV29TFLegDedConCodYDesc);
            AV31TFLegDedConCodYDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLegDedConCodYDesc_SelsJson", AV31TFLegDedConCodYDesc_SelsJson);
            AV30TFLegDedConCodYDesc_Sels.fromJSonString(AV31TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedDescrip") == 0 )
         {
            AV32TFLegDedDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLegDedDescrip", AV32TFLegDedDescrip);
            AV34TFLegDedDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFLegDedDescrip_SelsJson", AV34TFLegDedDescrip_SelsJson);
            AV33TFLegDedDescrip_Sels.fromJSonString(AV34TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedImporte") == 0 )
         {
            AV39TFLegDedImporte = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLegDedImporte", GXutil.ltrimstr( AV39TFLegDedImporte, 14, 2));
            AV40TFLegDedImporte_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLegDedImporte_To", GXutil.ltrimstr( AV40TFLegDedImporte_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV48TFLegDedMes_Sels", AV48TFLegDedMes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV30TFLegDedConCodYDesc_Sels", AV30TFLegDedConCodYDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV33TFLegDedDescrip_Sels", AV33TFLegDedDescrip_Sels);
   }

   private void e175X2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(23) ;
      }
      sendrow_232( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_23_Refreshing )
      {
         httpContext.doAjaxLoad(23, GridRow);
      }
   }

   public void e145X2( )
   {
      /* 'DoImportarSiradig' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.subirarchivosiradig", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "INS", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV5CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV13EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateTimeParm(AV44datetime)),GXutil.URLEncode(GXutil.ltrimstr(AV21LegNumero,8,0))}, new String[] {"TrnMode","CliCod","EmpCod","ArchSiradigFec","LegNumero"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV22OrderedBy, 4, 0))+":"+(AV23OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean8 = AV28TempBoolean ;
      GXv_boolean9[0] = GXt_boolean8 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SubirArchivoSiradig", GXv_boolean9) ;
      compdeduccionessolapa_impl.this.GXt_boolean8 = GXv_boolean9[0] ;
      AV28TempBoolean = GXt_boolean8 ;
      if ( ! ( AV28TempBoolean && ( false ) ) )
      {
         bttBtnimportarsiradig_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnimportarsiradig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportarsiradig_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue(AV51Pgmname+"GridState"), "") == 0 )
      {
         AV17GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV51Pgmname+"GridState"), null, null);
      }
      else
      {
         AV17GridState.fromxml(AV27Session.getValue(AV51Pgmname+"GridState"), null, null);
      }
      AV22OrderedBy = AV17GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22OrderedBy), 4, 0));
      AV23OrderedDsc = AV17GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23OrderedDsc", AV23OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV18GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDANIO") == 0 )
         {
            AV45TFLegDedAnio = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TFLegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFLegDedAnio), 4, 0));
            AV46TFLegDedAnio_To = (short)(GXutil.lval( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TFLegDedAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFLegDedAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDMES_SEL") == 0 )
         {
            AV47TFLegDedMes_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TFLegDedMes_SelsJson", AV47TFLegDedMes_SelsJson);
            AV48TFLegDedMes_Sels.fromJSonString(AV47TFLegDedMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC") == 0 )
         {
            AV29TFLegDedConCodYDesc = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29TFLegDedConCodYDesc", AV29TFLegDedConCodYDesc);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC_SEL") == 0 )
         {
            AV31TFLegDedConCodYDesc_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFLegDedConCodYDesc_SelsJson", AV31TFLegDedConCodYDesc_SelsJson);
            AV30TFLegDedConCodYDesc_Sels.fromJSonString(AV31TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP") == 0 )
         {
            AV32TFLegDedDescrip = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFLegDedDescrip", AV32TFLegDedDescrip);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP_SEL") == 0 )
         {
            AV34TFLegDedDescrip_SelsJson = AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFLegDedDescrip_SelsJson", AV34TFLegDedDescrip_SelsJson);
            AV33TFLegDedDescrip_Sels.fromJSonString(AV34TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDIMPORTE") == 0 )
         {
            AV39TFLegDedImporte = CommonUtil.decimalVal( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFLegDedImporte", GXutil.ltrimstr( AV39TFLegDedImporte, 14, 2));
            AV40TFLegDedImporte_To = CommonUtil.decimalVal( AV18GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40TFLegDedImporte_To", GXutil.ltrimstr( AV40TFLegDedImporte_To, 14, 2));
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFLegDedConCodYDesc_Sels.size()==0), AV31TFLegDedConCodYDesc_SelsJson, GXv_char7) ;
      compdeduccionessolapa_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV33TFLegDedDescrip_Sels.size()==0), AV34TFLegDedDescrip_SelsJson, GXv_char11) ;
      compdeduccionessolapa_impl.this.GXt_char10 = GXv_char11[0] ;
      Ddo_grid_Selectedvalue_set = "|"+((AV48TFLegDedMes_Sels.size()==0) ? "" : AV47TFLegDedMes_SelsJson)+"|"+GXt_char6+"|"+GXt_char10+"|" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFLegDedConCodYDesc)==0), AV29TFLegDedConCodYDesc, GXv_char11) ;
      compdeduccionessolapa_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV32TFLegDedDescrip)==0), AV32TFLegDedDescrip, GXv_char7) ;
      compdeduccionessolapa_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV45TFLegDedAnio) ? "" : GXutil.str( AV45TFLegDedAnio, 4, 0))+"||"+GXt_char10+"|"+GXt_char6+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLegDedImporte)==0) ? "" : GXutil.str( AV39TFLegDedImporte, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV46TFLegDedAnio_To) ? "" : GXutil.str( AV46TFLegDedAnio_To, 4, 0))+"||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLegDedImporte_To)==0) ? "" : GXutil.str( AV40TFLegDedImporte_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV17GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV17GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV17GridState.fromxml(AV27Session.getValue(AV51Pgmname+"GridState"), null, null);
      AV17GridState.setgxTv_SdtWWPGridState_Orderedby( AV22OrderedBy );
      AV17GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV23OrderedDsc );
      AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFLEGDEDANIO", httpContext.getMessage( "Año", ""), !((0==AV45TFLegDedAnio)&&(0==AV46TFLegDedAnio_To)), (short)(0), GXutil.trim( GXutil.str( AV45TFLegDedAnio, 4, 0)), GXutil.trim( GXutil.str( AV46TFLegDedAnio_To, 4, 0))) ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFLEGDEDMES_SEL", httpContext.getMessage( "Mes", ""), !(AV48TFLegDedMes_Sels.size()==0), (short)(0), AV48TFLegDedMes_Sels.toJSonString(false), "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFLEGDEDCONCODYDESC", httpContext.getMessage( "Concepto", ""), !(GXutil.strcmp("", AV29TFLegDedConCodYDesc)==0), (short)(0), AV29TFLegDedConCodYDesc, "", !(AV30TFLegDedConCodYDesc_Sels.size()==0), AV30TFLegDedConCodYDesc_Sels.toJSonString(false), "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFLEGDEDDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV32TFLegDedDescrip)==0), (short)(0), AV32TFLegDedDescrip, "", !(AV33TFLegDedDescrip_Sels.size()==0), AV33TFLegDedDescrip_Sels.toJSonString(false), "") ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV17GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFLEGDEDIMPORTE", httpContext.getMessage( "Importe", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLegDedImporte)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLegDedImporte_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV39TFLegDedImporte, 14, 2)), GXutil.trim( GXutil.str( AV40TFLegDedImporte_To, 14, 2))) ;
      AV17GridState = GXv_SdtWWPGridState12[0] ;
      if ( ! (0==AV5CliCod) )
      {
         AV18GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV5CliCod, 6, 0) );
         AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV18GridStateFilterValue, 0);
      }
      if ( ! (0==AV13EmpCod) )
      {
         AV18GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV13EmpCod, 4, 0) );
         AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV18GridStateFilterValue, 0);
      }
      if ( ! (0==AV21LegNumero) )
      {
         AV18GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LEGNUMERO" );
         AV18GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV21LegNumero, 8, 0) );
         AV17GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV18GridStateFilterValue, 0);
      }
      AV17GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV51Pgmname+"GridState", AV17GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV41TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV41TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV51Pgmname );
      AV41TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV41TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV19HTTPRequest.getScriptName()+"?"+AV19HTTPRequest.getQuerystring() );
      AV41TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "deduccionesSolapa" );
      AV42TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV42TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV42TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV5CliCod, 6, 0) );
      AV41TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV42TrnContextAtt, 0);
      AV42TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV42TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV42TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV13EmpCod, 4, 0) );
      AV41TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV42TrnContextAtt, 0);
      AV42TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV42TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LegNumero" );
      AV42TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV21LegNumero, 8, 0) );
      AV41TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV42TrnContextAtt, 0);
      AV27Session.setValue("TrnContext", AV41TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void wb_table1_6_5X2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellPaddingBottom'>") ;
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportarsiradig_Internalname, "gx.evt.setGridEvt("+GXutil.str( 23, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar archivo SIRADIG", ""), bttBtnimportarsiradig_Jsonclick, 5, httpContext.getMessage( "Importar archivo SIRADIG", ""), "", StyleString, ClassString, bttBtnimportarsiradig_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOIMPORTARSIRADIG\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CompDeduccionesSolapa.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid GridNoBorderCell HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol23( ) ;
      }
      if ( wbEnd == 23 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_23 = (int)(nGXsfl_23_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV15GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV16GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV14GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_6_5X2e( true) ;
      }
      else
      {
         wb_table1_6_5X2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      AV13EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
      AV21LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21LegNumero), 8, 0));
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
      pa5X2( ) ;
      ws5X2( ) ;
      we5X2( ) ;
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
      sCtrlAV5CliCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV13EmpCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV21LegNumero = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa5X2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "compdeduccionessolapa", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa5X2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV5CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
         AV13EmpCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
         AV21LegNumero = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21LegNumero), 8, 0));
      }
      wcpOAV5CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV5CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV13EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV13EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV21LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV21LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( AV5CliCod != wcpOAV5CliCod ) || ( AV13EmpCod != wcpOAV13EmpCod ) || ( AV21LegNumero != wcpOAV21LegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOAV5CliCod = AV5CliCod ;
      wcpOAV13EmpCod = AV13EmpCod ;
      wcpOAV21LegNumero = AV21LegNumero ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV5CliCod = httpContext.cgiGet( sPrefix+"AV5CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV5CliCod) > 0 )
      {
         AV5CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV5CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      }
      else
      {
         AV5CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV5CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV13EmpCod = httpContext.cgiGet( sPrefix+"AV13EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV13EmpCod) > 0 )
      {
         AV13EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV13EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EmpCod), 4, 0));
      }
      else
      {
         AV13EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV13EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV21LegNumero = httpContext.cgiGet( sPrefix+"AV21LegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV21LegNumero) > 0 )
      {
         AV21LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV21LegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21LegNumero), 8, 0));
      }
      else
      {
         AV21LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV21LegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa5X2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws5X2( ) ;
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
      ws5X2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV5CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV5CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV5CliCod_CTRL", GXutil.rtrim( sCtrlAV5CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV13EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV13EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV13EmpCod_CTRL", GXutil.rtrim( sCtrlAV13EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV21LegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV21LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV21LegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV21LegNumero_CTRL", GXutil.rtrim( sCtrlAV21LegNumero));
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
      we5X2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019452126", true, true);
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
      httpContext.AddJavascriptSource("compdeduccionessolapa.js", "?2024122019452127", false, true);
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

   public void subsflControlProps_232( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_23_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_23_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_23_idx ;
      edtLegDedSec_Internalname = sPrefix+"LEGDEDSEC_"+sGXsfl_23_idx ;
      edtLegDedFchDes_Internalname = sPrefix+"LEGDEDFCHDES_"+sGXsfl_23_idx ;
      edtLegDedAnio_Internalname = sPrefix+"LEGDEDANIO_"+sGXsfl_23_idx ;
      cmbLegDedMes.setInternalname( sPrefix+"LEGDEDMES_"+sGXsfl_23_idx );
      edtLegDedFchHas_Internalname = sPrefix+"LEGDEDFCHHAS_"+sGXsfl_23_idx ;
      edtLegDedConCodigo_Internalname = sPrefix+"LEGDEDCONCODIGO_"+sGXsfl_23_idx ;
      edtLegDedConCodYDesc_Internalname = sPrefix+"LEGDEDCONCODYDESC_"+sGXsfl_23_idx ;
      edtLegDedDescrip_Internalname = sPrefix+"LEGDEDDESCRIP_"+sGXsfl_23_idx ;
      edtLegDedImporte_Internalname = sPrefix+"LEGDEDIMPORTE_"+sGXsfl_23_idx ;
   }

   public void subsflControlProps_fel_232( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_23_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_23_fel_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_23_fel_idx ;
      edtLegDedSec_Internalname = sPrefix+"LEGDEDSEC_"+sGXsfl_23_fel_idx ;
      edtLegDedFchDes_Internalname = sPrefix+"LEGDEDFCHDES_"+sGXsfl_23_fel_idx ;
      edtLegDedAnio_Internalname = sPrefix+"LEGDEDANIO_"+sGXsfl_23_fel_idx ;
      cmbLegDedMes.setInternalname( sPrefix+"LEGDEDMES_"+sGXsfl_23_fel_idx );
      edtLegDedFchHas_Internalname = sPrefix+"LEGDEDFCHHAS_"+sGXsfl_23_fel_idx ;
      edtLegDedConCodigo_Internalname = sPrefix+"LEGDEDCONCODIGO_"+sGXsfl_23_fel_idx ;
      edtLegDedConCodYDesc_Internalname = sPrefix+"LEGDEDCONCODYDESC_"+sGXsfl_23_fel_idx ;
      edtLegDedDescrip_Internalname = sPrefix+"LEGDEDDESCRIP_"+sGXsfl_23_fel_idx ;
      edtLegDedImporte_Internalname = sPrefix+"LEGDEDIMPORTE_"+sGXsfl_23_fel_idx ;
   }

   public void sendrow_232( )
   {
      subsflControlProps_232( ) ;
      wb5X0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_23_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_23_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_23_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedSec_Internalname,GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A83LegDedSec), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedFchDes_Internalname,localUtil.format(A556LegDedFchDes, "99/99/99"),localUtil.format( A556LegDedFchDes, "99/99/99"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedFchDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedAnio_Internalname,GXutil.ltrim( localUtil.ntoc( A768LegDedAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A768LegDedAnio), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedAnio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Anio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbLegDedMes.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGDEDMES_" + sGXsfl_23_idx ;
            cmbLegDedMes.setName( GXCCtl );
            cmbLegDedMes.setWebtags( "" );
            cmbLegDedMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
            cmbLegDedMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
            cmbLegDedMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
            cmbLegDedMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
            cmbLegDedMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
            cmbLegDedMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
            cmbLegDedMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
            cmbLegDedMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
            cmbLegDedMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
            cmbLegDedMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
            cmbLegDedMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
            cmbLegDedMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
            if ( cmbLegDedMes.getItemCount() > 0 )
            {
               A767LegDedMes = (byte)(GXutil.lval( cmbLegDedMes.getValidValue(GXutil.trim( GXutil.str( A767LegDedMes, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegDedMes,cmbLegDedMes.getInternalname(),GXutil.trim( GXutil.str( A767LegDedMes, 2, 0)),Integer.valueOf(1),cmbLegDedMes.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegDedMes.setValue( GXutil.trim( GXutil.str( A767LegDedMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegDedMes.getInternalname(), "Values", cmbLegDedMes.ToJavascriptSource(), !bGXsfl_23_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedFchHas_Internalname,localUtil.format(A557LegDedFchHas, "99/99/99"),localUtil.format( A557LegDedFchHas, "99/99/99"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedFchHas_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedConCodigo_Internalname,GXutil.rtrim( A84LegDedConCodigo),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedConCodYDesc_Internalname,A570LegDedConCodYDesc,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedConCodYDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedDescrip_Internalname,A568LegDedDescrip,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A560LegDedImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A560LegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDedImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(23),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes5X2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_23_idx = ((subGrid_Islastpage==1)&&(nGXsfl_23_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_23_idx+1) ;
         sGXsfl_23_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_23_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_232( ) ;
      }
      /* End function sendrow_232 */
   }

   public void startgridcontrol23( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"23\">") ;
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
         httpContext.writeValue( httpContext.getMessage( "Ded Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Mes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Hasta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Deducción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A556LegDedFchDes, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A768LegDedAnio, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A767LegDedMes, (byte)(2), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A557LegDedFchHas, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A84LegDedConCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A570LegDedConCodYDesc);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A568LegDedDescrip);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A560LegDedImporte, (byte)(17), (byte)(2), ".", "")));
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
      bttBtnimportarsiradig_Internalname = sPrefix+"BTNIMPORTARSIRADIG" ;
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtLegDedSec_Internalname = sPrefix+"LEGDEDSEC" ;
      edtLegDedFchDes_Internalname = sPrefix+"LEGDEDFCHDES" ;
      edtLegDedAnio_Internalname = sPrefix+"LEGDEDANIO" ;
      cmbLegDedMes.setInternalname( sPrefix+"LEGDEDMES" );
      edtLegDedFchHas_Internalname = sPrefix+"LEGDEDFCHHAS" ;
      edtLegDedConCodigo_Internalname = sPrefix+"LEGDEDCONCODIGO" ;
      edtLegDedConCodYDesc_Internalname = sPrefix+"LEGDEDCONCODYDESC" ;
      edtLegDedDescrip_Internalname = sPrefix+"LEGDEDDESCRIP" ;
      edtLegDedImporte_Internalname = sPrefix+"LEGDEDIMPORTE" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
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
      edtLegDedImporte_Jsonclick = "" ;
      edtLegDedDescrip_Jsonclick = "" ;
      edtLegDedConCodYDesc_Jsonclick = "" ;
      edtLegDedConCodigo_Jsonclick = "" ;
      edtLegDedFchHas_Jsonclick = "" ;
      cmbLegDedMes.setJsonclick( "" );
      edtLegDedAnio_Jsonclick = "" ;
      edtLegDedFchDes_Jsonclick = "" ;
      edtLegDedSec_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      bttBtnimportarsiradig_Visible = 1 ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0||||-14.2" ;
      Ddo_grid_Datalistproc = "CompDeduccionesSolapaGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|1:Enero,2:Febrero,3:Marzo,4:Abril,5:Mayo,6:Junio,7:Julio,8:Agosto,9:Septiembre,10:Octubre,11:Noviembre,12:Diciembre|||" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|" ;
      Ddo_grid_Datalisttype = "|FixedValues|Dynamic|Dynamic|" ;
      Ddo_grid_Includedatalist = "|T|T|T|" ;
      Ddo_grid_Filterisrange = "T||||T" ;
      Ddo_grid_Filtertype = "Numeric||Character|Character|Numeric" ;
      Ddo_grid_Includefilter = "T||T|T|T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5" ;
      Ddo_grid_Columnids = "5:LegDedAnio|6:LegDedMes|9:LegDedConCodYDesc|10:LegDedDescrip|11:LegDedImporte" ;
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
      GXCCtl = "LEGDEDMES_" + sGXsfl_23_idx ;
      cmbLegDedMes.setName( GXCCtl );
      cmbLegDedMes.setWebtags( "" );
      cmbLegDedMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbLegDedMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbLegDedMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbLegDedMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbLegDedMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbLegDedMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbLegDedMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbLegDedMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbLegDedMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbLegDedMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbLegDedMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbLegDedMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbLegDedMes.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV23OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV46TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV48TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV29TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV30TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV32TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV33TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV39TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV44datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV15GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV16GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV14GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{ctrl:'BTNIMPORTARSIRADIG',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e115X2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV23OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV46TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV48TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV29TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV30TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV32TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV33TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV39TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV44datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e125X2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV23OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV46TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV48TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV29TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV30TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV32TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV33TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV39TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV44datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e135X2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV21LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV51Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV23OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV46TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV48TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV29TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV30TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV32TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV33TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV39TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV44datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV22OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV23OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV46TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV47TFLegDedMes_SelsJson',fld:'vTFLEGDEDMES_SELSJSON',pic:''},{av:'AV48TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV29TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV31TFLegDedConCodYDesc_SelsJson',fld:'vTFLEGDEDCONCODYDESC_SELSJSON',pic:''},{av:'AV30TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV32TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV34TFLegDedDescrip_SelsJson',fld:'vTFLEGDEDDESCRIP_SELSJSON',pic:''},{av:'AV33TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV39TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV40TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e175X2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("'DOIMPORTARSIRADIG'","{handler:'e145X2',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV13EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV44datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'AV21LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOIMPORTARSIRADIG'",",oparms:[{av:'AV21LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDCONCODIGO","{handler:'valid_Legdedconcodigo',iparms:[]");
      setEventMetadata("VALID_LEGDEDCONCODIGO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Legdedimporte',iparms:[]");
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
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV51Pgmname = "" ;
      AV48TFLegDedMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV29TFLegDedConCodYDesc = "" ;
      AV30TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32TFLegDedDescrip = "" ;
      AV33TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFLegDedImporte = DecimalUtil.ZERO ;
      AV40TFLegDedImporte_To = DecimalUtil.ZERO ;
      AV44datetime = GXutil.resetTime( GXutil.nullDate() );
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV14GridAppliedFilters = "" ;
      AV12DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      A84LegDedConCodigo = "" ;
      A570LegDedConCodYDesc = "" ;
      A568LegDedDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV29TFLegDedConCodYDesc = "" ;
      lV32TFLegDedDescrip = "" ;
      A559LegDedConDescrip = "" ;
      H005X2_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H005X2_A568LegDedDescrip = new String[] {""} ;
      H005X2_A570LegDedConCodYDesc = new String[] {""} ;
      H005X2_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      H005X2_A767LegDedMes = new byte[1] ;
      H005X2_A768LegDedAnio = new short[1] ;
      H005X2_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      H005X2_A83LegDedSec = new int[1] ;
      H005X2_A6LegNumero = new int[1] ;
      H005X2_A1EmpCod = new short[1] ;
      H005X2_A3CliCod = new int[1] ;
      H005X2_A84LegDedConCodigo = new String[] {""} ;
      H005X2_A559LegDedConDescrip = new String[] {""} ;
      H005X3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV43WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV47TFLegDedMes_SelsJson = "" ;
      AV31TFLegDedConCodYDesc_SelsJson = "" ;
      AV34TFLegDedDescrip_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_boolean9 = new boolean[1] ;
      AV27Session = httpContext.getWebSession();
      AV17GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV18GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState12 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV41TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV19HTTPRequest = httpContext.getHttpRequest();
      AV42TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnimportarsiradig_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV5CliCod = "" ;
      sCtrlAV13EmpCod = "" ;
      sCtrlAV21LegNumero = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.compdeduccionessolapa__default(),
         new Object[] {
             new Object[] {
            H005X2_A560LegDedImporte, H005X2_A568LegDedDescrip, H005X2_A570LegDedConCodYDesc, H005X2_A557LegDedFchHas, H005X2_A767LegDedMes, H005X2_A768LegDedAnio, H005X2_A556LegDedFchDes, H005X2_A83LegDedSec, H005X2_A6LegNumero, H005X2_A1EmpCod,
            H005X2_A3CliCod, H005X2_A84LegDedConCodigo, H005X2_A559LegDedConDescrip
            }
            , new Object[] {
            H005X3_AGRID_nRecordCount
            }
         }
      );
      AV51Pgmname = "CompDeduccionesSolapa" ;
      /* GeneXus formulas. */
      AV51Pgmname = "CompDeduccionesSolapa" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A767LegDedMes ;
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
   private short wcpOAV13EmpCod ;
   private short AV13EmpCod ;
   private short AV22OrderedBy ;
   private short AV45TFLegDedAnio ;
   private short AV46TFLegDedAnio_To ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A768LegDedAnio ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV5CliCod ;
   private int wcpOAV21LegNumero ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_23 ;
   private int AV5CliCod ;
   private int AV21LegNumero ;
   private int nGXsfl_23_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV48TFLegDedMes_Sels_size ;
   private int AV30TFLegDedConCodYDesc_Sels_size ;
   private int AV33TFLegDedDescrip_Sels_size ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV25PageToGo ;
   private int bttBtnimportarsiradig_Visible ;
   private int AV52GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV15GridCurrentPage ;
   private long AV16GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV39TFLegDedImporte ;
   private java.math.BigDecimal AV40TFLegDedImporte_To ;
   private java.math.BigDecimal A560LegDedImporte ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_23_idx="0001" ;
   private String AV51Pgmname ;
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
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Format ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
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
   private String edtLegDedSec_Internalname ;
   private String edtLegDedFchDes_Internalname ;
   private String edtLegDedAnio_Internalname ;
   private String edtLegDedFchHas_Internalname ;
   private String A84LegDedConCodigo ;
   private String edtLegDedConCodigo_Internalname ;
   private String edtLegDedConCodYDesc_Internalname ;
   private String edtLegDedDescrip_Internalname ;
   private String edtLegDedImporte_Internalname ;
   private String scmdbuf ;
   private String Gridpaginationbar_Internalname ;
   private String bttBtnimportarsiradig_Internalname ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblUnnamedtable1_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnimportarsiradig_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sCtrlAV5CliCod ;
   private String sCtrlAV13EmpCod ;
   private String sCtrlAV21LegNumero ;
   private String sGXsfl_23_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegDedSec_Jsonclick ;
   private String edtLegDedFchDes_Jsonclick ;
   private String edtLegDedAnio_Jsonclick ;
   private String GXCCtl ;
   private String edtLegDedFchHas_Jsonclick ;
   private String edtLegDedConCodigo_Jsonclick ;
   private String edtLegDedConCodYDesc_Jsonclick ;
   private String edtLegDedDescrip_Jsonclick ;
   private String edtLegDedImporte_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV44datetime ;
   private java.util.Date A556LegDedFchDes ;
   private java.util.Date A557LegDedFchHas ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV23OrderedDsc ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_23_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV28TempBoolean ;
   private boolean GXt_boolean8 ;
   private boolean GXv_boolean9[] ;
   private String AV47TFLegDedMes_SelsJson ;
   private String AV31TFLegDedConCodYDesc_SelsJson ;
   private String AV34TFLegDedDescrip_SelsJson ;
   private String AV29TFLegDedConCodYDesc ;
   private String AV32TFLegDedDescrip ;
   private String AV14GridAppliedFilters ;
   private String A570LegDedConCodYDesc ;
   private String A568LegDedDescrip ;
   private String lV29TFLegDedConCodYDesc ;
   private String lV32TFLegDedDescrip ;
   private String A559LegDedConDescrip ;
   private GXSimpleCollection<Byte> AV48TFLegDedMes_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV19HTTPRequest ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private HTMLChoice cmbLegDedMes ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H005X2_A560LegDedImporte ;
   private String[] H005X2_A568LegDedDescrip ;
   private String[] H005X2_A570LegDedConCodYDesc ;
   private java.util.Date[] H005X2_A557LegDedFchHas ;
   private byte[] H005X2_A767LegDedMes ;
   private short[] H005X2_A768LegDedAnio ;
   private java.util.Date[] H005X2_A556LegDedFchDes ;
   private int[] H005X2_A83LegDedSec ;
   private int[] H005X2_A6LegNumero ;
   private short[] H005X2_A1EmpCod ;
   private int[] H005X2_A3CliCod ;
   private String[] H005X2_A84LegDedConCodigo ;
   private String[] H005X2_A559LegDedConDescrip ;
   private long[] H005X3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV30TFLegDedConCodYDesc_Sels ;
   private GXSimpleCollection<String> AV33TFLegDedDescrip_Sels ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV12DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV17GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState12[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV18GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV41TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV42TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV43WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
}

final  class compdeduccionessolapa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H005X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV30TFLegDedConCodYDesc_Sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV48TFLegDedMes_Sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV33TFLegDedDescrip_Sels ,
                                          short AV45TFLegDedAnio ,
                                          short AV46TFLegDedAnio_To ,
                                          int AV48TFLegDedMes_Sels_size ,
                                          int AV30TFLegDedConCodYDesc_Sels_size ,
                                          String AV29TFLegDedConCodYDesc ,
                                          int AV33TFLegDedDescrip_Sels_size ,
                                          String AV32TFLegDedDescrip ,
                                          java.math.BigDecimal AV39TFLegDedImporte ,
                                          java.math.BigDecimal AV40TFLegDedImporte_To ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          short AV22OrderedBy ,
                                          boolean AV23OrderedDsc ,
                                          int AV5CliCod ,
                                          short AV13EmpCod ,
                                          int AV21LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[13];
      Object[] GXv_Object14 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) AS LegDedConCodYDesc, T1.LegDedFchHas, T1.LegDedMes," ;
      sSelectString += " T1.LegDedAnio, T1.LegDedFchDes, T1.LegDedSec, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedConCodigo AS LegDedConCodigo, T2.ConDescrip AS LegDedConDescrip" ;
      sFromString = " FROM (legajo_deducciones T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.LegDedConCodigo)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV30TFLegDedConCodYDesc_Sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) IN (", ")")+"))");
      if ( ! (0==AV45TFLegDedAnio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( ! (0==AV46TFLegDedAnio_To) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( AV48TFLegDedMes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48TFLegDedMes_Sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV30TFLegDedConCodYDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV29TFLegDedConCodYDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( ( AV33TFLegDedDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFLegDedDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( AV33TFLegDedDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFLegDedDescrip_Sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLegDedImporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLegDedImporte_To)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      if ( ( AV22OrderedBy == 1 ) && ! AV23OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedAnio, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 1 ) && ( AV23OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LegDedAnio DESC, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ! AV23OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedMes, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ( AV23OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LegDedMes DESC, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ! AV23OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, LegDedConCodYDesc, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ( AV23OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, LegDedConCodYDesc DESC, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ! AV23OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedDescrip, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ( AV23OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LegDedDescrip DESC, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ! AV23OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedImporte, T1.LegDedSec" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ( AV23OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegNumero DESC, T1.LegDedImporte DESC, T1.LegDedSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_H005X3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV30TFLegDedConCodYDesc_Sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV48TFLegDedMes_Sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV33TFLegDedDescrip_Sels ,
                                          short AV45TFLegDedAnio ,
                                          short AV46TFLegDedAnio_To ,
                                          int AV48TFLegDedMes_Sels_size ,
                                          int AV30TFLegDedConCodYDesc_Sels_size ,
                                          String AV29TFLegDedConCodYDesc ,
                                          int AV33TFLegDedDescrip_Sels_size ,
                                          String AV32TFLegDedDescrip ,
                                          java.math.BigDecimal AV39TFLegDedImporte ,
                                          java.math.BigDecimal AV40TFLegDedImporte_To ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          short AV22OrderedBy ,
                                          boolean AV23OrderedDsc ,
                                          int AV5CliCod ,
                                          short AV13EmpCod ,
                                          int AV21LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[10];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (legajo_deducciones T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV30TFLegDedConCodYDesc_Sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip)) IN (", ")")+"))");
      if ( ! (0==AV45TFLegDedAnio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int16[4] = (byte)(1) ;
      }
      if ( ! (0==AV46TFLegDedAnio_To) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int16[5] = (byte)(1) ;
      }
      if ( AV48TFLegDedMes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48TFLegDedMes_Sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV30TFLegDedConCodYDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV29TFLegDedConCodYDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T2.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int16[6] = (byte)(1) ;
      }
      if ( ( AV33TFLegDedDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFLegDedDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int16[7] = (byte)(1) ;
      }
      if ( AV33TFLegDedDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFLegDedDescrip_Sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLegDedImporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int16[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLegDedImporte_To)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int16[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV22OrderedBy == 1 ) && ! AV23OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 1 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ! AV23OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 2 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ! AV23OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 3 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ! AV23OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 4 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ! AV23OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV22OrderedBy == 5 ) && ( AV23OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
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
                  return conditional_H005X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() );
            case 1 :
                  return conditional_H005X3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H005X3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 10);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
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
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

