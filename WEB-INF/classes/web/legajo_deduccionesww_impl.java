package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajo_deduccionesww_impl extends GXDataArea
{
   public legajo_deduccionesww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajo_deduccionesww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_deduccionesww_impl.class ));
   }

   public legajo_deduccionesww_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbLegDedMes = new HTMLChoice();
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
            AV90MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90MenuOpcCod", AV90MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
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
      nRC_GXsfl_111 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_111"))) ;
      nGXsfl_111_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_111_idx"))) ;
      sGXsfl_111_idx = httpContext.GetPar( "sGXsfl_111_idx") ;
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
      AV85ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV6ColumnsSelector);
      AV113Pgmname = httpContext.GetPar( "Pgmname") ;
      AV90MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV22GridState);
      AV59TFLegIdNomApe = httpContext.GetPar( "TFLegIdNomApe") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60TFLegIdNomApe_Sels);
      AV77TFLegDedAnio = (short)(GXutil.lval( httpContext.GetPar( "TFLegDedAnio"))) ;
      AV78TFLegDedAnio_To = (short)(GXutil.lval( httpContext.GetPar( "TFLegDedAnio_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV80TFLegDedMes_Sels);
      AV74TFLegDedConCodYDesc = httpContext.GetPar( "TFLegDedConCodYDesc") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV75TFLegDedConCodYDesc_Sels);
      AV48TFLegDedDescrip = httpContext.GetPar( "TFLegDedDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV49TFLegDedDescrip_Sels);
      AV55TFLegDedImporte = CommonUtil.decimalVal( httpContext.GetPar( "TFLegDedImporte"), ".") ;
      AV56TFLegDedImporte_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLegDedImporte_To"), ".") ;
      AV31OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV33OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV5CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV81TotLegDedImporte = CommonUtil.decimalVal( httpContext.GetPar( "TotLegDedImporte"), ".") ;
      AV29IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV26IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      AV69datetime = localUtil.parseDTimeParm( httpContext.GetPar( "datetime")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV85ManageFiltersExecutionStep, AV6ColumnsSelector, AV113Pgmname, AV90MenuOpcCod, AV22GridState, AV59TFLegIdNomApe, AV60TFLegIdNomApe_Sels, AV77TFLegDedAnio, AV78TFLegDedAnio_To, AV80TFLegDedMes_Sels, AV74TFLegDedConCodYDesc, AV75TFLegDedConCodYDesc_Sels, AV48TFLegDedDescrip, AV49TFLegDedDescrip_Sels, AV55TFLegDedImporte, AV56TFLegDedImporte_To, AV31OrderedBy, AV33OrderedDsc, AV5CliCod, AV18EmpCod, AV81TotLegDedImporte, AV29IsAuthorized_Update, AV26IsAuthorized_Delete, AV92WelcomeMessage_NoMostrarMas, AV69datetime) ;
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
      pa2P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2P2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.legajo_deduccionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV90MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLEGDEDIMPORTE", getSecureSignedToken( "", localUtil.format( AV81TotLegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV29IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV26IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATETIME", getSecureSignedToken( "", localUtil.format( AV69datetime, "99/99/99 99:99")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_111", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_111, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV6ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV6ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV83ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV83ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV20GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV21GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV19GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV85ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV113Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV90MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV22GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV22GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGIDNOMAPE", AV59TFLegIdNomApe);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGIDNOMAPE_SELS", AV60TFLegIdNomApe_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGIDNOMAPE_SELS", AV60TFLegIdNomApe_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDANIO", GXutil.ltrim( localUtil.ntoc( AV77TFLegDedAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDANIO_TO", GXutil.ltrim( localUtil.ntoc( AV78TFLegDedAnio_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGDEDMES_SELS", AV80TFLegDedMes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGDEDMES_SELS", AV80TFLegDedMes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDCONCODYDESC", AV74TFLegDedConCodYDesc);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGDEDCONCODYDESC_SELS", AV75TFLegDedConCodYDesc_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGDEDCONCODYDESC_SELS", AV75TFLegDedConCodYDesc_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDDESCRIP", AV48TFLegDedDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFLEGDEDDESCRIP_SELS", AV49TFLegDedDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFLEGDEDDESCRIP_SELS", AV49TFLegDedDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDIMPORTE", GXutil.ltrim( localUtil.ntoc( AV55TFLegDedImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDIMPORTE_TO", GXutil.ltrim( localUtil.ntoc( AV56TFLegDedImporte_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV31OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV33OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLEGDEDIMPORTE", GXutil.ltrim( localUtil.ntoc( AV81TotLegDedImporte, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLEGDEDIMPORTE", getSecureSignedToken( "", localUtil.format( AV81TotLegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV29IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV29IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV26IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV26IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGIDNOMAPE_SELSJSON", AV61TFLegIdNomApe_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDMES_SELSJSON", AV79TFLegDedMes_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDCONCODYDESC_SELSJSON", AV73TFLegDedConCodYDesc_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLEGDEDDESCRIP_SELSJSON", AV50TFLegDedDescrip_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vDATETIME", localUtil.ttoc( AV69datetime, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATETIME", getSecureSignedToken( "", localUtil.format( AV69datetime, "99/99/99 99:99")));
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
         we2P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2P2( ) ;
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
      return formatLink("web.legajo_deduccionesww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV90MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "legajo_deduccionesWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Siradig", "") ;
   }

   public void wb2P0( )
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
         wb_table1_9_2P2( true) ;
      }
      else
      {
         wb_table1_9_2P2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_2P2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
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
      if ( wbEnd == 111 )
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

   public void start2P2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Siradig", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2P0( ) ;
   }

   public void ws2P2( )
   {
      start2P2( ) ;
      evt2P2( ) ;
   }

   public void evt2P2( )
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
                           e112P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e162P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e172P2 ();
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
                           nGXsfl_111_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_111_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_111_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1112( ) ;
                           AV66Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV66Update);
                           AV16Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV16Delete);
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A83LegDedSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLegDedSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A250LegIdNomApe = httpContext.cgiGet( edtLegIdNomApe_Internalname) ;
                           A556LegDedFchDes = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegDedFchDes_Internalname), 0)) ;
                           A557LegDedFchHas = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtLegDedFchHas_Internalname), 0)) ;
                           A768LegDedAnio = (short)(localUtil.ctol( httpContext.cgiGet( edtLegDedAnio_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbLegDedMes.setName( cmbLegDedMes.getInternalname() );
                           cmbLegDedMes.setValue( httpContext.cgiGet( cmbLegDedMes.getInternalname()) );
                           A767LegDedMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbLegDedMes.getInternalname()))) ;
                           A84LegDedConCodigo = httpContext.cgiGet( edtLegDedConCodigo_Internalname) ;
                           A570LegDedConCodYDesc = httpContext.cgiGet( edtLegDedConCodYDesc_Internalname) ;
                           A568LegDedDescrip = httpContext.cgiGet( edtLegDedDescrip_Internalname) ;
                           A560LegDedImporte = localUtil.ctond( httpContext.cgiGet( edtLegDedImporte_Internalname)) ;
                           AV86VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV86VerSVG);
                           AV87ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV87ModificarSVG);
                           AV88EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV88EliminarSVG);
                           AV89Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV89Display);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e182P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e192P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e202P2 ();
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

   public void we2P2( )
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

   public void pa2P2( )
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
      subsflControlProps_1112( ) ;
      while ( nGXsfl_111_idx <= nRC_GXsfl_111 )
      {
         sendrow_1112( ) ;
         nGXsfl_111_idx = ((subGrid_Islastpage==1)&&(nGXsfl_111_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_111_idx+1) ;
         sGXsfl_111_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_111_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1112( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV85ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV6ColumnsSelector ,
                                 String AV113Pgmname ,
                                 String AV90MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV22GridState ,
                                 String AV59TFLegIdNomApe ,
                                 GXSimpleCollection<String> AV60TFLegIdNomApe_Sels ,
                                 short AV77TFLegDedAnio ,
                                 short AV78TFLegDedAnio_To ,
                                 GXSimpleCollection<Byte> AV80TFLegDedMes_Sels ,
                                 String AV74TFLegDedConCodYDesc ,
                                 GXSimpleCollection<String> AV75TFLegDedConCodYDesc_Sels ,
                                 String AV48TFLegDedDescrip ,
                                 GXSimpleCollection<String> AV49TFLegDedDescrip_Sels ,
                                 java.math.BigDecimal AV55TFLegDedImporte ,
                                 java.math.BigDecimal AV56TFLegDedImporte_To ,
                                 short AV31OrderedBy ,
                                 boolean AV33OrderedDsc ,
                                 int AV5CliCod ,
                                 short AV18EmpCod ,
                                 java.math.BigDecimal AV81TotLegDedImporte ,
                                 boolean AV29IsAuthorized_Update ,
                                 boolean AV26IsAuthorized_Delete ,
                                 boolean AV92WelcomeMessage_NoMostrarMas ,
                                 java.util.Date AV69datetime )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e192P2 ();
      GRID_nCurrentRecord = 0 ;
      rf2P2( ) ;
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
      rf2P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV113Pgmname = "legajo_deduccionesWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavTotvaluelegdedimporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotvaluelegdedimporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvaluelegdedimporte_Enabled), 5, 0), true);
   }

   public void rf2P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(111) ;
      /* Execute user event: Refresh */
      e192P2 ();
      nGXsfl_111_idx = 1 ;
      sGXsfl_111_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_111_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1112( ) ;
      bGXsfl_111_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithTotalizer GridWithPaginationBar WorkWith");
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
         subsflControlProps_1112( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A570LegDedConCodYDesc ,
                                              AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                              A250LegIdNomApe ,
                                              AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                              Byte.valueOf(A767LegDedMes) ,
                                              AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                              A568LegDedDescrip ,
                                              AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                              Integer.valueOf(AV115Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                              AV114Legajo_deduccioneswwds_1_tflegidnomape ,
                                              Short.valueOf(AV116Legajo_deduccioneswwds_3_tflegdedanio) ,
                                              Short.valueOf(AV117Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                              Integer.valueOf(AV118Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                              Integer.valueOf(AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                              AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                              Integer.valueOf(AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                              AV121Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                              AV123Legajo_deduccioneswwds_10_tflegdedimporte ,
                                              AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                              Short.valueOf(A768LegDedAnio) ,
                                              A84LegDedConCodigo ,
                                              A559LegDedConDescrip ,
                                              A560LegDedImporte ,
                                              Short.valueOf(AV31OrderedBy) ,
                                              Boolean.valueOf(AV33OrderedDsc) ,
                                              Integer.valueOf(AV5CliCod) ,
                                              Short.valueOf(AV18EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV114Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV114Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
         lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
         lV121Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV121Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
         /* Using cursor H002P2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), lV114Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV116Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV117Legajo_deduccioneswwds_4_tflegdedanio_to), lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV121Legajo_deduccioneswwds_8_tflegdeddescrip, AV123Legajo_deduccioneswwds_10_tflegdedimporte, AV124Legajo_deduccioneswwds_11_tflegdedimporte_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_111_idx = 1 ;
         sGXsfl_111_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_111_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1112( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A560LegDedImporte = H002P2_A560LegDedImporte[0] ;
            A568LegDedDescrip = H002P2_A568LegDedDescrip[0] ;
            A570LegDedConCodYDesc = H002P2_A570LegDedConCodYDesc[0] ;
            A767LegDedMes = H002P2_A767LegDedMes[0] ;
            A768LegDedAnio = H002P2_A768LegDedAnio[0] ;
            A557LegDedFchHas = H002P2_A557LegDedFchHas[0] ;
            A556LegDedFchDes = H002P2_A556LegDedFchDes[0] ;
            A250LegIdNomApe = H002P2_A250LegIdNomApe[0] ;
            A83LegDedSec = H002P2_A83LegDedSec[0] ;
            A6LegNumero = H002P2_A6LegNumero[0] ;
            A1EmpCod = H002P2_A1EmpCod[0] ;
            A3CliCod = H002P2_A3CliCod[0] ;
            A84LegDedConCodigo = H002P2_A84LegDedConCodigo[0] ;
            A559LegDedConDescrip = H002P2_A559LegDedConDescrip[0] ;
            A250LegIdNomApe = H002P2_A250LegIdNomApe[0] ;
            A559LegDedConDescrip = H002P2_A559LegDedConDescrip[0] ;
            e202P2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(111) ;
         wb2P0( ) ;
      }
      bGXsfl_111_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2P2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV113Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV113Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV90MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV5CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTOTLEGDEDIMPORTE", GXutil.ltrim( localUtil.ntoc( AV81TotLegDedImporte, (byte)(18), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLEGDEDIMPORTE", getSecureSignedToken( "", localUtil.format( AV81TotLegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV29IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV29IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV26IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV26IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATETIME", localUtil.ttoc( AV69datetime, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATETIME", getSecureSignedToken( "", localUtil.format( AV69datetime, "99/99/99 99:99")));
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
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                           A250LegIdNomApe ,
                                           AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                           A568LegDedDescrip ,
                                           AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                           Integer.valueOf(AV115Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                           AV114Legajo_deduccioneswwds_1_tflegidnomape ,
                                           Short.valueOf(AV116Legajo_deduccioneswwds_3_tflegdedanio) ,
                                           Short.valueOf(AV117Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                           Integer.valueOf(AV118Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                           Integer.valueOf(AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                           AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                           Integer.valueOf(AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                           AV121Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                           AV123Legajo_deduccioneswwds_10_tflegdedimporte ,
                                           AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Short.valueOf(AV31OrderedBy) ,
                                           Boolean.valueOf(AV33OrderedDsc) ,
                                           Integer.valueOf(AV5CliCod) ,
                                           Short.valueOf(AV18EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV114Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV114Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
      lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
      lV121Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV121Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
      /* Using cursor H002P3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), lV114Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV116Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV117Legajo_deduccioneswwds_4_tflegdedanio_to), lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV121Legajo_deduccioneswwds_8_tflegdeddescrip, AV123Legajo_deduccioneswwds_10_tflegdedimporte, AV124Legajo_deduccioneswwds_11_tflegdedimporte_to});
      GRID_nRecordCount = H002P3_AGRID_nRecordCount[0] ;
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
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV85ManageFiltersExecutionStep, AV6ColumnsSelector, AV113Pgmname, AV90MenuOpcCod, AV22GridState, AV59TFLegIdNomApe, AV60TFLegIdNomApe_Sels, AV77TFLegDedAnio, AV78TFLegDedAnio_To, AV80TFLegDedMes_Sels, AV74TFLegDedConCodYDesc, AV75TFLegDedConCodYDesc_Sels, AV48TFLegDedDescrip, AV49TFLegDedDescrip_Sels, AV55TFLegDedImporte, AV56TFLegDedImporte_To, AV31OrderedBy, AV33OrderedDsc, AV5CliCod, AV18EmpCod, AV81TotLegDedImporte, AV29IsAuthorized_Update, AV26IsAuthorized_Delete, AV92WelcomeMessage_NoMostrarMas, AV69datetime) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV85ManageFiltersExecutionStep, AV6ColumnsSelector, AV113Pgmname, AV90MenuOpcCod, AV22GridState, AV59TFLegIdNomApe, AV60TFLegIdNomApe_Sels, AV77TFLegDedAnio, AV78TFLegDedAnio_To, AV80TFLegDedMes_Sels, AV74TFLegDedConCodYDesc, AV75TFLegDedConCodYDesc_Sels, AV48TFLegDedDescrip, AV49TFLegDedDescrip_Sels, AV55TFLegDedImporte, AV56TFLegDedImporte_To, AV31OrderedBy, AV33OrderedDsc, AV5CliCod, AV18EmpCod, AV81TotLegDedImporte, AV29IsAuthorized_Update, AV26IsAuthorized_Delete, AV92WelcomeMessage_NoMostrarMas, AV69datetime) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV85ManageFiltersExecutionStep, AV6ColumnsSelector, AV113Pgmname, AV90MenuOpcCod, AV22GridState, AV59TFLegIdNomApe, AV60TFLegIdNomApe_Sels, AV77TFLegDedAnio, AV78TFLegDedAnio_To, AV80TFLegDedMes_Sels, AV74TFLegDedConCodYDesc, AV75TFLegDedConCodYDesc_Sels, AV48TFLegDedDescrip, AV49TFLegDedDescrip_Sels, AV55TFLegDedImporte, AV56TFLegDedImporte_To, AV31OrderedBy, AV33OrderedDsc, AV5CliCod, AV18EmpCod, AV81TotLegDedImporte, AV29IsAuthorized_Update, AV26IsAuthorized_Delete, AV92WelcomeMessage_NoMostrarMas, AV69datetime) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV85ManageFiltersExecutionStep, AV6ColumnsSelector, AV113Pgmname, AV90MenuOpcCod, AV22GridState, AV59TFLegIdNomApe, AV60TFLegIdNomApe_Sels, AV77TFLegDedAnio, AV78TFLegDedAnio_To, AV80TFLegDedMes_Sels, AV74TFLegDedConCodYDesc, AV75TFLegDedConCodYDesc_Sels, AV48TFLegDedDescrip, AV49TFLegDedDescrip_Sels, AV55TFLegDedImporte, AV56TFLegDedImporte_To, AV31OrderedBy, AV33OrderedDsc, AV5CliCod, AV18EmpCod, AV81TotLegDedImporte, AV29IsAuthorized_Update, AV26IsAuthorized_Delete, AV92WelcomeMessage_NoMostrarMas, AV69datetime) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
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
         gxgrgrid_refresh( subGrid_Rows, AV85ManageFiltersExecutionStep, AV6ColumnsSelector, AV113Pgmname, AV90MenuOpcCod, AV22GridState, AV59TFLegIdNomApe, AV60TFLegIdNomApe_Sels, AV77TFLegDedAnio, AV78TFLegDedAnio_To, AV80TFLegDedMes_Sels, AV74TFLegDedConCodYDesc, AV75TFLegDedConCodYDesc_Sels, AV48TFLegDedDescrip, AV49TFLegDedDescrip_Sels, AV55TFLegDedImporte, AV56TFLegDedImporte_To, AV31OrderedBy, AV33OrderedDsc, AV5CliCod, AV18EmpCod, AV81TotLegDedImporte, AV29IsAuthorized_Update, AV26IsAuthorized_Delete, AV92WelcomeMessage_NoMostrarMas, AV69datetime) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV113Pgmname = "legajo_deduccionesWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_111_Refreshing);
      edtavTotvaluelegdedimporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTotvaluelegdedimporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvaluelegdedimporte_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup2P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e182P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV6ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV83ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_111 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_111"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV20GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV21GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV19GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV18EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV5CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV69datetime = localUtil.ctot( httpContext.cgiGet( "vDATETIME"), 0) ;
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
         AV98WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV92WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV92WelcomeMessage_NoMostrarMas", AV92WelcomeMessage_NoMostrarMas);
         AV82TotValueLegDedImporte = httpContext.cgiGet( edtavTotvaluelegdedimporte_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV82TotValueLegDedImporte", AV82TotValueLegDedImporte);
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
      e182P2 ();
      if (returnInSub) return;
   }

   public void e182P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV90MenuOpcCod, "", "") ;
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      legajo_deduccionesww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV24HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( "Siradig", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV31OrderedBy < 1 )
      {
         AV31OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char5[0] = AV93MenuBienveImgURL ;
      GXv_char6[0] = AV95MenuBienveTitulo ;
      GXv_char7[0] = AV96MenuBienveTexto ;
      GXv_boolean8[0] = AV97MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV90MenuOpcCod, GXv_char5, GXv_char6, GXv_char7, GXv_boolean8) ;
      legajo_deduccionesww_impl.this.AV93MenuBienveImgURL = GXv_char5[0] ;
      legajo_deduccionesww_impl.this.AV95MenuBienveTitulo = GXv_char6[0] ;
      legajo_deduccionesww_impl.this.AV96MenuBienveTexto = GXv_char7[0] ;
      legajo_deduccionesww_impl.this.AV97MenuBienveVisible = GXv_boolean8[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV97MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV97MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV95MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV96MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV98WelcomeMessage_Foto = AV93MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0) ? AV112Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV98WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV98WelcomeMessage_Foto), true);
         AV112Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV93MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0) ? AV112Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV98WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV98WelcomeMessage_Foto), true);
      }
      GXt_char9 = "" ;
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXv_char6[0] = GXt_char9 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char6) ;
      legajo_deduccionesww_impl.this.GXt_char9 = GXv_char6[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char9 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV106observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV106observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV106observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV106observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      AV70mensaje = AV71websession.getValue(httpContext.getMessage( "SubirArchivoSiradig", "")) ;
      if ( ! (GXutil.strcmp("", AV70mensaje)==0) )
      {
         if ( GXutil.strSearch( AV70mensaje, httpContext.getMessage( "No", ""), 1) != 0 )
         {
            AV72DVMessageType = "info" ;
         }
         else
         {
            AV72DVMessageType = "success" ;
         }
         new web.alert(remoteHandle, context).execute( AV72DVMessageType, AV70mensaje) ;
         AV71websession.remove(httpContext.getMessage( "SubirArchivoSiradig", ""));
      }
   }

   public void e192P2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int11 = AV18EmpCod ;
      GXv_int12[0] = GXt_int11 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int12) ;
      legajo_deduccionesww_impl.this.GXt_int11 = GXv_int12[0] ;
      AV18EmpCod = GXt_int11 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      GXt_int1 = AV5CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      legajo_deduccionesww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV5CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV68WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV68WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV85ManageFiltersExecutionStep == 1 )
      {
         AV85ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85ManageFiltersExecutionStep", GXutil.str( AV85ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV85ManageFiltersExecutionStep == 2 )
      {
         AV85ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85ManageFiltersExecutionStep", GXutil.str( AV85ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV36Session.getValue("legajo_deduccionesWWColumnsSelector"), "") != 0 )
      {
         AV8ColumnsSelectorXML = AV36Session.getValue("legajo_deduccionesWWColumnsSelector") ;
         AV6ColumnsSelector.fromxml(AV8ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtLegIdNomApe_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegIdNomApe_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegIdNomApe_Visible), 5, 0), !bGXsfl_111_Refreshing);
      edtLegDedAnio_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedAnio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedAnio_Visible), 5, 0), !bGXsfl_111_Refreshing);
      cmbLegDedMes.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLegDedMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbLegDedMes.getVisible(), 5, 0), !bGXsfl_111_Refreshing);
      edtLegDedConCodYDesc_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedConCodYDesc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedConCodYDesc_Visible), 5, 0), !bGXsfl_111_Refreshing);
      edtLegDedDescrip_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedDescrip_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedDescrip_Visible), 5, 0), !bGXsfl_111_Refreshing);
      edtLegDedImporte_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegDedImporte_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegDedImporte_Visible), 5, 0), !bGXsfl_111_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_111_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_111_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV6ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_111_Refreshing);
      /* Execute user subroutine: 'INITIALIZETOTALIZERS' */
      S182 ();
      if (returnInSub) return;
      AV20GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GridCurrentPage), 10, 0));
      AV21GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21GridPageCount), 10, 0));
      GXt_char10 = AV19GridAppliedFilters ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV113Pgmname, GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV19GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19GridAppliedFilters", AV19GridAppliedFilters);
      /* Execute user subroutine: 'CALCULATETOTALIZERS' */
      S192 ();
      if (returnInSub) return;
      GXt_char10 = AV105MenuOpcTitulo ;
      GXv_char7[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV90MenuOpcCod, GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV105MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV105MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV105MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV108filterCount) ;
      GXv_char7[0] = AV109filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV22GridState, GXv_int12, GXv_char7) ;
      legajo_deduccionesww_impl.this.AV108filterCount = GXv_int12[0] ;
      legajo_deduccionesww_impl.this.AV109filtrosTexto = GXv_char7[0] ;
      if ( AV108filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV108filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV109filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6ColumnsSelector", AV6ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83ManageFiltersData", AV83ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22GridState", AV22GridState);
   }

   public void e132P2( )
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
         AV34PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV34PageToGo) ;
      }
   }

   public void e142P2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e152P2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV31OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
         AV33OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33OrderedDsc", AV33OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegIdNomApe") == 0 )
         {
            AV59TFLegIdNomApe = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFLegIdNomApe", AV59TFLegIdNomApe);
            AV61TFLegIdNomApe_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFLegIdNomApe_SelsJson", AV61TFLegIdNomApe_SelsJson);
            AV60TFLegIdNomApe_Sels.fromJSonString(AV61TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedAnio") == 0 )
         {
            AV77TFLegDedAnio = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFLegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFLegDedAnio), 4, 0));
            AV78TFLegDedAnio_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFLegDedAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFLegDedAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedMes") == 0 )
         {
            AV79TFLegDedMes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFLegDedMes_SelsJson", AV79TFLegDedMes_SelsJson);
            AV80TFLegDedMes_Sels.fromJSonString(GXutil.strReplace( AV79TFLegDedMes_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedConCodYDesc") == 0 )
         {
            AV74TFLegDedConCodYDesc = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFLegDedConCodYDesc", AV74TFLegDedConCodYDesc);
            AV73TFLegDedConCodYDesc_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFLegDedConCodYDesc_SelsJson", AV73TFLegDedConCodYDesc_SelsJson);
            AV75TFLegDedConCodYDesc_Sels.fromJSonString(AV73TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedDescrip") == 0 )
         {
            AV48TFLegDedDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFLegDedDescrip", AV48TFLegDedDescrip);
            AV50TFLegDedDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFLegDedDescrip_SelsJson", AV50TFLegDedDescrip_SelsJson);
            AV49TFLegDedDescrip_Sels.fromJSonString(AV50TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LegDedImporte") == 0 )
         {
            AV55TFLegDedImporte = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFLegDedImporte", GXutil.ltrimstr( AV55TFLegDedImporte, 14, 2));
            AV56TFLegDedImporte_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFLegDedImporte_To", GXutil.ltrimstr( AV56TFLegDedImporte_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFLegDedDescrip_Sels", AV49TFLegDedDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV75TFLegDedConCodYDesc_Sels", AV75TFLegDedConCodYDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80TFLegDedMes_Sels", AV80TFLegDedMes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFLegIdNomApe_Sels", AV60TFLegIdNomApe_Sels);
   }

   private void e202P2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV66Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV66Update);
      if ( AV29IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.legajo_deducciones", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A83LegDedSec,8,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","LegDedSec"})  ;
      }
      AV16Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV16Delete);
      if ( AV26IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.legajo_deducciones", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A83LegDedSec,8,0))}, new String[] {"Mode","CliCod","EmpCod","LegNumero","LegDedSec"})  ;
      }
      AV89Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV89Display);
      edtavDisplay_Link = formatLink("web.legajo_deduccionesview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(A83LegDedSec,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","EmpCod","LegNumero","LegDedSec","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV86VerSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV86VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV86VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV87ModificarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV87ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV87ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV88EliminarSVG ;
      GXv_char7[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV88EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV88EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(111) ;
      }
      sendrow_1112( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_111_Refreshing )
      {
         httpContext.doAjaxLoad(111, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e112P2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV8ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV6ColumnsSelector.fromJSonString(AV8ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "legajo_deduccionesWWColumnsSelector", ((GXutil.strcmp("", AV8ColumnsSelectorXML)==0) ? "" : AV6ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6ColumnsSelector", AV6ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83ManageFiltersData", AV83ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22GridState", AV22GridState);
   }

   public void e122P2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S202 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("legajo_deduccionesWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV113Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV85ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85ManageFiltersExecutionStep", GXutil.str( AV85ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("legajo_deduccionesWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV85ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85ManageFiltersExecutionStep", GXutil.str( AV85ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV84ManageFiltersXml ;
         GXv_char7[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "legajo_deduccionesWWFilters", Ddo_managefilters_Activeeventkey, GXv_char7) ;
         legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
         AV84ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV84ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S202 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV113Pgmname+"GridState", AV84ManageFiltersXml) ;
            AV22GridState.fromxml(AV84ManageFiltersXml, null, null);
            AV31OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
            AV33OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33OrderedDsc", AV33OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S212 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV22GridState", AV22GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFLegIdNomApe_Sels", AV60TFLegIdNomApe_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80TFLegDedMes_Sels", AV80TFLegDedMes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV75TFLegDedConCodYDesc_Sels", AV75TFLegDedConCodYDesc_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TFLegDedDescrip_Sels", AV49TFLegDedDescrip_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6ColumnsSelector", AV6ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83ManageFiltersData", AV83ManageFiltersData);
   }

   public void e162P2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char7[0] = AV99ExcelFilename ;
      GXv_char6[0] = AV100ErrorMessage ;
      new web.legajo_deduccioneswwexport(remoteHandle, context).execute( GXv_char7, GXv_char6) ;
      legajo_deduccionesww_impl.this.AV99ExcelFilename = GXv_char7[0] ;
      legajo_deduccionesww_impl.this.AV100ErrorMessage = GXv_char6[0] ;
      if ( GXutil.strcmp(AV99ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV99ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV100ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV31OrderedBy, 4, 0))+":"+(AV33OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV6ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegIdNomApe", "", "Legajo", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegDedAnio", "", "Año", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegDedMes", "", "Mes", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegDedConCodYDesc", "", "Concepto", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegDedDescrip", "", "Descripción", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "LegDedImporte", "", "Importe", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ModificarSVG", "", "", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV6ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&EliminarSVG", "", "", true, "") ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char10 = AV67UserCustomValue ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "legajo_deduccionesWWColumnsSelector", GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      AV67UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV67UserCustomValue)==0) ) )
      {
         AV7ColumnsSelectorAux.fromxml(AV67UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector14[0] = AV7ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector15[0] = AV6ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, GXv_SdtWWPColumnsSelector15) ;
         AV7ColumnsSelectorAux = GXv_SdtWWPColumnsSelector14[0] ;
         AV6ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      }
      GXv_SdtWWPColumnsSelector15[0] = AV6ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV5CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV6ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean16 = AV29IsAuthorized_Update ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones_Update", GXv_boolean8) ;
      legajo_deduccionesww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV29IsAuthorized_Update = GXt_boolean16 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29IsAuthorized_Update", AV29IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV29IsAuthorized_Update));
      if ( ! ( AV29IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_111_Refreshing);
      }
      GXt_boolean16 = AV26IsAuthorized_Delete ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones_Delete", GXv_boolean8) ;
      legajo_deduccionesww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV26IsAuthorized_Delete = GXt_boolean16 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26IsAuthorized_Delete", AV26IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV26IsAuthorized_Delete));
      if ( ! ( AV26IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_111_Refreshing);
      }
      GXt_boolean16 = AV37TempBoolean ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "SubirArchivoSiradig", GXv_boolean8) ;
      legajo_deduccionesww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV37TempBoolean = GXt_boolean16 ;
      if ( ! ( AV37TempBoolean ) )
      {
         bttBtnimportarsiradig_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnimportarsiradig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnimportarsiradig_Visible), 5, 0), true);
      }
      GXt_boolean16 = AV37TempBoolean ;
      GXv_boolean8[0] = GXt_boolean16 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones_Insert", GXv_boolean8) ;
      legajo_deduccionesww_impl.this.GXt_boolean16 = GXv_boolean8[0] ;
      AV37TempBoolean = GXt_boolean16 ;
      if ( ! ( AV37TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = AV83ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "legajo_deduccionesWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[0] ;
      AV83ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   }

   public void S202( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV59TFLegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59TFLegIdNomApe", AV59TFLegIdNomApe);
      AV60TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV77TFLegDedAnio = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77TFLegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFLegDedAnio), 4, 0));
      AV78TFLegDedAnio_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78TFLegDedAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFLegDedAnio_To), 4, 0));
      AV80TFLegDedMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV74TFLegDedConCodYDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74TFLegDedConCodYDesc", AV74TFLegDedConCodYDesc);
      AV75TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48TFLegDedDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFLegDedDescrip", AV48TFLegDedDescrip);
      AV49TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV55TFLegDedImporte = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFLegDedImporte", GXutil.ltrimstr( AV55TFLegDedImporte, 14, 2));
      AV56TFLegDedImporte_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56TFLegDedImporte_To", GXutil.ltrimstr( AV56TFLegDedImporte_To, 14, 2));
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
      if ( GXutil.strcmp(AV36Session.getValue(AV113Pgmname+"GridState"), "") == 0 )
      {
         AV22GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV113Pgmname+"GridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV36Session.getValue(AV113Pgmname+"GridState"), null, null);
      }
      AV31OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31OrderedBy), 4, 0));
      AV33OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33OrderedDsc", AV33OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S212 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV22GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV22GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV22GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S212( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV125GXV1 = 1 ;
      while ( AV125GXV1 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV125GXV1));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV59TFLegIdNomApe = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFLegIdNomApe", AV59TFLegIdNomApe);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV61TFLegIdNomApe_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFLegIdNomApe_SelsJson", AV61TFLegIdNomApe_SelsJson);
            AV60TFLegIdNomApe_Sels.fromJSonString(AV61TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDANIO") == 0 )
         {
            AV77TFLegDedAnio = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV77TFLegDedAnio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77TFLegDedAnio), 4, 0));
            AV78TFLegDedAnio_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78TFLegDedAnio_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78TFLegDedAnio_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDMES_SEL") == 0 )
         {
            AV79TFLegDedMes_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79TFLegDedMes_SelsJson", AV79TFLegDedMes_SelsJson);
            AV80TFLegDedMes_Sels.fromJSonString(AV79TFLegDedMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC") == 0 )
         {
            AV74TFLegDedConCodYDesc = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV74TFLegDedConCodYDesc", AV74TFLegDedConCodYDesc);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC_SEL") == 0 )
         {
            AV73TFLegDedConCodYDesc_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV73TFLegDedConCodYDesc_SelsJson", AV73TFLegDedConCodYDesc_SelsJson);
            AV75TFLegDedConCodYDesc_Sels.fromJSonString(AV73TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP") == 0 )
         {
            AV48TFLegDedDescrip = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFLegDedDescrip", AV48TFLegDedDescrip);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP_SEL") == 0 )
         {
            AV50TFLegDedDescrip_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFLegDedDescrip_SelsJson", AV50TFLegDedDescrip_SelsJson);
            AV49TFLegDedDescrip_Sels.fromJSonString(AV50TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDIMPORTE") == 0 )
         {
            AV55TFLegDedImporte = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFLegDedImporte", GXutil.ltrimstr( AV55TFLegDedImporte, 14, 2));
            AV56TFLegDedImporte_To = CommonUtil.decimalVal( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFLegDedImporte_To", GXutil.ltrimstr( AV56TFLegDedImporte_To, 14, 2));
         }
         AV125GXV1 = (int)(AV125GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char7[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV60TFLegIdNomApe_Sels.size()==0), AV61TFLegIdNomApe_SelsJson, GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char7[0] ;
      GXt_char9 = "" ;
      GXv_char6[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV75TFLegDedConCodYDesc_Sels.size()==0), AV73TFLegDedConCodYDesc_SelsJson, GXv_char6) ;
      legajo_deduccionesww_impl.this.GXt_char9 = GXv_char6[0] ;
      GXt_char19 = "" ;
      GXv_char5[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV49TFLegDedDescrip_Sels.size()==0), AV50TFLegDedDescrip_SelsJson, GXv_char5) ;
      legajo_deduccionesww_impl.this.GXt_char19 = GXv_char5[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char10+"||"+((AV80TFLegDedMes_Sels.size()==0) ? "" : AV79TFLegDedMes_SelsJson)+"|"+GXt_char9+"|"+GXt_char19+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char19 = "" ;
      GXv_char7[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV59TFLegIdNomApe)==0), AV59TFLegIdNomApe, GXv_char7) ;
      legajo_deduccionesww_impl.this.GXt_char19 = GXv_char7[0] ;
      GXt_char10 = "" ;
      GXv_char6[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV74TFLegDedConCodYDesc)==0), AV74TFLegDedConCodYDesc, GXv_char6) ;
      legajo_deduccionesww_impl.this.GXt_char10 = GXv_char6[0] ;
      GXt_char9 = "" ;
      GXv_char5[0] = GXt_char9 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV48TFLegDedDescrip)==0), AV48TFLegDedDescrip, GXv_char5) ;
      legajo_deduccionesww_impl.this.GXt_char9 = GXv_char5[0] ;
      Ddo_grid_Filteredtext_set = GXt_char19+"|"+((0==AV77TFLegDedAnio) ? "" : GXutil.str( AV77TFLegDedAnio, 4, 0))+"||"+GXt_char10+"|"+GXt_char9+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLegDedImporte)==0) ? "" : GXutil.str( AV55TFLegDedImporte, 14, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|"+((0==AV78TFLegDedAnio_To) ? "" : GXutil.str( AV78TFLegDedAnio_To, 4, 0))+"||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLegDedImporte_To)==0) ? "" : GXutil.str( AV56TFLegDedImporte_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV22GridState.fromxml(AV36Session.getValue(AV113Pgmname+"GridState"), null, null);
      AV22GridState.setgxTv_SdtWWPGridState_Orderedby( AV31OrderedBy );
      AV22GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV33OrderedDsc );
      AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState20[0] = AV22GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLEGIDNOMAPE", httpContext.getMessage( "Legajo", ""), !(GXutil.strcmp("", AV59TFLegIdNomApe)==0), (short)(0), AV59TFLegIdNomApe, "", !(AV60TFLegIdNomApe_Sels.size()==0), AV60TFLegIdNomApe_Sels.toJSonString(false), "") ;
      AV22GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV22GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLEGDEDANIO", httpContext.getMessage( "Año", ""), !((0==AV77TFLegDedAnio)&&(0==AV78TFLegDedAnio_To)), (short)(0), GXutil.trim( GXutil.str( AV77TFLegDedAnio, 4, 0)), GXutil.trim( GXutil.str( AV78TFLegDedAnio_To, 4, 0))) ;
      AV22GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV22GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLEGDEDMES_SEL", httpContext.getMessage( "Mes", ""), !(AV80TFLegDedMes_Sels.size()==0), (short)(0), AV80TFLegDedMes_Sels.toJSonString(false), "") ;
      AV22GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV22GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLEGDEDCONCODYDESC", httpContext.getMessage( "Concepto", ""), !(GXutil.strcmp("", AV74TFLegDedConCodYDesc)==0), (short)(0), AV74TFLegDedConCodYDesc, "", !(AV75TFLegDedConCodYDesc_Sels.size()==0), AV75TFLegDedConCodYDesc_Sels.toJSonString(false), "") ;
      AV22GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV22GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLEGDEDDESCRIP", httpContext.getMessage( "Descripción", ""), !(GXutil.strcmp("", AV48TFLegDedDescrip)==0), (short)(0), AV48TFLegDedDescrip, "", !(AV49TFLegDedDescrip_Sels.size()==0), AV49TFLegDedDescrip_Sels.toJSonString(false), "") ;
      AV22GridState = GXv_SdtWWPGridState20[0] ;
      GXv_SdtWWPGridState20[0] = AV22GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState20, "TFLEGDEDIMPORTE", httpContext.getMessage( "Importe", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLegDedImporte)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV56TFLegDedImporte_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV55TFLegDedImporte, 14, 2)), GXutil.trim( GXutil.str( AV56TFLegDedImporte_To, 14, 2))) ;
      AV22GridState = GXv_SdtWWPGridState20[0] ;
      if ( ! (GXutil.strcmp("", AV90MenuOpcCod)==0) )
      {
         AV23GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV23GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV23GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV90MenuOpcCod );
         AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV23GridStateFilterValue, 0);
      }
      AV22GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV22GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV113Pgmname+"GridState", AV22GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV64TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV64TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV113Pgmname );
      AV64TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV64TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV24HTTPRequest.getScriptName()+"?"+AV24HTTPRequest.getQuerystring() );
      AV64TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "legajo_deducciones" );
      AV36Session.setValue("TrnContext", AV64TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S182( )
   {
      /* 'INITIALIZETOTALIZERS' Routine */
      returnInSub = false ;
      AV81TotLegDedImporte = DecimalUtil.doubleToDec(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TotLegDedImporte", GXutil.ltrimstr( AV81TotLegDedImporte, 18, 2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLEGDEDIMPORTE", getSecureSignedToken( "", localUtil.format( AV81TotLegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")));
   }

   public void S192( )
   {
      /* 'CALCULATETOTALIZERS' Routine */
      returnInSub = false ;
      AV114Legajo_deduccioneswwds_1_tflegidnomape = AV59TFLegIdNomApe ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = AV60TFLegIdNomApe_Sels ;
      AV116Legajo_deduccioneswwds_3_tflegdedanio = AV77TFLegDedAnio ;
      AV117Legajo_deduccioneswwds_4_tflegdedanio_to = AV78TFLegDedAnio_To ;
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = AV80TFLegDedMes_Sels ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV74TFLegDedConCodYDesc ;
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV75TFLegDedConCodYDesc_Sels ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = AV48TFLegDedDescrip ;
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV49TFLegDedDescrip_Sels ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = AV55TFLegDedImporte ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = AV56TFLegDedImporte_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                           A250LegIdNomApe ,
                                           AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                           A568LegDedDescrip ,
                                           AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                           Integer.valueOf(AV115Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                           AV114Legajo_deduccioneswwds_1_tflegidnomape ,
                                           Short.valueOf(AV116Legajo_deduccioneswwds_3_tflegdedanio) ,
                                           Short.valueOf(AV117Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                           Integer.valueOf(AV118Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                           Integer.valueOf(AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                           AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                           Integer.valueOf(AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                           AV121Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                           AV123Legajo_deduccioneswwds_10_tflegdedimporte ,
                                           AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Integer.valueOf(AV5CliCod) ,
                                           Short.valueOf(AV18EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV114Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV114Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
      lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
      lV121Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV121Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
      /* Using cursor H002P4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV5CliCod), Short.valueOf(AV18EmpCod), Integer.valueOf(AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), lV114Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV116Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV117Legajo_deduccioneswwds_4_tflegdedanio_to), lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV121Legajo_deduccioneswwds_8_tflegdeddescrip, AV123Legajo_deduccioneswwds_10_tflegdedimporte, AV124Legajo_deduccioneswwds_11_tflegdedimporte_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A6LegNumero = H002P4_A6LegNumero[0] ;
         A1EmpCod = H002P4_A1EmpCod[0] ;
         A3CliCod = H002P4_A3CliCod[0] ;
         A560LegDedImporte = H002P4_A560LegDedImporte[0] ;
         A568LegDedDescrip = H002P4_A568LegDedDescrip[0] ;
         A570LegDedConCodYDesc = H002P4_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = H002P4_A767LegDedMes[0] ;
         A768LegDedAnio = H002P4_A768LegDedAnio[0] ;
         A250LegIdNomApe = H002P4_A250LegIdNomApe[0] ;
         A84LegDedConCodigo = H002P4_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = H002P4_A559LegDedConDescrip[0] ;
         A250LegIdNomApe = H002P4_A250LegIdNomApe[0] ;
         A559LegDedConDescrip = H002P4_A559LegDedConDescrip[0] ;
         AV81TotLegDedImporte = A560LegDedImporte.add(AV81TotLegDedImporte) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV81TotLegDedImporte", GXutil.ltrimstr( AV81TotLegDedImporte, 18, 2));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTOTLEGDEDIMPORTE", getSecureSignedToken( "", localUtil.format( AV81TotLegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")));
         pr_default.readNext(2);
      }
      pr_default.close(2);
      AV82TotValueLegDedImporte = localUtil.format( AV81TotLegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82TotValueLegDedImporte", AV82TotValueLegDedImporte);
   }

   public void e172P2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV92WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean8[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV90MenuOpcCod, GXv_boolean8) ;
         GXv_char7[0] = AV94textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV5CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char7) ;
         legajo_deduccionesww_impl.this.AV94textoNoMostrara = GXv_char7[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV94textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean8[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV90MenuOpcCod, GXv_boolean8) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_2P2( true) ;
      }
      else
      {
         wb_table2_12_2P2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_2P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_2P2e( true) ;
      }
      else
      {
         wb_table1_9_2P2e( false) ;
      }
   }

   public void wb_table2_12_2P2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e212p1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_legajo_deduccionesWW.htm");
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
         AV98WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV112Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV98WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV98WelcomeMessage_Foto)==0) ? AV112Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV98WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV98WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_legajo_deduccionesWW.htm");
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
         wb_table3_30_2P2( true) ;
      }
      else
      {
         wb_table3_30_2P2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_2P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_2P2( true) ;
      }
      else
      {
         wb_table4_35_2P2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_2P2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_111_idx + "',0)\"" ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
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
         wb_table5_54_2P2( true) ;
      }
      else
      {
         wb_table5_54_2P2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_2P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_2P2( true) ;
      }
      else
      {
         wb_table6_63_2P2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_2P2e( boolean wbgen )
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
         startgridcontrol111( ) ;
      }
      if ( wbEnd == 111 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_111 = (int)(nGXsfl_111_idx-1) ;
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row Invisible", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table7_133_2P2( true) ;
      }
      else
      {
         wb_table7_133_2P2( false) ;
      }
      return  ;
   }

   public void wb_table7_133_2P2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         ucGridpaginationbar.setProperty("CurrentPage", AV20GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV21GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV19GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_2P2e( true) ;
      }
      else
      {
         wb_table2_12_2P2e( false) ;
      }
   }

   public void wb_table7_133_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblGridtabletotalizer_Internalname, tblGridtabletotalizer_Internalname, "", "TableTotalizerAl", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTotvaluelegdedimporte_Internalname, httpContext.getMessage( "Tot Value Leg Ded Importe", ""), "gx-form-item AttributeTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'" + sGXsfl_111_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTotvaluelegdedimporte_Internalname, AV82TotValueLegDedImporte, GXutil.rtrim( localUtil.format( AV82TotValueLegDedImporte, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,151);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvaluelegdedimporte_Jsonclick, 0, "AttributeTotalizer", "", "", "", "", 1, edtavTotvaluelegdedimporte_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_legajo_deduccionesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_133_2P2e( true) ;
      }
      else
      {
         wb_table7_133_2P2e( false) ;
      }
   }

   public void wb_table6_63_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablefiltros_Internalname, tblTablefiltros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportarsiradig_Internalname, "gx.evt.setGridEvt("+GXutil.str( 111, 3, 0)+","+"null"+");", httpContext.getMessage( "Importar archivo SIRADIG", ""), bttBtnimportarsiradig_Jsonclick, 7, httpContext.getMessage( "Importar archivo SIRADIG", ""), "", StyleString, ClassString, bttBtnimportarsiradig_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e222p1_client"+"'", TempTags, "", 2, "HLP_legajo_deduccionesWW.htm");
         httpContext.writeText( "</td>") ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_legajo_deduccionesWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV6ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV83ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 111, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_legajo_deduccionesWW.htm");
         httpContext.writeText( "</td>") ;
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_legajo_deduccionesWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table8_98_2P2( true) ;
      }
      else
      {
         wb_table8_98_2P2( false) ;
      }
      return  ;
   }

   public void wb_table8_98_2P2e( boolean wbgen )
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
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 111, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e232p1_client"+"'", TempTags, "", 2, "HLP_legajo_deduccionesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_63_2P2e( true) ;
      }
      else
      {
         wb_table6_63_2P2e( false) ;
      }
   }

   public void wb_table8_98_2P2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_98_2P2e( true) ;
      }
      else
      {
         wb_table8_98_2P2e( false) ;
      }
   }

   public void wb_table5_54_2P2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_2P2e( true) ;
      }
      else
      {
         wb_table5_54_2P2e( false) ;
      }
   }

   public void wb_table4_35_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_2P2e( true) ;
      }
      else
      {
         wb_table4_35_2P2e( false) ;
      }
   }

   public void wb_table3_30_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_legajo_deduccionesWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_2P2e( true) ;
      }
      else
      {
         wb_table3_30_2P2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV90MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90MenuOpcCod", AV90MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV90MenuOpcCod, ""))));
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
      pa2P2( ) ;
      ws2P2( ) ;
      we2P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171349439", true, true);
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
      httpContext.AddJavascriptSource("legajo_deduccionesww.js", "?2025171349439", false, true);
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

   public void subsflControlProps_1112( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_111_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_111_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_111_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_111_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_111_idx ;
      edtLegDedSec_Internalname = "LEGDEDSEC_"+sGXsfl_111_idx ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE_"+sGXsfl_111_idx ;
      edtLegDedFchDes_Internalname = "LEGDEDFCHDES_"+sGXsfl_111_idx ;
      edtLegDedFchHas_Internalname = "LEGDEDFCHHAS_"+sGXsfl_111_idx ;
      edtLegDedAnio_Internalname = "LEGDEDANIO_"+sGXsfl_111_idx ;
      cmbLegDedMes.setInternalname( "LEGDEDMES_"+sGXsfl_111_idx );
      edtLegDedConCodigo_Internalname = "LEGDEDCONCODIGO_"+sGXsfl_111_idx ;
      edtLegDedConCodYDesc_Internalname = "LEGDEDCONCODYDESC_"+sGXsfl_111_idx ;
      edtLegDedDescrip_Internalname = "LEGDEDDESCRIP_"+sGXsfl_111_idx ;
      edtLegDedImporte_Internalname = "LEGDEDIMPORTE_"+sGXsfl_111_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_111_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_111_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_111_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_111_idx ;
   }

   public void subsflControlProps_fel_1112( )
   {
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_111_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_111_fel_idx ;
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_111_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_111_fel_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_111_fel_idx ;
      edtLegDedSec_Internalname = "LEGDEDSEC_"+sGXsfl_111_fel_idx ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE_"+sGXsfl_111_fel_idx ;
      edtLegDedFchDes_Internalname = "LEGDEDFCHDES_"+sGXsfl_111_fel_idx ;
      edtLegDedFchHas_Internalname = "LEGDEDFCHHAS_"+sGXsfl_111_fel_idx ;
      edtLegDedAnio_Internalname = "LEGDEDANIO_"+sGXsfl_111_fel_idx ;
      cmbLegDedMes.setInternalname( "LEGDEDMES_"+sGXsfl_111_fel_idx );
      edtLegDedConCodigo_Internalname = "LEGDEDCONCODIGO_"+sGXsfl_111_fel_idx ;
      edtLegDedConCodYDesc_Internalname = "LEGDEDCONCODYDESC_"+sGXsfl_111_fel_idx ;
      edtLegDedDescrip_Internalname = "LEGDEDDESCRIP_"+sGXsfl_111_fel_idx ;
      edtLegDedImporte_Internalname = "LEGDEDIMPORTE_"+sGXsfl_111_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_111_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_111_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_111_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_111_fel_idx ;
   }

   public void sendrow_1112( )
   {
      subsflControlProps_1112( ) ;
      wb2P0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_111_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_111_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"GridWithTotalizer GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_111_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV66Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV16Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedSec_Internalname,GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A83LegDedSec), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegIdNomApe_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegIdNomApe_Internalname,A250LegIdNomApe,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegIdNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegIdNomApe_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedFchDes_Internalname,localUtil.format(A556LegDedFchDes, "99/99/99"),localUtil.format( A556LegDedFchDes, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedFchDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedFchHas_Internalname,localUtil.format(A557LegDedFchHas, "99/99/99"),localUtil.format( A557LegDedFchHas, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedFchHas_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegDedAnio_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedAnio_Internalname,GXutil.ltrim( localUtil.ntoc( A768LegDedAnio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A768LegDedAnio), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedAnio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegDedAnio_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Anio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbLegDedMes.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbLegDedMes.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "LEGDEDMES_" + sGXsfl_111_idx ;
            cmbLegDedMes.setName( GXCCtl );
            cmbLegDedMes.setWebtags( "" );
            cmbLegDedMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
            cmbLegDedMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
            cmbLegDedMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
            cmbLegDedMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
            cmbLegDedMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
            cmbLegDedMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
            cmbLegDedMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
            cmbLegDedMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
            cmbLegDedMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
            cmbLegDedMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
            cmbLegDedMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
            cmbLegDedMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
            if ( cmbLegDedMes.getItemCount() > 0 )
            {
               A767LegDedMes = (byte)(GXutil.lval( cmbLegDedMes.getValidValue(GXutil.trim( GXutil.str( A767LegDedMes, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbLegDedMes,cmbLegDedMes.getInternalname(),GXutil.trim( GXutil.str( A767LegDedMes, 2, 0)),Integer.valueOf(1),cmbLegDedMes.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbLegDedMes.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbLegDedMes.setValue( GXutil.trim( GXutil.str( A767LegDedMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLegDedMes.getInternalname(), "Values", cmbLegDedMes.ToJavascriptSource(), !bGXsfl_111_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedConCodigo_Internalname,GXutil.rtrim( A84LegDedConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegDedConCodYDesc_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedConCodYDesc_Internalname,A570LegDedConCodYDesc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedConCodYDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegDedConCodYDesc_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtLegDedDescrip_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedDescrip_Internalname,A568LegDedDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegDedDescrip_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtLegDedImporte_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegDedImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A560LegDedImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A560LegDedImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegDedImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtLegDedImporte_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV86VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV87ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV88EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV89Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(111),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2P2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_111_idx = ((subGrid_Islastpage==1)&&(nGXsfl_111_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_111_idx+1) ;
         sGXsfl_111_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_111_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1112( ) ;
      }
      /* End function sendrow_1112 */
   }

   public void startgridcontrol111( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"111\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithTotalizer GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegIdNomApe_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegDedAnio_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbLegDedMes.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Mes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegDedConCodYDesc_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Concepto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegDedDescrip_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtLegDedImporte_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"GridAction"+"\" "+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "&nbsp;", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridContainer.AddObjectProperty("Class", "GridWithTotalizer GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV66Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV16Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A83LegDedSec, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A250LegIdNomApe);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegIdNomApe_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A556LegDedFchDes, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A557LegDedFchHas, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A768LegDedAnio, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegDedAnio_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A767LegDedMes, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbLegDedMes.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A84LegDedConCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A570LegDedConCodYDesc);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegDedConCodYDesc_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A568LegDedDescrip);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegDedDescrip_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A560LegDedImporte, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtLegDedImporte_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV86VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV87ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV88EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV89Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
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
      bttBtnimportarsiradig_Internalname = "BTNIMPORTARSIRADIG" ;
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
      bttBtninsert_Internalname = "BTNINSERT" ;
      tblTablefiltros_Internalname = "TABLEFILTROS" ;
      divTablefiltrospadre_Internalname = "TABLEFILTROSPADRE" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLegDedSec_Internalname = "LEGDEDSEC" ;
      edtLegIdNomApe_Internalname = "LEGIDNOMAPE" ;
      edtLegDedFchDes_Internalname = "LEGDEDFCHDES" ;
      edtLegDedFchHas_Internalname = "LEGDEDFCHHAS" ;
      edtLegDedAnio_Internalname = "LEGDEDANIO" ;
      cmbLegDedMes.setInternalname( "LEGDEDMES" );
      edtLegDedConCodigo_Internalname = "LEGDEDCONCODIGO" ;
      edtLegDedConCodYDesc_Internalname = "LEGDEDCONCODYDESC" ;
      edtLegDedDescrip_Internalname = "LEGDEDDESCRIP" ;
      edtLegDedImporte_Internalname = "LEGDEDIMPORTE" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavTotvaluelegdedimporte_Internalname = "vTOTVALUELEGDEDIMPORTE" ;
      tblGridtabletotalizer_Internalname = "GRIDTABLETOTALIZER" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      tblTablepadding_Internalname = "TABLEPADDING" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
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
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      edtavEliminarsvg_Jsonclick = "" ;
      edtavEliminarsvg_Link = "" ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavEliminarsvg_Format = (short)(0) ;
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
      edtLegDedImporte_Jsonclick = "" ;
      edtLegDedDescrip_Jsonclick = "" ;
      edtLegDedConCodYDesc_Jsonclick = "" ;
      edtLegDedConCodigo_Jsonclick = "" ;
      cmbLegDedMes.setJsonclick( "" );
      edtLegDedAnio_Jsonclick = "" ;
      edtLegDedFchHas_Jsonclick = "" ;
      edtLegDedFchDes_Jsonclick = "" ;
      edtLegIdNomApe_Jsonclick = "" ;
      edtLegDedSec_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      subGrid_Class = "GridWithTotalizer GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtnimportarsiradig_Visible = 1 ;
      edtavTotvaluelegdedimporte_Jsonclick = "" ;
      edtavTotvaluelegdedimporte_Enabled = 1 ;
      chkavWelcomemessage_nomostrarmas.setEnabled( 1 );
      imgavWelcomemessage_foto_gximage = "" ;
      divWelcomemessage_welcometableparent_Visible = 1 ;
      lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDelete_Link = "" ;
      edtavUpdate_Link = "" ;
      edtavDisplay_Link = "" ;
      tblButtonfilter1_tablebadge_Tooltiptext = "" ;
      lblButtonfilter1_textblockbadgecount_Caption = "2" ;
      tblButtonfilter1_tablebadge_Visible = 1 ;
      lblCouttext_Caption = httpContext.getMessage( "27 registros", "") ;
      edtavEliminarsvg_Visible = -1 ;
      edtavModificarsvg_Visible = -1 ;
      edtavVersvg_Visible = -1 ;
      edtLegDedImporte_Visible = -1 ;
      edtLegDedDescrip_Visible = -1 ;
      edtLegDedConCodYDesc_Visible = -1 ;
      cmbLegDedMes.setVisible( -1 );
      edtLegDedAnio_Visible = -1 ;
      edtLegIdNomApe_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|4.0||||-14.2" ;
      Ddo_grid_Datalistproc = "legajo_deduccionesWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||1:Enero,2:Febrero,3:Marzo,4:Abril,5:Mayo,6:Junio,7:Julio,8:Agosto,9:Septiembre,10:Octubre,11:Noviembre,12:Diciembre|||" ;
      Ddo_grid_Allowmultipleselection = "T||T|T|T|" ;
      Ddo_grid_Datalisttype = "Dynamic||FixedValues|Dynamic|Dynamic|" ;
      Ddo_grid_Includedatalist = "T||T|T|T|" ;
      Ddo_grid_Filterisrange = "|T||||T" ;
      Ddo_grid_Filtertype = "Character|Numeric||Character|Character|Numeric" ;
      Ddo_grid_Includefilter = "T|T||T|T|T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "|1|2|3|4|5" ;
      Ddo_grid_Columnids = "6:LegIdNomApe|9:LegDedAnio|10:LegDedMes|12:LegDedConCodYDesc|13:LegDedDescrip|14:LegDedImporte" ;
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
      Form.setCaption( httpContext.getMessage( "Siradig", "") );
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
      GXCCtl = "LEGDEDMES_" + sGXsfl_111_idx ;
      cmbLegDedMes.setName( GXCCtl );
      cmbLegDedMes.setWebtags( "" );
      cmbLegDedMes.addItem("1", httpContext.getMessage( "Enero", ""), (short)(0));
      cmbLegDedMes.addItem("2", httpContext.getMessage( "Febrero", ""), (short)(0));
      cmbLegDedMes.addItem("3", httpContext.getMessage( "Marzo", ""), (short)(0));
      cmbLegDedMes.addItem("4", httpContext.getMessage( "Abril", ""), (short)(0));
      cmbLegDedMes.addItem("5", httpContext.getMessage( "Mayo", ""), (short)(0));
      cmbLegDedMes.addItem("6", httpContext.getMessage( "Junio", ""), (short)(0));
      cmbLegDedMes.addItem("7", httpContext.getMessage( "Julio", ""), (short)(0));
      cmbLegDedMes.addItem("8", httpContext.getMessage( "Agosto", ""), (short)(0));
      cmbLegDedMes.addItem("9", httpContext.getMessage( "Septiembre", ""), (short)(0));
      cmbLegDedMes.addItem("10", httpContext.getMessage( "Octubre", ""), (short)(0));
      cmbLegDedMes.addItem("11", httpContext.getMessage( "Noviembre", ""), (short)(0));
      cmbLegDedMes.addItem("12", httpContext.getMessage( "Diciembre", ""), (short)(0));
      if ( cmbLegDedMes.getItemCount() > 0 )
      {
         A767LegDedMes = (byte)(GXutil.lval( cmbLegDedMes.getValidValue(GXutil.trim( GXutil.str( A767LegDedMes, 2, 0))))) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV113Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A560LegDedImporte',fld:'LEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'edtLegDedAnio_Visible',ctrl:'LEGDEDANIO',prop:'Visible'},{av:'cmbLegDedMes'},{av:'edtLegDedConCodYDesc_Visible',ctrl:'LEGDEDCONCODYDESC',prop:'Visible'},{av:'edtLegDedDescrip_Visible',ctrl:'LEGDEDDESCRIP',prop:'Visible'},{av:'edtLegDedImporte_Visible',ctrl:'LEGDEDIMPORTE',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV20GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV21GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV19GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTARSIRADIG',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV83ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV82TotValueLegDedImporte',fld:'vTOTVALUELEGDEDIMPORTE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e132P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV113Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e142P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV113Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e152P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV113Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV50TFLegDedDescrip_SelsJson',fld:'vTFLEGDEDDESCRIP_SELSJSON',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV73TFLegDedConCodYDesc_SelsJson',fld:'vTFLEGDEDCONCODYDESC_SELSJSON',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV79TFLegDedMes_SelsJson',fld:'vTFLEGDEDMES_SELSJSON',pic:''},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV61TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e202P2',iparms:[{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A83LegDedSec',fld:'LEGDEDSEC',pic:'ZZZZZZZ9'},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV66Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV16Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV89Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV86VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV87ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV88EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e112P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV113Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A560LegDedImporte',fld:'LEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'edtLegDedAnio_Visible',ctrl:'LEGDEDANIO',prop:'Visible'},{av:'cmbLegDedMes'},{av:'edtLegDedConCodYDesc_Visible',ctrl:'LEGDEDCONCODYDESC',prop:'Visible'},{av:'edtLegDedDescrip_Visible',ctrl:'LEGDEDDESCRIP',prop:'Visible'},{av:'edtLegDedImporte_Visible',ctrl:'LEGDEDIMPORTE',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV20GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV21GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV19GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTARSIRADIG',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV83ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV82TotValueLegDedImporte',fld:'vTOTVALUELEGDEDIMPORTE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e122P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV113Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV61TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV79TFLegDedMes_SelsJson',fld:'vTFLEGDEDMES_SELSJSON',pic:''},{av:'AV73TFLegDedConCodYDesc_SelsJson',fld:'vTFLEGDEDCONCODYDESC_SELSJSON',pic:''},{av:'AV50TFLegDedDescrip_SelsJson',fld:'vTFLEGDEDDESCRIP_SELSJSON',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A560LegDedImporte',fld:'LEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV85ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV22GridState',fld:'vGRIDSTATE',pic:''},{av:'AV31OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV33OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV59TFLegIdNomApe',fld:'vTFLEGIDNOMAPE',pic:''},{av:'AV60TFLegIdNomApe_Sels',fld:'vTFLEGIDNOMAPE_SELS',pic:''},{av:'AV77TFLegDedAnio',fld:'vTFLEGDEDANIO',pic:'ZZZ9'},{av:'AV78TFLegDedAnio_To',fld:'vTFLEGDEDANIO_TO',pic:'ZZZ9'},{av:'AV80TFLegDedMes_Sels',fld:'vTFLEGDEDMES_SELS',pic:''},{av:'AV74TFLegDedConCodYDesc',fld:'vTFLEGDEDCONCODYDESC',pic:''},{av:'AV75TFLegDedConCodYDesc_Sels',fld:'vTFLEGDEDCONCODYDESC_SELS',pic:''},{av:'AV48TFLegDedDescrip',fld:'vTFLEGDEDDESCRIP',pic:''},{av:'AV49TFLegDedDescrip_Sels',fld:'vTFLEGDEDDESCRIP_SELS',pic:''},{av:'AV55TFLegDedImporte',fld:'vTFLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56TFLegDedImporte_To',fld:'vTFLEGDEDIMPORTE_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV50TFLegDedDescrip_SelsJson',fld:'vTFLEGDEDDESCRIP_SELSJSON',pic:''},{av:'AV73TFLegDedConCodYDesc_SelsJson',fld:'vTFLEGDEDCONCODYDESC_SELSJSON',pic:''},{av:'AV79TFLegDedMes_SelsJson',fld:'vTFLEGDEDMES_SELSJSON',pic:''},{av:'AV61TFLegIdNomApe_SelsJson',fld:'vTFLEGIDNOMAPE_SELSJSON',pic:''},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV6ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtLegIdNomApe_Visible',ctrl:'LEGIDNOMAPE',prop:'Visible'},{av:'edtLegDedAnio_Visible',ctrl:'LEGDEDANIO',prop:'Visible'},{av:'cmbLegDedMes'},{av:'edtLegDedConCodYDesc_Visible',ctrl:'LEGDEDCONCODYDESC',prop:'Visible'},{av:'edtLegDedDescrip_Visible',ctrl:'LEGDEDDESCRIP',prop:'Visible'},{av:'edtLegDedImporte_Visible',ctrl:'LEGDEDIMPORTE',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV20GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV21GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV19GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV29IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV26IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNIMPORTARSIRADIG',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV83ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV81TotLegDedImporte',fld:'vTOTLEGDEDIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99',hsh:true},{av:'AV82TotValueLegDedImporte',fld:'vTOTVALUELEGDEDIMPORTE',pic:''}]}");
      setEventMetadata("'DOIMPORTARSIRADIG'","{handler:'e222P1',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV69datetime',fld:'vDATETIME',pic:'99/99/99 99:99',hsh:true}]");
      setEventMetadata("'DOIMPORTARSIRADIG'",",oparms:[]}");
      setEventMetadata("'DOINSERT'","{handler:'e232P1',iparms:[{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e162P2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e172P2',iparms:[{av:'AV92WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV90MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV5CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e212P1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_LEGDEDCONCODIGO","{handler:'valid_Legdedconcodigo',iparms:[]");
      setEventMetadata("VALID_LEGDEDCONCODIGO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Display',iparms:[]");
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
      wcpOAV90MenuOpcCod = "" ;
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
      AV90MenuOpcCod = "" ;
      AV6ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV113Pgmname = "" ;
      AV22GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV59TFLegIdNomApe = "" ;
      AV60TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFLegDedMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV74TFLegDedConCodYDesc = "" ;
      AV75TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFLegDedDescrip = "" ;
      AV49TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFLegDedImporte = DecimalUtil.ZERO ;
      AV56TFLegDedImporte_To = DecimalUtil.ZERO ;
      AV81TotLegDedImporte = DecimalUtil.ZERO ;
      AV69datetime = GXutil.resetTime( GXutil.nullDate() );
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV15DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV83ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV19GridAppliedFilters = "" ;
      AV61TFLegIdNomApe_SelsJson = "" ;
      AV79TFLegDedMes_SelsJson = "" ;
      AV73TFLegDedConCodYDesc_SelsJson = "" ;
      AV50TFLegDedDescrip_SelsJson = "" ;
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
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV66Update = "" ;
      AV16Delete = "" ;
      A250LegIdNomApe = "" ;
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      A84LegDedConCodigo = "" ;
      A570LegDedConCodYDesc = "" ;
      A568LegDedDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      AV86VerSVG = "" ;
      AV87ModificarSVG = "" ;
      AV88EliminarSVG = "" ;
      AV89Display = "" ;
      AV115Legajo_deduccioneswwds_2_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV118Legajo_deduccioneswwds_5_tflegdedmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV114Legajo_deduccioneswwds_1_tflegidnomape = "" ;
      lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = "" ;
      lV121Legajo_deduccioneswwds_8_tflegdeddescrip = "" ;
      AV114Legajo_deduccioneswwds_1_tflegidnomape = "" ;
      AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc = "" ;
      AV121Legajo_deduccioneswwds_8_tflegdeddescrip = "" ;
      AV123Legajo_deduccioneswwds_10_tflegdedimporte = DecimalUtil.ZERO ;
      AV124Legajo_deduccioneswwds_11_tflegdedimporte_to = DecimalUtil.ZERO ;
      A559LegDedConDescrip = "" ;
      H002P2_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002P2_A568LegDedDescrip = new String[] {""} ;
      H002P2_A570LegDedConCodYDesc = new String[] {""} ;
      H002P2_A767LegDedMes = new byte[1] ;
      H002P2_A768LegDedAnio = new short[1] ;
      H002P2_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      H002P2_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      H002P2_A250LegIdNomApe = new String[] {""} ;
      H002P2_A83LegDedSec = new int[1] ;
      H002P2_A6LegNumero = new int[1] ;
      H002P2_A1EmpCod = new short[1] ;
      H002P2_A3CliCod = new int[1] ;
      H002P2_A84LegDedConCodigo = new String[] {""} ;
      H002P2_A559LegDedConDescrip = new String[] {""} ;
      H002P3_AGRID_nRecordCount = new long[1] ;
      AV98WelcomeMessage_Foto = "" ;
      AV82TotValueLegDedImporte = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV24HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV93MenuBienveImgURL = "" ;
      AV95MenuBienveTitulo = "" ;
      AV96MenuBienveTexto = "" ;
      AV112Welcomemessage_foto_GXI = "" ;
      AV106observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      AV70mensaje = "" ;
      AV71websession = httpContext.getWebSession();
      AV72DVMessageType = "" ;
      GXv_int2 = new int[1] ;
      AV68WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV36Session = httpContext.getWebSession();
      AV8ColumnsSelectorXML = "" ;
      AV105MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV109filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV84ManageFiltersXml = "" ;
      AV99ExcelFilename = "" ;
      AV100ErrorMessage = "" ;
      AV67UserCustomValue = "" ;
      AV7ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18 = new GXBaseCollection[1] ;
      AV23GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char19 = "" ;
      GXt_char10 = "" ;
      GXv_char6 = new String[1] ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_SdtWWPGridState20 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV64TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      H002P4_A83LegDedSec = new int[1] ;
      H002P4_A6LegNumero = new int[1] ;
      H002P4_A1EmpCod = new short[1] ;
      H002P4_A3CliCod = new int[1] ;
      H002P4_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H002P4_A568LegDedDescrip = new String[] {""} ;
      H002P4_A570LegDedConCodYDesc = new String[] {""} ;
      H002P4_A767LegDedMes = new byte[1] ;
      H002P4_A768LegDedAnio = new short[1] ;
      H002P4_A250LegIdNomApe = new String[] {""} ;
      H002P4_A84LegDedConCodigo = new String[] {""} ;
      H002P4_A559LegDedConDescrip = new String[] {""} ;
      AV94textoNoMostrara = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      bttBtnimportarsiradig_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtnexport_Jsonclick = "" ;
      lblButtonfilter1_textblock_svg_Jsonclick = "" ;
      lblButtonfilter1_textblock_texto_Jsonclick = "" ;
      bttBtninsert_Jsonclick = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_deduccionesww__default(),
         new Object[] {
             new Object[] {
            H002P2_A560LegDedImporte, H002P2_A568LegDedDescrip, H002P2_A570LegDedConCodYDesc, H002P2_A767LegDedMes, H002P2_A768LegDedAnio, H002P2_A557LegDedFchHas, H002P2_A556LegDedFchDes, H002P2_A250LegIdNomApe, H002P2_A83LegDedSec, H002P2_A6LegNumero,
            H002P2_A1EmpCod, H002P2_A3CliCod, H002P2_A84LegDedConCodigo, H002P2_A559LegDedConDescrip
            }
            , new Object[] {
            H002P3_AGRID_nRecordCount
            }
            , new Object[] {
            H002P4_A83LegDedSec, H002P4_A6LegNumero, H002P4_A1EmpCod, H002P4_A3CliCod, H002P4_A560LegDedImporte, H002P4_A568LegDedDescrip, H002P4_A570LegDedConCodYDesc, H002P4_A767LegDedMes, H002P4_A768LegDedAnio, H002P4_A250LegIdNomApe,
            H002P4_A84LegDedConCodigo, H002P4_A559LegDedConDescrip
            }
         }
      );
      AV113Pgmname = "legajo_deduccionesWW" ;
      /* GeneXus formulas. */
      AV113Pgmname = "legajo_deduccionesWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavTotvaluelegdedimporte_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV85ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte A767LegDedMes ;
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
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV77TFLegDedAnio ;
   private short AV78TFLegDedAnio_To ;
   private short AV31OrderedBy ;
   private short AV18EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short A768LegDedAnio ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV116Legajo_deduccioneswwds_3_tflegdedanio ;
   private short AV117Legajo_deduccioneswwds_4_tflegdedanio_to ;
   private short GXt_int11 ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_111 ;
   private int nGXsfl_111_idx=1 ;
   private int AV5CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavTotvaluelegdedimporte_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size ;
   private int AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size ;
   private int AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ;
   private int AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtLegIdNomApe_Visible ;
   private int edtLegDedAnio_Visible ;
   private int edtLegDedConCodYDesc_Visible ;
   private int edtLegDedDescrip_Visible ;
   private int edtLegDedImporte_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV108filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV34PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtnimportarsiradig_Visible ;
   private int bttBtninsert_Visible ;
   private int AV125GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV20GridCurrentPage ;
   private long AV21GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV55TFLegDedImporte ;
   private java.math.BigDecimal AV56TFLegDedImporte_To ;
   private java.math.BigDecimal AV81TotLegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private java.math.BigDecimal AV123Legajo_deduccioneswwds_10_tflegdedimporte ;
   private java.math.BigDecimal AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ;
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
   private String sGXsfl_111_idx="0001" ;
   private String AV113Pgmname ;
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
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV66Update ;
   private String edtavUpdate_Internalname ;
   private String AV16Delete ;
   private String edtavDelete_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtLegDedSec_Internalname ;
   private String edtLegIdNomApe_Internalname ;
   private String edtLegDedFchDes_Internalname ;
   private String edtLegDedFchHas_Internalname ;
   private String edtLegDedAnio_Internalname ;
   private String A84LegDedConCodigo ;
   private String edtLegDedConCodigo_Internalname ;
   private String edtLegDedConCodYDesc_Internalname ;
   private String edtLegDedDescrip_Internalname ;
   private String edtLegDedImporte_Internalname ;
   private String AV86VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV87ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV88EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String AV89Display ;
   private String edtavDisplay_Internalname ;
   private String edtavTotvaluelegdedimporte_Internalname ;
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
   private String AV106observerPalabra ;
   private String Buttonexport1_a3lexport_Internalname ;
   private String divButtonexport1_tablecontentbuttonimport_Internalname ;
   private String bttBtnexport_Internalname ;
   private String Buttonfilter1_a3lfilter_Internalname ;
   private String divButtonfilter1_tablecontent_Internalname ;
   private String AV72DVMessageType ;
   private String lblCouttext_Internalname ;
   private String lblCouttext_Caption ;
   private String tblButtonfilter1_tablebadge_Internalname ;
   private String lblButtonfilter1_textblockbadgecount_Caption ;
   private String lblButtonfilter1_textblockbadgecount_Internalname ;
   private String tblButtonfilter1_tablebadge_Tooltiptext ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtnimportarsiradig_Internalname ;
   private String bttBtninsert_Internalname ;
   private String GXt_char19 ;
   private String GXt_char10 ;
   private String GXv_char6[] ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXv_char7[] ;
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
   private String TempTags ;
   private String divWelcomemessage_tabletext_Internalname ;
   private String lblWelcomemessage_combotext_Jsonclick ;
   private String divTablefiltrospadre_Internalname ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String tblGridtabletotalizer_Internalname ;
   private String edtavTotvaluelegdedimporte_Jsonclick ;
   private String tblTablefiltros_Internalname ;
   private String bttBtnimportarsiradig_Jsonclick ;
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
   private String bttBtninsert_Jsonclick ;
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
   private String sGXsfl_111_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtLegDedSec_Jsonclick ;
   private String edtLegIdNomApe_Jsonclick ;
   private String edtLegDedFchDes_Jsonclick ;
   private String edtLegDedFchHas_Jsonclick ;
   private String edtLegDedAnio_Jsonclick ;
   private String GXCCtl ;
   private String edtLegDedConCodigo_Jsonclick ;
   private String edtLegDedConCodYDesc_Jsonclick ;
   private String edtLegDedDescrip_Jsonclick ;
   private String edtLegDedImporte_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date AV69datetime ;
   private java.util.Date A556LegDedFchDes ;
   private java.util.Date A557LegDedFchHas ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV33OrderedDsc ;
   private boolean AV29IsAuthorized_Update ;
   private boolean AV26IsAuthorized_Delete ;
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
   private boolean bGXsfl_111_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV97MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean AV37TempBoolean ;
   private boolean GXt_boolean16 ;
   private boolean GXv_boolean8[] ;
   private boolean AV98WelcomeMessage_Foto_IsBlob ;
   private String AV61TFLegIdNomApe_SelsJson ;
   private String AV79TFLegDedMes_SelsJson ;
   private String AV73TFLegDedConCodYDesc_SelsJson ;
   private String AV50TFLegDedDescrip_SelsJson ;
   private String AV96MenuBienveTexto ;
   private String AV8ColumnsSelectorXML ;
   private String AV84ManageFiltersXml ;
   private String AV67UserCustomValue ;
   private String AV94textoNoMostrara ;
   private String wcpOAV90MenuOpcCod ;
   private String AV90MenuOpcCod ;
   private String AV59TFLegIdNomApe ;
   private String AV74TFLegDedConCodYDesc ;
   private String AV48TFLegDedDescrip ;
   private String AV19GridAppliedFilters ;
   private String A250LegIdNomApe ;
   private String A570LegDedConCodYDesc ;
   private String A568LegDedDescrip ;
   private String lV114Legajo_deduccioneswwds_1_tflegidnomape ;
   private String lV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ;
   private String lV121Legajo_deduccioneswwds_8_tflegdeddescrip ;
   private String AV114Legajo_deduccioneswwds_1_tflegidnomape ;
   private String AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ;
   private String AV121Legajo_deduccioneswwds_8_tflegdeddescrip ;
   private String A559LegDedConDescrip ;
   private String AV82TotValueLegDedImporte ;
   private String AV93MenuBienveImgURL ;
   private String AV95MenuBienveTitulo ;
   private String AV112Welcomemessage_foto_GXI ;
   private String AV70mensaje ;
   private String AV105MenuOpcTitulo ;
   private String AV109filtrosTexto ;
   private String AV99ExcelFilename ;
   private String AV100ErrorMessage ;
   private String AV98WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ;
   private GXSimpleCollection<Byte> AV80TFLegDedMes_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV24HTTPRequest ;
   private com.genexus.webpanels.WebSession AV71websession ;
   private com.genexus.webpanels.WebSession AV36Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ;
   private GXSimpleCollection<String> AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbLegDedMes ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H002P2_A560LegDedImporte ;
   private String[] H002P2_A568LegDedDescrip ;
   private String[] H002P2_A570LegDedConCodYDesc ;
   private byte[] H002P2_A767LegDedMes ;
   private short[] H002P2_A768LegDedAnio ;
   private java.util.Date[] H002P2_A557LegDedFchHas ;
   private java.util.Date[] H002P2_A556LegDedFchDes ;
   private String[] H002P2_A250LegIdNomApe ;
   private int[] H002P2_A83LegDedSec ;
   private int[] H002P2_A6LegNumero ;
   private short[] H002P2_A1EmpCod ;
   private int[] H002P2_A3CliCod ;
   private String[] H002P2_A84LegDedConCodigo ;
   private String[] H002P2_A559LegDedConDescrip ;
   private long[] H002P3_AGRID_nRecordCount ;
   private int[] H002P4_A83LegDedSec ;
   private int[] H002P4_A6LegNumero ;
   private short[] H002P4_A1EmpCod ;
   private int[] H002P4_A3CliCod ;
   private java.math.BigDecimal[] H002P4_A560LegDedImporte ;
   private String[] H002P4_A568LegDedDescrip ;
   private String[] H002P4_A570LegDedConCodYDesc ;
   private byte[] H002P4_A767LegDedMes ;
   private short[] H002P4_A768LegDedAnio ;
   private String[] H002P4_A250LegIdNomApe ;
   private String[] H002P4_A84LegDedConCodigo ;
   private String[] H002P4_A559LegDedConDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV60TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV75TFLegDedConCodYDesc_Sels ;
   private GXSimpleCollection<String> AV49TFLegDedDescrip_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV83ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item17 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item18[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV6ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV7ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState20[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV64TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV68WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
}

final  class legajo_deduccionesww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002P2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV114Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV116Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV117Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV121Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV123Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          short AV31OrderedBy ,
                                          boolean AV33OrderedDsc ,
                                          int AV5CliCod ,
                                          short AV18EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[13];
      Object[] GXv_Object22 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) AS LegDedConCodYDesc, T1.LegDedMes, T1.LegDedAnio," ;
      sSelectString += " T1.LegDedFchHas, T1.LegDedFchDes, T2.LegIdNomApe, T1.LegDedSec, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedConCodigo AS LegDedConCodigo, T3.ConDescrip AS LegDedConDescrip" ;
      sFromString = " FROM ((legajo_deducciones T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON" ;
      sFromString += " T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.LegDedConCodigo)" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      if ( ( AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV116Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( ! (0==AV117Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV118Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( ( AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV121Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int21[7] = (byte)(1) ;
      }
      if ( AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV123Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int21[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV124Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int21[9] = (byte)(1) ;
      }
      if ( ( AV31OrderedBy == 1 ) && ! AV33OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LegDedAnio, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 1 ) && ( AV33OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LegDedAnio DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ! AV33OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LegDedMes, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ( AV33OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LegDedMes DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 3 ) && ! AV33OrderedDsc )
      {
         sOrderString += " ORDER BY LegDedConCodYDesc, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 3 ) && ( AV33OrderedDsc ) )
      {
         sOrderString += " ORDER BY LegDedConCodYDesc DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 4 ) && ! AV33OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LegDedDescrip, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 4 ) && ( AV33OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LegDedDescrip DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 5 ) && ! AV33OrderedDsc )
      {
         sOrderString += " ORDER BY T1.LegDedImporte, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( ( AV31OrderedBy == 5 ) && ( AV33OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.LegDedImporte DESC, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegDedSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_H002P3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV114Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV116Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV117Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV121Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV123Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          short AV31OrderedBy ,
                                          boolean AV33OrderedDsc ,
                                          int AV5CliCod ,
                                          short AV18EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[10];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((legajo_deducciones T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN" ;
      scmdbuf += " Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      if ( ( AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int24[3] = (byte)(1) ;
      }
      if ( AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV116Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int24[4] = (byte)(1) ;
      }
      if ( ! (0==AV117Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int24[5] = (byte)(1) ;
      }
      if ( AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV118Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int24[6] = (byte)(1) ;
      }
      if ( ( AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV121Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int24[7] = (byte)(1) ;
      }
      if ( AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV123Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int24[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV124Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int24[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV31OrderedBy == 1 ) && ! AV33OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 1 ) && ( AV33OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ! AV33OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 2 ) && ( AV33OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 3 ) && ! AV33OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 3 ) && ( AV33OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 4 ) && ! AV33OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 4 ) && ( AV33OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 5 ) && ! AV33OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV31OrderedBy == 5 ) && ( AV33OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
   }

   protected Object[] conditional_H002P4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV115Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV118Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV114Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV116Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV117Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV121Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV123Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV124Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          int AV5CliCod ,
                                          short AV18EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int27 = new byte[10];
      Object[] GXv_Object28 = new Object[2];
      scmdbuf = "SELECT T1.LegDedSec, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))" ;
      scmdbuf += " AS LegDedConCodYDesc, T1.LegDedMes, T1.LegDedAnio, T2.LegIdNomApe, T1.LegDedConCodigo AS LegDedConCodigo, T3.ConDescrip AS LegDedConDescrip FROM ((legajo_deducciones" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.ConCodigo = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      if ( ( AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int27[3] = (byte)(1) ;
      }
      if ( AV115Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV116Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int27[4] = (byte)(1) ;
      }
      if ( ! (0==AV117Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int27[5] = (byte)(1) ;
      }
      if ( AV118Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV118Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV120Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV119Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int27[6] = (byte)(1) ;
      }
      if ( ( AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV121Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int27[7] = (byte)(1) ;
      }
      if ( AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV122Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV123Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int27[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV124Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int27[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object28[0] = scmdbuf ;
      GXv_Object28[1] = GXv_int27 ;
      return GXv_Object28 ;
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
                  return conditional_H002P2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() );
            case 1 :
                  return conditional_H002P3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() );
            case 2 :
                  return conditional_H002P4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002P2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002P3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002P4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 10);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 10);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
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
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

