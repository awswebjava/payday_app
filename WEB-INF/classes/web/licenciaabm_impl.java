package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class licenciaabm_impl extends GXDataArea
{
   public licenciaabm_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public licenciaabm_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licenciaabm_impl.class ));
   }

   public licenciaabm_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavMostrar = new HTMLChoice();
      cmbavNovedadeventos_leglicsitcodigo = new HTMLChoice();
      cmbavMes = new HTMLChoice();
      cmbavDia = new HTMLChoice();
      chkavNovedadeventos_leglicconplus = UIFactory.getCheckbox(this);
      cmbavNovedadeventos_leglicestado = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV17TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17TrnMode", AV17TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV5CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
               AV6EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV6EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
               AV7LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV7LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7LegNumero), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LegNumero), "ZZZZZZZ9")));
               AV8LegLicenIni = localUtil.parseDateParm( httpContext.GetPar( "LegLicenIni")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8LegLicenIni", localUtil.format(AV8LegLicenIni, "99/99/99"));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGLICENINI", getSecureSignedToken( "", AV8LegLicenIni));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      paDF2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startDF2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.licenciaabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV5CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV6EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7LegNumero,8,0)),GXutil.URLEncode(GXutil.formatDateParm(AV8LegLicenIni))}, new String[] {"TrnMode","CliCod","EmpCod","LegNumero","LegLicenIni"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENLICTPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71LegCuenLicTpo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV32date));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACSITCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77vacSitCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDUMDATE", getSecureSignedToken( "", AV81dumDate));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGLICENINI", getSecureSignedToken( "", AV8LegLicenIni));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Novedadeventos", AV11NovedadEventos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Novedadeventos", AV11NovedadEventos);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vNOVEDADEVENTOS_LEGNUMERO_DATA", AV13NovedadEventos_LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOVEDADEVENTOS_LEGNUMERO_DATA", AV13NovedadEventos_LegNumero_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV17TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV6EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV97Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUENLICTPO", GXutil.rtrim( A2243LegCuenLicTpo));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUENANIO", GXutil.ltrim( localUtil.ntoc( A2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGCUENLICTPO", GXutil.rtrim( AV71LegCuenLicTpo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENLICTPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71LegCuenLicTpo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPRIMERAFECHA", localUtil.dtoc( AV26primerafecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUENLICPERINI", localUtil.dtoc( A2244LegCuenLicPerIni, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUENLICPERFIN", localUtil.dtoc( A2245LegCuenLicPerFin, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV32date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV32date));
      web.GxWebStd.gx_hidden_field( httpContext, "vULTIMAPRIMERAFECHA", localUtil.dtoc( AV75ultimaPrimeraFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV7LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV45PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVECODIGO", GXutil.rtrim( AV42ConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGCLASE", GXutil.ltrim( localUtil.ntoc( AV43LegClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV19CheckRequiredFieldsResult);
      web.GxWebStd.gx_hidden_field( httpContext, "vVACSITCODIGO", GXutil.rtrim( AV77vacSitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACSITCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77vacSitCodigo, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV16Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV16Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "SITPAICOD", GXutil.ltrim( localUtil.ntoc( A1593SitPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SITDESCABREV", A913sItDescAbrev);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITESLICENCIA", A738SitEsLicencia);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SITLICCUENTATRAB", A739SitLicCuentaTrab);
      web.GxWebStd.gx_hidden_field( httpContext, "SITCODIGO", GXutil.rtrim( A16SitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "SITDESCRIP", A334SitDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vDUMDATE", localUtil.dtoc( AV81dumDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDUMDATE", getSecureSignedToken( "", AV81dumDate));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGLICCNTDIAS", GXutil.ltrim( localUtil.ntoc( AV38LegLicCntDias, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGLICENINI", localUtil.dtoc( AV8LegLicenIni, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGLICENINI", getSecureSignedToken( "", AV8LegLicenIni));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vNOVEDADEVENTOS", AV11NovedadEventos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOVEDADEVENTOS", AV11NovedadEventos);
      }
      GXCCtlgxBlob = "NOVEDADEVENTOS_LEGLICFILE" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile());
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_NOVEDADEVENTOS_LEGNUMERO_Cls", GXutil.rtrim( Combo_novedadeventos_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_NOVEDADEVENTOS_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_novedadeventos_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_NOVEDADEVENTOS_LEGNUMERO_Enabled", GXutil.booltostr( Combo_novedadeventos_legnumero_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_NOVEDADEVENTOS_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_novedadeventos_legnumero_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_NOVEDADEVENTOS_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_novedadeventos_legnumero_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_NOVEDADEVENTOS_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_novedadeventos_legnumero_Selectedvalue_get));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
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
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         weDF2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtDF2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.licenciaabm", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV5CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV6EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7LegNumero,8,0)),GXutil.URLEncode(GXutil.formatDateParm(AV8LegLicenIni))}, new String[] {"TrnMode","CliCod","EmpCod","LegNumero","LegLicenIni"})  ;
   }

   public String getPgmname( )
   {
      return "LicenciaABM" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Licencia", "") ;
   }

   public void wbDF0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
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
         wb_table1_9_DF2( true) ;
      }
      else
      {
         wb_table1_9_DF2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_DF2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavNovedadeventos_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNovedadeventos_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavNovedadeventos_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LicenciaABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavNovedadeventos_empcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Empcod(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Empcod()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNovedadeventos_empcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavNovedadeventos_empcod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LicenciaABM.htm");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavImageuri_Internalname, AV52ImageURI, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", (short)(0), edtavImageuri_Visible, 1, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "4000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LicenciaABM.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCntdiashab_Internalname, GXutil.ltrim( localUtil.ntoc( AV63cntDiasHab, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV63cntDiasHab), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,110);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCntdiashab_Jsonclick, 0, "Attribute", "", "", "", "", edtavCntdiashab_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startDF2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Licencia", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupDF0( ) ;
   }

   public void wsDF2( )
   {
      startDF2( ) ;
      evtDF2( ) ;
   }

   public void evtDF2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_NOVEDADEVENTOS_LEGNUMERO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e12DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e13DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e14DF2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "NOVEDADEVENTOS_LEGLICSITCODIGO.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VMOSTRAR.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "NOVEDADEVENTOS_LEGLICENINI.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "NOVEDADEVENTOS_LEGLICENFIN.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VMES.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e19DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VDIA.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e20DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "NOVEDADEVENTOS_LEGLICENINI.ISVALID") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e21DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "NOVEDADEVENTOS_LEGLICENFIN.ISVALID") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e22DF2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e23DF2 ();
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
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

   public void weDF2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void paDF2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = cmbavMostrar.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      if ( cmbavMostrar.getItemCount() > 0 )
      {
         AV70Mostrar = cmbavMostrar.getValidValue(AV70Mostrar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70Mostrar", AV70Mostrar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMostrar.setValue( GXutil.rtrim( AV70Mostrar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Values", cmbavMostrar.ToJavascriptSource(), true);
      }
      if ( cmbavNovedadeventos_leglicsitcodigo.getItemCount() > 0 )
      {
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicsitcodigo( cmbavNovedadeventos_leglicsitcodigo.getValidValue(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavNovedadeventos_leglicsitcodigo.setValue( GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), "Values", cmbavNovedadeventos_leglicsitcodigo.ToJavascriptSource(), true);
      }
      if ( cmbavMes.getItemCount() > 0 )
      {
         AV24Mes = localUtil.ctod( cmbavMes.getValidValue(localUtil.dtoc( AV24Mes, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Mes", localUtil.format(AV24Mes, "99/99/99"));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMes.setValue( localUtil.dtoc( AV24Mes, 0, "/") );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
      }
      if ( cmbavDia.getItemCount() > 0 )
      {
         AV25Dia = localUtil.ctod( cmbavDia.getValidValue(localUtil.dtoc( AV25Dia, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Dia", localUtil.format(AV25Dia, "99/99/99"));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDia.setValue( localUtil.dtoc( AV25Dia, 0, "/") );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
      }
      if ( cmbavNovedadeventos_leglicestado.getItemCount() > 0 )
      {
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicestado( cmbavNovedadeventos_leglicestado.getValidValue(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicestado()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavNovedadeventos_leglicestado.setValue( GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicestado()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicestado.getInternalname(), "Values", cmbavNovedadeventos_leglicestado.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfDF2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV97Pgmname = "LicenciaABM" ;
      Gx_err = (short)(0) ;
      edtavLiqdlog_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqdlog_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdlog_Enabled), 5, 0), true);
      edtavCntdias_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdias_Enabled), 5, 0), true);
   }

   public void rfDF2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e13DF2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e23DF2 ();
         wbDF0( ) ;
      }
   }

   public void send_integrity_lvl_hashesDF2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV6EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV97Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGCUENLICTPO", GXutil.rtrim( AV71LegCuenLicTpo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENLICTPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71LegCuenLicTpo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV32date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV32date));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV45PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vVACSITCODIGO", GXutil.rtrim( AV77vacSitCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACSITCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77vacSitCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vDUMDATE", localUtil.dtoc( AV81dumDate, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDUMDATE", getSecureSignedToken( "", AV81dumDate));
   }

   public void before_start_formulas( )
   {
      AV97Pgmname = "LicenciaABM" ;
      Gx_err = (short)(0) ;
      edtavLiqdlog_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqdlog_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdlog_Enabled), 5, 0), true);
      edtavCntdias_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdias_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupDF0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12DF2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vNOVEDADEVENTOS"), AV11NovedadEventos);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Novedadeventos"), AV11NovedadEventos);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vNOVEDADEVENTOS_LEGNUMERO_DATA"), AV13NovedadEventos_LegNumero_Data);
         /* Read saved values. */
         Combo_novedadeventos_legnumero_Cls = httpContext.cgiGet( "COMBO_NOVEDADEVENTOS_LEGNUMERO_Cls") ;
         Combo_novedadeventos_legnumero_Selectedvalue_set = httpContext.cgiGet( "COMBO_NOVEDADEVENTOS_LEGNUMERO_Selectedvalue_set") ;
         Combo_novedadeventos_legnumero_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_NOVEDADEVENTOS_LEGNUMERO_Enabled")) ;
         Combo_novedadeventos_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_NOVEDADEVENTOS_LEGNUMERO_Emptyitem")) ;
         Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         Combo_novedadeventos_legnumero_Selectedvalue_get = httpContext.cgiGet( "COMBO_NOVEDADEVENTOS_LEGNUMERO_Selectedvalue_get") ;
         /* Read variables values. */
         cmbavMostrar.setValue( httpContext.cgiGet( cmbavMostrar.getInternalname()) );
         AV70Mostrar = httpContext.cgiGet( cmbavMostrar.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70Mostrar", AV70Mostrar);
         cmbavNovedadeventos_leglicsitcodigo.setValue( httpContext.cgiGet( cmbavNovedadeventos_leglicsitcodigo.getInternalname()) );
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicsitcodigo( httpContext.cgiGet( cmbavNovedadeventos_leglicsitcodigo.getInternalname()) );
         AV39LiqDLog = httpContext.cgiGet( edtavLiqdlog_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39LiqDLog", AV39LiqDLog);
         cmbavMes.setValue( httpContext.cgiGet( cmbavMes.getInternalname()) );
         AV24Mes = localUtil.ctod( httpContext.cgiGet( cmbavMes.getInternalname()), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Mes", localUtil.format(AV24Mes, "99/99/99"));
         cmbavDia.setValue( httpContext.cgiGet( cmbavDia.getInternalname()) );
         AV25Dia = localUtil.ctod( httpContext.cgiGet( cmbavDia.getInternalname()), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Dia", localUtil.format(AV25Dia, "99/99/99"));
         if ( localUtil.vcdate( httpContext.cgiGet( edtavNovedadeventos_leglicenini_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "NOVEDADEVENTOS_LEGLICENINI");
            GX_FocusControl = edtavNovedadeventos_leglicenini_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenini( GXutil.nullDate() );
         }
         else
         {
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenini( localUtil.ctod( httpContext.cgiGet( edtavNovedadeventos_leglicenini_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) );
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavNovedadeventos_leglicenfin_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "NOVEDADEVENTOS_LEGLICENFIN");
            GX_FocusControl = edtavNovedadeventos_leglicenfin_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenfin( GXutil.nullDate() );
         }
         else
         {
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenfin( localUtil.ctod( httpContext.cgiGet( edtavNovedadeventos_leglicenfin_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCntdias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCntdias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCNTDIAS");
            GX_FocusControl = edtavCntdias_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV34cntDias = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34cntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34cntDias), 4, 0));
         }
         else
         {
            AV34cntDias = (short)(localUtil.ctol( httpContext.cgiGet( edtavCntdias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34cntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34cntDias), 4, 0));
         }
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicconplus( GXutil.strtobool( httpContext.cgiGet( chkavNovedadeventos_leglicconplus.getInternalname())) );
         cmbavNovedadeventos_leglicestado.setValue( httpContext.cgiGet( cmbavNovedadeventos_leglicestado.getInternalname()) );
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicestado( httpContext.cgiGet( cmbavNovedadeventos_leglicestado.getInternalname()) );
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicmot( httpContext.cgiGet( edtavNovedadeventos_leglicmot_Internalname) );
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicfile_SetBlob(httpContext.cgiGet( edtavNovedadeventos_leglicfile_Internalname), httpContext.cgiGetFileName( edtavNovedadeventos_leglicfile_Internalname), httpContext.cgiGetFileType( edtavNovedadeventos_leglicfile_Internalname));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavNovedadeventos_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavNovedadeventos_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "NOVEDADEVENTOS_CLICOD");
            GX_FocusControl = edtavNovedadeventos_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Clicod( 0 );
         }
         else
         {
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavNovedadeventos_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavNovedadeventos_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavNovedadeventos_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "NOVEDADEVENTOS_EMPCOD");
            GX_FocusControl = edtavNovedadeventos_empcod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Empcod( (short)(0) );
         }
         else
         {
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Empcod( (short)(localUtil.ctol( httpContext.cgiGet( edtavNovedadeventos_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         AV52ImageURI = httpContext.cgiGet( edtavImageuri_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52ImageURI", AV52ImageURI);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCntdiashab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCntdiashab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCNTDIASHAB");
            GX_FocusControl = edtavCntdiashab_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV63cntDiasHab = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63cntDiasHab", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63cntDiasHab), 4, 0));
         }
         else
         {
            AV63cntDiasHab = (short)(localUtil.ctol( httpContext.cgiGet( edtavCntdiashab_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63cntDiasHab", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63cntDiasHab), 4, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( (GXutil.strcmp("", AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile())==0) )
         {
            GXCCtlgxBlob = "NOVEDADEVENTOS_LEGLICFILE" + "_gxBlob" ;
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicfile( httpContext.cgiGet( GXCCtlgxBlob) );
         }
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
      e12DF2 ();
      if (returnInSub) return;
   }

   public void e12DF2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Gx_mode = AV17TrnMode ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV71LegCuenLicTpo = "Vacaciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71LegCuenLicTpo", AV71LegCuenLicTpo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGCUENLICTPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71LegCuenLicTpo, ""))));
      GXt_char1 = AV77vacSitCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV5CliCod, GXv_char2) ;
      licenciaabm_impl.this.GXt_char1 = GXv_char2[0] ;
      AV77vacSitCodigo = GXt_char1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77vacSitCodigo", AV77vacSitCodigo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACSITCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV77vacSitCodigo, ""))));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV18LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV17TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV17TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV17TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV17TrnMode, "INS") != 0 )
         {
            AV11NovedadEventos.Load(AV5CliCod, AV6EmpCod, AV7LegNumero, AV8LegLicenIni);
            AV18LoadSuccess = AV11NovedadEventos.Success() ;
            if ( ! AV18LoadSuccess )
            {
               AV16Messages = AV11NovedadEventos.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV17TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 ) )
            {
               cmbavNovedadeventos_leglicestado.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicestado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavNovedadeventos_leglicestado.getEnabled(), 5, 0), true);
               edtavNovedadeventos_leglicmot_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicmot_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicmot_Enabled), 5, 0), true);
               edtavNovedadeventos_leglicfile_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicfile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicfile_Enabled), 5, 0), true);
               cmbavMostrar.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMostrar.getEnabled(), 5, 0), true);
               cmbavNovedadeventos_leglicsitcodigo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavNovedadeventos_leglicsitcodigo.getEnabled(), 5, 0), true);
               cmbavMes.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMes.getEnabled(), 5, 0), true);
               cmbavDia.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavDia.getEnabled(), 5, 0), true);
               edtavNovedadeventos_leglicenfin_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenfin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenfin_Enabled), 5, 0), true);
               chkavNovedadeventos_leglicconplus.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavNovedadeventos_leglicconplus.getInternalname(), "Enabled", GXutil.ltrimstr( chkavNovedadeventos_leglicconplus.getEnabled(), 5, 0), true);
            }
            Combo_novedadeventos_legnumero_Enabled = false ;
            ucCombo_novedadeventos_legnumero.sendProperty(context, "", false, Combo_novedadeventos_legnumero_Internalname, "Enabled", GXutil.booltostr( Combo_novedadeventos_legnumero_Enabled));
            edtavNovedadeventos_leglicenini_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenini_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenini_Enabled), 5, 0), true);
         }
      }
      else
      {
         AV18LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV18LoadSuccess )
      {
         if ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      /* Execute user subroutine: 'LOADCOMBONOVEDADEVENTOS_LEGNUMERO' */
      S122 ();
      if (returnInSub) return;
      edtavNovedadeventos_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_clicod_Visible), 5, 0), true);
      edtavNovedadeventos_empcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_empcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_empcod_Visible), 5, 0), true);
      edtavImageuri_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavImageuri_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImageuri_Visible), 5, 0), true);
      edtavCntdiashab_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdiashab_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdiashab_Visible), 5, 0), true);
      cmbavMes.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMes.getVisible(), 5, 0), true);
      cmbavDia.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
      chkavNovedadeventos_leglicconplus.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavNovedadeventos_leglicconplus.getInternalname(), "Visible", GXutil.ltrimstr( chkavNovedadeventos_leglicconplus.getVisible(), 5, 0), true);
      GXv_int3[0] = AV45PaiCod ;
      new web.empresagetpais(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, GXv_int3) ;
      licenciaabm_impl.this.AV45PaiCod = GXv_int3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45PaiCod), "ZZZ9")));
      if ( GXutil.strcmp(AV17TrnMode, "INS") == 0 )
      {
         AV70Mostrar = httpContext.getMessage( "remuneradas", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70Mostrar", AV70Mostrar);
         tblTbladicionales_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblTbladicionales_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTbladicionales_Visible), 5, 0), true);
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicestado( "autorizada" );
         edtavNovedadeventos_leglicenini_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenini_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenini_Visible), 5, 0), true);
         edtavNovedadeventos_leglicenfin_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenfin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenfin_Visible), 5, 0), true);
         edtavCntdias_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCntdias_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdias_Visible), 5, 0), true);
         cmbavNovedadeventos_leglicsitcodigo.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavNovedadeventos_leglicsitcodigo.getVisible(), 5, 0), true);
         edtavLiqdlog_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLiqdlog_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdlog_Visible), 5, 0), true);
         cmbavMes.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMes.getVisible(), 5, 0), true);
         cmbavDia.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
         cmbavMostrar.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMostrar.getVisible(), 5, 0), true);
      }
      else
      {
         cmbavMostrar.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMostrar.getVisible(), 5, 0), true);
         edtavNovedadeventos_leglicenini_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenini_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenini_Visible), 5, 0), true);
         edtavNovedadeventos_leglicenfin_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenfin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenfin_Visible), 5, 0), true);
         /* Execute user subroutine: 'VISIBILIDAD VACACIONES' */
         S132 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'ACTUALIZAR DIAS' */
         S142 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'COMBO LICENCIAS' */
      S152 ();
      if (returnInSub) return;
   }

   public void e13DF2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e11DF2( )
   {
      /* Combo_novedadeventos_legnumero_Onoptionclicked Routine */
      returnInSub = false ;
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Legnumero( (int)(GXutil.lval( Combo_novedadeventos_legnumero_Selectedvalue_get)) );
      /* Execute user subroutine: 'COMBO MES' */
      S172 ();
      if (returnInSub) return;
      GXv_int4[0] = AV43LegClase ;
      GXv_char2[0] = AV82LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), GXv_int4, GXv_char2) ;
      licenciaabm_impl.this.AV43LegClase = GXv_int4[0] ;
      licenciaabm_impl.this.AV82LegModTra = GXv_char2[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43LegClase", GXutil.str( AV43LegClase, 1, 0));
      if ( ( AV43LegClase != 1 ) || ( GXutil.strcmp(AV82LegModTra, "E") != 0 ) )
      {
         AV70Mostrar = httpContext.getMessage( "remuneradas", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70Mostrar", AV70Mostrar);
         cmbavMostrar.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMostrar.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbavMostrar.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMostrar.getEnabled(), 5, 0), true);
      }
      GXv_char2[0] = AV42ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), GXv_char2) ;
      licenciaabm_impl.this.AV42ConveCodigo = GXv_char2[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42ConveCodigo", AV42ConveCodigo);
      if ( (GXutil.strcmp("", AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo())==0) && ( GXutil.strcmp(AV70Mostrar, httpContext.getMessage( "remuneradas", "")) == 0 ) )
      {
         GXt_char1 = "" ;
         GXv_char2[0] = GXt_char1 ;
         new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV5CliCod, GXv_char2) ;
         licenciaabm_impl.this.GXt_char1 = GXv_char2[0] ;
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicsitcodigo( GXt_char1 );
      }
      /* Execute user subroutine: 'VISIBILIDAD VACACIONES' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11NovedadEventos", AV11NovedadEventos);
      cmbavMostrar.setValue( GXutil.rtrim( AV70Mostrar) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Values", cmbavMostrar.ToJavascriptSource(), true);
      cmbavMes.setValue( localUtil.dtoc( AV24Mes, 0, "/") );
      httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
      cmbavDia.setValue( localUtil.dtoc( AV25Dia, 0, "/") );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e14DF2 ();
      if (returnInSub) return;
   }

   public void e14DF2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Clicod( AV5CliCod );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Empcod( AV6EmpCod );
      GXv_boolean5[0] = AV57SitEsLicencia ;
      GXv_boolean6[0] = AV58sitEsAusencia ;
      GXv_boolean7[0] = AV59SitLicCuentaTrab ;
      GXv_boolean8[0] = AV60SitEsRevistaAFip ;
      GXv_boolean9[0] = false ;
      GXv_boolean10[0] = AV61EstadoCanPresen ;
      GXv_boolean11[0] = AV62EstadoRemCorr ;
      new web.getsituacionlicenciaprops(remoteHandle, context).execute( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo(), GXv_boolean5, GXv_boolean6, GXv_boolean7, GXv_boolean8, GXv_boolean9, GXv_boolean10, GXv_boolean11) ;
      licenciaabm_impl.this.AV57SitEsLicencia = GXv_boolean5[0] ;
      licenciaabm_impl.this.AV58sitEsAusencia = GXv_boolean6[0] ;
      licenciaabm_impl.this.AV59SitLicCuentaTrab = GXv_boolean7[0] ;
      licenciaabm_impl.this.AV60SitEsRevistaAFip = GXv_boolean8[0] ;
      licenciaabm_impl.this.AV61EstadoCanPresen = GXv_boolean10[0] ;
      licenciaabm_impl.this.AV62EstadoRemCorr = GXv_boolean11[0] ;
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Legsiteslic( (byte)((AV57SitEsLicencia ? 1 : 0)) );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Legsitesau( (byte)((AV58sitEsAusencia ? 1 : 0)) );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Legsitesafip( (byte)((AV60SitEsRevistaAFip ? 1 : 0)) );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Legsitcuentrab( (byte)((AV59SitLicCuentaTrab ? 1 : 0)) );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Legliccanpres( (byte)((AV61EstadoCanPresen ? 1 : 0)) );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicremcorr( (byte)((AV62EstadoRemCorr ? 1 : 0)) );
      if ( GXutil.strcmp(AV17TrnMode, "DSP") != 0 )
      {
         if ( GXutil.strcmp(AV17TrnMode, "DLT") != 0 )
         {
            /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
            S182 ();
            if (returnInSub) return;
         }
         if ( ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 ) || AV19CheckRequiredFieldsResult )
         {
            if ( GXutil.strcmp(AV17TrnMode, "DLT") == 0 )
            {
               AV11NovedadEventos.Delete();
            }
            else
            {
               AV11NovedadEventos.Save();
            }
            if ( AV11NovedadEventos.Success() )
            {
               /* Execute user subroutine: 'AFTER_TRN' */
               S192 ();
               if (returnInSub) return;
            }
            else
            {
               AV16Messages = AV11NovedadEventos.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11NovedadEventos", AV11NovedadEventos);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16Messages", AV16Messages);
   }

   public void S162( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV17TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBONOVEDADEVENTOS_LEGNUMERO' Routine */
      returnInSub = false ;
      /* Using cursor H00DF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV6EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = H00DF2_A3CliCod[0] ;
         A1EmpCod = H00DF2_A1EmpCod[0] ;
         A1818LegEstado = H00DF2_A1818LegEstado[0] ;
         A6LegNumero = H00DF2_A6LegNumero[0] ;
         A250LegIdNomApe = H00DF2_A250LegIdNomApe[0] ;
         AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV13NovedadEventos_LegNumero_Data.add(AV14Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      Combo_novedadeventos_legnumero_Selectedvalue_set = ((0==AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero()) ? "" : GXutil.trim( GXutil.str( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), 8, 0))) ;
      ucCombo_novedadeventos_legnumero.sendProperty(context, "", false, Combo_novedadeventos_legnumero_Internalname, "SelectedValue_set", Combo_novedadeventos_legnumero_Selectedvalue_set);
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV96GXV10 = 1 ;
      while ( AV96GXV10 <= AV16Messages.size() )
      {
         AV15Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV16Messages.elementAt(-1+AV96GXV10));
         httpContext.GX_msglist.addItem(AV15Message.getgxTv_SdtMessages_Message_Description());
         AV96GXV10 = (int)(AV96GXV10+1) ;
      }
   }

   public void S192( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo(), AV77vacSitCodigo) == 0 )
      {
         if ( GXutil.strcmp(AV17TrnMode, "DSP") != 0 )
         {
            if ( GXutil.strcmp(AV17TrnMode, "INS") != 0 )
            {
               AV78desdeAnio = (short)(GXutil.year( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini())-1) ;
               new web.inicializarperiodoscclic(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), AV78desdeAnio) ;
            }
            else
            {
               if ( GXutil.strcmp(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicestado(), "autorizada") == 0 )
               {
                  AV78desdeAnio = (short)(GXutil.year( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini())-1) ;
                  new web.asignarconsumoscclicencias(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legliccntdias(), "licencias", 0) ;
               }
            }
         }
      }
      if ( false )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "licenciaabm");
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), httpContext.getMessage( "LICENCIAS", "")) ;
         Application.commitDataStores(context, remoteHandle, pr_default, "licenciaabm");
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S182( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV19CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
      if ( ( GXutil.strcmp(AV17TrnMode, "UPD") == 0 ) || ( GXutil.strcmp(AV17TrnMode, "INS") == 0 ) )
      {
         GXv_boolean11[0] = AV50existe ;
         new web.getlicenciavalorenrango(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV7LegNumero, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo(), AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin(), AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), GXv_boolean11) ;
         licenciaabm_impl.this.AV50existe = GXv_boolean11[0] ;
         if ( AV50existe )
         {
            httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", httpContext.getMessage( "La licencia se solapa con otra licencia", ""), "error", edtavNovedadeventos_leglicenini_Internalname, "true", ""));
            AV19CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
         }
      }
      if ( GXutil.resetTime(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin()).before( GXutil.resetTime( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini() )) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin())) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", httpContext.getMessage( "La fecha de Fin debe ser mayor o igual a la fecha de inicio", ""), "error", edtavNovedadeventos_leglicenini_Internalname, "true", ""));
         AV19CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
      }
      if ( ( GXutil.strcmp(AV17TrnMode, "UPD") == 0 ) || ( GXutil.strcmp(AV17TrnMode, "INS") == 0 ) )
      {
         GXv_boolean11[0] = AV79estaDeVaca ;
         new web.estadelicenciaendia(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), "", AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin(), AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), false, GXv_boolean11) ;
         licenciaabm_impl.this.AV79estaDeVaca = GXv_boolean11[0] ;
         if ( AV79estaDeVaca )
         {
            AV19CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19CheckRequiredFieldsResult", AV19CheckRequiredFieldsResult);
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "El rango de fechas duplica con una licencia existente", "")) ;
         }
      }
   }

   public void e15DF2( )
   {
      /* Novedadeventos_leglicsitcodigo_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VISIBILIDAD VACACIONES' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11NovedadEventos", AV11NovedadEventos);
   }

   public void e16DF2( )
   {
      /* Mostrar_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'COMBO LICENCIAS' */
      S152 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavNovedadeventos_leglicsitcodigo.setValue( GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), "Values", cmbavNovedadeventos_leglicsitcodigo.ToJavascriptSource(), true);
   }

   public void e17DF2( )
   {
      /* Novedadeventos_leglicenini_Controlvaluechanged Routine */
      returnInSub = false ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin())) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini())) )
      {
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenfin( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini() );
      }
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11NovedadEventos", AV11NovedadEventos);
   }

   public void e18DF2( )
   {
      /* Novedadeventos_leglicenfin_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e19DF2( )
   {
      /* Mes_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'COMBO DIAS' */
      S202 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDia.setValue( localUtil.dtoc( AV25Dia, 0, "/") );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e20DF2( )
   {
      /* Dia_Click Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV97Pgmname, httpContext.getMessage( "click!! &dia ", "")+GXutil.trim( localUtil.dtoc( AV25Dia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV38LegLicCntDias, 4, 0))) ;
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenini( AV25Dia );
      AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicenfin( GXutil.dadd( AV25Dia, (AV38LegLicCntDias-1)) );
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11NovedadEventos", AV11NovedadEventos);
   }

   public void e21DF2( )
   {
      /* Novedadeventos_leglicenini_Isvalid Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e22DF2( )
   {
      /* Novedadeventos_leglicenfin_Isvalid Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ACTUALIZAR DIAS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'ACTUALIZAR DIAS' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "&NovedadEventos.LegLicenFin ", "")+GXutil.trim( localUtil.dtoc( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &NovedadEventos.LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin())) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini())) )
      {
         AV34cntDias = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34cntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34cntDias), 4, 0));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "&cntDias.SetEmpty()", "")) ;
      }
      else
      {
         AV34cntDias = (short)(GXutil.ddiff(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin(),AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini())+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34cntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV34cntDias), 4, 0));
         new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "&cntDias setea calculo", "")) ;
      }
   }

   public void S172( )
   {
      /* 'COMBO MES' Routine */
      returnInSub = false ;
      GXv_int4[0] = AV64EmpPerVacDes ;
      GXv_int12[0] = AV65EmpPerVacHas ;
      GXv_decimal13[0] = AV66EmpFracVacAnt ;
      new web.getemppervac(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, GXv_int4, GXv_int12, GXv_decimal13) ;
      licenciaabm_impl.this.AV64EmpPerVacDes = GXv_int4[0] ;
      licenciaabm_impl.this.AV65EmpPerVacHas = GXv_int12[0] ;
      licenciaabm_impl.this.AV66EmpFracVacAnt = GXv_decimal13[0] ;
      AV27hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
      AV41elaniopasado = GXutil.addyr( AV27hoy, (short)(-1)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "meses 1 &CliCod ", "")+GXutil.trim( GXutil.str( AV5CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV6EmpCod, 4, 0))+httpContext.getMessage( "  &NovedadEventos.LegNumero ", "")+GXutil.trim( GXutil.str( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), 8, 0))+httpContext.getMessage( " hoy ", "")+GXutil.trim( localUtil.dtoc( AV27hoy, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV73hoyAnio = (short)(GXutil.year( AV27hoy)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73hoyAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73hoyAnio), 4, 0));
      AV74pasadoAnio = (short)(AV73hoyAnio-1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74pasadoAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74pasadoAnio), 4, 0));
      /* Using cursor H00DF3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV6EmpCod), Integer.valueOf(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero()), AV71LegCuenLicTpo, Short.valueOf(AV74pasadoAnio), Short.valueOf(AV73hoyAnio)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A2266LegCuenAnio = H00DF3_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = H00DF3_A2243LegCuenLicTpo[0] ;
         A6LegNumero = H00DF3_A6LegNumero[0] ;
         A1EmpCod = H00DF3_A1EmpCod[0] ;
         A3CliCod = H00DF3_A3CliCod[0] ;
         A2244LegCuenLicPerIni = H00DF3_A2244LegCuenLicPerIni[0] ;
         A2245LegCuenLicPerFin = H00DF3_A2245LegCuenLicPerFin[0] ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV26primerafecha)) )
         {
            AV26primerafecha = A2244LegCuenLicPerIni ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26primerafecha", localUtil.format(AV26primerafecha, "99/99/9999"));
         }
         AV75ultimaPrimeraFecha = A2244LegCuenLicPerIni ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75ultimaPrimeraFecha", localUtil.format(AV75ultimaPrimeraFecha, "99/99/9999"));
         AV23ultimaFecha = A2245LegCuenLicPerFin ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "meses 2", "")) ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cmbavMes.removeAllItems();
      cmbavDia.removeAllItems();
      AV21i = (short)(1) ;
      if ( (( GXutil.resetTime(localUtil.ymdtod( GXutil.year( AV26primerafecha), GXutil.month( AV26primerafecha), 1)).after( GXutil.resetTime( localUtil.ymdtod( GXutil.year( AV27hoy), GXutil.month( AV27hoy), 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(localUtil.ymdtod( GXutil.year( AV26primerafecha), GXutil.month( AV26primerafecha), 1)), GXutil.resetTime(localUtil.ymdtod( GXutil.year( AV27hoy), GXutil.month( AV27hoy), 1))) )) )
      {
         AV31iniFecha = AV26primerafecha ;
      }
      else
      {
         AV31iniFecha = localUtil.ymdtod( GXutil.year( AV27hoy), GXutil.month( AV27hoy), 1) ;
      }
      cmbavMes.addItem(localUtil.dtoc( AV32date, 0, "/"), httpContext.getMessage( "Seleccione mes", ""), (short)(0));
      while ( (( GXutil.resetTime(AV31iniFecha).before( GXutil.resetTime( AV23ultimaFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV31iniFecha), GXutil.resetTime(AV23ultimaFecha)) )) )
      {
         cmbavMes.addItem(localUtil.dtoc( AV31iniFecha, 0, "/"), localUtil.cmonth( AV31iniFecha, httpContext.getLanguage( ))+" "+GXutil.trim( GXutil.str( GXutil.year( AV31iniFecha), 10, 0)), (short)(0));
         AV31iniFecha = GXutil.addmth( AV31iniFecha, (short)(1)) ;
      }
   }

   public void S202( )
   {
      /* 'COMBO DIAS' Routine */
      returnInSub = false ;
      cmbavDia.removeAllItems();
      cmbavDia.setVisible( 1 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
      AV33iniDia = AV24Mes ;
      if ( ! (0==AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero()) )
      {
         cmbavDia.addItem(localUtil.dtoc( AV32date, 0, "/"), httpContext.getMessage( "Seleccione", ""), (short)(0));
         while ( (( GXutil.resetTime(AV33iniDia).before( GXutil.resetTime( GXutil.eomdate( AV24Mes) )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV33iniDia), GXutil.resetTime(GXutil.eomdate( AV24Mes))) )) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "&iniDia.DayOfWeek() ", "")+GXutil.trim( GXutil.str( GXutil.dow( AV33iniDia), 10, 0))+httpContext.getMessage( " &iniDia ", "")+GXutil.trim( localUtil.dtoc( AV33iniDia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            if ( GXutil.dow( AV33iniDia) == 2 )
            {
               GXv_boolean11[0] = AV76trabajaEnDia ;
               new web.legtrabajaendia(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), AV33iniDia, GXv_boolean11) ;
               licenciaabm_impl.this.AV76trabajaEnDia = GXv_boolean11[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "&iniDia ", "")+GXutil.trim( localUtil.dtoc( AV33iniDia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &NovedadEventos.LegNumero ", "")+GXutil.trim( GXutil.str( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), 8, 0))+httpContext.getMessage( " &trabajaEnDia ", "")+GXutil.trim( GXutil.booltostr( AV76trabajaEnDia))) ;
               while ( ! AV76trabajaEnDia )
               {
                  AV33iniDia = GXutil.dadd( AV33iniDia, (1)) ;
                  GXv_boolean11[0] = AV76trabajaEnDia ;
                  new web.legtrabajaendia(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), AV33iniDia, GXv_boolean11) ;
                  licenciaabm_impl.this.AV76trabajaEnDia = GXv_boolean11[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV5CliCod, AV97Pgmname, httpContext.getMessage( "loop &iniDia ", "")+GXutil.trim( localUtil.dtoc( AV33iniDia, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &NovedadEventos.LegNumero ", "")+GXutil.trim( GXutil.str( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), 8, 0))+httpContext.getMessage( " &trabajaEnDia ", "")+GXutil.trim( GXutil.booltostr( AV76trabajaEnDia))) ;
               }
               AV80iniDiaTexto = GXutil.trim( localUtil.cdow( AV33iniDia, httpContext.getLanguage( ))) + " " + GXutil.trim( GXutil.str( GXutil.day( AV33iniDia), 10, 0)) + httpContext.getMessage( " de ", "") + GXutil.trim( localUtil.cmonth( AV33iniDia, httpContext.getLanguage( ))) + httpContext.getMessage( " de ", "") + GXutil.trim( GXutil.str( GXutil.year( AV33iniDia), 10, 0)) ;
               GXv_boolean11[0] = AV79estaDeVaca ;
               new web.estadelicenciaendia(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), AV77vacSitCodigo, AV33iniDia, AV33iniDia, AV81dumDate, false, GXv_boolean11) ;
               licenciaabm_impl.this.AV79estaDeVaca = GXv_boolean11[0] ;
               if ( AV79estaDeVaca )
               {
                  AV80iniDiaTexto += httpContext.getMessage( " (tomado)", "") ;
               }
               cmbavDia.addItem(localUtil.dtoc( AV33iniDia, 0, "/"), AV80iniDiaTexto, (short)(0));
            }
            AV33iniDia = GXutil.dadd( AV33iniDia, (1)) ;
         }
      }
   }

   public void S132( )
   {
      /* 'VISIBILIDAD VACACIONES' Routine */
      returnInSub = false ;
      cmbavNovedadeventos_leglicsitcodigo.setVisible( 1 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), "Visible", GXutil.ltrimstr( cmbavNovedadeventos_leglicsitcodigo.getVisible(), 5, 0), true);
      edtavNovedadeventos_leglicenini_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenini_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenini_Visible), 5, 0), true);
      edtavNovedadeventos_leglicenfin_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicenfin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNovedadeventos_leglicenfin_Visible), 5, 0), true);
      tblTbladicionales_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTbladicionales_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTbladicionales_Visible), 5, 0), true);
      edtavCntdias_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCntdias_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCntdias_Visible), 5, 0), true);
      if ( ( GXutil.strcmp(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo(), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV5CliCod)) == 0 ) && ! (0==AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero()) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_date14[0] = AV35LegFecIngreso ;
         GXv_date15[0] = AV36LegFecEgreso ;
         new web.getfecingresoyegreso(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), GXv_date14, GXv_date15) ;
         licenciaabm_impl.this.AV35LegFecIngreso = GXv_date14[0] ;
         licenciaabm_impl.this.AV36LegFecEgreso = GXv_date15[0] ;
         GXt_char1 = AV37mensualTLiqCod ;
         GXt_char16 = AV37mensualTLiqCod ;
         GXv_char2[0] = GXt_char16 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char2) ;
         licenciaabm_impl.this.GXt_char16 = GXv_char2[0] ;
         GXv_char17[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV5CliCod, GXt_char16, GXv_char17) ;
         licenciaabm_impl.this.GXt_char1 = GXv_char17[0] ;
         AV37mensualTLiqCod = GXt_char1 ;
         AV40vacacionesLiqPeriodo = localUtil.ymdtod( GXutil.year( AV75ultimaPrimeraFecha), 12, 31) ;
         GXv_int3[0] = AV38LegLicCntDias ;
         GXv_char17[0] = AV39LiqDLog ;
         new web.licccsugieredias(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Legnumero(), "Vacaciones", (short)(GXutil.year( AV40vacacionesLiqPeriodo)), GXv_int3, GXv_char17) ;
         licenciaabm_impl.this.AV38LegLicCntDias = GXv_int3[0] ;
         licenciaabm_impl.this.AV39LiqDLog = GXv_char17[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38LegLicCntDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38LegLicCntDias), 4, 0));
         httpContext.ajax_rsp_assign_attri("", false, "AV39LiqDLog", AV39LiqDLog);
         if ( GXutil.strcmp(AV17TrnMode, httpContext.getMessage( "INS", "")) == 0 )
         {
            cmbavMes.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMes.getVisible(), 5, 0), true);
            cmbavMostrar.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMostrar.getVisible(), 5, 0), true);
            edtavLiqdlog_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavLiqdlog_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdlog_Visible), 5, 0), true);
         }
         else
         {
            cmbavMes.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMes.getVisible(), 5, 0), true);
            cmbavDia.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
            cmbavMostrar.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMostrar.getVisible(), 5, 0), true);
            edtavLiqdlog_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavLiqdlog_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdlog_Visible), 5, 0), true);
         }
         GXv_decimal13[0] = AV44LiqDPlus ;
         new web.getplusdebasedecalculo(remoteHandle, context).execute( AV5CliCod, AV6EmpCod, 0, AV7LegNumero, AV45PaiCod, AV42ConveCodigo, AV43LegClase, "licencia", AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo(), "", GXv_decimal13) ;
         licenciaabm_impl.this.AV44LiqDPlus = GXv_decimal13[0] ;
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44LiqDPlus)==0) )
         {
            chkavNovedadeventos_leglicconplus.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop("", false, chkavNovedadeventos_leglicconplus.getInternalname(), "Visible", GXutil.ltrimstr( chkavNovedadeventos_leglicconplus.getVisible(), 5, 0), true);
         }
         else
         {
            chkavNovedadeventos_leglicconplus.setVisible( 1 );
            httpContext.ajax_rsp_assign_prop("", false, chkavNovedadeventos_leglicconplus.getInternalname(), "Visible", GXutil.ltrimstr( chkavNovedadeventos_leglicconplus.getVisible(), 5, 0), true);
            AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicconplus( true );
         }
      }
      else
      {
         cmbavMes.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMes.getVisible(), 5, 0), true);
         cmbavDia.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDia.getVisible(), 5, 0), true);
         chkavNovedadeventos_leglicconplus.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavNovedadeventos_leglicconplus.getInternalname(), "Visible", GXutil.ltrimstr( chkavNovedadeventos_leglicconplus.getVisible(), 5, 0), true);
         edtavLiqdlog_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLiqdlog_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqdlog_Visible), 5, 0), true);
         cmbavMostrar.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMostrar.getVisible(), 5, 0), true);
      }
   }

   public void S152( )
   {
      /* 'COMBO LICENCIAS' Routine */
      returnInSub = false ;
      cmbavNovedadeventos_leglicsitcodigo.removeAllItems();
      cmbavNovedadeventos_leglicsitcodigo.addItem("", httpContext.getMessage( "Seleccionar", ""), (short)(0));
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           AV70Mostrar ,
                                           Boolean.valueOf(A739SitLicCuentaTrab) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           Short.valueOf(A1593SitPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor H00DF4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV45PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1593SitPaiCod = H00DF4_A1593SitPaiCod[0] ;
         n1593SitPaiCod = H00DF4_n1593SitPaiCod[0] ;
         A738SitEsLicencia = H00DF4_A738SitEsLicencia[0] ;
         A739SitLicCuentaTrab = H00DF4_A739SitLicCuentaTrab[0] ;
         A334SitDescrip = H00DF4_A334SitDescrip[0] ;
         A16SitCodigo = H00DF4_A16SitCodigo[0] ;
         A913sItDescAbrev = H00DF4_A913sItDescAbrev[0] ;
         cmbavNovedadeventos_leglicsitcodigo.addItem(A16SitCodigo, A334SitDescrip, (short)(0));
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   protected void nextLoad( )
   {
   }

   protected void e23DF2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_DF2( boolean wbgen )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
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
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellAlignTop", "left", "top", "", "", "div");
         wb_table2_20_DF2( true) ;
      }
      else
      {
         wb_table2_20_DF2( false) ;
      }
      return  ;
   }

   public void wb_table2_20_DF2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_DF2e( true) ;
      }
      else
      {
         wb_table1_9_DF2e( false) ;
      }
   }

   public void wb_table2_20_DF2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTop'>") ;
         wb_table3_23_DF2( true) ;
      }
      else
      {
         wb_table3_23_DF2( false) ;
      }
      return  ;
   }

   public void wb_table3_23_DF2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='CellAlignTop'>") ;
         wb_table4_78_DF2( true) ;
      }
      else
      {
         wb_table4_78_DF2( false) ;
      }
      return  ;
   }

   public void wb_table4_78_DF2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_20_DF2e( true) ;
      }
      else
      {
         wb_table2_20_DF2e( false) ;
      }
   }

   public void wb_table4_78_DF2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTbladicionales_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTbladicionales_Internalname, tblTbladicionales_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavNovedadeventos_leglicestado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavNovedadeventos_leglicestado.getInternalname(), httpContext.getMessage( "Estado", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavNovedadeventos_leglicestado, cmbavNovedadeventos_leglicestado.getInternalname(), GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicestado()), 1, cmbavNovedadeventos_leglicestado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavNovedadeventos_leglicestado.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "", true, (byte)(0), "HLP_LicenciaABM.htm");
         cmbavNovedadeventos_leglicestado.setValue( GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicestado()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicestado.getInternalname(), "Values", cmbavNovedadeventos_leglicestado.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavNovedadeventos_leglicmot_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavNovedadeventos_leglicmot_Internalname, httpContext.getMessage( "Motivo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavNovedadeventos_leglicmot_Internalname, AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicmot(), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", (short)(0), 1, edtavNovedadeventos_leglicmot_Enabled, 1, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavNovedadeventos_leglicfile_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavNovedadeventos_leglicfile_Internalname, httpContext.getMessage( "Archivo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
         edtavNovedadeventos_leglicfile_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicfile_Internalname, "Filetype", edtavNovedadeventos_leglicfile_Filetype, true);
         if ( ! (GXutil.strcmp("", AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile())==0) )
         {
            gxblobfileaux.setSource( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile() );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavNovedadeventos_leglicfile_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavNovedadeventos_leglicfile_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicfile( gxblobfileaux.getURI() );
               edtavNovedadeventos_leglicfile_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicfile_Internalname, "Filetype", edtavNovedadeventos_leglicfile_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtavNovedadeventos_leglicfile_Internalname, "URL", httpContext.getResourceRelative(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile()), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtavNovedadeventos_leglicfile_Internalname, GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile()), httpContext.getResourceRelative(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile()), ((GXutil.strcmp("", edtavNovedadeventos_leglicfile_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavNovedadeventos_leglicfile_Filetype)==0) ? AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicfile() : edtavNovedadeventos_leglicfile_Filetype)) : edtavNovedadeventos_leglicfile_Contenttype), false, "", edtavNovedadeventos_leglicfile_Parameters, 0, edtavNovedadeventos_leglicfile_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavNovedadeventos_leglicfile_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "", "", "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_78_DF2e( true) ;
      }
      else
      {
         wb_table4_78_DF2e( false) ;
      }
   }

   public void wb_table3_23_DF2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell ExtendedComboCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittednovedadeventos_legnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_novedadeventos_legnumero_Internalname, httpContext.getMessage( "Legajo", ""), "", "", lblTextblockcombo_novedadeventos_legnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_novedadeventos_legnumero.setProperty("Caption", Combo_novedadeventos_legnumero_Caption);
         ucCombo_novedadeventos_legnumero.setProperty("Cls", Combo_novedadeventos_legnumero_Cls);
         ucCombo_novedadeventos_legnumero.setProperty("EmptyItem", Combo_novedadeventos_legnumero_Emptyitem);
         ucCombo_novedadeventos_legnumero.setProperty("DropDownOptionsData", AV13NovedadEventos_LegNumero_Data);
         ucCombo_novedadeventos_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_novedadeventos_legnumero_Internalname, "COMBO_NOVEDADEVENTOS_LEGNUMEROContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavMostrar.getVisible(), 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMostrar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavMostrar.getInternalname(), httpContext.getMessage( "Tipo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMostrar, cmbavMostrar.getInternalname(), GXutil.rtrim( AV70Mostrar), 1, cmbavMostrar.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavMostrar.getVisible(), cmbavMostrar.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,36);\"", "", true, (byte)(0), "HLP_LicenciaABM.htm");
         cmbavMostrar.setValue( GXutil.rtrim( AV70Mostrar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMostrar.getInternalname(), "Values", cmbavMostrar.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavNovedadeventos_leglicsitcodigo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavNovedadeventos_leglicsitcodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), httpContext.getMessage( "Licencia", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavNovedadeventos_leglicsitcodigo, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo()), 1, cmbavNovedadeventos_leglicsitcodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavNovedadeventos_leglicsitcodigo.getVisible(), cmbavNovedadeventos_leglicsitcodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,41);\"", "", true, (byte)(0), "HLP_LicenciaABM.htm");
         cmbavNovedadeventos_leglicsitcodigo.setValue( GXutil.rtrim( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavNovedadeventos_leglicsitcodigo.getInternalname(), "Values", cmbavNovedadeventos_leglicsitcodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavLiqdlog_Visible, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavLiqdlog_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqdlog_Internalname, httpContext.getMessage( "Vacaciones", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavLiqdlog_Internalname, AV39LiqDLog, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"", (short)(1), edtavLiqdlog_Visible, edtavLiqdlog_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavMes.getVisible(), 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavMes.getInternalname(), httpContext.getMessage( "Mes", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMes, cmbavMes.getInternalname(), localUtil.dtoc( AV24Mes, 0, "/"), 1, cmbavMes.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVMES.CLICK."+"'", "date", "", cmbavMes.getVisible(), cmbavMes.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"", "", true, (byte)(0), "HLP_LicenciaABM.htm");
         cmbavMes.setValue( localUtil.dtoc( AV24Mes, 0, "/") );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavDia.getVisible(), 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDia.getInternalname(), httpContext.getMessage( "Día", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDia, cmbavDia.getInternalname(), localUtil.dtoc( AV25Dia, 0, "/"), 1, cmbavDia.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVDIA.CLICK."+"'", "date", "", cmbavDia.getVisible(), cmbavDia.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,56);\"", "", true, (byte)(0), "HLP_LicenciaABM.htm");
         cmbavDia.setValue( localUtil.dtoc( AV25Dia, 0, "/") );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavNovedadeventos_leglicenini_Visible, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavNovedadeventos_leglicenini_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavNovedadeventos_leglicenini_Internalname, httpContext.getMessage( "Fecha de Inicio", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavNovedadeventos_leglicenini_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavNovedadeventos_leglicenini_Internalname, localUtil.format(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), "99/99/99"), localUtil.format( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenini(), "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNovedadeventos_leglicenini_Jsonclick, 0, "AttributeDate", "", "", "", "", edtavNovedadeventos_leglicenini_Visible, edtavNovedadeventos_leglicenini_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavNovedadeventos_leglicenini_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavNovedadeventos_leglicenini_Visible==0)||(edtavNovedadeventos_leglicenini_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LicenciaABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavNovedadeventos_leglicenfin_Visible, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavNovedadeventos_leglicenfin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavNovedadeventos_leglicenfin_Internalname, httpContext.getMessage( "Fecha de Fin", ""), "gx-form-item AttributeDateLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavNovedadeventos_leglicenfin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavNovedadeventos_leglicenfin_Internalname, localUtil.format(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin(), "99/99/99"), localUtil.format( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicenfin(), "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNovedadeventos_leglicenfin_Jsonclick, 0, "AttributeDate", "", "", "", "", edtavNovedadeventos_leglicenfin_Visible, edtavNovedadeventos_leglicenfin_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavNovedadeventos_leglicenfin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavNovedadeventos_leglicenfin_Visible==0)||(edtavNovedadeventos_leglicenfin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LicenciaABM.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavCntdias_Visible, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavCntdias_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavCntdias_Internalname, httpContext.getMessage( "Cantidad de días corridos", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavCntdias_Internalname, GXutil.ltrim( localUtil.ntoc( AV34cntDias, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCntdias_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV34cntDias), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV34cntDias), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,71);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCntdias_Jsonclick, 0, "Attribute", "", "", "", "", edtavCntdias_Visible, edtavCntdias_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LicenciaABM.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DataContentCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", chkavNovedadeventos_leglicconplus.getVisible(), 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+chkavNovedadeventos_leglicconplus.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavNovedadeventos_leglicconplus.getInternalname(), httpContext.getMessage( "Con Plus", ""), "gx-form-item AttributeCheckBoxLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavNovedadeventos_leglicconplus.getInternalname(), GXutil.booltostr( AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicconplus()), "", httpContext.getMessage( "Con Plus", ""), chkavNovedadeventos_leglicconplus.getVisible(), chkavNovedadeventos_leglicconplus.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(76, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,76);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_23_DF2e( true) ;
      }
      else
      {
         wb_table3_23_DF2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV17TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17TrnMode", AV17TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV17TrnMode, ""))));
      AV5CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      AV6EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6EmpCod), "ZZZ9")));
      AV7LegNumero = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7LegNumero), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LegNumero), "ZZZZZZZ9")));
      AV8LegLicenIni = (java.util.Date)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8LegLicenIni", localUtil.format(AV8LegLicenIni, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGLICENINI", getSecureSignedToken( "", AV8LegLicenIni));
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
      paDF2( ) ;
      wsDF2( ) ;
      weDF2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251714512955", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("licenciaabm.js", "?20251714512956", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockcombo_novedadeventos_legnumero_Internalname = "TEXTBLOCKCOMBO_NOVEDADEVENTOS_LEGNUMERO" ;
      Combo_novedadeventos_legnumero_Internalname = "COMBO_NOVEDADEVENTOS_LEGNUMERO" ;
      divTablesplittednovedadeventos_legnumero_Internalname = "TABLESPLITTEDNOVEDADEVENTOS_LEGNUMERO" ;
      cmbavMostrar.setInternalname( "vMOSTRAR" );
      cmbavNovedadeventos_leglicsitcodigo.setInternalname( "NOVEDADEVENTOS_LEGLICSITCODIGO" );
      edtavLiqdlog_Internalname = "vLIQDLOG" ;
      cmbavMes.setInternalname( "vMES" );
      cmbavDia.setInternalname( "vDIA" );
      edtavNovedadeventos_leglicenini_Internalname = "NOVEDADEVENTOS_LEGLICENINI" ;
      edtavNovedadeventos_leglicenfin_Internalname = "NOVEDADEVENTOS_LEGLICENFIN" ;
      edtavCntdias_Internalname = "vCNTDIAS" ;
      chkavNovedadeventos_leglicconplus.setInternalname( "NOVEDADEVENTOS_LEGLICCONPLUS" );
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      cmbavNovedadeventos_leglicestado.setInternalname( "NOVEDADEVENTOS_LEGLICESTADO" );
      edtavNovedadeventos_leglicmot_Internalname = "NOVEDADEVENTOS_LEGLICMOT" ;
      edtavNovedadeventos_leglicfile_Internalname = "NOVEDADEVENTOS_LEGLICFILE" ;
      tblTbladicionales_Internalname = "TBLADICIONALES" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavNovedadeventos_clicod_Internalname = "NOVEDADEVENTOS_CLICOD" ;
      edtavNovedadeventos_empcod_Internalname = "NOVEDADEVENTOS_EMPCOD" ;
      edtavImageuri_Internalname = "vIMAGEURI" ;
      edtavCntdiashab_Internalname = "vCNTDIASHAB" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      chkavNovedadeventos_leglicconplus.setEnabled( 1 );
      chkavNovedadeventos_leglicconplus.setVisible( 1 );
      edtavCntdias_Jsonclick = "" ;
      edtavCntdias_Enabled = 1 ;
      edtavNovedadeventos_leglicenfin_Jsonclick = "" ;
      edtavNovedadeventos_leglicenfin_Enabled = 1 ;
      edtavNovedadeventos_leglicenfin_Visible = 1 ;
      edtavNovedadeventos_leglicenini_Jsonclick = "" ;
      edtavNovedadeventos_leglicenini_Enabled = 1 ;
      edtavNovedadeventos_leglicenini_Visible = 1 ;
      cmbavDia.setJsonclick( "" );
      cmbavMes.setJsonclick( "" );
      edtavLiqdlog_Enabled = 1 ;
      cmbavNovedadeventos_leglicsitcodigo.setJsonclick( "" );
      cmbavNovedadeventos_leglicsitcodigo.setEnabled( 1 );
      cmbavNovedadeventos_leglicsitcodigo.setVisible( 1 );
      cmbavMostrar.setJsonclick( "" );
      edtavNovedadeventos_leglicfile_Jsonclick = "" ;
      edtavNovedadeventos_leglicfile_Parameters = "" ;
      edtavNovedadeventos_leglicfile_Contenttype = "" ;
      edtavNovedadeventos_leglicfile_Filetype = "" ;
      edtavNovedadeventos_leglicfile_Enabled = 1 ;
      edtavNovedadeventos_leglicmot_Enabled = 1 ;
      cmbavNovedadeventos_leglicestado.setJsonclick( "" );
      cmbavNovedadeventos_leglicestado.setEnabled( 1 );
      bttBtnenter_Visible = 1 ;
      cmbavMostrar.setVisible( 1 );
      edtavLiqdlog_Visible = 1 ;
      edtavCntdias_Visible = 1 ;
      tblTbladicionales_Visible = 1 ;
      cmbavDia.setVisible( 1 );
      cmbavMes.setVisible( 1 );
      edtavNovedadeventos_leglicenini_Enabled = 1 ;
      chkavNovedadeventos_leglicconplus.setEnabled( 1 );
      edtavNovedadeventos_leglicenfin_Enabled = 1 ;
      cmbavDia.setEnabled( 1 );
      cmbavMes.setEnabled( 1 );
      cmbavNovedadeventos_leglicsitcodigo.setEnabled( 1 );
      cmbavMostrar.setEnabled( 1 );
      edtavNovedadeventos_leglicfile_Enabled = 1 ;
      edtavNovedadeventos_leglicmot_Enabled = 1 ;
      cmbavNovedadeventos_leglicestado.setEnabled( 1 );
      edtavCntdiashab_Jsonclick = "" ;
      edtavCntdiashab_Visible = 1 ;
      edtavImageuri_Visible = 1 ;
      edtavNovedadeventos_empcod_Jsonclick = "" ;
      edtavNovedadeventos_empcod_Visible = 1 ;
      edtavNovedadeventos_clicod_Jsonclick = "" ;
      edtavNovedadeventos_clicod_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
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
      Combo_novedadeventos_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_novedadeventos_legnumero_Enabled = GXutil.toBoolean( -1) ;
      Combo_novedadeventos_legnumero_Cls = "ExtendedCombo Attribute" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Licencia", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavMostrar.setName( "vMOSTRAR" );
      cmbavMostrar.setWebtags( "" );
      cmbavMostrar.addItem("remuneradas", httpContext.getMessage( "Licencias remuneradas", ""), (short)(0));
      cmbavMostrar.addItem("no_remuneradas", httpContext.getMessage( "Licencias no remuneradas", ""), (short)(0));
      if ( cmbavMostrar.getItemCount() > 0 )
      {
         AV70Mostrar = cmbavMostrar.getValidValue(AV70Mostrar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70Mostrar", AV70Mostrar);
      }
      cmbavNovedadeventos_leglicsitcodigo.setName( "NOVEDADEVENTOS_LEGLICSITCODIGO" );
      cmbavNovedadeventos_leglicsitcodigo.setWebtags( "" );
      cmbavNovedadeventos_leglicsitcodigo.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      if ( cmbavNovedadeventos_leglicsitcodigo.getItemCount() > 0 )
      {
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicsitcodigo( cmbavNovedadeventos_leglicsitcodigo.getValidValue(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicsitcodigo()) );
      }
      cmbavMes.setName( "vMES" );
      cmbavMes.setWebtags( "" );
      if ( cmbavMes.getItemCount() > 0 )
      {
         AV24Mes = localUtil.ctod( cmbavMes.getValidValue(localUtil.dtoc( AV24Mes, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Mes", localUtil.format(AV24Mes, "99/99/99"));
      }
      cmbavDia.setName( "vDIA" );
      cmbavDia.setWebtags( "" );
      if ( cmbavDia.getItemCount() > 0 )
      {
         AV25Dia = localUtil.ctod( cmbavDia.getValidValue(localUtil.dtoc( AV25Dia, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Dia", localUtil.format(AV25Dia, "99/99/99"));
      }
      chkavNovedadeventos_leglicconplus.setName( "NOVEDADEVENTOS_LEGLICCONPLUS" );
      chkavNovedadeventos_leglicconplus.setWebtags( "" );
      chkavNovedadeventos_leglicconplus.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavNovedadeventos_leglicconplus.getInternalname(), "TitleCaption", chkavNovedadeventos_leglicconplus.getCaption(), true);
      chkavNovedadeventos_leglicconplus.setCheckedValue( "false" );
      cmbavNovedadeventos_leglicestado.setName( "NOVEDADEVENTOS_LEGLICESTADO" );
      cmbavNovedadeventos_leglicestado.setWebtags( "" );
      cmbavNovedadeventos_leglicestado.addItem("pendiente", httpContext.getMessage( "Pendiente de autorización", ""), (short)(0));
      cmbavNovedadeventos_leglicestado.addItem("autorizada", httpContext.getMessage( "Autorizada", ""), (short)(0));
      if ( cmbavNovedadeventos_leglicestado.getItemCount() > 0 )
      {
         AV11NovedadEventos.setgxTv_SdtNovedadEventos_Leglicestado( cmbavNovedadeventos_leglicestado.getValidValue(AV11NovedadEventos.getgxTv_SdtNovedadEventos_Leglicestado()) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GXV4',fld:'NOVEDADEVENTOS_LEGLICCONPLUS',pic:''},{av:'AV17TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV71LegCuenLicTpo',fld:'vLEGCUENLICTPO',pic:'',hsh:true},{av:'AV32date',fld:'vDATE',pic:'',hsh:true},{av:'AV7LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV45PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV77vacSitCodigo',fld:'vVACSITCODIGO',pic:'',hsh:true},{av:'AV81dumDate',fld:'vDUMDATE',pic:'',hsh:true},{av:'AV8LegLicenIni',fld:'vLEGLICENINI',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("COMBO_NOVEDADEVENTOS_LEGNUMERO.ONOPTIONCLICKED","{handler:'e11DF2',iparms:[{av:'Combo_novedadeventos_legnumero_Selectedvalue_get',ctrl:'COMBO_NOVEDADEVENTOS_LEGNUMERO',prop:'SelectedValue_get'},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'cmbavMostrar'},{av:'AV70Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A2243LegCuenLicTpo',fld:'LEGCUENLICTPO',pic:''},{av:'A2266LegCuenAnio',fld:'LEGCUENANIO',pic:'ZZZ9'},{av:'AV71LegCuenLicTpo',fld:'vLEGCUENLICTPO',pic:'',hsh:true},{av:'AV26primerafecha',fld:'vPRIMERAFECHA',pic:''},{av:'A2244LegCuenLicPerIni',fld:'LEGCUENLICPERINI',pic:''},{av:'A2245LegCuenLicPerFin',fld:'LEGCUENLICPERFIN',pic:''},{av:'AV32date',fld:'vDATE',pic:'',hsh:true},{av:'AV75ultimaPrimeraFecha',fld:'vULTIMAPRIMERAFECHA',pic:''},{av:'AV17TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV7LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV45PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV42ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV43LegClase',fld:'vLEGCLASE',pic:'9'}]");
      setEventMetadata("COMBO_NOVEDADEVENTOS_LEGNUMERO.ONOPTIONCLICKED",",oparms:[{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV43LegClase',fld:'vLEGCLASE',pic:'9'},{av:'cmbavMostrar'},{av:'AV70Mostrar',fld:'vMOSTRAR',pic:''},{av:'AV42ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV73hoyAnio',fld:'vHOYANIO',pic:'ZZZ9'},{av:'AV74pasadoAnio',fld:'vPASADOANIO',pic:'ZZZ9'},{av:'AV26primerafecha',fld:'vPRIMERAFECHA',pic:''},{av:'AV75ultimaPrimeraFecha',fld:'vULTIMAPRIMERAFECHA',pic:''},{av:'cmbavMes'},{av:'AV24Mes',fld:'vMES',pic:''},{av:'cmbavDia'},{av:'AV25Dia',fld:'vDIA',pic:''},{ctrl:'NOVEDADEVENTOS_LEGLICSITCODIGO',prop:'Visible'},{ctrl:'NOVEDADEVENTOS_LEGLICENINI',prop:'Visible'},{ctrl:'NOVEDADEVENTOS_LEGLICENFIN',prop:'Visible'},{av:'tblTbladicionales_Visible',ctrl:'TBLADICIONALES',prop:'Visible'},{av:'edtavCntdias_Visible',ctrl:'vCNTDIAS',prop:'Visible'},{av:'AV39LiqDLog',fld:'vLIQDLOG',pic:''},{av:'AV38LegLicCntDias',fld:'vLEGLICCNTDIAS',pic:'ZZZ9'},{av:'edtavLiqdlog_Visible',ctrl:'vLIQDLOG',prop:'Visible'},{ctrl:'NOVEDADEVENTOS_LEGLICCONPLUS',prop:'Visible'},{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("ENTER","{handler:'e14DF2',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV17TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV19CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV7LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV77vacSitCodigo',fld:'vVACSITCODIGO',pic:'',hsh:true},{av:'AV16Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV16Messages',fld:'vMESSAGES',pic:''},{av:'AV19CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("NOVEDADEVENTOS_LEGLICSITCODIGO.CONTROLVALUECHANGED","{handler:'e15DF2',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV75ultimaPrimeraFecha',fld:'vULTIMAPRIMERAFECHA',pic:''},{av:'AV17TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV7LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV45PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV42ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV43LegClase',fld:'vLEGCLASE',pic:'9'},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("NOVEDADEVENTOS_LEGLICSITCODIGO.CONTROLVALUECHANGED",",oparms:[{ctrl:'NOVEDADEVENTOS_LEGLICSITCODIGO',prop:'Visible'},{ctrl:'NOVEDADEVENTOS_LEGLICENINI',prop:'Visible'},{ctrl:'NOVEDADEVENTOS_LEGLICENFIN',prop:'Visible'},{av:'tblTbladicionales_Visible',ctrl:'TBLADICIONALES',prop:'Visible'},{av:'edtavCntdias_Visible',ctrl:'vCNTDIAS',prop:'Visible'},{av:'AV39LiqDLog',fld:'vLIQDLOG',pic:''},{av:'AV38LegLicCntDias',fld:'vLEGLICCNTDIAS',pic:'ZZZ9'},{av:'cmbavDia'},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'cmbavMes'},{av:'cmbavMostrar'},{av:'edtavLiqdlog_Visible',ctrl:'vLIQDLOG',prop:'Visible'},{ctrl:'NOVEDADEVENTOS_LEGLICCONPLUS',prop:'Visible'},{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("VMOSTRAR.CONTROLVALUECHANGED","{handler:'e16DF2',iparms:[{av:'A1593SitPaiCod',fld:'SITPAICOD',pic:'ZZZ9'},{av:'A913sItDescAbrev',fld:'SITDESCABREV',pic:'@!'},{av:'AV45PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A738SitEsLicencia',fld:'SITESLICENCIA',pic:''},{av:'cmbavMostrar'},{av:'AV70Mostrar',fld:'vMOSTRAR',pic:''},{av:'A739SitLicCuentaTrab',fld:'SITLICCUENTATRAB',pic:''},{av:'A16SitCodigo',fld:'SITCODIGO',pic:''},{av:'A334SitDescrip',fld:'SITDESCRIP',pic:'@!'}]");
      setEventMetadata("VMOSTRAR.CONTROLVALUECHANGED",",oparms:[]}");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENINI.CONTROLVALUECHANGED","{handler:'e17DF2',iparms:[{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENINI.CONTROLVALUECHANGED",",oparms:[{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENFIN.CONTROLVALUECHANGED","{handler:'e18DF2',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''}]");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENFIN.CONTROLVALUECHANGED",",oparms:[{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("VMES.CLICK","{handler:'e19DF2',iparms:[{av:'cmbavMes'},{av:'AV24Mes',fld:'vMES',pic:''},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV32date',fld:'vDATE',pic:'',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV6EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV77vacSitCodigo',fld:'vVACSITCODIGO',pic:'',hsh:true},{av:'AV81dumDate',fld:'vDUMDATE',pic:'',hsh:true}]");
      setEventMetadata("VMES.CLICK",",oparms:[{av:'cmbavDia'},{av:'AV25Dia',fld:'vDIA',pic:''}]}");
      setEventMetadata("VDIA.CLICK","{handler:'e20DF2',iparms:[{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavDia'},{av:'AV25Dia',fld:'vDIA',pic:''},{av:'AV38LegLicCntDias',fld:'vLEGLICCNTDIAS',pic:'ZZZ9'},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VDIA.CLICK",",oparms:[{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''},{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENINI.ISVALID","{handler:'e21DF2',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''}]");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENINI.ISVALID",",oparms:[{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENFIN.ISVALID","{handler:'e22DF2',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV97Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11NovedadEventos',fld:'vNOVEDADEVENTOS',pic:''}]");
      setEventMetadata("NOVEDADEVENTOS_LEGLICENFIN.ISVALID",",oparms:[{av:'AV34cntDias',fld:'vCNTDIAS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_GXV5","{handler:'validv_Gxv5',iparms:[]");
      setEventMetadata("VALIDV_GXV5",",oparms:[]}");
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
      wcpOAV17TrnMode = "" ;
      wcpOAV8LegLicenIni = GXutil.nullDate() ;
      Combo_novedadeventos_legnumero_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV17TrnMode = "" ;
      AV8LegLicenIni = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV97Pgmname = "" ;
      AV71LegCuenLicTpo = "" ;
      AV32date = GXutil.nullDate() ;
      AV77vacSitCodigo = "" ;
      AV81dumDate = GXutil.nullDate() ;
      GXKey = "" ;
      AV11NovedadEventos = new web.SdtNovedadEventos(remoteHandle);
      AV13NovedadEventos_LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A2243LegCuenLicTpo = "" ;
      AV26primerafecha = GXutil.nullDate() ;
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      AV75ultimaPrimeraFecha = GXutil.nullDate() ;
      AV42ConveCodigo = "" ;
      AV16Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      A913sItDescAbrev = "" ;
      A16SitCodigo = "" ;
      A334SitDescrip = "" ;
      GXCCtlgxBlob = "" ;
      Combo_novedadeventos_legnumero_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV52ImageURI = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV70Mostrar = "" ;
      AV24Mes = GXutil.nullDate() ;
      AV25Dia = GXutil.nullDate() ;
      AV39LiqDLog = "" ;
      Gx_mode = "" ;
      ucCombo_novedadeventos_legnumero = new com.genexus.webpanels.GXUserControl();
      AV82LegModTra = "" ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      scmdbuf = "" ;
      H00DF2_A3CliCod = new int[1] ;
      H00DF2_A1EmpCod = new short[1] ;
      H00DF2_A1818LegEstado = new byte[1] ;
      H00DF2_A6LegNumero = new int[1] ;
      H00DF2_A250LegIdNomApe = new String[] {""} ;
      A250LegIdNomApe = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV15Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      GXv_int4 = new byte[1] ;
      GXv_int12 = new byte[1] ;
      AV66EmpFracVacAnt = DecimalUtil.ZERO ;
      AV27hoy = GXutil.nullDate() ;
      AV41elaniopasado = GXutil.nullDate() ;
      H00DF3_A2266LegCuenAnio = new short[1] ;
      H00DF3_A2243LegCuenLicTpo = new String[] {""} ;
      H00DF3_A6LegNumero = new int[1] ;
      H00DF3_A1EmpCod = new short[1] ;
      H00DF3_A3CliCod = new int[1] ;
      H00DF3_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      H00DF3_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      AV23ultimaFecha = GXutil.nullDate() ;
      AV31iniFecha = GXutil.nullDate() ;
      AV33iniDia = GXutil.nullDate() ;
      AV80iniDiaTexto = "" ;
      GXv_boolean11 = new boolean[1] ;
      AV35LegFecIngreso = GXutil.nullDate() ;
      GXv_date14 = new java.util.Date[1] ;
      AV36LegFecEgreso = GXutil.nullDate() ;
      GXv_date15 = new java.util.Date[1] ;
      AV37mensualTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char16 = "" ;
      GXv_char2 = new String[1] ;
      AV40vacacionesLiqPeriodo = GXutil.nullDate() ;
      GXv_int3 = new short[1] ;
      GXv_char17 = new String[1] ;
      AV44LiqDPlus = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      H00DF4_A1593SitPaiCod = new short[1] ;
      H00DF4_n1593SitPaiCod = new boolean[] {false} ;
      H00DF4_A738SitEsLicencia = new boolean[] {false} ;
      H00DF4_A739SitLicCuentaTrab = new boolean[] {false} ;
      H00DF4_A334SitDescrip = new String[] {""} ;
      H00DF4_A16SitCodigo = new String[] {""} ;
      H00DF4_A913sItDescAbrev = new String[] {""} ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      lblTextblockcombo_novedadeventos_legnumero_Jsonclick = "" ;
      Combo_novedadeventos_legnumero_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licenciaabm__default(),
         new Object[] {
             new Object[] {
            H00DF2_A3CliCod, H00DF2_A1EmpCod, H00DF2_A1818LegEstado, H00DF2_A6LegNumero, H00DF2_A250LegIdNomApe
            }
            , new Object[] {
            H00DF3_A2266LegCuenAnio, H00DF3_A2243LegCuenLicTpo, H00DF3_A6LegNumero, H00DF3_A1EmpCod, H00DF3_A3CliCod, H00DF3_A2244LegCuenLicPerIni, H00DF3_A2245LegCuenLicPerFin
            }
            , new Object[] {
            H00DF4_A1593SitPaiCod, H00DF4_n1593SitPaiCod, H00DF4_A738SitEsLicencia, H00DF4_A739SitLicCuentaTrab, H00DF4_A334SitDescrip, H00DF4_A16SitCodigo, H00DF4_A913sItDescAbrev
            }
         }
      );
      AV97Pgmname = "LicenciaABM" ;
      /* GeneXus formulas. */
      AV97Pgmname = "LicenciaABM" ;
      Gx_err = (short)(0) ;
      edtavLiqdlog_Enabled = 0 ;
      edtavCntdias_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV43LegClase ;
   private byte nDonePA ;
   private byte A1818LegEstado ;
   private byte AV64EmpPerVacDes ;
   private byte GXv_int4[] ;
   private byte AV65EmpPerVacHas ;
   private byte GXv_int12[] ;
   private byte nGXWrapped ;
   private short wcpOAV6EmpCod ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV6EmpCod ;
   private short AV45PaiCod ;
   private short A1EmpCod ;
   private short A2266LegCuenAnio ;
   private short A1593SitPaiCod ;
   private short AV38LegLicCntDias ;
   private short wbEnd ;
   private short wbStart ;
   private short AV63cntDiasHab ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV34cntDias ;
   private short AV78desdeAnio ;
   private short AV73hoyAnio ;
   private short AV74pasadoAnio ;
   private short AV21i ;
   private short GXv_int3[] ;
   private int wcpOAV5CliCod ;
   private int wcpOAV7LegNumero ;
   private int AV5CliCod ;
   private int AV7LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int edtavNovedadeventos_clicod_Visible ;
   private int edtavNovedadeventos_empcod_Visible ;
   private int edtavImageuri_Visible ;
   private int edtavCntdiashab_Visible ;
   private int edtavLiqdlog_Enabled ;
   private int edtavCntdias_Enabled ;
   private int edtavNovedadeventos_leglicmot_Enabled ;
   private int edtavNovedadeventos_leglicfile_Enabled ;
   private int edtavNovedadeventos_leglicenfin_Enabled ;
   private int edtavNovedadeventos_leglicenini_Enabled ;
   private int tblTbladicionales_Visible ;
   private int edtavNovedadeventos_leglicenini_Visible ;
   private int edtavNovedadeventos_leglicenfin_Visible ;
   private int edtavCntdias_Visible ;
   private int edtavLiqdlog_Visible ;
   private int bttBtnenter_Visible ;
   private int AV96GXV10 ;
   private int idxLst ;
   private java.math.BigDecimal AV66EmpFracVacAnt ;
   private java.math.BigDecimal AV44LiqDPlus ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String wcpOAV17TrnMode ;
   private String Combo_novedadeventos_legnumero_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV17TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV97Pgmname ;
   private String AV71LegCuenLicTpo ;
   private String AV77vacSitCodigo ;
   private String GXKey ;
   private String A2243LegCuenLicTpo ;
   private String AV42ConveCodigo ;
   private String A16SitCodigo ;
   private String GXCCtlgxBlob ;
   private String Combo_novedadeventos_legnumero_Cls ;
   private String Combo_novedadeventos_legnumero_Selectedvalue_set ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavNovedadeventos_clicod_Internalname ;
   private String edtavNovedadeventos_clicod_Jsonclick ;
   private String edtavNovedadeventos_empcod_Internalname ;
   private String edtavNovedadeventos_empcod_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String edtavImageuri_Internalname ;
   private String edtavCntdiashab_Internalname ;
   private String edtavCntdiashab_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV70Mostrar ;
   private String edtavLiqdlog_Internalname ;
   private String edtavCntdias_Internalname ;
   private String edtavNovedadeventos_leglicenini_Internalname ;
   private String edtavNovedadeventos_leglicenfin_Internalname ;
   private String edtavNovedadeventos_leglicmot_Internalname ;
   private String edtavNovedadeventos_leglicfile_Internalname ;
   private String Gx_mode ;
   private String Combo_novedadeventos_legnumero_Internalname ;
   private String tblTbladicionales_Internalname ;
   private String AV82LegModTra ;
   private String bttBtnenter_Internalname ;
   private String scmdbuf ;
   private String AV37mensualTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char16 ;
   private String GXv_char2[] ;
   private String GXv_char17[] ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String edtavNovedadeventos_leglicfile_Filetype ;
   private String edtavNovedadeventos_leglicfile_Contenttype ;
   private String edtavNovedadeventos_leglicfile_Parameters ;
   private String edtavNovedadeventos_leglicfile_Jsonclick ;
   private String tblUnnamedtable2_Internalname ;
   private String divTablesplittednovedadeventos_legnumero_Internalname ;
   private String lblTextblockcombo_novedadeventos_legnumero_Internalname ;
   private String lblTextblockcombo_novedadeventos_legnumero_Jsonclick ;
   private String Combo_novedadeventos_legnumero_Caption ;
   private String edtavNovedadeventos_leglicenini_Jsonclick ;
   private String edtavNovedadeventos_leglicenfin_Jsonclick ;
   private String edtavCntdias_Jsonclick ;
   private java.util.Date wcpOAV8LegLicenIni ;
   private java.util.Date AV8LegLicenIni ;
   private java.util.Date AV32date ;
   private java.util.Date AV81dumDate ;
   private java.util.Date AV26primerafecha ;
   private java.util.Date A2244LegCuenLicPerIni ;
   private java.util.Date A2245LegCuenLicPerFin ;
   private java.util.Date AV75ultimaPrimeraFecha ;
   private java.util.Date AV24Mes ;
   private java.util.Date AV25Dia ;
   private java.util.Date AV27hoy ;
   private java.util.Date AV41elaniopasado ;
   private java.util.Date AV23ultimaFecha ;
   private java.util.Date AV31iniFecha ;
   private java.util.Date AV33iniDia ;
   private java.util.Date AV35LegFecIngreso ;
   private java.util.Date GXv_date14[] ;
   private java.util.Date AV36LegFecEgreso ;
   private java.util.Date GXv_date15[] ;
   private java.util.Date AV40vacacionesLiqPeriodo ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV19CheckRequiredFieldsResult ;
   private boolean A738SitEsLicencia ;
   private boolean A739SitLicCuentaTrab ;
   private boolean Combo_novedadeventos_legnumero_Enabled ;
   private boolean Combo_novedadeventos_legnumero_Emptyitem ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV18LoadSuccess ;
   private boolean AV57SitEsLicencia ;
   private boolean GXv_boolean5[] ;
   private boolean AV58sitEsAusencia ;
   private boolean GXv_boolean6[] ;
   private boolean AV59SitLicCuentaTrab ;
   private boolean GXv_boolean7[] ;
   private boolean AV60SitEsRevistaAFip ;
   private boolean GXv_boolean8[] ;
   private boolean GXv_boolean9[] ;
   private boolean AV61EstadoCanPresen ;
   private boolean GXv_boolean10[] ;
   private boolean AV62EstadoRemCorr ;
   private boolean AV50existe ;
   private boolean AV79estaDeVaca ;
   private boolean AV76trabajaEnDia ;
   private boolean GXv_boolean11[] ;
   private boolean Cond_result ;
   private boolean n1593SitPaiCod ;
   private String AV39LiqDLog ;
   private String A913sItDescAbrev ;
   private String A334SitDescrip ;
   private String AV52ImageURI ;
   private String A250LegIdNomApe ;
   private String AV80iniDiaTexto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucCombo_novedadeventos_legnumero ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice cmbavMostrar ;
   private HTMLChoice cmbavNovedadeventos_leglicsitcodigo ;
   private HTMLChoice cmbavMes ;
   private HTMLChoice cmbavDia ;
   private ICheckbox chkavNovedadeventos_leglicconplus ;
   private HTMLChoice cmbavNovedadeventos_leglicestado ;
   private IDataStoreProvider pr_default ;
   private int[] H00DF2_A3CliCod ;
   private short[] H00DF2_A1EmpCod ;
   private byte[] H00DF2_A1818LegEstado ;
   private int[] H00DF2_A6LegNumero ;
   private String[] H00DF2_A250LegIdNomApe ;
   private short[] H00DF3_A2266LegCuenAnio ;
   private String[] H00DF3_A2243LegCuenLicTpo ;
   private int[] H00DF3_A6LegNumero ;
   private short[] H00DF3_A1EmpCod ;
   private int[] H00DF3_A3CliCod ;
   private java.util.Date[] H00DF3_A2244LegCuenLicPerIni ;
   private java.util.Date[] H00DF3_A2245LegCuenLicPerFin ;
   private short[] H00DF4_A1593SitPaiCod ;
   private boolean[] H00DF4_n1593SitPaiCod ;
   private boolean[] H00DF4_A738SitEsLicencia ;
   private boolean[] H00DF4_A739SitLicCuentaTrab ;
   private String[] H00DF4_A334SitDescrip ;
   private String[] H00DF4_A16SitCodigo ;
   private String[] H00DF4_A913sItDescAbrev ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13NovedadEventos_LegNumero_Data ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV16Messages ;
   private com.genexus.SdtMessages_Message AV15Message ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
   private web.SdtNovedadEventos AV11NovedadEventos ;
}

final  class licenciaabm__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00DF4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV70Mostrar ,
                                          boolean A739SitLicCuentaTrab ,
                                          boolean A738SitEsLicencia ,
                                          short AV45PaiCod ,
                                          short A1593SitPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[1];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT SitPaiCod, SitEsLicencia, SitLicCuentaTrab, SitDescrip, SitCodigo, sItDescAbrev FROM Estado" ;
      addWhere(sWhereString, "(SitPaiCod = ?)");
      addWhere(sWhereString, "(SitEsLicencia = TRUE)");
      if ( GXutil.strcmp(AV70Mostrar, httpContext.getMessage( "remuneradas", "")) == 0 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = TRUE)");
      }
      if ( GXutil.strcmp(AV70Mostrar, httpContext.getMessage( "no_remuneradas", "")) == 0 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitPaiCod, sItDescAbrev" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_H00DF4(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , ((Boolean) dynConstraints[2]).booleanValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00DF2", "SELECT CliCod, EmpCod, LegEstado, LegNumero, LegIdNomApe FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) AND (LegEstado = 1) ORDER BY LegIdNomApe ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00DF3", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuenLicPerIni, LegCuenLicPerFin FROM legajo_cuenta_licencias WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio >= ?) AND (LegCuenAnio <= ?) ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00DF4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((boolean[]) buf[2])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 4);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

