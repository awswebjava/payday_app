package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacion_export3_impl extends GXDataArea
{
   public liquidacion_export3_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacion_export3_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacion_export3_impl.class ));
   }

   public liquidacion_export3_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbLegFormaPago = new HTMLChoice();
      cmbLegBanTipCuen = new HTMLChoice();
      cmbLegModTra = new HTMLChoice();
      cmbLegClase = new HTMLChoice();
      cmbLegTipoTarifa = new HTMLChoice();
      cmbLegSexo = new HTMLChoice();
      chkLegSCVO = UIFactory.getCheckbox(this);
      cmbDTipoConCod = new HTMLChoice();
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
            AV134MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV134MenuOpcCod", AV134MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV134MenuOpcCod, ""))));
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
      AV26ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21ColumnsSelector);
      AV162Pgmname = httpContext.GetPar( "Pgmname") ;
      AV134MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV28TFLegId = httpContext.GetPar( "TFLegId") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29TFLegId_Sels);
      AV31TFLegNomApe = httpContext.GetPar( "TFLegNomApe") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32TFLegNomApe_Sels);
      AV34TFLiqNombre = httpContext.GetPar( "TFLiqNombre") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35TFLiqNombre_Sels);
      AV37TFSecDescrip = httpContext.GetPar( "TFSecDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38TFSecDescrip_Sels);
      AV144TFLegOsoDes = httpContext.GetPar( "TFLegOsoDes") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV145TFLegOsoDes_Sels);
      AV45TFLegCuentaBanc = httpContext.GetPar( "TFLegCuentaBanc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV46TFLegCuentaBanc_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV156TFLegModTra_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV48TFLegClase_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV158TFLegTipoTarifa_Sels);
      AV53TFLiqDescrip = httpContext.GetPar( "TFLiqDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV54TFLiqDescrip_Sels);
      AV56TFLiqFecha = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecha")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV57TFLiqFecha_Sels);
      AV60TFLiqPerSinDia = httpContext.GetPar( "TFLiqPerSinDia") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV61TFLiqPerSinDia_Sels);
      AV63TFTliqDesc = httpContext.GetPar( "TFTliqDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV64TFTliqDesc_Sels);
      AV66TFLiqFecPago = localUtil.parseDateParm( httpContext.GetPar( "TFLiqFecPago")) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV67TFLiqFecPago_Sels);
      AV70TFDConCodigo = httpContext.GetPar( "TFDConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV71TFDConCodigo_Sels);
      AV73TFDConDescrip = httpContext.GetPar( "TFDConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV74TFDConDescrip_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV76TFDTipoConCod_Sels);
      AV78TFConClasifAux = httpContext.GetPar( "TFConClasifAux") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV79TFConClasifAux_Sels);
      AV80TFLiqDCanti = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDCanti"), ".") ;
      AV81TFLiqDCanti_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDCanti_To"), ".") ;
      AV84TFLiqDImpCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpCalcu"), ".") ;
      AV85TFLiqDImpCalcu_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpCalcu_To"), ".") ;
      AV129TFLiqDLogRecal = httpContext.GetPar( "TFLiqDLogRecal") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV130TFLiqDLogRecal_Sels);
      AV82TFLiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu"), ".") ;
      AV83TFLiqDImpReCalcu_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu_To"), ".") ;
      AV98CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV99EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV136WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV162Pgmname, AV134MenuOpcCod, AV12GridState, AV14OrderedBy, AV15OrderedDsc, AV28TFLegId, AV29TFLegId_Sels, AV31TFLegNomApe, AV32TFLegNomApe_Sels, AV34TFLiqNombre, AV35TFLiqNombre_Sels, AV37TFSecDescrip, AV38TFSecDescrip_Sels, AV144TFLegOsoDes, AV145TFLegOsoDes_Sels, AV45TFLegCuentaBanc, AV46TFLegCuentaBanc_Sels, AV156TFLegModTra_Sels, AV48TFLegClase_Sels, AV158TFLegTipoTarifa_Sels, AV53TFLiqDescrip, AV54TFLiqDescrip_Sels, AV56TFLiqFecha, AV57TFLiqFecha_Sels, AV60TFLiqPerSinDia, AV61TFLiqPerSinDia_Sels, AV63TFTliqDesc, AV64TFTliqDesc_Sels, AV66TFLiqFecPago, AV67TFLiqFecPago_Sels, AV70TFDConCodigo, AV71TFDConCodigo_Sels, AV73TFDConDescrip, AV74TFDConDescrip_Sels, AV76TFDTipoConCod_Sels, AV78TFConClasifAux, AV79TFConClasifAux_Sels, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, AV129TFLiqDLogRecal, AV130TFLiqDLogRecal_Sels, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, AV98CliCod, AV99EmpCod, AV136WelcomeMessage_NoMostrarMas) ;
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
      paJ82( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startJ82( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.liquidacion_export3", new String[] {GXutil.URLEncode(GXutil.rtrim(AV134MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV162Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV134MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV99EmpCod), "ZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV86DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV86DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV21ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV24ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV24ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV88GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV89GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV90GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV26ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV162Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV162Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV134MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV134MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGID", GXutil.rtrim( AV28TFLegId));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGID_SELS", AV29TFLegId_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGID_SELS", AV29TFLegId_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGNOMAPE", AV31TFLegNomApe);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGNOMAPE_SELS", AV32TFLegNomApe_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGNOMAPE_SELS", AV32TFLegNomApe_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQNOMBRE", AV34TFLiqNombre);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQNOMBRE_SELS", AV35TFLiqNombre_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQNOMBRE_SELS", AV35TFLiqNombre_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECDESCRIP", AV37TFSecDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFSECDESCRIP_SELS", AV38TFSecDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFSECDESCRIP_SELS", AV38TFSecDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGOSODES", AV144TFLegOsoDes);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGOSODES_SELS", AV145TFLegOsoDes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGOSODES_SELS", AV145TFLegOsoDes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENTABANC", AV45TFLegCuentaBanc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGCUENTABANC_SELS", AV46TFLegCuentaBanc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGCUENTABANC_SELS", AV46TFLegCuentaBanc_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGMODTRA_SELS", AV156TFLegModTra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGMODTRA_SELS", AV156TFLegModTra_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGCLASE_SELS", AV48TFLegClase_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGCLASE_SELS", AV48TFLegClase_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGTIPOTARIFA_SELS", AV158TFLegTipoTarifa_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGTIPOTARIFA_SELS", AV158TFLegTipoTarifa_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDESCRIP", AV53TFLiqDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQDESCRIP_SELS", AV54TFLiqDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQDESCRIP_SELS", AV54TFLiqDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQFECHA", localUtil.dtoc( AV56TFLiqFecha, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQFECHA_SELS", AV57TFLiqFecha_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQFECHA_SELS", AV57TFLiqFecha_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQPERSINDIA", GXutil.rtrim( AV60TFLiqPerSinDia));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQPERSINDIA_SELS", AV61TFLiqPerSinDia_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQPERSINDIA_SELS", AV61TFLiqPerSinDia_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTLIQDESC", AV63TFTliqDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFTLIQDESC_SELS", AV64TFTliqDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFTLIQDESC_SELS", AV64TFTliqDesc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQFECPAGO", localUtil.dtoc( AV66TFLiqFecPago, 0, "/"));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQFECPAGO_SELS", AV67TFLiqFecPago_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQFECPAGO_SELS", AV67TFLiqFecPago_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONCODIGO", GXutil.rtrim( AV70TFDConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDCONCODIGO_SELS", AV71TFDConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDCONCODIGO_SELS", AV71TFDConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONDESCRIP", AV73TFDConDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDCONDESCRIP_SELS", AV74TFDConDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDCONDESCRIP_SELS", AV74TFDConDescrip_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDTIPOCONCOD_SELS", AV76TFDTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDTIPOCONCOD_SELS", AV76TFDTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX", AV78TFConClasifAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONCLASIFAUX_SELS", AV79TFConClasifAux_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONCLASIFAUX_SELS", AV79TFConClasifAux_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDCANTI", GXutil.ltrim( localUtil.ntoc( AV80TFLiqDCanti, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDCANTI_TO", GXutil.ltrim( localUtil.ntoc( AV81TFLiqDCanti_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPCALCU", GXutil.ltrim( localUtil.ntoc( AV84TFLiqDImpCalcu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPCALCU_TO", GXutil.ltrim( localUtil.ntoc( AV85TFLiqDImpCalcu_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDLOGRECAL", AV129TFLiqDLogRecal);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLIQDLOGRECAL_SELS", AV130TFLiqDLogRecal_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLIQDLOGRECAL_SELS", AV130TFLiqDLogRecal_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPRECALCU", GXutil.ltrim( localUtil.ntoc( AV82TFLiqDImpReCalcu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPRECALCU_TO", GXutil.ltrim( localUtil.ntoc( AV83TFLiqDImpReCalcu_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV98CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV99EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV99EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGID_SELSJSON", AV27TFLegId_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGNOMAPE_SELSJSON", AV30TFLegNomApe_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQNOMBRE_SELSJSON", AV33TFLiqNombre_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFSECDESCRIP_SELSJSON", AV36TFSecDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGOSODES_SELSJSON", AV143TFLegOsoDes_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCUENTABANC_SELSJSON", AV44TFLegCuentaBanc_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGMODTRA_SELSJSON", AV155TFLegModTra_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGCLASE_SELSJSON", AV47TFLegClase_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGTIPOTARIFA_SELSJSON", AV157TFLegTipoTarifa_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDESCRIP_SELSJSON", AV52TFLiqDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQFECHA_SELSJSON", AV55TFLiqFecha_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQPERSINDIA_SELSJSON", AV59TFLiqPerSinDia_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFTLIQDESC_SELSJSON", AV62TFTliqDesc_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQFECPAGO_SELSJSON", AV65TFLiqFecPago_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONCODIGO_SELSJSON", AV69TFDConCodigo_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONDESCRIP_SELSJSON", AV72TFDConDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDTIPOCONCOD_SELSJSON", AV75TFDTipoConCod_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONCLASIFAUX_SELSJSON", AV77TFConClasifAux_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDLOGRECAL_SELSJSON", AV128TFLiqDLogRecal_SelsJson);
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
         weJ82( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtJ82( ) ;
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
      return formatLink("web.liquidacion_export3", new String[] {GXutil.URLEncode(GXutil.rtrim(AV134MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "liquidacion_export3" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Detalle de liquidaciones", "") ;
   }

   public void wbJ80( )
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
         wb_table1_9_J82( true) ;
      }
      else
      {
         wb_table1_9_J82( false) ;
      }
      return  ;
   }

   public void wb_table1_9_J82e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV86DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.setProperty("HasColumnsSelector", Grid_empowerer_Hascolumnsselector);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 176,'',false,'" + sGXsfl_108_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDdo_liqfechaauxdate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqfechaauxdate_Internalname, localUtil.format(AV58DDO_LiqFechaAuxDate, "99/99/9999"), localUtil.format( AV58DDO_LiqFechaAuxDate, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,176);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqfechaauxdate_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_liquidacion_export3.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavDdo_liqfechaauxdate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_liquidacion_export3.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divDdo_liqfecpagoauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 178,'',false,'" + sGXsfl_108_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDdo_liqfecpagoauxdate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_liqfecpagoauxdate_Internalname, localUtil.format(AV68DDO_LiqFecPagoAuxDate, "99/99/9999"), localUtil.format( AV68DDO_LiqFecPagoAuxDate, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,178);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_liqfecpagoauxdate_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_liquidacion_export3.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavDdo_liqfecpagoauxdate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_liquidacion_export3.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void startJ82( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Detalle de liquidaciones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupJ80( ) ;
   }

   public void wsJ82( )
   {
      startJ82( ) ;
      evtJ82( ) ;
   }

   public void evtJ82( )
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
                           e11J82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12J82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13J82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14J82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15J82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16J82 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17J82 ();
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
                           A93LegId = httpContext.cgiGet( edtLegId_Internalname) ;
                           n93LegId = false ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A591LegNomApe = httpContext.cgiGet( edtLegNomApe_Internalname) ;
                           A239LegCUIL = localUtil.ctol( httpContext.cgiGet( edtLegCUIL_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A874LiqNombre = httpContext.cgiGet( edtLiqNombre_Internalname) ;
                           A937LegConveCodigo = httpContext.cgiGet( edtLegConveCodigo_Internalname) ;
                           n937LegConveCodigo = false ;
                           AV17ConveDescri = httpContext.cgiGet( edtavConvedescri_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavConvedescri_Internalname, AV17ConveDescri);
                           A939LegCatCodigo = httpContext.cgiGet( edtLegCatCodigo_Internalname) ;
                           n939LegCatCodigo = false ;
                           AV18CatDescrip = httpContext.cgiGet( edtavCatdescrip_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV18CatDescrip);
                           A1579LegSecCodigo = httpContext.cgiGet( edtLegSecCodigo_Internalname) ;
                           n1579LegSecCodigo = false ;
                           A329SecDescrip = httpContext.cgiGet( edtSecDescrip_Internalname) ;
                           n329SecDescrip = false ;
                           A20ZonCod = httpContext.cgiGet( edtZonCod_Internalname) ;
                           n20ZonCod = false ;
                           A342ZonDescrip = httpContext.cgiGet( edtZonDescrip_Internalname) ;
                           cmbLegFormaPago.setName( cmbLegFormaPago.getInternalname() );
                           cmbLegFormaPago.setValue( httpContext.cgiGet( cmbLegFormaPago.getInternalname()) );
                           A248LegFormaPago = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegFormaPago.getInternalname()))) ;
                           A15LegActCodigo = httpContext.cgiGet( edtLegActCodigo_Internalname) ;
                           n15LegActCodigo = false ;
                           A227LegActDescri = httpContext.cgiGet( edtLegActDescri_Internalname) ;
                           A2225LegOsoDes = httpContext.cgiGet( edtLegOsoDes_Internalname) ;
                           A2226LegOsoAfipCod = httpContext.cgiGet( edtLegOsoAfipCod_Internalname) ;
                           n2226LegOsoAfipCod = false ;
                           A910LegSinCod = httpContext.cgiGet( edtLegSinCod_Internalname) ;
                           n910LegSinCod = false ;
                           A245LegFecIngreso = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegFecIngreso_Internalname), 0)) ;
                           A244LegFecEgreso = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegFecEgreso_Internalname), 0)) ;
                           n244LegFecEgreso = false ;
                           A1583LegMegCodigo = httpContext.cgiGet( edtLegMegCodigo_Internalname) ;
                           n1583LegMegCodigo = false ;
                           A300MegDescrip = httpContext.cgiGet( edtMegDescrip_Internalname) ;
                           n300MegDescrip = false ;
                           A234LegCBU = httpContext.cgiGet( edtLegCBU_Internalname) ;
                           n234LegCBU = false ;
                           A2224LegBanDes = httpContext.cgiGet( edtLegBanDes_Internalname) ;
                           cmbLegBanTipCuen.setName( cmbLegBanTipCuen.getInternalname() );
                           cmbLegBanTipCuen.setValue( httpContext.cgiGet( cmbLegBanTipCuen.getInternalname()) );
                           A232LegBanTipCuen = httpContext.cgiGet( cmbLegBanTipCuen.getInternalname()) ;
                           n232LegBanTipCuen = false ;
                           A231LegBanSuc = GXutil.upper( httpContext.cgiGet( edtLegBanSuc_Internalname)) ;
                           n231LegBanSuc = false ;
                           A238LegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtLegCuentaBanc_Internalname)) ;
                           n238LegCuentaBanc = false ;
                           cmbLegModTra.setName( cmbLegModTra.getInternalname() );
                           cmbLegModTra.setValue( httpContext.cgiGet( cmbLegModTra.getInternalname()) );
                           A2404LegModTra = httpContext.cgiGet( cmbLegModTra.getInternalname()) ;
                           cmbLegClase.setName( cmbLegClase.getInternalname() );
                           cmbLegClase.setValue( httpContext.cgiGet( cmbLegClase.getInternalname()) );
                           A235LegClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegClase.getInternalname()))) ;
                           cmbLegTipoTarifa.setName( cmbLegTipoTarifa.getInternalname() );
                           cmbLegTipoTarifa.setValue( httpContext.cgiGet( cmbLegTipoTarifa.getInternalname()) );
                           A2417LegTipoTarifa = httpContext.cgiGet( cmbLegTipoTarifa.getInternalname()) ;
                           A236LegCodPos = GXutil.upper( httpContext.cgiGet( edtLegCodPos_Internalname)) ;
                           cmbLegSexo.setName( cmbLegSexo.getInternalname() );
                           cmbLegSexo.setValue( httpContext.cgiGet( cmbLegSexo.getInternalname()) );
                           A263LegSexo = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegSexo.getInternalname()))) ;
                           n263LegSexo = false ;
                           A246LegFecNac = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegFecNac_Internalname), 0)) ;
                           A262LegSCVO = GXutil.strtobool( httpContext.cgiGet( chkLegSCVO.getInternalname())) ;
                           A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A271LiqDescrip = httpContext.cgiGet( edtLiqDescrip_Internalname) ;
                           A98LiqFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecha_Internalname), 0)) ;
                           A513LiqPerSinDia = httpContext.cgiGet( edtLiqPerSinDia_Internalname) ;
                           A32TLiqCod = httpContext.cgiGet( edtTLiqCod_Internalname) ;
                           n32TLiqCod = false ;
                           A340TliqDesc = GXutil.upper( httpContext.cgiGet( edtTliqDesc_Internalname)) ;
                           A280LiqFecPago = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLiqFecPago_Internalname), 0)) ;
                           A394DConCodigo = httpContext.cgiGet( edtDConCodigo_Internalname) ;
                           A393DConDescrip = httpContext.cgiGet( edtDConDescrip_Internalname) ;
                           cmbDTipoConCod.setName( cmbDTipoConCod.getInternalname() );
                           cmbDTipoConCod.setValue( httpContext.cgiGet( cmbDTipoConCod.getInternalname()) );
                           A464DTipoConCod = httpContext.cgiGet( cmbDTipoConCod.getInternalname()) ;
                           AV127ConClasifAux = httpContext.cgiGet( edtavConclasifaux_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavConclasifaux_Internalname, AV127ConClasifAux);
                           A269LiqDCanti = localUtil.ctond( httpContext.cgiGet( edtLiqDCanti_Internalname)) ;
                           n269LiqDCanti = false ;
                           A275LiqDImpCalcu = localUtil.ctond( httpContext.cgiGet( edtLiqDImpCalcu_Internalname)) ;
                           n275LiqDImpCalcu = false ;
                           A876LiqDReFormulaHTML = httpContext.cgiGet( edtLiqDReFormulaHTML_Internalname) ;
                           n876LiqDReFormulaHTML = false ;
                           A508LiqDFormulaHTML = httpContext.cgiGet( edtLiqDFormulaHTML_Internalname) ;
                           n508LiqDFormulaHTML = false ;
                           A1072LiqDLogRecal = httpContext.cgiGet( edtLiqDLogRecal_Internalname) ;
                           A81LiqDSecuencial = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqDSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A270LiqDErrorDesc = httpContext.cgiGet( edtLiqDErrorDesc_Internalname) ;
                           n270LiqDErrorDesc = false ;
                           A764LiqDImpReCalcu = localUtil.ctond( httpContext.cgiGet( edtLiqDImpReCalcu_Internalname)) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18J82 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19J82 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20J82 ();
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

   public void weJ82( )
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

   public void paJ82( )
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
                                 byte AV26ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ,
                                 String AV162Pgmname ,
                                 String AV134MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 String AV28TFLegId ,
                                 GXSimpleCollection<String> AV29TFLegId_Sels ,
                                 String AV31TFLegNomApe ,
                                 GXSimpleCollection<String> AV32TFLegNomApe_Sels ,
                                 String AV34TFLiqNombre ,
                                 GXSimpleCollection<String> AV35TFLiqNombre_Sels ,
                                 String AV37TFSecDescrip ,
                                 GXSimpleCollection<String> AV38TFSecDescrip_Sels ,
                                 String AV144TFLegOsoDes ,
                                 GXSimpleCollection<String> AV145TFLegOsoDes_Sels ,
                                 String AV45TFLegCuentaBanc ,
                                 GXSimpleCollection<String> AV46TFLegCuentaBanc_Sels ,
                                 GXSimpleCollection<String> AV156TFLegModTra_Sels ,
                                 GXSimpleCollection<Byte> AV48TFLegClase_Sels ,
                                 GXSimpleCollection<String> AV158TFLegTipoTarifa_Sels ,
                                 String AV53TFLiqDescrip ,
                                 GXSimpleCollection<String> AV54TFLiqDescrip_Sels ,
                                 java.util.Date AV56TFLiqFecha ,
                                 GXSimpleCollection<java.util.Date> AV57TFLiqFecha_Sels ,
                                 String AV60TFLiqPerSinDia ,
                                 GXSimpleCollection<String> AV61TFLiqPerSinDia_Sels ,
                                 String AV63TFTliqDesc ,
                                 GXSimpleCollection<String> AV64TFTliqDesc_Sels ,
                                 java.util.Date AV66TFLiqFecPago ,
                                 GXSimpleCollection<java.util.Date> AV67TFLiqFecPago_Sels ,
                                 String AV70TFDConCodigo ,
                                 GXSimpleCollection<String> AV71TFDConCodigo_Sels ,
                                 String AV73TFDConDescrip ,
                                 GXSimpleCollection<String> AV74TFDConDescrip_Sels ,
                                 GXSimpleCollection<String> AV76TFDTipoConCod_Sels ,
                                 String AV78TFConClasifAux ,
                                 GXSimpleCollection<String> AV79TFConClasifAux_Sels ,
                                 java.math.BigDecimal AV80TFLiqDCanti ,
                                 java.math.BigDecimal AV81TFLiqDCanti_To ,
                                 java.math.BigDecimal AV84TFLiqDImpCalcu ,
                                 java.math.BigDecimal AV85TFLiqDImpCalcu_To ,
                                 String AV129TFLiqDLogRecal ,
                                 GXSimpleCollection<String> AV130TFLiqDLogRecal_Sels ,
                                 java.math.BigDecimal AV82TFLiqDImpReCalcu ,
                                 java.math.BigDecimal AV83TFLiqDImpReCalcu_To ,
                                 int AV98CliCod ,
                                 short AV99EmpCod ,
                                 boolean AV136WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19J82 ();
      GRID_nCurrentRecord = 0 ;
      rfJ82( ) ;
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
      AV136WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV136WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV136WelcomeMessage_NoMostrarMas", AV136WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfJ82( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV162Pgmname = "liquidacion_export3" ;
      Gx_err = (short)(0) ;
      edtavConvedescri_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConvedescri_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConvedescri_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavCatdescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCatdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCatdescrip_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavConclasifaux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConclasifaux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConclasifaux_Enabled), 5, 0), !bGXsfl_108_Refreshing);
   }

   public void rfJ82( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(108) ;
      /* Execute user event: Refresh */
      e19J82 ();
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
                                              A93LegId ,
                                              AV29TFLegId_Sels ,
                                              A591LegNomApe ,
                                              AV32TFLegNomApe_Sels ,
                                              A874LiqNombre ,
                                              AV35TFLiqNombre_Sels ,
                                              A329SecDescrip ,
                                              AV38TFSecDescrip_Sels ,
                                              A2225LegOsoDes ,
                                              AV145TFLegOsoDes_Sels ,
                                              A238LegCuentaBanc ,
                                              AV46TFLegCuentaBanc_Sels ,
                                              A2404LegModTra ,
                                              AV156TFLegModTra_Sels ,
                                              Byte.valueOf(A235LegClase) ,
                                              AV48TFLegClase_Sels ,
                                              A2417LegTipoTarifa ,
                                              AV158TFLegTipoTarifa_Sels ,
                                              A271LiqDescrip ,
                                              AV54TFLiqDescrip_Sels ,
                                              A98LiqFecha ,
                                              AV57TFLiqFecha_Sels ,
                                              A513LiqPerSinDia ,
                                              AV61TFLiqPerSinDia_Sels ,
                                              A340TliqDesc ,
                                              AV64TFTliqDesc_Sels ,
                                              A280LiqFecPago ,
                                              AV67TFLiqFecPago_Sels ,
                                              A394DConCodigo ,
                                              AV71TFDConCodigo_Sels ,
                                              A393DConDescrip ,
                                              AV74TFDConDescrip_Sels ,
                                              A464DTipoConCod ,
                                              AV76TFDTipoConCod_Sels ,
                                              A1072LiqDLogRecal ,
                                              AV130TFLiqDLogRecal_Sels ,
                                              Integer.valueOf(AV29TFLegId_Sels.size()) ,
                                              AV28TFLegId ,
                                              Integer.valueOf(AV32TFLegNomApe_Sels.size()) ,
                                              AV31TFLegNomApe ,
                                              Integer.valueOf(AV35TFLiqNombre_Sels.size()) ,
                                              AV34TFLiqNombre ,
                                              Integer.valueOf(AV38TFSecDescrip_Sels.size()) ,
                                              Integer.valueOf(AV145TFLegOsoDes_Sels.size()) ,
                                              Integer.valueOf(AV46TFLegCuentaBanc_Sels.size()) ,
                                              Integer.valueOf(AV156TFLegModTra_Sels.size()) ,
                                              Integer.valueOf(AV48TFLegClase_Sels.size()) ,
                                              Integer.valueOf(AV158TFLegTipoTarifa_Sels.size()) ,
                                              Integer.valueOf(AV54TFLiqDescrip_Sels.size()) ,
                                              Integer.valueOf(AV57TFLiqFecha_Sels.size()) ,
                                              Integer.valueOf(AV61TFLiqPerSinDia_Sels.size()) ,
                                              AV60TFLiqPerSinDia ,
                                              Integer.valueOf(AV64TFTliqDesc_Sels.size()) ,
                                              Integer.valueOf(AV67TFLiqFecPago_Sels.size()) ,
                                              Integer.valueOf(AV71TFDConCodigo_Sels.size()) ,
                                              AV70TFDConCodigo ,
                                              Integer.valueOf(AV74TFDConDescrip_Sels.size()) ,
                                              AV73TFDConDescrip ,
                                              Integer.valueOf(AV76TFDTipoConCod_Sels.size()) ,
                                              AV80TFLiqDCanti ,
                                              AV81TFLiqDCanti_To ,
                                              AV84TFLiqDImpCalcu ,
                                              AV85TFLiqDImpCalcu_To ,
                                              Integer.valueOf(AV130TFLiqDLogRecal_Sels.size()) ,
                                              AV129TFLiqDLogRecal ,
                                              AV82TFLiqDImpReCalcu ,
                                              AV83TFLiqDImpReCalcu_To ,
                                              A269LiqDCanti ,
                                              A275LiqDImpCalcu ,
                                              A764LiqDImpReCalcu ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV98CliCod) ,
                                              Short.valueOf(AV99EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT,
                                              TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV28TFLegId = GXutil.padr( GXutil.rtrim( AV28TFLegId), 20, "%") ;
         lV31TFLegNomApe = GXutil.concat( GXutil.rtrim( AV31TFLegNomApe), "%", "") ;
         lV34TFLiqNombre = GXutil.concat( GXutil.rtrim( AV34TFLiqNombre), "%", "") ;
         lV60TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV60TFLiqPerSinDia), 20, "%") ;
         lV70TFDConCodigo = GXutil.padr( GXutil.rtrim( AV70TFDConCodigo), 10, "%") ;
         lV73TFDConDescrip = GXutil.concat( GXutil.rtrim( AV73TFDConDescrip), "%", "") ;
         lV129TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV129TFLiqDLogRecal), "%", "") ;
         /* Using cursor H00J82 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV98CliCod), Short.valueOf(AV99EmpCod), lV28TFLegId, lV31TFLegNomApe, lV34TFLiqNombre, lV60TFLiqPerSinDia, lV70TFDConCodigo, lV73TFDConDescrip, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, lV129TFLiqDLogRecal, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_108_idx = 1 ;
         sGXsfl_108_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_108_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1082( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1580LegOsoCod = H00J82_A1580LegOsoCod[0] ;
            n1580LegOsoCod = H00J82_n1580LegOsoCod[0] ;
            A1582LegBanCod = H00J82_A1582LegBanCod[0] ;
            n1582LegBanCod = H00J82_n1582LegBanCod[0] ;
            A6LegNumero = H00J82_A6LegNumero[0] ;
            A764LiqDImpReCalcu = H00J82_A764LiqDImpReCalcu[0] ;
            A270LiqDErrorDesc = H00J82_A270LiqDErrorDesc[0] ;
            n270LiqDErrorDesc = H00J82_n270LiqDErrorDesc[0] ;
            A81LiqDSecuencial = H00J82_A81LiqDSecuencial[0] ;
            A1072LiqDLogRecal = H00J82_A1072LiqDLogRecal[0] ;
            A508LiqDFormulaHTML = H00J82_A508LiqDFormulaHTML[0] ;
            n508LiqDFormulaHTML = H00J82_n508LiqDFormulaHTML[0] ;
            A876LiqDReFormulaHTML = H00J82_A876LiqDReFormulaHTML[0] ;
            n876LiqDReFormulaHTML = H00J82_n876LiqDReFormulaHTML[0] ;
            A275LiqDImpCalcu = H00J82_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = H00J82_n275LiqDImpCalcu[0] ;
            A269LiqDCanti = H00J82_A269LiqDCanti[0] ;
            n269LiqDCanti = H00J82_n269LiqDCanti[0] ;
            A464DTipoConCod = H00J82_A464DTipoConCod[0] ;
            A393DConDescrip = H00J82_A393DConDescrip[0] ;
            A394DConCodigo = H00J82_A394DConCodigo[0] ;
            A280LiqFecPago = H00J82_A280LiqFecPago[0] ;
            A340TliqDesc = H00J82_A340TliqDesc[0] ;
            A32TLiqCod = H00J82_A32TLiqCod[0] ;
            n32TLiqCod = H00J82_n32TLiqCod[0] ;
            A513LiqPerSinDia = H00J82_A513LiqPerSinDia[0] ;
            A98LiqFecha = H00J82_A98LiqFecha[0] ;
            A271LiqDescrip = H00J82_A271LiqDescrip[0] ;
            A31LiqNro = H00J82_A31LiqNro[0] ;
            A262LegSCVO = H00J82_A262LegSCVO[0] ;
            A246LegFecNac = H00J82_A246LegFecNac[0] ;
            A263LegSexo = H00J82_A263LegSexo[0] ;
            n263LegSexo = H00J82_n263LegSexo[0] ;
            A236LegCodPos = H00J82_A236LegCodPos[0] ;
            A2417LegTipoTarifa = H00J82_A2417LegTipoTarifa[0] ;
            A235LegClase = H00J82_A235LegClase[0] ;
            A2404LegModTra = H00J82_A2404LegModTra[0] ;
            A238LegCuentaBanc = H00J82_A238LegCuentaBanc[0] ;
            n238LegCuentaBanc = H00J82_n238LegCuentaBanc[0] ;
            A231LegBanSuc = H00J82_A231LegBanSuc[0] ;
            n231LegBanSuc = H00J82_n231LegBanSuc[0] ;
            A232LegBanTipCuen = H00J82_A232LegBanTipCuen[0] ;
            n232LegBanTipCuen = H00J82_n232LegBanTipCuen[0] ;
            A2224LegBanDes = H00J82_A2224LegBanDes[0] ;
            A234LegCBU = H00J82_A234LegCBU[0] ;
            n234LegCBU = H00J82_n234LegCBU[0] ;
            A300MegDescrip = H00J82_A300MegDescrip[0] ;
            n300MegDescrip = H00J82_n300MegDescrip[0] ;
            A1583LegMegCodigo = H00J82_A1583LegMegCodigo[0] ;
            n1583LegMegCodigo = H00J82_n1583LegMegCodigo[0] ;
            A244LegFecEgreso = H00J82_A244LegFecEgreso[0] ;
            n244LegFecEgreso = H00J82_n244LegFecEgreso[0] ;
            A245LegFecIngreso = H00J82_A245LegFecIngreso[0] ;
            A910LegSinCod = H00J82_A910LegSinCod[0] ;
            n910LegSinCod = H00J82_n910LegSinCod[0] ;
            A2226LegOsoAfipCod = H00J82_A2226LegOsoAfipCod[0] ;
            n2226LegOsoAfipCod = H00J82_n2226LegOsoAfipCod[0] ;
            A2225LegOsoDes = H00J82_A2225LegOsoDes[0] ;
            A227LegActDescri = H00J82_A227LegActDescri[0] ;
            A15LegActCodigo = H00J82_A15LegActCodigo[0] ;
            n15LegActCodigo = H00J82_n15LegActCodigo[0] ;
            A248LegFormaPago = H00J82_A248LegFormaPago[0] ;
            A342ZonDescrip = H00J82_A342ZonDescrip[0] ;
            A20ZonCod = H00J82_A20ZonCod[0] ;
            n20ZonCod = H00J82_n20ZonCod[0] ;
            A329SecDescrip = H00J82_A329SecDescrip[0] ;
            n329SecDescrip = H00J82_n329SecDescrip[0] ;
            A1579LegSecCodigo = H00J82_A1579LegSecCodigo[0] ;
            n1579LegSecCodigo = H00J82_n1579LegSecCodigo[0] ;
            A939LegCatCodigo = H00J82_A939LegCatCodigo[0] ;
            n939LegCatCodigo = H00J82_n939LegCatCodigo[0] ;
            A937LegConveCodigo = H00J82_A937LegConveCodigo[0] ;
            n937LegConveCodigo = H00J82_n937LegConveCodigo[0] ;
            A874LiqNombre = H00J82_A874LiqNombre[0] ;
            A239LegCUIL = H00J82_A239LegCUIL[0] ;
            A591LegNomApe = H00J82_A591LegNomApe[0] ;
            A1EmpCod = H00J82_A1EmpCod[0] ;
            A3CliCod = H00J82_A3CliCod[0] ;
            A93LegId = H00J82_A93LegId[0] ;
            n93LegId = H00J82_n93LegId[0] ;
            A1580LegOsoCod = H00J82_A1580LegOsoCod[0] ;
            n1580LegOsoCod = H00J82_n1580LegOsoCod[0] ;
            A1582LegBanCod = H00J82_A1582LegBanCod[0] ;
            n1582LegBanCod = H00J82_n1582LegBanCod[0] ;
            A262LegSCVO = H00J82_A262LegSCVO[0] ;
            A246LegFecNac = H00J82_A246LegFecNac[0] ;
            A263LegSexo = H00J82_A263LegSexo[0] ;
            n263LegSexo = H00J82_n263LegSexo[0] ;
            A236LegCodPos = H00J82_A236LegCodPos[0] ;
            A2417LegTipoTarifa = H00J82_A2417LegTipoTarifa[0] ;
            A235LegClase = H00J82_A235LegClase[0] ;
            A2404LegModTra = H00J82_A2404LegModTra[0] ;
            A238LegCuentaBanc = H00J82_A238LegCuentaBanc[0] ;
            n238LegCuentaBanc = H00J82_n238LegCuentaBanc[0] ;
            A231LegBanSuc = H00J82_A231LegBanSuc[0] ;
            n231LegBanSuc = H00J82_n231LegBanSuc[0] ;
            A232LegBanTipCuen = H00J82_A232LegBanTipCuen[0] ;
            n232LegBanTipCuen = H00J82_n232LegBanTipCuen[0] ;
            A234LegCBU = H00J82_A234LegCBU[0] ;
            n234LegCBU = H00J82_n234LegCBU[0] ;
            A1583LegMegCodigo = H00J82_A1583LegMegCodigo[0] ;
            n1583LegMegCodigo = H00J82_n1583LegMegCodigo[0] ;
            A244LegFecEgreso = H00J82_A244LegFecEgreso[0] ;
            n244LegFecEgreso = H00J82_n244LegFecEgreso[0] ;
            A245LegFecIngreso = H00J82_A245LegFecIngreso[0] ;
            A910LegSinCod = H00J82_A910LegSinCod[0] ;
            n910LegSinCod = H00J82_n910LegSinCod[0] ;
            A15LegActCodigo = H00J82_A15LegActCodigo[0] ;
            n15LegActCodigo = H00J82_n15LegActCodigo[0] ;
            A248LegFormaPago = H00J82_A248LegFormaPago[0] ;
            A20ZonCod = H00J82_A20ZonCod[0] ;
            n20ZonCod = H00J82_n20ZonCod[0] ;
            A1579LegSecCodigo = H00J82_A1579LegSecCodigo[0] ;
            n1579LegSecCodigo = H00J82_n1579LegSecCodigo[0] ;
            A939LegCatCodigo = H00J82_A939LegCatCodigo[0] ;
            n939LegCatCodigo = H00J82_n939LegCatCodigo[0] ;
            A937LegConveCodigo = H00J82_A937LegConveCodigo[0] ;
            n937LegConveCodigo = H00J82_n937LegConveCodigo[0] ;
            A239LegCUIL = H00J82_A239LegCUIL[0] ;
            A591LegNomApe = H00J82_A591LegNomApe[0] ;
            A93LegId = H00J82_A93LegId[0] ;
            n93LegId = H00J82_n93LegId[0] ;
            A227LegActDescri = H00J82_A227LegActDescri[0] ;
            A342ZonDescrip = H00J82_A342ZonDescrip[0] ;
            A300MegDescrip = H00J82_A300MegDescrip[0] ;
            n300MegDescrip = H00J82_n300MegDescrip[0] ;
            A2226LegOsoAfipCod = H00J82_A2226LegOsoAfipCod[0] ;
            n2226LegOsoAfipCod = H00J82_n2226LegOsoAfipCod[0] ;
            A2225LegOsoDes = H00J82_A2225LegOsoDes[0] ;
            A329SecDescrip = H00J82_A329SecDescrip[0] ;
            n329SecDescrip = H00J82_n329SecDescrip[0] ;
            A2224LegBanDes = H00J82_A2224LegBanDes[0] ;
            A280LiqFecPago = H00J82_A280LiqFecPago[0] ;
            A32TLiqCod = H00J82_A32TLiqCod[0] ;
            n32TLiqCod = H00J82_n32TLiqCod[0] ;
            A513LiqPerSinDia = H00J82_A513LiqPerSinDia[0] ;
            A98LiqFecha = H00J82_A98LiqFecha[0] ;
            A271LiqDescrip = H00J82_A271LiqDescrip[0] ;
            A874LiqNombre = H00J82_A874LiqNombre[0] ;
            A340TliqDesc = H00J82_A340TliqDesc[0] ;
            e20J82 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(108) ;
         wbJ80( ) ;
      }
      bGXsfl_108_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesJ82( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV162Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV162Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV134MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV134MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV98CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV99EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV99EmpCod), "ZZZ9")));
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
                                           A93LegId ,
                                           AV29TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV32TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV35TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV38TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV145TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV46TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV156TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV48TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV158TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV54TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV57TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV61TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV64TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV67TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV71TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV74TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV76TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV130TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV29TFLegId_Sels.size()) ,
                                           AV28TFLegId ,
                                           Integer.valueOf(AV32TFLegNomApe_Sels.size()) ,
                                           AV31TFLegNomApe ,
                                           Integer.valueOf(AV35TFLiqNombre_Sels.size()) ,
                                           AV34TFLiqNombre ,
                                           Integer.valueOf(AV38TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV145TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV46TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV156TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV48TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV158TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV54TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV57TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV61TFLiqPerSinDia_Sels.size()) ,
                                           AV60TFLiqPerSinDia ,
                                           Integer.valueOf(AV64TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV67TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV71TFDConCodigo_Sels.size()) ,
                                           AV70TFDConCodigo ,
                                           Integer.valueOf(AV74TFDConDescrip_Sels.size()) ,
                                           AV73TFDConDescrip ,
                                           Integer.valueOf(AV76TFDTipoConCod_Sels.size()) ,
                                           AV80TFLiqDCanti ,
                                           AV81TFLiqDCanti_To ,
                                           AV84TFLiqDImpCalcu ,
                                           AV85TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV130TFLiqDLogRecal_Sels.size()) ,
                                           AV129TFLiqDLogRecal ,
                                           AV82TFLiqDImpReCalcu ,
                                           AV83TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV98CliCod) ,
                                           Short.valueOf(AV99EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV28TFLegId = GXutil.padr( GXutil.rtrim( AV28TFLegId), 20, "%") ;
      lV31TFLegNomApe = GXutil.concat( GXutil.rtrim( AV31TFLegNomApe), "%", "") ;
      lV34TFLiqNombre = GXutil.concat( GXutil.rtrim( AV34TFLiqNombre), "%", "") ;
      lV60TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV60TFLiqPerSinDia), 20, "%") ;
      lV70TFDConCodigo = GXutil.padr( GXutil.rtrim( AV70TFDConCodigo), 10, "%") ;
      lV73TFDConDescrip = GXutil.concat( GXutil.rtrim( AV73TFDConDescrip), "%", "") ;
      lV129TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV129TFLiqDLogRecal), "%", "") ;
      /* Using cursor H00J83 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV98CliCod), Short.valueOf(AV99EmpCod), lV28TFLegId, lV31TFLegNomApe, lV34TFLiqNombre, lV60TFLiqPerSinDia, lV70TFDConCodigo, lV73TFDConDescrip, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, lV129TFLiqDLogRecal, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To});
      GRID_nRecordCount = H00J83_AGRID_nRecordCount[0] ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV162Pgmname, AV134MenuOpcCod, AV12GridState, AV14OrderedBy, AV15OrderedDsc, AV28TFLegId, AV29TFLegId_Sels, AV31TFLegNomApe, AV32TFLegNomApe_Sels, AV34TFLiqNombre, AV35TFLiqNombre_Sels, AV37TFSecDescrip, AV38TFSecDescrip_Sels, AV144TFLegOsoDes, AV145TFLegOsoDes_Sels, AV45TFLegCuentaBanc, AV46TFLegCuentaBanc_Sels, AV156TFLegModTra_Sels, AV48TFLegClase_Sels, AV158TFLegTipoTarifa_Sels, AV53TFLiqDescrip, AV54TFLiqDescrip_Sels, AV56TFLiqFecha, AV57TFLiqFecha_Sels, AV60TFLiqPerSinDia, AV61TFLiqPerSinDia_Sels, AV63TFTliqDesc, AV64TFTliqDesc_Sels, AV66TFLiqFecPago, AV67TFLiqFecPago_Sels, AV70TFDConCodigo, AV71TFDConCodigo_Sels, AV73TFDConDescrip, AV74TFDConDescrip_Sels, AV76TFDTipoConCod_Sels, AV78TFConClasifAux, AV79TFConClasifAux_Sels, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, AV129TFLiqDLogRecal, AV130TFLiqDLogRecal_Sels, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, AV98CliCod, AV99EmpCod, AV136WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV162Pgmname, AV134MenuOpcCod, AV12GridState, AV14OrderedBy, AV15OrderedDsc, AV28TFLegId, AV29TFLegId_Sels, AV31TFLegNomApe, AV32TFLegNomApe_Sels, AV34TFLiqNombre, AV35TFLiqNombre_Sels, AV37TFSecDescrip, AV38TFSecDescrip_Sels, AV144TFLegOsoDes, AV145TFLegOsoDes_Sels, AV45TFLegCuentaBanc, AV46TFLegCuentaBanc_Sels, AV156TFLegModTra_Sels, AV48TFLegClase_Sels, AV158TFLegTipoTarifa_Sels, AV53TFLiqDescrip, AV54TFLiqDescrip_Sels, AV56TFLiqFecha, AV57TFLiqFecha_Sels, AV60TFLiqPerSinDia, AV61TFLiqPerSinDia_Sels, AV63TFTliqDesc, AV64TFTliqDesc_Sels, AV66TFLiqFecPago, AV67TFLiqFecPago_Sels, AV70TFDConCodigo, AV71TFDConCodigo_Sels, AV73TFDConDescrip, AV74TFDConDescrip_Sels, AV76TFDTipoConCod_Sels, AV78TFConClasifAux, AV79TFConClasifAux_Sels, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, AV129TFLiqDLogRecal, AV130TFLiqDLogRecal_Sels, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, AV98CliCod, AV99EmpCod, AV136WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV162Pgmname, AV134MenuOpcCod, AV12GridState, AV14OrderedBy, AV15OrderedDsc, AV28TFLegId, AV29TFLegId_Sels, AV31TFLegNomApe, AV32TFLegNomApe_Sels, AV34TFLiqNombre, AV35TFLiqNombre_Sels, AV37TFSecDescrip, AV38TFSecDescrip_Sels, AV144TFLegOsoDes, AV145TFLegOsoDes_Sels, AV45TFLegCuentaBanc, AV46TFLegCuentaBanc_Sels, AV156TFLegModTra_Sels, AV48TFLegClase_Sels, AV158TFLegTipoTarifa_Sels, AV53TFLiqDescrip, AV54TFLiqDescrip_Sels, AV56TFLiqFecha, AV57TFLiqFecha_Sels, AV60TFLiqPerSinDia, AV61TFLiqPerSinDia_Sels, AV63TFTliqDesc, AV64TFTliqDesc_Sels, AV66TFLiqFecPago, AV67TFLiqFecPago_Sels, AV70TFDConCodigo, AV71TFDConCodigo_Sels, AV73TFDConDescrip, AV74TFDConDescrip_Sels, AV76TFDTipoConCod_Sels, AV78TFConClasifAux, AV79TFConClasifAux_Sels, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, AV129TFLiqDLogRecal, AV130TFLiqDLogRecal_Sels, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, AV98CliCod, AV99EmpCod, AV136WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV162Pgmname, AV134MenuOpcCod, AV12GridState, AV14OrderedBy, AV15OrderedDsc, AV28TFLegId, AV29TFLegId_Sels, AV31TFLegNomApe, AV32TFLegNomApe_Sels, AV34TFLiqNombre, AV35TFLiqNombre_Sels, AV37TFSecDescrip, AV38TFSecDescrip_Sels, AV144TFLegOsoDes, AV145TFLegOsoDes_Sels, AV45TFLegCuentaBanc, AV46TFLegCuentaBanc_Sels, AV156TFLegModTra_Sels, AV48TFLegClase_Sels, AV158TFLegTipoTarifa_Sels, AV53TFLiqDescrip, AV54TFLiqDescrip_Sels, AV56TFLiqFecha, AV57TFLiqFecha_Sels, AV60TFLiqPerSinDia, AV61TFLiqPerSinDia_Sels, AV63TFTliqDesc, AV64TFTliqDesc_Sels, AV66TFLiqFecPago, AV67TFLiqFecPago_Sels, AV70TFDConCodigo, AV71TFDConCodigo_Sels, AV73TFDConDescrip, AV74TFDConDescrip_Sels, AV76TFDTipoConCod_Sels, AV78TFConClasifAux, AV79TFConClasifAux_Sels, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, AV129TFLiqDLogRecal, AV130TFLiqDLogRecal_Sels, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, AV98CliCod, AV99EmpCod, AV136WelcomeMessage_NoMostrarMas) ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV26ManageFiltersExecutionStep, AV21ColumnsSelector, AV162Pgmname, AV134MenuOpcCod, AV12GridState, AV14OrderedBy, AV15OrderedDsc, AV28TFLegId, AV29TFLegId_Sels, AV31TFLegNomApe, AV32TFLegNomApe_Sels, AV34TFLiqNombre, AV35TFLiqNombre_Sels, AV37TFSecDescrip, AV38TFSecDescrip_Sels, AV144TFLegOsoDes, AV145TFLegOsoDes_Sels, AV45TFLegCuentaBanc, AV46TFLegCuentaBanc_Sels, AV156TFLegModTra_Sels, AV48TFLegClase_Sels, AV158TFLegTipoTarifa_Sels, AV53TFLiqDescrip, AV54TFLiqDescrip_Sels, AV56TFLiqFecha, AV57TFLiqFecha_Sels, AV60TFLiqPerSinDia, AV61TFLiqPerSinDia_Sels, AV63TFTliqDesc, AV64TFTliqDesc_Sels, AV66TFLiqFecPago, AV67TFLiqFecPago_Sels, AV70TFDConCodigo, AV71TFDConCodigo_Sels, AV73TFDConDescrip, AV74TFDConDescrip_Sels, AV76TFDTipoConCod_Sels, AV78TFConClasifAux, AV79TFConClasifAux_Sels, AV80TFLiqDCanti, AV81TFLiqDCanti_To, AV84TFLiqDImpCalcu, AV85TFLiqDImpCalcu_To, AV129TFLiqDLogRecal, AV130TFLiqDLogRecal_Sels, AV82TFLiqDImpReCalcu, AV83TFLiqDImpReCalcu_To, AV98CliCod, AV99EmpCod, AV136WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV162Pgmname = "liquidacion_export3" ;
      Gx_err = (short)(0) ;
      edtavConvedescri_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConvedescri_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConvedescri_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavCatdescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCatdescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCatdescrip_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      edtavConclasifaux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConclasifaux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConclasifaux_Enabled), 5, 0), !bGXsfl_108_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupJ80( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18J82 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV86DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV21ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV24ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_108 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_108"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV88GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV89GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV90GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV142WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV136WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV136WelcomeMessage_NoMostrarMas", AV136WelcomeMessage_NoMostrarMas);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDdo_liqfechaauxdate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDDO_LIQFECHAAUXDATE");
            GX_FocusControl = edtavDdo_liqfechaauxdate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV58DDO_LiqFechaAuxDate = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58DDO_LiqFechaAuxDate", localUtil.format(AV58DDO_LiqFechaAuxDate, "99/99/9999"));
         }
         else
         {
            AV58DDO_LiqFechaAuxDate = localUtil.ctod( httpContext.cgiGet( edtavDdo_liqfechaauxdate_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV58DDO_LiqFechaAuxDate", localUtil.format(AV58DDO_LiqFechaAuxDate, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDdo_liqfecpagoauxdate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDDO_LIQFECPAGOAUXDATE");
            GX_FocusControl = edtavDdo_liqfecpagoauxdate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV68DDO_LiqFecPagoAuxDate = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68DDO_LiqFecPagoAuxDate", localUtil.format(AV68DDO_LiqFecPagoAuxDate, "99/99/9999"));
         }
         else
         {
            AV68DDO_LiqFecPagoAuxDate = localUtil.ctod( httpContext.cgiGet( edtavDdo_liqfecpagoauxdate_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68DDO_LiqFecPagoAuxDate", localUtil.format(AV68DDO_LiqFecPagoAuxDate, "99/99/9999"));
         }
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
      e18J82 ();
      if (returnInSub) return;
   }

   public void e18J82( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV134MenuOpcCod, "", "") ;
      GXt_int1 = AV99EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacion_export3_impl.this.GXt_int1 = GXv_int2[0] ;
      AV99EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV99EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV99EmpCod), "ZZZ9")));
      GXt_int3 = AV98CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacion_export3_impl.this.GXt_int3 = GXv_int4[0] ;
      AV98CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV98CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV9HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( "Detalle de liquidaciones", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV14OrderedBy < 1 )
      {
         AV14OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV86DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV86DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char7[0] = AV137MenuBienveImgURL ;
      GXv_char8[0] = AV139MenuBienveTitulo ;
      GXv_char9[0] = AV140MenuBienveTexto ;
      GXv_boolean10[0] = AV141MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV134MenuOpcCod, GXv_char7, GXv_char8, GXv_char9, GXv_boolean10) ;
      liquidacion_export3_impl.this.AV137MenuBienveImgURL = GXv_char7[0] ;
      liquidacion_export3_impl.this.AV139MenuBienveTitulo = GXv_char8[0] ;
      liquidacion_export3_impl.this.AV140MenuBienveTexto = GXv_char9[0] ;
      liquidacion_export3_impl.this.AV141MenuBienveVisible = GXv_boolean10[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV141MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV141MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV139MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV140MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV142WelcomeMessage_Foto = AV137MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV142WelcomeMessage_Foto)==0) ? AV161Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV142WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV142WelcomeMessage_Foto), true);
         AV161Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV137MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV142WelcomeMessage_Foto)==0) ? AV161Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV142WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV142WelcomeMessage_Foto), true);
      }
      GXt_char11 = "" ;
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char9) ;
      liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
      GXv_char8[0] = GXt_char11 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char12, GXv_char8) ;
      liquidacion_export3_impl.this.GXt_char11 = GXv_char8[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char11 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV151observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV151observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV151observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV151observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
   }

   public void e19J82( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV99EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacion_export3_impl.this.GXt_int1 = GXv_int2[0] ;
      AV99EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV99EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV99EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV99EmpCod), "ZZZ9")));
      GXt_int3 = AV98CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacion_export3_impl.this.GXt_int3 = GXv_int4[0] ;
      AV98CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV98CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      if ( AV26ManageFiltersExecutionStep == 1 )
      {
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV26ManageFiltersExecutionStep == 2 )
      {
         AV26ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV23Session.getValue("liquidacion_export3ColumnsSelector"), "") != 0 )
      {
         AV19ColumnsSelectorXML = AV23Session.getValue("liquidacion_export3ColumnsSelector") ;
         AV21ColumnsSelector.fromxml(AV19ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S162 ();
         if (returnInSub) return;
      }
      edtLegId_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegId_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegNomApe_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNomApe_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNomApe_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCUIL_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCUIL_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCUIL_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqNombre_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNombre_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNombre_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavConvedescri_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConvedescri_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConvedescri_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtavCatdescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCatdescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCatdescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtSecDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtZonDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtZonDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtZonDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegFormaPago.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegFormaPago.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegFormaPago.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtLegActCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegActCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegActCodigo_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegOsoDes_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegOsoDes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegOsoDes_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegOsoAfipCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegOsoAfipCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegOsoAfipCod_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegSinCod_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegSinCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegSinCod_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegFecIngreso_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegFecIngreso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegFecIngreso_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegFecEgreso_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegFecEgreso_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegFecEgreso_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtMegDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCBU_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCBU_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCBU_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegBanDes_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegBanDes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegBanDes_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegBanTipCuen.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegBanTipCuen.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegBanTipCuen.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtLegBanSuc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegBanSuc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegBanSuc_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCuentaBanc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+21)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCuentaBanc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCuentaBanc_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegModTra.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+22)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegModTra.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegModTra.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegClase.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+23)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegClase.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegClase.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegTipoTarifa.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+24)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegTipoTarifa.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegTipoTarifa.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtLegCodPos_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+25)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegCodPos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegCodPos_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbLegSexo.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+26)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegSexo.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegSexo.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtLegFecNac_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+27)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegFecNac_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegFecNac_Visible), 5, 0), !bGXsfl_108_Refreshing);
      chkLegSCVO.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+28)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkLegSCVO.getInternalname(), "Visible", GXutil.ltrimstr( chkLegSCVO.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqNro_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+29)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqNro_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+30)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqFecha_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+31)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqFecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecha_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqPerSinDia_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+32)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqPerSinDia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqPerSinDia_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtTliqDesc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+33)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTliqDesc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTliqDesc_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqFecPago_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+34)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqFecPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqFecPago_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtDConCodigo_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+35)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConCodigo_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtDConDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+36)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtDConDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDConDescrip_Visible), 5, 0), !bGXsfl_108_Refreshing);
      cmbDTipoConCod.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+37)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Visible", GXutil.ltrimstr( cmbDTipoConCod.getVisible(), 5, 0), !bGXsfl_108_Refreshing);
      edtavConclasifaux_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+38)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConclasifaux_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConclasifaux_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDCanti_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+39)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDCanti_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDCanti_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDImpCalcu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+40)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDImpCalcu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDImpCalcu_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDReFormulaHTML_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+41)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDReFormulaHTML_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDReFormulaHTML_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDFormulaHTML_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+42)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDFormulaHTML_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDFormulaHTML_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDLogRecal_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+43)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDLogRecal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDLogRecal_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDErrorDesc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+44)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDErrorDesc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDErrorDesc_Visible), 5, 0), !bGXsfl_108_Refreshing);
      edtLiqDImpReCalcu_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV21ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+45)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLiqDImpReCalcu_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLiqDImpReCalcu_Visible), 5, 0), !bGXsfl_108_Refreshing);
      AV88GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV88GridCurrentPage), 10, 0));
      AV89GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV89GridPageCount), 10, 0));
      GXt_char12 = AV90GridAppliedFilters ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV162Pgmname, GXv_char9) ;
      liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
      AV90GridAppliedFilters = GXt_char12 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90GridAppliedFilters", AV90GridAppliedFilters);
      GXt_char12 = AV150MenuOpcTitulo ;
      GXv_char9[0] = GXt_char12 ;
      new web.gettxtcount(remoteHandle, context).execute( AV134MenuOpcCod, GXv_char9) ;
      liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
      AV150MenuOpcTitulo = GXt_char12 ;
      if ( (GXutil.strcmp("", AV150MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV150MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int2[0] = (short)(AV153filterCount) ;
      GXv_char9[0] = AV154filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int2, GXv_char9) ;
      liquidacion_export3_impl.this.AV153filterCount = GXv_int2[0] ;
      liquidacion_export3_impl.this.AV154filtrosTexto = GXv_char9[0] ;
      if ( AV153filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV153filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV154filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e13J82( )
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
         AV87PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV87PageToGo) ;
      }
   }

   public void e14J82( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15J82( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV14OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
         AV15OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegId") == 0 )
         {
            AV28TFLegId = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFLegId", AV28TFLegId);
            AV27TFLegId_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFLegId_SelsJson", AV27TFLegId_SelsJson);
            AV29TFLegId_Sels.fromJSonString(AV27TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegNomApe") == 0 )
         {
            AV31TFLegNomApe = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFLegNomApe", AV31TFLegNomApe);
            AV30TFLegNomApe_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFLegNomApe_SelsJson", AV30TFLegNomApe_SelsJson);
            AV32TFLegNomApe_Sels.fromJSonString(AV30TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqNombre") == 0 )
         {
            AV34TFLiqNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFLiqNombre", AV34TFLiqNombre);
            AV33TFLiqNombre_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFLiqNombre_SelsJson", AV33TFLiqNombre_SelsJson);
            AV35TFLiqNombre_Sels.fromJSonString(AV33TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SecDescrip") == 0 )
         {
            AV37TFSecDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFSecDescrip", AV37TFSecDescrip);
            AV36TFSecDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSecDescrip_SelsJson", AV36TFSecDescrip_SelsJson);
            AV38TFSecDescrip_Sels.fromJSonString(AV36TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegOsoDes") == 0 )
         {
            AV144TFLegOsoDes = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV144TFLegOsoDes", AV144TFLegOsoDes);
            AV143TFLegOsoDes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV143TFLegOsoDes_SelsJson", AV143TFLegOsoDes_SelsJson);
            AV145TFLegOsoDes_Sels.fromJSonString(AV143TFLegOsoDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegCuentaBanc") == 0 )
         {
            AV45TFLegCuentaBanc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFLegCuentaBanc", AV45TFLegCuentaBanc);
            AV44TFLegCuentaBanc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFLegCuentaBanc_SelsJson", AV44TFLegCuentaBanc_SelsJson);
            AV46TFLegCuentaBanc_Sels.fromJSonString(AV44TFLegCuentaBanc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegModTra") == 0 )
         {
            AV155TFLegModTra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV155TFLegModTra_SelsJson", AV155TFLegModTra_SelsJson);
            AV156TFLegModTra_Sels.fromJSonString(AV155TFLegModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegClase") == 0 )
         {
            AV47TFLegClase_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFLegClase_SelsJson", AV47TFLegClase_SelsJson);
            AV48TFLegClase_Sels.fromJSonString(GXutil.strReplace( AV47TFLegClase_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegTipoTarifa") == 0 )
         {
            AV157TFLegTipoTarifa_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV157TFLegTipoTarifa_SelsJson", AV157TFLegTipoTarifa_SelsJson);
            AV158TFLegTipoTarifa_Sels.fromJSonString(AV157TFLegTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDescrip") == 0 )
         {
            AV53TFLiqDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFLiqDescrip", AV53TFLiqDescrip);
            AV52TFLiqDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFLiqDescrip_SelsJson", AV52TFLiqDescrip_SelsJson);
            AV54TFLiqDescrip_Sels.fromJSonString(AV52TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFecha") == 0 )
         {
            AV56TFLiqFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFLiqFecha", localUtil.format(AV56TFLiqFecha, "99/99/9999"));
            AV55TFLiqFecha_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFLiqFecha_SelsJson", AV55TFLiqFecha_SelsJson);
            AV57TFLiqFecha_Sels.fromJSonString(AV55TFLiqFecha_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqPerSinDia") == 0 )
         {
            AV60TFLiqPerSinDia = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFLiqPerSinDia", AV60TFLiqPerSinDia);
            AV59TFLiqPerSinDia_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFLiqPerSinDia_SelsJson", AV59TFLiqPerSinDia_SelsJson);
            AV61TFLiqPerSinDia_Sels.fromJSonString(AV59TFLiqPerSinDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "TliqDesc") == 0 )
         {
            AV63TFTliqDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFTliqDesc", AV63TFTliqDesc);
            AV62TFTliqDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFTliqDesc_SelsJson", AV62TFTliqDesc_SelsJson);
            AV64TFTliqDesc_Sels.fromJSonString(AV62TFTliqDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqFecPago") == 0 )
         {
            AV66TFLiqFecPago = localUtil.ctod( Ddo_grid_Filteredtext_get, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFLiqFecPago", localUtil.format(AV66TFLiqFecPago, "99/99/9999"));
            AV65TFLiqFecPago_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFLiqFecPago_SelsJson", AV65TFLiqFecPago_SelsJson);
            AV67TFLiqFecPago_Sels.fromJSonString(AV65TFLiqFecPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DConCodigo") == 0 )
         {
            AV70TFDConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFDConCodigo", AV70TFDConCodigo);
            AV69TFDConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFDConCodigo_SelsJson", AV69TFDConCodigo_SelsJson);
            AV71TFDConCodigo_Sels.fromJSonString(AV69TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DConDescrip") == 0 )
         {
            AV73TFDConDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFDConDescrip", AV73TFDConDescrip);
            AV72TFDConDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFDConDescrip_SelsJson", AV72TFDConDescrip_SelsJson);
            AV74TFDConDescrip_Sels.fromJSonString(AV72TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DTipoConCod") == 0 )
         {
            AV75TFDTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFDTipoConCod_SelsJson", AV75TFDTipoConCod_SelsJson);
            AV76TFDTipoConCod_Sels.fromJSonString(AV75TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConClasifAux") == 0 )
         {
            AV78TFConClasifAux = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFConClasifAux", AV78TFConClasifAux);
            AV77TFConClasifAux_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFConClasifAux_SelsJson", AV77TFConClasifAux_SelsJson);
            AV79TFConClasifAux_Sels.fromJSonString(AV77TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDCanti") == 0 )
         {
            AV80TFLiqDCanti = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFLiqDCanti", GXutil.ltrimstr( AV80TFLiqDCanti, 14, 2));
            AV81TFLiqDCanti_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFLiqDCanti_To", GXutil.ltrimstr( AV81TFLiqDCanti_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDImpCalcu") == 0 )
         {
            AV84TFLiqDImpCalcu = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84TFLiqDImpCalcu", GXutil.ltrimstr( AV84TFLiqDImpCalcu, 14, 2));
            AV85TFLiqDImpCalcu_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV85TFLiqDImpCalcu_To", GXutil.ltrimstr( AV85TFLiqDImpCalcu_To, 14, 2));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDLogRecal") == 0 )
         {
            AV129TFLiqDLogRecal = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFLiqDLogRecal", AV129TFLiqDLogRecal);
            AV128TFLiqDLogRecal_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV128TFLiqDLogRecal_SelsJson", AV128TFLiqDLogRecal_SelsJson);
            AV130TFLiqDLogRecal_Sels.fromJSonString(AV128TFLiqDLogRecal_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDImpReCalcu") == 0 )
         {
            AV82TFLiqDImpReCalcu = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFLiqDImpReCalcu", GXutil.ltrimstr( AV82TFLiqDImpReCalcu, 14, 2));
            AV83TFLiqDImpReCalcu_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV83TFLiqDImpReCalcu_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV130TFLiqDLogRecal_Sels", AV130TFLiqDLogRecal_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV79TFConClasifAux_Sels", AV79TFConClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFDTipoConCod_Sels", AV76TFDTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74TFDConDescrip_Sels", AV74TFDConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV71TFDConCodigo_Sels", AV71TFDConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV67TFLiqFecPago_Sels", AV67TFLiqFecPago_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFTliqDesc_Sels", AV64TFTliqDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFLiqPerSinDia_Sels", AV61TFLiqPerSinDia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV57TFLiqFecha_Sels", AV57TFLiqFecha_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54TFLiqDescrip_Sels", AV54TFLiqDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV158TFLegTipoTarifa_Sels", AV158TFLegTipoTarifa_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFLegClase_Sels", AV48TFLegClase_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV156TFLegModTra_Sels", AV156TFLegModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFLegCuentaBanc_Sels", AV46TFLegCuentaBanc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV145TFLegOsoDes_Sels", AV145TFLegOsoDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38TFSecDescrip_Sels", AV38TFSecDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV35TFLiqNombre_Sels", AV35TFLiqNombre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32TFLegNomApe_Sels", AV32TFLegNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29TFLegId_Sels", AV29TFLegId_Sels);
   }

   private void e20J82( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", A939LegCatCodigo)==0) && ! (GXutil.strcmp("", A937LegConveCodigo)==0) )
      {
         GXv_char9[0] = AV17ConveDescri ;
         GXv_boolean10[0] = false ;
         new web.getconvenio(remoteHandle, context).execute( AV98CliCod, A937LegConveCodigo, GXv_char9, GXv_boolean10) ;
         liquidacion_export3_impl.this.AV17ConveDescri = GXv_char9[0] ;
         httpContext.ajax_rsp_assign_attri("", false, edtavConvedescri_Internalname, AV17ConveDescri);
         GXv_int4[0] = AV104CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV98CliCod, AV99EmpCod, A6LegNumero, GXv_int4) ;
         liquidacion_export3_impl.this.AV104CliConveVer = GXv_int4[0] ;
         GXv_char9[0] = AV18CatDescrip ;
         GXv_boolean10[0] = false ;
         new web.getcategoria(remoteHandle, context).execute( AV98CliCod, AV104CliConveVer, A937LegConveCodigo, A939LegCatCodigo, GXv_char9, GXv_boolean10) ;
         liquidacion_export3_impl.this.AV18CatDescrip = GXv_char9[0] ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV18CatDescrip);
      }
      else
      {
         GXt_char12 = AV17ConveDescri ;
         GXv_char9[0] = GXt_char12 ;
         new web.textofueradeconvenio(remoteHandle, context).execute( AV98CliCod, GXv_char9) ;
         liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
         AV17ConveDescri = GXt_char12 ;
         httpContext.ajax_rsp_assign_attri("", false, edtavConvedescri_Internalname, AV17ConveDescri);
         GXt_char12 = AV18CatDescrip ;
         GXv_char9[0] = GXt_char12 ;
         new web.textofueradeconvenio(remoteHandle, context).execute( AV98CliCod, GXv_char9) ;
         liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
         AV18CatDescrip = GXt_char12 ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCatdescrip_Internalname, AV18CatDescrip);
      }
      GXv_char9[0] = AV127ConClasifAux ;
      new web.getconceptoclasifaux(remoteHandle, context).execute( AV98CliCod, A394DConCodigo, GXv_char9) ;
      liquidacion_export3_impl.this.AV127ConClasifAux = GXv_char9[0] ;
      httpContext.ajax_rsp_assign_attri("", false, edtavConclasifaux_Internalname, AV127ConClasifAux);
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

   public void e11J82( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV19ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV21ColumnsSelector.fromJSonString(AV19ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "liquidacion_export3ColumnsSelector", ((GXutil.strcmp("", AV19ColumnsSelectorXML)==0) ? "" : AV21ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
   }

   public void e12J82( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S172 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S152 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("liquidacion_export3Filters")),GXutil.URLEncode(GXutil.rtrim(AV162Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("liquidacion_export3Filters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV26ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ManageFiltersExecutionStep", GXutil.str( AV26ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char12 = AV25ManageFiltersXml ;
         GXv_char9[0] = GXt_char12 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "liquidacion_export3Filters", Ddo_managefilters_Activeeventkey, GXv_char9) ;
         liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
         AV25ManageFiltersXml = GXt_char12 ;
         if ( (GXutil.strcmp("", AV25ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV162Pgmname+"GridState", AV25ManageFiltersXml) ;
            AV12GridState.fromxml(AV25ManageFiltersXml, null, null);
            AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
            AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S182 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29TFLegId_Sels", AV29TFLegId_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32TFLegNomApe_Sels", AV32TFLegNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV35TFLiqNombre_Sels", AV35TFLiqNombre_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38TFSecDescrip_Sels", AV38TFSecDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV145TFLegOsoDes_Sels", AV145TFLegOsoDes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV46TFLegCuentaBanc_Sels", AV46TFLegCuentaBanc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV156TFLegModTra_Sels", AV156TFLegModTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV48TFLegClase_Sels", AV48TFLegClase_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV158TFLegTipoTarifa_Sels", AV158TFLegTipoTarifa_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV54TFLiqDescrip_Sels", AV54TFLiqDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV57TFLiqFecha_Sels", AV57TFLiqFecha_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV61TFLiqPerSinDia_Sels", AV61TFLiqPerSinDia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64TFTliqDesc_Sels", AV64TFTliqDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV67TFLiqFecPago_Sels", AV67TFLiqFecPago_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV71TFDConCodigo_Sels", AV71TFDConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV74TFDConDescrip_Sels", AV74TFDConDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV76TFDTipoConCod_Sels", AV76TFDTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV79TFConClasifAux_Sels", AV79TFConClasifAux_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV130TFLiqDLogRecal_Sels", AV130TFLiqDLogRecal_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21ColumnsSelector", AV21ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24ManageFiltersData", AV24ManageFiltersData);
   }

   public void e16J82( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV101ExcelFilename ;
      GXv_char8[0] = AV102ErrorMessage ;
      new web.liquidacion_export3export(remoteHandle, context).execute( GXv_char9, GXv_char8) ;
      liquidacion_export3_impl.this.AV101ExcelFilename = GXv_char9[0] ;
      liquidacion_export3_impl.this.AV102ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV101ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV101ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV102ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV14OrderedBy, 4, 0))+":"+(AV15OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S162( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV21ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegId", "", "ID", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegNomApe", "", "Apellido y nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegCUIL", "", "CUIL", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqNombre", "", "Liq. nombre", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ConveDescri", "", "Convenio", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&CatDescrip", "", "Categoría", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "SecDescrip", "", "Area", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ZonDescrip", "", "Zona", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegFormaPago", "", "Forma de pago", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegActCodigo", "", "Actividad", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegOsoDes", "", "Obra social desc.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegOsoAfipCod", "", "Obra social cod.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegSinCod", "", "Sindicato cod.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegFecIngreso", "", "Fecha Ing.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegFecEgreso", "", "Fecha Egr.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "MegDescrip", "", "Motivo de egreso", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegCBU", "", "CBU", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegBanDes", "", "Banco", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegBanTipCuen", "", "Tipo de cuenta", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegBanSuc", "", "Sucursal", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegCuentaBanc", "", "Cuenta banco", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegModTra", "", "Relación", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegClase", "", "Frecuencia de pago", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegTipoTarifa", "", "Tipo de tarifa", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegCodPos", "", "Cod. pos.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegSexo", "", "Género", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegFecNac", "", "Fecha nac.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegSCVO", "", "Seguro Colectivo Vida Obligatorio", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqNro", "", "Nro. liquidación", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDescrip", "", "Observación liquidación", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqFecha", "", "Fecha liq.", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqPerSinDia", "", "Periodo", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "TliqDesc", "", "Tipo liq.", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqFecPago", "", "Fecha pago", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "DConCodigo", "", "Concepto cod.", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "DConDescrip", "", "Concepto desc.", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "DTipoConCod", "", "Tipo de concepto", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ConClasifAux", "", "Clasificación", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDCanti", "", "Cantidad", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDImpCalcu", "", "Importe original", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDReFormulaHTML", "", "Fórmula", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDFormulaHTML", "", "Fórmula original", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDLogRecal", "", "Log", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDErrorDesc", "", "Error", false, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV21ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LiqDImpReCalcu", "", "Importe", true, "") ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char12 = AV20UserCustomValue ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "liquidacion_export3ColumnsSelector", GXv_char9) ;
      liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
      AV20UserCustomValue = GXt_char12 ;
      if ( ! ( (GXutil.strcmp("", AV20UserCustomValue)==0) ) )
      {
         AV22ColumnsSelectorAux.fromxml(AV20UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector14[0] = AV22ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector15[0] = AV21ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, GXv_SdtWWPColumnsSelector15) ;
         AV22ColumnsSelectorAux = GXv_SdtWWPColumnsSelector14[0] ;
         AV21ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      }
      GXv_SdtWWPColumnsSelector15[0] = AV21ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV98CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV21ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV24ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "liquidacion_export3Filters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV24ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV28TFLegId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28TFLegId", AV28TFLegId);
      AV29TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFLegNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFLegNomApe", AV31TFLegNomApe);
      AV32TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV34TFLiqNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFLiqNombre", AV34TFLiqNombre);
      AV35TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37TFSecDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFSecDescrip", AV37TFSecDescrip);
      AV38TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV144TFLegOsoDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV144TFLegOsoDes", AV144TFLegOsoDes);
      AV145TFLegOsoDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45TFLegCuentaBanc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFLegCuentaBanc", AV45TFLegCuentaBanc);
      AV46TFLegCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV156TFLegModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48TFLegClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV158TFLegTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV53TFLiqDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFLiqDescrip", AV53TFLiqDescrip);
      AV54TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56TFLiqFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFLiqFecha", localUtil.format(AV56TFLiqFecha, "99/99/9999"));
      AV57TFLiqFecha_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      AV60TFLiqPerSinDia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60TFLiqPerSinDia", AV60TFLiqPerSinDia);
      AV61TFLiqPerSinDia_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63TFTliqDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TFTliqDesc", AV63TFTliqDesc);
      AV64TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV66TFLiqFecPago = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66TFLiqFecPago", localUtil.format(AV66TFLiqFecPago, "99/99/9999"));
      AV67TFLiqFecPago_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      AV70TFDConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70TFDConCodigo", AV70TFDConCodigo);
      AV71TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73TFDConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73TFDConDescrip", AV73TFDConDescrip);
      AV74TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV76TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV78TFConClasifAux = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFConClasifAux", AV78TFConClasifAux);
      AV79TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV80TFLiqDCanti = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80TFLiqDCanti", GXutil.ltrimstr( AV80TFLiqDCanti, 14, 2));
      AV81TFLiqDCanti_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TFLiqDCanti_To", GXutil.ltrimstr( AV81TFLiqDCanti_To, 14, 2));
      AV84TFLiqDImpCalcu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84TFLiqDImpCalcu", GXutil.ltrimstr( AV84TFLiqDImpCalcu, 14, 2));
      AV85TFLiqDImpCalcu_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85TFLiqDImpCalcu_To", GXutil.ltrimstr( AV85TFLiqDImpCalcu_To, 14, 2));
      AV129TFLiqDLogRecal = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV129TFLiqDLogRecal", AV129TFLiqDLogRecal);
      AV130TFLiqDLogRecal_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV82TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82TFLiqDImpReCalcu", GXutil.ltrimstr( AV82TFLiqDImpReCalcu, 14, 2));
      AV83TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV83TFLiqDImpReCalcu_To, 14, 2));
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
      if ( GXutil.strcmp(AV23Session.getValue(AV162Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV162Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV23Session.getValue(AV162Pgmname+"GridState"), null, null);
      }
      AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
      AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S182 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV12GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S182( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV163GXV1 = 1 ;
      while ( AV163GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV163GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV28TFLegId = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFLegId", AV28TFLegId);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV27TFLegId_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27TFLegId_SelsJson", AV27TFLegId_SelsJson);
            AV29TFLegId_Sels.fromJSonString(AV27TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV31TFLegNomApe = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFLegNomApe", AV31TFLegNomApe);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV30TFLegNomApe_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30TFLegNomApe_SelsJson", AV30TFLegNomApe_SelsJson);
            AV32TFLegNomApe_Sels.fromJSonString(AV30TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV34TFLiqNombre = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFLiqNombre", AV34TFLiqNombre);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV33TFLiqNombre_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFLiqNombre_SelsJson", AV33TFLiqNombre_SelsJson);
            AV35TFLiqNombre_Sels.fromJSonString(AV33TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP") == 0 )
         {
            AV37TFSecDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFSecDescrip", AV37TFSecDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP_SEL") == 0 )
         {
            AV36TFSecDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFSecDescrip_SelsJson", AV36TFSecDescrip_SelsJson);
            AV38TFSecDescrip_Sels.fromJSonString(AV36TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGOSODES") == 0 )
         {
            AV144TFLegOsoDes = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV144TFLegOsoDes", AV144TFLegOsoDes);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGOSODES_SEL") == 0 )
         {
            AV143TFLegOsoDes_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV143TFLegOsoDes_SelsJson", AV143TFLegOsoDes_SelsJson);
            AV145TFLegOsoDes_Sels.fromJSonString(AV143TFLegOsoDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENTABANC") == 0 )
         {
            AV45TFLegCuentaBanc = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFLegCuentaBanc", AV45TFLegCuentaBanc);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENTABANC_SEL") == 0 )
         {
            AV44TFLegCuentaBanc_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFLegCuentaBanc_SelsJson", AV44TFLegCuentaBanc_SelsJson);
            AV46TFLegCuentaBanc_Sels.fromJSonString(AV44TFLegCuentaBanc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGMODTRA_SEL") == 0 )
         {
            AV155TFLegModTra_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV155TFLegModTra_SelsJson", AV155TFLegModTra_SelsJson);
            AV156TFLegModTra_Sels.fromJSonString(AV155TFLegModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCLASE_SEL") == 0 )
         {
            AV47TFLegClase_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFLegClase_SelsJson", AV47TFLegClase_SelsJson);
            AV48TFLegClase_Sels.fromJSonString(AV47TFLegClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGTIPOTARIFA_SEL") == 0 )
         {
            AV157TFLegTipoTarifa_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV157TFLegTipoTarifa_SelsJson", AV157TFLegTipoTarifa_SelsJson);
            AV158TFLegTipoTarifa_Sels.fromJSonString(AV157TFLegTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP") == 0 )
         {
            AV53TFLiqDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFLiqDescrip", AV53TFLiqDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP_SEL") == 0 )
         {
            AV52TFLiqDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFLiqDescrip_SelsJson", AV52TFLiqDescrip_SelsJson);
            AV54TFLiqDescrip_Sels.fromJSonString(AV52TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV56TFLiqFecha = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFLiqFecha", localUtil.format(AV56TFLiqFecha, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA_SEL") == 0 )
         {
            AV55TFLiqFecha_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFLiqFecha_SelsJson", AV55TFLiqFecha_SelsJson);
            AV57TFLiqFecha_Sels.fromJSonString(AV55TFLiqFecha_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERSINDIA") == 0 )
         {
            AV60TFLiqPerSinDia = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV60TFLiqPerSinDia", AV60TFLiqPerSinDia);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERSINDIA_SEL") == 0 )
         {
            AV59TFLiqPerSinDia_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFLiqPerSinDia_SelsJson", AV59TFLiqPerSinDia_SelsJson);
            AV61TFLiqPerSinDia_Sels.fromJSonString(AV59TFLiqPerSinDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC") == 0 )
         {
            AV63TFTliqDesc = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63TFTliqDesc", AV63TFTliqDesc);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC_SEL") == 0 )
         {
            AV62TFTliqDesc_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV62TFTliqDesc_SelsJson", AV62TFTliqDesc_SelsJson);
            AV64TFTliqDesc_Sels.fromJSonString(AV62TFTliqDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV66TFLiqFecPago = localUtil.ctod( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV66TFLiqFecPago", localUtil.format(AV66TFLiqFecPago, "99/99/9999"));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO_SEL") == 0 )
         {
            AV65TFLiqFecPago_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFLiqFecPago_SelsJson", AV65TFLiqFecPago_SelsJson);
            AV67TFLiqFecPago_Sels.fromJSonString(AV65TFLiqFecPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV70TFDConCodigo = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70TFDConCodigo", AV70TFDConCodigo);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV69TFDConCodigo_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV69TFDConCodigo_SelsJson", AV69TFDConCodigo_SelsJson);
            AV71TFDConCodigo_Sels.fromJSonString(AV69TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV73TFDConDescrip = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFDConDescrip", AV73TFDConDescrip);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV72TFDConDescrip_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72TFDConDescrip_SelsJson", AV72TFDConDescrip_SelsJson);
            AV74TFDConDescrip_Sels.fromJSonString(AV72TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV75TFDTipoConCod_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV75TFDTipoConCod_SelsJson", AV75TFDTipoConCod_SelsJson);
            AV76TFDTipoConCod_Sels.fromJSonString(AV75TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV78TFConClasifAux = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFConClasifAux", AV78TFConClasifAux);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV77TFConClasifAux_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFConClasifAux_SelsJson", AV77TFConClasifAux_SelsJson);
            AV79TFConClasifAux_Sels.fromJSonString(AV77TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCANTI") == 0 )
         {
            AV80TFLiqDCanti = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV80TFLiqDCanti", GXutil.ltrimstr( AV80TFLiqDCanti, 14, 2));
            AV81TFLiqDCanti_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFLiqDCanti_To", GXutil.ltrimstr( AV81TFLiqDCanti_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPCALCU") == 0 )
         {
            AV84TFLiqDImpCalcu = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84TFLiqDImpCalcu", GXutil.ltrimstr( AV84TFLiqDImpCalcu, 14, 2));
            AV85TFLiqDImpCalcu_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV85TFLiqDImpCalcu_To", GXutil.ltrimstr( AV85TFLiqDImpCalcu_To, 14, 2));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDLOGRECAL") == 0 )
         {
            AV129TFLiqDLogRecal = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFLiqDLogRecal", AV129TFLiqDLogRecal);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDLOGRECAL_SEL") == 0 )
         {
            AV128TFLiqDLogRecal_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV128TFLiqDLogRecal_SelsJson", AV128TFLiqDLogRecal_SelsJson);
            AV130TFLiqDLogRecal_Sels.fromJSonString(AV128TFLiqDLogRecal_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV82TFLiqDImpReCalcu = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFLiqDImpReCalcu", GXutil.ltrimstr( AV82TFLiqDImpReCalcu, 14, 2));
            AV83TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV83TFLiqDImpReCalcu_To, 14, 2));
         }
         AV163GXV1 = (int)(AV163GXV1+1) ;
      }
      GXt_char12 = "" ;
      GXv_char9[0] = GXt_char12 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV29TFLegId_Sels.size()==0), AV27TFLegId_SelsJson, GXv_char9) ;
      liquidacion_export3_impl.this.GXt_char12 = GXv_char9[0] ;
      GXt_char11 = "" ;
      GXv_char8[0] = GXt_char11 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV32TFLegNomApe_Sels.size()==0), AV30TFLegNomApe_SelsJson, GXv_char8) ;
      liquidacion_export3_impl.this.GXt_char11 = GXv_char8[0] ;
      GXt_char18 = "" ;
      GXv_char7[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV35TFLiqNombre_Sels.size()==0), AV33TFLiqNombre_SelsJson, GXv_char7) ;
      liquidacion_export3_impl.this.GXt_char18 = GXv_char7[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV38TFSecDescrip_Sels.size()==0), AV36TFSecDescrip_SelsJson, GXv_char20) ;
      liquidacion_export3_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV145TFLegOsoDes_Sels.size()==0), AV143TFLegOsoDes_SelsJson, GXv_char22) ;
      liquidacion_export3_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV46TFLegCuentaBanc_Sels.size()==0), AV44TFLegCuentaBanc_SelsJson, GXv_char24) ;
      liquidacion_export3_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV156TFLegModTra_Sels.size()==0), AV155TFLegModTra_SelsJson, GXv_char26) ;
      liquidacion_export3_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV158TFLegTipoTarifa_Sels.size()==0), AV157TFLegTipoTarifa_SelsJson, GXv_char28) ;
      liquidacion_export3_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV54TFLiqDescrip_Sels.size()==0), AV52TFLiqDescrip_SelsJson, GXv_char30) ;
      liquidacion_export3_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV61TFLiqPerSinDia_Sels.size()==0), AV59TFLiqPerSinDia_SelsJson, GXv_char32) ;
      liquidacion_export3_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char33 = "" ;
      GXv_char34[0] = GXt_char33 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV64TFTliqDesc_Sels.size()==0), AV62TFTliqDesc_SelsJson, GXv_char34) ;
      liquidacion_export3_impl.this.GXt_char33 = GXv_char34[0] ;
      GXt_char35 = "" ;
      GXv_char36[0] = GXt_char35 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV71TFDConCodigo_Sels.size()==0), AV69TFDConCodigo_SelsJson, GXv_char36) ;
      liquidacion_export3_impl.this.GXt_char35 = GXv_char36[0] ;
      GXt_char37 = "" ;
      GXv_char38[0] = GXt_char37 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV74TFDConDescrip_Sels.size()==0), AV72TFDConDescrip_SelsJson, GXv_char38) ;
      liquidacion_export3_impl.this.GXt_char37 = GXv_char38[0] ;
      GXt_char39 = "" ;
      GXv_char40[0] = GXt_char39 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV76TFDTipoConCod_Sels.size()==0), AV75TFDTipoConCod_SelsJson, GXv_char40) ;
      liquidacion_export3_impl.this.GXt_char39 = GXv_char40[0] ;
      GXt_char41 = "" ;
      GXv_char42[0] = GXt_char41 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV79TFConClasifAux_Sels.size()==0), AV77TFConClasifAux_SelsJson, GXv_char42) ;
      liquidacion_export3_impl.this.GXt_char41 = GXv_char42[0] ;
      GXt_char43 = "" ;
      GXv_char44[0] = GXt_char43 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV130TFLiqDLogRecal_Sels.size()==0), AV128TFLiqDLogRecal_SelsJson, GXv_char44) ;
      liquidacion_export3_impl.this.GXt_char43 = GXv_char44[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char12+"|"+GXt_char11+"|"+GXt_char18+"|||"+GXt_char19+"|"+GXt_char21+"|"+GXt_char23+"|"+GXt_char25+"|"+((AV48TFLegClase_Sels.size()==0) ? "" : AV47TFLegClase_SelsJson)+"|"+GXt_char27+"|"+GXt_char29+"|"+((AV57TFLiqFecha_Sels.size()==0) ? "" : AV55TFLiqFecha_SelsJson)+"|"+GXt_char31+"|"+GXt_char33+"|"+((AV67TFLiqFecPago_Sels.size()==0) ? "" : AV65TFLiqFecPago_SelsJson)+"|"+GXt_char35+"|"+GXt_char37+"|"+GXt_char39+"|"+GXt_char41+"||||"+GXt_char43+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char43 = "" ;
      GXv_char44[0] = GXt_char43 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV28TFLegId)==0), AV28TFLegId, GXv_char44) ;
      liquidacion_export3_impl.this.GXt_char43 = GXv_char44[0] ;
      GXt_char41 = "" ;
      GXv_char42[0] = GXt_char41 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV31TFLegNomApe)==0), AV31TFLegNomApe, GXv_char42) ;
      liquidacion_export3_impl.this.GXt_char41 = GXv_char42[0] ;
      GXt_char39 = "" ;
      GXv_char40[0] = GXt_char39 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV34TFLiqNombre)==0), AV34TFLiqNombre, GXv_char40) ;
      liquidacion_export3_impl.this.GXt_char39 = GXv_char40[0] ;
      GXt_char37 = "" ;
      GXv_char38[0] = GXt_char37 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV37TFSecDescrip)==0), AV37TFSecDescrip, GXv_char38) ;
      liquidacion_export3_impl.this.GXt_char37 = GXv_char38[0] ;
      GXt_char35 = "" ;
      GXv_char36[0] = GXt_char35 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV144TFLegOsoDes)==0), AV144TFLegOsoDes, GXv_char36) ;
      liquidacion_export3_impl.this.GXt_char35 = GXv_char36[0] ;
      GXt_char33 = "" ;
      GXv_char34[0] = GXt_char33 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV45TFLegCuentaBanc)==0), AV45TFLegCuentaBanc, GXv_char34) ;
      liquidacion_export3_impl.this.GXt_char33 = GXv_char34[0] ;
      GXt_char31 = "" ;
      GXv_char32[0] = GXt_char31 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV53TFLiqDescrip)==0), AV53TFLiqDescrip, GXv_char32) ;
      liquidacion_export3_impl.this.GXt_char31 = GXv_char32[0] ;
      GXt_char29 = "" ;
      GXv_char30[0] = GXt_char29 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV60TFLiqPerSinDia)==0), AV60TFLiqPerSinDia, GXv_char30) ;
      liquidacion_export3_impl.this.GXt_char29 = GXv_char30[0] ;
      GXt_char27 = "" ;
      GXv_char28[0] = GXt_char27 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV63TFTliqDesc)==0), AV63TFTliqDesc, GXv_char28) ;
      liquidacion_export3_impl.this.GXt_char27 = GXv_char28[0] ;
      GXt_char25 = "" ;
      GXv_char26[0] = GXt_char25 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV70TFDConCodigo)==0), AV70TFDConCodigo, GXv_char26) ;
      liquidacion_export3_impl.this.GXt_char25 = GXv_char26[0] ;
      GXt_char23 = "" ;
      GXv_char24[0] = GXt_char23 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV73TFDConDescrip)==0), AV73TFDConDescrip, GXv_char24) ;
      liquidacion_export3_impl.this.GXt_char23 = GXv_char24[0] ;
      GXt_char21 = "" ;
      GXv_char22[0] = GXt_char21 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV78TFConClasifAux)==0), AV78TFConClasifAux, GXv_char22) ;
      liquidacion_export3_impl.this.GXt_char21 = GXv_char22[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV129TFLiqDLogRecal)==0), AV129TFLiqDLogRecal, GXv_char20) ;
      liquidacion_export3_impl.this.GXt_char19 = GXv_char20[0] ;
      Ddo_grid_Filteredtext_set = GXt_char43+"|"+GXt_char41+"|"+GXt_char39+"|||"+GXt_char37+"|"+GXt_char35+"|"+GXt_char33+"||||"+GXt_char31+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56TFLiqFecha)) ? "" : localUtil.dtoc( AV56TFLiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char29+"|"+GXt_char27+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66TFLiqFecPago)) ? "" : localUtil.dtoc( AV66TFLiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+"|"+GXt_char25+"|"+GXt_char23+"||"+GXt_char21+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFLiqDCanti)==0) ? "" : GXutil.str( AV80TFLiqDCanti, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV84TFLiqDImpCalcu)==0) ? "" : GXutil.str( AV84TFLiqDImpCalcu, 14, 2))+"||"+GXt_char19+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV82TFLiqDImpReCalcu)==0) ? "" : GXutil.str( AV82TFLiqDImpReCalcu, 14, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||||||||||||||||||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV81TFLiqDCanti_To)==0) ? "" : GXutil.str( AV81TFLiqDCanti_To, 14, 2))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV85TFLiqDImpCalcu_To)==0) ? "" : GXutil.str( AV85TFLiqDImpCalcu_To, 14, 2))+"|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV83TFLiqDImpReCalcu_To)==0) ? "" : GXutil.str( AV83TFLiqDImpReCalcu_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV23Session.getValue(AV162Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGID", httpContext.getMessage( "ID", ""), !(GXutil.strcmp("", AV28TFLegId)==0), (short)(0), AV28TFLegId, "", !(AV29TFLegId_Sels.size()==0), AV29TFLegId_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGNOMAPE", httpContext.getMessage( "Apellido y nombre", ""), !(GXutil.strcmp("", AV31TFLegNomApe)==0), (short)(0), AV31TFLegNomApe, "", !(AV32TFLegNomApe_Sels.size()==0), AV32TFLegNomApe_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQNOMBRE", httpContext.getMessage( "Liq. nombre", ""), !(GXutil.strcmp("", AV34TFLiqNombre)==0), (short)(0), AV34TFLiqNombre, "", !(AV35TFLiqNombre_Sels.size()==0), AV35TFLiqNombre_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFSECDESCRIP", httpContext.getMessage( "Area", ""), !(GXutil.strcmp("", AV37TFSecDescrip)==0), (short)(0), AV37TFSecDescrip, "", !(AV38TFSecDescrip_Sels.size()==0), AV38TFSecDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGOSODES", httpContext.getMessage( "Obra social desc.", ""), !(GXutil.strcmp("", AV144TFLegOsoDes)==0), (short)(0), AV144TFLegOsoDes, "", !(AV145TFLegOsoDes_Sels.size()==0), AV145TFLegOsoDes_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGCUENTABANC", httpContext.getMessage( "Cuenta banco", ""), !(GXutil.strcmp("", AV45TFLegCuentaBanc)==0), (short)(0), AV45TFLegCuentaBanc, "", !(AV46TFLegCuentaBanc_Sels.size()==0), AV46TFLegCuentaBanc_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGMODTRA_SEL", httpContext.getMessage( "Relación", ""), !(AV156TFLegModTra_Sels.size()==0), (short)(0), AV156TFLegModTra_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGCLASE_SEL", httpContext.getMessage( "Frecuencia de pago", ""), !(AV48TFLegClase_Sels.size()==0), (short)(0), AV48TFLegClase_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLEGTIPOTARIFA_SEL", httpContext.getMessage( "Tipo de tarifa", ""), !(AV158TFLegTipoTarifa_Sels.size()==0), (short)(0), AV158TFLegTipoTarifa_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQDESCRIP", httpContext.getMessage( "Observación liquidación", ""), !(GXutil.strcmp("", AV53TFLiqDescrip)==0), (short)(0), AV53TFLiqDescrip, "", !(AV54TFLiqDescrip_Sels.size()==0), AV54TFLiqDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQFECHA", httpContext.getMessage( "Fecha liq.", ""), !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV56TFLiqFecha)), (short)(0), GXutil.trim( localUtil.dtoc( AV56TFLiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "", !(AV57TFLiqFecha_Sels.size()==0), AV57TFLiqFecha_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQPERSINDIA", httpContext.getMessage( "Periodo", ""), !(GXutil.strcmp("", AV60TFLiqPerSinDia)==0), (short)(0), AV60TFLiqPerSinDia, "", !(AV61TFLiqPerSinDia_Sels.size()==0), AV61TFLiqPerSinDia_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFTLIQDESC", httpContext.getMessage( "Tipo liq.", ""), !(GXutil.strcmp("", AV63TFTliqDesc)==0), (short)(0), AV63TFTliqDesc, "", !(AV64TFTliqDesc_Sels.size()==0), AV64TFTliqDesc_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQFECPAGO", httpContext.getMessage( "Fecha pago", ""), !GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV66TFLiqFecPago)), (short)(0), GXutil.trim( localUtil.dtoc( AV66TFLiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")), "", !(AV67TFLiqFecPago_Sels.size()==0), AV67TFLiqFecPago_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFDCONCODIGO", httpContext.getMessage( "Concepto cod.", ""), !(GXutil.strcmp("", AV70TFDConCodigo)==0), (short)(0), AV70TFDConCodigo, "", !(AV71TFDConCodigo_Sels.size()==0), AV71TFDConCodigo_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFDCONDESCRIP", httpContext.getMessage( "Concepto desc.", ""), !(GXutil.strcmp("", AV73TFDConDescrip)==0), (short)(0), AV73TFDConDescrip, "", !(AV74TFDConDescrip_Sels.size()==0), AV74TFDConDescrip_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFDTIPOCONCOD_SEL", httpContext.getMessage( "Tipo de concepto", ""), !(AV76TFDTipoConCod_Sels.size()==0), (short)(0), AV76TFDTipoConCod_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFCONCLASIFAUX", httpContext.getMessage( "Clasificación", ""), !(GXutil.strcmp("", AV78TFConClasifAux)==0), (short)(0), AV78TFConClasifAux, "", !(AV79TFConClasifAux_Sels.size()==0), AV79TFConClasifAux_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQDCANTI", httpContext.getMessage( "Cantidad", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFLiqDCanti)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV81TFLiqDCanti_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV80TFLiqDCanti, 14, 2)), GXutil.trim( GXutil.str( AV81TFLiqDCanti_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQDIMPCALCU", httpContext.getMessage( "Importe original", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV84TFLiqDImpCalcu)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV85TFLiqDImpCalcu_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV84TFLiqDImpCalcu, 14, 2)), GXutil.trim( GXutil.str( AV85TFLiqDImpCalcu_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQDLOGRECAL", httpContext.getMessage( "Log", ""), !(GXutil.strcmp("", AV129TFLiqDLogRecal)==0), (short)(0), AV129TFLiqDLogRecal, "", !(AV130TFLiqDLogRecal_Sels.size()==0), AV130TFLiqDLogRecal_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      GXv_SdtWWPGridState45[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState45, "TFLIQDIMPRECALCU", httpContext.getMessage( "Importe", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV82TFLiqDImpReCalcu)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV83TFLiqDImpReCalcu_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV82TFLiqDImpReCalcu, 14, 2)), GXutil.trim( GXutil.str( AV83TFLiqDImpReCalcu_To, 14, 2))) ;
      AV12GridState = GXv_SdtWWPGridState45[0] ;
      if ( ! (GXutil.strcmp("", AV134MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV134MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV162Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV162Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Liquidacion_Excel_1" );
      AV23Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17J82( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV136WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean10[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV134MenuOpcCod, GXv_boolean10) ;
         GXv_char44[0] = AV138textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV98CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char44) ;
         liquidacion_export3_impl.this.AV138textoNoMostrara = GXv_char44[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV138textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean10[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV134MenuOpcCod, GXv_boolean10) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_J82( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_J82( true) ;
      }
      else
      {
         wb_table2_12_J82( false) ;
      }
      return  ;
   }

   public void wb_table2_12_J82e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_J82e( true) ;
      }
      else
      {
         wb_table1_9_J82e( false) ;
      }
   }

   public void wb_table2_12_J82( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21j81_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_liquidacion_export3.htm");
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
         AV142WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV142WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV161Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV142WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV142WelcomeMessage_Foto)==0) ? AV161Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV142WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV142WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_liquidacion_export3.htm");
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
         wb_table3_30_J82( true) ;
      }
      else
      {
         wb_table3_30_J82( false) ;
      }
      return  ;
   }

   public void wb_table3_30_J82e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_J82( true) ;
      }
      else
      {
         wb_table4_35_J82( false) ;
      }
      return  ;
   }

   public void wb_table4_35_J82e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV136WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
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
         wb_table5_54_J82( true) ;
      }
      else
      {
         wb_table5_54_J82( false) ;
      }
      return  ;
   }

   public void wb_table5_54_J82e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_J82( true) ;
      }
      else
      {
         wb_table6_63_J82( false) ;
      }
      return  ;
   }

   public void wb_table6_63_J82e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV88GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV89GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV90GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_J82e( true) ;
      }
      else
      {
         wb_table2_12_J82e( false) ;
      }
   }

   public void wb_table6_63_J82( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_liquidacion_export3.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV86DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV21ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV24ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 108, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_liquidacion_export3.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_liquidacion_export3.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_97_J82( true) ;
      }
      else
      {
         wb_table7_97_J82( false) ;
      }
      return  ;
   }

   public void wb_table7_97_J82e( boolean wbgen )
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
         wb_table6_63_J82e( true) ;
      }
      else
      {
         wb_table6_63_J82e( false) ;
      }
   }

   public void wb_table7_97_J82( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_97_J82e( true) ;
      }
      else
      {
         wb_table7_97_J82e( false) ;
      }
   }

   public void wb_table5_54_J82( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_J82e( true) ;
      }
      else
      {
         wb_table5_54_J82e( false) ;
      }
   }

   public void wb_table4_35_J82( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_J82e( true) ;
      }
      else
      {
         wb_table4_35_J82e( false) ;
      }
   }

   public void wb_table3_30_J82( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_liquidacion_export3.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_J82e( true) ;
      }
      else
      {
         wb_table3_30_J82e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV134MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV134MenuOpcCod", AV134MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV134MenuOpcCod, ""))));
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
      paJ82( ) ;
      wsJ82( ) ;
      weJ82( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713533532", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("liquidacion_export3.js", "?20251713533532", false, true);
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
      edtLegId_Internalname = "LEGID_"+sGXsfl_108_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_108_idx ;
      edtLegNomApe_Internalname = "LEGNOMAPE_"+sGXsfl_108_idx ;
      edtLegCUIL_Internalname = "LEGCUIL_"+sGXsfl_108_idx ;
      edtLiqNombre_Internalname = "LIQNOMBRE_"+sGXsfl_108_idx ;
      edtLegConveCodigo_Internalname = "LEGCONVECODIGO_"+sGXsfl_108_idx ;
      edtavConvedescri_Internalname = "vCONVEDESCRI_"+sGXsfl_108_idx ;
      edtLegCatCodigo_Internalname = "LEGCATCODIGO_"+sGXsfl_108_idx ;
      edtavCatdescrip_Internalname = "vCATDESCRIP_"+sGXsfl_108_idx ;
      edtLegSecCodigo_Internalname = "LEGSECCODIGO_"+sGXsfl_108_idx ;
      edtSecDescrip_Internalname = "SECDESCRIP_"+sGXsfl_108_idx ;
      edtZonCod_Internalname = "ZONCOD_"+sGXsfl_108_idx ;
      edtZonDescrip_Internalname = "ZONDESCRIP_"+sGXsfl_108_idx ;
      cmbLegFormaPago.setInternalname( "LEGFORMAPAGO_"+sGXsfl_108_idx );
      edtLegActCodigo_Internalname = "LEGACTCODIGO_"+sGXsfl_108_idx ;
      edtLegActDescri_Internalname = "LEGACTDESCRI_"+sGXsfl_108_idx ;
      edtLegOsoDes_Internalname = "LEGOSODES_"+sGXsfl_108_idx ;
      edtLegOsoAfipCod_Internalname = "LEGOSOAFIPCOD_"+sGXsfl_108_idx ;
      edtLegSinCod_Internalname = "LEGSINCOD_"+sGXsfl_108_idx ;
      edtLegFecIngreso_Internalname = "LEGFECINGRESO_"+sGXsfl_108_idx ;
      edtLegFecEgreso_Internalname = "LEGFECEGRESO_"+sGXsfl_108_idx ;
      edtLegMegCodigo_Internalname = "LEGMEGCODIGO_"+sGXsfl_108_idx ;
      edtMegDescrip_Internalname = "MEGDESCRIP_"+sGXsfl_108_idx ;
      edtLegCBU_Internalname = "LEGCBU_"+sGXsfl_108_idx ;
      edtLegBanDes_Internalname = "LEGBANDES_"+sGXsfl_108_idx ;
      cmbLegBanTipCuen.setInternalname( "LEGBANTIPCUEN_"+sGXsfl_108_idx );
      edtLegBanSuc_Internalname = "LEGBANSUC_"+sGXsfl_108_idx ;
      edtLegCuentaBanc_Internalname = "LEGCUENTABANC_"+sGXsfl_108_idx ;
      cmbLegModTra.setInternalname( "LEGMODTRA_"+sGXsfl_108_idx );
      cmbLegClase.setInternalname( "LEGCLASE_"+sGXsfl_108_idx );
      cmbLegTipoTarifa.setInternalname( "LEGTIPOTARIFA_"+sGXsfl_108_idx );
      edtLegCodPos_Internalname = "LEGCODPOS_"+sGXsfl_108_idx ;
      cmbLegSexo.setInternalname( "LEGSEXO_"+sGXsfl_108_idx );
      edtLegFecNac_Internalname = "LEGFECNAC_"+sGXsfl_108_idx ;
      chkLegSCVO.setInternalname( "LEGSCVO_"+sGXsfl_108_idx );
      edtLiqNro_Internalname = "LIQNRO_"+sGXsfl_108_idx ;
      edtLiqDescrip_Internalname = "LIQDESCRIP_"+sGXsfl_108_idx ;
      edtLiqFecha_Internalname = "LIQFECHA_"+sGXsfl_108_idx ;
      edtLiqPerSinDia_Internalname = "LIQPERSINDIA_"+sGXsfl_108_idx ;
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_108_idx ;
      edtTliqDesc_Internalname = "TLIQDESC_"+sGXsfl_108_idx ;
      edtLiqFecPago_Internalname = "LIQFECPAGO_"+sGXsfl_108_idx ;
      edtDConCodigo_Internalname = "DCONCODIGO_"+sGXsfl_108_idx ;
      edtDConDescrip_Internalname = "DCONDESCRIP_"+sGXsfl_108_idx ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD_"+sGXsfl_108_idx );
      edtavConclasifaux_Internalname = "vCONCLASIFAUX_"+sGXsfl_108_idx ;
      edtLiqDCanti_Internalname = "LIQDCANTI_"+sGXsfl_108_idx ;
      edtLiqDImpCalcu_Internalname = "LIQDIMPCALCU_"+sGXsfl_108_idx ;
      edtLiqDReFormulaHTML_Internalname = "LIQDREFORMULAHTML_"+sGXsfl_108_idx ;
      edtLiqDFormulaHTML_Internalname = "LIQDFORMULAHTML_"+sGXsfl_108_idx ;
      edtLiqDLogRecal_Internalname = "LIQDLOGRECAL_"+sGXsfl_108_idx ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL_"+sGXsfl_108_idx ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC_"+sGXsfl_108_idx ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU_"+sGXsfl_108_idx ;
   }

   public void subsflControlProps_fel_1082( )
   {
      edtLegId_Internalname = "LEGID_"+sGXsfl_108_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_108_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_108_fel_idx ;
      edtLegNomApe_Internalname = "LEGNOMAPE_"+sGXsfl_108_fel_idx ;
      edtLegCUIL_Internalname = "LEGCUIL_"+sGXsfl_108_fel_idx ;
      edtLiqNombre_Internalname = "LIQNOMBRE_"+sGXsfl_108_fel_idx ;
      edtLegConveCodigo_Internalname = "LEGCONVECODIGO_"+sGXsfl_108_fel_idx ;
      edtavConvedescri_Internalname = "vCONVEDESCRI_"+sGXsfl_108_fel_idx ;
      edtLegCatCodigo_Internalname = "LEGCATCODIGO_"+sGXsfl_108_fel_idx ;
      edtavCatdescrip_Internalname = "vCATDESCRIP_"+sGXsfl_108_fel_idx ;
      edtLegSecCodigo_Internalname = "LEGSECCODIGO_"+sGXsfl_108_fel_idx ;
      edtSecDescrip_Internalname = "SECDESCRIP_"+sGXsfl_108_fel_idx ;
      edtZonCod_Internalname = "ZONCOD_"+sGXsfl_108_fel_idx ;
      edtZonDescrip_Internalname = "ZONDESCRIP_"+sGXsfl_108_fel_idx ;
      cmbLegFormaPago.setInternalname( "LEGFORMAPAGO_"+sGXsfl_108_fel_idx );
      edtLegActCodigo_Internalname = "LEGACTCODIGO_"+sGXsfl_108_fel_idx ;
      edtLegActDescri_Internalname = "LEGACTDESCRI_"+sGXsfl_108_fel_idx ;
      edtLegOsoDes_Internalname = "LEGOSODES_"+sGXsfl_108_fel_idx ;
      edtLegOsoAfipCod_Internalname = "LEGOSOAFIPCOD_"+sGXsfl_108_fel_idx ;
      edtLegSinCod_Internalname = "LEGSINCOD_"+sGXsfl_108_fel_idx ;
      edtLegFecIngreso_Internalname = "LEGFECINGRESO_"+sGXsfl_108_fel_idx ;
      edtLegFecEgreso_Internalname = "LEGFECEGRESO_"+sGXsfl_108_fel_idx ;
      edtLegMegCodigo_Internalname = "LEGMEGCODIGO_"+sGXsfl_108_fel_idx ;
      edtMegDescrip_Internalname = "MEGDESCRIP_"+sGXsfl_108_fel_idx ;
      edtLegCBU_Internalname = "LEGCBU_"+sGXsfl_108_fel_idx ;
      edtLegBanDes_Internalname = "LEGBANDES_"+sGXsfl_108_fel_idx ;
      cmbLegBanTipCuen.setInternalname( "LEGBANTIPCUEN_"+sGXsfl_108_fel_idx );
      edtLegBanSuc_Internalname = "LEGBANSUC_"+sGXsfl_108_fel_idx ;
      edtLegCuentaBanc_Internalname = "LEGCUENTABANC_"+sGXsfl_108_fel_idx ;
      cmbLegModTra.setInternalname( "LEGMODTRA_"+sGXsfl_108_fel_idx );
      cmbLegClase.setInternalname( "LEGCLASE_"+sGXsfl_108_fel_idx );
      cmbLegTipoTarifa.setInternalname( "LEGTIPOTARIFA_"+sGXsfl_108_fel_idx );
      edtLegCodPos_Internalname = "LEGCODPOS_"+sGXsfl_108_fel_idx ;
      cmbLegSexo.setInternalname( "LEGSEXO_"+sGXsfl_108_fel_idx );
      edtLegFecNac_Internalname = "LEGFECNAC_"+sGXsfl_108_fel_idx ;
      chkLegSCVO.setInternalname( "LEGSCVO_"+sGXsfl_108_fel_idx );
      edtLiqNro_Internalname = "LIQNRO_"+sGXsfl_108_fel_idx ;
      edtLiqDescrip_Internalname = "LIQDESCRIP_"+sGXsfl_108_fel_idx ;
      edtLiqFecha_Internalname = "LIQFECHA_"+sGXsfl_108_fel_idx ;
      edtLiqPerSinDia_Internalname = "LIQPERSINDIA_"+sGXsfl_108_fel_idx ;
      edtTLiqCod_Internalname = "TLIQCOD_"+sGXsfl_108_fel_idx ;
      edtTliqDesc_Internalname = "TLIQDESC_"+sGXsfl_108_fel_idx ;
      edtLiqFecPago_Internalname = "LIQFECPAGO_"+sGXsfl_108_fel_idx ;
      edtDConCodigo_Internalname = "DCONCODIGO_"+sGXsfl_108_fel_idx ;
      edtDConDescrip_Internalname = "DCONDESCRIP_"+sGXsfl_108_fel_idx ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD_"+sGXsfl_108_fel_idx );
      edtavConclasifaux_Internalname = "vCONCLASIFAUX_"+sGXsfl_108_fel_idx ;
      edtLiqDCanti_Internalname = "LIQDCANTI_"+sGXsfl_108_fel_idx ;
      edtLiqDImpCalcu_Internalname = "LIQDIMPCALCU_"+sGXsfl_108_fel_idx ;
      edtLiqDReFormulaHTML_Internalname = "LIQDREFORMULAHTML_"+sGXsfl_108_fel_idx ;
      edtLiqDFormulaHTML_Internalname = "LIQDFORMULAHTML_"+sGXsfl_108_fel_idx ;
      edtLiqDLogRecal_Internalname = "LIQDLOGRECAL_"+sGXsfl_108_fel_idx ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL_"+sGXsfl_108_fel_idx ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC_"+sGXsfl_108_fel_idx ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU_"+sGXsfl_108_fel_idx ;
   }

   public void sendrow_1082( )
   {
      subsflControlProps_1082( ) ;
      wbJ80( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegId_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegId_Internalname,GXutil.rtrim( A93LegId),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegNomApe_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNomApe_Internalname,A591LegNomApe,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegNomApe_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegCUIL_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCUIL_Internalname,GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A239LegCUIL), "ZZ-ZZZZZZZZ-9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCUIL_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCUIL_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqNombre_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNombre_Internalname,A874LiqNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqNombre_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Descrip","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegConveCodigo_Internalname,GXutil.rtrim( A937LegConveCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegConveCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavConvedescri_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConvedescri_Internalname,AV17ConveDescri,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavConvedescri_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavConvedescri_Visible),Integer.valueOf(edtavConvedescri_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCatCodigo_Internalname,GXutil.rtrim( A939LegCatCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCatCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavCatdescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCatdescrip_Internalname,AV18CatDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCatdescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavCatdescrip_Visible),Integer.valueOf(edtavCatdescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegSecCodigo_Internalname,GXutil.rtrim( A1579LegSecCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegSecCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtSecDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecDescrip_Internalname,A329SecDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtSecDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtZonCod_Internalname,GXutil.rtrim( A20ZonCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtZonCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtZonDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtZonDescrip_Internalname,A342ZonDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtZonDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtZonDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLegFormaPago.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LEGFORMAPAGO_" + sGXsfl_108_idx ;
         cmbLegFormaPago.setName( GXCCtl );
         cmbLegFormaPago.setWebtags( "" );
         cmbLegFormaPago.addItem("1", httpContext.getMessage( "Efectivo", ""), (short)(0));
         cmbLegFormaPago.addItem("2", httpContext.getMessage( "Cheque", ""), (short)(0));
         cmbLegFormaPago.addItem("3", httpContext.getMessage( "Transferencia", ""), (short)(0));
         if ( cmbLegFormaPago.getItemCount() > 0 )
         {
            A248LegFormaPago = (byte)(GXutil.lval( cmbLegFormaPago.getValidValue(GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0))))) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegFormaPago,cmbLegFormaPago.getInternalname(),GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0)),Integer.valueOf(1),cmbLegFormaPago.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLegFormaPago.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegFormaPago.setValue( GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegFormaPago.getInternalname(), "Values", cmbLegFormaPago.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegActCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegActCodigo_Internalname,GXutil.rtrim( A15LegActCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegActCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegActCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegActDescri_Internalname,A227LegActDescri,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegActDescri_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegOsoDes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegOsoDes_Internalname,A2225LegOsoDes,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegOsoDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegOsoDes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegOsoAfipCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegOsoAfipCod_Internalname,GXutil.rtrim( A2226LegOsoAfipCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegOsoAfipCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegOsoAfipCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegSinCod_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegSinCod_Internalname,GXutil.rtrim( A910LegSinCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegSinCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegSinCod_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegFecIngreso_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegFecIngreso_Internalname,localUtil.format(A245LegFecIngreso, "99/99/9999"),localUtil.format( A245LegFecIngreso, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegFecIngreso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegFecIngreso_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegFecEgreso_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegFecEgreso_Internalname,localUtil.format(A244LegFecEgreso, "99/99/9999"),localUtil.format( A244LegFecEgreso, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegFecEgreso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegFecEgreso_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegMegCodigo_Internalname,GXutil.rtrim( A1583LegMegCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegMegCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtMegDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMegDescrip_Internalname,A300MegDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMegDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtMegDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegCBU_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCBU_Internalname,A234LegCBU,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCBU_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCBU_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CBU","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegBanDes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegBanDes_Internalname,A2224LegBanDes,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegBanDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegBanDes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLegBanTipCuen.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LEGBANTIPCUEN_" + sGXsfl_108_idx ;
         cmbLegBanTipCuen.setName( GXCCtl );
         cmbLegBanTipCuen.setWebtags( "" );
         cmbLegBanTipCuen.addItem("CA", httpContext.getMessage( "Caja de Ahorro", ""), (short)(0));
         cmbLegBanTipCuen.addItem("CC", httpContext.getMessage( "Cuenta Corriente", ""), (short)(0));
         if ( cmbLegBanTipCuen.getItemCount() > 0 )
         {
            A232LegBanTipCuen = cmbLegBanTipCuen.getValidValue(A232LegBanTipCuen) ;
            n232LegBanTipCuen = false ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegBanTipCuen,cmbLegBanTipCuen.getInternalname(),GXutil.rtrim( A232LegBanTipCuen),Integer.valueOf(1),cmbLegBanTipCuen.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLegBanTipCuen.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegBanTipCuen.setValue( GXutil.rtrim( A232LegBanTipCuen) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegBanTipCuen.getInternalname(), "Values", cmbLegBanTipCuen.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegBanSuc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegBanSuc_Internalname,A231LegBanSuc,GXutil.rtrim( localUtil.format( A231LegBanSuc, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegBanSuc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegBanSuc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegCuentaBanc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCuentaBanc_Internalname,A238LegCuentaBanc,GXutil.rtrim( localUtil.format( A238LegCuentaBanc, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCuentaBanc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCuentaBanc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionCorta","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLegModTra.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LEGMODTRA_" + sGXsfl_108_idx ;
         cmbLegModTra.setName( GXCCtl );
         cmbLegModTra.setWebtags( "" );
         cmbLegModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
         cmbLegModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
         if ( cmbLegModTra.getItemCount() > 0 )
         {
            A2404LegModTra = cmbLegModTra.getValidValue(A2404LegModTra) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegModTra,cmbLegModTra.getInternalname(),GXutil.rtrim( A2404LegModTra),Integer.valueOf(1),cmbLegModTra.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLegModTra.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegModTra.setValue( GXutil.rtrim( A2404LegModTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegModTra.getInternalname(), "Values", cmbLegModTra.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLegClase.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LEGCLASE_" + sGXsfl_108_idx ;
         cmbLegClase.setName( GXCCtl );
         cmbLegClase.setWebtags( "" );
         cmbLegClase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
         cmbLegClase.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
         cmbLegClase.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
         cmbLegClase.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
         if ( cmbLegClase.getItemCount() > 0 )
         {
            A235LegClase = (byte)(GXutil.lval( cmbLegClase.getValidValue(GXutil.trim( GXutil.str( A235LegClase, 1, 0))))) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegClase,cmbLegClase.getInternalname(),GXutil.trim( GXutil.str( A235LegClase, 1, 0)),Integer.valueOf(1),cmbLegClase.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLegClase.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegClase.setValue( GXutil.trim( GXutil.str( A235LegClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegClase.getInternalname(), "Values", cmbLegClase.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbLegTipoTarifa.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LEGTIPOTARIFA_" + sGXsfl_108_idx ;
         cmbLegTipoTarifa.setName( GXCCtl );
         cmbLegTipoTarifa.setWebtags( "" );
         cmbLegTipoTarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
         cmbLegTipoTarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
         if ( cmbLegTipoTarifa.getItemCount() > 0 )
         {
            A2417LegTipoTarifa = cmbLegTipoTarifa.getValidValue(A2417LegTipoTarifa) ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegTipoTarifa,cmbLegTipoTarifa.getInternalname(),GXutil.rtrim( A2417LegTipoTarifa),Integer.valueOf(1),cmbLegTipoTarifa.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbLegTipoTarifa.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegTipoTarifa.setValue( GXutil.rtrim( A2417LegTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegTipoTarifa.getInternalname(), "Values", cmbLegTipoTarifa.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegCodPos_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegCodPos_Internalname,GXutil.rtrim( A236LegCodPos),GXutil.rtrim( localUtil.format( A236LegCodPos, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegCodPos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegCodPos_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoPostal","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLegSexo.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         GXCCtl = "LEGSEXO_" + sGXsfl_108_idx ;
         cmbLegSexo.setName( GXCCtl );
         cmbLegSexo.setWebtags( "" );
         if ( cmbLegSexo.getItemCount() > 0 )
         {
            A263LegSexo = (byte)(GXutil.lval( cmbLegSexo.getValidValue(GXutil.trim( GXutil.str( A263LegSexo, 2, 0))))) ;
            n263LegSexo = false ;
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegSexo,cmbLegSexo.getInternalname(),GXutil.trim( GXutil.str( A263LegSexo, 2, 0)),Integer.valueOf(1),cmbLegSexo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLegSexo.getVisible()),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegSexo.setValue( GXutil.trim( GXutil.str( A263LegSexo, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegSexo.getInternalname(), "Values", cmbLegSexo.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegFecNac_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegFecNac_Internalname,localUtil.format(A246LegFecNac, "99/99/9999"),localUtil.format( A246LegFecNac, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegFecNac_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLegFecNac_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkLegSCVO.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "LEGSCVO_" + sGXsfl_108_idx ;
         chkLegSCVO.setName( GXCCtl );
         chkLegSCVO.setWebtags( "" );
         chkLegSCVO.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkLegSCVO.getInternalname(), "TitleCaption", chkLegSCVO.getCaption(), !bGXsfl_108_Refreshing);
         chkLegSCVO.setCheckedValue( "false" );
         A262LegSCVO = GXutil.strtobool( GXutil.booltostr( A262LegSCVO)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkLegSCVO.getInternalname(),GXutil.booltostr( A262LegSCVO),"","",Integer.valueOf(chkLegSCVO.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqNro_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNro_Internalname,GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqNro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDescrip_Internalname,A271LiqDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqFecha_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqFecha_Internalname,localUtil.format(A98LiqFecha, "99/99/9999"),localUtil.format( A98LiqFecha, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqFecha_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqPerSinDia_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqPerSinDia_Internalname,GXutil.rtrim( A513LiqPerSinDia),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqPerSinDia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqPerSinDia_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTLiqCod_Internalname,GXutil.rtrim( A32TLiqCod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTLiqCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtTliqDesc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTliqDesc_Internalname,A340TliqDesc,GXutil.rtrim( localUtil.format( A340TliqDesc, "@!")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTliqDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtTliqDesc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionMedia","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqFecPago_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqFecPago_Internalname,localUtil.format(A280LiqFecPago, "99/99/9999"),localUtil.format( A280LiqFecPago, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqFecPago_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqFecPago_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtDConCodigo_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConCodigo_Internalname,GXutil.rtrim( A394DConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtDConCodigo_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtDConDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConDescrip_Internalname,A393DConDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDConDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtDConDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbDTipoConCod.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbDTipoConCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DTIPOCONCOD_" + sGXsfl_108_idx ;
            cmbDTipoConCod.setName( GXCCtl );
            cmbDTipoConCod.setWebtags( "" );
            cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
            cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
            cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
            cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
            if ( cmbDTipoConCod.getItemCount() > 0 )
            {
               A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDTipoConCod,cmbDTipoConCod.getInternalname(),GXutil.rtrim( A464DTipoConCod),Integer.valueOf(1),cmbDTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbDTipoConCod.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Values", cmbDTipoConCod.ToJavascriptSource(), !bGXsfl_108_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavConclasifaux_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConclasifaux_Internalname,AV127ConClasifAux,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavConclasifaux_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtavConclasifaux_Visible),Integer.valueOf(edtavConclasifaux_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqDCanti_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDCanti_Internalname,GXutil.ltrim( localUtil.ntoc( A269LiqDCanti, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A269LiqDCanti, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDCanti_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLiqDCanti_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqDImpCalcu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDImpCalcu_Internalname,GXutil.ltrim( localUtil.ntoc( A275LiqDImpCalcu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A275LiqDImpCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDImpCalcu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDImpCalcu_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDReFormulaHTML_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDReFormulaHTML_Internalname,A876LiqDReFormulaHTML,A876LiqDReFormulaHTML,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDReFormulaHTML_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDReFormulaHTML_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDFormulaHTML_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDFormulaHTML_Internalname,A508LiqDFormulaHTML,A508LiqDFormulaHTML,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDFormulaHTML_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDFormulaHTML_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDLogRecal_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDLogRecal_Internalname,A1072LiqDLogRecal,A1072LiqDLogRecal,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDLogRecal_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDLogRecal_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDSecuencial_Internalname,GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDSecuencial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLiqDErrorDesc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDErrorDesc_Internalname,A270LiqDErrorDesc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDErrorDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDErrorDesc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLiqDImpReCalcu_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDImpReCalcu_Internalname,GXutil.ltrim( localUtil.ntoc( A764LiqDImpReCalcu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A764LiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDImpReCalcu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtLiqDImpReCalcu_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(108),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesJ82( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegId_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "ID", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegNomApe_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Apellido y nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCUIL_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CUIL", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqNombre_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liq. nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavConvedescri_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Convenio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavCatdescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Categoría", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtSecDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Area", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtZonDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Zona", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegFormaPago.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Forma de pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegActCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Actividad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegOsoDes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obra social desc.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegOsoAfipCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obra social cod.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegSinCod_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sindicato cod.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegFecIngreso_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha Ing.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegFecEgreso_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha Egr.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtMegDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Motivo de egreso", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCBU_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "CBU", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegBanDes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Banco", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegBanTipCuen.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de cuenta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegBanSuc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sucursal", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCuentaBanc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cuenta banco", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegModTra.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Relación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegClase.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Frecuencia de pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegTipoTarifa.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de tarifa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegCodPos_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod. pos.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegSexo.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Género", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegFecNac_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha nac.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkLegSCVO.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Seguro Colectivo Vida Obligatorio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqNro_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro. liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Observación liquidación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqFecha_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha liq.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqPerSinDia_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Periodo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtTliqDesc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo liq.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqFecPago_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha pago", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDConCodigo_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto cod.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtDConDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto desc.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbDTipoConCod.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavConclasifaux_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Clasificación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDCanti_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDImpCalcu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe original", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDReFormulaHTML_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fórmula", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDFormulaHTML_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fórmula original", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDLogRecal_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Log", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDErrorDesc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Error", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLiqDImpReCalcu_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A93LegId));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A591LegNomApe);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegNomApe_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(13), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCUIL_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A874LiqNombre);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqNombre_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A937LegConveCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV17ConveDescri);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConvedescri_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavConvedescri_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A939LegCatCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV18CatDescrip);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCatdescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavCatdescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1579LegSecCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A329SecDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtSecDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A20ZonCod));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A342ZonDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtZonDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A248LegFormaPago, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegFormaPago.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A15LegActCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegActCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A227LegActDescri);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2225LegOsoDes);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegOsoDes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2226LegOsoAfipCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegOsoAfipCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A910LegSinCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegSinCod_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A245LegFecIngreso, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegFecIngreso_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A244LegFecEgreso, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegFecEgreso_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1583LegMegCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A300MegDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMegDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A234LegCBU);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCBU_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2224LegBanDes);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegBanDes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A232LegBanTipCuen));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegBanTipCuen.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A231LegBanSuc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegBanSuc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A238LegCuentaBanc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCuentaBanc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2404LegModTra));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegModTra.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A235LegClase, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegClase.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2417LegTipoTarifa));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegTipoTarifa.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A236LegCodPos));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegCodPos_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A263LegSexo, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegSexo.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A246LegFecNac, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegFecNac_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A262LegSCVO));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkLegSCVO.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqNro_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A271LiqDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A98LiqFecha, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqFecha_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A513LiqPerSinDia));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqPerSinDia_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A32TLiqCod));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A340TliqDesc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTliqDesc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A280LiqFecPago, "99/99/9999"));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqFecPago_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A394DConCodigo));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDConCodigo_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A393DConDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtDConDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A464DTipoConCod));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbDTipoConCod.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV127ConClasifAux);
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConclasifaux_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavConclasifaux_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A269LiqDCanti, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDCanti_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A275LiqDImpCalcu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDImpCalcu_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A876LiqDReFormulaHTML);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDReFormulaHTML_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A508LiqDFormulaHTML);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDFormulaHTML_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1072LiqDLogRecal);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDLogRecal_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A270LiqDErrorDesc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDErrorDesc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A764LiqDImpReCalcu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLiqDImpReCalcu_Visible, (byte)(5), (byte)(0), ".", "")));
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
      edtLegId_Internalname = "LEGID" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNomApe_Internalname = "LEGNOMAPE" ;
      edtLegCUIL_Internalname = "LEGCUIL" ;
      edtLiqNombre_Internalname = "LIQNOMBRE" ;
      edtLegConveCodigo_Internalname = "LEGCONVECODIGO" ;
      edtavConvedescri_Internalname = "vCONVEDESCRI" ;
      edtLegCatCodigo_Internalname = "LEGCATCODIGO" ;
      edtavCatdescrip_Internalname = "vCATDESCRIP" ;
      edtLegSecCodigo_Internalname = "LEGSECCODIGO" ;
      edtSecDescrip_Internalname = "SECDESCRIP" ;
      edtZonCod_Internalname = "ZONCOD" ;
      edtZonDescrip_Internalname = "ZONDESCRIP" ;
      cmbLegFormaPago.setInternalname( "LEGFORMAPAGO" );
      edtLegActCodigo_Internalname = "LEGACTCODIGO" ;
      edtLegActDescri_Internalname = "LEGACTDESCRI" ;
      edtLegOsoDes_Internalname = "LEGOSODES" ;
      edtLegOsoAfipCod_Internalname = "LEGOSOAFIPCOD" ;
      edtLegSinCod_Internalname = "LEGSINCOD" ;
      edtLegFecIngreso_Internalname = "LEGFECINGRESO" ;
      edtLegFecEgreso_Internalname = "LEGFECEGRESO" ;
      edtLegMegCodigo_Internalname = "LEGMEGCODIGO" ;
      edtMegDescrip_Internalname = "MEGDESCRIP" ;
      edtLegCBU_Internalname = "LEGCBU" ;
      edtLegBanDes_Internalname = "LEGBANDES" ;
      cmbLegBanTipCuen.setInternalname( "LEGBANTIPCUEN" );
      edtLegBanSuc_Internalname = "LEGBANSUC" ;
      edtLegCuentaBanc_Internalname = "LEGCUENTABANC" ;
      cmbLegModTra.setInternalname( "LEGMODTRA" );
      cmbLegClase.setInternalname( "LEGCLASE" );
      cmbLegTipoTarifa.setInternalname( "LEGTIPOTARIFA" );
      edtLegCodPos_Internalname = "LEGCODPOS" ;
      cmbLegSexo.setInternalname( "LEGSEXO" );
      edtLegFecNac_Internalname = "LEGFECNAC" ;
      chkLegSCVO.setInternalname( "LEGSCVO" );
      edtLiqNro_Internalname = "LIQNRO" ;
      edtLiqDescrip_Internalname = "LIQDESCRIP" ;
      edtLiqFecha_Internalname = "LIQFECHA" ;
      edtLiqPerSinDia_Internalname = "LIQPERSINDIA" ;
      edtTLiqCod_Internalname = "TLIQCOD" ;
      edtTliqDesc_Internalname = "TLIQDESC" ;
      edtLiqFecPago_Internalname = "LIQFECPAGO" ;
      edtDConCodigo_Internalname = "DCONCODIGO" ;
      edtDConDescrip_Internalname = "DCONDESCRIP" ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD" );
      edtavConclasifaux_Internalname = "vCONCLASIFAUX" ;
      edtLiqDCanti_Internalname = "LIQDCANTI" ;
      edtLiqDImpCalcu_Internalname = "LIQDIMPCALCU" ;
      edtLiqDReFormulaHTML_Internalname = "LIQDREFORMULAHTML" ;
      edtLiqDFormulaHTML_Internalname = "LIQDFORMULAHTML" ;
      edtLiqDLogRecal_Internalname = "LIQDLOGRECAL" ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL" ;
      edtLiqDErrorDesc_Internalname = "LIQDERRORDESC" ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_liqfechaauxdate_Internalname = "vDDO_LIQFECHAAUXDATE" ;
      divDdo_liqfechaauxdates_Internalname = "DDO_LIQFECHAAUXDATES" ;
      edtavDdo_liqfecpagoauxdate_Internalname = "vDDO_LIQFECPAGOAUXDATE" ;
      divDdo_liqfecpagoauxdates_Internalname = "DDO_LIQFECPAGOAUXDATES" ;
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
      edtLiqDImpReCalcu_Jsonclick = "" ;
      edtLiqDErrorDesc_Jsonclick = "" ;
      edtLiqDSecuencial_Jsonclick = "" ;
      edtLiqDLogRecal_Jsonclick = "" ;
      edtLiqDFormulaHTML_Jsonclick = "" ;
      edtLiqDReFormulaHTML_Jsonclick = "" ;
      edtLiqDImpCalcu_Jsonclick = "" ;
      edtLiqDCanti_Jsonclick = "" ;
      edtavConclasifaux_Jsonclick = "" ;
      edtavConclasifaux_Enabled = 0 ;
      cmbDTipoConCod.setJsonclick( "" );
      edtDConDescrip_Jsonclick = "" ;
      edtDConCodigo_Jsonclick = "" ;
      edtLiqFecPago_Jsonclick = "" ;
      edtTliqDesc_Jsonclick = "" ;
      edtTLiqCod_Jsonclick = "" ;
      edtLiqPerSinDia_Jsonclick = "" ;
      edtLiqFecha_Jsonclick = "" ;
      edtLiqDescrip_Jsonclick = "" ;
      edtLiqNro_Jsonclick = "" ;
      chkLegSCVO.setCaption( "" );
      edtLegFecNac_Jsonclick = "" ;
      cmbLegSexo.setJsonclick( "" );
      edtLegCodPos_Jsonclick = "" ;
      cmbLegTipoTarifa.setJsonclick( "" );
      cmbLegClase.setJsonclick( "" );
      cmbLegModTra.setJsonclick( "" );
      edtLegCuentaBanc_Jsonclick = "" ;
      edtLegBanSuc_Jsonclick = "" ;
      cmbLegBanTipCuen.setJsonclick( "" );
      edtLegBanDes_Jsonclick = "" ;
      edtLegCBU_Jsonclick = "" ;
      edtMegDescrip_Jsonclick = "" ;
      edtLegMegCodigo_Jsonclick = "" ;
      edtLegFecEgreso_Jsonclick = "" ;
      edtLegFecIngreso_Jsonclick = "" ;
      edtLegSinCod_Jsonclick = "" ;
      edtLegOsoAfipCod_Jsonclick = "" ;
      edtLegOsoDes_Jsonclick = "" ;
      edtLegActDescri_Jsonclick = "" ;
      edtLegActCodigo_Jsonclick = "" ;
      cmbLegFormaPago.setJsonclick( "" );
      edtZonDescrip_Jsonclick = "" ;
      edtZonCod_Jsonclick = "" ;
      edtSecDescrip_Jsonclick = "" ;
      edtLegSecCodigo_Jsonclick = "" ;
      edtavCatdescrip_Jsonclick = "" ;
      edtavCatdescrip_Enabled = 0 ;
      edtLegCatCodigo_Jsonclick = "" ;
      edtavConvedescri_Jsonclick = "" ;
      edtavConvedescri_Enabled = 0 ;
      edtLegConveCodigo_Jsonclick = "" ;
      edtLiqNombre_Jsonclick = "" ;
      edtLegCUIL_Jsonclick = "" ;
      edtLegNomApe_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtLegId_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtLiqDImpReCalcu_Visible = -1 ;
      edtLiqDErrorDesc_Visible = -1 ;
      edtLiqDLogRecal_Visible = -1 ;
      edtLiqDFormulaHTML_Visible = -1 ;
      edtLiqDReFormulaHTML_Visible = -1 ;
      edtLiqDImpCalcu_Visible = -1 ;
      edtLiqDCanti_Visible = -1 ;
      edtavConclasifaux_Visible = -1 ;
      cmbDTipoConCod.setVisible( -1 );
      edtDConDescrip_Visible = -1 ;
      edtDConCodigo_Visible = -1 ;
      edtLiqFecPago_Visible = -1 ;
      edtTliqDesc_Visible = -1 ;
      edtLiqPerSinDia_Visible = -1 ;
      edtLiqFecha_Visible = -1 ;
      edtLiqDescrip_Visible = -1 ;
      edtLiqNro_Visible = -1 ;
      chkLegSCVO.setVisible( -1 );
      edtLegFecNac_Visible = -1 ;
      cmbLegSexo.setVisible( -1 );
      edtLegCodPos_Visible = -1 ;
      cmbLegTipoTarifa.setVisible( -1 );
      cmbLegClase.setVisible( -1 );
      cmbLegModTra.setVisible( -1 );
      edtLegCuentaBanc_Visible = -1 ;
      edtLegBanSuc_Visible = -1 ;
      cmbLegBanTipCuen.setVisible( -1 );
      edtLegBanDes_Visible = -1 ;
      edtLegCBU_Visible = -1 ;
      edtMegDescrip_Visible = -1 ;
      edtLegFecEgreso_Visible = -1 ;
      edtLegFecIngreso_Visible = -1 ;
      edtLegSinCod_Visible = -1 ;
      edtLegOsoAfipCod_Visible = -1 ;
      edtLegOsoDes_Visible = -1 ;
      edtLegActCodigo_Visible = -1 ;
      cmbLegFormaPago.setVisible( -1 );
      edtZonDescrip_Visible = -1 ;
      edtSecDescrip_Visible = -1 ;
      edtavCatdescrip_Visible = -1 ;
      edtavConvedescri_Visible = -1 ;
      edtLiqNombre_Visible = -1 ;
      edtLegCUIL_Visible = -1 ;
      edtLegNomApe_Visible = -1 ;
      edtLegId_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      edtavDdo_liqfecpagoauxdate_Jsonclick = "" ;
      edtavDdo_liqfechaauxdate_Jsonclick = "" ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "||||||||||||||||||||-14.2|-14.2|||-14.2" ;
      Ddo_grid_Datalistproc = "liquidacion_export3GetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||||E:Empleado,I:Independiente||H:Por hora trabajada,P:Por periodo trabajado||||||||REM_ARG:Remunerativo,NRE_ARG:No Remunerativo,DES_ARG:Retención,CAL_ARG:Cálculo||||||" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T||||T|" ;
      Ddo_grid_Datalisttype = "Dynamic|Dynamic|Dynamic|||Dynamic|Dynamic|Dynamic|FixedValues|Dynamic (with fixedValues)|FixedValues|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|FixedValues|Dynamic||||Dynamic|" ;
      Ddo_grid_Includedatalist = "T|T|T|||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T||||T|" ;
      Ddo_grid_Filterisrange = "||||||||||||||||||||T|T|||T" ;
      Ddo_grid_Filtertype = "Character|Character|Character|||Character|Character|Character||Numeric||Character|Date|Character|Character|Date|Character|Character||Character|Numeric|Numeric||Character|Numeric" ;
      Ddo_grid_Includefilter = "T|T|T|||T|T|T||T||T|T|T|T|T|T|T||T|T|T||T|T" ;
      Ddo_grid_Fixable = "||T|T|T||||T||T|||||||||T|||T|T|T" ;
      Ddo_grid_Includesortasc = "T|T|||||||T||T|||T||||T||||||T|T" ;
      Ddo_grid_Columnssortvalues = "4|3|||||||5||6|||7||||2||||||8|9" ;
      Ddo_grid_Columnids = "0:LegId|3:LegNomApe|5:LiqNombre|7:ConveDescri|9:CatDescrip|11:SecDescrip|17:LegOsoDes|28:LegCuentaBanc|29:LegModTra|30:LegClase|31:LegTipoTarifa|37:LiqDescrip|38:LiqFecha|39:LiqPerSinDia|41:TliqDesc|42:LiqFecPago|43:DConCodigo|44:DConDescrip|45:DTipoConCod|46:ConClasifAux|47:LiqDCanti|48:LiqDImpCalcu|49:LiqDReFormulaHTML|51:LiqDLogRecal|54:LiqDImpReCalcu" ;
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
      Form.setCaption( httpContext.getMessage( "Detalle de liquidaciones", "") );
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
      AV136WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV136WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV136WelcomeMessage_NoMostrarMas", AV136WelcomeMessage_NoMostrarMas);
      GXCCtl = "LEGFORMAPAGO_" + sGXsfl_108_idx ;
      cmbLegFormaPago.setName( GXCCtl );
      cmbLegFormaPago.setWebtags( "" );
      cmbLegFormaPago.addItem("1", httpContext.getMessage( "Efectivo", ""), (short)(0));
      cmbLegFormaPago.addItem("2", httpContext.getMessage( "Cheque", ""), (short)(0));
      cmbLegFormaPago.addItem("3", httpContext.getMessage( "Transferencia", ""), (short)(0));
      if ( cmbLegFormaPago.getItemCount() > 0 )
      {
         A248LegFormaPago = (byte)(GXutil.lval( cmbLegFormaPago.getValidValue(GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0))))) ;
      }
      GXCCtl = "LEGBANTIPCUEN_" + sGXsfl_108_idx ;
      cmbLegBanTipCuen.setName( GXCCtl );
      cmbLegBanTipCuen.setWebtags( "" );
      cmbLegBanTipCuen.addItem("CA", httpContext.getMessage( "Caja de Ahorro", ""), (short)(0));
      cmbLegBanTipCuen.addItem("CC", httpContext.getMessage( "Cuenta Corriente", ""), (short)(0));
      if ( cmbLegBanTipCuen.getItemCount() > 0 )
      {
         A232LegBanTipCuen = cmbLegBanTipCuen.getValidValue(A232LegBanTipCuen) ;
         n232LegBanTipCuen = false ;
      }
      GXCCtl = "LEGMODTRA_" + sGXsfl_108_idx ;
      cmbLegModTra.setName( GXCCtl );
      cmbLegModTra.setWebtags( "" );
      cmbLegModTra.addItem("E", httpContext.getMessage( "Empleado", ""), (short)(0));
      cmbLegModTra.addItem("I", httpContext.getMessage( "Independiente", ""), (short)(0));
      if ( cmbLegModTra.getItemCount() > 0 )
      {
         A2404LegModTra = cmbLegModTra.getValidValue(A2404LegModTra) ;
      }
      GXCCtl = "LEGCLASE_" + sGXsfl_108_idx ;
      cmbLegClase.setName( GXCCtl );
      cmbLegClase.setWebtags( "" );
      cmbLegClase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbLegClase.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbLegClase.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbLegClase.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbLegClase.getItemCount() > 0 )
      {
         A235LegClase = (byte)(GXutil.lval( cmbLegClase.getValidValue(GXutil.trim( GXutil.str( A235LegClase, 1, 0))))) ;
      }
      GXCCtl = "LEGTIPOTARIFA_" + sGXsfl_108_idx ;
      cmbLegTipoTarifa.setName( GXCCtl );
      cmbLegTipoTarifa.setWebtags( "" );
      cmbLegTipoTarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
      cmbLegTipoTarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
      if ( cmbLegTipoTarifa.getItemCount() > 0 )
      {
         A2417LegTipoTarifa = cmbLegTipoTarifa.getValidValue(A2417LegTipoTarifa) ;
      }
      GXCCtl = "LEGSEXO_" + sGXsfl_108_idx ;
      cmbLegSexo.setName( GXCCtl );
      cmbLegSexo.setWebtags( "" );
      if ( cmbLegSexo.getItemCount() > 0 )
      {
         A263LegSexo = (byte)(GXutil.lval( cmbLegSexo.getValidValue(GXutil.trim( GXutil.str( A263LegSexo, 2, 0))))) ;
         n263LegSexo = false ;
      }
      GXCCtl = "LEGSCVO_" + sGXsfl_108_idx ;
      chkLegSCVO.setName( GXCCtl );
      chkLegSCVO.setWebtags( "" );
      chkLegSCVO.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkLegSCVO.getInternalname(), "TitleCaption", chkLegSCVO.getCaption(), !bGXsfl_108_Refreshing);
      chkLegSCVO.setCheckedValue( "false" );
      A262LegSCVO = GXutil.strtobool( GXutil.booltostr( A262LegSCVO)) ;
      GXCCtl = "DTIPOCONCOD_" + sGXsfl_108_idx ;
      cmbDTipoConCod.setName( GXCCtl );
      cmbDTipoConCod.setWebtags( "" );
      cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbDTipoConCod.getItemCount() > 0 )
      {
         A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV162Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtavConvedescri_Visible',ctrl:'vCONVEDESCRI',prop:'Visible'},{av:'edtavCatdescrip_Visible',ctrl:'vCATDESCRIP',prop:'Visible'},{av:'edtSecDescrip_Visible',ctrl:'SECDESCRIP',prop:'Visible'},{av:'edtZonDescrip_Visible',ctrl:'ZONDESCRIP',prop:'Visible'},{av:'cmbLegFormaPago'},{av:'edtLegActCodigo_Visible',ctrl:'LEGACTCODIGO',prop:'Visible'},{av:'edtLegOsoDes_Visible',ctrl:'LEGOSODES',prop:'Visible'},{av:'edtLegOsoAfipCod_Visible',ctrl:'LEGOSOAFIPCOD',prop:'Visible'},{av:'edtLegSinCod_Visible',ctrl:'LEGSINCOD',prop:'Visible'},{av:'edtLegFecIngreso_Visible',ctrl:'LEGFECINGRESO',prop:'Visible'},{av:'edtLegFecEgreso_Visible',ctrl:'LEGFECEGRESO',prop:'Visible'},{av:'edtMegDescrip_Visible',ctrl:'MEGDESCRIP',prop:'Visible'},{av:'edtLegCBU_Visible',ctrl:'LEGCBU',prop:'Visible'},{av:'edtLegBanDes_Visible',ctrl:'LEGBANDES',prop:'Visible'},{av:'cmbLegBanTipCuen'},{av:'edtLegBanSuc_Visible',ctrl:'LEGBANSUC',prop:'Visible'},{av:'edtLegCuentaBanc_Visible',ctrl:'LEGCUENTABANC',prop:'Visible'},{av:'cmbLegModTra'},{av:'cmbLegClase'},{av:'cmbLegTipoTarifa'},{av:'edtLegCodPos_Visible',ctrl:'LEGCODPOS',prop:'Visible'},{av:'cmbLegSexo'},{av:'edtLegFecNac_Visible',ctrl:'LEGFECNAC',prop:'Visible'},{av:'chkLegSCVO.getVisible()',ctrl:'LEGSCVO',prop:'Visible'},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerSinDia_Visible',ctrl:'LIQPERSINDIA',prop:'Visible'},{av:'edtTliqDesc_Visible',ctrl:'TLIQDESC',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtDConCodigo_Visible',ctrl:'DCONCODIGO',prop:'Visible'},{av:'edtDConDescrip_Visible',ctrl:'DCONDESCRIP',prop:'Visible'},{av:'cmbDTipoConCod'},{av:'edtavConclasifaux_Visible',ctrl:'vCONCLASIFAUX',prop:'Visible'},{av:'edtLiqDCanti_Visible',ctrl:'LIQDCANTI',prop:'Visible'},{av:'edtLiqDImpCalcu_Visible',ctrl:'LIQDIMPCALCU',prop:'Visible'},{av:'edtLiqDReFormulaHTML_Visible',ctrl:'LIQDREFORMULAHTML',prop:'Visible'},{av:'edtLiqDFormulaHTML_Visible',ctrl:'LIQDFORMULAHTML',prop:'Visible'},{av:'edtLiqDLogRecal_Visible',ctrl:'LIQDLOGRECAL',prop:'Visible'},{av:'edtLiqDErrorDesc_Visible',ctrl:'LIQDERRORDESC',prop:'Visible'},{av:'edtLiqDImpReCalcu_Visible',ctrl:'LIQDIMPRECALCU',prop:'Visible'},{av:'AV88GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV89GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV90GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13J82',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV162Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14J82',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV162Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15J82',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV162Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV128TFLiqDLogRecal_SelsJson',fld:'vTFLIQDLOGRECAL_SELSJSON',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV77TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV75TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV72TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV69TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV65TFLiqFecPago_SelsJson',fld:'vTFLIQFECPAGO_SELSJSON',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV62TFTliqDesc_SelsJson',fld:'vTFTLIQDESC_SELSJSON',pic:''},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV59TFLiqPerSinDia_SelsJson',fld:'vTFLIQPERSINDIA_SELSJSON',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV55TFLiqFecha_SelsJson',fld:'vTFLIQFECHA_SELSJSON',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV52TFLiqDescrip_SelsJson',fld:'vTFLIQDESCRIP_SELSJSON',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV157TFLegTipoTarifa_SelsJson',fld:'vTFLEGTIPOTARIFA_SELSJSON',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV47TFLegClase_SelsJson',fld:'vTFLEGCLASE_SELSJSON',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV155TFLegModTra_SelsJson',fld:'vTFLEGMODTRA_SELSJSON',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV44TFLegCuentaBanc_SelsJson',fld:'vTFLEGCUENTABANC_SELSJSON',pic:''},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV143TFLegOsoDes_SelsJson',fld:'vTFLEGOSODES_SELSJSON',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV36TFSecDescrip_SelsJson',fld:'vTFSECDESCRIP_SELSJSON',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV33TFLiqNombre_SelsJson',fld:'vTFLIQNOMBRE_SELSJSON',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV30TFLegNomApe_SelsJson',fld:'vTFLEGNOMAPE_SELSJSON',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV27TFLegId_SelsJson',fld:'vTFLEGID_SELSJSON',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20J82',iparms:[{av:'A939LegCatCodigo',fld:'LEGCATCODIGO',pic:''},{av:'A937LegConveCodigo',fld:'LEGCONVECODIGO',pic:''},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A394DConCodigo',fld:'DCONCODIGO',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV17ConveDescri',fld:'vCONVEDESCRI',pic:''},{av:'AV18CatDescrip',fld:'vCATDESCRIP',pic:''},{av:'AV127ConClasifAux',fld:'vCONCLASIFAUX',pic:''}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11J82',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV162Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtavConvedescri_Visible',ctrl:'vCONVEDESCRI',prop:'Visible'},{av:'edtavCatdescrip_Visible',ctrl:'vCATDESCRIP',prop:'Visible'},{av:'edtSecDescrip_Visible',ctrl:'SECDESCRIP',prop:'Visible'},{av:'edtZonDescrip_Visible',ctrl:'ZONDESCRIP',prop:'Visible'},{av:'cmbLegFormaPago'},{av:'edtLegActCodigo_Visible',ctrl:'LEGACTCODIGO',prop:'Visible'},{av:'edtLegOsoDes_Visible',ctrl:'LEGOSODES',prop:'Visible'},{av:'edtLegOsoAfipCod_Visible',ctrl:'LEGOSOAFIPCOD',prop:'Visible'},{av:'edtLegSinCod_Visible',ctrl:'LEGSINCOD',prop:'Visible'},{av:'edtLegFecIngreso_Visible',ctrl:'LEGFECINGRESO',prop:'Visible'},{av:'edtLegFecEgreso_Visible',ctrl:'LEGFECEGRESO',prop:'Visible'},{av:'edtMegDescrip_Visible',ctrl:'MEGDESCRIP',prop:'Visible'},{av:'edtLegCBU_Visible',ctrl:'LEGCBU',prop:'Visible'},{av:'edtLegBanDes_Visible',ctrl:'LEGBANDES',prop:'Visible'},{av:'cmbLegBanTipCuen'},{av:'edtLegBanSuc_Visible',ctrl:'LEGBANSUC',prop:'Visible'},{av:'edtLegCuentaBanc_Visible',ctrl:'LEGCUENTABANC',prop:'Visible'},{av:'cmbLegModTra'},{av:'cmbLegClase'},{av:'cmbLegTipoTarifa'},{av:'edtLegCodPos_Visible',ctrl:'LEGCODPOS',prop:'Visible'},{av:'cmbLegSexo'},{av:'edtLegFecNac_Visible',ctrl:'LEGFECNAC',prop:'Visible'},{av:'chkLegSCVO.getVisible()',ctrl:'LEGSCVO',prop:'Visible'},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerSinDia_Visible',ctrl:'LIQPERSINDIA',prop:'Visible'},{av:'edtTliqDesc_Visible',ctrl:'TLIQDESC',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtDConCodigo_Visible',ctrl:'DCONCODIGO',prop:'Visible'},{av:'edtDConDescrip_Visible',ctrl:'DCONDESCRIP',prop:'Visible'},{av:'cmbDTipoConCod'},{av:'edtavConclasifaux_Visible',ctrl:'vCONCLASIFAUX',prop:'Visible'},{av:'edtLiqDCanti_Visible',ctrl:'LIQDCANTI',prop:'Visible'},{av:'edtLiqDImpCalcu_Visible',ctrl:'LIQDIMPCALCU',prop:'Visible'},{av:'edtLiqDReFormulaHTML_Visible',ctrl:'LIQDREFORMULAHTML',prop:'Visible'},{av:'edtLiqDFormulaHTML_Visible',ctrl:'LIQDFORMULAHTML',prop:'Visible'},{av:'edtLiqDLogRecal_Visible',ctrl:'LIQDLOGRECAL',prop:'Visible'},{av:'edtLiqDErrorDesc_Visible',ctrl:'LIQDERRORDESC',prop:'Visible'},{av:'edtLiqDImpReCalcu_Visible',ctrl:'LIQDIMPRECALCU',prop:'Visible'},{av:'AV88GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV89GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV90GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12J82',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV162Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV27TFLegId_SelsJson',fld:'vTFLEGID_SELSJSON',pic:''},{av:'AV30TFLegNomApe_SelsJson',fld:'vTFLEGNOMAPE_SELSJSON',pic:''},{av:'AV33TFLiqNombre_SelsJson',fld:'vTFLIQNOMBRE_SELSJSON',pic:''},{av:'AV36TFSecDescrip_SelsJson',fld:'vTFSECDESCRIP_SELSJSON',pic:''},{av:'AV143TFLegOsoDes_SelsJson',fld:'vTFLEGOSODES_SELSJSON',pic:''},{av:'AV44TFLegCuentaBanc_SelsJson',fld:'vTFLEGCUENTABANC_SELSJSON',pic:''},{av:'AV155TFLegModTra_SelsJson',fld:'vTFLEGMODTRA_SELSJSON',pic:''},{av:'AV47TFLegClase_SelsJson',fld:'vTFLEGCLASE_SELSJSON',pic:''},{av:'AV157TFLegTipoTarifa_SelsJson',fld:'vTFLEGTIPOTARIFA_SELSJSON',pic:''},{av:'AV52TFLiqDescrip_SelsJson',fld:'vTFLIQDESCRIP_SELSJSON',pic:''},{av:'AV55TFLiqFecha_SelsJson',fld:'vTFLIQFECHA_SELSJSON',pic:''},{av:'AV59TFLiqPerSinDia_SelsJson',fld:'vTFLIQPERSINDIA_SELSJSON',pic:''},{av:'AV62TFTliqDesc_SelsJson',fld:'vTFTLIQDESC_SELSJSON',pic:''},{av:'AV65TFLiqFecPago_SelsJson',fld:'vTFLIQFECPAGO_SELSJSON',pic:''},{av:'AV69TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV72TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV75TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV77TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV128TFLiqDLogRecal_SelsJson',fld:'vTFLIQDLOGRECAL_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV26ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28TFLegId',fld:'vTFLEGID',pic:''},{av:'AV29TFLegId_Sels',fld:'vTFLEGID_SELS',pic:''},{av:'AV31TFLegNomApe',fld:'vTFLEGNOMAPE',pic:''},{av:'AV32TFLegNomApe_Sels',fld:'vTFLEGNOMAPE_SELS',pic:''},{av:'AV34TFLiqNombre',fld:'vTFLIQNOMBRE',pic:''},{av:'AV35TFLiqNombre_Sels',fld:'vTFLIQNOMBRE_SELS',pic:''},{av:'AV37TFSecDescrip',fld:'vTFSECDESCRIP',pic:''},{av:'AV38TFSecDescrip_Sels',fld:'vTFSECDESCRIP_SELS',pic:''},{av:'AV144TFLegOsoDes',fld:'vTFLEGOSODES',pic:''},{av:'AV145TFLegOsoDes_Sels',fld:'vTFLEGOSODES_SELS',pic:''},{av:'AV45TFLegCuentaBanc',fld:'vTFLEGCUENTABANC',pic:'@!'},{av:'AV46TFLegCuentaBanc_Sels',fld:'vTFLEGCUENTABANC_SELS',pic:''},{av:'AV156TFLegModTra_Sels',fld:'vTFLEGMODTRA_SELS',pic:''},{av:'AV48TFLegClase_Sels',fld:'vTFLEGCLASE_SELS',pic:''},{av:'AV158TFLegTipoTarifa_Sels',fld:'vTFLEGTIPOTARIFA_SELS',pic:''},{av:'AV53TFLiqDescrip',fld:'vTFLIQDESCRIP',pic:''},{av:'AV54TFLiqDescrip_Sels',fld:'vTFLIQDESCRIP_SELS',pic:''},{av:'AV56TFLiqFecha',fld:'vTFLIQFECHA',pic:''},{av:'AV57TFLiqFecha_Sels',fld:'vTFLIQFECHA_SELS',pic:''},{av:'AV60TFLiqPerSinDia',fld:'vTFLIQPERSINDIA',pic:''},{av:'AV61TFLiqPerSinDia_Sels',fld:'vTFLIQPERSINDIA_SELS',pic:''},{av:'AV63TFTliqDesc',fld:'vTFTLIQDESC',pic:'@!'},{av:'AV64TFTliqDesc_Sels',fld:'vTFTLIQDESC_SELS',pic:''},{av:'AV66TFLiqFecPago',fld:'vTFLIQFECPAGO',pic:''},{av:'AV67TFLiqFecPago_Sels',fld:'vTFLIQFECPAGO_SELS',pic:''},{av:'AV70TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV71TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV73TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV74TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV76TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV78TFConClasifAux',fld:'vTFCONCLASIFAUX',pic:''},{av:'AV79TFConClasifAux_Sels',fld:'vTFCONCLASIFAUX_SELS',pic:''},{av:'AV80TFLiqDCanti',fld:'vTFLIQDCANTI',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV81TFLiqDCanti_To',fld:'vTFLIQDCANTI_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV84TFLiqDImpCalcu',fld:'vTFLIQDIMPCALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV85TFLiqDImpCalcu_To',fld:'vTFLIQDIMPCALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV129TFLiqDLogRecal',fld:'vTFLIQDLOGRECAL',pic:''},{av:'AV130TFLiqDLogRecal_Sels',fld:'vTFLIQDLOGRECAL_SELS',pic:''},{av:'AV82TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV83TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV128TFLiqDLogRecal_SelsJson',fld:'vTFLIQDLOGRECAL_SELSJSON',pic:''},{av:'AV77TFConClasifAux_SelsJson',fld:'vTFCONCLASIFAUX_SELSJSON',pic:''},{av:'AV75TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV72TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV69TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV65TFLiqFecPago_SelsJson',fld:'vTFLIQFECPAGO_SELSJSON',pic:''},{av:'AV62TFTliqDesc_SelsJson',fld:'vTFTLIQDESC_SELSJSON',pic:''},{av:'AV59TFLiqPerSinDia_SelsJson',fld:'vTFLIQPERSINDIA_SELSJSON',pic:''},{av:'AV55TFLiqFecha_SelsJson',fld:'vTFLIQFECHA_SELSJSON',pic:''},{av:'AV52TFLiqDescrip_SelsJson',fld:'vTFLIQDESCRIP_SELSJSON',pic:''},{av:'AV157TFLegTipoTarifa_SelsJson',fld:'vTFLEGTIPOTARIFA_SELSJSON',pic:''},{av:'AV47TFLegClase_SelsJson',fld:'vTFLEGCLASE_SELSJSON',pic:''},{av:'AV155TFLegModTra_SelsJson',fld:'vTFLEGMODTRA_SELSJSON',pic:''},{av:'AV44TFLegCuentaBanc_SelsJson',fld:'vTFLEGCUENTABANC_SELSJSON',pic:''},{av:'AV143TFLegOsoDes_SelsJson',fld:'vTFLEGOSODES_SELSJSON',pic:''},{av:'AV36TFSecDescrip_SelsJson',fld:'vTFSECDESCRIP_SELSJSON',pic:''},{av:'AV33TFLiqNombre_SelsJson',fld:'vTFLIQNOMBRE_SELSJSON',pic:''},{av:'AV30TFLegNomApe_SelsJson',fld:'vTFLEGNOMAPE_SELSJSON',pic:''},{av:'AV27TFLegId_SelsJson',fld:'vTFLEGID_SELSJSON',pic:''},{av:'AV99EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV21ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegId_Visible',ctrl:'LEGID',prop:'Visible'},{av:'edtLegNomApe_Visible',ctrl:'LEGNOMAPE',prop:'Visible'},{av:'edtLegCUIL_Visible',ctrl:'LEGCUIL',prop:'Visible'},{av:'edtLiqNombre_Visible',ctrl:'LIQNOMBRE',prop:'Visible'},{av:'edtavConvedescri_Visible',ctrl:'vCONVEDESCRI',prop:'Visible'},{av:'edtavCatdescrip_Visible',ctrl:'vCATDESCRIP',prop:'Visible'},{av:'edtSecDescrip_Visible',ctrl:'SECDESCRIP',prop:'Visible'},{av:'edtZonDescrip_Visible',ctrl:'ZONDESCRIP',prop:'Visible'},{av:'cmbLegFormaPago'},{av:'edtLegActCodigo_Visible',ctrl:'LEGACTCODIGO',prop:'Visible'},{av:'edtLegOsoDes_Visible',ctrl:'LEGOSODES',prop:'Visible'},{av:'edtLegOsoAfipCod_Visible',ctrl:'LEGOSOAFIPCOD',prop:'Visible'},{av:'edtLegSinCod_Visible',ctrl:'LEGSINCOD',prop:'Visible'},{av:'edtLegFecIngreso_Visible',ctrl:'LEGFECINGRESO',prop:'Visible'},{av:'edtLegFecEgreso_Visible',ctrl:'LEGFECEGRESO',prop:'Visible'},{av:'edtMegDescrip_Visible',ctrl:'MEGDESCRIP',prop:'Visible'},{av:'edtLegCBU_Visible',ctrl:'LEGCBU',prop:'Visible'},{av:'edtLegBanDes_Visible',ctrl:'LEGBANDES',prop:'Visible'},{av:'cmbLegBanTipCuen'},{av:'edtLegBanSuc_Visible',ctrl:'LEGBANSUC',prop:'Visible'},{av:'edtLegCuentaBanc_Visible',ctrl:'LEGCUENTABANC',prop:'Visible'},{av:'cmbLegModTra'},{av:'cmbLegClase'},{av:'cmbLegTipoTarifa'},{av:'edtLegCodPos_Visible',ctrl:'LEGCODPOS',prop:'Visible'},{av:'cmbLegSexo'},{av:'edtLegFecNac_Visible',ctrl:'LEGFECNAC',prop:'Visible'},{av:'chkLegSCVO.getVisible()',ctrl:'LEGSCVO',prop:'Visible'},{av:'edtLiqNro_Visible',ctrl:'LIQNRO',prop:'Visible'},{av:'edtLiqDescrip_Visible',ctrl:'LIQDESCRIP',prop:'Visible'},{av:'edtLiqFecha_Visible',ctrl:'LIQFECHA',prop:'Visible'},{av:'edtLiqPerSinDia_Visible',ctrl:'LIQPERSINDIA',prop:'Visible'},{av:'edtTliqDesc_Visible',ctrl:'TLIQDESC',prop:'Visible'},{av:'edtLiqFecPago_Visible',ctrl:'LIQFECPAGO',prop:'Visible'},{av:'edtDConCodigo_Visible',ctrl:'DCONCODIGO',prop:'Visible'},{av:'edtDConDescrip_Visible',ctrl:'DCONDESCRIP',prop:'Visible'},{av:'cmbDTipoConCod'},{av:'edtavConclasifaux_Visible',ctrl:'vCONCLASIFAUX',prop:'Visible'},{av:'edtLiqDCanti_Visible',ctrl:'LIQDCANTI',prop:'Visible'},{av:'edtLiqDImpCalcu_Visible',ctrl:'LIQDIMPCALCU',prop:'Visible'},{av:'edtLiqDReFormulaHTML_Visible',ctrl:'LIQDREFORMULAHTML',prop:'Visible'},{av:'edtLiqDFormulaHTML_Visible',ctrl:'LIQDFORMULAHTML',prop:'Visible'},{av:'edtLiqDLogRecal_Visible',ctrl:'LIQDLOGRECAL',prop:'Visible'},{av:'edtLiqDErrorDesc_Visible',ctrl:'LIQDERRORDESC',prop:'Visible'},{av:'edtLiqDImpReCalcu_Visible',ctrl:'LIQDIMPRECALCU',prop:'Visible'},{av:'AV88GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV89GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV90GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV24ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16J82',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17J82',iparms:[{av:'AV136WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV134MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV98CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21J81',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGSECCODIGO","{handler:'valid_Legseccodigo',iparms:[]");
      setEventMetadata("VALID_LEGSECCODIGO",",oparms:[]}");
      setEventMetadata("VALID_ZONCOD","{handler:'valid_Zoncod',iparms:[]");
      setEventMetadata("VALID_ZONCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGACTCODIGO","{handler:'valid_Legactcodigo',iparms:[]");
      setEventMetadata("VALID_LEGACTCODIGO",",oparms:[]}");
      setEventMetadata("VALID_LEGMEGCODIGO","{handler:'valid_Legmegcodigo',iparms:[]");
      setEventMetadata("VALID_LEGMEGCODIGO",",oparms:[]}");
      setEventMetadata("VALID_LIQNRO","{handler:'valid_Liqnro',iparms:[]");
      setEventMetadata("VALID_LIQNRO",",oparms:[]}");
      setEventMetadata("VALID_TLIQCOD","{handler:'valid_Tliqcod',iparms:[]");
      setEventMetadata("VALID_TLIQCOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Liqdimprecalcu',iparms:[]");
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
      wcpOAV134MenuOpcCod = "" ;
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
      AV134MenuOpcCod = "" ;
      AV21ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV162Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28TFLegId = "" ;
      AV29TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFLegNomApe = "" ;
      AV32TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34TFLiqNombre = "" ;
      AV35TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFSecDescrip = "" ;
      AV38TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV144TFLegOsoDes = "" ;
      AV145TFLegOsoDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFLegCuentaBanc = "" ;
      AV46TFLegCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV156TFLegModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFLegClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV158TFLegTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFLiqDescrip = "" ;
      AV54TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56TFLiqFecha = GXutil.nullDate() ;
      AV57TFLiqFecha_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV60TFLiqPerSinDia = "" ;
      AV61TFLiqPerSinDia_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFTliqDesc = "" ;
      AV64TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV66TFLiqFecPago = GXutil.nullDate() ;
      AV67TFLiqFecPago_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV70TFDConCodigo = "" ;
      AV71TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73TFDConDescrip = "" ;
      AV74TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV76TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV78TFConClasifAux = "" ;
      AV79TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFLiqDCanti = DecimalUtil.ZERO ;
      AV81TFLiqDCanti_To = DecimalUtil.ZERO ;
      AV84TFLiqDImpCalcu = DecimalUtil.ZERO ;
      AV85TFLiqDImpCalcu_To = DecimalUtil.ZERO ;
      AV129TFLiqDLogRecal = "" ;
      AV130TFLiqDLogRecal_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV82TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV83TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV86DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV24ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV90GridAppliedFilters = "" ;
      AV27TFLegId_SelsJson = "" ;
      AV30TFLegNomApe_SelsJson = "" ;
      AV33TFLiqNombre_SelsJson = "" ;
      AV36TFSecDescrip_SelsJson = "" ;
      AV143TFLegOsoDes_SelsJson = "" ;
      AV44TFLegCuentaBanc_SelsJson = "" ;
      AV155TFLegModTra_SelsJson = "" ;
      AV47TFLegClase_SelsJson = "" ;
      AV157TFLegTipoTarifa_SelsJson = "" ;
      AV52TFLiqDescrip_SelsJson = "" ;
      AV55TFLiqFecha_SelsJson = "" ;
      AV59TFLiqPerSinDia_SelsJson = "" ;
      AV62TFTliqDesc_SelsJson = "" ;
      AV65TFLiqFecPago_SelsJson = "" ;
      AV69TFDConCodigo_SelsJson = "" ;
      AV72TFDConDescrip_SelsJson = "" ;
      AV75TFDTipoConCod_SelsJson = "" ;
      AV77TFConClasifAux_SelsJson = "" ;
      AV128TFLiqDLogRecal_SelsJson = "" ;
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
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV58DDO_LiqFechaAuxDate = GXutil.nullDate() ;
      AV68DDO_LiqFecPagoAuxDate = GXutil.nullDate() ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A874LiqNombre = "" ;
      A937LegConveCodigo = "" ;
      AV17ConveDescri = "" ;
      A939LegCatCodigo = "" ;
      AV18CatDescrip = "" ;
      A1579LegSecCodigo = "" ;
      A329SecDescrip = "" ;
      A20ZonCod = "" ;
      A342ZonDescrip = "" ;
      A15LegActCodigo = "" ;
      A227LegActDescri = "" ;
      A2225LegOsoDes = "" ;
      A2226LegOsoAfipCod = "" ;
      A910LegSinCod = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A1583LegMegCodigo = "" ;
      A300MegDescrip = "" ;
      A234LegCBU = "" ;
      A2224LegBanDes = "" ;
      A232LegBanTipCuen = "" ;
      A231LegBanSuc = "" ;
      A238LegCuentaBanc = "" ;
      A2404LegModTra = "" ;
      A2417LegTipoTarifa = "" ;
      A236LegCodPos = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A513LiqPerSinDia = "" ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A464DTipoConCod = "" ;
      AV127ConClasifAux = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A876LiqDReFormulaHTML = "" ;
      A508LiqDFormulaHTML = "" ;
      A1072LiqDLogRecal = "" ;
      A270LiqDErrorDesc = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV28TFLegId = "" ;
      lV31TFLegNomApe = "" ;
      lV34TFLiqNombre = "" ;
      lV60TFLiqPerSinDia = "" ;
      lV70TFDConCodigo = "" ;
      lV73TFDConDescrip = "" ;
      lV129TFLiqDLogRecal = "" ;
      H00J82_A1580LegOsoCod = new String[] {""} ;
      H00J82_n1580LegOsoCod = new boolean[] {false} ;
      H00J82_A1582LegBanCod = new String[] {""} ;
      H00J82_n1582LegBanCod = new boolean[] {false} ;
      H00J82_A6LegNumero = new int[1] ;
      H00J82_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00J82_A270LiqDErrorDesc = new String[] {""} ;
      H00J82_n270LiqDErrorDesc = new boolean[] {false} ;
      H00J82_A81LiqDSecuencial = new int[1] ;
      H00J82_A1072LiqDLogRecal = new String[] {""} ;
      H00J82_A508LiqDFormulaHTML = new String[] {""} ;
      H00J82_n508LiqDFormulaHTML = new boolean[] {false} ;
      H00J82_A876LiqDReFormulaHTML = new String[] {""} ;
      H00J82_n876LiqDReFormulaHTML = new boolean[] {false} ;
      H00J82_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00J82_n275LiqDImpCalcu = new boolean[] {false} ;
      H00J82_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00J82_n269LiqDCanti = new boolean[] {false} ;
      H00J82_A464DTipoConCod = new String[] {""} ;
      H00J82_A393DConDescrip = new String[] {""} ;
      H00J82_A394DConCodigo = new String[] {""} ;
      H00J82_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      H00J82_A340TliqDesc = new String[] {""} ;
      H00J82_A32TLiqCod = new String[] {""} ;
      H00J82_n32TLiqCod = new boolean[] {false} ;
      H00J82_A513LiqPerSinDia = new String[] {""} ;
      H00J82_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00J82_A271LiqDescrip = new String[] {""} ;
      H00J82_A31LiqNro = new int[1] ;
      H00J82_A262LegSCVO = new boolean[] {false} ;
      H00J82_A246LegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      H00J82_A263LegSexo = new byte[1] ;
      H00J82_n263LegSexo = new boolean[] {false} ;
      H00J82_A236LegCodPos = new String[] {""} ;
      H00J82_A2417LegTipoTarifa = new String[] {""} ;
      H00J82_A235LegClase = new byte[1] ;
      H00J82_A2404LegModTra = new String[] {""} ;
      H00J82_A238LegCuentaBanc = new String[] {""} ;
      H00J82_n238LegCuentaBanc = new boolean[] {false} ;
      H00J82_A231LegBanSuc = new String[] {""} ;
      H00J82_n231LegBanSuc = new boolean[] {false} ;
      H00J82_A232LegBanTipCuen = new String[] {""} ;
      H00J82_n232LegBanTipCuen = new boolean[] {false} ;
      H00J82_A2224LegBanDes = new String[] {""} ;
      H00J82_A234LegCBU = new String[] {""} ;
      H00J82_n234LegCBU = new boolean[] {false} ;
      H00J82_A300MegDescrip = new String[] {""} ;
      H00J82_n300MegDescrip = new boolean[] {false} ;
      H00J82_A1583LegMegCodigo = new String[] {""} ;
      H00J82_n1583LegMegCodigo = new boolean[] {false} ;
      H00J82_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00J82_n244LegFecEgreso = new boolean[] {false} ;
      H00J82_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      H00J82_A910LegSinCod = new String[] {""} ;
      H00J82_n910LegSinCod = new boolean[] {false} ;
      H00J82_A2226LegOsoAfipCod = new String[] {""} ;
      H00J82_n2226LegOsoAfipCod = new boolean[] {false} ;
      H00J82_A2225LegOsoDes = new String[] {""} ;
      H00J82_A227LegActDescri = new String[] {""} ;
      H00J82_A15LegActCodigo = new String[] {""} ;
      H00J82_n15LegActCodigo = new boolean[] {false} ;
      H00J82_A248LegFormaPago = new byte[1] ;
      H00J82_A342ZonDescrip = new String[] {""} ;
      H00J82_A20ZonCod = new String[] {""} ;
      H00J82_n20ZonCod = new boolean[] {false} ;
      H00J82_A329SecDescrip = new String[] {""} ;
      H00J82_n329SecDescrip = new boolean[] {false} ;
      H00J82_A1579LegSecCodigo = new String[] {""} ;
      H00J82_n1579LegSecCodigo = new boolean[] {false} ;
      H00J82_A939LegCatCodigo = new String[] {""} ;
      H00J82_n939LegCatCodigo = new boolean[] {false} ;
      H00J82_A937LegConveCodigo = new String[] {""} ;
      H00J82_n937LegConveCodigo = new boolean[] {false} ;
      H00J82_A874LiqNombre = new String[] {""} ;
      H00J82_A239LegCUIL = new long[1] ;
      H00J82_A591LegNomApe = new String[] {""} ;
      H00J82_A1EmpCod = new short[1] ;
      H00J82_A3CliCod = new int[1] ;
      H00J82_A93LegId = new String[] {""} ;
      H00J82_n93LegId = new boolean[] {false} ;
      A1580LegOsoCod = "" ;
      A1582LegBanCod = "" ;
      H00J83_AGRID_nRecordCount = new long[1] ;
      AV142WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV137MenuBienveImgURL = "" ;
      AV139MenuBienveTitulo = "" ;
      AV140MenuBienveTexto = "" ;
      AV161Welcomemessage_foto_GXI = "" ;
      AV151observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV19ColumnsSelectorXML = "" ;
      AV150MenuOpcTitulo = "" ;
      GXv_int2 = new short[1] ;
      AV154filtrosTexto = "" ;
      GXv_int4 = new int[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV25ManageFiltersXml = "" ;
      AV101ExcelFilename = "" ;
      AV102ErrorMessage = "" ;
      AV20UserCustomValue = "" ;
      AV22ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char12 = "" ;
      GXv_char9 = new String[1] ;
      GXt_char11 = "" ;
      GXv_char8 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char43 = "" ;
      GXt_char41 = "" ;
      GXv_char42 = new String[1] ;
      GXt_char39 = "" ;
      GXv_char40 = new String[1] ;
      GXt_char37 = "" ;
      GXv_char38 = new String[1] ;
      GXt_char35 = "" ;
      GXv_char36 = new String[1] ;
      GXt_char33 = "" ;
      GXv_char34 = new String[1] ;
      GXt_char31 = "" ;
      GXv_char32 = new String[1] ;
      GXt_char29 = "" ;
      GXv_char30 = new String[1] ;
      GXt_char27 = "" ;
      GXv_char28 = new String[1] ;
      GXt_char25 = "" ;
      GXv_char26 = new String[1] ;
      GXt_char23 = "" ;
      GXv_char24 = new String[1] ;
      GXt_char21 = "" ;
      GXv_char22 = new String[1] ;
      GXt_char19 = "" ;
      GXv_char20 = new String[1] ;
      GXv_SdtWWPGridState45 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV138textoNoMostrara = "" ;
      GXv_char44 = new String[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacion_export3__default(),
         new Object[] {
             new Object[] {
            H00J82_A1580LegOsoCod, H00J82_n1580LegOsoCod, H00J82_A1582LegBanCod, H00J82_n1582LegBanCod, H00J82_A6LegNumero, H00J82_A764LiqDImpReCalcu, H00J82_A270LiqDErrorDesc, H00J82_n270LiqDErrorDesc, H00J82_A81LiqDSecuencial, H00J82_A1072LiqDLogRecal,
            H00J82_A508LiqDFormulaHTML, H00J82_n508LiqDFormulaHTML, H00J82_A876LiqDReFormulaHTML, H00J82_n876LiqDReFormulaHTML, H00J82_A275LiqDImpCalcu, H00J82_n275LiqDImpCalcu, H00J82_A269LiqDCanti, H00J82_n269LiqDCanti, H00J82_A464DTipoConCod, H00J82_A393DConDescrip,
            H00J82_A394DConCodigo, H00J82_A280LiqFecPago, H00J82_A340TliqDesc, H00J82_A32TLiqCod, H00J82_n32TLiqCod, H00J82_A513LiqPerSinDia, H00J82_A98LiqFecha, H00J82_A271LiqDescrip, H00J82_A31LiqNro, H00J82_A262LegSCVO,
            H00J82_A246LegFecNac, H00J82_A263LegSexo, H00J82_n263LegSexo, H00J82_A236LegCodPos, H00J82_A2417LegTipoTarifa, H00J82_A235LegClase, H00J82_A2404LegModTra, H00J82_A238LegCuentaBanc, H00J82_n238LegCuentaBanc, H00J82_A231LegBanSuc,
            H00J82_n231LegBanSuc, H00J82_A232LegBanTipCuen, H00J82_n232LegBanTipCuen, H00J82_A2224LegBanDes, H00J82_A234LegCBU, H00J82_n234LegCBU, H00J82_A300MegDescrip, H00J82_n300MegDescrip, H00J82_A1583LegMegCodigo, H00J82_n1583LegMegCodigo,
            H00J82_A244LegFecEgreso, H00J82_n244LegFecEgreso, H00J82_A245LegFecIngreso, H00J82_A910LegSinCod, H00J82_n910LegSinCod, H00J82_A2226LegOsoAfipCod, H00J82_n2226LegOsoAfipCod, H00J82_A2225LegOsoDes, H00J82_A227LegActDescri, H00J82_A15LegActCodigo,
            H00J82_n15LegActCodigo, H00J82_A248LegFormaPago, H00J82_A342ZonDescrip, H00J82_A20ZonCod, H00J82_n20ZonCod, H00J82_A329SecDescrip, H00J82_n329SecDescrip, H00J82_A1579LegSecCodigo, H00J82_n1579LegSecCodigo, H00J82_A939LegCatCodigo,
            H00J82_n939LegCatCodigo, H00J82_A937LegConveCodigo, H00J82_n937LegConveCodigo, H00J82_A874LiqNombre, H00J82_A239LegCUIL, H00J82_A591LegNomApe, H00J82_A1EmpCod, H00J82_A3CliCod, H00J82_A93LegId, H00J82_n93LegId
            }
            , new Object[] {
            H00J83_AGRID_nRecordCount
            }
         }
      );
      AV162Pgmname = "liquidacion_export3" ;
      /* GeneXus formulas. */
      AV162Pgmname = "liquidacion_export3" ;
      Gx_err = (short)(0) ;
      edtavConvedescri_Enabled = 0 ;
      edtavCatdescrip_Enabled = 0 ;
      edtavConclasifaux_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV26ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte A248LegFormaPago ;
   private byte A235LegClase ;
   private byte A263LegSexo ;
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
   private short AV14OrderedBy ;
   private short AV99EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_108 ;
   private int nGXsfl_108_idx=1 ;
   private int AV98CliCod ;
   private int A6LegNumero ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private int subGrid_Islastpage ;
   private int edtavConvedescri_Enabled ;
   private int edtavCatdescrip_Enabled ;
   private int edtavConclasifaux_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV29TFLegId_Sels_size ;
   private int AV32TFLegNomApe_Sels_size ;
   private int AV35TFLiqNombre_Sels_size ;
   private int AV38TFSecDescrip_Sels_size ;
   private int AV145TFLegOsoDes_Sels_size ;
   private int AV46TFLegCuentaBanc_Sels_size ;
   private int AV156TFLegModTra_Sels_size ;
   private int AV48TFLegClase_Sels_size ;
   private int AV158TFLegTipoTarifa_Sels_size ;
   private int AV54TFLiqDescrip_Sels_size ;
   private int AV57TFLiqFecha_Sels_size ;
   private int AV61TFLiqPerSinDia_Sels_size ;
   private int AV64TFTliqDesc_Sels_size ;
   private int AV67TFLiqFecPago_Sels_size ;
   private int AV71TFDConCodigo_Sels_size ;
   private int AV74TFDConDescrip_Sels_size ;
   private int AV76TFDTipoConCod_Sels_size ;
   private int AV130TFLiqDLogRecal_Sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int3 ;
   private int edtLegId_Visible ;
   private int edtLegNomApe_Visible ;
   private int edtLegCUIL_Visible ;
   private int edtLiqNombre_Visible ;
   private int edtavConvedescri_Visible ;
   private int edtavCatdescrip_Visible ;
   private int edtSecDescrip_Visible ;
   private int edtZonDescrip_Visible ;
   private int edtLegActCodigo_Visible ;
   private int edtLegOsoDes_Visible ;
   private int edtLegOsoAfipCod_Visible ;
   private int edtLegSinCod_Visible ;
   private int edtLegFecIngreso_Visible ;
   private int edtLegFecEgreso_Visible ;
   private int edtMegDescrip_Visible ;
   private int edtLegCBU_Visible ;
   private int edtLegBanDes_Visible ;
   private int edtLegBanSuc_Visible ;
   private int edtLegCuentaBanc_Visible ;
   private int edtLegCodPos_Visible ;
   private int edtLegFecNac_Visible ;
   private int edtLiqNro_Visible ;
   private int edtLiqDescrip_Visible ;
   private int edtLiqFecha_Visible ;
   private int edtLiqPerSinDia_Visible ;
   private int edtTliqDesc_Visible ;
   private int edtLiqFecPago_Visible ;
   private int edtDConCodigo_Visible ;
   private int edtDConDescrip_Visible ;
   private int edtavConclasifaux_Visible ;
   private int edtLiqDCanti_Visible ;
   private int edtLiqDImpCalcu_Visible ;
   private int edtLiqDReFormulaHTML_Visible ;
   private int edtLiqDFormulaHTML_Visible ;
   private int edtLiqDLogRecal_Visible ;
   private int edtLiqDErrorDesc_Visible ;
   private int edtLiqDImpReCalcu_Visible ;
   private int lblCouttext_Visible ;
   private int AV153filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV87PageToGo ;
   private int AV104CliConveVer ;
   private int GXv_int4[] ;
   private int AV163GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV88GridCurrentPage ;
   private long AV89GridPageCount ;
   private long A239LegCUIL ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV80TFLiqDCanti ;
   private java.math.BigDecimal AV81TFLiqDCanti_To ;
   private java.math.BigDecimal AV84TFLiqDImpCalcu ;
   private java.math.BigDecimal AV85TFLiqDImpCalcu_To ;
   private java.math.BigDecimal AV82TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV83TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
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
   private String AV162Pgmname ;
   private String AV28TFLegId ;
   private String AV60TFLiqPerSinDia ;
   private String AV70TFDConCodigo ;
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
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_liqfechaauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_liqfechaauxdate_Internalname ;
   private String edtavDdo_liqfechaauxdate_Jsonclick ;
   private String divDdo_liqfecpagoauxdates_Internalname ;
   private String edtavDdo_liqfecpagoauxdate_Internalname ;
   private String edtavDdo_liqfecpagoauxdate_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String A93LegId ;
   private String edtLegId_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLegNomApe_Internalname ;
   private String edtLegCUIL_Internalname ;
   private String edtLiqNombre_Internalname ;
   private String A937LegConveCodigo ;
   private String edtLegConveCodigo_Internalname ;
   private String edtavConvedescri_Internalname ;
   private String A939LegCatCodigo ;
   private String edtLegCatCodigo_Internalname ;
   private String edtavCatdescrip_Internalname ;
   private String A1579LegSecCodigo ;
   private String edtLegSecCodigo_Internalname ;
   private String edtSecDescrip_Internalname ;
   private String A20ZonCod ;
   private String edtZonCod_Internalname ;
   private String edtZonDescrip_Internalname ;
   private String A15LegActCodigo ;
   private String edtLegActCodigo_Internalname ;
   private String edtLegActDescri_Internalname ;
   private String edtLegOsoDes_Internalname ;
   private String A2226LegOsoAfipCod ;
   private String edtLegOsoAfipCod_Internalname ;
   private String A910LegSinCod ;
   private String edtLegSinCod_Internalname ;
   private String edtLegFecIngreso_Internalname ;
   private String edtLegFecEgreso_Internalname ;
   private String A1583LegMegCodigo ;
   private String edtLegMegCodigo_Internalname ;
   private String edtMegDescrip_Internalname ;
   private String edtLegCBU_Internalname ;
   private String edtLegBanDes_Internalname ;
   private String A232LegBanTipCuen ;
   private String edtLegBanSuc_Internalname ;
   private String edtLegCuentaBanc_Internalname ;
   private String A2404LegModTra ;
   private String A2417LegTipoTarifa ;
   private String A236LegCodPos ;
   private String edtLegCodPos_Internalname ;
   private String edtLegFecNac_Internalname ;
   private String edtLiqNro_Internalname ;
   private String edtLiqDescrip_Internalname ;
   private String edtLiqFecha_Internalname ;
   private String A513LiqPerSinDia ;
   private String edtLiqPerSinDia_Internalname ;
   private String A32TLiqCod ;
   private String edtTLiqCod_Internalname ;
   private String edtTliqDesc_Internalname ;
   private String edtLiqFecPago_Internalname ;
   private String A394DConCodigo ;
   private String edtDConCodigo_Internalname ;
   private String edtDConDescrip_Internalname ;
   private String A464DTipoConCod ;
   private String edtavConclasifaux_Internalname ;
   private String edtLiqDCanti_Internalname ;
   private String edtLiqDImpCalcu_Internalname ;
   private String edtLiqDReFormulaHTML_Internalname ;
   private String edtLiqDFormulaHTML_Internalname ;
   private String edtLiqDLogRecal_Internalname ;
   private String edtLiqDSecuencial_Internalname ;
   private String edtLiqDErrorDesc_Internalname ;
   private String edtLiqDImpReCalcu_Internalname ;
   private String scmdbuf ;
   private String lV28TFLegId ;
   private String lV60TFLiqPerSinDia ;
   private String lV70TFDConCodigo ;
   private String A1580LegOsoCod ;
   private String A1582LegBanCod ;
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
   private String AV151observerPalabra ;
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
   private String GXt_char12 ;
   private String GXv_char9[] ;
   private String GXt_char11 ;
   private String GXv_char8[] ;
   private String GXt_char18 ;
   private String GXv_char7[] ;
   private String GXt_char43 ;
   private String GXt_char41 ;
   private String GXv_char42[] ;
   private String GXt_char39 ;
   private String GXv_char40[] ;
   private String GXt_char37 ;
   private String GXv_char38[] ;
   private String GXt_char35 ;
   private String GXv_char36[] ;
   private String GXt_char33 ;
   private String GXv_char34[] ;
   private String GXt_char31 ;
   private String GXv_char32[] ;
   private String GXt_char29 ;
   private String GXv_char30[] ;
   private String GXt_char27 ;
   private String GXv_char28[] ;
   private String GXt_char25 ;
   private String GXv_char26[] ;
   private String GXt_char23 ;
   private String GXv_char24[] ;
   private String GXt_char21 ;
   private String GXv_char22[] ;
   private String GXt_char19 ;
   private String GXv_char20[] ;
   private String GXv_char44[] ;
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
   private String edtLegId_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNomApe_Jsonclick ;
   private String edtLegCUIL_Jsonclick ;
   private String edtLiqNombre_Jsonclick ;
   private String edtLegConveCodigo_Jsonclick ;
   private String edtavConvedescri_Jsonclick ;
   private String edtLegCatCodigo_Jsonclick ;
   private String edtavCatdescrip_Jsonclick ;
   private String edtLegSecCodigo_Jsonclick ;
   private String edtSecDescrip_Jsonclick ;
   private String edtZonCod_Jsonclick ;
   private String edtZonDescrip_Jsonclick ;
   private String GXCCtl ;
   private String edtLegActCodigo_Jsonclick ;
   private String edtLegActDescri_Jsonclick ;
   private String edtLegOsoDes_Jsonclick ;
   private String edtLegOsoAfipCod_Jsonclick ;
   private String edtLegSinCod_Jsonclick ;
   private String edtLegFecIngreso_Jsonclick ;
   private String edtLegFecEgreso_Jsonclick ;
   private String edtLegMegCodigo_Jsonclick ;
   private String edtMegDescrip_Jsonclick ;
   private String edtLegCBU_Jsonclick ;
   private String edtLegBanDes_Jsonclick ;
   private String edtLegBanSuc_Jsonclick ;
   private String edtLegCuentaBanc_Jsonclick ;
   private String edtLegCodPos_Jsonclick ;
   private String edtLegFecNac_Jsonclick ;
   private String edtLiqNro_Jsonclick ;
   private String edtLiqDescrip_Jsonclick ;
   private String edtLiqFecha_Jsonclick ;
   private String edtLiqPerSinDia_Jsonclick ;
   private String edtTLiqCod_Jsonclick ;
   private String edtTliqDesc_Jsonclick ;
   private String edtLiqFecPago_Jsonclick ;
   private String edtDConCodigo_Jsonclick ;
   private String edtDConDescrip_Jsonclick ;
   private String edtavConclasifaux_Jsonclick ;
   private String edtLiqDCanti_Jsonclick ;
   private String edtLiqDImpCalcu_Jsonclick ;
   private String edtLiqDReFormulaHTML_Jsonclick ;
   private String edtLiqDFormulaHTML_Jsonclick ;
   private String edtLiqDLogRecal_Jsonclick ;
   private String edtLiqDSecuencial_Jsonclick ;
   private String edtLiqDErrorDesc_Jsonclick ;
   private String edtLiqDImpReCalcu_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV56TFLiqFecha ;
   private java.util.Date AV66TFLiqFecPago ;
   private java.util.Date AV58DDO_LiqFechaAuxDate ;
   private java.util.Date AV68DDO_LiqFecPagoAuxDate ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A246LegFecNac ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV136WelcomeMessage_NoMostrarMas ;
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
   private boolean n93LegId ;
   private boolean n937LegConveCodigo ;
   private boolean n939LegCatCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n329SecDescrip ;
   private boolean n20ZonCod ;
   private boolean n15LegActCodigo ;
   private boolean n2226LegOsoAfipCod ;
   private boolean n910LegSinCod ;
   private boolean n244LegFecEgreso ;
   private boolean n1583LegMegCodigo ;
   private boolean n300MegDescrip ;
   private boolean n234LegCBU ;
   private boolean n232LegBanTipCuen ;
   private boolean n231LegBanSuc ;
   private boolean n238LegCuentaBanc ;
   private boolean n263LegSexo ;
   private boolean A262LegSCVO ;
   private boolean n32TLiqCod ;
   private boolean n269LiqDCanti ;
   private boolean n275LiqDImpCalcu ;
   private boolean n876LiqDReFormulaHTML ;
   private boolean n508LiqDFormulaHTML ;
   private boolean n270LiqDErrorDesc ;
   private boolean bGXsfl_108_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n1580LegOsoCod ;
   private boolean n1582LegBanCod ;
   private boolean returnInSub ;
   private boolean AV141MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean GXv_boolean10[] ;
   private boolean AV142WelcomeMessage_Foto_IsBlob ;
   private String AV27TFLegId_SelsJson ;
   private String AV30TFLegNomApe_SelsJson ;
   private String AV33TFLiqNombre_SelsJson ;
   private String AV36TFSecDescrip_SelsJson ;
   private String AV143TFLegOsoDes_SelsJson ;
   private String AV44TFLegCuentaBanc_SelsJson ;
   private String AV155TFLegModTra_SelsJson ;
   private String AV47TFLegClase_SelsJson ;
   private String AV157TFLegTipoTarifa_SelsJson ;
   private String AV52TFLiqDescrip_SelsJson ;
   private String AV55TFLiqFecha_SelsJson ;
   private String AV59TFLiqPerSinDia_SelsJson ;
   private String AV62TFTliqDesc_SelsJson ;
   private String AV65TFLiqFecPago_SelsJson ;
   private String AV69TFDConCodigo_SelsJson ;
   private String AV72TFDConDescrip_SelsJson ;
   private String AV75TFDTipoConCod_SelsJson ;
   private String AV77TFConClasifAux_SelsJson ;
   private String AV128TFLiqDLogRecal_SelsJson ;
   private String A876LiqDReFormulaHTML ;
   private String A508LiqDFormulaHTML ;
   private String A1072LiqDLogRecal ;
   private String AV140MenuBienveTexto ;
   private String AV19ColumnsSelectorXML ;
   private String AV25ManageFiltersXml ;
   private String AV20UserCustomValue ;
   private String AV138textoNoMostrara ;
   private String wcpOAV134MenuOpcCod ;
   private String AV134MenuOpcCod ;
   private String AV31TFLegNomApe ;
   private String AV34TFLiqNombre ;
   private String AV37TFSecDescrip ;
   private String AV144TFLegOsoDes ;
   private String AV45TFLegCuentaBanc ;
   private String AV53TFLiqDescrip ;
   private String AV63TFTliqDesc ;
   private String AV73TFDConDescrip ;
   private String AV78TFConClasifAux ;
   private String AV129TFLiqDLogRecal ;
   private String AV90GridAppliedFilters ;
   private String A591LegNomApe ;
   private String A874LiqNombre ;
   private String AV17ConveDescri ;
   private String AV18CatDescrip ;
   private String A329SecDescrip ;
   private String A342ZonDescrip ;
   private String A227LegActDescri ;
   private String A2225LegOsoDes ;
   private String A300MegDescrip ;
   private String A234LegCBU ;
   private String A2224LegBanDes ;
   private String A231LegBanSuc ;
   private String A238LegCuentaBanc ;
   private String A271LiqDescrip ;
   private String A340TliqDesc ;
   private String A393DConDescrip ;
   private String AV127ConClasifAux ;
   private String A270LiqDErrorDesc ;
   private String lV31TFLegNomApe ;
   private String lV34TFLiqNombre ;
   private String lV73TFDConDescrip ;
   private String lV129TFLiqDLogRecal ;
   private String AV137MenuBienveImgURL ;
   private String AV139MenuBienveTitulo ;
   private String AV161Welcomemessage_foto_GXI ;
   private String AV150MenuOpcTitulo ;
   private String AV154filtrosTexto ;
   private String AV101ExcelFilename ;
   private String AV102ErrorMessage ;
   private String AV142WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV48TFLegClase_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbLegFormaPago ;
   private HTMLChoice cmbLegBanTipCuen ;
   private HTMLChoice cmbLegModTra ;
   private HTMLChoice cmbLegClase ;
   private HTMLChoice cmbLegTipoTarifa ;
   private HTMLChoice cmbLegSexo ;
   private ICheckbox chkLegSCVO ;
   private HTMLChoice cmbDTipoConCod ;
   private IDataStoreProvider pr_default ;
   private String[] H00J82_A1580LegOsoCod ;
   private boolean[] H00J82_n1580LegOsoCod ;
   private String[] H00J82_A1582LegBanCod ;
   private boolean[] H00J82_n1582LegBanCod ;
   private int[] H00J82_A6LegNumero ;
   private java.math.BigDecimal[] H00J82_A764LiqDImpReCalcu ;
   private String[] H00J82_A270LiqDErrorDesc ;
   private boolean[] H00J82_n270LiqDErrorDesc ;
   private int[] H00J82_A81LiqDSecuencial ;
   private String[] H00J82_A1072LiqDLogRecal ;
   private String[] H00J82_A508LiqDFormulaHTML ;
   private boolean[] H00J82_n508LiqDFormulaHTML ;
   private String[] H00J82_A876LiqDReFormulaHTML ;
   private boolean[] H00J82_n876LiqDReFormulaHTML ;
   private java.math.BigDecimal[] H00J82_A275LiqDImpCalcu ;
   private boolean[] H00J82_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] H00J82_A269LiqDCanti ;
   private boolean[] H00J82_n269LiqDCanti ;
   private String[] H00J82_A464DTipoConCod ;
   private String[] H00J82_A393DConDescrip ;
   private String[] H00J82_A394DConCodigo ;
   private java.util.Date[] H00J82_A280LiqFecPago ;
   private String[] H00J82_A340TliqDesc ;
   private String[] H00J82_A32TLiqCod ;
   private boolean[] H00J82_n32TLiqCod ;
   private String[] H00J82_A513LiqPerSinDia ;
   private java.util.Date[] H00J82_A98LiqFecha ;
   private String[] H00J82_A271LiqDescrip ;
   private int[] H00J82_A31LiqNro ;
   private boolean[] H00J82_A262LegSCVO ;
   private java.util.Date[] H00J82_A246LegFecNac ;
   private byte[] H00J82_A263LegSexo ;
   private boolean[] H00J82_n263LegSexo ;
   private String[] H00J82_A236LegCodPos ;
   private String[] H00J82_A2417LegTipoTarifa ;
   private byte[] H00J82_A235LegClase ;
   private String[] H00J82_A2404LegModTra ;
   private String[] H00J82_A238LegCuentaBanc ;
   private boolean[] H00J82_n238LegCuentaBanc ;
   private String[] H00J82_A231LegBanSuc ;
   private boolean[] H00J82_n231LegBanSuc ;
   private String[] H00J82_A232LegBanTipCuen ;
   private boolean[] H00J82_n232LegBanTipCuen ;
   private String[] H00J82_A2224LegBanDes ;
   private String[] H00J82_A234LegCBU ;
   private boolean[] H00J82_n234LegCBU ;
   private String[] H00J82_A300MegDescrip ;
   private boolean[] H00J82_n300MegDescrip ;
   private String[] H00J82_A1583LegMegCodigo ;
   private boolean[] H00J82_n1583LegMegCodigo ;
   private java.util.Date[] H00J82_A244LegFecEgreso ;
   private boolean[] H00J82_n244LegFecEgreso ;
   private java.util.Date[] H00J82_A245LegFecIngreso ;
   private String[] H00J82_A910LegSinCod ;
   private boolean[] H00J82_n910LegSinCod ;
   private String[] H00J82_A2226LegOsoAfipCod ;
   private boolean[] H00J82_n2226LegOsoAfipCod ;
   private String[] H00J82_A2225LegOsoDes ;
   private String[] H00J82_A227LegActDescri ;
   private String[] H00J82_A15LegActCodigo ;
   private boolean[] H00J82_n15LegActCodigo ;
   private byte[] H00J82_A248LegFormaPago ;
   private String[] H00J82_A342ZonDescrip ;
   private String[] H00J82_A20ZonCod ;
   private boolean[] H00J82_n20ZonCod ;
   private String[] H00J82_A329SecDescrip ;
   private boolean[] H00J82_n329SecDescrip ;
   private String[] H00J82_A1579LegSecCodigo ;
   private boolean[] H00J82_n1579LegSecCodigo ;
   private String[] H00J82_A939LegCatCodigo ;
   private boolean[] H00J82_n939LegCatCodigo ;
   private String[] H00J82_A937LegConveCodigo ;
   private boolean[] H00J82_n937LegConveCodigo ;
   private String[] H00J82_A874LiqNombre ;
   private long[] H00J82_A239LegCUIL ;
   private String[] H00J82_A591LegNomApe ;
   private short[] H00J82_A1EmpCod ;
   private int[] H00J82_A3CliCod ;
   private String[] H00J82_A93LegId ;
   private boolean[] H00J82_n93LegId ;
   private long[] H00J83_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV29TFLegId_Sels ;
   private GXSimpleCollection<String> AV156TFLegModTra_Sels ;
   private GXSimpleCollection<String> AV158TFLegTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV61TFLiqPerSinDia_Sels ;
   private GXSimpleCollection<String> AV71TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV76TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV32TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV35TFLiqNombre_Sels ;
   private GXSimpleCollection<String> AV38TFSecDescrip_Sels ;
   private GXSimpleCollection<String> AV145TFLegOsoDes_Sels ;
   private GXSimpleCollection<String> AV46TFLegCuentaBanc_Sels ;
   private GXSimpleCollection<String> AV54TFLiqDescrip_Sels ;
   private GXSimpleCollection<String> AV64TFTliqDesc_Sels ;
   private GXSimpleCollection<String> AV74TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV79TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV130TFLiqDLogRecal_Sels ;
   private GXSimpleCollection<java.util.Date> AV57TFLiqFecha_Sels ;
   private GXSimpleCollection<java.util.Date> AV67TFLiqFecPago_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV24ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV22ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV86DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState45[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
}

