package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357cabf1357legdedgenwc_impl extends GXWebComponent
{
   public f1357cabf1357legdedgenwc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357cabf1357legdedgenwc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357cabf1357legdedgenwc_impl.class ));
   }

   public f1357cabf1357legdedgenwc_impl( int remoteHandle ,
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
      cmbF1357CTipoPre = new HTMLChoice();
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
               AV40F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40F1357CTipoPre", GXutil.str( AV40F1357CTipoPre, 1, 0));
               AV10F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10F1357CPer", AV10F1357CPer);
               AV11F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11F1357CSec), 2, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV8CliCod),Short.valueOf(AV9EmpCod),Byte.valueOf(AV40F1357CTipoPre),AV10F1357CPer,Byte.valueOf(AV11F1357CSec)});
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
      AV40F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
      AV10F1357CPer = httpContext.GetPar( "F1357CPer") ;
      AV11F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
      AV43Pgmname = httpContext.GetPar( "Pgmname") ;
      AV17OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV18OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV37TFLegIdNomApe = httpContext.GetPar( "TFLegIdNomApe") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38TFLegIdNomApe_Sels);
      AV31TFF1357LDGDescuentosLey = httpContext.GetPar( "TFF1357LDGDescuentosLey") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32TFF1357LDGDescuentosLey_Sels);
      AV34TFF1357LDGOtrDescuLey = httpContext.GetPar( "TFF1357LDGOtrDescuLey") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35TFF1357LDGOtrDescuLey_Sels);
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV40F1357CTipoPre, AV10F1357CPer, AV11F1357CSec, AV43Pgmname, AV17OrderedBy, AV18OrderedDsc, AV37TFLegIdNomApe, AV38TFLegIdNomApe_Sels, AV31TFF1357LDGDescuentosLey, AV32TFF1357LDGDescuentosLey_Sels, AV34TFF1357LDGOtrDescuLey, AV35TFF1357LDGOtrDescuLey_Sels, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa9L2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "F1357 Cab F1357 Leg Ded Gen WC", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357cabf1357legdedgenwc", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV40F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(AV10F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(AV11F1357CSec,2,0))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV43Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_22", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_22, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV40F1357CTipoPre", GXutil.ltrim( localUtil.ntoc( wcpOAV40F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV10F1357CPer", GXutil.rtrim( wcpOAV10F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11F1357CSec", GXutil.ltrim( localUtil.ntoc( wcpOAV11F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV43Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV43Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV17OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV18OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFLEGIDNOMAPE", AV37TFLegIdNomApe);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFLEGIDNOMAPE_SELS", AV38TFLegIdNomApe_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFLEGIDNOMAPE_SELS", AV38TFLegIdNomApe_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFF1357LDGDESCUENTOSLEY", AV31TFF1357LDGDescuentosLey);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFF1357LDGDESCUENTOSLEY_SELS", AV32TFF1357LDGDescuentosLey_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFF1357LDGDESCUENTOSLEY_SELS", AV32TFF1357LDGDescuentosLey_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFF1357LDGOTRDESCULEY", AV34TFF1357LDGOtrDescuLey);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFF1357LDGOTRDESCULEY_SELS", AV35TFF1357LDGOtrDescuLey_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFF1357LDGOTRDESCULEY_SELS", AV35TFF1357LDGOtrDescuLey_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV8CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV9EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vF1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( AV40F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vF1357CPER", GXutil.rtrim( AV10F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vF1357CSEC", GXutil.ltrim( localUtil.ntoc( AV11F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
   }

   public void renderHtmlCloseForm9L2( )
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
      return "F1357CabF1357LegDedGenWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "F1357 Cab F1357 Leg Ded Gen WC", "") ;
   }

   public void wb9L0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.f1357cabf1357legdedgenwc");
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
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV20DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357CabF1357LegDedGenWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_F1357CabF1357LegDedGenWC.htm");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbF1357CTipoPre, cmbF1357CTipoPre.getInternalname(), GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)), 1, cmbF1357CTipoPre.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbF1357CTipoPre.getVisible(), 0, 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_F1357CabF1357LegDedGenWC.htm");
         cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbF1357CTipoPre.getInternalname(), "Values", cmbF1357CTipoPre.ToJavascriptSource(), true);
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CPer_Internalname, GXutil.rtrim( A777F1357CPer), GXutil.rtrim( localUtil.format( A777F1357CPer, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CPer_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CPer_Visible, 0, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_F1357CabF1357LegDedGenWC.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357CSec_Internalname, GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A778F1357CSec), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357CSec_Jsonclick, 0, "Attribute", "", "", "", "", edtF1357CSec_Visible, 0, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_F1357CabF1357LegDedGenWC.htm");
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

   public void start9L2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "F1357 Cab F1357 Leg Ded Gen WC", ""), (short)(0)) ;
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
            strup9L0( ) ;
         }
      }
   }

   public void ws9L2( )
   {
      start9L2( ) ;
      evt9L2( ) ;
   }

   public void evt9L2( )
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
                              strup9L0( ) ;
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
                              strup9L0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e119L2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup9L0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e129L2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup9L0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e139L2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup9L0( ) ;
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
                              strup9L0( ) ;
                           }
                           nGXsfl_22_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_222( ) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
                           A863F1357LDGTipReg = httpContext.cgiGet( edtF1357LDGTipReg_Internalname) ;
                           A802F1357LDGPrepaga = localUtil.ctond( httpContext.cgiGet( edtF1357LDGPrepaga_Internalname)) ;
                           A803F1357LDGSeguro = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguro_Internalname)) ;
                           A804F1357LDGSeguMixto = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSeguMixto_Internalname)) ;
                           A805F1357LDGRetPriv = localUtil.ctond( httpContext.cgiGet( edtF1357LDGRetPriv_Internalname)) ;
                           A806F1357LDGCuotapartes = localUtil.ctond( httpContext.cgiGet( edtF1357LDGCuotapartes_Internalname)) ;
                           A807F1357LDGSepelio = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSepelio_Internalname)) ;
                           A808F1357LDGRodado = localUtil.ctond( httpContext.cgiGet( edtF1357LDGRodado_Internalname)) ;
                           A809F1357LDGDonaciones = localUtil.ctond( httpContext.cgiGet( edtF1357LDGDonaciones_Internalname)) ;
                           A810F1357LDGOblig = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOblig_Internalname)) ;
                           A811F1357LDGMed = localUtil.ctond( httpContext.cgiGet( edtF1357LDGMed_Internalname)) ;
                           A812F1357LDGHipoteca = localUtil.ctond( httpContext.cgiGet( edtF1357LDGHipoteca_Internalname)) ;
                           A813F1357LDGSGR = localUtil.ctond( httpContext.cgiGet( edtF1357LDGSGR_Internalname)) ;
                           A814F1357LDGOtrasCaja = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasCaja_Internalname)) ;
                           A815F1357LDGAlquiler = localUtil.ctond( httpContext.cgiGet( edtF1357LDGAlquiler_Internalname)) ;
                           A816F1357LDGDomes = localUtil.ctond( httpContext.cgiGet( edtF1357LDGDomes_Internalname)) ;
                           A817F1357LDGViaticos = localUtil.ctond( httpContext.cgiGet( edtF1357LDGViaticos_Internalname)) ;
                           A818F1357LDGIndu = localUtil.ctond( httpContext.cgiGet( edtF1357LDGIndu_Internalname)) ;
                           A819F1357LDGOtras = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtras_Internalname)) ;
                           A820F1357LDGTotal = localUtil.ctond( httpContext.cgiGet( edtF1357LDGTotal_Internalname)) ;
                           A821F1357LDGOtrasAnses = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasAnses_Internalname)) ;
                           A822F1357LDGOtrasProf = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasProf_Internalname)) ;
                           A823F1357LDGOtrasActores = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasActores_Internalname)) ;
                           A824F1357LDGOtrasPrev = localUtil.ctond( httpContext.cgiGet( edtF1357LDGOtrasPrev_Internalname)) ;
                           A825F1357LDGDescuentosLey = httpContext.cgiGet( edtF1357LDGDescuentosLey_Internalname) ;
                           A826F1357LDGOtrDescuLey = httpContext.cgiGet( edtF1357LDGOtrDescuLey_Internalname) ;
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
                                       e149L2 ();
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
                                       e159L2 ();
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
                                       e169L2 ();
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
                                    strup9L0( ) ;
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

   public void we9L2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm9L2( ) ;
         }
      }
   }

   public void pa9L2( )
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
                                 byte AV40F1357CTipoPre ,
                                 String AV10F1357CPer ,
                                 byte AV11F1357CSec ,
                                 String AV43Pgmname ,
                                 short AV17OrderedBy ,
                                 boolean AV18OrderedDsc ,
                                 String AV37TFLegIdNomApe ,
                                 GXSimpleCollection<String> AV38TFLegIdNomApe_Sels ,
                                 String AV31TFF1357LDGDescuentosLey ,
                                 GXSimpleCollection<String> AV32TFF1357LDGDescuentosLey_Sels ,
                                 String AV34TFF1357LDGOtrDescuLey ,
                                 GXSimpleCollection<String> AV35TFF1357LDGOtrDescuLey_Sels ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e159L2 ();
      GRID_nCurrentRecord = 0 ;
      rf9L2( ) ;
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
      if ( cmbF1357CTipoPre.getItemCount() > 0 )
      {
         A784F1357CTipoPre = (byte)(GXutil.lval( cmbF1357CTipoPre.getValidValue(GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbF1357CTipoPre.setValue( GXutil.trim( GXutil.str( A784F1357CTipoPre, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbF1357CTipoPre.getInternalname(), "Values", cmbF1357CTipoPre.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf9L2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV43Pgmname = "F1357CabF1357LegDedGenWC" ;
      Gx_err = (short)(0) ;
   }

   public void rf9L2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(22) ;
      /* Execute user event: Refresh */
      e159L2 ();
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
                                              A250LegIdNomApe ,
                                              AV38TFLegIdNomApe_Sels ,
                                              A825F1357LDGDescuentosLey ,
                                              AV32TFF1357LDGDescuentosLey_Sels ,
                                              A826F1357LDGOtrDescuLey ,
                                              AV35TFF1357LDGOtrDescuLey_Sels ,
                                              Integer.valueOf(AV38TFLegIdNomApe_Sels.size()) ,
                                              AV37TFLegIdNomApe ,
                                              Integer.valueOf(AV32TFF1357LDGDescuentosLey_Sels.size()) ,
                                              AV31TFF1357LDGDescuentosLey ,
                                              Integer.valueOf(AV35TFF1357LDGOtrDescuLey_Sels.size()) ,
                                              AV34TFF1357LDGOtrDescuLey ,
                                              Short.valueOf(AV17OrderedBy) ,
                                              Boolean.valueOf(AV18OrderedDsc) ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Byte.valueOf(AV40F1357CTipoPre) ,
                                              AV10F1357CPer ,
                                              Byte.valueOf(AV11F1357CSec) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Byte.valueOf(A784F1357CTipoPre) ,
                                              A777F1357CPer ,
                                              Byte.valueOf(A778F1357CSec) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING,
                                              TypeConstants.BYTE
                                              }
         });
         lV37TFLegIdNomApe = GXutil.concat( GXutil.rtrim( AV37TFLegIdNomApe), "%", "") ;
         lV31TFF1357LDGDescuentosLey = GXutil.concat( GXutil.rtrim( AV31TFF1357LDGDescuentosLey), "%", "") ;
         lV34TFF1357LDGOtrDescuLey = GXutil.concat( GXutil.rtrim( AV34TFF1357LDGOtrDescuLey), "%", "") ;
         /* Using cursor H009L2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Byte.valueOf(AV40F1357CTipoPre), AV10F1357CPer, Byte.valueOf(AV11F1357CSec), lV37TFLegIdNomApe, lV31TFF1357LDGDescuentosLey, lV34TFF1357LDGOtrDescuLey, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_22_idx = 1 ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A3CliCod = H009L2_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = H009L2_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A784F1357CTipoPre = H009L2_A784F1357CTipoPre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
            A777F1357CPer = H009L2_A777F1357CPer[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A777F1357CPer", A777F1357CPer);
            A778F1357CSec = H009L2_A778F1357CSec[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
            A826F1357LDGOtrDescuLey = H009L2_A826F1357LDGOtrDescuLey[0] ;
            A825F1357LDGDescuentosLey = H009L2_A825F1357LDGDescuentosLey[0] ;
            A824F1357LDGOtrasPrev = H009L2_A824F1357LDGOtrasPrev[0] ;
            A823F1357LDGOtrasActores = H009L2_A823F1357LDGOtrasActores[0] ;
            A822F1357LDGOtrasProf = H009L2_A822F1357LDGOtrasProf[0] ;
            A821F1357LDGOtrasAnses = H009L2_A821F1357LDGOtrasAnses[0] ;
            A820F1357LDGTotal = H009L2_A820F1357LDGTotal[0] ;
            A819F1357LDGOtras = H009L2_A819F1357LDGOtras[0] ;
            A818F1357LDGIndu = H009L2_A818F1357LDGIndu[0] ;
            A817F1357LDGViaticos = H009L2_A817F1357LDGViaticos[0] ;
            A816F1357LDGDomes = H009L2_A816F1357LDGDomes[0] ;
            A815F1357LDGAlquiler = H009L2_A815F1357LDGAlquiler[0] ;
            A814F1357LDGOtrasCaja = H009L2_A814F1357LDGOtrasCaja[0] ;
            A813F1357LDGSGR = H009L2_A813F1357LDGSGR[0] ;
            A812F1357LDGHipoteca = H009L2_A812F1357LDGHipoteca[0] ;
            A811F1357LDGMed = H009L2_A811F1357LDGMed[0] ;
            A810F1357LDGOblig = H009L2_A810F1357LDGOblig[0] ;
            A809F1357LDGDonaciones = H009L2_A809F1357LDGDonaciones[0] ;
            A808F1357LDGRodado = H009L2_A808F1357LDGRodado[0] ;
            A807F1357LDGSepelio = H009L2_A807F1357LDGSepelio[0] ;
            A806F1357LDGCuotapartes = H009L2_A806F1357LDGCuotapartes[0] ;
            A805F1357LDGRetPriv = H009L2_A805F1357LDGRetPriv[0] ;
            A804F1357LDGSeguMixto = H009L2_A804F1357LDGSeguMixto[0] ;
            A803F1357LDGSeguro = H009L2_A803F1357LDGSeguro[0] ;
            A802F1357LDGPrepaga = H009L2_A802F1357LDGPrepaga[0] ;
            A863F1357LDGTipReg = H009L2_A863F1357LDGTipReg[0] ;
            A250LegIdNomApe = H009L2_A250LegIdNomApe[0] ;
            A6LegNumero = H009L2_A6LegNumero[0] ;
            A250LegIdNomApe = H009L2_A250LegIdNomApe[0] ;
            e169L2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(22) ;
         wb9L0( ) ;
      }
      bGXsfl_22_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes9L2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV43Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV43Pgmname, ""))));
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
                                           A250LegIdNomApe ,
                                           AV38TFLegIdNomApe_Sels ,
                                           A825F1357LDGDescuentosLey ,
                                           AV32TFF1357LDGDescuentosLey_Sels ,
                                           A826F1357LDGOtrDescuLey ,
                                           AV35TFF1357LDGOtrDescuLey_Sels ,
                                           Integer.valueOf(AV38TFLegIdNomApe_Sels.size()) ,
                                           AV37TFLegIdNomApe ,
                                           Integer.valueOf(AV32TFF1357LDGDescuentosLey_Sels.size()) ,
                                           AV31TFF1357LDGDescuentosLey ,
                                           Integer.valueOf(AV35TFF1357LDGOtrDescuLey_Sels.size()) ,
                                           AV34TFF1357LDGOtrDescuLey ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Byte.valueOf(AV40F1357CTipoPre) ,
                                           AV10F1357CPer ,
                                           Byte.valueOf(AV11F1357CSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Byte.valueOf(A784F1357CTipoPre) ,
                                           A777F1357CPer ,
                                           Byte.valueOf(A778F1357CSec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING,
                                           TypeConstants.BYTE
                                           }
      });
      lV37TFLegIdNomApe = GXutil.concat( GXutil.rtrim( AV37TFLegIdNomApe), "%", "") ;
      lV31TFF1357LDGDescuentosLey = GXutil.concat( GXutil.rtrim( AV31TFF1357LDGDescuentosLey), "%", "") ;
      lV34TFF1357LDGOtrDescuLey = GXutil.concat( GXutil.rtrim( AV34TFF1357LDGOtrDescuLey), "%", "") ;
      /* Using cursor H009L3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Byte.valueOf(AV40F1357CTipoPre), AV10F1357CPer, Byte.valueOf(AV11F1357CSec), lV37TFLegIdNomApe, lV31TFF1357LDGDescuentosLey, lV34TFF1357LDGOtrDescuLey});
      GRID_nRecordCount = H009L3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV40F1357CTipoPre, AV10F1357CPer, AV11F1357CSec, AV43Pgmname, AV17OrderedBy, AV18OrderedDsc, AV37TFLegIdNomApe, AV38TFLegIdNomApe_Sels, AV31TFF1357LDGDescuentosLey, AV32TFF1357LDGDescuentosLey_Sels, AV34TFF1357LDGOtrDescuLey, AV35TFF1357LDGOtrDescuLey_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV40F1357CTipoPre, AV10F1357CPer, AV11F1357CSec, AV43Pgmname, AV17OrderedBy, AV18OrderedDsc, AV37TFLegIdNomApe, AV38TFLegIdNomApe_Sels, AV31TFF1357LDGDescuentosLey, AV32TFF1357LDGDescuentosLey_Sels, AV34TFF1357LDGOtrDescuLey, AV35TFF1357LDGOtrDescuLey_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV40F1357CTipoPre, AV10F1357CPer, AV11F1357CSec, AV43Pgmname, AV17OrderedBy, AV18OrderedDsc, AV37TFLegIdNomApe, AV38TFLegIdNomApe_Sels, AV31TFF1357LDGDescuentosLey, AV32TFF1357LDGDescuentosLey_Sels, AV34TFF1357LDGOtrDescuLey, AV35TFF1357LDGOtrDescuLey_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV40F1357CTipoPre, AV10F1357CPer, AV11F1357CSec, AV43Pgmname, AV17OrderedBy, AV18OrderedDsc, AV37TFLegIdNomApe, AV38TFLegIdNomApe_Sels, AV31TFF1357LDGDescuentosLey, AV32TFF1357LDGDescuentosLey_Sels, AV34TFF1357LDGOtrDescuLey, AV35TFF1357LDGOtrDescuLey_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8CliCod, AV9EmpCod, AV40F1357CTipoPre, AV10F1357CPer, AV11F1357CSec, AV43Pgmname, AV17OrderedBy, AV18OrderedDsc, AV37TFLegIdNomApe, AV38TFLegIdNomApe_Sels, AV31TFF1357LDGDescuentosLey, AV32TFF1357LDGDescuentosLey_Sels, AV34TFF1357LDGOtrDescuLey, AV35TFF1357LDGOtrDescuLey_Sels, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV43Pgmname = "F1357CabF1357LegDedGenWC" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9L0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e149L2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV20DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_22 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_22"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV23GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV24GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV25GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV40F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV40F1357CTipoPre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV10F1357CPer = httpContext.cgiGet( sPrefix+"wcpOAV10F1357CPer") ;
         wcpOAV11F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11F1357CSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( sPrefix+"DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( sPrefix+"DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( sPrefix+"DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( sPrefix+"DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( sPrefix+"DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( sPrefix+"DDO_GRID_Filtertype") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( sPrefix+"DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( sPrefix+"DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( sPrefix+"DDO_GRID_Datalistproc") ;
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
         /* Read variables values. */
         A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         cmbF1357CTipoPre.setName( cmbF1357CTipoPre.getInternalname() );
         cmbF1357CTipoPre.setValue( httpContext.cgiGet( cmbF1357CTipoPre.getInternalname()) );
         A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.cgiGet( cmbF1357CTipoPre.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
         A777F1357CPer = httpContext.cgiGet( edtF1357CPer_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A777F1357CPer", A777F1357CPer);
         A778F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( edtF1357CSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
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
      e149L2 ();
      if (returnInSub) return;
   }

   public void e149L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_int1 = GXv_int2[0] ;
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
      cmbF1357CTipoPre.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbF1357CTipoPre.getInternalname(), "Visible", GXutil.ltrimstr( cmbF1357CTipoPre.getVisible(), 5, 0), true);
      edtF1357CPer_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtF1357CPer_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CPer_Visible), 5, 0), true);
      edtF1357CSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtF1357CSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtF1357CSec_Visible), 5, 0), true);
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

   public void e159L2( )
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
      f1357cabf1357legdedgenwc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliCod), 6, 0));
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV23GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GridCurrentPage), 10, 0));
      AV24GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridPageCount), 10, 0));
      GXt_char6 = AV25GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV43Pgmname, GXv_char7) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char6 = GXv_char7[0] ;
      AV25GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25GridAppliedFilters", AV25GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e119L2( )
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

   public void e129L2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e139L2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegIdNomApe") == 0 )
         {
            AV37TFLegIdNomApe = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLegIdNomApe", AV37TFLegIdNomApe);
            AV36TFLegIdNomApe_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLegIdNomApe_SelsJson", AV36TFLegIdNomApe_SelsJson);
            AV38TFLegIdNomApe_Sels.fromJSonString(AV36TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "F1357LDGDescuentosLey") == 0 )
         {
            AV31TFF1357LDGDescuentosLey = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFF1357LDGDescuentosLey", AV31TFF1357LDGDescuentosLey);
            AV30TFF1357LDGDescuentosLey_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFF1357LDGDescuentosLey_SelsJson", AV30TFF1357LDGDescuentosLey_SelsJson);
            AV32TFF1357LDGDescuentosLey_Sels.fromJSonString(AV30TFF1357LDGDescuentosLey_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "F1357LDGOtrDescuLey") == 0 )
         {
            AV34TFF1357LDGOtrDescuLey = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFF1357LDGOtrDescuLey", AV34TFF1357LDGOtrDescuLey);
            AV33TFF1357LDGOtrDescuLey_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFF1357LDGOtrDescuLey_SelsJson", AV33TFF1357LDGOtrDescuLey_SelsJson);
            AV35TFF1357LDGOtrDescuLey_Sels.fromJSonString(AV33TFF1357LDGOtrDescuLey_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV38TFLegIdNomApe_Sels", AV38TFLegIdNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV32TFF1357LDGDescuentosLey_Sels", AV32TFF1357LDGDescuentosLey_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV35TFF1357LDGOtrDescuLey_Sels", AV35TFF1357LDGOtrDescuLey_Sels);
   }

   private void e169L2( )
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
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV17OrderedBy, 4, 0))+":"+(AV18OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19Session.getValue(AV43Pgmname+"GridState"), "") == 0 )
      {
         AV15GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV43Pgmname+"GridState"), null, null);
      }
      else
      {
         AV15GridState.fromxml(AV19Session.getValue(AV43Pgmname+"GridState"), null, null);
      }
      AV17OrderedBy = AV15GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17OrderedBy), 4, 0));
      AV18OrderedDsc = AV15GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18OrderedDsc", AV18OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV37TFLegIdNomApe = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFLegIdNomApe", AV37TFLegIdNomApe);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV36TFLegIdNomApe_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFLegIdNomApe_SelsJson", AV36TFLegIdNomApe_SelsJson);
            AV38TFLegIdNomApe_Sels.fromJSonString(AV36TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGDESCUENTOSLEY") == 0 )
         {
            AV31TFF1357LDGDescuentosLey = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFF1357LDGDescuentosLey", AV31TFF1357LDGDescuentosLey);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGDESCUENTOSLEY_SEL") == 0 )
         {
            AV30TFF1357LDGDescuentosLey_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFF1357LDGDescuentosLey_SelsJson", AV30TFF1357LDGDescuentosLey_SelsJson);
            AV32TFF1357LDGDescuentosLey_Sels.fromJSonString(AV30TFF1357LDGDescuentosLey_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGOTRDESCULEY") == 0 )
         {
            AV34TFF1357LDGOtrDescuLey = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFF1357LDGOtrDescuLey", AV34TFF1357LDGOtrDescuLey);
         }
         else if ( GXutil.strcmp(AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFF1357LDGOTRDESCULEY_SEL") == 0 )
         {
            AV33TFF1357LDGOtrDescuLey_SelsJson = AV16GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFF1357LDGOtrDescuLey_SelsJson", AV33TFF1357LDGOtrDescuLey_SelsJson);
            AV35TFF1357LDGOtrDescuLey_Sels.fromJSonString(AV33TFF1357LDGOtrDescuLey_SelsJson, null);
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV38TFLegIdNomApe_Sels.size()==0), AV36TFLegIdNomApe_SelsJson, GXv_char7) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV32TFF1357LDGDescuentosLey_Sels.size()==0), AV30TFF1357LDGDescuentosLey_SelsJson, GXv_char9) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV35TFF1357LDGOtrDescuLey_Sels.size()==0), AV33TFF1357LDGOtrDescuLey_SelsJson, GXv_char11) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char10 = GXv_char11[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char6+"||||||||||||||||||||||||"+GXt_char8+"|"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFLegIdNomApe)==0), AV37TFLegIdNomApe, GXv_char11) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFF1357LDGDescuentosLey)==0), AV31TFF1357LDGDescuentosLey, GXv_char9) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFF1357LDGOtrDescuLey)==0), AV34TFF1357LDGOtrDescuLey, GXv_char7) ;
      f1357cabf1357legdedgenwc_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char10+"||||||||||||||||||||||||"+GXt_char8+"|"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
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
      AV15GridState.fromxml(AV19Session.getValue(AV43Pgmname+"GridState"), null, null);
      AV15GridState.setgxTv_SdtWWPGridState_Orderedby( AV17OrderedBy );
      AV15GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV18OrderedDsc );
      AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState12[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFLEGIDNOMAPE", httpContext.getMessage( "Legajo", ""), !(GXutil.strcmp("", AV37TFLegIdNomApe)==0), (short)(0), AV37TFLegIdNomApe, "", !(AV38TFLegIdNomApe_Sels.size()==0), AV38TFLegIdNomApe_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFF1357LDGDESCUENTOSLEY", httpContext.getMessage( "Descuentos de Ley", ""), !(GXutil.strcmp("", AV31TFF1357LDGDescuentosLey)==0), (short)(0), AV31TFF1357LDGDescuentosLey, "", !(AV32TFF1357LDGDescuentosLey_Sels.size()==0), AV32TFF1357LDGDescuentosLey_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState12[0] ;
      GXv_SdtWWPGridState12[0] = AV15GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState12, "TFF1357LDGOTRDESCULEY", httpContext.getMessage( "Descuentos de Ley (Otros empleos)", ""), !(GXutil.strcmp("", AV34TFF1357LDGOtrDescuLey)==0), (short)(0), AV34TFF1357LDGOtrDescuLey, "", !(AV35TFF1357LDGOtrDescuLey_Sels.size()==0), AV35TFF1357LDGOtrDescuLey_Sels.toJSonString(false), "") ;
      AV15GridState = GXv_SdtWWPGridState12[0] ;
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
      if ( ! (0==AV40F1357CTipoPre) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&F1357CTIPOPRE" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV40F1357CTipoPre, 1, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      if ( ! (GXutil.strcmp("", AV10F1357CPer)==0) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&F1357CPER" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV10F1357CPer );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      if ( ! (0==AV11F1357CSec) )
      {
         AV16GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&F1357CSEC" );
         AV16GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV11F1357CSec, 2, 0) );
         AV15GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV16GridStateFilterValue, 0);
      }
      AV15GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV43Pgmname+"GridState", AV15GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV13TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV43Pgmname );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV12HTTPRequest.getScriptName()+"?"+AV12HTTPRequest.getQuerystring() );
      AV13TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "F1357LegDedGen" );
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8CliCod, 6, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV9EmpCod, 4, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "F1357CTipoPre" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV40F1357CTipoPre, 1, 0) );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "F1357CPer" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV10F1357CPer );
      AV13TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV14TrnContextAtt, 0);
      AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "F1357CSec" );
      AV14TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV11F1357CSec, 2, 0) );
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
      AV40F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40F1357CTipoPre", GXutil.str( AV40F1357CTipoPre, 1, 0));
      AV10F1357CPer = (String)getParm(obj,3,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10F1357CPer", AV10F1357CPer);
      AV11F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11F1357CSec), 2, 0));
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
      pa9L2( ) ;
      ws9L2( ) ;
      we9L2( ) ;
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
      sCtrlAV40F1357CTipoPre = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV10F1357CPer = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlAV11F1357CSec = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa9L2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "f1357cabf1357legdedgenwc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa9L2( ) ;
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
         AV40F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40F1357CTipoPre", GXutil.str( AV40F1357CTipoPre, 1, 0));
         AV10F1357CPer = (String)getParm(obj,5,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10F1357CPer", AV10F1357CPer);
         AV11F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.BYTE), TypeConstants.BYTE)).byteValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11F1357CSec), 2, 0));
      }
      wcpOAV8CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV9EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV40F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV40F1357CTipoPre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV10F1357CPer = httpContext.cgiGet( sPrefix+"wcpOAV10F1357CPer") ;
      wcpOAV11F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11F1357CSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( AV8CliCod != wcpOAV8CliCod ) || ( AV9EmpCod != wcpOAV9EmpCod ) || ( AV40F1357CTipoPre != wcpOAV40F1357CTipoPre ) || ( GXutil.strcmp(AV10F1357CPer, wcpOAV10F1357CPer) != 0 ) || ( AV11F1357CSec != wcpOAV11F1357CSec ) ) )
      {
         setjustcreated();
      }
      wcpOAV8CliCod = AV8CliCod ;
      wcpOAV9EmpCod = AV9EmpCod ;
      wcpOAV40F1357CTipoPre = AV40F1357CTipoPre ;
      wcpOAV10F1357CPer = AV10F1357CPer ;
      wcpOAV11F1357CSec = AV11F1357CSec ;
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
      sCtrlAV40F1357CTipoPre = httpContext.cgiGet( sPrefix+"AV40F1357CTipoPre_CTRL") ;
      if ( GXutil.len( sCtrlAV40F1357CTipoPre) > 0 )
      {
         AV40F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlAV40F1357CTipoPre), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40F1357CTipoPre", GXutil.str( AV40F1357CTipoPre, 1, 0));
      }
      else
      {
         AV40F1357CTipoPre = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV40F1357CTipoPre_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV10F1357CPer = httpContext.cgiGet( sPrefix+"AV10F1357CPer_CTRL") ;
      if ( GXutil.len( sCtrlAV10F1357CPer) > 0 )
      {
         AV10F1357CPer = httpContext.cgiGet( sCtrlAV10F1357CPer) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10F1357CPer", AV10F1357CPer);
      }
      else
      {
         AV10F1357CPer = httpContext.cgiGet( sPrefix+"AV10F1357CPer_PARM") ;
      }
      sCtrlAV11F1357CSec = httpContext.cgiGet( sPrefix+"AV11F1357CSec_CTRL") ;
      if ( GXutil.len( sCtrlAV11F1357CSec) > 0 )
      {
         AV11F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( sCtrlAV11F1357CSec), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11F1357CSec), 2, 0));
      }
      else
      {
         AV11F1357CSec = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV11F1357CSec_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa9L2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws9L2( ) ;
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
      ws9L2( ) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV40F1357CTipoPre_PARM", GXutil.ltrim( localUtil.ntoc( AV40F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV40F1357CTipoPre)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV40F1357CTipoPre_CTRL", GXutil.rtrim( sCtrlAV40F1357CTipoPre));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10F1357CPer_PARM", GXutil.rtrim( AV10F1357CPer));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10F1357CPer)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10F1357CPer_CTRL", GXutil.rtrim( sCtrlAV10F1357CPer));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11F1357CSec_PARM", GXutil.ltrim( localUtil.ntoc( AV11F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11F1357CSec)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11F1357CSec_CTRL", GXutil.rtrim( sCtrlAV11F1357CSec));
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
      we9L2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713384791", true, true);
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
      httpContext.AddJavascriptSource("f1357cabf1357legdedgenwc.js", "?20251713384791", false, true);
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
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_22_idx ;
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE_"+sGXsfl_22_idx ;
      edtF1357LDGTipReg_Internalname = sPrefix+"F1357LDGTIPREG_"+sGXsfl_22_idx ;
      edtF1357LDGPrepaga_Internalname = sPrefix+"F1357LDGPREPAGA_"+sGXsfl_22_idx ;
      edtF1357LDGSeguro_Internalname = sPrefix+"F1357LDGSEGURO_"+sGXsfl_22_idx ;
      edtF1357LDGSeguMixto_Internalname = sPrefix+"F1357LDGSEGUMIXTO_"+sGXsfl_22_idx ;
      edtF1357LDGRetPriv_Internalname = sPrefix+"F1357LDGRETPRIV_"+sGXsfl_22_idx ;
      edtF1357LDGCuotapartes_Internalname = sPrefix+"F1357LDGCUOTAPARTES_"+sGXsfl_22_idx ;
      edtF1357LDGSepelio_Internalname = sPrefix+"F1357LDGSEPELIO_"+sGXsfl_22_idx ;
      edtF1357LDGRodado_Internalname = sPrefix+"F1357LDGRODADO_"+sGXsfl_22_idx ;
      edtF1357LDGDonaciones_Internalname = sPrefix+"F1357LDGDONACIONES_"+sGXsfl_22_idx ;
      edtF1357LDGOblig_Internalname = sPrefix+"F1357LDGOBLIG_"+sGXsfl_22_idx ;
      edtF1357LDGMed_Internalname = sPrefix+"F1357LDGMED_"+sGXsfl_22_idx ;
      edtF1357LDGHipoteca_Internalname = sPrefix+"F1357LDGHIPOTECA_"+sGXsfl_22_idx ;
      edtF1357LDGSGR_Internalname = sPrefix+"F1357LDGSGR_"+sGXsfl_22_idx ;
      edtF1357LDGOtrasCaja_Internalname = sPrefix+"F1357LDGOTRASCAJA_"+sGXsfl_22_idx ;
      edtF1357LDGAlquiler_Internalname = sPrefix+"F1357LDGALQUILER_"+sGXsfl_22_idx ;
      edtF1357LDGDomes_Internalname = sPrefix+"F1357LDGDOMES_"+sGXsfl_22_idx ;
      edtF1357LDGViaticos_Internalname = sPrefix+"F1357LDGVIATICOS_"+sGXsfl_22_idx ;
      edtF1357LDGIndu_Internalname = sPrefix+"F1357LDGINDU_"+sGXsfl_22_idx ;
      edtF1357LDGOtras_Internalname = sPrefix+"F1357LDGOTRAS_"+sGXsfl_22_idx ;
      edtF1357LDGTotal_Internalname = sPrefix+"F1357LDGTOTAL_"+sGXsfl_22_idx ;
      edtF1357LDGOtrasAnses_Internalname = sPrefix+"F1357LDGOTRASANSES_"+sGXsfl_22_idx ;
      edtF1357LDGOtrasProf_Internalname = sPrefix+"F1357LDGOTRASPROF_"+sGXsfl_22_idx ;
      edtF1357LDGOtrasActores_Internalname = sPrefix+"F1357LDGOTRASACTORES_"+sGXsfl_22_idx ;
      edtF1357LDGOtrasPrev_Internalname = sPrefix+"F1357LDGOTRASPREV_"+sGXsfl_22_idx ;
      edtF1357LDGDescuentosLey_Internalname = sPrefix+"F1357LDGDESCUENTOSLEY_"+sGXsfl_22_idx ;
      edtF1357LDGOtrDescuLey_Internalname = sPrefix+"F1357LDGOTRDESCULEY_"+sGXsfl_22_idx ;
   }

   public void subsflControlProps_fel_222( )
   {
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO_"+sGXsfl_22_fel_idx ;
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE_"+sGXsfl_22_fel_idx ;
      edtF1357LDGTipReg_Internalname = sPrefix+"F1357LDGTIPREG_"+sGXsfl_22_fel_idx ;
      edtF1357LDGPrepaga_Internalname = sPrefix+"F1357LDGPREPAGA_"+sGXsfl_22_fel_idx ;
      edtF1357LDGSeguro_Internalname = sPrefix+"F1357LDGSEGURO_"+sGXsfl_22_fel_idx ;
      edtF1357LDGSeguMixto_Internalname = sPrefix+"F1357LDGSEGUMIXTO_"+sGXsfl_22_fel_idx ;
      edtF1357LDGRetPriv_Internalname = sPrefix+"F1357LDGRETPRIV_"+sGXsfl_22_fel_idx ;
      edtF1357LDGCuotapartes_Internalname = sPrefix+"F1357LDGCUOTAPARTES_"+sGXsfl_22_fel_idx ;
      edtF1357LDGSepelio_Internalname = sPrefix+"F1357LDGSEPELIO_"+sGXsfl_22_fel_idx ;
      edtF1357LDGRodado_Internalname = sPrefix+"F1357LDGRODADO_"+sGXsfl_22_fel_idx ;
      edtF1357LDGDonaciones_Internalname = sPrefix+"F1357LDGDONACIONES_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOblig_Internalname = sPrefix+"F1357LDGOBLIG_"+sGXsfl_22_fel_idx ;
      edtF1357LDGMed_Internalname = sPrefix+"F1357LDGMED_"+sGXsfl_22_fel_idx ;
      edtF1357LDGHipoteca_Internalname = sPrefix+"F1357LDGHIPOTECA_"+sGXsfl_22_fel_idx ;
      edtF1357LDGSGR_Internalname = sPrefix+"F1357LDGSGR_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtrasCaja_Internalname = sPrefix+"F1357LDGOTRASCAJA_"+sGXsfl_22_fel_idx ;
      edtF1357LDGAlquiler_Internalname = sPrefix+"F1357LDGALQUILER_"+sGXsfl_22_fel_idx ;
      edtF1357LDGDomes_Internalname = sPrefix+"F1357LDGDOMES_"+sGXsfl_22_fel_idx ;
      edtF1357LDGViaticos_Internalname = sPrefix+"F1357LDGVIATICOS_"+sGXsfl_22_fel_idx ;
      edtF1357LDGIndu_Internalname = sPrefix+"F1357LDGINDU_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtras_Internalname = sPrefix+"F1357LDGOTRAS_"+sGXsfl_22_fel_idx ;
      edtF1357LDGTotal_Internalname = sPrefix+"F1357LDGTOTAL_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtrasAnses_Internalname = sPrefix+"F1357LDGOTRASANSES_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtrasProf_Internalname = sPrefix+"F1357LDGOTRASPROF_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtrasActores_Internalname = sPrefix+"F1357LDGOTRASACTORES_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtrasPrev_Internalname = sPrefix+"F1357LDGOTRASPREV_"+sGXsfl_22_fel_idx ;
      edtF1357LDGDescuentosLey_Internalname = sPrefix+"F1357LDGDESCUENTOSLEY_"+sGXsfl_22_fel_idx ;
      edtF1357LDGOtrDescuLey_Internalname = sPrefix+"F1357LDGOTRDESCULEY_"+sGXsfl_22_fel_idx ;
   }

   public void sendrow_222( )
   {
      subsflControlProps_222( ) ;
      wb9L0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegIdNomApe_Internalname,A250LegIdNomApe,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtLegIdNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGTipReg_Internalname,GXutil.rtrim( A863F1357LDGTipReg),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGTipReg_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGPrepaga_Internalname,GXutil.ltrim( localUtil.ntoc( A802F1357LDGPrepaga, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A802F1357LDGPrepaga, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGPrepaga_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGSeguro_Internalname,GXutil.ltrim( localUtil.ntoc( A803F1357LDGSeguro, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A803F1357LDGSeguro, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGSeguro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGSeguMixto_Internalname,GXutil.ltrim( localUtil.ntoc( A804F1357LDGSeguMixto, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A804F1357LDGSeguMixto, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGSeguMixto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGRetPriv_Internalname,GXutil.ltrim( localUtil.ntoc( A805F1357LDGRetPriv, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A805F1357LDGRetPriv, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGRetPriv_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGCuotapartes_Internalname,GXutil.ltrim( localUtil.ntoc( A806F1357LDGCuotapartes, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A806F1357LDGCuotapartes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGCuotapartes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGSepelio_Internalname,GXutil.ltrim( localUtil.ntoc( A807F1357LDGSepelio, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A807F1357LDGSepelio, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGSepelio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGRodado_Internalname,GXutil.ltrim( localUtil.ntoc( A808F1357LDGRodado, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A808F1357LDGRodado, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGRodado_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGDonaciones_Internalname,GXutil.ltrim( localUtil.ntoc( A809F1357LDGDonaciones, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A809F1357LDGDonaciones, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGDonaciones_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOblig_Internalname,GXutil.ltrim( localUtil.ntoc( A810F1357LDGOblig, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A810F1357LDGOblig, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOblig_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGMed_Internalname,GXutil.ltrim( localUtil.ntoc( A811F1357LDGMed, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A811F1357LDGMed, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGMed_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGHipoteca_Internalname,GXutil.ltrim( localUtil.ntoc( A812F1357LDGHipoteca, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A812F1357LDGHipoteca, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGHipoteca_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGSGR_Internalname,GXutil.ltrim( localUtil.ntoc( A813F1357LDGSGR, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A813F1357LDGSGR, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGSGR_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtrasCaja_Internalname,GXutil.ltrim( localUtil.ntoc( A814F1357LDGOtrasCaja, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A814F1357LDGOtrasCaja, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtrasCaja_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGAlquiler_Internalname,GXutil.ltrim( localUtil.ntoc( A815F1357LDGAlquiler, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A815F1357LDGAlquiler, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGAlquiler_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGDomes_Internalname,GXutil.ltrim( localUtil.ntoc( A816F1357LDGDomes, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A816F1357LDGDomes, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGDomes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGViaticos_Internalname,GXutil.ltrim( localUtil.ntoc( A817F1357LDGViaticos, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A817F1357LDGViaticos, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGViaticos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGIndu_Internalname,GXutil.ltrim( localUtil.ntoc( A818F1357LDGIndu, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A818F1357LDGIndu, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGIndu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtras_Internalname,GXutil.ltrim( localUtil.ntoc( A819F1357LDGOtras, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A819F1357LDGOtras, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtras_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A820F1357LDGTotal, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A820F1357LDGTotal, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGTotal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtrasAnses_Internalname,GXutil.ltrim( localUtil.ntoc( A821F1357LDGOtrasAnses, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A821F1357LDGOtrasAnses, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtrasAnses_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtrasProf_Internalname,GXutil.ltrim( localUtil.ntoc( A822F1357LDGOtrasProf, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A822F1357LDGOtrasProf, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtrasProf_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtrasActores_Internalname,GXutil.ltrim( localUtil.ntoc( A823F1357LDGOtrasActores, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A823F1357LDGOtrasActores, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtrasActores_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtrasPrev_Internalname,GXutil.ltrim( localUtil.ntoc( A824F1357LDGOtrasPrev, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A824F1357LDGOtrasPrev, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtrasPrev_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes16_2","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGDescuentosLey_Internalname,A825F1357LDGDescuentosLey,A825F1357LDGDescuentosLey,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGDescuentosLey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtF1357LDGOtrDescuLey_Internalname,A826F1357LDGOtrDescuLey,A826F1357LDGOtrDescuLey,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtF1357LDGOtrDescuLey_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes9L2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "LDGTip Reg", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUOTAS MÉDICO ASISTENCIALES", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "PRIMAS DE SEGURO PARA EL CASO DE MUERTE", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "SEGUROS MUERTE/MIXTOS SUJETAS AL CONTROL DE LA SSN", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "SEGURO DE RETIRO PRIVADOS -SUJETAS AL CONTROL DE LA SSN", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "ADQUISICIÓN DE CUOTAPARTES DE FCI CON FINES DE RETIRO", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "GASTOS DE SEPELIO", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "GTOS AMORT E INT RODADO CORREDORES Y VIAJANTES DE COMERCIO", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "DONAC. FISCOS NAC./PROV./MUN./INST. ART 26 INC. E) Y F) LIG", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "DTOS OBLIG POR LEY NACIONAL, PROVINCIAL O MUNICIPAL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "HONORARIOS SERV. ASISTENCIA SANITARIA, MÉDICA Y PARAMÉDICA", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "INTERESES CRÉDITOS HIPOTECARIOS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "AP. CAP. SOC. /FONDO DE RIESGO DE SOCIOS PROTECTORES DE SGR", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Otras Deducciones- AP. CAJAS COMPLEM.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "ALQUILERES DE INMUEBLES DESTINADOS A SU CASA HABITACIÓN", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "EMPLEADOS DEL SERVICIO DOMESTICO", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "GTOS MOV./VIÁTICOS ABONADOS POR EL EMPLEADOR", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "INDUMENTARIA/EQUIPAMIENTO-USO EXLUSIVO-CARÁCTER OBLIGATORIO", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "OTRAS DEDUCCIONES", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "TOTAL DEDUCCIONES GENERALES (Topeadas)", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Otras Deducciones - Aportes para Jubilaciones, Retiros y Subsidios ANSeS", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Otras Deducciones - Cajas Provinciales o Municipales o de Previsión para Profesionales", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Otras Deducciones - Actores - Retribución pagada a los representantes - RG 2442/08", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "tras Deducciones - Fondos Compensadores de Previsión", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descuentos de Ley", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descuentos de Ley (Otros empleos)", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A250LegIdNomApe);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A863F1357LDGTipReg));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A802F1357LDGPrepaga, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A803F1357LDGSeguro, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A804F1357LDGSeguMixto, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A805F1357LDGRetPriv, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A806F1357LDGCuotapartes, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A807F1357LDGSepelio, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A808F1357LDGRodado, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A809F1357LDGDonaciones, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A810F1357LDGOblig, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A811F1357LDGMed, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A812F1357LDGHipoteca, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A813F1357LDGSGR, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A814F1357LDGOtrasCaja, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A815F1357LDGAlquiler, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A816F1357LDGDomes, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A817F1357LDGViaticos, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A818F1357LDGIndu, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A819F1357LDGOtras, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A820F1357LDGTotal, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A821F1357LDGOtrasAnses, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A822F1357LDGOtrasProf, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A823F1357LDGOtrasActores, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A824F1357LDGOtrasPrev, (byte)(20), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A825F1357LDGDescuentosLey);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A826F1357LDGOtrDescuLey);
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
      edtLegNumero_Internalname = sPrefix+"LEGNUMERO" ;
      edtLegIdNomApe_Internalname = sPrefix+"LEGIDNOMAPE" ;
      edtF1357LDGTipReg_Internalname = sPrefix+"F1357LDGTIPREG" ;
      edtF1357LDGPrepaga_Internalname = sPrefix+"F1357LDGPREPAGA" ;
      edtF1357LDGSeguro_Internalname = sPrefix+"F1357LDGSEGURO" ;
      edtF1357LDGSeguMixto_Internalname = sPrefix+"F1357LDGSEGUMIXTO" ;
      edtF1357LDGRetPriv_Internalname = sPrefix+"F1357LDGRETPRIV" ;
      edtF1357LDGCuotapartes_Internalname = sPrefix+"F1357LDGCUOTAPARTES" ;
      edtF1357LDGSepelio_Internalname = sPrefix+"F1357LDGSEPELIO" ;
      edtF1357LDGRodado_Internalname = sPrefix+"F1357LDGRODADO" ;
      edtF1357LDGDonaciones_Internalname = sPrefix+"F1357LDGDONACIONES" ;
      edtF1357LDGOblig_Internalname = sPrefix+"F1357LDGOBLIG" ;
      edtF1357LDGMed_Internalname = sPrefix+"F1357LDGMED" ;
      edtF1357LDGHipoteca_Internalname = sPrefix+"F1357LDGHIPOTECA" ;
      edtF1357LDGSGR_Internalname = sPrefix+"F1357LDGSGR" ;
      edtF1357LDGOtrasCaja_Internalname = sPrefix+"F1357LDGOTRASCAJA" ;
      edtF1357LDGAlquiler_Internalname = sPrefix+"F1357LDGALQUILER" ;
      edtF1357LDGDomes_Internalname = sPrefix+"F1357LDGDOMES" ;
      edtF1357LDGViaticos_Internalname = sPrefix+"F1357LDGVIATICOS" ;
      edtF1357LDGIndu_Internalname = sPrefix+"F1357LDGINDU" ;
      edtF1357LDGOtras_Internalname = sPrefix+"F1357LDGOTRAS" ;
      edtF1357LDGTotal_Internalname = sPrefix+"F1357LDGTOTAL" ;
      edtF1357LDGOtrasAnses_Internalname = sPrefix+"F1357LDGOTRASANSES" ;
      edtF1357LDGOtrasProf_Internalname = sPrefix+"F1357LDGOTRASPROF" ;
      edtF1357LDGOtrasActores_Internalname = sPrefix+"F1357LDGOTRASACTORES" ;
      edtF1357LDGOtrasPrev_Internalname = sPrefix+"F1357LDGOTRASPREV" ;
      edtF1357LDGDescuentosLey_Internalname = sPrefix+"F1357LDGDESCUENTOSLEY" ;
      edtF1357LDGOtrDescuLey_Internalname = sPrefix+"F1357LDGOTRDESCULEY" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      divTablegridheader_Internalname = sPrefix+"TABLEGRIDHEADER" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtEmpCod_Internalname = sPrefix+"EMPCOD" ;
      cmbF1357CTipoPre.setInternalname( sPrefix+"F1357CTIPOPRE" );
      edtF1357CPer_Internalname = sPrefix+"F1357CPER" ;
      edtF1357CSec_Internalname = sPrefix+"F1357CSEC" ;
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
      edtF1357LDGOtrDescuLey_Jsonclick = "" ;
      edtF1357LDGDescuentosLey_Jsonclick = "" ;
      edtF1357LDGOtrasPrev_Jsonclick = "" ;
      edtF1357LDGOtrasActores_Jsonclick = "" ;
      edtF1357LDGOtrasProf_Jsonclick = "" ;
      edtF1357LDGOtrasAnses_Jsonclick = "" ;
      edtF1357LDGTotal_Jsonclick = "" ;
      edtF1357LDGOtras_Jsonclick = "" ;
      edtF1357LDGIndu_Jsonclick = "" ;
      edtF1357LDGViaticos_Jsonclick = "" ;
      edtF1357LDGDomes_Jsonclick = "" ;
      edtF1357LDGAlquiler_Jsonclick = "" ;
      edtF1357LDGOtrasCaja_Jsonclick = "" ;
      edtF1357LDGSGR_Jsonclick = "" ;
      edtF1357LDGHipoteca_Jsonclick = "" ;
      edtF1357LDGMed_Jsonclick = "" ;
      edtF1357LDGOblig_Jsonclick = "" ;
      edtF1357LDGDonaciones_Jsonclick = "" ;
      edtF1357LDGRodado_Jsonclick = "" ;
      edtF1357LDGSepelio_Jsonclick = "" ;
      edtF1357LDGCuotapartes_Jsonclick = "" ;
      edtF1357LDGRetPriv_Jsonclick = "" ;
      edtF1357LDGSeguMixto_Jsonclick = "" ;
      edtF1357LDGSeguro_Jsonclick = "" ;
      edtF1357LDGPrepaga_Jsonclick = "" ;
      edtF1357LDGTipReg_Jsonclick = "" ;
      edtLegIdNomApe_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Sortable = (byte)(0) ;
      edtF1357CSec_Jsonclick = "" ;
      edtF1357CSec_Visible = 1 ;
      edtF1357CPer_Jsonclick = "" ;
      edtF1357CPer_Visible = 1 ;
      cmbF1357CTipoPre.setJsonclick( "" );
      cmbF1357CTipoPre.setVisible( 1 );
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Datalistproc = "F1357CabF1357LegDedGenWCGetFilterData" ;
      Ddo_grid_Allowmultipleselection = "T||||||||||||||||||||||||T|T" ;
      Ddo_grid_Datalisttype = "Dynamic||||||||||||||||||||||||Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "T||||||||||||||||||||||||T|T" ;
      Ddo_grid_Filtertype = "Character||||||||||||||||||||||||Character|Character" ;
      Ddo_grid_Includefilter = "T||||||||||||||||||||||||T|T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25" ;
      Ddo_grid_Columnids = "1:LegIdNomApe|3:F1357LDGPrepaga|4:F1357LDGSeguro|5:F1357LDGSeguMixto|6:F1357LDGRetPriv|7:F1357LDGCuotapartes|8:F1357LDGSepelio|9:F1357LDGRodado|10:F1357LDGDonaciones|11:F1357LDGOblig|12:F1357LDGMed|13:F1357LDGHipoteca|14:F1357LDGSGR|15:F1357LDGOtrasCaja|16:F1357LDGAlquiler|17:F1357LDGDomes|18:F1357LDGViaticos|19:F1357LDGIndu|20:F1357LDGOtras|21:F1357LDGTotal|22:F1357LDGOtrasAnses|23:F1357LDGOtrasProf|24:F1357LDGOtrasActores|25:F1357LDGOtrasPrev|26:F1357LDGDescuentosLey|27:F1357LDGOtrDescuLey" ;
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
      cmbF1357CTipoPre.setName( "F1357CTIPOPRE" );
      cmbF1357CTipoPre.setWebtags( "" );
      cmbF1357CTipoPre.addItem("1", httpContext.getMessage( "Anual", ""), (short)(0));
      cmbF1357CTipoPre.addItem("2", httpContext.getMessage( "Final", ""), (short)(0));
      cmbF1357CTipoPre.addItem("3", httpContext.getMessage( "Informativa", ""), (short)(0));
      if ( cmbF1357CTipoPre.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV40F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9'},{av:'AV10F1357CPer',fld:'vF1357CPER',pic:''},{av:'AV11F1357CSec',fld:'vF1357CSEC',pic:'Z9'},{av:'AV43Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV37TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV38TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV31TFF1357LDGDescuentosLey',fld:'vTFF1357LDGDESCUENTOSLEY',pic:''},{av:'AV32TFF1357LDGDescuentosLey_Sels',fld:'vTFF1357LDGDESCUENTOSLEY_SELS',pic:''},{av:'AV34TFF1357LDGOtrDescuLey',fld:'vTFF1357LDGOTRDESCULEY',pic:''},{av:'AV35TFF1357LDGOtrDescuLey_Sels',fld:'vTFF1357LDGOTRDESCULEY_SELS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV23GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV24GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV25GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e119L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV40F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9'},{av:'AV10F1357CPer',fld:'vF1357CPER',pic:''},{av:'AV11F1357CSec',fld:'vF1357CSEC',pic:'Z9'},{av:'AV43Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV37TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV38TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV31TFF1357LDGDescuentosLey',fld:'vTFF1357LDGDESCUENTOSLEY',pic:''},{av:'AV32TFF1357LDGDescuentosLey_Sels',fld:'vTFF1357LDGDESCUENTOSLEY_SELS',pic:''},{av:'AV34TFF1357LDGOtrDescuLey',fld:'vTFF1357LDGOTRDESCULEY',pic:''},{av:'AV35TFF1357LDGOtrDescuLey_Sels',fld:'vTFF1357LDGOTRDESCULEY_SELS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e129L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV40F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9'},{av:'AV10F1357CPer',fld:'vF1357CPER',pic:''},{av:'AV11F1357CSec',fld:'vF1357CSEC',pic:'Z9'},{av:'AV43Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV37TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV38TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV31TFF1357LDGDescuentosLey',fld:'vTFF1357LDGDESCUENTOSLEY',pic:''},{av:'AV32TFF1357LDGDescuentosLey_Sels',fld:'vTFF1357LDGDESCUENTOSLEY_SELS',pic:''},{av:'AV34TFF1357LDGOtrDescuLey',fld:'vTFF1357LDGOTRDESCULEY',pic:''},{av:'AV35TFF1357LDGOtrDescuLey_Sels',fld:'vTFF1357LDGOTRDESCULEY_SELS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e139L2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV9EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV40F1357CTipoPre',fld:'vF1357CTIPOPRE',pic:'9'},{av:'AV10F1357CPer',fld:'vF1357CPER',pic:''},{av:'AV11F1357CSec',fld:'vF1357CSEC',pic:'Z9'},{av:'AV43Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV37TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV38TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV31TFF1357LDGDescuentosLey',fld:'vTFF1357LDGDESCUENTOSLEY',pic:''},{av:'AV32TFF1357LDGDescuentosLey_Sels',fld:'vTFF1357LDGDESCUENTOSLEY_SELS',pic:''},{av:'AV34TFF1357LDGOtrDescuLey',fld:'vTFF1357LDGOTRDESCULEY',pic:''},{av:'AV35TFF1357LDGOtrDescuLey_Sels',fld:'vTFF1357LDGOTRDESCULEY_SELS',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV17OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV18OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV37TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV36TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV38TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV31TFF1357LDGDescuentosLey',fld:'vTFF1357LDGDESCUENTOSLEY',pic:''},{av:'AV30TFF1357LDGDescuentosLey_SelsJson',fld:'vTFF1357LDGDESCUENTOSLEY_SELSJSON',pic:''},{av:'AV32TFF1357LDGDescuentosLey_Sels',fld:'vTFF1357LDGDESCUENTOSLEY_SELS',pic:''},{av:'AV34TFF1357LDGOtrDescuLey',fld:'vTFF1357LDGOTRDESCULEY',pic:''},{av:'AV33TFF1357LDGOtrDescuLey_SelsJson',fld:'vTFF1357LDGOTRDESCULEY_SELSJSON',pic:''},{av:'AV35TFF1357LDGOtrDescuLey_Sels',fld:'vTFF1357LDGOTRDESCULEY_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e169L2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_F1357ldgotrdesculey',iparms:[]");
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
      wcpOAV10F1357CPer = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV10F1357CPer = "" ;
      AV43Pgmname = "" ;
      AV37TFLegIdNomApe = "" ;
      AV38TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFF1357LDGDescuentosLey = "" ;
      AV32TFF1357LDGDescuentosLey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFF1357LDGOtrDescuLey = "" ;
      AV35TFF1357LDGOtrDescuLey_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV25GridAppliedFilters = "" ;
      AV20DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      A777F1357CPer = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A250LegIdNomApe = "" ;
      A863F1357LDGTipReg = "" ;
      A802F1357LDGPrepaga = DecimalUtil.ZERO ;
      A803F1357LDGSeguro = DecimalUtil.ZERO ;
      A804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      A805F1357LDGRetPriv = DecimalUtil.ZERO ;
      A806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      A807F1357LDGSepelio = DecimalUtil.ZERO ;
      A808F1357LDGRodado = DecimalUtil.ZERO ;
      A809F1357LDGDonaciones = DecimalUtil.ZERO ;
      A810F1357LDGOblig = DecimalUtil.ZERO ;
      A811F1357LDGMed = DecimalUtil.ZERO ;
      A812F1357LDGHipoteca = DecimalUtil.ZERO ;
      A813F1357LDGSGR = DecimalUtil.ZERO ;
      A814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      A815F1357LDGAlquiler = DecimalUtil.ZERO ;
      A816F1357LDGDomes = DecimalUtil.ZERO ;
      A817F1357LDGViaticos = DecimalUtil.ZERO ;
      A818F1357LDGIndu = DecimalUtil.ZERO ;
      A819F1357LDGOtras = DecimalUtil.ZERO ;
      A820F1357LDGTotal = DecimalUtil.ZERO ;
      A821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      A822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      A823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      A824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      A825F1357LDGDescuentosLey = "" ;
      A826F1357LDGOtrDescuLey = "" ;
      scmdbuf = "" ;
      lV37TFLegIdNomApe = "" ;
      lV31TFF1357LDGDescuentosLey = "" ;
      lV34TFF1357LDGOtrDescuLey = "" ;
      H009L2_A3CliCod = new int[1] ;
      H009L2_A1EmpCod = new short[1] ;
      H009L2_A784F1357CTipoPre = new byte[1] ;
      H009L2_A777F1357CPer = new String[] {""} ;
      H009L2_A778F1357CSec = new byte[1] ;
      H009L2_A826F1357LDGOtrDescuLey = new String[] {""} ;
      H009L2_A825F1357LDGDescuentosLey = new String[] {""} ;
      H009L2_A824F1357LDGOtrasPrev = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A823F1357LDGOtrasActores = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A822F1357LDGOtrasProf = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A821F1357LDGOtrasAnses = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A820F1357LDGTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A819F1357LDGOtras = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A818F1357LDGIndu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A817F1357LDGViaticos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A816F1357LDGDomes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A815F1357LDGAlquiler = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A814F1357LDGOtrasCaja = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A813F1357LDGSGR = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A812F1357LDGHipoteca = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A811F1357LDGMed = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A810F1357LDGOblig = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A809F1357LDGDonaciones = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A808F1357LDGRodado = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A807F1357LDGSepelio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A806F1357LDGCuotapartes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A805F1357LDGRetPriv = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A804F1357LDGSeguMixto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A803F1357LDGSeguro = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A802F1357LDGPrepaga = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009L2_A863F1357LDGTipReg = new String[] {""} ;
      H009L2_A250LegIdNomApe = new String[] {""} ;
      H009L2_A6LegNumero = new int[1] ;
      H009L3_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV36TFLegIdNomApe_SelsJson = "" ;
      AV30TFF1357LDGDescuentosLey_SelsJson = "" ;
      AV33TFF1357LDGOtrDescuLey_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV19Session = httpContext.getWebSession();
      AV15GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV16GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState12 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12HTTPRequest = httpContext.getHttpRequest();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8CliCod = "" ;
      sCtrlAV9EmpCod = "" ;
      sCtrlAV40F1357CTipoPre = "" ;
      sCtrlAV10F1357CPer = "" ;
      sCtrlAV11F1357CSec = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357cabf1357legdedgenwc__default(),
         new Object[] {
             new Object[] {
            H009L2_A3CliCod, H009L2_A1EmpCod, H009L2_A784F1357CTipoPre, H009L2_A777F1357CPer, H009L2_A778F1357CSec, H009L2_A826F1357LDGOtrDescuLey, H009L2_A825F1357LDGDescuentosLey, H009L2_A824F1357LDGOtrasPrev, H009L2_A823F1357LDGOtrasActores, H009L2_A822F1357LDGOtrasProf,
            H009L2_A821F1357LDGOtrasAnses, H009L2_A820F1357LDGTotal, H009L2_A819F1357LDGOtras, H009L2_A818F1357LDGIndu, H009L2_A817F1357LDGViaticos, H009L2_A816F1357LDGDomes, H009L2_A815F1357LDGAlquiler, H009L2_A814F1357LDGOtrasCaja, H009L2_A813F1357LDGSGR, H009L2_A812F1357LDGHipoteca,
            H009L2_A811F1357LDGMed, H009L2_A810F1357LDGOblig, H009L2_A809F1357LDGDonaciones, H009L2_A808F1357LDGRodado, H009L2_A807F1357LDGSepelio, H009L2_A806F1357LDGCuotapartes, H009L2_A805F1357LDGRetPriv, H009L2_A804F1357LDGSeguMixto, H009L2_A803F1357LDGSeguro, H009L2_A802F1357LDGPrepaga,
            H009L2_A863F1357LDGTipReg, H009L2_A250LegIdNomApe, H009L2_A6LegNumero
            }
            , new Object[] {
            H009L3_AGRID_nRecordCount
            }
         }
      );
      AV43Pgmname = "F1357CabF1357LegDedGenWC" ;
      /* GeneXus formulas. */
      AV43Pgmname = "F1357CabF1357LegDedGenWC" ;
      Gx_err = (short)(0) ;
   }

   private byte wcpOAV40F1357CTipoPre ;
   private byte wcpOAV11F1357CSec ;
   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV40F1357CTipoPre ;
   private byte AV11F1357CSec ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
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
   private short AV17OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
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
   private int edtF1357CPer_Visible ;
   private int edtF1357CSec_Visible ;
   private int A6LegNumero ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV38TFLegIdNomApe_Sels_size ;
   private int AV32TFF1357LDGDescuentosLey_Sels_size ;
   private int AV35TFF1357LDGOtrDescuLey_Sels_size ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV22PageToGo ;
   private int AV44GXV1 ;
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
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal A802F1357LDGPrepaga ;
   private java.math.BigDecimal A803F1357LDGSeguro ;
   private java.math.BigDecimal A804F1357LDGSeguMixto ;
   private java.math.BigDecimal A805F1357LDGRetPriv ;
   private java.math.BigDecimal A806F1357LDGCuotapartes ;
   private java.math.BigDecimal A807F1357LDGSepelio ;
   private java.math.BigDecimal A808F1357LDGRodado ;
   private java.math.BigDecimal A809F1357LDGDonaciones ;
   private java.math.BigDecimal A810F1357LDGOblig ;
   private java.math.BigDecimal A811F1357LDGMed ;
   private java.math.BigDecimal A812F1357LDGHipoteca ;
   private java.math.BigDecimal A813F1357LDGSGR ;
   private java.math.BigDecimal A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal A815F1357LDGAlquiler ;
   private java.math.BigDecimal A816F1357LDGDomes ;
   private java.math.BigDecimal A817F1357LDGViaticos ;
   private java.math.BigDecimal A818F1357LDGIndu ;
   private java.math.BigDecimal A819F1357LDGOtras ;
   private java.math.BigDecimal A820F1357LDGTotal ;
   private java.math.BigDecimal A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal A822F1357LDGOtrasProf ;
   private java.math.BigDecimal A823F1357LDGOtrasActores ;
   private java.math.BigDecimal A824F1357LDGOtrasPrev ;
   private String wcpOAV10F1357CPer ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV10F1357CPer ;
   private String sGXsfl_22_idx="0001" ;
   private String AV43Pgmname ;
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
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistproc ;
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
   private String edtF1357CPer_Internalname ;
   private String A777F1357CPer ;
   private String edtF1357CPer_Jsonclick ;
   private String edtF1357CSec_Internalname ;
   private String edtF1357CSec_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtLegNumero_Internalname ;
   private String edtLegIdNomApe_Internalname ;
   private String A863F1357LDGTipReg ;
   private String edtF1357LDGTipReg_Internalname ;
   private String edtF1357LDGPrepaga_Internalname ;
   private String edtF1357LDGSeguro_Internalname ;
   private String edtF1357LDGSeguMixto_Internalname ;
   private String edtF1357LDGRetPriv_Internalname ;
   private String edtF1357LDGCuotapartes_Internalname ;
   private String edtF1357LDGSepelio_Internalname ;
   private String edtF1357LDGRodado_Internalname ;
   private String edtF1357LDGDonaciones_Internalname ;
   private String edtF1357LDGOblig_Internalname ;
   private String edtF1357LDGMed_Internalname ;
   private String edtF1357LDGHipoteca_Internalname ;
   private String edtF1357LDGSGR_Internalname ;
   private String edtF1357LDGOtrasCaja_Internalname ;
   private String edtF1357LDGAlquiler_Internalname ;
   private String edtF1357LDGDomes_Internalname ;
   private String edtF1357LDGViaticos_Internalname ;
   private String edtF1357LDGIndu_Internalname ;
   private String edtF1357LDGOtras_Internalname ;
   private String edtF1357LDGTotal_Internalname ;
   private String edtF1357LDGOtrasAnses_Internalname ;
   private String edtF1357LDGOtrasProf_Internalname ;
   private String edtF1357LDGOtrasActores_Internalname ;
   private String edtF1357LDGOtrasPrev_Internalname ;
   private String edtF1357LDGDescuentosLey_Internalname ;
   private String edtF1357LDGOtrDescuLey_Internalname ;
   private String scmdbuf ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String sCtrlAV8CliCod ;
   private String sCtrlAV9EmpCod ;
   private String sCtrlAV40F1357CTipoPre ;
   private String sCtrlAV10F1357CPer ;
   private String sCtrlAV11F1357CSec ;
   private String sGXsfl_22_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegIdNomApe_Jsonclick ;
   private String edtF1357LDGTipReg_Jsonclick ;
   private String edtF1357LDGPrepaga_Jsonclick ;
   private String edtF1357LDGSeguro_Jsonclick ;
   private String edtF1357LDGSeguMixto_Jsonclick ;
   private String edtF1357LDGRetPriv_Jsonclick ;
   private String edtF1357LDGCuotapartes_Jsonclick ;
   private String edtF1357LDGSepelio_Jsonclick ;
   private String edtF1357LDGRodado_Jsonclick ;
   private String edtF1357LDGDonaciones_Jsonclick ;
   private String edtF1357LDGOblig_Jsonclick ;
   private String edtF1357LDGMed_Jsonclick ;
   private String edtF1357LDGHipoteca_Jsonclick ;
   private String edtF1357LDGSGR_Jsonclick ;
   private String edtF1357LDGOtrasCaja_Jsonclick ;
   private String edtF1357LDGAlquiler_Jsonclick ;
   private String edtF1357LDGDomes_Jsonclick ;
   private String edtF1357LDGViaticos_Jsonclick ;
   private String edtF1357LDGIndu_Jsonclick ;
   private String edtF1357LDGOtras_Jsonclick ;
   private String edtF1357LDGTotal_Jsonclick ;
   private String edtF1357LDGOtrasAnses_Jsonclick ;
   private String edtF1357LDGOtrasProf_Jsonclick ;
   private String edtF1357LDGOtrasActores_Jsonclick ;
   private String edtF1357LDGOtrasPrev_Jsonclick ;
   private String edtF1357LDGDescuentosLey_Jsonclick ;
   private String edtF1357LDGOtrDescuLey_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV18OrderedDsc ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_22_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A825F1357LDGDescuentosLey ;
   private String A826F1357LDGOtrDescuLey ;
   private String AV36TFLegIdNomApe_SelsJson ;
   private String AV30TFF1357LDGDescuentosLey_SelsJson ;
   private String AV33TFF1357LDGOtrDescuLey_SelsJson ;
   private String AV37TFLegIdNomApe ;
   private String AV31TFF1357LDGDescuentosLey ;
   private String AV34TFF1357LDGOtrDescuLey ;
   private String AV25GridAppliedFilters ;
   private String A250LegIdNomApe ;
   private String lV37TFLegIdNomApe ;
   private String lV31TFF1357LDGDescuentosLey ;
   private String lV34TFF1357LDGOtrDescuLey ;
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
   private HTMLChoice cmbF1357CTipoPre ;
   private IDataStoreProvider pr_default ;
   private int[] H009L2_A3CliCod ;
   private short[] H009L2_A1EmpCod ;
   private byte[] H009L2_A784F1357CTipoPre ;
   private String[] H009L2_A777F1357CPer ;
   private byte[] H009L2_A778F1357CSec ;
   private String[] H009L2_A826F1357LDGOtrDescuLey ;
   private String[] H009L2_A825F1357LDGDescuentosLey ;
   private java.math.BigDecimal[] H009L2_A824F1357LDGOtrasPrev ;
   private java.math.BigDecimal[] H009L2_A823F1357LDGOtrasActores ;
   private java.math.BigDecimal[] H009L2_A822F1357LDGOtrasProf ;
   private java.math.BigDecimal[] H009L2_A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal[] H009L2_A820F1357LDGTotal ;
   private java.math.BigDecimal[] H009L2_A819F1357LDGOtras ;
   private java.math.BigDecimal[] H009L2_A818F1357LDGIndu ;
   private java.math.BigDecimal[] H009L2_A817F1357LDGViaticos ;
   private java.math.BigDecimal[] H009L2_A816F1357LDGDomes ;
   private java.math.BigDecimal[] H009L2_A815F1357LDGAlquiler ;
   private java.math.BigDecimal[] H009L2_A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal[] H009L2_A813F1357LDGSGR ;
   private java.math.BigDecimal[] H009L2_A812F1357LDGHipoteca ;
   private java.math.BigDecimal[] H009L2_A811F1357LDGMed ;
   private java.math.BigDecimal[] H009L2_A810F1357LDGOblig ;
   private java.math.BigDecimal[] H009L2_A809F1357LDGDonaciones ;
   private java.math.BigDecimal[] H009L2_A808F1357LDGRodado ;
   private java.math.BigDecimal[] H009L2_A807F1357LDGSepelio ;
   private java.math.BigDecimal[] H009L2_A806F1357LDGCuotapartes ;
   private java.math.BigDecimal[] H009L2_A805F1357LDGRetPriv ;
   private java.math.BigDecimal[] H009L2_A804F1357LDGSeguMixto ;
   private java.math.BigDecimal[] H009L2_A803F1357LDGSeguro ;
   private java.math.BigDecimal[] H009L2_A802F1357LDGPrepaga ;
   private String[] H009L2_A863F1357LDGTipReg ;
   private String[] H009L2_A250LegIdNomApe ;
   private int[] H009L2_A6LegNumero ;
   private long[] H009L3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV38TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV32TFF1357LDGDescuentosLey_Sels ;
   private GXSimpleCollection<String> AV35TFF1357LDGOtrDescuLey_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV15GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState12[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV16GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV20DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
}

final  class f1357cabf1357legdedgenwc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H009L2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV38TFLegIdNomApe_Sels ,
                                          String A825F1357LDGDescuentosLey ,
                                          GXSimpleCollection<String> AV32TFF1357LDGDescuentosLey_Sels ,
                                          String A826F1357LDGOtrDescuLey ,
                                          GXSimpleCollection<String> AV35TFF1357LDGOtrDescuLey_Sels ,
                                          int AV38TFLegIdNomApe_Sels_size ,
                                          String AV37TFLegIdNomApe ,
                                          int AV32TFF1357LDGDescuentosLey_Sels_size ,
                                          String AV31TFF1357LDGDescuentosLey ,
                                          int AV35TFF1357LDGOtrDescuLey_Sels_size ,
                                          String AV34TFF1357LDGOtrDescuLey ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          byte AV40F1357CTipoPre ,
                                          String AV10F1357CPer ,
                                          byte AV11F1357CSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A784F1357CTipoPre ,
                                          String A777F1357CPer ,
                                          byte A778F1357CSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[11];
      Object[] GXv_Object14 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrDescuLey, T1.F1357LDGDescuentosLey, T1.F1357LDGOtrasPrev, T1.F1357LDGOtrasActores," ;
      sSelectString += " T1.F1357LDGOtrasProf, T1.F1357LDGOtrasAnses, T1.F1357LDGTotal, T1.F1357LDGOtras, T1.F1357LDGIndu, T1.F1357LDGViaticos, T1.F1357LDGDomes, T1.F1357LDGAlquiler, T1.F1357LDGOtrasCaja," ;
      sSelectString += " T1.F1357LDGSGR, T1.F1357LDGHipoteca, T1.F1357LDGMed, T1.F1357LDGOblig, T1.F1357LDGDonaciones, T1.F1357LDGRodado, T1.F1357LDGSepelio, T1.F1357LDGCuotapartes, T1.F1357LDGRetPriv," ;
      sSelectString += " T1.F1357LDGSeguMixto, T1.F1357LDGSeguro, T1.F1357LDGPrepaga, T1.F1357LDGTipReg, T2.LegIdNomApe, T1.LegNumero" ;
      sFromString = " FROM (F1357LegDedGen T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.F1357CTipoPre = ? and T1.F1357CPer = ( ?) and T1.F1357CSec = ?)");
      if ( ( AV38TFLegIdNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV37TFLegIdNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( AV38TFLegIdNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLegIdNomApe_Sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ( AV32TFF1357LDGDescuentosLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFF1357LDGDescuentosLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGDescuentosLey) like LOWER(?))");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( AV32TFF1357LDGDescuentosLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFF1357LDGDescuentosLey_Sels, "T1.F1357LDGDescuentosLey IN (", ")")+")");
      }
      if ( ( AV35TFF1357LDGOtrDescuLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV34TFF1357LDGOtrDescuLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGOtrDescuLey) like LOWER(?))");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( AV35TFF1357LDGOtrDescuLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV35TFF1357LDGOtrDescuLey_Sels, "T1.F1357LDGOtrDescuLey IN (", ")")+")");
      }
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGPrepaga, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGPrepaga DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGSeguro, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGSeguro DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGSeguMixto, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGSeguMixto DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGRetPriv, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGRetPriv DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGCuotapartes, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGCuotapartes DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGSepelio, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGSepelio DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGRodado, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGRodado DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGDonaciones, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGDonaciones DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOblig, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOblig DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGMed, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGMed DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGHipoteca, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGHipoteca DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGSGR, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGSGR DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrasCaja, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtrasCaja DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGAlquiler, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 14 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGAlquiler DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGDomes, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 15 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGDomes DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGViaticos, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 16 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGViaticos DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGIndu, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 17 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGIndu DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtras, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 18 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtras DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGTotal, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 19 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGTotal DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrasAnses, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 20 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtrasAnses DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrasProf, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 21 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtrasProf DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrasActores, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 22 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtrasActores DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrasPrev, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 23 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtrasPrev DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGDescuentosLey, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 24 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGDescuentosLey DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ! AV18OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.F1357LDGOtrDescuLey, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( ( AV17OrderedBy == 25 ) && ( AV18OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.F1357CTipoPre DESC, T1.F1357CPer DESC, T1.F1357CSec DESC, T1.F1357LDGOtrDescuLey DESC, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.F1357CTipoPre, T1.F1357CPer, T1.F1357CSec, T1.LegNumero, T1.F1357LDGTipReg" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_H009L3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV38TFLegIdNomApe_Sels ,
                                          String A825F1357LDGDescuentosLey ,
                                          GXSimpleCollection<String> AV32TFF1357LDGDescuentosLey_Sels ,
                                          String A826F1357LDGOtrDescuLey ,
                                          GXSimpleCollection<String> AV35TFF1357LDGOtrDescuLey_Sels ,
                                          int AV38TFLegIdNomApe_Sels_size ,
                                          String AV37TFLegIdNomApe ,
                                          int AV32TFF1357LDGDescuentosLey_Sels_size ,
                                          String AV31TFF1357LDGDescuentosLey ,
                                          int AV35TFF1357LDGOtrDescuLey_Sels_size ,
                                          String AV34TFF1357LDGOtrDescuLey ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          byte AV40F1357CTipoPre ,
                                          String AV10F1357CPer ,
                                          byte AV11F1357CSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          byte A784F1357CTipoPre ,
                                          String A777F1357CPer ,
                                          byte A778F1357CSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[8];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (F1357LegDedGen T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.F1357CTipoPre = ? and T1.F1357CPer = ( ?) and T1.F1357CSec = ?)");
      if ( ( AV38TFLegIdNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV37TFLegIdNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int16[5] = (byte)(1) ;
      }
      if ( AV38TFLegIdNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLegIdNomApe_Sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ( AV32TFF1357LDGDescuentosLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFF1357LDGDescuentosLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGDescuentosLey) like LOWER(?))");
      }
      else
      {
         GXv_int16[6] = (byte)(1) ;
      }
      if ( AV32TFF1357LDGDescuentosLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFF1357LDGDescuentosLey_Sels, "T1.F1357LDGDescuentosLey IN (", ")")+")");
      }
      if ( ( AV35TFF1357LDGOtrDescuLey_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV34TFF1357LDGOtrDescuLey)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.F1357LDGOtrDescuLey) like LOWER(?))");
      }
      else
      {
         GXv_int16[7] = (byte)(1) ;
      }
      if ( AV35TFF1357LDGOtrDescuLey_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV35TFF1357LDGOtrDescuLey_Sels, "T1.F1357LDGOtrDescuLey IN (", ")")+")");
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
                  return conditional_H009L2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).byteValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).byteValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() );
            case 1 :
                  return conditional_H009L3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).byteValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).byteValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009L2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H009L3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
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
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(26,2);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((java.math.BigDecimal[]) buf[28])[0] = rslt.getBigDecimal(29,2);
               ((java.math.BigDecimal[]) buf[29])[0] = rslt.getBigDecimal(30,2);
               ((String[]) buf[30])[0] = rslt.getString(31, 2);
               ((String[]) buf[31])[0] = rslt.getVarchar(32);
               ((int[]) buf[32])[0] = rslt.getInt(33);
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
                  stmt.setByte(sIdx, ((Number) parms[13]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 200);
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
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 6);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[12]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 200);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 200);
               }
               return;
      }
   }

}

