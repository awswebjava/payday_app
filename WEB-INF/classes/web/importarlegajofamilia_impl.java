package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importarlegajofamilia_impl extends GXWebComponent
{
   public importarlegajofamilia_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importarlegajofamilia_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importarlegajofamilia_impl.class ));
   }

   public importarlegajofamilia_impl( int remoteHandle ,
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
               AV10MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10MigrLegNumero), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Integer.valueOf(AV10MigrLegNumero)});
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
      nRC_GXsfl_13 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_13"))) ;
      nGXsfl_13_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_13_idx"))) ;
      sGXsfl_13_idx = httpContext.GetPar( "sGXsfl_13_idx") ;
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
      AV10MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
      AV32TFiconoUpdate = httpContext.GetPar( "TFiconoUpdate") ;
      AV33TFiconoUpdateOperator = (short)(GXutil.lval( httpContext.GetPar( "TFiconoUpdateOperator"))) ;
      AV20TFMigrLegFamParen = httpContext.GetPar( "TFMigrLegFamParen") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21TFMigrLegFamParen_Sels);
      AV23TFMigrLegFamNroDoc = httpContext.GetPar( "TFMigrLegFamNroDoc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24TFMigrLegFamNroDoc_Sels);
      AV25TFMigrLegFamDedGan = CommonUtil.decimalVal( httpContext.GetPar( "TFMigrLegFamDedGan"), ".") ;
      AV26TFMigrLegFamDedGan_To = CommonUtil.decimalVal( httpContext.GetPar( "TFMigrLegFamDedGan_To"), ".") ;
      AV28TFMigrLegFamAdh = httpContext.GetPar( "TFMigrLegFamAdh") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29TFMigrLegFamAdh_Sels);
      AV48Pgmname = httpContext.GetPar( "Pgmname") ;
      AV16OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV17OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV49Importarlegajofamiliads_1_clicod = (int)(GXutil.lval( httpContext.GetPar( "Importarlegajofamiliads_1_clicod"))) ;
      AV50Importarlegajofamiliads_2_empcod = (short)(GXutil.lval( httpContext.GetPar( "Importarlegajofamiliads_2_empcod"))) ;
      AV51Importarlegajofamiliads_3_migrlegnumero = (int)(GXutil.lval( httpContext.GetPar( "Importarlegajofamiliads_3_migrlegnumero"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV32TFiconoUpdate, AV33TFiconoUpdateOperator, AV20TFMigrLegFamParen, AV21TFMigrLegFamParen_Sels, AV23TFMigrLegFamNroDoc, AV24TFMigrLegFamNroDoc_Sels, AV25TFMigrLegFamDedGan, AV26TFMigrLegFamDedGan_To, AV28TFMigrLegFamAdh, AV29TFMigrLegFamAdh_Sels, AV48Pgmname, AV16OrderedBy, AV17OrderedDsc, AV49Importarlegajofamiliads_1_clicod, AV50Importarlegajofamiliads_2_empcod, AV51Importarlegajofamiliads_3_migrlegnumero, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paM72( ) ;
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
         httpContext.writeValue( httpContext.getMessage( " importacion_legajo Familia", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importarlegajofamilia", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10MigrLegNumero,8,0))}, new String[] {"CliCod","EmpCod","MigrLegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV48Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_13", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_13, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV30DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV30DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10MigrLegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV10MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMIGRLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV10MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFICONOUPDATE", GXutil.rtrim( AV32TFiconoUpdate));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFICONOUPDATEOPERATOR", GXutil.ltrim( localUtil.ntoc( AV33TFiconoUpdateOperator, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFMIGRLEGFAMPAREN", AV20TFMigrLegFamParen);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFMIGRLEGFAMPAREN_SELS", AV21TFMigrLegFamParen_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFMIGRLEGFAMPAREN_SELS", AV21TFMigrLegFamParen_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFMIGRLEGFAMNRODOC", AV23TFMigrLegFamNroDoc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFMIGRLEGFAMNRODOC_SELS", AV24TFMigrLegFamNroDoc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFMIGRLEGFAMNRODOC_SELS", AV24TFMigrLegFamNroDoc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFMIGRLEGFAMDEDGAN", GXutil.ltrim( localUtil.ntoc( AV25TFMigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFMIGRLEGFAMDEDGAN_TO", GXutil.ltrim( localUtil.ntoc( AV26TFMigrLegFamDedGan_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFMIGRLEGFAMADH", GXutil.rtrim( AV28TFMigrLegFamAdh));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFMIGRLEGFAMADH_SELS", AV29TFMigrLegFamAdh_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFMIGRLEGFAMADH_SELS", AV29TFMigrLegFamAdh_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV48Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV48Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MIGRLEGFAMERRORES", A2084MigrLegFamErrores);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MIGRLEGFAMWARNINGS", A2085MigrLegFamWarnings);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTARLEGAJOFAMILIADS_1_CLICOD", GXutil.ltrim( localUtil.ntoc( AV49Importarlegajofamiliads_1_clicod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTARLEGAJOFAMILIADS_2_EMPCOD", GXutil.ltrim( localUtil.ntoc( AV50Importarlegajofamiliads_2_empcod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV51Importarlegajofamiliads_3_migrlegnumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Gridinternalname", GXutil.rtrim( Popover_iconoupdate_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Iteminternalname", GXutil.rtrim( Popover_iconoupdate_Iteminternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Isgriditem", GXutil.booltostr( Popover_iconoupdate_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Popoverwidth", GXutil.ltrim( localUtil.ntoc( Popover_iconoupdate_Popoverwidth, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"POPOVER_ICONOUPDATE_Visible", GXutil.booltostr( Popover_iconoupdate_Visible));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Popoversingrid", GXutil.rtrim( Grid_empowerer_Popoversingrid));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumnfixedfilter", GXutil.rtrim( Ddo_grid_Selectedcolumnfixedfilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
   }

   public void renderHtmlCloseFormM72( )
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
      return "ImportarLegajoFamilia" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " importacion_legajo Familia", "") ;
   }

   public void wbM70( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.importarlegajofamilia");
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Familiares", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ImportarLegajoFamilia.htm");
         wb_table1_10_M72( true) ;
      }
      else
      {
         wb_table1_10_M72( false) ;
      }
      return  ;
   }

   public void wb_table1_10_M72e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV30DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("PopoversInGrid", Grid_empowerer_Popoversingrid);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"W0034"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            web.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+sPrefix+"gxHTMLWrpW0034"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( bGXsfl_13_Refreshing )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
                  {
                     httpContext.ajax_rspStartCmp(sPrefix+"gxHTMLWrpW0034"+"");
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
      if ( wbEnd == 13 )
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
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
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

   public void startM72( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( " importacion_legajo Familia", ""), (short)(0)) ;
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
            strupM70( ) ;
         }
      }
   }

   public void wsM72( )
   {
      startM72( ) ;
      evtM72( ) ;
   }

   public void evtM72( )
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
                              strupM70( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupM70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11M72 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupM70( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupM70( ) ;
                           }
                           AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
                           AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
                           AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
                           AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
                           AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
                           AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
                           AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
                           AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
                           AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
                           AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
                           AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
                           AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
                           AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
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
                              strupM70( ) ;
                           }
                           nGXsfl_13_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_132( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2078MigrLegFamSec = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrLegFamSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV34iconoUpdateWithTags = httpContext.cgiGet( edtavIconoupdatewithtags_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV34iconoUpdateWithTags);
                           AV31iconoUpdate = httpContext.cgiGet( edtavIconoupdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdate_Internalname, AV31iconoUpdate);
                           A2079MigrLegFamParen = httpContext.cgiGet( edtMigrLegFamParen_Internalname) ;
                           A2086MigrLegFamDiscap = httpContext.cgiGet( edtMigrLegFamDiscap_Internalname) ;
                           A2080MigrLegFamNroDoc = httpContext.cgiGet( edtMigrLegFamNroDoc_Internalname) ;
                           A2081MigrLegFamDedGan = localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)) ;
                           A2082MigrLegFamAdh = httpContext.cgiGet( edtMigrLegFamAdh_Internalname) ;
                           A2088MigrLegFamNomApe = httpContext.cgiGet( edtMigrLegFamNomApe_Internalname) ;
                           A2089MigrLegFamFecNac = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtMigrLegFamFecNac_Internalname), 0)) ;
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
                                       e12M72 ();
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
                                       e13M72 ();
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
                                       e14M72 ();
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
                                    strupM70( ) ;
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
                     if ( nCmpId == 34 )
                     {
                        OldWwpaux_wc = httpContext.cgiGet( sPrefix+"W0034") ;
                        if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                        {
                           WebComp_Wwpaux_wc = WebUtils.getWebComponent(getClass(), "web." + OldWwpaux_wc + "_impl", remoteHandle, context);
                           WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                        }
                        if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                        {
                           WebComp_Wwpaux_wc.componentprocess(sPrefix+"W0034", "", sEvt);
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

   public void weM72( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormM72( ) ;
         }
      }
   }

   public void paM72( )
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
      subsflControlProps_132( ) ;
      while ( nGXsfl_13_idx <= nRC_GXsfl_13 )
      {
         sendrow_132( ) ;
         nGXsfl_13_idx = ((subGrid_Islastpage==1)&&(nGXsfl_13_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_13_idx+1) ;
         sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_132( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV8CliCod ,
                                 short AV9EmpCod ,
                                 int AV10MigrLegNumero ,
                                 String AV32TFiconoUpdate ,
                                 short AV33TFiconoUpdateOperator ,
                                 String AV20TFMigrLegFamParen ,
                                 GXSimpleCollection<String> AV21TFMigrLegFamParen_Sels ,
                                 String AV23TFMigrLegFamNroDoc ,
                                 GXSimpleCollection<String> AV24TFMigrLegFamNroDoc_Sels ,
                                 java.math.BigDecimal AV25TFMigrLegFamDedGan ,
                                 java.math.BigDecimal AV26TFMigrLegFamDedGan_To ,
                                 String AV28TFMigrLegFamAdh ,
                                 GXSimpleCollection<String> AV29TFMigrLegFamAdh_Sels ,
                                 String AV48Pgmname ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 int AV49Importarlegajofamiliads_1_clicod ,
                                 short AV50Importarlegajofamiliads_2_empcod ,
                                 int AV51Importarlegajofamiliads_3_migrlegnumero ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e13M72 ();
      GRID_nCurrentRecord = 0 ;
      rfM72( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_MIGRLEGNUMERO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MIGRLEGNUMERO", GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_MIGRLEGFAMSEC", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(A2078MigrLegFamSec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"MIGRLEGFAMSEC", GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), ".", "")));
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
      rfM72( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV48Pgmname = "ImportarLegajoFamilia" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_13_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_13_Refreshing);
   }

   public void rfM72( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(13) ;
      /* Execute user event: Refresh */
      e13M72 ();
      nGXsfl_13_idx = 1 ;
      sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_132( ) ;
      bGXsfl_13_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "WorkWith");
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
         subsflControlProps_132( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A2079MigrLegFamParen ,
                                              AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                              A2080MigrLegFamNroDoc ,
                                              AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                              A2082MigrLegFamAdh ,
                                              AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                              Short.valueOf(AV53Importarlegajofamiliads_5_tficonoupdateoperator) ,
                                              Integer.valueOf(AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels.size()) ,
                                              AV54Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                              Integer.valueOf(AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels.size()) ,
                                              AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                              AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                              AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                              Integer.valueOf(AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels.size()) ,
                                              AV60Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                              A2084MigrLegFamErrores ,
                                              A2085MigrLegFamWarnings ,
                                              A2081MigrLegFamDedGan ,
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              Integer.valueOf(AV49Importarlegajofamiliads_1_clicod) ,
                                              Short.valueOf(AV50Importarlegajofamiliads_2_empcod) ,
                                              Integer.valueOf(AV51Importarlegajofamiliads_3_migrlegnumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A87MigrLegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         lV54Importarlegajofamiliads_6_tfmigrlegfamparen = GXutil.concat( GXutil.rtrim( AV54Importarlegajofamiliads_6_tfmigrlegfamparen), "%", "") ;
         lV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = GXutil.concat( GXutil.rtrim( AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc), "%", "") ;
         lV60Importarlegajofamiliads_12_tfmigrlegfamadh = GXutil.padr( GXutil.rtrim( AV60Importarlegajofamiliads_12_tfmigrlegfamadh), 20, "%") ;
         /* Using cursor H00M72 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV49Importarlegajofamiliads_1_clicod), Short.valueOf(AV50Importarlegajofamiliads_2_empcod), Integer.valueOf(AV51Importarlegajofamiliads_3_migrlegnumero), lV54Importarlegajofamiliads_6_tfmigrlegfamparen, lV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc, AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan, AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to, lV60Importarlegajofamiliads_12_tfmigrlegfamadh, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_13_idx = 1 ;
         sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_132( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2085MigrLegFamWarnings = H00M72_A2085MigrLegFamWarnings[0] ;
            A2084MigrLegFamErrores = H00M72_A2084MigrLegFamErrores[0] ;
            A2089MigrLegFamFecNac = H00M72_A2089MigrLegFamFecNac[0] ;
            A2088MigrLegFamNomApe = H00M72_A2088MigrLegFamNomApe[0] ;
            A2082MigrLegFamAdh = H00M72_A2082MigrLegFamAdh[0] ;
            A2081MigrLegFamDedGan = H00M72_A2081MigrLegFamDedGan[0] ;
            A2080MigrLegFamNroDoc = H00M72_A2080MigrLegFamNroDoc[0] ;
            A2086MigrLegFamDiscap = H00M72_A2086MigrLegFamDiscap[0] ;
            A2079MigrLegFamParen = H00M72_A2079MigrLegFamParen[0] ;
            A2078MigrLegFamSec = H00M72_A2078MigrLegFamSec[0] ;
            A87MigrLegNumero = H00M72_A87MigrLegNumero[0] ;
            A1EmpCod = H00M72_A1EmpCod[0] ;
            A3CliCod = H00M72_A3CliCod[0] ;
            e14M72 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(13) ;
         wbM70( ) ;
      }
      bGXsfl_13_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesM72( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV48Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV48Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_CLICOD"+"_"+sGXsfl_13_idx, getSecureSignedToken( sPrefix+sGXsfl_13_idx, localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_EMPCOD"+"_"+sGXsfl_13_idx, getSecureSignedToken( sPrefix+sGXsfl_13_idx, localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_MIGRLEGNUMERO"+"_"+sGXsfl_13_idx, getSecureSignedToken( sPrefix+sGXsfl_13_idx, localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_MIGRLEGFAMSEC"+"_"+sGXsfl_13_idx, getSecureSignedToken( sPrefix+sGXsfl_13_idx, localUtil.format( DecimalUtil.doubleToDec(A2078MigrLegFamSec), "ZZZ9")));
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
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2079MigrLegFamParen ,
                                           AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                           A2080MigrLegFamNroDoc ,
                                           AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                           A2082MigrLegFamAdh ,
                                           AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                           Short.valueOf(AV53Importarlegajofamiliads_5_tficonoupdateoperator) ,
                                           Integer.valueOf(AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels.size()) ,
                                           AV54Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                           Integer.valueOf(AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels.size()) ,
                                           AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                           AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                           AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                           Integer.valueOf(AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels.size()) ,
                                           AV60Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                           A2084MigrLegFamErrores ,
                                           A2085MigrLegFamWarnings ,
                                           A2081MigrLegFamDedGan ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           Integer.valueOf(AV49Importarlegajofamiliads_1_clicod) ,
                                           Short.valueOf(AV50Importarlegajofamiliads_2_empcod) ,
                                           Integer.valueOf(AV51Importarlegajofamiliads_3_migrlegnumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A87MigrLegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV54Importarlegajofamiliads_6_tfmigrlegfamparen = GXutil.concat( GXutil.rtrim( AV54Importarlegajofamiliads_6_tfmigrlegfamparen), "%", "") ;
      lV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = GXutil.concat( GXutil.rtrim( AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc), "%", "") ;
      lV60Importarlegajofamiliads_12_tfmigrlegfamadh = GXutil.padr( GXutil.rtrim( AV60Importarlegajofamiliads_12_tfmigrlegfamadh), 20, "%") ;
      /* Using cursor H00M73 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV49Importarlegajofamiliads_1_clicod), Short.valueOf(AV50Importarlegajofamiliads_2_empcod), Integer.valueOf(AV51Importarlegajofamiliads_3_migrlegnumero), lV54Importarlegajofamiliads_6_tfmigrlegfamparen, lV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc, AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan, AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to, lV60Importarlegajofamiliads_12_tfmigrlegfamadh});
      GRID_nRecordCount = H00M73_AGRID_nRecordCount[0] ;
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
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV32TFiconoUpdate, AV33TFiconoUpdateOperator, AV20TFMigrLegFamParen, AV21TFMigrLegFamParen_Sels, AV23TFMigrLegFamNroDoc, AV24TFMigrLegFamNroDoc_Sels, AV25TFMigrLegFamDedGan, AV26TFMigrLegFamDedGan_To, AV28TFMigrLegFamAdh, AV29TFMigrLegFamAdh_Sels, AV48Pgmname, AV16OrderedBy, AV17OrderedDsc, AV49Importarlegajofamiliads_1_clicod, AV50Importarlegajofamiliads_2_empcod, AV51Importarlegajofamiliads_3_migrlegnumero, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV32TFiconoUpdate, AV33TFiconoUpdateOperator, AV20TFMigrLegFamParen, AV21TFMigrLegFamParen_Sels, AV23TFMigrLegFamNroDoc, AV24TFMigrLegFamNroDoc_Sels, AV25TFMigrLegFamDedGan, AV26TFMigrLegFamDedGan_To, AV28TFMigrLegFamAdh, AV29TFMigrLegFamAdh_Sels, AV48Pgmname, AV16OrderedBy, AV17OrderedDsc, AV49Importarlegajofamiliads_1_clicod, AV50Importarlegajofamiliads_2_empcod, AV51Importarlegajofamiliads_3_migrlegnumero, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV32TFiconoUpdate, AV33TFiconoUpdateOperator, AV20TFMigrLegFamParen, AV21TFMigrLegFamParen_Sels, AV23TFMigrLegFamNroDoc, AV24TFMigrLegFamNroDoc_Sels, AV25TFMigrLegFamDedGan, AV26TFMigrLegFamDedGan_To, AV28TFMigrLegFamAdh, AV29TFMigrLegFamAdh_Sels, AV48Pgmname, AV16OrderedBy, AV17OrderedDsc, AV49Importarlegajofamiliads_1_clicod, AV50Importarlegajofamiliads_2_empcod, AV51Importarlegajofamiliads_3_migrlegnumero, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV32TFiconoUpdate, AV33TFiconoUpdateOperator, AV20TFMigrLegFamParen, AV21TFMigrLegFamParen_Sels, AV23TFMigrLegFamNroDoc, AV24TFMigrLegFamNroDoc_Sels, AV25TFMigrLegFamDedGan, AV26TFMigrLegFamDedGan_To, AV28TFMigrLegFamAdh, AV29TFMigrLegFamAdh_Sels, AV48Pgmname, AV16OrderedBy, AV17OrderedDsc, AV49Importarlegajofamiliads_1_clicod, AV50Importarlegajofamiliads_2_empcod, AV51Importarlegajofamiliads_3_migrlegnumero, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV32TFiconoUpdate, AV33TFiconoUpdateOperator, AV20TFMigrLegFamParen, AV21TFMigrLegFamParen_Sels, AV23TFMigrLegFamNroDoc, AV24TFMigrLegFamNroDoc_Sels, AV25TFMigrLegFamDedGan, AV26TFMigrLegFamDedGan_To, AV28TFMigrLegFamAdh, AV29TFMigrLegFamAdh_Sels, AV48Pgmname, AV16OrderedBy, AV17OrderedDsc, AV49Importarlegajofamiliads_1_clicod, AV50Importarlegajofamiliads_2_empcod, AV51Importarlegajofamiliads_3_migrlegnumero, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV48Pgmname = "ImportarLegajoFamilia" ;
      Gx_err = (short)(0) ;
      edtavIconoupdatewithtags_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdatewithtags_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdatewithtags_Enabled), 5, 0), !bGXsfl_13_Refreshing);
      edtavIconoupdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIconoupdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoupdate_Enabled), 5, 0), !bGXsfl_13_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupM70( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12M72 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV30DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_13 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_13"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Popover_iconoupdate_Gridinternalname = httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Gridinternalname") ;
         Popover_iconoupdate_Iteminternalname = httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Iteminternalname") ;
         Popover_iconoupdate_Isgriditem = GXutil.strtobool( httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Isgriditem")) ;
         Popover_iconoupdate_Popoverwidth = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Popoverwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Popover_iconoupdate_Visible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"POPOVER_ICONOUPDATE_Visible")) ;
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
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Popoversingrid = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Popoversingrid") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Selectedcolumnfixedfilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedcolumnfixedfilter") ;
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
      e12M72 ();
      if (returnInSub) return;
   }

   public void e12M72( )
   {
      /* Start Routine */
      returnInSub = false ;
      Popover_iconoupdate_Gridinternalname = subGrid_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "GridInternalName", Popover_iconoupdate_Gridinternalname);
      Popover_iconoupdate_Iteminternalname = edtavIconoupdatewithtags_Internalname ;
      ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "ItemInternalName", Popover_iconoupdate_Iteminternalname);
      subGrid_Rows = 0 ;
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV30DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV30DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.msgdebug_prod(remoteHandle, context).execute( AV48Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " nro ", "")+GXutil.trim( GXutil.str( AV10MigrLegNumero, 8, 0))) ;
   }

   public void e13M72( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV49Importarlegajofamiliads_1_clicod = AV8CliCod ;
      AV50Importarlegajofamiliads_2_empcod = AV9EmpCod ;
      AV51Importarlegajofamiliads_3_migrlegnumero = AV10MigrLegNumero ;
      AV52Importarlegajofamiliads_4_tficonoupdate = AV32TFiconoUpdate ;
      AV53Importarlegajofamiliads_5_tficonoupdateoperator = AV33TFiconoUpdateOperator ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = AV20TFMigrLegFamParen ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = AV21TFMigrLegFamParen_Sels ;
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = AV23TFMigrLegFamNroDoc ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = AV24TFMigrLegFamNroDoc_Sels ;
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = AV25TFMigrLegFamDedGan ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = AV26TFMigrLegFamDedGan_To ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = AV28TFMigrLegFamAdh ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = AV29TFMigrLegFamAdh_Sels ;
   }

   public void e11M72( )
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
               AV33TFiconoUpdateOperator = (short)(1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFiconoUpdateOperator), 4, 0));
               AV32TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFiconoUpdate", AV32TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "2") == 0 )
            {
               AV33TFiconoUpdateOperator = (short)(2) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFiconoUpdateOperator), 4, 0));
               AV32TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFiconoUpdate", AV32TFiconoUpdate);
            }
            else if ( GXutil.strcmp(Ddo_grid_Selectedcolumnfixedfilter, "3") == 0 )
            {
               AV33TFiconoUpdateOperator = (short)(3) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFiconoUpdateOperator), 4, 0));
               AV32TFiconoUpdate = "" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32TFiconoUpdate", AV32TFiconoUpdate);
            }
            else
            {
               AV33TFiconoUpdateOperator = (short)(0) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFiconoUpdateOperator), 4, 0));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegFamParen") == 0 )
         {
            AV20TFMigrLegFamParen = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TFMigrLegFamParen", AV20TFMigrLegFamParen);
            AV19TFMigrLegFamParen_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TFMigrLegFamParen_SelsJson", AV19TFMigrLegFamParen_SelsJson);
            AV21TFMigrLegFamParen_Sels.fromJSonString(AV19TFMigrLegFamParen_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegFamNroDoc") == 0 )
         {
            AV23TFMigrLegFamNroDoc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23TFMigrLegFamNroDoc", AV23TFMigrLegFamNroDoc);
            AV22TFMigrLegFamNroDoc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TFMigrLegFamNroDoc_SelsJson", AV22TFMigrLegFamNroDoc_SelsJson);
            AV24TFMigrLegFamNroDoc_Sels.fromJSonString(AV22TFMigrLegFamNroDoc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegFamDedGan") == 0 )
         {
            AV25TFMigrLegFamDedGan = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFMigrLegFamDedGan", GXutil.ltrimstr( AV25TFMigrLegFamDedGan, 6, 4));
            AV26TFMigrLegFamDedGan_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFMigrLegFamDedGan_To", GXutil.ltrimstr( AV26TFMigrLegFamDedGan_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "MigrLegFamAdh") == 0 )
         {
            AV28TFMigrLegFamAdh = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFMigrLegFamAdh", AV28TFMigrLegFamAdh);
            AV27TFMigrLegFamAdh_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFMigrLegFamAdh_SelsJson", AV27TFMigrLegFamAdh_SelsJson);
            AV29TFMigrLegFamAdh_Sels.fromJSonString(AV27TFMigrLegFamAdh_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV21TFMigrLegFamParen_Sels", AV21TFMigrLegFamParen_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV24TFMigrLegFamNroDoc_Sels", AV24TFMigrLegFamNroDoc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV29TFMigrLegFamAdh_Sels", AV29TFMigrLegFamAdh_Sels);
   }

   private void e14M72( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      edtavIconoupdatewithtags_Link = formatLink("web.importacion_legajofamilia", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A87MigrLegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A2078MigrLegFamSec,4,0))}, new String[] {"Mode","CliCod","EmpCod","MigrLegNumero","MigrLegFamSec"})  ;
      new web.msgdebug7(remoteHandle, context).execute( AV48Pgmname, "") ;
      if ( ! (GXutil.strcmp("", A2084MigrLegFamErrores)==0) || ! (GXutil.strcmp("", A2085MigrLegFamWarnings)==0) )
      {
         Popover_iconoupdate_Visible = true ;
         ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "Visible", GXutil.booltostr( Popover_iconoupdate_Visible));
      }
      else
      {
         Popover_iconoupdate_Visible = false ;
         ucPopover_iconoupdate.sendProperty(context, sPrefix, false, Popover_iconoupdate_Internalname, "Visible", GXutil.booltostr( Popover_iconoupdate_Visible));
      }
      AV31iconoUpdate = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdate_Internalname, AV31iconoUpdate);
      AV34iconoUpdateWithTags = AV31iconoUpdate ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV34iconoUpdateWithTags);
      if ( (GXutil.strcmp("", A2084MigrLegFamErrores)==0) && ! (GXutil.strcmp("", A2085MigrLegFamWarnings)==0) )
      {
         AV34iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconWarning FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Warnings", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV34iconoUpdateWithTags);
      }
      if ( ! (GXutil.strcmp("", A2084MigrLegFamErrores)==0) )
      {
         AV34iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconDanger FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Con Errores", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV34iconoUpdateWithTags);
      }
      if ( (GXutil.strcmp("", A2084MigrLegFamErrores)==0) && (GXutil.strcmp("", A2085MigrLegFamWarnings)==0) )
      {
         AV34iconoUpdateWithTags += GXutil.format( "<i class='fa fa-circle FontColorIconSuccess FontColorIconSmall TagAfterText BootstrapTooltipTop' title='%1'></i>", httpContext.getMessage( "Validado OK", ""), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV34iconoUpdateWithTags);
      }
      AV34iconoUpdateWithTags += "<i class='WWPPopoverIcon TagAfterText fa fa-caret-down'></i>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavIconoupdatewithtags_Internalname, AV34iconoUpdateWithTags);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(13) ;
      }
      sendrow_132( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_13_Refreshing )
      {
         httpContext.doAjaxLoad(13, GridRow);
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

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV18Session.getValue(AV48Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV48Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV18Session.getValue(AV48Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV62GXV1 = 1 ;
      while ( AV62GXV1 <= AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV62GXV1));
         if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV33TFiconoUpdateOperator = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFiconoUpdateOperator", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33TFiconoUpdateOperator), 4, 0));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMPAREN") == 0 )
         {
            AV20TFMigrLegFamParen = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20TFMigrLegFamParen", AV20TFMigrLegFamParen);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMPAREN_SEL") == 0 )
         {
            AV19TFMigrLegFamParen_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TFMigrLegFamParen_SelsJson", AV19TFMigrLegFamParen_SelsJson);
            AV21TFMigrLegFamParen_Sels.fromJSonString(AV19TFMigrLegFamParen_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMNRODOC") == 0 )
         {
            AV23TFMigrLegFamNroDoc = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23TFMigrLegFamNroDoc", AV23TFMigrLegFamNroDoc);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMNRODOC_SEL") == 0 )
         {
            AV22TFMigrLegFamNroDoc_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TFMigrLegFamNroDoc_SelsJson", AV22TFMigrLegFamNroDoc_SelsJson);
            AV24TFMigrLegFamNroDoc_Sels.fromJSonString(AV22TFMigrLegFamNroDoc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMDEDGAN") == 0 )
         {
            AV25TFMigrLegFamDedGan = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFMigrLegFamDedGan", GXutil.ltrimstr( AV25TFMigrLegFamDedGan, 6, 4));
            AV26TFMigrLegFamDedGan_To = CommonUtil.decimalVal( AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TFMigrLegFamDedGan_To", GXutil.ltrimstr( AV26TFMigrLegFamDedGan_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMADH") == 0 )
         {
            AV28TFMigrLegFamAdh = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFMigrLegFamAdh", AV28TFMigrLegFamAdh);
         }
         else if ( GXutil.strcmp(AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMIGRLEGFAMADH_SEL") == 0 )
         {
            AV27TFMigrLegFamAdh_SelsJson = AV15GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFMigrLegFamAdh_SelsJson", AV27TFMigrLegFamAdh_SelsJson);
            AV29TFMigrLegFamAdh_Sels.fromJSonString(AV27TFMigrLegFamAdh_SelsJson, null);
         }
         AV62GXV1 = (int)(AV62GXV1+1) ;
      }
      GXt_char4 = "" ;
      GXv_char5[0] = GXt_char4 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV21TFMigrLegFamParen_Sels.size()==0), AV19TFMigrLegFamParen_SelsJson, GXv_char5) ;
      importarlegajofamilia_impl.this.GXt_char4 = GXv_char5[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV24TFMigrLegFamNroDoc_Sels.size()==0), AV22TFMigrLegFamNroDoc_SelsJson, GXv_char7) ;
      importarlegajofamilia_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV29TFMigrLegFamAdh_Sels.size()==0), AV27TFMigrLegFamAdh_SelsJson, GXv_char9) ;
      importarlegajofamilia_impl.this.GXt_char8 = GXv_char9[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char4+"|"+GXt_char6+"||"+GXt_char8 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV20TFMigrLegFamParen)==0), AV20TFMigrLegFamParen, GXv_char9) ;
      importarlegajofamilia_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV23TFMigrLegFamNroDoc)==0), AV23TFMigrLegFamNroDoc, GXv_char7) ;
      importarlegajofamilia_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char4 = "" ;
      GXv_char5[0] = GXt_char4 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFMigrLegFamAdh)==0), AV28TFMigrLegFamAdh, GXv_char5) ;
      importarlegajofamilia_impl.this.GXt_char4 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = "|"+GXt_char8+"|"+GXt_char6+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFMigrLegFamDedGan)==0) ? "" : GXutil.str( AV25TFMigrLegFamDedGan, 6, 4))+"|"+GXt_char4 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFMigrLegFamDedGan_To)==0) ? "" : GXutil.str( AV26TFMigrLegFamDedGan_To, 6, 4))+"|" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      Ddo_grid_Selectedfixedfilter = ((AV33TFiconoUpdateOperator!=1) ? "" : "1")+((AV33TFiconoUpdateOperator!=2) ? "" : "2")+((AV33TFiconoUpdateOperator!=3) ? "" : "3")+"||||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedFixedFilter", Ddo_grid_Selectedfixedfilter);
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
      AV14GridState.fromxml(AV18Session.getValue(AV48Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFICONOUPDATE", "", !((GXutil.strcmp("", AV32TFiconoUpdate)==0)&&(0==AV33TFiconoUpdateOperator)), AV33TFiconoUpdateOperator, AV32TFiconoUpdate, "") ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFMIGRLEGFAMPAREN", "", !(GXutil.strcmp("", AV20TFMigrLegFamParen)==0), (short)(0), AV20TFMigrLegFamParen, "", !(AV21TFMigrLegFamParen_Sels.size()==0), AV21TFMigrLegFamParen_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFMIGRLEGFAMNRODOC", "", !(GXutil.strcmp("", AV23TFMigrLegFamNroDoc)==0), (short)(0), AV23TFMigrLegFamNroDoc, "", !(AV24TFMigrLegFamNroDoc_Sels.size()==0), AV24TFMigrLegFamNroDoc_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFMIGRLEGFAMDEDGAN", "", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFMigrLegFamDedGan)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFMigrLegFamDedGan_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV25TFMigrLegFamDedGan, 6, 4)), GXutil.trim( GXutil.str( AV26TFMigrLegFamDedGan_To, 6, 4))) ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV14GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFMIGRLEGFAMADH", "", !(GXutil.strcmp("", AV28TFMigrLegFamAdh)==0), (short)(0), AV28TFMigrLegFamAdh, "", !(AV29TFMigrLegFamAdh_Sels.size()==0), AV29TFMigrLegFamAdh_Sels.toJSonString(false), "") ;
      AV14GridState = GXv_SdtWWPGridState10[0] ;
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
      if ( ! (0==AV10MigrLegNumero) )
      {
         AV15GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MIGRLEGNUMERO" );
         AV15GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV10MigrLegNumero, 8, 0) );
         AV14GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV15GridStateFilterValue, 0);
      }
      AV14GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV14GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV48Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV48Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "importacion_legajoFamilia" );
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "MigrLegNumero" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV10MigrLegNumero, 8, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV18Session.setValue("TrnContext", AV12TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void wb_table1_10_M72( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid NestedGridCell CellMarginTop GridNoBorderCell HasGridEmpowerer'>") ;
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol13( ) ;
      }
      if ( wbEnd == 13 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_13 = (int)(nGXsfl_13_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
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
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_10_M72e( true) ;
      }
      else
      {
         wb_table1_10_M72e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      AV10MigrLegNumero = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10MigrLegNumero), 8, 0));
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
      paM72( ) ;
      wsM72( ) ;
      weM72( ) ;
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
      sCtrlAV10MigrLegNumero = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paM72( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "importarlegajofamilia", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paM72( ) ;
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
         AV10MigrLegNumero = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10MigrLegNumero), 8, 0));
      }
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV10MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( AV10MigrLegNumero != wcpOAV10MigrLegNumero ) ) )
      {
         setjustcreated();
      }
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV10MigrLegNumero = AV10MigrLegNumero ;
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
      sCtrlAV10MigrLegNumero = httpContext.cgiGet( sPrefix+"AV10MigrLegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV10MigrLegNumero) > 0 )
      {
         AV10MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV10MigrLegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10MigrLegNumero), 8, 0));
      }
      else
      {
         AV10MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV10MigrLegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paM72( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsM72( ) ;
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
      wsM72( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10MigrLegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV10MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10MigrLegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10MigrLegNumero_CTRL", GXutil.rtrim( sCtrlAV10MigrLegNumero));
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
      weM72( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020115539", true, true);
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
      httpContext.AddJavascriptSource("importarlegajofamilia.js", "?2024122020115539", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_132( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_13_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_13_idx ;
      edtMigrLegNumero_Internalname = sPrefix+"MIGRLEGNUMERO_"+sGXsfl_13_idx ;
      edtMigrLegFamSec_Internalname = sPrefix+"MIGRLEGFAMSEC_"+sGXsfl_13_idx ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS_"+sGXsfl_13_idx ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE_"+sGXsfl_13_idx ;
      edtMigrLegFamParen_Internalname = sPrefix+"MIGRLEGFAMPAREN_"+sGXsfl_13_idx ;
      edtMigrLegFamDiscap_Internalname = sPrefix+"MIGRLEGFAMDISCAP_"+sGXsfl_13_idx ;
      edtMigrLegFamNroDoc_Internalname = sPrefix+"MIGRLEGFAMNRODOC_"+sGXsfl_13_idx ;
      edtMigrLegFamDedGan_Internalname = sPrefix+"MIGRLEGFAMDEDGAN_"+sGXsfl_13_idx ;
      edtMigrLegFamAdh_Internalname = sPrefix+"MIGRLEGFAMADH_"+sGXsfl_13_idx ;
      edtMigrLegFamNomApe_Internalname = sPrefix+"MIGRLEGFAMNOMAPE_"+sGXsfl_13_idx ;
      edtMigrLegFamFecNac_Internalname = sPrefix+"MIGRLEGFAMFECNAC_"+sGXsfl_13_idx ;
   }

   public void subsflControlProps_fel_132( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_13_fel_idx ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD_"+sGXsfl_13_fel_idx ;
      edtMigrLegNumero_Internalname = sPrefix+"MIGRLEGNUMERO_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamSec_Internalname = sPrefix+"MIGRLEGFAMSEC_"+sGXsfl_13_fel_idx ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS_"+sGXsfl_13_fel_idx ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamParen_Internalname = sPrefix+"MIGRLEGFAMPAREN_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamDiscap_Internalname = sPrefix+"MIGRLEGFAMDISCAP_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamNroDoc_Internalname = sPrefix+"MIGRLEGFAMNRODOC_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamDedGan_Internalname = sPrefix+"MIGRLEGFAMDEDGAN_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamAdh_Internalname = sPrefix+"MIGRLEGFAMADH_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamNomApe_Internalname = sPrefix+"MIGRLEGFAMNOMAPE_"+sGXsfl_13_fel_idx ;
      edtMigrLegFamFecNac_Internalname = sPrefix+"MIGRLEGFAMFECNAC_"+sGXsfl_13_fel_idx ;
   }

   public void sendrow_132( )
   {
      subsflControlProps_132( ) ;
      wbM70( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_13_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_13_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_13_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamSec_Internalname,GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2078MigrLegFamSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 18,'"+sPrefix+"',false,'"+sGXsfl_13_idx+"',13)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdatewithtags_Internalname,AV34iconoUpdateWithTags,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdatewithtags_Enabled!=0)&&(edtavIconoupdatewithtags_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,18);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavIconoupdatewithtags_Link,"","","",edtavIconoupdatewithtags_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavIconoupdatewithtags_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 19,'"+sPrefix+"',false,'"+sGXsfl_13_idx+"',13)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIconoupdate_Internalname,GXutil.rtrim( AV31iconoUpdate),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIconoupdate_Enabled!=0)&&(edtavIconoupdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,19);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+"e15m72_client"+"'","","","","",edtavIconoupdate_Jsonclick,Integer.valueOf(7),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavIconoupdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamParen_Internalname,A2079MigrLegFamParen,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamParen_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamDiscap_Internalname,GXutil.rtrim( A2086MigrLegFamDiscap),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamDiscap_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamNroDoc_Internalname,A2080MigrLegFamNroDoc,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamNroDoc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamDedGan_Internalname,GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A2081MigrLegFamDedGan, "9.9999")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamDedGan_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamAdh_Internalname,GXutil.rtrim( A2082MigrLegFamAdh),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamAdh_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamNomApe_Internalname,A2088MigrLegFamNomApe,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamFecNac_Internalname,localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"),localUtil.format( A2089MigrLegFamFecNac, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamFecNac_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesM72( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_13_idx = ((subGrid_Islastpage==1)&&(nGXsfl_13_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_13_idx+1) ;
         sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_132( ) ;
      }
      /* End function sendrow_132 */
   }

   public void startgridcontrol13( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"13\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeValue( httpContext.getMessage( "Leg Numero", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fam Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Modificar", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Modificar", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Parentesco", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Discapacitado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro. Doc.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Deduce ganancias", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Adherente a la obra social", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nombre y apellido", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de nacimiento", "")) ;
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
         GridContainer.AddObjectProperty("Class", "WorkWith");
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV34iconoUpdateWithTags);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdatewithtags_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavIconoupdatewithtags_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV31iconoUpdate));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIconoupdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2079MigrLegFamParen);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2086MigrLegFamDiscap));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2080MigrLegFamNroDoc);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2082MigrLegFamAdh));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2088MigrLegFamNomApe);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
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
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtMigrLegNumero_Internalname = sPrefix+"MIGRLEGNUMERO" ;
      edtMigrLegFamSec_Internalname = sPrefix+"MIGRLEGFAMSEC" ;
      edtavIconoupdatewithtags_Internalname = sPrefix+"vICONOUPDATEWITHTAGS" ;
      edtavIconoupdate_Internalname = sPrefix+"vICONOUPDATE" ;
      edtMigrLegFamParen_Internalname = sPrefix+"MIGRLEGFAMPAREN" ;
      edtMigrLegFamDiscap_Internalname = sPrefix+"MIGRLEGFAMDISCAP" ;
      edtMigrLegFamNroDoc_Internalname = sPrefix+"MIGRLEGFAMNRODOC" ;
      edtMigrLegFamDedGan_Internalname = sPrefix+"MIGRLEGFAMDEDGAN" ;
      edtMigrLegFamAdh_Internalname = sPrefix+"MIGRLEGFAMADH" ;
      edtMigrLegFamNomApe_Internalname = sPrefix+"MIGRLEGFAMNOMAPE" ;
      edtMigrLegFamFecNac_Internalname = sPrefix+"MIGRLEGFAMFECNAC" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = sPrefix+"UNNAMEDGROUP2" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Popover_iconoupdate_Internalname = sPrefix+"POPOVER_ICONOUPDATE" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
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
      edtMigrLegFamFecNac_Jsonclick = "" ;
      edtMigrLegFamNomApe_Jsonclick = "" ;
      edtMigrLegFamAdh_Jsonclick = "" ;
      edtMigrLegFamDedGan_Jsonclick = "" ;
      edtMigrLegFamNroDoc_Jsonclick = "" ;
      edtMigrLegFamDiscap_Jsonclick = "" ;
      edtMigrLegFamParen_Jsonclick = "" ;
      edtavIconoupdate_Jsonclick = "" ;
      edtavIconoupdate_Visible = 0 ;
      edtavIconoupdate_Enabled = 1 ;
      edtavIconoupdatewithtags_Jsonclick = "" ;
      edtavIconoupdatewithtags_Visible = -1 ;
      edtavIconoupdatewithtags_Link = "" ;
      edtavIconoupdatewithtags_Enabled = 1 ;
      edtMigrLegFamSec_Jsonclick = "" ;
      edtMigrLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Popoversingrid = "Popover_iconoUpdate" ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|||6.4|" ;
      Ddo_grid_Fixedfilters = "1:Con Warnings:fa fa-circle FontColorIconWarning FontColorIconSmall ConditionalFormattingFilterIcon,2:Con Errores:fa fa-circle FontColorIconDanger FontColorIconSmall ConditionalFormattingFilterIcon,3:Validados OK:fa fa-circle FontColorIconSuccess FontColorIconSmall ConditionalFormattingFilterIcon||||" ;
      Ddo_grid_Datalistproc = "ImportarLegajoFamiliaGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "|T|T||T" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic||Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T||T" ;
      Ddo_grid_Filterisrange = "|||T|" ;
      Ddo_grid_Filtertype = "|Character|Character|Numeric|Character" ;
      Ddo_grid_Includefilter = "|T|T|T|T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|1|2|3|4" ;
      Ddo_grid_Columnids = "4:iconoUpdate|6:MigrLegFamParen|8:MigrLegFamNroDoc|9:MigrLegFamDedGan|10:MigrLegFamAdh" ;
      Ddo_grid_Gridinternalname = "" ;
      Popover_iconoupdate_Visible = GXutil.toBoolean( -1) ;
      Popover_iconoupdate_Popoverwidth = 400 ;
      Popover_iconoupdate_Isgriditem = GXutil.toBoolean( -1) ;
      Popover_iconoupdate_Iteminternalname = "" ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV49Importarlegajofamiliads_1_clicod',fld:'vIMPORTARLEGAJOFAMILIADS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV50Importarlegajofamiliads_2_empcod',fld:'vIMPORTARLEGAJOFAMILIADS_2_EMPCOD',pic:'ZZZ9'},{av:'AV51Importarlegajofamiliads_3_migrlegnumero',fld:'vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e11M72',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV49Importarlegajofamiliads_1_clicod',fld:'vIMPORTARLEGAJOFAMILIADS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV50Importarlegajofamiliads_2_empcod',fld:'vIMPORTARLEGAJOFAMILIADS_2_EMPCOD',pic:'ZZZ9'},{av:'AV51Importarlegajofamiliads_3_migrlegnumero',fld:'vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Selectedcolumnfixedfilter',ctrl:'DDO_GRID',prop:'SelectedColumnFixedFilter'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV19TFMigrLegFamParen_SelsJson',fld:'vTFMIGRLEGFAMPAREN_SELSJSON',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV22TFMigrLegFamNroDoc_SelsJson',fld:'vTFMIGRLEGFAMNRODOC_SELSJSON',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV27TFMigrLegFamAdh_SelsJson',fld:'vTFMIGRLEGFAMADH_SELSJSON',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e14M72',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A2078MigrLegFamSec',fld:'MIGRLEGFAMSEC',pic:'ZZZ9',hsh:true},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A2084MigrLegFamErrores',fld:'MIGRLEGFAMERRORES',pic:''},{av:'A2085MigrLegFamWarnings',fld:'MIGRLEGFAMWARNINGS',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtavIconoupdatewithtags_Link',ctrl:'vICONOUPDATEWITHTAGS',prop:'Link'},{av:'Popover_iconoupdate_Visible',ctrl:'POPOVER_ICONOUPDATE',prop:'Visible'},{av:'AV31iconoUpdate',fld:'vICONOUPDATE',pic:''},{av:'AV34iconoUpdateWithTags',fld:'vICONOUPDATEWITHTAGS',pic:''}]}");
      setEventMetadata("VICONOUPDATE.CLICK","{handler:'e15M72',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9',hsh:true},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A2078MigrLegFamSec',fld:'MIGRLEGFAMSEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VICONOUPDATE.CLICK",",oparms:[{ctrl:'WWPAUX_WC'}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV49Importarlegajofamiliads_1_clicod',fld:'vIMPORTARLEGAJOFAMILIADS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV50Importarlegajofamiliads_2_empcod',fld:'vIMPORTARLEGAJOFAMILIADS_2_EMPCOD',pic:'ZZZ9'},{av:'AV51Importarlegajofamiliads_3_migrlegnumero',fld:'vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV49Importarlegajofamiliads_1_clicod',fld:'vIMPORTARLEGAJOFAMILIADS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV50Importarlegajofamiliads_2_empcod',fld:'vIMPORTARLEGAJOFAMILIADS_2_EMPCOD',pic:'ZZZ9'},{av:'AV51Importarlegajofamiliads_3_migrlegnumero',fld:'vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV49Importarlegajofamiliads_1_clicod',fld:'vIMPORTARLEGAJOFAMILIADS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV50Importarlegajofamiliads_2_empcod',fld:'vIMPORTARLEGAJOFAMILIADS_2_EMPCOD',pic:'ZZZ9'},{av:'AV51Importarlegajofamiliads_3_migrlegnumero',fld:'vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV49Importarlegajofamiliads_1_clicod',fld:'vIMPORTARLEGAJOFAMILIADS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV50Importarlegajofamiliads_2_empcod',fld:'vIMPORTARLEGAJOFAMILIADS_2_EMPCOD',pic:'ZZZ9'},{av:'AV51Importarlegajofamiliads_3_migrlegnumero',fld:'vIMPORTARLEGAJOFAMILIADS_3_MIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'sPrefix'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV32TFiconoUpdate',fld:'vTFICONOUPDATE',pic:''},{av:'AV33TFiconoUpdateOperator',fld:'vTFICONOUPDATEOPERATOR',pic:'ZZZ9'},{av:'AV20TFMigrLegFamParen',fld:'vTFMIGRLEGFAMPAREN',pic:''},{av:'AV21TFMigrLegFamParen_Sels',fld:'vTFMIGRLEGFAMPAREN_SELS',pic:''},{av:'AV23TFMigrLegFamNroDoc',fld:'vTFMIGRLEGFAMNRODOC',pic:''},{av:'AV24TFMigrLegFamNroDoc_Sels',fld:'vTFMIGRLEGFAMNRODOC_SELS',pic:''},{av:'AV25TFMigrLegFamDedGan',fld:'vTFMIGRLEGFAMDEDGAN',pic:'9.9999'},{av:'AV26TFMigrLegFamDedGan_To',fld:'vTFMIGRLEGFAMDEDGAN_TO',pic:'9.9999'},{av:'AV28TFMigrLegFamAdh',fld:'vTFMIGRLEGFAMADH',pic:''},{av:'AV29TFMigrLegFamAdh_Sels',fld:'vTFMIGRLEGFAMADH_SELS',pic:''},{av:'AV48Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Migrlegfamfecnac',iparms:[]");
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
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Selectedcolumnfixedfilter = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV32TFiconoUpdate = "" ;
      AV20TFMigrLegFamParen = "" ;
      AV21TFMigrLegFamParen_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFMigrLegFamNroDoc = "" ;
      AV24TFMigrLegFamNroDoc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFMigrLegFamDedGan = DecimalUtil.ZERO ;
      AV26TFMigrLegFamDedGan_To = DecimalUtil.ZERO ;
      AV28TFMigrLegFamAdh = "" ;
      AV29TFMigrLegFamAdh_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV30DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      A2084MigrLegFamErrores = "" ;
      A2085MigrLegFamWarnings = "" ;
      Popover_iconoupdate_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Ddo_grid_Selectedfixedfilter = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ucPopover_iconoupdate = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV52Importarlegajofamiliads_4_tficonoupdate = "" ;
      AV54Importarlegajofamiliads_6_tfmigrlegfamparen = "" ;
      AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = "" ;
      AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan = DecimalUtil.ZERO ;
      AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to = DecimalUtil.ZERO ;
      AV60Importarlegajofamiliads_12_tfmigrlegfamadh = "" ;
      AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34iconoUpdateWithTags = "" ;
      AV31iconoUpdate = "" ;
      A2079MigrLegFamParen = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2082MigrLegFamAdh = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      scmdbuf = "" ;
      lV54Importarlegajofamiliads_6_tfmigrlegfamparen = "" ;
      lV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc = "" ;
      lV60Importarlegajofamiliads_12_tfmigrlegfamadh = "" ;
      H00M72_A2085MigrLegFamWarnings = new String[] {""} ;
      H00M72_A2084MigrLegFamErrores = new String[] {""} ;
      H00M72_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H00M72_A2088MigrLegFamNomApe = new String[] {""} ;
      H00M72_A2082MigrLegFamAdh = new String[] {""} ;
      H00M72_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00M72_A2080MigrLegFamNroDoc = new String[] {""} ;
      H00M72_A2086MigrLegFamDiscap = new String[] {""} ;
      H00M72_A2079MigrLegFamParen = new String[] {""} ;
      H00M72_A2078MigrLegFamSec = new short[1] ;
      H00M72_A87MigrLegNumero = new int[1] ;
      H00M72_A1EmpCod = new short[1] ;
      H00M72_A3CliCod = new int[1] ;
      H00M73_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV19TFMigrLegFamParen_SelsJson = "" ;
      AV22TFMigrLegFamNroDoc_SelsJson = "" ;
      AV27TFMigrLegFamAdh_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV18Session = httpContext.getWebSession();
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState10 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV10MigrLegNumero = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      TempTags = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importarlegajofamilia__default(),
         new Object[] {
             new Object[] {
            H00M72_A2085MigrLegFamWarnings, H00M72_A2084MigrLegFamErrores, H00M72_A2089MigrLegFamFecNac, H00M72_A2088MigrLegFamNomApe, H00M72_A2082MigrLegFamAdh, H00M72_A2081MigrLegFamDedGan, H00M72_A2080MigrLegFamNroDoc, H00M72_A2086MigrLegFamDiscap, H00M72_A2079MigrLegFamParen, H00M72_A2078MigrLegFamSec,
            H00M72_A87MigrLegNumero, H00M72_A1EmpCod, H00M72_A3CliCod
            }
            , new Object[] {
            H00M73_AGRID_nRecordCount
            }
         }
      );
      AV48Pgmname = "ImportarLegajoFamilia" ;
      /* GeneXus formulas. */
      AV48Pgmname = "ImportarLegajoFamilia" ;
      Gx_err = (short)(0) ;
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
   private short wcpOAV9EmpCod ;
   private short AV9EmpCod ;
   private short AV33TFiconoUpdateOperator ;
   private short AV16OrderedBy ;
   private short AV50Importarlegajofamiliads_2_empcod ;
   private short wbEnd ;
   private short wbStart ;
   private short AV53Importarlegajofamiliads_5_tficonoupdateoperator ;
   private short A1EmpCod ;
   private short A2078MigrLegFamSec ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8CliCod ;
   private int wcpOAV10MigrLegNumero ;
   private int subGrid_Rows ;
   private int nRC_GXsfl_13 ;
   private int AV8CliCod ;
   private int AV10MigrLegNumero ;
   private int nGXsfl_13_idx=1 ;
   private int AV49Importarlegajofamiliads_1_clicod ;
   private int AV51Importarlegajofamiliads_3_migrlegnumero ;
   private int Popover_iconoupdate_Popoverwidth ;
   private int A3CliCod ;
   private int A87MigrLegNumero ;
   private int subGrid_Islastpage ;
   private int edtavIconoupdatewithtags_Enabled ;
   private int edtavIconoupdate_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ;
   private int AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ;
   private int AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ;
   private int AV62GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavIconoupdatewithtags_Visible ;
   private int edtavIconoupdate_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV25TFMigrLegFamDedGan ;
   private java.math.BigDecimal AV26TFMigrLegFamDedGan_To ;
   private java.math.BigDecimal AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan ;
   private java.math.BigDecimal AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Selectedcolumnfixedfilter ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_13_idx="0001" ;
   private String AV32TFiconoUpdate ;
   private String AV28TFMigrLegFamAdh ;
   private String AV48Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
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
   private String Grid_empowerer_Gridinternalname ;
   private String Grid_empowerer_Popoversingrid ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Popover_iconoupdate_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavIconoupdatewithtags_Internalname ;
   private String AV52Importarlegajofamiliads_4_tficonoupdate ;
   private String AV60Importarlegajofamiliads_12_tfmigrlegfamadh ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtMigrLegNumero_Internalname ;
   private String edtMigrLegFamSec_Internalname ;
   private String AV31iconoUpdate ;
   private String edtavIconoupdate_Internalname ;
   private String edtMigrLegFamParen_Internalname ;
   private String A2086MigrLegFamDiscap ;
   private String edtMigrLegFamDiscap_Internalname ;
   private String edtMigrLegFamNroDoc_Internalname ;
   private String edtMigrLegFamDedGan_Internalname ;
   private String A2082MigrLegFamAdh ;
   private String edtMigrLegFamAdh_Internalname ;
   private String edtMigrLegFamNomApe_Internalname ;
   private String edtMigrLegFamFecNac_Internalname ;
   private String scmdbuf ;
   private String lV60Importarlegajofamiliads_12_tfmigrlegfamadh ;
   private String edtavIconoupdatewithtags_Link ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String tblUnnamedtable1_Internalname ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV10MigrLegNumero ;
   private String sGXsfl_13_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtMigrLegNumero_Jsonclick ;
   private String edtMigrLegFamSec_Jsonclick ;
   private String TempTags ;
   private String edtavIconoupdatewithtags_Jsonclick ;
   private String edtavIconoupdate_Jsonclick ;
   private String edtMigrLegFamParen_Jsonclick ;
   private String edtMigrLegFamDiscap_Jsonclick ;
   private String edtMigrLegFamNroDoc_Jsonclick ;
   private String edtMigrLegFamDedGan_Jsonclick ;
   private String edtMigrLegFamAdh_Jsonclick ;
   private String edtMigrLegFamNomApe_Jsonclick ;
   private String edtMigrLegFamFecNac_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17OrderedDsc ;
   private boolean Popover_iconoupdate_Isgriditem ;
   private boolean Popover_iconoupdate_Visible ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean bGXsfl_13_Refreshing=false ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A2084MigrLegFamErrores ;
   private String A2085MigrLegFamWarnings ;
   private String AV19TFMigrLegFamParen_SelsJson ;
   private String AV22TFMigrLegFamNroDoc_SelsJson ;
   private String AV27TFMigrLegFamAdh_SelsJson ;
   private String AV20TFMigrLegFamParen ;
   private String AV23TFMigrLegFamNroDoc ;
   private String AV54Importarlegajofamiliads_6_tfmigrlegfamparen ;
   private String AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc ;
   private String AV34iconoUpdateWithTags ;
   private String A2079MigrLegFamParen ;
   private String A2080MigrLegFamNroDoc ;
   private String A2088MigrLegFamNomApe ;
   private String lV54Importarlegajofamiliads_6_tfmigrlegfamparen ;
   private String lV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private com.genexus.webpanels.GXUserControl ucPopover_iconoupdate ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private IDataStoreProvider pr_default ;
   private String[] H00M72_A2085MigrLegFamWarnings ;
   private String[] H00M72_A2084MigrLegFamErrores ;
   private java.util.Date[] H00M72_A2089MigrLegFamFecNac ;
   private String[] H00M72_A2088MigrLegFamNomApe ;
   private String[] H00M72_A2082MigrLegFamAdh ;
   private java.math.BigDecimal[] H00M72_A2081MigrLegFamDedGan ;
   private String[] H00M72_A2080MigrLegFamNroDoc ;
   private String[] H00M72_A2086MigrLegFamDiscap ;
   private String[] H00M72_A2079MigrLegFamParen ;
   private short[] H00M72_A2078MigrLegFamSec ;
   private int[] H00M72_A87MigrLegNumero ;
   private short[] H00M72_A1EmpCod ;
   private int[] H00M72_A3CliCod ;
   private long[] H00M73_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV29TFMigrLegFamAdh_Sels ;
   private GXSimpleCollection<String> AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels ;
   private GXSimpleCollection<String> AV21TFMigrLegFamParen_Sels ;
   private GXSimpleCollection<String> AV24TFMigrLegFamNroDoc_Sels ;
   private GXSimpleCollection<String> AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels ;
   private GXSimpleCollection<String> AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState10[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV15GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV30DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class importarlegajofamilia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00M72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2079MigrLegFamParen ,
                                          GXSimpleCollection<String> AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                          String A2080MigrLegFamNroDoc ,
                                          GXSimpleCollection<String> AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                          String A2082MigrLegFamAdh ,
                                          GXSimpleCollection<String> AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                          short AV53Importarlegajofamiliads_5_tficonoupdateoperator ,
                                          int AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ,
                                          String AV54Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                          int AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ,
                                          String AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                          java.math.BigDecimal AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                          java.math.BigDecimal AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                          int AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ,
                                          String AV60Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                          String A2084MigrLegFamErrores ,
                                          String A2085MigrLegFamWarnings ,
                                          java.math.BigDecimal A2081MigrLegFamDedGan ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV49Importarlegajofamiliads_1_clicod ,
                                          short AV50Importarlegajofamiliads_2_empcod ,
                                          int AV51Importarlegajofamiliads_3_migrlegnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A87MigrLegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[11];
      Object[] GXv_Object12 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " MigrLegFamWarnings, MigrLegFamErrores, MigrLegFamFecNac, MigrLegFamNomApe, MigrLegFamAdh, MigrLegFamDedGan, MigrLegFamNroDoc, MigrLegFamDiscap, MigrLegFamParen," ;
      sSelectString += " MigrLegFamSec, MigrLegNumero, EmpCod, CliCod" ;
      sFromString = " FROM importacion_legajoFamilia" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and MigrLegNumero = ?)");
      if ( AV53Importarlegajofamiliads_5_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( AV53Importarlegajofamiliads_5_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegFamErrores))=0))");
      }
      if ( AV53Importarlegajofamiliads_5_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( ( AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Importarlegajofamiliads_6_tfmigrlegfamparen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamParen) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels, "MigrLegFamParen IN (", ")")+")");
      }
      if ( ( AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamNroDoc) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels, "MigrLegFamNroDoc IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Importarlegajofamiliads_12_tfmigrlegfamadh)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamAdh) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels, "MigrLegFamAdh IN (", ")")+")");
      }
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamParen, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC, MigrLegFamParen DESC, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamNroDoc, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC, MigrLegFamNroDoc DESC, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamDedGan, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC, MigrLegFamDedGan DESC, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamAdh, MigrLegFamSec" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC, MigrLegFamAdh DESC, MigrLegFamSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_H00M73( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2079MigrLegFamParen ,
                                          GXSimpleCollection<String> AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels ,
                                          String A2080MigrLegFamNroDoc ,
                                          GXSimpleCollection<String> AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels ,
                                          String A2082MigrLegFamAdh ,
                                          GXSimpleCollection<String> AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels ,
                                          short AV53Importarlegajofamiliads_5_tficonoupdateoperator ,
                                          int AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size ,
                                          String AV54Importarlegajofamiliads_6_tfmigrlegfamparen ,
                                          int AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size ,
                                          String AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc ,
                                          java.math.BigDecimal AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan ,
                                          java.math.BigDecimal AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to ,
                                          int AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size ,
                                          String AV60Importarlegajofamiliads_12_tfmigrlegfamadh ,
                                          String A2084MigrLegFamErrores ,
                                          String A2085MigrLegFamWarnings ,
                                          java.math.BigDecimal A2081MigrLegFamDedGan ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          int AV49Importarlegajofamiliads_1_clicod ,
                                          short AV50Importarlegajofamiliads_2_empcod ,
                                          int AV51Importarlegajofamiliads_3_migrlegnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A87MigrLegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[8];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM importacion_legajoFamilia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and MigrLegNumero = ?)");
      if ( AV53Importarlegajofamiliads_5_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and Not (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( AV53Importarlegajofamiliads_5_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from MigrLegFamErrores))=0))");
      }
      if ( AV53Importarlegajofamiliads_5_tficonoupdateoperator == 3 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from MigrLegFamErrores))=0) and (char_length(trim(trailing ' ' from MigrLegFamWarnings))=0))");
      }
      if ( ( AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Importarlegajofamiliads_6_tfmigrlegfamparen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamParen) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Importarlegajofamiliads_7_tfmigrlegfamparen_sels, "MigrLegFamParen IN (", ")")+")");
      }
      if ( ( AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Importarlegajofamiliads_8_tfmigrlegfamnrodoc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamNroDoc) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Importarlegajofamiliads_9_tfmigrlegfamnrodoc_sels, "MigrLegFamNroDoc IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Importarlegajofamiliads_10_tfmigrlegfamdedgan)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Importarlegajofamiliads_11_tfmigrlegfamdedgan_to)==0) )
      {
         addWhere(sWhereString, "(MigrLegFamDedGan <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ( AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Importarlegajofamiliads_12_tfmigrlegfamadh)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MigrLegFamAdh) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Importarlegajofamiliads_13_tfmigrlegfamadh_sels, "MigrLegFamAdh IN (", ")")+")");
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
                  return conditional_H00M72(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() );
            case 1 :
                  return conditional_H00M73(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Boolean) dynConstraints[19]).booleanValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00M72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00M73", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               return;
      }
   }

}

