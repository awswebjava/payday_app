package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class calculo_parametrostab_impl extends GXWebComponent
{
   public calculo_parametrostab_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public calculo_parametrostab_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_parametrostab_impl.class ));
   }

   public calculo_parametrostab_impl( int remoteHandle ,
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
      cmbCalParId = new HTMLChoice();
      chkCalParObl = UIFactory.getCheckbox(this);
      cmbidOperando = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
               AV8PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiCod), 4, 0));
               AV9idOperando = httpContext.GetPar( "idOperando") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9idOperando", AV9idOperando);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(AV8PaiCod),AV9idOperando});
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
               gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PaiCod") ;
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
      nRC_GXsfl_21 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_21"))) ;
      nGXsfl_21_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_21_idx"))) ;
      sGXsfl_21_idx = httpContext.GetPar( "sGXsfl_21_idx") ;
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
      AV8PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV9idOperando = httpContext.GetPar( "idOperando") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV55ColumnsSelector);
      AV59Pgmname = httpContext.GetPar( "Pgmname") ;
      AV15OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV16OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV19TFCalParNombre = httpContext.GetPar( "TFCalParNombre") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV20TFCalParNombre_Sels);
      AV22TFCalParDesc = httpContext.GetPar( "TFCalParDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23TFCalParDesc_Sels);
      AV25TFCalParCampo = httpContext.GetPar( "TFCalParCampo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV26TFCalParCampo_Sels);
      AV28TFCalParValLista = httpContext.GetPar( "TFCalParValLista") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29TFCalParValLista_Sels);
      AV31TFCalParDef = httpContext.GetPar( "TFCalParDef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32TFCalParDef_Sels);
      AV33TFCalParObl_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFCalParObl_Sel"))) ;
      AV34TFCalParGrp = (byte)(GXutil.lval( httpContext.GetPar( "TFCalParGrp"))) ;
      AV35TFCalParGrp_To = (byte)(GXutil.lval( httpContext.GetPar( "TFCalParGrp_To"))) ;
      AV36TFCalParGrpDep = (byte)(GXutil.lval( httpContext.GetPar( "TFCalParGrpDep"))) ;
      AV37TFCalParGrpDep_To = (byte)(GXutil.lval( httpContext.GetPar( "TFCalParGrpDep_To"))) ;
      AV39TFCalParEjemplo = httpContext.GetPar( "TFCalParEjemplo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV40TFCalParEjemplo_Sels);
      AV42TFCalParEjemExpli = httpContext.GetPar( "TFCalParEjemExpli") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV43TFCalParEjemExpli_Sels);
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV8PaiCod, AV9idOperando, AV55ColumnsSelector, AV59Pgmname, AV15OrderedBy, AV16OrderedDsc, AV19TFCalParNombre, AV20TFCalParNombre_Sels, AV22TFCalParDesc, AV23TFCalParDesc_Sels, AV25TFCalParCampo, AV26TFCalParCampo_Sels, AV28TFCalParValLista, AV29TFCalParValLista_Sels, AV31TFCalParDef, AV32TFCalParDef_Sels, AV33TFCalParObl_Sel, AV34TFCalParGrp, AV35TFCalParGrp_To, AV36TFCalParGrpDep, AV37TFCalParGrpDep_To, AV39TFCalParEjemplo, AV40TFCalParEjemplo_Sels, AV42TFCalParEjemExpli, AV43TFCalParEjemExpli_Sels, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paMA2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Calculo_parametros Tab", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.calculo_parametrostab", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV8PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9idOperando))}, new String[] {"PaiCod","idOperando"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV59Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_21", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_21, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV44DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV44DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCOLUMNSSELECTOR", AV55ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCOLUMNSSELECTOR", AV55ColumnsSelector);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV47GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV48GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRIDAPPLIEDFILTERS", AV49GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8PaiCod", GXutil.ltrim( localUtil.ntoc( wcpOAV8PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV9idOperando", GXutil.rtrim( wcpOAV9idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV59Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV59Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV15OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vORDEREDDSC", AV16OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARNOMBRE", AV19TFCalParNombre);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPARNOMBRE_SELS", AV20TFCalParNombre_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPARNOMBRE_SELS", AV20TFCalParNombre_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARDESC", AV22TFCalParDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPARDESC_SELS", AV23TFCalParDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPARDESC_SELS", AV23TFCalParDesc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARCAMPO", AV25TFCalParCampo);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPARCAMPO_SELS", AV26TFCalParCampo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPARCAMPO_SELS", AV26TFCalParCampo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARVALLISTA", AV28TFCalParValLista);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPARVALLISTA_SELS", AV29TFCalParValLista_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPARVALLISTA_SELS", AV29TFCalParValLista_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARDEF", GXutil.rtrim( AV31TFCalParDef));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPARDEF_SELS", AV32TFCalParDef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPARDEF_SELS", AV32TFCalParDef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPAROBL_SEL", GXutil.ltrim( localUtil.ntoc( AV33TFCalParObl_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARGRP", GXutil.ltrim( localUtil.ntoc( AV34TFCalParGrp, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARGRP_TO", GXutil.ltrim( localUtil.ntoc( AV35TFCalParGrp_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARGRPDEP", GXutil.ltrim( localUtil.ntoc( AV36TFCalParGrpDep, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPARGRPDEP_TO", GXutil.ltrim( localUtil.ntoc( AV37TFCalParGrpDep_To, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPAREJEMPLO", AV39TFCalParEjemplo);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPAREJEMPLO_SELS", AV40TFCalParEjemplo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPAREJEMPLO_SELS", AV40TFCalParEjemplo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTFCALPAREJEMEXPLI", AV42TFCalParEjemExpli);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vTFCALPAREJEMEXPLI_SELS", AV43TFCalParEjemExpli_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vTFCALPAREJEMEXPLI_SELS", AV43TFCalParEjemExpli_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV8PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIDOPERANDO", GXutil.rtrim( AV9idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
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

   public void renderHtmlCloseFormMA2( )
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
      return "Calculo_parametrosTab" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Calculo_parametros Tab", "") ;
   }

   public void wbMA0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.calculo_parametrostab");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
         wb_table1_6_MA2( true) ;
      }
      else
      {
         wb_table1_6_MA2( false) ;
      }
      return  ;
   }

   public void wb_table1_6_MA2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV44DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, sPrefix+"DDO_GRIDContainer");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Calculo_parametrosTab.htm");
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbidOperando, cmbidOperando.getInternalname(), GXutil.rtrim( A74idOperando), 1, cmbidOperando.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbidOperando.getVisible(), 0, 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Calculo_parametrosTab.htm");
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
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
      if ( wbEnd == 21 )
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

   public void startMA2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Calculo_parametros Tab", ""), (short)(0)) ;
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
            strupMA0( ) ;
         }
      }
   }

   public void wsMA2( )
   {
      startMA2( ) ;
      evtMA2( ) ;
   }

   public void evtMA2( )
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
                              strupMA0( ) ;
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
                              strupMA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11MA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12MA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e13MA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMA0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14MA2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupMA0( ) ;
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
                              strupMA0( ) ;
                           }
                           nGXsfl_21_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_212( ) ;
                           cmbCalParId.setName( cmbCalParId.getInternalname() );
                           cmbCalParId.setValue( httpContext.cgiGet( cmbCalParId.getInternalname()) );
                           A2098CalParId = httpContext.cgiGet( cmbCalParId.getInternalname()) ;
                           A2110CalParNombre = httpContext.cgiGet( edtCalParNombre_Internalname) ;
                           A2100CalParDesc = httpContext.cgiGet( edtCalParDesc_Internalname) ;
                           A2099CalParCampo = httpContext.cgiGet( edtCalParCampo_Internalname) ;
                           A2111CalParValLista = httpContext.cgiGet( edtCalParValLista_Internalname) ;
                           A2107CalParDef = httpContext.cgiGet( edtCalParDef_Internalname) ;
                           A2106CalParObl = GXutil.strtobool( httpContext.cgiGet( chkCalParObl.getInternalname())) ;
                           A2104CalParGrp = (byte)(localUtil.ctol( httpContext.cgiGet( edtCalParGrp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2105CalParGrpDep = (byte)(localUtil.ctol( httpContext.cgiGet( edtCalParGrpDep_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2108CalParEjemplo = httpContext.cgiGet( edtCalParEjemplo_Internalname) ;
                           A2109CalParEjemExpli = httpContext.cgiGet( edtCalParEjemExpli_Internalname) ;
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
                                       e15MA2 ();
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
                                       e16MA2 ();
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
                                       e17MA2 ();
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
                                    strupMA0( ) ;
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

   public void weMA2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormMA2( ) ;
         }
      }
   }

   public void paMA2( )
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
      subsflControlProps_212( ) ;
      while ( nGXsfl_21_idx <= nRC_GXsfl_21 )
      {
         sendrow_212( ) ;
         nGXsfl_21_idx = ((subGrid_Islastpage==1)&&(nGXsfl_21_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_21_idx+1) ;
         sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_212( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 short AV8PaiCod ,
                                 String AV9idOperando ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV55ColumnsSelector ,
                                 String AV59Pgmname ,
                                 short AV15OrderedBy ,
                                 boolean AV16OrderedDsc ,
                                 String AV19TFCalParNombre ,
                                 GXSimpleCollection<String> AV20TFCalParNombre_Sels ,
                                 String AV22TFCalParDesc ,
                                 GXSimpleCollection<String> AV23TFCalParDesc_Sels ,
                                 String AV25TFCalParCampo ,
                                 GXSimpleCollection<String> AV26TFCalParCampo_Sels ,
                                 String AV28TFCalParValLista ,
                                 GXSimpleCollection<String> AV29TFCalParValLista_Sels ,
                                 String AV31TFCalParDef ,
                                 GXSimpleCollection<String> AV32TFCalParDef_Sels ,
                                 byte AV33TFCalParObl_Sel ,
                                 byte AV34TFCalParGrp ,
                                 byte AV35TFCalParGrp_To ,
                                 byte AV36TFCalParGrpDep ,
                                 byte AV37TFCalParGrpDep_To ,
                                 String AV39TFCalParEjemplo ,
                                 GXSimpleCollection<String> AV40TFCalParEjemplo_Sels ,
                                 String AV42TFCalParEjemExpli ,
                                 GXSimpleCollection<String> AV43TFCalParEjemExpli_Sels ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16MA2 ();
      GRID_nCurrentRecord = 0 ;
      rfMA2( ) ;
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
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfMA2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV59Pgmname = "Calculo_parametrosTab" ;
      Gx_err = (short)(0) ;
   }

   public void rfMA2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(21) ;
      /* Execute user event: Refresh */
      e16MA2 ();
      nGXsfl_21_idx = 1 ;
      sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_212( ) ;
      bGXsfl_21_Refreshing = true ;
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
         subsflControlProps_212( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A2110CalParNombre ,
                                              AV20TFCalParNombre_Sels ,
                                              A2100CalParDesc ,
                                              AV23TFCalParDesc_Sels ,
                                              A2099CalParCampo ,
                                              AV26TFCalParCampo_Sels ,
                                              A2111CalParValLista ,
                                              AV29TFCalParValLista_Sels ,
                                              A2107CalParDef ,
                                              AV32TFCalParDef_Sels ,
                                              A2108CalParEjemplo ,
                                              AV40TFCalParEjemplo_Sels ,
                                              A2109CalParEjemExpli ,
                                              AV43TFCalParEjemExpli_Sels ,
                                              Integer.valueOf(AV20TFCalParNombre_Sels.size()) ,
                                              AV19TFCalParNombre ,
                                              Integer.valueOf(AV23TFCalParDesc_Sels.size()) ,
                                              AV22TFCalParDesc ,
                                              Integer.valueOf(AV26TFCalParCampo_Sels.size()) ,
                                              AV25TFCalParCampo ,
                                              Integer.valueOf(AV29TFCalParValLista_Sels.size()) ,
                                              AV28TFCalParValLista ,
                                              Integer.valueOf(AV32TFCalParDef_Sels.size()) ,
                                              AV31TFCalParDef ,
                                              Byte.valueOf(AV33TFCalParObl_Sel) ,
                                              Byte.valueOf(AV34TFCalParGrp) ,
                                              Byte.valueOf(AV35TFCalParGrp_To) ,
                                              Byte.valueOf(AV36TFCalParGrpDep) ,
                                              Byte.valueOf(AV37TFCalParGrpDep_To) ,
                                              Integer.valueOf(AV40TFCalParEjemplo_Sels.size()) ,
                                              AV39TFCalParEjemplo ,
                                              Integer.valueOf(AV43TFCalParEjemExpli_Sels.size()) ,
                                              AV42TFCalParEjemExpli ,
                                              Boolean.valueOf(A2106CalParObl) ,
                                              Byte.valueOf(A2104CalParGrp) ,
                                              Byte.valueOf(A2105CalParGrpDep) ,
                                              Short.valueOf(AV15OrderedBy) ,
                                              Boolean.valueOf(AV16OrderedDsc) ,
                                              Short.valueOf(AV8PaiCod) ,
                                              AV9idOperando ,
                                              Short.valueOf(A46PaiCod) ,
                                              A74idOperando } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                              TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                              }
         });
         lV19TFCalParNombre = GXutil.concat( GXutil.rtrim( AV19TFCalParNombre), "%", "") ;
         lV22TFCalParDesc = GXutil.concat( GXutil.rtrim( AV22TFCalParDesc), "%", "") ;
         lV25TFCalParCampo = GXutil.concat( GXutil.rtrim( AV25TFCalParCampo), "%", "") ;
         lV28TFCalParValLista = GXutil.concat( GXutil.rtrim( AV28TFCalParValLista), "%", "") ;
         lV31TFCalParDef = GXutil.padr( GXutil.rtrim( AV31TFCalParDef), 20, "%") ;
         lV39TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV39TFCalParEjemplo), "%", "") ;
         lV42TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV42TFCalParEjemExpli), "%", "") ;
         /* Using cursor H00MA2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9idOperando, lV19TFCalParNombre, lV22TFCalParDesc, lV25TFCalParCampo, lV28TFCalParValLista, lV31TFCalParDef, Byte.valueOf(AV34TFCalParGrp), Byte.valueOf(AV35TFCalParGrp_To), Byte.valueOf(AV36TFCalParGrpDep), Byte.valueOf(AV37TFCalParGrpDep_To), lV39TFCalParEjemplo, lV42TFCalParEjemExpli, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_21_idx = 1 ;
         sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_212( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A46PaiCod = H00MA2_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A74idOperando = H00MA2_A74idOperando[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
            A2109CalParEjemExpli = H00MA2_A2109CalParEjemExpli[0] ;
            A2108CalParEjemplo = H00MA2_A2108CalParEjemplo[0] ;
            A2105CalParGrpDep = H00MA2_A2105CalParGrpDep[0] ;
            A2104CalParGrp = H00MA2_A2104CalParGrp[0] ;
            A2106CalParObl = H00MA2_A2106CalParObl[0] ;
            A2107CalParDef = H00MA2_A2107CalParDef[0] ;
            A2111CalParValLista = H00MA2_A2111CalParValLista[0] ;
            A2099CalParCampo = H00MA2_A2099CalParCampo[0] ;
            A2100CalParDesc = H00MA2_A2100CalParDesc[0] ;
            A2110CalParNombre = H00MA2_A2110CalParNombre[0] ;
            A2098CalParId = H00MA2_A2098CalParId[0] ;
            e17MA2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(21) ;
         wbMA0( ) ;
      }
      bGXsfl_21_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesMA2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV59Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV59Pgmname, ""))));
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
                                           A2110CalParNombre ,
                                           AV20TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV23TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV26TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV29TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV32TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV40TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV43TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV20TFCalParNombre_Sels.size()) ,
                                           AV19TFCalParNombre ,
                                           Integer.valueOf(AV23TFCalParDesc_Sels.size()) ,
                                           AV22TFCalParDesc ,
                                           Integer.valueOf(AV26TFCalParCampo_Sels.size()) ,
                                           AV25TFCalParCampo ,
                                           Integer.valueOf(AV29TFCalParValLista_Sels.size()) ,
                                           AV28TFCalParValLista ,
                                           Integer.valueOf(AV32TFCalParDef_Sels.size()) ,
                                           AV31TFCalParDef ,
                                           Byte.valueOf(AV33TFCalParObl_Sel) ,
                                           Byte.valueOf(AV34TFCalParGrp) ,
                                           Byte.valueOf(AV35TFCalParGrp_To) ,
                                           Byte.valueOf(AV36TFCalParGrpDep) ,
                                           Byte.valueOf(AV37TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV40TFCalParEjemplo_Sels.size()) ,
                                           AV39TFCalParEjemplo ,
                                           Integer.valueOf(AV43TFCalParEjemExpli_Sels.size()) ,
                                           AV42TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV15OrderedBy) ,
                                           Boolean.valueOf(AV16OrderedDsc) ,
                                           Short.valueOf(AV8PaiCod) ,
                                           AV9idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV19TFCalParNombre = GXutil.concat( GXutil.rtrim( AV19TFCalParNombre), "%", "") ;
      lV22TFCalParDesc = GXutil.concat( GXutil.rtrim( AV22TFCalParDesc), "%", "") ;
      lV25TFCalParCampo = GXutil.concat( GXutil.rtrim( AV25TFCalParCampo), "%", "") ;
      lV28TFCalParValLista = GXutil.concat( GXutil.rtrim( AV28TFCalParValLista), "%", "") ;
      lV31TFCalParDef = GXutil.padr( GXutil.rtrim( AV31TFCalParDef), 20, "%") ;
      lV39TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV39TFCalParEjemplo), "%", "") ;
      lV42TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV42TFCalParEjemExpli), "%", "") ;
      /* Using cursor H00MA3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV8PaiCod), AV9idOperando, lV19TFCalParNombre, lV22TFCalParDesc, lV25TFCalParCampo, lV28TFCalParValLista, lV31TFCalParDef, Byte.valueOf(AV34TFCalParGrp), Byte.valueOf(AV35TFCalParGrp_To), Byte.valueOf(AV36TFCalParGrpDep), Byte.valueOf(AV37TFCalParGrpDep_To), lV39TFCalParEjemplo, lV42TFCalParEjemExpli});
      GRID_nRecordCount = H00MA3_AGRID_nRecordCount[0] ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8PaiCod, AV9idOperando, AV55ColumnsSelector, AV59Pgmname, AV15OrderedBy, AV16OrderedDsc, AV19TFCalParNombre, AV20TFCalParNombre_Sels, AV22TFCalParDesc, AV23TFCalParDesc_Sels, AV25TFCalParCampo, AV26TFCalParCampo_Sels, AV28TFCalParValLista, AV29TFCalParValLista_Sels, AV31TFCalParDef, AV32TFCalParDef_Sels, AV33TFCalParObl_Sel, AV34TFCalParGrp, AV35TFCalParGrp_To, AV36TFCalParGrpDep, AV37TFCalParGrpDep_To, AV39TFCalParEjemplo, AV40TFCalParEjemplo_Sels, AV42TFCalParEjemExpli, AV43TFCalParEjemExpli_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8PaiCod, AV9idOperando, AV55ColumnsSelector, AV59Pgmname, AV15OrderedBy, AV16OrderedDsc, AV19TFCalParNombre, AV20TFCalParNombre_Sels, AV22TFCalParDesc, AV23TFCalParDesc_Sels, AV25TFCalParCampo, AV26TFCalParCampo_Sels, AV28TFCalParValLista, AV29TFCalParValLista_Sels, AV31TFCalParDef, AV32TFCalParDef_Sels, AV33TFCalParObl_Sel, AV34TFCalParGrp, AV35TFCalParGrp_To, AV36TFCalParGrpDep, AV37TFCalParGrpDep_To, AV39TFCalParEjemplo, AV40TFCalParEjemplo_Sels, AV42TFCalParEjemExpli, AV43TFCalParEjemExpli_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8PaiCod, AV9idOperando, AV55ColumnsSelector, AV59Pgmname, AV15OrderedBy, AV16OrderedDsc, AV19TFCalParNombre, AV20TFCalParNombre_Sels, AV22TFCalParDesc, AV23TFCalParDesc_Sels, AV25TFCalParCampo, AV26TFCalParCampo_Sels, AV28TFCalParValLista, AV29TFCalParValLista_Sels, AV31TFCalParDef, AV32TFCalParDef_Sels, AV33TFCalParObl_Sel, AV34TFCalParGrp, AV35TFCalParGrp_To, AV36TFCalParGrpDep, AV37TFCalParGrpDep_To, AV39TFCalParEjemplo, AV40TFCalParEjemplo_Sels, AV42TFCalParEjemExpli, AV43TFCalParEjemExpli_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8PaiCod, AV9idOperando, AV55ColumnsSelector, AV59Pgmname, AV15OrderedBy, AV16OrderedDsc, AV19TFCalParNombre, AV20TFCalParNombre_Sels, AV22TFCalParDesc, AV23TFCalParDesc_Sels, AV25TFCalParCampo, AV26TFCalParCampo_Sels, AV28TFCalParValLista, AV29TFCalParValLista_Sels, AV31TFCalParDef, AV32TFCalParDef_Sels, AV33TFCalParObl_Sel, AV34TFCalParGrp, AV35TFCalParGrp_To, AV36TFCalParGrpDep, AV37TFCalParGrpDep_To, AV39TFCalParEjemplo, AV40TFCalParEjemplo_Sels, AV42TFCalParEjemExpli, AV43TFCalParEjemExpli_Sels, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV8PaiCod, AV9idOperando, AV55ColumnsSelector, AV59Pgmname, AV15OrderedBy, AV16OrderedDsc, AV19TFCalParNombre, AV20TFCalParNombre_Sels, AV22TFCalParDesc, AV23TFCalParDesc_Sels, AV25TFCalParCampo, AV26TFCalParCampo_Sels, AV28TFCalParValLista, AV29TFCalParValLista_Sels, AV31TFCalParDef, AV32TFCalParDef_Sels, AV33TFCalParObl_Sel, AV34TFCalParGrp, AV35TFCalParGrp_To, AV36TFCalParGrpDep, AV37TFCalParGrpDep_To, AV39TFCalParEjemplo, AV40TFCalParEjemplo_Sels, AV42TFCalParEjemExpli, AV43TFCalParEjemExpli_Sels, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV59Pgmname = "Calculo_parametrosTab" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupMA0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15MA2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV44DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCOLUMNSSELECTOR"), AV55ColumnsSelector);
         /* Read saved values. */
         nRC_GXsfl_21 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_21"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV47GridCurrentPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV48GridPageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV49GridAppliedFilters = httpContext.cgiGet( sPrefix+"vGRIDAPPLIEDFILTERS") ;
         wcpOAV8PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV9idOperando = httpContext.cgiGet( sPrefix+"wcpOAV9idOperando") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( sPrefix+"DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
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
         A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         cmbidOperando.setName( cmbidOperando.getInternalname() );
         cmbidOperando.setValue( httpContext.cgiGet( cmbidOperando.getInternalname()) );
         A74idOperando = httpContext.cgiGet( cmbidOperando.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A74idOperando", A74idOperando);
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
      e15MA2 ();
      if (returnInSub) return;
   }

   public void e15MA2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV50CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      calculo_parametrostab_impl.this.GXt_int1 = GXv_int2[0] ;
      AV50CliCod = GXt_int1 ;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, sPrefix, false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      cmbidOperando.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbidOperando.getInternalname(), "Visible", GXutil.ltrimstr( cmbidOperando.getVisible(), 5, 0), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV15OrderedBy < 1 )
      {
         AV15OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV44DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV44DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, sPrefix, false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e16MA2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV50CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      calculo_parametrostab_impl.this.GXt_int1 = GXv_int2[0] ;
      AV50CliCod = GXt_int1 ;
      GXv_SdtWWPContext5[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV6WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV17Session.getValue("Calculo_parametrosTabColumnsSelector"), "") != 0 )
      {
         AV53ColumnsSelectorXML = AV17Session.getValue("Calculo_parametrosTabColumnsSelector") ;
         AV55ColumnsSelector.fromxml(AV53ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S152 ();
         if (returnInSub) return;
      }
      edtCalParNombre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParNombre_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParDesc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParDesc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDesc_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParCampo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParCampo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParCampo_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParValLista_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParValLista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParValLista_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParDef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParDef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParDef_Visible), 5, 0), !bGXsfl_21_Refreshing);
      chkCalParObl.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCalParObl.getInternalname(), "Visible", GXutil.ltrimstr( chkCalParObl.getVisible(), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParGrp_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParGrp_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParGrp_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParGrpDep_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParGrpDep_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParGrpDep_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParEjemplo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParEjemplo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParEjemplo_Visible), 5, 0), !bGXsfl_21_Refreshing);
      edtCalParEjemExpli_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV55ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCalParEjemExpli_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCalParEjemExpli_Visible), 5, 0), !bGXsfl_21_Refreshing);
      AV47GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47GridCurrentPage), 10, 0));
      AV48GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48GridPageCount), 10, 0));
      GXt_char6 = AV49GridAppliedFilters ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV59Pgmname, GXv_char7) ;
      calculo_parametrostab_impl.this.GXt_char6 = GXv_char7[0] ;
      AV49GridAppliedFilters = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49GridAppliedFilters", AV49GridAppliedFilters);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV55ColumnsSelector", AV55ColumnsSelector);
   }

   public void e12MA2( )
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
         AV46PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV46PageToGo) ;
      }
   }

   public void e13MA2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e14MA2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV15OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
         AV16OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedDsc", AV16OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParNombre") == 0 )
         {
            AV19TFCalParNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TFCalParNombre", AV19TFCalParNombre);
            AV18TFCalParNombre_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18TFCalParNombre_SelsJson", AV18TFCalParNombre_SelsJson);
            AV20TFCalParNombre_Sels.fromJSonString(AV18TFCalParNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParDesc") == 0 )
         {
            AV22TFCalParDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TFCalParDesc", AV22TFCalParDesc);
            AV21TFCalParDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21TFCalParDesc_SelsJson", AV21TFCalParDesc_SelsJson);
            AV23TFCalParDesc_Sels.fromJSonString(AV21TFCalParDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParCampo") == 0 )
         {
            AV25TFCalParCampo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFCalParCampo", AV25TFCalParCampo);
            AV24TFCalParCampo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24TFCalParCampo_SelsJson", AV24TFCalParCampo_SelsJson);
            AV26TFCalParCampo_Sels.fromJSonString(AV24TFCalParCampo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParValLista") == 0 )
         {
            AV28TFCalParValLista = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFCalParValLista", AV28TFCalParValLista);
            AV27TFCalParValLista_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFCalParValLista_SelsJson", AV27TFCalParValLista_SelsJson);
            AV29TFCalParValLista_Sels.fromJSonString(AV27TFCalParValLista_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParDef") == 0 )
         {
            AV31TFCalParDef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFCalParDef", AV31TFCalParDef);
            AV30TFCalParDef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFCalParDef_SelsJson", AV30TFCalParDef_SelsJson);
            AV32TFCalParDef_Sels.fromJSonString(AV30TFCalParDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParObl") == 0 )
         {
            AV33TFCalParObl_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFCalParObl_Sel", GXutil.str( AV33TFCalParObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParGrp") == 0 )
         {
            AV34TFCalParGrp = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFCalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFCalParGrp), 2, 0));
            AV35TFCalParGrp_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFCalParGrp_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFCalParGrp_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParGrpDep") == 0 )
         {
            AV36TFCalParGrpDep = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFCalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFCalParGrpDep), 2, 0));
            AV37TFCalParGrpDep_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFCalParGrpDep_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFCalParGrpDep_To), 2, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParEjemplo") == 0 )
         {
            AV39TFCalParEjemplo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFCalParEjemplo", AV39TFCalParEjemplo);
            AV38TFCalParEjemplo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFCalParEjemplo_SelsJson", AV38TFCalParEjemplo_SelsJson);
            AV40TFCalParEjemplo_Sels.fromJSonString(AV38TFCalParEjemplo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CalParEjemExpli") == 0 )
         {
            AV42TFCalParEjemExpli = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFCalParEjemExpli", AV42TFCalParEjemExpli);
            AV41TFCalParEjemExpli_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TFCalParEjemExpli_SelsJson", AV41TFCalParEjemExpli_SelsJson);
            AV43TFCalParEjemExpli_Sels.fromJSonString(AV41TFCalParEjemExpli_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV43TFCalParEjemExpli_Sels", AV43TFCalParEjemExpli_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV40TFCalParEjemplo_Sels", AV40TFCalParEjemplo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV32TFCalParDef_Sels", AV32TFCalParDef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV29TFCalParValLista_Sels", AV29TFCalParValLista_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV26TFCalParCampo_Sels", AV26TFCalParCampo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV23TFCalParDesc_Sels", AV23TFCalParDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV20TFCalParNombre_Sels", AV20TFCalParNombre_Sels);
   }

   private void e17MA2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(21) ;
      }
      sendrow_212( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_21_Refreshing )
      {
         httpContext.doAjaxLoad(21, GridRow);
      }
   }

   public void e11MA2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV53ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV55ColumnsSelector.fromJSonString(AV53ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Calculo_parametrosTabColumnsSelector", ((GXutil.strcmp("", AV53ColumnsSelectorXML)==0) ? "" : AV55ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV55ColumnsSelector", AV55ColumnsSelector);
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV15OrderedBy, 4, 0))+":"+(AV16OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV55ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParNombre", "", "Nombre", false, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParDesc", "", "Descripción", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParCampo", "", "Tabla y campo o expresión regular", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParValLista", "", "Lista de valores válidos", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParDef", "", "Valor por omisión", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParObl", "", "Obligatorio", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParGrp", "", "Grupo", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParGrpDep", "", "Dependencia grupo", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParEjemplo", "", "Ejemplo", true, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV55ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "CalParEjemExpli", "", "Explicación de ejemplo", false, "") ;
      AV55ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV54UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Calculo_parametrosTabColumnsSelector", GXv_char7) ;
      calculo_parametrostab_impl.this.GXt_char6 = GXv_char7[0] ;
      AV54UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV54UserCustomValue)==0) ) )
      {
         AV56ColumnsSelectorAux.fromxml(AV54UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV56ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV55ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV56ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV55ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV17Session.getValue(AV59Pgmname+"GridState"), "") == 0 )
      {
         AV13GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV59Pgmname+"GridState"), null, null);
      }
      else
      {
         AV13GridState.fromxml(AV17Session.getValue(AV59Pgmname+"GridState"), null, null);
      }
      AV15OrderedBy = AV13GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
      AV16OrderedDsc = AV13GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16OrderedDsc", AV16OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV60GXV1 = 1 ;
      while ( AV60GXV1 <= AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV60GXV1));
         if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARNOMBRE") == 0 )
         {
            AV19TFCalParNombre = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19TFCalParNombre", AV19TFCalParNombre);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARNOMBRE_SEL") == 0 )
         {
            AV18TFCalParNombre_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18TFCalParNombre_SelsJson", AV18TFCalParNombre_SelsJson);
            AV20TFCalParNombre_Sels.fromJSonString(AV18TFCalParNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDESC") == 0 )
         {
            AV22TFCalParDesc = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TFCalParDesc", AV22TFCalParDesc);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDESC_SEL") == 0 )
         {
            AV21TFCalParDesc_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21TFCalParDesc_SelsJson", AV21TFCalParDesc_SelsJson);
            AV23TFCalParDesc_Sels.fromJSonString(AV21TFCalParDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARCAMPO") == 0 )
         {
            AV25TFCalParCampo = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25TFCalParCampo", AV25TFCalParCampo);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARCAMPO_SEL") == 0 )
         {
            AV24TFCalParCampo_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24TFCalParCampo_SelsJson", AV24TFCalParCampo_SelsJson);
            AV26TFCalParCampo_Sels.fromJSonString(AV24TFCalParCampo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARVALLISTA") == 0 )
         {
            AV28TFCalParValLista = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28TFCalParValLista", AV28TFCalParValLista);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARVALLISTA_SEL") == 0 )
         {
            AV27TFCalParValLista_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TFCalParValLista_SelsJson", AV27TFCalParValLista_SelsJson);
            AV29TFCalParValLista_Sels.fromJSonString(AV27TFCalParValLista_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDEF") == 0 )
         {
            AV31TFCalParDef = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31TFCalParDef", AV31TFCalParDef);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDEF_SEL") == 0 )
         {
            AV30TFCalParDef_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30TFCalParDef_SelsJson", AV30TFCalParDef_SelsJson);
            AV32TFCalParDef_Sels.fromJSonString(AV30TFCalParDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAROBL_SEL") == 0 )
         {
            AV33TFCalParObl_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33TFCalParObl_Sel", GXutil.str( AV33TFCalParObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARGRP") == 0 )
         {
            AV34TFCalParGrp = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34TFCalParGrp", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34TFCalParGrp), 2, 0));
            AV35TFCalParGrp_To = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35TFCalParGrp_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35TFCalParGrp_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARGRPDEP") == 0 )
         {
            AV36TFCalParGrpDep = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36TFCalParGrpDep", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36TFCalParGrpDep), 2, 0));
            AV37TFCalParGrpDep_To = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37TFCalParGrpDep_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFCalParGrpDep_To), 2, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMPLO") == 0 )
         {
            AV39TFCalParEjemplo = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39TFCalParEjemplo", AV39TFCalParEjemplo);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMPLO_SEL") == 0 )
         {
            AV38TFCalParEjemplo_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38TFCalParEjemplo_SelsJson", AV38TFCalParEjemplo_SelsJson);
            AV40TFCalParEjemplo_Sels.fromJSonString(AV38TFCalParEjemplo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMEXPLI") == 0 )
         {
            AV42TFCalParEjemExpli = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42TFCalParEjemExpli", AV42TFCalParEjemExpli);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMEXPLI_SEL") == 0 )
         {
            AV41TFCalParEjemExpli_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TFCalParEjemExpli_SelsJson", AV41TFCalParEjemExpli_SelsJson);
            AV43TFCalParEjemExpli_Sels.fromJSonString(AV41TFCalParEjemExpli_SelsJson, null);
         }
         AV60GXV1 = (int)(AV60GXV1+1) ;
      }
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV20TFCalParNombre_Sels.size()==0), AV18TFCalParNombre_SelsJson, GXv_char7) ;
      calculo_parametrostab_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV23TFCalParDesc_Sels.size()==0), AV21TFCalParDesc_SelsJson, GXv_char11) ;
      calculo_parametrostab_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV26TFCalParCampo_Sels.size()==0), AV24TFCalParCampo_SelsJson, GXv_char13) ;
      calculo_parametrostab_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV29TFCalParValLista_Sels.size()==0), AV27TFCalParValLista_SelsJson, GXv_char15) ;
      calculo_parametrostab_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV32TFCalParDef_Sels.size()==0), AV30TFCalParDef_SelsJson, GXv_char17) ;
      calculo_parametrostab_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV40TFCalParEjemplo_Sels.size()==0), AV38TFCalParEjemplo_SelsJson, GXv_char19) ;
      calculo_parametrostab_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV43TFCalParEjemExpli_Sels.size()==0), AV41TFCalParEjemExpli_SelsJson, GXv_char21) ;
      calculo_parametrostab_impl.this.GXt_char20 = GXv_char21[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char6+"|"+GXt_char10+"|"+GXt_char12+"|"+GXt_char14+"|"+GXt_char16+"|"+((0==AV33TFCalParObl_Sel) ? "" : GXutil.str( AV33TFCalParObl_Sel, 1, 0))+"|||"+GXt_char18+"|"+GXt_char20 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV19TFCalParNombre)==0), AV19TFCalParNombre, GXv_char21) ;
      calculo_parametrostab_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV22TFCalParDesc)==0), AV22TFCalParDesc, GXv_char19) ;
      calculo_parametrostab_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV25TFCalParCampo)==0), AV25TFCalParCampo, GXv_char17) ;
      calculo_parametrostab_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFCalParValLista)==0), AV28TFCalParValLista, GXv_char15) ;
      calculo_parametrostab_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFCalParDef)==0), AV31TFCalParDef, GXv_char13) ;
      calculo_parametrostab_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV39TFCalParEjemplo)==0), AV39TFCalParEjemplo, GXv_char11) ;
      calculo_parametrostab_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV42TFCalParEjemExpli)==0), AV42TFCalParEjemExpli, GXv_char7) ;
      calculo_parametrostab_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = GXt_char20+"|"+GXt_char18+"|"+GXt_char16+"|"+GXt_char14+"|"+GXt_char12+"||"+((0==AV34TFCalParGrp) ? "" : GXutil.str( AV34TFCalParGrp, 2, 0))+"|"+((0==AV36TFCalParGrpDep) ? "" : GXutil.str( AV36TFCalParGrpDep, 2, 0))+"|"+GXt_char10+"|"+GXt_char6 ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||"+((0==AV35TFCalParGrp_To) ? "" : GXutil.str( AV35TFCalParGrp_To, 2, 0))+"|"+((0==AV37TFCalParGrpDep_To) ? "" : GXutil.str( AV37TFCalParGrpDep_To, 2, 0))+"||" ;
      ucDdo_grid.sendProperty(context, sPrefix, false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV13GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV13GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV13GridState.fromxml(AV17Session.getValue(AV59Pgmname+"GridState"), null, null);
      AV13GridState.setgxTv_SdtWWPGridState_Orderedby( AV15OrderedBy );
      AV13GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV16OrderedDsc );
      AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARNOMBRE", httpContext.getMessage( "Nombre", ""), !(GXutil.strcmp("", AV19TFCalParNombre)==0), (short)(0), AV19TFCalParNombre, "", !(AV20TFCalParNombre_Sels.size()==0), AV20TFCalParNombre_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARDESC", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV22TFCalParDesc)==0), (short)(0), AV22TFCalParDesc, "", !(AV23TFCalParDesc_Sels.size()==0), AV23TFCalParDesc_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARCAMPO", httpContext.getMessage( "Tabla y campo o expresión regular", ""), !(GXutil.strcmp("", AV25TFCalParCampo)==0), (short)(0), AV25TFCalParCampo, "", !(AV26TFCalParCampo_Sels.size()==0), AV26TFCalParCampo_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARVALLISTA", httpContext.getMessage( "Lista de valores válidos", ""), !(GXutil.strcmp("", AV28TFCalParValLista)==0), (short)(0), AV28TFCalParValLista, "", !(AV29TFCalParValLista_Sels.size()==0), AV29TFCalParValLista_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARDEF", httpContext.getMessage( "Valor por omisión", ""), !(GXutil.strcmp("", AV31TFCalParDef)==0), (short)(0), AV31TFCalParDef, "", !(AV32TFCalParDef_Sels.size()==0), AV32TFCalParDef_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPAROBL_SEL", httpContext.getMessage( "Obligatorio", ""), !(0==AV33TFCalParObl_Sel), (short)(0), GXutil.trim( GXutil.str( AV33TFCalParObl_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARGRP", httpContext.getMessage( "Grupo", ""), !((0==AV34TFCalParGrp)&&(0==AV35TFCalParGrp_To)), (short)(0), GXutil.trim( GXutil.str( AV34TFCalParGrp, 2, 0)), GXutil.trim( GXutil.str( AV35TFCalParGrp_To, 2, 0))) ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPARGRPDEP", httpContext.getMessage( "Dependencia grupo", ""), !((0==AV36TFCalParGrpDep)&&(0==AV37TFCalParGrpDep_To)), (short)(0), GXutil.trim( GXutil.str( AV36TFCalParGrpDep, 2, 0)), GXutil.trim( GXutil.str( AV37TFCalParGrpDep_To, 2, 0))) ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPAREJEMPLO", httpContext.getMessage( "Ejemplo", ""), !(GXutil.strcmp("", AV39TFCalParEjemplo)==0), (short)(0), AV39TFCalParEjemplo, "", !(AV40TFCalParEjemplo_Sels.size()==0), AV40TFCalParEjemplo_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      GXv_SdtWWPGridState22[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState22, "TFCALPAREJEMEXPLI", httpContext.getMessage( "Explicación de ejemplo", ""), !(GXutil.strcmp("", AV42TFCalParEjemExpli)==0), (short)(0), AV42TFCalParEjemExpli, "", !(AV43TFCalParEjemExpli_Sels.size()==0), AV43TFCalParEjemExpli_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState22[0] ;
      if ( ! (0==AV8PaiCod) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&PAICOD" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV8PaiCod, 4, 0) );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      if ( ! (GXutil.strcmp("", AV9idOperando)==0) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&IDOPERANDO" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV9idOperando );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      AV13GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV59Pgmname+"GridState", AV13GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV11TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV59Pgmname );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Calculo_parametros" );
      AV12TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "PaiCod" );
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8PaiCod, 4, 0) );
      AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV12TrnContextAtt, 0);
      AV12TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "idOperando" );
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV9idOperando );
      AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV12TrnContextAtt, 0);
      AV17Session.setValue("TrnContext", AV11TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void wb_table1_6_MA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         wb_table2_9_MA2( true) ;
      }
      else
      {
         wb_table2_9_MA2( false) ;
      }
      return  ;
   }

   public void wb_table2_9_MA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol21( ) ;
      }
      if ( wbEnd == 21 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_21 = (int)(nGXsfl_21_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV47GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV48GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV49GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, sPrefix+"GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_6_MA2e( true) ;
      }
      else
      {
         wb_table1_6_MA2e( false) ;
      }
   }

   public void wb_table2_9_MA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltrospadre_Internalname, tblTablefiltrospadre_Internalname, "", "TableBlanca", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table3_12_MA2( true) ;
      }
      else
      {
         wb_table3_12_MA2( false) ;
      }
      return  ;
   }

   public void wb_table3_12_MA2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_9_MA2e( true) ;
      }
      else
      {
         wb_table2_9_MA2e( false) ;
      }
   }

   public void wb_table3_12_MA2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV44DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV55ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, sPrefix+"DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_12_MA2e( true) ;
      }
      else
      {
         wb_table3_12_MA2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV8PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiCod), 4, 0));
      AV9idOperando = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9idOperando", AV9idOperando);
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
      paMA2( ) ;
      wsMA2( ) ;
      weMA2( ) ;
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
      sCtrlAV8PaiCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV9idOperando = (String)getParm(obj,1,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paMA2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "calculo_parametrostab", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paMA2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV8PaiCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiCod), 4, 0));
         AV9idOperando = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9idOperando", AV9idOperando);
      }
      wcpOAV8PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV8PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV9idOperando = httpContext.cgiGet( sPrefix+"wcpOAV9idOperando") ;
      if ( ! GetJustCreated( ) && ( ( AV8PaiCod != wcpOAV8PaiCod ) || ( GXutil.strcmp(AV9idOperando, wcpOAV9idOperando) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOAV8PaiCod = AV8PaiCod ;
      wcpOAV9idOperando = AV9idOperando ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV8PaiCod = httpContext.cgiGet( sPrefix+"AV8PaiCod_CTRL") ;
      if ( GXutil.len( sCtrlAV8PaiCod) > 0 )
      {
         AV8PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV8PaiCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8PaiCod), 4, 0));
      }
      else
      {
         AV8PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV8PaiCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV9idOperando = httpContext.cgiGet( sPrefix+"AV9idOperando_CTRL") ;
      if ( GXutil.len( sCtrlAV9idOperando) > 0 )
      {
         AV9idOperando = httpContext.cgiGet( sCtrlAV9idOperando) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9idOperando", AV9idOperando);
      }
      else
      {
         AV9idOperando = httpContext.cgiGet( sPrefix+"AV9idOperando_PARM") ;
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
      paMA2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsMA2( ) ;
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
      wsMA2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8PaiCod_PARM", GXutil.ltrim( localUtil.ntoc( AV8PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8PaiCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8PaiCod_CTRL", GXutil.rtrim( sCtrlAV8PaiCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9idOperando_PARM", GXutil.rtrim( AV9idOperando));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV9idOperando)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV9idOperando_CTRL", GXutil.rtrim( sCtrlAV9idOperando));
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
      weMA2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412201942177", true, true);
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
      httpContext.AddJavascriptSource("calculo_parametrostab.js", "?202412201942178", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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

   public void subsflControlProps_212( )
   {
      cmbCalParId.setInternalname( sPrefix+"CALPARID_"+sGXsfl_21_idx );
      edtCalParNombre_Internalname = sPrefix+"CALPARNOMBRE_"+sGXsfl_21_idx ;
      edtCalParDesc_Internalname = sPrefix+"CALPARDESC_"+sGXsfl_21_idx ;
      edtCalParCampo_Internalname = sPrefix+"CALPARCAMPO_"+sGXsfl_21_idx ;
      edtCalParValLista_Internalname = sPrefix+"CALPARVALLISTA_"+sGXsfl_21_idx ;
      edtCalParDef_Internalname = sPrefix+"CALPARDEF_"+sGXsfl_21_idx ;
      chkCalParObl.setInternalname( sPrefix+"CALPAROBL_"+sGXsfl_21_idx );
      edtCalParGrp_Internalname = sPrefix+"CALPARGRP_"+sGXsfl_21_idx ;
      edtCalParGrpDep_Internalname = sPrefix+"CALPARGRPDEP_"+sGXsfl_21_idx ;
      edtCalParEjemplo_Internalname = sPrefix+"CALPAREJEMPLO_"+sGXsfl_21_idx ;
      edtCalParEjemExpli_Internalname = sPrefix+"CALPAREJEMEXPLI_"+sGXsfl_21_idx ;
   }

   public void subsflControlProps_fel_212( )
   {
      cmbCalParId.setInternalname( sPrefix+"CALPARID_"+sGXsfl_21_fel_idx );
      edtCalParNombre_Internalname = sPrefix+"CALPARNOMBRE_"+sGXsfl_21_fel_idx ;
      edtCalParDesc_Internalname = sPrefix+"CALPARDESC_"+sGXsfl_21_fel_idx ;
      edtCalParCampo_Internalname = sPrefix+"CALPARCAMPO_"+sGXsfl_21_fel_idx ;
      edtCalParValLista_Internalname = sPrefix+"CALPARVALLISTA_"+sGXsfl_21_fel_idx ;
      edtCalParDef_Internalname = sPrefix+"CALPARDEF_"+sGXsfl_21_fel_idx ;
      chkCalParObl.setInternalname( sPrefix+"CALPAROBL_"+sGXsfl_21_fel_idx );
      edtCalParGrp_Internalname = sPrefix+"CALPARGRP_"+sGXsfl_21_fel_idx ;
      edtCalParGrpDep_Internalname = sPrefix+"CALPARGRPDEP_"+sGXsfl_21_fel_idx ;
      edtCalParEjemplo_Internalname = sPrefix+"CALPAREJEMPLO_"+sGXsfl_21_fel_idx ;
      edtCalParEjemExpli_Internalname = sPrefix+"CALPAREJEMEXPLI_"+sGXsfl_21_fel_idx ;
   }

   public void sendrow_212( )
   {
      subsflControlProps_212( ) ;
      wbMA0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_21_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_21_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_21_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbCalParId.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CALPARID_" + sGXsfl_21_idx ;
            cmbCalParId.setName( GXCCtl );
            cmbCalParId.setWebtags( "" );
            cmbCalParId.addItem("Devolver", httpContext.getMessage( "Cantidad ingresada en novedad \"C\" o Total \"T\" (valor por omisión)", ""), (short)(0));
            cmbCalParId.addItem("Calculo", httpContext.getMessage( "\"mejor\", o \"promedio\", o \"suma\" (valor por omisión)", ""), (short)(0));
            cmbCalParId.addItem("Periodo", httpContext.getMessage( "Periodo. Valores posibles: \"semestre\" para liquidaciones del semestre, \"acumulado\" para liquidaciones acumuladas en el año en curso, \"deMesesAnteriores\" para liquidaciones de periodos anteriores, \"liquidacionesAnteriores\", \"mismoPeriodo\" para liquidaciones del mismo periodo, \"anterioresDelPeriodo\" para liquidaciones anteriores del periodo (sin incluir el periodo liquidado), \"tramoGanancias\" para liquidaciones de periodos del mismo tramo de ganancias", ""), (short)(0));
            cmbCalParId.addItem("Concepto", httpContext.getMessage( "Código de concepto", ""), (short)(0));
            cmbCalParId.addItem("TipoLiq", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
            cmbCalParId.addItem("Adicional", httpContext.getMessage( "Código de adicional de convenio", ""), (short)(0));
            cmbCalParId.addItem("AdicionalOpcion", httpContext.getMessage( "Opción de adicional de convenio", ""), (short)(0));
            cmbCalParId.addItem("Area", httpContext.getMessage( "Area", ""), (short)(0));
            cmbCalParId.addItem("Categoria", httpContext.getMessage( "Categoría", ""), (short)(0));
            cmbCalParId.addItem("Clase", httpContext.getMessage( "Clase", ""), (short)(0));
            cmbCalParId.addItem("Convenio", httpContext.getMessage( "Convenio", ""), (short)(0));
            cmbCalParId.addItem("MotivoEgreso", httpContext.getMessage( "Motivo de egreso", ""), (short)(0));
            cmbCalParId.addItem("ObraSocial", httpContext.getMessage( "Obra Social", ""), (short)(0));
            cmbCalParId.addItem("Sexo", httpContext.getMessage( "Sexo", ""), (short)(0));
            cmbCalParId.addItem("Sindicato", httpContext.getMessage( "Sindicato", ""), (short)(0));
            cmbCalParId.addItem("Tipo de trabajo", httpContext.getMessage( "TipoTrabajo", ""), (short)(0));
            cmbCalParId.addItem("Dia", httpContext.getMessage( "Día", ""), (short)(0));
            cmbCalParId.addItem("TipoObligacion", httpContext.getMessage( "Tipo de obligación", ""), (short)(0));
            cmbCalParId.addItem("AplIIGG", httpContext.getMessage( "Código de tratamiento de exención", ""), (short)(0));
            cmbCalParId.addItem("TipoDeConcepto", httpContext.getMessage( "Solo de tipo de concepto determinado", ""), (short)(0));
            cmbCalParId.addItem("SueldoBasico", httpContext.getMessage( "Sueldo básico fuera de convenio", ""), (short)(0));
            cmbCalParId.addItem("PropiedadAdicional", httpContext.getMessage( "Propiedad Adicional de legajo por convenio", ""), (short)(0));
            if ( cmbCalParId.getItemCount() > 0 )
            {
               A2098CalParId = cmbCalParId.getValidValue(A2098CalParId) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCalParId,cmbCalParId.getInternalname(),GXutil.rtrim( A2098CalParId),Integer.valueOf(1),cmbCalParId.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbCalParId.setValue( GXutil.rtrim( A2098CalParId) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCalParId.getInternalname(), "Values", cmbCalParId.ToJavascriptSource(), !bGXsfl_21_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParNombre_Internalname,A2110CalParNombre,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParDesc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParDesc_Internalname,A2100CalParDesc,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParDesc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParCampo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParCampo_Internalname,A2099CalParCampo,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParCampo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParCampo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParValLista_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParValLista_Internalname,A2111CalParValLista,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParValLista_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParValLista_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParDef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParDef_Internalname,GXutil.rtrim( A2107CalParDef),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParDef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParDef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"palabra","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkCalParObl.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CALPAROBL_" + sGXsfl_21_idx ;
         chkCalParObl.setName( GXCCtl );
         chkCalParObl.setWebtags( "" );
         chkCalParObl.setCaption( "" );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCalParObl.getInternalname(), "TitleCaption", chkCalParObl.getCaption(), !bGXsfl_21_Refreshing);
         chkCalParObl.setCheckedValue( "false" );
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkCalParObl.getInternalname(),GXutil.booltostr( A2106CalParObl),"","",Integer.valueOf(chkCalParObl.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCalParGrp_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParGrp_Internalname,GXutil.ltrim( localUtil.ntoc( A2104CalParGrp, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2104CalParGrp), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParGrp_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParGrp_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtCalParGrpDep_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParGrpDep_Internalname,GXutil.ltrim( localUtil.ntoc( A2105CalParGrpDep, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2105CalParGrpDep), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParGrpDep_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParGrpDep_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParEjemplo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParEjemplo_Internalname,A2108CalParEjemplo,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParEjemplo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParEjemplo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtCalParEjemExpli_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCalParEjemExpli_Internalname,A2109CalParEjemExpli,A2109CalParEjemExpli,"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCalParEjemExpli_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtCalParEjemExpli_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesMA2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_21_idx = ((subGrid_Islastpage==1)&&(nGXsfl_21_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_21_idx+1) ;
         sGXsfl_21_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_21_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_212( ) ;
      }
      /* End function sendrow_212 */
   }

   public void startgridcontrol21( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"21\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParDesc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParCampo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tabla y campo o expresión regular", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParValLista_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Lista de valores válidos", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParDef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Valor por omisión", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkCalParObl.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obligatorio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParGrp_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Grupo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParGrpDep_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Dependencia grupo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParEjemplo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Ejemplo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtCalParEjemExpli_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Explicación de ejemplo", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2098CalParId));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2110CalParNombre);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParNombre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2100CalParDesc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParDesc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2099CalParCampo);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParCampo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2111CalParValLista);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParValLista_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2107CalParDef));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParDef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2106CalParObl));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkCalParObl.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2104CalParGrp, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParGrp_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2105CalParGrpDep, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParGrpDep_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2108CalParEjemplo);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParEjemplo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2109CalParEjemExpli);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCalParEjemExpli_Visible, (byte)(5), (byte)(0), ".", "")));
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
      Ddo_gridcolumnsselector_Internalname = sPrefix+"DDO_GRIDCOLUMNSSELECTOR" ;
      tblTablefiltros_Internalname = sPrefix+"TABLEFILTROS" ;
      tblTablefiltrospadre_Internalname = sPrefix+"TABLEFILTROSPADRE" ;
      cmbCalParId.setInternalname( sPrefix+"CALPARID" );
      edtCalParNombre_Internalname = sPrefix+"CALPARNOMBRE" ;
      edtCalParDesc_Internalname = sPrefix+"CALPARDESC" ;
      edtCalParCampo_Internalname = sPrefix+"CALPARCAMPO" ;
      edtCalParValLista_Internalname = sPrefix+"CALPARVALLISTA" ;
      edtCalParDef_Internalname = sPrefix+"CALPARDEF" ;
      chkCalParObl.setInternalname( sPrefix+"CALPAROBL" );
      edtCalParGrp_Internalname = sPrefix+"CALPARGRP" ;
      edtCalParGrpDep_Internalname = sPrefix+"CALPARGRPDEP" ;
      edtCalParEjemplo_Internalname = sPrefix+"CALPAREJEMPLO" ;
      edtCalParEjemExpli_Internalname = sPrefix+"CALPAREJEMEXPLI" ;
      Gridpaginationbar_Internalname = sPrefix+"GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = sPrefix+"GRIDTABLEWITHPAGINATIONBAR" ;
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Ddo_grid_Internalname = sPrefix+"DDO_GRID" ;
      edtPaiCod_Internalname = sPrefix+"PAICOD" ;
      cmbidOperando.setInternalname( sPrefix+"IDOPERANDO" );
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
      edtCalParEjemExpli_Jsonclick = "" ;
      edtCalParEjemplo_Jsonclick = "" ;
      edtCalParGrpDep_Jsonclick = "" ;
      edtCalParGrp_Jsonclick = "" ;
      chkCalParObl.setCaption( "" );
      edtCalParDef_Jsonclick = "" ;
      edtCalParValLista_Jsonclick = "" ;
      edtCalParCampo_Jsonclick = "" ;
      edtCalParDesc_Jsonclick = "" ;
      edtCalParNombre_Jsonclick = "" ;
      cmbCalParId.setJsonclick( "" );
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtCalParEjemExpli_Visible = -1 ;
      edtCalParEjemplo_Visible = -1 ;
      edtCalParGrpDep_Visible = -1 ;
      edtCalParGrp_Visible = -1 ;
      chkCalParObl.setVisible( -1 );
      edtCalParDef_Visible = -1 ;
      edtCalParValLista_Visible = -1 ;
      edtCalParCampo_Visible = -1 ;
      edtCalParDesc_Visible = -1 ;
      edtCalParNombre_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      cmbidOperando.setJsonclick( "" );
      cmbidOperando.setVisible( 1 );
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "||||||2.0|2.0||" ;
      Ddo_grid_Datalistproc = "Calculo_parametrosTabGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||1:WWP_TSChecked,2:WWP_TSUnChecked||||" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|T|T||||T|T" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|||Dynamic|Dynamic" ;
      Ddo_grid_Includedatalist = "T|T|T|T|T|T|||T|T" ;
      Ddo_grid_Filterisrange = "||||||T|T||" ;
      Ddo_grid_Filtertype = "Character|Character|Character|Character|Character||Numeric|Numeric|Character|Character" ;
      Ddo_grid_Includefilter = "T|T|T|T|T||T|T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5|6|7|8|9|10|11" ;
      Ddo_grid_Columnids = "1:CalParNombre|2:CalParDesc|3:CalParCampo|4:CalParValLista|5:CalParDef|6:CalParObl|7:CalParGrp|8:CalParGrpDep|9:CalParEjemplo|10:CalParEjemExpli" ;
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
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
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
      GXCCtl = "CALPARID_" + sGXsfl_21_idx ;
      cmbCalParId.setName( GXCCtl );
      cmbCalParId.setWebtags( "" );
      cmbCalParId.addItem("Devolver", httpContext.getMessage( "Cantidad ingresada en novedad \"C\" o Total \"T\" (valor por omisión)", ""), (short)(0));
      cmbCalParId.addItem("Calculo", httpContext.getMessage( "\"mejor\", o \"promedio\", o \"suma\" (valor por omisión)", ""), (short)(0));
      cmbCalParId.addItem("Periodo", httpContext.getMessage( "Periodo. Valores posibles: \"semestre\" para liquidaciones del semestre, \"acumulado\" para liquidaciones acumuladas en el año en curso, \"deMesesAnteriores\" para liquidaciones de periodos anteriores, \"liquidacionesAnteriores\", \"mismoPeriodo\" para liquidaciones del mismo periodo, \"anterioresDelPeriodo\" para liquidaciones anteriores del periodo (sin incluir el periodo liquidado), \"tramoGanancias\" para liquidaciones de periodos del mismo tramo de ganancias", ""), (short)(0));
      cmbCalParId.addItem("Concepto", httpContext.getMessage( "Código de concepto", ""), (short)(0));
      cmbCalParId.addItem("TipoLiq", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbCalParId.addItem("Adicional", httpContext.getMessage( "Código de adicional de convenio", ""), (short)(0));
      cmbCalParId.addItem("AdicionalOpcion", httpContext.getMessage( "Opción de adicional de convenio", ""), (short)(0));
      cmbCalParId.addItem("Area", httpContext.getMessage( "Area", ""), (short)(0));
      cmbCalParId.addItem("Categoria", httpContext.getMessage( "Categoría", ""), (short)(0));
      cmbCalParId.addItem("Clase", httpContext.getMessage( "Clase", ""), (short)(0));
      cmbCalParId.addItem("Convenio", httpContext.getMessage( "Convenio", ""), (short)(0));
      cmbCalParId.addItem("MotivoEgreso", httpContext.getMessage( "Motivo de egreso", ""), (short)(0));
      cmbCalParId.addItem("ObraSocial", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbCalParId.addItem("Sexo", httpContext.getMessage( "Sexo", ""), (short)(0));
      cmbCalParId.addItem("Sindicato", httpContext.getMessage( "Sindicato", ""), (short)(0));
      cmbCalParId.addItem("Tipo de trabajo", httpContext.getMessage( "TipoTrabajo", ""), (short)(0));
      cmbCalParId.addItem("Dia", httpContext.getMessage( "Día", ""), (short)(0));
      cmbCalParId.addItem("TipoObligacion", httpContext.getMessage( "Tipo de obligación", ""), (short)(0));
      cmbCalParId.addItem("AplIIGG", httpContext.getMessage( "Código de tratamiento de exención", ""), (short)(0));
      cmbCalParId.addItem("TipoDeConcepto", httpContext.getMessage( "Solo de tipo de concepto determinado", ""), (short)(0));
      cmbCalParId.addItem("SueldoBasico", httpContext.getMessage( "Sueldo básico fuera de convenio", ""), (short)(0));
      cmbCalParId.addItem("PropiedadAdicional", httpContext.getMessage( "Propiedad Adicional de legajo por convenio", ""), (short)(0));
      if ( cmbCalParId.getItemCount() > 0 )
      {
      }
      GXCCtl = "CALPAROBL_" + sGXsfl_21_idx ;
      chkCalParObl.setName( GXCCtl );
      chkCalParObl.setWebtags( "" );
      chkCalParObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCalParObl.getInternalname(), "TitleCaption", chkCalParObl.getCaption(), !bGXsfl_21_Refreshing);
      chkCalParObl.setCheckedValue( "false" );
      cmbidOperando.setName( "IDOPERANDO" );
      cmbidOperando.setWebtags( "" );
      cmbidOperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
      cmbidOperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbidOperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
      cmbidOperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
      cmbidOperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
      cmbidOperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
      cmbidOperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
      cmbidOperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
      cmbidOperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
      cmbidOperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
      cmbidOperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbidOperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
      cmbidOperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
      cmbidOperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
      cmbidOperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
      cmbidOperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
      cmbidOperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
      cmbidOperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
      cmbidOperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
      cmbidOperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
      cmbidOperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
      cmbidOperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
      cmbidOperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
      cmbidOperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
      cmbidOperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
      cmbidOperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
      cmbidOperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
      cmbidOperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
      cmbidOperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
      cmbidOperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
      cmbidOperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
      cmbidOperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
      cmbidOperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
      cmbidOperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
      cmbidOperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
      cmbidOperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
      cmbidOperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
      cmbidOperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
      cmbidOperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
      cmbidOperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
      cmbidOperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
      cmbidOperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
      cmbidOperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
      cmbidOperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
      cmbidOperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
      cmbidOperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
      cmbidOperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
      cmbidOperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
      cmbidOperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
      cmbidOperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
      cmbidOperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
      cmbidOperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
      cmbidOperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
      cmbidOperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
      cmbidOperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
      cmbidOperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
      cmbidOperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
      cmbidOperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
      cmbidOperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
      cmbidOperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
      cmbidOperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
      cmbidOperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
      cmbidOperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
      cmbidOperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
      cmbidOperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
      cmbidOperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
      cmbidOperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbidOperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
      cmbidOperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
      cmbidOperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
      cmbidOperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
      cmbidOperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
      cmbidOperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
      cmbidOperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
      cmbidOperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
      cmbidOperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
      cmbidOperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
      cmbidOperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
      cmbidOperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
      cmbidOperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
      cmbidOperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
      cmbidOperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
      cmbidOperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
      cmbidOperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
      cmbidOperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
      cmbidOperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
      cmbidOperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
      cmbidOperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
      cmbidOperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
      cmbidOperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
      cmbidOperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
      cmbidOperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
      cmbidOperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
      cmbidOperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
      cmbidOperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
      cmbidOperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
      cmbidOperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
      cmbidOperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
      cmbidOperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
      if ( cmbidOperando.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'sPrefix'},{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV9idOperando',fld:'vIDOPERANDO',pic:''},{av:'AV59Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV19TFCalParNombre',fld:'vTFCALPARNOMBRE',pic:''},{av:'AV20TFCalParNombre_Sels',fld:'vTFCALPARNOMBRE_SELS',pic:''},{av:'AV22TFCalParDesc',fld:'vTFCALPARDESC',pic:''},{av:'AV23TFCalParDesc_Sels',fld:'vTFCALPARDESC_SELS',pic:''},{av:'AV25TFCalParCampo',fld:'vTFCALPARCAMPO',pic:''},{av:'AV26TFCalParCampo_Sels',fld:'vTFCALPARCAMPO_SELS',pic:''},{av:'AV28TFCalParValLista',fld:'vTFCALPARVALLISTA',pic:''},{av:'AV29TFCalParValLista_Sels',fld:'vTFCALPARVALLISTA_SELS',pic:''},{av:'AV31TFCalParDef',fld:'vTFCALPARDEF',pic:''},{av:'AV32TFCalParDef_Sels',fld:'vTFCALPARDEF_SELS',pic:''},{av:'AV33TFCalParObl_Sel',fld:'vTFCALPAROBL_SEL',pic:'9'},{av:'AV34TFCalParGrp',fld:'vTFCALPARGRP',pic:'Z9'},{av:'AV35TFCalParGrp_To',fld:'vTFCALPARGRP_TO',pic:'Z9'},{av:'AV36TFCalParGrpDep',fld:'vTFCALPARGRPDEP',pic:'Z9'},{av:'AV37TFCalParGrpDep_To',fld:'vTFCALPARGRPDEP_TO',pic:'Z9'},{av:'AV39TFCalParEjemplo',fld:'vTFCALPAREJEMPLO',pic:''},{av:'AV40TFCalParEjemplo_Sels',fld:'vTFCALPAREJEMPLO_SELS',pic:''},{av:'AV42TFCalParEjemExpli',fld:'vTFCALPAREJEMEXPLI',pic:''},{av:'AV43TFCalParEjemExpli_Sels',fld:'vTFCALPAREJEMEXPLI_SELS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCalParNombre_Visible',ctrl:'CALPARNOMBRE',prop:'Visible'},{av:'edtCalParDesc_Visible',ctrl:'CALPARDESC',prop:'Visible'},{av:'edtCalParCampo_Visible',ctrl:'CALPARCAMPO',prop:'Visible'},{av:'edtCalParValLista_Visible',ctrl:'CALPARVALLISTA',prop:'Visible'},{av:'edtCalParDef_Visible',ctrl:'CALPARDEF',prop:'Visible'},{av:'chkCalParObl.getVisible()',ctrl:'CALPAROBL',prop:'Visible'},{av:'edtCalParGrp_Visible',ctrl:'CALPARGRP',prop:'Visible'},{av:'edtCalParGrpDep_Visible',ctrl:'CALPARGRPDEP',prop:'Visible'},{av:'edtCalParEjemplo_Visible',ctrl:'CALPAREJEMPLO',prop:'Visible'},{av:'edtCalParEjemExpli_Visible',ctrl:'CALPAREJEMEXPLI',prop:'Visible'},{av:'AV47GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV48GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV49GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12MA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV9idOperando',fld:'vIDOPERANDO',pic:''},{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV59Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV19TFCalParNombre',fld:'vTFCALPARNOMBRE',pic:''},{av:'AV20TFCalParNombre_Sels',fld:'vTFCALPARNOMBRE_SELS',pic:''},{av:'AV22TFCalParDesc',fld:'vTFCALPARDESC',pic:''},{av:'AV23TFCalParDesc_Sels',fld:'vTFCALPARDESC_SELS',pic:''},{av:'AV25TFCalParCampo',fld:'vTFCALPARCAMPO',pic:''},{av:'AV26TFCalParCampo_Sels',fld:'vTFCALPARCAMPO_SELS',pic:''},{av:'AV28TFCalParValLista',fld:'vTFCALPARVALLISTA',pic:''},{av:'AV29TFCalParValLista_Sels',fld:'vTFCALPARVALLISTA_SELS',pic:''},{av:'AV31TFCalParDef',fld:'vTFCALPARDEF',pic:''},{av:'AV32TFCalParDef_Sels',fld:'vTFCALPARDEF_SELS',pic:''},{av:'AV33TFCalParObl_Sel',fld:'vTFCALPAROBL_SEL',pic:'9'},{av:'AV34TFCalParGrp',fld:'vTFCALPARGRP',pic:'Z9'},{av:'AV35TFCalParGrp_To',fld:'vTFCALPARGRP_TO',pic:'Z9'},{av:'AV36TFCalParGrpDep',fld:'vTFCALPARGRPDEP',pic:'Z9'},{av:'AV37TFCalParGrpDep_To',fld:'vTFCALPARGRPDEP_TO',pic:'Z9'},{av:'AV39TFCalParEjemplo',fld:'vTFCALPAREJEMPLO',pic:''},{av:'AV40TFCalParEjemplo_Sels',fld:'vTFCALPAREJEMPLO_SELS',pic:''},{av:'AV42TFCalParEjemExpli',fld:'vTFCALPAREJEMEXPLI',pic:''},{av:'AV43TFCalParEjemExpli_Sels',fld:'vTFCALPAREJEMEXPLI_SELS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13MA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV9idOperando',fld:'vIDOPERANDO',pic:''},{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV59Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV19TFCalParNombre',fld:'vTFCALPARNOMBRE',pic:''},{av:'AV20TFCalParNombre_Sels',fld:'vTFCALPARNOMBRE_SELS',pic:''},{av:'AV22TFCalParDesc',fld:'vTFCALPARDESC',pic:''},{av:'AV23TFCalParDesc_Sels',fld:'vTFCALPARDESC_SELS',pic:''},{av:'AV25TFCalParCampo',fld:'vTFCALPARCAMPO',pic:''},{av:'AV26TFCalParCampo_Sels',fld:'vTFCALPARCAMPO_SELS',pic:''},{av:'AV28TFCalParValLista',fld:'vTFCALPARVALLISTA',pic:''},{av:'AV29TFCalParValLista_Sels',fld:'vTFCALPARVALLISTA_SELS',pic:''},{av:'AV31TFCalParDef',fld:'vTFCALPARDEF',pic:''},{av:'AV32TFCalParDef_Sels',fld:'vTFCALPARDEF_SELS',pic:''},{av:'AV33TFCalParObl_Sel',fld:'vTFCALPAROBL_SEL',pic:'9'},{av:'AV34TFCalParGrp',fld:'vTFCALPARGRP',pic:'Z9'},{av:'AV35TFCalParGrp_To',fld:'vTFCALPARGRP_TO',pic:'Z9'},{av:'AV36TFCalParGrpDep',fld:'vTFCALPARGRPDEP',pic:'Z9'},{av:'AV37TFCalParGrpDep_To',fld:'vTFCALPARGRPDEP_TO',pic:'Z9'},{av:'AV39TFCalParEjemplo',fld:'vTFCALPAREJEMPLO',pic:''},{av:'AV40TFCalParEjemplo_Sels',fld:'vTFCALPAREJEMPLO_SELS',pic:''},{av:'AV42TFCalParEjemExpli',fld:'vTFCALPAREJEMEXPLI',pic:''},{av:'AV43TFCalParEjemExpli_Sels',fld:'vTFCALPAREJEMEXPLI_SELS',pic:''},{av:'sPrefix'},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e14MA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV9idOperando',fld:'vIDOPERANDO',pic:''},{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV59Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV19TFCalParNombre',fld:'vTFCALPARNOMBRE',pic:''},{av:'AV20TFCalParNombre_Sels',fld:'vTFCALPARNOMBRE_SELS',pic:''},{av:'AV22TFCalParDesc',fld:'vTFCALPARDESC',pic:''},{av:'AV23TFCalParDesc_Sels',fld:'vTFCALPARDESC_SELS',pic:''},{av:'AV25TFCalParCampo',fld:'vTFCALPARCAMPO',pic:''},{av:'AV26TFCalParCampo_Sels',fld:'vTFCALPARCAMPO_SELS',pic:''},{av:'AV28TFCalParValLista',fld:'vTFCALPARVALLISTA',pic:''},{av:'AV29TFCalParValLista_Sels',fld:'vTFCALPARVALLISTA_SELS',pic:''},{av:'AV31TFCalParDef',fld:'vTFCALPARDEF',pic:''},{av:'AV32TFCalParDef_Sels',fld:'vTFCALPARDEF_SELS',pic:''},{av:'AV33TFCalParObl_Sel',fld:'vTFCALPAROBL_SEL',pic:'9'},{av:'AV34TFCalParGrp',fld:'vTFCALPARGRP',pic:'Z9'},{av:'AV35TFCalParGrp_To',fld:'vTFCALPARGRP_TO',pic:'Z9'},{av:'AV36TFCalParGrpDep',fld:'vTFCALPARGRPDEP',pic:'Z9'},{av:'AV37TFCalParGrpDep_To',fld:'vTFCALPARGRPDEP_TO',pic:'Z9'},{av:'AV39TFCalParEjemplo',fld:'vTFCALPAREJEMPLO',pic:''},{av:'AV40TFCalParEjemplo_Sels',fld:'vTFCALPAREJEMPLO_SELS',pic:''},{av:'AV42TFCalParEjemExpli',fld:'vTFCALPAREJEMEXPLI',pic:''},{av:'AV43TFCalParEjemExpli_Sels',fld:'vTFCALPAREJEMEXPLI_SELS',pic:''},{av:'sPrefix'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV42TFCalParEjemExpli',fld:'vTFCALPAREJEMEXPLI',pic:''},{av:'AV41TFCalParEjemExpli_SelsJson',fld:'vTFCALPAREJEMEXPLI_SELSJSON',pic:''},{av:'AV43TFCalParEjemExpli_Sels',fld:'vTFCALPAREJEMEXPLI_SELS',pic:''},{av:'AV39TFCalParEjemplo',fld:'vTFCALPAREJEMPLO',pic:''},{av:'AV38TFCalParEjemplo_SelsJson',fld:'vTFCALPAREJEMPLO_SELSJSON',pic:''},{av:'AV40TFCalParEjemplo_Sels',fld:'vTFCALPAREJEMPLO_SELS',pic:''},{av:'AV36TFCalParGrpDep',fld:'vTFCALPARGRPDEP',pic:'Z9'},{av:'AV37TFCalParGrpDep_To',fld:'vTFCALPARGRPDEP_TO',pic:'Z9'},{av:'AV34TFCalParGrp',fld:'vTFCALPARGRP',pic:'Z9'},{av:'AV35TFCalParGrp_To',fld:'vTFCALPARGRP_TO',pic:'Z9'},{av:'AV33TFCalParObl_Sel',fld:'vTFCALPAROBL_SEL',pic:'9'},{av:'AV31TFCalParDef',fld:'vTFCALPARDEF',pic:''},{av:'AV30TFCalParDef_SelsJson',fld:'vTFCALPARDEF_SELSJSON',pic:''},{av:'AV32TFCalParDef_Sels',fld:'vTFCALPARDEF_SELS',pic:''},{av:'AV28TFCalParValLista',fld:'vTFCALPARVALLISTA',pic:''},{av:'AV27TFCalParValLista_SelsJson',fld:'vTFCALPARVALLISTA_SELSJSON',pic:''},{av:'AV29TFCalParValLista_Sels',fld:'vTFCALPARVALLISTA_SELS',pic:''},{av:'AV25TFCalParCampo',fld:'vTFCALPARCAMPO',pic:''},{av:'AV24TFCalParCampo_SelsJson',fld:'vTFCALPARCAMPO_SELSJSON',pic:''},{av:'AV26TFCalParCampo_Sels',fld:'vTFCALPARCAMPO_SELS',pic:''},{av:'AV22TFCalParDesc',fld:'vTFCALPARDESC',pic:''},{av:'AV21TFCalParDesc_SelsJson',fld:'vTFCALPARDESC_SELSJSON',pic:''},{av:'AV23TFCalParDesc_Sels',fld:'vTFCALPARDESC_SELS',pic:''},{av:'AV19TFCalParNombre',fld:'vTFCALPARNOMBRE',pic:''},{av:'AV18TFCalParNombre_SelsJson',fld:'vTFCALPARNOMBRE_SELSJSON',pic:''},{av:'AV20TFCalParNombre_Sels',fld:'vTFCALPARNOMBRE_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17MA2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11MA2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV8PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'AV9idOperando',fld:'vIDOPERANDO',pic:''},{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV59Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV19TFCalParNombre',fld:'vTFCALPARNOMBRE',pic:''},{av:'AV20TFCalParNombre_Sels',fld:'vTFCALPARNOMBRE_SELS',pic:''},{av:'AV22TFCalParDesc',fld:'vTFCALPARDESC',pic:''},{av:'AV23TFCalParDesc_Sels',fld:'vTFCALPARDESC_SELS',pic:''},{av:'AV25TFCalParCampo',fld:'vTFCALPARCAMPO',pic:''},{av:'AV26TFCalParCampo_Sels',fld:'vTFCALPARCAMPO_SELS',pic:''},{av:'AV28TFCalParValLista',fld:'vTFCALPARVALLISTA',pic:''},{av:'AV29TFCalParValLista_Sels',fld:'vTFCALPARVALLISTA_SELS',pic:''},{av:'AV31TFCalParDef',fld:'vTFCALPARDEF',pic:''},{av:'AV32TFCalParDef_Sels',fld:'vTFCALPARDEF_SELS',pic:''},{av:'AV33TFCalParObl_Sel',fld:'vTFCALPAROBL_SEL',pic:'9'},{av:'AV34TFCalParGrp',fld:'vTFCALPARGRP',pic:'Z9'},{av:'AV35TFCalParGrp_To',fld:'vTFCALPARGRP_TO',pic:'Z9'},{av:'AV36TFCalParGrpDep',fld:'vTFCALPARGRPDEP',pic:'Z9'},{av:'AV37TFCalParGrpDep_To',fld:'vTFCALPARGRPDEP_TO',pic:'Z9'},{av:'AV39TFCalParEjemplo',fld:'vTFCALPAREJEMPLO',pic:''},{av:'AV40TFCalParEjemplo_Sels',fld:'vTFCALPAREJEMPLO_SELS',pic:''},{av:'AV42TFCalParEjemExpli',fld:'vTFCALPAREJEMEXPLI',pic:''},{av:'AV43TFCalParEjemExpli_Sels',fld:'vTFCALPAREJEMEXPLI_SELS',pic:''},{av:'sPrefix'},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV55ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtCalParNombre_Visible',ctrl:'CALPARNOMBRE',prop:'Visible'},{av:'edtCalParDesc_Visible',ctrl:'CALPARDESC',prop:'Visible'},{av:'edtCalParCampo_Visible',ctrl:'CALPARCAMPO',prop:'Visible'},{av:'edtCalParValLista_Visible',ctrl:'CALPARVALLISTA',prop:'Visible'},{av:'edtCalParDef_Visible',ctrl:'CALPARDEF',prop:'Visible'},{av:'chkCalParObl.getVisible()',ctrl:'CALPAROBL',prop:'Visible'},{av:'edtCalParGrp_Visible',ctrl:'CALPARGRP',prop:'Visible'},{av:'edtCalParGrpDep_Visible',ctrl:'CALPARGRPDEP',prop:'Visible'},{av:'edtCalParEjemplo_Visible',ctrl:'CALPAREJEMPLO',prop:'Visible'},{av:'edtCalParEjemExpli_Visible',ctrl:'CALPAREJEMEXPLI',prop:'Visible'},{av:'AV47GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV48GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV49GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Calparejemexpli',iparms:[]");
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
      wcpOAV9idOperando = "" ;
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
      AV9idOperando = "" ;
      AV55ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV59Pgmname = "" ;
      AV19TFCalParNombre = "" ;
      AV20TFCalParNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22TFCalParDesc = "" ;
      AV23TFCalParDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFCalParCampo = "" ;
      AV26TFCalParCampo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28TFCalParValLista = "" ;
      AV29TFCalParValLista_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFCalParDef = "" ;
      AV32TFCalParDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFCalParEjemplo = "" ;
      AV40TFCalParEjemplo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFCalParEjemExpli = "" ;
      AV43TFCalParEjemExpli_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV44DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV49GridAppliedFilters = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      A74idOperando = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A2098CalParId = "" ;
      A2110CalParNombre = "" ;
      A2100CalParDesc = "" ;
      A2099CalParCampo = "" ;
      A2111CalParValLista = "" ;
      A2107CalParDef = "" ;
      A2108CalParEjemplo = "" ;
      A2109CalParEjemExpli = "" ;
      scmdbuf = "" ;
      lV19TFCalParNombre = "" ;
      lV22TFCalParDesc = "" ;
      lV25TFCalParCampo = "" ;
      lV28TFCalParValLista = "" ;
      lV31TFCalParDef = "" ;
      lV39TFCalParEjemplo = "" ;
      lV42TFCalParEjemExpli = "" ;
      H00MA2_A46PaiCod = new short[1] ;
      H00MA2_A74idOperando = new String[] {""} ;
      H00MA2_A2109CalParEjemExpli = new String[] {""} ;
      H00MA2_A2108CalParEjemplo = new String[] {""} ;
      H00MA2_A2105CalParGrpDep = new byte[1] ;
      H00MA2_A2104CalParGrp = new byte[1] ;
      H00MA2_A2106CalParObl = new boolean[] {false} ;
      H00MA2_A2107CalParDef = new String[] {""} ;
      H00MA2_A2111CalParValLista = new String[] {""} ;
      H00MA2_A2099CalParCampo = new String[] {""} ;
      H00MA2_A2100CalParDesc = new String[] {""} ;
      H00MA2_A2110CalParNombre = new String[] {""} ;
      H00MA2_A2098CalParId = new String[] {""} ;
      H00MA3_AGRID_nRecordCount = new long[1] ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV17Session = httpContext.getWebSession();
      AV53ColumnsSelectorXML = "" ;
      AV18TFCalParNombre_SelsJson = "" ;
      AV21TFCalParDesc_SelsJson = "" ;
      AV24TFCalParCampo_SelsJson = "" ;
      AV27TFCalParValLista_SelsJson = "" ;
      AV30TFCalParDef_SelsJson = "" ;
      AV38TFCalParEjemplo_SelsJson = "" ;
      AV41TFCalParEjemExpli_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV54UserCustomValue = "" ;
      AV56ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV13GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV14GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char20 = "" ;
      GXv_char21 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char19 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char13 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_SdtWWPGridState22 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10HTTPRequest = httpContext.getHttpRequest();
      AV12TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV8PaiCod = "" ;
      sCtrlAV9idOperando = "" ;
      subGrid_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculo_parametrostab__default(),
         new Object[] {
             new Object[] {
            H00MA2_A46PaiCod, H00MA2_A74idOperando, H00MA2_A2109CalParEjemExpli, H00MA2_A2108CalParEjemplo, H00MA2_A2105CalParGrpDep, H00MA2_A2104CalParGrp, H00MA2_A2106CalParObl, H00MA2_A2107CalParDef, H00MA2_A2111CalParValLista, H00MA2_A2099CalParCampo,
            H00MA2_A2100CalParDesc, H00MA2_A2110CalParNombre, H00MA2_A2098CalParId
            }
            , new Object[] {
            H00MA3_AGRID_nRecordCount
            }
         }
      );
      AV59Pgmname = "Calculo_parametrosTab" ;
      /* GeneXus formulas. */
      AV59Pgmname = "Calculo_parametrosTab" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV33TFCalParObl_Sel ;
   private byte AV34TFCalParGrp ;
   private byte AV35TFCalParGrp_To ;
   private byte AV36TFCalParGrpDep ;
   private byte AV37TFCalParGrpDep_To ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte A2104CalParGrp ;
   private byte A2105CalParGrpDep ;
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
   private short wcpOAV8PaiCod ;
   private short AV8PaiCod ;
   private short AV15OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_21 ;
   private int nGXsfl_21_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int edtPaiCod_Visible ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV20TFCalParNombre_Sels_size ;
   private int AV23TFCalParDesc_Sels_size ;
   private int AV26TFCalParCampo_Sels_size ;
   private int AV29TFCalParValLista_Sels_size ;
   private int AV32TFCalParDef_Sels_size ;
   private int AV40TFCalParEjemplo_Sels_size ;
   private int AV43TFCalParEjemExpli_Sels_size ;
   private int AV50CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtCalParNombre_Visible ;
   private int edtCalParDesc_Visible ;
   private int edtCalParCampo_Visible ;
   private int edtCalParValLista_Visible ;
   private int edtCalParDef_Visible ;
   private int edtCalParGrp_Visible ;
   private int edtCalParGrpDep_Visible ;
   private int edtCalParEjemplo_Visible ;
   private int edtCalParEjemExpli_Visible ;
   private int AV46PageToGo ;
   private int AV60GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV47GridCurrentPage ;
   private long AV48GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String wcpOAV9idOperando ;
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
   private String AV9idOperando ;
   private String sGXsfl_21_idx="0001" ;
   private String AV59Pgmname ;
   private String AV31TFCalParDef ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
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
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String A74idOperando ;
   private String Grid_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String A2098CalParId ;
   private String edtCalParNombre_Internalname ;
   private String edtCalParDesc_Internalname ;
   private String edtCalParCampo_Internalname ;
   private String edtCalParValLista_Internalname ;
   private String A2107CalParDef ;
   private String edtCalParDef_Internalname ;
   private String edtCalParGrp_Internalname ;
   private String edtCalParGrpDep_Internalname ;
   private String edtCalParEjemplo_Internalname ;
   private String edtCalParEjemExpli_Internalname ;
   private String scmdbuf ;
   private String lV31TFCalParDef ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXt_char20 ;
   private String GXv_char21[] ;
   private String GXt_char18 ;
   private String GXv_char19[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char12 ;
   private String GXv_char13[] ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String tblUnnamedtable1_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTablefiltrospadre_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String sCtrlAV8PaiCod ;
   private String sCtrlAV9idOperando ;
   private String sGXsfl_21_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtCalParNombre_Jsonclick ;
   private String edtCalParDesc_Jsonclick ;
   private String edtCalParCampo_Jsonclick ;
   private String edtCalParValLista_Jsonclick ;
   private String edtCalParDef_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtCalParGrp_Jsonclick ;
   private String edtCalParGrpDep_Jsonclick ;
   private String edtCalParEjemplo_Jsonclick ;
   private String edtCalParEjemExpli_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV16OrderedDsc ;
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
   private boolean A2106CalParObl ;
   private boolean bGXsfl_21_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String A2109CalParEjemExpli ;
   private String AV53ColumnsSelectorXML ;
   private String AV18TFCalParNombre_SelsJson ;
   private String AV21TFCalParDesc_SelsJson ;
   private String AV24TFCalParCampo_SelsJson ;
   private String AV27TFCalParValLista_SelsJson ;
   private String AV30TFCalParDef_SelsJson ;
   private String AV38TFCalParEjemplo_SelsJson ;
   private String AV41TFCalParEjemExpli_SelsJson ;
   private String AV54UserCustomValue ;
   private String AV19TFCalParNombre ;
   private String AV22TFCalParDesc ;
   private String AV25TFCalParCampo ;
   private String AV28TFCalParValLista ;
   private String AV39TFCalParEjemplo ;
   private String AV42TFCalParEjemExpli ;
   private String AV49GridAppliedFilters ;
   private String A2110CalParNombre ;
   private String A2100CalParDesc ;
   private String A2099CalParCampo ;
   private String A2111CalParValLista ;
   private String A2108CalParEjemplo ;
   private String lV19TFCalParNombre ;
   private String lV22TFCalParDesc ;
   private String lV25TFCalParCampo ;
   private String lV28TFCalParValLista ;
   private String lV39TFCalParEjemplo ;
   private String lV42TFCalParEjemExpli ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.webpanels.WebSession AV17Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private HTMLChoice cmbCalParId ;
   private ICheckbox chkCalParObl ;
   private HTMLChoice cmbidOperando ;
   private IDataStoreProvider pr_default ;
   private short[] H00MA2_A46PaiCod ;
   private String[] H00MA2_A74idOperando ;
   private String[] H00MA2_A2109CalParEjemExpli ;
   private String[] H00MA2_A2108CalParEjemplo ;
   private byte[] H00MA2_A2105CalParGrpDep ;
   private byte[] H00MA2_A2104CalParGrp ;
   private boolean[] H00MA2_A2106CalParObl ;
   private String[] H00MA2_A2107CalParDef ;
   private String[] H00MA2_A2111CalParValLista ;
   private String[] H00MA2_A2099CalParCampo ;
   private String[] H00MA2_A2100CalParDesc ;
   private String[] H00MA2_A2110CalParNombre ;
   private String[] H00MA2_A2098CalParId ;
   private long[] H00MA3_AGRID_nRecordCount ;
   private GXSimpleCollection<String> AV32TFCalParDef_Sels ;
   private GXSimpleCollection<String> AV20TFCalParNombre_Sels ;
   private GXSimpleCollection<String> AV23TFCalParDesc_Sels ;
   private GXSimpleCollection<String> AV26TFCalParCampo_Sels ;
   private GXSimpleCollection<String> AV29TFCalParValLista_Sels ;
   private GXSimpleCollection<String> AV40TFCalParEjemplo_Sels ;
   private GXSimpleCollection<String> AV43TFCalParEjemExpli_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV12TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV13GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState22[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV14GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV44DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV55ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV56ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
}

final  class calculo_parametrostab__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00MA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV20TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV23TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV26TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV29TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV32TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV40TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV43TFCalParEjemExpli_Sels ,
                                          int AV20TFCalParNombre_Sels_size ,
                                          String AV19TFCalParNombre ,
                                          int AV23TFCalParDesc_Sels_size ,
                                          String AV22TFCalParDesc ,
                                          int AV26TFCalParCampo_Sels_size ,
                                          String AV25TFCalParCampo ,
                                          int AV29TFCalParValLista_Sels_size ,
                                          String AV28TFCalParValLista ,
                                          int AV32TFCalParDef_Sels_size ,
                                          String AV31TFCalParDef ,
                                          byte AV33TFCalParObl_Sel ,
                                          byte AV34TFCalParGrp ,
                                          byte AV35TFCalParGrp_To ,
                                          byte AV36TFCalParGrpDep ,
                                          byte AV37TFCalParGrpDep_To ,
                                          int AV40TFCalParEjemplo_Sels_size ,
                                          String AV39TFCalParEjemplo ,
                                          int AV43TFCalParEjemExpli_Sels_size ,
                                          String AV42TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          short AV8PaiCod ,
                                          String AV9idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[16];
      Object[] GXv_Object24 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " PaiCod, idOperando, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParValLista, CalParCampo, CalParDesc, CalParNombre, CalParId" ;
      sFromString = " FROM Calculo_parametros" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV20TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int23[2] = (byte)(1) ;
      }
      if ( AV20TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV23TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV22TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      if ( AV23TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV23TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV26TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV25TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int23[4] = (byte)(1) ;
      }
      if ( AV26TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV26TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV29TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV28TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int23[5] = (byte)(1) ;
      }
      if ( AV29TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV32TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int23[6] = (byte)(1) ;
      }
      if ( AV32TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV33TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV33TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV34TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int23[7] = (byte)(1) ;
      }
      if ( ! (0==AV35TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int23[8] = (byte)(1) ;
      }
      if ( ! (0==AV36TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int23[9] = (byte)(1) ;
      }
      if ( ! (0==AV37TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int23[10] = (byte)(1) ;
      }
      if ( ( AV40TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int23[11] = (byte)(1) ;
      }
      if ( AV40TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV40TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV43TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV42TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int23[12] = (byte)(1) ;
      }
      if ( AV43TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV43TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      if ( AV15OrderedBy == 1 )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParGrp DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParNombre, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParNombre DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParDesc, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParDesc DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParCampo, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParCampo DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParValLista, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParValLista DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParDef, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParDef DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParObl, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParObl DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParGrp, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParGrp DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParGrpDep, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParGrpDep DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParEjemplo, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParEjemplo DESC, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParEjemExpli, CalParId" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY PaiCod DESC, idOperando DESC, CalParEjemExpli DESC, CalParId" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY PaiCod, idOperando, CalParId" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_H00MA3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV20TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV23TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV26TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV29TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV32TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV40TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV43TFCalParEjemExpli_Sels ,
                                          int AV20TFCalParNombre_Sels_size ,
                                          String AV19TFCalParNombre ,
                                          int AV23TFCalParDesc_Sels_size ,
                                          String AV22TFCalParDesc ,
                                          int AV26TFCalParCampo_Sels_size ,
                                          String AV25TFCalParCampo ,
                                          int AV29TFCalParValLista_Sels_size ,
                                          String AV28TFCalParValLista ,
                                          int AV32TFCalParDef_Sels_size ,
                                          String AV31TFCalParDef ,
                                          byte AV33TFCalParObl_Sel ,
                                          byte AV34TFCalParGrp ,
                                          byte AV35TFCalParGrp_To ,
                                          byte AV36TFCalParGrpDep ,
                                          byte AV37TFCalParGrpDep_To ,
                                          int AV40TFCalParEjemplo_Sels_size ,
                                          String AV39TFCalParEjemplo ,
                                          int AV43TFCalParEjemExpli_Sels_size ,
                                          String AV42TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          short AV8PaiCod ,
                                          String AV9idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int26 = new byte[13];
      Object[] GXv_Object27 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV20TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int26[2] = (byte)(1) ;
      }
      if ( AV20TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV23TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV22TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int26[3] = (byte)(1) ;
      }
      if ( AV23TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV23TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV26TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV25TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int26[4] = (byte)(1) ;
      }
      if ( AV26TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV26TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV29TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV28TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int26[5] = (byte)(1) ;
      }
      if ( AV29TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV32TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int26[6] = (byte)(1) ;
      }
      if ( AV32TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV33TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV33TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV34TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int26[7] = (byte)(1) ;
      }
      if ( ! (0==AV35TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int26[8] = (byte)(1) ;
      }
      if ( ! (0==AV36TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int26[9] = (byte)(1) ;
      }
      if ( ! (0==AV37TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int26[10] = (byte)(1) ;
      }
      if ( ( AV40TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int26[11] = (byte)(1) ;
      }
      if ( AV40TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV40TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV43TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV42TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int26[12] = (byte)(1) ;
      }
      if ( AV43TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV43TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( AV15OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object27[0] = scmdbuf ;
      GXv_Object27[1] = GXv_int26 ;
      return GXv_Object27 ;
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
                  return conditional_H00MA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , (String)dynConstraints[41] );
            case 1 :
                  return conditional_H00MA3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).shortValue() , (String)dynConstraints[41] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00MA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00MA3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
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
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[24]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[25]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
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
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
      }
   }

}

