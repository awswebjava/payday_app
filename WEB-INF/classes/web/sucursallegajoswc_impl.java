package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sucursallegajoswc_impl extends GXWebComponent
{
   public sucursallegajoswc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sucursallegajoswc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sucursallegajoswc_impl.class ));
   }

   public sucursallegajoswc_impl( int remoteHandle ,
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
      cmbLegTipDoc = new HTMLChoice();
      cmbLegSexo = new HTMLChoice();
      cmbLegEstadoCivil = new HTMLChoice();
      cmbLegDiscapacidad = new HTMLChoice();
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
               AV10LegSucCodigo = httpContext.GetPar( "LegSucCodigo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegSucCodigo", AV10LegSucCodigo);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),AV10LegSucCodigo});
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
      AV10LegSucCodigo = httpContext.GetPar( "LegSucCodigo") ;
      AV27Pgmname = httpContext.GetPar( "Pgmname") ;
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
      gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LegSucCodigo, AV27Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paPL2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Sucursal Legajos WC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.sucursallegajoswc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV10LegSucCodigo))}, new String[] {"CliCod","EmpCod","LegSucCodigo"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV27Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_22", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_22, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV22GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV23GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV24GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10LegSucCodigo", GXutil.rtrim( wcpOAV10LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV27Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV27Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV16OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV17OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGSUCCODIGO", GXutil.rtrim( AV10LegSucCodigo));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
   }

   public void renderHtmlCloseFormPL2( )
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
      return "SucursalLegajosWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Sucursal Legajos WC", "") ;
   }

   public void wbPL0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.sucursallegajoswc");
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
         ucGridpaginationbar.setProperty("CurrentPage", AV22GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV23GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV24GridAppliedFilters);
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_SucursalLegajosWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_SucursalLegajosWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtLegSucCodigo_Internalname, GXutil.rtrim( A1577LegSucCodigo), GXutil.rtrim( localUtil.format( A1577LegSucCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegSucCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtLegSucCodigo_Visible, 0, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_SucursalLegajosWC.htm");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
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

   public void startPL2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Sucursal Legajos WC", ""), (short)(0)) ;
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
            strupPL0( ) ;
         }
      }
   }

   public void wsPL2( )
   {
      startPL2( ) ;
      evtPL2( ) ;
   }

   public void evtPL2( )
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
                              strupPL0( ) ;
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
                              strupPL0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11PL2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupPL0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12PL2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupPL0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13PL2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupPL0( ) ;
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
                              strupPL0( ) ;
                           }
                           nGXsfl_22_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_222( ) ;
                           A2EmpNom = GXutil.upper( httpContext.cgiGet( edtEmpNom_Internalname)) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A230LegApellido = httpContext.cgiGet( edtLegApellido_Internalname) ;
                           A251LegNombre = httpContext.cgiGet( edtLegNombre_Internalname) ;
                           A249LegFoto = httpContext.cgiGet( edtLegFoto_Internalname) ;
                           n249LegFoto = false ;
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "URL", httpContext.getResourceRelative(A249LegFoto), !bGXsfl_22_Refreshing);
                           cmbLegTipDoc.setName( cmbLegTipDoc.getInternalname() );
                           cmbLegTipDoc.setValue( httpContext.cgiGet( cmbLegTipDoc.getInternalname()) );
                           A266LegTipDoc = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegTipDoc.getInternalname()))) ;
                           A257LegNumDoc = GXutil.upper( httpContext.cgiGet( edtLegNumDoc_Internalname)) ;
                           A246LegFecNac = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegFecNac_Internalname), 0)) ;
                           cmbLegSexo.setName( cmbLegSexo.getInternalname() );
                           cmbLegSexo.setValue( httpContext.cgiGet( cmbLegSexo.getInternalname()) );
                           A263LegSexo = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegSexo.getInternalname()))) ;
                           n263LegSexo = false ;
                           cmbLegEstadoCivil.setName( cmbLegEstadoCivil.getInternalname() );
                           cmbLegEstadoCivil.setValue( httpContext.cgiGet( cmbLegEstadoCivil.getInternalname()) );
                           A243LegEstadoCivil = (short)(GXutil.lval( httpContext.cgiGet( cmbLegEstadoCivil.getInternalname()))) ;
                           n243LegEstadoCivil = false ;
                           A21LegNacionCod = (short)(localUtil.ctol( httpContext.cgiGet( edtLegNacionCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n21LegNacionCod = false ;
                           A256LegNacionalidad = GXutil.upper( httpContext.cgiGet( edtLegNacionalidad_Internalname)) ;
                           A239LegCUIL = localUtil.ctol( httpContext.cgiGet( edtLegCUIL_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           cmbLegDiscapacidad.setName( cmbLegDiscapacidad.getInternalname() );
                           cmbLegDiscapacidad.setValue( httpContext.cgiGet( cmbLegDiscapacidad.getInternalname()) );
                           A241LegDiscapacidad = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegDiscapacidad.getInternalname()))) ;
                           A242LegDomici = httpContext.cgiGet( edtLegDomici_Internalname) ;
                           A479LegEmail = httpContext.cgiGet( edtLegEmail_Internalname) ;
                           A236LegCodPos = GXutil.upper( httpContext.cgiGet( edtLegCodPos_Internalname)) ;
                           A22LegPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtLegPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n22LegPaiCod = false ;
                           A258LegPaiNom = GXutil.upper( httpContext.cgiGet( edtLegPaiNom_Internalname)) ;
                           A23LegProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtLegProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n23LegProvCod = false ;
                           A260LegProvNom = httpContext.cgiGet( edtLegProvNom_Internalname) ;
                           A24LegLocCod = (short)(localUtil.ctol( httpContext.cgiGet( edtLegLocCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n24LegLocCod = false ;
                           A255LegLocNom = GXutil.upper( httpContext.cgiGet( edtLegLocNom_Internalname)) ;
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
                                       e14PL2 ();
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
                                       e15PL2 ();
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
                                       e16PL2 ();
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
                                    strupPL0( ) ;
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

   public void wePL2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormPL2( ) ;
         }
      }
   }

   public void paPL2( )
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
                                 String AV10LegSucCodigo ,
                                 String AV27Pgmname ,
                                 short AV16OrderedBy ,
                                 boolean AV17OrderedDsc ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e15PL2 ();
      GRID_nCurrentRecord = 0 ;
      rfPL2( ) ;
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
      rfPL2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV27Pgmname = "SucursalLegajosWC" ;
      Gx_err = (short)(0) ;
   }

   public void rfPL2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(22) ;
      /* Execute user event: Refresh */
      e15PL2 ();
      nGXsfl_22_idx = 1 ;
      sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_222( ) ;
      bGXsfl_22_Refreshing = true ;
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
         subsflControlProps_222( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV16OrderedBy) ,
                                              Boolean.valueOf(AV17OrderedDsc) ,
                                              A1577LegSucCodigo ,
                                              AV10LegSucCodigo ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor H00PL2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), AV10LegSucCodigo, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_22_idx = 1 ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1030LegFotoNom = H00PL2_A1030LegFotoNom[0] ;
            edtLegFoto_Filename = A1030LegFotoNom ;
            A1031LegFotoExt = H00PL2_A1031LegFotoExt[0] ;
            edtLegFoto_Filetype = A1031LegFotoExt ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "Filetype", edtLegFoto_Filetype, !bGXsfl_22_Refreshing);
            A3CliCod = H00PL2_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = H00PL2_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1577LegSucCodigo = H00PL2_A1577LegSucCodigo[0] ;
            n1577LegSucCodigo = H00PL2_n1577LegSucCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1577LegSucCodigo", A1577LegSucCodigo);
            A255LegLocNom = H00PL2_A255LegLocNom[0] ;
            A24LegLocCod = H00PL2_A24LegLocCod[0] ;
            n24LegLocCod = H00PL2_n24LegLocCod[0] ;
            A260LegProvNom = H00PL2_A260LegProvNom[0] ;
            A23LegProvCod = H00PL2_A23LegProvCod[0] ;
            n23LegProvCod = H00PL2_n23LegProvCod[0] ;
            A258LegPaiNom = H00PL2_A258LegPaiNom[0] ;
            A22LegPaiCod = H00PL2_A22LegPaiCod[0] ;
            n22LegPaiCod = H00PL2_n22LegPaiCod[0] ;
            A236LegCodPos = H00PL2_A236LegCodPos[0] ;
            A479LegEmail = H00PL2_A479LegEmail[0] ;
            A242LegDomici = H00PL2_A242LegDomici[0] ;
            A241LegDiscapacidad = H00PL2_A241LegDiscapacidad[0] ;
            A239LegCUIL = H00PL2_A239LegCUIL[0] ;
            A256LegNacionalidad = H00PL2_A256LegNacionalidad[0] ;
            A21LegNacionCod = H00PL2_A21LegNacionCod[0] ;
            n21LegNacionCod = H00PL2_n21LegNacionCod[0] ;
            A243LegEstadoCivil = H00PL2_A243LegEstadoCivil[0] ;
            n243LegEstadoCivil = H00PL2_n243LegEstadoCivil[0] ;
            A263LegSexo = H00PL2_A263LegSexo[0] ;
            n263LegSexo = H00PL2_n263LegSexo[0] ;
            A246LegFecNac = H00PL2_A246LegFecNac[0] ;
            A257LegNumDoc = H00PL2_A257LegNumDoc[0] ;
            A266LegTipDoc = H00PL2_A266LegTipDoc[0] ;
            A249LegFoto = H00PL2_A249LegFoto[0] ;
            n249LegFoto = H00PL2_n249LegFoto[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "URL", httpContext.getResourceRelative(A249LegFoto), !bGXsfl_22_Refreshing);
            A251LegNombre = H00PL2_A251LegNombre[0] ;
            A230LegApellido = H00PL2_A230LegApellido[0] ;
            A6LegNumero = H00PL2_A6LegNumero[0] ;
            A2EmpNom = H00PL2_A2EmpNom[0] ;
            A2EmpNom = H00PL2_A2EmpNom[0] ;
            A258LegPaiNom = H00PL2_A258LegPaiNom[0] ;
            A260LegProvNom = H00PL2_A260LegProvNom[0] ;
            A255LegLocNom = H00PL2_A255LegLocNom[0] ;
            A256LegNacionalidad = H00PL2_A256LegNacionalidad[0] ;
            e16PL2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(22) ;
         wbPL0( ) ;
      }
      bGXsfl_22_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesPL2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV27Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV27Pgmname, ""))));
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
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) ,
                                           A1577LegSucCodigo ,
                                           AV10LegSucCodigo ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor H00PL3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), AV10LegSucCodigo});
      GRID_nRecordCount = H00PL3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LegSucCodigo, AV27Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LegSucCodigo, AV27Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LegSucCodigo, AV27Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LegSucCodigo, AV27Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV10LegSucCodigo, AV27Pgmname, AV16OrderedBy, AV17OrderedDsc, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV27Pgmname = "SucursalLegajosWC" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupPL0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14PL2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_22 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_22"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV22GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV23GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV24GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10LegSucCodigo = httpContext.cgiGet( sPrefix+"wcpOAV10LegSucCodigo") ;
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
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( sPrefix+"DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_get") ;
         /* Read variables values. */
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1577LegSucCodigo = httpContext.cgiGet( edtLegSucCodigo_Internalname) ;
         n1577LegSucCodigo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1577LegSucCodigo", A1577LegSucCodigo);
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
      e14PL2 ();
      if (returnInSub) return;
   }

   public void e14PL2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      sucursallegajoswc_impl.this.GXt_int1 = GXv_int2[0] ;
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
      edtLegSucCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegSucCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegSucCodigo_Visible), 5, 0), true);
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e15PL2( )
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
      sucursallegajoswc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV22GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GridCurrentPage), 10, 0));
      AV23GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GridPageCount), 10, 0));
      GXt_char6 = AV24GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV27Pgmname, GXv_char7) ;
      sucursallegajoswc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV24GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24GridAppliedFilters", AV24GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e11PL2( )
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
         AV21PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV21PageToGo) ;
      }
   }

   public void e12PL2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e13PL2( )
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
      /*  Sending Event outputs  */
   }

   private void e16PL2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
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
      if ( GXutil.strcmp(AV18Session.getValue(AV27Pgmname+"GridState"), "") == 0 )
      {
         AV14GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV27Pgmname+"GridState"), null, null);
      }
      else
      {
         AV14GridState.fromxml(AV18Session.getValue(AV27Pgmname+"GridState"), null, null);
      }
      AV16OrderedBy = AV14GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16OrderedBy), 4, 0));
      AV17OrderedDsc = AV14GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedDsc", AV17OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV14GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV14GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV14GridState.fromxml(AV18Session.getValue(AV27Pgmname+"GridState"), null, null);
      AV14GridState.setgxTv_SdtWWPGridState_Orderedby( AV16OrderedBy );
      AV14GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV17OrderedDsc );
      AV14GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV27Pgmname+"GridState", AV14GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV12TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV27Pgmname );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV12TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Legajos" );
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LegSucCodigo" );
      AV13TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV10LegSucCodigo );
      AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV13TrnContextAtt, 0);
      AV18Session.setValue("TrnContext", AV12TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8CliCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      AV9EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9EmpCod), 4, 0));
      AV10LegSucCodigo = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegSucCodigo", AV10LegSucCodigo);
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
      paPL2( ) ;
      wsPL2( ) ;
      wePL2( ) ;
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
      sCtrlAV10LegSucCodigo = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paPL2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "sucursallegajoswc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paPL2( ) ;
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
         AV10LegSucCodigo = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegSucCodigo", AV10LegSucCodigo);
      }
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10LegSucCodigo = httpContext.cgiGet( sPrefix+"wcpOAV10LegSucCodigo") ;
      if ( ! GetJustCreated( ) && ( ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( GXutil.strcmp(AV10LegSucCodigo, wcpOAV10LegSucCodigo) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV10LegSucCodigo = AV10LegSucCodigo ;
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
      sCtrlAV10LegSucCodigo = httpContext.cgiGet( sPrefix+"AV10LegSucCodigo_CTRL") ;
      if ( GXutil.len( sCtrlAV10LegSucCodigo) > 0 )
      {
         AV10LegSucCodigo = httpContext.cgiGet( sCtrlAV10LegSucCodigo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10LegSucCodigo", AV10LegSucCodigo);
      }
      else
      {
         AV10LegSucCodigo = httpContext.cgiGet( sPrefix+"AV10LegSucCodigo_PARM") ;
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
      paPL2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsPL2( ) ;
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
      wsPL2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LegSucCodigo_PARM", GXutil.rtrim( AV10LegSucCodigo));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10LegSucCodigo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10LegSucCodigo_CTRL", GXutil.rtrim( sCtrlAV10LegSucCodigo));
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
      wePL2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713584595", true, true);
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
      httpContext.AddJavascriptSource("sucursallegajoswc.js", "?20251713584595", false, true);
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

   public void subsflControlProps_222( )
   {
      edtEmpNom_Internalname = sPrefix+"EMPNOM_"+sGXsfl_22_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_22_idx ;
      edtLegApellido_Internalname = sPrefix+"LEGAPELLIDO_"+sGXsfl_22_idx ;
      edtLegNombre_Internalname = sPrefix+"LEGNOMBRE_"+sGXsfl_22_idx ;
      edtLegFoto_Internalname = sPrefix+"LEGFOTO_"+sGXsfl_22_idx ;
      edtLegFotoNom_Internalname = sPrefix+"LEGFOTONOM_"+sGXsfl_22_idx ;
      edtLegFotoExt_Internalname = sPrefix+"LEGFOTOEXT_"+sGXsfl_22_idx ;
      cmbLegTipDoc.setInternalname( sPrefix+"LEGTIPDOC_"+sGXsfl_22_idx );
      edtLegNumDoc_Internalname = sPrefix+"LEGNUMDOC_"+sGXsfl_22_idx ;
      edtLegFecNac_Internalname = sPrefix+"LEGFECNAC_"+sGXsfl_22_idx ;
      cmbLegSexo.setInternalname( sPrefix+"LEGSEXO_"+sGXsfl_22_idx );
      cmbLegEstadoCivil.setInternalname( sPrefix+"LEGESTADOCIVIL_"+sGXsfl_22_idx );
      edtLegNacionCod_Internalname = sPrefix+"LEGNACIONCOD_"+sGXsfl_22_idx ;
      edtLegNacionalidad_Internalname = sPrefix+"LEGNACIONALIDAD_"+sGXsfl_22_idx ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL_"+sGXsfl_22_idx ;
      cmbLegDiscapacidad.setInternalname( sPrefix+"LEGDISCAPACIDAD_"+sGXsfl_22_idx );
      edtLegDomici_Internalname = sPrefix+"LEGDOMICI_"+sGXsfl_22_idx ;
      edtLegEmail_Internalname = sPrefix+"LEGEMAIL_"+sGXsfl_22_idx ;
      edtLegCodPos_Internalname = sPrefix+"LEGCODPOS_"+sGXsfl_22_idx ;
      edtLegPaiCod_Internalname = sPrefix+"LEGPAICOD_"+sGXsfl_22_idx ;
      edtLegPaiNom_Internalname = sPrefix+"LEGPAINOM_"+sGXsfl_22_idx ;
      edtLegProvCod_Internalname = sPrefix+"LEGPROVCOD_"+sGXsfl_22_idx ;
      edtLegProvNom_Internalname = sPrefix+"LEGPROVNOM_"+sGXsfl_22_idx ;
      edtLegLocCod_Internalname = sPrefix+"LEGLOCCOD_"+sGXsfl_22_idx ;
      edtLegLocNom_Internalname = sPrefix+"LEGLOCNOM_"+sGXsfl_22_idx ;
   }

   public void subsflControlProps_fel_222( )
   {
      edtEmpNom_Internalname = sPrefix+"EMPNOM_"+sGXsfl_22_fel_idx ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_22_fel_idx ;
      edtLegApellido_Internalname = sPrefix+"LEGAPELLIDO_"+sGXsfl_22_fel_idx ;
      edtLegNombre_Internalname = sPrefix+"LEGNOMBRE_"+sGXsfl_22_fel_idx ;
      edtLegFoto_Internalname = sPrefix+"LEGFOTO_"+sGXsfl_22_fel_idx ;
      edtLegFotoNom_Internalname = sPrefix+"LEGFOTONOM_"+sGXsfl_22_fel_idx ;
      edtLegFotoExt_Internalname = sPrefix+"LEGFOTOEXT_"+sGXsfl_22_fel_idx ;
      cmbLegTipDoc.setInternalname( sPrefix+"LEGTIPDOC_"+sGXsfl_22_fel_idx );
      edtLegNumDoc_Internalname = sPrefix+"LEGNUMDOC_"+sGXsfl_22_fel_idx ;
      edtLegFecNac_Internalname = sPrefix+"LEGFECNAC_"+sGXsfl_22_fel_idx ;
      cmbLegSexo.setInternalname( sPrefix+"LEGSEXO_"+sGXsfl_22_fel_idx );
      cmbLegEstadoCivil.setInternalname( sPrefix+"LEGESTADOCIVIL_"+sGXsfl_22_fel_idx );
      edtLegNacionCod_Internalname = sPrefix+"LEGNACIONCOD_"+sGXsfl_22_fel_idx ;
      edtLegNacionalidad_Internalname = sPrefix+"LEGNACIONALIDAD_"+sGXsfl_22_fel_idx ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL_"+sGXsfl_22_fel_idx ;
      cmbLegDiscapacidad.setInternalname( sPrefix+"LEGDISCAPACIDAD_"+sGXsfl_22_fel_idx );
      edtLegDomici_Internalname = sPrefix+"LEGDOMICI_"+sGXsfl_22_fel_idx ;
      edtLegEmail_Internalname = sPrefix+"LEGEMAIL_"+sGXsfl_22_fel_idx ;
      edtLegCodPos_Internalname = sPrefix+"LEGCODPOS_"+sGXsfl_22_fel_idx ;
      edtLegPaiCod_Internalname = sPrefix+"LEGPAICOD_"+sGXsfl_22_fel_idx ;
      edtLegPaiNom_Internalname = sPrefix+"LEGPAINOM_"+sGXsfl_22_fel_idx ;
      edtLegProvCod_Internalname = sPrefix+"LEGPROVCOD_"+sGXsfl_22_fel_idx ;
      edtLegProvNom_Internalname = sPrefix+"LEGPROVNOM_"+sGXsfl_22_fel_idx ;
      edtLegLocCod_Internalname = sPrefix+"LEGLOCCOD_"+sGXsfl_22_fel_idx ;
      edtLegLocNom_Internalname = sPrefix+"LEGLOCNOM_"+sGXsfl_22_fel_idx ;
   }

   public void sendrow_222( )
   {
      subsflControlProps_222( ) ;
      wbPL0( ) ;
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
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_22_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpNom_Internalname,A2EmpNom,GXutil.rtrim( localUtil.format( A2EmpNom, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtEmpNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionLarga","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegApellido_Internalname,A230LegApellido,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegApellido_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNombre_Internalname,A251LegNombre,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         ClassString = "Attribute" ;
         StyleString = "" ;
         edtLegFoto_Filename = A1030LegFotoNom ;
         edtLegFoto_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "Filetype", edtLegFoto_Filetype, !bGXsfl_22_Refreshing);
         edtLegFoto_Filetype = A1031LegFotoExt ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "Filetype", edtLegFoto_Filetype, !bGXsfl_22_Refreshing);
         if ( ! (GXutil.strcmp("", A249LegFoto)==0) )
         {
            gxblobfileaux.setSource( A249LegFoto );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtLegFoto_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtLegFoto_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A249LegFoto = gxblobfileaux.getURI() ;
               n249LegFoto = false ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "URL", httpContext.getResourceRelative(A249LegFoto), !bGXsfl_22_Refreshing);
               edtLegFoto_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "Filetype", edtLegFoto_Filetype, !bGXsfl_22_Refreshing);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtLegFoto_Internalname, "URL", httpContext.getResourceRelative(A249LegFoto), !bGXsfl_22_Refreshing);
         }
         GridRow.AddColumnProperties("blob", 2, isAjaxCallMode( ), new Object[] {edtLegFoto_Internalname,GXutil.rtrim( A249LegFoto),httpContext.getResourceRelative(A249LegFoto),((GXutil.strcmp("", edtLegFoto_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtLegFoto_Filetype)==0) ? A249LegFoto : edtLegFoto_Filetype)) : edtLegFoto_Contenttype),Boolean.valueOf(true),"",edtLegFoto_Parameters,Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(60),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),edtLegFoto_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'",StyleString,ClassString,"WWColumn hidden-xs","",""+"","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegFotoNom_Internalname,A1030LegFotoNom,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegFotoNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegFotoExt_Internalname,GXutil.rtrim( A1031LegFotoExt),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegFotoExt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbLegTipDoc.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGTIPDOC_" + sGXsfl_22_idx ;
            cmbLegTipDoc.setName( GXCCtl );
            cmbLegTipDoc.setWebtags( "" );
            cmbLegTipDoc.addItem("0", httpContext.getMessage( "DNI", ""), (short)(0));
            cmbLegTipDoc.addItem("1", httpContext.getMessage( "LC", ""), (short)(0));
            cmbLegTipDoc.addItem("2", httpContext.getMessage( "LE", ""), (short)(0));
            cmbLegTipDoc.addItem("3", httpContext.getMessage( "Pasaporte", ""), (short)(0));
            cmbLegTipDoc.addItem("4", httpContext.getMessage( "Certif. de Migracion", ""), (short)(0));
            cmbLegTipDoc.addItem("5", httpContext.getMessage( "CI Provincial", ""), (short)(0));
            if ( cmbLegTipDoc.getItemCount() > 0 )
            {
               A266LegTipDoc = (byte)(GXutil.lval( cmbLegTipDoc.getValidValue(GXutil.trim( GXutil.str( A266LegTipDoc, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegTipDoc,cmbLegTipDoc.getInternalname(),GXutil.trim( GXutil.str( A266LegTipDoc, 1, 0)),Integer.valueOf(1),cmbLegTipDoc.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegTipDoc.setValue( GXutil.trim( GXutil.str( A266LegTipDoc, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegTipDoc.getInternalname(), "Values", cmbLegTipDoc.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumDoc_Internalname,A257LegNumDoc,GXutil.rtrim( localUtil.format( A257LegNumDoc, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNumDoc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionCorta","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegFecNac_Internalname,localUtil.format(A246LegFecNac, "99/99/9999"),localUtil.format( A246LegFecNac, "99/99/9999"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegFecNac_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbLegSexo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGSEXO_" + sGXsfl_22_idx ;
            cmbLegSexo.setName( GXCCtl );
            cmbLegSexo.setWebtags( "" );
            if ( cmbLegSexo.getItemCount() > 0 )
            {
               A263LegSexo = (byte)(GXutil.lval( cmbLegSexo.getValidValue(GXutil.trim( GXutil.str( A263LegSexo, 2, 0))))) ;
               n263LegSexo = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegSexo,cmbLegSexo.getInternalname(),GXutil.trim( GXutil.str( A263LegSexo, 2, 0)),Integer.valueOf(1),cmbLegSexo.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegSexo.setValue( GXutil.trim( GXutil.str( A263LegSexo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegSexo.getInternalname(), "Values", cmbLegSexo.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbLegEstadoCivil.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGESTADOCIVIL_" + sGXsfl_22_idx ;
            cmbLegEstadoCivil.setName( GXCCtl );
            cmbLegEstadoCivil.setWebtags( "" );
            if ( cmbLegEstadoCivil.getItemCount() > 0 )
            {
               A243LegEstadoCivil = (short)(GXutil.lval( cmbLegEstadoCivil.getValidValue(GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0))))) ;
               n243LegEstadoCivil = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegEstadoCivil,cmbLegEstadoCivil.getInternalname(),GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0)),Integer.valueOf(1),cmbLegEstadoCivil.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegEstadoCivil.setValue( GXutil.trim( GXutil.str( A243LegEstadoCivil, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegEstadoCivil.getInternalname(), "Values", cmbLegEstadoCivil.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNacionCod_Internalname,GXutil.ltrim( localUtil.ntoc( A21LegNacionCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A21LegNacionCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNacionCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNacionalidad_Internalname,A256LegNacionalidad,GXutil.rtrim( localUtil.format( A256LegNacionalidad, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNacionalidad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCUIL_Internalname,GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbLegDiscapacidad.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGDISCAPACIDAD_" + sGXsfl_22_idx ;
            cmbLegDiscapacidad.setName( GXCCtl );
            cmbLegDiscapacidad.setWebtags( "" );
            cmbLegDiscapacidad.addItem("0", httpContext.getMessage( "NO", ""), (short)(0));
            cmbLegDiscapacidad.addItem("1", httpContext.getMessage( "SI", ""), (short)(0));
            if ( cmbLegDiscapacidad.getItemCount() > 0 )
            {
               A241LegDiscapacidad = (byte)(GXutil.lval( cmbLegDiscapacidad.getValidValue(GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegDiscapacidad,cmbLegDiscapacidad.getInternalname(),GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0)),Integer.valueOf(1),cmbLegDiscapacidad.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegDiscapacidad.setValue( GXutil.trim( GXutil.str( A241LegDiscapacidad, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbLegDiscapacidad.getInternalname(), "Values", cmbLegDiscapacidad.ToJavascriptSource(), !bGXsfl_22_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDomici_Internalname,A242LegDomici,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegDomici_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"VarcharTextArea","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegEmail_Internalname,A479LegEmail,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","mailto:"+A479LegEmail,"","","",edtLegEmail_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"email","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Email","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCodPos_Internalname,GXutil.rtrim( A236LegCodPos),GXutil.rtrim( localUtil.format( A236LegCodPos, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegCodPos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoPostal","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegPaiCod_Internalname,GXutil.ltrim( localUtil.ntoc( A22LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A22LegPaiCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegPaiCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegPaiNom_Internalname,A258LegPaiNom,GXutil.rtrim( localUtil.format( A258LegPaiNom, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegPaiNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegProvCod_Internalname,GXutil.ltrim( localUtil.ntoc( A23LegProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A23LegProvCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegProvCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegProvNom_Internalname,A260LegProvNom,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegProvNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegLocCod_Internalname,GXutil.ltrim( localUtil.ntoc( A24LegLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A24LegLocCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegLocCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegLocNom_Internalname,A255LegLocNom,GXutil.rtrim( localUtil.format( A255LegLocNom, "@!")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegLocNom_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionLarga","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesPL2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Apellido", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nombres", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Foto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Foto Nom", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Foto Ext", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tip. Doc.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Documento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fec. Nac.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sexo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Est. Civil", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nacionalidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nacionalidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Discapacidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Domicilio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Email", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod. Pos.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pais L", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pais Leg", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Provincia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Provincia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Localidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Localidad", "")) ;
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
         GridColumn.AddObjectProperty("Value", A2EmpNom);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A230LegApellido);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A251LegNombre);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A249LegFoto);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1030LegFotoNom);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1031LegFotoExt));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A266LegTipDoc, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A257LegNumDoc);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A246LegFecNac, "99/99/9999"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A263LegSexo, (byte)(2), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A243LegEstadoCivil, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A21LegNacionCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A256LegNacionalidad);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A241LegDiscapacidad, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A242LegDomici);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A479LegEmail);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A236LegCodPos));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A22LegPaiCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A258LegPaiNom);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A23LegProvCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A260LegProvNom);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A24LegLocCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A255LegLocNom);
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
      divTableactions_Internalname = sPrefix+"TABLEACTIONS" ;
      divTableheadercontent_Internalname = sPrefix+"TABLEHEADERCONTENT" ;
      divTableheader_Internalname = sPrefix+"TABLEHEADER" ;
      edtEmpNom_Internalname = sPrefix+"EMPNOM" ;
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtLegApellido_Internalname = sPrefix+"LEGAPELLIDO" ;
      edtLegNombre_Internalname = sPrefix+"LEGNOMBRE" ;
      edtLegFoto_Internalname = sPrefix+"LEGFOTO" ;
      edtLegFotoNom_Internalname = sPrefix+"LEGFOTONOM" ;
      edtLegFotoExt_Internalname = sPrefix+"LEGFOTOEXT" ;
      cmbLegTipDoc.setInternalname( sPrefix+"LEGTIPDOC" );
      edtLegNumDoc_Internalname = sPrefix+"LEGNUMDOC" ;
      edtLegFecNac_Internalname = sPrefix+"LEGFECNAC" ;
      cmbLegSexo.setInternalname( sPrefix+"LEGSEXO" );
      cmbLegEstadoCivil.setInternalname( sPrefix+"LEGESTADOCIVIL" );
      edtLegNacionCod_Internalname = sPrefix+"LEGNACIONCOD" ;
      edtLegNacionalidad_Internalname = sPrefix+"LEGNACIONALIDAD" ;
      edtLegCUIL_Internalname = sPrefix+"LEGCUIL" ;
      cmbLegDiscapacidad.setInternalname( sPrefix+"LEGDISCAPACIDAD" );
      edtLegDomici_Internalname = sPrefix+"LEGDOMICI" ;
      edtLegEmail_Internalname = sPrefix+"LEGEMAIL" ;
      edtLegCodPos_Internalname = sPrefix+"LEGCODPOS" ;
      edtLegPaiCod_Internalname = sPrefix+"LEGPAICOD" ;
      edtLegPaiNom_Internalname = sPrefix+"LEGPAINOM" ;
      edtLegProvCod_Internalname = sPrefix+"LEGPROVCOD" ;
      edtLegProvNom_Internalname = sPrefix+"LEGPROVNOM" ;
      edtLegLocCod_Internalname = sPrefix+"LEGLOCCOD" ;
      edtLegLocNom_Internalname = sPrefix+"LEGLOCNOM" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      edtLegSucCodigo_Internalname = sPrefix+"LEGSUCCODIGO" ;
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
      edtLegLocNom_Jsonclick = "" ;
      edtLegLocCod_Jsonclick = "" ;
      edtLegProvNom_Jsonclick = "" ;
      edtLegProvCod_Jsonclick = "" ;
      edtLegPaiNom_Jsonclick = "" ;
      edtLegPaiCod_Jsonclick = "" ;
      edtLegCodPos_Jsonclick = "" ;
      edtLegEmail_Jsonclick = "" ;
      edtLegDomici_Jsonclick = "" ;
      cmbLegDiscapacidad.setJsonclick( "" );
      edtLegCUIL_Jsonclick = "" ;
      edtLegNacionalidad_Jsonclick = "" ;
      edtLegNacionCod_Jsonclick = "" ;
      cmbLegEstadoCivil.setJsonclick( "" );
      cmbLegSexo.setJsonclick( "" );
      edtLegFecNac_Jsonclick = "" ;
      edtLegNumDoc_Jsonclick = "" ;
      cmbLegTipDoc.setJsonclick( "" );
      edtLegFotoExt_Jsonclick = "" ;
      edtLegFotoNom_Jsonclick = "" ;
      edtLegFoto_Jsonclick = "" ;
      edtLegFoto_Parameters = "" ;
      edtLegFoto_Contenttype = "" ;
      edtLegNombre_Jsonclick = "" ;
      edtLegApellido_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpNom_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtLegFoto_Filetype = "" ;
      subGrid_Sortable = (byte)(0) ;
      edtLegSucCodigo_Jsonclick = "" ;
      edtLegSucCodigo_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22" ;
      Ddo_grid_Columnids = "0:EmpNom|1:LegNumero|2:LegApellido|3:LegNombre|7:LegTipDoc|8:LegNumDoc|9:LegFecNac|10:LegSexo|11:LegEstadoCivil|12:LegNacionCod|13:LegNacionalidad|14:LegCUIL|15:LegDiscapacidad|16:LegDomici|17:LegEmail|18:LegCodPos|19:LegPaiCod|20:LegPaiNom|21:LegProvCod|22:LegProvNom|23:LegLocCod|24:LegLocNom" ;
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
      GXCCtl = "LEGTIPDOC_" + sGXsfl_22_idx ;
      cmbLegTipDoc.setName( GXCCtl );
      cmbLegTipDoc.setWebtags( "" );
      cmbLegTipDoc.addItem("0", httpContext.getMessage( "DNI", ""), (short)(0));
      cmbLegTipDoc.addItem("1", httpContext.getMessage( "LC", ""), (short)(0));
      cmbLegTipDoc.addItem("2", httpContext.getMessage( "LE", ""), (short)(0));
      cmbLegTipDoc.addItem("3", httpContext.getMessage( "Pasaporte", ""), (short)(0));
      cmbLegTipDoc.addItem("4", httpContext.getMessage( "Certif. de Migracion", ""), (short)(0));
      cmbLegTipDoc.addItem("5", httpContext.getMessage( "CI Provincial", ""), (short)(0));
      if ( cmbLegTipDoc.getItemCount() > 0 )
      {
      }
      GXCCtl = "LEGSEXO_" + sGXsfl_22_idx ;
      cmbLegSexo.setName( GXCCtl );
      cmbLegSexo.setWebtags( "" );
      if ( cmbLegSexo.getItemCount() > 0 )
      {
      }
      GXCCtl = "LEGESTADOCIVIL_" + sGXsfl_22_idx ;
      cmbLegEstadoCivil.setName( GXCCtl );
      cmbLegEstadoCivil.setWebtags( "" );
      if ( cmbLegEstadoCivil.getItemCount() > 0 )
      {
      }
      GXCCtl = "LEGDISCAPACIDAD_" + sGXsfl_22_idx ;
      cmbLegDiscapacidad.setName( GXCCtl );
      cmbLegDiscapacidad.setWebtags( "" );
      cmbLegDiscapacidad.addItem("0", httpContext.getMessage( "NO", ""), (short)(0));
      cmbLegDiscapacidad.addItem("1", httpContext.getMessage( "SI", ""), (short)(0));
      if ( cmbLegDiscapacidad.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV27Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV22GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV23GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV24GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e11PL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'AV27Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12PL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'AV27Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e13PL2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV10LegSucCodigo',fld:'vLEGSUCCODIGO',pic:''},{av:'AV27Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV16OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV17OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e16PL2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNACIONCOD","{handler:'valid_Legnacioncod',iparms:[]");
      setEventMetadata("VALID_LEGNACIONCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGPAICOD","{handler:'valid_Legpaicod',iparms:[]");
      setEventMetadata("VALID_LEGPAICOD",",oparms:[]}");
      setEventMetadata("VALID_LEGPROVCOD","{handler:'valid_Legprovcod',iparms:[]");
      setEventMetadata("VALID_LEGPROVCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGLOCCOD","{handler:'valid_Legloccod',iparms:[]");
      setEventMetadata("VALID_LEGLOCCOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Leglocnom',iparms:[]");
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
      wcpOAV10LegSucCodigo = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV10LegSucCodigo = "" ;
      AV27Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV24GridAppliedFilters = "" ;
      AV19DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      A1577LegSucCodigo = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A2EmpNom = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A249LegFoto = "" ;
      A257LegNumDoc = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A256LegNacionalidad = "" ;
      A242LegDomici = "" ;
      A479LegEmail = "" ;
      A236LegCodPos = "" ;
      A258LegPaiNom = "" ;
      A260LegProvNom = "" ;
      A255LegLocNom = "" ;
      scmdbuf = "" ;
      H00PL2_A1030LegFotoNom = new String[] {""} ;
      H00PL2_A1031LegFotoExt = new String[] {""} ;
      H00PL2_A3CliCod = new int[1] ;
      H00PL2_A1EmpCod = new short[1] ;
      H00PL2_A1577LegSucCodigo = new String[] {""} ;
      H00PL2_n1577LegSucCodigo = new boolean[] {false} ;
      H00PL2_A255LegLocNom = new String[] {""} ;
      H00PL2_A24LegLocCod = new short[1] ;
      H00PL2_n24LegLocCod = new boolean[] {false} ;
      H00PL2_A260LegProvNom = new String[] {""} ;
      H00PL2_A23LegProvCod = new short[1] ;
      H00PL2_n23LegProvCod = new boolean[] {false} ;
      H00PL2_A258LegPaiNom = new String[] {""} ;
      H00PL2_A22LegPaiCod = new short[1] ;
      H00PL2_n22LegPaiCod = new boolean[] {false} ;
      H00PL2_A236LegCodPos = new String[] {""} ;
      H00PL2_A479LegEmail = new String[] {""} ;
      H00PL2_A242LegDomici = new String[] {""} ;
      H00PL2_A241LegDiscapacidad = new byte[1] ;
      H00PL2_A239LegCUIL = new long[1] ;
      H00PL2_A256LegNacionalidad = new String[] {""} ;
      H00PL2_A21LegNacionCod = new short[1] ;
      H00PL2_n21LegNacionCod = new boolean[] {false} ;
      H00PL2_A243LegEstadoCivil = new short[1] ;
      H00PL2_n243LegEstadoCivil = new boolean[] {false} ;
      H00PL2_A263LegSexo = new byte[1] ;
      H00PL2_n263LegSexo = new boolean[] {false} ;
      H00PL2_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H00PL2_A257LegNumDoc = new String[] {""} ;
      H00PL2_A266LegTipDoc = new byte[1] ;
      H00PL2_A249LegFoto = new String[] {""} ;
      H00PL2_n249LegFoto = new boolean[] {false} ;
      H00PL2_A251LegNombre = new String[] {""} ;
      H00PL2_A230LegApellido = new String[] {""} ;
      H00PL2_A6LegNumero = new int[1] ;
      H00PL2_A2EmpNom = new String[] {""} ;
      A1030LegFotoNom = "" ;
      edtLegFoto_Filename = "" ;
      A1031LegFotoExt = "" ;
      H00PL3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV18Session = httpContext.getWebSession();
      AV14GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV10LegSucCodigo = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sucursallegajoswc__default(),
         new Object[] {
             new Object[] {
            H00PL2_A1030LegFotoNom, H00PL2_A1031LegFotoExt, H00PL2_A3CliCod, H00PL2_A1EmpCod, H00PL2_A1577LegSucCodigo, H00PL2_n1577LegSucCodigo, H00PL2_A255LegLocNom, H00PL2_A24LegLocCod, H00PL2_n24LegLocCod, H00PL2_A260LegProvNom,
            H00PL2_A23LegProvCod, H00PL2_n23LegProvCod, H00PL2_A258LegPaiNom, H00PL2_A22LegPaiCod, H00PL2_n22LegPaiCod, H00PL2_A236LegCodPos, H00PL2_A479LegEmail, H00PL2_A242LegDomici, H00PL2_A241LegDiscapacidad, H00PL2_A239LegCUIL,
            H00PL2_A256LegNacionalidad, H00PL2_A21LegNacionCod, H00PL2_n21LegNacionCod, H00PL2_A243LegEstadoCivil, H00PL2_n243LegEstadoCivil, H00PL2_A263LegSexo, H00PL2_n263LegSexo, H00PL2_A246LegFecNac, H00PL2_A257LegNumDoc, H00PL2_A266LegTipDoc,
            H00PL2_A249LegFoto, H00PL2_n249LegFoto, H00PL2_A251LegNombre, H00PL2_A230LegApellido, H00PL2_A6LegNumero, H00PL2_A2EmpNom
            }
            , new Object[] {
            H00PL3_AGRID_nRecordCount
            }
         }
      );
      AV27Pgmname = "SucursalLegajosWC" ;
      /* GeneXus formulas. */
      AV27Pgmname = "SucursalLegajosWC" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A266LegTipDoc ;
   private byte A263LegSexo ;
   private byte A241LegDiscapacidad ;
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
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A243LegEstadoCivil ;
   private short A21LegNacionCod ;
   private short A22LegPaiCod ;
   private short A23LegProvCod ;
   private short A24LegLocCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV8CliCod ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_22 ;
   private int AV8CliCod ;
   private int nGXsfl_22_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int edtCliCod_Visible ;
   private int edtEmpCod_Visible ;
   private int edtLegSucCodigo_Visible ;
   private int A6LegNumero ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV21PageToGo ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV22GridCurrentPage ;
   private long AV23GridPageCount ;
   private long A239LegCUIL ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String wcpOAV10LegSucCodigo ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV10LegSucCodigo ;
   private String sGXsfl_22_idx="0001" ;
   private String AV27Pgmname ;
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
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablegridheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
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
   private String edtLegSucCodigo_Internalname ;
   private String A1577LegSucCodigo ;
   private String edtLegSucCodigo_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtEmpNom_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtLegApellido_Internalname ;
   private String edtLegNombre_Internalname ;
   private String edtLegFoto_Internalname ;
   private String edtLegNumDoc_Internalname ;
   private String edtLegFecNac_Internalname ;
   private String edtLegNacionCod_Internalname ;
   private String edtLegNacionalidad_Internalname ;
   private String edtLegCUIL_Internalname ;
   private String edtLegDomici_Internalname ;
   private String edtLegEmail_Internalname ;
   private String A236LegCodPos ;
   private String edtLegCodPos_Internalname ;
   private String edtLegPaiCod_Internalname ;
   private String edtLegPaiNom_Internalname ;
   private String edtLegProvCod_Internalname ;
   private String edtLegProvNom_Internalname ;
   private String edtLegLocCod_Internalname ;
   private String edtLegLocNom_Internalname ;
   private String scmdbuf ;
   private String edtLegFoto_Filename ;
   private String A1031LegFotoExt ;
   private String edtLegFoto_Filetype ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV10LegSucCodigo ;
   private String edtLegFotoNom_Internalname ;
   private String edtLegFotoExt_Internalname ;
   private String sGXsfl_22_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtEmpNom_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegApellido_Jsonclick ;
   private String edtLegNombre_Jsonclick ;
   private String edtLegFoto_Contenttype ;
   private String edtLegFoto_Parameters ;
   private String edtLegFoto_Jsonclick ;
   private String edtLegFotoNom_Jsonclick ;
   private String edtLegFotoExt_Jsonclick ;
   private String GXCCtl ;
   private String edtLegNumDoc_Jsonclick ;
   private String edtLegFecNac_Jsonclick ;
   private String edtLegNacionCod_Jsonclick ;
   private String edtLegNacionalidad_Jsonclick ;
   private String edtLegCUIL_Jsonclick ;
   private String edtLegDomici_Jsonclick ;
   private String edtLegEmail_Jsonclick ;
   private String edtLegCodPos_Jsonclick ;
   private String edtLegPaiCod_Jsonclick ;
   private String edtLegPaiNom_Jsonclick ;
   private String edtLegProvCod_Jsonclick ;
   private String edtLegProvNom_Jsonclick ;
   private String edtLegLocCod_Jsonclick ;
   private String edtLegLocNom_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A246LegFecNac ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17OrderedDsc ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n249LegFoto ;
   private boolean bGXsfl_22_Refreshing=false ;
   private boolean n263LegSexo ;
   private boolean n243LegEstadoCivil ;
   private boolean n21LegNacionCod ;
   private boolean n22LegPaiCod ;
   private boolean n23LegProvCod ;
   private boolean n24LegLocCod ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1577LegSucCodigo ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A249LegFoto ;
   private String AV24GridAppliedFilters ;
   private String A2EmpNom ;
   private String A230LegApellido ;
   private String A251LegNombre ;
   private String A257LegNumDoc ;
   private String A256LegNacionalidad ;
   private String A242LegDomici ;
   private String A479LegEmail ;
   private String A258LegPaiNom ;
   private String A260LegProvNom ;
   private String A255LegLocNom ;
   private String A1030LegFotoNom ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice cmbLegTipDoc ;
   private HTMLChoice cmbLegSexo ;
   private HTMLChoice cmbLegEstadoCivil ;
   private HTMLChoice cmbLegDiscapacidad ;
   private IDataStoreProvider pr_default ;
   private String[] H00PL2_A1030LegFotoNom ;
   private String[] H00PL2_A1031LegFotoExt ;
   private int[] H00PL2_A3CliCod ;
   private short[] H00PL2_A1EmpCod ;
   private String[] H00PL2_A1577LegSucCodigo ;
   private boolean[] H00PL2_n1577LegSucCodigo ;
   private String[] H00PL2_A255LegLocNom ;
   private short[] H00PL2_A24LegLocCod ;
   private boolean[] H00PL2_n24LegLocCod ;
   private String[] H00PL2_A260LegProvNom ;
   private short[] H00PL2_A23LegProvCod ;
   private boolean[] H00PL2_n23LegProvCod ;
   private String[] H00PL2_A258LegPaiNom ;
   private short[] H00PL2_A22LegPaiCod ;
   private boolean[] H00PL2_n22LegPaiCod ;
   private String[] H00PL2_A236LegCodPos ;
   private String[] H00PL2_A479LegEmail ;
   private String[] H00PL2_A242LegDomici ;
   private byte[] H00PL2_A241LegDiscapacidad ;
   private long[] H00PL2_A239LegCUIL ;
   private String[] H00PL2_A256LegNacionalidad ;
   private short[] H00PL2_A21LegNacionCod ;
   private boolean[] H00PL2_n21LegNacionCod ;
   private short[] H00PL2_A243LegEstadoCivil ;
   private boolean[] H00PL2_n243LegEstadoCivil ;
   private byte[] H00PL2_A263LegSexo ;
   private boolean[] H00PL2_n263LegSexo ;
   private java.util.Date[] H00PL2_A246LegFecNac ;
   private String[] H00PL2_A257LegNumDoc ;
   private byte[] H00PL2_A266LegTipDoc ;
   private String[] H00PL2_A249LegFoto ;
   private boolean[] H00PL2_n249LegFoto ;
   private String[] H00PL2_A251LegNombre ;
   private String[] H00PL2_A230LegApellido ;
   private int[] H00PL2_A6LegNumero ;
   private String[] H00PL2_A2EmpNom ;
   private long[] H00PL3_AGRID_nRecordCount ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV14GridState ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class sucursallegajoswc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00PL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          String A1577LegSucCodigo ,
                                          String AV10LegSucCodigo ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.LegFotoNom, T1.LegFotoExt, T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T5.LocNom AS LegLocNom, T1.LegLocCod AS LegLocCod, T4.ProvNom AS LegProvNom, T1.LegProvCod" ;
      sSelectString += " AS LegProvCod, T3.PaiNom AS LegPaiNom, T1.LegPaiCod AS LegPaiCod, T1.LegCodPos, T1.LegEmail, T1.LegDomici, T1.LegDiscapacidad, T1.LegCUIL, T6.PaiNom AS LegNacionalidad," ;
      sSelectString += " T1.LegNacionCod AS LegNacionCod, T1.LegEstadoCivil, T1.LegSexo, T1.LegFecNac, T1.LegNumDoc, T1.LegTipDoc, T1.LegFoto, T1.LegNombre, T1.LegApellido, T1.LegNumero," ;
      sSelectString += " T2.EmpNom" ;
      sFromString = " FROM (((((Legajo T1 INNER JOIN Empresa T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod) LEFT JOIN Pais T3 ON T3.PaiCod = T1.LegPaiCod) LEFT JOIN Provincia" ;
      sFromString += " T4 ON T4.PaiCod = T1.LegPaiCod AND T4.ProvCod = T1.LegProvCod) LEFT JOIN Localidad T5 ON T5.PaiCod = T1.LegPaiCod AND T5.ProvCod = T1.LegProvCod AND T5.LocCod =" ;
      sFromString += " T1.LegLocCod) LEFT JOIN Pais T6 ON T6.PaiCod = T1.LegNacionCod)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LegSucCodigo = ( ?))");
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T2.EmpNom, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T2.EmpNom DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegNumero DESC" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegApellido, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegApellido DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegNombre, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegNombre DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegTipDoc, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegTipDoc DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegNumDoc, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 6 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegNumDoc DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegFecNac, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 7 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegFecNac DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegSexo, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 8 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegSexo DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 9 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegEstadoCivil, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 9 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegEstadoCivil DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 10 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegNacionCod, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 10 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegNacionCod DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 11 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T6.PaiNom, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 11 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T6.PaiNom DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 12 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegCUIL, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 12 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegCUIL DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 13 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegDiscapacidad, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 13 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegDiscapacidad DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 14 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegDomici, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 14 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegDomici DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 15 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegEmail, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 15 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegEmail DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 16 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegCodPos, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 16 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegCodPos DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 17 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegPaiCod, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 17 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegPaiCod DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 18 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T3.PaiNom, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 18 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T3.PaiNom DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 19 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegProvCod, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 19 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegProvCod DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 20 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T4.ProvNom, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 20 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T4.ProvNom DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 21 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T1.LegLocCod, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 21 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T1.LegLocCod DESC, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 22 ) && ! AV17OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegSucCodigo, T5.LocNom, T1.LegNumero" ;
      }
      else if ( ( AV16OrderedBy == 22 ) && ( AV17OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.LegSucCodigo DESC, T5.LocNom DESC, T1.LegNumero" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_H00PL3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc ,
                                          String A1577LegSucCodigo ,
                                          String AV10LegSucCodigo ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[3];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (((((Legajo T1 INNER JOIN Empresa T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod) LEFT JOIN Pais T5 ON T5.PaiCod = T1.LegPaiCod) LEFT" ;
      scmdbuf += " JOIN Provincia T6 ON T6.PaiCod = T1.LegPaiCod AND T6.ProvCod = T1.LegProvCod) LEFT JOIN Localidad T3 ON T3.PaiCod = T1.LegPaiCod AND T3.ProvCod = T1.LegProvCod" ;
      scmdbuf += " AND T3.LocCod = T1.LegLocCod) LEFT JOIN Pais T4 ON T4.PaiCod = T1.LegNacionCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LegSucCodigo = ( ?))");
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
      else if ( ( AV16OrderedBy == 11 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 11 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 12 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 12 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 13 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 13 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 14 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 14 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 15 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 15 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 16 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 16 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 17 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 17 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 18 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 18 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 19 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 19 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 20 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 20 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 21 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 21 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 22 ) && ! AV17OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV16OrderedBy == 22 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_H00PL2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
            case 1 :
                  return conditional_H00PL3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00PL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00PL3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((short[]) buf[13])[0] = rslt.getShort(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(12, 20);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((byte[]) buf[18])[0] = rslt.getByte(15);
               ((long[]) buf[19])[0] = rslt.getLong(16);
               ((String[]) buf[20])[0] = rslt.getVarchar(17);
               ((short[]) buf[21])[0] = rslt.getShort(18);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((short[]) buf[23])[0] = rslt.getShort(19);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((byte[]) buf[25])[0] = rslt.getByte(20);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[27])[0] = rslt.getGXDate(21);
               ((String[]) buf[28])[0] = rslt.getVarchar(22);
               ((byte[]) buf[29])[0] = rslt.getByte(23);
               ((String[]) buf[30])[0] = rslt.getBLOBFile(24, rslt.getString(2, 20), rslt.getVarchar(1));
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(25);
               ((String[]) buf[33])[0] = rslt.getVarchar(26);
               ((int[]) buf[34])[0] = rslt.getInt(27);
               ((String[]) buf[35])[0] = rslt.getVarchar(28);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               return;
      }
   }

}

