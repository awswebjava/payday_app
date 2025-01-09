package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ajustesporinflacion_impl extends GXDataArea
{
   public ajustesporinflacion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ajustesporinflacion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ajustesporinflacion_impl.class ));
   }

   public ajustesporinflacion_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV5MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5MenuOpcCod", AV5MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5MenuOpcCod, ""))));
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
      paOM2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startOM2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.ajustesporinflacion", new String[] {GXutil.URLEncode(GXutil.rtrim(AV5MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV27DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV27DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECCODIGO_DATA", AV26SecCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECCODIGO_DATA", AV26SecCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPUESTOCODIGO_DATA", AV29PuestoCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPUESTOCODIGO_DATA", AV29PuestoCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUCCODIGO_DATA", AV30SucCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUCCODIGO_DATA", AV30SucCodigo_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO_DATA", AV31LegNumero_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO_DATA", AV31LegNumero_Data);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV25CheckRequiredFieldsResult);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLEGNUMERO", AV22LegNumero);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLEGNUMERO", AV22LegNumero);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV15EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGESTADO", GXutil.ltrim( localUtil.ntoc( A1818LegEstado, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCONVECODIGO", GXutil.rtrim( A937LegConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGSECCODIGO", GXutil.rtrim( A1579LegSecCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECCODIGO", AV19SecCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECCODIGO", AV19SecCodigo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "LEGPUESCODIGO", GXutil.rtrim( A1578LegPuesCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPUESTOCODIGO", AV20PuestoCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPUESTOCODIGO", AV20PuestoCodigo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "LEGSUCCODIGO", GXutil.rtrim( A1577LegSucCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUCCODIGO", AV21SucCodigo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUCCODIGO", AV21SucCodigo);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV38Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV5MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Cls", GXutil.rtrim( Combo_seccodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_seccodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_seccodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_seccodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_seccodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Emptyitemtext", GXutil.rtrim( Combo_seccodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Cls", GXutil.rtrim( Combo_puestocodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_puestocodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_puestocodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_puestocodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_puestocodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Emptyitemtext", GXutil.rtrim( Combo_puestocodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Cls", GXutil.rtrim( Combo_succodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_succodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Allowmultipleselection", GXutil.booltostr( Combo_succodigo_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Includeonlyselectedoption", GXutil.booltostr( Combo_succodigo_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Multiplevaluestype", GXutil.rtrim( Combo_succodigo_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Emptyitemtext", GXutil.rtrim( Combo_succodigo_Emptyitemtext));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Cls", GXutil.rtrim( Combo_legnumero_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_set", GXutil.rtrim( Combo_legnumero_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Allowmultipleselection", GXutil.booltostr( Combo_legnumero_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Includeonlyselectedoption", GXutil.booltostr( Combo_legnumero_Includeonlyselectedoption));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Emptyitem", GXutil.booltostr( Combo_legnumero_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Multiplevaluestype", GXutil.rtrim( Combo_legnumero_Multiplevaluestype));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Title", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmationtext", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Confirmationtext));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Yesbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Nobuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Nobuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Cancelbuttoncaption", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Cancelbuttoncaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttonposition", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Yesbuttonposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmtype", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Confirmtype));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Ddointernalname", GXutil.rtrim( Combo_legnumero_Ddointernalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Result", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Selectedvalue_get", GXutil.rtrim( Combo_legnumero_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_succodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_puestocodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_seccodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_LEGNUMERO_Ddointernalname", GXutil.rtrim( Combo_legnumero_Ddointernalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVELOP_CONFIRMPANEL_CONFIRMAR_Result", GXutil.rtrim( Dvelop_confirmpanel_confirmar_Result));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SUCCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_succodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PUESTOCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_puestocodigo_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECCODIGO_Selectedvalue_get", GXutil.rtrim( Combo_seccodigo_Selectedvalue_get));
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
         weOM2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtOM2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.ajustesporinflacion", new String[] {GXutil.URLEncode(GXutil.rtrim(AV5MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "ajustesPorInflacion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Ajuste de sueldos por inflación", "") ;
   }

   public void wbOM0( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_OM2( true) ;
      }
      else
      {
         wb_table1_9_OM2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_OM2e( boolean wbgen )
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
         wb_table2_110_OM2( true) ;
      }
      else
      {
         wb_table2_110_OM2( false) ;
      }
      return  ;
   }

   public void wb_table2_110_OM2e( boolean wbgen )
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

   public void startOM2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Ajuste de sueldos por inflación", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupOM0( ) ;
   }

   public void wsOM2( )
   {
      startOM2( ) ;
      evtOM2( ) ;
   }

   public void evtOM2( )
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_SECCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_PUESTOCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_SUCCODIGO.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DVELOP_CONFIRMPANEL_CONFIRMAR.CLOSE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e15OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoConfirmar' */
                           e16OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e17OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e19OM2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                              }
                              dynload_actions( ) ;
                           }
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

   public void weOM2( )
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

   public void paOM2( )
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
            GX_FocusControl = chkavWelcomemessage_nomostrarmas.getInternalname() ;
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
      AV23WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV23WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23WelcomeMessage_NoMostrarMas", AV23WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfOM2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV38Pgmname = "ajustesPorInflacion" ;
      Gx_err = (short)(0) ;
   }

   public void rfOM2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e17OM2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e19OM2 ();
         wbOM0( ) ;
      }
   }

   public void send_integrity_lvl_hashesOM2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV14CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV15EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV38Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV5MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5MenuOpcCod, ""))));
   }

   public void before_start_formulas( )
   {
      AV38Pgmname = "ajustesPorInflacion" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupOM0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15OM2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV27DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECCODIGO_DATA"), AV26SecCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPUESTOCODIGO_DATA"), AV29PuestoCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSUCCODIGO_DATA"), AV30SucCodigo_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO_DATA"), AV31LegNumero_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLEGNUMERO"), AV22LegNumero);
         /* Read saved values. */
         Combo_seccodigo_Cls = httpContext.cgiGet( "COMBO_SECCODIGO_Cls") ;
         Combo_seccodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_SECCODIGO_Selectedvalue_set") ;
         Combo_seccodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Allowmultipleselection")) ;
         Combo_seccodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECCODIGO_Includeonlyselectedoption")) ;
         Combo_seccodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_SECCODIGO_Multiplevaluestype") ;
         Combo_seccodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_SECCODIGO_Emptyitemtext") ;
         Combo_puestocodigo_Cls = httpContext.cgiGet( "COMBO_PUESTOCODIGO_Cls") ;
         Combo_puestocodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_PUESTOCODIGO_Selectedvalue_set") ;
         Combo_puestocodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PUESTOCODIGO_Allowmultipleselection")) ;
         Combo_puestocodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PUESTOCODIGO_Includeonlyselectedoption")) ;
         Combo_puestocodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_PUESTOCODIGO_Multiplevaluestype") ;
         Combo_puestocodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_PUESTOCODIGO_Emptyitemtext") ;
         Combo_succodigo_Cls = httpContext.cgiGet( "COMBO_SUCCODIGO_Cls") ;
         Combo_succodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_SUCCODIGO_Selectedvalue_set") ;
         Combo_succodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUCCODIGO_Allowmultipleselection")) ;
         Combo_succodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SUCCODIGO_Includeonlyselectedoption")) ;
         Combo_succodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_SUCCODIGO_Multiplevaluestype") ;
         Combo_succodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_SUCCODIGO_Emptyitemtext") ;
         Combo_legnumero_Cls = httpContext.cgiGet( "COMBO_LEGNUMERO_Cls") ;
         Combo_legnumero_Selectedvalue_set = httpContext.cgiGet( "COMBO_LEGNUMERO_Selectedvalue_set") ;
         Combo_legnumero_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Allowmultipleselection")) ;
         Combo_legnumero_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Includeonlyselectedoption")) ;
         Combo_legnumero_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LEGNUMERO_Emptyitem")) ;
         Combo_legnumero_Multiplevaluestype = httpContext.cgiGet( "COMBO_LEGNUMERO_Multiplevaluestype") ;
         Dvelop_confirmpanel_confirmar_Title = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Title") ;
         Dvelop_confirmpanel_confirmar_Confirmationtext = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmationtext") ;
         Dvelop_confirmpanel_confirmar_Yesbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttoncaption") ;
         Dvelop_confirmpanel_confirmar_Nobuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Nobuttoncaption") ;
         Dvelop_confirmpanel_confirmar_Cancelbuttoncaption = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Cancelbuttoncaption") ;
         Dvelop_confirmpanel_confirmar_Yesbuttonposition = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Yesbuttonposition") ;
         Dvelop_confirmpanel_confirmar_Confirmtype = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Confirmtype") ;
         Combo_legnumero_Ddointernalname = httpContext.cgiGet( "COMBO_LEGNUMERO_Ddointernalname") ;
         Dvelop_confirmpanel_confirmar_Result = httpContext.cgiGet( "DVELOP_CONFIRMPANEL_CONFIRMAR_Result") ;
         Combo_succodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_SUCCODIGO_Selectedvalue_get") ;
         Combo_puestocodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_PUESTOCODIGO_Selectedvalue_get") ;
         Combo_seccodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_SECCODIGO_Selectedvalue_get") ;
         /* Read variables values. */
         AV24WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV23WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23WelcomeMessage_NoMostrarMas", AV23WelcomeMessage_NoMostrarMas);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavNuevafecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vNUEVAFECHA");
            GX_FocusControl = edtavNuevafecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16nuevaFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16nuevaFecha", localUtil.format(AV16nuevaFecha, "99/99/99"));
         }
         else
         {
            AV16nuevaFecha = localUtil.ctod( httpContext.cgiGet( edtavNuevafecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16nuevaFecha", localUtil.format(AV16nuevaFecha, "99/99/99"));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavPorunaje_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavPorunaje_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPORUNAJE");
            GX_FocusControl = edtavPorunaje_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17porUnaje = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17porUnaje", GXutil.ltrimstr( AV17porUnaje, 6, 4));
         }
         else
         {
            AV17porUnaje = localUtil.ctond( httpContext.cgiGet( edtavPorunaje_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17porUnaje", GXutil.ltrimstr( AV17porUnaje, 6, 4));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavOrigenfecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vORIGENFECHA");
            GX_FocusControl = edtavOrigenfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18origenFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18origenFecha", localUtil.format(AV18origenFecha, "99/99/99"));
         }
         else
         {
            AV18origenFecha = localUtil.ctod( httpContext.cgiGet( edtavOrigenfecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18origenFecha", localUtil.format(AV18origenFecha, "99/99/99"));
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
      e15OM2 ();
      if (returnInSub) return;
   }

   public void e15OM2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV8headTitle = Form.getCaption() ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", "", AV8headTitle) ;
      GXt_int1 = AV15EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      ajustesporinflacion_impl.this.GXt_int1 = GXv_int2[0] ;
      AV15EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      GXt_int3 = AV14CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      ajustesporinflacion_impl.this.GXt_int3 = GXv_int4[0] ;
      AV14CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV27DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV27DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      /* Execute user subroutine: 'LOADCOMBOSECCODIGO' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOPUESTOCODIGO' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOSUCCODIGO' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S142 ();
      if (returnInSub) return;
      GXv_char7[0] = AV9MenuBienveImgURL ;
      GXv_char8[0] = AV11MenuBienveTitulo ;
      GXv_char9[0] = AV12MenuBienveTexto ;
      GXv_boolean10[0] = AV13MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV5MenuOpcCod, GXv_char7, GXv_char8, GXv_char9, GXv_boolean10) ;
      ajustesporinflacion_impl.this.AV9MenuBienveImgURL = GXv_char7[0] ;
      ajustesporinflacion_impl.this.AV11MenuBienveTitulo = GXv_char8[0] ;
      ajustesporinflacion_impl.this.AV12MenuBienveTexto = GXv_char9[0] ;
      ajustesporinflacion_impl.this.AV13MenuBienveVisible = GXv_boolean10[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV13MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV13MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV11MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV12MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV24WelcomeMessage_Foto = AV9MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV24WelcomeMessage_Foto)==0) ? AV36Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24WelcomeMessage_Foto), true);
         AV36Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV9MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV24WelcomeMessage_Foto)==0) ? AV36Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24WelcomeMessage_Foto), true);
      }
      GXt_char11 = "" ;
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char9) ;
      ajustesporinflacion_impl.this.GXt_char12 = GXv_char9[0] ;
      GXv_char8[0] = GXt_char11 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char12, GXv_char8) ;
      ajustesporinflacion_impl.this.GXt_char11 = GXv_char8[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char11 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      new web.setopcionmenusesion(remoteHandle, context).execute( AV5MenuOpcCod, "", AV8headTitle) ;
   }

   public void e16OM2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S152 ();
      if (returnInSub) return;
      if ( AV25CheckRequiredFieldsResult )
      {
         this.executeUsercontrolMethod("", false, "DVELOP_CONFIRMPANEL_CONFIRMARContainer", "Confirm", "", new Object[] {});
      }
      /*  Sending Event outputs  */
   }

   public void e14OM2( )
   {
      /* Dvelop_confirmpanel_confirmar_Close Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Dvelop_confirmpanel_confirmar_Result, "Yes") == 0 )
      {
         /* Execute user subroutine: 'DO ACTION CONFIRMAR' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegNumero", AV22LegNumero);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31LegNumero_Data", AV31LegNumero_Data);
   }

   public void e13OM2( )
   {
      /* Combo_succodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV21SucCodigo.fromJSonString(Combo_succodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21SucCodigo", AV21SucCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31LegNumero_Data", AV31LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegNumero", AV22LegNumero);
   }

   public void e12OM2( )
   {
      /* Combo_puestocodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV20PuestoCodigo.fromJSonString(Combo_puestocodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20PuestoCodigo", AV20PuestoCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31LegNumero_Data", AV31LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegNumero", AV22LegNumero);
   }

   public void e11OM2( )
   {
      /* Combo_seccodigo_Onoptionclicked Routine */
      returnInSub = false ;
      AV19SecCodigo.fromJSonString(Combo_seccodigo_Selectedvalue_get, null);
      /* Execute user subroutine: 'LOADCOMBOLEGNUMERO' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19SecCodigo", AV19SecCodigo);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31LegNumero_Data", AV31LegNumero_Data);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22LegNumero", AV22LegNumero);
   }

   public void S162( )
   {
      /* 'DO ACTION CONFIRMAR' Routine */
      returnInSub = false ;
      if ( AV25CheckRequiredFieldsResult )
      {
         GXv_char9[0] = AV33error ;
         new web.ajustarsueldos(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV22LegNumero, AV18origenFecha, AV16nuevaFecha, AV17porUnaje, GXv_char9) ;
         ajustesporinflacion_impl.this.AV33error = GXv_char9[0] ;
         if ( ! (GXutil.strcmp("", AV33error)==0) )
         {
            new web.alert(remoteHandle, context).execute( "error", AV33error) ;
         }
         else
         {
            new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Se actualizaron los sueldos correctamente", "")) ;
            AV18origenFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18origenFecha", localUtil.format(AV18origenFecha, "99/99/99"));
            AV16nuevaFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16nuevaFecha", localUtil.format(AV16nuevaFecha, "99/99/99"));
            AV17porUnaje = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17porUnaje", GXutil.ltrimstr( AV17porUnaje, 6, 4));
            AV22LegNumero.clear();
            AV31LegNumero_Data.clear();
         }
      }
   }

   public void S152( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV25CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV16nuevaFecha)) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nueva fecha de vigencia", ""), "", "", "", "", "", "", "", ""), "error", edtavNuevafecha_Internalname, "true", ""));
         AV25CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV17porUnaje)==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Factor de incremento", ""), "", "", "", "", "", "", "", ""), "error", edtavPorunaje_Internalname, "true", ""));
         AV25CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18origenFecha)) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de origen", ""), "", "", "", "", "", "", "", ""), "error", edtavOrigenfecha_Internalname, "true", ""));
         AV25CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      }
      if ( AV22LegNumero.size() == 0 )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajos", ""), "", "", "", "", "", "", "", ""), "error", Combo_legnumero_Ddointernalname, "true", ""));
         AV25CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      }
      if ( (( GXutil.resetTime(AV16nuevaFecha).before( GXutil.resetTime( AV18origenFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV16nuevaFecha), GXutil.resetTime(AV18origenFecha)) )) )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "La fecha nueva debe ser mayor a la fecha de origen", "")) ;
         AV25CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      }
      if ( ( AV17porUnaje.doubleValue() > 0 ) && ( AV17porUnaje.doubleValue() <= 1 ) )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "El factor de incremento debe ser mayor a 1", "")) ;
         AV25CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25CheckRequiredFieldsResult", AV25CheckRequiredFieldsResult);
      }
   }

   public void S142( )
   {
      /* 'LOADCOMBOLEGNUMERO' Routine */
      returnInSub = false ;
      AV31LegNumero_Data.clear();
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1579LegSecCodigo ,
                                           AV19SecCodigo ,
                                           A1578LegPuesCodigo ,
                                           AV20PuestoCodigo ,
                                           A1577LegSucCodigo ,
                                           AV21SucCodigo ,
                                           Integer.valueOf(AV19SecCodigo.size()) ,
                                           Integer.valueOf(AV20PuestoCodigo.size()) ,
                                           Integer.valueOf(AV21SucCodigo.size()) ,
                                           A937LegConveCodigo ,
                                           Byte.valueOf(A1818LegEstado) ,
                                           Integer.valueOf(AV14CliCod) ,
                                           Short.valueOf(AV15EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor H00OM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV15EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1577LegSucCodigo = H00OM2_A1577LegSucCodigo[0] ;
         n1577LegSucCodigo = H00OM2_n1577LegSucCodigo[0] ;
         A1578LegPuesCodigo = H00OM2_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = H00OM2_n1578LegPuesCodigo[0] ;
         A1579LegSecCodigo = H00OM2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = H00OM2_n1579LegSecCodigo[0] ;
         A937LegConveCodigo = H00OM2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = H00OM2_n937LegConveCodigo[0] ;
         A1818LegEstado = H00OM2_A1818LegEstado[0] ;
         A1EmpCod = H00OM2_A1EmpCod[0] ;
         A3CliCod = H00OM2_A3CliCod[0] ;
         A6LegNumero = H00OM2_A6LegNumero[0] ;
         A250LegIdNomApe = H00OM2_A250LegIdNomApe[0] ;
         AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
         AV31LegNumero_Data.add(AV28Combo_DataItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      Combo_legnumero_Selectedvalue_set = AV22LegNumero.toJSonString(false) ;
      ucCombo_legnumero.sendProperty(context, "", false, Combo_legnumero_Internalname, "SelectedValue_set", Combo_legnumero_Selectedvalue_set);
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "LoadComboLegNumero &LegNumero_Data ", "")+GXutil.trim( GXutil.str( AV31LegNumero_Data.size(), 9, 0))) ;
      if ( AV31LegNumero_Data.size() == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "LoadComboLegNumero noneEeee\"", "")) ;
         AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( "" );
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( "" );
         AV31LegNumero_Data.add(AV28Combo_DataItem, 0);
      }
      AV39L = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "LoadComboLegNumero 4", "")) ;
      while ( AV39L <= AV22LegNumero.size() )
      {
         AV32validoEs = false ;
         AV40GXV1 = 1 ;
         while ( AV40GXV1 <= AV31LegNumero_Data.size() )
         {
            AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV31LegNumero_Data.elementAt(-1+AV40GXV1));
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "LoadComboLegNumero 5", "")) ;
            if ( CommonUtil.decimalVal( AV28Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Id(), ".").doubleValue() == ((Number) AV22LegNumero.elementAt(-1+AV39L)).intValue() )
            {
               AV32validoEs = true ;
               if (true) break;
            }
            AV40GXV1 = (int)(AV40GXV1+1) ;
         }
         if ( AV32validoEs )
         {
            AV39L = (byte)(AV39L+1) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "LoadComboLegNumero 6", "")) ;
            AV22LegNumero.removeItem(AV39L);
         }
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOSUCCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor H00OM3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV15EmpCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = H00OM3_A3CliCod[0] ;
         A1EmpCod = H00OM3_A1EmpCod[0] ;
         A1243SucCodigo = H00OM3_A1243SucCodigo[0] ;
         A1244SucDescrip = H00OM3_A1244SucDescrip[0] ;
         AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1243SucCodigo );
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1244SucDescrip );
         AV30SucCodigo_Data.add(AV28Combo_DataItem, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      Combo_succodigo_Selectedvalue_set = AV21SucCodigo.toJSonString(false) ;
      ucCombo_succodigo.sendProperty(context, "", false, Combo_succodigo_Internalname, "SelectedValue_set", Combo_succodigo_Selectedvalue_set);
   }

   public void S122( )
   {
      /* 'LOADCOMBOPUESTOCODIGO' Routine */
      returnInSub = false ;
      AV29PuestoCodigo_Data.clear();
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV19SecCodigo ,
                                           Integer.valueOf(AV19SecCodigo.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV14CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor H00OM4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV14CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A3CliCod = H00OM4_A3CliCod[0] ;
         A13SecCodigo = H00OM4_A13SecCodigo[0] ;
         A1240PuestoCodigo = H00OM4_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = H00OM4_A1241PuestoDescrip[0] ;
         AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1240PuestoCodigo );
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1241PuestoDescrip );
         AV29PuestoCodigo_Data.add(AV28Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_puestocodigo_Selectedvalue_set = AV20PuestoCodigo.toJSonString(false) ;
      ucCombo_puestocodigo.sendProperty(context, "", false, Combo_puestocodigo_Internalname, "SelectedValue_set", Combo_puestocodigo_Selectedvalue_set);
      AV39L = (byte)(1) ;
      while ( AV39L <= AV20PuestoCodigo.size() )
      {
         AV32validoEs = false ;
         AV43GXV2 = 1 ;
         while ( AV43GXV2 <= AV29PuestoCodigo_Data.size() )
         {
            AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)((web.wwpbaseobjects.SdtDVB_SDTComboData_Item)AV29PuestoCodigo_Data.elementAt(-1+AV43GXV2));
            if ( GXutil.strcmp(GXutil.trim( AV28Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Id()), (String)AV20PuestoCodigo.elementAt(-1+AV39L)) == 0 )
            {
               AV32validoEs = true ;
               if (true) break;
            }
            AV43GXV2 = (int)(AV43GXV2+1) ;
         }
         if ( AV32validoEs )
         {
            AV39L = (byte)(AV39L+1) ;
         }
         else
         {
            AV20PuestoCodigo.removeItem(AV39L);
         }
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOSECCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor H00OM5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV14CliCod)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A3CliCod = H00OM5_A3CliCod[0] ;
         A13SecCodigo = H00OM5_A13SecCodigo[0] ;
         A329SecDescrip = H00OM5_A329SecDescrip[0] ;
         AV28Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A13SecCodigo );
         AV28Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A329SecDescrip );
         AV26SecCodigo_Data.add(AV28Combo_DataItem, 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
      Combo_seccodigo_Selectedvalue_set = AV19SecCodigo.toJSonString(false) ;
      ucCombo_seccodigo.sendProperty(context, "", false, Combo_seccodigo_Internalname, "SelectedValue_set", Combo_seccodigo_Selectedvalue_set);
   }

   public void e17OM2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV15EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      ajustesporinflacion_impl.this.GXt_int1 = GXv_int2[0] ;
      AV15EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EmpCod), "ZZZ9")));
      GXt_int3 = AV14CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      ajustesporinflacion_impl.this.GXt_int3 = GXv_int4[0] ;
      AV14CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void e18OM2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV23WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean10[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV5MenuOpcCod, GXv_boolean10) ;
         GXv_char9[0] = AV10textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char9) ;
         ajustesporinflacion_impl.this.AV10textoNoMostrara = GXv_char9[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV10textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean10[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV5MenuOpcCod, GXv_boolean10) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e19OM2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_110_OM2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabledvelop_confirmpanel_confirmar_Internalname, tblTabledvelop_confirmpanel_confirmar_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tbody>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-center;text-align:-moz-center;text-align:-webkit-center")+"\">") ;
         /* User Defined Control */
         ucDvelop_confirmpanel_confirmar.setProperty("Title", Dvelop_confirmpanel_confirmar_Title);
         ucDvelop_confirmpanel_confirmar.setProperty("ConfirmationText", Dvelop_confirmpanel_confirmar_Confirmationtext);
         ucDvelop_confirmpanel_confirmar.setProperty("YesButtonCaption", Dvelop_confirmpanel_confirmar_Yesbuttoncaption);
         ucDvelop_confirmpanel_confirmar.setProperty("NoButtonCaption", Dvelop_confirmpanel_confirmar_Nobuttoncaption);
         ucDvelop_confirmpanel_confirmar.setProperty("CancelButtonCaption", Dvelop_confirmpanel_confirmar_Cancelbuttoncaption);
         ucDvelop_confirmpanel_confirmar.setProperty("YesButtonPosition", Dvelop_confirmpanel_confirmar_Yesbuttonposition);
         ucDvelop_confirmpanel_confirmar.setProperty("ConfirmType", Dvelop_confirmpanel_confirmar_Confirmtype);
         ucDvelop_confirmpanel_confirmar.render(context, "dvelop.gxbootstrap.confirmpanel", Dvelop_confirmpanel_confirmar_Internalname, "DVELOP_CONFIRMPANEL_CONFIRMARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVELOP_CONFIRMPANEL_CONFIRMARContainer"+"Body"+"\" style=\"display:none;\">") ;
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "</tbody>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_110_OM2e( true) ;
      }
      else
      {
         wb_table2_110_OM2e( false) ;
      }
   }

   public void wb_table1_9_OM2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e20om1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentitem_Internalname, 1, 0, "px", 0, "px", "WelcomeContentItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomecontentflex_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableImagenCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableimagen_Internalname, 1, 0, "px", 0, "px", "WelcomeTableImagen", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Welcome Message_Foto", ""), "gx-form-item WelcomeImagenLabel", 0, true, "width: 25%;");
         /* Static Bitmap Variable */
         ClassString = "WelcomeImagen" + " " + ((GXutil.strcmp(imgavWelcomemessage_foto_gximage, "")==0) ? "" : "GX_Image_"+imgavWelcomemessage_foto_gximage+"_Class") ;
         StyleString = "" ;
         AV24WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV24WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV36Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV24WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV24WelcomeMessage_Foto)==0) ? AV36Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV24WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV24WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "WelcomeTableTextoCell", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletexto_Internalname, 1, 0, "px", 0, "px", "WelcomeTableTexto", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;align-items:flex-start;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table3_27_OM2( true) ;
      }
      else
      {
         wb_table3_27_OM2( false) ;
      }
      return  ;
   }

   public void wb_table3_27_OM2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_32_OM2( true) ;
      }
      else
      {
         wb_table4_32_OM2( false) ;
      }
      return  ;
   }

   public void wb_table4_32_OM2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcomebottomitem_Internalname, 1, 0, "px", 0, "px", "WelcomeBottomItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablecmb_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tablec_Internalname, 1, 0, "px", 0, "px", "TableC font14px", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), "gx-form-item AttributeCheckBoxLabel", 0, true, "width: 25%;");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV23WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tabletext_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Required", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavNuevafecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavNuevafecha_Internalname, httpContext.getMessage( "Nueva fecha de vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavNuevafecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavNuevafecha_Internalname, localUtil.format(AV16nuevaFecha, "99/99/99"), localUtil.format( AV16nuevaFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNuevafecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavNuevafecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavNuevafecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavNuevafecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ajustesPorInflacion.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Required", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPorunaje_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavPorunaje_Internalname, httpContext.getMessage( "Factor de incremento", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPorunaje_Internalname, GXutil.ltrim( localUtil.ntoc( AV17porUnaje, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavPorunaje_Enabled!=0) ? localUtil.format( AV17porUnaje, "9.9999") : localUtil.format( AV17porUnaje, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPorunaje_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavPorunaje_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Required", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOrigenfecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavOrigenfecha_Internalname, httpContext.getMessage( "Fecha de origen", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavOrigenfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavOrigenfecha_Internalname, localUtil.format(AV18origenFecha, "99/99/99"), localUtil.format( AV18origenFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOrigenfecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavOrigenfecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavOrigenfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavOrigenfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ajustesPorInflacion.htm");
         httpContext.writeTextNL( "</div>") ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_seccodigo_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblockcombo_seccodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
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
         ucCombo_seccodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV27DDO_TitleSettingsIcons);
         ucCombo_seccodigo.setProperty("DropDownOptionsData", AV26SecCodigo_Data);
         ucCombo_seccodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_seccodigo_Internalname, "COMBO_SECCODIGOContainer");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_puestocodigo_Internalname, httpContext.getMessage( "Puesto", ""), "", "", lblTextblockcombo_puestocodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
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
         ucCombo_puestocodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV27DDO_TitleSettingsIcons);
         ucCombo_puestocodigo.setProperty("DropDownOptionsData", AV29PuestoCodigo_Data);
         ucCombo_puestocodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_puestocodigo_Internalname, "COMBO_PUESTOCODIGOContainer");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_succodigo_Internalname, httpContext.getMessage( "Sucursal", ""), "", "", lblTextblockcombo_succodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
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
         ucCombo_succodigo.setProperty("DropDownOptionsTitleSettingsIcons", AV27DDO_TitleSettingsIcons);
         ucCombo_succodigo.setProperty("DropDownOptionsData", AV30SucCodigo_Data);
         ucCombo_succodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_succodigo_Internalname, "COMBO_SUCCODIGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Required ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedlegnumero_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_legnumero_Internalname, httpContext.getMessage( "Legajos", ""), "", "", lblTextblockcombo_legnumero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
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
         ucCombo_legnumero.setProperty("DropDownOptionsTitleSettingsIcons", AV27DDO_TitleSettingsIcons);
         ucCombo_legnumero.setProperty("DropDownOptionsData", AV31LegNumero_Data);
         ucCombo_legnumero.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_legnumero_Internalname, "COMBO_LEGNUMEROContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 7, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e21om1_client"+"'", TempTags, "", 2, "HLP_ajustesPorInflacion.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_OM2e( true) ;
      }
      else
      {
         wb_table1_9_OM2e( false) ;
      }
   }

   public void wb_table4_32_OM2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_32_OM2e( true) ;
      }
      else
      {
         wb_table4_32_OM2e( false) ;
      }
   }

   public void wb_table3_27_OM2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_ajustesPorInflacion.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_27_OM2e( true) ;
      }
      else
      {
         wb_table3_27_OM2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV5MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5MenuOpcCod", AV5MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5MenuOpcCod, ""))));
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
      paOM2( ) ;
      wsOM2( ) ;
      weOM2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171325268", true, true);
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
      httpContext.AddJavascriptSource("ajustesporinflacion.js", "?2025171325268", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/ConfirmPanel/BootstrapConfirmPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblWelcomemessage_closehelp_Internalname = "WELCOMEMESSAGE_CLOSEHELP" ;
      divWelcomemessage_tableclose_Internalname = "WELCOMEMESSAGE_TABLECLOSE" ;
      divWelcomemessage_welcometableprincipal_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL" ;
      imgavWelcomemessage_foto_Internalname = "vWELCOMEMESSAGE_FOTO" ;
      divWelcomemessage_welcometableimagen_Internalname = "WELCOMEMESSAGE_WELCOMETABLEIMAGEN" ;
      lblWelcomemessage_titulo_Internalname = "WELCOMEMESSAGE_TITULO" ;
      tblWelcomemessage_tabletitulo_Internalname = "WELCOMEMESSAGE_TABLETITULO" ;
      lblWelcomemessage_descripcion_Internalname = "WELCOMEMESSAGE_DESCRIPCION" ;
      tblWelcomemessage_tabledescripcion_Internalname = "WELCOMEMESSAGE_TABLEDESCRIPCION" ;
      divWelcomemessage_tabletexto_Internalname = "WELCOMEMESSAGE_TABLETEXTO" ;
      divWelcomemessage_welcomecontentflex_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTFLEX" ;
      divWelcomemessage_welcomecontentitem_Internalname = "WELCOMEMESSAGE_WELCOMECONTENTITEM" ;
      chkavWelcomemessage_nomostrarmas.setInternalname( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      divWelcomemessage_tablec_Internalname = "WELCOMEMESSAGE_TABLEC" ;
      lblWelcomemessage_combotext_Internalname = "WELCOMEMESSAGE_COMBOTEXT" ;
      divWelcomemessage_tabletext_Internalname = "WELCOMEMESSAGE_TABLETEXT" ;
      divWelcomemessage_tablecmb_Internalname = "WELCOMEMESSAGE_TABLECMB" ;
      divWelcomemessage_welcomebottomitem_Internalname = "WELCOMEMESSAGE_WELCOMEBOTTOMITEM" ;
      divWelcomemessage_welcometableparent_Internalname = "WELCOMEMESSAGE_WELCOMETABLEPARENT" ;
      edtavNuevafecha_Internalname = "vNUEVAFECHA" ;
      edtavPorunaje_Internalname = "vPORUNAJE" ;
      edtavOrigenfecha_Internalname = "vORIGENFECHA" ;
      lblTextblockcombo_seccodigo_Internalname = "TEXTBLOCKCOMBO_SECCODIGO" ;
      Combo_seccodigo_Internalname = "COMBO_SECCODIGO" ;
      divTablesplittedseccodigo_Internalname = "TABLESPLITTEDSECCODIGO" ;
      lblTextblockcombo_puestocodigo_Internalname = "TEXTBLOCKCOMBO_PUESTOCODIGO" ;
      Combo_puestocodigo_Internalname = "COMBO_PUESTOCODIGO" ;
      divTablesplittedpuestocodigo_Internalname = "TABLESPLITTEDPUESTOCODIGO" ;
      lblTextblockcombo_succodigo_Internalname = "TEXTBLOCKCOMBO_SUCCODIGO" ;
      Combo_succodigo_Internalname = "COMBO_SUCCODIGO" ;
      divTablesplittedsuccodigo_Internalname = "TABLESPLITTEDSUCCODIGO" ;
      lblTextblockcombo_legnumero_Internalname = "TEXTBLOCKCOMBO_LEGNUMERO" ;
      Combo_legnumero_Internalname = "COMBO_LEGNUMERO" ;
      divTablesplittedlegnumero_Internalname = "TABLESPLITTEDLEGNUMERO" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Dvelop_confirmpanel_confirmar_Internalname = "DVELOP_CONFIRMPANEL_CONFIRMAR" ;
      tblTabledvelop_confirmpanel_confirmar_Internalname = "TABLEDVELOP_CONFIRMPANEL_CONFIRMAR" ;
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
      Combo_legnumero_Caption = "" ;
      Combo_succodigo_Caption = "" ;
      Combo_puestocodigo_Caption = "" ;
      Combo_seccodigo_Caption = "" ;
      edtavOrigenfecha_Jsonclick = "" ;
      edtavOrigenfecha_Enabled = 1 ;
      edtavPorunaje_Jsonclick = "" ;
      edtavPorunaje_Enabled = 1 ;
      edtavNuevafecha_Jsonclick = "" ;
      edtavNuevafecha_Enabled = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      Dvelop_confirmpanel_confirmar_Confirmtype = "1" ;
      Dvelop_confirmpanel_confirmar_Yesbuttonposition = "left" ;
      Dvelop_confirmpanel_confirmar_Cancelbuttoncaption = "WWP_ConfirmTextCancel" ;
      Dvelop_confirmpanel_confirmar_Nobuttoncaption = "WWP_ConfirmTextNo" ;
      Dvelop_confirmpanel_confirmar_Yesbuttoncaption = "WWP_ConfirmTextYes" ;
      Dvelop_confirmpanel_confirmar_Confirmationtext = "¿Confirma actualizar el sueldo de los legajos seleccionados?" ;
      Dvelop_confirmpanel_confirmar_Title = httpContext.getMessage( "Confirmación", "") ;
      Combo_legnumero_Multiplevaluestype = "Tags" ;
      Combo_legnumero_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_legnumero_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_legnumero_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_legnumero_Cls = "ExtendedCombo Attribute" ;
      Combo_succodigo_Emptyitemtext = "Todas" ;
      Combo_succodigo_Multiplevaluestype = "Tags" ;
      Combo_succodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_succodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_succodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_puestocodigo_Emptyitemtext = "Todos" ;
      Combo_puestocodigo_Multiplevaluestype = "Tags" ;
      Combo_puestocodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_puestocodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_puestocodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_seccodigo_Emptyitemtext = "Todas" ;
      Combo_seccodigo_Multiplevaluestype = "Tags" ;
      Combo_seccodigo_Includeonlyselectedoption = GXutil.toBoolean( -1) ;
      Combo_seccodigo_Allowmultipleselection = GXutil.toBoolean( -1) ;
      Combo_seccodigo_Cls = "ExtendedCombo Attribute" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Ajuste de sueldos por inflación", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavWelcomemessage_nomostrarmas.setName( "vWELCOMEMESSAGE_NOMOSTRARMAS" );
      chkavWelcomemessage_nomostrarmas.setWebtags( "" );
      chkavWelcomemessage_nomostrarmas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavWelcomemessage_nomostrarmas.getInternalname(), "TitleCaption", chkavWelcomemessage_nomostrarmas.getCaption(), true);
      chkavWelcomemessage_nomostrarmas.setCheckedValue( "false" );
      AV23WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV23WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23WelcomeMessage_NoMostrarMas", AV23WelcomeMessage_NoMostrarMas);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV23WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV38Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV5MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e16OM2',iparms:[{av:'AV25CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV16nuevaFecha',fld:'vNUEVAFECHA',pic:''},{av:'AV17porUnaje',fld:'vPORUNAJE',pic:'9.9999'},{av:'AV18origenFecha',fld:'vORIGENFECHA',pic:''},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''},{av:'Combo_legnumero_Ddointernalname',ctrl:'COMBO_LEGNUMERO',prop:'DDOInternalName'}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV25CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("DVELOP_CONFIRMPANEL_CONFIRMAR.CLOSE","{handler:'e14OM2',iparms:[{av:'Dvelop_confirmpanel_confirmar_Result',ctrl:'DVELOP_CONFIRMPANEL_CONFIRMAR',prop:'Result'},{av:'AV25CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV18origenFecha',fld:'vORIGENFECHA',pic:''},{av:'AV16nuevaFecha',fld:'vNUEVAFECHA',pic:''},{av:'AV17porUnaje',fld:'vPORUNAJE',pic:'9.9999'}]");
      setEventMetadata("DVELOP_CONFIRMPANEL_CONFIRMAR.CLOSE",",oparms:[{av:'AV18origenFecha',fld:'vORIGENFECHA',pic:''},{av:'AV16nuevaFecha',fld:'vNUEVAFECHA',pic:''},{av:'AV17porUnaje',fld:'vPORUNAJE',pic:'9.9999'},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV31LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''}]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e21OM1',iparms:[]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("COMBO_SUCCODIGO.ONOPTIONCLICKED","{handler:'e13OM2',iparms:[{av:'Combo_succodigo_Selectedvalue_get',ctrl:'COMBO_SUCCODIGO',prop:'SelectedValue_get'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV19SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV20PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV21SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV38Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("COMBO_SUCCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV21SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'AV31LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''}]}");
      setEventMetadata("COMBO_PUESTOCODIGO.ONOPTIONCLICKED","{handler:'e12OM2',iparms:[{av:'Combo_puestocodigo_Selectedvalue_get',ctrl:'COMBO_PUESTOCODIGO',prop:'SelectedValue_get'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV19SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV20PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV21SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV38Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("COMBO_PUESTOCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV20PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'AV31LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''}]}");
      setEventMetadata("COMBO_SECCODIGO.ONOPTIONCLICKED","{handler:'e11OM2',iparms:[{av:'Combo_seccodigo_Selectedvalue_get',ctrl:'COMBO_SECCODIGO',prop:'SelectedValue_get'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'AV15EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A1818LegEstado',fld:'LEGESTADO',pic:'9'},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'A1579LegSecCodigo',fld:'LEGSECCODIGO',pic:''},{av:'AV19SecCodigo',fld:'vSECCODIGO',pic:''},{av:'A1578LegPuesCodigo',fld:'LEGPUESCODIGO',pic:''},{av:'AV20PuestoCodigo',fld:'vPUESTOCODIGO',pic:''},{av:'A1577LegSucCodigo',fld:'LEGSUCCODIGO',pic:''},{av:'AV21SucCodigo',fld:'vSUCCODIGO',pic:''},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''},{av:'AV38Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("COMBO_SECCODIGO.ONOPTIONCLICKED",",oparms:[{av:'AV19SecCodigo',fld:'vSECCODIGO',pic:''},{av:'AV31LegNumero_Data',fld:'vLEGNUMERO_DATA',pic:''},{av:'Combo_legnumero_Selectedvalue_set',ctrl:'COMBO_LEGNUMERO',prop:'SelectedValue_set'},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:''}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18OM2',iparms:[{av:'AV23WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV5MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV14CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e20OM1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
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
      wcpOAV5MenuOpcCod = "" ;
      Combo_legnumero_Ddointernalname = "" ;
      Dvelop_confirmpanel_confirmar_Result = "" ;
      Combo_legnumero_Selectedvalue_get = "" ;
      Combo_succodigo_Selectedvalue_get = "" ;
      Combo_puestocodigo_Selectedvalue_get = "" ;
      Combo_seccodigo_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV5MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV38Pgmname = "" ;
      GXKey = "" ;
      AV27DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV26SecCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV29PuestoCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV30SucCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV31LegNumero_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV22LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      A937LegConveCodigo = "" ;
      A1579LegSecCodigo = "" ;
      AV19SecCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      A1578LegPuesCodigo = "" ;
      AV20PuestoCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      A1577LegSucCodigo = "" ;
      AV21SucCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      A250LegIdNomApe = "" ;
      Combo_seccodigo_Selectedvalue_set = "" ;
      Combo_puestocodigo_Selectedvalue_set = "" ;
      Combo_succodigo_Selectedvalue_set = "" ;
      Combo_legnumero_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV24WelcomeMessage_Foto = "" ;
      AV16nuevaFecha = GXutil.nullDate() ;
      AV17porUnaje = DecimalUtil.ZERO ;
      AV18origenFecha = GXutil.nullDate() ;
      AV8headTitle = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV9MenuBienveImgURL = "" ;
      GXv_char7 = new String[1] ;
      AV11MenuBienveTitulo = "" ;
      AV12MenuBienveTexto = "" ;
      AV36Welcomemessage_foto_GXI = "" ;
      GXt_char11 = "" ;
      GXt_char12 = "" ;
      GXv_char8 = new String[1] ;
      AV33error = "" ;
      scmdbuf = "" ;
      H00OM2_A1577LegSucCodigo = new String[] {""} ;
      H00OM2_n1577LegSucCodigo = new boolean[] {false} ;
      H00OM2_A1578LegPuesCodigo = new String[] {""} ;
      H00OM2_n1578LegPuesCodigo = new boolean[] {false} ;
      H00OM2_A1579LegSecCodigo = new String[] {""} ;
      H00OM2_n1579LegSecCodigo = new boolean[] {false} ;
      H00OM2_A937LegConveCodigo = new String[] {""} ;
      H00OM2_n937LegConveCodigo = new boolean[] {false} ;
      H00OM2_A1818LegEstado = new byte[1] ;
      H00OM2_A1EmpCod = new short[1] ;
      H00OM2_A3CliCod = new int[1] ;
      H00OM2_A6LegNumero = new int[1] ;
      H00OM2_A250LegIdNomApe = new String[] {""} ;
      AV28Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucCombo_legnumero = new com.genexus.webpanels.GXUserControl();
      H00OM3_A3CliCod = new int[1] ;
      H00OM3_A1EmpCod = new short[1] ;
      H00OM3_A1243SucCodigo = new String[] {""} ;
      H00OM3_A1244SucDescrip = new String[] {""} ;
      A1243SucCodigo = "" ;
      A1244SucDescrip = "" ;
      ucCombo_succodigo = new com.genexus.webpanels.GXUserControl();
      A13SecCodigo = "" ;
      H00OM4_A3CliCod = new int[1] ;
      H00OM4_A13SecCodigo = new String[] {""} ;
      H00OM4_A1240PuestoCodigo = new String[] {""} ;
      H00OM4_A1241PuestoDescrip = new String[] {""} ;
      A1240PuestoCodigo = "" ;
      A1241PuestoDescrip = "" ;
      ucCombo_puestocodigo = new com.genexus.webpanels.GXUserControl();
      H00OM5_A3CliCod = new int[1] ;
      H00OM5_A13SecCodigo = new String[] {""} ;
      H00OM5_A329SecDescrip = new String[] {""} ;
      A329SecDescrip = "" ;
      ucCombo_seccodigo = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV10textoNoMostrara = "" ;
      GXv_char9 = new String[1] ;
      GXv_boolean10 = new boolean[1] ;
      sStyleString = "" ;
      ucDvelop_confirmpanel_confirmar = new com.genexus.webpanels.GXUserControl();
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblTextblockcombo_seccodigo_Jsonclick = "" ;
      lblTextblockcombo_puestocodigo_Jsonclick = "" ;
      lblTextblockcombo_succodigo_Jsonclick = "" ;
      lblTextblockcombo_legnumero_Jsonclick = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ajustesporinflacion__default(),
         new Object[] {
             new Object[] {
            H00OM2_A1577LegSucCodigo, H00OM2_n1577LegSucCodigo, H00OM2_A1578LegPuesCodigo, H00OM2_n1578LegPuesCodigo, H00OM2_A1579LegSecCodigo, H00OM2_n1579LegSecCodigo, H00OM2_A937LegConveCodigo, H00OM2_n937LegConveCodigo, H00OM2_A1818LegEstado, H00OM2_A1EmpCod,
            H00OM2_A3CliCod, H00OM2_A6LegNumero, H00OM2_A250LegIdNomApe
            }
            , new Object[] {
            H00OM3_A3CliCod, H00OM3_A1EmpCod, H00OM3_A1243SucCodigo, H00OM3_A1244SucDescrip
            }
            , new Object[] {
            H00OM4_A3CliCod, H00OM4_A13SecCodigo, H00OM4_A1240PuestoCodigo, H00OM4_A1241PuestoDescrip
            }
            , new Object[] {
            H00OM5_A3CliCod, H00OM5_A13SecCodigo, H00OM5_A329SecDescrip
            }
         }
      );
      AV38Pgmname = "ajustesPorInflacion" ;
      /* GeneXus formulas. */
      AV38Pgmname = "ajustesPorInflacion" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte A1818LegEstado ;
   private byte nDonePA ;
   private byte AV39L ;
   private byte nGXWrapped ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV15EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int AV14CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int AV19SecCodigo_size ;
   private int AV20PuestoCodigo_size ;
   private int AV21SucCodigo_size ;
   private int AV40GXV1 ;
   private int AV43GXV2 ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int edtavNuevafecha_Enabled ;
   private int edtavPorunaje_Enabled ;
   private int edtavOrigenfecha_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal AV17porUnaje ;
   private String Combo_legnumero_Ddointernalname ;
   private String Dvelop_confirmpanel_confirmar_Result ;
   private String Combo_legnumero_Selectedvalue_get ;
   private String Combo_succodigo_Selectedvalue_get ;
   private String Combo_puestocodigo_Selectedvalue_get ;
   private String Combo_seccodigo_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV38Pgmname ;
   private String GXKey ;
   private String A937LegConveCodigo ;
   private String A1579LegSecCodigo ;
   private String A1578LegPuesCodigo ;
   private String A1577LegSucCodigo ;
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
   private String Dvelop_confirmpanel_confirmar_Title ;
   private String Dvelop_confirmpanel_confirmar_Confirmationtext ;
   private String Dvelop_confirmpanel_confirmar_Yesbuttoncaption ;
   private String Dvelop_confirmpanel_confirmar_Nobuttoncaption ;
   private String Dvelop_confirmpanel_confirmar_Cancelbuttoncaption ;
   private String Dvelop_confirmpanel_confirmar_Yesbuttonposition ;
   private String Dvelop_confirmpanel_confirmar_Confirmtype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String edtavNuevafecha_Internalname ;
   private String edtavPorunaje_Internalname ;
   private String edtavOrigenfecha_Internalname ;
   private String GXv_char7[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String GXt_char11 ;
   private String GXt_char12 ;
   private String GXv_char8[] ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String scmdbuf ;
   private String Combo_legnumero_Internalname ;
   private String A1243SucCodigo ;
   private String Combo_succodigo_Internalname ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private String Combo_puestocodigo_Internalname ;
   private String Combo_seccodigo_Internalname ;
   private String GXv_char9[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String sStyleString ;
   private String tblTabledvelop_confirmpanel_confirmar_Internalname ;
   private String Dvelop_confirmpanel_confirmar_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String ClassString ;
   private String imgavWelcomemessage_foto_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablecontent_Internalname ;
   private String edtavNuevafecha_Jsonclick ;
   private String edtavPorunaje_Jsonclick ;
   private String edtavOrigenfecha_Jsonclick ;
   private String divTablesplittedseccodigo_Internalname ;
   private String lblTextblockcombo_seccodigo_Internalname ;
   private String lblTextblockcombo_seccodigo_Jsonclick ;
   private String Combo_seccodigo_Caption ;
   private String divTablesplittedpuestocodigo_Internalname ;
   private String lblTextblockcombo_puestocodigo_Internalname ;
   private String lblTextblockcombo_puestocodigo_Jsonclick ;
   private String Combo_puestocodigo_Caption ;
   private String divTablesplittedsuccodigo_Internalname ;
   private String lblTextblockcombo_succodigo_Internalname ;
   private String lblTextblockcombo_succodigo_Jsonclick ;
   private String Combo_succodigo_Caption ;
   private String divTablesplittedlegnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Internalname ;
   private String lblTextblockcombo_legnumero_Jsonclick ;
   private String Combo_legnumero_Caption ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private java.util.Date AV16nuevaFecha ;
   private java.util.Date AV18origenFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV25CheckRequiredFieldsResult ;
   private boolean Combo_seccodigo_Allowmultipleselection ;
   private boolean Combo_seccodigo_Includeonlyselectedoption ;
   private boolean Combo_puestocodigo_Allowmultipleselection ;
   private boolean Combo_puestocodigo_Includeonlyselectedoption ;
   private boolean Combo_succodigo_Allowmultipleselection ;
   private boolean Combo_succodigo_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Allowmultipleselection ;
   private boolean Combo_legnumero_Includeonlyselectedoption ;
   private boolean Combo_legnumero_Emptyitem ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV23WelcomeMessage_NoMostrarMas ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV13MenuBienveVisible ;
   private boolean n1577LegSucCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean AV32validoEs ;
   private boolean GXv_boolean10[] ;
   private boolean AV24WelcomeMessage_Foto_IsBlob ;
   private String AV12MenuBienveTexto ;
   private String AV10textoNoMostrara ;
   private String wcpOAV5MenuOpcCod ;
   private String AV5MenuOpcCod ;
   private String A250LegIdNomApe ;
   private String AV8headTitle ;
   private String AV9MenuBienveImgURL ;
   private String AV11MenuBienveTitulo ;
   private String AV36Welcomemessage_foto_GXI ;
   private String AV33error ;
   private String A1244SucDescrip ;
   private String A1241PuestoDescrip ;
   private String A329SecDescrip ;
   private String AV24WelcomeMessage_Foto ;
   private GXSimpleCollection<Integer> AV22LegNumero ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucCombo_legnumero ;
   private com.genexus.webpanels.GXUserControl ucCombo_succodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_puestocodigo ;
   private com.genexus.webpanels.GXUserControl ucCombo_seccodigo ;
   private com.genexus.webpanels.GXUserControl ucDvelop_confirmpanel_confirmar ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private IDataStoreProvider pr_default ;
   private String[] H00OM2_A1577LegSucCodigo ;
   private boolean[] H00OM2_n1577LegSucCodigo ;
   private String[] H00OM2_A1578LegPuesCodigo ;
   private boolean[] H00OM2_n1578LegPuesCodigo ;
   private String[] H00OM2_A1579LegSecCodigo ;
   private boolean[] H00OM2_n1579LegSecCodigo ;
   private String[] H00OM2_A937LegConveCodigo ;
   private boolean[] H00OM2_n937LegConveCodigo ;
   private byte[] H00OM2_A1818LegEstado ;
   private short[] H00OM2_A1EmpCod ;
   private int[] H00OM2_A3CliCod ;
   private int[] H00OM2_A6LegNumero ;
   private String[] H00OM2_A250LegIdNomApe ;
   private int[] H00OM3_A3CliCod ;
   private short[] H00OM3_A1EmpCod ;
   private String[] H00OM3_A1243SucCodigo ;
   private String[] H00OM3_A1244SucDescrip ;
   private int[] H00OM4_A3CliCod ;
   private String[] H00OM4_A13SecCodigo ;
   private String[] H00OM4_A1240PuestoCodigo ;
   private String[] H00OM4_A1241PuestoDescrip ;
   private int[] H00OM5_A3CliCod ;
   private String[] H00OM5_A13SecCodigo ;
   private String[] H00OM5_A329SecDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV19SecCodigo ;
   private GXSimpleCollection<String> AV20PuestoCodigo ;
   private GXSimpleCollection<String> AV21SucCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV26SecCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV29PuestoCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV30SucCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV31LegNumero_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV28Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV27DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
}

final  class ajustesporinflacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00OM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1579LegSecCodigo ,
                                          GXSimpleCollection<String> AV19SecCodigo ,
                                          String A1578LegPuesCodigo ,
                                          GXSimpleCollection<String> AV20PuestoCodigo ,
                                          String A1577LegSucCodigo ,
                                          GXSimpleCollection<String> AV21SucCodigo ,
                                          int AV19SecCodigo_size ,
                                          int AV20PuestoCodigo_size ,
                                          int AV21SucCodigo_size ,
                                          String A937LegConveCodigo ,
                                          byte A1818LegEstado ,
                                          int AV14CliCod ,
                                          short AV15EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[2];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT LegSucCodigo, LegPuesCodigo, LegSecCodigo, LegConveCodigo, LegEstado, EmpCod, CliCod, LegNumero, LegIdNomApe FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "((char_length(trim(trailing ' ' from LegConveCodigo))=0) or LegConveCodigo IS NULL)");
      addWhere(sWhereString, "(LegEstado = 1)");
      if ( AV19SecCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19SecCodigo, "LegSecCodigo IN (", ")")+")");
      }
      if ( AV20PuestoCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20PuestoCodigo, "LegPuesCodigo IN (", ")")+")");
      }
      if ( AV21SucCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV21SucCodigo, "LegSucCodigo IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_H00OM4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV19SecCodigo ,
                                          int AV19SecCodigo_size ,
                                          int A3CliCod ,
                                          int AV14CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[1];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT CliCod, SecCodigo, PuestoCodigo, PuestoDescrip FROM Puesto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV19SecCodigo_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19SecCodigo, "SecCodigo IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PuestoDescrip" ;
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
                  return conditional_H00OM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() );
            case 2 :
                  return conditional_H00OM4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00OM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OM3", "SELECT CliCod, EmpCod, SucCodigo, SucDescrip FROM Sucursal WHERE (CliCod = ?) AND (EmpCod = ?) ORDER BY SucDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OM4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OM5", "SELECT CliCod, SecCodigo, SecDescrip FROM Seccion WHERE CliCod = ? ORDER BY CliCod, SecDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((byte[]) buf[8])[0] = rslt.getByte(5);
               ((short[]) buf[9])[0] = rslt.getShort(6);
               ((int[]) buf[10])[0] = rslt.getInt(7);
               ((int[]) buf[11])[0] = rslt.getInt(8);
               ((String[]) buf[12])[0] = rslt.getVarchar(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

