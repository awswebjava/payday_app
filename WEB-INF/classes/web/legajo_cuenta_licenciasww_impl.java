package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_cuenta_licenciasww_impl extends GXDataArea
{
   public legajo_cuenta_licenciasww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_cuenta_licenciasww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_cuenta_licenciasww_impl.class ));
   }

   public legajo_cuenta_licenciasww_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbLegCuenLicTpo = new HTMLChoice();
      chkLegCuLIncluir = UIFactory.getCheckbox(this);
      chkLegCuLRecalc = UIFactory.getCheckbox(this);
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV36MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36MenuOpcCod", AV36MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36MenuOpcCod, ""))));
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_108 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_108"))) ;
      nGXsfl_108_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_108_idx"))) ;
      sGXsfl_108_idx = httpContext.GetPar( "sGXsfl_108_idx") ;
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
      AV99ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV7ColumnsSelector);
      AV112Pgmname = httpContext.GetPar( "Pgmname") ;
      AV36MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV25GridState);
      AV55TFLegCuenAnio = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuenAnio"))) ;
      AV56TFLegCuenAnio_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuenAnio_To"))) ;
      AV81TFLegIdNomApe = httpContext.GetPar( "TFLegIdNomApe") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV82TFLegIdNomApe_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV65TFLegCuenLicTpo_Sels);
      AV49TFLegCueAntAbr = httpContext.GetPar( "TFLegCueAntAbr") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV50TFLegCueAntAbr_Sels);
      AV57TFLegCuenDiasCorres = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuenDiasCorres"))) ;
      AV58TFLegCuenDiasCorres_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuenDiasCorres_To"))) ;
      AV70TFLegCuLiPAnt = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPAnt"))) ;
      AV71TFLegCuLiPAnt_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPAnt_To"))) ;
      AV67TFLegCuLActVen = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLActVen"))) ;
      AV68TFLegCuLActVen_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLActVen_To"))) ;
      AV78TFLegCuLiPVen = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPVen"))) ;
      AV79TFLegCuLiPVen_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPVen_To"))) ;
      AV74TFLegCuLiPCur = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPCur"))) ;
      AV75TFLegCuLiPCur_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPCur_To"))) ;
      AV72TFLegCuLiPApr = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPApr"))) ;
      AV73TFLegCuLiPApr_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPApr_To"))) ;
      AV59TFLegCuenDiasGoz = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuenDiasGoz"))) ;
      AV60TFLegCuenDiasGoz_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuenDiasGoz_To"))) ;
      AV76TFLegCuLiPSaldo = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPSaldo"))) ;
      AV77TFLegCuLiPSaldo_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegCuLiPSaldo_To"))) ;
      AV38OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV40OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV31IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV21EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV99ManageFiltersExecutionStep, AV7ColumnsSelector, AV112Pgmname, AV36MenuOpcCod, AV25GridState, AV55TFLegCuenAnio, AV56TFLegCuenAnio_To, AV81TFLegIdNomApe, AV82TFLegIdNomApe_Sels, AV65TFLegCuenLicTpo_Sels, AV49TFLegCueAntAbr, AV50TFLegCueAntAbr_Sels, AV57TFLegCuenDiasCorres, AV58TFLegCuenDiasCorres_To, AV70TFLegCuLiPAnt, AV71TFLegCuLiPAnt_To, AV67TFLegCuLActVen, AV68TFLegCuLActVen_To, AV78TFLegCuLiPVen, AV79TFLegCuLiPVen_To, AV74TFLegCuLiPCur, AV75TFLegCuLiPCur_To, AV72TFLegCuLiPApr, AV73TFLegCuLiPApr_To, AV59TFLegCuenDiasGoz, AV60TFLegCuenDiasGoz_To, AV76TFLegCuLiPSaldo, AV77TFLegCuLiPSaldo_To, AV38OrderedBy, AV40OrderedDsc, AV6CliCod, AV31IsAuthorized_Update, AV21EmpCod, AV92WelcomeMessage_NoMostrarMas) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
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
      paOO2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startOO2( ) ;
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
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajo_cuenta_licenciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV36MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV112Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV31IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_108", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_108, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV7ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV7ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV97ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV97ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV23GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV24GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV22GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV99ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV112Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV112Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV36MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV25GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV25GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENANIO", GXutil.ltrim( localUtil.ntoc( AV55TFLegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENANIO_TO", GXutil.ltrim( localUtil.ntoc( AV56TFLegCuenAnio_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGIDNOMAPE", AV81TFLegIdNomApe);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGIDNOMAPE_SELS", AV82TFLegIdNomApe_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGIDNOMAPE_SELS", AV82TFLegIdNomApe_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGCUENLICTPO_SELS", AV65TFLegCuenLicTpo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGCUENLICTPO_SELS", AV65TFLegCuenLicTpo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUEANTABR", AV49TFLegCueAntAbr);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGCUEANTABR_SELS", AV50TFLegCueAntAbr_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGCUEANTABR_SELS", AV50TFLegCueAntAbr_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENDIASCORRES", GXutil.ltrim( localUtil.ntoc( AV57TFLegCuenDiasCorres, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENDIASCORRES_TO", GXutil.ltrim( localUtil.ntoc( AV58TFLegCuenDiasCorres_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPANT", GXutil.ltrim( localUtil.ntoc( AV70TFLegCuLiPAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPANT_TO", GXutil.ltrim( localUtil.ntoc( AV71TFLegCuLiPAnt_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULACTVEN", GXutil.ltrim( localUtil.ntoc( AV67TFLegCuLActVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULACTVEN_TO", GXutil.ltrim( localUtil.ntoc( AV68TFLegCuLActVen_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPVEN", GXutil.ltrim( localUtil.ntoc( AV78TFLegCuLiPVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPVEN_TO", GXutil.ltrim( localUtil.ntoc( AV79TFLegCuLiPVen_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPCUR", GXutil.ltrim( localUtil.ntoc( AV74TFLegCuLiPCur, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPCUR_TO", GXutil.ltrim( localUtil.ntoc( AV75TFLegCuLiPCur_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPAPR", GXutil.ltrim( localUtil.ntoc( AV72TFLegCuLiPApr, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPAPR_TO", GXutil.ltrim( localUtil.ntoc( AV73TFLegCuLiPApr_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENDIASGOZ", GXutil.ltrim( localUtil.ntoc( AV59TFLegCuenDiasGoz, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENDIASGOZ_TO", GXutil.ltrim( localUtil.ntoc( AV60TFLegCuenDiasGoz_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPSALDO", GXutil.ltrim( localUtil.ntoc( AV76TFLegCuLiPSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCULIPSALDO_TO", GXutil.ltrim( localUtil.ntoc( AV77TFLegCuLiPSaldo_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV38OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV40OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV31IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV31IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUEANTTEXTO", A2301LegCueAntTexto);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCULLOGDIS", A2329LegCuLLogDis);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGIDNOMAPE_SELSJSON", AV83TFLegIdNomApe_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENLICTPO_SELSJSON", AV66TFLegCuenLicTpo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUEANTABR_SELSJSON", AV51TFLegCueAntAbr_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV21EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Observer", GXutil.rtrim( Buttonexport1_a3lexport_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Boton_clon_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_clon_id));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONEXPORT1_A3LEXPORT_Boton_orig_id", GXutil.rtrim( Buttonexport1_a3lexport_Boton_orig_id));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icontype", GXutil.rtrim( Ddo_gridcolumnsselector_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Icon", GXutil.rtrim( Ddo_gridcolumnsselector_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Caption", GXutil.rtrim( Ddo_gridcolumnsselector_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Tooltip", GXutil.rtrim( Ddo_gridcolumnsselector_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Cls", GXutil.rtrim( Ddo_gridcolumnsselector_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype", GXutil.rtrim( Ddo_gridcolumnsselector_Dropdownoptionstype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname", GXutil.rtrim( Ddo_gridcolumnsselector_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_Observer", GXutil.rtrim( Buttonfilter1_a3lfilter_Observer));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_A3l_filter_id", GXutil.rtrim( Buttonfilter1_a3lfilter_A3l_filter_id));
      web.GxWebStd.gx_hidden_field( httpContext, "BUTTONFILTER1_A3LFILTER_Filter_orig", GXutil.rtrim( Buttonfilter1_a3lfilter_Filter_orig));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Fixable", GXutil.rtrim( Ddo_grid_Fixable));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hascolumnsselector", GXutil.booltostr( Grid_empowerer_Hascolumnsselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues", GXutil.rtrim( Ddo_gridcolumnsselector_Columnsselectorvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         weOO2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtOO2( ) ;
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
      return formatLink("web.legajo_cuenta_licenciasww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV36MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "legajo_cuenta_licenciasWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " legajo_cuenta_licencias", "") ;
   }

   public void wbOO0( )
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
         wb_table1_9_OO2( true) ;
      }
      else
      {
         wb_table1_9_OO2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_OO2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 141,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninicializar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Inicializar periodos", ""), bttBtninicializar_Jsonclick, 5, httpContext.getMessage( "Inicializar periodos", ""), "", StyleString, ClassString, bttBtninicializar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINICIALIZAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_cuenta_licenciasWW.htm");
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 108 )
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
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startOO2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " legajo_cuenta_licencias", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupOO0( ) ;
   }

   public void wsOO2( )
   {
      startOO2( ) ;
      evtOO2( ) ;
   }

   public void evtOO2( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINICIALIZAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Doinicializar' */
                           e16OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e17OO2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18OO2 ();
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
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_108_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1082( ) ;
                           A2266LegCuenAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
                           cmbLegCuenLicTpo.setName( cmbLegCuenLicTpo.getInternalname() );
                           cmbLegCuenLicTpo.setValue( httpContext.cgiGet( cmbLegCuenLicTpo.getInternalname()) );
                           A2243LegCuenLicTpo = httpContext.cgiGet( cmbLegCuenLicTpo.getInternalname()) ;
                           A2321LegCuLIncluir = GXutil.strtobool( httpContext.cgiGet( chkLegCuLIncluir.getInternalname())) ;
                           A2322LegCuLRecalc = GXutil.strtobool( httpContext.cgiGet( chkLegCuLRecalc.getInternalname())) ;
                           A2328LegCueAntAbr = httpContext.cgiGet( edtLegCueAntAbr_Internalname) ;
                           A2244LegCuenLicPerIni = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegCuenLicPerIni_Internalname), 0)) ;
                           A2245LegCuenLicPerFin = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegCuenLicPerFin_Internalname), 0)) ;
                           A2247LegCuenDiasCorres = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasCorres_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2303LegCuLiPAnt = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2315LegCuLActVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLActVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2304LegCuLiPVen = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPVen_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2302LegCuLiPCur = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPCur_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2306LegCuLiPApr = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPApr_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2248LegCuenDiasGoz = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuenDiasGoz_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A2305LegCuLiPSaldo = (short)(localUtil.ctol( httpContext.cgiGet( edtLegCuLiPSaldo_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           AV88Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV88Update);
                           AV19Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV19Display);
                           AV10Consumido = httpContext.cgiGet( edtavConsumido_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavConsumido_Internalname, AV10Consumido);
                           AV90VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV90VerSVG);
                           AV37ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV37ModificarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e19OO2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e20OO2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21OO2 ();
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

   public void weOO2( )
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

   public void paOO2( )
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

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1082( ) ;
      while ( nGXsfl_108_idx <= nRC_GXsfl_108 )
      {
         sendrow_1082( ) ;
         nGXsfl_108_idx = ((subGrid_Islastpage==1)&&(nGXsfl_108_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_108_idx+1) ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV99ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV7ColumnsSelector ,
                                 String AV112Pgmname ,
                                 String AV36MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV25GridState ,
                                 short AV55TFLegCuenAnio ,
                                 short AV56TFLegCuenAnio_To ,
                                 String AV81TFLegIdNomApe ,
                                 GXSimpleCollection<String> AV82TFLegIdNomApe_Sels ,
                                 GXSimpleCollection<String> AV65TFLegCuenLicTpo_Sels ,
                                 String AV49TFLegCueAntAbr ,
                                 GXSimpleCollection<String> AV50TFLegCueAntAbr_Sels ,
                                 short AV57TFLegCuenDiasCorres ,
                                 short AV58TFLegCuenDiasCorres_To ,
                                 short AV70TFLegCuLiPAnt ,
                                 short AV71TFLegCuLiPAnt_To ,
                                 short AV67TFLegCuLActVen ,
                                 short AV68TFLegCuLActVen_To ,
                                 short AV78TFLegCuLiPVen ,
                                 short AV79TFLegCuLiPVen_To ,
                                 short AV74TFLegCuLiPCur ,
                                 short AV75TFLegCuLiPCur_To ,
                                 short AV72TFLegCuLiPApr ,
                                 short AV73TFLegCuLiPApr_To ,
                                 short AV59TFLegCuenDiasGoz ,
                                 short AV60TFLegCuenDiasGoz_To ,
                                 short AV76TFLegCuLiPSaldo ,
                                 short AV77TFLegCuLiPSaldo_To ,
                                 short AV38OrderedBy ,
                                 boolean AV40OrderedDsc ,
                                 int AV6CliCod ,
                                 boolean AV31IsAuthorized_Update ,
                                 short AV21EmpCod ,
                                 boolean AV92WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e20OO2 ();
      GRID_nCurrentRecord = 0 ;
      rfOO2( ) ;
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
      AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV92WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92WelcomeMessage_NoMostrarMas", AV92WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfOO2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV112Pgmname = "legajo_cuenta_licenciasWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavConsumido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConsumido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumido_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rfOO2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e20OO2 ();
      nGXsfl_108_idx = 1 ;
      sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1082( ) ;
      bGXsfl_108_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
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
         subsflControlProps_1082( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A250LegIdNomApe ,
                                              AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                              A2243LegCuenLicTpo ,
                                              AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                              A2328LegCueAntAbr ,
                                              AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                              Short.valueOf(AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio) ,
                                              Short.valueOf(AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) ,
                                              Integer.valueOf(AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels.size()) ,
                                              AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                              Integer.valueOf(AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels.size()) ,
                                              Integer.valueOf(AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels.size()) ,
                                              AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                              Short.valueOf(AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) ,
                                              Short.valueOf(AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) ,
                                              Short.valueOf(AV122Legajo_cuenta_licenciaswwds_10_tflegculipant) ,
                                              Short.valueOf(AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to) ,
                                              Short.valueOf(AV124Legajo_cuenta_licenciaswwds_12_tflegculactven) ,
                                              Short.valueOf(AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to) ,
                                              Short.valueOf(AV126Legajo_cuenta_licenciaswwds_14_tflegculipven) ,
                                              Short.valueOf(AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to) ,
                                              Short.valueOf(AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur) ,
                                              Short.valueOf(AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) ,
                                              Short.valueOf(AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr) ,
                                              Short.valueOf(AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) ,
                                              Short.valueOf(AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) ,
                                              Short.valueOf(AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) ,
                                              Short.valueOf(AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) ,
                                              Short.valueOf(AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) ,
                                              Short.valueOf(A2266LegCuenAnio) ,
                                              Short.valueOf(A2247LegCuenDiasCorres) ,
                                              Short.valueOf(A2303LegCuLiPAnt) ,
                                              Short.valueOf(A2315LegCuLActVen) ,
                                              Short.valueOf(A2304LegCuLiPVen) ,
                                              Short.valueOf(A2302LegCuLiPCur) ,
                                              Short.valueOf(A2306LegCuLiPApr) ,
                                              Short.valueOf(A2248LegCuenDiasGoz) ,
                                              Short.valueOf(A2305LegCuLiPSaldo) ,
                                              Short.valueOf(AV38OrderedBy) ,
                                              Boolean.valueOf(AV40OrderedDsc) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Short.valueOf(AV21EmpCod) ,
                                              Integer.valueOf(AV6CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.INT
                                              }
         });
         lV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape), "%", "") ;
         lV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = GXutil.concat( GXutil.rtrim( AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr), "%", "") ;
         /* Using cursor H00OO2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV6CliCod), Short.valueOf(AV21EmpCod), Short.valueOf(AV21EmpCod), Short.valueOf(AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio), Short.valueOf(AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to), lV115Legajo_cuenta_licenciaswwds_3_tflegidnomape, lV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr, Short.valueOf(AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres), Short.valueOf(AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to), Short.valueOf(AV122Legajo_cuenta_licenciaswwds_10_tflegculipant), Short.valueOf(AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to), Short.valueOf(AV124Legajo_cuenta_licenciaswwds_12_tflegculactven), Short.valueOf(AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to), Short.valueOf(AV126Legajo_cuenta_licenciaswwds_14_tflegculipven), Short.valueOf(AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to), Short.valueOf(AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur), Short.valueOf(AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to), Short.valueOf(AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr), Short.valueOf(AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to), Short.valueOf(AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz), Short.valueOf(AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to), Short.valueOf(AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo), Short.valueOf(AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2301LegCueAntTexto = H00OO2_A2301LegCueAntTexto[0] ;
            A2329LegCuLLogDis = H00OO2_A2329LegCuLLogDis[0] ;
            A2305LegCuLiPSaldo = H00OO2_A2305LegCuLiPSaldo[0] ;
            A2248LegCuenDiasGoz = H00OO2_A2248LegCuenDiasGoz[0] ;
            A2306LegCuLiPApr = H00OO2_A2306LegCuLiPApr[0] ;
            A2302LegCuLiPCur = H00OO2_A2302LegCuLiPCur[0] ;
            A2304LegCuLiPVen = H00OO2_A2304LegCuLiPVen[0] ;
            A2315LegCuLActVen = H00OO2_A2315LegCuLActVen[0] ;
            A2303LegCuLiPAnt = H00OO2_A2303LegCuLiPAnt[0] ;
            A2247LegCuenDiasCorres = H00OO2_A2247LegCuenDiasCorres[0] ;
            A2245LegCuenLicPerFin = H00OO2_A2245LegCuenLicPerFin[0] ;
            A2244LegCuenLicPerIni = H00OO2_A2244LegCuenLicPerIni[0] ;
            A2328LegCueAntAbr = H00OO2_A2328LegCueAntAbr[0] ;
            A2322LegCuLRecalc = H00OO2_A2322LegCuLRecalc[0] ;
            A2321LegCuLIncluir = H00OO2_A2321LegCuLIncluir[0] ;
            A2243LegCuenLicTpo = H00OO2_A2243LegCuenLicTpo[0] ;
            A250LegIdNomApe = H00OO2_A250LegIdNomApe[0] ;
            A6LegNumero = H00OO2_A6LegNumero[0] ;
            A1EmpCod = H00OO2_A1EmpCod[0] ;
            A3CliCod = H00OO2_A3CliCod[0] ;
            A2266LegCuenAnio = H00OO2_A2266LegCuenAnio[0] ;
            A250LegIdNomApe = H00OO2_A250LegIdNomApe[0] ;
            e21OO2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(108) ;
         wbOO0( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesOO2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV112Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV112Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV36MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV31IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV31IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV21EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
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
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                           A2243LegCuenLicTpo ,
                                           AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                           A2328LegCueAntAbr ,
                                           AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                           Short.valueOf(AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio) ,
                                           Short.valueOf(AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) ,
                                           Integer.valueOf(AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels.size()) ,
                                           AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                           Integer.valueOf(AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels.size()) ,
                                           Integer.valueOf(AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels.size()) ,
                                           AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                           Short.valueOf(AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) ,
                                           Short.valueOf(AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) ,
                                           Short.valueOf(AV122Legajo_cuenta_licenciaswwds_10_tflegculipant) ,
                                           Short.valueOf(AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to) ,
                                           Short.valueOf(AV124Legajo_cuenta_licenciaswwds_12_tflegculactven) ,
                                           Short.valueOf(AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to) ,
                                           Short.valueOf(AV126Legajo_cuenta_licenciaswwds_14_tflegculipven) ,
                                           Short.valueOf(AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to) ,
                                           Short.valueOf(AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur) ,
                                           Short.valueOf(AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) ,
                                           Short.valueOf(AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr) ,
                                           Short.valueOf(AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) ,
                                           Short.valueOf(AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) ,
                                           Short.valueOf(AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) ,
                                           Short.valueOf(AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) ,
                                           Short.valueOf(AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           Short.valueOf(A2247LegCuenDiasCorres) ,
                                           Short.valueOf(A2303LegCuLiPAnt) ,
                                           Short.valueOf(A2315LegCuLActVen) ,
                                           Short.valueOf(A2304LegCuLiPVen) ,
                                           Short.valueOf(A2302LegCuLiPCur) ,
                                           Short.valueOf(A2306LegCuLiPApr) ,
                                           Short.valueOf(A2248LegCuenDiasGoz) ,
                                           Short.valueOf(A2305LegCuLiPSaldo) ,
                                           Short.valueOf(AV38OrderedBy) ,
                                           Boolean.valueOf(AV40OrderedDsc) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV21EmpCod) ,
                                           Integer.valueOf(AV6CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape), "%", "") ;
      lV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = GXutil.concat( GXutil.rtrim( AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr), "%", "") ;
      /* Using cursor H00OO3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV6CliCod), Short.valueOf(AV21EmpCod), Short.valueOf(AV21EmpCod), Short.valueOf(AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio), Short.valueOf(AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to), lV115Legajo_cuenta_licenciaswwds_3_tflegidnomape, lV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr, Short.valueOf(AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres), Short.valueOf(AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to), Short.valueOf(AV122Legajo_cuenta_licenciaswwds_10_tflegculipant), Short.valueOf(AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to), Short.valueOf(AV124Legajo_cuenta_licenciaswwds_12_tflegculactven), Short.valueOf(AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to), Short.valueOf(AV126Legajo_cuenta_licenciaswwds_14_tflegculipven), Short.valueOf(AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to), Short.valueOf(AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur), Short.valueOf(AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to), Short.valueOf(AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr), Short.valueOf(AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to), Short.valueOf(AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz), Short.valueOf(AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to), Short.valueOf(AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo), Short.valueOf(AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to)});
      GRID_nRecordCount = H00OO3_AGRID_nRecordCount[0] ;
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
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV99ManageFiltersExecutionStep, AV7ColumnsSelector, AV112Pgmname, AV36MenuOpcCod, AV25GridState, AV55TFLegCuenAnio, AV56TFLegCuenAnio_To, AV81TFLegIdNomApe, AV82TFLegIdNomApe_Sels, AV65TFLegCuenLicTpo_Sels, AV49TFLegCueAntAbr, AV50TFLegCueAntAbr_Sels, AV57TFLegCuenDiasCorres, AV58TFLegCuenDiasCorres_To, AV70TFLegCuLiPAnt, AV71TFLegCuLiPAnt_To, AV67TFLegCuLActVen, AV68TFLegCuLActVen_To, AV78TFLegCuLiPVen, AV79TFLegCuLiPVen_To, AV74TFLegCuLiPCur, AV75TFLegCuLiPCur_To, AV72TFLegCuLiPApr, AV73TFLegCuLiPApr_To, AV59TFLegCuenDiasGoz, AV60TFLegCuenDiasGoz_To, AV76TFLegCuLiPSaldo, AV77TFLegCuLiPSaldo_To, AV38OrderedBy, AV40OrderedDsc, AV6CliCod, AV31IsAuthorized_Update, AV21EmpCod, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV99ManageFiltersExecutionStep, AV7ColumnsSelector, AV112Pgmname, AV36MenuOpcCod, AV25GridState, AV55TFLegCuenAnio, AV56TFLegCuenAnio_To, AV81TFLegIdNomApe, AV82TFLegIdNomApe_Sels, AV65TFLegCuenLicTpo_Sels, AV49TFLegCueAntAbr, AV50TFLegCueAntAbr_Sels, AV57TFLegCuenDiasCorres, AV58TFLegCuenDiasCorres_To, AV70TFLegCuLiPAnt, AV71TFLegCuLiPAnt_To, AV67TFLegCuLActVen, AV68TFLegCuLActVen_To, AV78TFLegCuLiPVen, AV79TFLegCuLiPVen_To, AV74TFLegCuLiPCur, AV75TFLegCuLiPCur_To, AV72TFLegCuLiPApr, AV73TFLegCuLiPApr_To, AV59TFLegCuenDiasGoz, AV60TFLegCuenDiasGoz_To, AV76TFLegCuLiPSaldo, AV77TFLegCuLiPSaldo_To, AV38OrderedBy, AV40OrderedDsc, AV6CliCod, AV31IsAuthorized_Update, AV21EmpCod, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV99ManageFiltersExecutionStep, AV7ColumnsSelector, AV112Pgmname, AV36MenuOpcCod, AV25GridState, AV55TFLegCuenAnio, AV56TFLegCuenAnio_To, AV81TFLegIdNomApe, AV82TFLegIdNomApe_Sels, AV65TFLegCuenLicTpo_Sels, AV49TFLegCueAntAbr, AV50TFLegCueAntAbr_Sels, AV57TFLegCuenDiasCorres, AV58TFLegCuenDiasCorres_To, AV70TFLegCuLiPAnt, AV71TFLegCuLiPAnt_To, AV67TFLegCuLActVen, AV68TFLegCuLActVen_To, AV78TFLegCuLiPVen, AV79TFLegCuLiPVen_To, AV74TFLegCuLiPCur, AV75TFLegCuLiPCur_To, AV72TFLegCuLiPApr, AV73TFLegCuLiPApr_To, AV59TFLegCuenDiasGoz, AV60TFLegCuenDiasGoz_To, AV76TFLegCuLiPSaldo, AV77TFLegCuLiPSaldo_To, AV38OrderedBy, AV40OrderedDsc, AV6CliCod, AV31IsAuthorized_Update, AV21EmpCod, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV99ManageFiltersExecutionStep, AV7ColumnsSelector, AV112Pgmname, AV36MenuOpcCod, AV25GridState, AV55TFLegCuenAnio, AV56TFLegCuenAnio_To, AV81TFLegIdNomApe, AV82TFLegIdNomApe_Sels, AV65TFLegCuenLicTpo_Sels, AV49TFLegCueAntAbr, AV50TFLegCueAntAbr_Sels, AV57TFLegCuenDiasCorres, AV58TFLegCuenDiasCorres_To, AV70TFLegCuLiPAnt, AV71TFLegCuLiPAnt_To, AV67TFLegCuLActVen, AV68TFLegCuLActVen_To, AV78TFLegCuLiPVen, AV79TFLegCuLiPVen_To, AV74TFLegCuLiPCur, AV75TFLegCuLiPCur_To, AV72TFLegCuLiPApr, AV73TFLegCuLiPApr_To, AV59TFLegCuenDiasGoz, AV60TFLegCuenDiasGoz_To, AV76TFLegCuLiPSaldo, AV77TFLegCuLiPSaldo_To, AV38OrderedBy, AV40OrderedDsc, AV6CliCod, AV31IsAuthorized_Update, AV21EmpCod, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV99ManageFiltersExecutionStep, AV7ColumnsSelector, AV112Pgmname, AV36MenuOpcCod, AV25GridState, AV55TFLegCuenAnio, AV56TFLegCuenAnio_To, AV81TFLegIdNomApe, AV82TFLegIdNomApe_Sels, AV65TFLegCuenLicTpo_Sels, AV49TFLegCueAntAbr, AV50TFLegCueAntAbr_Sels, AV57TFLegCuenDiasCorres, AV58TFLegCuenDiasCorres_To, AV70TFLegCuLiPAnt, AV71TFLegCuLiPAnt_To, AV67TFLegCuLActVen, AV68TFLegCuLActVen_To, AV78TFLegCuLiPVen, AV79TFLegCuLiPVen_To, AV74TFLegCuLiPCur, AV75TFLegCuLiPCur_To, AV72TFLegCuLiPApr, AV73TFLegCuLiPApr_To, AV59TFLegCuenDiasGoz, AV60TFLegCuenDiasGoz_To, AV76TFLegCuLiPSaldo, AV77TFLegCuLiPSaldo_To, AV38OrderedBy, AV40OrderedDsc, AV6CliCod, AV31IsAuthorized_Update, AV21EmpCod, AV92WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV112Pgmname = "legajo_cuenta_licenciasWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavConsumido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConsumido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumido_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupOO0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e19OO2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV7ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV97ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV23GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV24GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV22GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Buttonexport1_a3lexport_Observer = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Observer") ;
         Buttonexport1_a3lexport_Boton_clon_id = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Boton_clon_id") ;
         Buttonexport1_a3lexport_Boton_orig_id = httpContext.cgiGet( "BUTTONEXPORT1_A3LEXPORT_Boton_orig_id") ;
         Ddo_gridcolumnsselector_Icontype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icontype") ;
         Ddo_gridcolumnsselector_Icon = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Icon") ;
         Ddo_gridcolumnsselector_Caption = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Caption") ;
         Ddo_gridcolumnsselector_Tooltip = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Tooltip") ;
         Ddo_gridcolumnsselector_Cls = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Cls") ;
         Ddo_gridcolumnsselector_Dropdownoptionstype = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Dropdownoptionstype") ;
         Ddo_gridcolumnsselector_Gridinternalname = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Gridinternalname") ;
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Buttonfilter1_a3lfilter_Observer = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_Observer") ;
         Buttonfilter1_a3lfilter_A3l_filter_id = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_A3l_filter_id") ;
         Buttonfilter1_a3lfilter_Filter_orig = httpContext.cgiGet( "BUTTONFILTER1_A3LFILTER_Filter_orig") ;
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Fixable = httpContext.cgiGet( "DDO_GRID_Fixable") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Ddo_grid_Format = httpContext.cgiGet( "DDO_GRID_Format") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         Grid_empowerer_Hascolumnsselector = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hascolumnsselector")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_gridcolumnsselector_Columnsselectorvalues = httpContext.cgiGet( "DDO_GRIDCOLUMNSSELECTOR_Columnsselectorvalues") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV91WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92WelcomeMessage_NoMostrarMas", AV92WelcomeMessage_NoMostrarMas);
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
      e19OO2 ();
      if (returnInSub) return;
   }

   public void e19OO2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV36MenuOpcCod, "", "") ;
      GXt_int1 = AV21EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      legajo_cuenta_licenciasww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV21EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
      GXt_int3 = AV6CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      legajo_cuenta_licenciasww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV6CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV27HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " legajo_cuenta_licencias", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV38OrderedBy < 1 )
      {
         AV38OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char7[0] = AV32MenuBienveImgURL ;
      GXv_char8[0] = AV34MenuBienveTitulo ;
      GXv_char9[0] = AV33MenuBienveTexto ;
      GXv_boolean10[0] = AV35MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV36MenuOpcCod, GXv_char7, GXv_char8, GXv_char9, GXv_boolean10) ;
      legajo_cuenta_licenciasww_impl.this.AV32MenuBienveImgURL = GXv_char7[0] ;
      legajo_cuenta_licenciasww_impl.this.AV34MenuBienveTitulo = GXv_char8[0] ;
      legajo_cuenta_licenciasww_impl.this.AV33MenuBienveTexto = GXv_char9[0] ;
      legajo_cuenta_licenciasww_impl.this.AV35MenuBienveVisible = GXv_boolean10[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV35MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV35MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV34MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV33MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV91WelcomeMessage_Foto = AV32MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV91WelcomeMessage_Foto)==0) ? AV111Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV91WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV91WelcomeMessage_Foto), true);
         AV111Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV32MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV91WelcomeMessage_Foto)==0) ? AV111Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV91WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV91WelcomeMessage_Foto), true);
      }
      GXt_char11 = "" ;
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      GXv_char8[0] = GXt_char11 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char12, GXv_char8) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char11 = GXv_char8[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char11 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV108observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV108observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV108observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV108observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXv_char9[0] = AV42parmvalue ;
      new web.getparametro(remoteHandle, context).execute( AV6CliCod, new web.modotest_codigoparam(remoteHandle, context).executeUdp( ), GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.AV42parmvalue = GXv_char9[0] ;
      AV47testEs = GXutil.boolval( AV42parmvalue) ;
      bttBtninicializar_Visible = (AV47testEs ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtninicializar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninicializar_Visible), 5, 0), true);
   }

   public void e20OO2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV21EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      legajo_cuenta_licenciasww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV21EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21EmpCod), "ZZZ9")));
      GXt_int3 = AV6CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      legajo_cuenta_licenciasww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV6CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV93WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV93WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV99ManageFiltersExecutionStep == 1 )
      {
         AV99ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ManageFiltersExecutionStep", GXutil.str( AV99ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV99ManageFiltersExecutionStep == 2 )
      {
         AV99ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ManageFiltersExecutionStep", GXutil.str( AV99ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV45Session.getValue("legajo_cuenta_licenciasWWColumnsSelector"), "") != 0 )
      {
         AV9ColumnsSelectorXML = AV45Session.getValue("legajo_cuenta_licenciasWWColumnsSelector") ;
         AV7ColumnsSelector.fromxml(AV9ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtLegCuenAnio_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenAnio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenAnio_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegIdNomApe_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegIdNomApe_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegIdNomApe_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegCuenLicTpo.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegCuenLicTpo.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCueAntAbr_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCueAntAbr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCueAntAbr_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuenDiasCorres_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasCorres_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasCorres_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuLiPAnt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPAnt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPAnt_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuLActVen_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLActVen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLActVen_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuLiPVen_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPVen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPVen_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuLiPCur_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPCur_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPCur_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuLiPApr_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPApr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPApr_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuenDiasGoz_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuenDiasGoz_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuenDiasGoz_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuLiPSaldo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuLiPSaldo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuLiPSaldo_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavConsumido_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConsumido_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumido_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV7ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV23GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GridCurrentPage), 10, 0));
      AV24GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridPageCount), 10, 0));
      GXt_char12 = AV22GridAppliedFilters ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV112Pgmname, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV22GridAppliedFilters = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22GridAppliedFilters", AV22GridAppliedFilters);
      GXt_char12 = AV104MenuOpcTitulo ;
      GXv_char9[0] = GXt_char12 ;
      new web.gettxtcount(remoteHandle, context).execute( AV36MenuOpcCod, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV104MenuOpcTitulo = GXt_char12 ;
      if ( (GXutil.strcmp("", AV104MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV104MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int2[0] = (short)(AV106filterCount) ;
      GXv_char9[0] = AV107filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV25GridState, GXv_int2, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.AV106filterCount = GXv_int2[0] ;
      legajo_cuenta_licenciasww_impl.this.AV107filtrosTexto = GXv_char9[0] ;
      if ( AV106filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV106filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV107filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio = AV55TFLegCuenAnio ;
      AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to = AV56TFLegCuenAnio_To ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = AV81TFLegIdNomApe ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = AV82TFLegIdNomApe_Sels ;
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = AV65TFLegCuenLicTpo_Sels ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = AV49TFLegCueAntAbr ;
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = AV50TFLegCueAntAbr_Sels ;
      AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres = AV57TFLegCuenDiasCorres ;
      AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to = AV58TFLegCuenDiasCorres_To ;
      AV122Legajo_cuenta_licenciaswwds_10_tflegculipant = AV70TFLegCuLiPAnt ;
      AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to = AV71TFLegCuLiPAnt_To ;
      AV124Legajo_cuenta_licenciaswwds_12_tflegculactven = AV67TFLegCuLActVen ;
      AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to = AV68TFLegCuLActVen_To ;
      AV126Legajo_cuenta_licenciaswwds_14_tflegculipven = AV78TFLegCuLiPVen ;
      AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to = AV79TFLegCuLiPVen_To ;
      AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur = AV74TFLegCuLiPCur ;
      AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to = AV75TFLegCuLiPCur_To ;
      AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr = AV72TFLegCuLiPApr ;
      AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to = AV73TFLegCuLiPApr_To ;
      AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz = AV59TFLegCuenDiasGoz ;
      AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to = AV60TFLegCuenDiasGoz_To ;
      AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo = AV76TFLegCuLiPSaldo ;
      AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to = AV77TFLegCuLiPSaldo_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7ColumnsSelector", AV7ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV97ManageFiltersData", AV97ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25GridState", AV25GridState);
   }

   public void e13OO2( )
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
         AV41PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV41PageToGo) ;
      }
   }

   public void e14OO2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15OO2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV38OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38OrderedBy), 4, 0));
         AV40OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40OrderedDsc", AV40OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuenAnio") == 0 )
         {
            AV55TFLegCuenAnio = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFLegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55TFLegCuenAnio), 4, 0));
            AV56TFLegCuenAnio_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFLegCuenAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFLegCuenAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegIdNomApe") == 0 )
         {
            AV81TFLegIdNomApe = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFLegIdNomApe", AV81TFLegIdNomApe);
            AV83TFLegIdNomApe_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFLegIdNomApe_SelsJson", AV83TFLegIdNomApe_SelsJson);
            AV82TFLegIdNomApe_Sels.fromJSonString(AV83TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuenLicTpo") == 0 )
         {
            AV66TFLegCuenLicTpo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFLegCuenLicTpo_SelsJson", AV66TFLegCuenLicTpo_SelsJson);
            AV65TFLegCuenLicTpo_Sels.fromJSonString(AV66TFLegCuenLicTpo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCueAntAbr") == 0 )
         {
            AV49TFLegCueAntAbr = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFLegCueAntAbr", AV49TFLegCueAntAbr);
            AV51TFLegCueAntAbr_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFLegCueAntAbr_SelsJson", AV51TFLegCueAntAbr_SelsJson);
            AV50TFLegCueAntAbr_Sels.fromJSonString(AV51TFLegCueAntAbr_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuenDiasCorres") == 0 )
         {
            AV57TFLegCuenDiasCorres = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFLegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFLegCuenDiasCorres), 4, 0));
            AV58TFLegCuenDiasCorres_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFLegCuenDiasCorres_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFLegCuenDiasCorres_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuLiPAnt") == 0 )
         {
            AV70TFLegCuLiPAnt = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFLegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70TFLegCuLiPAnt), 4, 0));
            AV71TFLegCuLiPAnt_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFLegCuLiPAnt_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71TFLegCuLiPAnt_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuLActVen") == 0 )
         {
            AV67TFLegCuLActVen = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFLegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFLegCuLActVen), 4, 0));
            AV68TFLegCuLActVen_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFLegCuLActVen_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFLegCuLActVen_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuLiPVen") == 0 )
         {
            AV78TFLegCuLiPVen = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFLegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFLegCuLiPVen), 4, 0));
            AV79TFLegCuLiPVen_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFLegCuLiPVen_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79TFLegCuLiPVen_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuLiPCur") == 0 )
         {
            AV74TFLegCuLiPCur = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFLegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFLegCuLiPCur), 4, 0));
            AV75TFLegCuLiPCur_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFLegCuLiPCur_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75TFLegCuLiPCur_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuLiPApr") == 0 )
         {
            AV72TFLegCuLiPApr = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFLegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72TFLegCuLiPApr), 4, 0));
            AV73TFLegCuLiPApr_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFLegCuLiPApr_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73TFLegCuLiPApr_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuenDiasGoz") == 0 )
         {
            AV59TFLegCuenDiasGoz = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFLegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59TFLegCuenDiasGoz), 4, 0));
            AV60TFLegCuenDiasGoz_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFLegCuenDiasGoz_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFLegCuenDiasGoz_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuLiPSaldo") == 0 )
         {
            AV76TFLegCuLiPSaldo = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFLegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76TFLegCuLiPSaldo), 4, 0));
            AV77TFLegCuLiPSaldo_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFLegCuLiPSaldo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFLegCuLiPSaldo_To), 4, 0));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFLegCueAntAbr_Sels", AV50TFLegCueAntAbr_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65TFLegCuenLicTpo_Sels", AV65TFLegCuenLicTpo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV82TFLegIdNomApe_Sels", AV82TFLegIdNomApe_Sels);
   }

   private void e21OO2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV88Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV88Update);
      if ( AV31IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.legajo_cuenta_licencias", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(A2243LegCuenLicTpo)),GXutil.URLEncode(GXutil.ltrimstr(A2266LegCuenAnio,4,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","LegCuenLicTpo","LegCuenAnio"})  ;
      }
      AV19Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV19Display);
      edtavDisplay_Link = formatLink("web.legajo_cuenta_licenciasview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(A2243LegCuenLicTpo)),GXutil.URLEncode(GXutil.ltrimstr(A2266LegCuenAnio,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","LegCuenLicTpo","LegCuenAnio","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char12 = AV90VerSVG ;
      GXv_char9[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV90VerSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV90VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char12 = AV37ModificarSVG ;
      GXv_char9[0] = GXt_char12 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV37ModificarSVG = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV37ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      GXv_char9[0] = AV5aprobadosTxt ;
      new web.getlicccaprobadostxt(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A2243LegCuenLicTpo, A2266LegCuenAnio, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.AV5aprobadosTxt = GXv_char9[0] ;
      edtLegCuenDiasGoz_Tooltiptext = GXutil.trim( AV5aprobadosTxt) ;
      GXv_decimal14[0] = AV43porcentaje ;
      GXv_char9[0] = AV94consumidosTxt ;
      new web.licccgetprcconsumido(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A2243LegCuenLicTpo, A2266LegCuenAnio, GXv_decimal14, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.AV43porcentaje = GXv_decimal14[0] ;
      legajo_cuenta_licenciasww_impl.this.AV94consumidosTxt = GXv_char9[0] ;
      AV10Consumido = GXutil.trim( GXutil.str( AV43porcentaje, 6, 2)) + "%" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavConsumido_Internalname, AV10Consumido);
      edtavConsumido_Tooltiptext = GXutil.trim( AV94consumidosTxt) ;
      edtLegCueAntAbr_Tooltiptext = GXutil.trim( A2301LegCueAntTexto) ;
      edtLegCuenAnio_Tooltiptext = httpContext.getMessage( "Periodo desde el ", "")+GXutil.trim( localUtil.dtoc( A2244LegCuenLicPerIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " hasta el ", "")+GXutil.trim( localUtil.dtoc( A2245LegCuenLicPerFin, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      edtLegCuLiPSaldo_Tooltiptext = GXutil.trim( A2329LegCuLLogDis) ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(108) ;
      }
      sendrow_1082( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_108_Refreshing )
      {
         httpContext.doAjaxLoad(108, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11OO2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV9ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV7ColumnsSelector.fromJSonString(AV9ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "legajo_cuenta_licenciasWWColumnsSelector", ((GXutil.strcmp("", AV9ColumnsSelectorXML)==0) ? "" : AV7ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7ColumnsSelector", AV7ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV97ManageFiltersData", AV97ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25GridState", AV25GridState);
   }

   public void e12OO2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S182 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("legajo_cuenta_licenciasWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV112Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV99ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ManageFiltersExecutionStep", GXutil.str( AV99ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("legajo_cuenta_licenciasWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV99ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV99ManageFiltersExecutionStep", GXutil.str( AV99ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char12 = AV98ManageFiltersXml ;
         GXv_char9[0] = GXt_char12 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "legajo_cuenta_licenciasWWFilters", Ddo_managefilters_Activeeventkey, GXv_char9) ;
         legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
         AV98ManageFiltersXml = GXt_char12 ;
         if ( (GXutil.strcmp("", AV98ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV112Pgmname+"GridState", AV98ManageFiltersXml) ;
            AV25GridState.fromxml(AV98ManageFiltersXml, null, null);
            AV38OrderedBy = AV25GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38OrderedBy), 4, 0));
            AV40OrderedDsc = AV25GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40OrderedDsc", AV40OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S192 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25GridState", AV25GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV82TFLegIdNomApe_Sels", AV82TFLegIdNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV65TFLegCuenLicTpo_Sels", AV65TFLegCuenLicTpo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV50TFLegCueAntAbr_Sels", AV50TFLegCueAntAbr_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7ColumnsSelector", AV7ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV97ManageFiltersData", AV97ManageFiltersData);
   }

   public void e16OO2( )
   {
      /* 'Doinicializar' Routine */
      returnInSub = false ;
      new web.inicializarperiodoscclic(remoteHandle, context).execute( AV6CliCod, AV21EmpCod, 0, (short)(0)) ;
   }

   public void e17OO2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV95ExcelFilename ;
      GXv_char8[0] = AV96ErrorMessage ;
      new web.legajo_cuenta_licenciaswwexport(remoteHandle, context).execute( GXv_char9, GXv_char8) ;
      legajo_cuenta_licenciasww_impl.this.AV95ExcelFilename = GXv_char9[0] ;
      legajo_cuenta_licenciasww_impl.this.AV96ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV95ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV95ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV96ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV38OrderedBy, 4, 0))+":"+(AV40OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV7ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuenAnio", "", "Año", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegIdNomApe", "", "Legajo", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuenLicTpo", "", "Tipo", false, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCueAntAbr", "", "Antiguedad para vacaciones", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuenDiasCorres", "", "Corresponden", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuLiPAnt", "", "Pendientes anteriores", false, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuLActVen", "", "Pendientes actuales a vencer", false, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuLiPVen", "", "Pendientes vencidas", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuLiPCur", "", "Asignación pendiente", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuLiPApr", "", "Aprobación pendiente", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuenDiasGoz", "", "Aprobadas", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "LegCuLiPSaldo", "", "Total disponible", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "&Consumido", "", "Consumido", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "&VerSVG", "", "", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXv_SdtWWPColumnsSelector15[0] = AV7ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, "&ModificarSVG", "", "", true, "") ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      GXt_char12 = AV89UserCustomValue ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "legajo_cuenta_licenciasWWColumnsSelector", GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      AV89UserCustomValue = GXt_char12 ;
      if ( ! ( (GXutil.strcmp("", AV89UserCustomValue)==0) ) )
      {
         AV8ColumnsSelectorAux.fromxml(AV89UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector15[0] = AV8ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector16[0] = AV7ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector15, GXv_SdtWWPColumnsSelector16) ;
         AV8ColumnsSelectorAux = GXv_SdtWWPColumnsSelector15[0] ;
         AV7ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
      }
      GXv_SdtWWPColumnsSelector16[0] = AV7ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV6CliCod, GXv_SdtWWPColumnsSelector16) ;
      AV7ColumnsSelector = GXv_SdtWWPColumnsSelector16[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean17 = AV31IsAuthorized_Update ;
      GXv_boolean10[0] = GXt_boolean17 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_cuenta_licencias_Update", GXv_boolean10) ;
      legajo_cuenta_licenciasww_impl.this.GXt_boolean17 = GXv_boolean10[0] ;
      AV31IsAuthorized_Update = GXt_boolean17 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31IsAuthorized_Update", AV31IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV31IsAuthorized_Update));
      if ( ! ( AV31IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_108_Refreshing);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = AV97ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "legajo_cuenta_licenciasWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[0] ;
      AV97ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV55TFLegCuenAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFLegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55TFLegCuenAnio), 4, 0));
      AV56TFLegCuenAnio_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFLegCuenAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFLegCuenAnio_To), 4, 0));
      AV81TFLegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TFLegIdNomApe", AV81TFLegIdNomApe);
      AV82TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65TFLegCuenLicTpo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49TFLegCueAntAbr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFLegCueAntAbr", AV49TFLegCueAntAbr);
      AV50TFLegCueAntAbr_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57TFLegCuenDiasCorres = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57TFLegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFLegCuenDiasCorres), 4, 0));
      AV58TFLegCuenDiasCorres_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58TFLegCuenDiasCorres_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFLegCuenDiasCorres_To), 4, 0));
      AV70TFLegCuLiPAnt = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70TFLegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70TFLegCuLiPAnt), 4, 0));
      AV71TFLegCuLiPAnt_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71TFLegCuLiPAnt_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71TFLegCuLiPAnt_To), 4, 0));
      AV67TFLegCuLActVen = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67TFLegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFLegCuLActVen), 4, 0));
      AV68TFLegCuLActVen_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68TFLegCuLActVen_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFLegCuLActVen_To), 4, 0));
      AV78TFLegCuLiPVen = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFLegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFLegCuLiPVen), 4, 0));
      AV79TFLegCuLiPVen_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79TFLegCuLiPVen_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79TFLegCuLiPVen_To), 4, 0));
      AV74TFLegCuLiPCur = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74TFLegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFLegCuLiPCur), 4, 0));
      AV75TFLegCuLiPCur_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75TFLegCuLiPCur_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75TFLegCuLiPCur_To), 4, 0));
      AV72TFLegCuLiPApr = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72TFLegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72TFLegCuLiPApr), 4, 0));
      AV73TFLegCuLiPApr_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73TFLegCuLiPApr_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73TFLegCuLiPApr_To), 4, 0));
      AV59TFLegCuenDiasGoz = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFLegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59TFLegCuenDiasGoz), 4, 0));
      AV60TFLegCuenDiasGoz_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFLegCuenDiasGoz_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFLegCuenDiasGoz_To), 4, 0));
      AV76TFLegCuLiPSaldo = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76TFLegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76TFLegCuLiPSaldo), 4, 0));
      AV77TFLegCuLiPSaldo_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFLegCuLiPSaldo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFLegCuLiPSaldo_To), 4, 0));
      Ddo_grid_Selectedvalue_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      Ddo_grid_Filteredtext_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV45Session.getValue(AV112Pgmname+"GridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV112Pgmname+"GridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV45Session.getValue(AV112Pgmname+"GridState"), null, null);
      }
      AV38OrderedBy = AV25GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38OrderedBy), 4, 0));
      AV40OrderedDsc = AV25GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40OrderedDsc", AV40OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV25GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV25GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV25GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV136GXV1 = 1 ;
      while ( AV136GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV136GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENANIO") == 0 )
         {
            AV55TFLegCuenAnio = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFLegCuenAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55TFLegCuenAnio), 4, 0));
            AV56TFLegCuenAnio_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFLegCuenAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56TFLegCuenAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV81TFLegIdNomApe = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFLegIdNomApe", AV81TFLegIdNomApe);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV83TFLegIdNomApe_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFLegIdNomApe_SelsJson", AV83TFLegIdNomApe_SelsJson);
            AV82TFLegIdNomApe_Sels.fromJSonString(AV83TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENLICTPO_SEL") == 0 )
         {
            AV66TFLegCuenLicTpo_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFLegCuenLicTpo_SelsJson", AV66TFLegCuenLicTpo_SelsJson);
            AV65TFLegCuenLicTpo_Sels.fromJSonString(AV66TFLegCuenLicTpo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUEANTABR") == 0 )
         {
            AV49TFLegCueAntAbr = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFLegCueAntAbr", AV49TFLegCueAntAbr);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUEANTABR_SEL") == 0 )
         {
            AV51TFLegCueAntAbr_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFLegCueAntAbr_SelsJson", AV51TFLegCueAntAbr_SelsJson);
            AV50TFLegCueAntAbr_Sels.fromJSonString(AV51TFLegCueAntAbr_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENDIASCORRES") == 0 )
         {
            AV57TFLegCuenDiasCorres = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV57TFLegCuenDiasCorres", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57TFLegCuenDiasCorres), 4, 0));
            AV58TFLegCuenDiasCorres_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58TFLegCuenDiasCorres_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58TFLegCuenDiasCorres_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPANT") == 0 )
         {
            AV70TFLegCuLiPAnt = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFLegCuLiPAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV70TFLegCuLiPAnt), 4, 0));
            AV71TFLegCuLiPAnt_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71TFLegCuLiPAnt_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71TFLegCuLiPAnt_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULACTVEN") == 0 )
         {
            AV67TFLegCuLActVen = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFLegCuLActVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFLegCuLActVen), 4, 0));
            AV68TFLegCuLActVen_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFLegCuLActVen_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFLegCuLActVen_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPVEN") == 0 )
         {
            AV78TFLegCuLiPVen = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFLegCuLiPVen", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFLegCuLiPVen), 4, 0));
            AV79TFLegCuLiPVen_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFLegCuLiPVen_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79TFLegCuLiPVen_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPCUR") == 0 )
         {
            AV74TFLegCuLiPCur = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFLegCuLiPCur", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV74TFLegCuLiPCur), 4, 0));
            AV75TFLegCuLiPCur_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFLegCuLiPCur_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV75TFLegCuLiPCur_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPAPR") == 0 )
         {
            AV72TFLegCuLiPApr = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFLegCuLiPApr", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV72TFLegCuLiPApr), 4, 0));
            AV73TFLegCuLiPApr_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFLegCuLiPApr_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV73TFLegCuLiPApr_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENDIASGOZ") == 0 )
         {
            AV59TFLegCuenDiasGoz = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFLegCuenDiasGoz", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59TFLegCuenDiasGoz), 4, 0));
            AV60TFLegCuenDiasGoz_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFLegCuenDiasGoz_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60TFLegCuenDiasGoz_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCULIPSALDO") == 0 )
         {
            AV76TFLegCuLiPSaldo = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76TFLegCuLiPSaldo", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76TFLegCuLiPSaldo), 4, 0));
            AV77TFLegCuLiPSaldo_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFLegCuLiPSaldo_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFLegCuLiPSaldo_To), 4, 0));
         }
         AV136GXV1 = (int)(AV136GXV1+1) ;
      }
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV82TFLegIdNomApe_Sels.size()==0), AV83TFLegIdNomApe_SelsJson, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char9[0] ;
      GXt_char11 = "" ;
      GXv_char8[0] = GXt_char11 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV65TFLegCuenLicTpo_Sels.size()==0), AV66TFLegCuenLicTpo_SelsJson, GXv_char8) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char11 = GXv_char8[0] ;
      GXt_char20 = "" ;
      GXv_char7[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV50TFLegCueAntAbr_Sels.size()==0), AV51TFLegCueAntAbr_SelsJson, GXv_char7) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char20 = GXv_char7[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char12+"|"+GXt_char11+"|"+GXt_char20+"|||||||||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char20 = "" ;
      GXv_char9[0] = GXt_char20 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV81TFLegIdNomApe)==0), AV81TFLegIdNomApe, GXv_char9) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char20 = GXv_char9[0] ;
      GXt_char12 = "" ;
      GXv_char8[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV49TFLegCueAntAbr)==0), AV49TFLegCueAntAbr, GXv_char8) ;
      legajo_cuenta_licenciasww_impl.this.GXt_char12 = GXv_char8[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV55TFLegCuenAnio) ? "" : GXutil.str( AV55TFLegCuenAnio, 4, 0))+"|"+GXt_char20+"||"+GXt_char12+"|"+((0==AV57TFLegCuenDiasCorres) ? "" : GXutil.str( AV57TFLegCuenDiasCorres, 4, 0))+"|"+((0==AV70TFLegCuLiPAnt) ? "" : GXutil.str( AV70TFLegCuLiPAnt, 4, 0))+"|"+((0==AV67TFLegCuLActVen) ? "" : GXutil.str( AV67TFLegCuLActVen, 4, 0))+"|"+((0==AV78TFLegCuLiPVen) ? "" : GXutil.str( AV78TFLegCuLiPVen, 4, 0))+"|"+((0==AV74TFLegCuLiPCur) ? "" : GXutil.str( AV74TFLegCuLiPCur, 4, 0))+"|"+((0==AV72TFLegCuLiPApr) ? "" : GXutil.str( AV72TFLegCuLiPApr, 4, 0))+"|"+((0==AV59TFLegCuenDiasGoz) ? "" : GXutil.str( AV59TFLegCuenDiasGoz, 4, 0))+"|"+((0==AV76TFLegCuLiPSaldo) ? "" : GXutil.str( AV76TFLegCuLiPSaldo, 4, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV56TFLegCuenAnio_To) ? "" : GXutil.str( AV56TFLegCuenAnio_To, 4, 0))+"||||"+((0==AV58TFLegCuenDiasCorres_To) ? "" : GXutil.str( AV58TFLegCuenDiasCorres_To, 4, 0))+"|"+((0==AV71TFLegCuLiPAnt_To) ? "" : GXutil.str( AV71TFLegCuLiPAnt_To, 4, 0))+"|"+((0==AV68TFLegCuLActVen_To) ? "" : GXutil.str( AV68TFLegCuLActVen_To, 4, 0))+"|"+((0==AV79TFLegCuLiPVen_To) ? "" : GXutil.str( AV79TFLegCuLiPVen_To, 4, 0))+"|"+((0==AV75TFLegCuLiPCur_To) ? "" : GXutil.str( AV75TFLegCuLiPCur_To, 4, 0))+"|"+((0==AV73TFLegCuLiPApr_To) ? "" : GXutil.str( AV73TFLegCuLiPApr_To, 4, 0))+"|"+((0==AV60TFLegCuenDiasGoz_To) ? "" : GXutil.str( AV60TFLegCuenDiasGoz_To, 4, 0))+"|"+((0==AV77TFLegCuLiPSaldo_To) ? "" : GXutil.str( AV77TFLegCuLiPSaldo_To, 4, 0))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV25GridState.fromxml(AV45Session.getValue(AV112Pgmname+"GridState"), null, null);
      AV25GridState.setgxTv_SdtWWPGridState_Orderedby( AV38OrderedBy );
      AV25GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV40OrderedDsc );
      AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCUENANIO", httpContext.getMessage( "Año", ""), !((0==AV55TFLegCuenAnio)&&(0==AV56TFLegCuenAnio_To)), (short)(0), GXutil.trim( GXutil.str( AV55TFLegCuenAnio, 4, 0)), GXutil.trim( GXutil.str( AV56TFLegCuenAnio_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGIDNOMAPE", httpContext.getMessage( "Legajo", ""), !(GXutil.strcmp("", AV81TFLegIdNomApe)==0), (short)(0), AV81TFLegIdNomApe, "", !(AV82TFLegIdNomApe_Sels.size()==0), AV82TFLegIdNomApe_Sels.toJSonString(false), "") ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCUENLICTPO_SEL", httpContext.getMessage( "Tipo", ""), !(AV65TFLegCuenLicTpo_Sels.size()==0), (short)(0), AV65TFLegCuenLicTpo_Sels.toJSonString(false), "") ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCUEANTABR", httpContext.getMessage( "Antiguedad para vacaciones", ""), !(GXutil.strcmp("", AV49TFLegCueAntAbr)==0), (short)(0), AV49TFLegCueAntAbr, "", !(AV50TFLegCueAntAbr_Sels.size()==0), AV50TFLegCueAntAbr_Sels.toJSonString(false), "") ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCUENDIASCORRES", httpContext.getMessage( "Corresponden", ""), !((0==AV57TFLegCuenDiasCorres)&&(0==AV58TFLegCuenDiasCorres_To)), (short)(0), GXutil.trim( GXutil.str( AV57TFLegCuenDiasCorres, 4, 0)), GXutil.trim( GXutil.str( AV58TFLegCuenDiasCorres_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCULIPANT", httpContext.getMessage( "Pendientes anteriores", ""), !((0==AV70TFLegCuLiPAnt)&&(0==AV71TFLegCuLiPAnt_To)), (short)(0), GXutil.trim( GXutil.str( AV70TFLegCuLiPAnt, 4, 0)), GXutil.trim( GXutil.str( AV71TFLegCuLiPAnt_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCULACTVEN", httpContext.getMessage( "Pendientes actuales a vencer", ""), !((0==AV67TFLegCuLActVen)&&(0==AV68TFLegCuLActVen_To)), (short)(0), GXutil.trim( GXutil.str( AV67TFLegCuLActVen, 4, 0)), GXutil.trim( GXutil.str( AV68TFLegCuLActVen_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCULIPVEN", httpContext.getMessage( "Pendientes vencidas", ""), !((0==AV78TFLegCuLiPVen)&&(0==AV79TFLegCuLiPVen_To)), (short)(0), GXutil.trim( GXutil.str( AV78TFLegCuLiPVen, 4, 0)), GXutil.trim( GXutil.str( AV79TFLegCuLiPVen_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCULIPCUR", httpContext.getMessage( "Asignación pendiente", ""), !((0==AV74TFLegCuLiPCur)&&(0==AV75TFLegCuLiPCur_To)), (short)(0), GXutil.trim( GXutil.str( AV74TFLegCuLiPCur, 4, 0)), GXutil.trim( GXutil.str( AV75TFLegCuLiPCur_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCULIPAPR", httpContext.getMessage( "Aprobación pendiente", ""), !((0==AV72TFLegCuLiPApr)&&(0==AV73TFLegCuLiPApr_To)), (short)(0), GXutil.trim( GXutil.str( AV72TFLegCuLiPApr, 4, 0)), GXutil.trim( GXutil.str( AV73TFLegCuLiPApr_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCUENDIASGOZ", httpContext.getMessage( "Aprobadas", ""), !((0==AV59TFLegCuenDiasGoz)&&(0==AV60TFLegCuenDiasGoz_To)), (short)(0), GXutil.trim( GXutil.str( AV59TFLegCuenDiasGoz, 4, 0)), GXutil.trim( GXutil.str( AV60TFLegCuenDiasGoz_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV25GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFLEGCULIPSALDO", httpContext.getMessage( "Total disponible", ""), !((0==AV76TFLegCuLiPSaldo)&&(0==AV77TFLegCuLiPSaldo_To)), (short)(0), GXutil.trim( GXutil.str( AV76TFLegCuLiPSaldo, 4, 0)), GXutil.trim( GXutil.str( AV77TFLegCuLiPSaldo_To, 4, 0))) ;
      AV25GridState = GXv_SdtWWPGridState21[0] ;
      if ( ! (GXutil.strcmp("", AV36MenuOpcCod)==0) )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV26GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV26GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV36MenuOpcCod );
         AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV26GridStateFilterValue, 0);
      }
      AV25GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV25GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV112Pgmname+"GridState", AV25GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV86TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV86TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV112Pgmname );
      AV86TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV86TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV27HTTPRequest.getScriptName()+"?"+AV27HTTPRequest.getQuerystring() );
      AV86TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "legajo_cuenta_licencias" );
      AV45Session.setValue("TrnContext", AV86TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e18OO2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV92WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean10[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV36MenuOpcCod, GXv_boolean10) ;
         GXv_char9[0] = AV48textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV6CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char9) ;
         legajo_cuenta_licenciasww_impl.this.AV48textoNoMostrara = GXv_char9[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV48textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean10[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV36MenuOpcCod, GXv_boolean10) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_OO2( true) ;
      }
      else
      {
         wb_table2_12_OO2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_OO2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_OO2e( true) ;
      }
      else
      {
         wb_table1_9_OO2e( false) ;
      }
   }

   public void wb_table2_12_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablepadding_Internalname, tblTablepadding_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e22oo1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_legajo_cuenta_licenciasWW.htm");
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
         AV91WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV91WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV111Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV91WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV91WelcomeMessage_Foto)==0) ? AV111Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV91WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV91WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_legajo_cuenta_licenciasWW.htm");
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
         wb_table3_30_OO2( true) ;
      }
      else
      {
         wb_table3_30_OO2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_OO2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_OO2( true) ;
      }
      else
      {
         wb_table4_35_OO2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_OO2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_108_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV92WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
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
         web.GxWebStd.gx_div_start( httpContext, divTablefiltrospadre_Internalname, 1, 0, "px", 0, "px", "TableFiltrosPadre", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;align-self:center;", "div");
         wb_table5_54_OO2( true) ;
      }
      else
      {
         wb_table5_54_OO2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_OO2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_OO2( true) ;
      }
      else
      {
         wb_table6_63_OO2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_OO2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='SectionGrid GridFixedTitles HasGridEmpowerer'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol108( ) ;
      }
      if ( wbEnd == 108 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_108 = (int)(nGXsfl_108_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
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
         ucGridpaginationbar.setProperty("AppliedFilters", AV22GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_OO2e( true) ;
      }
      else
      {
         wb_table2_12_OO2e( false) ;
      }
   }

   public void wb_table6_63_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_tablecontentbuttonimport_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImport", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_legajo_cuenta_licenciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonexport1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonexport1_a3lexport.render(context, "a3lclonevent", Buttonexport1_a3lexport_Internalname, "BUTTONEXPORT1_A3LEXPORTContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* User Defined Control */
         ucDdo_gridcolumnsselector.setProperty("IconType", Ddo_gridcolumnsselector_Icontype);
         ucDdo_gridcolumnsselector.setProperty("Icon", Ddo_gridcolumnsselector_Icon);
         ucDdo_gridcolumnsselector.setProperty("Caption", Ddo_gridcolumnsselector_Caption);
         ucDdo_gridcolumnsselector.setProperty("Tooltip", Ddo_gridcolumnsselector_Tooltip);
         ucDdo_gridcolumnsselector.setProperty("Cls", Ddo_gridcolumnsselector_Cls);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsType", Ddo_gridcolumnsselector_Dropdownoptionstype);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV7ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV97ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_cuenta_licenciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_tablecontent_Internalname, divButtonfilter1_tablecontent_Visible, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_filtros_Internalname, 1, 0, "px", 0, "px", "TableContentButtonImportFiltros", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_svg_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_legajo_cuenta_licenciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divButtonfilter1_table_texto_Internalname, 1, 0, "px", 0, "px", "ML10", "left", "top", " "+"data-gx-flex"+" ", "align-items:center;", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_OO2( true) ;
      }
      else
      {
         wb_table7_97_OO2( false) ;
      }
      return  ;
   }

   public void wb_table7_97_OO2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* User Defined Control */
         ucButtonfilter1_a3lfilter.render(context, "a3lfilter", Buttonfilter1_a3lfilter_Internalname, "BUTTONFILTER1_A3LFILTERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_63_OO2e( true) ;
      }
      else
      {
         wb_table6_63_OO2e( false) ;
      }
   }

   public void wb_table7_97_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblButtonfilter1_tablebadge_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblButtonfilter1_tablebadge_Internalname, tblButtonfilter1_tablebadge_Internalname, "", "TableBadge", 0, "", tblButtonfilter1_tablebadge_Tooltiptext, 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_OO2e( true) ;
      }
      else
      {
         wb_table7_97_OO2e( false) ;
      }
   }

   public void wb_table5_54_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTabletotalregistros_Internalname, tblTabletotalregistros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabletotal_Internalname, 1, 0, "px", 0, "px", "TotalPill ML15", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_OO2e( true) ;
      }
      else
      {
         wb_table5_54_OO2e( false) ;
      }
   }

   public void wb_table4_35_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_OO2e( true) ;
      }
      else
      {
         wb_table4_35_OO2e( false) ;
      }
   }

   public void wb_table3_30_OO2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_cuenta_licenciasWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_OO2e( true) ;
      }
      else
      {
         wb_table3_30_OO2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV36MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36MenuOpcCod", AV36MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV36MenuOpcCod, ""))));
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
      paOO2( ) ;
      wsOO2( ) ;
      weOO2( ) ;
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
      httpContext.AddStyleSheetFile("a3lfilter.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713492592", true, true);
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
      httpContext.AddJavascriptSource("legajo_cuenta_licenciasww.js", "?20251713492592", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LClonEventRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LFilterRender.js", "", false, true);
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

   public void subsflControlProps_1082( )
   {
      edtLegCuenAnio_Internalname = "LEGCUENANIO_"+sGXsfl_108_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_108_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_108_idx ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE_"+sGXsfl_108_idx ;
      cmbLegCuenLicTpo.setInternalname( "LEGCUENLICTPO_"+sGXsfl_108_idx );
      chkLegCuLIncluir.setInternalname( "LEGCULINCLUIR_"+sGXsfl_108_idx );
      chkLegCuLRecalc.setInternalname( "LEGCULRECALC_"+sGXsfl_108_idx );
      edtLegCueAntAbr_Internalname = "LEGCUEANTABR_"+sGXsfl_108_idx ;
      edtLegCuenLicPerIni_Internalname = "LEGCUENLICPERINI_"+sGXsfl_108_idx ;
      edtLegCuenLicPerFin_Internalname = "LEGCUENLICPERFIN_"+sGXsfl_108_idx ;
      edtLegCuenDiasCorres_Internalname = "LEGCUENDIASCORRES_"+sGXsfl_108_idx ;
      edtLegCuLiPAnt_Internalname = "LEGCULIPANT_"+sGXsfl_108_idx ;
      edtLegCuLActVen_Internalname = "LEGCULACTVEN_"+sGXsfl_108_idx ;
      edtLegCuLiPVen_Internalname = "LEGCULIPVEN_"+sGXsfl_108_idx ;
      edtLegCuLiPCur_Internalname = "LEGCULIPCUR_"+sGXsfl_108_idx ;
      edtLegCuLiPApr_Internalname = "LEGCULIPAPR_"+sGXsfl_108_idx ;
      edtLegCuenDiasGoz_Internalname = "LEGCUENDIASGOZ_"+sGXsfl_108_idx ;
      edtLegCuLiPSaldo_Internalname = "LEGCULIPSALDO_"+sGXsfl_108_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_idx ;
      edtavConsumido_Internalname = "vCONSUMIDO_"+sGXsfl_108_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtLegCuenAnio_Internalname = "LEGCUENANIO_"+sGXsfl_108_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_108_fel_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_108_fel_idx ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE_"+sGXsfl_108_fel_idx ;
      cmbLegCuenLicTpo.setInternalname( "LEGCUENLICTPO_"+sGXsfl_108_fel_idx );
      chkLegCuLIncluir.setInternalname( "LEGCULINCLUIR_"+sGXsfl_108_fel_idx );
      chkLegCuLRecalc.setInternalname( "LEGCULRECALC_"+sGXsfl_108_fel_idx );
      edtLegCueAntAbr_Internalname = "LEGCUEANTABR_"+sGXsfl_108_fel_idx ;
      edtLegCuenLicPerIni_Internalname = "LEGCUENLICPERINI_"+sGXsfl_108_fel_idx ;
      edtLegCuenLicPerFin_Internalname = "LEGCUENLICPERFIN_"+sGXsfl_108_fel_idx ;
      edtLegCuenDiasCorres_Internalname = "LEGCUENDIASCORRES_"+sGXsfl_108_fel_idx ;
      edtLegCuLiPAnt_Internalname = "LEGCULIPANT_"+sGXsfl_108_fel_idx ;
      edtLegCuLActVen_Internalname = "LEGCULACTVEN_"+sGXsfl_108_fel_idx ;
      edtLegCuLiPVen_Internalname = "LEGCULIPVEN_"+sGXsfl_108_fel_idx ;
      edtLegCuLiPCur_Internalname = "LEGCULIPCUR_"+sGXsfl_108_fel_idx ;
      edtLegCuLiPApr_Internalname = "LEGCULIPAPR_"+sGXsfl_108_fel_idx ;
      edtLegCuenDiasGoz_Internalname = "LEGCUENDIASGOZ_"+sGXsfl_108_fel_idx ;
      edtLegCuLiPSaldo_Internalname = "LEGCULIPSALDO_"+sGXsfl_108_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_108_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_108_fel_idx ;
      edtavConsumido_Internalname = "vCONSUMIDO_"+sGXsfl_108_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_108_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wbOO0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_108_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_108_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_108_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuenAnio_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuenAnio_Internalname,GXutil.ltrim( localUtil.ntoc( A2266LegCuenAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2266LegCuenAnio), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","",edtLegCuenAnio_Tooltiptext,"",edtLegCuenAnio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuenAnio_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Anio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegIdNomApe_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegIdNomApe_Internalname,A250LegIdNomApe,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegIdNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegIdNomApe_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLegCuenLicTpo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLegCuenLicTpo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGCUENLICTPO_" + sGXsfl_108_idx ;
            cmbLegCuenLicTpo.setName( GXCCtl );
            cmbLegCuenLicTpo.setWebtags( "" );
            cmbLegCuenLicTpo.addItem("Vacaciones", httpContext.getMessage( "Vacaciones", ""), (short)(0));
            if ( cmbLegCuenLicTpo.getItemCount() > 0 )
            {
               A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegCuenLicTpo,cmbLegCuenLicTpo.getInternalname(),GXutil.rtrim( A2243LegCuenLicTpo),Integer.valueOf(1),cmbLegCuenLicTpo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLegCuenLicTpo.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegCuenLicTpo.setValue( GXutil.rtrim( A2243LegCuenLicTpo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegCuenLicTpo.getInternalname(), "Values", cmbLegCuenLicTpo.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "LEGCULINCLUIR_" + sGXsfl_108_idx ;
         chkLegCuLIncluir.setName( GXCCtl );
         chkLegCuLIncluir.setWebtags( "" );
         chkLegCuLIncluir.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkLegCuLIncluir.getInternalname(), "TitleCaption", chkLegCuLIncluir.getCaption(), !bGXsfl_108_Refreshing);
         chkLegCuLIncluir.setCheckedValue( "false" );
         A2321LegCuLIncluir = GXutil.strtobool( GXutil.booltostr( A2321LegCuLIncluir)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkLegCuLIncluir.getInternalname(),GXutil.booltostr( A2321LegCuLIncluir),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "LEGCULRECALC_" + sGXsfl_108_idx ;
         chkLegCuLRecalc.setName( GXCCtl );
         chkLegCuLRecalc.setWebtags( "" );
         chkLegCuLRecalc.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkLegCuLRecalc.getInternalname(), "TitleCaption", chkLegCuLRecalc.getCaption(), !bGXsfl_108_Refreshing);
         chkLegCuLRecalc.setCheckedValue( "false" );
         A2322LegCuLRecalc = GXutil.strtobool( GXutil.booltostr( A2322LegCuLRecalc)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkLegCuLRecalc.getInternalname(),GXutil.booltostr( A2322LegCuLRecalc),"","",Integer.valueOf(0),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegCueAntAbr_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCueAntAbr_Internalname,A2328LegCueAntAbr,"","","'"+""+"'"+",false,"+"'"+""+"'","","",edtLegCueAntAbr_Tooltiptext,"",edtLegCueAntAbr_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegCueAntAbr_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuenLicPerIni_Internalname,localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"),localUtil.format( A2244LegCuenLicPerIni, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuenLicPerIni_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuenLicPerFin_Internalname,localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"),localUtil.format( A2245LegCuenLicPerFin, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuenLicPerFin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuenDiasCorres_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuenDiasCorres_Internalname,GXutil.ltrim( localUtil.ntoc( A2247LegCuenDiasCorres, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2247LegCuenDiasCorres), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuenDiasCorres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuenDiasCorres_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuLiPAnt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLiPAnt_Internalname,GXutil.ltrim( localUtil.ntoc( A2303LegCuLiPAnt, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2303LegCuLiPAnt), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLiPAnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuLiPAnt_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuLActVen_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLActVen_Internalname,GXutil.ltrim( localUtil.ntoc( A2315LegCuLActVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2315LegCuLActVen), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLActVen_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuLActVen_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuLiPVen_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLiPVen_Internalname,GXutil.ltrim( localUtil.ntoc( A2304LegCuLiPVen, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2304LegCuLiPVen), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLiPVen_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuLiPVen_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuLiPCur_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLiPCur_Internalname,GXutil.ltrim( localUtil.ntoc( A2302LegCuLiPCur, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2302LegCuLiPCur), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLiPCur_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuLiPCur_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuLiPApr_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLiPApr_Internalname,GXutil.ltrim( localUtil.ntoc( A2306LegCuLiPApr, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2306LegCuLiPApr), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuLiPApr_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegCuLiPApr_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuenDiasGoz_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuenDiasGoz_Internalname,GXutil.ltrim( localUtil.ntoc( A2248LegCuenDiasGoz, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2248LegCuenDiasGoz), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","",edtLegCuenDiasGoz_Tooltiptext,"",edtLegCuenDiasGoz_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuenDiasGoz_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCuLiPSaldo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuLiPSaldo_Internalname,GXutil.ltrim( localUtil.ntoc( A2305LegCuLiPSaldo, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2305LegCuLiPSaldo), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","",edtLegCuLiPSaldo_Tooltiptext,"",edtLegCuLiPSaldo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuLiPSaldo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV88Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV19Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavConsumido_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConsumido_Internalname,GXutil.rtrim( AV10Consumido),"","","'"+""+"'"+",false,"+"'"+""+"'","","",edtavConsumido_Tooltiptext,"",edtavConsumido_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavConsumido_Visible),Integer.valueOf(edtavConsumido_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV90VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV37ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesOO2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_108_idx = ((subGrid_Islastpage==1)&&(nGXsfl_108_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_108_idx+1) ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
      }
      /* End function sendrow_1082 */
   }

   public void startgridcontrol108( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"108\">") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuenAnio_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegIdNomApe_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegCuenLicTpo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCueAntAbr_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Antiguedad para vacaciones", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuenDiasCorres_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Corresponden", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuLiPAnt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pendientes anteriores", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuLActVen_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pendientes actuales a vencer", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuLiPVen_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pendientes vencidas", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuLiPCur_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Asignación pendiente", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuLiPApr_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Aprobación pendiente", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuenDiasGoz_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Aprobadas", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuLiPSaldo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total disponible", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavConsumido_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Consumido", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
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
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2266LegCuenAnio, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLegCuenAnio_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuenAnio_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
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
         GridColumn.AddObjectProperty("Value", A250LegIdNomApe);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegIdNomApe_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2243LegCuenLicTpo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegCuenLicTpo.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2321LegCuLIncluir));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A2322LegCuLRecalc));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2328LegCueAntAbr);
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLegCueAntAbr_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCueAntAbr_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A2244LegCuenLicPerIni, "99/99/9999"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A2245LegCuenLicPerFin, "99/99/9999"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2247LegCuenDiasCorres, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuenDiasCorres_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2303LegCuLiPAnt, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuLiPAnt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2315LegCuLActVen, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuLActVen_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2304LegCuLiPVen, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuLiPVen_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2302LegCuLiPCur, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuLiPCur_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2306LegCuLiPApr, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuLiPApr_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2248LegCuenDiasGoz, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLegCuenDiasGoz_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuenDiasGoz_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2305LegCuLiPSaldo, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLegCuLiPSaldo_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuLiPSaldo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV88Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV19Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV10Consumido));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConsumido_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavConsumido_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavConsumido_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV90VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV37ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      lblTotaltext_Internalname = "TOTALTEXT" ;
      lblCouttext_Internalname = "COUTTEXT" ;
      divTabletotal_Internalname = "TABLETOTAL" ;
      tblTabletotalregistros_Internalname = "TABLETOTALREGISTROS" ;
      lblButtonexport1_textblock_svg_Internalname = "BUTTONEXPORT1_TEXTBLOCK_SVG" ;
      divButtonexport1_table_svg_Internalname = "BUTTONEXPORT1_TABLE_SVG" ;
      lblButtonexport1_textblock_texto_Internalname = "BUTTONEXPORT1_TEXTBLOCK_TEXTO" ;
      divButtonexport1_table_texto_Internalname = "BUTTONEXPORT1_TABLE_TEXTO" ;
      Buttonexport1_a3lexport_Internalname = "BUTTONEXPORT1_A3LEXPORT" ;
      divButtonexport1_tablecontentbuttonimport_Internalname = "BUTTONEXPORT1_TABLECONTENTBUTTONIMPORT" ;
      Ddo_gridcolumnsselector_Internalname = "DDO_GRIDCOLUMNSSELECTOR" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      bttBtnexport_Internalname = "BTNEXPORT" ;
      lblButtonfilter1_textblock_svg_Internalname = "BUTTONFILTER1_TEXTBLOCK_SVG" ;
      divButtonfilter1_table_svg_Internalname = "BUTTONFILTER1_TABLE_SVG" ;
      lblButtonfilter1_textblock_texto_Internalname = "BUTTONFILTER1_TEXTBLOCK_TEXTO" ;
      divButtonfilter1_table_texto_Internalname = "BUTTONFILTER1_TABLE_TEXTO" ;
      lblButtonfilter1_textblockbadgecount_Internalname = "BUTTONFILTER1_TEXTBLOCKBADGECOUNT" ;
      tblButtonfilter1_tablebadge_Internalname = "BUTTONFILTER1_TABLEBADGE" ;
      divButtonfilter1_filtros_Internalname = "BUTTONFILTER1_FILTROS" ;
      Buttonfilter1_a3lfilter_Internalname = "BUTTONFILTER1_A3LFILTER" ;
      divButtonfilter1_tablecontent_Internalname = "BUTTONFILTER1_TABLECONTENT" ;
      tblTablefiltros_Internalname = "TABLEFILTROS" ;
      divTablefiltrospadre_Internalname = "TABLEFILTROSPADRE" ;
      edtLegCuenAnio_Internalname = "LEGCUENANIO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE" ;
      cmbLegCuenLicTpo.setInternalname( "LEGCUENLICTPO" );
      chkLegCuLIncluir.setInternalname( "LEGCULINCLUIR" );
      chkLegCuLRecalc.setInternalname( "LEGCULRECALC" );
      edtLegCueAntAbr_Internalname = "LEGCUEANTABR" ;
      edtLegCuenLicPerIni_Internalname = "LEGCUENLICPERINI" ;
      edtLegCuenLicPerFin_Internalname = "LEGCUENLICPERFIN" ;
      edtLegCuenDiasCorres_Internalname = "LEGCUENDIASCORRES" ;
      edtLegCuLiPAnt_Internalname = "LEGCULIPANT" ;
      edtLegCuLActVen_Internalname = "LEGCULACTVEN" ;
      edtLegCuLiPVen_Internalname = "LEGCULIPVEN" ;
      edtLegCuLiPCur_Internalname = "LEGCULIPCUR" ;
      edtLegCuLiPApr_Internalname = "LEGCULIPAPR" ;
      edtLegCuenDiasGoz_Internalname = "LEGCUENDIASGOZ" ;
      edtLegCuLiPSaldo_Internalname = "LEGCULIPSALDO" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavConsumido_Internalname = "vCONSUMIDO" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      bttBtninicializar_Internalname = "BTNINICIALIZAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavModificarsvg_Jsonclick = "" ;
      edtavModificarsvg_Columnclass = "WWColumn" ;
      edtavModificarsvg_Link = "" ;
      edtavModificarsvg_Enabled = 0 ;
      edtavModificarsvg_Format = (short)(0) ;
      edtavVersvg_Jsonclick = "" ;
      edtavVersvg_Columnclass = "WWColumn" ;
      edtavVersvg_Link = "" ;
      edtavVersvg_Enabled = 0 ;
      edtavVersvg_Format = (short)(0) ;
      edtavConsumido_Jsonclick = "" ;
      edtavConsumido_Tooltiptext = "" ;
      edtavConsumido_Enabled = 0 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtLegCuLiPSaldo_Jsonclick = "" ;
      edtLegCuLiPSaldo_Tooltiptext = "" ;
      edtLegCuenDiasGoz_Jsonclick = "" ;
      edtLegCuenDiasGoz_Tooltiptext = "" ;
      edtLegCuLiPApr_Jsonclick = "" ;
      edtLegCuLiPCur_Jsonclick = "" ;
      edtLegCuLiPVen_Jsonclick = "" ;
      edtLegCuLActVen_Jsonclick = "" ;
      edtLegCuLiPAnt_Jsonclick = "" ;
      edtLegCuenDiasCorres_Jsonclick = "" ;
      edtLegCuenLicPerFin_Jsonclick = "" ;
      edtLegCuenLicPerIni_Jsonclick = "" ;
      edtLegCueAntAbr_Jsonclick = "" ;
      edtLegCueAntAbr_Tooltiptext = "" ;
      chkLegCuLRecalc.setCaption( "" );
      chkLegCuLIncluir.setCaption( "" );
      cmbLegCuenLicTpo.setJsonclick( "" );
      edtLegIdNomApe_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtLegCuenAnio_Jsonclick = "" ;
      edtLegCuenAnio_Tooltiptext = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavUpdate_Visible = -1 ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtavConsumido_Visible = -1 ;
      edtLegCuLiPSaldo_Visible = -1 ;
      edtLegCuenDiasGoz_Visible = -1 ;
      edtLegCuLiPApr_Visible = -1 ;
      edtLegCuLiPCur_Visible = -1 ;
      edtLegCuLiPVen_Visible = -1 ;
      edtLegCuLActVen_Visible = -1 ;
      edtLegCuLiPAnt_Visible = -1 ;
      edtLegCuenDiasCorres_Visible = -1 ;
      edtLegCueAntAbr_Visible = -1 ;
      cmbLegCuenLicTpo.setVisible( -1 );
      edtLegIdNomApe_Visible = -1 ;
      edtLegCuenAnio_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      bttBtninicializar_Visible = 1 ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0||||4.0|4.0|4.0|4.0|4.0|4.0|4.0|4.0|" ;
      Ddo_grid_Datalistproc = "legajo_cuenta_licenciasWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||Vacaciones:Vacaciones||||||||||" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|||||||||" ;
      Ddo_grid_Datalisttype = "|Dynamic|FixedValues|Dynamic|||||||||" ;
      Ddo_grid_Includedatalist = "|T|T|T|||||||||" ;
      Ddo_grid_Filterisrange = "T||||T|T|T|T|T|T|T|T|" ;
      Ddo_grid_Filtertype = "Numeric|Character||Character|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|Numeric|" ;
      Ddo_grid_Includefilter = "T|T||T|T|T|T|T|T|T|T|T|" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|||T|||T||||||" ;
      Ddo_grid_Columnssortvalues = "|||2|||3||||||" ;
      Ddo_grid_Columnids = "0:LegCuenAnio|4:LegIdNomApe|5:LegCuenLicTpo|8:LegCueAntAbr|11:LegCuenDiasCorres|12:LegCuLiPAnt|13:LegCuLActVen|14:LegCuLiPVen|15:LegCuLiPCur|16:LegCuLiPApr|17:LegCuenDiasGoz|18:LegCuLiPSaldo|21:Consumido" ;
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
      Buttonfilter1_a3lfilter_Filter_orig = "" ;
      Buttonfilter1_a3lfilter_A3l_filter_id = "" ;
      Buttonfilter1_a3lfilter_Observer = "" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Ddo_gridcolumnsselector_Dropdownoptionstype = "GridColumnsSelector" ;
      Ddo_gridcolumnsselector_Cls = "ColumnsSelector" ;
      Ddo_gridcolumnsselector_Tooltip = "WWP_EditColumnsTooltip" ;
      Ddo_gridcolumnsselector_Caption = httpContext.getMessage( "Columnas", "") ;
      Ddo_gridcolumnsselector_Icon = "fas fa-cog" ;
      Ddo_gridcolumnsselector_Icontype = "FontIcon" ;
      Buttonexport1_a3lexport_Boton_orig_id = "" ;
      Buttonexport1_a3lexport_Boton_clon_id = "" ;
      Buttonexport1_a3lexport_Observer = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " legajo_cuenta_licencias", "") );
      subGrid_Rows = 0 ;
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
      AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV92WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92WelcomeMessage_NoMostrarMas", AV92WelcomeMessage_NoMostrarMas);
      GXCCtl = "LEGCUENLICTPO_" + sGXsfl_108_idx ;
      cmbLegCuenLicTpo.setName( GXCCtl );
      cmbLegCuenLicTpo.setWebtags( "" );
      cmbLegCuenLicTpo.addItem("Vacaciones", httpContext.getMessage( "Vacaciones", ""), (short)(0));
      if ( cmbLegCuenLicTpo.getItemCount() > 0 )
      {
         A2243LegCuenLicTpo = cmbLegCuenLicTpo.getValidValue(A2243LegCuenLicTpo) ;
      }
      GXCCtl = "LEGCULINCLUIR_" + sGXsfl_108_idx ;
      chkLegCuLIncluir.setName( GXCCtl );
      chkLegCuLIncluir.setWebtags( "" );
      chkLegCuLIncluir.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLegCuLIncluir.getInternalname(), "TitleCaption", chkLegCuLIncluir.getCaption(), !bGXsfl_108_Refreshing);
      chkLegCuLIncluir.setCheckedValue( "false" );
      A2321LegCuLIncluir = GXutil.strtobool( GXutil.booltostr( A2321LegCuLIncluir)) ;
      GXCCtl = "LEGCULRECALC_" + sGXsfl_108_idx ;
      chkLegCuLRecalc.setName( GXCCtl );
      chkLegCuLRecalc.setWebtags( "" );
      chkLegCuLRecalc.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLegCuLRecalc.getInternalname(), "TitleCaption", chkLegCuLRecalc.getCaption(), !bGXsfl_108_Refreshing);
      chkLegCuLRecalc.setCheckedValue( "false" );
      A2322LegCuLRecalc = GXutil.strtobool( GXutil.booltostr( A2322LegCuLRecalc)) ;
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV112Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegCuenAnio_Visible',ctrl:'LEGCUENANIO',prop:'Visible'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'cmbLegCuenLicTpo'},{av:'edtLegCueAntAbr_Visible',ctrl:'LEGCUEANTABR',prop:'Visible'},{av:'edtLegCuenDiasCorres_Visible',ctrl:'LEGCUENDIASCORRES',prop:'Visible'},{av:'edtLegCuLiPAnt_Visible',ctrl:'LEGCULIPANT',prop:'Visible'},{av:'edtLegCuLActVen_Visible',ctrl:'LEGCULACTVEN',prop:'Visible'},{av:'edtLegCuLiPVen_Visible',ctrl:'LEGCULIPVEN',prop:'Visible'},{av:'edtLegCuLiPCur_Visible',ctrl:'LEGCULIPCUR',prop:'Visible'},{av:'edtLegCuLiPApr_Visible',ctrl:'LEGCULIPAPR',prop:'Visible'},{av:'edtLegCuenDiasGoz_Visible',ctrl:'LEGCUENDIASGOZ',prop:'Visible'},{av:'edtLegCuLiPSaldo_Visible',ctrl:'LEGCULIPSALDO',prop:'Visible'},{av:'edtavConsumido_Visible',ctrl:'vCONSUMIDO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV23GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV24GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV22GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV97ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13OO2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV112Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14OO2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV112Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15OO2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV112Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV51TFLegCueAntAbr_SelsJson',fld:'vTFLEGCUEANTABR_SELSJSON',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV66TFLegCuenLicTpo_SelsJson',fld:'vTFLEGCUENLICTPO_SELSJSON',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV83TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e21OO2',iparms:[{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'cmbLegCuenLicTpo'},{av:'A2243LegCuenLicTpo',fld:'LEGCUENLICTPO',pic:''},{av:'A2266LegCuenAnio',fld:'LEGCUENANIO',pic:'ZZZ9'},{av:'A2301LegCueAntTexto',fld:'LEGCUEANTTEXTO',pic:''},{av:'A2244LegCuenLicPerIni',fld:'LEGCUENLICPERINI',pic:''},{av:'A2245LegCuenLicPerFin',fld:'LEGCUENLICPERFIN',pic:''},{av:'A2329LegCuLLogDis',fld:'LEGCULLOGDIS',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV88Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV19Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV90VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV37ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtLegCuenDiasGoz_Tooltiptext',ctrl:'LEGCUENDIASGOZ',prop:'Tooltiptext'},{av:'AV10Consumido',fld:'vCONSUMIDO',pic:''},{av:'edtavConsumido_Tooltiptext',ctrl:'vCONSUMIDO',prop:'Tooltiptext'},{av:'edtLegCueAntAbr_Tooltiptext',ctrl:'LEGCUEANTABR',prop:'Tooltiptext'},{av:'edtLegCuenAnio_Tooltiptext',ctrl:'LEGCUENANIO',prop:'Tooltiptext'},{av:'edtLegCuLiPSaldo_Tooltiptext',ctrl:'LEGCULIPSALDO',prop:'Tooltiptext'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11OO2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV112Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLegCuenAnio_Visible',ctrl:'LEGCUENANIO',prop:'Visible'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'cmbLegCuenLicTpo'},{av:'edtLegCueAntAbr_Visible',ctrl:'LEGCUEANTABR',prop:'Visible'},{av:'edtLegCuenDiasCorres_Visible',ctrl:'LEGCUENDIASCORRES',prop:'Visible'},{av:'edtLegCuLiPAnt_Visible',ctrl:'LEGCULIPANT',prop:'Visible'},{av:'edtLegCuLActVen_Visible',ctrl:'LEGCULACTVEN',prop:'Visible'},{av:'edtLegCuLiPVen_Visible',ctrl:'LEGCULIPVEN',prop:'Visible'},{av:'edtLegCuLiPCur_Visible',ctrl:'LEGCULIPCUR',prop:'Visible'},{av:'edtLegCuLiPApr_Visible',ctrl:'LEGCULIPAPR',prop:'Visible'},{av:'edtLegCuenDiasGoz_Visible',ctrl:'LEGCUENDIASGOZ',prop:'Visible'},{av:'edtLegCuLiPSaldo_Visible',ctrl:'LEGCULIPSALDO',prop:'Visible'},{av:'edtavConsumido_Visible',ctrl:'vCONSUMIDO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV23GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV24GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV22GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV97ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12OO2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV112Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV83TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV66TFLegCuenLicTpo_SelsJson',fld:'vTFLEGCUENLICTPO_SELSJSON',pic:''},{av:'AV51TFLegCueAntAbr_SelsJson',fld:'vTFLEGCUEANTABR_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV99ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV25GridState',fld:'vGRIDSTATE',pic:''},{av:'AV38OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV40OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV55TFLegCuenAnio',fld:'vTFLEGCUENANIO',pic:'ZZZ9'},{av:'AV56TFLegCuenAnio_To',fld:'vTFLEGCUENANIO_TO',pic:'ZZZ9'},{av:'AV81TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV82TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV65TFLegCuenLicTpo_Sels',fld:'vTFLEGCUENLICTPO_SELS',pic:''},{av:'AV49TFLegCueAntAbr',fld:'vTFLEGCUEANTABR',pic:''},{av:'AV50TFLegCueAntAbr_Sels',fld:'vTFLEGCUEANTABR_SELS',pic:''},{av:'AV57TFLegCuenDiasCorres',fld:'vTFLEGCUENDIASCORRES',pic:'ZZZ9'},{av:'AV58TFLegCuenDiasCorres_To',fld:'vTFLEGCUENDIASCORRES_TO',pic:'ZZZ9'},{av:'AV70TFLegCuLiPAnt',fld:'vTFLEGCULIPANT',pic:'ZZZ9'},{av:'AV71TFLegCuLiPAnt_To',fld:'vTFLEGCULIPANT_TO',pic:'ZZZ9'},{av:'AV67TFLegCuLActVen',fld:'vTFLEGCULACTVEN',pic:'ZZZ9'},{av:'AV68TFLegCuLActVen_To',fld:'vTFLEGCULACTVEN_TO',pic:'ZZZ9'},{av:'AV78TFLegCuLiPVen',fld:'vTFLEGCULIPVEN',pic:'ZZZ9'},{av:'AV79TFLegCuLiPVen_To',fld:'vTFLEGCULIPVEN_TO',pic:'ZZZ9'},{av:'AV74TFLegCuLiPCur',fld:'vTFLEGCULIPCUR',pic:'ZZZ9'},{av:'AV75TFLegCuLiPCur_To',fld:'vTFLEGCULIPCUR_TO',pic:'ZZZ9'},{av:'AV72TFLegCuLiPApr',fld:'vTFLEGCULIPAPR',pic:'ZZZ9'},{av:'AV73TFLegCuLiPApr_To',fld:'vTFLEGCULIPAPR_TO',pic:'ZZZ9'},{av:'AV59TFLegCuenDiasGoz',fld:'vTFLEGCUENDIASGOZ',pic:'ZZZ9'},{av:'AV60TFLegCuenDiasGoz_To',fld:'vTFLEGCUENDIASGOZ_TO',pic:'ZZZ9'},{av:'AV76TFLegCuLiPSaldo',fld:'vTFLEGCULIPSALDO',pic:'ZZZ9'},{av:'AV77TFLegCuLiPSaldo_To',fld:'vTFLEGCULIPSALDO_TO',pic:'ZZZ9'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV51TFLegCueAntAbr_SelsJson',fld:'vTFLEGCUEANTABR_SELSJSON',pic:''},{av:'AV66TFLegCuenLicTpo_SelsJson',fld:'vTFLEGCUENLICTPO_SELSJSON',pic:''},{av:'AV83TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegCuenAnio_Visible',ctrl:'LEGCUENANIO',prop:'Visible'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'cmbLegCuenLicTpo'},{av:'edtLegCueAntAbr_Visible',ctrl:'LEGCUEANTABR',prop:'Visible'},{av:'edtLegCuenDiasCorres_Visible',ctrl:'LEGCUENDIASCORRES',prop:'Visible'},{av:'edtLegCuLiPAnt_Visible',ctrl:'LEGCULIPANT',prop:'Visible'},{av:'edtLegCuLActVen_Visible',ctrl:'LEGCULACTVEN',prop:'Visible'},{av:'edtLegCuLiPVen_Visible',ctrl:'LEGCULIPVEN',prop:'Visible'},{av:'edtLegCuLiPCur_Visible',ctrl:'LEGCULIPCUR',prop:'Visible'},{av:'edtLegCuLiPApr_Visible',ctrl:'LEGCULIPAPR',prop:'Visible'},{av:'edtLegCuenDiasGoz_Visible',ctrl:'LEGCUENDIASGOZ',prop:'Visible'},{av:'edtLegCuLiPSaldo_Visible',ctrl:'LEGCULIPSALDO',prop:'Visible'},{av:'edtavConsumido_Visible',ctrl:'vCONSUMIDO',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'AV23GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV24GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV22GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV31IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV97ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINICIALIZAR'","{handler:'e16OO2',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINICIALIZAR'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e17OO2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e18OO2',iparms:[{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV36MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e22OO1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Modificarsvg',iparms:[]");
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
      wcpOAV36MenuOpcCod = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_gridcolumnsselector_Columnsselectorvalues = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV36MenuOpcCod = "" ;
      AV7ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV112Pgmname = "" ;
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV81TFLegIdNomApe = "" ;
      AV82TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65TFLegCuenLicTpo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFLegCueAntAbr = "" ;
      AV50TFLegCueAntAbr_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV17DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV97ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV22GridAppliedFilters = "" ;
      A2301LegCueAntTexto = "" ;
      A2329LegCuLLogDis = "" ;
      AV83TFLegIdNomApe_SelsJson = "" ;
      AV66TFLegCuenLicTpo_SelsJson = "" ;
      AV51TFLegCueAntAbr_SelsJson = "" ;
      Ddo_gridcolumnsselector_Gridinternalname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtninicializar_Jsonclick = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A250LegIdNomApe = "" ;
      A2243LegCuenLicTpo = "" ;
      A2328LegCueAntAbr = "" ;
      A2244LegCuenLicPerIni = GXutil.nullDate() ;
      A2245LegCuenLicPerFin = GXutil.nullDate() ;
      AV88Update = "" ;
      AV19Display = "" ;
      AV10Consumido = "" ;
      AV90VerSVG = "" ;
      AV37ModificarSVG = "" ;
      AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = "" ;
      lV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = "" ;
      AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape = "" ;
      AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr = "" ;
      H00OO2_A2301LegCueAntTexto = new String[] {""} ;
      H00OO2_A2329LegCuLLogDis = new String[] {""} ;
      H00OO2_A2305LegCuLiPSaldo = new short[1] ;
      H00OO2_A2248LegCuenDiasGoz = new short[1] ;
      H00OO2_A2306LegCuLiPApr = new short[1] ;
      H00OO2_A2302LegCuLiPCur = new short[1] ;
      H00OO2_A2304LegCuLiPVen = new short[1] ;
      H00OO2_A2315LegCuLActVen = new short[1] ;
      H00OO2_A2303LegCuLiPAnt = new short[1] ;
      H00OO2_A2247LegCuenDiasCorres = new short[1] ;
      H00OO2_A2245LegCuenLicPerFin = new java.util.Date[] {GXutil.nullDate()} ;
      H00OO2_A2244LegCuenLicPerIni = new java.util.Date[] {GXutil.nullDate()} ;
      H00OO2_A2328LegCueAntAbr = new String[] {""} ;
      H00OO2_A2322LegCuLRecalc = new boolean[] {false} ;
      H00OO2_A2321LegCuLIncluir = new boolean[] {false} ;
      H00OO2_A2243LegCuenLicTpo = new String[] {""} ;
      H00OO2_A250LegIdNomApe = new String[] {""} ;
      H00OO2_A6LegNumero = new int[1] ;
      H00OO2_A1EmpCod = new short[1] ;
      H00OO2_A3CliCod = new int[1] ;
      H00OO2_A2266LegCuenAnio = new short[1] ;
      H00OO3_AGRID_nRecordCount = new long[1] ;
      AV91WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV27HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV32MenuBienveImgURL = "" ;
      AV34MenuBienveTitulo = "" ;
      AV33MenuBienveTexto = "" ;
      AV111Welcomemessage_foto_GXI = "" ;
      AV108observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV42parmvalue = "" ;
      GXv_int4 = new int[1] ;
      AV93WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV45Session = httpContext.getWebSession();
      AV9ColumnsSelectorXML = "" ;
      AV104MenuOpcTitulo = "" ;
      GXv_int2 = new short[1] ;
      AV107filtrosTexto = "" ;
      AV5aprobadosTxt = "" ;
      AV43porcentaje = DecimalUtil.ZERO ;
      GXv_decimal14 = new java.math.BigDecimal[1] ;
      AV94consumidosTxt = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV98ManageFiltersXml = "" ;
      AV95ExcelFilename = "" ;
      AV96ErrorMessage = "" ;
      AV89UserCustomValue = "" ;
      AV8ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector16 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19 = new GXBaseCollection[1] ;
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char11 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char20 = "" ;
      GXt_char12 = "" ;
      GXv_char8 = new String[1] ;
      GXv_SdtWWPGridState21 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV86TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV48textoNoMostrara = "" ;
      GXv_char9 = new String[1] ;
      GXv_boolean10 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      lblButtonfilter1_textblockbadgecount_Jsonclick = "" ;
      lblTotaltext_Jsonclick = "" ;
      lblCouttext_Jsonclick = "" ;
      lblWelcomemessage_descripcion_Jsonclick = "" ;
      lblWelcomemessage_titulo_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_cuenta_licenciasww__default(),
         new Object[] {
             new Object[] {
            H00OO2_A2301LegCueAntTexto, H00OO2_A2329LegCuLLogDis, H00OO2_A2305LegCuLiPSaldo, H00OO2_A2248LegCuenDiasGoz, H00OO2_A2306LegCuLiPApr, H00OO2_A2302LegCuLiPCur, H00OO2_A2304LegCuLiPVen, H00OO2_A2315LegCuLActVen, H00OO2_A2303LegCuLiPAnt, H00OO2_A2247LegCuenDiasCorres,
            H00OO2_A2245LegCuenLicPerFin, H00OO2_A2244LegCuenLicPerIni, H00OO2_A2328LegCueAntAbr, H00OO2_A2322LegCuLRecalc, H00OO2_A2321LegCuLIncluir, H00OO2_A2243LegCuenLicTpo, H00OO2_A250LegIdNomApe, H00OO2_A6LegNumero, H00OO2_A1EmpCod, H00OO2_A3CliCod,
            H00OO2_A2266LegCuenAnio
            }
            , new Object[] {
            H00OO3_AGRID_nRecordCount
            }
         }
      );
      AV112Pgmname = "legajo_cuenta_licenciasWW" ;
      /* GeneXus formulas. */
      AV112Pgmname = "legajo_cuenta_licenciasWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavConsumido_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV99ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
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
   private short AV55TFLegCuenAnio ;
   private short AV56TFLegCuenAnio_To ;
   private short AV57TFLegCuenDiasCorres ;
   private short AV58TFLegCuenDiasCorres_To ;
   private short AV70TFLegCuLiPAnt ;
   private short AV71TFLegCuLiPAnt_To ;
   private short AV67TFLegCuLActVen ;
   private short AV68TFLegCuLActVen_To ;
   private short AV78TFLegCuLiPVen ;
   private short AV79TFLegCuLiPVen_To ;
   private short AV74TFLegCuLiPCur ;
   private short AV75TFLegCuLiPCur_To ;
   private short AV72TFLegCuLiPApr ;
   private short AV73TFLegCuLiPApr_To ;
   private short AV59TFLegCuenDiasGoz ;
   private short AV60TFLegCuenDiasGoz_To ;
   private short AV76TFLegCuLiPSaldo ;
   private short AV77TFLegCuLiPSaldo_To ;
   private short AV38OrderedBy ;
   private short AV21EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2247LegCuenDiasCorres ;
   private short A2303LegCuLiPAnt ;
   private short A2315LegCuLActVen ;
   private short A2304LegCuLiPVen ;
   private short A2302LegCuLiPCur ;
   private short A2306LegCuLiPApr ;
   private short A2248LegCuenDiasGoz ;
   private short A2305LegCuLiPSaldo ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio ;
   private short AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ;
   private short AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ;
   private short AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ;
   private short AV122Legajo_cuenta_licenciaswwds_10_tflegculipant ;
   private short AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to ;
   private short AV124Legajo_cuenta_licenciaswwds_12_tflegculactven ;
   private short AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to ;
   private short AV126Legajo_cuenta_licenciaswwds_14_tflegculipven ;
   private short AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to ;
   private short AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur ;
   private short AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ;
   private short AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr ;
   private short AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ;
   private short AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ;
   private short AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ;
   private short AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ;
   private short AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV6CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtninicializar_Visible ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavConsumido_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ;
   private int AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ;
   private int AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int edtLegCuenAnio_Visible ;
   private int edtLegIdNomApe_Visible ;
   private int edtLegCueAntAbr_Visible ;
   private int edtLegCuenDiasCorres_Visible ;
   private int edtLegCuLiPAnt_Visible ;
   private int edtLegCuLActVen_Visible ;
   private int edtLegCuLiPVen_Visible ;
   private int edtLegCuLiPCur_Visible ;
   private int edtLegCuLiPApr_Visible ;
   private int edtLegCuenDiasGoz_Visible ;
   private int edtLegCuLiPSaldo_Visible ;
   private int edtavConsumido_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV106filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV41PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int AV136GXV1 ;
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
   private java.math.BigDecimal AV43porcentaje ;
   private java.math.BigDecimal GXv_decimal14[] ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_gridcolumnsselector_Columnsselectorvalues ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_108_idx="0001" ;
   private String AV112Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Buttonexport1_a3lexport_Observer ;
   private String Buttonexport1_a3lexport_Boton_clon_id ;
   private String Buttonexport1_a3lexport_Boton_orig_id ;
   private String Ddo_gridcolumnsselector_Icontype ;
   private String Ddo_gridcolumnsselector_Icon ;
   private String Ddo_gridcolumnsselector_Caption ;
   private String Ddo_gridcolumnsselector_Tooltip ;
   private String Ddo_gridcolumnsselector_Cls ;
   private String Ddo_gridcolumnsselector_Dropdownoptionstype ;
   private String Ddo_gridcolumnsselector_Gridinternalname ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Buttonfilter1_a3lfilter_Observer ;
   private String Buttonfilter1_a3lfilter_A3l_filter_id ;
   private String Buttonfilter1_a3lfilter_Filter_orig ;
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
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String bttBtninicializar_Internalname ;
   private String bttBtninicializar_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtLegCuenAnio_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtLegIdNomApe_Internalname ;
   private String A2243LegCuenLicTpo ;
   private String edtLegCueAntAbr_Internalname ;
   private String edtLegCuenLicPerIni_Internalname ;
   private String edtLegCuenLicPerFin_Internalname ;
   private String edtLegCuenDiasCorres_Internalname ;
   private String edtLegCuLiPAnt_Internalname ;
   private String edtLegCuLActVen_Internalname ;
   private String edtLegCuLiPVen_Internalname ;
   private String edtLegCuLiPCur_Internalname ;
   private String edtLegCuLiPApr_Internalname ;
   private String edtLegCuenDiasGoz_Internalname ;
   private String edtLegCuLiPSaldo_Internalname ;
   private String AV88Update ;
   private String edtavUpdate_Internalname ;
   private String AV19Display ;
   private String edtavDisplay_Internalname ;
   private String AV10Consumido ;
   private String edtavConsumido_Internalname ;
   private String AV90VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV37ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String scmdbuf ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV108observerPalabra ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String bttBtnexport_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavUpdate_Link ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtLegCuenDiasGoz_Tooltiptext ;
   private String edtavConsumido_Tooltiptext ;
   private String edtLegCueAntAbr_Tooltiptext ;
   private String edtLegCuenAnio_Tooltiptext ;
   private String edtLegCuLiPSaldo_Tooltiptext ;
   private String GXt_char11 ;
   private String GXv_char7[] ;
   private String GXt_char20 ;
   private String GXt_char12 ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String lblWelcomemessage_combotext_Caption ;
   private String lblWelcomemessage_combotext_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String tblTablepadding_Internalname ;
   private String divWelcomemessage_welcometableprincipal_Internalname ;
   private String divWelcomemessage_tableclose_Internalname ;
   private String lblWelcomemessage_closehelp_Jsonclick ;
   private String divWelcomemessage_welcomecontentitem_Internalname ;
   private String divWelcomemessage_welcomecontentflex_Internalname ;
   private String divWelcomemessage_welcometableimagen_Internalname ;
   private String imgavWelcomemessage_foto_gximage ;
   private String sImgUrl ;
   private String divWelcomemessage_tabletexto_Internalname ;
   private String divWelcomemessage_welcomebottomitem_Internalname ;
   private String divWelcomemessage_tablecmb_Internalname ;
   private String divWelcomemessage_tablec_Internalname ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblTablefiltros_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtnexport_Jsonclick ;
   private String divButtonfilter1_filtros_Internalname ;
   private String divButtonfilter1_table_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Internalname ;
   private String lblButtonfilter1_textblock_svg_Jsonclick ;
   private String divButtonfilter1_table_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Internalname ;
   private String lblButtonfilter1_textblock_texto_Jsonclick ;
   private String lblButtonfilter1_textblockbadgecount_Jsonclick ;
   private String tblTabletotalregistros_Internalname ;
   private String divTabletotal_Internalname ;
   private String lblTotaltext_Internalname ;
   private String lblTotaltext_Jsonclick ;
   private String lblCouttext_Jsonclick ;
   private String tblWelcomemessage_tabledescripcion_Internalname ;
   private String lblWelcomemessage_descripcion_Jsonclick ;
   private String tblWelcomemessage_tabletitulo_Internalname ;
   private String lblWelcomemessage_titulo_Jsonclick ;
   private String sGXsfl_108_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtLegCuenAnio_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegIdNomApe_Jsonclick ;
   private String GXCCtl ;
   private String edtLegCueAntAbr_Jsonclick ;
   private String edtLegCuenLicPerIni_Jsonclick ;
   private String edtLegCuenLicPerFin_Jsonclick ;
   private String edtLegCuenDiasCorres_Jsonclick ;
   private String edtLegCuLiPAnt_Jsonclick ;
   private String edtLegCuLActVen_Jsonclick ;
   private String edtLegCuLiPVen_Jsonclick ;
   private String edtLegCuLiPCur_Jsonclick ;
   private String edtLegCuLiPApr_Jsonclick ;
   private String edtLegCuenDiasGoz_Jsonclick ;
   private String edtLegCuLiPSaldo_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavConsumido_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A2244LegCuenLicPerIni ;
   private java.util.Date A2245LegCuenLicPerFin ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV40OrderedDsc ;
   private boolean AV31IsAuthorized_Update ;
   private boolean AV92WelcomeMessage_NoMostrarMas ;
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
   private boolean A2321LegCuLIncluir ;
   private boolean A2322LegCuLRecalc ;
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV35MenuBienveVisible ;
   private boolean AV47testEs ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean17 ;
   private boolean GXv_boolean10[] ;
   private boolean AV91WelcomeMessage_Foto_IsBlob ;
   private String A2301LegCueAntTexto ;
   private String A2329LegCuLLogDis ;
   private String AV83TFLegIdNomApe_SelsJson ;
   private String AV66TFLegCuenLicTpo_SelsJson ;
   private String AV51TFLegCueAntAbr_SelsJson ;
   private String AV33MenuBienveTexto ;
   private String AV42parmvalue ;
   private String AV9ColumnsSelectorXML ;
   private String AV98ManageFiltersXml ;
   private String AV89UserCustomValue ;
   private String AV48textoNoMostrara ;
   private String wcpOAV36MenuOpcCod ;
   private String AV36MenuOpcCod ;
   private String AV81TFLegIdNomApe ;
   private String AV49TFLegCueAntAbr ;
   private String AV22GridAppliedFilters ;
   private String A250LegIdNomApe ;
   private String A2328LegCueAntAbr ;
   private String lV115Legajo_cuenta_licenciaswwds_3_tflegidnomape ;
   private String lV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr ;
   private String AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape ;
   private String AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr ;
   private String AV32MenuBienveImgURL ;
   private String AV34MenuBienveTitulo ;
   private String AV111Welcomemessage_foto_GXI ;
   private String AV104MenuOpcTitulo ;
   private String AV107filtrosTexto ;
   private String AV5aprobadosTxt ;
   private String AV94consumidosTxt ;
   private String AV95ExcelFilename ;
   private String AV96ErrorMessage ;
   private String AV91WelcomeMessage_Foto ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV27HTTPRequest ;
   private com.genexus.webpanels.WebSession AV45Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ;
   private GXSimpleCollection<String> AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbLegCuenLicTpo ;
   private ICheckbox chkLegCuLIncluir ;
   private ICheckbox chkLegCuLRecalc ;
   private IDataStoreProvider pr_default ;
   private String[] H00OO2_A2301LegCueAntTexto ;
   private String[] H00OO2_A2329LegCuLLogDis ;
   private short[] H00OO2_A2305LegCuLiPSaldo ;
   private short[] H00OO2_A2248LegCuenDiasGoz ;
   private short[] H00OO2_A2306LegCuLiPApr ;
   private short[] H00OO2_A2302LegCuLiPCur ;
   private short[] H00OO2_A2304LegCuLiPVen ;
   private short[] H00OO2_A2315LegCuLActVen ;
   private short[] H00OO2_A2303LegCuLiPAnt ;
   private short[] H00OO2_A2247LegCuenDiasCorres ;
   private java.util.Date[] H00OO2_A2245LegCuenLicPerFin ;
   private java.util.Date[] H00OO2_A2244LegCuenLicPerIni ;
   private String[] H00OO2_A2328LegCueAntAbr ;
   private boolean[] H00OO2_A2322LegCuLRecalc ;
   private boolean[] H00OO2_A2321LegCuLIncluir ;
   private String[] H00OO2_A2243LegCuenLicTpo ;
   private String[] H00OO2_A250LegIdNomApe ;
   private int[] H00OO2_A6LegNumero ;
   private short[] H00OO2_A1EmpCod ;
   private int[] H00OO2_A3CliCod ;
   private short[] H00OO2_A2266LegCuenAnio ;
   private long[] H00OO3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV65TFLegCuenLicTpo_Sels ;
   private GXSimpleCollection<String> AV82TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV50TFLegCueAntAbr_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV97ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item18 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item19[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV7ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV8ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector16[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState21[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV86TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV93WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
}

final  class legajo_cuenta_licenciasww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00OO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                          String A2243LegCuenLicTpo ,
                                          GXSimpleCollection<String> AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                          String A2328LegCueAntAbr ,
                                          GXSimpleCollection<String> AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                          short AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio ,
                                          short AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ,
                                          int AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ,
                                          String AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                          int AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ,
                                          int AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ,
                                          String AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                          short AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ,
                                          short AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ,
                                          short AV122Legajo_cuenta_licenciaswwds_10_tflegculipant ,
                                          short AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to ,
                                          short AV124Legajo_cuenta_licenciaswwds_12_tflegculactven ,
                                          short AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to ,
                                          short AV126Legajo_cuenta_licenciaswwds_14_tflegculipven ,
                                          short AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to ,
                                          short AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur ,
                                          short AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ,
                                          short AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr ,
                                          short AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ,
                                          short AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ,
                                          short AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ,
                                          short AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ,
                                          short AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ,
                                          short A2266LegCuenAnio ,
                                          short A2247LegCuenDiasCorres ,
                                          short A2303LegCuLiPAnt ,
                                          short A2315LegCuLActVen ,
                                          short A2304LegCuLiPVen ,
                                          short A2302LegCuLiPCur ,
                                          short A2306LegCuLiPApr ,
                                          short A2248LegCuenDiasGoz ,
                                          short A2305LegCuLiPSaldo ,
                                          short AV38OrderedBy ,
                                          boolean AV40OrderedDsc ,
                                          short A1EmpCod ,
                                          short AV21EmpCod ,
                                          int AV6CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[26];
      Object[] GXv_Object23 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.LegCueAntTexto, T1.LegCuLLogDis, T1.LegCuLiPSaldo, T1.LegCuenDiasGoz, T1.LegCuLiPApr, T1.LegCuLiPCur, T1.LegCuLiPVen, T1.LegCuLActVen, T1.LegCuLiPAnt, T1.LegCuenDiasCorres," ;
      sSelectString += " T1.LegCuenLicPerFin, T1.LegCuenLicPerIni, T1.LegCueAntAbr, T1.LegCuLRecalc, T1.LegCuLIncluir, T1.LegCuenLicTpo, T2.LegIdNomApe, T1.LegNumero, T1.EmpCod, T1.CliCod," ;
      sSelectString += " T1.LegCuenAnio" ;
      sFromString = " FROM (legajo_cuenta_licencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio >= ?)");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( ! (0==AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio <= ?)");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( ( AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels, "T1.LegCuenLicTpo IN (", ")")+")");
      }
      if ( ( AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegCueAntAbr) like LOWER(?))");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels, "T1.LegCueAntAbr IN (", ")")+")");
      }
      if ( ! (0==AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres >= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( ! (0==AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres <= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (0==AV122Legajo_cuenta_licenciaswwds_10_tflegculipant) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt >= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( ! (0==AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt <= ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ! (0==AV124Legajo_cuenta_licenciaswwds_12_tflegculactven) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen >= ?)");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( ! (0==AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen <= ?)");
      }
      else
      {
         GXv_int22[12] = (byte)(1) ;
      }
      if ( ! (0==AV126Legajo_cuenta_licenciaswwds_14_tflegculipven) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen >= ?)");
      }
      else
      {
         GXv_int22[13] = (byte)(1) ;
      }
      if ( ! (0==AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen <= ?)");
      }
      else
      {
         GXv_int22[14] = (byte)(1) ;
      }
      if ( ! (0==AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur >= ?)");
      }
      else
      {
         GXv_int22[15] = (byte)(1) ;
      }
      if ( ! (0==AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur <= ?)");
      }
      else
      {
         GXv_int22[16] = (byte)(1) ;
      }
      if ( ! (0==AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr >= ?)");
      }
      else
      {
         GXv_int22[17] = (byte)(1) ;
      }
      if ( ! (0==AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr <= ?)");
      }
      else
      {
         GXv_int22[18] = (byte)(1) ;
      }
      if ( ! (0==AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz >= ?)");
      }
      else
      {
         GXv_int22[19] = (byte)(1) ;
      }
      if ( ! (0==AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz <= ?)");
      }
      else
      {
         GXv_int22[20] = (byte)(1) ;
      }
      if ( ! (0==AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo >= ?)");
      }
      else
      {
         GXv_int22[21] = (byte)(1) ;
      }
      if ( ! (0==AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo <= ?)");
      }
      else
      {
         GXv_int22[22] = (byte)(1) ;
      }
      if ( AV38OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio DESC" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ! AV40OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LegCueAntAbr, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ( AV40OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LegCueAntAbr DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ! AV40OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LegCuLActVen, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ( AV40OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LegCuLActVen DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegCuenLicTpo, T1.LegCuenAnio" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_H00OO3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels ,
                                          String A2243LegCuenLicTpo ,
                                          GXSimpleCollection<String> AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels ,
                                          String A2328LegCueAntAbr ,
                                          GXSimpleCollection<String> AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels ,
                                          short AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio ,
                                          short AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to ,
                                          int AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size ,
                                          String AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape ,
                                          int AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size ,
                                          int AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size ,
                                          String AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr ,
                                          short AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres ,
                                          short AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to ,
                                          short AV122Legajo_cuenta_licenciaswwds_10_tflegculipant ,
                                          short AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to ,
                                          short AV124Legajo_cuenta_licenciaswwds_12_tflegculactven ,
                                          short AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to ,
                                          short AV126Legajo_cuenta_licenciaswwds_14_tflegculipven ,
                                          short AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to ,
                                          short AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur ,
                                          short AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to ,
                                          short AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr ,
                                          short AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to ,
                                          short AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz ,
                                          short AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to ,
                                          short AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo ,
                                          short AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to ,
                                          short A2266LegCuenAnio ,
                                          short A2247LegCuenDiasCorres ,
                                          short A2303LegCuLiPAnt ,
                                          short A2315LegCuLActVen ,
                                          short A2304LegCuLiPVen ,
                                          short A2302LegCuLiPCur ,
                                          short A2306LegCuLiPApr ,
                                          short A2248LegCuenDiasGoz ,
                                          short A2305LegCuLiPSaldo ,
                                          short AV38OrderedBy ,
                                          boolean AV40OrderedDsc ,
                                          short A1EmpCod ,
                                          short AV21EmpCod ,
                                          int AV6CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[23];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (legajo_cuenta_licencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV113Legajo_cuenta_licenciaswwds_1_tflegcuenanio) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio >= ?)");
      }
      else
      {
         GXv_int25[3] = (byte)(1) ;
      }
      if ( ! (0==AV114Legajo_cuenta_licenciaswwds_2_tflegcuenanio_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenAnio <= ?)");
      }
      else
      {
         GXv_int25[4] = (byte)(1) ;
      }
      if ( ( AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV115Legajo_cuenta_licenciaswwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int25[5] = (byte)(1) ;
      }
      if ( AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV116Legajo_cuenta_licenciaswwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117Legajo_cuenta_licenciaswwds_5_tflegcuenlictpo_sels, "T1.LegCuenLicTpo IN (", ")")+")");
      }
      if ( ( AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV118Legajo_cuenta_licenciaswwds_6_tflegcueantabr)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegCueAntAbr) like LOWER(?))");
      }
      else
      {
         GXv_int25[6] = (byte)(1) ;
      }
      if ( AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV119Legajo_cuenta_licenciaswwds_7_tflegcueantabr_sels, "T1.LegCueAntAbr IN (", ")")+")");
      }
      if ( ! (0==AV120Legajo_cuenta_licenciaswwds_8_tflegcuendiascorres) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres >= ?)");
      }
      else
      {
         GXv_int25[7] = (byte)(1) ;
      }
      if ( ! (0==AV121Legajo_cuenta_licenciaswwds_9_tflegcuendiascorres_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasCorres <= ?)");
      }
      else
      {
         GXv_int25[8] = (byte)(1) ;
      }
      if ( ! (0==AV122Legajo_cuenta_licenciaswwds_10_tflegculipant) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt >= ?)");
      }
      else
      {
         GXv_int25[9] = (byte)(1) ;
      }
      if ( ! (0==AV123Legajo_cuenta_licenciaswwds_11_tflegculipant_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPAnt <= ?)");
      }
      else
      {
         GXv_int25[10] = (byte)(1) ;
      }
      if ( ! (0==AV124Legajo_cuenta_licenciaswwds_12_tflegculactven) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen >= ?)");
      }
      else
      {
         GXv_int25[11] = (byte)(1) ;
      }
      if ( ! (0==AV125Legajo_cuenta_licenciaswwds_13_tflegculactven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLActVen <= ?)");
      }
      else
      {
         GXv_int25[12] = (byte)(1) ;
      }
      if ( ! (0==AV126Legajo_cuenta_licenciaswwds_14_tflegculipven) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen >= ?)");
      }
      else
      {
         GXv_int25[13] = (byte)(1) ;
      }
      if ( ! (0==AV127Legajo_cuenta_licenciaswwds_15_tflegculipven_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPVen <= ?)");
      }
      else
      {
         GXv_int25[14] = (byte)(1) ;
      }
      if ( ! (0==AV128Legajo_cuenta_licenciaswwds_16_tflegculipcur) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur >= ?)");
      }
      else
      {
         GXv_int25[15] = (byte)(1) ;
      }
      if ( ! (0==AV129Legajo_cuenta_licenciaswwds_17_tflegculipcur_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPCur <= ?)");
      }
      else
      {
         GXv_int25[16] = (byte)(1) ;
      }
      if ( ! (0==AV130Legajo_cuenta_licenciaswwds_18_tflegculipapr) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr >= ?)");
      }
      else
      {
         GXv_int25[17] = (byte)(1) ;
      }
      if ( ! (0==AV131Legajo_cuenta_licenciaswwds_19_tflegculipapr_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPApr <= ?)");
      }
      else
      {
         GXv_int25[18] = (byte)(1) ;
      }
      if ( ! (0==AV132Legajo_cuenta_licenciaswwds_20_tflegcuendiasgoz) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz >= ?)");
      }
      else
      {
         GXv_int25[19] = (byte)(1) ;
      }
      if ( ! (0==AV133Legajo_cuenta_licenciaswwds_21_tflegcuendiasgoz_to) )
      {
         addWhere(sWhereString, "(T1.LegCuenDiasGoz <= ?)");
      }
      else
      {
         GXv_int25[20] = (byte)(1) ;
      }
      if ( ! (0==AV134Legajo_cuenta_licenciaswwds_22_tflegculipsaldo) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo >= ?)");
      }
      else
      {
         GXv_int25[21] = (byte)(1) ;
      }
      if ( ! (0==AV135Legajo_cuenta_licenciaswwds_23_tflegculipsaldo_to) )
      {
         addWhere(sWhereString, "(T1.LegCuLiPSaldo <= ?)");
      }
      else
      {
         GXv_int25[22] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV38OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ! AV40OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 2 ) && ( AV40OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ! AV40OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV38OrderedBy == 3 ) && ( AV40OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
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
                  return conditional_H00OO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() );
            case 1 :
                  return conditional_H00OO3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).shortValue() , ((Number) dynConstraints[37]).shortValue() , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00OO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00OO3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 20);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((int[]) buf[19])[0] = rslt.getInt(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
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
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[28]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 40);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[46]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[47]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[49]).intValue());
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[50]).intValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[51]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 40);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[38]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[40]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[41]).shortValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[42]).shortValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[43]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[44]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[45]).shortValue());
               }
               return;
      }
   }

}

