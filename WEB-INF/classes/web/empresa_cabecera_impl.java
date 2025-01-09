package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresa_cabecera_impl extends GXDataArea
{
   public empresa_cabecera_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresa_cabecera_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_cabecera_impl.class ));
   }

   public empresa_cabecera_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      chkavEmpresa_abm_1_empmodempl = UIFactory.getCheckbox(this);
      chkavEmpresa_abm_1_empmodauto = UIFactory.getCheckbox(this);
      cmbavEmpresa_abm_1_empmodtra = new HTMLChoice();
      dynavEmpresa_abm_1_actcodigo = new HTMLChoice();
      dynavEmpresa_abm_1_empcondicod = new HTMLChoice();
      dynavEmpresa_abm_1_empzoncod = new HTMLChoice();
      dynavEmpresa_abm_1_tipemplecod = new HTMLChoice();
      dynavEmpresa_abm_1_provcod = new HTMLChoice();
      dynavEmpresa_abm_1_empactcomercial = new HTMLChoice();
      dynavEmpresa_abm_1_artsec = new HTMLChoice();
      chkavEmpresa_abm_1_empliqgan = UIFactory.getCheckbox(this);
      cmbavEmpresa_abm_1_emppromdesde = new HTMLChoice();
      cmbavEmpresa_abm_1_empdiahspext = new HTMLChoice();
      cmbavEmpresa_abm_1_emppervacdes = new HTMLChoice();
      cmbavEmpresa_abm_1_emppervachas = new HTMLChoice();
      chkavEmpresa_abm_1_empliqfer = UIFactory.getCheckbox(this);
      chkavEmpresa_abm_1_empliqferjor = UIFactory.getCheckbox(this);
      chkavEmpresa_abm_1_empvacexplim = UIFactory.getCheckbox(this);
      cmbavEmpresa_abm_1_emptipoexp = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"EMPRESA_ABM_1_PROVCOD") == 0 )
         {
            AV108PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV108PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV108PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV108PaiCod), "ZZZ9")));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvempresa_abm_1_provcodKD2( AV108PaiCod) ;
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
            AV76TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TrnMode", AV76TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV76TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
               AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
               AV85MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV85MenuOpcCod", AV85MenuOpcCod);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV85MenuOpcCod, ""))));
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
      paKD2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startKD2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LImgUploader2Render.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LImgUploader2Render.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(AV76TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV85MenuOpcCod))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV108PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV161Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDLOCCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV105oldLocCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPLOGONOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV98oldEmpLogoNom, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFIRMANOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97oldEmpFirmaNom, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPDIR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV103oldEmpDir, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDPROVCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV104oldProvCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV106oldEmpNom, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPCUIT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV107oldEmpCUIT), "ZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFRACVACANT", getSecureSignedToken( "", localUtil.format( AV114oldEmpFracVacAnt, "9.9999")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPVACDISMAX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV115oldEmpVacDisMax), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACDES", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV116oldEmpPerVacDes), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACHAS", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV117oldEmpPerVacHas), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV85MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV76TrnMode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Empresa_abm_1", AV19Empresa_abm_1);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Empresa_abm_1", AV19Empresa_abm_1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV113DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV113DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPRESA_ABM_1_LOCCOD_DATA", AV112Empresa_abm_1_LocCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPRESA_ABM_1_LOCCOD_DATA", AV112Empresa_abm_1_LocCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPRESA_ABM_1_EMPOSOCOD_DATA", AV87Empresa_abm_1_EmpOsoCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPRESA_ABM_1_EMPOSOCOD_DATA", AV87Empresa_abm_1_EmpOsoCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV76TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV76TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV5CheckRequiredFieldsResult);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV161Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV161Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDLOCCOD", GXutil.ltrim( localUtil.ntoc( AV105oldLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDLOCCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV105oldLocCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPLOGONOM", AV98oldEmpLogoNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPLOGONOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV98oldEmpLogoNom, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPFIRMANOM", AV97oldEmpFirmaNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFIRMANOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97oldEmpFirmaNom, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPDIR", AV103oldEmpDir);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPDIR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV103oldEmpDir, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDPROVCOD", GXutil.ltrim( localUtil.ntoc( AV104oldProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDPROVCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV104oldProvCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPNOM", AV106oldEmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV106oldEmpNom, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPCUIT", GXutil.ltrim( localUtil.ntoc( AV107oldEmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPCUIT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV107oldEmpCUIT), "ZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPFRACVACANT", GXutil.ltrim( localUtil.ntoc( AV114oldEmpFracVacAnt, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFRACVACANT", getSecureSignedToken( "", localUtil.format( AV114oldEmpFracVacAnt, "9.9999")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPVACDISMAX", GXutil.ltrim( localUtil.ntoc( AV115oldEmpVacDisMax, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPVACDISMAX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV115oldEmpVacDisMax), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPPERVACDES", GXutil.ltrim( localUtil.ntoc( AV116oldEmpPerVacDes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACDES", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV116oldEmpPerVacDes), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPPERVACHAS", GXutil.ltrim( localUtil.ntoc( AV117oldEmpPerVacHas, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACHAS", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV117oldEmpPerVacHas), "Z9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPARM_INIPERCCLIC", AV121parm_iniPerCCLic);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPARM_INIPERCCLIC", AV121parm_iniPerCCLic);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV85MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV85MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV65Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV65Messages);
      }
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vVINODECLICK", AV82vinoDeClick);
      web.GxWebStd.gx_hidden_field( httpContext, "PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PROVCOD", GXutil.ltrim( localUtil.ntoc( A47ProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LOCCOD", GXutil.ltrim( localUtil.ntoc( A48LocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LOCNOM", A286LocNom);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV108PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV108PaiCod), "ZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vEMPRESA_ABM_1", AV19Empresa_abm_1);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vEMPRESA_ABM_1", AV19Empresa_abm_1);
      }
      GXCCtlgxBlob = "vINPUTFILELOGO" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, AV119inputFileLogo);
      GXCCtlgxBlob = "vINPUTFILEFIRMA" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, AV120inputFileFirma);
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Width", GXutil.rtrim( Dvpanel_unnamedtable4_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable4_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable4_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Cls", GXutil.rtrim( Dvpanel_unnamedtable4_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Title", GXutil.rtrim( Dvpanel_unnamedtable4_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable4_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable4_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable4_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable4_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE4_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable4_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Cls", GXutil.rtrim( Combo_empresa_abm_1_loccod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Selectedvalue_set", GXutil.rtrim( Combo_empresa_abm_1_loccod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Enabled", GXutil.booltostr( Combo_empresa_abm_1_loccod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Emptyitem", GXutil.booltostr( Combo_empresa_abm_1_loccod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Cls", GXutil.rtrim( Combo_empresa_abm_1_emposocod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Selectedvalue_set", GXutil.rtrim( Combo_empresa_abm_1_emposocod_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Enabled", GXutil.booltostr( Combo_empresa_abm_1_emposocod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Width", GXutil.rtrim( Dvpanel_unnamedtable3_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable3_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable3_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Cls", GXutil.rtrim( Dvpanel_unnamedtable3_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Title", GXutil.rtrim( Dvpanel_unnamedtable3_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable3_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable3_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable3_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Buttonclass", GXutil.rtrim( A3limguploaderlogo_Buttonclass));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Button_caption", GXutil.rtrim( A3limguploaderlogo_Button_caption));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Buttonid", GXutil.rtrim( A3limguploaderlogo_Buttonid));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Class_img", GXutil.rtrim( A3limguploaderlogo_Class_img));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Id_img", GXutil.rtrim( A3limguploaderlogo_Id_img));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Src_default", GXutil.rtrim( A3limguploaderlogo_Src_default));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Observer", GXutil.rtrim( A3limguploaderlogo_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Mode", GXutil.rtrim( A3limguploaderlogo_Mode));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Photo_name_id", GXutil.rtrim( A3limguploaderlogo_Photo_name_id));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERLOGO_Inputfileid", GXutil.rtrim( A3limguploaderlogo_Inputfileid));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Buttonclass", GXutil.rtrim( A3limguploaderfirma_Buttonclass));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Button_caption", GXutil.rtrim( A3limguploaderfirma_Button_caption));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Buttonid", GXutil.rtrim( A3limguploaderfirma_Buttonid));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Class_img", GXutil.rtrim( A3limguploaderfirma_Class_img));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Id_img", GXutil.rtrim( A3limguploaderfirma_Id_img));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Src_default", GXutil.rtrim( A3limguploaderfirma_Src_default));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Observer", GXutil.rtrim( A3limguploaderfirma_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Mode", GXutil.rtrim( A3limguploaderfirma_Mode));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Photo_name_id", GXutil.rtrim( A3limguploaderfirma_Photo_name_id));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LIMGUPLOADERFIRMA_Inputfileid", GXutil.rtrim( A3limguploaderfirma_Inputfileid));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Selectedvalue_get", GXutil.rtrim( Combo_empresa_abm_1_emposocod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Selectedvalue_get", GXutil.rtrim( Combo_empresa_abm_1_loccod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Ddointernalname", GXutil.rtrim( Combo_empresa_abm_1_loccod_Ddointernalname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Selectedvalue_get", GXutil.rtrim( Combo_empresa_abm_1_loccod_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_LOCCOD_Ddointernalname", GXutil.rtrim( Combo_empresa_abm_1_loccod_Ddointernalname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Selectedvalue_get", GXutil.rtrim( Combo_empresa_abm_1_emposocod_Selectedvalue_get));
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
         weKD2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtKD2( ) ;
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
      return formatLink("web.empresa_cabecera", new String[] {GXutil.URLEncode(GXutil.rtrim(AV76TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV85MenuOpcCod))}, new String[] {"TrnMode","CliCod","EmpCod","MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Empresa_cabecera" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Empresa", "") ;
   }

   public void wbKD0( )
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableparent_Internalname, divWelcomemessage_welcometableparent_Visible, 0, "px", 0, "px", "WelcomeTableParent", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_welcometableprincipal_Internalname, 1, 0, "px", 0, "px", "WelcomeHeaderItem", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divWelcomemessage_tableclose_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11kd1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Empresa_cabecera.htm");
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
         AV100WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV100WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV159Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV100WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV100WelcomeMessage_Foto)==0) ? AV159Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV100WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgavWelcomemessage_foto_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV100WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Empresa_cabecera.htm");
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
         wb_table1_24_KD2( true) ;
      }
      else
      {
         wb_table1_24_KD2( false) ;
      }
      return  ;
   }

   public void wb_table1_24_KD2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_29_KD2( true) ;
      }
      else
      {
         wb_table2_29_KD2( false) ;
      }
      return  ;
   }

   public void wb_table2_29_KD2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV101WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,39);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empnom_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empnom_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empnom_Internalname, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empnom(), GXutil.rtrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empnom(), "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empnom_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empnom_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empcuit_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empcuit_Internalname, httpContext.getMessage( "CUIT", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empcuit_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcuit(), (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcuit()), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empcuit_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empcuit_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable4.setProperty("Width", Dvpanel_unnamedtable4_Width);
         ucDvpanel_unnamedtable4.setProperty("AutoWidth", Dvpanel_unnamedtable4_Autowidth);
         ucDvpanel_unnamedtable4.setProperty("AutoHeight", Dvpanel_unnamedtable4_Autoheight);
         ucDvpanel_unnamedtable4.setProperty("Cls", Dvpanel_unnamedtable4_Cls);
         ucDvpanel_unnamedtable4.setProperty("Title", Dvpanel_unnamedtable4_Title);
         ucDvpanel_unnamedtable4.setProperty("Collapsible", Dvpanel_unnamedtable4_Collapsible);
         ucDvpanel_unnamedtable4.setProperty("Collapsed", Dvpanel_unnamedtable4_Collapsed);
         ucDvpanel_unnamedtable4.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable4_Showcollapseicon);
         ucDvpanel_unnamedtable4.setProperty("IconPosition", Dvpanel_unnamedtable4_Iconposition);
         ucDvpanel_unnamedtable4.setProperty("AutoScroll", Dvpanel_unnamedtable4_Autoscroll);
         ucDvpanel_unnamedtable4.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable4_Internalname, "DVPANEL_UNNAMEDTABLE4Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE4Container"+"UnnamedTable4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmpresa_abm_1_empmodempl.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavEmpresa_abm_1_empmodempl.getInternalname(), httpContext.getMessage( "Empleados", ""), " AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmpresa_abm_1_empmodempl.getInternalname(), GXutil.booltostr( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodempl()), "", httpContext.getMessage( "Empleados", ""), 1, chkavEmpresa_abm_1_empmodempl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(71, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,71);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmpresa_abm_1_empmodauto.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavEmpresa_abm_1_empmodauto.getInternalname(), httpContext.getMessage( "Independientes", ""), " AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmpresa_abm_1_empmodauto.getInternalname(), GXutil.booltostr( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodauto()), "", httpContext.getMessage( "Independientes", ""), 1, chkavEmpresa_abm_1_empmodauto.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(75, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,75);\"");
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
         web.GxWebStd.gx_div_start( httpContext, divEmpresa_abm_1_empmodtra_cell_Internalname, 1, 0, "px", 0, "px", divEmpresa_abm_1_empmodtra_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavEmpresa_abm_1_empmodtra.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresa_abm_1_empmodtra.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresa_abm_1_empmodtra.getInternalname(), httpContext.getMessage( "Modo de trabajo predeterminado", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresa_abm_1_empmodtra, cmbavEmpresa_abm_1_empmodtra.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodtra()), 1, cmbavEmpresa_abm_1_empmodtra.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavEmpresa_abm_1_empmodtra.getVisible(), cmbavEmpresa_abm_1_empmodtra.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,80);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         cmbavEmpresa_abm_1_empmodtra.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodtra()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Values", cmbavEmpresa_abm_1_empmodtra.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_actcodigo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_actcodigo.getInternalname(), httpContext.getMessage( "Actividad AFIP predeterminada", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_actcodigo, dynavEmpresa_abm_1_actcodigo.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()), 1, dynavEmpresa_abm_1_actcodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavEmpresa_abm_1_actcodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_actcodigo.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_actcodigo.getInternalname(), "Values", dynavEmpresa_abm_1_actcodigo.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_empcondicod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_empcondicod.getInternalname(), httpContext.getMessage( "Condición AFIP predeterminada", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_empcondicod, dynavEmpresa_abm_1_empcondicod.getInternalname(), GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0)), 1, dynavEmpresa_abm_1_empcondicod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEmpresa_abm_1_empcondicod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_empcondicod.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empcondicod.getInternalname(), "Values", dynavEmpresa_abm_1_empcondicod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_empzoncod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_empzoncod.getInternalname(), httpContext.getMessage( "Zona AFIP", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_empzoncod, dynavEmpresa_abm_1_empzoncod.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()), 1, dynavEmpresa_abm_1_empzoncod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavEmpresa_abm_1_empzoncod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,95);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_empzoncod.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empzoncod.getInternalname(), "Values", dynavEmpresa_abm_1_empzoncod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_tipemplecod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_tipemplecod.getInternalname(), httpContext.getMessage( "Tipo de Empleador según decreto 814/01 art. 2", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_tipemplecod, dynavEmpresa_abm_1_tipemplecod.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()), 1, dynavEmpresa_abm_1_tipemplecod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavEmpresa_abm_1_tipemplecod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,100);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_tipemplecod.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_tipemplecod.getInternalname(), "Values", dynavEmpresa_abm_1_tipemplecod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_provcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_provcod.getInternalname(), httpContext.getMessage( "Provincia", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_provcod, dynavEmpresa_abm_1_provcod.getInternalname(), GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), 4, 0)), 1, dynavEmpresa_abm_1_provcod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEmpresa_abm_1_provcod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,105);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_provcod.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_provcod.getInternalname(), "Values", dynavEmpresa_abm_1_provcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedempresa_abm_1_loccod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_empresa_abm_1_loccod_Internalname, httpContext.getMessage( "Localidad", ""), "", "", lblTextblockcombo_empresa_abm_1_loccod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_empresa_abm_1_loccod.setProperty("Caption", Combo_empresa_abm_1_loccod_Caption);
         ucCombo_empresa_abm_1_loccod.setProperty("Cls", Combo_empresa_abm_1_loccod_Cls);
         ucCombo_empresa_abm_1_loccod.setProperty("EmptyItem", Combo_empresa_abm_1_loccod_Emptyitem);
         ucCombo_empresa_abm_1_loccod.setProperty("DropDownOptionsTitleSettingsIcons", AV113DDO_TitleSettingsIcons);
         ucCombo_empresa_abm_1_loccod.setProperty("DropDownOptionsData", AV112Empresa_abm_1_LocCod_Data);
         ucCombo_empresa_abm_1_loccod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_empresa_abm_1_loccod_Internalname, "COMBO_EMPRESA_ABM_1_LOCCODContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_empactcomercial.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_empactcomercial.getInternalname(), httpContext.getMessage( "Actividad comercial", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_empactcomercial, dynavEmpresa_abm_1_empactcomercial.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()), 1, dynavEmpresa_abm_1_empactcomercial.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavEmpresa_abm_1_empactcomercial.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_empactcomercial.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empactcomercial.getInternalname(), "Values", dynavEmpresa_abm_1_empactcomercial.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavEmpresa_abm_1_artsec.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavEmpresa_abm_1_artsec.getInternalname(), httpContext.getMessage( "ART", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEmpresa_abm_1_artsec, dynavEmpresa_abm_1_artsec.getInternalname(), GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0)), 1, dynavEmpresa_abm_1_artsec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEmpresa_abm_1_artsec.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,123);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         dynavEmpresa_abm_1_artsec.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_artsec.getInternalname(), "Values", dynavEmpresa_abm_1_artsec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empdir_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empdir_Internalname, httpContext.getMessage( "Direccion", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empdir_Internalname, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdir(), GXutil.rtrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdir(), "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,128);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empdir_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empdir_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_emptel_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_emptel_Internalname, httpContext.getMessage( "Telefono", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_emptel_Internalname, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptel(), GXutil.rtrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptel(), "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,133);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_emptel_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_emptel_Enabled, 1, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empantiguedad_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empantiguedad_Internalname, httpContext.getMessage( "Antiguedad para empleados fuera de convenio", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empantiguedad_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empantiguedad(), (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empantiguedad(), "ZZZZZZZZ9.9999")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,138);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empantiguedad_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empantiguedad_Enabled, 1, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_emppresentismo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_emppresentismo_Internalname, httpContext.getMessage( "Presentismo para empleados fuera de convenio", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_emppresentismo_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppresentismo(), (byte)(14), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppresentismo(), "ZZZZZZZZ9.9999")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,143);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_emppresentismo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_emppresentismo_Enabled, 1, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmpresa_abm_1_empliqgan.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavEmpresa_abm_1_empliqgan.getInternalname(), httpContext.getMessage( "Liquida ganancias", ""), " AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 148,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmpresa_abm_1_empliqgan.getInternalname(), GXutil.booltostr( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empliqgan()), "", httpContext.getMessage( "Liquida ganancias", ""), 1, chkavEmpresa_abm_1_empliqgan.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(148, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,148);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresa_abm_1_emppromdesde.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresa_abm_1_emppromdesde.getInternalname(), httpContext.getMessage( "Calcular promedio de remuneraciones anteriores variables desde", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresa_abm_1_emppromdesde, cmbavEmpresa_abm_1_emppromdesde.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppromdesde()), 1, cmbavEmpresa_abm_1_emppromdesde.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavEmpresa_abm_1_emppromdesde.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,153);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         cmbavEmpresa_abm_1_emppromdesde.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppromdesde()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppromdesde.getInternalname(), "Values", cmbavEmpresa_abm_1_emppromdesde.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empguaredadmin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empguaredadmin_Internalname, httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empguaredadmin_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empguaredadmin(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empguaredadmin()), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,158);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empguaredadmin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empguaredadmin_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empguaredadmax_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empguaredadmax_Internalname, httpContext.getMessage( "Edad máxima del hijo/hija hasta la que puede gozar el beneficio de guardería", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 163,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empguaredadmax_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empguaredadmax(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empguaredadmax()), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,163);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empguaredadmax_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empguaredadmax_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedempresa_abm_1_emposocod_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_empresa_abm_1_emposocod_Internalname, httpContext.getMessage( "Obra social predeterminada", ""), "", "", lblTextblockcombo_empresa_abm_1_emposocod_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_empresa_abm_1_emposocod.setProperty("Caption", Combo_empresa_abm_1_emposocod_Caption);
         ucCombo_empresa_abm_1_emposocod.setProperty("Cls", Combo_empresa_abm_1_emposocod_Cls);
         ucCombo_empresa_abm_1_emposocod.setProperty("DropDownOptionsData", AV87Empresa_abm_1_EmpOsoCod_Data);
         ucCombo_empresa_abm_1_emposocod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_empresa_abm_1_emposocod_Internalname, "COMBO_EMPRESA_ABM_1_EMPOSOCODContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable2.setProperty("Width", Dvpanel_unnamedtable2_Width);
         ucDvpanel_unnamedtable2.setProperty("AutoWidth", Dvpanel_unnamedtable2_Autowidth);
         ucDvpanel_unnamedtable2.setProperty("AutoHeight", Dvpanel_unnamedtable2_Autoheight);
         ucDvpanel_unnamedtable2.setProperty("Cls", Dvpanel_unnamedtable2_Cls);
         ucDvpanel_unnamedtable2.setProperty("Title", Dvpanel_unnamedtable2_Title);
         ucDvpanel_unnamedtable2.setProperty("Collapsible", Dvpanel_unnamedtable2_Collapsible);
         ucDvpanel_unnamedtable2.setProperty("Collapsed", Dvpanel_unnamedtable2_Collapsed);
         ucDvpanel_unnamedtable2.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable2_Showcollapseicon);
         ucDvpanel_unnamedtable2.setProperty("IconPosition", Dvpanel_unnamedtable2_Iconposition);
         ucDvpanel_unnamedtable2.setProperty("AutoScroll", Dvpanel_unnamedtable2_Autoscroll);
         ucDvpanel_unnamedtable2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable2_Internalname, "DVPANEL_UNNAMEDTABLE2Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE2Container"+"UnnamedTable2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empmeshspext_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empmeshspext_Internalname, httpContext.getMessage( "Cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 181,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empmeshspext_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmeshspext(), (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmeshspext(), "ZZ9.9")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'1');"+";gx.evt.onblur(this,181);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empmeshspext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empmeshspext_Enabled, 1, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavEmpresa_abm_1_empdiahspext.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresa_abm_1_empdiahspext.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), httpContext.getMessage( "Días habiles del mes para obtener cantidad de horas del mes para cálculo de 1 hora de trabajo para empleados de clase mensual", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 186,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresa_abm_1_empdiahspext, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdiahspext()), 1, cmbavEmpresa_abm_1_empdiahspext.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavEmpresa_abm_1_empdiahspext.getVisible(), cmbavEmpresa_abm_1_empdiahspext.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,186);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         cmbavEmpresa_abm_1_empdiahspext.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdiahspext()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), "Values", cmbavEmpresa_abm_1_empdiahspext.ToJavascriptSource(), true);
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable3.setProperty("Width", Dvpanel_unnamedtable3_Width);
         ucDvpanel_unnamedtable3.setProperty("AutoWidth", Dvpanel_unnamedtable3_Autowidth);
         ucDvpanel_unnamedtable3.setProperty("AutoHeight", Dvpanel_unnamedtable3_Autoheight);
         ucDvpanel_unnamedtable3.setProperty("Cls", Dvpanel_unnamedtable3_Cls);
         ucDvpanel_unnamedtable3.setProperty("Title", Dvpanel_unnamedtable3_Title);
         ucDvpanel_unnamedtable3.setProperty("Collapsible", Dvpanel_unnamedtable3_Collapsible);
         ucDvpanel_unnamedtable3.setProperty("Collapsed", Dvpanel_unnamedtable3_Collapsed);
         ucDvpanel_unnamedtable3.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable3_Showcollapseicon);
         ucDvpanel_unnamedtable3.setProperty("IconPosition", Dvpanel_unnamedtable3_Iconposition);
         ucDvpanel_unnamedtable3.setProperty("AutoScroll", Dvpanel_unnamedtable3_Autoscroll);
         ucDvpanel_unnamedtable3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable3_Internalname, "DVPANEL_UNNAMEDTABLE3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE3Container"+"UnnamedTable3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresa_abm_1_emppervacdes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresa_abm_1_emppervacdes.getInternalname(), httpContext.getMessage( "Periodo de vacaciones desde", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresa_abm_1_emppervacdes, cmbavEmpresa_abm_1_emppervacdes.getInternalname(), GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes(), 2, 0)), 1, cmbavEmpresa_abm_1_emppervacdes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavEmpresa_abm_1_emppervacdes.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,196);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         cmbavEmpresa_abm_1_emppervacdes.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppervacdes.getInternalname(), "Values", cmbavEmpresa_abm_1_emppervacdes.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEmpresa_abm_1_emppervachas.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavEmpresa_abm_1_emppervachas.getInternalname(), httpContext.getMessage( "Periodo de vacaciones hasta", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 201,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresa_abm_1_emppervachas, cmbavEmpresa_abm_1_emppervachas.getInternalname(), GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas(), 2, 0)), 1, cmbavEmpresa_abm_1_emppervachas.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavEmpresa_abm_1_emppervachas.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,201);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         cmbavEmpresa_abm_1_emppervachas.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppervachas.getInternalname(), "Values", cmbavEmpresa_abm_1_emppervachas.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empfracvacant_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empfracvacant_Internalname, httpContext.getMessage( "Proporción de días de vacaciones disponibles pendientes de goce del año anterior", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 206,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empfracvacant_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfracvacant(), (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfracvacant(), "9.9999")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,206);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empfracvacant_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empfracvacant_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmpresa_abm_1_empvacdismax_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavEmpresa_abm_1_empvacdismax_Internalname, httpContext.getMessage( "Máximo de días disponibles para acumular vacaciones pendientes", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 211,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empvacdismax_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacdismax(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacdismax()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,211);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empvacdismax_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEmpresa_abm_1_empvacdismax_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmpresa_abm_1_empliqfer.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavEmpresa_abm_1_empliqfer.getInternalname(), httpContext.getMessage( "Exponer feriados en mensuales", ""), " AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 216,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmpresa_abm_1_empliqfer.getInternalname(), GXutil.booltostr( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empliqfer()), "", httpContext.getMessage( "Exponer feriados en mensuales", ""), 1, chkavEmpresa_abm_1_empliqfer.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(216, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,216);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmpresa_abm_1_empliqferjor.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavEmpresa_abm_1_empliqferjor.getInternalname(), httpContext.getMessage( "Liquidar feriados en jornales", ""), " AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 221,'',false,'',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmpresa_abm_1_empliqferjor.getInternalname(), GXutil.booltostr( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empliqferjor()), "", httpContext.getMessage( "Liquidar feriados en jornales", ""), 1, chkavEmpresa_abm_1_empliqferjor.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(221, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,221);\"");
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucA3limguploaderlogo.render(context, "a3limguploader2", A3limguploaderlogo_Internalname, "A3LIMGUPLOADERLOGOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucA3limguploaderfirma.render(context, "a3limguploader2", A3limguploaderfirma_Internalname, "A3LIMGUPLOADERFIRMAContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 232,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 234,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavInputfilelogo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavInputfilelogo_Internalname, " ", " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 239,'',false,'',0)\"" ;
         edtavInputfilelogo_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavInputfilelogo_Internalname, "Filetype", edtavInputfilelogo_Filetype, true);
         if ( ! (GXutil.strcmp("", AV119inputFileLogo)==0) )
         {
            gxblobfileaux.setSource( AV119inputFileLogo );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavInputfilelogo_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavInputfilelogo_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV119inputFileLogo = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavInputfilelogo_Internalname, "URL", httpContext.getResourceRelative(AV119inputFileLogo), true);
               edtavInputfilelogo_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavInputfilelogo_Internalname, "Filetype", edtavInputfilelogo_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtavInputfilelogo_Internalname, "URL", httpContext.getResourceRelative(AV119inputFileLogo), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtavInputfilelogo_Internalname, GXutil.rtrim( AV119inputFileLogo), httpContext.getResourceRelative(AV119inputFileLogo), ((GXutil.strcmp("", edtavInputfilelogo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavInputfilelogo_Filetype)==0) ? AV119inputFileLogo : edtavInputfilelogo_Filetype)) : edtavInputfilelogo_Contenttype), false, "", edtavInputfilelogo_Parameters, 0, edtavInputfilelogo_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavInputfilelogo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,239);\"", "", "", "HLP_Empresa_cabecera.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavInputfilefirma_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         ClassString = "Attribute" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 244,'',false,'',0)\"" ;
         edtavInputfilefirma_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavInputfilefirma_Internalname, "Filetype", edtavInputfilefirma_Filetype, true);
         if ( ! (GXutil.strcmp("", AV120inputFileFirma)==0) )
         {
            gxblobfileaux.setSource( AV120inputFileFirma );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavInputfilefirma_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavInputfilefirma_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV120inputFileFirma = gxblobfileaux.getURI() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavInputfilefirma_Internalname, "URL", httpContext.getResourceRelative(AV120inputFileFirma), true);
               edtavInputfilefirma_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavInputfilefirma_Internalname, "Filetype", edtavInputfilefirma_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtavInputfilefirma_Internalname, "URL", httpContext.getResourceRelative(AV120inputFileFirma), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtavInputfilefirma_Internalname, GXutil.rtrim( AV120inputFileFirma), httpContext.getResourceRelative(AV120inputFileFirma), ((GXutil.strcmp("", edtavInputfilefirma_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavInputfilefirma_Filetype)==0) ? AV120inputFileFirma : edtavInputfilefirma_Filetype)) : edtavInputfilefirma_Contenttype), false, "", edtavInputfilefirma_Parameters, 0, edtavInputfilefirma_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavInputfilefirma_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,244);\"", "", "", "HLP_Empresa_cabecera.htm");
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
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 248,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavFotodir_Internalname, AV34fotoDir, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,248);\"", (short)(0), edtavFotodir_Visible, 1, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Empresa_cabecera.htm");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 249,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavFotonamelogo_Internalname, AV38fotoNameLogo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,249);\"", (short)(0), edtavFotonamelogo_Visible, 1, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Empresa_cabecera.htm");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 250,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavFotonamefirma_Internalname, AV37fotoNameFirma, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,250);\"", (short)(0), edtavFotonamefirma_Visible, 1, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Empresa_cabecera.htm");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 251,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmpresa_abm_1_empvacexplim.getInternalname(), GXutil.booltostr( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacexplim()), "", "", chkavEmpresa_abm_1_empvacexplim.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(251, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,251);\"");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 252,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empvacexptie_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacexptie(), (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacexptie()), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,252);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empvacexptie_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresa_abm_1_empvacexptie_Visible, 1, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 253,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_clicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Clicod(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Clicod()), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,253);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_clicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresa_abm_1_clicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 254,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_empcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,254);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_empcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresa_abm_1_empcod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 255,'',false,'',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpresa_abm_1_paicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Paicod(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Paicod()), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,255);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpresa_abm_1_paicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpresa_abm_1_paicod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresa_cabecera.htm");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEmpresa_abm_1_emptipoexp, cmbavEmpresa_abm_1_emptipoexp.getInternalname(), GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptipoexp(), 1, 0)), 1, cmbavEmpresa_abm_1_emptipoexp.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavEmpresa_abm_1_emptipoexp.getVisible(), 1, 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,256);\"", "", true, (byte)(0), "HLP_Empresa_cabecera.htm");
         cmbavEmpresa_abm_1_emptipoexp.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptipoexp(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emptipoexp.getInternalname(), "Values", cmbavEmpresa_abm_1_emptipoexp.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void startKD2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Empresa", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupKD0( ) ;
   }

   public void wsKD2( )
   {
      startKD2( ) ;
      evtKD2( ) ;
   }

   public void evtKD2( )
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_EMPRESA_ABM_1_LOCCOD.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12KD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "COMBO_EMPRESA_ABM_1_EMPOSOCOD.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13KD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e14KD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e15KD2 ();
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
                                 e16KD2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17KD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "EMPRESA_ABM_1_PROVCOD.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18KD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e19KD2 ();
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

   public void weKD2( )
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

   public void paKD2( )
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

   public void gxdlvempresa_abm_1_artsecKD1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_artsec_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_artsec_htmlKD1( )
   {
      short gxdynajaxvalue;
      gxdlvempresa_abm_1_artsec_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_artsec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavEmpresa_abm_1_artsec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_artsec.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Artsec( (short)(GXutil.lval( dynavEmpresa_abm_1_artsec.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0))))) );
      }
   }

   protected void gxdlvempresa_abm_1_artsec_dataKD1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00KD2_A1151ARTSec[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00KD2_A1152ARTNom[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvempresa_abm_1_empactcomercialKD1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_empactcomercial_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_empactcomercial_htmlKD1( )
   {
      String gxdynajaxvalue;
      gxdlvempresa_abm_1_empactcomercial_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_empactcomercial.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavEmpresa_abm_1_empactcomercial.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_empactcomercial.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empactcomercial( dynavEmpresa_abm_1_empactcomercial.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()) );
      }
   }

   protected void gxdlvempresa_abm_1_empactcomercial_dataKD1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD3 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00KD3_A903ActComCodigo[0]));
         gxdynajaxctrldescr.add(H00KD3_A904ActComDescripcion[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvempresa_abm_1_tipemplecodKD1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_tipemplecod_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_tipemplecod_htmlKD1( )
   {
      String gxdynajaxvalue;
      gxdlvempresa_abm_1_tipemplecod_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_tipemplecod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavEmpresa_abm_1_tipemplecod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_tipemplecod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Tipemplecod( dynavEmpresa_abm_1_tipemplecod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()) );
      }
   }

   protected void gxdlvempresa_abm_1_tipemplecod_dataKD1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00KD4_A45TipEmpleCod[0]));
         gxdynajaxctrldescr.add(H00KD4_A339TipEmpleDescri[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void gxdlvempresa_abm_1_empzoncodKD1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_empzoncod_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_empzoncod_htmlKD1( )
   {
      String gxdynajaxvalue;
      gxdlvempresa_abm_1_empzoncod_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_empzoncod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavEmpresa_abm_1_empzoncod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_empzoncod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod( dynavEmpresa_abm_1_empzoncod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()) );
      }
   }

   protected void gxdlvempresa_abm_1_empzoncod_dataKD1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00KD5_A20ZonCod[0]));
         gxdynajaxctrldescr.add(H00KD5_A342ZonDescrip[0]);
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void gxdlvempresa_abm_1_empcondicodKD1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_empcondicod_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_empcondicod_htmlKD1( )
   {
      short gxdynajaxvalue;
      gxdlvempresa_abm_1_empcondicod_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_empcondicod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavEmpresa_abm_1_empcondicod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_empcondicod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcondicod( (short)(GXutil.lval( dynavEmpresa_abm_1_empcondicod.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0))))) );
      }
   }

   protected void gxdlvempresa_abm_1_empcondicod_dataKD1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00KD6_A17CondiCodigo[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00KD6_A144CondiDescri[0]);
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void gxdlvempresa_abm_1_actcodigoKD1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_actcodigo_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_actcodigo_htmlKD1( )
   {
      String gxdynajaxvalue;
      gxdlvempresa_abm_1_actcodigo_dataKD1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_actcodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavEmpresa_abm_1_actcodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_actcodigo.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Actcodigo( dynavEmpresa_abm_1_actcodigo.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()) );
      }
   }

   protected void gxdlvempresa_abm_1_actcodigo_dataKD1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD7 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00KD7_A43ActCodigo[0]));
         gxdynajaxctrldescr.add(H00KD7_A108ActDescrip[0]);
         pr_default.readNext(5);
      }
      pr_default.close(5);
   }

   public void gxdlvempresa_abm_1_provcodKD2( short AV108PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvempresa_abm_1_provcod_dataKD2( AV108PaiCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvempresa_abm_1_provcod_htmlKD2( short AV108PaiCod )
   {
      short gxdynajaxvalue;
      gxdlvempresa_abm_1_provcod_dataKD2( AV108PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEmpresa_abm_1_provcod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavEmpresa_abm_1_provcod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavEmpresa_abm_1_provcod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Provcod( (short)(GXutil.lval( dynavEmpresa_abm_1_provcod.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), 4, 0))))) );
      }
   }

   protected void gxdlvempresa_abm_1_provcod_dataKD2( short AV108PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H00KD8 */
      pr_default.execute(6, new Object[] {Short.valueOf(AV108PaiCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00KD8_A47ProvCod[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00KD8_A322ProvNom[0]);
         pr_default.readNext(6);
      }
      pr_default.close(6);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_artsec.setName( "EMPRESA_ABM_1_ARTSEC" );
         dynavEmpresa_abm_1_artsec.setWebtags( "" );
         dynavEmpresa_abm_1_artsec.removeAllItems();
         /* Using cursor H00KD9 */
         pr_default.execute(7);
         while ( (pr_default.getStatus(7) != 101) )
         {
            dynavEmpresa_abm_1_artsec.addItem(GXutil.trim( GXutil.str( H00KD9_A1151ARTSec[0], 4, 0)), H00KD9_A1152ARTNom[0], (short)(0));
            pr_default.readNext(7);
         }
         pr_default.close(7);
         if ( dynavEmpresa_abm_1_artsec.getItemCount() > 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Artsec( (short)(GXutil.lval( dynavEmpresa_abm_1_artsec.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0))))) );
         }
         dynavEmpresa_abm_1_empactcomercial.setName( "EMPRESA_ABM_1_EMPACTCOMERCIAL" );
         dynavEmpresa_abm_1_empactcomercial.setWebtags( "" );
         dynavEmpresa_abm_1_empactcomercial.removeAllItems();
         /* Using cursor H00KD10 */
         pr_default.execute(8);
         while ( (pr_default.getStatus(8) != 101) )
         {
            dynavEmpresa_abm_1_empactcomercial.addItem(H00KD10_A903ActComCodigo[0], H00KD10_A904ActComDescripcion[0], (short)(0));
            pr_default.readNext(8);
         }
         pr_default.close(8);
         if ( dynavEmpresa_abm_1_empactcomercial.getItemCount() > 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empactcomercial( dynavEmpresa_abm_1_empactcomercial.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()) );
         }
         dynavEmpresa_abm_1_tipemplecod.setName( "EMPRESA_ABM_1_TIPEMPLECOD" );
         dynavEmpresa_abm_1_tipemplecod.setWebtags( "" );
         dynavEmpresa_abm_1_tipemplecod.removeAllItems();
         /* Using cursor H00KD11 */
         pr_default.execute(9);
         while ( (pr_default.getStatus(9) != 101) )
         {
            dynavEmpresa_abm_1_tipemplecod.addItem(H00KD11_A45TipEmpleCod[0], H00KD11_A339TipEmpleDescri[0], (short)(0));
            pr_default.readNext(9);
         }
         pr_default.close(9);
         if ( dynavEmpresa_abm_1_tipemplecod.getItemCount() > 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Tipemplecod( dynavEmpresa_abm_1_tipemplecod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()) );
         }
         dynavEmpresa_abm_1_empzoncod.setName( "EMPRESA_ABM_1_EMPZONCOD" );
         dynavEmpresa_abm_1_empzoncod.setWebtags( "" );
         dynavEmpresa_abm_1_empzoncod.removeAllItems();
         /* Using cursor H00KD12 */
         pr_default.execute(10);
         while ( (pr_default.getStatus(10) != 101) )
         {
            dynavEmpresa_abm_1_empzoncod.addItem(H00KD12_A20ZonCod[0], H00KD12_A342ZonDescrip[0], (short)(0));
            pr_default.readNext(10);
         }
         pr_default.close(10);
         if ( dynavEmpresa_abm_1_empzoncod.getItemCount() > 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod( dynavEmpresa_abm_1_empzoncod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()) );
         }
         dynavEmpresa_abm_1_empcondicod.setName( "EMPRESA_ABM_1_EMPCONDICOD" );
         dynavEmpresa_abm_1_empcondicod.setWebtags( "" );
         dynavEmpresa_abm_1_empcondicod.removeAllItems();
         /* Using cursor H00KD13 */
         pr_default.execute(11);
         while ( (pr_default.getStatus(11) != 101) )
         {
            dynavEmpresa_abm_1_empcondicod.addItem(GXutil.trim( GXutil.str( H00KD13_A17CondiCodigo[0], 4, 0)), H00KD13_A144CondiDescri[0], (short)(0));
            pr_default.readNext(11);
         }
         pr_default.close(11);
         if ( dynavEmpresa_abm_1_empcondicod.getItemCount() > 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcondicod( (short)(GXutil.lval( dynavEmpresa_abm_1_empcondicod.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0))))) );
         }
         dynavEmpresa_abm_1_actcodigo.setName( "EMPRESA_ABM_1_ACTCODIGO" );
         dynavEmpresa_abm_1_actcodigo.setWebtags( "" );
         dynavEmpresa_abm_1_actcodigo.removeAllItems();
         /* Using cursor H00KD14 */
         pr_default.execute(12);
         while ( (pr_default.getStatus(12) != 101) )
         {
            dynavEmpresa_abm_1_actcodigo.addItem(H00KD14_A43ActCodigo[0], H00KD14_A108ActDescrip[0], (short)(0));
            pr_default.readNext(12);
         }
         pr_default.close(12);
         if ( dynavEmpresa_abm_1_actcodigo.getItemCount() > 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Actcodigo( dynavEmpresa_abm_1_actcodigo.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()) );
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      AV101WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV101WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV101WelcomeMessage_NoMostrarMas", AV101WelcomeMessage_NoMostrarMas);
      if ( cmbavEmpresa_abm_1_empmodtra.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodtra( cmbavEmpresa_abm_1_empmodtra.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodtra()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresa_abm_1_empmodtra.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodtra()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Values", cmbavEmpresa_abm_1_empmodtra.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_actcodigo.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Actcodigo( dynavEmpresa_abm_1_actcodigo.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_actcodigo.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_actcodigo.getInternalname(), "Values", dynavEmpresa_abm_1_actcodigo.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_empcondicod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcondicod( (short)(GXutil.lval( dynavEmpresa_abm_1_empcondicod.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_empcondicod.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empcondicod.getInternalname(), "Values", dynavEmpresa_abm_1_empcondicod.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_empzoncod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod( dynavEmpresa_abm_1_empzoncod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_empzoncod.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empzoncod.getInternalname(), "Values", dynavEmpresa_abm_1_empzoncod.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_tipemplecod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Tipemplecod( dynavEmpresa_abm_1_tipemplecod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_tipemplecod.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_tipemplecod.getInternalname(), "Values", dynavEmpresa_abm_1_tipemplecod.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_provcod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Provcod( (short)(GXutil.lval( dynavEmpresa_abm_1_provcod.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), 4, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_provcod.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_provcod.getInternalname(), "Values", dynavEmpresa_abm_1_provcod.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_empactcomercial.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empactcomercial( dynavEmpresa_abm_1_empactcomercial.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_empactcomercial.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empactcomercial.getInternalname(), "Values", dynavEmpresa_abm_1_empactcomercial.ToJavascriptSource(), true);
      }
      if ( dynavEmpresa_abm_1_artsec.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Artsec( (short)(GXutil.lval( dynavEmpresa_abm_1_artsec.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEmpresa_abm_1_artsec.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_artsec.getInternalname(), "Values", dynavEmpresa_abm_1_artsec.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresa_abm_1_emppromdesde.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppromdesde( cmbavEmpresa_abm_1_emppromdesde.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppromdesde()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresa_abm_1_emppromdesde.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppromdesde()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppromdesde.getInternalname(), "Values", cmbavEmpresa_abm_1_emppromdesde.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresa_abm_1_empdiahspext.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empdiahspext( cmbavEmpresa_abm_1_empdiahspext.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdiahspext()) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresa_abm_1_empdiahspext.setValue( GXutil.rtrim( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdiahspext()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), "Values", cmbavEmpresa_abm_1_empdiahspext.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresa_abm_1_emppervacdes.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervacdes( (byte)(GXutil.lval( cmbavEmpresa_abm_1_emppervacdes.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes(), 2, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresa_abm_1_emppervacdes.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppervacdes.getInternalname(), "Values", cmbavEmpresa_abm_1_emppervacdes.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresa_abm_1_emppervachas.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervachas( (byte)(GXutil.lval( cmbavEmpresa_abm_1_emppervachas.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas(), 2, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresa_abm_1_emppervachas.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas(), 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppervachas.getInternalname(), "Values", cmbavEmpresa_abm_1_emppervachas.ToJavascriptSource(), true);
      }
      if ( cmbavEmpresa_abm_1_emptipoexp.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emptipoexp( (byte)(GXutil.lval( cmbavEmpresa_abm_1_emptipoexp.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptipoexp(), 1, 0))))) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEmpresa_abm_1_emptipoexp.setValue( GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptipoexp(), 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emptipoexp.getInternalname(), "Values", cmbavEmpresa_abm_1_emptipoexp.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfKD2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV161Pgmname = "Empresa_cabecera" ;
      Gx_err = (short)(0) ;
   }

   public void rfKD2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e15KD2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e19KD2 ();
         wbKD0( ) ;
      }
   }

   public void send_integrity_lvl_hashesKD2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV108PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV108PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV161Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV161Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDLOCCOD", GXutil.ltrim( localUtil.ntoc( AV105oldLocCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDLOCCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV105oldLocCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPLOGONOM", AV98oldEmpLogoNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPLOGONOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV98oldEmpLogoNom, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPFIRMANOM", AV97oldEmpFirmaNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFIRMANOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97oldEmpFirmaNom, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPDIR", AV103oldEmpDir);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPDIR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV103oldEmpDir, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDPROVCOD", GXutil.ltrim( localUtil.ntoc( AV104oldProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDPROVCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV104oldProvCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPNOM", AV106oldEmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV106oldEmpNom, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPCUIT", GXutil.ltrim( localUtil.ntoc( AV107oldEmpCUIT, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPCUIT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV107oldEmpCUIT), "ZZZZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPFRACVACANT", GXutil.ltrim( localUtil.ntoc( AV114oldEmpFracVacAnt, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFRACVACANT", getSecureSignedToken( "", localUtil.format( AV114oldEmpFracVacAnt, "9.9999")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPVACDISMAX", GXutil.ltrim( localUtil.ntoc( AV115oldEmpVacDisMax, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPVACDISMAX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV115oldEmpVacDisMax), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPPERVACDES", GXutil.ltrim( localUtil.ntoc( AV116oldEmpPerVacDes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACDES", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV116oldEmpPerVacDes), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vOLDEMPPERVACHAS", GXutil.ltrim( localUtil.ntoc( AV117oldEmpPerVacHas, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACHAS", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV117oldEmpPerVacHas), "Z9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV85MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV85MenuOpcCod, ""))));
   }

   public void before_start_formulas( )
   {
      AV161Pgmname = "Empresa_cabecera" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupKD0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14KD2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvempresa_abm_1_provcod_htmlKD2( AV108PaiCod) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMPRESA_ABM_1"), AV19Empresa_abm_1);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Empresa_abm_1"), AV19Empresa_abm_1);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV113DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMPRESA_ABM_1_LOCCOD_DATA"), AV112Empresa_abm_1_LocCod_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vEMPRESA_ABM_1_EMPOSOCOD_DATA"), AV87Empresa_abm_1_EmpOsoCod_Data);
         /* Read saved values. */
         Dvpanel_unnamedtable4_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Width") ;
         Dvpanel_unnamedtable4_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Autowidth")) ;
         Dvpanel_unnamedtable4_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Autoheight")) ;
         Dvpanel_unnamedtable4_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Cls") ;
         Dvpanel_unnamedtable4_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Title") ;
         Dvpanel_unnamedtable4_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Collapsible")) ;
         Dvpanel_unnamedtable4_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Collapsed")) ;
         Dvpanel_unnamedtable4_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Showcollapseicon")) ;
         Dvpanel_unnamedtable4_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Iconposition") ;
         Dvpanel_unnamedtable4_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE4_Autoscroll")) ;
         Combo_empresa_abm_1_loccod_Cls = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_LOCCOD_Cls") ;
         Combo_empresa_abm_1_loccod_Selectedvalue_set = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_LOCCOD_Selectedvalue_set") ;
         Combo_empresa_abm_1_loccod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_LOCCOD_Enabled")) ;
         Combo_empresa_abm_1_loccod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_LOCCOD_Emptyitem")) ;
         Combo_empresa_abm_1_emposocod_Cls = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Cls") ;
         Combo_empresa_abm_1_emposocod_Selectedvalue_set = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Selectedvalue_set") ;
         Combo_empresa_abm_1_emposocod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Enabled")) ;
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         Dvpanel_unnamedtable2_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Width") ;
         Dvpanel_unnamedtable2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autowidth")) ;
         Dvpanel_unnamedtable2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoheight")) ;
         Dvpanel_unnamedtable2_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Cls") ;
         Dvpanel_unnamedtable2_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Title") ;
         Dvpanel_unnamedtable2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsible")) ;
         Dvpanel_unnamedtable2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsed")) ;
         Dvpanel_unnamedtable2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showcollapseicon")) ;
         Dvpanel_unnamedtable2_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Iconposition") ;
         Dvpanel_unnamedtable2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoscroll")) ;
         Dvpanel_unnamedtable3_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Width") ;
         Dvpanel_unnamedtable3_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autowidth")) ;
         Dvpanel_unnamedtable3_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autoheight")) ;
         Dvpanel_unnamedtable3_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Cls") ;
         Dvpanel_unnamedtable3_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Title") ;
         Dvpanel_unnamedtable3_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Collapsible")) ;
         Dvpanel_unnamedtable3_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Collapsed")) ;
         Dvpanel_unnamedtable3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Showcollapseicon")) ;
         Dvpanel_unnamedtable3_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Iconposition") ;
         Dvpanel_unnamedtable3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autoscroll")) ;
         A3limguploaderlogo_Buttonclass = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Buttonclass") ;
         A3limguploaderlogo_Button_caption = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Button_caption") ;
         A3limguploaderlogo_Buttonid = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Buttonid") ;
         A3limguploaderlogo_Class_img = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Class_img") ;
         A3limguploaderlogo_Id_img = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Id_img") ;
         A3limguploaderlogo_Src_default = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Src_default") ;
         A3limguploaderlogo_Observer = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Observer") ;
         A3limguploaderlogo_Mode = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Mode") ;
         A3limguploaderlogo_Photo_name_id = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Photo_name_id") ;
         A3limguploaderlogo_Inputfileid = httpContext.cgiGet( "A3LIMGUPLOADERLOGO_Inputfileid") ;
         A3limguploaderfirma_Buttonclass = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Buttonclass") ;
         A3limguploaderfirma_Button_caption = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Button_caption") ;
         A3limguploaderfirma_Buttonid = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Buttonid") ;
         A3limguploaderfirma_Class_img = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Class_img") ;
         A3limguploaderfirma_Id_img = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Id_img") ;
         A3limguploaderfirma_Src_default = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Src_default") ;
         A3limguploaderfirma_Observer = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Observer") ;
         A3limguploaderfirma_Mode = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Mode") ;
         A3limguploaderfirma_Photo_name_id = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Photo_name_id") ;
         A3limguploaderfirma_Inputfileid = httpContext.cgiGet( "A3LIMGUPLOADERFIRMA_Inputfileid") ;
         Combo_empresa_abm_1_loccod_Selectedvalue_get = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_LOCCOD_Selectedvalue_get") ;
         Combo_empresa_abm_1_loccod_Ddointernalname = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_LOCCOD_Ddointernalname") ;
         Combo_empresa_abm_1_emposocod_Selectedvalue_get = httpContext.cgiGet( "COMBO_EMPRESA_ABM_1_EMPOSOCOD_Selectedvalue_get") ;
         /* Read variables values. */
         AV100WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV101WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV101WelcomeMessage_NoMostrarMas", AV101WelcomeMessage_NoMostrarMas);
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empnom( GXutil.upper( httpContext.cgiGet( edtavEmpresa_abm_1_empnom_Internalname)) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empcuit_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empcuit_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPCUIT");
            GX_FocusControl = edtavEmpresa_abm_1_empcuit_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcuit( 0 );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcuit( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empcuit_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) );
         }
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodempl( GXutil.strtobool( httpContext.cgiGet( chkavEmpresa_abm_1_empmodempl.getInternalname())) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodauto( GXutil.strtobool( httpContext.cgiGet( chkavEmpresa_abm_1_empmodauto.getInternalname())) );
         cmbavEmpresa_abm_1_empmodtra.setValue( httpContext.cgiGet( cmbavEmpresa_abm_1_empmodtra.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodtra( httpContext.cgiGet( cmbavEmpresa_abm_1_empmodtra.getInternalname()) );
         dynavEmpresa_abm_1_actcodigo.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_actcodigo.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Actcodigo( httpContext.cgiGet( dynavEmpresa_abm_1_actcodigo.getInternalname()) );
         dynavEmpresa_abm_1_empcondicod.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_empcondicod.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcondicod( (short)(GXutil.lval( httpContext.cgiGet( dynavEmpresa_abm_1_empcondicod.getInternalname()))) );
         dynavEmpresa_abm_1_empzoncod.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_empzoncod.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod( httpContext.cgiGet( dynavEmpresa_abm_1_empzoncod.getInternalname()) );
         dynavEmpresa_abm_1_tipemplecod.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_tipemplecod.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Tipemplecod( httpContext.cgiGet( dynavEmpresa_abm_1_tipemplecod.getInternalname()) );
         dynavEmpresa_abm_1_provcod.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_provcod.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Provcod( (short)(GXutil.lval( httpContext.cgiGet( dynavEmpresa_abm_1_provcod.getInternalname()))) );
         dynavEmpresa_abm_1_empactcomercial.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_empactcomercial.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empactcomercial( httpContext.cgiGet( dynavEmpresa_abm_1_empactcomercial.getInternalname()) );
         dynavEmpresa_abm_1_artsec.setValue( httpContext.cgiGet( dynavEmpresa_abm_1_artsec.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Artsec( (short)(GXutil.lval( httpContext.cgiGet( dynavEmpresa_abm_1_artsec.getInternalname()))) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empdir( GXutil.upper( httpContext.cgiGet( edtavEmpresa_abm_1_empdir_Internalname)) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emptel( GXutil.upper( httpContext.cgiGet( edtavEmpresa_abm_1_emptel_Internalname)) );
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empantiguedad_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empantiguedad_Internalname)), DecimalUtil.stringToDec("999999999.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPANTIGUEDAD");
            GX_FocusControl = edtavEmpresa_abm_1_empantiguedad_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empantiguedad( DecimalUtil.ZERO );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empantiguedad( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empantiguedad_Internalname)) );
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_emppresentismo_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_emppresentismo_Internalname)), DecimalUtil.stringToDec("999999999.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPPRESENTISMO");
            GX_FocusControl = edtavEmpresa_abm_1_emppresentismo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppresentismo( DecimalUtil.ZERO );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppresentismo( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_emppresentismo_Internalname)) );
         }
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empliqgan( GXutil.strtobool( httpContext.cgiGet( chkavEmpresa_abm_1_empliqgan.getInternalname())) );
         cmbavEmpresa_abm_1_emppromdesde.setValue( httpContext.cgiGet( cmbavEmpresa_abm_1_emppromdesde.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppromdesde( httpContext.cgiGet( cmbavEmpresa_abm_1_emppromdesde.getInternalname()) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empguaredadmin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empguaredadmin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPGUAREDADMIN");
            GX_FocusControl = edtavEmpresa_abm_1_empguaredadmin_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empguaredadmin( (byte)(0) );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empguaredadmin( (byte)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empguaredadmin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empguaredadmax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empguaredadmax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPGUAREDADMAX");
            GX_FocusControl = edtavEmpresa_abm_1_empguaredadmax_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empguaredadmax( (byte)(0) );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empguaredadmax( (byte)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empguaredadmax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empmeshspext_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empmeshspext_Internalname)), DecimalUtil.stringToDec("999.9")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPMESHSPEXT");
            GX_FocusControl = edtavEmpresa_abm_1_empmeshspext_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmeshspext( DecimalUtil.ZERO );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmeshspext( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empmeshspext_Internalname)) );
         }
         cmbavEmpresa_abm_1_empdiahspext.setValue( httpContext.cgiGet( cmbavEmpresa_abm_1_empdiahspext.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empdiahspext( httpContext.cgiGet( cmbavEmpresa_abm_1_empdiahspext.getInternalname()) );
         cmbavEmpresa_abm_1_emppervacdes.setValue( httpContext.cgiGet( cmbavEmpresa_abm_1_emppervacdes.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervacdes( (byte)(GXutil.lval( httpContext.cgiGet( cmbavEmpresa_abm_1_emppervacdes.getInternalname()))) );
         cmbavEmpresa_abm_1_emppervachas.setValue( httpContext.cgiGet( cmbavEmpresa_abm_1_emppervachas.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervachas( (byte)(GXutil.lval( httpContext.cgiGet( cmbavEmpresa_abm_1_emppervachas.getInternalname()))) );
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empfracvacant_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empfracvacant_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPFRACVACANT");
            GX_FocusControl = edtavEmpresa_abm_1_empfracvacant_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empfracvacant( DecimalUtil.ZERO );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empfracvacant( localUtil.ctond( httpContext.cgiGet( edtavEmpresa_abm_1_empfracvacant_Internalname)) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empvacdismax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empvacdismax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPVACDISMAX");
            GX_FocusControl = edtavEmpresa_abm_1_empvacdismax_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empvacdismax( 0 );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empvacdismax( (int)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empvacdismax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empliqfer( GXutil.strtobool( httpContext.cgiGet( chkavEmpresa_abm_1_empliqfer.getInternalname())) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empliqferjor( GXutil.strtobool( httpContext.cgiGet( chkavEmpresa_abm_1_empliqferjor.getInternalname())) );
         AV119inputFileLogo = httpContext.cgiGet( edtavInputfilelogo_Internalname) ;
         AV120inputFileFirma = httpContext.cgiGet( edtavInputfilefirma_Internalname) ;
         AV34fotoDir = httpContext.cgiGet( edtavFotodir_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34fotoDir", AV34fotoDir);
         AV38fotoNameLogo = httpContext.cgiGet( edtavFotonamelogo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38fotoNameLogo", AV38fotoNameLogo);
         AV37fotoNameFirma = httpContext.cgiGet( edtavFotonamefirma_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37fotoNameFirma", AV37fotoNameFirma);
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empvacexplim( GXutil.strtobool( httpContext.cgiGet( chkavEmpresa_abm_1_empvacexplim.getInternalname())) );
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empvacexptie_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empvacexptie_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPVACEXPTIE");
            GX_FocusControl = edtavEmpresa_abm_1_empvacexptie_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empvacexptie( (byte)(0) );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empvacexptie( (byte)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empvacexptie_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_CLICOD");
            GX_FocusControl = edtavEmpresa_abm_1_clicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Clicod( 0 );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Clicod( (int)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_clicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_EMPCOD");
            GX_FocusControl = edtavEmpresa_abm_1_empcod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcod( (short)(0) );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcod( (short)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_empcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_paicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_paicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESA_ABM_1_PAICOD");
            GX_FocusControl = edtavEmpresa_abm_1_paicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Paicod( (short)(0) );
         }
         else
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Paicod( (short)(localUtil.ctol( httpContext.cgiGet( edtavEmpresa_abm_1_paicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
         }
         cmbavEmpresa_abm_1_emptipoexp.setValue( httpContext.cgiGet( cmbavEmpresa_abm_1_emptipoexp.getInternalname()) );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emptipoexp( (byte)(GXutil.lval( httpContext.cgiGet( cmbavEmpresa_abm_1_emptipoexp.getInternalname()))) );
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( (GXutil.strcmp("", AV119inputFileLogo)==0) )
         {
            GXCCtlgxBlob = "vINPUTFILELOGO" + "_gxBlob" ;
            AV119inputFileLogo = httpContext.cgiGet( GXCCtlgxBlob) ;
         }
         if ( (GXutil.strcmp("", AV120inputFileFirma)==0) )
         {
            GXCCtlgxBlob = "vINPUTFILEFIRMA" + "_gxBlob" ;
            AV120inputFileFirma = httpContext.cgiGet( GXCCtlgxBlob) ;
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
      e14KD2 ();
      if (returnInSub) return;
   }

   public void e14KD2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV85MenuOpcCod, "", "") ;
      GXv_int1[0] = AV108PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int1) ;
      empresa_cabecera_impl.this.AV108PaiCod = GXv_int1[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV108PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV108PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV108PaiCod), "ZZZ9")));
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV63LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV76TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV76TrnMode, "INS") == 0 ) ) || ( ( GXutil.strcmp(AV76TrnMode, "UPD") == 0 ) ) || ( ( GXutil.strcmp(AV76TrnMode, "DLT") == 0 ) ) )
      {
         if ( GXutil.strcmp(AV76TrnMode, "INS") != 0 )
         {
            AV19Empresa_abm_1.Load(AV7CliCod, AV18EmpCod);
            AV63LoadSuccess = AV19Empresa_abm_1.Success() ;
            if ( ! AV63LoadSuccess )
            {
               AV65Messages = AV19Empresa_abm_1.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV76TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV76TrnMode, "DLT") == 0 ) )
            {
               edtavInputfilelogo_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavInputfilelogo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInputfilelogo_Enabled), 5, 0), true);
               edtavInputfilefirma_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavInputfilefirma_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInputfilefirma_Enabled), 5, 0), true);
               cmbavEmpresa_abm_1_emppervacdes.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppervacdes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresa_abm_1_emppervacdes.getEnabled(), 5, 0), true);
               cmbavEmpresa_abm_1_emppervachas.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppervachas.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresa_abm_1_emppervachas.getEnabled(), 5, 0), true);
               edtavEmpresa_abm_1_empfracvacant_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empfracvacant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empfracvacant_Enabled), 5, 0), true);
               edtavEmpresa_abm_1_empvacdismax_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empvacdismax_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empvacdismax_Enabled), 5, 0), true);
               chkavEmpresa_abm_1_empliqfer.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empliqfer.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEmpresa_abm_1_empliqfer.getEnabled(), 5, 0), true);
               chkavEmpresa_abm_1_empliqferjor.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empliqferjor.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEmpresa_abm_1_empliqferjor.getEnabled(), 5, 0), true);
               edtavEmpresa_abm_1_empmeshspext_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empmeshspext_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empmeshspext_Enabled), 5, 0), true);
               cmbavEmpresa_abm_1_empdiahspext.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresa_abm_1_empdiahspext.getEnabled(), 5, 0), true);
               edtavEmpresa_abm_1_empnom_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empnom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empnom_Enabled), 5, 0), true);
               edtavEmpresa_abm_1_empcuit_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empcuit_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empcuit_Enabled), 5, 0), true);
               cmbavEmpresa_abm_1_empmodtra.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresa_abm_1_empmodtra.getEnabled(), 5, 0), true);
               dynavEmpresa_abm_1_actcodigo.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_actcodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_actcodigo.getEnabled(), 5, 0), true);
               dynavEmpresa_abm_1_empcondicod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empcondicod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_empcondicod.getEnabled(), 5, 0), true);
               dynavEmpresa_abm_1_empzoncod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empzoncod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_empzoncod.getEnabled(), 5, 0), true);
               dynavEmpresa_abm_1_tipemplecod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_tipemplecod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_tipemplecod.getEnabled(), 5, 0), true);
               dynavEmpresa_abm_1_provcod.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_provcod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_provcod.getEnabled(), 5, 0), true);
               Combo_empresa_abm_1_loccod_Enabled = false ;
               ucCombo_empresa_abm_1_loccod.sendProperty(context, "", false, Combo_empresa_abm_1_loccod_Internalname, "Enabled", GXutil.booltostr( Combo_empresa_abm_1_loccod_Enabled));
               dynavEmpresa_abm_1_empactcomercial.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empactcomercial.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_empactcomercial.getEnabled(), 5, 0), true);
               dynavEmpresa_abm_1_artsec.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_artsec.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_artsec.getEnabled(), 5, 0), true);
               edtavEmpresa_abm_1_empdir_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empdir_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empdir_Enabled), 5, 0), true);
               edtavEmpresa_abm_1_emptel_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_emptel_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_emptel_Enabled), 5, 0), true);
               edtavEmpresa_abm_1_empantiguedad_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empantiguedad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empantiguedad_Enabled), 5, 0), true);
               edtavEmpresa_abm_1_emppresentismo_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_emppresentismo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_emppresentismo_Enabled), 5, 0), true);
               chkavEmpresa_abm_1_empliqgan.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empliqgan.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEmpresa_abm_1_empliqgan.getEnabled(), 5, 0), true);
               cmbavEmpresa_abm_1_emppromdesde.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emppromdesde.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEmpresa_abm_1_emppromdesde.getEnabled(), 5, 0), true);
               edtavEmpresa_abm_1_empguaredadmin_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empguaredadmin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empguaredadmin_Enabled), 5, 0), true);
               edtavEmpresa_abm_1_empguaredadmax_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empguaredadmax_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empguaredadmax_Enabled), 5, 0), true);
               Combo_empresa_abm_1_emposocod_Enabled = false ;
               ucCombo_empresa_abm_1_emposocod.sendProperty(context, "", false, Combo_empresa_abm_1_emposocod_Internalname, "Enabled", GXutil.booltostr( Combo_empresa_abm_1_emposocod_Enabled));
               chkavEmpresa_abm_1_empmodempl.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empmodempl.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEmpresa_abm_1_empmodempl.getEnabled(), 5, 0), true);
               chkavEmpresa_abm_1_empmodauto.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empmodauto.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEmpresa_abm_1_empmodauto.getEnabled(), 5, 0), true);
               chkavWelcomemessage_nomostrarmas.setEnabled( 0 );
               httpContext.ajax_rsp_assign_prop("", false, chkavWelcomemessage_nomostrarmas.getInternalname(), "Enabled", GXutil.ltrimstr( chkavWelcomemessage_nomostrarmas.getEnabled(), 5, 0), true);
               imgavWelcomemessage_foto_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavWelcomemessage_foto_Enabled), 5, 0), true);
            }
         }
      }
      else
      {
         AV63LoadSuccess = false ;
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      if ( AV63LoadSuccess )
      {
         if ( GXutil.strcmp(AV76TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV113DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV113DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      /* Execute user subroutine: 'LOADCOMBOEMPRESA_ABM_1_LOCCOD' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOEMPRESA_ABM_1_EMPOSOCOD' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S142 ();
      if (returnInSub) return;
      edtavFotodir_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFotodir_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFotodir_Visible), 5, 0), true);
      edtavFotonamelogo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFotonamelogo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFotonamelogo_Visible), 5, 0), true);
      edtavFotonamefirma_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFotonamefirma_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFotonamefirma_Visible), 5, 0), true);
      chkavEmpresa_abm_1_empvacexplim.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empvacexplim.getInternalname(), "Visible", GXutil.ltrimstr( chkavEmpresa_abm_1_empvacexplim.getVisible(), 5, 0), true);
      edtavEmpresa_abm_1_empvacexptie_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empvacexptie_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empvacexptie_Visible), 5, 0), true);
      edtavEmpresa_abm_1_clicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_clicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_clicod_Visible), 5, 0), true);
      edtavEmpresa_abm_1_empcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_empcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_empcod_Visible), 5, 0), true);
      edtavEmpresa_abm_1_paicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpresa_abm_1_paicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpresa_abm_1_paicod_Visible), 5, 0), true);
      cmbavEmpresa_abm_1_emptipoexp.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_emptipoexp.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_emptipoexp.getVisible(), 5, 0), true);
      GXv_char4[0] = AV93MenuBienveImgURL ;
      GXv_char5[0] = AV95MenuBienveTitulo ;
      GXv_char6[0] = AV94MenuBienveTexto ;
      GXv_boolean7[0] = AV96MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV85MenuOpcCod, GXv_char4, GXv_char5, GXv_char6, GXv_boolean7) ;
      empresa_cabecera_impl.this.AV93MenuBienveImgURL = GXv_char4[0] ;
      empresa_cabecera_impl.this.AV95MenuBienveTitulo = GXv_char5[0] ;
      empresa_cabecera_impl.this.AV94MenuBienveTexto = GXv_char6[0] ;
      empresa_cabecera_impl.this.AV96MenuBienveVisible = GXv_boolean7[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV96MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV96MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV95MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV94MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV100WelcomeMessage_Foto = AV93MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV100WelcomeMessage_Foto)==0) ? AV159Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV100WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV100WelcomeMessage_Foto), true);
         AV159Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV93MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV100WelcomeMessage_Foto)==0) ? AV159Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV100WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV100WelcomeMessage_Foto), true);
      }
      GXt_char8 = "" ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char6) ;
      empresa_cabecera_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char8 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char9, GXv_char5) ;
      empresa_cabecera_impl.this.GXt_char8 = GXv_char5[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char8 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      dynavEmpresa_abm_1_empzoncod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynavEmpresa_abm_1_empzoncod.getInternalname(), "Enabled", GXutil.ltrimstr( dynavEmpresa_abm_1_empzoncod.getEnabled(), 5, 0), true);
      A3limguploaderlogo_Observer = httpContext.getMessage( "gx.onload", "") ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "observer", A3limguploaderlogo_Observer);
      A3limguploaderfirma_Observer = httpContext.getMessage( "gx.onload", "") ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "observer", A3limguploaderfirma_Observer);
      A3limguploaderlogo_Inputfileid = edtavInputfilelogo_Internalname ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "inputfileId", A3limguploaderlogo_Inputfileid);
      A3limguploaderfirma_Inputfileid = edtavInputfilefirma_Internalname ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "inputfileId", A3limguploaderfirma_Inputfileid);
      if ( GXutil.strcmp(AV76TrnMode, "INS") == 0 )
      {
         GXt_int10 = (short)(0) ;
         GXv_int1[0] = GXt_int10 ;
         new web.getnextemp(remoteHandle, context).execute( AV7CliCod, GXv_int1) ;
         empresa_cabecera_impl.this.GXt_int10 = GXv_int1[0] ;
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcod( GXt_int10 );
      }
      GXv_char6[0] = AV15destinationDir ;
      new web.getnombrecarpetaennode(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, 0, GXv_char6) ;
      empresa_cabecera_impl.this.AV15destinationDir = GXv_char6[0] ;
      if ( GXutil.strcmp(AV76TrnMode, "INS") != 0 )
      {
         AV98oldEmpLogoNom = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emplogonom() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV98oldEmpLogoNom", AV98oldEmpLogoNom);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPLOGONOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV98oldEmpLogoNom, ""))));
         AV97oldEmpFirmaNom = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfirmanom() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV97oldEmpFirmaNom", AV97oldEmpFirmaNom);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFIRMANOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV97oldEmpFirmaNom, ""))));
         AV34fotoDir = AV15destinationDir ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34fotoDir", AV34fotoDir);
         AV38fotoNameLogo = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emplogonom() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38fotoNameLogo", AV38fotoNameLogo);
         AV37fotoNameFirma = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfirmanom() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37fotoNameFirma", AV37fotoNameFirma);
         if ( ! (GXutil.strcmp("", AV38fotoNameLogo)==0) )
         {
            GXt_char9 = "" ;
            GXv_char6[0] = GXt_char9 ;
            new web.devuelveurlfoto(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, 0, httpContext.getMessage( "logo", ""), AV38fotoNameLogo, GXv_char6) ;
            empresa_cabecera_impl.this.GXt_char9 = GXv_char6[0] ;
            A3limguploaderlogo_Src_default = GXt_char9 ;
            ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "src_default", A3limguploaderlogo_Src_default);
         }
         if ( ! (GXutil.strcmp("", AV37fotoNameFirma)==0) )
         {
            GXt_char9 = "" ;
            GXv_char6[0] = GXt_char9 ;
            new web.devuelveurlfoto(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, 0, httpContext.getMessage( "firma", ""), AV37fotoNameFirma, GXv_char6) ;
            empresa_cabecera_impl.this.GXt_char9 = GXv_char6[0] ;
            A3limguploaderfirma_Src_default = GXt_char9 ;
            ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "src_default", A3limguploaderfirma_Src_default);
         }
      }
      else
      {
         GXv_int1[0] = (short)(0) ;
         GXv_int11[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptipoexp() ;
         GXv_char6[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppromdesde() ;
         GXv_int12[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes() ;
         GXv_int13[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas() ;
         GXv_decimal14[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfracvacant() ;
         GXv_char5[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial() ;
         GXv_boolean7[0] = false ;
         GXv_int15[0] = (byte)(0) ;
         GXv_int16[0] = 0 ;
         GXv_char4[0] = "" ;
         GXv_int17[0] = (short)(0) ;
         GXv_int18[0] = (short)(0) ;
         GXv_int19[0] = (short)(0) ;
         GXv_char20[0] = "" ;
         GXv_char21[0] = "" ;
         new web.datosultimaemp(remoteHandle, context).execute( AV7CliCod, GXv_int1, GXv_int11, GXv_char6, GXv_int12, GXv_int13, GXv_decimal14, GXv_char5, GXv_boolean7, GXv_int15, GXv_int16, GXv_char4, GXv_int17, GXv_int18, GXv_int19, GXv_char20, GXv_char21) ;
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emptipoexp( GXv_int11[0] );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppromdesde( GXv_char6[0] );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervacdes( GXv_int12[0] );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervachas( GXv_int13[0] );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empfracvacant( GXv_decimal14[0] );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empactcomercial( GXv_char5[0] );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Clicod( AV7CliCod );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Paicod( AV108PaiCod );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empliqferjor( true );
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcondicod( (short)(1) );
      }
      A3limguploaderlogo_Buttonclass = httpContext.getMessage( " Button btn btn-default", "") ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "buttonClass", A3limguploaderlogo_Buttonclass);
      A3limguploaderlogo_Class_img = httpContext.getMessage( "ReadonlyW100px", "") ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "class_img", A3limguploaderlogo_Class_img);
      A3limguploaderfirma_Buttonclass = httpContext.getMessage( " Button btn btn-default", "") ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "buttonClass", A3limguploaderfirma_Buttonclass);
      A3limguploaderfirma_Class_img = httpContext.getMessage( "ReadonlyW100px", "") ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "class_img", A3limguploaderfirma_Class_img);
      A3limguploaderlogo_Button_caption = httpContext.getMessage( "Seleccionar imagen para logo", "") ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "button_caption", A3limguploaderlogo_Button_caption);
      A3limguploaderlogo_Id_img = httpContext.getMessage( "logo_id", "") ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "id_img", A3limguploaderlogo_Id_img);
      A3limguploaderlogo_Buttonid = httpContext.getMessage( "upload_button_logo_id", "") ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "buttonId", A3limguploaderlogo_Buttonid);
      A3limguploaderfirma_Button_caption = httpContext.getMessage( "Seleccionar imagen para firma", "") ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "button_caption", A3limguploaderfirma_Button_caption);
      A3limguploaderfirma_Id_img = httpContext.getMessage( "firma_id", "") ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "id_img", A3limguploaderfirma_Id_img);
      A3limguploaderfirma_Buttonid = httpContext.getMessage( "upload_button_firma_id", "") ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "buttonId", A3limguploaderfirma_Buttonid);
      A3limguploaderlogo_Photo_name_id = edtavFotonamelogo_Internalname ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "photo_name_id", A3limguploaderlogo_Photo_name_id);
      A3limguploaderlogo_Mode = AV76TrnMode ;
      ucA3limguploaderlogo.sendProperty(context, "", false, A3limguploaderlogo_Internalname, "mode", A3limguploaderlogo_Mode);
      A3limguploaderfirma_Photo_name_id = edtavFotonamefirma_Internalname ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "photo_name_id", A3limguploaderfirma_Photo_name_id);
      A3limguploaderfirma_Mode = AV76TrnMode ;
      ucA3limguploaderfirma.sendProperty(context, "", false, A3limguploaderfirma_Internalname, "mode", A3limguploaderfirma_Mode);
      /* Execute user subroutine: 'VISIBILIDAD HS DEL MES' */
      S152 ();
      if (returnInSub) return;
      AV103oldEmpDir = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdir() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV103oldEmpDir", AV103oldEmpDir);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPDIR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV103oldEmpDir, "@!"))));
      AV104oldProvCod = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV104oldProvCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV104oldProvCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDPROVCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV104oldProvCod), "ZZZ9")));
      AV105oldLocCod = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV105oldLocCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV105oldLocCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDLOCCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV105oldLocCod), "ZZZ9")));
      AV106oldEmpNom = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empnom() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV106oldEmpNom", AV106oldEmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPNOM", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV106oldEmpNom, "@!"))));
      AV107oldEmpCUIT = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcuit() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV107oldEmpCUIT", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV107oldEmpCUIT), 11, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPCUIT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV107oldEmpCUIT), "ZZZZZZZZZZ9")));
      AV117oldEmpPerVacHas = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV117oldEmpPerVacHas", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV117oldEmpPerVacHas), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACHAS", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV117oldEmpPerVacHas), "Z9")));
      AV116oldEmpPerVacDes = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV116oldEmpPerVacDes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV116oldEmpPerVacDes), 2, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPPERVACDES", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV116oldEmpPerVacDes), "Z9")));
      AV115oldEmpVacDisMax = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacdismax() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115oldEmpVacDisMax", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV115oldEmpVacDisMax), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPVACDISMAX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV115oldEmpVacDisMax), "ZZZZZ9")));
      AV114oldEmpFracVacAnt = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfracvacant() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV114oldEmpFracVacAnt", GXutil.ltrimstr( AV114oldEmpFracVacAnt, 6, 4));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLDEMPFRACVACANT", getSecureSignedToken( "", localUtil.format( AV114oldEmpFracVacAnt, "9.9999")));
   }

   public void e15KD2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S162 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e13KD2( )
   {
      /* Combo_empresa_abm_1_emposocod_Onoptionclicked Routine */
      returnInSub = false ;
      AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emposocod( Combo_empresa_abm_1_emposocod_Selectedvalue_get );
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Empresa_abm_1", AV19Empresa_abm_1);
   }

   public void e12KD2( )
   {
      /* Combo_empresa_abm_1_loccod_Onoptionclicked Routine */
      returnInSub = false ;
      AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Loccod( (short)(GXutil.lval( Combo_empresa_abm_1_loccod_Selectedvalue_get)) );
      /* Execute user subroutine: 'ZONA DE LOCALIDAD' */
      S172 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Empresa_abm_1", AV19Empresa_abm_1);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e16KD2 ();
      if (returnInSub) return;
   }

   public void e16KD2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV92error = "" ;
      if ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfracvacant().doubleValue() > 1 )
      {
         AV92error = httpContext.getMessage( "No puede asignar un valor mayor a 1 en \"Proporción de días de vacaciones disponibles pendientes de goce del año anterior\"", "") ;
      }
      if ( ! AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodauto() && ! AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodempl() )
      {
         AV92error = httpContext.getMessage( "Debe seleccionar relación laboral de colaboradores", "") ;
      }
      if ( (GXutil.strcmp("", AV92error)==0) )
      {
         if ( GXutil.strcmp(AV76TrnMode, httpContext.getMessage( "DLT", "")) != 0 )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emplogonom( AV38fotoNameLogo );
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empfirmanom( AV37fotoNameFirma );
         }
         if ( GXutil.strcmp(AV76TrnMode, httpContext.getMessage( "INS", "")) == 0 )
         {
            GXv_int19[0] = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Paicod() ;
            new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int19) ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Paicod( GXv_int19[0] );
            GXt_int10 = (short)(0) ;
            GXv_int19[0] = GXt_int10 ;
            new web.getnextemp(remoteHandle, context).execute( AV7CliCod, GXv_int19) ;
            empresa_cabecera_impl.this.GXt_int10 = GXv_int19[0] ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcod( GXt_int10 );
         }
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Actcomcodigo( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial() );
         if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emposocod())==0) )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emposocod_SetNull();
         }
         if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod())==0) )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod_SetNull();
         }
         if ( ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodauto() ) && ! AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodempl() )
         {
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodtra( "I" );
         }
         else
         {
            if ( ! AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodauto() && ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodempl() ) )
            {
               AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodtra( "E" );
            }
         }
         if ( GXutil.strcmp(AV76TrnMode, "DSP") != 0 )
         {
            if ( GXutil.strcmp(AV76TrnMode, "DLT") != 0 )
            {
               /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
               S182 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV76TrnMode, "DLT") == 0 ) || AV5CheckRequiredFieldsResult )
            {
               if ( GXutil.strcmp(AV76TrnMode, "DLT") == 0 )
               {
                  AV19Empresa_abm_1.Delete();
               }
               else
               {
                  AV19Empresa_abm_1.Save();
               }
               if ( AV19Empresa_abm_1.Success() )
               {
                  /* Execute user subroutine: 'AFTER_TRN' */
                  S192 ();
                  if (returnInSub) return;
               }
               else
               {
                  AV65Messages = AV19Empresa_abm_1.GetMessages() ;
                  /* Execute user subroutine: 'SHOW MESSAGES' */
                  S112 ();
                  if (returnInSub) return;
               }
            }
         }
      }
      else
      {
         new web.alert(remoteHandle, context).execute( "error", AV92error) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Empresa_abm_1", AV19Empresa_abm_1);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65Messages", AV65Messages);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV121parm_iniPerCCLic", AV121parm_iniPerCCLic);
   }

   public void S162( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV76TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S182( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV5CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empnom())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), "error", edtavEmpresa_abm_1_empnom_Internalname, "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcuit()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "CUIT", ""), "", "", "", "", "", "", "", ""), "error", edtavEmpresa_abm_1_empcuit_Internalname, "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad AFIP predeterminada", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_actcodigo.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Condición AFIP predeterminada", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_empcondicod.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Zona AFIP", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_empzoncod.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo de Empleador según decreto 814/01 art. 2", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_tipemplecod.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_provcod.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "error", Combo_empresa_abm_1_loccod_Ddointernalname, "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad comercial", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_empactcomercial.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "ART", ""), "", "", "", "", "", "", "", ""), "error", dynavEmpresa_abm_1_artsec.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdir())==0) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Direccion", ""), "", "", "", "", "", "", "", ""), "error", edtavEmpresa_abm_1_empdir_Internalname, "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Periodo de vacaciones desde", ""), "", "", "", "", "", "", "", ""), "error", cmbavEmpresa_abm_1_emppervacdes.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas()) )
      {
         httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Periodo de vacaciones hasta", ""), "", "", "", "", "", "", "", ""), "error", cmbavEmpresa_abm_1_emppervachas.getInternalname(), "true", ""));
         AV5CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5CheckRequiredFieldsResult", AV5CheckRequiredFieldsResult);
      }
      if ( ! AV5CheckRequiredFieldsResult )
      {
         new web.alert(remoteHandle, context).execute( "error", new web.msggralrequired(remoteHandle, context).executeUdp( AV7CliCod)) ;
      }
   }

   public void S142( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodempl() ) && ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodauto() ) ) )
      {
         cmbavEmpresa_abm_1_empmodtra.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_empmodtra.getVisible(), 5, 0), true);
         divEmpresa_abm_1_empmodtra_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpresa_abm_1_empmodtra_cell_Internalname, "Class", divEmpresa_abm_1_empmodtra_cell_Class, true);
      }
      else
      {
         cmbavEmpresa_abm_1_empmodtra.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_empmodtra.getVisible(), 5, 0), true);
         divEmpresa_abm_1_empmodtra_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpresa_abm_1_empmodtra_cell_Internalname, "Class", divEmpresa_abm_1_empmodtra_cell_Class, true);
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOEMPRESA_ABM_1_EMPOSOCOD' Routine */
      returnInSub = false ;
      /* Using cursor H00KD15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(13) != 101) )
      {
         A3CliCod = H00KD15_A3CliCod[0] ;
         A555OsoSiglaYDesc = H00KD15_A555OsoSiglaYDesc[0] ;
         A5OsoCod = H00KD15_A5OsoCod[0] ;
         AV80Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV80Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A555OsoSiglaYDesc );
         AV80Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A5OsoCod );
         AV87Empresa_abm_1_EmpOsoCod_Data.add(AV80Combo_DataItem, 0);
         pr_default.readNext(13);
      }
      pr_default.close(13);
      Combo_empresa_abm_1_emposocod_Selectedvalue_set = AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emposocod() ;
      ucCombo_empresa_abm_1_emposocod.sendProperty(context, "", false, Combo_empresa_abm_1_emposocod_Internalname, "SelectedValue_set", Combo_empresa_abm_1_emposocod_Selectedvalue_set);
   }

   public void S122( )
   {
      /* 'LOADCOMBOEMPRESA_ABM_1_LOCCOD' Routine */
      returnInSub = false ;
      if ( ! AV82vinoDeClick )
      {
         if ( ( GXutil.strcmp(AV76TrnMode, "INS") == 0 ) && (0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod()) )
         {
            GXv_int19[0] = AV110empresa_ProvCod ;
            GXv_int18[0] = AV109empresa_LocCod ;
            GXv_char21[0] = "" ;
            new web.getultempresalocalidad(remoteHandle, context).execute( AV7CliCod, GXv_int19, GXv_int18, GXv_char21) ;
            empresa_cabecera_impl.this.AV110empresa_ProvCod = GXv_int19[0] ;
            empresa_cabecera_impl.this.AV109empresa_LocCod = GXv_int18[0] ;
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Provcod( AV110empresa_ProvCod );
            AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Loccod( AV109empresa_LocCod );
            /* Execute user subroutine: 'ZONA DE LOCALIDAD' */
            S172 ();
            if (returnInSub) return;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV108PaiCod, 4, 0))+httpContext.getMessage( " &Empresa_abm_1.ProvCod ", "")+GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), 4, 0))) ;
      AV112Empresa_abm_1_LocCod_Data.clear();
      AV162GXLvl440 = (byte)(0) ;
      /* Using cursor H00KD16 */
      pr_default.execute(14, new Object[] {Short.valueOf(AV108PaiCod), Short.valueOf(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod())});
      while ( (pr_default.getStatus(14) != 101) )
      {
         A47ProvCod = H00KD16_A47ProvCod[0] ;
         A46PaiCod = H00KD16_A46PaiCod[0] ;
         A48LocCod = H00KD16_A48LocCod[0] ;
         A286LocNom = H00KD16_A286LocNom[0] ;
         AV162GXLvl440 = (byte)(1) ;
         AV80Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV80Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A48LocCod, 4, 0)) );
         AV80Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( A286LocNom) );
         AV112Empresa_abm_1_LocCod_Data.add(AV80Combo_DataItem, 0);
         pr_default.readNext(14);
      }
      pr_default.close(14);
      if ( AV162GXLvl440 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "none", "")) ;
      }
      AV112Empresa_abm_1_LocCod_Data.sort("Title");
      Combo_empresa_abm_1_loccod_Selectedvalue_set = ((0==AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod()) ? "" : GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod(), 4, 0))) ;
      ucCombo_empresa_abm_1_loccod.sendProperty(context, "", false, Combo_empresa_abm_1_loccod_Internalname, "SelectedValue_set", Combo_empresa_abm_1_loccod_Selectedvalue_set);
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV163GXV35 = 1 ;
      while ( AV163GXV35 <= AV65Messages.size() )
      {
         AV64Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV65Messages.elementAt(-1+AV163GXV35));
         httpContext.GX_msglist.addItem(AV64Message.getgxTv_SdtMessages_Message_Description());
         AV163GXV35 = (int)(AV163GXV35+1) ;
      }
   }

   public void S192( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      if ( false )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "empresa_cabecera");
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "empresa_cabecera");
         new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "!after 1 trnmode ", "")+AV76TrnMode) ;
         if ( GXutil.strcmp(AV76TrnMode, "INS") == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "llama", "")) ;
            new web.copiarbasecalcdepaiaemp(remoteHandle, context).execute( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Paicod(), AV7CliCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod(), 0) ;
            new web.copiarconfhorasextdepaiaemp(remoteHandle, context).execute( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Paicod(), AV7CliCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod(), 0) ;
            new web.newempreligiondefault(remoteHandle, context).execute( AV7CliCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod()) ;
            new web.inicializartemplaterecibo(remoteHandle, context).execute( AV7CliCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod()) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "oldloc ", "")+GXutil.trim( GXutil.str( AV105oldLocCod, 4, 0))+httpContext.getMessage( " loc actual ", "")+GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod(), 4, 0))) ;
         if ( ( GXutil.strcmp(AV76TrnMode, "UPD") == 0 ) && ( ( GXutil.strcmp(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emplogonom(), AV98oldEmpLogoNom) != 0 ) || ( GXutil.strcmp(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfirmanom(), AV97oldEmpFirmaNom) != 0 ) || ( GXutil.strcmp(AV103oldEmpDir, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdir()) != 0 ) || ( AV104oldProvCod != AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod() ) || ( AV105oldLocCod != AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod() ) || ( GXutil.strcmp(AV106oldEmpNom, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empnom()) != 0 ) || ( AV107oldEmpCUIT != AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcuit() ) ) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "llama a ActualizaArchivosLiq", "")) ;
            new web.actualizaarchivosliq(remoteHandle, context).execute( AV7CliCod, AV18EmpCod) ;
         }
         if ( ( GXutil.strcmp(AV76TrnMode, "UPD") == 0 ) && ( ( DecimalUtil.compareTo(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfracvacant(), AV114oldEmpFracVacAnt) != 0 ) || ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empvacdismax() != AV115oldEmpVacDisMax ) || ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes() != AV116oldEmpPerVacDes ) || ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas() != AV117oldEmpPerVacHas ) ) )
         {
            AV121parm_iniPerCCLic.setgxTv_Sdtparm_iniPerCCLic_Clicod( AV7CliCod );
            AV121parm_iniPerCCLic.setgxTv_Sdtparm_iniPerCCLic_Empcod( AV18EmpCod );
            AV121parm_iniPerCCLic.setgxTv_Sdtparm_iniPerCCLic_Legnumero( 0 );
            AV121parm_iniPerCCLic.setgxTv_Sdtparm_iniPerCCLic_Desdeanio( (short)(0) );
            AV122Texto = AV121parm_iniPerCCLic.toJSonString(false, true) ;
            callSubmit( 1 , new Object[]{ AV122Texto });
         }
         new web.setempresa(remoteHandle, context).execute( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod()) ;
         if ( GXutil.strcmp(AV76TrnMode, httpContext.getMessage( "DLT", "")) != 0 )
         {
            GXt_char9 = AV102bucket_name ;
            GXt_char8 = AV102bucket_name ;
            GXv_char21[0] = GXt_char8 ;
            new web.bucketname_codigoparam(remoteHandle, context).execute( GXv_char21) ;
            empresa_cabecera_impl.this.GXt_char8 = GXv_char21[0] ;
            GXv_char20[0] = GXt_char9 ;
            new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char8, GXv_char20) ;
            empresa_cabecera_impl.this.GXt_char9 = GXv_char20[0] ;
            AV102bucket_name = GXt_char9 ;
            if ( ! (GXutil.strcmp("", AV102bucket_name)==0) )
            {
               new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV161Pgmname, httpContext.getMessage( "after 3 &Empresa_abm_1.EmpLogoNom ", "")+AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emplogonom()+httpContext.getMessage( " &oldEmpLogoNom ", "")+AV98oldEmpLogoNom) ;
               if ( ! (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emplogonom())==0) && ( GXutil.strcmp(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emplogonom(), AV98oldEmpLogoNom) != 0 ) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV161Pgmname, httpContext.getMessage( "after 4", "")) ;
                  GXv_char21[0] = AV92error ;
                  new web.invocarauploadfile2(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod(), 0, 0, GXutil.blobToBase64( AV119inputFileLogo), GXutil.trim( AV38fotoNameLogo), httpContext.getMessage( "image/jpeg", ""), AV102bucket_name, httpContext.getMessage( "logo", ""), GXv_char21) ;
                  empresa_cabecera_impl.this.AV92error = GXv_char21[0] ;
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV161Pgmname, httpContext.getMessage( "after 5", "")) ;
                  if ( ! (GXutil.strcmp("", AV92error)==0) )
                  {
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV7CliCod, AV161Pgmname, httpContext.getMessage( "after 6", "")) ;
                     new web.alert(remoteHandle, context).execute( "error", AV92error) ;
                  }
               }
               if ( ! (GXutil.strcmp("", AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfirmanom())==0) && ( GXutil.strcmp(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empfirmanom(), AV97oldEmpFirmaNom) != 0 ) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "after 4", "")) ;
                  GXv_char21[0] = AV92error ;
                  new web.invocarauploadfile2(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod(), 0, 0, GXutil.blobToBase64( AV120inputFileFirma), AV37fotoNameFirma, httpContext.getMessage( "image/jpeg", ""), AV102bucket_name, httpContext.getMessage( "firma", ""), GXv_char21) ;
                  empresa_cabecera_impl.this.AV92error = GXv_char21[0] ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "after 5", "")) ;
                  if ( ! (GXutil.strcmp("", AV92error)==0) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "after 6", "")) ;
                     new web.alert(remoteHandle, context).execute( "error", AV92error) ;
                  }
               }
            }
         }
         if ( GXutil.strcmp(AV76TrnMode, httpContext.getMessage( "INS", "")) == 0 )
         {
            GXv_char21[0] = AV86URL ;
            new web.getlinkmenu(remoteHandle, context).execute( AV7CliCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcod(), (byte)(0), "", httpContext.getMessage( "Empresa", ""), GXv_char21) ;
            empresa_cabecera_impl.this.AV86URL = GXv_char21[0] ;
         }
         else
         {
            GXv_char21[0] = AV86URL ;
            new web.getlinkpadre(remoteHandle, context).execute( AV7CliCod, AV18EmpCod, AV85MenuOpcCod, GXv_char21) ;
            empresa_cabecera_impl.this.AV86URL = GXv_char21[0] ;
         }
         callWebObject(formatLink(AV86URL, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
   }

   public void e17KD2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV101WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean7[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV85MenuOpcCod, GXv_boolean7) ;
         GXv_char21[0] = AV99textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char21) ;
         empresa_cabecera_impl.this.AV99textoNoMostrara = GXv_char21[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV99textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean7[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV85MenuOpcCod, GXv_boolean7) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void e18KD2( )
   {
      /* Empresa_abm_1_provcod_Controlvaluechanged Routine */
      returnInSub = false ;
      AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Loccod( (short)(0) );
      /* Execute user subroutine: 'ZONA DE LOCALIDAD' */
      S172 ();
      if (returnInSub) return;
      AV82vinoDeClick = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82vinoDeClick", AV82vinoDeClick);
      /* Execute user subroutine: 'LOADCOMBOEMPRESA_ABM_1_LOCCOD' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Empresa_abm_1", AV19Empresa_abm_1);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV112Empresa_abm_1_LocCod_Data", AV112Empresa_abm_1_LocCod_Data);
   }

   public void S152( )
   {
      /* 'VISIBILIDAD HS DEL MES' Routine */
      returnInSub = false ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmeshspext())==0) )
      {
         cmbavEmpresa_abm_1_empdiahspext.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_empdiahspext.getVisible(), 5, 0), true);
      }
      else
      {
         cmbavEmpresa_abm_1_empdiahspext.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empdiahspext.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_empdiahspext.getVisible(), 5, 0), true);
      }
   }

   public void S172( )
   {
      /* 'ZONA DE LOCALIDAD' Routine */
      returnInSub = false ;
      GXv_char21[0] = AV111LocaZona ;
      new web.getzonaporlocalidad(remoteHandle, context).execute( AV108PaiCod, AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Provcod(), AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Loccod(), GXv_char21) ;
      empresa_cabecera_impl.this.AV111LocaZona = GXv_char21[0] ;
      AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod( AV111LocaZona );
   }

   public void S202( )
   {
      /* 'MODO PREDETERMINADO VISIBLE' Routine */
      returnInSub = false ;
      if ( ! ( ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodempl() ) && ( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodauto() ) ) )
      {
         cmbavEmpresa_abm_1_empmodtra.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_empmodtra.getVisible(), 5, 0), true);
         divEmpresa_abm_1_empmodtra_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpresa_abm_1_empmodtra_cell_Internalname, "Class", divEmpresa_abm_1_empmodtra_cell_Class, true);
      }
      else
      {
         cmbavEmpresa_abm_1_empmodtra.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEmpresa_abm_1_empmodtra.getInternalname(), "Visible", GXutil.ltrimstr( cmbavEmpresa_abm_1_empmodtra.getVisible(), 5, 0), true);
         divEmpresa_abm_1_empmodtra_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpresa_abm_1_empmodtra_cell_Internalname, "Class", divEmpresa_abm_1_empmodtra_cell_Class, true);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e19KD2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_29_KD2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Empresa_cabecera.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_29_KD2e( true) ;
      }
      else
      {
         wb_table2_29_KD2e( false) ;
      }
   }

   public void wb_table1_24_KD2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Empresa_cabecera.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_24_KD2e( true) ;
      }
      else
      {
         wb_table1_24_KD2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV76TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76TrnMode", AV76TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV76TrnMode, ""))));
      AV7CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      AV18EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      AV85MenuOpcCod = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85MenuOpcCod", AV85MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV85MenuOpcCod, ""))));
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
      paKD2( ) ;
      wsKD2( ) ;
      weKD2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316543190", true, true);
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
      httpContext.AddJavascriptSource("empresa_cabecera.js", "?20251316543190", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LImgUploader2Render.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LImgUploader2Render.js", "", false, true);
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
      edtavEmpresa_abm_1_empnom_Internalname = "EMPRESA_ABM_1_EMPNOM" ;
      edtavEmpresa_abm_1_empcuit_Internalname = "EMPRESA_ABM_1_EMPCUIT" ;
      chkavEmpresa_abm_1_empmodempl.setInternalname( "EMPRESA_ABM_1_EMPMODEMPL" );
      chkavEmpresa_abm_1_empmodauto.setInternalname( "EMPRESA_ABM_1_EMPMODAUTO" );
      divUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      Dvpanel_unnamedtable4_Internalname = "DVPANEL_UNNAMEDTABLE4" ;
      cmbavEmpresa_abm_1_empmodtra.setInternalname( "EMPRESA_ABM_1_EMPMODTRA" );
      divEmpresa_abm_1_empmodtra_cell_Internalname = "EMPRESA_ABM_1_EMPMODTRA_CELL" ;
      dynavEmpresa_abm_1_actcodigo.setInternalname( "EMPRESA_ABM_1_ACTCODIGO" );
      dynavEmpresa_abm_1_empcondicod.setInternalname( "EMPRESA_ABM_1_EMPCONDICOD" );
      dynavEmpresa_abm_1_empzoncod.setInternalname( "EMPRESA_ABM_1_EMPZONCOD" );
      dynavEmpresa_abm_1_tipemplecod.setInternalname( "EMPRESA_ABM_1_TIPEMPLECOD" );
      dynavEmpresa_abm_1_provcod.setInternalname( "EMPRESA_ABM_1_PROVCOD" );
      lblTextblockcombo_empresa_abm_1_loccod_Internalname = "TEXTBLOCKCOMBO_EMPRESA_ABM_1_LOCCOD" ;
      Combo_empresa_abm_1_loccod_Internalname = "COMBO_EMPRESA_ABM_1_LOCCOD" ;
      divTablesplittedempresa_abm_1_loccod_Internalname = "TABLESPLITTEDEMPRESA_ABM_1_LOCCOD" ;
      dynavEmpresa_abm_1_empactcomercial.setInternalname( "EMPRESA_ABM_1_EMPACTCOMERCIAL" );
      dynavEmpresa_abm_1_artsec.setInternalname( "EMPRESA_ABM_1_ARTSEC" );
      edtavEmpresa_abm_1_empdir_Internalname = "EMPRESA_ABM_1_EMPDIR" ;
      edtavEmpresa_abm_1_emptel_Internalname = "EMPRESA_ABM_1_EMPTEL" ;
      edtavEmpresa_abm_1_empantiguedad_Internalname = "EMPRESA_ABM_1_EMPANTIGUEDAD" ;
      edtavEmpresa_abm_1_emppresentismo_Internalname = "EMPRESA_ABM_1_EMPPRESENTISMO" ;
      chkavEmpresa_abm_1_empliqgan.setInternalname( "EMPRESA_ABM_1_EMPLIQGAN" );
      cmbavEmpresa_abm_1_emppromdesde.setInternalname( "EMPRESA_ABM_1_EMPPROMDESDE" );
      edtavEmpresa_abm_1_empguaredadmin_Internalname = "EMPRESA_ABM_1_EMPGUAREDADMIN" ;
      edtavEmpresa_abm_1_empguaredadmax_Internalname = "EMPRESA_ABM_1_EMPGUAREDADMAX" ;
      lblTextblockcombo_empresa_abm_1_emposocod_Internalname = "TEXTBLOCKCOMBO_EMPRESA_ABM_1_EMPOSOCOD" ;
      Combo_empresa_abm_1_emposocod_Internalname = "COMBO_EMPRESA_ABM_1_EMPOSOCOD" ;
      divTablesplittedempresa_abm_1_emposocod_Internalname = "TABLESPLITTEDEMPRESA_ABM_1_EMPOSOCOD" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      edtavEmpresa_abm_1_empmeshspext_Internalname = "EMPRESA_ABM_1_EMPMESHSPEXT" ;
      cmbavEmpresa_abm_1_empdiahspext.setInternalname( "EMPRESA_ABM_1_EMPDIAHSPEXT" );
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      Dvpanel_unnamedtable2_Internalname = "DVPANEL_UNNAMEDTABLE2" ;
      cmbavEmpresa_abm_1_emppervacdes.setInternalname( "EMPRESA_ABM_1_EMPPERVACDES" );
      cmbavEmpresa_abm_1_emppervachas.setInternalname( "EMPRESA_ABM_1_EMPPERVACHAS" );
      edtavEmpresa_abm_1_empfracvacant_Internalname = "EMPRESA_ABM_1_EMPFRACVACANT" ;
      edtavEmpresa_abm_1_empvacdismax_Internalname = "EMPRESA_ABM_1_EMPVACDISMAX" ;
      chkavEmpresa_abm_1_empliqfer.setInternalname( "EMPRESA_ABM_1_EMPLIQFER" );
      chkavEmpresa_abm_1_empliqferjor.setInternalname( "EMPRESA_ABM_1_EMPLIQFERJOR" );
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      Dvpanel_unnamedtable3_Internalname = "DVPANEL_UNNAMEDTABLE3" ;
      A3limguploaderlogo_Internalname = "A3LIMGUPLOADERLOGO" ;
      A3limguploaderfirma_Internalname = "A3LIMGUPLOADERFIRMA" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      edtavInputfilelogo_Internalname = "vINPUTFILELOGO" ;
      edtavInputfilefirma_Internalname = "vINPUTFILEFIRMA" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavFotodir_Internalname = "vFOTODIR" ;
      edtavFotonamelogo_Internalname = "vFOTONAMELOGO" ;
      edtavFotonamefirma_Internalname = "vFOTONAMEFIRMA" ;
      chkavEmpresa_abm_1_empvacexplim.setInternalname( "EMPRESA_ABM_1_EMPVACEXPLIM" );
      edtavEmpresa_abm_1_empvacexptie_Internalname = "EMPRESA_ABM_1_EMPVACEXPTIE" ;
      edtavEmpresa_abm_1_clicod_Internalname = "EMPRESA_ABM_1_CLICOD" ;
      edtavEmpresa_abm_1_empcod_Internalname = "EMPRESA_ABM_1_EMPCOD" ;
      edtavEmpresa_abm_1_paicod_Internalname = "EMPRESA_ABM_1_PAICOD" ;
      cmbavEmpresa_abm_1_emptipoexp.setInternalname( "EMPRESA_ABM_1_EMPTIPOEXP" );
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
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      chkavEmpresa_abm_1_empmodauto.setEnabled( 1 );
      chkavEmpresa_abm_1_empmodempl.setEnabled( 1 );
      edtavEmpresa_abm_1_empguaredadmax_Enabled = 1 ;
      edtavEmpresa_abm_1_empguaredadmin_Enabled = 1 ;
      cmbavEmpresa_abm_1_emppromdesde.setEnabled( 1 );
      chkavEmpresa_abm_1_empliqgan.setEnabled( 1 );
      edtavEmpresa_abm_1_emppresentismo_Enabled = 1 ;
      edtavEmpresa_abm_1_empantiguedad_Enabled = 1 ;
      edtavEmpresa_abm_1_emptel_Enabled = 1 ;
      edtavEmpresa_abm_1_empdir_Enabled = 1 ;
      dynavEmpresa_abm_1_artsec.setEnabled( 1 );
      dynavEmpresa_abm_1_empactcomercial.setEnabled( 1 );
      dynavEmpresa_abm_1_provcod.setEnabled( 1 );
      dynavEmpresa_abm_1_tipemplecod.setEnabled( 1 );
      dynavEmpresa_abm_1_empzoncod.setEnabled( 1 );
      dynavEmpresa_abm_1_empcondicod.setEnabled( 1 );
      dynavEmpresa_abm_1_actcodigo.setEnabled( 1 );
      cmbavEmpresa_abm_1_empmodtra.setEnabled( 1 );
      edtavEmpresa_abm_1_empcuit_Enabled = 1 ;
      edtavEmpresa_abm_1_empnom_Enabled = 1 ;
      cmbavEmpresa_abm_1_empdiahspext.setEnabled( 1 );
      edtavEmpresa_abm_1_empmeshspext_Enabled = 1 ;
      chkavEmpresa_abm_1_empliqferjor.setEnabled( 1 );
      chkavEmpresa_abm_1_empliqfer.setEnabled( 1 );
      edtavEmpresa_abm_1_empvacdismax_Enabled = 1 ;
      edtavEmpresa_abm_1_empfracvacant_Enabled = 1 ;
      cmbavEmpresa_abm_1_emppervachas.setEnabled( 1 );
      cmbavEmpresa_abm_1_emppervacdes.setEnabled( 1 );
      cmbavEmpresa_abm_1_emptipoexp.setJsonclick( "" );
      cmbavEmpresa_abm_1_emptipoexp.setVisible( 1 );
      edtavEmpresa_abm_1_paicod_Jsonclick = "" ;
      edtavEmpresa_abm_1_paicod_Visible = 1 ;
      edtavEmpresa_abm_1_empcod_Jsonclick = "" ;
      edtavEmpresa_abm_1_empcod_Visible = 1 ;
      edtavEmpresa_abm_1_clicod_Jsonclick = "" ;
      edtavEmpresa_abm_1_clicod_Visible = 1 ;
      edtavEmpresa_abm_1_empvacexptie_Jsonclick = "" ;
      edtavEmpresa_abm_1_empvacexptie_Visible = 1 ;
      chkavEmpresa_abm_1_empvacexplim.setVisible( 1 );
      edtavFotonamefirma_Visible = 1 ;
      edtavFotonamelogo_Visible = 1 ;
      edtavFotodir_Visible = 1 ;
      edtavInputfilefirma_Jsonclick = "" ;
      edtavInputfilefirma_Parameters = "" ;
      edtavInputfilefirma_Contenttype = "" ;
      edtavInputfilefirma_Filetype = "" ;
      edtavInputfilefirma_Enabled = 1 ;
      edtavInputfilelogo_Jsonclick = "" ;
      edtavInputfilelogo_Parameters = "" ;
      edtavInputfilelogo_Contenttype = "" ;
      edtavInputfilelogo_Filetype = "" ;
      edtavInputfilelogo_Enabled = 1 ;
      bttBtnenter_Visible = 1 ;
      chkavEmpresa_abm_1_empliqferjor.setEnabled( 1 );
      chkavEmpresa_abm_1_empliqfer.setEnabled( 1 );
      edtavEmpresa_abm_1_empvacdismax_Jsonclick = "" ;
      edtavEmpresa_abm_1_empvacdismax_Enabled = 1 ;
      edtavEmpresa_abm_1_empfracvacant_Jsonclick = "" ;
      edtavEmpresa_abm_1_empfracvacant_Enabled = 1 ;
      cmbavEmpresa_abm_1_emppervachas.setJsonclick( "" );
      cmbavEmpresa_abm_1_emppervachas.setEnabled( 1 );
      cmbavEmpresa_abm_1_emppervacdes.setJsonclick( "" );
      cmbavEmpresa_abm_1_emppervacdes.setEnabled( 1 );
      cmbavEmpresa_abm_1_empdiahspext.setJsonclick( "" );
      cmbavEmpresa_abm_1_empdiahspext.setEnabled( 1 );
      cmbavEmpresa_abm_1_empdiahspext.setVisible( 1 );
      edtavEmpresa_abm_1_empmeshspext_Jsonclick = "" ;
      edtavEmpresa_abm_1_empmeshspext_Enabled = 1 ;
      edtavEmpresa_abm_1_empguaredadmax_Jsonclick = "" ;
      edtavEmpresa_abm_1_empguaredadmax_Enabled = 1 ;
      edtavEmpresa_abm_1_empguaredadmin_Jsonclick = "" ;
      edtavEmpresa_abm_1_empguaredadmin_Enabled = 1 ;
      cmbavEmpresa_abm_1_emppromdesde.setJsonclick( "" );
      cmbavEmpresa_abm_1_emppromdesde.setEnabled( 1 );
      chkavEmpresa_abm_1_empliqgan.setEnabled( 1 );
      edtavEmpresa_abm_1_emppresentismo_Jsonclick = "" ;
      edtavEmpresa_abm_1_emppresentismo_Enabled = 1 ;
      edtavEmpresa_abm_1_empantiguedad_Jsonclick = "" ;
      edtavEmpresa_abm_1_empantiguedad_Enabled = 1 ;
      edtavEmpresa_abm_1_emptel_Jsonclick = "" ;
      edtavEmpresa_abm_1_emptel_Enabled = 1 ;
      edtavEmpresa_abm_1_empdir_Jsonclick = "" ;
      edtavEmpresa_abm_1_empdir_Enabled = 1 ;
      dynavEmpresa_abm_1_artsec.setJsonclick( "" );
      dynavEmpresa_abm_1_artsec.setEnabled( 1 );
      dynavEmpresa_abm_1_empactcomercial.setJsonclick( "" );
      dynavEmpresa_abm_1_empactcomercial.setEnabled( 1 );
      Combo_empresa_abm_1_loccod_Caption = "" ;
      dynavEmpresa_abm_1_provcod.setJsonclick( "" );
      dynavEmpresa_abm_1_provcod.setEnabled( 1 );
      dynavEmpresa_abm_1_tipemplecod.setJsonclick( "" );
      dynavEmpresa_abm_1_tipemplecod.setEnabled( 1 );
      dynavEmpresa_abm_1_empzoncod.setJsonclick( "" );
      dynavEmpresa_abm_1_empzoncod.setEnabled( 1 );
      dynavEmpresa_abm_1_empcondicod.setJsonclick( "" );
      dynavEmpresa_abm_1_empcondicod.setEnabled( 1 );
      dynavEmpresa_abm_1_actcodigo.setJsonclick( "" );
      dynavEmpresa_abm_1_actcodigo.setEnabled( 1 );
      cmbavEmpresa_abm_1_empmodtra.setJsonclick( "" );
      cmbavEmpresa_abm_1_empmodtra.setEnabled( 1 );
      cmbavEmpresa_abm_1_empmodtra.setVisible( 1 );
      divEmpresa_abm_1_empmodtra_cell_Class = "col-xs-12 col-sm-6" ;
      chkavEmpresa_abm_1_empmodauto.setEnabled( 1 );
      chkavEmpresa_abm_1_empmodempl.setEnabled( 1 );
      edtavEmpresa_abm_1_empcuit_Jsonclick = "" ;
      edtavEmpresa_abm_1_empcuit_Enabled = 1 ;
      edtavEmpresa_abm_1_empnom_Jsonclick = "" ;
      edtavEmpresa_abm_1_empnom_Enabled = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      imgavWelcomemessage_foto_Enabled = 0 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      A3limguploaderfirma_Inputfileid = "" ;
      A3limguploaderfirma_Photo_name_id = "" ;
      A3limguploaderfirma_Mode = "" ;
      A3limguploaderfirma_Observer = "" ;
      A3limguploaderfirma_Src_default = "" ;
      A3limguploaderfirma_Id_img = "" ;
      A3limguploaderfirma_Class_img = "" ;
      A3limguploaderfirma_Buttonid = "" ;
      A3limguploaderfirma_Button_caption = "" ;
      A3limguploaderfirma_Buttonclass = "" ;
      A3limguploaderlogo_Inputfileid = "" ;
      A3limguploaderlogo_Photo_name_id = "" ;
      A3limguploaderlogo_Mode = "" ;
      A3limguploaderlogo_Observer = "" ;
      A3limguploaderlogo_Src_default = "" ;
      A3limguploaderlogo_Id_img = "" ;
      A3limguploaderlogo_Class_img = "" ;
      A3limguploaderlogo_Buttonid = "" ;
      A3limguploaderlogo_Button_caption = "" ;
      A3limguploaderlogo_Buttonclass = "" ;
      Dvpanel_unnamedtable3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Iconposition = "Right" ;
      Dvpanel_unnamedtable3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Title = httpContext.getMessage( "Licencias y feriados", "") ;
      Dvpanel_unnamedtable3_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Width = "100%" ;
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Title = httpContext.getMessage( "Hora normal", "") ;
      Dvpanel_unnamedtable2_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Datos generales", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      Combo_empresa_abm_1_emposocod_Enabled = GXutil.toBoolean( -1) ;
      Combo_empresa_abm_1_emposocod_Cls = "ExtendedCombo Attribute" ;
      Combo_empresa_abm_1_loccod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_empresa_abm_1_loccod_Enabled = GXutil.toBoolean( -1) ;
      Combo_empresa_abm_1_loccod_Cls = "ExtendedCombo Attribute" ;
      Dvpanel_unnamedtable4_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Iconposition = "Right" ;
      Dvpanel_unnamedtable4_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Title = httpContext.getMessage( "Relación laboral de colaboradores", "") ;
      Dvpanel_unnamedtable4_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable4_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Empresa", "") );
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
      AV101WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV101WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV101WelcomeMessage_NoMostrarMas", AV101WelcomeMessage_NoMostrarMas);
      chkavEmpresa_abm_1_empmodempl.setName( "EMPRESA_ABM_1_EMPMODEMPL" );
      chkavEmpresa_abm_1_empmodempl.setWebtags( "" );
      chkavEmpresa_abm_1_empmodempl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empmodempl.getInternalname(), "TitleCaption", chkavEmpresa_abm_1_empmodempl.getCaption(), true);
      chkavEmpresa_abm_1_empmodempl.setCheckedValue( "false" );
      chkavEmpresa_abm_1_empmodauto.setName( "EMPRESA_ABM_1_EMPMODAUTO" );
      chkavEmpresa_abm_1_empmodauto.setWebtags( "" );
      chkavEmpresa_abm_1_empmodauto.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empmodauto.getInternalname(), "TitleCaption", chkavEmpresa_abm_1_empmodauto.getCaption(), true);
      chkavEmpresa_abm_1_empmodauto.setCheckedValue( "false" );
      cmbavEmpresa_abm_1_empmodtra.setName( "EMPRESA_ABM_1_EMPMODTRA" );
      cmbavEmpresa_abm_1_empmodtra.setWebtags( "" );
      cmbavEmpresa_abm_1_empmodtra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbavEmpresa_abm_1_empmodtra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbavEmpresa_abm_1_empmodtra.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empmodtra( cmbavEmpresa_abm_1_empmodtra.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empmodtra()) );
      }
      dynavEmpresa_abm_1_actcodigo.setName( "EMPRESA_ABM_1_ACTCODIGO" );
      dynavEmpresa_abm_1_actcodigo.setWebtags( "" );
      dynavEmpresa_abm_1_actcodigo.removeAllItems();
      /* Using cursor H00KD17 */
      pr_default.execute(15);
      while ( (pr_default.getStatus(15) != 101) )
      {
         dynavEmpresa_abm_1_actcodigo.addItem(H00KD17_A43ActCodigo[0], H00KD17_A108ActDescrip[0], (short)(0));
         pr_default.readNext(15);
      }
      pr_default.close(15);
      if ( dynavEmpresa_abm_1_actcodigo.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Actcodigo( dynavEmpresa_abm_1_actcodigo.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Actcodigo()) );
      }
      dynavEmpresa_abm_1_empcondicod.setName( "EMPRESA_ABM_1_EMPCONDICOD" );
      dynavEmpresa_abm_1_empcondicod.setWebtags( "" );
      dynavEmpresa_abm_1_empcondicod.removeAllItems();
      /* Using cursor H00KD18 */
      pr_default.execute(16);
      while ( (pr_default.getStatus(16) != 101) )
      {
         dynavEmpresa_abm_1_empcondicod.addItem(GXutil.trim( GXutil.str( H00KD18_A17CondiCodigo[0], 4, 0)), H00KD18_A144CondiDescri[0], (short)(0));
         pr_default.readNext(16);
      }
      pr_default.close(16);
      if ( dynavEmpresa_abm_1_empcondicod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empcondicod( (short)(GXutil.lval( dynavEmpresa_abm_1_empcondicod.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empcondicod(), 4, 0))))) );
      }
      dynavEmpresa_abm_1_empzoncod.setName( "EMPRESA_ABM_1_EMPZONCOD" );
      dynavEmpresa_abm_1_empzoncod.setWebtags( "" );
      dynavEmpresa_abm_1_empzoncod.removeAllItems();
      /* Using cursor H00KD19 */
      pr_default.execute(17);
      while ( (pr_default.getStatus(17) != 101) )
      {
         dynavEmpresa_abm_1_empzoncod.addItem(H00KD19_A20ZonCod[0], H00KD19_A342ZonDescrip[0], (short)(0));
         pr_default.readNext(17);
      }
      pr_default.close(17);
      if ( dynavEmpresa_abm_1_empzoncod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empzoncod( dynavEmpresa_abm_1_empzoncod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empzoncod()) );
      }
      dynavEmpresa_abm_1_tipemplecod.setName( "EMPRESA_ABM_1_TIPEMPLECOD" );
      dynavEmpresa_abm_1_tipemplecod.setWebtags( "" );
      dynavEmpresa_abm_1_tipemplecod.removeAllItems();
      /* Using cursor H00KD20 */
      pr_default.execute(18);
      while ( (pr_default.getStatus(18) != 101) )
      {
         dynavEmpresa_abm_1_tipemplecod.addItem(H00KD20_A45TipEmpleCod[0], H00KD20_A339TipEmpleDescri[0], (short)(0));
         pr_default.readNext(18);
      }
      pr_default.close(18);
      if ( dynavEmpresa_abm_1_tipemplecod.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Tipemplecod( dynavEmpresa_abm_1_tipemplecod.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Tipemplecod()) );
      }
      dynavEmpresa_abm_1_provcod.setName( "EMPRESA_ABM_1_PROVCOD" );
      dynavEmpresa_abm_1_provcod.setWebtags( "" );
      dynavEmpresa_abm_1_empactcomercial.setName( "EMPRESA_ABM_1_EMPACTCOMERCIAL" );
      dynavEmpresa_abm_1_empactcomercial.setWebtags( "" );
      dynavEmpresa_abm_1_empactcomercial.removeAllItems();
      /* Using cursor H00KD21 */
      pr_default.execute(19);
      while ( (pr_default.getStatus(19) != 101) )
      {
         dynavEmpresa_abm_1_empactcomercial.addItem(H00KD21_A903ActComCodigo[0], H00KD21_A904ActComDescripcion[0], (short)(0));
         pr_default.readNext(19);
      }
      pr_default.close(19);
      if ( dynavEmpresa_abm_1_empactcomercial.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empactcomercial( dynavEmpresa_abm_1_empactcomercial.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empactcomercial()) );
      }
      dynavEmpresa_abm_1_artsec.setName( "EMPRESA_ABM_1_ARTSEC" );
      dynavEmpresa_abm_1_artsec.setWebtags( "" );
      dynavEmpresa_abm_1_artsec.removeAllItems();
      /* Using cursor H00KD22 */
      pr_default.execute(20);
      while ( (pr_default.getStatus(20) != 101) )
      {
         dynavEmpresa_abm_1_artsec.addItem(GXutil.trim( GXutil.str( H00KD22_A1151ARTSec[0], 4, 0)), H00KD22_A1152ARTNom[0], (short)(0));
         pr_default.readNext(20);
      }
      pr_default.close(20);
      if ( dynavEmpresa_abm_1_artsec.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Artsec( (short)(GXutil.lval( dynavEmpresa_abm_1_artsec.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Artsec(), 4, 0))))) );
      }
      chkavEmpresa_abm_1_empliqgan.setName( "EMPRESA_ABM_1_EMPLIQGAN" );
      chkavEmpresa_abm_1_empliqgan.setWebtags( "" );
      chkavEmpresa_abm_1_empliqgan.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empliqgan.getInternalname(), "TitleCaption", chkavEmpresa_abm_1_empliqgan.getCaption(), true);
      chkavEmpresa_abm_1_empliqgan.setCheckedValue( "false" );
      cmbavEmpresa_abm_1_emppromdesde.setName( "EMPRESA_ABM_1_EMPPROMDESDE" );
      cmbavEmpresa_abm_1_emppromdesde.setWebtags( "" );
      cmbavEmpresa_abm_1_emppromdesde.addItem("actual", httpContext.getMessage( "Mes Actual", ""), (short)(0));
      cmbavEmpresa_abm_1_emppromdesde.addItem("anterior", httpContext.getMessage( "Mes anterior", ""), (short)(0));
      if ( cmbavEmpresa_abm_1_emppromdesde.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppromdesde( cmbavEmpresa_abm_1_emppromdesde.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppromdesde()) );
      }
      cmbavEmpresa_abm_1_empdiahspext.setName( "EMPRESA_ABM_1_EMPDIAHSPEXT" );
      cmbavEmpresa_abm_1_empdiahspext.setWebtags( "" );
      cmbavEmpresa_abm_1_empdiahspext.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
      cmbavEmpresa_abm_1_empdiahspext.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
      cmbavEmpresa_abm_1_empdiahspext.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
      if ( cmbavEmpresa_abm_1_empdiahspext.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Empdiahspext( cmbavEmpresa_abm_1_empdiahspext.getValidValue(AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Empdiahspext()) );
      }
      cmbavEmpresa_abm_1_emppervacdes.setName( "EMPRESA_ABM_1_EMPPERVACDES" );
      cmbavEmpresa_abm_1_emppervacdes.setWebtags( "" );
      cmbavEmpresa_abm_1_emppervacdes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervacdes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavEmpresa_abm_1_emppervacdes.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervacdes( (byte)(GXutil.lval( cmbavEmpresa_abm_1_emppervacdes.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervacdes(), 2, 0))))) );
      }
      cmbavEmpresa_abm_1_emppervachas.setName( "EMPRESA_ABM_1_EMPPERVACHAS" );
      cmbavEmpresa_abm_1_emppervachas.setWebtags( "" );
      cmbavEmpresa_abm_1_emppervachas.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbavEmpresa_abm_1_emppervachas.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbavEmpresa_abm_1_emppervachas.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emppervachas( (byte)(GXutil.lval( cmbavEmpresa_abm_1_emppervachas.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emppervachas(), 2, 0))))) );
      }
      chkavEmpresa_abm_1_empliqfer.setName( "EMPRESA_ABM_1_EMPLIQFER" );
      chkavEmpresa_abm_1_empliqfer.setWebtags( "" );
      chkavEmpresa_abm_1_empliqfer.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empliqfer.getInternalname(), "TitleCaption", chkavEmpresa_abm_1_empliqfer.getCaption(), true);
      chkavEmpresa_abm_1_empliqfer.setCheckedValue( "false" );
      chkavEmpresa_abm_1_empliqferjor.setName( "EMPRESA_ABM_1_EMPLIQFERJOR" );
      chkavEmpresa_abm_1_empliqferjor.setWebtags( "" );
      chkavEmpresa_abm_1_empliqferjor.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empliqferjor.getInternalname(), "TitleCaption", chkavEmpresa_abm_1_empliqferjor.getCaption(), true);
      chkavEmpresa_abm_1_empliqferjor.setCheckedValue( "false" );
      chkavEmpresa_abm_1_empvacexplim.setName( "EMPRESA_ABM_1_EMPVACEXPLIM" );
      chkavEmpresa_abm_1_empvacexplim.setWebtags( "" );
      chkavEmpresa_abm_1_empvacexplim.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmpresa_abm_1_empvacexplim.getInternalname(), "TitleCaption", chkavEmpresa_abm_1_empvacexplim.getCaption(), true);
      chkavEmpresa_abm_1_empvacexplim.setCheckedValue( "false" );
      cmbavEmpresa_abm_1_emptipoexp.setName( "EMPRESA_ABM_1_EMPTIPOEXP" );
      cmbavEmpresa_abm_1_emptipoexp.setWebtags( "" );
      cmbavEmpresa_abm_1_emptipoexp.addItem("1", httpContext.getMessage( "Prorratear sueldo a días trabajados, liquidar vacaciones/licencia/feriado sin plus incluido, y exponer el plus en concepto explícito", ""), (short)(0));
      cmbavEmpresa_abm_1_emptipoexp.addItem("2", httpContext.getMessage( "No prorratear sueldo a días trabajados, liquidar vacaciones/licencia/feriado con plus incluido  y exponer el plus de manera implícita restando por días no trabajados", ""), (short)(0));
      if ( cmbavEmpresa_abm_1_emptipoexp.getItemCount() > 0 )
      {
         AV19Empresa_abm_1.setgxTv_SdtEmpresa_abm_1_Emptipoexp( (byte)(GXutil.lval( cmbavEmpresa_abm_1_emptipoexp.getValidValue(GXutil.trim( GXutil.str( AV19Empresa_abm_1.getgxTv_SdtEmpresa_abm_1_Emptipoexp(), 1, 0))))) );
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavEmpresa_abm_1_artsec'},{av:'GXV12',fld:'EMPRESA_ABM_1_ARTSEC',pic:'ZZZ9'},{av:'dynavEmpresa_abm_1_empactcomercial'},{av:'GXV11',fld:'EMPRESA_ABM_1_EMPACTCOMERCIAL',pic:''},{av:'dynavEmpresa_abm_1_tipemplecod'},{av:'GXV9',fld:'EMPRESA_ABM_1_TIPEMPLECOD',pic:''},{av:'dynavEmpresa_abm_1_empzoncod'},{av:'GXV8',fld:'EMPRESA_ABM_1_EMPZONCOD',pic:''},{av:'dynavEmpresa_abm_1_empcondicod'},{av:'GXV7',fld:'EMPRESA_ABM_1_EMPCONDICOD',pic:'ZZZ9'},{av:'dynavEmpresa_abm_1_actcodigo'},{av:'GXV6',fld:'EMPRESA_ABM_1_ACTCODIGO',pic:''},{av:'AV101WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'GXV3',fld:'EMPRESA_ABM_1_EMPMODEMPL',pic:''},{av:'GXV4',fld:'EMPRESA_ABM_1_EMPMODAUTO',pic:''},{av:'GXV17',fld:'EMPRESA_ABM_1_EMPLIQGAN',pic:''},{av:'GXV27',fld:'EMPRESA_ABM_1_EMPLIQFER',pic:''},{av:'GXV28',fld:'EMPRESA_ABM_1_EMPLIQFERJOR',pic:''},{av:'GXV29',fld:'EMPRESA_ABM_1_EMPVACEXPLIM',pic:''},{av:'AV76TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV105oldLocCod',fld:'vOLDLOCCOD',pic:'ZZZ9',hsh:true},{av:'AV98oldEmpLogoNom',fld:'vOLDEMPLOGONOM',pic:'',hsh:true},{av:'AV97oldEmpFirmaNom',fld:'vOLDEMPFIRMANOM',pic:'',hsh:true},{av:'AV103oldEmpDir',fld:'vOLDEMPDIR',pic:'@!',hsh:true},{av:'AV104oldProvCod',fld:'vOLDPROVCOD',pic:'ZZZ9',hsh:true},{av:'AV106oldEmpNom',fld:'vOLDEMPNOM',pic:'@!',hsh:true},{av:'AV107oldEmpCUIT',fld:'vOLDEMPCUIT',pic:'ZZZZZZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV114oldEmpFracVacAnt',fld:'vOLDEMPFRACVACANT',pic:'9.9999',hsh:true},{av:'AV115oldEmpVacDisMax',fld:'vOLDEMPVACDISMAX',pic:'ZZZZZ9',hsh:true},{av:'AV116oldEmpPerVacDes',fld:'vOLDEMPPERVACDES',pic:'Z9',hsh:true},{av:'AV117oldEmpPerVacHas',fld:'vOLDEMPPERVACHAS',pic:'Z9',hsh:true},{av:'AV85MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV108PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("COMBO_EMPRESA_ABM_1_EMPOSOCOD.ONOPTIONCLICKED","{handler:'e13KD2',iparms:[{av:'Combo_empresa_abm_1_emposocod_Selectedvalue_get',ctrl:'COMBO_EMPRESA_ABM_1_EMPOSOCOD',prop:'SelectedValue_get'},{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''}]");
      setEventMetadata("COMBO_EMPRESA_ABM_1_EMPOSOCOD.ONOPTIONCLICKED",",oparms:[{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''}]}");
      setEventMetadata("COMBO_EMPRESA_ABM_1_LOCCOD.ONOPTIONCLICKED","{handler:'e12KD2',iparms:[{av:'Combo_empresa_abm_1_loccod_Selectedvalue_get',ctrl:'COMBO_EMPRESA_ABM_1_LOCCOD',prop:'SelectedValue_get'},{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''},{av:'AV108PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("COMBO_EMPRESA_ABM_1_LOCCOD.ONOPTIONCLICKED",",oparms:[{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e16KD2',iparms:[{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''},{av:'AV76TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV38fotoNameLogo',fld:'vFOTONAMELOGO',pic:''},{av:'AV37fotoNameFirma',fld:'vFOTONAMEFIRMA',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV5CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'Combo_empresa_abm_1_loccod_Ddointernalname',ctrl:'COMBO_EMPRESA_ABM_1_LOCCOD',prop:'DDOInternalName'},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV105oldLocCod',fld:'vOLDLOCCOD',pic:'ZZZ9',hsh:true},{av:'AV98oldEmpLogoNom',fld:'vOLDEMPLOGONOM',pic:'',hsh:true},{av:'AV97oldEmpFirmaNom',fld:'vOLDEMPFIRMANOM',pic:'',hsh:true},{av:'AV103oldEmpDir',fld:'vOLDEMPDIR',pic:'@!',hsh:true},{av:'AV104oldProvCod',fld:'vOLDPROVCOD',pic:'ZZZ9',hsh:true},{av:'AV106oldEmpNom',fld:'vOLDEMPNOM',pic:'@!',hsh:true},{av:'AV107oldEmpCUIT',fld:'vOLDEMPCUIT',pic:'ZZZZZZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV114oldEmpFracVacAnt',fld:'vOLDEMPFRACVACANT',pic:'9.9999',hsh:true},{av:'AV115oldEmpVacDisMax',fld:'vOLDEMPVACDISMAX',pic:'ZZZZZ9',hsh:true},{av:'AV116oldEmpPerVacDes',fld:'vOLDEMPPERVACDES',pic:'Z9',hsh:true},{av:'AV117oldEmpPerVacHas',fld:'vOLDEMPPERVACHAS',pic:'Z9',hsh:true},{av:'AV121parm_iniPerCCLic',fld:'vPARM_INIPERCCLIC',pic:''},{av:'AV119inputFileLogo',fld:'vINPUTFILELOGO',pic:''},{av:'AV120inputFileFirma',fld:'vINPUTFILEFIRMA',pic:''},{av:'AV85MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV65Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''},{av:'AV65Messages',fld:'vMESSAGES',pic:''},{av:'AV5CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV121parm_iniPerCCLic',fld:'vPARM_INIPERCCLIC',pic:''}]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17KD2',iparms:[{av:'AV101WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV85MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e11KD1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("EMPRESA_ABM_1_PROVCOD.CONTROLVALUECHANGED","{handler:'e18KD2',iparms:[{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''},{av:'AV108PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV82vinoDeClick',fld:'vVINODECLICK',pic:''},{av:'AV76TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A47ProvCod',fld:'PROVCOD',pic:'ZZZ9'},{av:'A48LocCod',fld:'LOCCOD',pic:'ZZZ9'},{av:'A286LocNom',fld:'LOCNOM',pic:'@!'}]");
      setEventMetadata("EMPRESA_ABM_1_PROVCOD.CONTROLVALUECHANGED",",oparms:[{av:'AV19Empresa_abm_1',fld:'vEMPRESA_ABM_1',pic:''},{av:'AV82vinoDeClick',fld:'vVINODECLICK',pic:''},{av:'AV112Empresa_abm_1_LocCod_Data',fld:'vEMPRESA_ABM_1_LOCCOD_DATA',pic:''},{av:'Combo_empresa_abm_1_loccod_Selectedvalue_set',ctrl:'COMBO_EMPRESA_ABM_1_LOCCOD',prop:'SelectedValue_set'}]}");
      setEventMetadata("VALIDV_GXV5","{handler:'validv_Gxv5',iparms:[]");
      setEventMetadata("VALIDV_GXV5",",oparms:[]}");
      setEventMetadata("VALIDV_GXV18","{handler:'validv_Gxv18',iparms:[]");
      setEventMetadata("VALIDV_GXV18",",oparms:[]}");
      setEventMetadata("VALIDV_GXV22","{handler:'validv_Gxv22',iparms:[]");
      setEventMetadata("VALIDV_GXV22",",oparms:[]}");
      setEventMetadata("VALIDV_GXV23","{handler:'validv_Gxv23',iparms:[]");
      setEventMetadata("VALIDV_GXV23",",oparms:[]}");
      setEventMetadata("VALIDV_GXV24","{handler:'validv_Gxv24',iparms:[]");
      setEventMetadata("VALIDV_GXV24",",oparms:[]}");
      setEventMetadata("VALIDV_GXV34","{handler:'validv_Gxv34',iparms:[]");
      setEventMetadata("VALIDV_GXV34",",oparms:[]}");
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
   public void submit( int submitId ,
                       Object [] submitParms ,
                       ModelContext submitContext )
   {
      UserInformation submitUI = (UserInformation) GXObjectHelper.getUserInformation(context, -1);
      int remoteHandle = submitUI.getHandle();
      try
      {
         switch ( submitId )
         {
               case 1 :
                  new web.inipercclic_submit(remoteHandle, submitContext).execute( (String)submitParms[0]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
         }
      }
      catch ( Exception e )
      {
         Application.cleanupConnection(remoteHandle);
         e.printStackTrace();
      }
   }

   public void initialize( )
   {
      wcpOAV76TrnMode = "" ;
      wcpOAV85MenuOpcCod = "" ;
      Combo_empresa_abm_1_emposocod_Selectedvalue_get = "" ;
      Combo_empresa_abm_1_loccod_Selectedvalue_get = "" ;
      Combo_empresa_abm_1_loccod_Ddointernalname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV76TrnMode = "" ;
      AV85MenuOpcCod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV161Pgmname = "" ;
      AV98oldEmpLogoNom = "" ;
      AV97oldEmpFirmaNom = "" ;
      AV103oldEmpDir = "" ;
      AV106oldEmpNom = "" ;
      AV114oldEmpFracVacAnt = DecimalUtil.ZERO ;
      GXKey = "" ;
      AV19Empresa_abm_1 = new web.SdtEmpresa_abm_1(remoteHandle);
      AV113DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV112Empresa_abm_1_LocCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV87Empresa_abm_1_EmpOsoCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV121parm_iniPerCCLic = new web.Sdtparm_iniPerCCLic(remoteHandle, context);
      AV65Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      A286LocNom = "" ;
      GXCCtlgxBlob = "" ;
      AV119inputFileLogo = "" ;
      AV120inputFileFirma = "" ;
      Combo_empresa_abm_1_loccod_Selectedvalue_set = "" ;
      Combo_empresa_abm_1_emposocod_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV100WelcomeMessage_Foto = "" ;
      AV159Welcomemessage_foto_GXI = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_unnamedtable4 = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_empresa_abm_1_loccod_Jsonclick = "" ;
      ucCombo_empresa_abm_1_loccod = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_empresa_abm_1_emposocod_Jsonclick = "" ;
      ucCombo_empresa_abm_1_emposocod = new com.genexus.webpanels.GXUserControl();
      Combo_empresa_abm_1_emposocod_Caption = "" ;
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_unnamedtable3 = new com.genexus.webpanels.GXUserControl();
      ucA3limguploaderlogo = new com.genexus.webpanels.GXUserControl();
      ucA3limguploaderfirma = new com.genexus.webpanels.GXUserControl();
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      AV34fotoDir = "" ;
      AV38fotoNameLogo = "" ;
      AV37fotoNameFirma = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00KD2_A1151ARTSec = new short[1] ;
      H00KD2_A1152ARTNom = new String[] {""} ;
      H00KD3_A903ActComCodigo = new String[] {""} ;
      H00KD3_A904ActComDescripcion = new String[] {""} ;
      H00KD4_A45TipEmpleCod = new String[] {""} ;
      H00KD4_A339TipEmpleDescri = new String[] {""} ;
      H00KD5_A20ZonCod = new String[] {""} ;
      H00KD5_A342ZonDescrip = new String[] {""} ;
      H00KD6_A17CondiCodigo = new short[1] ;
      H00KD6_A144CondiDescri = new String[] {""} ;
      H00KD7_A43ActCodigo = new String[] {""} ;
      H00KD7_A108ActDescrip = new String[] {""} ;
      H00KD8_A47ProvCod = new short[1] ;
      H00KD8_A322ProvNom = new String[] {""} ;
      H00KD8_A46PaiCod = new short[1] ;
      H00KD9_A1151ARTSec = new short[1] ;
      H00KD9_A1152ARTNom = new String[] {""} ;
      H00KD10_A903ActComCodigo = new String[] {""} ;
      H00KD10_A904ActComDescripcion = new String[] {""} ;
      H00KD11_A45TipEmpleCod = new String[] {""} ;
      H00KD11_A339TipEmpleDescri = new String[] {""} ;
      H00KD12_A20ZonCod = new String[] {""} ;
      H00KD12_A342ZonDescrip = new String[] {""} ;
      H00KD13_A17CondiCodigo = new short[1] ;
      H00KD13_A144CondiDescri = new String[] {""} ;
      H00KD14_A43ActCodigo = new String[] {""} ;
      H00KD14_A108ActDescrip = new String[] {""} ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV93MenuBienveImgURL = "" ;
      AV95MenuBienveTitulo = "" ;
      AV94MenuBienveTexto = "" ;
      AV15destinationDir = "" ;
      GXv_int1 = new short[1] ;
      GXv_int11 = new byte[1] ;
      GXv_char6 = new String[1] ;
      GXv_int12 = new byte[1] ;
      GXv_int13 = new byte[1] ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      GXv_char5 = new String[1] ;
      GXv_int15 = new byte[1] ;
      GXv_int16 = new int[1] ;
      GXv_char4 = new String[1] ;
      GXv_int17 = new short[1] ;
      AV92error = "" ;
      H00KD15_A3CliCod = new int[1] ;
      H00KD15_A555OsoSiglaYDesc = new String[] {""} ;
      H00KD15_A5OsoCod = new String[] {""} ;
      A555OsoSiglaYDesc = "" ;
      A5OsoCod = "" ;
      AV80Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      GXv_int19 = new short[1] ;
      GXv_int18 = new short[1] ;
      H00KD16_A47ProvCod = new short[1] ;
      H00KD16_A46PaiCod = new short[1] ;
      H00KD16_A48LocCod = new short[1] ;
      H00KD16_A286LocNom = new String[] {""} ;
      AV64Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV122Texto = "" ;
      AV102bucket_name = "" ;
      GXt_char9 = "" ;
      GXt_char8 = "" ;
      GXv_char20 = new String[1] ;
      AV86URL = "" ;
      AV99textoNoMostrara = "" ;
      GXv_boolean7 = new boolean[1] ;
      AV111LocaZona = "" ;
      GXv_char21 = new String[1] ;
      sStyleString = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      H00KD17_A43ActCodigo = new String[] {""} ;
      H00KD17_A108ActDescrip = new String[] {""} ;
      H00KD18_A17CondiCodigo = new short[1] ;
      H00KD18_A144CondiDescri = new String[] {""} ;
      H00KD19_A20ZonCod = new String[] {""} ;
      H00KD19_A342ZonDescrip = new String[] {""} ;
      H00KD20_A45TipEmpleCod = new String[] {""} ;
      H00KD20_A339TipEmpleDescri = new String[] {""} ;
      H00KD21_A903ActComCodigo = new String[] {""} ;
      H00KD21_A904ActComDescripcion = new String[] {""} ;
      H00KD22_A1151ARTSec = new short[1] ;
      H00KD22_A1152ARTNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_cabecera__default(),
         new Object[] {
             new Object[] {
            H00KD2_A1151ARTSec, H00KD2_A1152ARTNom
            }
            , new Object[] {
            H00KD3_A903ActComCodigo, H00KD3_A904ActComDescripcion
            }
            , new Object[] {
            H00KD4_A45TipEmpleCod, H00KD4_A339TipEmpleDescri
            }
            , new Object[] {
            H00KD5_A20ZonCod, H00KD5_A342ZonDescrip
            }
            , new Object[] {
            H00KD6_A17CondiCodigo, H00KD6_A144CondiDescri
            }
            , new Object[] {
            H00KD7_A43ActCodigo, H00KD7_A108ActDescrip
            }
            , new Object[] {
            H00KD8_A47ProvCod, H00KD8_A322ProvNom, H00KD8_A46PaiCod
            }
            , new Object[] {
            H00KD9_A1151ARTSec, H00KD9_A1152ARTNom
            }
            , new Object[] {
            H00KD10_A903ActComCodigo, H00KD10_A904ActComDescripcion
            }
            , new Object[] {
            H00KD11_A45TipEmpleCod, H00KD11_A339TipEmpleDescri
            }
            , new Object[] {
            H00KD12_A20ZonCod, H00KD12_A342ZonDescrip
            }
            , new Object[] {
            H00KD13_A17CondiCodigo, H00KD13_A144CondiDescri
            }
            , new Object[] {
            H00KD14_A43ActCodigo, H00KD14_A108ActDescrip
            }
            , new Object[] {
            H00KD15_A3CliCod, H00KD15_A555OsoSiglaYDesc, H00KD15_A5OsoCod
            }
            , new Object[] {
            H00KD16_A47ProvCod, H00KD16_A46PaiCod, H00KD16_A48LocCod, H00KD16_A286LocNom
            }
            , new Object[] {
            H00KD17_A43ActCodigo, H00KD17_A108ActDescrip
            }
            , new Object[] {
            H00KD18_A17CondiCodigo, H00KD18_A144CondiDescri
            }
            , new Object[] {
            H00KD19_A20ZonCod, H00KD19_A342ZonDescrip
            }
            , new Object[] {
            H00KD20_A45TipEmpleCod, H00KD20_A339TipEmpleDescri
            }
            , new Object[] {
            H00KD21_A903ActComCodigo, H00KD21_A904ActComDescripcion
            }
            , new Object[] {
            H00KD22_A1151ARTSec, H00KD22_A1152ARTNom
            }
         }
      );
      AV161Pgmname = "Empresa_cabecera" ;
      /* GeneXus formulas. */
      AV161Pgmname = "Empresa_cabecera" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV116oldEmpPerVacDes ;
   private byte AV117oldEmpPerVacHas ;
   private byte nDonePA ;
   private byte GXv_int11[] ;
   private byte GXv_int12[] ;
   private byte GXv_int13[] ;
   private byte GXv_int15[] ;
   private byte AV162GXLvl440 ;
   private byte nGXWrapped ;
   private short wcpOAV18EmpCod ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV108PaiCod ;
   private short AV18EmpCod ;
   private short AV105oldLocCod ;
   private short AV104oldProvCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int1[] ;
   private short GXv_int17[] ;
   private short GXt_int10 ;
   private short AV110empresa_ProvCod ;
   private short GXv_int19[] ;
   private short AV109empresa_LocCod ;
   private short GXv_int18[] ;
   private int wcpOAV7CliCod ;
   private int AV7CliCod ;
   private int AV115oldEmpVacDisMax ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int imgavWelcomemessage_foto_Enabled ;
   private int edtavEmpresa_abm_1_empnom_Enabled ;
   private int edtavEmpresa_abm_1_empcuit_Enabled ;
   private int edtavEmpresa_abm_1_empdir_Enabled ;
   private int edtavEmpresa_abm_1_emptel_Enabled ;
   private int edtavEmpresa_abm_1_empantiguedad_Enabled ;
   private int edtavEmpresa_abm_1_emppresentismo_Enabled ;
   private int edtavEmpresa_abm_1_empguaredadmin_Enabled ;
   private int edtavEmpresa_abm_1_empguaredadmax_Enabled ;
   private int edtavEmpresa_abm_1_empmeshspext_Enabled ;
   private int edtavEmpresa_abm_1_empfracvacant_Enabled ;
   private int edtavEmpresa_abm_1_empvacdismax_Enabled ;
   private int bttBtnenter_Visible ;
   private int edtavInputfilelogo_Enabled ;
   private int edtavInputfilefirma_Enabled ;
   private int edtavFotodir_Visible ;
   private int edtavFotonamelogo_Visible ;
   private int edtavFotonamefirma_Visible ;
   private int edtavEmpresa_abm_1_empvacexptie_Visible ;
   private int edtavEmpresa_abm_1_clicod_Visible ;
   private int edtavEmpresa_abm_1_empcod_Visible ;
   private int edtavEmpresa_abm_1_paicod_Visible ;
   private int gxdynajaxindex ;
   private int GXv_int16[] ;
   private int A3CliCod ;
   private int AV163GXV35 ;
   private int idxLst ;
   private long AV107oldEmpCUIT ;
   private java.math.BigDecimal AV114oldEmpFracVacAnt ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private String wcpOAV76TrnMode ;
   private String Combo_empresa_abm_1_emposocod_Selectedvalue_get ;
   private String Combo_empresa_abm_1_loccod_Selectedvalue_get ;
   private String Combo_empresa_abm_1_loccod_Ddointernalname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV76TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV161Pgmname ;
   private String GXKey ;
   private String GXCCtlgxBlob ;
   private String Dvpanel_unnamedtable4_Width ;
   private String Dvpanel_unnamedtable4_Cls ;
   private String Dvpanel_unnamedtable4_Title ;
   private String Dvpanel_unnamedtable4_Iconposition ;
   private String Combo_empresa_abm_1_loccod_Cls ;
   private String Combo_empresa_abm_1_loccod_Selectedvalue_set ;
   private String Combo_empresa_abm_1_emposocod_Cls ;
   private String Combo_empresa_abm_1_emposocod_Selectedvalue_set ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_unnamedtable2_Width ;
   private String Dvpanel_unnamedtable2_Cls ;
   private String Dvpanel_unnamedtable2_Title ;
   private String Dvpanel_unnamedtable2_Iconposition ;
   private String Dvpanel_unnamedtable3_Width ;
   private String Dvpanel_unnamedtable3_Cls ;
   private String Dvpanel_unnamedtable3_Title ;
   private String Dvpanel_unnamedtable3_Iconposition ;
   private String A3limguploaderlogo_Buttonclass ;
   private String A3limguploaderlogo_Button_caption ;
   private String A3limguploaderlogo_Buttonid ;
   private String A3limguploaderlogo_Class_img ;
   private String A3limguploaderlogo_Id_img ;
   private String A3limguploaderlogo_Src_default ;
   private String A3limguploaderlogo_Observer ;
   private String A3limguploaderlogo_Mode ;
   private String A3limguploaderlogo_Photo_name_id ;
   private String A3limguploaderlogo_Inputfileid ;
   private String A3limguploaderfirma_Buttonclass ;
   private String A3limguploaderfirma_Button_caption ;
   private String A3limguploaderfirma_Buttonid ;
   private String A3limguploaderfirma_Class_img ;
   private String A3limguploaderfirma_Id_img ;
   private String A3limguploaderfirma_Src_default ;
   private String A3limguploaderfirma_Observer ;
   private String A3limguploaderfirma_Mode ;
   private String A3limguploaderfirma_Photo_name_id ;
   private String A3limguploaderfirma_Inputfileid ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String ClassString ;
   private String imgavWelcomemessage_foto_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String edtavEmpresa_abm_1_empnom_Internalname ;
   private String edtavEmpresa_abm_1_empnom_Jsonclick ;
   private String edtavEmpresa_abm_1_empcuit_Internalname ;
   private String edtavEmpresa_abm_1_empcuit_Jsonclick ;
   private String Dvpanel_unnamedtable4_Internalname ;
   private String divUnnamedtable4_Internalname ;
   private String divEmpresa_abm_1_empmodtra_cell_Internalname ;
   private String divEmpresa_abm_1_empmodtra_cell_Class ;
   private String divTablesplittedempresa_abm_1_loccod_Internalname ;
   private String lblTextblockcombo_empresa_abm_1_loccod_Internalname ;
   private String lblTextblockcombo_empresa_abm_1_loccod_Jsonclick ;
   private String Combo_empresa_abm_1_loccod_Caption ;
   private String Combo_empresa_abm_1_loccod_Internalname ;
   private String edtavEmpresa_abm_1_empdir_Internalname ;
   private String edtavEmpresa_abm_1_empdir_Jsonclick ;
   private String edtavEmpresa_abm_1_emptel_Internalname ;
   private String edtavEmpresa_abm_1_emptel_Jsonclick ;
   private String edtavEmpresa_abm_1_empantiguedad_Internalname ;
   private String edtavEmpresa_abm_1_empantiguedad_Jsonclick ;
   private String edtavEmpresa_abm_1_emppresentismo_Internalname ;
   private String edtavEmpresa_abm_1_emppresentismo_Jsonclick ;
   private String edtavEmpresa_abm_1_empguaredadmin_Internalname ;
   private String edtavEmpresa_abm_1_empguaredadmin_Jsonclick ;
   private String edtavEmpresa_abm_1_empguaredadmax_Internalname ;
   private String edtavEmpresa_abm_1_empguaredadmax_Jsonclick ;
   private String divTablesplittedempresa_abm_1_emposocod_Internalname ;
   private String lblTextblockcombo_empresa_abm_1_emposocod_Internalname ;
   private String lblTextblockcombo_empresa_abm_1_emposocod_Jsonclick ;
   private String Combo_empresa_abm_1_emposocod_Caption ;
   private String Combo_empresa_abm_1_emposocod_Internalname ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String edtavEmpresa_abm_1_empmeshspext_Internalname ;
   private String edtavEmpresa_abm_1_empmeshspext_Jsonclick ;
   private String Dvpanel_unnamedtable3_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String edtavEmpresa_abm_1_empfracvacant_Internalname ;
   private String edtavEmpresa_abm_1_empfracvacant_Jsonclick ;
   private String edtavEmpresa_abm_1_empvacdismax_Internalname ;
   private String edtavEmpresa_abm_1_empvacdismax_Jsonclick ;
   private String A3limguploaderlogo_Internalname ;
   private String A3limguploaderfirma_Internalname ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String edtavInputfilelogo_Internalname ;
   private String edtavInputfilelogo_Filetype ;
   private String edtavInputfilelogo_Contenttype ;
   private String edtavInputfilelogo_Parameters ;
   private String edtavInputfilelogo_Jsonclick ;
   private String edtavInputfilefirma_Internalname ;
   private String edtavInputfilefirma_Filetype ;
   private String edtavInputfilefirma_Contenttype ;
   private String edtavInputfilefirma_Parameters ;
   private String edtavInputfilefirma_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavFotodir_Internalname ;
   private String edtavFotonamelogo_Internalname ;
   private String edtavFotonamefirma_Internalname ;
   private String edtavEmpresa_abm_1_empvacexptie_Internalname ;
   private String edtavEmpresa_abm_1_empvacexptie_Jsonclick ;
   private String edtavEmpresa_abm_1_clicod_Internalname ;
   private String edtavEmpresa_abm_1_clicod_Jsonclick ;
   private String edtavEmpresa_abm_1_empcod_Internalname ;
   private String edtavEmpresa_abm_1_empcod_Jsonclick ;
   private String edtavEmpresa_abm_1_paicod_Internalname ;
   private String edtavEmpresa_abm_1_paicod_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXv_char4[] ;
   private String A5OsoCod ;
   private String GXt_char9 ;
   private String GXt_char8 ;
   private String GXv_char20[] ;
   private String AV111LocaZona ;
   private String GXv_char21[] ;
   private String sStyleString ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV5CheckRequiredFieldsResult ;
   private boolean AV82vinoDeClick ;
   private boolean Dvpanel_unnamedtable4_Autowidth ;
   private boolean Dvpanel_unnamedtable4_Autoheight ;
   private boolean Dvpanel_unnamedtable4_Collapsible ;
   private boolean Dvpanel_unnamedtable4_Collapsed ;
   private boolean Dvpanel_unnamedtable4_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable4_Autoscroll ;
   private boolean Combo_empresa_abm_1_loccod_Enabled ;
   private boolean Combo_empresa_abm_1_loccod_Emptyitem ;
   private boolean Combo_empresa_abm_1_emposocod_Enabled ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean Dvpanel_unnamedtable2_Autowidth ;
   private boolean Dvpanel_unnamedtable2_Autoheight ;
   private boolean Dvpanel_unnamedtable2_Collapsible ;
   private boolean Dvpanel_unnamedtable2_Collapsed ;
   private boolean Dvpanel_unnamedtable2_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable2_Autoscroll ;
   private boolean Dvpanel_unnamedtable3_Autowidth ;
   private boolean Dvpanel_unnamedtable3_Autoheight ;
   private boolean Dvpanel_unnamedtable3_Collapsible ;
   private boolean Dvpanel_unnamedtable3_Collapsed ;
   private boolean Dvpanel_unnamedtable3_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable3_Autoscroll ;
   private boolean wbLoad ;
   private boolean AV100WelcomeMessage_Foto_IsBlob ;
   private boolean AV101WelcomeMessage_NoMostrarMas ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV63LoadSuccess ;
   private boolean AV96MenuBienveVisible ;
   private boolean GXv_boolean7[] ;
   private String AV94MenuBienveTexto ;
   private String AV99textoNoMostrara ;
   private String AV119inputFileLogo ;
   private String AV120inputFileFirma ;
   private String wcpOAV85MenuOpcCod ;
   private String AV85MenuOpcCod ;
   private String AV98oldEmpLogoNom ;
   private String AV97oldEmpFirmaNom ;
   private String AV103oldEmpDir ;
   private String AV106oldEmpNom ;
   private String A286LocNom ;
   private String AV159Welcomemessage_foto_GXI ;
   private String AV34fotoDir ;
   private String AV38fotoNameLogo ;
   private String AV37fotoNameFirma ;
   private String AV93MenuBienveImgURL ;
   private String AV95MenuBienveTitulo ;
   private String AV15destinationDir ;
   private String AV92error ;
   private String A555OsoSiglaYDesc ;
   private String AV122Texto ;
   private String AV102bucket_name ;
   private String AV86URL ;
   private String AV100WelcomeMessage_Foto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable4 ;
   private com.genexus.webpanels.GXUserControl ucCombo_empresa_abm_1_loccod ;
   private com.genexus.webpanels.GXUserControl ucCombo_empresa_abm_1_emposocod ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable3 ;
   private com.genexus.webpanels.GXUserControl ucA3limguploaderlogo ;
   private com.genexus.webpanels.GXUserControl ucA3limguploaderfirma ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private ICheckbox chkavEmpresa_abm_1_empmodempl ;
   private ICheckbox chkavEmpresa_abm_1_empmodauto ;
   private HTMLChoice cmbavEmpresa_abm_1_empmodtra ;
   private HTMLChoice dynavEmpresa_abm_1_actcodigo ;
   private HTMLChoice dynavEmpresa_abm_1_empcondicod ;
   private HTMLChoice dynavEmpresa_abm_1_empzoncod ;
   private HTMLChoice dynavEmpresa_abm_1_tipemplecod ;
   private HTMLChoice dynavEmpresa_abm_1_provcod ;
   private HTMLChoice dynavEmpresa_abm_1_empactcomercial ;
   private HTMLChoice dynavEmpresa_abm_1_artsec ;
   private ICheckbox chkavEmpresa_abm_1_empliqgan ;
   private HTMLChoice cmbavEmpresa_abm_1_emppromdesde ;
   private HTMLChoice cmbavEmpresa_abm_1_empdiahspext ;
   private HTMLChoice cmbavEmpresa_abm_1_emppervacdes ;
   private HTMLChoice cmbavEmpresa_abm_1_emppervachas ;
   private ICheckbox chkavEmpresa_abm_1_empliqfer ;
   private ICheckbox chkavEmpresa_abm_1_empliqferjor ;
   private ICheckbox chkavEmpresa_abm_1_empvacexplim ;
   private HTMLChoice cmbavEmpresa_abm_1_emptipoexp ;
   private IDataStoreProvider pr_default ;
   private short[] H00KD2_A1151ARTSec ;
   private String[] H00KD2_A1152ARTNom ;
   private String[] H00KD3_A903ActComCodigo ;
   private String[] H00KD3_A904ActComDescripcion ;
   private String[] H00KD4_A45TipEmpleCod ;
   private String[] H00KD4_A339TipEmpleDescri ;
   private String[] H00KD5_A20ZonCod ;
   private String[] H00KD5_A342ZonDescrip ;
   private short[] H00KD6_A17CondiCodigo ;
   private String[] H00KD6_A144CondiDescri ;
   private String[] H00KD7_A43ActCodigo ;
   private String[] H00KD7_A108ActDescrip ;
   private short[] H00KD8_A47ProvCod ;
   private String[] H00KD8_A322ProvNom ;
   private short[] H00KD8_A46PaiCod ;
   private short[] H00KD9_A1151ARTSec ;
   private String[] H00KD9_A1152ARTNom ;
   private String[] H00KD10_A903ActComCodigo ;
   private String[] H00KD10_A904ActComDescripcion ;
   private String[] H00KD11_A45TipEmpleCod ;
   private String[] H00KD11_A339TipEmpleDescri ;
   private String[] H00KD12_A20ZonCod ;
   private String[] H00KD12_A342ZonDescrip ;
   private short[] H00KD13_A17CondiCodigo ;
   private String[] H00KD13_A144CondiDescri ;
   private String[] H00KD14_A43ActCodigo ;
   private String[] H00KD14_A108ActDescrip ;
   private int[] H00KD15_A3CliCod ;
   private String[] H00KD15_A555OsoSiglaYDesc ;
   private String[] H00KD15_A5OsoCod ;
   private short[] H00KD16_A47ProvCod ;
   private short[] H00KD16_A46PaiCod ;
   private short[] H00KD16_A48LocCod ;
   private String[] H00KD16_A286LocNom ;
   private String[] H00KD17_A43ActCodigo ;
   private String[] H00KD17_A108ActDescrip ;
   private short[] H00KD18_A17CondiCodigo ;
   private String[] H00KD18_A144CondiDescri ;
   private String[] H00KD19_A20ZonCod ;
   private String[] H00KD19_A342ZonDescrip ;
   private String[] H00KD20_A45TipEmpleCod ;
   private String[] H00KD20_A339TipEmpleDescri ;
   private String[] H00KD21_A903ActComCodigo ;
   private String[] H00KD21_A904ActComDescripcion ;
   private short[] H00KD22_A1151ARTSec ;
   private String[] H00KD22_A1152ARTNom ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV112Empresa_abm_1_LocCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV87Empresa_abm_1_EmpOsoCod_Data ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV65Messages ;
   private com.genexus.SdtMessages_Message AV64Message ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV80Combo_DataItem ;
   private web.SdtEmpresa_abm_1 AV19Empresa_abm_1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV113DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
   private web.Sdtparm_iniPerCCLic AV121parm_iniPerCCLic ;
}

final  class empresa_cabecera__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00KD2", "SELECT ARTSec, ARTNom FROM ART ORDER BY ARTNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD3", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD4", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador ORDER BY TipEmpleDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD5", "SELECT ZonCod, ZonDescrip FROM Zona ORDER BY ZonDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD6", "SELECT CondiCodigo, CondiDescri FROM CondicionAFIP ORDER BY CondiDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD7", "SELECT ActCodigo, ActDescrip FROM Actividad ORDER BY ActDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD8", "SELECT ProvCod, ProvNom, PaiCod FROM Provincia WHERE PaiCod = ? ORDER BY ProvNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD9", "SELECT ARTSec, ARTNom FROM ART ORDER BY ARTNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD10", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD11", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador ORDER BY TipEmpleDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD12", "SELECT ZonCod, ZonDescrip FROM Zona ORDER BY ZonDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD13", "SELECT CondiCodigo, CondiDescri FROM CondicionAFIP ORDER BY CondiDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD14", "SELECT ActCodigo, ActDescrip FROM Actividad ORDER BY ActDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD15", "SELECT CliCod, OsoSiglaYDesc, OsoCod FROM ObraSocial WHERE CliCod = ? ORDER BY CliCod, OsoCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD16", "SELECT ProvCod, PaiCod, LocCod, LocNom FROM Localidad WHERE PaiCod = ? and ProvCod = ? ORDER BY PaiCod, ProvCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD17", "SELECT ActCodigo, ActDescrip FROM Actividad ORDER BY ActDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD18", "SELECT CondiCodigo, CondiDescri FROM CondicionAFIP ORDER BY CondiDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD19", "SELECT ZonCod, ZonDescrip FROM Zona ORDER BY ZonDescrip ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD20", "SELECT TipEmpleCod, TipEmpleDescri FROM TipoEmpleador ORDER BY TipEmpleDescri ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD21", "SELECT ActComCodigo, ActComDescripcion FROM actividadcomercial ORDER BY ActComDescripcion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00KD22", "SELECT ARTSec, ARTNom FROM ART ORDER BY ARTNom ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

