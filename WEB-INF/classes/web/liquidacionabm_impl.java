package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacionabm_impl extends GXWebComponent
{
   public liquidacionabm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacionabm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionabm_impl.class ));
   }

   public liquidacionabm_impl( int remoteHandle ,
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
      cmbavLiqperano = new HTMLChoice();
      cmbavLiqpermes = new HTMLChoice();
      cmbavLiqmodtra = new HTMLChoice();
      cmbavLiqtipotarifa = new HTMLChoice();
      cmbavLiqfrecpag = new HTMLChoice();
      cmbavTliqcod = new HTMLChoice();
      chkavLiqsac = UIFactory.getCheckbox(this);
      cmbavConveniofiltro = new HTMLChoice();
      radavAplicaa = new HTMLChoice();
      cmbavLiqdepperano = new HTMLChoice();
      cmbavLiqdeppermes = new HTMLChoice();
      chkavInsert = UIFactory.getCheckbox(this);
      chkavUpdate = UIFactory.getCheckbox(this);
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
               AV94MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94MenuOpcCod", AV94MenuOpcCod);
               AV23Modo = httpContext.GetPar( "Modo") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23Modo", AV23Modo);
               AV32CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32CliCod), 6, 0));
               AV11EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
               AV20LiqNroPar = (int)(GXutil.lval( httpContext.GetPar( "LiqNroPar"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20LiqNroPar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20LiqNroPar), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV94MenuOpcCod,AV23Modo,Integer.valueOf(AV32CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV20LiqNroPar)});
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
         pa2S2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Liquidacion ABM", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacionabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV94MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV23Modo)),GXutil.URLEncode(GXutil.ltrimstr(AV32CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV20LiqNroPar,8,0))}, new String[] {"MenuOpcCod","Modo","CliCod","EmpCod","LiqNroPar"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV155Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV68vacacionesTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQCLASE", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV16LiqClase), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQUINCENATLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV65quincenaTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENSUALTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV111mensualTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV83PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQESTADO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV5LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDUMMYDATE", getSecureSignedToken( sPrefix, AV47dummyDate));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSOLA_OPCION_MODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV134sola_opcion_modoPalabra, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDDO_TITLESETTINGSICONS", AV10DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDDO_TITLESETTINGSICONS", AV10DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONVECODIGO_DATA", AV97ConveCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONVECODIGO_DATA", AV97ConveCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCATCODIGO_DATA", AV8CatCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCATCODIGO_DATA", AV8CatCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSECCODIGO_DATA", AV25SecCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSECCODIGO_DATA", AV25SecCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vPUESTOCODIGO_DATA", AV102PuestoCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vPUESTOCODIGO_DATA", AV102PuestoCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSUCCODIGO_DATA", AV103SucCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSUCCODIGO_DATA", AV103SucCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLEGNUMERO_DATA", AV14LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLEGNUMERO_DATA", AV14LegNumero_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLIQDEPBANCOD_DATA", AV46LiqDepBanCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLIQDEPBANCOD_DATA", AV46LiqDepBanCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV94MenuOpcCod", wcpOAV94MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV23Modo", GXutil.rtrim( wcpOAV23Modo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV32CliCod", GXutil.ltrim( localUtil.ntoc( wcpOAV32CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV11EmpCod", GXutil.ltrim( localUtil.ntoc( wcpOAV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV20LiqNroPar", GXutil.ltrim( localUtil.ntoc( wcpOAV20LiqNroPar, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV32CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV155Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV155Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODO", GXutil.rtrim( AV23Modo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVACACIONESTLIQCOD", GXutil.rtrim( AV68vacacionesTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV68vacacionesTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLEGNUMERO", AV13LegNumero);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLEGNUMERO", AV13LegNumero);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCONVECODIGO", AV82ConveCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCONVECODIGO", AV82ConveCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCATCODIGO", AV7CatCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCATCODIGO", AV7CatCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSECCODIGO", AV24SecCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSECCODIGO", AV24SecCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vPUESTOCODIGO", AV100PuestoCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vPUESTOCODIGO", AV100PuestoCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSUCCODIGO", AV101SucCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSUCCODIGO", AV101SucCodigo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQCLASE", GXutil.ltrim( localUtil.ntoc( AV16LiqClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQCLASE", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV16LiqClase), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vAGUITLIQCOD", GXutil.rtrim( AV52aguiTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQNROPAR", GXutil.ltrim( localUtil.ntoc( AV20LiqNroPar, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECEGRESO", localUtil.dtoc( A244LegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGESTADO", GXutil.ltrim( localUtil.ntoc( A1818LegEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCLASE", GXutil.ltrim( localUtil.ntoc( A235LegClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGMODTRA", GXutil.rtrim( A2404LegModTra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGTIPOTARIFA", GXutil.rtrim( A2417LegTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGFECINGRESO", localUtil.dtoc( A245LegFecIngreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCONVECODIGO", GXutil.rtrim( A937LegConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGCATCODIGO", GXutil.rtrim( A939LegCatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSECCODIGO", GXutil.rtrim( A1579LegSecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGPUESCODIGO", GXutil.rtrim( A1578LegPuesCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGSUCCODIGO", GXutil.rtrim( A1577LegSucCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vMODIFICONOMBRE", AV107modificoNombre);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQPERPALABRA", GXutil.rtrim( AV78LiqPerPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vQUINCENATLIQCOD", GXutil.rtrim( AV65quincenaTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQUINCENATLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV65quincenaTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSACES", GXutil.ltrim( localUtil.ntoc( AV109sacEs, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENSUALTLIQCOD", GXutil.rtrim( AV111mensualTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENSUALTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV111mensualTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PUESTODESCRIP", A1241PuestoDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SECCODIGO", GXutil.rtrim( A13SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PUESTOCODIGO", GXutil.rtrim( A1240PuestoCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CATDESCRIP", A123CatDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLIPAICONVE", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV83PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV83PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CLICONVENIO", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CATCLASE", GXutil.ltrim( localUtil.ntoc( A1838CatClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CATCODIGO", GXutil.rtrim( A8CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCONFIRMARRESPUESTA", GXutil.rtrim( AV63confirmarRespuesta));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQESTADO", GXutil.ltrim( localUtil.ntoc( AV5LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQESTADO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV5LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDUMMYDATE", localUtil.dtoc( AV47dummyDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDUMMYDATE", getSecureSignedToken( sPrefix, AV47dummyDate));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQSACLOG", AV110LiqSacLog);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSOLA_OPCION_MODOPALABRA", GXutil.rtrim( AV134sola_opcion_modoPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSOLA_OPCION_MODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV134sola_opcion_modoPalabra, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vFECHASRANGOTOCO", GXutil.ltrim( localUtil.ntoc( AV145fechasRangoToco, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOFECHAPAGO", AV70tocoFechaPago);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TLIQORD", GXutil.ltrim( localUtil.ntoc( A1817TLiqOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"TLIQHABILITADA", A341TLiqHabilitada);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TLIQCOD", GXutil.rtrim( A32TLiqCod));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOLIQSAC", AV112tocoLiqSac);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vTOCOFECHASPREVISIONAL", AV69tocoFechasPrevisional);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENUOPCCOD", AV94MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Cls", GXutil.rtrim( Combo_convecodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Selectedvalue_set", GXutil.rtrim( Combo_convecodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Allowmultipleselection", GXutil.booltostr( Combo_convecodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_convecodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Multiplevaluestype", GXutil.rtrim( Combo_convecodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Emptyitemtext", GXutil.rtrim( Combo_convecodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Cls", GXutil.rtrim( Combo_catcodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_catcodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_catcodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_catcodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_catcodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Emptyitemtext", GXutil.rtrim( Combo_catcodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Cls", GXutil.rtrim( Combo_seccodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_seccodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Enabled", GXutil.booltostr( Combo_seccodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_seccodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_seccodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_seccodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Emptyitemtext", GXutil.rtrim( Combo_seccodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Cls", GXutil.rtrim( Combo_puestocodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_puestocodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Enabled", GXutil.booltostr( Combo_puestocodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_puestocodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_puestocodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_puestocodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Emptyitemtext", GXutil.rtrim( Combo_puestocodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Cls", GXutil.rtrim( Combo_succodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_succodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Enabled", GXutil.booltostr( Combo_succodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_succodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_succodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_succodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Emptyitemtext", GXutil.rtrim( Combo_succodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Allowmultipleselection", GXutil.booltostr( Combo_legnumero_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Includeonlyselectedoption", GXutil.booltostr( Combo_legnumero_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_legnumero_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Multiplevaluestype", GXutil.rtrim( Combo_legnumero_Multiplevaluestype));
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
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LIQDEPBANCOD_Cls", GXutil.rtrim( Combo_liqdepbancod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LIQDEPBANCOD_Selectedvalue_set", GXutil.rtrim( Combo_liqdepbancod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LIQDEPBANCOD_Enabled", GXutil.booltostr( Combo_liqdepbancod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Width", GXutil.rtrim( Dvpanel_tableprevi_Width));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Autowidth", GXutil.booltostr( Dvpanel_tableprevi_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Autoheight", GXutil.booltostr( Dvpanel_tableprevi_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Cls", GXutil.rtrim( Dvpanel_tableprevi_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Title", GXutil.rtrim( Dvpanel_tableprevi_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Collapsible", GXutil.booltostr( Dvpanel_tableprevi_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Collapsed", GXutil.booltostr( Dvpanel_tableprevi_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Showcollapseicon", GXutil.booltostr( Dvpanel_tableprevi_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Iconposition", GXutil.rtrim( Dvpanel_tableprevi_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEPREVI_Autoscroll", GXutil.booltostr( Dvpanel_tableprevi_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Title", GXutil.rtrim( Dvelop_confirmpanel_enter_Title));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_enter_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_enter_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_enter_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_enter_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_enter_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_enter_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Result", GXutil.rtrim( Dvelop_confirmpanel_enter_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LIQDEPBANCOD_Selectedvalue_get", GXutil.rtrim( Combo_liqdepbancod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_legnumero_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_succodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_puestocodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_seccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_catcodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Selectedvalue_get", GXutil.rtrim( Combo_convecodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Result", GXutil.rtrim( Dvelop_confirmpanel_enter_Result));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SUCCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_succodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PUESTOCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_puestocodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_SECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_seccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CATCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_catcodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_CONVECODIGO_Selectedvalue_get", GXutil.rtrim( Combo_convecodigo_Selectedvalue_get));
   }

   public void renderHtmlCloseForm2S2( )
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
      return "LiquidacionABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liquidacion ABM", "") ;
   }

   public void wb2S0( )
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
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.liquidacionabm");
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
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
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
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqperano.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqperano.getInternalname(), httpContext.getMessage( "Año", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqperano, cmbavLiqperano.getInternalname(), GXutil.trim( GXutil.str( AV44LiqPerAno, 4, 0)), 1, cmbavLiqperano.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLiqperano.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqperano.setValue( GXutil.trim( GXutil.str( AV44LiqPerAno, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqperano.getInternalname(), "Values", cmbavLiqperano.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqpermes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqpermes.getInternalname(), httpContext.getMessage( "Mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqpermes, cmbavLiqpermes.getInternalname(), GXutil.trim( GXutil.str( AV45LiqPerMes, 2, 0)), 1, cmbavLiqpermes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLiqpermes.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqpermes.setValue( GXutil.trim( GXutil.str( AV45LiqPerMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqpermes.getInternalname(), "Values", cmbavLiqpermes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavLiqmodtra.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqmodtra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqmodtra.getInternalname(), httpContext.getMessage( "Relación laboral", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqmodtra, cmbavLiqmodtra.getInternalname(), GXutil.rtrim( AV124LiqModTra), 1, cmbavLiqmodtra.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavLiqmodtra.getVisible(), cmbavLiqmodtra.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqmodtra.setValue( GXutil.rtrim( AV124LiqModTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqmodtra.getInternalname(), "Values", cmbavLiqmodtra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavLiqtipotarifa.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqtipotarifa.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqtipotarifa.getInternalname(), httpContext.getMessage( "Tipo de tarifa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqtipotarifa, cmbavLiqtipotarifa.getInternalname(), GXutil.rtrim( AV146LiqTipoTarifa), 1, cmbavLiqtipotarifa.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavLiqtipotarifa.getVisible(), cmbavLiqtipotarifa.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqtipotarifa.setValue( GXutil.rtrim( AV146LiqTipoTarifa) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqtipotarifa.getInternalname(), "Values", cmbavLiqtipotarifa.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavLiqfrecpag.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqfrecpag.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqfrecpag.getInternalname(), httpContext.getMessage( "Frecuencia de pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqfrecpag, cmbavLiqfrecpag.getInternalname(), GXutil.trim( GXutil.str( AV126LiqFrecPag, 1, 0)), 1, cmbavLiqfrecpag.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", cmbavLiqfrecpag.getVisible(), cmbavLiqfrecpag.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqfrecpag.setValue( GXutil.trim( GXutil.str( AV126LiqFrecPag, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqfrecpag.getInternalname(), "Values", cmbavLiqfrecpag.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavTliqcod.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavTliqcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavTliqcod.getInternalname(), httpContext.getMessage( "Tipo de liquidación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavTliqcod, cmbavTliqcod.getInternalname(), GXutil.rtrim( AV26TLiqCod), 1, cmbavTliqcod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavTliqcod.getVisible(), cmbavTliqcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqfecpago_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqfecpago_Internalname, httpContext.getMessage( "Fecha de pago", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqfecpago_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqfecpago_Internalname, localUtil.format(AV37LiqFecPago, "99/99/9999"), localUtil.format( AV37LiqFecPago, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,52);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqfecpago_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLiqfecpago_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqfecpago_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLiqfecpago_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqperdes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqperdes_Internalname, httpContext.getMessage( "Periodo trabajado desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqperdes_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqperdes_Internalname, localUtil.format(AV127LiqPerDes, "99/99/9999"), localUtil.format( AV127LiqPerDes, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,57);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqperdes_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLiqperdes_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqperdes_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLiqperdes_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqperhas_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqperhas_Internalname, httpContext.getMessage( "Periodo trabajado hasta", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqperhas_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqperhas_Internalname, localUtil.format(AV128LiqPerHas, "99/99/9999"), localUtil.format( AV128LiqPerHas, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,62);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqperhas_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLiqperhas_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqperhas_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLiqperhas_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavLiqsac.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavLiqsac.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavLiqsac.getInternalname(), httpContext.getMessage( "Liquidar SAC", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLiqsac.getInternalname(), GXutil.booltostr( AV108LiqSac), "", httpContext.getMessage( "Liquidar SAC", ""), chkavLiqsac.getVisible(), chkavLiqsac.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(67, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,67);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavConveniofiltro.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConveniofiltro.getInternalname(), httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConveniofiltro, cmbavConveniofiltro.getInternalname(), GXutil.rtrim( AV104ConvenioFiltro), 1, cmbavConveniofiltro.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavConveniofiltro.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavConveniofiltro.setValue( GXutil.rtrim( AV104ConvenioFiltro) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedconvecodigo_Internalname, divTablesplittedconvecodigo_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_convecodigo_Internalname, httpContext.getMessage( "Esquema tarifario / Convenio", ""), "", "", lblTextblockcombo_convecodigo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_convecodigo.setProperty("Caption", Combo_convecodigo_Caption);
         ucCombo_convecodigo.setProperty("Cls", Combo_convecodigo_Cls);
         ucCombo_convecodigo.setProperty("AllowMultipleSelection", Combo_convecodigo_Allowmultipleselection);
         ucCombo_convecodigo.setProperty("IncludeOnlySelectedOption", Combo_convecodigo_Includeonlyselectedoption);
         ucCombo_convecodigo.setProperty("MultipleValuesType", Combo_convecodigo_Multiplevaluestype);
         ucCombo_convecodigo.setProperty("EmptyItemText", Combo_convecodigo_Emptyitemtext);
         ucCombo_convecodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_convecodigo.setProperty("DropDownOptionsData", AV97ConveCodigo_Data);
         ucCombo_convecodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_convecodigo_Internalname, sPrefix+"COMBO_CONVECODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedcatcodigo_Internalname, divTablesplittedcatcodigo_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_catcodigo_Internalname, httpContext.getMessage( "Categoria", ""), "", "", lblTextblockcombo_catcodigo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_catcodigo.setProperty("Caption", Combo_catcodigo_Caption);
         ucCombo_catcodigo.setProperty("Cls", Combo_catcodigo_Cls);
         ucCombo_catcodigo.setProperty("AllowMultipleSelection", Combo_catcodigo_Allowmultipleselection);
         ucCombo_catcodigo.setProperty("IncludeOnlySelectedOption", Combo_catcodigo_Includeonlyselectedoption);
         ucCombo_catcodigo.setProperty("MultipleValuesType", Combo_catcodigo_Multiplevaluestype);
         ucCombo_catcodigo.setProperty("EmptyItemText", Combo_catcodigo_Emptyitemtext);
         ucCombo_catcodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_catcodigo.setProperty("DropDownOptionsData", AV8CatCodigo_Data);
         ucCombo_catcodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_catcodigo_Internalname, sPrefix+"COMBO_CATCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedseccodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_seccodigo_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblockcombo_seccodigo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_seccodigo.setProperty("Caption", Combo_seccodigo_Caption);
         ucCombo_seccodigo.setProperty("Cls", Combo_seccodigo_Cls);
         ucCombo_seccodigo.setProperty("AllowMultipleSelection", Combo_seccodigo_Allowmultipleselection);
         ucCombo_seccodigo.setProperty("IncludeOnlySelectedOption", Combo_seccodigo_Includeonlyselectedoption);
         ucCombo_seccodigo.setProperty("MultipleValuesType", Combo_seccodigo_Multiplevaluestype);
         ucCombo_seccodigo.setProperty("EmptyItemText", Combo_seccodigo_Emptyitemtext);
         ucCombo_seccodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_seccodigo.setProperty("DropDownOptionsData", AV25SecCodigo_Data);
         ucCombo_seccodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_seccodigo_Internalname, sPrefix+"COMBO_SECCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedpuestocodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_puestocodigo_Internalname, httpContext.getMessage( "Puesto", ""), "", "", lblTextblockcombo_puestocodigo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_puestocodigo.setProperty("Caption", Combo_puestocodigo_Caption);
         ucCombo_puestocodigo.setProperty("Cls", Combo_puestocodigo_Cls);
         ucCombo_puestocodigo.setProperty("AllowMultipleSelection", Combo_puestocodigo_Allowmultipleselection);
         ucCombo_puestocodigo.setProperty("IncludeOnlySelectedOption", Combo_puestocodigo_Includeonlyselectedoption);
         ucCombo_puestocodigo.setProperty("MultipleValuesType", Combo_puestocodigo_Multiplevaluestype);
         ucCombo_puestocodigo.setProperty("EmptyItemText", Combo_puestocodigo_Emptyitemtext);
         ucCombo_puestocodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_puestocodigo.setProperty("DropDownOptionsData", AV102PuestoCodigo_Data);
         ucCombo_puestocodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_puestocodigo_Internalname, sPrefix+"COMBO_PUESTOCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedsuccodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_succodigo_Internalname, httpContext.getMessage( "Sucursal", ""), "", "", lblTextblockcombo_succodigo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_succodigo.setProperty("Caption", Combo_succodigo_Caption);
         ucCombo_succodigo.setProperty("Cls", Combo_succodigo_Cls);
         ucCombo_succodigo.setProperty("AllowMultipleSelection", Combo_succodigo_Allowmultipleselection);
         ucCombo_succodigo.setProperty("IncludeOnlySelectedOption", Combo_succodigo_Includeonlyselectedoption);
         ucCombo_succodigo.setProperty("MultipleValuesType", Combo_succodigo_Multiplevaluestype);
         ucCombo_succodigo.setProperty("EmptyItemText", Combo_succodigo_Emptyitemtext);
         ucCombo_succodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_succodigo.setProperty("DropDownOptionsData", AV103SucCodigo_Data);
         ucCombo_succodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_succodigo_Internalname, sPrefix+"COMBO_SUCCODIGOContainer");
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
         web.GxWebStd.gx_div_start( httpContext, "", radavAplicaa.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+radavAplicaa.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Legajos", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Radio button */
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_radio_ctrl( httpContext, radavAplicaa, radavAplicaa.getInternalname(), GXutil.rtrim( AV6AplicaA), "", radavAplicaa.getVisible(), radavAplicaa.getEnabled(), 0, 0, StyleString, ClassString, "", "", 0, radavAplicaa.getJsonclick(), "'"+sPrefix+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, divTablesplittedlegnumero_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legnumero_Internalname, httpContext.getMessage( "Legajos", ""), "", "", lblTextblockcombo_legnumero_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_legnumero.setProperty("Caption", Combo_legnumero_Caption);
         ucCombo_legnumero.setProperty("Cls", Combo_legnumero_Cls);
         ucCombo_legnumero.setProperty("AllowMultipleSelection", Combo_legnumero_Allowmultipleselection);
         ucCombo_legnumero.setProperty("IncludeOnlySelectedOption", Combo_legnumero_Includeonlyselectedoption);
         ucCombo_legnumero.setProperty("EmptyItem", Combo_legnumero_Emptyitem);
         ucCombo_legnumero.setProperty("MultipleValuesType", Combo_legnumero_Multiplevaluestype);
         ucCombo_legnumero.setProperty("DropDownOptionsTitleSettingsIcons", AV10DDO_TitleSettingsIcons);
         ucCombo_legnumero.setProperty("DropDownOptionsData", AV14LegNumero_Data);
         ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, sPrefix+"COMBO_LEGNUMEROContainer");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqnombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqnombre_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 130,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavLiqnombre_Internalname, AV66LiqNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,130);\"", (short)(0), 1, edtavLiqnombre_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqdescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqdescrip_Internalname, httpContext.getMessage( "Observación", ""), "col-sm-3 obsLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "obs" ;
         StyleString = "" ;
         ClassString = "obs" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavLiqdescrip_Internalname, AV36LiqDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,135);\"", (short)(0), 1, edtavLiqdescrip_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_LiquidacionABM.htm");
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
         ucDvpanel_tableprevi.setProperty("Width", Dvpanel_tableprevi_Width);
         ucDvpanel_tableprevi.setProperty("AutoWidth", Dvpanel_tableprevi_Autowidth);
         ucDvpanel_tableprevi.setProperty("AutoHeight", Dvpanel_tableprevi_Autoheight);
         ucDvpanel_tableprevi.setProperty("Cls", Dvpanel_tableprevi_Cls);
         ucDvpanel_tableprevi.setProperty("Title", Dvpanel_tableprevi_Title);
         ucDvpanel_tableprevi.setProperty("Collapsible", Dvpanel_tableprevi_Collapsible);
         ucDvpanel_tableprevi.setProperty("Collapsed", Dvpanel_tableprevi_Collapsed);
         ucDvpanel_tableprevi.setProperty("ShowCollapseIcon", Dvpanel_tableprevi_Showcollapseicon);
         ucDvpanel_tableprevi.setProperty("IconPosition", Dvpanel_tableprevi_Iconposition);
         ucDvpanel_tableprevi.setProperty("AutoScroll", Dvpanel_tableprevi_Autoscroll);
         ucDvpanel_tableprevi.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableprevi_Internalname, sPrefix+"DVPANEL_TABLEPREVIContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEPREVIContainer"+"TablePrevi"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableprevi_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedliqdepbancod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_liqdepbancod_Internalname, httpContext.getMessage( "Banco", ""), "", "", lblTextblockcombo_liqdepbancod_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_liqdepbancod.setProperty("Caption", Combo_liqdepbancod_Caption);
         ucCombo_liqdepbancod.setProperty("Cls", Combo_liqdepbancod_Cls);
         ucCombo_liqdepbancod.setProperty("DropDownOptionsData", AV46LiqDepBanCod_Data);
         ucCombo_liqdepbancod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_liqdepbancod_Internalname, sPrefix+"COMBO_LIQDEPBANCODContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Periodo", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_LiquidacionABM.htm");
         wb_table1_152_2S2( true) ;
      }
      else
      {
         wb_table1_152_2S2( false) ;
      }
      return  ;
   }

   public void wb_table1_152_2S2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqdepprvfec_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqdepprvfec_Internalname, httpContext.getMessage( "Fecha de depósito", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 166,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqdepprvfec_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqdepprvfec_Internalname, localUtil.format(AV41LiqDepPrvFec, "99/99/99"), localUtil.format( AV41LiqDepPrvFec, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,166);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqdepprvfec_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLiqdepprvfec_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqdepprvfec_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLiqdepprvfec_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 171,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 173,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_176_2S2( true) ;
      }
      else
      {
         wb_table2_176_2S2( false) ;
      }
      return  ;
   }

   public void wb_table2_176_2S2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 205,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqdepbancod_Internalname, GXutil.rtrim( AV40LiqDepBanCod), GXutil.rtrim( localUtil.format( AV40LiqDepBanCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,205);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqdepbancod_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqdepbancod_Visible, edtavLiqdepbancod_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 206,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEstadoaccion_Internalname, GXutil.rtrim( AV30EstadoAccion), GXutil.rtrim( localUtil.format( AV30EstadoAccion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,206);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEstadoaccion_Jsonclick, 0, "Attribute", "", "", "", "", edtavEstadoaccion_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 207,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqfecha_Internalname, localUtil.format(AV18LiqFecha, "99/99/9999"), localUtil.format( AV18LiqFecha, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,207);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqfecha_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqfecha_Visible, edtavLiqfecha_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavLiqfecha_Visible==0)||(edtavLiqfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 208,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqnro_Internalname, GXutil.ltrim( localUtil.ntoc( AV19LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19LiqNro), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,208);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqnro_Jsonclick, 0, "Attribute", "", "", "", "", edtavLiqnro_Visible, 1, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 209,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavInsert.getInternalname(), GXutil.booltostr( AV80insert), "", "", chkavInsert.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(209, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,209);\"");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 210,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUpdate.getInternalname(), GXutil.booltostr( AV81update), "", "", chkavUpdate.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(210, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,210);\"");
         wb_table3_211_2S2( true) ;
      }
      else
      {
         wb_table3_211_2S2( false) ;
      }
      return  ;
   }

   public void wb_table3_211_2S2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start2S2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Liquidacion ABM", ""), (short)(0)) ;
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
            strup2S0( ) ;
         }
      }
   }

   public void ws2S2( )
   {
      start2S2( ) ;
      evt2S2( ) ;
   }

   public void evt2S2( )
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
                              strup2S0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_CONVECODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e112S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_CATCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e122S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_SECCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e132S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_PUESTOCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e142S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_SUCCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e152S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_ENTER.CLOSE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e162S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e172S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
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
                                       e182S2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e192S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQMODTRA.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e202S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQSAC.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e212S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VCONVENIOFILTRO.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e222S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQFECPAGO.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e232S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQFRECPAG.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e242S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VTLIQCOD.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e252S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQPERMES.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e262S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQPERANO.ISVALID") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e272S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e282S2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = cmbavLiqperano.getInternalname() ;
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

   public void we2S2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2S2( ) ;
         }
      }
   }

   public void pa2S2( )
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
            GX_FocusControl = cmbavLiqperano.getInternalname() ;
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
      if ( cmbavLiqperano.getItemCount() > 0 )
      {
         AV44LiqPerAno = (short)(GXutil.lval( cmbavLiqperano.getValidValue(GXutil.trim( GXutil.str( AV44LiqPerAno, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44LiqPerAno), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqperano.setValue( GXutil.trim( GXutil.str( AV44LiqPerAno, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqperano.getInternalname(), "Values", cmbavLiqperano.ToJavascriptSource(), true);
      }
      if ( cmbavLiqpermes.getItemCount() > 0 )
      {
         AV45LiqPerMes = (byte)(GXutil.lval( cmbavLiqpermes.getValidValue(GXutil.trim( GXutil.str( AV45LiqPerMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45LiqPerMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqpermes.setValue( GXutil.trim( GXutil.str( AV45LiqPerMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqpermes.getInternalname(), "Values", cmbavLiqpermes.ToJavascriptSource(), true);
      }
      if ( cmbavLiqmodtra.getItemCount() > 0 )
      {
         AV124LiqModTra = cmbavLiqmodtra.getValidValue(AV124LiqModTra) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV124LiqModTra", AV124LiqModTra);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqmodtra.setValue( GXutil.rtrim( AV124LiqModTra) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqmodtra.getInternalname(), "Values", cmbavLiqmodtra.ToJavascriptSource(), true);
      }
      if ( cmbavLiqtipotarifa.getItemCount() > 0 )
      {
         AV146LiqTipoTarifa = cmbavLiqtipotarifa.getValidValue(AV146LiqTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV146LiqTipoTarifa", AV146LiqTipoTarifa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqtipotarifa.setValue( GXutil.rtrim( AV146LiqTipoTarifa) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqtipotarifa.getInternalname(), "Values", cmbavLiqtipotarifa.ToJavascriptSource(), true);
      }
      if ( cmbavLiqfrecpag.getItemCount() > 0 )
      {
         AV126LiqFrecPag = (byte)(GXutil.lval( cmbavLiqfrecpag.getValidValue(GXutil.trim( GXutil.str( AV126LiqFrecPag, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126LiqFrecPag", GXutil.str( AV126LiqFrecPag, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqfrecpag.setValue( GXutil.trim( GXutil.str( AV126LiqFrecPag, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqfrecpag.getInternalname(), "Values", cmbavLiqfrecpag.ToJavascriptSource(), true);
      }
      if ( cmbavTliqcod.getItemCount() > 0 )
      {
         AV26TLiqCod = cmbavTliqcod.getValidValue(AV26TLiqCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TLiqCod", AV26TLiqCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
      }
      AV108LiqSac = GXutil.strtobool( GXutil.booltostr( AV108LiqSac)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108LiqSac", AV108LiqSac);
      if ( cmbavConveniofiltro.getItemCount() > 0 )
      {
         AV104ConvenioFiltro = cmbavConveniofiltro.getValidValue(AV104ConvenioFiltro) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV104ConvenioFiltro", AV104ConvenioFiltro);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConveniofiltro.setValue( GXutil.rtrim( AV104ConvenioFiltro) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConveniofiltro.getInternalname(), "Values", cmbavConveniofiltro.ToJavascriptSource(), true);
      }
      AV6AplicaA = GXutil.rtrim( AV6AplicaA) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AplicaA", AV6AplicaA);
      if ( cmbavLiqdepperano.getItemCount() > 0 )
      {
         AV42LiqDepPerAno = (short)(GXutil.lval( cmbavLiqdepperano.getValidValue(GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42LiqDepPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42LiqDepPerAno), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqdepperano.setValue( GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdepperano.getInternalname(), "Values", cmbavLiqdepperano.ToJavascriptSource(), true);
      }
      if ( cmbavLiqdeppermes.getItemCount() > 0 )
      {
         AV43LiqDepPerMes = (byte)(GXutil.lval( cmbavLiqdeppermes.getValidValue(GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43LiqDepPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43LiqDepPerMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLiqdeppermes.setValue( GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdeppermes.getInternalname(), "Values", cmbavLiqdeppermes.ToJavascriptSource(), true);
      }
      AV80insert = GXutil.strtobool( GXutil.booltostr( AV80insert)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80insert", AV80insert);
      AV81update = GXutil.strtobool( GXutil.booltostr( AV81update)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81update", AV81update);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2S2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV155Pgmname = "LiquidacionABM" ;
      Gx_err = (short)(0) ;
   }

   public void rf2S2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e192S2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e282S2 ();
         wb2S0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2S2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPGMNAME", GXutil.rtrim( AV155Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPGMNAME", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV155Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vVACACIONESTLIQCOD", GXutil.rtrim( AV68vacacionesTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV68vacacionesTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQCLASE", GXutil.ltrim( localUtil.ntoc( AV16LiqClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQCLASE", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV16LiqClase), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vQUINCENATLIQCOD", GXutil.rtrim( AV65quincenaTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQUINCENATLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV65quincenaTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMENSUALTLIQCOD", GXutil.rtrim( AV111mensualTLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENSUALTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV111mensualTLiqCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAICOD", GXutil.ltrim( localUtil.ntoc( AV83PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV83PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vLIQESTADO", GXutil.ltrim( localUtil.ntoc( AV5LiqEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQESTADO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV5LiqEstado), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vDUMMYDATE", localUtil.dtoc( AV47dummyDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vDUMMYDATE", getSecureSignedToken( sPrefix, AV47dummyDate));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vSOLA_OPCION_MODOPALABRA", GXutil.rtrim( AV134sola_opcion_modoPalabra));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSOLA_OPCION_MODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV134sola_opcion_modoPalabra, ""))));
   }

   public void before_start_formulas( )
   {
      AV155Pgmname = "LiquidacionABM" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2S0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e172S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDDO_TITLESETTINGSICONS"), AV10DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCONVECODIGO_DATA"), AV97ConveCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vCATCODIGO_DATA"), AV8CatCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vSECCODIGO_DATA"), AV25SecCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vPUESTOCODIGO_DATA"), AV102PuestoCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vSUCCODIGO_DATA"), AV103SucCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vLEGNUMERO_DATA"), AV14LegNumero_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vLIQDEPBANCOD_DATA"), AV46LiqDepBanCod_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vLEGNUMERO"), AV13LegNumero);
         /* Read saved values. */
         wcpOAV94MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV94MenuOpcCod") ;
         wcpOAV23Modo = httpContext.cgiGet( sPrefix+"wcpOAV23Modo") ;
         wcpOAV32CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV32CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV20LiqNroPar = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV20LiqNroPar"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV69tocoFechasPrevisional = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vTOCOFECHASPREVISIONAL")) ;
         AV32CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV107modificoNombre = GXutil.strtobool( httpContext.cgiGet( sPrefix+"vMODIFICONOMBRE")) ;
         AV145fechasRangoToco = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"vFECHASRANGOTOCO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Combo_convecodigo_Cls = httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Cls") ;
         Combo_convecodigo_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Selectedvalue_set") ;
         Combo_convecodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Allowmultipleselection")) ;
         Combo_convecodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Includeonlyselectedoption")) ;
         Combo_convecodigo_Multiplevaluestype = httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Multiplevaluestype") ;
         Combo_convecodigo_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Emptyitemtext") ;
         Combo_catcodigo_Cls = httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Cls") ;
         Combo_catcodigo_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Selectedvalue_set") ;
         Combo_catcodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Allowmultipleselection")) ;
         Combo_catcodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Includeonlyselectedoption")) ;
         Combo_catcodigo_Multiplevaluestype = httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Multiplevaluestype") ;
         Combo_catcodigo_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Emptyitemtext") ;
         Combo_seccodigo_Cls = httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Cls") ;
         Combo_seccodigo_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Selectedvalue_set") ;
         Combo_seccodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Enabled")) ;
         Combo_seccodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Allowmultipleselection")) ;
         Combo_seccodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Includeonlyselectedoption")) ;
         Combo_seccodigo_Multiplevaluestype = httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Multiplevaluestype") ;
         Combo_seccodigo_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Emptyitemtext") ;
         Combo_puestocodigo_Cls = httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Cls") ;
         Combo_puestocodigo_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Selectedvalue_set") ;
         Combo_puestocodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Enabled")) ;
         Combo_puestocodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Allowmultipleselection")) ;
         Combo_puestocodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Includeonlyselectedoption")) ;
         Combo_puestocodigo_Multiplevaluestype = httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Multiplevaluestype") ;
         Combo_puestocodigo_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Emptyitemtext") ;
         Combo_succodigo_Cls = httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Cls") ;
         Combo_succodigo_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Selectedvalue_set") ;
         Combo_succodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Enabled")) ;
         Combo_succodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Allowmultipleselection")) ;
         Combo_succodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Includeonlyselectedoption")) ;
         Combo_succodigo_Multiplevaluestype = httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Multiplevaluestype") ;
         Combo_succodigo_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Emptyitemtext") ;
         Combo_legnumero_Cls = httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Cls") ;
         Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Selectedvalue_set") ;
         Combo_legnumero_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Enabled")) ;
         Combo_legnumero_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Allowmultipleselection")) ;
         Combo_legnumero_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Includeonlyselectedoption")) ;
         Combo_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Emptyitem")) ;
         Combo_legnumero_Multiplevaluestype = httpContext.cgiGet( sPrefix+"COMBO_LEGNUMERO_Multiplevaluestype") ;
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
         Combo_liqdepbancod_Cls = httpContext.cgiGet( sPrefix+"COMBO_LIQDEPBANCOD_Cls") ;
         Combo_liqdepbancod_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_LIQDEPBANCOD_Selectedvalue_set") ;
         Combo_liqdepbancod_Enabled = GXutil.strtobool( httpContext.cgiGet( sPrefix+"COMBO_LIQDEPBANCOD_Enabled")) ;
         Dvpanel_tableprevi_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Width") ;
         Dvpanel_tableprevi_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Autowidth")) ;
         Dvpanel_tableprevi_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Autoheight")) ;
         Dvpanel_tableprevi_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Cls") ;
         Dvpanel_tableprevi_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Title") ;
         Dvpanel_tableprevi_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Collapsible")) ;
         Dvpanel_tableprevi_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Collapsed")) ;
         Dvpanel_tableprevi_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Showcollapseicon")) ;
         Dvpanel_tableprevi_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Iconposition") ;
         Dvpanel_tableprevi_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEPREVI_Autoscroll")) ;
         Dvelop_confirmpanel_enter_Title = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Title") ;
         Dvelop_confirmpanel_enter_Confirmationtext = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Confirmationtext") ;
         Dvelop_confirmpanel_enter_Yesbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Yesbuttoncaption") ;
         Dvelop_confirmpanel_enter_Nobuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Nobuttoncaption") ;
         Dvelop_confirmpanel_enter_Cancelbuttoncaption = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_enter_Yesbuttonposition = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Yesbuttonposition") ;
         Dvelop_confirmpanel_enter_Confirmtype = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Confirmtype") ;
         Dvelop_confirmpanel_enter_Result = httpContext.cgiGet( sPrefix+"DVELOP_CONFIRMPANEL_ENTER_Result") ;
         Combo_succodigo_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_SUCCODIGO_Selectedvalue_get") ;
         Combo_puestocodigo_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_PUESTOCODIGO_Selectedvalue_get") ;
         Combo_seccodigo_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_SECCODIGO_Selectedvalue_get") ;
         Combo_catcodigo_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_CATCODIGO_Selectedvalue_get") ;
         Combo_convecodigo_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_CONVECODIGO_Selectedvalue_get") ;
         /* Read variables values. */
         cmbavLiqperano.setValue( httpContext.cgiGet( cmbavLiqperano.getInternalname()) );
         AV44LiqPerAno = (short)(GXutil.lval( httpContext.cgiGet( cmbavLiqperano.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44LiqPerAno), 4, 0));
         cmbavLiqpermes.setValue( httpContext.cgiGet( cmbavLiqpermes.getInternalname()) );
         AV45LiqPerMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLiqpermes.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45LiqPerMes), 2, 0));
         cmbavLiqmodtra.setValue( httpContext.cgiGet( cmbavLiqmodtra.getInternalname()) );
         AV124LiqModTra = httpContext.cgiGet( cmbavLiqmodtra.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV124LiqModTra", AV124LiqModTra);
         cmbavLiqtipotarifa.setValue( httpContext.cgiGet( cmbavLiqtipotarifa.getInternalname()) );
         AV146LiqTipoTarifa = httpContext.cgiGet( cmbavLiqtipotarifa.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV146LiqTipoTarifa", AV146LiqTipoTarifa);
         cmbavLiqfrecpag.setValue( httpContext.cgiGet( cmbavLiqfrecpag.getInternalname()) );
         AV126LiqFrecPag = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLiqfrecpag.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126LiqFrecPag", GXutil.str( AV126LiqFrecPag, 1, 0));
         cmbavTliqcod.setValue( httpContext.cgiGet( cmbavTliqcod.getInternalname()) );
         AV26TLiqCod = httpContext.cgiGet( cmbavTliqcod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TLiqCod", AV26TLiqCod);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqfecpago_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQFECPAGO");
            GX_FocusControl = edtavLiqfecpago_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV37LiqFecPago = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37LiqFecPago", localUtil.format(AV37LiqFecPago, "99/99/9999"));
         }
         else
         {
            AV37LiqFecPago = localUtil.ctod( httpContext.cgiGet( edtavLiqfecpago_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37LiqFecPago", localUtil.format(AV37LiqFecPago, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqperdes_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQPERDES");
            GX_FocusControl = edtavLiqperdes_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV127LiqPerDes = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
         }
         else
         {
            AV127LiqPerDes = localUtil.ctod( httpContext.cgiGet( edtavLiqperdes_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqperhas_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQPERHAS");
            GX_FocusControl = edtavLiqperhas_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV128LiqPerHas = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
         }
         else
         {
            AV128LiqPerHas = localUtil.ctod( httpContext.cgiGet( edtavLiqperhas_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
         }
         AV108LiqSac = GXutil.strtobool( httpContext.cgiGet( chkavLiqsac.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108LiqSac", AV108LiqSac);
         cmbavConveniofiltro.setValue( httpContext.cgiGet( cmbavConveniofiltro.getInternalname()) );
         AV104ConvenioFiltro = httpContext.cgiGet( cmbavConveniofiltro.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV104ConvenioFiltro", AV104ConvenioFiltro);
         AV6AplicaA = httpContext.cgiGet( radavAplicaa.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AplicaA", AV6AplicaA);
         AV66LiqNombre = httpContext.cgiGet( edtavLiqnombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66LiqNombre", AV66LiqNombre);
         AV36LiqDescrip = httpContext.cgiGet( edtavLiqdescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36LiqDescrip", AV36LiqDescrip);
         cmbavLiqdepperano.setValue( httpContext.cgiGet( cmbavLiqdepperano.getInternalname()) );
         AV42LiqDepPerAno = (short)(GXutil.lval( httpContext.cgiGet( cmbavLiqdepperano.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42LiqDepPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42LiqDepPerAno), 4, 0));
         cmbavLiqdeppermes.setValue( httpContext.cgiGet( cmbavLiqdeppermes.getInternalname()) );
         AV43LiqDepPerMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbavLiqdeppermes.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43LiqDepPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43LiqDepPerMes), 2, 0));
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqdepprvfec_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQDEPPRVFEC");
            GX_FocusControl = edtavLiqdepprvfec_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV41LiqDepPrvFec = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41LiqDepPrvFec", localUtil.format(AV41LiqDepPrvFec, "99/99/99"));
         }
         else
         {
            AV41LiqDepPrvFec = localUtil.ctod( httpContext.cgiGet( edtavLiqdepprvfec_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41LiqDepPrvFec", localUtil.format(AV41LiqDepPrvFec, "99/99/99"));
         }
         AV55egresoTLiqCod = httpContext.cgiGet( edtavEgresotliqcod_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55egresoTLiqCod", AV55egresoTLiqCod);
         AV59gananciasTLiqCod = httpContext.cgiGet( edtavGananciastliqcod_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59gananciasTLiqCod", AV59gananciasTLiqCod);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqperiodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQPERIODO");
            GX_FocusControl = edtavLiqperiodo_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV58LiqPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58LiqPeriodo", localUtil.format(AV58LiqPeriodo, "99/99/9999"));
         }
         else
         {
            AV58LiqPeriodo = localUtil.ctod( httpContext.cgiGet( edtavLiqperiodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58LiqPeriodo", localUtil.format(AV58LiqPeriodo, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavMenos1liqperiodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vMENOS1LIQPERIODO");
            GX_FocusControl = edtavMenos1liqperiodo_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV79menos1LiqPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79menos1LiqPeriodo", localUtil.format(AV79menos1LiqPeriodo, "99/99/9999"));
         }
         else
         {
            AV79menos1LiqPeriodo = localUtil.ctod( httpContext.cgiGet( edtavMenos1liqperiodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79menos1LiqPeriodo", localUtil.format(AV79menos1LiqPeriodo, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavFindemesfecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vFINDEMESFECHA");
            GX_FocusControl = edtavFindemesfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV93finDeMesFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93finDeMesFecha", localUtil.format(AV93finDeMesFecha, "99/99/9999"));
         }
         else
         {
            AV93finDeMesFecha = localUtil.ctod( httpContext.cgiGet( edtavFindemesfecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93finDeMesFecha", localUtil.format(AV93finDeMesFecha, "99/99/9999"));
         }
         AV40LiqDepBanCod = httpContext.cgiGet( edtavLiqdepbancod_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqDepBanCod", AV40LiqDepBanCod);
         AV30EstadoAccion = httpContext.cgiGet( edtavEstadoaccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30EstadoAccion", AV30EstadoAccion);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavLiqfecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vLIQFECHA");
            GX_FocusControl = edtavLiqfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18LiqFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18LiqFecha", localUtil.format(AV18LiqFecha, "99/99/9999"));
         }
         else
         {
            AV18LiqFecha = localUtil.ctod( httpContext.cgiGet( edtavLiqfecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18LiqFecha", localUtil.format(AV18LiqFecha, "99/99/9999"));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLiqnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLIQNRO");
            GX_FocusControl = edtavLiqnro_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19LiqNro = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19LiqNro), 8, 0));
         }
         else
         {
            AV19LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtavLiqnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19LiqNro), 8, 0));
         }
         AV80insert = GXutil.strtobool( httpContext.cgiGet( chkavInsert.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80insert", AV80insert);
         AV81update = GXutil.strtobool( httpContext.cgiGet( chkavUpdate.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81update", AV81update);
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
      e172S2 ();
      if (returnInSub) return;
   }

   public void e172S2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_char1 = AV111mensualTLiqCod ;
      GXt_char2 = AV111mensualTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      liquidacionabm_impl.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char2, GXv_char4) ;
      liquidacionabm_impl.this.GXt_char1 = GXv_char4[0] ;
      AV111mensualTLiqCod = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV111mensualTLiqCod", AV111mensualTLiqCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vMENSUALTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV111mensualTLiqCod, ""))));
      AV80insert = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80insert", AV80insert);
      AV81update = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81update", AV81update);
      tblTableinvi_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, tblTableinvi_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTableinvi_Visible), 5, 0), true);
      GXt_char2 = AV55egresoTLiqCod ;
      GXt_char1 = AV55egresoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      liquidacionabm_impl.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char3) ;
      liquidacionabm_impl.this.GXt_char2 = GXv_char3[0] ;
      AV55egresoTLiqCod = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55egresoTLiqCod", AV55egresoTLiqCod);
      GXt_char2 = AV68vacacionesTLiqCod ;
      GXt_char1 = AV68vacacionesTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      liquidacionabm_impl.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char3) ;
      liquidacionabm_impl.this.GXt_char2 = GXv_char3[0] ;
      AV68vacacionesTLiqCod = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68vacacionesTLiqCod", AV68vacacionesTLiqCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vVACACIONESTLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV68vacacionesTLiqCod, ""))));
      GXv_int5[0] = AV83PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV32CliCod, GXv_int5) ;
      liquidacionabm_impl.this.AV83PaiCod = GXv_int5[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAICOD", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV83PaiCod), "ZZZ9")));
      cmbavLiqperano.removeAllItems();
      AV84hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 )
      {
         AV86anioHoy = (short)(GXutil.year( AV84hoy)) ;
         AV88anio = (short)(AV86anioHoy-1) ;
         cmbavLiqperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         AV85anioPasado = (short)(AV88anio-1) ;
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV85anioPasado, 4, 0)), GXutil.trim( GXutil.str( AV85anioPasado, 4, 0)), (short)(0));
         cmbavLiqperano.addItem(GXutil.trim( GXutil.str( AV86anioHoy, 4, 0)), GXutil.trim( GXutil.str( AV86anioHoy, 4, 0)), (short)(0));
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV86anioHoy, 4, 0)), GXutil.trim( GXutil.str( AV86anioHoy, 4, 0)), (short)(0));
         AV88anio = (short)(AV86anioHoy+1) ;
         cmbavLiqperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         GXt_int6 = AV19LiqNro ;
         GXv_int7[0] = GXt_int6 ;
         new web.obtnumliquidacion(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, GXv_int7) ;
         liquidacionabm_impl.this.GXt_int6 = GXv_int7[0] ;
         AV19LiqNro = GXt_int6 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19LiqNro), 8, 0));
         AV6AplicaA = httpContext.getMessage( "TODOS", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AplicaA", AV6AplicaA);
         AV126LiqFrecPag = (byte)(1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126LiqFrecPag", GXutil.str( AV126LiqFrecPag, 1, 0));
         AV146LiqTipoTarifa = "P" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV146LiqTipoTarifa", AV146LiqTipoTarifa);
         AV18LiqFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18LiqFecha", localUtil.format(AV18LiqFecha, "99/99/9999"));
         GXt_decimal8 = DecimalUtil.doubleToDec(AV44LiqPerAno) ;
         GXv_decimal9[0] = GXt_decimal8 ;
         new web.obtenerdesesionnumerico(remoteHandle, context).execute( httpContext.getMessage( "&LiqPerAno", ""), GXv_decimal9) ;
         liquidacionabm_impl.this.GXt_decimal8 = GXv_decimal9[0] ;
         AV44LiqPerAno = (short)(DecimalUtil.decToDouble(GXt_decimal8)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44LiqPerAno), 4, 0));
         AV45LiqPerMes = (byte)(GXutil.lval( new web.obtenerdesesion(remoteHandle, context).executeUdp( httpContext.getMessage( "&LiqPerMes", "")))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45LiqPerMes), 2, 0));
         if ( (0==AV44LiqPerAno) )
         {
            GXv_int5[0] = AV44LiqPerAno ;
            GXv_int10[0] = AV45LiqPerMes ;
            GXv_boolean11[0] = false ;
            new web.getperiodosigliq(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, 0, GXv_int5, GXv_int10, GXv_boolean11) ;
            liquidacionabm_impl.this.AV44LiqPerAno = GXv_int5[0] ;
            liquidacionabm_impl.this.AV45LiqPerMes = (byte)((byte)(GXv_int10[0])) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44LiqPerAno), 4, 0));
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45LiqPerMes), 2, 0));
         }
         GXv_char4[0] = AV134sola_opcion_modoPalabra ;
         new web.getparametro(remoteHandle, context).execute( AV32CliCod, httpContext.getMessage( "sola_opcion_modo", ""), GXv_char4) ;
         liquidacionabm_impl.this.AV134sola_opcion_modoPalabra = GXv_char4[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV134sola_opcion_modoPalabra", AV134sola_opcion_modoPalabra);
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vSOLA_OPCION_MODOPALABRA", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV134sola_opcion_modoPalabra, ""))));
         AV30EstadoAccion = httpContext.getMessage( "LIQUIDAR", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30EstadoAccion", AV30EstadoAccion);
         AV5LiqEstado = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5LiqEstado", GXutil.str( AV5LiqEstado, 1, 0));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQESTADO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV5LiqEstado), "9")));
         if ( (GXutil.strcmp("", AV26TLiqCod)==0) )
         {
            GXt_char2 = AV26TLiqCod ;
            GXv_char4[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV32CliCod, httpContext.getMessage( "DEF_TLIQCOD", ""), GXv_char4) ;
            liquidacionabm_impl.this.GXt_char2 = GXv_char4[0] ;
            AV26TLiqCod = GXt_char2 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TLiqCod", AV26TLiqCod);
         }
         AV38inicialLiqFecPago = AV18LiqFecha ;
         GXv_boolean11[0] = AV39hayPendientesDeCerrar ;
         new web.haypendientescierre(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, GXv_boolean11) ;
         liquidacionabm_impl.this.AV39hayPendientesDeCerrar = GXv_boolean11[0] ;
         GXt_char2 = AV40LiqDepBanCod ;
         GXv_char4[0] = GXt_char2 ;
         new web.liqgetultbancprevi(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, GXv_char4) ;
         liquidacionabm_impl.this.GXt_char2 = GXv_char4[0] ;
         AV40LiqDepBanCod = GXt_char2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqDepBanCod", AV40LiqDepBanCod);
      }
      else
      {
         AV19LiqNro = AV20LiqNroPar ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19LiqNro), 8, 0));
         GXv_char4[0] = AV36LiqDescrip ;
         GXv_date12[0] = AV18LiqFecha ;
         GXv_int13[0] = AV16LiqClase ;
         GXv_char3[0] = AV124LiqModTra ;
         GXv_int14[0] = AV126LiqFrecPag ;
         GXv_char15[0] = AV146LiqTipoTarifa ;
         GXv_char16[0] = AV26TLiqCod ;
         GXv_objcol_int17[0] = AV13LegNumero ;
         GXv_char18[0] = AV6AplicaA ;
         GXv_int19[0] = AV5LiqEstado ;
         GXv_date20[0] = AV37LiqFecPago ;
         GXv_char21[0] = AV40LiqDepBanCod ;
         GXv_date22[0] = AV41LiqDepPrvFec ;
         GXv_int10[0] = AV42LiqDepPerAno ;
         GXv_int23[0] = AV43LiqDepPerMes ;
         GXv_int5[0] = AV44LiqPerAno ;
         GXv_int24[0] = AV45LiqPerMes ;
         GXv_char25[0] = AV66LiqNombre ;
         GXv_char26[0] = AV78LiqPerPalabra ;
         GXv_date27[0] = AV127LiqPerDes ;
         GXv_date28[0] = AV128LiqPerHas ;
         new web.obtdatosliquidacion(remoteHandle, context).execute( AV11EmpCod, AV19LiqNro, GXv_char4, GXv_date12, GXv_int13, GXv_char3, GXv_int14, GXv_char15, GXv_char16, GXv_objcol_int17, GXv_char18, GXv_int19, GXv_date20, GXv_char21, GXv_date22, GXv_int10, GXv_int23, GXv_int5, GXv_int24, GXv_char25, GXv_char26, GXv_date27, GXv_date28) ;
         liquidacionabm_impl.this.AV36LiqDescrip = GXv_char4[0] ;
         liquidacionabm_impl.this.AV18LiqFecha = GXv_date12[0] ;
         liquidacionabm_impl.this.AV16LiqClase = GXv_int13[0] ;
         liquidacionabm_impl.this.AV124LiqModTra = GXv_char3[0] ;
         liquidacionabm_impl.this.AV126LiqFrecPag = GXv_int14[0] ;
         liquidacionabm_impl.this.AV146LiqTipoTarifa = GXv_char15[0] ;
         liquidacionabm_impl.this.AV26TLiqCod = GXv_char16[0] ;
         AV13LegNumero = GXv_objcol_int17[0] ;
         liquidacionabm_impl.this.AV6AplicaA = GXv_char18[0] ;
         liquidacionabm_impl.this.AV5LiqEstado = GXv_int19[0] ;
         liquidacionabm_impl.this.AV37LiqFecPago = GXv_date20[0] ;
         liquidacionabm_impl.this.AV40LiqDepBanCod = GXv_char21[0] ;
         liquidacionabm_impl.this.AV41LiqDepPrvFec = GXv_date22[0] ;
         liquidacionabm_impl.this.AV42LiqDepPerAno = GXv_int10[0] ;
         liquidacionabm_impl.this.AV43LiqDepPerMes = GXv_int23[0] ;
         liquidacionabm_impl.this.AV44LiqPerAno = GXv_int5[0] ;
         liquidacionabm_impl.this.AV45LiqPerMes = GXv_int24[0] ;
         liquidacionabm_impl.this.AV66LiqNombre = GXv_char25[0] ;
         liquidacionabm_impl.this.AV78LiqPerPalabra = GXv_char26[0] ;
         liquidacionabm_impl.this.AV127LiqPerDes = GXv_date27[0] ;
         liquidacionabm_impl.this.AV128LiqPerHas = GXv_date28[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36LiqDescrip", AV36LiqDescrip);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18LiqFecha", localUtil.format(AV18LiqFecha, "99/99/9999"));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16LiqClase", GXutil.str( AV16LiqClase, 1, 0));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQCLASE", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV16LiqClase), "9")));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV124LiqModTra", AV124LiqModTra);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126LiqFrecPag", GXutil.str( AV126LiqFrecPag, 1, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV146LiqTipoTarifa", AV146LiqTipoTarifa);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TLiqCod", AV26TLiqCod);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AplicaA", AV6AplicaA);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5LiqEstado", GXutil.str( AV5LiqEstado, 1, 0));
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLIQESTADO", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV5LiqEstado), "9")));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37LiqFecPago", localUtil.format(AV37LiqFecPago, "99/99/9999"));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40LiqDepBanCod", AV40LiqDepBanCod);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41LiqDepPrvFec", localUtil.format(AV41LiqDepPrvFec, "99/99/99"));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42LiqDepPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42LiqDepPerAno), 4, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43LiqDepPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43LiqDepPerMes), 2, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44LiqPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44LiqPerAno), 4, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45LiqPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45LiqPerMes), 2, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66LiqNombre", AV66LiqNombre);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78LiqPerPalabra", AV78LiqPerPalabra);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
         AV58LiqPeriodo = localUtil.ymdtod( AV44LiqPerAno, AV45LiqPerMes, 1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58LiqPeriodo", localUtil.format(AV58LiqPeriodo, "99/99/9999"));
         AV87updAnio = AV44LiqPerAno ;
         AV88anio = (short)(AV87updAnio-1) ;
         cmbavLiqperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         AV85anioPasado = (short)(AV88anio-1) ;
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV85anioPasado, 4, 0)), GXutil.trim( GXutil.str( AV85anioPasado, 4, 0)), (short)(0));
         cmbavLiqperano.addItem(GXutil.trim( GXutil.str( AV87updAnio, 4, 0)), GXutil.trim( GXutil.str( AV87updAnio, 4, 0)), (short)(0));
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV87updAnio, 4, 0)), GXutil.trim( GXutil.str( AV87updAnio, 4, 0)), (short)(0));
         AV88anio = (short)(AV87updAnio+1) ;
         cmbavLiqperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         cmbavLiqdepperano.addItem(GXutil.trim( GXutil.str( AV88anio, 4, 0)), GXutil.trim( GXutil.str( AV88anio, 4, 0)), (short)(0));
         AV38inicialLiqFecPago = AV18LiqFecha ;
         if ( AV5LiqEstado == 0 )
         {
            AV30EstadoAccion = httpContext.getMessage( "PENDIENTE", "") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30EstadoAccion", AV30EstadoAccion);
         }
         else
         {
            AV30EstadoAccion = httpContext.getMessage( "LIQUIDAR", "") ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30EstadoAccion", AV30EstadoAccion);
         }
         if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "UPD", "")) != 0 )
         {
            edtavLiqfecpago_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqfecpago_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqfecpago_Enabled), 5, 0), true);
            edtavLiqnombre_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnombre_Enabled), 5, 0), true);
            edtavLiqdepbancod_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqdepbancod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdepbancod_Enabled), 5, 0), true);
            Combo_liqdepbancod_Enabled = false ;
            ucCombo_liqdepbancod.sendProperty(context, sPrefix, false, Combo_liqdepbancod_Internalname, "Enabled", GXutil.booltostr( Combo_liqdepbancod_Enabled));
            edtavLiqdepprvfec_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqdepprvfec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdepprvfec_Enabled), 5, 0), true);
            cmbavLiqdepperano.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdepperano.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqdepperano.getEnabled(), 5, 0), true);
            cmbavLiqdeppermes.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdeppermes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqdeppermes.getEnabled(), 5, 0), true);
            cmbavLiqperano.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqperano.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqperano.getEnabled(), 5, 0), true);
            cmbavLiqpermes.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqpermes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqpermes.getEnabled(), 5, 0), true);
            edtavLiqdescrip_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdescrip_Enabled), 5, 0), true);
            edtavLiqfecha_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqfecha_Enabled), 5, 0), true);
            cmbavTliqcod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTliqcod.getEnabled(), 5, 0), true);
            radavAplicaa.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, radavAplicaa.getInternalname(), "Enabled", GXutil.ltrimstr( radavAplicaa.getEnabled(), 5, 0), true);
            Combo_legnumero_Enabled = false ;
            ucCombo_legnumero.sendProperty(context, sPrefix, false, Combo_legnumero_Internalname, "Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
            chkavLiqsac.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavLiqsac.getInternalname(), "Enabled", GXutil.ltrimstr( chkavLiqsac.getEnabled(), 5, 0), true);
            cmbavConveniofiltro.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavConveniofiltro.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavConveniofiltro.getEnabled(), 5, 0), true);
            Combo_seccodigo_Enabled = false ;
            ucCombo_seccodigo.sendProperty(context, sPrefix, false, Combo_seccodigo_Internalname, "Enabled", GXutil.booltostr( Combo_seccodigo_Enabled));
            Combo_puestocodigo_Enabled = false ;
            ucCombo_puestocodigo.sendProperty(context, sPrefix, false, Combo_puestocodigo_Internalname, "Enabled", GXutil.booltostr( Combo_puestocodigo_Enabled));
            Combo_succodigo_Enabled = false ;
            ucCombo_succodigo.sendProperty(context, sPrefix, false, Combo_succodigo_Internalname, "Enabled", GXutil.booltostr( Combo_succodigo_Enabled));
            if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "DSP", "")) == 0 )
            {
               bttBtnenter_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
               divTablesplittedlegnumero_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedlegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegnumero_Visible), 5, 0), true);
               radavAplicaa.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, radavAplicaa.getInternalname(), "Visible", GXutil.ltrimstr( radavAplicaa.getVisible(), 5, 0), true);
            }
         }
         else
         {
            edtavLiqfecha_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqfecha_Enabled), 5, 0), true);
            cmbavLiqperano.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqperano.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqperano.getEnabled(), 5, 0), true);
            cmbavLiqpermes.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqpermes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqpermes.getEnabled(), 5, 0), true);
            cmbavTliqcod.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTliqcod.getEnabled(), 5, 0), true);
            radavAplicaa.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, radavAplicaa.getInternalname(), "Enabled", GXutil.ltrimstr( radavAplicaa.getEnabled(), 5, 0), true);
            Combo_legnumero_Enabled = false ;
            ucCombo_legnumero.sendProperty(context, sPrefix, false, Combo_legnumero_Internalname, "Enabled", GXutil.booltostr( Combo_legnumero_Enabled));
         }
      }
      /* Execute user subroutine: 'COMBO MODOS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO FRECUENCIAS' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO TIPOS' */
      S132 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 )
      {
         /* Execute user subroutine: 'CALCULAR PERIODO' */
         S142 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'DEFAULT FECHAS PAGO Y PREVISIONAL' */
         S152 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
         S162 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'VISIBILIDAD SAC' */
         S172 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'ARMAR NOMBRE' */
         S182 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'COMBO TARIFAS' */
      S192 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD LEGAJOS' */
      S202 ();
      if (returnInSub) return;
      GXt_int6 = AV32CliCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
      liquidacionabm_impl.this.GXt_int6 = GXv_int7[0] ;
      AV32CliCod = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32CliCod), 6, 0));
      edtavLiqdepbancod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqdepbancod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdepbancod_Visible), 5, 0), true);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29 = AV10DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons30[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons30) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons30[0] ;
      AV10DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29;
      /* Execute user subroutine: 'LOADCOMBOCONVECODIGO' */
      S212 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOCATCODIGO' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOSECCODIGO' */
      S232 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOPUESTOCODIGO' */
      S242 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOSUCCODIGO' */
      S252 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLIQDEPBANCOD' */
      S272 ();
      if (returnInSub) return;
      edtavEstadoaccion_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavEstadoaccion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEstadoaccion_Visible), 5, 0), true);
      edtavLiqfecha_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqfecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqfecha_Visible), 5, 0), true);
      edtavLiqnro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqnro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnro_Visible), 5, 0), true);
      chkavInsert.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavInsert.getInternalname(), "Visible", GXutil.ltrimstr( chkavInsert.getVisible(), 5, 0), true);
      chkavUpdate.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUpdate.getInternalname(), "Visible", GXutil.ltrimstr( chkavUpdate.getVisible(), 5, 0), true);
      GXt_char2 = AV65quincenaTLiqCod ;
      GXt_char1 = AV65quincenaTLiqCod ;
      GXv_char26[0] = GXt_char1 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char26) ;
      liquidacionabm_impl.this.GXt_char1 = GXv_char26[0] ;
      GXv_char25[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char25) ;
      liquidacionabm_impl.this.GXt_char2 = GXv_char25[0] ;
      AV65quincenaTLiqCod = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65quincenaTLiqCod", AV65quincenaTLiqCod);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQUINCENATLIQCOD", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV65quincenaTLiqCod, ""))));
      /* Execute user subroutine: 'SELECCIONAR CONVENIOS VISIBLE' */
      S282 ();
      if (returnInSub) return;
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e182S2 ();
      if (returnInSub) return;
   }

   public void e182S2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      GXv_boolean11[0] = AV95actPendHay ;
      new web.hayactualizacionpendiente(remoteHandle, context).execute( AV32CliCod, GXv_boolean11) ;
      liquidacionabm_impl.this.AV95actPendHay = GXv_boolean11[0] ;
      if ( ! AV95actPendHay )
      {
         /* Execute user subroutine: 'DO ACTION ENTER' */
         S292 ();
         if (returnInSub) return;
      }
      else
      {
         Dvelop_confirmpanel_enter_Title = httpContext.getMessage( "ATENCION!", "") ;
         ucDvelop_confirmpanel_enter.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_enter_Internalname, "Title", Dvelop_confirmpanel_enter_Title);
         Dvelop_confirmpanel_enter_Confirmationtext = httpContext.getMessage( "Hay actualizaciones pendientes de aplicar. ¿Igualmente desea proceder con la liquidación?", "") ;
         ucDvelop_confirmpanel_enter.sendProperty(context, sPrefix, false, Dvelop_confirmpanel_enter_Internalname, "ConfirmationText", Dvelop_confirmpanel_enter_Confirmationtext);
         this.executeUsercontrolMethod(sPrefix, false, "DVELOP_CONFIRMPANEL_ENTERContainer", "Confirm", "", new Object[] {});
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
      cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
   }

   public void e162S2( )
   {
      /* Dvelop_confirmpanel_enter_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_enter_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION ENTER' */
         S292 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
      cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
   }

   public void e152S2( )
   {
      /* Combo_succodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV101SucCodigo.fromJSonString(Combo_succodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV101SucCodigo", AV101SucCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void e142S2( )
   {
      /* Combo_puestocodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV100PuestoCodigo.fromJSonString(Combo_puestocodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV100PuestoCodigo", AV100PuestoCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void e132S2( )
   {
      /* Combo_seccodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV24SecCodigo.fromJSonString(Combo_seccodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOPUESTOCODIGO' */
      S242 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV24SecCodigo", AV24SecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV102PuestoCodigo_Data", AV102PuestoCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV100PuestoCodigo", AV100PuestoCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void e122S2( )
   {
      /* Combo_catcodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV7CatCodigo.fromJSonString(Combo_catcodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7CatCodigo", AV7CatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void e112S2( )
   {
      /* Combo_convecodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV82ConveCodigo.fromJSonString(Combo_convecodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOCATCODIGO' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV82ConveCodigo", AV82ConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV8CatCodigo_Data", AV8CatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7CatCodigo", AV7CatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void S292( )
   {
      /* 'DO ACTION ENTER' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, "0") ;
      AV63confirmarRespuesta = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63confirmarRespuesta", AV63confirmarRespuesta);
      if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "DSP", "")) == 0 )
      {
         /* Execute user subroutine: 'IR A WW' */
         S302 ();
         if (returnInSub) return;
      }
      else
      {
         AV12error = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&modo ", "")+AV23Modo+httpContext.getMessage( " &TLiqCod ", "")+GXutil.trim( AV26TLiqCod)+httpContext.getMessage( " &AplicaA ", "")+GXutil.trim( AV6AplicaA)) ;
         if ( ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 ) && (GXutil.strcmp("", AV66LiqNombre)==0) )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar descripción de la liquidación", "")) ;
            AV12error = true ;
         }
         if ( ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 ) && ( ( GXutil.strcmp(AV26TLiqCod, AV55egresoTLiqCod) == 0 ) || ( GXutil.strcmp(AV26TLiqCod, AV68vacacionesTLiqCod) == 0 ) ) && ( GXutil.strcmp(AV6AplicaA, httpContext.getMessage( "TODOS", "")) == 0 ) )
         {
            AV12error = true ;
            if ( GXutil.strcmp(AV26TLiqCod, AV55egresoTLiqCod) == 0 )
            {
               new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Para liquidación de egreso debe seleccionar legajos específicos", "")) ;
            }
            else
            {
               new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Para liquidación de adelanto de vacaciones debe seleccionar legajos específicos", "")) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "especificos", "")) ;
         }
         else
         {
            if ( GXutil.strcmp(AV26TLiqCod, AV55egresoTLiqCod) == 0 )
            {
               GXv_boolean11[0] = AV57egresoOK ;
               new web.egresovalidar(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV13LegNumero, GXv_boolean11) ;
               liquidacionabm_impl.this.AV57egresoOK = GXv_boolean11[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&egresoOK ", "")+GXutil.trim( GXutil.booltostr( AV57egresoOK))+httpContext.getMessage( " &LegNumero.count ", "")+GXutil.trim( GXutil.str( AV13LegNumero.size(), 9, 0))) ;
               if ( ! AV57egresoOK )
               {
                  AV12error = true ;
                  new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Para liquidación de egreso los legajos deben tener fecha de egreso", "")) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "error fec egr", "")) ;
               }
               else
               {
               }
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, "1") ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18LiqFecha)) )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar la fecha de liquidacion", "")) ;
            AV12error = true ;
         }
         if ( ! AV12error )
         {
            GXv_boolean11[0] = AV12error ;
            GXv_int7[0] = AV54procesandoLiqNro ;
            GXv_char26[0] = AV92procesandoERror ;
            new web.hayalgunaliquidacionprocesando(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, 0, AV13LegNumero, GXv_boolean11, GXv_int7, GXv_char26) ;
            liquidacionabm_impl.this.AV12error = GXv_boolean11[0] ;
            liquidacionabm_impl.this.AV54procesandoLiqNro = GXv_int7[0] ;
            liquidacionabm_impl.this.AV92procesandoERror = GXv_char26[0] ;
            if ( AV12error )
            {
               new web.alert(remoteHandle, context).execute( "error", GXutil.trim( AV92procesandoERror)+" "+GXutil.trim( GXutil.str( AV54procesandoLiqNro, 8, 0))) ;
            }
         }
         AV62confirmar_LegNumero.clear();
         if ( ! AV12error && ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 ) )
         {
            if ( GXutil.strcmp(AV6AplicaA, httpContext.getMessage( "TODOS", "")) == 0 )
            {
               GXv_objcol_int17[0] = AV13LegNumero ;
               new web.getlegajosporfiltros(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV19LiqNro, AV124LiqModTra, AV126LiqFrecPag, AV146LiqTipoTarifa, AV58LiqPeriodo, AV26TLiqCod, AV104ConvenioFiltro, AV82ConveCodigo, AV7CatCodigo, AV24SecCodigo, AV100PuestoCodigo, AV101SucCodigo, GXv_objcol_int17) ;
               AV13LegNumero = GXv_objcol_int17[0] ;
            }
            AV105l = (short)(1) ;
            while ( AV105l <= AV13LegNumero.size() )
            {
               if ( ((Number) AV13LegNumero.elementAt(-1+AV105l)).intValue() == 0 )
               {
                  AV13LegNumero.removeItem(AV105l);
               }
               else
               {
                  AV105l = (short)(AV105l+1) ;
               }
            }
            if ( AV13LegNumero.size() == 0 )
            {
               if ( GXutil.strcmp(AV6AplicaA, httpContext.getMessage( "TODOS", "")) == 0 )
               {
                  new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "No hay legajos que apliquen a los filtros seleccionados", "")) ;
               }
               else
               {
                  new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar al menos 1 Legajo", "")) ;
               }
               AV12error = true ;
            }
            GXv_boolean11[0] = AV50duplica ;
            GXv_int7[0] = AV51dupliLiqnro ;
            GXv_objcol_int17[0] = AV62confirmar_LegNumero ;
            new web.duplicaliquidacion(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV16LiqClase, localUtil.ymdtod( AV44LiqPerAno, AV45LiqPerMes, 1), AV13LegNumero, AV26TLiqCod, GXv_boolean11, GXv_int7, GXv_objcol_int17) ;
            liquidacionabm_impl.this.AV50duplica = GXv_boolean11[0] ;
            liquidacionabm_impl.this.AV51dupliLiqnro = GXv_int7[0] ;
            AV62confirmar_LegNumero = GXv_objcol_int17[0] ;
            if ( AV50duplica )
            {
               AV12error = true ;
               AV28mensaje = httpContext.getMessage( "La Liquidación duplica con liquidación anterior", "") ;
               new web.alert(remoteHandle, context).execute( "error", AV28mensaje) ;
               AV13LegNumero.clear();
            }
            else
            {
            }
         }
         else
         {
         }
         if ( ! AV12error && ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 ) )
         {
            AV27LegNoAplican.clear();
            AV76LegNoAplican2.clear();
            GXv_objcol_int17[0] = AV27LegNoAplican ;
            GXv_objcol_int31[0] = AV76LegNoAplican2 ;
            new web.getlegajosnoaplican(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV26TLiqCod, AV58LiqPeriodo, AV62confirmar_LegNumero, GXv_objcol_int17, GXv_objcol_int31) ;
            AV27LegNoAplican = GXv_objcol_int17[0] ;
            AV76LegNoAplican2 = GXv_objcol_int31[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&LegNoAplican count ", "")+GXutil.trim( GXutil.str( AV27LegNoAplican.size(), 9, 0))+httpContext.getMessage( " &LegNoAplican2 ", "")+GXutil.trim( GXutil.str( AV76LegNoAplican2.size(), 9, 0))) ;
            if ( ( AV27LegNoAplican.size() > 0 ) || ( AV76LegNoAplican2.size() > 0 ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic1", "")) ;
               if ( AV27LegNoAplican.size() > 0 )
               {
                  AV12error = true ;
                  AV13LegNumero.clear();
                  if ( AV27LegNoAplican.size() > 1 )
                  {
                     AV28mensaje = GXutil.trim( GXutil.str( AV27LegNoAplican.size(), 9, 0)) + httpContext.getMessage( " legajos ", "") ;
                  }
                  else
                  {
                     AV28mensaje = httpContext.getMessage( "El legajo ", "") ;
                     GXt_char2 = AV28mensaje ;
                     GXv_char26[0] = GXt_char2 ;
                     new web.getlegidnomape(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, ((Number) AV27LegNoAplican.elementAt(-1+1)).intValue(), GXv_char26) ;
                     liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
                     AV28mensaje += GXt_char2 ;
                  }
                  if ( AV27LegNoAplican.size() > 1 )
                  {
                     AV28mensaje += httpContext.getMessage( " no aplican a clase de liquidación", "") ;
                  }
                  else
                  {
                     AV28mensaje += httpContext.getMessage( " no aplica a clase de liquidación", "") ;
                  }
                  new web.alert(remoteHandle, context).execute( "error", AV28mensaje) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic2", "")) ;
               if ( AV76LegNoAplican2.size() > 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic3", "")) ;
                  AV12error = true ;
                  AV13LegNumero.clear();
                  if ( AV76LegNoAplican2.size() > 1 )
                  {
                     AV28mensaje = GXutil.trim( GXutil.str( AV76LegNoAplican2.size(), 9, 0)) + httpContext.getMessage( " legajos ", "") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic4", "")) ;
                  }
                  else
                  {
                     AV28mensaje = httpContext.getMessage( "El legajo ", "") ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic5", "")) ;
                     GXt_char2 = AV28mensaje ;
                     GXv_char26[0] = GXt_char2 ;
                     new web.getlegidnomape(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, ((Number) AV76LegNoAplican2.elementAt(-1+1)).intValue(), GXv_char26) ;
                     liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
                     AV28mensaje += GXt_char2 ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic6", "")) ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic7", "")) ;
                  if ( AV76LegNoAplican2.size() > 1 )
                  {
                     AV28mensaje += httpContext.getMessage( " tienen la liquidación anterior faltante", "") ;
                  }
                  else
                  {
                     AV28mensaje += httpContext.getMessage( " tiene la liquidación anterior faltante", "") ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic8", "")) ;
                  new web.alert(remoteHandle, context).execute( "error", AV28mensaje) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic9", "")) ;
               }
            }
            else
            {
               if ( ( GXutil.strcmp(AV146LiqTipoTarifa, "H") == 0 ) && ( GXutil.strcmp(AV26TLiqCod, AV52aguiTLiqCod) != 0 ) && ( GXutil.strcmp(AV26TLiqCod, AV68vacacionesTLiqCod) != 0 ) )
               {
                  AV27LegNoAplican.clear();
                  AV76LegNoAplican2.clear();
                  AV28mensaje = "" ;
                  GXv_objcol_int31[0] = AV27LegNoAplican ;
                  GXv_objcol_int17[0] = AV76LegNoAplican2 ;
                  new web.getlegajosfaltaagenda(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV19LiqNro, new web.getparametro(remoteHandle, context).executeUdp( AV32CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( )), "", AV26TLiqCod, AV62confirmar_LegNumero, AV58LiqPeriodo, false, AV127LiqPerDes, AV128LiqPerHas, GXv_objcol_int31, GXv_objcol_int17) ;
                  AV27LegNoAplican = GXv_objcol_int31[0] ;
                  AV76LegNoAplican2 = GXv_objcol_int17[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "2 &LegNoAplican count ", "")+GXutil.trim( GXutil.str( AV27LegNoAplican.size(), 9, 0))) ;
                  if ( AV27LegNoAplican.size() > 0 )
                  {
                     AV12error = true ;
                     AV13LegNumero.clear();
                     if ( AV27LegNoAplican.size() > 1 )
                     {
                        AV28mensaje = httpContext.getMessage( "Debe informar horas trabajadas en el periodo para los siguientes legajos: ", "") ;
                     }
                     else
                     {
                        AV28mensaje = httpContext.getMessage( "Debe informar horas trabajadas en el periodo para el siguiente legajo: ", "") ;
                     }
                     AV29i = (short)(1) ;
                     while ( AV29i <= AV27LegNoAplican.size() )
                     {
                        GXt_char2 = AV28mensaje ;
                        GXv_char26[0] = GXt_char2 ;
                        new web.getlegidnomape(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, ((Number) AV27LegNoAplican.elementAt(-1+AV29i)).intValue(), GXv_char26) ;
                        liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
                        AV28mensaje += GXt_char2 ;
                        if ( AV29i != AV27LegNoAplican.size() )
                        {
                           AV28mensaje += ", " ;
                        }
                        AV29i = (short)(AV29i+1) ;
                     }
                     new web.alert(remoteHandle, context).execute( "error", AV28mensaje) ;
                  }
               }
               if ( GXutil.strcmp(AV26TLiqCod, AV68vacacionesTLiqCod) == 0 )
               {
                  AV71AdelVacLegNoAplican.clear();
                  AV28mensaje = "" ;
                  GXt_char2 = AV72adelVacConCodigo ;
                  GXt_char1 = AV72adelVacConCodigo ;
                  GXv_char26[0] = GXt_char1 ;
                  new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char26) ;
                  liquidacionabm_impl.this.GXt_char1 = GXv_char26[0] ;
                  GXv_char25[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char25) ;
                  liquidacionabm_impl.this.GXt_char2 = GXv_char25[0] ;
                  AV72adelVacConCodigo = GXt_char2 ;
                  GXt_char2 = AV77adelVacMesActualConcodigo ;
                  GXt_char1 = AV77adelVacMesActualConcodigo ;
                  GXv_char26[0] = GXt_char1 ;
                  new web.concepto_adelantovacamesactual_codigoparam(remoteHandle, context).execute( GXv_char26) ;
                  liquidacionabm_impl.this.GXt_char1 = GXv_char26[0] ;
                  GXv_char25[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char25) ;
                  liquidacionabm_impl.this.GXt_char2 = GXv_char25[0] ;
                  AV77adelVacMesActualConcodigo = GXt_char2 ;
                  GXv_objcol_int31[0] = AV71AdelVacLegNoAplican ;
                  GXv_objcol_int17[0] = AV76LegNoAplican2 ;
                  new web.getlegajosfaltaagenda(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV19LiqNro, AV72adelVacConCodigo, AV77adelVacMesActualConcodigo, AV26TLiqCod, AV62confirmar_LegNumero, AV58LiqPeriodo, true, AV127LiqPerDes, AV128LiqPerHas, GXv_objcol_int31, GXv_objcol_int17) ;
                  AV71AdelVacLegNoAplican = GXv_objcol_int31[0] ;
                  AV76LegNoAplican2 = GXv_objcol_int17[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "2 &AdelVacLegNoAplican count ", "")+GXutil.trim( GXutil.str( AV71AdelVacLegNoAplican.size(), 9, 0))) ;
                  if ( ( AV71AdelVacLegNoAplican.size() > 0 ) || ( AV76LegNoAplican2.size() > 0 ) )
                  {
                     AV12error = true ;
                     AV13LegNumero.clear();
                     if ( AV71AdelVacLegNoAplican.size() > 0 )
                     {
                        if ( AV71AdelVacLegNoAplican.size() > 1 )
                        {
                           AV28mensaje = httpContext.getMessage( "Debe informar novedad concepto de \\\"Adelanto de vacaciones mes próximo\\\" para los siguientes legajos: ", "") ;
                        }
                        else
                        {
                           AV28mensaje = httpContext.getMessage( "Debe informar novedad concepto de \\\"Adelanto de vacaciones mes próximo\\\" para el siguiente legajo: ", "") ;
                        }
                        AV29i = (short)(1) ;
                        while ( AV29i <= AV71AdelVacLegNoAplican.size() )
                        {
                           GXt_char2 = AV28mensaje ;
                           GXv_char26[0] = GXt_char2 ;
                           new web.getlegidnomape(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, ((Number) AV71AdelVacLegNoAplican.elementAt(-1+AV29i)).intValue(), GXv_char26) ;
                           liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
                           AV28mensaje += GXt_char2 ;
                           if ( AV29i != AV71AdelVacLegNoAplican.size() )
                           {
                              AV28mensaje += ", " ;
                           }
                           AV29i = (short)(AV29i+1) ;
                        }
                        new web.alert(remoteHandle, context).execute( "error", AV28mensaje) ;
                     }
                     if ( AV76LegNoAplican2.size() > 0 )
                     {
                        if ( AV76LegNoAplican2.size() > 1 )
                        {
                           AV28mensaje = httpContext.getMessage( "Para liquidar adelanto de vacaciones de mes próximo debe antes liquidar el mes completo en los siguientes legajos: ", "") ;
                        }
                        else
                        {
                           AV28mensaje = httpContext.getMessage( "Para liquidar adelanto de vacaciones de mes próximo debe antes liquidar el mes completo en el siguiente legajo: ", "") ;
                        }
                        AV29i = (short)(1) ;
                        while ( AV29i <= AV76LegNoAplican2.size() )
                        {
                           GXt_char2 = AV28mensaje ;
                           GXv_char26[0] = GXt_char2 ;
                           new web.getlegidnomape(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, ((Number) AV76LegNoAplican2.elementAt(-1+AV29i)).intValue(), GXv_char26) ;
                           liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
                           AV28mensaje += GXt_char2 ;
                           if ( AV29i != AV76LegNoAplican2.size() )
                           {
                              AV28mensaje += ", " ;
                           }
                           AV29i = (short)(AV29i+1) ;
                        }
                        new web.alert(remoteHandle, context).execute( "error", AV28mensaje) ;
                     }
                  }
               }
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "noaplic10", "")) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, "2") ;
         if ( ! AV12error )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, "3") ;
            if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "UPD", "")) == 0 )
            {
               new web.modificaliquidacioncabecera(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV20LiqNroPar, AV36LiqDescrip, AV37LiqFecPago, AV44LiqPerAno, AV45LiqPerMes, AV41LiqDepPrvFec, AV40LiqDepBanCod, AV42LiqDepPerAno, AV43LiqDepPerMes, AV66LiqNombre) ;
               GXv_char26[0] = "" ;
               new web.resetearecibos(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV20LiqNroPar, 0, GXv_char26) ;
               /* Execute user subroutine: 'IR A WW' */
               S302 ();
               if (returnInSub) return;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, "4") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&confirmar_LegNumero ", "")+AV62confirmar_LegNumero.toJSonString(false)) ;
               AV64window.setHeight( 800 );
               AV89websession.setValue(httpContext.getMessage( "&confirmar_LegNumero", ""), AV62confirmar_LegNumero.toJSonString(false));
               /* Window Datatype Object Property */
               AV64window.setUrl( formatLink("web.confirmarliquidacion", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV32CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV58LiqPeriodo)),GXutil.URLEncode(GXutil.rtrim(AV26TLiqCod)),GXutil.URLEncode(GXutil.rtrim(AV63confirmarRespuesta)),GXutil.URLEncode(GXutil.rtrim(AV66LiqNombre))}, new String[] {"CliCod","EmpCod","LiqPeriodo","TLiqCod","Respuesta","LiqNombre"})  );
               AV64window.setReturnParms(new Object[] {"AV32CliCod","AV11EmpCod","AV58LiqPeriodo","AV26TLiqCod","AV63confirmarRespuesta",});
               httpContext.newWindow(AV64window);
               httpContext.doAjaxRefreshCmp(sPrefix);
            }
         }
      }
   }

   public void S272( )
   {
      /* 'LOADCOMBOLIQDEPBANCOD' Routine */
      returnInSub = false ;
      /* Using cursor H002S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = H002S2_A3CliCod[0] ;
         A1EmpCod = H002S2_A1EmpCod[0] ;
         A1966EmpBanCod = H002S2_A1966EmpBanCod[0] ;
         A1967EmpBanDescrip = H002S2_A1967EmpBanDescrip[0] ;
         A1967EmpBanDescrip = H002S2_A1967EmpBanDescrip[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1966EmpBanCod );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1967EmpBanDescrip );
         AV46LiqDepBanCod_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      Combo_liqdepbancod_Selectedvalue_set = AV40LiqDepBanCod ;
      ucCombo_liqdepbancod.sendProperty(context, sPrefix, false, Combo_liqdepbancod_Internalname, "SelectedValue_set", Combo_liqdepbancod_Selectedvalue_set);
   }

   public void S262( )
   {
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "LoadComboLegNumero 1", "")) ;
      AV14LegNumero_Data.clear();
      AV79menos1LiqPeriodo = GXutil.dadd( AV58LiqPeriodo, (-1)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79menos1LiqPeriodo", localUtil.format(AV79menos1LiqPeriodo, "99/99/9999"));
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A937LegConveCodigo ,
                                           AV82ConveCodigo ,
                                           A939LegCatCodigo ,
                                           AV7CatCodigo ,
                                           A1579LegSecCodigo ,
                                           AV24SecCodigo ,
                                           A1578LegPuesCodigo ,
                                           AV100PuestoCodigo ,
                                           A1577LegSucCodigo ,
                                           AV101SucCodigo ,
                                           AV26TLiqCod ,
                                           AV55egresoTLiqCod ,
                                           Integer.valueOf(AV82ConveCodigo.size()) ,
                                           AV104ConvenioFiltro ,
                                           Integer.valueOf(AV7CatCodigo.size()) ,
                                           Integer.valueOf(AV24SecCodigo.size()) ,
                                           Integer.valueOf(AV100PuestoCodigo.size()) ,
                                           Integer.valueOf(AV101SucCodigo.size()) ,
                                           A244LegFecEgreso ,
                                           AV79menos1LiqPeriodo ,
                                           AV93finDeMesFecha ,
                                           A245LegFecIngreso ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV32CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Byte.valueOf(A1818LegEstado) ,
                                           Byte.valueOf(A235LegClase) ,
                                           Byte.valueOf(AV126LiqFrecPag) ,
                                           A2404LegModTra ,
                                           AV124LiqModTra ,
                                           A2417LegTipoTarifa ,
                                           AV146LiqTipoTarifa } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      /* Using cursor H002S3 */
      pr_default.execute(1, new Object[] {AV93finDeMesFecha, Integer.valueOf(AV32CliCod), Short.valueOf(AV11EmpCod), Byte.valueOf(AV126LiqFrecPag), AV124LiqModTra, AV146LiqTipoTarifa, AV79menos1LiqPeriodo, AV93finDeMesFecha});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = H002S3_A3CliCod[0] ;
         A1EmpCod = H002S3_A1EmpCod[0] ;
         A1818LegEstado = H002S3_A1818LegEstado[0] ;
         A235LegClase = H002S3_A235LegClase[0] ;
         A2404LegModTra = H002S3_A2404LegModTra[0] ;
         A2417LegTipoTarifa = H002S3_A2417LegTipoTarifa[0] ;
         A1577LegSucCodigo = H002S3_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = H002S3_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = H002S3_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = H002S3_n1578LegPuesCodigo[0] ;
         A1579LegSecCodigo = H002S3_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = H002S3_n1579LegSecCodigo[0] ;
         A939LegCatCodigo = H002S3_A939LegCatCodigo[0] ;
         n939LegCatCodigo = H002S3_n939LegCatCodigo[0] ;
         A937LegConveCodigo = H002S3_A937LegConveCodigo[0] ;
         n937LegConveCodigo = H002S3_n937LegConveCodigo[0] ;
         A245LegFecIngreso = H002S3_A245LegFecIngreso[0] ;
         A244LegFecEgreso = H002S3_A244LegFecEgreso[0] ;
         n244LegFecEgreso = H002S3_n244LegFecEgreso[0] ;
         A6LegNumero = H002S3_A6LegNumero[0] ;
         A250LegIdNomApe = H002S3_A250LegIdNomApe[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV14LegNumero_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      Combo_legnumero_Selectedvalue_set = AV13LegNumero.toJSonString(false) ;
      ucCombo_legnumero.sendProperty(context, sPrefix, false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "LoadComboLegNumero &LegNumero_Data ", "")+GXutil.trim( GXutil.str( AV14LegNumero_Data.size(), 9, 0))) ;
      if ( AV14LegNumero_Data.size() == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "LoadComboLegNumero noneEeee\"", "")) ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( "" );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( "" );
         AV14LegNumero_Data.add(AV9Combo_DataItem, 0);
      }
      AV105l = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "LoadComboLegNumero 4", "")) ;
      while ( AV105l <= AV13LegNumero.size() )
      {
         AV106validoEs = false ;
         AV158GXV1 = 1 ;
         while ( AV158GXV1 <= AV14LegNumero_Data.size() )
         {
            AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV14LegNumero_Data.elementAt(-1+AV158GXV1));
            new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "LoadComboLegNumero 5", "")) ;
            if ( CommonUtil.decimalVal( AV9Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Id(), ".").doubleValue() == ((Number) AV13LegNumero.elementAt(-1+AV105l)).intValue() )
            {
               AV106validoEs = true ;
               if (true) break;
            }
            AV158GXV1 = (int)(AV158GXV1+1) ;
         }
         if ( AV106validoEs )
         {
            AV105l = (short)(AV105l+1) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "LoadComboLegNumero 6", "")) ;
            AV13LegNumero.removeItem(AV105l);
         }
      }
   }

   public void S252( )
   {
      /* 'LOADCOMBOSUCCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor H002S4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A3CliCod = H002S4_A3CliCod[0] ;
         A1EmpCod = H002S4_A1EmpCod[0] ;
         A1243SucCodigo = H002S4_A1243SucCodigo[0] ;
         A1244SucDescrip = H002S4_A1244SucDescrip[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1243SucCodigo );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1244SucDescrip );
         AV103SucCodigo_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_succodigo_Selectedvalue_set = AV101SucCodigo.toJSonString(false) ;
      ucCombo_succodigo.sendProperty(context, sPrefix, false, Combo_succodigo_Internalname, "SelectedValue_set", Combo_succodigo_Selectedvalue_set);
   }

   public void S242( )
   {
      /* 'LOADCOMBOPUESTOCODIGO' Routine */
      returnInSub = false ;
      AV102PuestoCodigo_Data.clear();
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV24SecCodigo ,
                                           Integer.valueOf(AV24SecCodigo.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV32CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor H002S5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV32CliCod)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A3CliCod = H002S5_A3CliCod[0] ;
         A13SecCodigo = H002S5_A13SecCodigo[0] ;
         A1240PuestoCodigo = H002S5_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = H002S5_A1241PuestoDescrip[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1240PuestoCodigo );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1241PuestoDescrip );
         AV102PuestoCodigo_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
      Combo_puestocodigo_Selectedvalue_set = AV100PuestoCodigo.toJSonString(false) ;
      ucCombo_puestocodigo.sendProperty(context, sPrefix, false, Combo_puestocodigo_Internalname, "SelectedValue_set", Combo_puestocodigo_Selectedvalue_set);
      AV105l = (short)(1) ;
      while ( AV105l <= AV100PuestoCodigo.size() )
      {
         AV106validoEs = false ;
         AV161GXV2 = 1 ;
         while ( AV161GXV2 <= AV102PuestoCodigo_Data.size() )
         {
            AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV102PuestoCodigo_Data.elementAt(-1+AV161GXV2));
            if ( GXutil.strcmp(GXutil.trim( AV9Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Id()), (String)AV100PuestoCodigo.elementAt(-1+AV105l)) == 0 )
            {
               AV106validoEs = true ;
               if (true) break;
            }
            AV161GXV2 = (int)(AV161GXV2+1) ;
         }
         if ( AV106validoEs )
         {
            AV105l = (short)(AV105l+1) ;
         }
         else
         {
            AV100PuestoCodigo.removeItem(AV105l);
         }
      }
   }

   public void S232( )
   {
      /* 'LOADCOMBOSECCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor H002S6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV32CliCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A3CliCod = H002S6_A3CliCod[0] ;
         A13SecCodigo = H002S6_A13SecCodigo[0] ;
         A329SecDescrip = H002S6_A329SecDescrip[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A13SecCodigo );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A329SecDescrip );
         AV25SecCodigo_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(4);
      }
      pr_default.close(4);
      Combo_seccodigo_Selectedvalue_set = AV24SecCodigo.toJSonString(false) ;
      ucCombo_seccodigo.sendProperty(context, sPrefix, false, Combo_seccodigo_Internalname, "SelectedValue_set", Combo_seccodigo_Selectedvalue_set);
   }

   public void S222( )
   {
      /* 'LOADCOMBOCATCODIGO' Routine */
      returnInSub = false ;
      AV8CatCodigo_Data.clear();
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A1565CliConvenio ,
                                           AV82ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV32CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV83PaiCod) ,
                                           Byte.valueOf(A1838CatClase) ,
                                           Byte.valueOf(AV126LiqFrecPag) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE
                                           }
      });
      /* Using cursor H002S7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV83PaiCod), Byte.valueOf(AV126LiqFrecPag)});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A3CliCod = H002S7_A3CliCod[0] ;
         A1564CliPaiConve = H002S7_A1564CliPaiConve[0] ;
         A1838CatClase = H002S7_A1838CatClase[0] ;
         A1565CliConvenio = H002S7_A1565CliConvenio[0] ;
         A8CatCodigo = H002S7_A8CatCodigo[0] ;
         A123CatDescrip = H002S7_A123CatDescrip[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A8CatCodigo );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A123CatDescrip );
         AV8CatCodigo_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(5);
      }
      pr_default.close(5);
      Combo_catcodigo_Selectedvalue_set = AV7CatCodigo.toJSonString(false) ;
      ucCombo_catcodigo.sendProperty(context, sPrefix, false, Combo_catcodigo_Internalname, "SelectedValue_set", Combo_catcodigo_Selectedvalue_set);
      AV105l = (short)(1) ;
      while ( AV105l <= AV7CatCodigo.size() )
      {
         AV106validoEs = false ;
         AV164GXV3 = 1 ;
         while ( AV164GXV3 <= AV8CatCodigo_Data.size() )
         {
            AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV8CatCodigo_Data.elementAt(-1+AV164GXV3));
            if ( GXutil.strcmp(GXutil.trim( AV9Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Id()), (String)AV7CatCodigo.elementAt(-1+AV105l)) == 0 )
            {
               AV106validoEs = true ;
               if (true) break;
            }
            AV164GXV3 = (int)(AV164GXV3+1) ;
         }
         if ( AV106validoEs )
         {
            AV105l = (short)(AV105l+1) ;
         }
         else
         {
            AV7CatCodigo.removeItem(AV105l);
         }
      }
   }

   public void S212( )
   {
      /* 'LOADCOMBOCONVECODIGO' Routine */
      returnInSub = false ;
      AV97ConveCodigo_Data.clear();
      /* Using cursor H002S8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV32CliCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A1564CliPaiConve = H002S8_A1564CliPaiConve[0] ;
         A3CliCod = H002S8_A3CliCod[0] ;
         A1565CliConvenio = H002S8_A1565CliConvenio[0] ;
         A1567CliConvenioDescrip = H002S8_A1567CliConvenioDescrip[0] ;
         A1567CliConvenioDescrip = H002S8_A1567CliConvenioDescrip[0] ;
         AV9Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1565CliConvenio );
         AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1567CliConvenioDescrip );
         AV97ConveCodigo_Data.add(AV9Combo_DataItem, 0);
         pr_default.readNext(6);
      }
      pr_default.close(6);
      Combo_convecodigo_Selectedvalue_set = AV82ConveCodigo.toJSonString(false) ;
      ucCombo_convecodigo.sendProperty(context, sPrefix, false, Combo_convecodigo_Internalname, "SelectedValue_set", Combo_convecodigo_Selectedvalue_set);
   }

   public void e192S2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int6 = AV32CliCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
      liquidacionabm_impl.this.GXt_int6 = GXv_int7[0] ;
      AV32CliCod = GXt_int6 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32CliCod), 6, 0));
      if ( ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 ) && ( GXutil.strcmp(AV63confirmarRespuesta, httpContext.getMessage( "OK", "")) == 0 ) )
      {
         GXt_int6 = AV19LiqNro ;
         GXv_int7[0] = GXt_int6 ;
         new web.obtnumliquidacion(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, GXv_int7) ;
         liquidacionabm_impl.this.GXt_int6 = GXv_int7[0] ;
         AV19LiqNro = GXt_int6 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19LiqNro), 8, 0));
         AV119clientId = AV99ServerSocket.getgxTv_SdtSocket_Clientid() ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "client id ", "")+AV119clientId) ;
         GXt_dtime32 = GXutil.resetTime( AV47dummyDate );
         GXv_date28[0] = AV123vaciaFecha ;
         new web.newliquidacioncabecera(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV19LiqNro, AV44LiqPerAno, AV45LiqPerMes, AV78LiqPerPalabra, AV36LiqDescrip, AV18LiqFecha, AV16LiqClase, AV124LiqModTra, AV126LiqFrecPag, AV146LiqTipoTarifa, AV127LiqPerDes, AV128LiqPerHas, AV37LiqFecPago, AV26TLiqCod, AV5LiqEstado, AV5LiqEstado, AV6AplicaA, AV40LiqDepBanCod, AV41LiqDepPrvFec, AV42LiqDepPerAno, AV43LiqDepPerMes, GXt_dtime32, AV66LiqNombre, 0, AV108LiqSac, AV110LiqSacLog, (short)(AV13LegNumero.size()), GXv_date28) ;
         liquidacionabm_impl.this.AV123vaciaFecha = GXv_date28[0] ;
         Application.commitDataStores(context, remoteHandle, pr_default, "liquidacionabm");
         GXv_int24[0] = (byte)(AV113predetLiquidaSac) ;
         GXv_char26[0] = "" ;
         new web.liquidar_sac(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, 0, AV26TLiqCod, AV58LiqPeriodo, GXv_int24, GXv_char26) ;
         liquidacionabm_impl.this.AV113predetLiquidaSac = GXv_int24[0] ;
         if ( ( AV113predetLiquidaSac == 1 ) && ! AV108LiqSac )
         {
            GXt_char2 = AV110LiqSacLog ;
            GXv_char26[0] = GXt_char2 ;
            new web.mensajeeligenosac(remoteHandle, context).execute( GXv_char26) ;
            liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
            AV110LiqSacLog += ". " + GXt_char2 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV110LiqSacLog", AV110LiqSacLog);
         }
         new web.liquidacionporlotes(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV19LiqNro, AV13LegNumero, AV16LiqClase, AV124LiqModTra, AV126LiqFrecPag, AV146LiqTipoTarifa, AV127LiqPerDes, AV128LiqPerHas, AV26TLiqCod, AV45LiqPerMes, AV44LiqPerAno, AV119clientId, false) ;
         /* Execute user subroutine: 'IR A WW' */
         S302 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
   }

   public void e202S2( )
   {
      /* Liqmodtra_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'COMBO FRECUENCIAS' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO TARIFAS' */
      S192 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO TIPOS' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavLiqfrecpag.setValue( GXutil.trim( GXutil.str( AV126LiqFrecPag, 1, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqfrecpag.getInternalname(), "Values", cmbavLiqfrecpag.ToJavascriptSource(), true);
      cmbavLiqtipotarifa.setValue( GXutil.rtrim( AV146LiqTipoTarifa) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqtipotarifa.getInternalname(), "Values", cmbavLiqtipotarifa.ToJavascriptSource(), true);
      cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
   }

   public void e212S2( )
   {
      /* Liqsac_Controlvaluechanged Routine */
      returnInSub = false ;
      AV112tocoLiqSac = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV112tocoLiqSac", AV112tocoLiqSac);
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e222S2( )
   {
      /* Conveniofiltro_Controlvaluechanged Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&ConvenioFiltro.ControlValueChanged 1", "")) ;
      /* Execute user subroutine: 'SELECCIONAR CONVENIOS VISIBLE' */
      S282 ();
      if (returnInSub) return;
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&ConvenioFiltro.ControlValueChanged 2", "")) ;
      if ( ( GXutil.strcmp(AV104ConvenioFiltro, "Todos") == 0 ) || ( GXutil.strcmp(AV104ConvenioFiltro, "Fuera") == 0 ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&ConvenioFiltro.ControlValueChanged 3", "")) ;
         AV82ConveCodigo.clear();
         AV97ConveCodigo_Data.clear();
         AV7CatCodigo.clear();
         AV8CatCodigo_Data.clear();
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV155Pgmname, httpContext.getMessage( "&ConvenioFiltro.ControlValueChanged 4", "")) ;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV82ConveCodigo", AV82ConveCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV97ConveCodigo_Data", AV97ConveCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7CatCodigo", AV7CatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV8CatCodigo_Data", AV8CatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void e232S2( )
   {
      /* Liqfecpago_Controlvaluechanged Routine */
      returnInSub = false ;
      AV70tocoFechaPago = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70tocoFechaPago", AV70tocoFechaPago);
      /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e242S2( )
   {
      /* Liqfrecpag_Controlvaluechanged Routine */
      returnInSub = false ;
      AV67LegClase = AV126LiqFrecPag ;
      /* Execute user subroutine: 'COMBO TARIFAS' */
      S192 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'COMBO TIPOS' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOCATCODIGO' */
      S222 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavLiqtipotarifa.setValue( GXutil.rtrim( AV146LiqTipoTarifa) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqtipotarifa.getInternalname(), "Values", cmbavLiqtipotarifa.ToJavascriptSource(), true);
      cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV8CatCodigo_Data", AV8CatCodigo_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV7CatCodigo", AV7CatCodigo);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
   }

   public void e252S2( )
   {
      /* Tliqcod_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VISIBILIDAD SAC' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV26TLiqCod, AV55egresoTLiqCod) == 0 )
      {
         AV6AplicaA = httpContext.getMessage( "ALGUNOS", "") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AplicaA", AV6AplicaA);
      }
      else
      {
      }
      /* Execute user subroutine: 'DEFAULT FECHAS PAGO Y PREVISIONAL' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      radavAplicaa.setValue( GXutil.rtrim( AV6AplicaA) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, radavAplicaa.getInternalname(), "Values", radavAplicaa.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
      cmbavLiqdeppermes.setValue( GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdeppermes.getInternalname(), "Values", cmbavLiqdeppermes.ToJavascriptSource(), true);
      cmbavLiqdepperano.setValue( GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdepperano.getInternalname(), "Values", cmbavLiqdepperano.ToJavascriptSource(), true);
   }

   public void e262S2( )
   {
      /* Liqpermes_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'COMBO TIPOS' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'CALCULAR PERIODO' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT FECHAS PAGO Y PREVISIONAL' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD SAC' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavTliqcod.setValue( GXutil.rtrim( AV26TLiqCod) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Values", cmbavTliqcod.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
      cmbavLiqdeppermes.setValue( GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdeppermes.getInternalname(), "Values", cmbavLiqdeppermes.ToJavascriptSource(), true);
      cmbavLiqdepperano.setValue( GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdepperano.getInternalname(), "Values", cmbavLiqdepperano.ToJavascriptSource(), true);
   }

   public void e272S2( )
   {
      /* Liqperano_Isvalid Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CALCULAR PERIODO' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S262 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT FECHAS PAGO Y PREVISIONAL' */
      S152 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'DEFAULT PERIODO DESDE HASTA' */
      S162 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'VISIBILIDAD SAC' */
      S172 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ARMAR NOMBRE' */
      S182 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14LegNumero_Data", AV14LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13LegNumero", AV13LegNumero);
      cmbavLiqdeppermes.setValue( GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdeppermes.getInternalname(), "Values", cmbavLiqdeppermes.ToJavascriptSource(), true);
      cmbavLiqdepperano.setValue( GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdepperano.getInternalname(), "Values", cmbavLiqdepperano.ToJavascriptSource(), true);
   }

   public void S142( )
   {
      /* 'CALCULAR PERIODO' Routine */
      returnInSub = false ;
      AV58LiqPeriodo = localUtil.ymdtod( AV44LiqPerAno, AV45LiqPerMes, 1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58LiqPeriodo", localUtil.format(AV58LiqPeriodo, "99/99/9999"));
      GXv_char26[0] = AV78LiqPerPalabra ;
      new web.armaperpalabra(remoteHandle, context).execute( AV32CliCod, AV58LiqPeriodo, GXv_char26) ;
      liquidacionabm_impl.this.AV78LiqPerPalabra = GXv_char26[0] ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78LiqPerPalabra", AV78LiqPerPalabra);
   }

   public void S112( )
   {
      /* 'COMBO MODOS' Routine */
      returnInSub = false ;
      AV139unicoLiqModTra = "" ;
      AV125cntModos = (short)(0) ;
      cmbavLiqmodtra.removeAllItems();
      /* Using cursor H002S9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(7) != 101) )
      {
         brk2S10 = false ;
         A3CliCod = H002S9_A3CliCod[0] ;
         A1EmpCod = H002S9_A1EmpCod[0] ;
         A2404LegModTra = H002S9_A2404LegModTra[0] ;
         AV138modo_trabajo = A2404LegModTra ;
         AV139unicoLiqModTra = A2404LegModTra ;
         cmbavLiqmodtra.addItem(A2404LegModTra, httpContext.getMessage( web.gxdomainmodo_trabajo.getDescription(httpContext,(String)AV138modo_trabajo), ""), (short)(0));
         AV125cntModos = (short)(AV125cntModos+1) ;
         while ( (pr_default.getStatus(7) != 101) && ( H002S9_A3CliCod[0] == A3CliCod ) && ( H002S9_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(H002S9_A2404LegModTra[0], A2404LegModTra) == 0 ) )
         {
            brk2S10 = false ;
            brk2S10 = true ;
            pr_default.readNext(7);
         }
         if ( ! brk2S10 )
         {
            brk2S10 = true ;
            pr_default.readNext(7);
         }
      }
      pr_default.close(7);
      if ( AV125cntModos == 1 )
      {
         AV124LiqModTra = AV139unicoLiqModTra ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV124LiqModTra", AV124LiqModTra);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV155Pgmname, httpContext.getMessage( "combo modo setea liqmodtra ", "")+AV124LiqModTra+httpContext.getMessage( " por tener 1 solo", "")) ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV134sola_opcion_modoPalabra)), httpContext.getMessage( "INVISIBLE", "")) == 0 )
         {
            cmbavLiqmodtra.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqmodtra.getInternalname(), "Visible", GXutil.ltrimstr( cmbavLiqmodtra.getVisible(), 5, 0), true);
         }
         else
         {
            cmbavLiqmodtra.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqmodtra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqmodtra.getEnabled(), 5, 0), true);
         }
      }
      else
      {
         GXt_char2 = AV124LiqModTra ;
         GXv_char26[0] = GXt_char2 ;
         new web.getempmodtrapredet(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, GXv_char26) ;
         liquidacionabm_impl.this.GXt_char2 = GXv_char26[0] ;
         AV124LiqModTra = GXt_char2 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV124LiqModTra", AV124LiqModTra);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV155Pgmname, httpContext.getMessage( "combo modo setea liqmodtra ", "")+AV124LiqModTra+httpContext.getMessage( " default de empresa", "")) ;
      }
   }

   public void S132( )
   {
      /* 'COMBO TIPOS' Routine */
      returnInSub = false ;
      AV136tliqCant = (short)(0) ;
      AV61permanece = false ;
      AV60anterior = AV26TLiqCod ;
      AV143anteriorExiste = false ;
      AV144unicoTLiqCod = "" ;
      GXt_char2 = AV52aguiTLiqCod ;
      GXt_char1 = AV52aguiTLiqCod ;
      GXv_char26[0] = GXt_char1 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char26) ;
      liquidacionabm_impl.this.GXt_char1 = GXv_char26[0] ;
      GXv_char25[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char1, GXv_char25) ;
      liquidacionabm_impl.this.GXt_char2 = GXv_char25[0] ;
      AV52aguiTLiqCod = GXt_char2 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52aguiTLiqCod", AV52aguiTLiqCod);
      cmbavTliqcod.removeAllItems();
      /* Using cursor H002S10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV32CliCod)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A3CliCod = H002S10_A3CliCod[0] ;
         A341TLiqHabilitada = H002S10_A341TLiqHabilitada[0] ;
         A32TLiqCod = H002S10_A32TLiqCod[0] ;
         A1817TLiqOrd = H002S10_A1817TLiqOrd[0] ;
         GXv_boolean11[0] = AV135existe ;
         GXv_char26[0] = AV141TLiqDescAuxFrec ;
         new web.tliqmodyfrecexiste(remoteHandle, context).execute( A3CliCod, A32TLiqCod, AV124LiqModTra, AV126LiqFrecPag, GXv_boolean11, GXv_char26) ;
         liquidacionabm_impl.this.AV135existe = GXv_boolean11[0] ;
         liquidacionabm_impl.this.AV141TLiqDescAuxFrec = GXv_char26[0] ;
         if ( AV135existe )
         {
            if ( GXutil.strcmp(A32TLiqCod, AV60anterior) == 0 )
            {
               AV143anteriorExiste = true ;
            }
            if ( ( GXutil.strcmp(A32TLiqCod, AV52aguiTLiqCod) != 0 ) || ( ( AV45LiqPerMes == 6 ) || ( AV45LiqPerMes == 12 ) ) )
            {
               cmbavTliqcod.addItem(A32TLiqCod, AV141TLiqDescAuxFrec, (short)(0));
               AV144unicoTLiqCod = A32TLiqCod ;
               AV136tliqCant = (short)(AV136tliqCant+1) ;
               if ( GXutil.strcmp(A32TLiqCod, AV60anterior) == 0 )
               {
                  AV61permanece = true ;
               }
            }
         }
         pr_default.readNext(8);
      }
      pr_default.close(8);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV155Pgmname, httpContext.getMessage( "&permanece ", "")+GXutil.trim( GXutil.booltostr( AV61permanece))+httpContext.getMessage( " &anteriorExiste ", "")+GXutil.trim( GXutil.booltostr( AV143anteriorExiste))+httpContext.getMessage( " anterior ", "")+AV60anterior) ;
      if ( ( AV61permanece ) && ( AV143anteriorExiste ) )
      {
         AV26TLiqCod = AV60anterior ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TLiqCod", AV26TLiqCod);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV155Pgmname, httpContext.getMessage( "pisa con anterior", "")) ;
      }
      if ( AV136tliqCant <= 1 )
      {
         if ( AV136tliqCant == 1 )
         {
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV134sola_opcion_modoPalabra)), httpContext.getMessage( "INVISIBLE", "")) == 0 )
            {
               cmbavTliqcod.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Visible", GXutil.ltrimstr( cmbavTliqcod.getVisible(), 5, 0), true);
            }
            else
            {
               cmbavTliqcod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTliqcod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTliqcod.getEnabled(), 5, 0), true);
            }
            AV26TLiqCod = AV144unicoTLiqCod ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26TLiqCod", AV26TLiqCod);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV155Pgmname, httpContext.getMessage( "pisa con único", "")) ;
         }
         else
         {
         }
      }
   }

   public void S202( )
   {
      /* 'VISIBILIDAD LEGAJOS' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV6AplicaA, httpContext.getMessage( "TODOS", "")) == 0 )
      {
         divTablesplittedlegnumero_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedlegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegnumero_Visible), 5, 0), true);
      }
      else
      {
         divTablesplittedlegnumero_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedlegnumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedlegnumero_Visible), 5, 0), true);
      }
   }

   public void S152( )
   {
      /* 'DEFAULT FECHAS PAGO Y PREVISIONAL' Routine */
      returnInSub = false ;
      if ( ! AV69tocoFechasPrevisional )
      {
         AV41LiqDepPrvFec = localUtil.ymdtod( AV44LiqPerAno, AV45LiqPerMes, 1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41LiqDepPrvFec", localUtil.format(AV41LiqDepPrvFec, "99/99/99"));
         GXt_int33 = AV43LiqDepPerMes ;
         GXv_int24[0] = GXt_int33 ;
         new web.mesantes(remoteHandle, context).execute( AV45LiqPerMes, GXv_int24) ;
         liquidacionabm_impl.this.GXt_int33 = GXv_int24[0] ;
         AV43LiqDepPerMes = GXt_int33 ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43LiqDepPerMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43LiqDepPerMes), 2, 0));
         AV42LiqDepPerAno = AV44LiqPerAno ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42LiqDepPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42LiqDepPerAno), 4, 0));
         if ( AV43LiqDepPerMes == 12 )
         {
            AV42LiqDepPerAno = (short)(AV42LiqDepPerAno-1) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42LiqDepPerAno", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42LiqDepPerAno), 4, 0));
         }
      }
      if ( ! AV70tocoFechaPago )
      {
         GXv_date28[0] = AV37LiqFecPago ;
         new web.defaultfechapago(remoteHandle, context).execute( AV32CliCod, AV26TLiqCod, AV58LiqPeriodo, GXv_date28) ;
         liquidacionabm_impl.this.AV37LiqFecPago = GXv_date28[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37LiqFecPago", localUtil.format(AV37LiqFecPago, "99/99/9999"));
      }
   }

   public void S182( )
   {
      /* 'ARMAR NOMBRE' Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) == 0 ) && ! AV107modificoNombre )
      {
         GXv_char26[0] = AV78LiqPerPalabra ;
         GXv_char25[0] = AV66LiqNombre ;
         new web.armaliqnombre2(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, AV58LiqPeriodo, GXv_char26, AV26TLiqCod, AV124LiqModTra, AV126LiqFrecPag, AV104ConvenioFiltro, AV82ConveCodigo, AV7CatCodigo, AV24SecCodigo, AV100PuestoCodigo, AV101SucCodigo, GXv_char25) ;
         liquidacionabm_impl.this.AV78LiqPerPalabra = GXv_char26[0] ;
         liquidacionabm_impl.this.AV66LiqNombre = GXv_char25[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78LiqPerPalabra", AV78LiqPerPalabra);
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66LiqNombre", AV66LiqNombre);
      }
      if ( GXutil.strcmp(AV26TLiqCod, AV65quincenaTLiqCod) == 0 )
      {
         AV93finDeMesFecha = localUtil.ymdtod( GXutil.year( AV58LiqPeriodo), GXutil.month( AV58LiqPeriodo), 15) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93finDeMesFecha", localUtil.format(AV93finDeMesFecha, "99/99/9999"));
      }
      else
      {
         AV93finDeMesFecha = GXutil.eomdate( AV58LiqPeriodo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93finDeMesFecha", localUtil.format(AV93finDeMesFecha, "99/99/9999"));
      }
      if ( AV109sacEs == 1 )
      {
         if ( GXutil.strcmp(AV26TLiqCod, AV111mensualTLiqCod) == 0 )
         {
            if ( AV108LiqSac )
            {
               AV66LiqNombre += httpContext.getMessage( "- Con SAC", "") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66LiqNombre", AV66LiqNombre);
            }
            else
            {
               AV66LiqNombre += httpContext.getMessage( "- Sin SAC", "") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66LiqNombre", AV66LiqNombre);
            }
         }
      }
   }

   public void S302( )
   {
      /* 'IR A WW' Routine */
      returnInSub = false ;
      callWebObject(formatLink("web.periodoview", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "Periodos", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV32CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateParm(AV58LiqPeriodo)),GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "LiquidacionWW", "")))}, new String[] {"MenuOpcCod","CliCod","EmpCod","PeriodoLiq","TabCode"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S282( )
   {
      /* 'SELECCIONAR CONVENIOS VISIBLE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV104ConvenioFiltro, "EnConvenio") == 0 )
      {
         divTablesplittedconvecodigo_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedconvecodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedconvecodigo_Visible), 5, 0), true);
         divTablesplittedcatcodigo_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedcatcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedcatcodigo_Visible), 5, 0), true);
      }
      else
      {
         divTablesplittedconvecodigo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedconvecodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedconvecodigo_Visible), 5, 0), true);
         divTablesplittedcatcodigo_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablesplittedcatcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesplittedcatcodigo_Visible), 5, 0), true);
      }
   }

   public void S172( )
   {
      /* 'VISIBILIDAD SAC' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", "")) != 0 )
      {
         chkavLiqsac.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavLiqsac.getInternalname(), "Visible", GXutil.ltrimstr( chkavLiqsac.getVisible(), 5, 0), true);
      }
      else
      {
         GXv_int24[0] = AV109sacEs ;
         GXv_char26[0] = AV110LiqSacLog ;
         new web.liquidar_sac(remoteHandle, context).execute( AV32CliCod, AV11EmpCod, 0, AV26TLiqCod, AV58LiqPeriodo, GXv_int24, GXv_char26) ;
         liquidacionabm_impl.this.AV109sacEs = GXv_int24[0] ;
         liquidacionabm_impl.this.AV110LiqSacLog = GXv_char26[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV109sacEs", GXutil.str( AV109sacEs, 1, 0));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV110LiqSacLog", AV110LiqSacLog);
         if ( ( GXutil.strcmp(AV26TLiqCod, AV111mensualTLiqCod) != 0 ) || ( AV109sacEs == ( 0 )) )
         {
            if ( AV109sacEs == 1 )
            {
               AV108LiqSac = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108LiqSac", AV108LiqSac);
            }
            else
            {
               AV108LiqSac = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108LiqSac", AV108LiqSac);
            }
            chkavLiqsac.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavLiqsac.getInternalname(), "Visible", GXutil.ltrimstr( chkavLiqsac.getVisible(), 5, 0), true);
         }
         else
         {
            chkavLiqsac.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavLiqsac.getInternalname(), "Visible", GXutil.ltrimstr( chkavLiqsac.getVisible(), 5, 0), true);
            if ( ! AV112tocoLiqSac )
            {
               AV108LiqSac = true ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV108LiqSac", AV108LiqSac);
            }
         }
      }
   }

   public void S162( )
   {
      /* 'DEFAULT PERIODO DESDE HASTA' Routine */
      returnInSub = false ;
      if ( ( AV126LiqFrecPag == 2 ) && ( GXutil.strcmp(AV26TLiqCod, AV65quincenaTLiqCod) == 0 ) )
      {
         GXv_date28[0] = AV127LiqPerDes ;
         GXv_date27[0] = AV128LiqPerHas ;
         new web.getperiodoquincena(remoteHandle, context).execute( AV32CliCod, (short)(1), AV58LiqPeriodo, GXv_date28, GXv_date27) ;
         liquidacionabm_impl.this.AV127LiqPerDes = GXv_date28[0] ;
         liquidacionabm_impl.this.AV128LiqPerHas = GXv_date27[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
         edtavLiqperdes_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperdes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperdes_Enabled), 5, 0), true);
         edtavLiqperhas_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperhas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperhas_Enabled), 5, 0), true);
      }
      else
      {
         if ( ( AV126LiqFrecPag == 2 ) && ( GXutil.strcmp(AV26TLiqCod, AV111mensualTLiqCod) == 0 ) )
         {
            GXv_date28[0] = AV127LiqPerDes ;
            GXv_date27[0] = AV128LiqPerHas ;
            new web.getperiodoquincena(remoteHandle, context).execute( AV32CliCod, (short)(2), AV58LiqPeriodo, GXv_date28, GXv_date27) ;
            liquidacionabm_impl.this.AV127LiqPerDes = GXv_date28[0] ;
            liquidacionabm_impl.this.AV128LiqPerHas = GXv_date27[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
            edtavLiqperdes_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperdes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperdes_Enabled), 5, 0), true);
            edtavLiqperhas_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperhas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperhas_Enabled), 5, 0), true);
         }
         else
         {
            if ( ( GXutil.strcmp(AV26TLiqCod, AV65quincenaTLiqCod) != 0 ) && ( GXutil.strcmp(AV124LiqModTra, "E") == 0 ) )
            {
               edtavLiqperdes_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperdes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperdes_Enabled), 5, 0), true);
               edtavLiqperhas_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperhas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperhas_Enabled), 5, 0), true);
               AV127LiqPerDes = AV58LiqPeriodo ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
               AV128LiqPerHas = GXutil.eomdate( AV58LiqPeriodo) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
            }
            else
            {
               edtavLiqperdes_Enabled = (((GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", ""))==0)||(GXutil.strcmp(AV23Modo, httpContext.getMessage( "UPD", ""))==0)) ? 1 : 0) ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperdes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperdes_Enabled), 5, 0), true);
               edtavLiqperhas_Enabled = (((GXutil.strcmp(AV23Modo, httpContext.getMessage( "INS", ""))==0)||(GXutil.strcmp(AV23Modo, httpContext.getMessage( "UPD", ""))==0)) ? 1 : 0) ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLiqperhas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqperhas_Enabled), 5, 0), true);
               if ( ( AV145fechasRangoToco == ( 0 )) )
               {
                  if ( ! AV70tocoFechaPago )
                  {
                     if ( ( AV126LiqFrecPag == 3 ) || ( AV126LiqFrecPag == 4 ) )
                     {
                        AV37LiqFecPago = GXutil.serverDate( context, remoteHandle, pr_default) ;
                        httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37LiqFecPago", localUtil.format(AV37LiqFecPago, "99/99/9999"));
                     }
                  }
                  AV128LiqPerHas = AV37LiqFecPago ;
                  httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV128LiqPerHas", localUtil.format(AV128LiqPerHas, "99/99/9999"));
                  if ( AV126LiqFrecPag == 1 )
                  {
                     AV127LiqPerDes = GXutil.addmth( AV128LiqPerHas, (short)(-1)) ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
                  }
                  else if ( AV126LiqFrecPag == 2 )
                  {
                     AV127LiqPerDes = GXutil.dadd( AV128LiqPerHas, (-14)) ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
                  }
                  else if ( AV126LiqFrecPag == 3 )
                  {
                     AV127LiqPerDes = GXutil.dadd( AV128LiqPerHas, (-6)) ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
                  }
                  else if ( AV126LiqFrecPag == 4 )
                  {
                     AV127LiqPerDes = AV128LiqPerHas ;
                     httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV127LiqPerDes", localUtil.format(AV127LiqPerDes, "99/99/9999"));
                  }
               }
            }
         }
      }
   }

   public void S122( )
   {
      /* 'COMBO FRECUENCIAS' Routine */
      returnInSub = false ;
      AV140unicoLiqFrecPag = (byte)(0) ;
      AV129diarioHay = false ;
      AV130semanalHay = false ;
      AV131quincenalHay = false ;
      AV132mensualHay = false ;
      AV133frecsCnt = (short)(0) ;
      cmbavLiqfrecpag.removeAllItems();
      new web.msgdebug_prod2(remoteHandle, context).execute( AV32CliCod, AV155Pgmname, httpContext.getMessage( "combo frec &LiqModTra ", "")+AV124LiqModTra) ;
      /* Using cursor H002S11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV11EmpCod), AV124LiqModTra});
      while ( (pr_default.getStatus(9) != 101) )
      {
         A2404LegModTra = H002S11_A2404LegModTra[0] ;
         A1818LegEstado = H002S11_A1818LegEstado[0] ;
         A1EmpCod = H002S11_A1EmpCod[0] ;
         A3CliCod = H002S11_A3CliCod[0] ;
         A235LegClase = H002S11_A235LegClase[0] ;
         AV142ClaseLeg = A235LegClase ;
         cmbavLiqfrecpag.addItem(GXutil.trim( GXutil.str( A235LegClase, 1, 0)), GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV142ClaseLeg), "")), (short)(0));
         AV140unicoLiqFrecPag = A235LegClase ;
         if ( A235LegClase == 4 )
         {
            AV129diarioHay = true ;
         }
         else if ( A235LegClase == 3 )
         {
            AV130semanalHay = true ;
         }
         else if ( A235LegClase == 2 )
         {
            AV131quincenalHay = true ;
         }
         else if ( A235LegClase == 1 )
         {
            AV132mensualHay = true ;
         }
         if ( ( AV129diarioHay ) && ( AV130semanalHay ) && ( AV131quincenalHay ) && ( AV132mensualHay ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(9);
      }
      pr_default.close(9);
      if ( AV129diarioHay )
      {
         AV133frecsCnt = (short)(AV133frecsCnt+1) ;
      }
      if ( AV130semanalHay )
      {
         AV133frecsCnt = (short)(AV133frecsCnt+1) ;
      }
      if ( AV131quincenalHay )
      {
         AV133frecsCnt = (short)(AV133frecsCnt+1) ;
      }
      if ( AV132mensualHay )
      {
         AV133frecsCnt = (short)(AV133frecsCnt+1) ;
      }
      if ( AV133frecsCnt <= 1 )
      {
         AV126LiqFrecPag = AV140unicoLiqFrecPag ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV126LiqFrecPag", GXutil.str( AV126LiqFrecPag, 1, 0));
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV134sola_opcion_modoPalabra)), httpContext.getMessage( "INVISIBLE", "")) == 0 )
         {
            cmbavLiqfrecpag.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqfrecpag.getInternalname(), "Visible", GXutil.ltrimstr( cmbavLiqfrecpag.getVisible(), 5, 0), true);
         }
         else
         {
            cmbavLiqfrecpag.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqfrecpag.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqfrecpag.getEnabled(), 5, 0), true);
         }
      }
   }

   public void S192( )
   {
      /* 'COMBO TARIFAS' Routine */
      returnInSub = false ;
      AV147unicoLiqTipoTarifa = "" ;
      AV148porHoraHay = false ;
      AV150porPeriodoHay = false ;
      AV151tarfiassCnt = (short)(0) ;
      cmbavLiqtipotarifa.removeAllItems();
      /* Using cursor H002S12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV11EmpCod), AV124LiqModTra});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A2404LegModTra = H002S12_A2404LegModTra[0] ;
         A1818LegEstado = H002S12_A1818LegEstado[0] ;
         A1EmpCod = H002S12_A1EmpCod[0] ;
         A3CliCod = H002S12_A3CliCod[0] ;
         A2417LegTipoTarifa = H002S12_A2417LegTipoTarifa[0] ;
         AV152tipo_tarifa = A2417LegTipoTarifa ;
         cmbavLiqtipotarifa.addItem(A2417LegTipoTarifa, GXutil.trim( httpContext.getMessage( web.gxdomaintipo_tarifa.getDescription(httpContext,(String)AV152tipo_tarifa), "")), (short)(0));
         AV146LiqTipoTarifa = A2417LegTipoTarifa ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV146LiqTipoTarifa", AV146LiqTipoTarifa);
         if ( GXutil.strcmp(A2417LegTipoTarifa, "H") == 0 )
         {
            AV148porHoraHay = true ;
         }
         else if ( GXutil.strcmp(A2417LegTipoTarifa, "P") == 0 )
         {
            AV150porPeriodoHay = true ;
         }
         if ( ( AV148porHoraHay ) && ( AV150porPeriodoHay ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(10);
      }
      pr_default.close(10);
      if ( AV148porHoraHay )
      {
         AV151tarfiassCnt = (short)(AV151tarfiassCnt+1) ;
      }
      if ( AV150porPeriodoHay )
      {
         AV151tarfiassCnt = (short)(AV151tarfiassCnt+1) ;
      }
      if ( AV151tarfiassCnt <= 1 )
      {
         AV146LiqTipoTarifa = AV147unicoLiqTipoTarifa ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV146LiqTipoTarifa", AV146LiqTipoTarifa);
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV134sola_opcion_modoPalabra)), httpContext.getMessage( "INVISIBLE", "")) == 0 )
         {
            cmbavLiqtipotarifa.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqtipotarifa.getInternalname(), "Visible", GXutil.ltrimstr( cmbavLiqtipotarifa.getVisible(), 5, 0), true);
         }
         else
         {
            cmbavLiqtipotarifa.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqtipotarifa.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLiqtipotarifa.getEnabled(), 5, 0), true);
         }
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e282S2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table3_211_2S2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_enter_Internalname, tblTabledvelop_confirmpanel_enter_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_enter.setProperty("Title", Dvelop_confirmpanel_enter_Title);
         ucDvelop_confirmpanel_enter.setProperty("ConfirmationText", Dvelop_confirmpanel_enter_Confirmationtext);
         ucDvelop_confirmpanel_enter.setProperty("YesButtonCaption", Dvelop_confirmpanel_enter_Yesbuttoncaption);
         ucDvelop_confirmpanel_enter.setProperty("NoButtonCaption", Dvelop_confirmpanel_enter_Nobuttoncaption);
         ucDvelop_confirmpanel_enter.setProperty("CancelButtonCaption", Dvelop_confirmpanel_enter_Cancelbuttoncaption);
         ucDvelop_confirmpanel_enter.setProperty("YesButtonPosition", Dvelop_confirmpanel_enter_Yesbuttonposition);
         ucDvelop_confirmpanel_enter.setProperty("ConfirmType", Dvelop_confirmpanel_enter_Confirmtype);
         ucDvelop_confirmpanel_enter.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_enter_Internalname, sPrefix+"DVELOP_CONFIRMPANEL_ENTERContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVELOP_CONFIRMPANEL_ENTERContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_211_2S2e( true) ;
      }
      else
      {
         wb_table3_211_2S2e( false) ;
      }
   }

   public void wb_table2_176_2S2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTableinvi_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTableinvi_Internalname, tblTableinvi_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavEgresotliqcod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEgresotliqcod_Internalname, httpContext.getMessage( "Codigo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 181,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEgresotliqcod_Internalname, GXutil.rtrim( AV55egresoTLiqCod), GXutil.rtrim( localUtil.format( AV55egresoTLiqCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,181);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEgresotliqcod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEgresotliqcod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavGananciastliqcod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavGananciastliqcod_Internalname, httpContext.getMessage( "Codigo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 186,'" + sPrefix + "',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavGananciastliqcod_Internalname, GXutil.rtrim( AV59gananciasTLiqCod), GXutil.rtrim( localUtil.format( AV59gananciasTLiqCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,186);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGananciastliqcod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGananciastliqcod_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqperiodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqperiodo_Internalname, httpContext.getMessage( "Periodo liquidado", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 191,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavLiqperiodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavLiqperiodo_Internalname, localUtil.format(AV58LiqPeriodo, "99/99/9999"), localUtil.format( AV58LiqPeriodo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,191);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLiqperiodo_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavLiqperiodo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavLiqperiodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavLiqperiodo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavMenos1liqperiodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMenos1liqperiodo_Internalname, httpContext.getMessage( "Periodo liquidado", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavMenos1liqperiodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMenos1liqperiodo_Internalname, localUtil.format(AV79menos1LiqPeriodo, "99/99/9999"), localUtil.format( AV79menos1LiqPeriodo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,196);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMenos1liqperiodo_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavMenos1liqperiodo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavMenos1liqperiodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavMenos1liqperiodo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavFindemesfecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavFindemesfecha_Internalname, httpContext.getMessage( "fin De Mes Fecha", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 201,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavFindemesfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavFindemesfecha_Internalname, localUtil.format(AV93finDeMesFecha, "99/99/9999"), localUtil.format( AV93finDeMesFecha, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,201);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFindemesfecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavFindemesfecha_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_LiquidacionABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavFindemesfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavFindemesfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LiquidacionABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_176_2S2e( true) ;
      }
      else
      {
         wb_table2_176_2S2e( false) ;
      }
   }

   public void wb_table1_152_2S2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqdepperano.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqdepperano.getInternalname(), httpContext.getMessage( "Año", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 157,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqdepperano, cmbavLiqdepperano.getInternalname(), GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0)), 1, cmbavLiqdepperano.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLiqdepperano.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,157);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqdepperano.setValue( GXutil.trim( GXutil.str( AV42LiqDepPerAno, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdepperano.getInternalname(), "Values", cmbavLiqdepperano.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLiqdeppermes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavLiqdeppermes.getInternalname(), httpContext.getMessage( "Mes", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 161,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLiqdeppermes, cmbavLiqdeppermes.getInternalname(), GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0)), 1, cmbavLiqdeppermes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavLiqdeppermes.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,161);\"", "", true, (byte)(0), "HLP_LiquidacionABM.htm");
         cmbavLiqdeppermes.setValue( GXutil.trim( GXutil.str( AV43LiqDepPerMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavLiqdeppermes.getInternalname(), "Values", cmbavLiqdeppermes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_152_2S2e( true) ;
      }
      else
      {
         wb_table1_152_2S2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV94MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94MenuOpcCod", AV94MenuOpcCod);
      AV23Modo = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23Modo", AV23Modo);
      AV32CliCod = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32CliCod), 6, 0));
      AV11EmpCod = ((Number) GXutil.testNumericType( getParm(obj,3,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      AV20LiqNroPar = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20LiqNroPar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20LiqNroPar), 8, 0));
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
      pa2S2( ) ;
      ws2S2( ) ;
      we2S2( ) ;
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
      sCtrlAV94MenuOpcCod = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV23Modo = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV32CliCod = (String)getParm(obj,2,TypeConstants.STRING) ;
      sCtrlAV11EmpCod = (String)getParm(obj,3,TypeConstants.STRING) ;
      sCtrlAV20LiqNroPar = (String)getParm(obj,4,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa2S2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "liquidacionabm", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa2S2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV94MenuOpcCod = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94MenuOpcCod", AV94MenuOpcCod);
         AV23Modo = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23Modo", AV23Modo);
         AV32CliCod = ((Number) GXutil.testNumericType( getParm(obj,4,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32CliCod), 6, 0));
         AV11EmpCod = ((Number) GXutil.testNumericType( getParm(obj,5,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
         AV20LiqNroPar = ((Number) GXutil.testNumericType( getParm(obj,6,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20LiqNroPar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20LiqNroPar), 8, 0));
      }
      wcpOAV94MenuOpcCod = httpContext.cgiGet( sPrefix+"wcpOAV94MenuOpcCod") ;
      wcpOAV23Modo = httpContext.cgiGet( sPrefix+"wcpOAV23Modo") ;
      wcpOAV32CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV32CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV11EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      wcpOAV20LiqNroPar = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV20LiqNroPar"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV94MenuOpcCod, wcpOAV94MenuOpcCod) != 0 ) || ( GXutil.strcmp(AV23Modo, wcpOAV23Modo) != 0 ) || ( AV32CliCod != wcpOAV32CliCod ) || ( AV11EmpCod != wcpOAV11EmpCod ) || ( AV20LiqNroPar != wcpOAV20LiqNroPar ) ) )
      {
         setjustcreated();
      }
      wcpOAV94MenuOpcCod = AV94MenuOpcCod ;
      wcpOAV23Modo = AV23Modo ;
      wcpOAV32CliCod = AV32CliCod ;
      wcpOAV11EmpCod = AV11EmpCod ;
      wcpOAV20LiqNroPar = AV20LiqNroPar ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV94MenuOpcCod = httpContext.cgiGet( sPrefix+"AV94MenuOpcCod_CTRL") ;
      if ( GXutil.len( sCtrlAV94MenuOpcCod) > 0 )
      {
         AV94MenuOpcCod = httpContext.cgiGet( sCtrlAV94MenuOpcCod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94MenuOpcCod", AV94MenuOpcCod);
      }
      else
      {
         AV94MenuOpcCod = httpContext.cgiGet( sPrefix+"AV94MenuOpcCod_PARM") ;
      }
      sCtrlAV23Modo = httpContext.cgiGet( sPrefix+"AV23Modo_CTRL") ;
      if ( GXutil.len( sCtrlAV23Modo) > 0 )
      {
         AV23Modo = httpContext.cgiGet( sCtrlAV23Modo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23Modo", AV23Modo);
      }
      else
      {
         AV23Modo = httpContext.cgiGet( sPrefix+"AV23Modo_PARM") ;
      }
      sCtrlAV32CliCod = httpContext.cgiGet( sPrefix+"AV32CliCod_CTRL") ;
      if ( GXutil.len( sCtrlAV32CliCod) > 0 )
      {
         AV32CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV32CliCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32CliCod), 6, 0));
      }
      else
      {
         AV32CliCod = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV32CliCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV11EmpCod = httpContext.cgiGet( sPrefix+"AV11EmpCod_CTRL") ;
      if ( GXutil.len( sCtrlAV11EmpCod) > 0 )
      {
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlAV11EmpCod), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      }
      else
      {
         AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV11EmpCod_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      sCtrlAV20LiqNroPar = httpContext.cgiGet( sPrefix+"AV20LiqNroPar_CTRL") ;
      if ( GXutil.len( sCtrlAV20LiqNroPar) > 0 )
      {
         AV20LiqNroPar = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV20LiqNroPar), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20LiqNroPar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20LiqNroPar), 8, 0));
      }
      else
      {
         AV20LiqNroPar = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV20LiqNroPar_PARM"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
      pa2S2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws2S2( ) ;
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
      ws2S2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV94MenuOpcCod_PARM", AV94MenuOpcCod);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV94MenuOpcCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV94MenuOpcCod_CTRL", GXutil.rtrim( sCtrlAV94MenuOpcCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV23Modo_PARM", GXutil.rtrim( AV23Modo));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV23Modo)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV23Modo_CTRL", GXutil.rtrim( sCtrlAV23Modo));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV32CliCod_PARM", GXutil.ltrim( localUtil.ntoc( AV32CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV32CliCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV32CliCod_CTRL", GXutil.rtrim( sCtrlAV32CliCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11EmpCod_PARM", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV11EmpCod)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV11EmpCod_CTRL", GXutil.rtrim( sCtrlAV11EmpCod));
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV20LiqNroPar_PARM", GXutil.ltrim( localUtil.ntoc( AV20LiqNroPar, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV20LiqNroPar)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV20LiqNroPar_CTRL", GXutil.rtrim( sCtrlAV20LiqNroPar));
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
      we2S2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187221363", true, true);
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
      httpContext.AddJavascriptSource("liquidacionabm.js", "?2025187221363", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbavLiqperano.setInternalname( sPrefix+"vLIQPERANO" );
      cmbavLiqpermes.setInternalname( sPrefix+"vLIQPERMES" );
      cmbavLiqmodtra.setInternalname( sPrefix+"vLIQMODTRA" );
      cmbavLiqtipotarifa.setInternalname( sPrefix+"vLIQTIPOTARIFA" );
      cmbavLiqfrecpag.setInternalname( sPrefix+"vLIQFRECPAG" );
      cmbavTliqcod.setInternalname( sPrefix+"vTLIQCOD" );
      edtavLiqfecpago_Internalname = sPrefix+"vLIQFECPAGO" ;
      edtavLiqperdes_Internalname = sPrefix+"vLIQPERDES" ;
      edtavLiqperhas_Internalname = sPrefix+"vLIQPERHAS" ;
      chkavLiqsac.setInternalname( sPrefix+"vLIQSAC" );
      cmbavConveniofiltro.setInternalname( sPrefix+"vCONVENIOFILTRO" );
      lblTextblockcombo_convecodigo_Internalname = sPrefix+"TEXTBLOCKCOMBO_CONVECODIGO" ;
      Combo_convecodigo_Internalname = sPrefix+"COMBO_CONVECODIGO" ;
      divTablesplittedconvecodigo_Internalname = sPrefix+"TABLESPLITTEDCONVECODIGO" ;
      lblTextblockcombo_catcodigo_Internalname = sPrefix+"TEXTBLOCKCOMBO_CATCODIGO" ;
      Combo_catcodigo_Internalname = sPrefix+"COMBO_CATCODIGO" ;
      divTablesplittedcatcodigo_Internalname = sPrefix+"TABLESPLITTEDCATCODIGO" ;
      lblTextblockcombo_seccodigo_Internalname = sPrefix+"TEXTBLOCKCOMBO_SECCODIGO" ;
      Combo_seccodigo_Internalname = sPrefix+"COMBO_SECCODIGO" ;
      divTablesplittedseccodigo_Internalname = sPrefix+"TABLESPLITTEDSECCODIGO" ;
      lblTextblockcombo_puestocodigo_Internalname = sPrefix+"TEXTBLOCKCOMBO_PUESTOCODIGO" ;
      Combo_puestocodigo_Internalname = sPrefix+"COMBO_PUESTOCODIGO" ;
      divTablesplittedpuestocodigo_Internalname = sPrefix+"TABLESPLITTEDPUESTOCODIGO" ;
      lblTextblockcombo_succodigo_Internalname = sPrefix+"TEXTBLOCKCOMBO_SUCCODIGO" ;
      Combo_succodigo_Internalname = sPrefix+"COMBO_SUCCODIGO" ;
      divTablesplittedsuccodigo_Internalname = sPrefix+"TABLESPLITTEDSUCCODIGO" ;
      radavAplicaa.setInternalname( sPrefix+"vAPLICAA" );
      lblTextblockcombo_legnumero_Internalname = sPrefix+"TEXTBLOCKCOMBO_LEGNUMERO" ;
      Combo_legnumero_Internalname = sPrefix+"COMBO_LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = sPrefix+"TABLESPLITTEDLEGNUMERO" ;
      edtavLiqnombre_Internalname = sPrefix+"vLIQNOMBRE" ;
      edtavLiqdescrip_Internalname = sPrefix+"vLIQDESCRIP" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      lblTextblockcombo_liqdepbancod_Internalname = sPrefix+"TEXTBLOCKCOMBO_LIQDEPBANCOD" ;
      Combo_liqdepbancod_Internalname = sPrefix+"COMBO_LIQDEPBANCOD" ;
      divTablesplittedliqdepbancod_Internalname = sPrefix+"TABLESPLITTEDLIQDEPBANCOD" ;
      cmbavLiqdepperano.setInternalname( sPrefix+"vLIQDEPPERANO" );
      cmbavLiqdeppermes.setInternalname( sPrefix+"vLIQDEPPERMES" );
      tblUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = sPrefix+"UNNAMEDGROUP2" ;
      edtavLiqdepprvfec_Internalname = sPrefix+"vLIQDEPPRVFEC" ;
      divTableprevi_Internalname = sPrefix+"TABLEPREVI" ;
      Dvpanel_tableprevi_Internalname = sPrefix+"DVPANEL_TABLEPREVI" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtncancel_Internalname = sPrefix+"BTNCANCEL" ;
      edtavEgresotliqcod_Internalname = sPrefix+"vEGRESOTLIQCOD" ;
      edtavGananciastliqcod_Internalname = sPrefix+"vGANANCIASTLIQCOD" ;
      edtavLiqperiodo_Internalname = sPrefix+"vLIQPERIODO" ;
      edtavMenos1liqperiodo_Internalname = sPrefix+"vMENOS1LIQPERIODO" ;
      edtavFindemesfecha_Internalname = sPrefix+"vFINDEMESFECHA" ;
      tblTableinvi_Internalname = sPrefix+"TABLEINVI" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      edtavLiqdepbancod_Internalname = sPrefix+"vLIQDEPBANCOD" ;
      edtavEstadoaccion_Internalname = sPrefix+"vESTADOACCION" ;
      edtavLiqfecha_Internalname = sPrefix+"vLIQFECHA" ;
      edtavLiqnro_Internalname = sPrefix+"vLIQNRO" ;
      chkavInsert.setInternalname( sPrefix+"vINSERT" );
      chkavUpdate.setInternalname( sPrefix+"vUPDATE" );
      Dvelop_confirmpanel_enter_Internalname = sPrefix+"DVELOP_CONFIRMPANEL_ENTER" ;
      tblTabledvelop_confirmpanel_enter_Internalname = sPrefix+"TABLEDVELOP_CONFIRMPANEL_ENTER" ;
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
      cmbavLiqdeppermes.setJsonclick( "" );
      cmbavLiqdepperano.setJsonclick( "" );
      edtavFindemesfecha_Jsonclick = "" ;
      edtavFindemesfecha_Enabled = 1 ;
      edtavMenos1liqperiodo_Jsonclick = "" ;
      edtavMenos1liqperiodo_Enabled = 1 ;
      edtavLiqperiodo_Jsonclick = "" ;
      edtavLiqperiodo_Enabled = 1 ;
      edtavGananciastliqcod_Jsonclick = "" ;
      edtavGananciastliqcod_Enabled = 1 ;
      edtavEgresotliqcod_Jsonclick = "" ;
      edtavEgresotliqcod_Enabled = 1 ;
      cmbavLiqdeppermes.setEnabled( 1 );
      cmbavLiqdepperano.setEnabled( 1 );
      tblTableinvi_Visible = 1 ;
      chkavUpdate.setVisible( 1 );
      chkavInsert.setVisible( 1 );
      edtavLiqnro_Jsonclick = "" ;
      edtavLiqnro_Visible = 1 ;
      edtavLiqfecha_Jsonclick = "" ;
      edtavLiqfecha_Enabled = 1 ;
      edtavLiqfecha_Visible = 1 ;
      edtavEstadoaccion_Jsonclick = "" ;
      edtavEstadoaccion_Visible = 1 ;
      edtavLiqdepbancod_Jsonclick = "" ;
      edtavLiqdepbancod_Enabled = 1 ;
      edtavLiqdepbancod_Visible = 1 ;
      bttBtnenter_Visible = 1 ;
      edtavLiqdepprvfec_Jsonclick = "" ;
      edtavLiqdepprvfec_Enabled = 1 ;
      edtavLiqdescrip_Enabled = 1 ;
      edtavLiqnombre_Enabled = 1 ;
      Combo_legnumero_Caption = "" ;
      divTablesplittedlegnumero_Visible = 1 ;
      radavAplicaa.setJsonclick( "" );
      radavAplicaa.setEnabled( 1 );
      radavAplicaa.setVisible( 1 );
      Combo_succodigo_Caption = "" ;
      Combo_puestocodigo_Caption = "" ;
      Combo_seccodigo_Caption = "" ;
      Combo_catcodigo_Caption = "" ;
      divTablesplittedcatcodigo_Visible = 1 ;
      Combo_convecodigo_Caption = "" ;
      divTablesplittedconvecodigo_Visible = 1 ;
      cmbavConveniofiltro.setJsonclick( "" );
      cmbavConveniofiltro.setEnabled( 1 );
      chkavLiqsac.setEnabled( 1 );
      chkavLiqsac.setVisible( 1 );
      edtavLiqperhas_Jsonclick = "" ;
      edtavLiqperhas_Enabled = 1 ;
      edtavLiqperdes_Jsonclick = "" ;
      edtavLiqperdes_Enabled = 1 ;
      edtavLiqfecpago_Jsonclick = "" ;
      edtavLiqfecpago_Enabled = 1 ;
      cmbavTliqcod.setJsonclick( "" );
      cmbavTliqcod.setEnabled( 1 );
      cmbavTliqcod.setVisible( 1 );
      cmbavLiqfrecpag.setJsonclick( "" );
      cmbavLiqfrecpag.setEnabled( 1 );
      cmbavLiqfrecpag.setVisible( 1 );
      cmbavLiqtipotarifa.setJsonclick( "" );
      cmbavLiqtipotarifa.setEnabled( 1 );
      cmbavLiqtipotarifa.setVisible( 1 );
      cmbavLiqmodtra.setJsonclick( "" );
      cmbavLiqmodtra.setEnabled( 1 );
      cmbavLiqmodtra.setVisible( 1 );
      cmbavLiqpermes.setJsonclick( "" );
      cmbavLiqpermes.setEnabled( 1 );
      cmbavLiqperano.setJsonclick( "" );
      cmbavLiqperano.setEnabled( 1 );
      Dvelop_confirmpanel_enter_Confirmtype = "1" ;
      Dvelop_confirmpanel_enter_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_enter_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_enter_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_enter_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_enter_Confirmationtext = "Confirmación" ;
      Dvelop_confirmpanel_enter_Title = httpContext.getMessage( "Confirmar", "") ;
      Dvpanel_tableprevi_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableprevi_Iconposition = "Right" ;
      Dvpanel_tableprevi_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableprevi_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_tableprevi_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tableprevi_Title = httpContext.getMessage( "Último depósito de aportes y contribuciones", "") ;
      Dvpanel_tableprevi_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableprevi_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableprevi_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableprevi_Width = "100%" ;
      Combo_liqdepbancod_Enabled = GXutil.toBoolean( -1) ;
      Combo_liqdepbancod_Cls = "ExtendedCombo Attribute" ;
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
      Combo_legnumero_Multiplevaluestype = "Tags" ;
      Combo_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legnumero_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legnumero_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legnumero_Enabled = GXutil.toBoolean( -1) ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
      Combo_succodigo_Emptyitemtext = "Todas" ;
      Combo_succodigo_Multiplevaluestype = "Tags" ;
      Combo_succodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_succodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_succodigo_Enabled = GXutil.toBoolean( -1) ;
      Combo_succodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_puestocodigo_Emptyitemtext = "Todos" ;
      Combo_puestocodigo_Multiplevaluestype = "Tags" ;
      Combo_puestocodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_puestocodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_puestocodigo_Enabled = GXutil.toBoolean( -1) ;
      Combo_puestocodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_seccodigo_Emptyitemtext = "Todas" ;
      Combo_seccodigo_Multiplevaluestype = "Tags" ;
      Combo_seccodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_seccodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_seccodigo_Enabled = GXutil.toBoolean( -1) ;
      Combo_seccodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_catcodigo_Emptyitemtext = "Todas" ;
      Combo_catcodigo_Multiplevaluestype = "Tags" ;
      Combo_catcodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_catcodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_catcodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_convecodigo_Emptyitemtext = "Todos" ;
      Combo_convecodigo_Multiplevaluestype = "Tags" ;
      Combo_convecodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_convecodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_convecodigo_Cls = "ExtendedCombo Attribute" ;
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
      cmbavLiqperano.setName( "vLIQPERANO" );
      cmbavLiqperano.setWebtags( "" );
      cmbavLiqperano.addItem("2022", "2022", (short)(0));
      cmbavLiqperano.addItem("2023", "2023", (short)(0));
      cmbavLiqperano.addItem("2024", "2024", (short)(0));
      if ( cmbavLiqperano.getItemCount() > 0 )
      {
      }
      cmbavLiqpermes.setName( "vLIQPERMES" );
      cmbavLiqpermes.setWebtags( "" );
      cmbavLiqpermes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavLiqpermes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavLiqpermes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavLiqpermes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavLiqpermes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavLiqpermes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavLiqpermes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavLiqpermes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavLiqpermes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavLiqpermes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavLiqpermes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavLiqpermes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavLiqpermes.getItemCount() > 0 )
      {
      }
      cmbavLiqmodtra.setName( "vLIQMODTRA" );
      cmbavLiqmodtra.setWebtags( "" );
      cmbavLiqmodtra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbavLiqmodtra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbavLiqmodtra.getItemCount() > 0 )
      {
      }
      cmbavLiqtipotarifa.setName( "vLIQTIPOTARIFA" );
      cmbavLiqtipotarifa.setWebtags( "" );
      cmbavLiqtipotarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
      cmbavLiqtipotarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
      if ( cmbavLiqtipotarifa.getItemCount() > 0 )
      {
      }
      cmbavLiqfrecpag.setName( "vLIQFRECPAG" );
      cmbavLiqfrecpag.setWebtags( "" );
      cmbavLiqfrecpag.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbavLiqfrecpag.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbavLiqfrecpag.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbavLiqfrecpag.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbavLiqfrecpag.getItemCount() > 0 )
      {
      }
      cmbavTliqcod.setName( "vTLIQCOD" );
      cmbavTliqcod.setWebtags( "" );
      if ( cmbavTliqcod.getItemCount() > 0 )
      {
      }
      chkavLiqsac.setName( "vLIQSAC" );
      chkavLiqsac.setWebtags( "" );
      chkavLiqsac.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavLiqsac.getInternalname(), "TitleCaption", chkavLiqsac.getCaption(), true);
      chkavLiqsac.setCheckedValue( "false" );
      cmbavConveniofiltro.setName( "vCONVENIOFILTRO" );
      cmbavConveniofiltro.setWebtags( "" );
      cmbavConveniofiltro.addItem("Todos", httpContext.getMessage( "Todos", ""), (short)(0));
      cmbavConveniofiltro.addItem("Fuera", httpContext.getMessage( "Solo fuera de convenio", ""), (short)(0));
      cmbavConveniofiltro.addItem("EnConvenio", httpContext.getMessage( "En convenio", ""), (short)(0));
      if ( cmbavConveniofiltro.getItemCount() > 0 )
      {
      }
      radavAplicaa.setName( "vAPLICAA" );
      radavAplicaa.setWebtags( "" );
      radavAplicaa.addItem("TODOS", httpContext.getMessage( "Todos los empleados", ""), (short)(0));
      radavAplicaa.addItem("ALGUNOS", httpContext.getMessage( "Empleados específicos", ""), (short)(0));
      cmbavLiqdepperano.setName( "vLIQDEPPERANO" );
      cmbavLiqdepperano.setWebtags( "" );
      cmbavLiqdepperano.addItem("2022", "2022", (short)(0));
      cmbavLiqdepperano.addItem("2023", "2023", (short)(0));
      if ( cmbavLiqdepperano.getItemCount() > 0 )
      {
      }
      cmbavLiqdeppermes.setName( "vLIQDEPPERMES" );
      cmbavLiqdeppermes.setWebtags( "" );
      cmbavLiqdeppermes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavLiqdeppermes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavLiqdeppermes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavLiqdeppermes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavLiqdeppermes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavLiqdeppermes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavLiqdeppermes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavLiqdeppermes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavLiqdeppermes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavLiqdeppermes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavLiqdeppermes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavLiqdeppermes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavLiqdeppermes.getItemCount() > 0 )
      {
      }
      chkavInsert.setName( "vINSERT" );
      chkavInsert.setWebtags( "" );
      chkavInsert.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavInsert.getInternalname(), "TitleCaption", chkavInsert.getCaption(), true);
      chkavInsert.setCheckedValue( "false" );
      chkavUpdate.setName( "vUPDATE" );
      chkavUpdate.setWebtags( "" );
      chkavUpdate.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUpdate.getInternalname(), "TitleCaption", chkavUpdate.getCaption(), true);
      chkavUpdate.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV63confirmarRespuesta',fld:'vCONFIRMARRESPUESTA',pic:''},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavLiqperano'},{av:'AV44LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV36LiqDescrip',fld:'vLIQDESCRIP',pic:''},{av:'AV18LiqFecha',fld:'vLIQFECHA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV40LiqDepBanCod',fld:'vLIQDEPBANCOD',pic:''},{av:'AV41LiqDepPrvFec',fld:'vLIQDEPPRVFEC',pic:''},{av:'cmbavLiqdepperano'},{av:'AV42LiqDepPerAno',fld:'vLIQDEPPERANO',pic:'ZZZ9'},{av:'cmbavLiqdeppermes'},{av:'AV43LiqDepPerMes',fld:'vLIQDEPPERMES',pic:'Z9'},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV110LiqSacLog',fld:'vLIQSACLOG',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'radavAplicaa'},{av:'AV6AplicaA',fld:'vAPLICAA',pic:''},{av:'AV80insert',fld:'vINSERT',pic:''},{av:'AV81update',fld:'vUPDATE',pic:''},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV68vacacionesTLiqCod',fld:'vVACACIONESTLIQCOD',pic:'',hsh:true},{av:'AV16LiqClase',fld:'vLIQCLASE',pic:'9',hsh:true},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV83PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV5LiqEstado',fld:'vLIQESTADO',pic:'9',hsh:true},{av:'AV47dummyDate',fld:'vDUMMYDATE',pic:'',hsh:true},{av:'AV134sola_opcion_modoPalabra',fld:'vSOLA_OPCION_MODOPALABRA',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV110LiqSacLog',fld:'vLIQSACLOG',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e182S2',iparms:[{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV6AplicaA',fld:'vAPLICAA',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'AV68vacacionesTLiqCod',fld:'vVACACIONESTLIQCOD',pic:'',hsh:true},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV18LiqFecha',fld:'vLIQFECHA',pic:''},{av:'AV19LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'AV16LiqClase',fld:'vLIQCLASE',pic:'9',hsh:true},{av:'cmbavLiqperano'},{av:'AV44LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV52aguiTLiqCod',fld:'vAGUITLIQCOD',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV20LiqNroPar',fld:'vLIQNROPAR',pic:'ZZZZZZZ9'},{av:'AV36LiqDescrip',fld:'vLIQDESCRIP',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV41LiqDepPrvFec',fld:'vLIQDEPPRVFEC',pic:''},{av:'AV40LiqDepBanCod',fld:'vLIQDEPBANCOD',pic:''},{av:'cmbavLiqdepperano'},{av:'AV42LiqDepPerAno',fld:'vLIQDEPPERANO',pic:'ZZZ9'},{av:'cmbavLiqdeppermes'},{av:'AV43LiqDepPerMes',fld:'vLIQDEPPERMES',pic:'Z9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'Dvelop_confirmpanel_enter_Title',ctrl:'DVELOP_CONFIRMPANEL_ENTER',prop:'Title'},{av:'Dvelop_confirmpanel_enter_Confirmationtext',ctrl:'DVELOP_CONFIRMPANEL_ENTER',prop:'ConfirmationText'},{av:'AV63confirmarRespuesta',fld:'vCONFIRMARRESPUESTA',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_ENTER.CLOSE","{handler:'e162S2',iparms:[{av:'Dvelop_confirmpanel_enter_Result',ctrl:'DVELOP_CONFIRMPANEL_ENTER',prop:'Result'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'radavAplicaa'},{av:'AV6AplicaA',fld:'vAPLICAA',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'AV68vacacionesTLiqCod',fld:'vVACACIONESTLIQCOD',pic:'',hsh:true},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV18LiqFecha',fld:'vLIQFECHA',pic:''},{av:'AV19LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'AV16LiqClase',fld:'vLIQCLASE',pic:'9',hsh:true},{av:'cmbavLiqperano'},{av:'AV44LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV52aguiTLiqCod',fld:'vAGUITLIQCOD',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV20LiqNroPar',fld:'vLIQNROPAR',pic:'ZZZZZZZ9'},{av:'AV36LiqDescrip',fld:'vLIQDESCRIP',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV41LiqDepPrvFec',fld:'vLIQDEPPRVFEC',pic:''},{av:'AV40LiqDepBanCod',fld:'vLIQDEPBANCOD',pic:''},{av:'cmbavLiqdepperano'},{av:'AV42LiqDepPerAno',fld:'vLIQDEPPERANO',pic:'ZZZ9'},{av:'cmbavLiqdeppermes'},{av:'AV43LiqDepPerMes',fld:'vLIQDEPPERMES',pic:'Z9'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_ENTER.CLOSE",",oparms:[{av:'AV63confirmarRespuesta',fld:'vCONFIRMARRESPUESTA',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("COMBO_SUCCODIGO.ONOPTIONCLICKED","{handler:'e152S2',iparms:[{av:'Combo_succodigo_Selectedvalue_get',ctrl:'COMBO_SUCCODIGO',prop:'SelectedValue_get'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("COMBO_SUCCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("COMBO_PUESTOCODIGO.ONOPTIONCLICKED","{handler:'e142S2',iparms:[{av:'Combo_puestocodigo_Selectedvalue_get',ctrl:'COMBO_PUESTOCODIGO',prop:'SelectedValue_get'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("COMBO_PUESTOCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("COMBO_SECCODIGO.ONOPTIONCLICKED","{handler:'e132S2',iparms:[{av:'Combo_seccodigo_Selectedvalue_get',ctrl:'COMBO_SECCODIGO',prop:'SelectedValue_get'},{av:'A1241PuestoDescrip',fld:'PUESTODESCRIP',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A13SecCodigo',fld:'SECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1240PuestoCodigo',fld:'PUESTOCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("COMBO_SECCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'AV102PuestoCodigo_Data',fld:'vPUESTOCODIGO_DATA',pic:''},{av:'Combo_puestocodigo_Selectedvalue_set',ctrl:'COMBO_PUESTOCODIGO',prop:'SelectedValue_set'},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("COMBO_CATCODIGO.ONOPTIONCLICKED","{handler:'e122S2',iparms:[{av:'Combo_catcodigo_Selectedvalue_get',ctrl:'COMBO_CATCODIGO',prop:'SelectedValue_get'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("COMBO_CATCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("COMBO_CONVECODIGO.ONOPTIONCLICKED","{handler:'e112S2',iparms:[{av:'Combo_convecodigo_Selectedvalue_get',ctrl:'COMBO_CONVECODIGO',prop:'SelectedValue_get'},{av:'A123CatDescrip',fld:'CATDESCRIP',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'AV83PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'A1838CatClase',fld:'CATCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("COMBO_CONVECODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV8CatCodigo_Data',fld:'vCATCODIGO_DATA',pic:''},{av:'Combo_catcodigo_Selectedvalue_set',ctrl:'COMBO_CATCODIGO',prop:'SelectedValue_set'},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("VLIQMODTRA.CONTROLVALUECHANGED","{handler:'e202S2',iparms:[{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'AV134sola_opcion_modoPalabra',fld:'vSOLA_OPCION_MODOPALABRA',pic:'',hsh:true},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV145fechasRangoToco',fld:'vFECHASRANGOTOCO',pic:'ZZZ9'},{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'A1817TLiqOrd',fld:'TLIQORD',pic:'ZZZ9'},{av:'A341TLiqHabilitada',fld:'TLIQHABILITADA',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'}]");
      setEventMetadata("VLIQMODTRA.CONTROLVALUECHANGED",",oparms:[{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'edtavLiqperdes_Enabled',ctrl:'vLIQPERDES',prop:'Enabled'},{av:'edtavLiqperhas_Enabled',ctrl:'vLIQPERHAS',prop:'Enabled'},{av:'AV52aguiTLiqCod',fld:'vAGUITLIQCOD',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''}]}");
      setEventMetadata("VLIQSAC.CONTROLVALUECHANGED","{handler:'e212S2',iparms:[{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("VLIQSAC.CONTROLVALUECHANGED",",oparms:[{av:'AV112tocoLiqSac',fld:'vTOCOLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("VCONVENIOFILTRO.CONTROLVALUECHANGED","{handler:'e222S2',iparms:[{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("VCONVENIOFILTRO.CONTROLVALUECHANGED",",oparms:[{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV97ConveCodigo_Data',fld:'vCONVECODIGO_DATA',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV8CatCodigo_Data',fld:'vCATCODIGO_DATA',pic:''},{av:'divTablesplittedconvecodigo_Visible',ctrl:'TABLESPLITTEDCONVECODIGO',prop:'Visible'},{av:'divTablesplittedcatcodigo_Visible',ctrl:'TABLESPLITTEDCATCODIGO',prop:'Visible'},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("VLIQFECPAGO.CONTROLVALUECHANGED","{handler:'e232S2',iparms:[{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV145fechasRangoToco',fld:'vFECHASRANGOTOCO',pic:'ZZZ9'},{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''}]");
      setEventMetadata("VLIQFECPAGO.CONTROLVALUECHANGED",",oparms:[{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'edtavLiqperdes_Enabled',ctrl:'vLIQPERDES',prop:'Enabled'},{av:'edtavLiqperhas_Enabled',ctrl:'vLIQPERHAS',prop:'Enabled'}]}");
      setEventMetadata("VLIQFRECPAG.CONTROLVALUECHANGED","{handler:'e242S2',iparms:[{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'AV134sola_opcion_modoPalabra',fld:'vSOLA_OPCION_MODOPALABRA',pic:'',hsh:true},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV145fechasRangoToco',fld:'vFECHASRANGOTOCO',pic:'ZZZ9'},{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'A1817TLiqOrd',fld:'TLIQORD',pic:'ZZZ9'},{av:'A341TLiqHabilitada',fld:'TLIQHABILITADA',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A123CatDescrip',fld:'CATDESCRIP',pic:''},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'AV83PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'A1838CatClase',fld:'CATCLASE',pic:'9'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("VLIQFRECPAG.CONTROLVALUECHANGED",",oparms:[{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'edtavLiqperdes_Enabled',ctrl:'vLIQPERDES',prop:'Enabled'},{av:'edtavLiqperhas_Enabled',ctrl:'vLIQPERHAS',prop:'Enabled'},{av:'AV52aguiTLiqCod',fld:'vAGUITLIQCOD',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV8CatCodigo_Data',fld:'vCATCODIGO_DATA',pic:''},{av:'Combo_catcodigo_Selectedvalue_set',ctrl:'COMBO_CATCODIGO',prop:'SelectedValue_set'},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("VTLIQCOD.CONTROLVALUECHANGED","{handler:'e252S2',iparms:[{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV112tocoLiqSac',fld:'vTOCOLIQSAC',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV69tocoFechasPrevisional',fld:'vTOCOFECHASPREVISIONAL',pic:''},{av:'cmbavLiqperano'},{av:'AV44LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV145fechasRangoToco',fld:'vFECHASRANGOTOCO',pic:'ZZZ9'},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''}]");
      setEventMetadata("VTLIQCOD.CONTROLVALUECHANGED",",oparms:[{av:'radavAplicaa'},{av:'AV6AplicaA',fld:'vAPLICAA',pic:''},{av:'AV110LiqSacLog',fld:'vLIQSACLOG',pic:''},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'chkavLiqsac.getVisible()',ctrl:'vLIQSAC',prop:'Visible'},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV41LiqDepPrvFec',fld:'vLIQDEPPRVFEC',pic:''},{av:'cmbavLiqdeppermes'},{av:'AV43LiqDepPerMes',fld:'vLIQDEPPERMES',pic:'Z9'},{av:'cmbavLiqdepperano'},{av:'AV42LiqDepPerAno',fld:'vLIQDEPPERANO',pic:'ZZZ9'},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'edtavLiqperdes_Enabled',ctrl:'vLIQPERDES',prop:'Enabled'},{av:'edtavLiqperhas_Enabled',ctrl:'vLIQPERHAS',prop:'Enabled'}]}");
      setEventMetadata("VLIQPERMES.CONTROLVALUECHANGED","{handler:'e262S2',iparms:[{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1817TLiqOrd',fld:'TLIQORD',pic:'ZZZ9'},{av:'A341TLiqHabilitada',fld:'TLIQHABILITADA',pic:''},{av:'A32TLiqCod',fld:'TLIQCOD',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134sola_opcion_modoPalabra',fld:'vSOLA_OPCION_MODOPALABRA',pic:'',hsh:true},{av:'cmbavLiqperano'},{av:'AV44LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV69tocoFechasPrevisional',fld:'vTOCOFECHASPREVISIONAL',pic:''},{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV145fechasRangoToco',fld:'vFECHASRANGOTOCO',pic:'ZZZ9'},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV112tocoLiqSac',fld:'vTOCOLIQSAC',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("VLIQPERMES.CONTROLVALUECHANGED",",oparms:[{av:'AV52aguiTLiqCod',fld:'vAGUITLIQCOD',pic:''},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV41LiqDepPrvFec',fld:'vLIQDEPPRVFEC',pic:''},{av:'cmbavLiqdeppermes'},{av:'AV43LiqDepPerMes',fld:'vLIQDEPPERMES',pic:'Z9'},{av:'cmbavLiqdepperano'},{av:'AV42LiqDepPerAno',fld:'vLIQDEPPERANO',pic:'ZZZ9'},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'edtavLiqperdes_Enabled',ctrl:'vLIQPERDES',prop:'Enabled'},{av:'edtavLiqperhas_Enabled',ctrl:'vLIQPERHAS',prop:'Enabled'},{av:'AV110LiqSacLog',fld:'vLIQSACLOG',pic:''},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'chkavLiqsac.getVisible()',ctrl:'vLIQSAC',prop:'Visible'},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("VLIQPERANO.ISVALID","{handler:'e272S2',iparms:[{av:'cmbavLiqperano'},{av:'AV44LiqPerAno',fld:'vLIQPERANO',pic:'ZZZ9'},{av:'cmbavLiqpermes'},{av:'AV45LiqPerMes',fld:'vLIQPERMES',pic:'Z9'},{av:'AV32CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV155Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV11EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'cmbavTliqcod'},{av:'AV26TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV55egresoTLiqCod',fld:'vEGRESOTLIQCOD',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A235LegClase',fld:'LEGCLASE',pic:'9'},{av:'cmbavLiqfrecpag'},{av:'AV126LiqFrecPag',fld:'vLIQFRECPAG',pic:'9'},{av:'A2404LegModTra',fld:'LEGMODTRA',pic:''},{av:'cmbavLiqmodtra'},{av:'AV124LiqModTra',fld:'vLIQMODTRA',pic:''},{av:'A2417LegTipoTarifa',fld:'LEGTIPOTARIFA',pic:''},{av:'cmbavLiqtipotarifa'},{av:'AV146LiqTipoTarifa',fld:'vLIQTIPOTARIFA',pic:''},{av:'A245LegFecIngreso',fld:'LEGFECINGRESO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV82ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'cmbavConveniofiltro'},{av:'AV104ConvenioFiltro',fld:'vCONVENIOFILTRO',pic:''},{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV24SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV100PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV101SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV69tocoFechasPrevisional',fld:'vTOCOFECHASPREVISIONAL',pic:''},{av:'AV70tocoFechaPago',fld:'vTOCOFECHAPAGO',pic:''},{av:'AV65quincenaTLiqCod',fld:'vQUINCENATLIQCOD',pic:'',hsh:true},{av:'AV111mensualTLiqCod',fld:'vMENSUALTLIQCOD',pic:'',hsh:true},{av:'AV23Modo',fld:'vMODO',pic:''},{av:'AV145fechasRangoToco',fld:'vFECHASRANGOTOCO',pic:'ZZZ9'},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV112tocoLiqSac',fld:'vTOCOLIQSAC',pic:''},{av:'AV107modificoNombre',fld:'vMODIFICONOMBRE',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''}]");
      setEventMetadata("VLIQPERANO.ISVALID",",oparms:[{av:'AV58LiqPeriodo',fld:'vLIQPERIODO',pic:''},{av:'AV78LiqPerPalabra',fld:'vLIQPERPALABRA',pic:''},{av:'AV14LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'AV79menos1LiqPeriodo',fld:'vMENOS1LIQPERIODO',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV41LiqDepPrvFec',fld:'vLIQDEPPRVFEC',pic:''},{av:'cmbavLiqdeppermes'},{av:'AV43LiqDepPerMes',fld:'vLIQDEPPERMES',pic:'Z9'},{av:'cmbavLiqdepperano'},{av:'AV42LiqDepPerAno',fld:'vLIQDEPPERANO',pic:'ZZZ9'},{av:'AV37LiqFecPago',fld:'vLIQFECPAGO',pic:''},{av:'AV128LiqPerHas',fld:'vLIQPERHAS',pic:''},{av:'AV127LiqPerDes',fld:'vLIQPERDES',pic:''},{av:'edtavLiqperdes_Enabled',ctrl:'vLIQPERDES',prop:'Enabled'},{av:'edtavLiqperhas_Enabled',ctrl:'vLIQPERHAS',prop:'Enabled'},{av:'AV110LiqSacLog',fld:'vLIQSACLOG',pic:''},{av:'AV109sacEs',fld:'vSACES',pic:'9'},{av:'AV108LiqSac',fld:'vLIQSAC',pic:''},{av:'chkavLiqsac.getVisible()',ctrl:'vLIQSAC',prop:'Visible'},{av:'AV66LiqNombre',fld:'vLIQNOMBRE',pic:''},{av:'AV93finDeMesFecha',fld:'vFINDEMESFECHA',pic:''}]}");
      setEventMetadata("VALIDV_LIQPERMES","{handler:'validv_Liqpermes',iparms:[]");
      setEventMetadata("VALIDV_LIQPERMES",",oparms:[]}");
      setEventMetadata("VALIDV_LIQMODTRA","{handler:'validv_Liqmodtra',iparms:[]");
      setEventMetadata("VALIDV_LIQMODTRA",",oparms:[]}");
      setEventMetadata("VALIDV_LIQTIPOTARIFA","{handler:'validv_Liqtipotarifa',iparms:[]");
      setEventMetadata("VALIDV_LIQTIPOTARIFA",",oparms:[]}");
      setEventMetadata("VALIDV_LIQFRECPAG","{handler:'validv_Liqfrecpag',iparms:[]");
      setEventMetadata("VALIDV_LIQFRECPAG",",oparms:[]}");
      setEventMetadata("VALIDV_CONVENIOFILTRO","{handler:'validv_Conveniofiltro',iparms:[]");
      setEventMetadata("VALIDV_CONVENIOFILTRO",",oparms:[]}");
      setEventMetadata("VALIDV_LIQDEPPERMES","{handler:'validv_Liqdeppermes',iparms:[]");
      setEventMetadata("VALIDV_LIQDEPPERMES",",oparms:[]}");
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
      wcpOAV94MenuOpcCod = "" ;
      wcpOAV23Modo = "" ;
      Dvelop_confirmpanel_enter_Result = "" ;
      Combo_liqdepbancod_Selectedvalue_get = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      Combo_succodigo_Selectedvalue_get = "" ;
      Combo_puestocodigo_Selectedvalue_get = "" ;
      Combo_seccodigo_Selectedvalue_get = "" ;
      Combo_catcodigo_Selectedvalue_get = "" ;
      Combo_convecodigo_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV94MenuOpcCod = "" ;
      AV23Modo = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV155Pgmname = "" ;
      AV68vacacionesTLiqCod = "" ;
      AV65quincenaTLiqCod = "" ;
      AV111mensualTLiqCod = "" ;
      AV47dummyDate = GXutil.nullDate() ;
      AV134sola_opcion_modoPalabra = "" ;
      GXKey = "" ;
      AV10DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV97ConveCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV8CatCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV25SecCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV102PuestoCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV103SucCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV14LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV46LiqDepBanCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV13LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV82ConveCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV7CatCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24SecCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100PuestoCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV101SucCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52aguiTLiqCod = "" ;
      A250LegIdNomApe = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A2404LegModTra = "" ;
      A2417LegTipoTarifa = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A937LegConveCodigo = "" ;
      A939LegCatCodigo = "" ;
      A1579LegSecCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      A1577LegSucCodigo = "" ;
      AV78LiqPerPalabra = "" ;
      A1241PuestoDescrip = "" ;
      A13SecCodigo = "" ;
      A1240PuestoCodigo = "" ;
      A123CatDescrip = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      AV63confirmarRespuesta = "" ;
      AV110LiqSacLog = "" ;
      A32TLiqCod = "" ;
      Combo_convecodigo_Selectedvalue_set = "" ;
      Combo_catcodigo_Selectedvalue_set = "" ;
      Combo_seccodigo_Selectedvalue_set = "" ;
      Combo_puestocodigo_Selectedvalue_set = "" ;
      Combo_succodigo_Selectedvalue_set = "" ;
      Combo_legnumero_Selectedvalue_set = "" ;
      Combo_liqdepbancod_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV124LiqModTra = "" ;
      AV146LiqTipoTarifa = "" ;
      AV26TLiqCod = "" ;
      AV37LiqFecPago = GXutil.nullDate() ;
      AV127LiqPerDes = GXutil.nullDate() ;
      AV128LiqPerHas = GXutil.nullDate() ;
      AV104ConvenioFiltro = "" ;
      lblTextblockcombo_convecodigo_Jsonclick = "" ;
      ucCombo_convecodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_catcodigo_Jsonclick = "" ;
      ucCombo_catcodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_seccodigo_Jsonclick = "" ;
      ucCombo_seccodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_puestocodigo_Jsonclick = "" ;
      ucCombo_puestocodigo = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_succodigo_Jsonclick = "" ;
      ucCombo_succodigo = new com.genexus.webpanels.GXUserControl();
      AV6AplicaA = "" ;
      lblTextblockcombo_legnumero_Jsonclick = "" ;
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      AV66LiqNombre = "" ;
      AV36LiqDescrip = "" ;
      ucDvpanel_tableprevi = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_liqdepbancod_Jsonclick = "" ;
      ucCombo_liqdepbancod = new com.genexus.webpanels.GXUserControl();
      Combo_liqdepbancod_Caption = "" ;
      AV41LiqDepPrvFec = GXutil.nullDate() ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      AV40LiqDepBanCod = "" ;
      AV30EstadoAccion = "" ;
      AV18LiqFecha = GXutil.nullDate() ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV55egresoTLiqCod = "" ;
      AV59gananciasTLiqCod = "" ;
      AV58LiqPeriodo = GXutil.nullDate() ;
      AV79menos1LiqPeriodo = GXutil.nullDate() ;
      AV93finDeMesFecha = GXutil.nullDate() ;
      AV84hoy = GXutil.nullDate() ;
      GXt_decimal8 = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      AV38inicialLiqFecPago = GXutil.nullDate() ;
      GXv_char4 = new String[1] ;
      GXv_date12 = new java.util.Date[1] ;
      GXv_int13 = new byte[1] ;
      GXv_char3 = new String[1] ;
      GXv_int14 = new byte[1] ;
      GXv_char15 = new String[1] ;
      GXv_char16 = new String[1] ;
      GXv_char18 = new String[1] ;
      GXv_int19 = new byte[1] ;
      GXv_date20 = new java.util.Date[1] ;
      GXv_char21 = new String[1] ;
      GXv_date22 = new java.util.Date[1] ;
      GXv_int10 = new short[1] ;
      GXv_int23 = new byte[1] ;
      GXv_int5 = new short[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons30 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucDvelop_confirmpanel_enter = new com.genexus.webpanels.GXUserControl();
      AV92procesandoERror = "" ;
      AV62confirmar_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV28mensaje = "" ;
      AV27LegNoAplican = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV76LegNoAplican2 = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV71AdelVacLegNoAplican = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV72adelVacConCodigo = "" ;
      AV77adelVacMesActualConcodigo = "" ;
      GXv_objcol_int31 = new GXSimpleCollection[1] ;
      GXv_objcol_int17 = new GXSimpleCollection[1] ;
      AV64window = new com.genexus.webpanels.GXWindow();
      AV89websession = httpContext.getWebSession();
      scmdbuf = "" ;
      H002S2_A3CliCod = new int[1] ;
      H002S2_A1EmpCod = new short[1] ;
      H002S2_A1966EmpBanCod = new String[] {""} ;
      H002S2_A1967EmpBanDescrip = new String[] {""} ;
      A1966EmpBanCod = "" ;
      A1967EmpBanDescrip = "" ;
      AV9Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      H002S3_A3CliCod = new int[1] ;
      H002S3_A1EmpCod = new short[1] ;
      H002S3_A1818LegEstado = new byte[1] ;
      H002S3_A235LegClase = new byte[1] ;
      H002S3_A2404LegModTra = new String[] {""} ;
      H002S3_A2417LegTipoTarifa = new String[] {""} ;
      H002S3_A1577LegSucCodigo = new String[] {""} ;
      H002S3_n1577LegSucCodigo = new boolean[] {false} ;
      H002S3_A1578LegPuesCodigo = new String[] {""} ;
      H002S3_n1578LegPuesCodigo = new boolean[] {false} ;
      H002S3_A1579LegSecCodigo = new String[] {""} ;
      H002S3_n1579LegSecCodigo = new boolean[] {false} ;
      H002S3_A939LegCatCodigo = new String[] {""} ;
      H002S3_n939LegCatCodigo = new boolean[] {false} ;
      H002S3_A937LegConveCodigo = new String[] {""} ;
      H002S3_n937LegConveCodigo = new boolean[] {false} ;
      H002S3_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H002S3_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      H002S3_n244LegFecEgreso = new boolean[] {false} ;
      H002S3_A6LegNumero = new int[1] ;
      H002S3_A250LegIdNomApe = new String[] {""} ;
      H002S4_A3CliCod = new int[1] ;
      H002S4_A1EmpCod = new short[1] ;
      H002S4_A1243SucCodigo = new String[] {""} ;
      H002S4_A1244SucDescrip = new String[] {""} ;
      A1243SucCodigo = "" ;
      A1244SucDescrip = "" ;
      H002S5_A3CliCod = new int[1] ;
      H002S5_A13SecCodigo = new String[] {""} ;
      H002S5_A1240PuestoCodigo = new String[] {""} ;
      H002S5_A1241PuestoDescrip = new String[] {""} ;
      H002S6_A3CliCod = new int[1] ;
      H002S6_A13SecCodigo = new String[] {""} ;
      H002S6_A329SecDescrip = new String[] {""} ;
      A329SecDescrip = "" ;
      H002S7_A3CliCod = new int[1] ;
      H002S7_A1564CliPaiConve = new short[1] ;
      H002S7_A1838CatClase = new byte[1] ;
      H002S7_A1565CliConvenio = new String[] {""} ;
      H002S7_A8CatCodigo = new String[] {""} ;
      H002S7_A123CatDescrip = new String[] {""} ;
      H002S8_A1564CliPaiConve = new short[1] ;
      H002S8_A3CliCod = new int[1] ;
      H002S8_A1565CliConvenio = new String[] {""} ;
      H002S8_A1567CliConvenioDescrip = new String[] {""} ;
      A1567CliConvenioDescrip = "" ;
      GXv_int7 = new int[1] ;
      AV119clientId = "" ;
      AV99ServerSocket = new com.genexuscore.genexus.server.SdtSocket(remoteHandle, context);
      GXt_dtime32 = GXutil.resetTime( GXutil.nullDate() );
      AV123vaciaFecha = GXutil.nullDate() ;
      AV139unicoLiqModTra = "" ;
      H002S9_A6LegNumero = new int[1] ;
      H002S9_A3CliCod = new int[1] ;
      H002S9_A1EmpCod = new short[1] ;
      H002S9_A2404LegModTra = new String[] {""} ;
      AV138modo_trabajo = "" ;
      AV60anterior = "" ;
      AV144unicoTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      H002S10_A3CliCod = new int[1] ;
      H002S10_A341TLiqHabilitada = new boolean[] {false} ;
      H002S10_A32TLiqCod = new String[] {""} ;
      H002S10_A1817TLiqOrd = new short[1] ;
      GXv_boolean11 = new boolean[1] ;
      AV141TLiqDescAuxFrec = "" ;
      GXv_char25 = new String[1] ;
      GXv_int24 = new byte[1] ;
      GXv_char26 = new String[1] ;
      GXv_date28 = new java.util.Date[1] ;
      GXv_date27 = new java.util.Date[1] ;
      H002S11_A6LegNumero = new int[1] ;
      H002S11_A2404LegModTra = new String[] {""} ;
      H002S11_A1818LegEstado = new byte[1] ;
      H002S11_A1EmpCod = new short[1] ;
      H002S11_A3CliCod = new int[1] ;
      H002S11_A235LegClase = new byte[1] ;
      AV147unicoLiqTipoTarifa = "" ;
      H002S12_A6LegNumero = new int[1] ;
      H002S12_A2404LegModTra = new String[] {""} ;
      H002S12_A1818LegEstado = new byte[1] ;
      H002S12_A1EmpCod = new short[1] ;
      H002S12_A3CliCod = new int[1] ;
      H002S12_A2417LegTipoTarifa = new String[] {""} ;
      AV152tipo_tarifa = "" ;
      sStyleString = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV94MenuOpcCod = "" ;
      sCtrlAV23Modo = "" ;
      sCtrlAV32CliCod = "" ;
      sCtrlAV11EmpCod = "" ;
      sCtrlAV20LiqNroPar = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionabm__default(),
         new Object[] {
             new Object[] {
            H002S2_A3CliCod, H002S2_A1EmpCod, H002S2_A1966EmpBanCod, H002S2_A1967EmpBanDescrip
            }
            , new Object[] {
            H002S3_A3CliCod, H002S3_A1EmpCod, H002S3_A1818LegEstado, H002S3_A235LegClase, H002S3_A2404LegModTra, H002S3_A2417LegTipoTarifa, H002S3_A1577LegSucCodigo, H002S3_n1577LegSucCodigo, H002S3_A1578LegPuesCodigo, H002S3_n1578LegPuesCodigo,
            H002S3_A1579LegSecCodigo, H002S3_n1579LegSecCodigo, H002S3_A939LegCatCodigo, H002S3_n939LegCatCodigo, H002S3_A937LegConveCodigo, H002S3_n937LegConveCodigo, H002S3_A245LegFecIngreso, H002S3_A244LegFecEgreso, H002S3_n244LegFecEgreso, H002S3_A6LegNumero,
            H002S3_A250LegIdNomApe
            }
            , new Object[] {
            H002S4_A3CliCod, H002S4_A1EmpCod, H002S4_A1243SucCodigo, H002S4_A1244SucDescrip
            }
            , new Object[] {
            H002S5_A3CliCod, H002S5_A13SecCodigo, H002S5_A1240PuestoCodigo, H002S5_A1241PuestoDescrip
            }
            , new Object[] {
            H002S6_A3CliCod, H002S6_A13SecCodigo, H002S6_A329SecDescrip
            }
            , new Object[] {
            H002S7_A3CliCod, H002S7_A1564CliPaiConve, H002S7_A1838CatClase, H002S7_A1565CliConvenio, H002S7_A8CatCodigo, H002S7_A123CatDescrip
            }
            , new Object[] {
            H002S8_A1564CliPaiConve, H002S8_A3CliCod, H002S8_A1565CliConvenio, H002S8_A1567CliConvenioDescrip
            }
            , new Object[] {
            H002S9_A6LegNumero, H002S9_A3CliCod, H002S9_A1EmpCod, H002S9_A2404LegModTra
            }
            , new Object[] {
            H002S10_A3CliCod, H002S10_A341TLiqHabilitada, H002S10_A32TLiqCod, H002S10_A1817TLiqOrd
            }
            , new Object[] {
            H002S11_A6LegNumero, H002S11_A2404LegModTra, H002S11_A1818LegEstado, H002S11_A1EmpCod, H002S11_A3CliCod, H002S11_A235LegClase
            }
            , new Object[] {
            H002S12_A6LegNumero, H002S12_A2404LegModTra, H002S12_A1818LegEstado, H002S12_A1EmpCod, H002S12_A3CliCod, H002S12_A2417LegTipoTarifa
            }
         }
      );
      AV155Pgmname = "LiquidacionABM" ;
      /* GeneXus formulas. */
      AV155Pgmname = "LiquidacionABM" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV16LiqClase ;
   private byte AV5LiqEstado ;
   private byte A1818LegEstado ;
   private byte A235LegClase ;
   private byte AV109sacEs ;
   private byte A1838CatClase ;
   private byte AV45LiqPerMes ;
   private byte AV126LiqFrecPag ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte AV43LiqDepPerMes ;
   private byte GXv_int13[] ;
   private byte GXv_int14[] ;
   private byte GXv_int19[] ;
   private byte GXv_int23[] ;
   private byte AV67LegClase ;
   private byte GXt_int33 ;
   private byte GXv_int24[] ;
   private byte AV140unicoLiqFrecPag ;
   private byte AV142ClaseLeg ;
   private byte nGXWrapped ;
   private short wcpOAV11EmpCod ;
   private short nRcdExists_14 ;
   private short nIsMod_14 ;
   private short nRcdExists_13 ;
   private short nIsMod_13 ;
   private short nRcdExists_12 ;
   private short nIsMod_12 ;
   private short nRcdExists_10 ;
   private short nIsMod_10 ;
   private short nRcdExists_11 ;
   private short nIsMod_11 ;
   private short nRcdExists_9 ;
   private short nIsMod_9 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV11EmpCod ;
   private short AV83PaiCod ;
   private short A1EmpCod ;
   private short A1564CliPaiConve ;
   private short AV145fechasRangoToco ;
   private short A1817TLiqOrd ;
   private short wbEnd ;
   private short wbStart ;
   private short AV44LiqPerAno ;
   private short gxcookieaux ;
   private short AV42LiqDepPerAno ;
   private short Gx_err ;
   private short AV86anioHoy ;
   private short AV88anio ;
   private short AV85anioPasado ;
   private short GXv_int10[] ;
   private short GXv_int5[] ;
   private short AV87updAnio ;
   private short AV105l ;
   private short AV29i ;
   private short AV113predetLiquidaSac ;
   private short AV125cntModos ;
   private short AV136tliqCant ;
   private short AV133frecsCnt ;
   private short AV151tarfiassCnt ;
   private int wcpOAV32CliCod ;
   private int wcpOAV20LiqNroPar ;
   private int AV32CliCod ;
   private int AV20LiqNroPar ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int edtavLiqfecpago_Enabled ;
   private int edtavLiqperdes_Enabled ;
   private int edtavLiqperhas_Enabled ;
   private int divTablesplittedconvecodigo_Visible ;
   private int divTablesplittedcatcodigo_Visible ;
   private int divTablesplittedlegnumero_Visible ;
   private int edtavLiqnombre_Enabled ;
   private int edtavLiqdescrip_Enabled ;
   private int edtavLiqdepprvfec_Enabled ;
   private int bttBtnenter_Visible ;
   private int edtavLiqdepbancod_Visible ;
   private int edtavLiqdepbancod_Enabled ;
   private int edtavEstadoaccion_Visible ;
   private int edtavLiqfecha_Visible ;
   private int edtavLiqfecha_Enabled ;
   private int AV19LiqNro ;
   private int edtavLiqnro_Visible ;
   private int tblTableinvi_Visible ;
   private int AV54procesandoLiqNro ;
   private int AV51dupliLiqnro ;
   private int AV82ConveCodigo_size ;
   private int AV7CatCodigo_size ;
   private int AV24SecCodigo_size ;
   private int AV100PuestoCodigo_size ;
   private int AV101SucCodigo_size ;
   private int AV158GXV1 ;
   private int AV161GXV2 ;
   private int AV164GXV3 ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private int edtavEgresotliqcod_Enabled ;
   private int edtavGananciastliqcod_Enabled ;
   private int edtavLiqperiodo_Enabled ;
   private int edtavMenos1liqperiodo_Enabled ;
   private int edtavFindemesfecha_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal GXt_decimal8 ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private String wcpOAV23Modo ;
   private String Dvelop_confirmpanel_enter_Result ;
   private String Combo_liqdepbancod_Selectedvalue_get ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String Combo_succodigo_Selectedvalue_get ;
   private String Combo_puestocodigo_Selectedvalue_get ;
   private String Combo_seccodigo_Selectedvalue_get ;
   private String Combo_catcodigo_Selectedvalue_get ;
   private String Combo_convecodigo_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String AV23Modo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV155Pgmname ;
   private String AV68vacacionesTLiqCod ;
   private String AV65quincenaTLiqCod ;
   private String AV111mensualTLiqCod ;
   private String AV134sola_opcion_modoPalabra ;
   private String GXKey ;
   private String AV52aguiTLiqCod ;
   private String A2404LegModTra ;
   private String A2417LegTipoTarifa ;
   private String A937LegConveCodigo ;
   private String A939LegCatCodigo ;
   private String A1579LegSecCodigo ;
   private String A1578LegPuesCodigo ;
   private String A1577LegSucCodigo ;
   private String AV78LiqPerPalabra ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV63confirmarRespuesta ;
   private String A32TLiqCod ;
   private String Combo_convecodigo_Cls ;
   private String Combo_convecodigo_Selectedvalue_set ;
   private String Combo_convecodigo_Multiplevaluestype ;
   private String Combo_convecodigo_Emptyitemtext ;
   private String Combo_catcodigo_Cls ;
   private String Combo_catcodigo_Selectedvalue_set ;
   private String Combo_catcodigo_Multiplevaluestype ;
   private String Combo_catcodigo_Emptyitemtext ;
   private String Combo_seccodigo_Cls ;
   private String Combo_seccodigo_Selectedvalue_set ;
   private String Combo_seccodigo_Multiplevaluestype ;
   private String Combo_seccodigo_Emptyitemtext ;
   private String Combo_puestocodigo_Cls ;
   private String Combo_puestocodigo_Selectedvalue_set ;
   private String Combo_puestocodigo_Multiplevaluestype ;
   private String Combo_puestocodigo_Emptyitemtext ;
   private String Combo_succodigo_Cls ;
   private String Combo_succodigo_Selectedvalue_set ;
   private String Combo_succodigo_Multiplevaluestype ;
   private String Combo_succodigo_Emptyitemtext ;
   private String Combo_legnumero_Cls ;
   private String Combo_legnumero_Selectedvalue_set ;
   private String Combo_legnumero_Multiplevaluestype ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Combo_liqdepbancod_Cls ;
   private String Combo_liqdepbancod_Selectedvalue_set ;
   private String Dvpanel_tableprevi_Width ;
   private String Dvpanel_tableprevi_Cls ;
   private String Dvpanel_tableprevi_Title ;
   private String Dvpanel_tableprevi_Iconposition ;
   private String Dvelop_confirmpanel_enter_Title ;
   private String Dvelop_confirmpanel_enter_Confirmationtext ;
   private String Dvelop_confirmpanel_enter_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_enter_Nobuttoncaption ;
   private String Dvelop_confirmpanel_enter_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_enter_Yesbuttonposition ;
   private String Dvelop_confirmpanel_enter_Confirmtype ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String AV124LiqModTra ;
   private String AV146LiqTipoTarifa ;
   private String AV26TLiqCod ;
   private String edtavLiqfecpago_Internalname ;
   private String edtavLiqfecpago_Jsonclick ;
   private String edtavLiqperdes_Internalname ;
   private String edtavLiqperdes_Jsonclick ;
   private String edtavLiqperhas_Internalname ;
   private String edtavLiqperhas_Jsonclick ;
   private String AV104ConvenioFiltro ;
   private String divTablesplittedconvecodigo_Internalname ;
   private String lblTextblockcombo_convecodigo_Internalname ;
   private String lblTextblockcombo_convecodigo_Jsonclick ;
   private String Combo_convecodigo_Caption ;
   private String Combo_convecodigo_Internalname ;
   private String divTablesplittedcatcodigo_Internalname ;
   private String lblTextblockcombo_catcodigo_Internalname ;
   private String lblTextblockcombo_catcodigo_Jsonclick ;
   private String Combo_catcodigo_Caption ;
   private String Combo_catcodigo_Internalname ;
   private String divTablesplittedseccodigo_Internalname ;
   private String lblTextblockcombo_seccodigo_Internalname ;
   private String lblTextblockcombo_seccodigo_Jsonclick ;
   private String Combo_seccodigo_Caption ;
   private String Combo_seccodigo_Internalname ;
   private String divTablesplittedpuestocodigo_Internalname ;
   private String lblTextblockcombo_puestocodigo_Internalname ;
   private String lblTextblockcombo_puestocodigo_Jsonclick ;
   private String Combo_puestocodigo_Caption ;
   private String Combo_puestocodigo_Internalname ;
   private String divTablesplittedsuccodigo_Internalname ;
   private String lblTextblockcombo_succodigo_Internalname ;
   private String lblTextblockcombo_succodigo_Jsonclick ;
   private String Combo_succodigo_Caption ;
   private String Combo_succodigo_Internalname ;
   private String AV6AplicaA ;
   private String divTablesplittedlegnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String Combo_legnumero_Internalname ;
   private String edtavLiqnombre_Internalname ;
   private String edtavLiqdescrip_Internalname ;
   private String Dvpanel_tableprevi_Internalname ;
   private String divTableprevi_Internalname ;
   private String divTablesplittedliqdepbancod_Internalname ;
   private String lblTextblockcombo_liqdepbancod_Internalname ;
   private String lblTextblockcombo_liqdepbancod_Jsonclick ;
   private String Combo_liqdepbancod_Caption ;
   private String Combo_liqdepbancod_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String edtavLiqdepprvfec_Internalname ;
   private String edtavLiqdepprvfec_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavLiqdepbancod_Internalname ;
   private String AV40LiqDepBanCod ;
   private String edtavLiqdepbancod_Jsonclick ;
   private String edtavEstadoaccion_Internalname ;
   private String AV30EstadoAccion ;
   private String edtavEstadoaccion_Jsonclick ;
   private String edtavLiqfecha_Internalname ;
   private String edtavLiqfecha_Jsonclick ;
   private String edtavLiqnro_Internalname ;
   private String edtavLiqnro_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV55egresoTLiqCod ;
   private String edtavEgresotliqcod_Internalname ;
   private String AV59gananciasTLiqCod ;
   private String edtavGananciastliqcod_Internalname ;
   private String edtavLiqperiodo_Internalname ;
   private String edtavMenos1liqperiodo_Internalname ;
   private String edtavFindemesfecha_Internalname ;
   private String tblTableinvi_Internalname ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char15[] ;
   private String GXv_char16[] ;
   private String GXv_char18[] ;
   private String GXv_char21[] ;
   private String Dvelop_confirmpanel_enter_Internalname ;
   private String AV72adelVacConCodigo ;
   private String AV77adelVacMesActualConcodigo ;
   private String scmdbuf ;
   private String A1966EmpBanCod ;
   private String A1243SucCodigo ;
   private String AV139unicoLiqModTra ;
   private String AV138modo_trabajo ;
   private String AV60anterior ;
   private String AV144unicoTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char25[] ;
   private String GXv_char26[] ;
   private String AV147unicoLiqTipoTarifa ;
   private String AV152tipo_tarifa ;
   private String sStyleString ;
   private String tblTabledvelop_confirmpanel_enter_Internalname ;
   private String edtavEgresotliqcod_Jsonclick ;
   private String edtavGananciastliqcod_Jsonclick ;
   private String edtavLiqperiodo_Jsonclick ;
   private String edtavMenos1liqperiodo_Jsonclick ;
   private String edtavFindemesfecha_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String sCtrlAV94MenuOpcCod ;
   private String sCtrlAV23Modo ;
   private String sCtrlAV32CliCod ;
   private String sCtrlAV11EmpCod ;
   private String sCtrlAV20LiqNroPar ;
   private java.util.Date GXt_dtime32 ;
   private java.util.Date AV47dummyDate ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date AV37LiqFecPago ;
   private java.util.Date AV127LiqPerDes ;
   private java.util.Date AV128LiqPerHas ;
   private java.util.Date AV41LiqDepPrvFec ;
   private java.util.Date AV18LiqFecha ;
   private java.util.Date AV58LiqPeriodo ;
   private java.util.Date AV79menos1LiqPeriodo ;
   private java.util.Date AV93finDeMesFecha ;
   private java.util.Date AV84hoy ;
   private java.util.Date AV38inicialLiqFecPago ;
   private java.util.Date GXv_date12[] ;
   private java.util.Date GXv_date20[] ;
   private java.util.Date GXv_date22[] ;
   private java.util.Date AV123vaciaFecha ;
   private java.util.Date GXv_date28[] ;
   private java.util.Date GXv_date27[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV107modificoNombre ;
   private boolean AV70tocoFechaPago ;
   private boolean A341TLiqHabilitada ;
   private boolean AV112tocoLiqSac ;
   private boolean AV69tocoFechasPrevisional ;
   private boolean Combo_convecodigo_Allowmultipleselection ;
   private boolean Combo_convecodigo_Includeonlyselectedoption ;
   private boolean Combo_catcodigo_Allowmultipleselection ;
   private boolean Combo_catcodigo_Includeonlyselectedoption ;
   private boolean Combo_seccodigo_Enabled ;
   private boolean Combo_seccodigo_Allowmultipleselection ;
   private boolean Combo_seccodigo_Includeonlyselectedoption ;
   private boolean Combo_puestocodigo_Enabled ;
   private boolean Combo_puestocodigo_Allowmultipleselection ;
   private boolean Combo_puestocodigo_Includeonlyselectedoption ;
   private boolean Combo_succodigo_Enabled ;
   private boolean Combo_succodigo_Allowmultipleselection ;
   private boolean Combo_succodigo_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Enabled ;
   private boolean Combo_legnumero_Allowmultipleselection ;
   private boolean Combo_legnumero_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_liqdepbancod_Enabled ;
   private boolean Dvpanel_tableprevi_Autowidth ;
   private boolean Dvpanel_tableprevi_Autoheight ;
   private boolean Dvpanel_tableprevi_Collapsible ;
   private boolean Dvpanel_tableprevi_Collapsed ;
   private boolean Dvpanel_tableprevi_Showcollapseicon ;
   private boolean Dvpanel_tableprevi_Autoscroll ;
   private boolean wbLoad ;
   private boolean AV108LiqSac ;
   private boolean AV80insert ;
   private boolean AV81update ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV39hayPendientesDeCerrar ;
   private boolean AV95actPendHay ;
   private boolean AV12error ;
   private boolean AV57egresoOK ;
   private boolean AV50duplica ;
   private boolean n1577LegSucCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n939LegCatCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean n244LegFecEgreso ;
   private boolean AV106validoEs ;
   private boolean brk2S10 ;
   private boolean AV61permanece ;
   private boolean AV143anteriorExiste ;
   private boolean AV135existe ;
   private boolean GXv_boolean11[] ;
   private boolean AV129diarioHay ;
   private boolean AV130semanalHay ;
   private boolean AV131quincenalHay ;
   private boolean AV132mensualHay ;
   private boolean AV148porHoraHay ;
   private boolean AV150porPeriodoHay ;
   private String wcpOAV94MenuOpcCod ;
   private String AV94MenuOpcCod ;
   private String A250LegIdNomApe ;
   private String A1241PuestoDescrip ;
   private String A123CatDescrip ;
   private String AV110LiqSacLog ;
   private String AV66LiqNombre ;
   private String AV36LiqDescrip ;
   private String AV92procesandoERror ;
   private String AV28mensaje ;
   private String A1967EmpBanDescrip ;
   private String A1244SucDescrip ;
   private String A329SecDescrip ;
   private String A1567CliConvenioDescrip ;
   private String AV119clientId ;
   private String AV141TLiqDescAuxFrec ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private GXSimpleCollection<Integer> AV62confirmar_LegNumero ;
   private GXSimpleCollection<Integer> AV27LegNoAplican ;
   private GXSimpleCollection<Integer> AV76LegNoAplican2 ;
   private GXSimpleCollection<Integer> AV71AdelVacLegNoAplican ;
   private GXSimpleCollection<Integer> GXv_objcol_int31[] ;
   private GXSimpleCollection<Integer> GXv_objcol_int17[] ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.GXWindow AV64window ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_convecodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_catcodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_seccodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_puestocodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_succodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableprevi ;
   private com.genexus.webpanels.GXUserControl ucCombo_liqdepbancod ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_enter ;
   private com.genexuscore.genexus.server.SdtSocket AV99ServerSocket ;
   private HTMLChoice cmbavLiqperano ;
   private HTMLChoice cmbavLiqpermes ;
   private HTMLChoice cmbavLiqmodtra ;
   private HTMLChoice cmbavLiqtipotarifa ;
   private HTMLChoice cmbavLiqfrecpag ;
   private HTMLChoice cmbavTliqcod ;
   private ICheckbox chkavLiqsac ;
   private HTMLChoice cmbavConveniofiltro ;
   private HTMLChoice radavAplicaa ;
   private HTMLChoice cmbavLiqdepperano ;
   private HTMLChoice cmbavLiqdeppermes ;
   private ICheckbox chkavInsert ;
   private ICheckbox chkavUpdate ;
   private IDataStoreProvider pr_default ;
   private int[] H002S2_A3CliCod ;
   private short[] H002S2_A1EmpCod ;
   private String[] H002S2_A1966EmpBanCod ;
   private String[] H002S2_A1967EmpBanDescrip ;
   private int[] H002S3_A3CliCod ;
   private short[] H002S3_A1EmpCod ;
   private byte[] H002S3_A1818LegEstado ;
   private byte[] H002S3_A235LegClase ;
   private String[] H002S3_A2404LegModTra ;
   private String[] H002S3_A2417LegTipoTarifa ;
   private String[] H002S3_A1577LegSucCodigo ;
   private boolean[] H002S3_n1577LegSucCodigo ;
   private String[] H002S3_A1578LegPuesCodigo ;
   private boolean[] H002S3_n1578LegPuesCodigo ;
   private String[] H002S3_A1579LegSecCodigo ;
   private boolean[] H002S3_n1579LegSecCodigo ;
   private String[] H002S3_A939LegCatCodigo ;
   private boolean[] H002S3_n939LegCatCodigo ;
   private String[] H002S3_A937LegConveCodigo ;
   private boolean[] H002S3_n937LegConveCodigo ;
   private java.util.Date[] H002S3_A245LegFecIngreso ;
   private java.util.Date[] H002S3_A244LegFecEgreso ;
   private boolean[] H002S3_n244LegFecEgreso ;
   private int[] H002S3_A6LegNumero ;
   private String[] H002S3_A250LegIdNomApe ;
   private int[] H002S4_A3CliCod ;
   private short[] H002S4_A1EmpCod ;
   private String[] H002S4_A1243SucCodigo ;
   private String[] H002S4_A1244SucDescrip ;
   private int[] H002S5_A3CliCod ;
   private String[] H002S5_A13SecCodigo ;
   private String[] H002S5_A1240PuestoCodigo ;
   private String[] H002S5_A1241PuestoDescrip ;
   private int[] H002S6_A3CliCod ;
   private String[] H002S6_A13SecCodigo ;
   private String[] H002S6_A329SecDescrip ;
   private int[] H002S7_A3CliCod ;
   private short[] H002S7_A1564CliPaiConve ;
   private byte[] H002S7_A1838CatClase ;
   private String[] H002S7_A1565CliConvenio ;
   private String[] H002S7_A8CatCodigo ;
   private String[] H002S7_A123CatDescrip ;
   private short[] H002S8_A1564CliPaiConve ;
   private int[] H002S8_A3CliCod ;
   private String[] H002S8_A1565CliConvenio ;
   private String[] H002S8_A1567CliConvenioDescrip ;
   private int[] H002S9_A6LegNumero ;
   private int[] H002S9_A3CliCod ;
   private short[] H002S9_A1EmpCod ;
   private String[] H002S9_A2404LegModTra ;
   private int[] H002S10_A3CliCod ;
   private boolean[] H002S10_A341TLiqHabilitada ;
   private String[] H002S10_A32TLiqCod ;
   private short[] H002S10_A1817TLiqOrd ;
   private int[] H002S11_A6LegNumero ;
   private String[] H002S11_A2404LegModTra ;
   private byte[] H002S11_A1818LegEstado ;
   private short[] H002S11_A1EmpCod ;
   private int[] H002S11_A3CliCod ;
   private byte[] H002S11_A235LegClase ;
   private int[] H002S12_A6LegNumero ;
   private String[] H002S12_A2404LegModTra ;
   private byte[] H002S12_A1818LegEstado ;
   private short[] H002S12_A1EmpCod ;
   private int[] H002S12_A3CliCod ;
   private String[] H002S12_A2417LegTipoTarifa ;
   private com.genexus.webpanels.WebSession AV89websession ;
   private GXSimpleCollection<String> AV82ConveCodigo ;
   private GXSimpleCollection<String> AV7CatCodigo ;
   private GXSimpleCollection<String> AV24SecCodigo ;
   private GXSimpleCollection<String> AV100PuestoCodigo ;
   private GXSimpleCollection<String> AV101SucCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV97ConveCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV8CatCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV25SecCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV102PuestoCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV103SucCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14LegNumero_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV46LiqDepBanCod_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV9Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV10DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons29 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons30[] ;
}

final  class liquidacionabm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002S3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A937LegConveCodigo ,
                                          GXSimpleCollection<String> AV82ConveCodigo ,
                                          String A939LegCatCodigo ,
                                          GXSimpleCollection<String> AV7CatCodigo ,
                                          String A1579LegSecCodigo ,
                                          GXSimpleCollection<String> AV24SecCodigo ,
                                          String A1578LegPuesCodigo ,
                                          GXSimpleCollection<String> AV100PuestoCodigo ,
                                          String A1577LegSucCodigo ,
                                          GXSimpleCollection<String> AV101SucCodigo ,
                                          String AV26TLiqCod ,
                                          String AV55egresoTLiqCod ,
                                          int AV82ConveCodigo_size ,
                                          String AV104ConvenioFiltro ,
                                          int AV7CatCodigo_size ,
                                          int AV24SecCodigo_size ,
                                          int AV100PuestoCodigo_size ,
                                          int AV101SucCodigo_size ,
                                          java.util.Date A244LegFecEgreso ,
                                          java.util.Date AV79menos1LiqPeriodo ,
                                          java.util.Date AV93finDeMesFecha ,
                                          java.util.Date A245LegFecIngreso ,
                                          int A3CliCod ,
                                          int AV32CliCod ,
                                          short A1EmpCod ,
                                          short AV11EmpCod ,
                                          byte A1818LegEstado ,
                                          byte A235LegClase ,
                                          byte AV126LiqFrecPag ,
                                          String A2404LegModTra ,
                                          String AV124LiqModTra ,
                                          String A2417LegTipoTarifa ,
                                          String AV146LiqTipoTarifa )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int34 = new byte[8];
      Object[] GXv_Object35 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegEstado, LegClase, LegModTra, LegTipoTarifa, LegSucCodigo, LegPuesCodigo, LegSecCodigo, LegCatCodigo, LegConveCodigo, LegFecIngreso, LegFecEgreso," ;
      scmdbuf += " LegNumero, LegIdNomApe FROM Legajo" ;
      addWhere(sWhereString, "(LegFecIngreso <= ?)");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(LegEstado = 1)");
      addWhere(sWhereString, "(LegClase = ?)");
      addWhere(sWhereString, "(LegModTra = ( ?))");
      addWhere(sWhereString, "(LegTipoTarifa = ( ?))");
      if ( GXutil.strcmp(AV26TLiqCod, AV55egresoTLiqCod) != 0 )
      {
         addWhere(sWhereString, "(LegFecEgreso >= ? or (LegFecEgreso = DATE '00010101'))");
      }
      else
      {
         GXv_int34[6] = (byte)(1) ;
      }
      if ( GXutil.strcmp(AV26TLiqCod, AV55egresoTLiqCod) == 0 )
      {
         addWhere(sWhereString, "(LegFecEgreso <= ? and Not (LegFecEgreso = DATE '00010101'))");
      }
      else
      {
         GXv_int34[7] = (byte)(1) ;
      }
      if ( AV82ConveCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82ConveCodigo, "LegConveCodigo IN (", ")")+")");
      }
      if ( GXutil.strcmp(AV104ConvenioFiltro, "Fuera") == 0 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from LegConveCodigo))=0) or LegConveCodigo IS NULL)");
      }
      if ( GXutil.strcmp(AV104ConvenioFiltro, "EnConvenio") == 0 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from LegConveCodigo))=0) and Not LegConveCodigo IS NULL)");
      }
      if ( AV7CatCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV7CatCodigo, "LegCatCodigo IN (", ")")+")");
      }
      if ( AV24SecCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV24SecCodigo, "LegSecCodigo IN (", ")")+")");
      }
      if ( AV100PuestoCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100PuestoCodigo, "LegPuesCodigo IN (", ")")+")");
      }
      if ( AV101SucCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101SucCodigo, "LegSucCodigo IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LegIdNomApe" ;
      GXv_Object35[0] = scmdbuf ;
      GXv_Object35[1] = GXv_int34 ;
      return GXv_Object35 ;
   }

   protected Object[] conditional_H002S5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV24SecCodigo ,
                                          int AV24SecCodigo_size ,
                                          int A3CliCod ,
                                          int AV32CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int37 = new byte[1];
      Object[] GXv_Object38 = new Object[2];
      scmdbuf = "SELECT CliCod, SecCodigo, PuestoCodigo, PuestoDescrip FROM Puesto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV24SecCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV24SecCodigo, "SecCodigo IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PuestoDescrip" ;
      GXv_Object38[0] = scmdbuf ;
      GXv_Object38[1] = GXv_int37 ;
      return GXv_Object38 ;
   }

   protected Object[] conditional_H002S7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1565CliConvenio ,
                                          GXSimpleCollection<String> AV82ConveCodigo ,
                                          int A3CliCod ,
                                          int AV32CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV83PaiCod ,
                                          byte A1838CatClase ,
                                          byte AV126LiqFrecPag )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int40 = new byte[3];
      Object[] GXv_Object41 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CatClase, CliConvenio, CatCodigo, CatDescrip FROM Categoria1" ;
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82ConveCodigo, "CliConvenio IN (", ")")+")");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CatClase = ?)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CatDescrip" ;
      GXv_Object41[0] = scmdbuf ;
      GXv_Object41[1] = GXv_int40 ;
      return GXv_Object41 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_H002S3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (java.util.Date)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , (String)dynConstraints[29] , (String)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] );
            case 3 :
                  return conditional_H002S5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() );
            case 5 :
                  return conditional_H002S7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002S2", "SELECT T1.CliCod, T1.EmpCod, T1.EmpBanCod AS EmpBanCod, T2.BanDescrip AS EmpBanDescrip FROM (EmpresaBancos T1 INNER JOIN Banco T2 ON T2.CliCod = T1.CliCod AND T2.BanCod = T1.EmpBanCod) WHERE (T1.CliCod = ?) AND (T1.EmpCod = ?) ORDER BY T2.BanDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S4", "SELECT CliCod, EmpCod, SucCodigo, SucDescrip FROM Sucursal WHERE (CliCod = ?) AND (EmpCod = ?) ORDER BY SucDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S6", "SELECT CliCod, SecCodigo, SecDescrip FROM Seccion WHERE CliCod = ? ORDER BY CliCod, SecDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S8", "SELECT T1.CliPaiConve AS CliPaiConve, T1.CliCod, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? ORDER BY T2.ConveDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S9", "SELECT LegNumero, CliCod, EmpCod, LegModTra FROM Legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LegModTra ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S10", "SELECT CliCod, TLiqHabilitada, TLiqCod, TLiqOrd FROM TipoLiquidacion WHERE (CliCod = ?) AND (TLiqHabilitada = TRUE) ORDER BY CliCod, TLiqOrd ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S11", "SELECT LegNumero, LegModTra, LegEstado, EmpCod, CliCod, LegClase FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegEstado = 1) AND (LegModTra = ( ?)) ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002S12", "SELECT LegNumero, LegModTra, LegEstado, EmpCod, CliCod, LegTipoTarifa FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegEstado = 1) AND (LegModTra = ( ?)) ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(12);
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(14);
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[8]);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[11]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
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
                  stmt.setByte(sIdx, ((Number) parms[5]).byteValue());
               }
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               return;
      }
   }

}

