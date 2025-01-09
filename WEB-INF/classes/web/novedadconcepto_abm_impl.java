package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class novedadconcepto_abm_impl extends GXWebComponent
{
   public novedadconcepto_abm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public novedadconcepto_abm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadconcepto_abm_impl.class ));
   }

   public novedadconcepto_abm_impl( int remoteHandle ,
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
      cmbavOpcionforval = new HTMLChoice();
      radavMetodo = new HTMLChoice();
      cmbavPerdesde = new HTMLChoice();
      cmbavHasta = new HTMLChoice();
      cmbavQuincena = new HTMLChoice();
      cmbavDia = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
               AV27TrnMode = httpContext.GetPar( "TrnMode") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TrnMode", AV27TrnMode);
               AV18CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
               AV19EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19EmpCod), 4, 0));
               AV33parmLegNumero = (int)(GXutil.lval( httpContext.GetPar( "parmLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33parmLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33parmLegNumero), 8, 0));
               AV20AgeOrden = (short)(GXutil.lval( httpContext.GetPar( "AgeOrden"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20AgeOrden), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV27TrnMode,Integer.valueOf(AV18CliCod),Short.valueOf(AV19EmpCod),Integer.valueOf(AV33parmLegNumero),Short.valueOf(AV20AgeOrden)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paBK2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Novedad concepto", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.novedadconcepto_abm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV18CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV19EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV33parmLegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV20AgeOrden,4,0))}, new String[] {"TrnMode","CliCod","EmpCod","parmLegNumero","AgeOrden"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV117Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vADELVACPROXCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75adelVacProxConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOY", getSecureSignedToken( sPrefix, AV29hoy));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHORASNORMALESCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83horasNormalesConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vANIO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV26anio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQPERANO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV24LiqPerAno), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQPERMES", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV25LiqPerMes), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESSUBTIPOCONCOD1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV42vacacionesSubTipoConCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vULTNOVLIQPERIODO", getSecureSignedToken( sPrefix, AV101ultNovLiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSIGLIQLIQPERIODO", getSecureSignedToken( sPrefix, AV100sigLiqLiqPeriodo));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLEGNUMERO_DATA", AV21LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLEGNUMERO_DATA", AV21LegNumero_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV46DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV46DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONCODIGO_DATA", AV23ConCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONCODIGO_DATA", AV23ConCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV27TrnMode", GXutil.rtrim( wcpOAV27TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV18CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV18CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV19EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV19EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV33parmLegNumero", GXutil.ltrim( localUtil.ntoc( wcpOAV33parmLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV20AgeOrden", GXutil.ltrim( localUtil.ntoc( wcpOAV20AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV117Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV117Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vADELVACPROXCONCODIGO", GXutil.rtrim( AV75adelVacProxConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vADELVACPROXCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75adelVacProxConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGCLASE", GXutil.ltrim( localUtil.ntoc( AV32LegClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOPERIODOS", AV40tocoPeriodos);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOLEGAJO", AV114tocoLegajo);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOCONCEPTO", AV113tocoConcepto);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vHOY", localUtil.dtoc( AV29hoy, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOY", getSecureSignedToken( sPrefix, AV29hoy));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vYAMODIFICOIMPORTE", AV103yaModificoImporte);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vHORASNORMALESCONCODIGO", GXutil.rtrim( AV83horasNormalesConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHORASNORMALESCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83horasNormalesConCodigo, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vYAMODIFICOCANTIDAD", AV102yaModificoCantidad);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vANIO", GXutil.ltrim( localUtil.ntoc( AV26anio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vANIO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV26anio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQPERANO", GXutil.ltrim( localUtil.ntoc( AV24LiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQPERANO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV24LiqPerAno), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQPERMES", GXutil.ltrim( localUtil.ntoc( AV25LiqPerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQPERMES", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV25LiqPerMes), "Z9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHAY", AV82hay);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONDESCRIP", A41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SUBTIPOCONCOD1", GXutil.rtrim( A38SubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVACACIONESSUBTIPOCONCOD1", GXutil.rtrim( AV42vacacionesSubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESSUBTIPOCONCOD1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV42vacacionesSubTipoConCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONCONDICION", GXutil.rtrim( A953ConCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TIPOCONCOD", GXutil.rtrim( A37TipoConCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONVIGENCIA", GXutil.ltrim( localUtil.ntoc( A162ConVigencia, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"CONPUENOV", A1826ConPueNov);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONCODIGO", GXutil.rtrim( A26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONCEPTOCONVECODIGO", GXutil.rtrim( A1645ConceptoConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CONCEPTOPAIS", GXutil.ltrim( localUtil.ntoc( A1644ConceptoPais, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGPAICOD", GXutil.ltrim( localUtil.ntoc( AV47LegPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTIPO_TARIFA", GXutil.rtrim( AV111tipo_tarifa));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGCONVECODIGO", GXutil.rtrim( AV48LegConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vULTNOVLIQPERIODO", localUtil.dtoc( AV101ultNovLiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vULTNOVLIQPERIODO", getSecureSignedToken( sPrefix, AV101ultNovLiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSIGLIQLIQPERIODO", localUtil.dtoc( AV100sigLiqLiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSIGLIQLIQPERIODO", getSecureSignedToken( sPrefix, AV100sigLiqLiqPeriodo));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOHASTA", AV41tocoHasta);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vIMPORTESTR", GXutil.rtrim( AV50importeStr));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vERROR", AV93error);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLEGMODTRA", GXutil.rtrim( AV110LegModTra));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vERRORES", AV34errores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vERRORES", AV34errores);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTRNMODE", GXutil.rtrim( AV27TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPARMLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV33parmLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Visible", GXutil.booltostr( Combo_legnumero_Visible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_legnumero_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONCODIGO_Cls", GXutil.rtrim( Combo_concodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_concodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Width", GXutil.rtrim( Dvpanel_pertbl_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Autowidth", GXutil.booltostr( Dvpanel_pertbl_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Autoheight", GXutil.booltostr( Dvpanel_pertbl_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Cls", GXutil.rtrim( Dvpanel_pertbl_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Title", GXutil.rtrim( Dvpanel_pertbl_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Collapsible", GXutil.booltostr( Dvpanel_pertbl_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Collapsed", GXutil.booltostr( Dvpanel_pertbl_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Showcollapseicon", GXutil.booltostr( Dvpanel_pertbl_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Iconposition", GXutil.rtrim( Dvpanel_pertbl_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_PERTBL_Autoscroll", GXutil.booltostr( Dvpanel_pertbl_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_concodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_legnumero_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_concodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_legnumero_Selectedvalue_get));
   }

   public void renderHtmlCloseFormBK2( )
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
      return "NovedadConcepto_ABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Novedad concepto", "") ;
   }

   public void wbBK0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.novedadconcepto_abm");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
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
         wb_table1_9_BK2( true) ;
      }
      else
      {
         wb_table1_9_BK2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_BK2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 111,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV14LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV14LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,111);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLegnumero_Jsonclick, 0, "Attribute", "", "", "", "", edtavLegnumero_Visible, 1, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcodigo_Internalname, GXutil.rtrim( AV15ConCodigo), GXutil.rtrim( localUtil.format( AV15ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavConcodigo_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_NovedadConcepto_ABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConceptofiltro_Internalname, GXutil.ltrim( localUtil.ntoc( AV57ConceptoFiltro, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV57ConceptoFiltro), "9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,113);\"", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVCONCEPTOFILTRO.CLICK."+"'", "", "", "", "", edtavConceptofiltro_Jsonclick, 5, "Attribute", "", "", "", "", edtavConceptofiltro_Visible, 1, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV18CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavClicod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpcod_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAgeorden_Internalname, GXutil.ltrim( localUtil.ntoc( AV20AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV20AgeOrden), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAgeorden_Jsonclick, 0, "Attribute", "", "", "", "", edtavAgeorden_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startBK2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Novedad concepto", ""), (short)(0)) ;
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
            strupBK0( ) ;
         }
      }
   }

   public void wsBK2( )
   {
      startBK2( ) ;
      evtBK2( ) ;
   }

   public void evtBK2( )
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
                              strupBK0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_LEGNUMERO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_CONCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VQUINCENA.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONCEPTOFILTRO.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VOPCIONFORVAL.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e16BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VMETODO.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e17BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VPERDESDE.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e18BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VHASTA.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e19BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
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
                                       /* Execute user event: Enter */
                                       e20BK2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VAGECANTI.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e21BK2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e22BK2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupBK0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavAgecanti_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weBK2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormBK2( ) ;
         }
      }
   }

   public void paBK2( )
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
            GX_FocusControl = edtavAgecanti_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      if ( cmbavOpcionforval.getItemCount() > 0 )
      {
         AV44OpcionForVal = (byte)(GXutil.lval( cmbavOpcionforval.getValidValue(GXutil.trim( GXutil.str( AV44OpcionForVal, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44OpcionForVal", GXutil.str( AV44OpcionForVal, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOpcionforval.setValue( GXutil.trim( GXutil.str( AV44OpcionForVal, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOpcionforval.getInternalname(), "Values", cmbavOpcionforval.ToJavascriptSource(), true);
      }
      AV7Metodo = (byte)(localUtil.ctol( GXutil.ltrim( localUtil.ntoc( AV7Metodo, (byte)(1), (byte)(0), ".", "")), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Metodo", GXutil.str( AV7Metodo, 1, 0));
      if ( cmbavPerdesde.getItemCount() > 0 )
      {
         AV10PerDesde = localUtil.ctod( cmbavPerdesde.getValidValue(localUtil.dtoc( AV10PerDesde, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10PerDesde", localUtil.format(AV10PerDesde, "99/99/99"));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPerdesde.setValue( localUtil.dtoc( AV10PerDesde, 0, "/") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Values", cmbavPerdesde.ToJavascriptSource(), true);
      }
      if ( cmbavHasta.getItemCount() > 0 )
      {
         AV13Hasta = localUtil.ctod( cmbavHasta.getValidValue(localUtil.dtoc( AV13Hasta, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Hasta", localUtil.format(AV13Hasta, "99/99/99"));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavHasta.setValue( localUtil.dtoc( AV13Hasta, 0, "/") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Values", cmbavHasta.ToJavascriptSource(), true);
      }
      if ( cmbavQuincena.getItemCount() > 0 )
      {
         AV106quincena = (byte)(GXutil.lval( cmbavQuincena.getValidValue(GXutil.trim( GXutil.str( AV106quincena, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV106quincena", GXutil.str( AV106quincena, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavQuincena.setValue( GXutil.trim( GXutil.str( AV106quincena, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavQuincena.getInternalname(), "Values", cmbavQuincena.ToJavascriptSource(), true);
      }
      if ( cmbavDia.getItemCount() > 0 )
      {
         AV58dia = (byte)(GXutil.lval( cmbavDia.getValidValue(GXutil.trim( GXutil.str( AV58dia, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58dia), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfBK2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV117Pgmname = "NovedadConcepto_ABM" ;
      Gx_err = (short)(0) ;
   }

   public void rfBK2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e22BK2 ();
         wbBK0( ) ;
      }
   }

   public void send_integrity_lvl_hashesBK2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV117Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV117Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vADELVACPROXCONCODIGO", GXutil.rtrim( AV75adelVacProxConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vADELVACPROXCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75adelVacProxConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vHOY", localUtil.dtoc( AV29hoy, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOY", getSecureSignedToken( sPrefix, AV29hoy));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vHORASNORMALESCONCODIGO", GXutil.rtrim( AV83horasNormalesConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHORASNORMALESCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83horasNormalesConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vANIO", GXutil.ltrim( localUtil.ntoc( AV26anio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vANIO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV26anio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQPERANO", GXutil.ltrim( localUtil.ntoc( AV24LiqPerAno, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQPERANO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV24LiqPerAno), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQPERMES", GXutil.ltrim( localUtil.ntoc( AV25LiqPerMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQPERMES", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV25LiqPerMes), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVACACIONESSUBTIPOCONCOD1", GXutil.rtrim( AV42vacacionesSubTipoConCod1));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESSUBTIPOCONCOD1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV42vacacionesSubTipoConCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vULTNOVLIQPERIODO", localUtil.dtoc( AV101ultNovLiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vULTNOVLIQPERIODO", getSecureSignedToken( sPrefix, AV101ultNovLiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSIGLIQLIQPERIODO", localUtil.dtoc( AV100sigLiqLiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSIGLIQLIQPERIODO", getSecureSignedToken( sPrefix, AV100sigLiqLiqPeriodo));
   }

   public void before_start_formulas( )
   {
      AV117Pgmname = "NovedadConcepto_ABM" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupBK0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13BK2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vLEGNUMERO_DATA"), AV21LegNumero_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV46DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCONCODIGO_DATA"), AV23ConCodigo_Data);
         /* Read saved values. */
         wcpOAV27TrnMode = httpContext.cgiGet( sPrefix+"wcpOAV27TrnMode") ;
         wcpOAV18CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV18CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV19EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV19EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV33parmLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV33parmLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV20AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV20AgeOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV103yaModificoImporte = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vYAMODIFICOIMPORTE")) ;
         Combo_legnumero_Cls = httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Cls") ;
         Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Selectedvalue_set") ;
         Combo_legnumero_Visible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Visible")) ;
         Combo_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Emptyitem")) ;
         Combo_concodigo_Cls = httpContext.cgiGet( sPrefix+"COMBO_CONCODIGO_Cls") ;
         Combo_concodigo_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_CONCODIGO_Selectedvalue_set") ;
         Dvpanel_tableattributes_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         Dvpanel_pertbl_Width = httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Width") ;
         Dvpanel_pertbl_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Autowidth")) ;
         Dvpanel_pertbl_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Autoheight")) ;
         Dvpanel_pertbl_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Cls") ;
         Dvpanel_pertbl_Title = httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Title") ;
         Dvpanel_pertbl_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Collapsible")) ;
         Dvpanel_pertbl_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Collapsed")) ;
         Dvpanel_pertbl_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Showcollapseicon")) ;
         Dvpanel_pertbl_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Iconposition") ;
         Dvpanel_pertbl_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_PERTBL_Autoscroll")) ;
         Combo_concodigo_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_CONCODIGO_Selectedvalue_get") ;
         Combo_legnumero_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Selectedvalue_get") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavAgecanti_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavAgecanti_Internalname)), DecimalUtil.stringToDec("999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAGECANTI");
            GX_FocusControl = edtavAgecanti_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16AgeCanti = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
         }
         else
         {
            AV16AgeCanti = localUtil.ctond( httpContext.cgiGet( edtavAgecanti_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
         }
         cmbavOpcionforval.setValue( httpContext.cgiGet( cmbavOpcionforval.getInternalname()) );
         AV44OpcionForVal = (byte)(GXutil.lval( httpContext.cgiGet( cmbavOpcionforval.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44OpcionForVal", GXutil.str( AV44OpcionForVal, 1, 0));
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavAgeimporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavAgeimporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAGEIMPORTE");
            GX_FocusControl = edtavAgeimporte_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17AgeImporte = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17AgeImporte", GXutil.ltrimstr( AV17AgeImporte, 14, 2));
         }
         else
         {
            AV17AgeImporte = localUtil.ctond( httpContext.cgiGet( edtavAgeimporte_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17AgeImporte", GXutil.ltrimstr( AV17AgeImporte, 14, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( radavMetodo.getInternalname()), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( radavMetodo.getInternalname()), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMETODO");
            wbErr = true ;
            AV7Metodo = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Metodo", GXutil.str( AV7Metodo, 1, 0));
         }
         else
         {
            AV7Metodo = (byte)(localUtil.ctol( httpContext.cgiGet( radavMetodo.getInternalname()), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Metodo", GXutil.str( AV7Metodo, 1, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavAgefecdes_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vAGEFECDES");
            GX_FocusControl = edtavAgefecdes_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8AgeFecDes = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AgeFecDes", localUtil.format(AV8AgeFecDes, "99/99/9999"));
         }
         else
         {
            AV8AgeFecDes = localUtil.ctod( httpContext.cgiGet( edtavAgefecdes_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AgeFecDes", localUtil.format(AV8AgeFecDes, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavAgefechas_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vAGEFECHAS");
            GX_FocusControl = edtavAgefechas_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9AgeFecHas = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9AgeFecHas", localUtil.format(AV9AgeFecHas, "99/99/9999"));
         }
         else
         {
            AV9AgeFecHas = localUtil.ctod( httpContext.cgiGet( edtavAgefechas_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9AgeFecHas", localUtil.format(AV9AgeFecHas, "99/99/9999"));
         }
         cmbavPerdesde.setValue( httpContext.cgiGet( cmbavPerdesde.getInternalname()) );
         AV10PerDesde = localUtil.ctod( httpContext.cgiGet( cmbavPerdesde.getInternalname()), 0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10PerDesde", localUtil.format(AV10PerDesde, "99/99/99"));
         cmbavHasta.setValue( httpContext.cgiGet( cmbavHasta.getInternalname()) );
         AV13Hasta = localUtil.ctod( httpContext.cgiGet( cmbavHasta.getInternalname()), 0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Hasta", localUtil.format(AV13Hasta, "99/99/99"));
         cmbavQuincena.setValue( httpContext.cgiGet( cmbavQuincena.getInternalname()) );
         AV106quincena = (byte)(GXutil.lval( httpContext.cgiGet( cmbavQuincena.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV106quincena", GXutil.str( AV106quincena, 1, 0));
         cmbavDia.setValue( httpContext.cgiGet( cmbavDia.getInternalname()) );
         AV58dia = (byte)(GXutil.lval( httpContext.cgiGet( cmbavDia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58dia), 2, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLEGNUMERO");
            GX_FocusControl = edtavLegnumero_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV14LegNumero = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
         }
         else
         {
            AV14LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavLegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
         }
         AV15ConCodigo = httpContext.cgiGet( edtavConcodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConCodigo", AV15ConCodigo);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavConceptofiltro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavConceptofiltro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCONCEPTOFILTRO");
            GX_FocusControl = edtavConceptofiltro_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV57ConceptoFiltro = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57ConceptoFiltro", GXutil.str( AV57ConceptoFiltro, 1, 0));
         }
         else
         {
            AV57ConceptoFiltro = (byte)(localUtil.ctol( httpContext.cgiGet( edtavConceptofiltro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57ConceptoFiltro", GXutil.str( AV57ConceptoFiltro, 1, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13BK2 ();
      if (returnInSub) return;
   }

   public void e13BK2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, "1") ;
      GXt_char1 = AV75adelVacProxConCodigo ;
      GXt_char2 = AV75adelVacProxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      novedadconcepto_abm_impl.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char2, GXv_char4) ;
      novedadconcepto_abm_impl.this.GXt_char1 = GXv_char4[0] ;
      AV75adelVacProxConCodigo = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75adelVacProxConCodigo", AV75adelVacProxConCodigo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vADELVACPROXCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV75adelVacProxConCodigo, ""))));
      GXt_char2 = AV83horasNormalesConCodigo ;
      GXt_char1 = AV83horasNormalesConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      novedadconcepto_abm_impl.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char3) ;
      novedadconcepto_abm_impl.this.GXt_char2 = GXv_char3[0] ;
      AV83horasNormalesConCodigo = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83horasNormalesConCodigo", AV83horasNormalesConCodigo);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHORASNORMALESCONCODIGO", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV83horasNormalesConCodigo, ""))));
      GXt_char2 = AV42vacacionesSubTipoConCod1 ;
      GXv_char4[0] = GXt_char2 ;
      new web.subtipovacaciones(remoteHandle, context).execute( GXv_char4) ;
      novedadconcepto_abm_impl.this.GXt_char2 = GXv_char4[0] ;
      AV42vacacionesSubTipoConCod1 = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42vacacionesSubTipoConCod1", AV42vacacionesSubTipoConCod1);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESSUBTIPOCONCOD1", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV42vacacionesSubTipoConCod1, ""))));
      AV57ConceptoFiltro = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57ConceptoFiltro", GXutil.str( AV57ConceptoFiltro, 1, 0));
      AV106quincena = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV106quincena", GXutil.str( AV106quincena, 1, 0));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV46DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV46DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      edtavConcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcodigo_Visible), 5, 0), true);
      edtavLegnumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLegnumero_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOCONCODIGO' */
      S122 ();
      if (returnInSub) return;
      edtavConceptofiltro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConceptofiltro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConceptofiltro_Visible), 5, 0), true);
      edtavClicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClicod_Visible), 5, 0), true);
      edtavEmpcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEmpcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpcod_Visible), 5, 0), true);
      edtavAgeorden_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgeorden_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgeorden_Visible), 5, 0), true);
      AV29hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29hoy", localUtil.format(AV29hoy, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHOY", getSecureSignedToken( sPrefix, AV29hoy));
      AV26anio = (short)(GXutil.year( AV29hoy)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26anio), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vANIO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV26anio), "ZZZ9")));
      if ( ! (0==AV33parmLegNumero) )
      {
         AV14LegNumero = AV33parmLegNumero ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
         Combo_legnumero_Visible = false ;
         ucCombo_legnumero.sendProperty(context, sPrefix, false, Combo_legnumero_Internalname, "Visible", GXutil.booltostr( Combo_legnumero_Visible));
         /* Execute user subroutine: 'GET LEGAJO CLASE' */
         S132 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'CONCEPTO POR DEFECTO' */
         S142 ();
         if (returnInSub) return;
      }
      else
      {
         Combo_legnumero_Visible = true ;
         ucCombo_legnumero.sendProperty(context, sPrefix, false, Combo_legnumero_Internalname, "Visible", GXutil.booltostr( Combo_legnumero_Visible));
      }
      AV7Metodo = (byte)(2) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Metodo", GXutil.str( AV7Metodo, 1, 0));
      /* Execute user subroutine: 'COMBO PERDESDE' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBLES' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV27TrnMode, httpContext.getMessage( "INS", "")) == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "ins 1", "")) ;
         AV16AgeCanti = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "ins 2", "")) ;
         /* Execute user subroutine: 'DEFAULT PERIODO' */
         S172 ();
         if (returnInSub) return;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "ins 3", "")) ;
         /* Execute user subroutine: 'COMBO OPCIONFORVAL' */
         S182 ();
         if (returnInSub) return;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "ins 4", "")) ;
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "return por ", "")+AV27TrnMode) ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "endstart", "")) ;
   }

   public void e12BK2( )
   {
      /* Combo_concodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV113tocoConcepto = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV113tocoConcepto", AV113tocoConcepto);
      AV15ConCodigo = Combo_concodigo_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConCodigo", AV15ConCodigo);
      /* Execute user subroutine: 'VISIBLES' */
      S162 ();
      if (returnInSub) return;
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "concodigo ", "")+AV15ConCodigo+httpContext.getMessage( " &adelVacProxConCodigo ", "")+GXutil.trim( AV75adelVacProxConCodigo)) ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConCodigo)), GXutil.upper( GXutil.trim( AV75adelVacProxConCodigo))) == 0 )
      {
         AV74auxAgeFecDes = GXutil.addmth( AV8AgeFecDes, (short)(1)) ;
         AV76auxAgeFecHas = GXutil.addmth( AV9AgeFecHas, (short)(1)) ;
         AV79LiqDCanti = DecimalUtil.doubleToDec(0) ;
      }
      else
      {
         AV74auxAgeFecDes = AV8AgeFecDes ;
         AV76auxAgeFecHas = AV9AgeFecHas ;
         AV79LiqDCanti = DecimalUtil.doubleToDec(1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&auxAgeFecDes ", "")+GXutil.trim( localUtil.dtoc( AV74auxAgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      /* Execute user subroutine: 'COMBO OPCIONFORVAL' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavOpcionforval.setValue( GXutil.trim( GXutil.str( AV44OpcionForVal, 1, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOpcionforval.getInternalname(), "Values", cmbavOpcionforval.ToJavascriptSource(), true);
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e11BK2( )
   {
      /* Combo_legnumero_Onoptionclicked Routine */
      returnInSub = false ;
      AV114tocoLegajo = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV114tocoLegajo", AV114tocoLegajo);
      AV14LegNumero = (int)(GXutil.lval( Combo_legnumero_Selectedvalue_get)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
      AV106quincena = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV106quincena", GXutil.str( AV106quincena, 1, 0));
      AV15ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConCodigo", AV15ConCodigo);
      /* Execute user subroutine: 'GET LEGAJO CLASE' */
      S132 ();
      if (returnInSub) return;
      GXv_char4[0] = AV48LegConveCodigo ;
      GXv_int7[0] = AV47LegPaiCod ;
      new web.empleadogetconvenio2(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_char4, GXv_int7) ;
      novedadconcepto_abm_impl.this.AV48LegConveCodigo = GXv_char4[0] ;
      novedadconcepto_abm_impl.this.AV47LegPaiCod = GXv_int7[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48LegConveCodigo", AV48LegConveCodigo);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47LegPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47LegPaiCod), 4, 0));
      /* Execute user subroutine: 'COMBO PERDESDE' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT PERIODO' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBLES' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOCONCODIGO' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'CONCEPTO POR DEFECTO' */
      S142 ();
      if (returnInSub) return;
      if ( AV32LegClase == 2 )
      {
         /* Execute user subroutine: 'DEFAULT QUINCENAS' */
         S192 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'OPCIONES FOR VAL' */
      S202 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavQuincena.setValue( GXutil.trim( GXutil.str( AV106quincena, 1, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavQuincena.getInternalname(), "Values", cmbavQuincena.ToJavascriptSource(), true);
      cmbavPerdesde.setValue( localUtil.dtoc( AV10PerDesde, 0, "/") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Values", cmbavPerdesde.ToJavascriptSource(), true);
      cmbavHasta.setValue( localUtil.dtoc( AV13Hasta, 0, "/") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Values", cmbavHasta.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV23ConCodigo_Data", AV23ConCodigo_Data);
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void S122( )
   {
      /* 'LOADCOMBOCONCODIGO' Routine */
      returnInSub = false ;
      AV23ConCodigo_Data.clear();
      /* Using cursor H00BK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), AV42vacacionesSubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1826ConPueNov = H00BK2_A1826ConPueNov[0] ;
         A162ConVigencia = H00BK2_A162ConVigencia[0] ;
         A37TipoConCod = H00BK2_A37TipoConCod[0] ;
         A38SubTipoConCod1 = H00BK2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = H00BK2_n38SubTipoConCod1[0] ;
         A953ConCondicion = H00BK2_A953ConCondicion[0] ;
         n953ConCondicion = H00BK2_n953ConCondicion[0] ;
         A3CliCod = H00BK2_A3CliCod[0] ;
         A26ConCodigo = H00BK2_A26ConCodigo[0] ;
         A1645ConceptoConveCodigo = H00BK2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = H00BK2_n1645ConceptoConveCodigo[0] ;
         A1644ConceptoPais = H00BK2_A1644ConceptoPais[0] ;
         n1644ConceptoPais = H00BK2_n1644ConceptoPais[0] ;
         A41ConDescrip = H00BK2_A41ConDescrip[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "ConCodigo ", "")+GXutil.trim( A26ConCodigo)) ;
         if ( ! (GXutil.strcmp("", A1645ConceptoConveCodigo)==0) && ! H00BK2_n1645ConceptoConveCodigo[0] )
         {
            if ( ( AV57ConceptoFiltro == 2 ) || ( ( A1644ConceptoPais == AV47LegPaiCod ) && ( GXutil.strcmp(A1645ConceptoConveCodigo, AV48LegConveCodigo) == 0 ) ) || ( ( GXutil.strcmp(AV111tipo_tarifa, "H") == 0 ) && (GXutil.strcmp("", AV48LegConveCodigo)==0) ) )
            {
               AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
               AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( A41ConDescrip) );
               AV23ConCodigo_Data.add(AV22Combo_DataItem, 0);
            }
         }
         else
         {
            AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A41ConDescrip );
            AV23ConCodigo_Data.add(AV22Combo_DataItem, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      Combo_concodigo_Selectedvalue_set = AV15ConCodigo ;
      ucCombo_concodigo.sendProperty(context, sPrefix, false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
   }

   public void S112( )
   {
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      /* Using cursor H00BK3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = H00BK3_A3CliCod[0] ;
         A1EmpCod = H00BK3_A1EmpCod[0] ;
         A1818LegEstado = H00BK3_A1818LegEstado[0] ;
         A6LegNumero = H00BK3_A6LegNumero[0] ;
         A250LegIdNomApe = H00BK3_A250LegIdNomApe[0] ;
         AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV21LegNumero_Data.add(AV22Combo_DataItem, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      Combo_legnumero_Selectedvalue_set = ((0==AV14LegNumero) ? "" : GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
      ucCombo_legnumero.sendProperty(context, sPrefix, false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
   }

   public void e14BK2( )
   {
      /* Quincena_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VISIBILIDAD DIA' */
      S212 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e15BK2( )
   {
      /* Conceptofiltro_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADCOMBOCONCODIGO' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV23ConCodigo_Data", AV23ConCodigo_Data);
   }

   public void e16BK2( )
   {
      /* Opcionforval_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OPCIONES FOR VAL' */
      S202 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e17BK2( )
   {
      /* Metodo_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VISIBLES' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e18BK2( )
   {
      /* Perdesde_Click Routine */
      returnInSub = false ;
      AV40tocoPeriodos = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40tocoPeriodos", AV40tocoPeriodos);
      if ( ! AV41tocoHasta )
      {
         AV13Hasta = AV10PerDesde ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Hasta", localUtil.format(AV13Hasta, "99/99/99"));
      }
      /* Execute user subroutine: 'ARMA FECHAS DESDE COMBOS' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'OPCIONES FOR VAL' */
      S202 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavHasta.setValue( localUtil.dtoc( AV13Hasta, 0, "/") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Values", cmbavHasta.ToJavascriptSource(), true);
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e19BK2( )
   {
      /* Hasta_Click Routine */
      returnInSub = false ;
      AV41tocoHasta = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41tocoHasta", AV41tocoHasta);
      AV40tocoPeriodos = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40tocoPeriodos", AV40tocoPeriodos);
      /* Execute user subroutine: 'ARMA FECHAS DESDE COMBOS' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'OPCIONES FOR VAL' */
      S202 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e20BK2 ();
      if (returnInSub) return;
   }

   public void e20BK2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV34errores.clear();
      if ( (0==AV14LegNumero) )
      {
         AV34errores.add(httpContext.getMessage( "Debe ingresar legajo", ""), 0);
      }
      if ( (GXutil.strcmp("", AV15ConCodigo)==0) )
      {
         AV34errores.add(httpContext.getMessage( "Debe ingresar concepto", ""), 0);
      }
      else
      {
         if ( AV16AgeCanti.doubleValue() > 0 )
         {
            GXv_objcol_int8[0] = AV35rangoNumeros ;
            new web.getrangoconcepto(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_objcol_int8) ;
            AV35rangoNumeros = GXv_objcol_int8[0] ;
            if ( AV35rangoNumeros.size() >= 2 )
            {
               if ( ( AV16AgeCanti.doubleValue() < ((Number) AV35rangoNumeros.elementAt(-1+1)).shortValue() ) || ( AV16AgeCanti.doubleValue() > ((Number) AV35rangoNumeros.elementAt(-1+2)).shortValue() ) )
               {
                  AV34errores.add(httpContext.getMessage( "Cantidad fuera de rango", ""), 0);
               }
            }
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeCanti)==0) )
      {
         AV34errores.add(httpContext.getMessage( "La cantidad debe ser mayor a cero", ""), 0);
      }
      GXv_char4[0] = AV43ConFormula ;
      new web.getformulaconcepto(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_char4) ;
      novedadconcepto_abm_impl.this.AV43ConFormula = GXv_char4[0] ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV17AgeImporte)==0) && ( (GXutil.strcmp("", AV43ConFormula)==0) || ( AV44OpcionForVal == 2 ) ) )
      {
         AV34errores.add(httpContext.getMessage( "Debe ingresar importe", ""), 0);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV9AgeFecHas)) && GXutil.resetTime(AV8AgeFecDes).after( GXutil.resetTime( AV9AgeFecHas )) )
      {
         AV34errores.add(httpContext.getMessage( "La fecha hasta debe ser posterior a la fecha desde", ""), 0);
      }
      if ( ( AV32LegClase == 2 ) && (0==AV106quincena) )
      {
         AV34errores.add(httpContext.getMessage( "Debe seleccionar quincena", ""), 0);
      }
      GXt_char2 = AV65feriadoTrabajadoConCodigo ;
      GXt_char1 = AV65feriadoTrabajadoConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.feriadostrabajados_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      novedadconcepto_abm_impl.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char3) ;
      novedadconcepto_abm_impl.this.GXt_char2 = GXv_char3[0] ;
      AV65feriadoTrabajadoConCodigo = GXt_char2 ;
      GXt_char2 = AV105feriadoTrabajadoHorConCodigo ;
      GXt_char1 = AV105feriadoTrabajadoHorConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.feriadostrabajadoshoras_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      novedadconcepto_abm_impl.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char3) ;
      novedadconcepto_abm_impl.this.GXt_char2 = GXv_char3[0] ;
      AV105feriadoTrabajadoHorConCodigo = GXt_char2 ;
      if ( ( GXutil.strcmp(AV15ConCodigo, AV65feriadoTrabajadoConCodigo) == 0 ) || ( GXutil.strcmp(AV15ConCodigo, AV105feriadoTrabajadoHorConCodigo) == 0 ) )
      {
         if ( (0==AV58dia) )
         {
            AV34errores.add(httpContext.getMessage( "Debe seleccionar día específico del feriado trabajado", ""), 0);
         }
         else
         {
            GXt_int9 = AV71PaiCod ;
            GXv_int7[0] = GXt_int9 ;
            new web.empresagetpais(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, GXv_int7) ;
            novedadconcepto_abm_impl.this.GXt_int9 = GXv_int7[0] ;
            AV71PaiCod = GXt_int9 ;
            AV70diaDate = localUtil.ymdtod( GXutil.year( AV10PerDesde), GXutil.month( AV10PerDesde), AV58dia) ;
            GXt_boolean10 = AV72feriadoEs ;
            GXv_boolean11[0] = GXt_boolean10 ;
            new web.diaesferiado(remoteHandle, context).execute( AV71PaiCod, AV70diaDate, GXv_boolean11) ;
            novedadconcepto_abm_impl.this.GXt_boolean10 = GXv_boolean11[0] ;
            AV72feriadoEs = GXt_boolean10 ;
            if ( ! AV72feriadoEs )
            {
               AV34errores.add(httpContext.getMessage( "Debe seleccionar día feriado", ""), 0);
            }
         }
      }
      else
      {
         if ( ( AV32LegClase != 1 ) && ( AV32LegClase != 2 ) && ( AV7Metodo == 2 ) && (0==AV58dia) )
         {
            AV34errores.add(httpContext.getMessage( "Debe seleccionar día", ""), 0);
         }
      }
      GXv_char4[0] = AV55SubTipoConCod1 ;
      GXv_char3[0] = "" ;
      new web.conceptogetsubtipos(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_char4, GXv_char3) ;
      novedadconcepto_abm_impl.this.AV55SubTipoConCod1 = GXv_char4[0] ;
      if ( GXutil.strcmp(AV55SubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_char4[0] = AV63MprCod ;
         new web.getlegajomodalidad(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_char4) ;
         novedadconcepto_abm_impl.this.AV63MprCod = GXv_char4[0] ;
         GXv_boolean11[0] = AV64MprHorasExtras ;
         new web.getmodalidadextras(remoteHandle, context).execute( AV63MprCod, GXv_boolean11) ;
         novedadconcepto_abm_impl.this.AV64MprHorasExtras = GXv_boolean11[0] ;
         if ( ! AV64MprHorasExtras )
         {
            AV34errores.add(httpContext.getMessage( "Modalidad de contratación no permite realizar horas extras", ""), 0);
         }
         GXv_char4[0] = AV67SecCodigo ;
         GXv_char3[0] = AV66PuestoCodigo ;
         GXv_char12[0] = AV73PuestoDescrip ;
         new web.getlegajopuesto(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_char4, GXv_char3, GXv_char12) ;
         novedadconcepto_abm_impl.this.AV67SecCodigo = GXv_char4[0] ;
         novedadconcepto_abm_impl.this.AV66PuestoCodigo = GXv_char3[0] ;
         novedadconcepto_abm_impl.this.AV73PuestoDescrip = GXv_char12[0] ;
         GXv_boolean11[0] = AV68PuestoHorasExt ;
         new web.getpuestoextras(remoteHandle, context).execute( AV18CliCod, AV67SecCodigo, AV66PuestoCodigo, GXv_boolean11) ;
         novedadconcepto_abm_impl.this.AV68PuestoHorasExt = GXv_boolean11[0] ;
         if ( ! AV68PuestoHorasExt && ! (GXutil.strcmp("", AV66PuestoCodigo)==0) )
         {
            AV34errores.add(httpContext.getMessage( "Puesto ", "")+GXutil.trim( AV73PuestoDescrip)+httpContext.getMessage( " no permite realizar horas extras", ""), 0);
         }
      }
      if ( AV34errores.size() == 0 )
      {
         GXv_char12[0] = AV43ConFormula ;
         new web.getformulaconcepto(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_char12) ;
         novedadconcepto_abm_impl.this.AV43ConFormula = GXv_char12[0] ;
         if ( ! (GXutil.strcmp("", AV43ConFormula)==0) )
         {
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConCodigo)), GXutil.upper( GXutil.trim( AV75adelVacProxConCodigo))) == 0 )
            {
               AV74auxAgeFecDes = GXutil.addmth( AV8AgeFecDes, (short)(1)) ;
               AV76auxAgeFecHas = GXutil.addmth( AV9AgeFecHas, (short)(1)) ;
            }
            else
            {
               AV74auxAgeFecDes = AV8AgeFecDes ;
               AV76auxAgeFecHas = AV9AgeFecHas ;
            }
            if ( AV44OpcionForVal == 1 )
            {
               GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char12[0] = AV93error ;
               GXv_decimal14[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char4[0] = AV50importeStr ;
               new web.previsualizacionnovedad(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, AV15ConCodigo, DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(0), AV74auxAgeFecDes, AV76auxAgeFecHas, true, GXv_decimal13, GXv_char12, GXv_decimal14, GXv_char4) ;
               novedadconcepto_abm_impl.this.AV93error = GXv_char12[0] ;
               novedadconcepto_abm_impl.this.AV50importeStr = GXv_char4[0] ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93error", AV93error);
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50importeStr", AV50importeStr);
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "previ ", "")+AV50importeStr) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, CommonUtil.decimalVal( AV50importeStr, "."))==0) && ( AV44OpcionForVal == 1 ) )
            {
               if ( ! (GXutil.strcmp("", AV93error)==0) )
               {
                  GXv_char12[0] = AV93error ;
                  GXv_char4[0] = "" ;
                  new web.parsearerrorprincipal(remoteHandle, context).execute( GXv_char12, GXv_char4) ;
                  novedadconcepto_abm_impl.this.AV93error = GXv_char12[0] ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93error", AV93error);
                  AV34errores.add(httpContext.getMessage( "El concepto no se puede agregar porque devuelve cero. Error: ", "")+GXutil.trim( AV93error), 0);
               }
               else
               {
                  AV34errores.add(httpContext.getMessage( "El concepto no se puede agregar porque devuelve ", "")+GXutil.trim( AV50importeStr), 0);
               }
            }
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "enter &errores ", "")+GXutil.trim( GXutil.str( AV34errores.size(), 9, 0))) ;
      if ( AV34errores.size() > 0 )
      {
         /* Execute user subroutine: 'MOSTRAR ERRORES' */
         S232 ();
         if (returnInSub) return;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "enter &&dia ", "")+GXutil.trim( GXutil.str( AV58dia, 2, 0))) ;
         if ( ! (0==AV58dia) )
         {
            AV8AgeFecDes = localUtil.ymdtod( GXutil.year( AV8AgeFecDes), GXutil.month( AV8AgeFecDes), AV58dia) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AgeFecDes", localUtil.format(AV8AgeFecDes, "99/99/9999"));
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "ente ", "")+GXutil.trim( localUtil.dtoc( AV8AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            AV9AgeFecHas = AV8AgeFecDes ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9AgeFecHas", localUtil.format(AV9AgeFecHas, "99/99/9999"));
         }
         if ( AV106quincena == 3 )
         {
            AV11primeraQuincena = true ;
            AV12segundaQuincena = true ;
         }
         else
         {
            if ( AV106quincena == 2 )
            {
               AV11primeraQuincena = false ;
               AV12segundaQuincena = true ;
            }
            else
            {
               if ( AV106quincena == 1 )
               {
                  AV11primeraQuincena = true ;
                  AV12segundaQuincena = false ;
               }
               else
               {
                  AV11primeraQuincena = false ;
                  AV12segundaQuincena = false ;
               }
            }
         }
         GXv_objcol_svchar15[0] = AV34errores ;
         new web.grabanovedadconcepto(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, AV15ConCodigo, AV58dia, AV16AgeCanti, AV17AgeImporte, AV32LegClase, AV110LegModTra, AV7Metodo, AV8AgeFecDes, AV9AgeFecHas, AV11primeraQuincena, AV12segundaQuincena, GXv_objcol_svchar15) ;
         AV34errores = GXv_objcol_svchar15[0] ;
         if ( AV34errores.size() > 0 )
         {
            /* Execute user subroutine: 'MOSTRAR ERRORES' */
            S232 ();
            if (returnInSub) return;
         }
         else
         {
            new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV18CliCod, AV19EmpCod, AV14LegNumero, httpContext.getMessage( "NOVEDADES", "")) ;
            httpContext.setWebReturnParms(new Object[] {});
            httpContext.setWebReturnParmsMetadata(new Object[] {});
            httpContext.wjLocDisableFrm = (byte)(1) ;
            httpContext.nUserReturn = (byte)(1) ;
            returnInSub = true;
            if (true) return;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV34errores", AV34errores);
   }

   public void e21BK2( )
   {
      /* Agecanti_Controlvaluechanged Routine */
      returnInSub = false ;
      AV102yaModificoCantidad = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV102yaModificoCantidad", AV102yaModificoCantidad);
      /* Execute user subroutine: 'OPCIONES FOR VAL' */
      S202 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S222( )
   {
      /* 'ARMA FECHAS DESDE COMBOS' Routine */
      returnInSub = false ;
      AV8AgeFecDes = AV10PerDesde ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AgeFecDes", localUtil.format(AV8AgeFecDes, "99/99/9999"));
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "sub arma fechas ", "")+GXutil.trim( localUtil.dtoc( AV8AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV9AgeFecHas = AV13Hasta ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9AgeFecHas", localUtil.format(AV9AgeFecHas, "99/99/9999"));
      /* Execute user subroutine: 'VISIBILIDAD DIA' */
      S212 ();
      if (returnInSub) return;
   }

   public void S152( )
   {
      /* 'COMBO PERDESDE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "Combo PerDesde &LegNumero ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
      AV92hastaAnio = AV26anio ;
      if ( (0==AV14LegNumero) )
      {
         AV90desdeAnio = AV26anio ;
      }
      else
      {
         GXv_int7[0] = AV88ultAnio ;
         GXv_int16[0] = AV89ultMes ;
         GXv_boolean11[0] = AV82hay ;
         new web.getperiodoultnovedad(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_int7, GXv_int16, GXv_boolean11) ;
         novedadconcepto_abm_impl.this.AV88ultAnio = GXv_int7[0] ;
         novedadconcepto_abm_impl.this.AV89ultMes = (byte)((byte)(GXv_int16[0])) ;
         novedadconcepto_abm_impl.this.AV82hay = GXv_boolean11[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV82hay", AV82hay);
         new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&LegNumero ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))+httpContext.getMessage( " &hay ", "")+GXutil.trim( GXutil.booltostr( AV82hay))) ;
         if ( ! AV82hay )
         {
            GXv_date17[0] = AV91LegFecIngreso ;
            new web.getfecingreso(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_date17) ;
            novedadconcepto_abm_impl.this.AV91LegFecIngreso = GXv_date17[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&LegFecIngreso ", "")+GXutil.trim( localUtil.dtoc( AV91LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            AV90desdeAnio = (short)(GXutil.year( AV91LegFecIngreso)) ;
         }
         else
         {
            AV90desdeAnio = AV88ultAnio ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&desdeAnio ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0))+httpContext.getMessage( " &hastaAnio ", "")+GXutil.trim( GXutil.str( AV92hastaAnio, 4, 0))) ;
      cmbavPerdesde.removeAllItems();
      cmbavHasta.removeAllItems();
      while ( AV90desdeAnio <= AV92hastaAnio )
      {
         AV30mesPalabra.clear();
         AV30mesPalabra.add(httpContext.getMessage( "ENERO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "FEBRERO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "MARZO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "ABRIL ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "MAYO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "JUNIO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "JULIO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "AGOSTO ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "SEPTIEMBRE ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "OCTUBRE ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "NOVIEMBRE ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV30mesPalabra.add(httpContext.getMessage( "DICIEMBRE ", "")+GXutil.trim( GXutil.str( AV90desdeAnio, 4, 0)), 0);
         AV31i = (short)(1) ;
         while ( AV31i <= 12 )
         {
            cmbavPerdesde.addItem(localUtil.dtoc( localUtil.ymdtod( AV90desdeAnio, AV31i, 1), 0, "/"), GXutil.trim( (String)AV30mesPalabra.elementAt(-1+AV31i)), (short)(0));
            AV31i = (short)(AV31i+1) ;
         }
         AV31i = (short)(1) ;
         while ( AV31i <= 12 )
         {
            cmbavHasta.addItem(localUtil.dtoc( localUtil.ymdtod( AV90desdeAnio, AV31i, 1), 0, "/"), GXutil.trim( (String)AV30mesPalabra.elementAt(-1+AV31i)), (short)(0));
            AV31i = (short)(AV31i+1) ;
         }
         AV90desdeAnio = (short)(AV90desdeAnio+1) ;
      }
   }

   public void S162( )
   {
      /* 'VISIBLES' Routine */
      returnInSub = false ;
      if ( AV7Metodo == 1 )
      {
         edtavAgefecdes_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgefecdes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgefecdes_Visible), 5, 0), true);
         edtavAgefechas_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgefechas_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgefechas_Visible), 5, 0), true);
         cmbavPerdesde.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Visible", GXutil.ltrimstr( cmbavPerdesde.getVisible(), 5, 0), true);
         cmbavQuincena.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavQuincena.getInternalname(), "Visible", GXutil.ltrimstr( cmbavQuincena.getVisible(), 5, 0), true);
         cmbavHasta.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Visible", GXutil.ltrimstr( cmbavHasta.getVisible(), 5, 0), true);
         cmbavDia.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
      }
      else
      {
         edtavAgefecdes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgefecdes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgefecdes_Visible), 5, 0), true);
         edtavAgefechas_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgefechas_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgefechas_Visible), 5, 0), true);
         cmbavPerdesde.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Visible", GXutil.ltrimstr( cmbavPerdesde.getVisible(), 5, 0), true);
         if ( AV32LegClase == 2 )
         {
            cmbavQuincena.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavQuincena.getInternalname(), "Visible", GXutil.ltrimstr( cmbavQuincena.getVisible(), 5, 0), true);
         }
         else
         {
            cmbavQuincena.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavQuincena.getInternalname(), "Visible", GXutil.ltrimstr( cmbavQuincena.getVisible(), 5, 0), true);
         }
         cmbavHasta.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Visible", GXutil.ltrimstr( cmbavHasta.getVisible(), 5, 0), true);
      }
      edtavAgecanti_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgecanti_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgecanti_Visible), 5, 0), true);
      edtavAgecanti_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgecanti_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgecanti_Enabled), 5, 0), true);
      GXv_objcol_int8[0] = AV35rangoNumeros ;
      new web.getrangoconcepto(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_objcol_int8) ;
      AV35rangoNumeros = GXv_objcol_int8[0] ;
      if ( AV35rangoNumeros.size() >= 1 )
      {
         if ( ( AV35rangoNumeros.size() == 2 ) || ( AV35rangoNumeros.size() == 1 ) )
         {
            if ( ( AV35rangoNumeros.size() == 1 ) || ( ( AV35rangoNumeros.size() == 2 ) && ( ((Number) AV35rangoNumeros.elementAt(-1+1)).shortValue() == ((Number) AV35rangoNumeros.elementAt(-1+2)).shortValue() ) ) )
            {
               edtavAgecanti_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgecanti_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgecanti_Enabled), 5, 0), true);
            }
            else
            {
               if ( ( AV35rangoNumeros.size() == 2 ) && ( ((Number) AV35rangoNumeros.elementAt(-1+1)).shortValue() == 0 ) && ( ((Number) AV35rangoNumeros.elementAt(-1+2)).shortValue() == 1 ) )
               {
                  edtavAgecanti_Visible = 0 ;
                  httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgecanti_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgecanti_Visible), 5, 0), true);
               }
            }
         }
      }
      /* Execute user subroutine: 'VISIBILIDAD DIA' */
      S212 ();
      if (returnInSub) return;
   }

   public void S172( )
   {
      /* 'DEFAULT PERIODO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "default periodo &tocoPeriodos ", "")+GXutil.trim( GXutil.booltostr( AV40tocoPeriodos))) ;
      if ( ! AV40tocoPeriodos )
      {
         GXv_int16[0] = AV19EmpCod ;
         GXv_int18[0] = AV14LegNumero ;
         GXv_int7[0] = AV108defaultAnio ;
         GXv_int19[0] = AV109defaultMesNro ;
         GXv_boolean11[0] = AV107defaultHay ;
         new web.getnovedadmesdefault(remoteHandle, context).execute( AV18CliCod, GXv_int16, GXv_int18, GXv_int7, GXv_int19, GXv_boolean11) ;
         novedadconcepto_abm_impl.this.AV19EmpCod = GXv_int16[0] ;
         novedadconcepto_abm_impl.this.AV14LegNumero = GXv_int18[0] ;
         novedadconcepto_abm_impl.this.AV108defaultAnio = GXv_int7[0] ;
         novedadconcepto_abm_impl.this.AV109defaultMesNro = GXv_int19[0] ;
         novedadconcepto_abm_impl.this.AV107defaultHay = GXv_boolean11[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19EmpCod), 4, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14LegNumero), 8, 0));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "default periods 1 &LiqPerAno ", "")+GXutil.trim( GXutil.str( AV24LiqPerAno, 4, 0))+httpContext.getMessage( " &anio ", "")+GXutil.trim( GXutil.str( AV26anio, 4, 0))+httpContext.getMessage( " &LiqPerAno ", "")+GXutil.trim( GXutil.str( AV24LiqPerAno, 4, 0))+httpContext.getMessage( " liqpermes ", "")+GXutil.trim( GXutil.str( AV25LiqPerMes, 2, 0))) ;
         if ( AV107defaultHay )
         {
            AV10PerDesde = localUtil.ymdtod( AV108defaultAnio, AV109defaultMesNro, 1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10PerDesde", localUtil.format(AV10PerDesde, "99/99/99"));
            AV13Hasta = AV10PerDesde ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Hasta", localUtil.format(AV13Hasta, "99/99/99"));
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "default periods 2", "")) ;
            /* Execute user subroutine: 'ARMA FECHAS DESDE COMBOS' */
            S222 ();
            if (returnInSub) return;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "default periods 3 &hay ", "")+GXutil.trim( GXutil.booltostr( AV82hay))) ;
            if ( ! AV82hay )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "default periods 4", "")) ;
               AV10PerDesde = localUtil.ymdtod( GXutil.year( AV29hoy), GXutil.month( AV29hoy), 1) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10PerDesde", localUtil.format(AV10PerDesde, "99/99/99"));
               AV13Hasta = AV10PerDesde ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Hasta", localUtil.format(AV13Hasta, "99/99/99"));
               /* Execute user subroutine: 'ARMA FECHAS DESDE COMBOS' */
               S222 ();
               if (returnInSub) return;
            }
            else
            {
            }
         }
      }
   }

   public void S192( )
   {
      /* 'DEFAULT QUINCENAS' Routine */
      returnInSub = false ;
      GXt_char2 = AV86quincenaTLiqCod ;
      GXt_char1 = AV86quincenaTLiqCod ;
      GXv_char12[0] = GXt_char1 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char12) ;
      novedadconcepto_abm_impl.this.GXt_char1 = GXv_char12[0] ;
      GXv_char4[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char4) ;
      novedadconcepto_abm_impl.this.GXt_char2 = GXv_char4[0] ;
      AV86quincenaTLiqCod = GXt_char2 ;
      GXv_boolean11[0] = AV87primeraTiene ;
      new web.legajotieneliquidacion(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, AV10PerDesde, AV86quincenaTLiqCod, GXv_boolean11) ;
      novedadconcepto_abm_impl.this.AV87primeraTiene = GXv_boolean11[0] ;
      if ( ! AV87primeraTiene )
      {
         AV106quincena = (byte)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV106quincena", GXutil.str( AV106quincena, 1, 0));
      }
      else
      {
         AV106quincena = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV106quincena", GXutil.str( AV106quincena, 1, 0));
      }
   }

   public void S132( )
   {
      /* 'GET LEGAJO CLASE' Routine */
      returnInSub = false ;
      GXv_int20[0] = AV32LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_int20) ;
      novedadconcepto_abm_impl.this.AV32LegClase = GXv_int20[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32LegClase", GXutil.str( AV32LegClase, 1, 0));
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV18CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV19EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV14LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "&LegClase: ", "")+GXutil.trim( GXutil.str( AV32LegClase, 1, 0))) ;
      GXv_char12[0] = AV110LegModTra ;
      new web.getlegajomodtra(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, GXv_char12) ;
      novedadconcepto_abm_impl.this.AV110LegModTra = GXv_char12[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV110LegModTra", AV110LegModTra);
      GXv_char12[0] = AV111tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, 0, AV14LegNumero, (short)(0), "", "", GXv_char12) ;
      novedadconcepto_abm_impl.this.AV111tipo_tarifa = GXv_char12[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV111tipo_tarifa", AV111tipo_tarifa);
   }

   public void S232( )
   {
      /* 'MOSTRAR ERRORES' Routine */
      returnInSub = false ;
      AV31i = (short)(1) ;
      while ( AV31i <= AV34errores.size() )
      {
         new web.alert(remoteHandle, context).execute( "error", (String)AV34errores.elementAt(-1+AV31i)) ;
         AV31i = (short)(AV31i+1) ;
      }
   }

   public void S142( )
   {
      /* 'CONCEPTO POR DEFECTO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "concepto por defecto 1 &concodigo ", "")+AV15ConCodigo+httpContext.getMessage( " &LegClase ", "")+GXutil.trim( GXutil.str( AV32LegClase, 1, 0))+httpContext.getMessage( " &tipo_tarifa ", "")+AV111tipo_tarifa) ;
      if ( (GXutil.strcmp("", AV15ConCodigo)==0) && ( GXutil.strcmp(AV111tipo_tarifa, "H") == 0 ) )
      {
         if ( GXutil.resetTime(AV101ultNovLiqPeriodo).after( GXutil.resetTime( AV100sigLiqLiqPeriodo )) )
         {
            GXt_char2 = AV15ConCodigo ;
            GXt_char1 = AV15ConCodigo ;
            GXv_char12[0] = GXt_char1 ;
            new web.conceptohorasextras50_codigoparam(remoteHandle, context).execute( GXv_char12) ;
            novedadconcepto_abm_impl.this.GXt_char1 = GXv_char12[0] ;
            GXv_char4[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char4) ;
            novedadconcepto_abm_impl.this.GXt_char2 = GXv_char4[0] ;
            AV15ConCodigo = GXt_char2 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConCodigo", AV15ConCodigo);
         }
         else
         {
            GXt_char2 = AV15ConCodigo ;
            GXt_char1 = AV15ConCodigo ;
            GXv_char12[0] = GXt_char1 ;
            new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char12) ;
            novedadconcepto_abm_impl.this.GXt_char1 = GXv_char12[0] ;
            GXv_char4[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char4) ;
            novedadconcepto_abm_impl.this.GXt_char2 = GXv_char4[0] ;
            AV15ConCodigo = GXt_char2 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConCodigo", AV15ConCodigo);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "pone por defecto ", "")+GXutil.trim( AV15ConCodigo)+httpContext.getMessage( " (clicod ", "")+GXutil.trim( GXutil.str( AV18CliCod, 6, 0))) ;
         Combo_concodigo_Selectedvalue_set = AV15ConCodigo ;
         ucCombo_concodigo.sendProperty(context, sPrefix, false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
      }
      else
      {
         if ( (GXutil.strcmp("", AV15ConCodigo)==0) && ( GXutil.strcmp(AV111tipo_tarifa, "P") == 0 ) )
         {
            GXt_char2 = AV15ConCodigo ;
            GXt_char1 = AV15ConCodigo ;
            GXv_char12[0] = GXt_char1 ;
            new web.conceptohorasextras50_codigoparam(remoteHandle, context).execute( GXv_char12) ;
            novedadconcepto_abm_impl.this.GXt_char1 = GXv_char12[0] ;
            GXv_char4[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV18CliCod, GXt_char1, GXv_char4) ;
            novedadconcepto_abm_impl.this.GXt_char2 = GXv_char4[0] ;
            AV15ConCodigo = GXt_char2 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ConCodigo", AV15ConCodigo);
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "pone por defecto ", "")+GXutil.trim( AV15ConCodigo)+httpContext.getMessage( " (clicod ", "")+GXutil.trim( GXutil.str( AV18CliCod, 6, 0))) ;
            Combo_concodigo_Selectedvalue_set = AV15ConCodigo ;
            ucCombo_concodigo.sendProperty(context, sPrefix, false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
         }
      }
   }

   public void S182( )
   {
      /* 'COMBO OPCIONFORVAL' Routine */
      returnInSub = false ;
      cmbavOpcionforval.removeAllItems();
      GXv_char12[0] = AV43ConFormula ;
      new web.getformulaconcepto(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_char12) ;
      novedadconcepto_abm_impl.this.AV43ConFormula = GXv_char12[0] ;
      if ( (GXutil.strcmp("", AV15ConCodigo)==0) || ! (GXutil.strcmp("", AV43ConFormula)==0) )
      {
         cmbavOpcionforval.addItem("1", httpContext.getMessage( "Automático", ""), (short)(0));
      }
      cmbavOpcionforval.addItem("2", httpContext.getMessage( "Valor fijo", ""), (short)(0));
      if ( (GXutil.strcmp("", AV15ConCodigo)==0) )
      {
         AV44OpcionForVal = (byte)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44OpcionForVal", GXutil.str( AV44OpcionForVal, 1, 0));
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV43ConFormula)==0) )
         {
            AV44OpcionForVal = (byte)(1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44OpcionForVal", GXutil.str( AV44OpcionForVal, 1, 0));
         }
         else
         {
            AV44OpcionForVal = (byte)(2) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44OpcionForVal", GXutil.str( AV44OpcionForVal, 1, 0));
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "llama 1", "")) ;
      /* Execute user subroutine: 'OPCIONES FOR VAL' */
      S202 ();
      if (returnInSub) return;
   }

   public void S202( )
   {
      /* 'OPCIONES FOR VAL' Routine */
      returnInSub = false ;
      if ( ( AV40tocoPeriodos ) || ( AV114tocoLegajo ) || ( AV113tocoConcepto ) )
      {
         AV80desdeFecha = AV8AgeFecDes ;
         AV81hastaFecha = AV9AgeFecHas ;
      }
      else
      {
         AV80desdeFecha = AV29hoy ;
         AV81hastaFecha = AV29hoy ;
      }
      lblOpcionforval_righttext_Format = (short)(1) ;
      if ( ! AV103yaModificoImporte )
      {
         AV17AgeImporte = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17AgeImporte", GXutil.ltrimstr( AV17AgeImporte, 14, 2));
      }
      if ( AV44OpcionForVal == 1 )
      {
         edtavAgeimporte_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgeimporte_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgeimporte_Visible), 5, 0), true);
         lblOpcionforval_righttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblOpcionforval_righttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblOpcionforval_righttext_Visible), 5, 0), true);
         if ( ! (GXutil.strcmp("", AV15ConCodigo)==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "concodigo ", "")+AV15ConCodigo+httpContext.getMessage( " &adelVacProxConCodigo ", "")+GXutil.trim( AV75adelVacProxConCodigo)) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeCanti)==0) )
            {
               if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConCodigo)), GXutil.upper( GXutil.trim( AV75adelVacProxConCodigo))) == 0 )
               {
                  AV79LiqDCanti = DecimalUtil.doubleToDec(0) ;
               }
               else
               {
                  AV79LiqDCanti = DecimalUtil.doubleToDec(1) ;
               }
            }
            else
            {
               AV79LiqDCanti = AV16AgeCanti ;
            }
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV15ConCodigo)), GXutil.upper( GXutil.trim( AV75adelVacProxConCodigo))) == 0 )
            {
               AV74auxAgeFecDes = GXutil.addmth( AV80desdeFecha, (short)(1)) ;
               AV76auxAgeFecHas = GXutil.addmth( AV81hastaFecha, (short)(1)) ;
            }
            else
            {
               AV74auxAgeFecDes = AV80desdeFecha ;
               AV76auxAgeFecHas = AV80desdeFecha ;
            }
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "&auxAgeFecDes ", "")+GXutil.trim( localUtil.dtoc( AV74auxAgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " tocoperiodo ", "")+GXutil.trim( GXutil.booltostr( AV40tocoPeriodos))+httpContext.getMessage( " desdefecha ", "")+GXutil.trim( localUtil.dtoc( AV80desdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " hastafecha ", "")+GXutil.trim( localUtil.dtoc( AV81hastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            GXv_decimal14[0] = AV77defaultAgeCanti ;
            GXv_char12[0] = "" ;
            GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char4[0] = AV78LiqDLog ;
            new web.previsualizacionnovedad(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, AV15ConCodigo, AV79LiqDCanti, AV17AgeImporte, AV74auxAgeFecDes, AV76auxAgeFecHas, false, GXv_decimal14, GXv_char12, GXv_decimal13, GXv_char4) ;
            novedadconcepto_abm_impl.this.AV77defaultAgeCanti = GXv_decimal14[0] ;
            novedadconcepto_abm_impl.this.AV78LiqDLog = GXv_char4[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "!&defaultAgeCanti ", "")+GXutil.trim( GXutil.str( AV77defaultAgeCanti, 9, 2))+httpContext.getMessage( " &horasNormalesConCodigo ", "")+AV83horasNormalesConCodigo+httpContext.getMessage( " &ConCodigo ", "")+AV15ConCodigo) ;
            if ( GXutil.strcmp(AV15ConCodigo, AV83horasNormalesConCodigo) == 0 )
            {
               /* Execute user subroutine: 'CANTI INICIAL HORAS NORMALES' */
               S242 ();
               if (returnInSub) return;
            }
            else
            {
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeCanti)==0) )
               {
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77defaultAgeCanti)==0) )
                  {
                     /* Execute user subroutine: 'CANTI INICIAL' */
                     S252 ();
                     if (returnInSub) return;
                  }
                  else
                  {
                     AV16AgeCanti = AV77defaultAgeCanti ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "agecanti ", "")+GXutil.trim( GXutil.str( AV16AgeCanti, 9, 2))+httpContext.getMessage( " (sub opciones for val ..def)", "")) ;
                  }
               }
            }
            GXt_char2 = AV104errPrinPalabra ;
            GXv_char12[0] = GXt_char2 ;
            new web.getcoderrprin(remoteHandle, context).execute( GXv_char12) ;
            novedadconcepto_abm_impl.this.GXt_char2 = GXv_char12[0] ;
            AV104errPrinPalabra = GXt_char2 ;
            AV78LiqDLog = GXutil.strReplace( AV78LiqDLog, AV104errPrinPalabra, "") ;
            lblOpcionforval_righttext_Caption = AV78LiqDLog ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblOpcionforval_righttext_Internalname, "Caption", lblOpcionforval_righttext_Caption, true);
         }
         else
         {
            lblOpcionforval_righttext_Caption = "" ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, lblOpcionforval_righttext_Internalname, "Caption", lblOpcionforval_righttext_Caption, true);
         }
      }
      else
      {
         edtavAgeimporte_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAgeimporte_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAgeimporte_Visible), 5, 0), true);
         lblOpcionforval_righttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblOpcionforval_righttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblOpcionforval_righttext_Visible), 5, 0), true);
         /* Execute user subroutine: 'CANTI INICIAL' */
         S252 ();
         if (returnInSub) return;
      }
   }

   public void S212( )
   {
      /* 'VISIBILIDAD DIA' Routine */
      returnInSub = false ;
      AV58dia = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58dia), 2, 0));
      if ( ( AV7Metodo == 2 ) && GXutil.dateCompare(GXutil.resetTime(AV10PerDesde), GXutil.resetTime(AV13Hasta)) && ! ( ( AV32LegClase == 2 ) && (0==AV106quincena) ) && ! ( ( AV32LegClase == 2 ) && ( AV106quincena == 3 ) ) )
      {
         cmbavDia.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
         cmbavDia.removeAllItems();
         cmbavDia.addItem("0", httpContext.getMessage( "Seleccionar", ""), (short)(0));
         if ( ! (0==AV106quincena) )
         {
            if ( AV106quincena == 1 )
            {
               GXv_date17[0] = AV59auxDesdeFecha ;
               GXv_date21[0] = AV60auxHastaFecha ;
               new web.getperiodoquincena(remoteHandle, context).execute( AV18CliCod, (short)(1), AV10PerDesde, GXv_date17, GXv_date21) ;
               novedadconcepto_abm_impl.this.AV59auxDesdeFecha = GXv_date17[0] ;
               novedadconcepto_abm_impl.this.AV60auxHastaFecha = GXv_date21[0] ;
            }
            else
            {
               GXv_date21[0] = AV59auxDesdeFecha ;
               GXv_date17[0] = AV60auxHastaFecha ;
               new web.getperiodoquincena(remoteHandle, context).execute( AV18CliCod, (short)(2), AV10PerDesde, GXv_date21, GXv_date17) ;
               novedadconcepto_abm_impl.this.AV59auxDesdeFecha = GXv_date21[0] ;
               novedadconcepto_abm_impl.this.AV60auxHastaFecha = GXv_date17[0] ;
            }
         }
         else
         {
            AV59auxDesdeFecha = AV10PerDesde ;
            AV60auxHastaFecha = GXutil.eomdate( AV10PerDesde) ;
         }
         AV31i = (short)(GXutil.day( AV59auxDesdeFecha)) ;
         while ( AV31i <= GXutil.day( AV60auxHastaFecha) )
         {
            AV70diaDate = localUtil.ymdtod( GXutil.year( AV59auxDesdeFecha), GXutil.month( AV59auxDesdeFecha), AV31i) ;
            AV69diaPalabra = GXutil.trim( localUtil.cdow( AV70diaDate, httpContext.getLanguage( ))) + " " + GXutil.trim( GXutil.str( AV31i, 4, 0)) ;
            GXt_int9 = AV71PaiCod ;
            GXv_int19[0] = GXt_int9 ;
            new web.empresagetpais(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, GXv_int19) ;
            novedadconcepto_abm_impl.this.GXt_int9 = GXv_int19[0] ;
            AV71PaiCod = GXt_int9 ;
            GXt_boolean10 = AV72feriadoEs ;
            GXv_boolean11[0] = GXt_boolean10 ;
            new web.diaesferiado(remoteHandle, context).execute( AV71PaiCod, AV70diaDate, GXv_boolean11) ;
            novedadconcepto_abm_impl.this.GXt_boolean10 = GXv_boolean11[0] ;
            AV72feriadoEs = GXt_boolean10 ;
            if ( AV72feriadoEs )
            {
               AV69diaPalabra += httpContext.getMessage( " (feriado)", "") ;
            }
            cmbavDia.addItem(GXutil.trim( GXutil.str( AV31i, 2, 0)), AV69diaPalabra, (short)(0));
            AV31i = (short)(AV31i+1) ;
         }
      }
      else
      {
         cmbavDia.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
      }
      if ( AV7Metodo == 2 )
      {
         if ( (0==AV106quincena) || ( AV106quincena == 3 ) )
         {
            cmbavPerdesde.setCaption( httpContext.getMessage( "Desde", "") );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Caption", cmbavPerdesde.getCaption(), true);
            cmbavHasta.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Visible", GXutil.ltrimstr( cmbavHasta.getVisible(), 5, 0), true);
         }
         else
         {
            cmbavPerdesde.setCaption( httpContext.getMessage( "Mes", "") );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Caption", cmbavPerdesde.getCaption(), true);
            cmbavHasta.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Visible", GXutil.ltrimstr( cmbavHasta.getVisible(), 5, 0), true);
         }
      }
   }

   public void S252( )
   {
      /* 'CANTI INICIAL' Routine */
      returnInSub = false ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16AgeCanti)==0) )
      {
         GXv_objcol_int8[0] = AV35rangoNumeros ;
         new web.getrangoconcepto(remoteHandle, context).execute( AV18CliCod, AV15ConCodigo, GXv_objcol_int8) ;
         AV35rangoNumeros = GXv_objcol_int8[0] ;
         if ( AV35rangoNumeros.size() == 0 )
         {
            AV16AgeCanti = DecimalUtil.doubleToDec(1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "agecanti ", "")+GXutil.trim( GXutil.str( AV16AgeCanti, 9, 2))+httpContext.getMessage( " (sub canti inicial a", "")) ;
         }
         else
         {
            AV16AgeCanti = DecimalUtil.doubleToDec(((Number) AV35rangoNumeros.elementAt(-1+1)).shortValue()) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "agecanti ", "")+GXutil.trim( GXutil.str( AV16AgeCanti, 9, 2))+httpContext.getMessage( " (sub canti inicial b", "")) ;
         }
      }
   }

   public void S242( )
   {
      /* 'CANTI INICIAL HORAS NORMALES' Routine */
      returnInSub = false ;
      if ( ! AV102yaModificoCantidad )
      {
         if ( ! (0==AV106quincena) )
         {
            if ( AV106quincena == 1 )
            {
               AV85quincenaNro = (short)(1) ;
            }
            else
            {
               AV85quincenaNro = (short)(2) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV117Pgmname, httpContext.getMessage( "manda afefecdes ", "")+GXutil.trim( localUtil.dtoc( AV8AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            GXv_decimal14[0] = AV16AgeCanti ;
            new web.horasdefaultquincena(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV14LegNumero, AV8AgeFecDes, AV85quincenaNro, GXv_decimal14) ;
            novedadconcepto_abm_impl.this.AV16AgeCanti = GXv_decimal14[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AgeCanti", GXutil.ltrimstr( AV16AgeCanti, 9, 2));
            new web.msgdebug_prod2(remoteHandle, context).execute( AV18CliCod, AV117Pgmname, httpContext.getMessage( "agecanti ", "")+GXutil.trim( GXutil.str( AV16AgeCanti, 9, 2))+httpContext.getMessage( " sub canti inicial horas normales", "")) ;
         }
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e22BK2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_BK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
         ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
         ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
         ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
         ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
         ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
         ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
         ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
         ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
         ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, sPrefix+"DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legnumero_Internalname, httpContext.getMessage( "Legajo", ""), "", "", lblTextblockcombo_legnumero_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
         ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
         ucCombo_legnumero.setProperty("EmptyItem", Combo_legnumero_Emptyitem);
         ucCombo_legnumero.setProperty("DropDownOptionsData", AV21LegNumero_Data);
         ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, sPrefix+"COMBO_LEGNUMEROContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedconcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_concodigo_Internalname, httpContext.getMessage( "Concepto", ""), "", "", lblTextblockcombo_concodigo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_concodigo.setProperty("Caption", Combo_concodigo_Caption);
         ucCombo_concodigo.setProperty("Cls", Combo_concodigo_Cls);
         ucCombo_concodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV46DDO_TitleSettingsIcons);
         ucCombo_concodigo.setProperty("DropDownOptionsData", AV23ConCodigo_Data);
         ucCombo_concodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_concodigo_Internalname, sPrefix+"COMBO_CONCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavAgecanti_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAgecanti_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAgecanti_Internalname, httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAgecanti_Internalname, GXutil.ltrim( localUtil.ntoc( AV16AgeCanti, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV16AgeCanti, "ZZZZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAgecanti_Jsonclick, 0, "Attribute", "", "", "", "", edtavAgecanti_Visible, edtavAgecanti_Enabled, 1, "text", "", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell MB15", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedopcionforval_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockopcionforval_Internalname, httpContext.getMessage( "Valor", ""), "", "", lblTextblockopcionforval_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         wb_table2_46_BK2( true) ;
      }
      else
      {
         wb_table2_46_BK2( false) ;
      }
      return  ;
   }

   public void wb_table2_46_BK2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavAgeimporte_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAgeimporte_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAgeimporte_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAgeimporte_Internalname, GXutil.ltrim( localUtil.ntoc( AV17AgeImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavAgeimporte_Enabled!=0) ? localUtil.format( AV17AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV17AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,57);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAgeimporte_Jsonclick, 0, "Attribute", "", "", "", "", edtavAgeimporte_Visible, edtavAgeimporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_pertbl.setProperty("Width", Dvpanel_pertbl_Width);
         ucDvpanel_pertbl.setProperty("AutoWidth", Dvpanel_pertbl_Autowidth);
         ucDvpanel_pertbl.setProperty("AutoHeight", Dvpanel_pertbl_Autoheight);
         ucDvpanel_pertbl.setProperty("Cls", Dvpanel_pertbl_Cls);
         ucDvpanel_pertbl.setProperty("Title", Dvpanel_pertbl_Title);
         ucDvpanel_pertbl.setProperty("Collapsible", Dvpanel_pertbl_Collapsible);
         ucDvpanel_pertbl.setProperty("Collapsed", Dvpanel_pertbl_Collapsed);
         ucDvpanel_pertbl.setProperty("ShowCollapseIcon", Dvpanel_pertbl_Showcollapseicon);
         ucDvpanel_pertbl.setProperty("IconPosition", Dvpanel_pertbl_Iconposition);
         ucDvpanel_pertbl.setProperty("AutoScroll", Dvpanel_pertbl_Autoscroll);
         ucDvpanel_pertbl.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_pertbl_Internalname, sPrefix+"DVPANEL_PERTBLContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_PERTBLContainer"+"PerTbl"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPertbl_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+radavMetodo.getInternalname()+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Radio button */
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_radio_ctrl( httpContext, radavMetodo, radavMetodo.getInternalname(), GXutil.str( AV7Metodo, 1, 0), "", 1, 1, 0, 0, StyleString, ClassString, "", "", 0, radavMetodo.getJsonclick(), "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavAgefecdes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAgefecdes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAgefecdes_Internalname, httpContext.getMessage( "Desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavAgefecdes_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAgefecdes_Internalname, localUtil.format(AV8AgeFecDes, "99/99/9999"), localUtil.format( AV8AgeFecDes, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,72);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAgefecdes_Jsonclick, 0, "AttributeDate", "", "", "", "", edtavAgefecdes_Visible, edtavAgefecdes_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavAgefecdes_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavAgefecdes_Visible==0)||(edtavAgefecdes_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_NovedadConcepto_ABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavAgefechas_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAgefechas_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAgefechas_Internalname, httpContext.getMessage( "Hasta", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavAgefechas_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAgefechas_Internalname, localUtil.format(AV9AgeFecHas, "99/99/9999"), localUtil.format( AV9AgeFecHas, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,77);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAgefechas_Jsonclick, 0, "AttributeDate", "", "", "", "", edtavAgefechas_Visible, edtavAgefechas_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavAgefechas_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavAgefechas_Visible==0)||(edtavAgefechas_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_NovedadConcepto_ABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavPerdesde.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPerdesde.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavPerdesde.getInternalname(), cmbavPerdesde.getCaption(), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPerdesde, cmbavPerdesde.getInternalname(), localUtil.dtoc( AV10PerDesde, 0, "/"), 1, cmbavPerdesde.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVPERDESDE.CLICK."+"'", "date", "", cmbavPerdesde.getVisible(), cmbavPerdesde.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "", true, (byte)(0), "HLP_NovedadConcepto_ABM.htm");
         cmbavPerdesde.setValue( localUtil.dtoc( AV10PerDesde, 0, "/") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPerdesde.getInternalname(), "Values", cmbavPerdesde.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavHasta.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavHasta.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavHasta.getInternalname(), httpContext.getMessage( "Hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavHasta, cmbavHasta.getInternalname(), localUtil.dtoc( AV13Hasta, 0, "/"), 1, cmbavHasta.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVHASTA.CLICK."+"'", "date", "", cmbavHasta.getVisible(), cmbavHasta.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "", true, (byte)(0), "HLP_NovedadConcepto_ABM.htm");
         cmbavHasta.setValue( localUtil.dtoc( AV13Hasta, 0, "/") );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavHasta.getInternalname(), "Values", cmbavHasta.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavQuincena.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavQuincena.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavQuincena.getInternalname(), httpContext.getMessage( "Quincena", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavQuincena, cmbavQuincena.getInternalname(), GXutil.trim( GXutil.str( AV106quincena, 1, 0)), 1, cmbavQuincena.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavQuincena.getVisible(), cmbavQuincena.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "", true, (byte)(0), "HLP_NovedadConcepto_ABM.htm");
         cmbavQuincena.setValue( GXutil.trim( GXutil.str( AV106quincena, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavQuincena.getInternalname(), "Values", cmbavQuincena.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavDia.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDia.getInternalname(), httpContext.getMessage( "Día", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDia, cmbavDia.getInternalname(), GXutil.trim( GXutil.str( AV58dia, 2, 0)), 1, cmbavDia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavDia.getVisible(), cmbavDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,97);\"", "", true, (byte)(0), "HLP_NovedadConcepto_ABM.htm");
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV58dia, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_NovedadConcepto_ABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_BK2e( true) ;
      }
      else
      {
         wb_table1_9_BK2e( false) ;
      }
   }

   public void wb_table2_46_BK2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemergedopcionforval_Internalname, tblTablemergedopcionforval_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavOpcionforval.getInternalname(), httpContext.getMessage( "Opcion For Val", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOpcionforval, cmbavOpcionforval.getInternalname(), GXutil.trim( GXutil.str( AV44OpcionForVal, 1, 0)), 1, cmbavOpcionforval.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVOPCIONFORVAL.CLICK."+"'", "int", "", 1, cmbavOpcionforval.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "", true, (byte)(0), "HLP_NovedadConcepto_ABM.htm");
         cmbavOpcionforval.setValue( GXutil.trim( GXutil.str( AV44OpcionForVal, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOpcionforval.getInternalname(), "Values", cmbavOpcionforval.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblOpcionforval_righttext_Internalname, lblOpcionforval_righttext_Caption, "", "", lblOpcionforval_righttext_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", lblOpcionforval_righttext_Visible, 1, 0, lblOpcionforval_righttext_Format, "HLP_NovedadConcepto_ABM.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_46_BK2e( true) ;
      }
      else
      {
         wb_table2_46_BK2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV27TrnMode = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TrnMode", AV27TrnMode);
      AV18CliCod = ((Number) GXutil.testNumericType( getParm(obj,1,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
      AV19EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19EmpCod), 4, 0));
      AV33parmLegNumero = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33parmLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33parmLegNumero), 8, 0));
      AV20AgeOrden = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20AgeOrden), 4, 0));
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
      paBK2( ) ;
      wsBK2( ) ;
      weBK2( ) ;
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
      sCtrlAV27TrnMode = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV18CliCod = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV19EmpCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV33parmLegNumero = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlAV20AgeOrden = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paBK2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "novedadconcepto_abm", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paBK2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV27TrnMode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TrnMode", AV27TrnMode);
         AV18CliCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
         AV19EmpCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19EmpCod), 4, 0));
         AV33parmLegNumero = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33parmLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33parmLegNumero), 8, 0));
         AV20AgeOrden = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20AgeOrden), 4, 0));
      }
      wcpOAV27TrnMode = httpContext.cgiGet( sPrefix+"wcpOAV27TrnMode") ;
      wcpOAV18CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV18CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV19EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV19EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV33parmLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV33parmLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV20AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV20AgeOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV27TrnMode, wcpOAV27TrnMode) != 0 ) || ( AV18CliCod != wcpOAV18CliCod ) || ( AV19EmpCod != wcpOAV19EmpCod ) || ( AV33parmLegNumero != wcpOAV33parmLegNumero ) || ( AV20AgeOrden != wcpOAV20AgeOrden ) ) )
      {
         setjustcreated();
      }
      wcpOAV27TrnMode = AV27TrnMode ;
      wcpOAV18CliCod = AV18CliCod ;
      wcpOAV19EmpCod = AV19EmpCod ;
      wcpOAV33parmLegNumero = AV33parmLegNumero ;
      wcpOAV20AgeOrden = AV20AgeOrden ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV27TrnMode = httpContext.cgiGet( sPrefix+"AV27TrnMode_CTRL") ;
      if ( GXutil.len( sCtrlAV27TrnMode) > 0 )
      {
         AV27TrnMode = httpContext.cgiGet( sCtrlAV27TrnMode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27TrnMode", AV27TrnMode);
      }
      else
      {
         AV27TrnMode = httpContext.cgiGet( sPrefix+"AV27TrnMode_PARM") ;
      }
      sCtrlAV18CliCod = httpContext.cgiGet( sPrefix+"AV18CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV18CliCod) > 0 )
      {
         AV18CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV18CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18CliCod), 6, 0));
      }
      else
      {
         AV18CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV18CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV19EmpCod = httpContext.cgiGet( sPrefix+"AV19EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV19EmpCod) > 0 )
      {
         AV19EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV19EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19EmpCod), 4, 0));
      }
      else
      {
         AV19EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV19EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV33parmLegNumero = httpContext.cgiGet( sPrefix+"AV33parmLegNumero_CTRL") ;
      if ( GXutil.len( sCtrlAV33parmLegNumero) > 0 )
      {
         AV33parmLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV33parmLegNumero), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33parmLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33parmLegNumero), 8, 0));
      }
      else
      {
         AV33parmLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV33parmLegNumero_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV20AgeOrden = httpContext.cgiGet( sPrefix+"AV20AgeOrden_CTRL") ;
      if ( GXutil.len( sCtrlAV20AgeOrden) > 0 )
      {
         AV20AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV20AgeOrden), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20AgeOrden), 4, 0));
      }
      else
      {
         AV20AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV20AgeOrden_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      paBK2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsBK2( ) ;
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
      wsBK2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV27TrnMode_PARM", GXutil.rtrim( AV27TrnMode));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV27TrnMode)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV27TrnMode_CTRL", GXutil.rtrim( sCtrlAV27TrnMode));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV18CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV18CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18CliCod_CTRL", GXutil.rtrim( sCtrlAV18CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV19EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV19EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV19EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV19EmpCod_CTRL", GXutil.rtrim( sCtrlAV19EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV33parmLegNumero_PARM", GXutil.ltrim( localUtil.ntoc( AV33parmLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV33parmLegNumero)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV33parmLegNumero_CTRL", GXutil.rtrim( sCtrlAV33parmLegNumero));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV20AgeOrden_PARM", GXutil.ltrim( localUtil.ntoc( AV20AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV20AgeOrden)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV20AgeOrden_CTRL", GXutil.rtrim( sCtrlAV20AgeOrden));
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
      weBK2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251810315168", true, true);
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
      httpContext.AddJavascriptSource("novedadconcepto_abm.js", "?20251810315169", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockcombo_legnumero_Internalname = sPrefix+"TEXTBLOCKCOMBO_LEGNUMERO" ;
      Combo_legnumero_Internalname = sPrefix+"COMBO_LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = sPrefix+"TABLESPLITTEDLEGNUMERO" ;
      lblTextblockcombo_concodigo_Internalname = sPrefix+"TEXTBLOCKCOMBO_CONCODIGO" ;
      Combo_concodigo_Internalname = sPrefix+"COMBO_CONCODIGO" ;
      divTablesplittedconcodigo_Internalname = sPrefix+"TABLESPLITTEDCONCODIGO" ;
      edtavAgecanti_Internalname = sPrefix+"vAGECANTI" ;
      lblTextblockopcionforval_Internalname = sPrefix+"TEXTBLOCKOPCIONFORVAL" ;
      cmbavOpcionforval.setInternalname( sPrefix+"vOPCIONFORVAL" );
      lblOpcionforval_righttext_Internalname = sPrefix+"OPCIONFORVAL_RIGHTTEXT" ;
      tblTablemergedopcionforval_Internalname = sPrefix+"TABLEMERGEDOPCIONFORVAL" ;
      divTablesplittedopcionforval_Internalname = sPrefix+"TABLESPLITTEDOPCIONFORVAL" ;
      edtavAgeimporte_Internalname = sPrefix+"vAGEIMPORTE" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      radavMetodo.setInternalname( sPrefix+"vMETODO" );
      edtavAgefecdes_Internalname = sPrefix+"vAGEFECDES" ;
      edtavAgefechas_Internalname = sPrefix+"vAGEFECHAS" ;
      cmbavPerdesde.setInternalname( sPrefix+"vPERDESDE" );
      cmbavHasta.setInternalname( sPrefix+"vHASTA" );
      cmbavQuincena.setInternalname( sPrefix+"vQUINCENA" );
      cmbavDia.setInternalname( sPrefix+"vDIA" );
      divPertbl_Internalname = sPrefix+"PERTBL" ;
      Dvpanel_pertbl_Internalname = sPrefix+"DVPANEL_PERTBL" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtncancel_Internalname = sPrefix+"BTNCANCEL" ;
      tblTablemainfix_Internalname = sPrefix+"TABLEMAINFIX" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      edtavLegnumero_Internalname = sPrefix+"vLEGNUMERO" ;
      edtavConcodigo_Internalname = sPrefix+"vCONCODIGO" ;
      edtavConceptofiltro_Internalname = sPrefix+"vCONCEPTOFILTRO" ;
      edtavClicod_Internalname = sPrefix+"vCLICOD" ;
      edtavEmpcod_Internalname = sPrefix+"vEMPCOD" ;
      edtavAgeorden_Internalname = sPrefix+"vAGEORDEN" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      lblOpcionforval_righttext_Format = (short)(0) ;
      lblOpcionforval_righttext_Visible = 1 ;
      cmbavOpcionforval.setJsonclick( "" );
      cmbavOpcionforval.setEnabled( 1 );
      cmbavDia.setJsonclick( "" );
      cmbavDia.setEnabled( 1 );
      cmbavQuincena.setJsonclick( "" );
      cmbavQuincena.setEnabled( 1 );
      cmbavHasta.setJsonclick( "" );
      cmbavHasta.setEnabled( 1 );
      cmbavPerdesde.setJsonclick( "" );
      cmbavPerdesde.setEnabled( 1 );
      edtavAgefechas_Jsonclick = "" ;
      edtavAgefechas_Enabled = 1 ;
      edtavAgefecdes_Jsonclick = "" ;
      edtavAgefecdes_Enabled = 1 ;
      radavMetodo.setJsonclick( "" );
      edtavAgeimporte_Jsonclick = "" ;
      edtavAgeimporte_Enabled = 1 ;
      edtavAgecanti_Jsonclick = "" ;
      Combo_concodigo_Caption = "" ;
      cmbavPerdesde.setCaption( httpContext.getMessage( "Desde", "") );
      lblOpcionforval_righttext_Caption = httpContext.getMessage( "Texto derecha", "") ;
      edtavAgeimporte_Visible = 1 ;
      edtavAgecanti_Enabled = 1 ;
      edtavAgecanti_Visible = 1 ;
      cmbavDia.setVisible( 1 );
      cmbavHasta.setVisible( 1 );
      cmbavQuincena.setVisible( 1 );
      cmbavPerdesde.setVisible( 1 );
      edtavAgefechas_Visible = 1 ;
      edtavAgefecdes_Visible = 1 ;
      edtavAgeorden_Jsonclick = "" ;
      edtavAgeorden_Visible = 1 ;
      edtavEmpcod_Jsonclick = "" ;
      edtavEmpcod_Visible = 1 ;
      edtavClicod_Jsonclick = "" ;
      edtavClicod_Visible = 1 ;
      edtavConceptofiltro_Jsonclick = "" ;
      edtavConceptofiltro_Visible = 1 ;
      edtavConcodigo_Jsonclick = "" ;
      edtavConcodigo_Visible = 1 ;
      edtavLegnumero_Jsonclick = "" ;
      edtavLegnumero_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_pertbl_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_pertbl_Iconposition = "Right" ;
      Dvpanel_pertbl_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_pertbl_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_pertbl_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_pertbl_Title = httpContext.getMessage( "Seleccionar periodo", "") ;
      Dvpanel_pertbl_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_pertbl_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_pertbl_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_pertbl_Width = "100%" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Combo_concodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legnumero_Visible = GXutil.toBoolean( -1) ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
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
      cmbavOpcionforval.setName( "vOPCIONFORVAL" );
      cmbavOpcionforval.setWebtags( "" );
      if ( cmbavOpcionforval.getItemCount() > 0 )
      {
      }
      radavMetodo.setName( "vMETODO" );
      radavMetodo.setWebtags( "" );
      radavMetodo.addItem("2", httpContext.getMessage( "Agil", ""), (short)(0));
      radavMetodo.addItem("1", httpContext.getMessage( "Fechas", ""), (short)(0));
      cmbavPerdesde.setName( "vPERDESDE" );
      cmbavPerdesde.setWebtags( "" );
      if ( cmbavPerdesde.getItemCount() > 0 )
      {
      }
      cmbavHasta.setName( "vHASTA" );
      cmbavHasta.setWebtags( "" );
      if ( cmbavHasta.getItemCount() > 0 )
      {
      }
      cmbavQuincena.setName( "vQUINCENA" );
      cmbavQuincena.setWebtags( "" );
      cmbavQuincena.addItem("1", httpContext.getMessage( "Primera", ""), (short)(0));
      cmbavQuincena.addItem("2", httpContext.getMessage( "Segunda", ""), (short)(0));
      cmbavQuincena.addItem("3", httpContext.getMessage( "Ambas", ""), (short)(0));
      if ( cmbavQuincena.getItemCount() > 0 )
      {
      }
      cmbavDia.setName( "vDIA" );
      cmbavDia.setWebtags( "" );
      if ( cmbavDia.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'AV26anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV24LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9',hsh:true},{av:'AV25LiqPerMes',fld:'vLIQPERMES',pic:'Z9',hsh:true},{av:'AV42vacacionesSubTipoConCod1',fld:'vVACACIONESSUBTIPOCONCOD1',pic:'',hsh:true},{av:'AV101ultNovLiqPeriodo',fld:'vULTNOVLIQPERIODO',pic:'',hsh:true},{av:'AV100sigLiqLiqPeriodo',fld:'vSIGLIQLIQPERIODO',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("COMBO_CONCODIGO.ONOPTIONCLICKED","{handler:'e12BK2',iparms:[{av:'Combo_concodigo_Selectedvalue_get',ctrl:'COMBO_CONCODIGO',prop:'SelectedValue_get'},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'AV103yaModificoImporte',fld:'vYAMODIFICOIMPORTE',pic:''},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''}]");
      setEventMetadata("COMBO_CONCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'cmbavDia'},{av:'edtavAgefecdes_Visible',ctrl:'vAGEFECDES',prop:'Visible'},{av:'edtavAgefechas_Visible',ctrl:'vAGEFECHAS',prop:'Visible'},{av:'cmbavPerdesde'},{av:'cmbavQuincena'},{av:'cmbavHasta'},{av:'edtavAgecanti_Visible',ctrl:'vAGECANTI',prop:'Visible'},{av:'edtavAgecanti_Enabled',ctrl:'vAGECANTI',prop:'Enabled'},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV58dia',fld:'vDIA',pic:'Z9'},{av:'lblOpcionforval_righttext_Format',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Format'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'lblOpcionforval_righttext_Caption',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Caption'},{av:'edtavAgeimporte_Visible',ctrl:'vAGEIMPORTE',prop:'Visible'},{av:'lblOpcionforval_righttext_Visible',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Visible'}]}");
      setEventMetadata("COMBO_LEGNUMERO.ONOPTIONCLICKED","{handler:'e11BK2',iparms:[{av:'Combo_legnumero_Selectedvalue_get',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_get'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV26anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV24LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9',hsh:true},{av:'AV25LiqPerMes',fld:'vLIQPERMES',pic:'Z9',hsh:true},{av:'AV82hay',fld:'vHAY',pic:''},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'AV42vacacionesSubTipoConCod1',fld:'vVACACIONESSUBTIPOCONCOD1',pic:'',hsh:true},{av:'A953ConCondicion',fld:'CONCONDICION',pic:''},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A162ConVigencia',fld:'CONVIGENCIA',pic:'9'},{av:'A1826ConPueNov',fld:'CONPUENOV',pic:''},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A1645ConceptoConveCodigo',fld:'CONCEPTOCONVECODIGO',pic:''},{av:'AV57ConceptoFiltro',fld:'vCONCEPTOFILTRO',pic:'9'},{av:'A1644ConceptoPais',fld:'CONCEPTOPAIS',pic:'ZZZ9'},{av:'AV47LegPaiCod',fld:'vLEGPAICOD',pic:'ZZZ9'},{av:'AV111tipo_tarifa',fld:'vTIPO_TARIFA',pic:''},{av:'AV48LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV101ultNovLiqPeriodo',fld:'vULTNOVLIQPERIODO',pic:'',hsh:true},{av:'AV100sigLiqLiqPeriodo',fld:'vSIGLIQLIQPERIODO',pic:'',hsh:true},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV103yaModificoImporte',fld:'vYAMODIFICOIMPORTE',pic:''},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''}]");
      setEventMetadata("COMBO_LEGNUMERO.ONOPTIONCLICKED",",oparms:[{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV47LegPaiCod',fld:'vLEGPAICOD',pic:'ZZZ9'},{av:'AV48LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'AV110LegModTra',fld:'vLEGMODTRA',pic:''},{av:'AV111tipo_tarifa',fld:'vTIPO_TARIFA',pic:''},{av:'AV82hay',fld:'vHAY',pic:''},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavDia'},{av:'edtavAgefecdes_Visible',ctrl:'vAGEFECDES',prop:'Visible'},{av:'edtavAgefechas_Visible',ctrl:'vAGEFECHAS',prop:'Visible'},{av:'edtavAgecanti_Visible',ctrl:'vAGECANTI',prop:'Visible'},{av:'edtavAgecanti_Enabled',ctrl:'vAGECANTI',prop:'Enabled'},{av:'AV23ConCodigo_Data',fld:'vCONCODIGO_DATA',pic:''},{av:'Combo_concodigo_Selectedvalue_set',ctrl:'COMBO_CONCODIGO',prop:'SelectedValue_set'},{av:'lblOpcionforval_righttext_Format',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Format'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'lblOpcionforval_righttext_Caption',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Caption'},{av:'edtavAgeimporte_Visible',ctrl:'vAGEIMPORTE',prop:'Visible'},{av:'lblOpcionforval_righttext_Visible',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Visible'},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV58dia',fld:'vDIA',pic:'Z9'}]}");
      setEventMetadata("VQUINCENA.CONTROLVALUECHANGED","{handler:'e14BK2',iparms:[{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VQUINCENA.CONTROLVALUECHANGED",",oparms:[{av:'cmbavDia'},{av:'AV58dia',fld:'vDIA',pic:'Z9'},{av:'cmbavPerdesde'},{av:'cmbavHasta'}]}");
      setEventMetadata("VCONCEPTOFILTRO.CLICK","{handler:'e15BK2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A38SubTipoConCod1',fld:'SUBTIPOCONCOD1',pic:''},{av:'AV42vacacionesSubTipoConCod1',fld:'vVACACIONESSUBTIPOCONCOD1',pic:'',hsh:true},{av:'A953ConCondicion',fld:'CONCONDICION',pic:''},{av:'A37TipoConCod',fld:'TIPOCONCOD',pic:''},{av:'A162ConVigencia',fld:'CONVIGENCIA',pic:'9'},{av:'A1826ConPueNov',fld:'CONPUENOV',pic:''},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A1645ConceptoConveCodigo',fld:'CONCEPTOCONVECODIGO',pic:''},{av:'AV57ConceptoFiltro',fld:'vCONCEPTOFILTRO',pic:'9'},{av:'A1644ConceptoPais',fld:'CONCEPTOPAIS',pic:'ZZZ9'},{av:'AV47LegPaiCod',fld:'vLEGPAICOD',pic:'ZZZ9'},{av:'AV111tipo_tarifa',fld:'vTIPO_TARIFA',pic:''},{av:'AV48LegConveCodigo',fld:'vLEGCONVECODIGO',pic:''},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''}]");
      setEventMetadata("VCONCEPTOFILTRO.CLICK",",oparms:[{av:'AV23ConCodigo_Data',fld:'vCONCODIGO_DATA',pic:''},{av:'Combo_concodigo_Selectedvalue_set',ctrl:'COMBO_CONCODIGO',prop:'SelectedValue_set'}]}");
      setEventMetadata("VOPCIONFORVAL.CLICK","{handler:'e16BK2',iparms:[{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'AV103yaModificoImporte',fld:'vYAMODIFICOIMPORTE',pic:''},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'}]");
      setEventMetadata("VOPCIONFORVAL.CLICK",",oparms:[{av:'lblOpcionforval_righttext_Format',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Format'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'lblOpcionforval_righttext_Caption',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Caption'},{av:'edtavAgeimporte_Visible',ctrl:'vAGEIMPORTE',prop:'Visible'},{av:'lblOpcionforval_righttext_Visible',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Visible'}]}");
      setEventMetadata("VMETODO.CONTROLVALUECHANGED","{handler:'e17BK2',iparms:[{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VMETODO.CONTROLVALUECHANGED",",oparms:[{av:'cmbavDia'},{av:'edtavAgefecdes_Visible',ctrl:'vAGEFECDES',prop:'Visible'},{av:'edtavAgefechas_Visible',ctrl:'vAGEFECHAS',prop:'Visible'},{av:'cmbavPerdesde'},{av:'cmbavQuincena'},{av:'cmbavHasta'},{av:'edtavAgecanti_Visible',ctrl:'vAGECANTI',prop:'Visible'},{av:'edtavAgecanti_Enabled',ctrl:'vAGECANTI',prop:'Enabled'},{av:'AV58dia',fld:'vDIA',pic:'Z9'}]}");
      setEventMetadata("VPERDESDE.CLICK","{handler:'e18BK2',iparms:[{av:'AV41tocoHasta',fld:'vTOCOHASTA',pic:''},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'AV103yaModificoImporte',fld:'vYAMODIFICOIMPORTE',pic:''},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''}]");
      setEventMetadata("VPERDESDE.CLICK",",oparms:[{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'lblOpcionforval_righttext_Format',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Format'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'lblOpcionforval_righttext_Caption',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Caption'},{av:'edtavAgeimporte_Visible',ctrl:'vAGEIMPORTE',prop:'Visible'},{av:'lblOpcionforval_righttext_Visible',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Visible'},{av:'cmbavDia'},{av:'AV58dia',fld:'vDIA',pic:'Z9'},{av:'cmbavPerdesde'}]}");
      setEventMetadata("VHASTA.CLICK","{handler:'e19BK2',iparms:[{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavHasta'},{av:'AV13Hasta',fld:'vHASTA',pic:''},{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'AV103yaModificoImporte',fld:'vYAMODIFICOIMPORTE',pic:''},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''}]");
      setEventMetadata("VHASTA.CLICK",",oparms:[{av:'AV41tocoHasta',fld:'vTOCOHASTA',pic:''},{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'lblOpcionforval_righttext_Format',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Format'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'lblOpcionforval_righttext_Caption',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Caption'},{av:'edtavAgeimporte_Visible',ctrl:'vAGEIMPORTE',prop:'Visible'},{av:'lblOpcionforval_righttext_Visible',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Visible'},{av:'cmbavDia'},{av:'AV58dia',fld:'vDIA',pic:'Z9'},{av:'cmbavPerdesde'},{av:'cmbavHasta'}]}");
      setEventMetadata("ENTER","{handler:'e20BK2',iparms:[{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV32LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'},{av:'cmbavDia'},{av:'AV58dia',fld:'vDIA',pic:'Z9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavPerdesde'},{av:'AV10PerDesde',fld:'vPERDESDE',pic:''},{av:'radavMetodo'},{av:'AV7Metodo',fld:'vMETODO',pic:'9'},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV50importeStr',fld:'vIMPORTESTR',pic:''},{av:'AV93error',fld:'vERROR',pic:''},{av:'AV110LegModTra',fld:'vLEGMODTRA',pic:''},{av:'AV34errores',fld:'vERRORES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV34errores',fld:'vERRORES',pic:''},{av:'AV50importeStr',fld:'vIMPORTESTR',pic:''},{av:'AV93error',fld:'vERROR',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''}]}");
      setEventMetadata("VAGECANTI.CONTROLVALUECHANGED","{handler:'e21BK2',iparms:[{av:'AV40tocoPeriodos',fld:'vTOCOPERIODOS',pic:''},{av:'AV114tocoLegajo',fld:'vTOCOLEGAJO',pic:''},{av:'AV113tocoConcepto',fld:'vTOCOCONCEPTO',pic:''},{av:'AV8AgeFecDes',fld:'vAGEFECDES',pic:''},{av:'AV9AgeFecHas',fld:'vAGEFECHAS',pic:''},{av:'AV29hoy',fld:'vHOY',pic:'',hsh:true},{av:'AV103yaModificoImporte',fld:'vYAMODIFICOIMPORTE',pic:''},{av:'cmbavOpcionforval'},{av:'AV44OpcionForVal',fld:'vOPCIONFORVAL',pic:'9'},{av:'AV15ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV117Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV75adelVacProxConCodigo',fld:'vADELVACPROXCONCODIGO',pic:'',hsh:true},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'AV18CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV14LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83horasNormalesConCodigo',fld:'vHORASNORMALESCONCODIGO',pic:'',hsh:true},{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''},{av:'cmbavQuincena'},{av:'AV106quincena',fld:'vQUINCENA',pic:'9'}]");
      setEventMetadata("VAGECANTI.CONTROLVALUECHANGED",",oparms:[{av:'AV102yaModificoCantidad',fld:'vYAMODIFICOCANTIDAD',pic:''},{av:'lblOpcionforval_righttext_Format',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Format'},{av:'AV17AgeImporte',fld:'vAGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV16AgeCanti',fld:'vAGECANTI',pic:'ZZZZZ9.99'},{av:'lblOpcionforval_righttext_Caption',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Caption'},{av:'edtavAgeimporte_Visible',ctrl:'vAGEIMPORTE',prop:'Visible'},{av:'lblOpcionforval_righttext_Visible',ctrl:'OPCIONFORVAL_RIGHTTEXT',prop:'Visible'}]}");
      setEventMetadata("VALIDV_CLICOD","{handler:'validv_Clicod',iparms:[]");
      setEventMetadata("VALIDV_CLICOD",",oparms:[]}");
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
      wcpOAV27TrnMode = "" ;
      Combo_concodigo_Selectedvalue_get = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV27TrnMode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV117Pgmname = "" ;
      AV75adelVacProxConCodigo = "" ;
      AV29hoy = GXutil.nullDate() ;
      AV83horasNormalesConCodigo = "" ;
      AV42vacacionesSubTipoConCod1 = "" ;
      AV101ultNovLiqPeriodo = GXutil.nullDate() ;
      AV100sigLiqLiqPeriodo = GXutil.nullDate() ;
      GXKey = "" ;
      AV21LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV46DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV23ConCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A41ConDescrip = "" ;
      A38SubTipoConCod1 = "" ;
      A953ConCondicion = "" ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A1645ConceptoConveCodigo = "" ;
      AV111tipo_tarifa = "" ;
      AV48LegConveCodigo = "" ;
      AV50importeStr = "" ;
      AV93error = "" ;
      AV110LegModTra = "" ;
      AV34errores = new GXSimpleCollection<String>(String.class, "internal", "");
      Combo_legnumero_Selectedvalue_set = "" ;
      Combo_concodigo_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      TempTags = "" ;
      AV15ConCodigo = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10PerDesde = GXutil.nullDate() ;
      AV13Hasta = GXutil.nullDate() ;
      AV16AgeCanti = DecimalUtil.ZERO ;
      AV17AgeImporte = DecimalUtil.ZERO ;
      AV8AgeFecDes = GXutil.nullDate() ;
      AV9AgeFecHas = GXutil.nullDate() ;
      Gx_mode = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      AV74auxAgeFecDes = GXutil.nullDate() ;
      AV76auxAgeFecHas = GXutil.nullDate() ;
      AV79LiqDCanti = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      H00BK2_A1826ConPueNov = new boolean[] {false} ;
      H00BK2_A162ConVigencia = new byte[1] ;
      H00BK2_A37TipoConCod = new String[] {""} ;
      H00BK2_A38SubTipoConCod1 = new String[] {""} ;
      H00BK2_n38SubTipoConCod1 = new boolean[] {false} ;
      H00BK2_A953ConCondicion = new String[] {""} ;
      H00BK2_n953ConCondicion = new boolean[] {false} ;
      H00BK2_A3CliCod = new int[1] ;
      H00BK2_A26ConCodigo = new String[] {""} ;
      H00BK2_A1645ConceptoConveCodigo = new String[] {""} ;
      H00BK2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      H00BK2_A1644ConceptoPais = new short[1] ;
      H00BK2_n1644ConceptoPais = new boolean[] {false} ;
      H00BK2_A41ConDescrip = new String[] {""} ;
      AV22Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucCombo_concodigo = new com.genexus.webpanels.GXUserControl();
      H00BK3_A3CliCod = new int[1] ;
      H00BK3_A1EmpCod = new short[1] ;
      H00BK3_A1818LegEstado = new byte[1] ;
      H00BK3_A6LegNumero = new int[1] ;
      H00BK3_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      AV35rangoNumeros = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV43ConFormula = "" ;
      AV65feriadoTrabajadoConCodigo = "" ;
      AV105feriadoTrabajadoHorConCodigo = "" ;
      AV70diaDate = GXutil.nullDate() ;
      AV55SubTipoConCod1 = "" ;
      AV63MprCod = "" ;
      AV67SecCodigo = "" ;
      AV66PuestoCodigo = "" ;
      GXv_char3 = new String[1] ;
      AV73PuestoDescrip = "" ;
      GXv_objcol_svchar15 = new GXSimpleCollection[1] ;
      AV91LegFecIngreso = GXutil.nullDate() ;
      AV30mesPalabra = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int16 = new short[1] ;
      GXv_int18 = new int[1] ;
      GXv_int7 = new short[1] ;
      AV86quincenaTLiqCod = "" ;
      GXv_int20 = new byte[1] ;
      GXt_char1 = "" ;
      AV80desdeFecha = GXutil.nullDate() ;
      AV81hastaFecha = GXutil.nullDate() ;
      AV77defaultAgeCanti = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      AV78LiqDLog = "" ;
      GXv_char4 = new String[1] ;
      AV104errPrinPalabra = "" ;
      GXt_char2 = "" ;
      GXv_char12 = new String[1] ;
      AV59auxDesdeFecha = GXutil.nullDate() ;
      AV60auxHastaFecha = GXutil.nullDate() ;
      GXv_date21 = new java.util.Date[1] ;
      GXv_date17 = new java.util.Date[1] ;
      AV69diaPalabra = "" ;
      GXv_int19 = new short[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_objcol_int8 = new GXSimpleCollection[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_legnumero_Jsonclick = "" ;
      Combo_legnumero_Caption = "" ;
      lblTextblockcombo_concodigo_Jsonclick = "" ;
      lblTextblockopcionforval_Jsonclick = "" ;
      ucDvpanel_pertbl = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      lblOpcionforval_righttext_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV27TrnMode = "" ;
      sCtrlAV18CliCod = "" ;
      sCtrlAV19EmpCod = "" ;
      sCtrlAV33parmLegNumero = "" ;
      sCtrlAV20AgeOrden = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadconcepto_abm__default(),
         new Object[] {
             new Object[] {
            H00BK2_A1826ConPueNov, H00BK2_A162ConVigencia, H00BK2_A37TipoConCod, H00BK2_A38SubTipoConCod1, H00BK2_n38SubTipoConCod1, H00BK2_A953ConCondicion, H00BK2_n953ConCondicion, H00BK2_A3CliCod, H00BK2_A26ConCodigo, H00BK2_A1645ConceptoConveCodigo,
            H00BK2_n1645ConceptoConveCodigo, H00BK2_A1644ConceptoPais, H00BK2_n1644ConceptoPais, H00BK2_A41ConDescrip
            }
            , new Object[] {
            H00BK3_A3CliCod, H00BK3_A1EmpCod, H00BK3_A1818LegEstado, H00BK3_A6LegNumero, H00BK3_A250LegIdNomApe
            }
         }
      );
      AV117Pgmname = "NovedadConcepto_ABM" ;
      /* GeneXus formulas. */
      AV117Pgmname = "NovedadConcepto_ABM" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV25LiqPerMes ;
   private byte AV32LegClase ;
   private byte A162ConVigencia ;
   private byte AV57ConceptoFiltro ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte AV44OpcionForVal ;
   private byte AV7Metodo ;
   private byte AV106quincena ;
   private byte AV58dia ;
   private byte A1818LegEstado ;
   private byte AV89ultMes ;
   private byte GXv_int20[] ;
   private byte nGXWrapped ;
   private short wcpOAV19EmpCod ;
   private short wcpOAV20AgeOrden ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV19EmpCod ;
   private short AV20AgeOrden ;
   private short AV26anio ;
   private short AV24LiqPerAno ;
   private short A1644ConceptoPais ;
   private short AV47LegPaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1EmpCod ;
   private short AV71PaiCod ;
   private short AV92hastaAnio ;
   private short AV90desdeAnio ;
   private short AV88ultAnio ;
   private short AV31i ;
   private short GXv_int16[] ;
   private short AV108defaultAnio ;
   private short GXv_int7[] ;
   private short AV109defaultMesNro ;
   private short lblOpcionforval_righttext_Format ;
   private short GXt_int9 ;
   private short GXv_int19[] ;
   private short AV85quincenaNro ;
   private int wcpOAV18CliCod ;
   private int wcpOAV33parmLegNumero ;
   private int AV18CliCod ;
   private int AV33parmLegNumero ;
   private int A3CliCod ;
   private int AV14LegNumero ;
   private int edtavLegnumero_Visible ;
   private int edtavConcodigo_Visible ;
   private int edtavConceptofiltro_Visible ;
   private int edtavClicod_Visible ;
   private int edtavEmpcod_Visible ;
   private int edtavAgeorden_Visible ;
   private int A6LegNumero ;
   private int edtavAgefecdes_Visible ;
   private int edtavAgefechas_Visible ;
   private int edtavAgecanti_Visible ;
   private int edtavAgecanti_Enabled ;
   private int GXv_int18[] ;
   private int edtavAgeimporte_Visible ;
   private int lblOpcionforval_righttext_Visible ;
   private int edtavAgeimporte_Enabled ;
   private int edtavAgefecdes_Enabled ;
   private int edtavAgefechas_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal AV16AgeCanti ;
   private java.math.BigDecimal AV17AgeImporte ;
   private java.math.BigDecimal AV79LiqDCanti ;
   private java.math.BigDecimal AV77defaultAgeCanti ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private String wcpOAV27TrnMode ;
   private String Combo_concodigo_Selectedvalue_get ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV27TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV117Pgmname ;
   private String AV75adelVacProxConCodigo ;
   private String AV83horasNormalesConCodigo ;
   private String AV42vacacionesSubTipoConCod1 ;
   private String GXKey ;
   private String A38SubTipoConCod1 ;
   private String A953ConCondicion ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String A1645ConceptoConveCodigo ;
   private String AV111tipo_tarifa ;
   private String AV48LegConveCodigo ;
   private String AV50importeStr ;
   private String AV110LegModTra ;
   private String Combo_legnumero_Cls ;
   private String Combo_legnumero_Selectedvalue_set ;
   private String Combo_concodigo_Cls ;
   private String Combo_concodigo_Selectedvalue_set ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_pertbl_Width ;
   private String Dvpanel_pertbl_Cls ;
   private String Dvpanel_pertbl_Title ;
   private String Dvpanel_pertbl_Iconposition ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavLegnumero_Internalname ;
   private String edtavLegnumero_Jsonclick ;
   private String edtavConcodigo_Internalname ;
   private String AV15ConCodigo ;
   private String edtavConcodigo_Jsonclick ;
   private String edtavConceptofiltro_Internalname ;
   private String edtavConceptofiltro_Jsonclick ;
   private String edtavClicod_Internalname ;
   private String edtavClicod_Jsonclick ;
   private String edtavEmpcod_Internalname ;
   private String edtavEmpcod_Jsonclick ;
   private String edtavAgeorden_Internalname ;
   private String edtavAgeorden_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavAgecanti_Internalname ;
   private String edtavAgeimporte_Internalname ;
   private String edtavAgefecdes_Internalname ;
   private String edtavAgefechas_Internalname ;
   private String Gx_mode ;
   private String Combo_legnumero_Internalname ;
   private String scmdbuf ;
   private String Combo_concodigo_Internalname ;
   private String AV65feriadoTrabajadoConCodigo ;
   private String AV105feriadoTrabajadoHorConCodigo ;
   private String AV55SubTipoConCod1 ;
   private String AV63MprCod ;
   private String AV67SecCodigo ;
   private String AV66PuestoCodigo ;
   private String GXv_char3[] ;
   private String AV86quincenaTLiqCod ;
   private String GXt_char1 ;
   private String lblOpcionforval_righttext_Internalname ;
   private String GXv_char4[] ;
   private String AV104errPrinPalabra ;
   private String GXt_char2 ;
   private String GXv_char12[] ;
   private String lblOpcionforval_righttext_Caption ;
   private String AV69diaPalabra ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String divTablesplittedlegnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String divTablesplittedconcodigo_Internalname ;
   private String lblTextblockcombo_concodigo_Internalname ;
   private String lblTextblockcombo_concodigo_Jsonclick ;
   private String Combo_concodigo_Caption ;
   private String edtavAgecanti_Jsonclick ;
   private String divTablesplittedopcionforval_Internalname ;
   private String lblTextblockopcionforval_Internalname ;
   private String lblTextblockopcionforval_Jsonclick ;
   private String edtavAgeimporte_Jsonclick ;
   private String Dvpanel_pertbl_Internalname ;
   private String divPertbl_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtavAgefecdes_Jsonclick ;
   private String edtavAgefechas_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String tblTablemergedopcionforval_Internalname ;
   private String lblOpcionforval_righttext_Jsonclick ;
   private String sCtrlAV27TrnMode ;
   private String sCtrlAV18CliCod ;
   private String sCtrlAV19EmpCod ;
   private String sCtrlAV33parmLegNumero ;
   private String sCtrlAV20AgeOrden ;
   private java.util.Date AV29hoy ;
   private java.util.Date AV101ultNovLiqPeriodo ;
   private java.util.Date AV100sigLiqLiqPeriodo ;
   private java.util.Date AV10PerDesde ;
   private java.util.Date AV13Hasta ;
   private java.util.Date AV8AgeFecDes ;
   private java.util.Date AV9AgeFecHas ;
   private java.util.Date AV74auxAgeFecDes ;
   private java.util.Date AV76auxAgeFecHas ;
   private java.util.Date AV70diaDate ;
   private java.util.Date AV91LegFecIngreso ;
   private java.util.Date AV80desdeFecha ;
   private java.util.Date AV81hastaFecha ;
   private java.util.Date AV59auxDesdeFecha ;
   private java.util.Date AV60auxHastaFecha ;
   private java.util.Date GXv_date21[] ;
   private java.util.Date GXv_date17[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV40tocoPeriodos ;
   private boolean AV114tocoLegajo ;
   private boolean AV113tocoConcepto ;
   private boolean AV103yaModificoImporte ;
   private boolean AV102yaModificoCantidad ;
   private boolean AV82hay ;
   private boolean A1826ConPueNov ;
   private boolean AV41tocoHasta ;
   private boolean Combo_legnumero_Visible ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_pertbl_Autowidth ;
   private boolean Dvpanel_pertbl_Autoheight ;
   private boolean Dvpanel_pertbl_Collapsible ;
   private boolean Dvpanel_pertbl_Collapsed ;
   private boolean Dvpanel_pertbl_Showcollapseicon ;
   private boolean Dvpanel_pertbl_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean n38SubTipoConCod1 ;
   private boolean n953ConCondicion ;
   private boolean n1645ConceptoConveCodigo ;
   private boolean n1644ConceptoPais ;
   private boolean AV72feriadoEs ;
   private boolean Cond_result ;
   private boolean AV64MprHorasExtras ;
   private boolean AV68PuestoHorasExt ;
   private boolean AV11primeraQuincena ;
   private boolean AV12segundaQuincena ;
   private boolean AV107defaultHay ;
   private boolean AV87primeraTiene ;
   private boolean GXt_boolean10 ;
   private boolean GXv_boolean11[] ;
   private String AV43ConFormula ;
   private String AV78LiqDLog ;
   private String A41ConDescrip ;
   private String AV93error ;
   private String A250LegIdNomApe ;
   private String AV73PuestoDescrip ;
   private GXSimpleCollection<Short> AV35rangoNumeros ;
   private GXSimpleCollection<Short> GXv_objcol_int8[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.webpanels.GXUserControl ucCombo_concodigo ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_pertbl ;
   private HTMLChoice cmbavOpcionforval ;
   private HTMLChoice radavMetodo ;
   private HTMLChoice cmbavPerdesde ;
   private HTMLChoice cmbavHasta ;
   private HTMLChoice cmbavQuincena ;
   private HTMLChoice cmbavDia ;
   private IDataStoreProvider pr_default ;
   private boolean[] H00BK2_A1826ConPueNov ;
   private byte[] H00BK2_A162ConVigencia ;
   private String[] H00BK2_A37TipoConCod ;
   private String[] H00BK2_A38SubTipoConCod1 ;
   private boolean[] H00BK2_n38SubTipoConCod1 ;
   private String[] H00BK2_A953ConCondicion ;
   private boolean[] H00BK2_n953ConCondicion ;
   private int[] H00BK2_A3CliCod ;
   private String[] H00BK2_A26ConCodigo ;
   private String[] H00BK2_A1645ConceptoConveCodigo ;
   private boolean[] H00BK2_n1645ConceptoConveCodigo ;
   private short[] H00BK2_A1644ConceptoPais ;
   private boolean[] H00BK2_n1644ConceptoPais ;
   private String[] H00BK2_A41ConDescrip ;
   private int[] H00BK3_A3CliCod ;
   private short[] H00BK3_A1EmpCod ;
   private byte[] H00BK3_A1818LegEstado ;
   private int[] H00BK3_A6LegNumero ;
   private String[] H00BK3_A250LegIdNomApe ;
   private GXSimpleCollection<String> AV30mesPalabra ;
   private GXSimpleCollection<String> AV34errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar15[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21LegNumero_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV23ConCodigo_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV22Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV46DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
}

final  class novedadconcepto_abm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00BK2", "SELECT ConPueNov, ConVigencia, TipoConCod, SubTipoConCod1, ConCondicion, CliCod, ConCodigo, ConceptoConveCodigo, ConceptoPais, ConDescrip FROM Concepto WHERE (CliCod = ?) AND (ConCondicion = ( 'A0') or SubTipoConCod1 = ( ?) or ConCondicion = ( 'B16')) AND (TipoConCod <> ( 'CAL_ARG')) AND (ConVigencia = 1 or ConPueNov = TRUE) ORDER BY CliCod, ConDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00BK3", "SELECT CliCod, EmpCod, LegEstado, LegNumero, LegIdNomApe FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) AND (LegEstado = 1) ORDER BY LegIdNomApe ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               ((String[]) buf[9])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