final  class liquidacion_export3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00J82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV29TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV32TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV35TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV38TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV145TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV46TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV156TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV48TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV158TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV54TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV57TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV61TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV64TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV67TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV71TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV74TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV76TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV130TFLiqDLogRecal_Sels ,
                                          int AV29TFLegId_Sels_size ,
                                          String AV28TFLegId ,
                                          int AV32TFLegNomApe_Sels_size ,
                                          String AV31TFLegNomApe ,
                                          int AV35TFLiqNombre_Sels_size ,
                                          String AV34TFLiqNombre ,
                                          int AV38TFSecDescrip_Sels_size ,
                                          int AV145TFLegOsoDes_Sels_size ,
                                          int AV46TFLegCuentaBanc_Sels_size ,
                                          int AV156TFLegModTra_Sels_size ,
                                          int AV48TFLegClase_Sels_size ,
                                          int AV158TFLegTipoTarifa_Sels_size ,
                                          int AV54TFLiqDescrip_Sels_size ,
                                          int AV57TFLiqFecha_Sels_size ,
                                          int AV61TFLiqPerSinDia_Sels_size ,
                                          String AV60TFLiqPerSinDia ,
                                          int AV64TFTliqDesc_Sels_size ,
                                          int AV67TFLiqFecPago_Sels_size ,
                                          int AV71TFDConCodigo_Sels_size ,
                                          String AV70TFDConCodigo ,
                                          int AV74TFDConDescrip_Sels_size ,
                                          String AV73TFDConDescrip ,
                                          int AV76TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV80TFLiqDCanti ,
                                          java.math.BigDecimal AV81TFLiqDCanti_To ,
                                          java.math.BigDecimal AV84TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV85TFLiqDImpCalcu_To ,
                                          int AV130TFLiqDLogRecal_Sels_size ,
                                          String AV129TFLiqDLogRecal ,
                                          java.math.BigDecimal AV82TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV83TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV98CliCod ,
                                          short AV99EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int46 = new byte[18];
      Object[] GXv_Object47 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T2.LegOsoCod AS LegOsoCod, T2.LegBanCod AS LegBanCod, T1.LegNumero, T1.LiqDImpReCalcu, T1.LiqDErrorDesc, T1.LiqDSecuencial, T1.LiqDLogRecal, T1.LiqDFormulaHTML," ;
      sSelectString += " T1.LiqDReFormulaHTML, T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T9.LiqFecPago, T10.TliqDesc, T9.TLiqCod, T9.LiqPerSinDia, T9.LiqFecha," ;
      sSelectString += " T9.LiqDescrip, T1.LiqNro, T2.LegSCVO, T2.LegFecNac, T2.LegSexo, T2.LegCodPos, T2.LegTipoTarifa, T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T2.LegBanSuc, T2.LegBanTipCuen," ;
      sSelectString += " T8.BanDescrip AS LegBanDes, T2.LegCBU, T5.MegDescrip, T2.LegMegCodigo AS LegMegCodigo, T2.LegFecEgreso, T2.LegFecIngreso, T2.LegSinCod, T6.OsoC3992 AS LegOsoAfipCod," ;
      sSelectString += " T6.OsoDescrip AS LegOsoDes, T3.ActDescrip AS LegActDescri, T2.LegActCodigo AS LegActCodigo, T2.LegFormaPago, T4.ZonDescrip, T2.ZonCod, T7.SecDescrip, T2.LegSecCodigo" ;
      sSelectString += " AS LegSecCodigo, T2.LegCatCodigo, T2.LegConveCodigo, T9.LiqNombre, T2.LegCUIL, T2.LegNomApe, T1.EmpCod, T1.CliCod, T2.LegId" ;
      sFromString = " FROM (((((((((LiquidacionDetalle T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN Actividad" ;
      sFromString += " T3 ON T3.ActCodigo = T2.LegActCodigo) LEFT JOIN Zona T4 ON T4.ZonCod = T2.ZonCod) LEFT JOIN MotivoEgreso T5 ON T5.CliCod = T1.CliCod AND T5.MegCodigo = T2.LegMegCodigo)" ;
      sFromString += " LEFT JOIN ObraSocial T6 ON T6.CliCod = T1.CliCod AND T6.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T7 ON T7.CliCod = T1.CliCod AND T7.SecCodigo = T2.LegSecCodigo)" ;
      sFromString += " LEFT JOIN Banco T8 ON T8.CliCod = T1.CliCod AND T8.BanCod = T2.LegBanCod) INNER JOIN Liquidacion T9 ON T9.CliCod = T1.CliCod AND T9.EmpCod = T1.EmpCod AND T9.LiqNro" ;
      sFromString += " = T1.LiqNro) LEFT JOIN TipoLiquidacion T10 ON T10.CliCod = T1.CliCod AND T10.TLiqCod = T9.TLiqCod)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV29TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV28TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int46[2] = (byte)(1) ;
      }
      if ( AV29TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV32TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int46[3] = (byte)(1) ;
      }
      if ( AV32TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV35TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV34TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T9.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int46[4] = (byte)(1) ;
      }
      if ( AV35TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV35TFLiqNombre_Sels, "T9.LiqNombre IN (", ")")+")");
      }
      if ( AV38TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFSecDescrip_Sels, "T7.SecDescrip IN (", ")")+")");
      }
      if ( AV145TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV145TFLegOsoDes_Sels, "T6.OsoDescrip IN (", ")")+")");
      }
      if ( AV46TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV156TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV156TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV48TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV158TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV158TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV54TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54TFLiqDescrip_Sels, "T9.LiqDescrip IN (", ")")+")");
      }
      if ( AV57TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57TFLiqFecha_Sels, "T9.LiqFecha IN (", ")")+")");
      }
      if ( ( AV61TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T9.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int46[5] = (byte)(1) ;
      }
      if ( AV61TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61TFLiqPerSinDia_Sels, "T9.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV64TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64TFTliqDesc_Sels, "T10.TliqDesc IN (", ")")+")");
      }
      if ( AV67TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFLiqFecPago_Sels, "T9.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV71TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int46[6] = (byte)(1) ;
      }
      if ( AV71TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV74TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int46[7] = (byte)(1) ;
      }
      if ( AV74TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV76TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int46[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int46[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int46[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int46[11] = (byte)(1) ;
      }
      if ( ( AV130TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV129TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int46[12] = (byte)(1) ;
      }
      if ( AV130TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int46[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int46[14] = (byte)(1) ;
      }
      if ( AV14OrderedBy == 1 )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.DConCodigo, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.DConDescrip, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T1.DConDescrip DESC, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T2.LegNomApe, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T2.LegNomApe DESC, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T2.LegId, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.CliCod DESC, T1.EmpCod DESC, T2.LegId DESC, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T2.LegModTra, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.LegModTra DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T2.LegTipoTarifa, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.LegTipoTarifa DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T9.LiqPerSinDia, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T9.LiqPerSinDia DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqDLogRecal, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqDLogRecal DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LiqDImpReCalcu, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LiqDImpReCalcu DESC, T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.LiqDSecuencial" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object47[0] = scmdbuf ;
      GXv_Object47[1] = GXv_int46 ;
      return GXv_Object47 ;
   }

   protected Object[] conditional_H00J83( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV29TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV32TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV35TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV38TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV145TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV46TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV156TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV48TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV158TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV54TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV57TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV61TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV64TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV67TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV71TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV74TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV76TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV130TFLiqDLogRecal_Sels ,
                                          int AV29TFLegId_Sels_size ,
                                          String AV28TFLegId ,
                                          int AV32TFLegNomApe_Sels_size ,
                                          String AV31TFLegNomApe ,
                                          int AV35TFLiqNombre_Sels_size ,
                                          String AV34TFLiqNombre ,
                                          int AV38TFSecDescrip_Sels_size ,
                                          int AV145TFLegOsoDes_Sels_size ,
                                          int AV46TFLegCuentaBanc_Sels_size ,
                                          int AV156TFLegModTra_Sels_size ,
                                          int AV48TFLegClase_Sels_size ,
                                          int AV158TFLegTipoTarifa_Sels_size ,
                                          int AV54TFLiqDescrip_Sels_size ,
                                          int AV57TFLiqFecha_Sels_size ,
                                          int AV61TFLiqPerSinDia_Sels_size ,
                                          String AV60TFLiqPerSinDia ,
                                          int AV64TFTliqDesc_Sels_size ,
                                          int AV67TFLiqFecPago_Sels_size ,
                                          int AV71TFDConCodigo_Sels_size ,
                                          String AV70TFDConCodigo ,
                                          int AV74TFDConDescrip_Sels_size ,
                                          String AV73TFDConDescrip ,
                                          int AV76TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV80TFLiqDCanti ,
                                          java.math.BigDecimal AV81TFLiqDCanti_To ,
                                          java.math.BigDecimal AV84TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV85TFLiqDImpCalcu_To ,
                                          int AV130TFLiqDLogRecal_Sels_size ,
                                          String AV129TFLiqDLogRecal ,
                                          java.math.BigDecimal AV82TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV83TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV98CliCod ,
                                          short AV99EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int49 = new byte[15];
      Object[] GXv_Object50 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (((((((((LiquidacionDetalle T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT" ;
      scmdbuf += " JOIN Actividad T3 ON T3.ActCodigo = T2.LegActCodigo) LEFT JOIN Zona T4 ON T4.ZonCod = T2.ZonCod) LEFT JOIN MotivoEgreso T5 ON T5.CliCod = T1.CliCod AND T5.MegCodigo" ;
      scmdbuf += " = T2.LegMegCodigo) LEFT JOIN ObraSocial T6 ON T6.CliCod = T1.CliCod AND T6.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T7 ON T7.CliCod = T1.CliCod AND T7.SecCodigo" ;
      scmdbuf += " = T2.LegSecCodigo) LEFT JOIN Banco T8 ON T8.CliCod = T1.CliCod AND T8.BanCod = T2.LegBanCod) INNER JOIN Liquidacion T9 ON T9.CliCod = T1.CliCod AND T9.EmpCod =" ;
      scmdbuf += " T1.EmpCod AND T9.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T10 ON T10.CliCod = T1.CliCod AND T10.TLiqCod = T9.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV29TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV28TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int49[2] = (byte)(1) ;
      }
      if ( AV29TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV29TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV32TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV31TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int49[3] = (byte)(1) ;
      }
      if ( AV32TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV35TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV34TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T9.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int49[4] = (byte)(1) ;
      }
      if ( AV35TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV35TFLiqNombre_Sels, "T9.LiqNombre IN (", ")")+")");
      }
      if ( AV38TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFSecDescrip_Sels, "T7.SecDescrip IN (", ")")+")");
      }
      if ( AV145TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV145TFLegOsoDes_Sels, "T6.OsoDescrip IN (", ")")+")");
      }
      if ( AV46TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV156TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV156TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV48TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV158TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV158TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV54TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54TFLiqDescrip_Sels, "T9.LiqDescrip IN (", ")")+")");
      }
      if ( AV57TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57TFLiqFecha_Sels, "T9.LiqFecha IN (", ")")+")");
      }
      if ( ( AV61TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T9.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int49[5] = (byte)(1) ;
      }
      if ( AV61TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61TFLiqPerSinDia_Sels, "T9.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV64TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64TFTliqDesc_Sels, "T10.TliqDesc IN (", ")")+")");
      }
      if ( AV67TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV67TFLiqFecPago_Sels, "T9.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV71TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int49[6] = (byte)(1) ;
      }
      if ( AV71TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV74TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int49[7] = (byte)(1) ;
      }
      if ( AV74TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV76TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int49[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int49[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int49[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV85TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int49[11] = (byte)(1) ;
      }
      if ( ( AV130TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV129TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int49[12] = (byte)(1) ;
      }
      if ( AV130TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int49[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int49[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV14OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 9 ) && ( AV15OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object50[0] = scmdbuf ;
      GXv_Object50[1] = GXv_int49 ;
      return GXv_Object50 ;
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
                  return conditional_H00J82(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).shortValue() , ((Boolean) dynConstraints[71]).booleanValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).shortValue() );
            case 1 :
                  return conditional_H00J83(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).shortValue() , ((Boolean) dynConstraints[71]).booleanValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() , ((Number) dynConstraints[74]).intValue() , ((Number) dynConstraints[75]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00J82", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00J83", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(2, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(12, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[21])[0] = rslt.getGXDate(15);
               ((String[]) buf[22])[0] = rslt.getVarchar(16);
               ((String[]) buf[23])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 20);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(19);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((int[]) buf[28])[0] = rslt.getInt(21);
               ((boolean[]) buf[29])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[30])[0] = rslt.getGXDate(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getString(25, 20);
               ((String[]) buf[34])[0] = rslt.getString(26, 1);
               ((byte[]) buf[35])[0] = rslt.getByte(27);
               ((String[]) buf[36])[0] = rslt.getString(28, 1);
               ((String[]) buf[37])[0] = rslt.getVarchar(29);
               ((boolean[]) buf[38])[0] = rslt.wasNull();
               ((String[]) buf[39])[0] = rslt.getVarchar(30);
               ((boolean[]) buf[40])[0] = rslt.wasNull();
               ((String[]) buf[41])[0] = rslt.getString(31, 20);
               ((boolean[]) buf[42])[0] = rslt.wasNull();
               ((String[]) buf[43])[0] = rslt.getVarchar(32);
               ((String[]) buf[44])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getVarchar(34);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((String[]) buf[48])[0] = rslt.getString(35, 20);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[50])[0] = rslt.getGXDate(36);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(37);
               ((String[]) buf[53])[0] = rslt.getString(38, 20);
               ((boolean[]) buf[54])[0] = rslt.wasNull();
               ((String[]) buf[55])[0] = rslt.getString(39, 20);
               ((boolean[]) buf[56])[0] = rslt.wasNull();
               ((String[]) buf[57])[0] = rslt.getVarchar(40);
               ((String[]) buf[58])[0] = rslt.getVarchar(41);
               ((String[]) buf[59])[0] = rslt.getString(42, 8);
               ((boolean[]) buf[60])[0] = rslt.wasNull();
               ((byte[]) buf[61])[0] = rslt.getByte(43);
               ((String[]) buf[62])[0] = rslt.getVarchar(44);
               ((String[]) buf[63])[0] = rslt.getString(45, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((String[]) buf[65])[0] = rslt.getVarchar(46);
               ((boolean[]) buf[66])[0] = rslt.wasNull();
               ((String[]) buf[67])[0] = rslt.getString(47, 20);
               ((boolean[]) buf[68])[0] = rslt.wasNull();
               ((String[]) buf[69])[0] = rslt.getString(48, 40);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               ((String[]) buf[71])[0] = rslt.getString(49, 20);
               ((boolean[]) buf[72])[0] = rslt.wasNull();
               ((String[]) buf[73])[0] = rslt.getVarchar(50);
               ((long[]) buf[74])[0] = rslt.getLong(51);
               ((String[]) buf[75])[0] = rslt.getVarchar(52);
               ((short[]) buf[76])[0] = rslt.getShort(53);
               ((int[]) buf[77])[0] = rslt.getInt(54);
               ((String[]) buf[78])[0] = rslt.getString(55, 20);
               ((boolean[]) buf[79])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[24], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[33]).intValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[34]).intValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[35]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
      }
   }

}

