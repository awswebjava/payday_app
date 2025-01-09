package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_horasextras_pordiaww_impl extends GXDataArea
{
   public convenio_horasextras_pordiaww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_horasextras_pordiaww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_horasextras_pordiaww_impl.class ));
   }

   public convenio_horasextras_pordiaww_impl( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbConvHsPDiaTipTra = new HTMLChoice();
      cmbConveHsPDiaDia = new HTMLChoice();
      cmbConveTarifaPDCri = new HTMLChoice();
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
            AV55MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55MenuOpcCod", AV55MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55MenuOpcCod, ""))));
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
      nRC_GXsfl_110 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_110"))) ;
      nGXsfl_110_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_110_idx"))) ;
      sGXsfl_110_idx = httpContext.GetPar( "sGXsfl_110_idx") ;
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
      AV49ConveCodigo = httpContext.GetPar( "ConveCodigo") ;
      AV47PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV71ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV19ColumnsSelector);
      AV87Pgmname = httpContext.GetPar( "Pgmname") ;
      AV55MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV12GridState);
      AV22TFConveHsExSec = (short)(GXutil.lval( httpContext.GetPar( "TFConveHsExSec"))) ;
      AV23TFConveHsExSec_To = (short)(GXutil.lval( httpContext.GetPar( "TFConveHsExSec_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV25TFConvHsPDiaTipTra_Sels);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV27TFConveHsPDiaDia_Sels);
      AV29TFConveHsPDiaDesde = httpContext.GetPar( "TFConveHsPDiaDesde") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30TFConveHsPDiaDesde_Sels);
      AV31TFConveTarifaPDia = CommonUtil.decimalVal( httpContext.GetPar( "TFConveTarifaPDia"), ".") ;
      AV32TFConveTarifaPDia_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveTarifaPDia_To"), ".") ;
      AV33TFConveTarifaPDRec = CommonUtil.decimalVal( httpContext.GetPar( "TFConveTarifaPDRec"), ".") ;
      AV34TFConveTarifaPDRec_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveTarifaPDRec_To"), ".") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV83TFConveTarifaPDCri_Sels);
      AV65TFConveHsPdiaRelRef = httpContext.GetPar( "TFConveHsPdiaRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV66TFConveHsPdiaRelRef_Sels);
      AV14OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV15OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV45CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV41IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV43IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV57WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      AV48CliConvenio = httpContext.GetPar( "CliConvenio") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV49ConveCodigo, AV47PaiCod, AV71ManageFiltersExecutionStep, AV19ColumnsSelector, AV87Pgmname, AV55MenuOpcCod, AV12GridState, AV22TFConveHsExSec, AV23TFConveHsExSec_To, AV25TFConvHsPDiaTipTra_Sels, AV27TFConveHsPDiaDia_Sels, AV29TFConveHsPDiaDesde, AV30TFConveHsPDiaDesde_Sels, AV31TFConveTarifaPDia, AV32TFConveTarifaPDia_To, AV33TFConveTarifaPDRec, AV34TFConveTarifaPDRec_To, AV83TFConveTarifaPDCri_Sels, AV65TFConveHsPdiaRelRef, AV66TFConveHsPdiaRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV57WelcomeMessage_NoMostrarMas, AV48CliConvenio) ;
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
      paFD2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startFD2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_horasextras_pordiaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55MenuOpcCod))}, new String[] {"MenuOpcCod"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV47PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48CliConvenio, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_110", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_110, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV35DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV35DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV19ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV69ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV69ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV37GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV38GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV39GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV71ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV55MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV12GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV12GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSEXSEC", GXutil.ltrim( localUtil.ntoc( AV22TFConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSEXSEC_TO", GXutil.ltrim( localUtil.ntoc( AV23TFConveHsExSec_To, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVHSPDIATIPTRA_SELS", AV25TFConvHsPDiaTipTra_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVHSPDIATIPTRA_SELS", AV25TFConvHsPDiaTipTra_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVEHSPDIADIA_SELS", AV27TFConveHsPDiaDia_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVEHSPDIADIA_SELS", AV27TFConveHsPDiaDia_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSPDIADESDE", GXutil.rtrim( AV29TFConveHsPDiaDesde));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVEHSPDIADESDE_SELS", AV30TFConveHsPDiaDesde_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVEHSPDIADESDE_SELS", AV30TFConveHsPDiaDesde_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVETARIFAPDIA", GXutil.ltrim( localUtil.ntoc( AV31TFConveTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVETARIFAPDIA_TO", GXutil.ltrim( localUtil.ntoc( AV32TFConveTarifaPDia_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVETARIFAPDREC", GXutil.ltrim( localUtil.ntoc( AV33TFConveTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVETARIFAPDREC_TO", GXutil.ltrim( localUtil.ntoc( AV34TFConveTarifaPDRec_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVETARIFAPDCRI_SELS", AV83TFConveTarifaPDCri_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVETARIFAPDCRI_SELS", AV83TFConveTarifaPDCri_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSPDIARELREF", AV65TFConveHsPdiaRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVEHSPDIARELREF_SELS", AV66TFConveHsPdiaRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVEHSPDIARELREF_SELS", AV66TFConveHsPdiaRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV14OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV15OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV45CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV41IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV43IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVHSPDIATIPTRA_SELSJSON", AV24TFConvHsPDiaTipTra_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSPDIADIA_SELSJSON", AV26TFConveHsPDiaDia_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSPDIADESDE_SELSJSON", AV28TFConveHsPDiaDesde_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVETARIFAPDCRI_SELSJSON", AV82TFConveTarifaPDCri_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEHSPDIARELREF_SELSJSON", AV64TFConveHsPdiaRelRef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV47PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV47PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV48CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVECODIGO", GXutil.rtrim( AV49ConveCodigo));
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
         weFD2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtFD2( ) ;
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
      return formatLink("web.convenio_horasextras_pordiaww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55MenuOpcCod))}, new String[] {"MenuOpcCod"})  ;
   }

   public String getPgmname( )
   {
      return "Convenio_horasextras_porDiaWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Convenio_horasextras_por Dia", "") ;
   }

   public void wbFD0( )
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
         wb_table1_9_FD2( true) ;
      }
      else
      {
         wb_table1_9_FD2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_FD2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV35DDO_TitleSettingsIcons);
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
      if ( wbEnd == 110 )
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

   public void startFD2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Convenio_horasextras_por Dia", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupFD0( ) ;
   }

   public void wsFD2( )
   {
      startFD2( ) ;
      evtFD2( ) ;
   }

   public void evtFD2( )
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
                           e11FD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12FD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13FD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14FD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15FD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16FD2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17FD2 ();
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
                           nGXsfl_110_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1102( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
                           A1327ConveHsExSec = (short)(localUtil.ctol( httpContext.cgiGet( edtConveHsExSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbConvHsPDiaTipTra.setName( cmbConvHsPDiaTipTra.getInternalname() );
                           cmbConvHsPDiaTipTra.setValue( httpContext.cgiGet( cmbConvHsPDiaTipTra.getInternalname()) );
                           A1326ConvHsPDiaTipTra = httpContext.cgiGet( cmbConvHsPDiaTipTra.getInternalname()) ;
                           cmbConveHsPDiaDia.setName( cmbConveHsPDiaDia.getInternalname() );
                           cmbConveHsPDiaDia.setValue( httpContext.cgiGet( cmbConveHsPDiaDia.getInternalname()) );
                           A1328ConveHsPDiaDia = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveHsPDiaDia.getInternalname()))) ;
                           A1329ConveHsPDiaDesde = httpContext.cgiGet( edtConveHsPDiaDesde_Internalname) ;
                           n1329ConveHsPDiaDesde = false ;
                           A1330ConveTarifaPDia = localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDia_Internalname)) ;
                           A1350ConveTarifaPDRec = localUtil.ctond( httpContext.cgiGet( edtConveTarifaPDRec_Internalname)) ;
                           cmbConveTarifaPDCri.setName( cmbConveTarifaPDCri.getInternalname() );
                           cmbConveTarifaPDCri.setValue( httpContext.cgiGet( cmbConveTarifaPDCri.getInternalname()) );
                           A2432ConveTarifaPDCri = httpContext.cgiGet( cmbConveTarifaPDCri.getInternalname()) ;
                           A2067ConveHsPdiaRelRef = httpContext.cgiGet( edtConveHsPdiaRelRef_Internalname) ;
                           AV40Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV40Update);
                           AV42Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV42Delete);
                           AV54Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV54Display);
                           AV51VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV51VerSVG);
                           AV52ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV52ModificarSVG);
                           AV53EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV53EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18FD2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19FD2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20FD2 ();
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

   public void weFD2( )
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

   public void paFD2( )
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
      subsflControlProps_1102( ) ;
      while ( nGXsfl_110_idx <= nRC_GXsfl_110 )
      {
         sendrow_1102( ) ;
         nGXsfl_110_idx = ((subGrid_Islastpage==1)&&(nGXsfl_110_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_110_idx+1) ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV49ConveCodigo ,
                                 short AV47PaiCod ,
                                 byte AV71ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ,
                                 String AV87Pgmname ,
                                 String AV55MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV12GridState ,
                                 short AV22TFConveHsExSec ,
                                 short AV23TFConveHsExSec_To ,
                                 GXSimpleCollection<String> AV25TFConvHsPDiaTipTra_Sels ,
                                 GXSimpleCollection<Byte> AV27TFConveHsPDiaDia_Sels ,
                                 String AV29TFConveHsPDiaDesde ,
                                 GXSimpleCollection<String> AV30TFConveHsPDiaDesde_Sels ,
                                 java.math.BigDecimal AV31TFConveTarifaPDia ,
                                 java.math.BigDecimal AV32TFConveTarifaPDia_To ,
                                 java.math.BigDecimal AV33TFConveTarifaPDRec ,
                                 java.math.BigDecimal AV34TFConveTarifaPDRec_To ,
                                 GXSimpleCollection<String> AV83TFConveTarifaPDCri_Sels ,
                                 String AV65TFConveHsPdiaRelRef ,
                                 GXSimpleCollection<String> AV66TFConveHsPdiaRelRef_Sels ,
                                 short AV14OrderedBy ,
                                 boolean AV15OrderedDsc ,
                                 int AV45CliCod ,
                                 boolean AV41IsAuthorized_Update ,
                                 boolean AV43IsAuthorized_Delete ,
                                 boolean AV57WelcomeMessage_NoMostrarMas ,
                                 String AV48CliConvenio )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19FD2 ();
      GRID_nCurrentRecord = 0 ;
      rfFD2( ) ;
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
      AV57WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV57WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57WelcomeMessage_NoMostrarMas", AV57WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfFD2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV87Pgmname = "Convenio_horasextras_porDiaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
   }

   public void rfFD2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e19FD2 ();
      nGXsfl_110_idx = 1 ;
      sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1102( ) ;
      bGXsfl_110_Refreshing = true ;
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
         subsflControlProps_1102( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A1326ConvHsPDiaTipTra ,
                                              AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                              Byte.valueOf(A1328ConveHsPDiaDia) ,
                                              AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                              A1329ConveHsPDiaDesde ,
                                              AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                              A2432ConveTarifaPDCri ,
                                              AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                              A2067ConveHsPdiaRelRef ,
                                              AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                              Short.valueOf(AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec) ,
                                              Short.valueOf(AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) ,
                                              Integer.valueOf(AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels.size()) ,
                                              Integer.valueOf(AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels.size()) ,
                                              Integer.valueOf(AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels.size()) ,
                                              AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                              AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                              AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                              AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                              AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                              Integer.valueOf(AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels.size()) ,
                                              Integer.valueOf(AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels.size()) ,
                                              AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                              Short.valueOf(A1327ConveHsExSec) ,
                                              A1330ConveTarifaPDia ,
                                              A1350ConveTarifaPDRec ,
                                              Short.valueOf(AV14OrderedBy) ,
                                              Boolean.valueOf(AV15OrderedDsc) ,
                                              Integer.valueOf(AV45CliCod) ,
                                              Short.valueOf(AV47PaiCod) ,
                                              AV49ConveCodigo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              A1565CliConvenio } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                              TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                              }
         });
         lV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde), 5, "%") ;
         lV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = GXutil.concat( GXutil.rtrim( AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref), "%", "") ;
         /* Using cursor H00FD2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV45CliCod), Short.valueOf(AV47PaiCod), AV49ConveCodigo, Short.valueOf(AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec), Short.valueOf(AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to), lV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde, AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia, AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to, AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec, AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to, lV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2067ConveHsPdiaRelRef = H00FD2_A2067ConveHsPdiaRelRef[0] ;
            A2432ConveTarifaPDCri = H00FD2_A2432ConveTarifaPDCri[0] ;
            A1350ConveTarifaPDRec = H00FD2_A1350ConveTarifaPDRec[0] ;
            A1330ConveTarifaPDia = H00FD2_A1330ConveTarifaPDia[0] ;
            A1329ConveHsPDiaDesde = H00FD2_A1329ConveHsPDiaDesde[0] ;
            n1329ConveHsPDiaDesde = H00FD2_n1329ConveHsPDiaDesde[0] ;
            A1328ConveHsPDiaDia = H00FD2_A1328ConveHsPDiaDia[0] ;
            A1326ConvHsPDiaTipTra = H00FD2_A1326ConvHsPDiaTipTra[0] ;
            A1327ConveHsExSec = H00FD2_A1327ConveHsExSec[0] ;
            A1565CliConvenio = H00FD2_A1565CliConvenio[0] ;
            A1564CliPaiConve = H00FD2_A1564CliPaiConve[0] ;
            A3CliCod = H00FD2_A3CliCod[0] ;
            e20FD2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbFD0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesFD2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV87Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV87Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV55MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV45CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV41IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV43IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV47PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV47PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV48CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV48CliConvenio, ""))));
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
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1326ConvHsPDiaTipTra ,
                                           AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                           Byte.valueOf(A1328ConveHsPDiaDia) ,
                                           AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                           A1329ConveHsPDiaDesde ,
                                           AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                           A2432ConveTarifaPDCri ,
                                           AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                           A2067ConveHsPdiaRelRef ,
                                           AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                           Short.valueOf(AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec) ,
                                           Short.valueOf(AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) ,
                                           Integer.valueOf(AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels.size()) ,
                                           Integer.valueOf(AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels.size()) ,
                                           AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                           AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                           AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                           AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                           AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                           Integer.valueOf(AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels.size()) ,
                                           AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                           Short.valueOf(A1327ConveHsExSec) ,
                                           A1330ConveTarifaPDia ,
                                           A1350ConveTarifaPDRec ,
                                           Short.valueOf(AV14OrderedBy) ,
                                           Boolean.valueOf(AV15OrderedDsc) ,
                                           Integer.valueOf(AV45CliCod) ,
                                           Short.valueOf(AV47PaiCod) ,
                                           AV49ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde), 5, "%") ;
      lV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = GXutil.concat( GXutil.rtrim( AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref), "%", "") ;
      /* Using cursor H00FD3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV45CliCod), Short.valueOf(AV47PaiCod), AV49ConveCodigo, Short.valueOf(AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec), Short.valueOf(AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to), lV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde, AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia, AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to, AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec, AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to, lV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref});
      GRID_nRecordCount = H00FD3_AGRID_nRecordCount[0] ;
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
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV49ConveCodigo, AV47PaiCod, AV71ManageFiltersExecutionStep, AV19ColumnsSelector, AV87Pgmname, AV55MenuOpcCod, AV12GridState, AV22TFConveHsExSec, AV23TFConveHsExSec_To, AV25TFConvHsPDiaTipTra_Sels, AV27TFConveHsPDiaDia_Sels, AV29TFConveHsPDiaDesde, AV30TFConveHsPDiaDesde_Sels, AV31TFConveTarifaPDia, AV32TFConveTarifaPDia_To, AV33TFConveTarifaPDRec, AV34TFConveTarifaPDRec_To, AV83TFConveTarifaPDCri_Sels, AV65TFConveHsPdiaRelRef, AV66TFConveHsPdiaRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV57WelcomeMessage_NoMostrarMas, AV48CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV49ConveCodigo, AV47PaiCod, AV71ManageFiltersExecutionStep, AV19ColumnsSelector, AV87Pgmname, AV55MenuOpcCod, AV12GridState, AV22TFConveHsExSec, AV23TFConveHsExSec_To, AV25TFConvHsPDiaTipTra_Sels, AV27TFConveHsPDiaDia_Sels, AV29TFConveHsPDiaDesde, AV30TFConveHsPDiaDesde_Sels, AV31TFConveTarifaPDia, AV32TFConveTarifaPDia_To, AV33TFConveTarifaPDRec, AV34TFConveTarifaPDRec_To, AV83TFConveTarifaPDCri_Sels, AV65TFConveHsPdiaRelRef, AV66TFConveHsPdiaRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV57WelcomeMessage_NoMostrarMas, AV48CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV49ConveCodigo, AV47PaiCod, AV71ManageFiltersExecutionStep, AV19ColumnsSelector, AV87Pgmname, AV55MenuOpcCod, AV12GridState, AV22TFConveHsExSec, AV23TFConveHsExSec_To, AV25TFConvHsPDiaTipTra_Sels, AV27TFConveHsPDiaDia_Sels, AV29TFConveHsPDiaDesde, AV30TFConveHsPDiaDesde_Sels, AV31TFConveTarifaPDia, AV32TFConveTarifaPDia_To, AV33TFConveTarifaPDRec, AV34TFConveTarifaPDRec_To, AV83TFConveTarifaPDCri_Sels, AV65TFConveHsPdiaRelRef, AV66TFConveHsPdiaRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV57WelcomeMessage_NoMostrarMas, AV48CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV49ConveCodigo, AV47PaiCod, AV71ManageFiltersExecutionStep, AV19ColumnsSelector, AV87Pgmname, AV55MenuOpcCod, AV12GridState, AV22TFConveHsExSec, AV23TFConveHsExSec_To, AV25TFConvHsPDiaTipTra_Sels, AV27TFConveHsPDiaDia_Sels, AV29TFConveHsPDiaDesde, AV30TFConveHsPDiaDesde_Sels, AV31TFConveTarifaPDia, AV32TFConveTarifaPDia_To, AV33TFConveTarifaPDRec, AV34TFConveTarifaPDRec_To, AV83TFConveTarifaPDCri_Sels, AV65TFConveHsPdiaRelRef, AV66TFConveHsPdiaRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV57WelcomeMessage_NoMostrarMas, AV48CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV49ConveCodigo, AV47PaiCod, AV71ManageFiltersExecutionStep, AV19ColumnsSelector, AV87Pgmname, AV55MenuOpcCod, AV12GridState, AV22TFConveHsExSec, AV23TFConveHsExSec_To, AV25TFConvHsPDiaTipTra_Sels, AV27TFConveHsPDiaDia_Sels, AV29TFConveHsPDiaDesde, AV30TFConveHsPDiaDesde_Sels, AV31TFConveTarifaPDia, AV32TFConveTarifaPDia_To, AV33TFConveTarifaPDRec, AV34TFConveTarifaPDRec_To, AV83TFConveTarifaPDCri_Sels, AV65TFConveHsPdiaRelRef, AV66TFConveHsPdiaRelRef_Sels, AV14OrderedBy, AV15OrderedDsc, AV45CliCod, AV41IsAuthorized_Update, AV43IsAuthorized_Delete, AV57WelcomeMessage_NoMostrarMas, AV48CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV87Pgmname = "Convenio_horasextras_porDiaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Enabled), 5, 0), !bGXsfl_110_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strupFD0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18FD2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV35DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV19ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV69ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV37GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV38GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV39GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV48CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
         AV47PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV45CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         AV63WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV57WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57WelcomeMessage_NoMostrarMas", AV57WelcomeMessage_NoMostrarMas);
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
      e18FD2 ();
      if (returnInSub) return;
   }

   public void e18FD2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV55MenuOpcCod, "", "") ;
      GXt_int1 = AV45CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_horasextras_pordiaww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV45CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
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
      GXt_boolean3 = AV81IsAuthorized_ConveHsPDiaDia ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasEspeciales", GXv_boolean4) ;
      convenio_horasextras_pordiaww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV81IsAuthorized_ConveHsPDiaDia = GXt_boolean3 ;
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Convenio_horasextras_por Dia", "") );
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
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV35DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV35DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char7[0] = AV58MenuBienveImgURL ;
      GXv_char8[0] = AV60MenuBienveTitulo ;
      GXv_char9[0] = AV61MenuBienveTexto ;
      GXv_boolean4[0] = AV62MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV55MenuOpcCod, GXv_char7, GXv_char8, GXv_char9, GXv_boolean4) ;
      convenio_horasextras_pordiaww_impl.this.AV58MenuBienveImgURL = GXv_char7[0] ;
      convenio_horasextras_pordiaww_impl.this.AV60MenuBienveTitulo = GXv_char8[0] ;
      convenio_horasextras_pordiaww_impl.this.AV61MenuBienveTexto = GXv_char9[0] ;
      convenio_horasextras_pordiaww_impl.this.AV62MenuBienveVisible = GXv_boolean4[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV62MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV62MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV60MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV61MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV63WelcomeMessage_Foto = AV58MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0) ? AV86Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV63WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV63WelcomeMessage_Foto), true);
         AV86Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV58MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0) ? AV86Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV63WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV63WelcomeMessage_Foto), true);
      }
      GXt_char10 = "" ;
      GXt_char11 = "" ;
      GXv_char9[0] = GXt_char11 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      GXv_char8[0] = GXt_char10 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char11, GXv_char8) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char10 = GXv_char8[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char10 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV80observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV80observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV80observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV80observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXv_char9[0] = AV49ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.AV49ConveCodigo = GXv_char9[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49ConveCodigo", AV49ConveCodigo);
      GXv_int12[0] = AV47PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV45CliCod, GXv_int12) ;
      convenio_horasextras_pordiaww_impl.this.AV47PaiCod = GXv_int12[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV47PaiCod), "ZZZ9")));
   }

   public void e19FD2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV45CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      convenio_horasextras_pordiaww_impl.this.GXt_int1 = GXv_int2[0] ;
      AV45CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext13[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext13) ;
      AV6WWPContext = GXv_SdtWWPContext13[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV71ManageFiltersExecutionStep == 1 )
      {
         AV71ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71ManageFiltersExecutionStep", GXutil.str( AV71ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV71ManageFiltersExecutionStep == 2 )
      {
         AV71ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71ManageFiltersExecutionStep", GXutil.str( AV71ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV21Session.getValue("Convenio_horasextras_porDiaWWColumnsSelector"), "") != 0 )
      {
         AV17ColumnsSelectorXML = AV21Session.getValue("Convenio_horasextras_porDiaWWColumnsSelector") ;
         AV19ColumnsSelector.fromxml(AV17ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtConveHsExSec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsExSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsExSec_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConvHsPDiaTipTra.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Visible", GXutil.ltrimstr( cmbConvHsPDiaTipTra.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      cmbConveHsPDiaDia.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveHsPDiaDia.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveHsPDiaDia.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsPDiaDesde_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsPDiaDesde_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsPDiaDesde_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveTarifaPDia_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveTarifaPDia_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveTarifaPDia_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveTarifaPDRec_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveTarifaPDRec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveTarifaPDRec_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConveTarifaPDCri.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveTarifaPDCri.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveTarifaPDCri.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConveHsPdiaRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveHsPdiaRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveHsPdiaRelRef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV19ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV37GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37GridCurrentPage), 10, 0));
      AV38GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38GridPageCount), 10, 0));
      GXt_char11 = AV39GridAppliedFilters ;
      GXv_char9[0] = GXt_char11 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV87Pgmname, GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      AV39GridAppliedFilters = GXt_char11 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39GridAppliedFilters", AV39GridAppliedFilters);
      GXt_char11 = AV76MenuOpcTitulo ;
      GXv_char9[0] = GXt_char11 ;
      new web.gettxtcount(remoteHandle, context).execute( AV55MenuOpcCod, GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      AV76MenuOpcTitulo = GXt_char11 ;
      if ( (GXutil.strcmp("", AV76MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV76MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int12[0] = (short)(AV78filterCount) ;
      GXv_char9[0] = AV79filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV12GridState, GXv_int12, GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.AV78filterCount = GXv_int12[0] ;
      convenio_horasextras_pordiaww_impl.this.AV79filtrosTexto = GXv_char9[0] ;
      if ( AV78filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV78filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV79filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      GXv_char9[0] = AV49ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.AV49ConveCodigo = GXv_char9[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49ConveCodigo", AV49ConveCodigo);
      AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV22TFConveHsExSec ;
      AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV23TFConveHsExSec_To ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV25TFConvHsPDiaTipTra_Sels ;
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV27TFConveHsPDiaDia_Sels ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV29TFConveHsPDiaDesde ;
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV30TFConveHsPDiaDesde_Sels ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV31TFConveTarifaPDia ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV32TFConveTarifaPDia_To ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV33TFConveTarifaPDRec ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV34TFConveTarifaPDRec_To ;
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV83TFConveTarifaPDCri_Sels ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV65TFConveHsPdiaRelRef ;
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV66TFConveHsPdiaRelRef_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV69ManageFiltersData", AV69ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66TFConveHsPdiaRelRef_Sels", AV66TFConveHsPdiaRelRef_Sels);
   }

   public void e13FD2( )
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
         AV36PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV36PageToGo) ;
      }
   }

   public void e14FD2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15FD2( )
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
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsExSec") == 0 )
         {
            AV22TFConveHsExSec = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFConveHsExSec), 4, 0));
            AV23TFConveHsExSec_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFConveHsExSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFConveHsExSec_To), 4, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConvHsPDiaTipTra") == 0 )
         {
            AV24TFConvHsPDiaTipTra_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFConvHsPDiaTipTra_SelsJson", AV24TFConvHsPDiaTipTra_SelsJson);
            AV25TFConvHsPDiaTipTra_Sels.fromJSonString(AV24TFConvHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsPDiaDia") == 0 )
         {
            AV26TFConveHsPDiaDia_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFConveHsPDiaDia_SelsJson", AV26TFConveHsPDiaDia_SelsJson);
            AV27TFConveHsPDiaDia_Sels.fromJSonString(GXutil.strReplace( AV26TFConveHsPDiaDia_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsPDiaDesde") == 0 )
         {
            AV29TFConveHsPDiaDesde = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFConveHsPDiaDesde", AV29TFConveHsPDiaDesde);
            AV28TFConveHsPDiaDesde_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFConveHsPDiaDesde_SelsJson", AV28TFConveHsPDiaDesde_SelsJson);
            AV30TFConveHsPDiaDesde_Sels.fromJSonString(AV28TFConveHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveTarifaPDia") == 0 )
         {
            AV31TFConveTarifaPDia = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFConveTarifaPDia", GXutil.ltrimstr( AV31TFConveTarifaPDia, 6, 4));
            AV32TFConveTarifaPDia_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConveTarifaPDia_To", GXutil.ltrimstr( AV32TFConveTarifaPDia_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveTarifaPDRec") == 0 )
         {
            AV33TFConveTarifaPDRec = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConveTarifaPDRec", GXutil.ltrimstr( AV33TFConveTarifaPDRec, 6, 4));
            AV34TFConveTarifaPDRec_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFConveTarifaPDRec_To", GXutil.ltrimstr( AV34TFConveTarifaPDRec_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveTarifaPDCri") == 0 )
         {
            AV82TFConveTarifaPDCri_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFConveTarifaPDCri_SelsJson", AV82TFConveTarifaPDCri_SelsJson);
            AV83TFConveTarifaPDCri_Sels.fromJSonString(AV82TFConveTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveHsPdiaRelRef") == 0 )
         {
            AV65TFConveHsPdiaRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFConveHsPdiaRelRef", AV65TFConveHsPdiaRelRef);
            AV64TFConveHsPdiaRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFConveHsPdiaRelRef_SelsJson", AV64TFConveHsPdiaRelRef_SelsJson);
            AV66TFConveHsPdiaRelRef_Sels.fromJSonString(AV64TFConveHsPdiaRelRef_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66TFConveHsPdiaRelRef_Sels", AV66TFConveHsPdiaRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83TFConveTarifaPDCri_Sels", AV83TFConveTarifaPDCri_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFConveHsPDiaDesde_Sels", AV30TFConveHsPDiaDesde_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFConveHsPDiaDia_Sels", AV27TFConveHsPDiaDia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25TFConvHsPDiaTipTra_Sels", AV25TFConvHsPDiaTipTra_Sels);
   }

   private void e20FD2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV40Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV40Update);
      if ( AV41IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.convenio_horasextras_pordia", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1327ConveHsExSec,4,0))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveHsExSec"})  ;
      }
      AV42Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV42Delete);
      if ( AV43IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.convenio_horasextras_pordia", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1327ConveHsExSec,4,0))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveHsExSec"})  ;
      }
      AV54Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV54Display);
      edtavDisplay_Link = formatLink("web.convenio_horasextras_pordiaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1327ConveHsExSec,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","CliPaiConve","CliConvenio","ConveHsExSec","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char11 = AV51VerSVG ;
      GXv_char9[0] = GXt_char11 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      AV51VerSVG = GXt_char11 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV51VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char11 = AV52ModificarSVG ;
      GXv_char9[0] = GXt_char11 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      AV52ModificarSVG = GXt_char11 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV52ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char11 = AV53EliminarSVG ;
      GXv_char9[0] = GXt_char11 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      AV53EliminarSVG = GXt_char11 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV53EliminarSVG);
      edtavEliminarsvg_Link = edtavDelete_Link ;
      edtavDelete_Visible = 0 ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(110) ;
      }
      sendrow_1102( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_110_Refreshing )
      {
         httpContext.doAjaxLoad(110, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11FD2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV17ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV19ColumnsSelector.fromJSonString(AV17ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Convenio_horasextras_porDiaWWColumnsSelector", ((GXutil.strcmp("", AV17ColumnsSelectorXML)==0) ? "" : AV19ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV69ManageFiltersData", AV69ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66TFConveHsPdiaRelRef_Sels", AV66TFConveHsPdiaRelRef_Sels);
   }

   public void e12FD2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("Convenio_horasextras_porDiaWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV87Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV71ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71ManageFiltersExecutionStep", GXutil.str( AV71ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("Convenio_horasextras_porDiaWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV71ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71ManageFiltersExecutionStep", GXutil.str( AV71ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char11 = AV70ManageFiltersXml ;
         GXv_char9[0] = GXt_char11 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "Convenio_horasextras_porDiaWWFilters", Ddo_managefilters_Activeeventkey, GXv_char9) ;
         convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
         AV70ManageFiltersXml = GXt_char11 ;
         if ( (GXutil.strcmp("", AV70ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV70ManageFiltersXml) ;
            AV12GridState.fromxml(AV70ManageFiltersXml, null, null);
            AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
            AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12GridState", AV12GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25TFConvHsPDiaTipTra_Sels", AV25TFConvHsPDiaTipTra_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27TFConveHsPDiaDia_Sels", AV27TFConveHsPDiaDia_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV30TFConveHsPDiaDesde_Sels", AV30TFConveHsPDiaDesde_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV83TFConveTarifaPDCri_Sels", AV83TFConveTarifaPDCri_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66TFConveHsPdiaRelRef_Sels", AV66TFConveHsPdiaRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ColumnsSelector", AV19ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV69ManageFiltersData", AV69ManageFiltersData);
   }

   public void e16FD2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char9[0] = AV67ExcelFilename ;
      GXv_char8[0] = AV68ErrorMessage ;
      new web.convenio_horasextras_pordiawwexport(remoteHandle, context).execute( GXv_char9, GXv_char8) ;
      convenio_horasextras_pordiaww_impl.this.AV67ExcelFilename = GXv_char9[0] ;
      convenio_horasextras_pordiaww_impl.this.AV68ErrorMessage = GXv_char8[0] ;
      if ( GXutil.strcmp(AV67ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV67ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV68ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV14OrderedBy, 4, 0))+":"+(AV15OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV19ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveHsExSec", "", "Secuencial", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConvHsPDiaTipTra", "", "Tipo de trabajo", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveHsPDiaDia", "", "Día", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveHsPDiaDesde", "", "Hora desde", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveTarifaPDia", "", "Aumento de horas extras sobre hora normal", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveTarifaPDRec", "", "Recargo a hora normal diurna", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveTarifaPDCri", "", "Criterio", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV45CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "ConveHsPdiaRelRef", "", "Liberación", true, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "", "", "", false, "") ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
         AV65TFConveHsPdiaRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65TFConveHsPdiaRelRef", AV65TFConveHsPdiaRelRef);
         AV66TFConveHsPdiaRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&VerSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&ModificarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXv_SdtWWPColumnsSelector14[0] = AV19ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, "&EliminarSVG", "", "", true, "") ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      GXt_char11 = AV18UserCustomValue ;
      GXv_char9[0] = GXt_char11 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Convenio_horasextras_porDiaWWColumnsSelector", GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      AV18UserCustomValue = GXt_char11 ;
      if ( ! ( (GXutil.strcmp("", AV18UserCustomValue)==0) ) )
      {
         AV20ColumnsSelectorAux.fromxml(AV18UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector15[0] = AV19ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector14, GXv_SdtWWPColumnsSelector15) ;
         AV20ColumnsSelectorAux = GXv_SdtWWPColumnsSelector14[0] ;
         AV19ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
      }
      GXv_SdtWWPColumnsSelector15[0] = AV19ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV45CliCod, GXv_SdtWWPColumnsSelector15) ;
      AV19ColumnsSelector = GXv_SdtWWPColumnsSelector15[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV41IsAuthorized_Update ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia_Update", GXv_boolean4) ;
      convenio_horasextras_pordiaww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV41IsAuthorized_Update = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41IsAuthorized_Update", AV41IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV41IsAuthorized_Update));
      if ( ! ( AV41IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean3 = AV43IsAuthorized_Delete ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia_Delete", GXv_boolean4) ;
      convenio_horasextras_pordiaww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV43IsAuthorized_Delete = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43IsAuthorized_Delete", AV43IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV43IsAuthorized_Delete));
      if ( ! ( AV43IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean3 = AV44TempBoolean ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia_Insert", GXv_boolean4) ;
      convenio_horasextras_pordiaww_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV44TempBoolean = GXt_boolean3 ;
      if ( ! ( AV44TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV69ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "Convenio_horasextras_porDiaWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV69ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV22TFConveHsExSec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22TFConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFConveHsExSec), 4, 0));
      AV23TFConveHsExSec_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23TFConveHsExSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFConveHsExSec_To), 4, 0));
      AV25TFConvHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27TFConveHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV29TFConveHsPDiaDesde = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29TFConveHsPDiaDesde", AV29TFConveHsPDiaDesde);
      AV30TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31TFConveTarifaPDia = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31TFConveTarifaPDia", GXutil.ltrimstr( AV31TFConveTarifaPDia, 6, 4));
      AV32TFConveTarifaPDia_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32TFConveTarifaPDia_To", GXutil.ltrimstr( AV32TFConveTarifaPDia_To, 6, 4));
      AV33TFConveTarifaPDRec = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33TFConveTarifaPDRec", GXutil.ltrimstr( AV33TFConveTarifaPDRec, 6, 4));
      AV34TFConveTarifaPDRec_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TFConveTarifaPDRec_To", GXutil.ltrimstr( AV34TFConveTarifaPDRec_To, 6, 4));
      AV83TFConveTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65TFConveHsPdiaRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65TFConveHsPdiaRelRef", AV65TFConveHsPdiaRelRef);
      AV66TFConveHsPdiaRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV21Session.getValue(AV87Pgmname+"GridState"), "") == 0 )
      {
         AV12GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV87Pgmname+"GridState"), null, null);
      }
      else
      {
         AV12GridState.fromxml(AV21Session.getValue(AV87Pgmname+"GridState"), null, null);
      }
      AV14OrderedBy = AV12GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14OrderedBy), 4, 0));
      AV15OrderedDsc = AV12GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedDsc", AV15OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV12GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV12GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV12GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV101GXV1 = 1 ;
      while ( AV101GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV101GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSEXSEC") == 0 )
         {
            AV22TFConveHsExSec = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFConveHsExSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22TFConveHsExSec), 4, 0));
            AV23TFConveHsExSec_To = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFConveHsExSec_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23TFConveHsExSec_To), 4, 0));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVHSPDIATIPTRA_SEL") == 0 )
         {
            AV24TFConvHsPDiaTipTra_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24TFConvHsPDiaTipTra_SelsJson", AV24TFConvHsPDiaTipTra_SelsJson);
            AV25TFConvHsPDiaTipTra_Sels.fromJSonString(AV24TFConvHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADIA_SEL") == 0 )
         {
            AV26TFConveHsPDiaDia_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFConveHsPDiaDia_SelsJson", AV26TFConveHsPDiaDia_SelsJson);
            AV27TFConveHsPDiaDia_Sels.fromJSonString(AV26TFConveHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE") == 0 )
         {
            AV29TFConveHsPDiaDesde = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29TFConveHsPDiaDesde", AV29TFConveHsPDiaDesde);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE_SEL") == 0 )
         {
            AV28TFConveHsPDiaDesde_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28TFConveHsPDiaDesde_SelsJson", AV28TFConveHsPDiaDesde_SelsJson);
            AV30TFConveHsPDiaDesde_Sels.fromJSonString(AV28TFConveHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDIA") == 0 )
         {
            AV31TFConveTarifaPDia = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31TFConveTarifaPDia", GXutil.ltrimstr( AV31TFConveTarifaPDia, 6, 4));
            AV32TFConveTarifaPDia_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32TFConveTarifaPDia_To", GXutil.ltrimstr( AV32TFConveTarifaPDia_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDREC") == 0 )
         {
            AV33TFConveTarifaPDRec = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33TFConveTarifaPDRec", GXutil.ltrimstr( AV33TFConveTarifaPDRec, 6, 4));
            AV34TFConveTarifaPDRec_To = CommonUtil.decimalVal( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34TFConveTarifaPDRec_To", GXutil.ltrimstr( AV34TFConveTarifaPDRec_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDCRI_SEL") == 0 )
         {
            AV82TFConveTarifaPDCri_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFConveTarifaPDCri_SelsJson", AV82TFConveTarifaPDCri_SelsJson);
            AV83TFConveTarifaPDCri_Sels.fromJSonString(AV82TFConveTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIARELREF") == 0 )
         {
            AV65TFConveHsPdiaRelRef = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65TFConveHsPdiaRelRef", AV65TFConveHsPdiaRelRef);
         }
         else if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIARELREF_SEL") == 0 )
         {
            AV64TFConveHsPdiaRelRef_SelsJson = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV64TFConveHsPdiaRelRef_SelsJson", AV64TFConveHsPdiaRelRef_SelsJson);
            AV66TFConveHsPdiaRelRef_Sels.fromJSonString(AV64TFConveHsPdiaRelRef_SelsJson, null);
         }
         AV101GXV1 = (int)(AV101GXV1+1) ;
      }
      GXt_char11 = "" ;
      GXv_char9[0] = GXt_char11 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV25TFConvHsPDiaTipTra_Sels.size()==0), AV24TFConvHsPDiaTipTra_SelsJson, GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char11 = GXv_char9[0] ;
      GXt_char10 = "" ;
      GXv_char8[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV30TFConveHsPDiaDesde_Sels.size()==0), AV28TFConveHsPDiaDesde_SelsJson, GXv_char8) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char10 = GXv_char8[0] ;
      GXt_char18 = "" ;
      GXv_char7[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV83TFConveTarifaPDCri_Sels.size()==0), AV82TFConveTarifaPDCri_SelsJson, GXv_char7) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char18 = GXv_char7[0] ;
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV66TFConveHsPdiaRelRef_Sels.size()==0), AV64TFConveHsPdiaRelRef_SelsJson, GXv_char20) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char19 = GXv_char20[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char11+"|"+((AV27TFConveHsPDiaDia_Sels.size()==0) ? "" : AV26TFConveHsPDiaDia_SelsJson)+"|"+GXt_char10+"|||"+GXt_char18+"|"+GXt_char19 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char19 = "" ;
      GXv_char20[0] = GXt_char19 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV29TFConveHsPDiaDesde)==0), AV29TFConveHsPDiaDesde, GXv_char20) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char19 = GXv_char20[0] ;
      GXt_char18 = "" ;
      GXv_char9[0] = GXt_char18 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV65TFConveHsPdiaRelRef)==0), AV65TFConveHsPdiaRelRef, GXv_char9) ;
      convenio_horasextras_pordiaww_impl.this.GXt_char18 = GXv_char9[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV22TFConveHsExSec) ? "" : GXutil.str( AV22TFConveHsExSec, 4, 0))+"|||"+GXt_char19+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFConveTarifaPDia)==0) ? "" : GXutil.str( AV31TFConveTarifaPDia, 6, 4))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFConveTarifaPDRec)==0) ? "" : GXutil.str( AV33TFConveTarifaPDRec, 6, 4))+"||"+GXt_char18 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV23TFConveHsExSec_To) ? "" : GXutil.str( AV23TFConveHsExSec_To, 4, 0))+"||||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFConveTarifaPDia_To)==0) ? "" : GXutil.str( AV32TFConveTarifaPDia_To, 6, 4))+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFConveTarifaPDRec_To)==0) ? "" : GXutil.str( AV34TFConveTarifaPDRec_To, 6, 4))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV21Session.getValue(AV87Pgmname+"GridState"), null, null);
      AV12GridState.setgxTv_SdtWWPGridState_Orderedby( AV14OrderedBy );
      AV12GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV15OrderedDsc );
      AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVEHSEXSEC", httpContext.getMessage( "Secuencial", ""), !((0==AV22TFConveHsExSec)&&(0==AV23TFConveHsExSec_To)), (short)(0), GXutil.trim( GXutil.str( AV22TFConveHsExSec, 4, 0)), GXutil.trim( GXutil.str( AV23TFConveHsExSec_To, 4, 0))) ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVHSPDIATIPTRA_SEL", httpContext.getMessage( "Tipo de trabajo", ""), !(AV25TFConvHsPDiaTipTra_Sels.size()==0), (short)(0), AV25TFConvHsPDiaTipTra_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVEHSPDIADIA_SEL", httpContext.getMessage( "Día", ""), !(AV27TFConveHsPDiaDia_Sels.size()==0), (short)(0), AV27TFConveHsPDiaDia_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVEHSPDIADESDE", httpContext.getMessage( "Hora desde", ""), !(GXutil.strcmp("", AV29TFConveHsPDiaDesde)==0), (short)(0), AV29TFConveHsPDiaDesde, "", !(AV30TFConveHsPDiaDesde_Sels.size()==0), AV30TFConveHsPDiaDesde_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVETARIFAPDIA", httpContext.getMessage( "Aumento de horas extras sobre hora normal", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFConveTarifaPDia)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFConveTarifaPDia_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV31TFConveTarifaPDia, 6, 4)), GXutil.trim( GXutil.str( AV32TFConveTarifaPDia_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVETARIFAPDREC", httpContext.getMessage( "Recargo a hora normal diurna", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFConveTarifaPDRec)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFConveTarifaPDRec_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV33TFConveTarifaPDRec, 6, 4)), GXutil.trim( GXutil.str( AV34TFConveTarifaPDRec_To, 6, 4))) ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVETARIFAPDCRI_SEL", httpContext.getMessage( "Criterio", ""), !(AV83TFConveTarifaPDCri_Sels.size()==0), (short)(0), AV83TFConveTarifaPDCri_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      GXv_SdtWWPGridState21[0] = AV12GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState21, "TFCONVEHSPDIARELREF", httpContext.getMessage( "Liberación", ""), !(GXutil.strcmp("", AV65TFConveHsPdiaRelRef)==0), (short)(0), AV65TFConveHsPdiaRelRef, "", !(AV66TFConveHsPdiaRelRef_Sels.size()==0), AV66TFConveHsPdiaRelRef_Sels.toJSonString(false), "") ;
      AV12GridState = GXv_SdtWWPGridState21[0] ;
      if ( ! (GXutil.strcmp("", AV55MenuOpcCod)==0) )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV13GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV55MenuOpcCod );
         AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV13GridStateFilterValue, 0);
      }
      AV12GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV12GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV87Pgmname+"GridState", AV12GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV10TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV87Pgmname );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV9HTTPRequest.getScriptName()+"?"+AV9HTTPRequest.getQuerystring() );
      AV10TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Convenio_horasextras_porDia" );
      AV21Session.setValue("TrnContext", AV10TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17FD2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV57WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean4[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV55MenuOpcCod, GXv_boolean4) ;
         GXv_char20[0] = AV59textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV45CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char20) ;
         convenio_horasextras_pordiaww_impl.this.AV59textoNoMostrara = GXv_char20[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV59textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean4[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV55MenuOpcCod, GXv_boolean4) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_FD2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_FD2( true) ;
      }
      else
      {
         wb_table2_12_FD2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_FD2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_FD2e( true) ;
      }
      else
      {
         wb_table1_9_FD2e( false) ;
      }
   }

   public void wb_table2_12_FD2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21fd1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         AV63WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV86Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV63WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV63WelcomeMessage_Foto)==0) ? AV86Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV63WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV63WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         wb_table3_30_FD2( true) ;
      }
      else
      {
         wb_table3_30_FD2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_FD2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_FD2( true) ;
      }
      else
      {
         wb_table4_35_FD2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_FD2e( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_110_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV57WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         wb_table5_54_FD2( true) ;
      }
      else
      {
         wb_table5_54_FD2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_FD2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_FD2( true) ;
      }
      else
      {
         wb_table6_63_FD2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_FD2e( boolean wbgen )
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
         startgridcontrol110( ) ;
      }
      if ( wbEnd == 110 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_110 = (int)(nGXsfl_110_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV37GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV38GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV39GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_FD2e( true) ;
      }
      else
      {
         wb_table2_12_FD2e( false) ;
      }
   }

   public void wb_table6_63_FD2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV35DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV19ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV69ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e22fd1_client"+"'", TempTags, "", 2, "HLP_Convenio_horasextras_porDiaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Convenio_horasextras_porDiaWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_FD2( true) ;
      }
      else
      {
         wb_table7_99_FD2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_FD2e( boolean wbgen )
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
         wb_table6_63_FD2e( true) ;
      }
      else
      {
         wb_table6_63_FD2e( false) ;
      }
   }

   public void wb_table7_99_FD2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_FD2e( true) ;
      }
      else
      {
         wb_table7_99_FD2e( false) ;
      }
   }

   public void wb_table5_54_FD2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_FD2e( true) ;
      }
      else
      {
         wb_table5_54_FD2e( false) ;
      }
   }

   public void wb_table4_35_FD2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_FD2e( true) ;
      }
      else
      {
         wb_table4_35_FD2e( false) ;
      }
   }

   public void wb_table3_30_FD2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_horasextras_porDiaWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_FD2e( true) ;
      }
      else
      {
         wb_table3_30_FD2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV55MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55MenuOpcCod", AV55MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55MenuOpcCod, ""))));
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
      paFD2( ) ;
      wsFD2( ) ;
      weFD2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251818312052", true, true);
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
      httpContext.AddJavascriptSource("convenio_horasextras_pordiaww.js", "?20251818312052", false, true);
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

   public void subsflControlProps_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_idx ;
      edtCliPaiConve_Internalname = "CLIPAICONVE_"+sGXsfl_110_idx ;
      edtCliConvenio_Internalname = "CLICONVENIO_"+sGXsfl_110_idx ;
      edtConveHsExSec_Internalname = "CONVEHSEXSEC_"+sGXsfl_110_idx ;
      cmbConvHsPDiaTipTra.setInternalname( "CONVHSPDIATIPTRA_"+sGXsfl_110_idx );
      cmbConveHsPDiaDia.setInternalname( "CONVEHSPDIADIA_"+sGXsfl_110_idx );
      edtConveHsPDiaDesde_Internalname = "CONVEHSPDIADESDE_"+sGXsfl_110_idx ;
      edtConveTarifaPDia_Internalname = "CONVETARIFAPDIA_"+sGXsfl_110_idx ;
      edtConveTarifaPDRec_Internalname = "CONVETARIFAPDREC_"+sGXsfl_110_idx ;
      cmbConveTarifaPDCri.setInternalname( "CONVETARIFAPDCRI_"+sGXsfl_110_idx );
      edtConveHsPdiaRelRef_Internalname = "CONVEHSPDIARELREF_"+sGXsfl_110_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_idx ;
   }

   public void subsflControlProps_fel_1102( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_110_fel_idx ;
      edtCliPaiConve_Internalname = "CLIPAICONVE_"+sGXsfl_110_fel_idx ;
      edtCliConvenio_Internalname = "CLICONVENIO_"+sGXsfl_110_fel_idx ;
      edtConveHsExSec_Internalname = "CONVEHSEXSEC_"+sGXsfl_110_fel_idx ;
      cmbConvHsPDiaTipTra.setInternalname( "CONVHSPDIATIPTRA_"+sGXsfl_110_fel_idx );
      cmbConveHsPDiaDia.setInternalname( "CONVEHSPDIADIA_"+sGXsfl_110_fel_idx );
      edtConveHsPDiaDesde_Internalname = "CONVEHSPDIADESDE_"+sGXsfl_110_fel_idx ;
      edtConveTarifaPDia_Internalname = "CONVETARIFAPDIA_"+sGXsfl_110_fel_idx ;
      edtConveTarifaPDRec_Internalname = "CONVETARIFAPDREC_"+sGXsfl_110_fel_idx ;
      cmbConveTarifaPDCri.setInternalname( "CONVETARIFAPDCRI_"+sGXsfl_110_fel_idx );
      edtConveHsPdiaRelRef_Internalname = "CONVEHSPDIARELREF_"+sGXsfl_110_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_110_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_110_fel_idx ;
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_110_fel_idx ;
      edtavVersvg_Internalname = "vVERSVG_"+sGXsfl_110_fel_idx ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG_"+sGXsfl_110_fel_idx ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG_"+sGXsfl_110_fel_idx ;
   }

   public void sendrow_1102( )
   {
      subsflControlProps_1102( ) ;
      wbFD0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_110_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_110_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_110_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliPaiConve_Internalname,GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliPaiConve_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConvenio_Internalname,GXutil.rtrim( A1565CliConvenio),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConvenio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveHsExSec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsExSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1327ConveHsExSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1327ConveHsExSec), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsExSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsExSec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConvHsPDiaTipTra.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConvHsPDiaTipTra.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVHSPDIATIPTRA_" + sGXsfl_110_idx ;
            cmbConvHsPDiaTipTra.setName( GXCCtl );
            cmbConvHsPDiaTipTra.setWebtags( "" );
            cmbConvHsPDiaTipTra.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
            cmbConvHsPDiaTipTra.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
            cmbConvHsPDiaTipTra.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
            if ( cmbConvHsPDiaTipTra.getItemCount() > 0 )
            {
               A1326ConvHsPDiaTipTra = cmbConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConvHsPDiaTipTra,cmbConvHsPDiaTipTra.getInternalname(),GXutil.rtrim( A1326ConvHsPDiaTipTra),Integer.valueOf(1),cmbConvHsPDiaTipTra.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConvHsPDiaTipTra.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConvHsPDiaTipTra.setValue( GXutil.rtrim( A1326ConvHsPDiaTipTra) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConvHsPDiaTipTra.getInternalname(), "Values", cmbConvHsPDiaTipTra.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConveHsPDiaDia.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConveHsPDiaDia.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVEHSPDIADIA_" + sGXsfl_110_idx ;
            cmbConveHsPDiaDia.setName( GXCCtl );
            cmbConveHsPDiaDia.setWebtags( "" );
            cmbConveHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
            cmbConveHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
            if ( cmbConveHsPDiaDia.getItemCount() > 0 )
            {
               A1328ConveHsPDiaDia = (byte)(GXutil.lval( cmbConveHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveHsPDiaDia,cmbConveHsPDiaDia.getInternalname(),GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)),Integer.valueOf(1),cmbConveHsPDiaDia.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConveHsPDiaDia.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConveHsPDiaDia.setValue( GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveHsPDiaDia.getInternalname(), "Values", cmbConveHsPDiaDia.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConveHsPDiaDesde_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsPDiaDesde_Internalname,GXutil.rtrim( A1329ConveHsPDiaDesde),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsPDiaDesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveHsPDiaDesde_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveTarifaPDia_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveTarifaPDia_Internalname,GXutil.ltrim( localUtil.ntoc( A1330ConveTarifaPDia, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1330ConveTarifaPDia, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveTarifaPDia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveTarifaPDia_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveTarifaPDRec_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveTarifaPDRec_Internalname,GXutil.ltrim( localUtil.ntoc( A1350ConveTarifaPDRec, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1350ConveTarifaPDRec, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveTarifaPDRec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveTarifaPDRec_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConveTarifaPDCri.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConveTarifaPDCri.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVETARIFAPDCRI_" + sGXsfl_110_idx ;
            cmbConveTarifaPDCri.setName( GXCCtl );
            cmbConveTarifaPDCri.setWebtags( "" );
            cmbConveTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
            cmbConveTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
            if ( cmbConveTarifaPDCri.getItemCount() > 0 )
            {
               A2432ConveTarifaPDCri = cmbConveTarifaPDCri.getValidValue(A2432ConveTarifaPDCri) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveTarifaPDCri,cmbConveTarifaPDCri.getInternalname(),GXutil.rtrim( A2432ConveTarifaPDCri),Integer.valueOf(1),cmbConveTarifaPDCri.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConveTarifaPDCri.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConveTarifaPDCri.setValue( GXutil.rtrim( A2432ConveTarifaPDCri) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveTarifaPDCri.getInternalname(), "Values", cmbConveTarifaPDCri.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConveHsPdiaRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveHsPdiaRelRef_Internalname,A2067ConveHsPdiaRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveHsPdiaRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtConveHsPdiaRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV40Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV42Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV54Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV51VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV52ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV53EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesFD2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_110_idx = ((subGrid_Islastpage==1)&&(nGXsfl_110_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_110_idx+1) ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
      }
      /* End function sendrow_1102 */
   }

   public void startgridcontrol110( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"110\">") ;
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
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsExSec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Secuencial", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConvHsPDiaTipTra.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo de trabajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConveHsPDiaDia.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Día", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsPDiaDesde_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Hora desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveTarifaPDia_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Aumento de horas extras sobre hora normal", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveTarifaPDRec_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Recargo a hora normal diurna", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConveTarifaPDCri.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Criterio", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveHsPdiaRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liberación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1565CliConvenio));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1327ConveHsExSec, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsExSec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1326ConvHsPDiaTipTra));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConvHsPDiaTipTra.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1328ConveHsPDiaDia, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConveHsPDiaDia.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1329ConveHsPDiaDesde));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsPDiaDesde_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1330ConveTarifaPDia, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveTarifaPDia_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1350ConveTarifaPDRec, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveTarifaPDRec_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A2432ConveTarifaPDCri));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConveTarifaPDCri.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2067ConveHsPdiaRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveHsPdiaRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV40Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV42Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV54Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV52ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV53EliminarSVG));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavEliminarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavEliminarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
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
      bttBtninsert_Internalname = "BTNINSERT" ;
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
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      edtConveHsExSec_Internalname = "CONVEHSEXSEC" ;
      cmbConvHsPDiaTipTra.setInternalname( "CONVHSPDIATIPTRA" );
      cmbConveHsPDiaDia.setInternalname( "CONVEHSPDIADIA" );
      edtConveHsPDiaDesde_Internalname = "CONVEHSPDIADESDE" ;
      edtConveTarifaPDia_Internalname = "CONVETARIFAPDIA" ;
      edtConveTarifaPDRec_Internalname = "CONVETARIFAPDREC" ;
      cmbConveTarifaPDCri.setInternalname( "CONVETARIFAPDCRI" );
      edtConveHsPdiaRelRef_Internalname = "CONVEHSPDIARELREF" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavVersvg_Internalname = "vVERSVG" ;
      edtavModificarsvg_Internalname = "vMODIFICARSVG" ;
      edtavEliminarsvg_Internalname = "vELIMINARSVG" ;
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
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Enabled = 0 ;
      edtavDisplay_Visible = -1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Enabled = 0 ;
      edtConveHsPdiaRelRef_Jsonclick = "" ;
      cmbConveTarifaPDCri.setJsonclick( "" );
      edtConveTarifaPDRec_Jsonclick = "" ;
      edtConveTarifaPDia_Jsonclick = "" ;
      edtConveHsPDiaDesde_Jsonclick = "" ;
      cmbConveHsPDiaDia.setJsonclick( "" );
      cmbConvHsPDiaTipTra.setJsonclick( "" );
      edtConveHsExSec_Jsonclick = "" ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      lblCouttext_Visible = 1 ;
      divButtonfilter1_tablecontent_Visible = 1 ;
      bttBtnexport_Visible = 1 ;
      bttBtninsert_Visible = 1 ;
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
      edtConveHsPdiaRelRef_Visible = -1 ;
      cmbConveTarifaPDCri.setVisible( -1 );
      edtConveTarifaPDRec_Visible = -1 ;
      edtConveTarifaPDia_Visible = -1 ;
      edtConveHsPDiaDesde_Visible = -1 ;
      cmbConveHsPDiaDia.setVisible( -1 );
      cmbConvHsPDiaTipTra.setVisible( -1 );
      edtConveHsExSec_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "4.0||||6.4|6.4||" ;
      Ddo_grid_Datalistproc = "Convenio_horasextras_porDiaWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|diurno:Diurno,nocturno:Nocturno,insalubre:Insalubre|1:Domingo,2:Lunes,3:Martes,4:Miércoles,5:Jueves,6:Viernes,7:Sábado,8:Feriado,9:Día hábil no especificado||||exceso:Por exceder las horas normales,horario:Por fecha y horario determinado|" ;
      Ddo_grid_Allowmultipleselection = "|T|T|T|||T|T" ;
      Ddo_grid_Datalisttype = "|FixedValues|FixedValues|Dynamic|||FixedValues|Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T|T|||T|T" ;
      Ddo_grid_Filterisrange = "T||||T|T||" ;
      Ddo_grid_Filtertype = "Numeric|||Character|Numeric|Numeric||Character" ;
      Ddo_grid_Includefilter = "T|||T|T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8" ;
      Ddo_grid_Columnids = "3:ConveHsExSec|4:ConvHsPDiaTipTra|5:ConveHsPDiaDia|6:ConveHsPDiaDesde|7:ConveTarifaPDia|8:ConveTarifaPDRec|9:ConveTarifaPDCri|10:ConveHsPdiaRelRef" ;
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
      Form.setCaption( httpContext.getMessage( " Convenio_horasextras_por Dia", "") );
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
      AV57WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV57WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57WelcomeMessage_NoMostrarMas", AV57WelcomeMessage_NoMostrarMas);
      GXCCtl = "CONVHSPDIATIPTRA_" + sGXsfl_110_idx ;
      cmbConvHsPDiaTipTra.setName( GXCCtl );
      cmbConvHsPDiaTipTra.setWebtags( "" );
      cmbConvHsPDiaTipTra.addItem("diurno", httpContext.getMessage( "Diurno", ""), (short)(0));
      cmbConvHsPDiaTipTra.addItem("nocturno", httpContext.getMessage( "Nocturno", ""), (short)(0));
      cmbConvHsPDiaTipTra.addItem("insalubre", httpContext.getMessage( "Insalubre", ""), (short)(0));
      if ( cmbConvHsPDiaTipTra.getItemCount() > 0 )
      {
         A1326ConvHsPDiaTipTra = cmbConvHsPDiaTipTra.getValidValue(A1326ConvHsPDiaTipTra) ;
      }
      GXCCtl = "CONVEHSPDIADIA_" + sGXsfl_110_idx ;
      cmbConveHsPDiaDia.setName( GXCCtl );
      cmbConveHsPDiaDia.setWebtags( "" );
      cmbConveHsPDiaDia.addItem("1", httpContext.getMessage( "Domingo", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("2", httpContext.getMessage( "Lunes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("3", httpContext.getMessage( "Martes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("4", httpContext.getMessage( "Miércoles", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("5", httpContext.getMessage( "Jueves", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("6", httpContext.getMessage( "Viernes", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("7", httpContext.getMessage( "Sábado", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("8", httpContext.getMessage( "Feriado", ""), (short)(0));
      cmbConveHsPDiaDia.addItem("9", httpContext.getMessage( "Día hábil no especificado", ""), (short)(0));
      if ( cmbConveHsPDiaDia.getItemCount() > 0 )
      {
         A1328ConveHsPDiaDia = (byte)(GXutil.lval( cmbConveHsPDiaDia.getValidValue(GXutil.trim( GXutil.str( A1328ConveHsPDiaDia, 1, 0))))) ;
      }
      GXCCtl = "CONVETARIFAPDCRI_" + sGXsfl_110_idx ;
      cmbConveTarifaPDCri.setName( GXCCtl );
      cmbConveTarifaPDCri.setWebtags( "" );
      cmbConveTarifaPDCri.addItem("exceso", httpContext.getMessage( "Por exceder las horas normales", ""), (short)(0));
      cmbConveTarifaPDCri.addItem("horario", httpContext.getMessage( "Por fecha y horario determinado", ""), (short)(0));
      if ( cmbConveTarifaPDCri.getItemCount() > 0 )
      {
         A2432ConveTarifaPDCri = cmbConveTarifaPDCri.getValidValue(A2432ConveTarifaPDCri) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConveHsExSec_Visible',ctrl:'CONVEHSEXSEC',prop:'Visible'},{av:'cmbConvHsPDiaTipTra'},{av:'cmbConveHsPDiaDia'},{av:'edtConveHsPDiaDesde_Visible',ctrl:'CONVEHSPDIADESDE',prop:'Visible'},{av:'edtConveTarifaPDia_Visible',ctrl:'CONVETARIFAPDIA',prop:'Visible'},{av:'edtConveTarifaPDRec_Visible',ctrl:'CONVETARIFAPDREC',prop:'Visible'},{av:'cmbConveTarifaPDCri'},{av:'edtConveHsPdiaRelRef_Visible',ctrl:'CONVEHSPDIARELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV37GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV38GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV39GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV69ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13FD2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14FD2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15FD2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV64TFConveHsPdiaRelRef_SelsJson',fld:'vTFCONVEHSPDIARELREF_SELSJSON',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV82TFConveTarifaPDCri_SelsJson',fld:'vTFCONVETARIFAPDCRI_SELSJSON',pic:''},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV28TFConveHsPDiaDesde_SelsJson',fld:'vTFCONVEHSPDIADESDE_SELSJSON',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV26TFConveHsPDiaDia_SelsJson',fld:'vTFCONVEHSPDIADIA_SELSJSON',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV24TFConvHsPDiaTipTra_SelsJson',fld:'vTFCONVHSPDIATIPTRA_SELSJSON',pic:''},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20FD2',iparms:[{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'A1327ConveHsExSec',fld:'CONVEHSEXSEC',pic:'ZZZ9'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV40Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV42Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV54Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV51VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV52ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV53EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11FD2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtConveHsExSec_Visible',ctrl:'CONVEHSEXSEC',prop:'Visible'},{av:'cmbConvHsPDiaTipTra'},{av:'cmbConveHsPDiaDia'},{av:'edtConveHsPDiaDesde_Visible',ctrl:'CONVEHSPDIADESDE',prop:'Visible'},{av:'edtConveTarifaPDia_Visible',ctrl:'CONVETARIFAPDIA',prop:'Visible'},{av:'edtConveTarifaPDRec_Visible',ctrl:'CONVETARIFAPDREC',prop:'Visible'},{av:'cmbConveTarifaPDCri'},{av:'edtConveHsPdiaRelRef_Visible',ctrl:'CONVEHSPDIARELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV37GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV38GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV39GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV69ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12FD2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV87Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV24TFConvHsPDiaTipTra_SelsJson',fld:'vTFCONVHSPDIATIPTRA_SELSJSON',pic:''},{av:'AV26TFConveHsPDiaDia_SelsJson',fld:'vTFCONVEHSPDIADIA_SELSJSON',pic:''},{av:'AV28TFConveHsPDiaDesde_SelsJson',fld:'vTFCONVEHSPDIADESDE_SELSJSON',pic:''},{av:'AV82TFConveTarifaPDCri_SelsJson',fld:'vTFCONVETARIFAPDCRI_SELSJSON',pic:''},{av:'AV64TFConveHsPdiaRelRef_SelsJson',fld:'vTFCONVEHSPDIARELREF_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV71ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV12GridState',fld:'vGRIDSTATE',pic:''},{av:'AV14OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV15OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV22TFConveHsExSec',fld:'vTFCONVEHSEXSEC',pic:'ZZZ9'},{av:'AV23TFConveHsExSec_To',fld:'vTFCONVEHSEXSEC_TO',pic:'ZZZ9'},{av:'AV25TFConvHsPDiaTipTra_Sels',fld:'vTFCONVHSPDIATIPTRA_SELS',pic:''},{av:'AV27TFConveHsPDiaDia_Sels',fld:'vTFCONVEHSPDIADIA_SELS',pic:''},{av:'AV29TFConveHsPDiaDesde',fld:'vTFCONVEHSPDIADESDE',pic:''},{av:'AV30TFConveHsPDiaDesde_Sels',fld:'vTFCONVEHSPDIADESDE_SELS',pic:''},{av:'AV31TFConveTarifaPDia',fld:'vTFCONVETARIFAPDIA',pic:'9.9999'},{av:'AV32TFConveTarifaPDia_To',fld:'vTFCONVETARIFAPDIA_TO',pic:'9.9999'},{av:'AV33TFConveTarifaPDRec',fld:'vTFCONVETARIFAPDREC',pic:'9.9999'},{av:'AV34TFConveTarifaPDRec_To',fld:'vTFCONVETARIFAPDREC_TO',pic:'9.9999'},{av:'AV83TFConveTarifaPDCri_Sels',fld:'vTFCONVETARIFAPDCRI_SELS',pic:''},{av:'AV65TFConveHsPdiaRelRef',fld:'vTFCONVEHSPDIARELREF',pic:''},{av:'AV66TFConveHsPdiaRelRef_Sels',fld:'vTFCONVEHSPDIARELREF_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV64TFConveHsPdiaRelRef_SelsJson',fld:'vTFCONVEHSPDIARELREF_SELSJSON',pic:''},{av:'AV82TFConveTarifaPDCri_SelsJson',fld:'vTFCONVETARIFAPDCRI_SELSJSON',pic:''},{av:'AV28TFConveHsPDiaDesde_SelsJson',fld:'vTFCONVEHSPDIADESDE_SELSJSON',pic:''},{av:'AV26TFConveHsPDiaDia_SelsJson',fld:'vTFCONVEHSPDIADIA_SELSJSON',pic:''},{av:'AV24TFConvHsPDiaTipTra_SelsJson',fld:'vTFCONVHSPDIATIPTRA_SELSJSON',pic:''},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV19ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConveHsExSec_Visible',ctrl:'CONVEHSEXSEC',prop:'Visible'},{av:'cmbConvHsPDiaTipTra'},{av:'cmbConveHsPDiaDia'},{av:'edtConveHsPDiaDesde_Visible',ctrl:'CONVEHSPDIADESDE',prop:'Visible'},{av:'edtConveTarifaPDia_Visible',ctrl:'CONVETARIFAPDIA',prop:'Visible'},{av:'edtConveTarifaPDRec_Visible',ctrl:'CONVETARIFAPDREC',prop:'Visible'},{av:'cmbConveTarifaPDCri'},{av:'edtConveHsPdiaRelRef_Visible',ctrl:'CONVEHSPDIARELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV37GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV38GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV39GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV49ConveCodigo',fld:'vCONVECODIGO',pic:''},{av:'AV41IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV43IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV69ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e22FD1',iparms:[{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV47PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV48CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16FD2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17FD2',iparms:[{av:'AV57WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV55MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV45CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21FD1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Eliminarsvg',iparms:[]");
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
      wcpOAV55MenuOpcCod = "" ;
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
      AV55MenuOpcCod = "" ;
      AV49ConveCodigo = "" ;
      AV19ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV87Pgmname = "" ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25TFConvHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27TFConveHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV29TFConveHsPDiaDesde = "" ;
      AV30TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFConveTarifaPDia = DecimalUtil.ZERO ;
      AV32TFConveTarifaPDia_To = DecimalUtil.ZERO ;
      AV33TFConveTarifaPDRec = DecimalUtil.ZERO ;
      AV34TFConveTarifaPDRec_To = DecimalUtil.ZERO ;
      AV83TFConveTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65TFConveHsPdiaRelRef = "" ;
      AV66TFConveHsPdiaRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48CliConvenio = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV35DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV69ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV39GridAppliedFilters = "" ;
      AV24TFConvHsPDiaTipTra_SelsJson = "" ;
      AV26TFConveHsPDiaDia_SelsJson = "" ;
      AV28TFConveHsPDiaDesde_SelsJson = "" ;
      AV82TFConveTarifaPDCri_SelsJson = "" ;
      AV64TFConveHsPdiaRelRef_SelsJson = "" ;
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
      A1565CliConvenio = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A2432ConveTarifaPDCri = "" ;
      A2067ConveHsPdiaRelRef = "" ;
      AV40Update = "" ;
      AV42Delete = "" ;
      AV54Display = "" ;
      AV51VerSVG = "" ;
      AV52ModificarSVG = "" ;
      AV53EliminarSVG = "" ;
      AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = "" ;
      lV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = "" ;
      AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = "" ;
      AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = DecimalUtil.ZERO ;
      AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = DecimalUtil.ZERO ;
      AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = DecimalUtil.ZERO ;
      AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = DecimalUtil.ZERO ;
      AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = "" ;
      H00FD2_A2067ConveHsPdiaRelRef = new String[] {""} ;
      H00FD2_A2432ConveTarifaPDCri = new String[] {""} ;
      H00FD2_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FD2_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00FD2_A1329ConveHsPDiaDesde = new String[] {""} ;
      H00FD2_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      H00FD2_A1328ConveHsPDiaDia = new byte[1] ;
      H00FD2_A1326ConvHsPDiaTipTra = new String[] {""} ;
      H00FD2_A1327ConveHsExSec = new short[1] ;
      H00FD2_A1565CliConvenio = new String[] {""} ;
      H00FD2_A1564CliPaiConve = new short[1] ;
      H00FD2_A3CliCod = new int[1] ;
      H00FD3_AGRID_nRecordCount = new long[1] ;
      AV63WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV9HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV58MenuBienveImgURL = "" ;
      AV60MenuBienveTitulo = "" ;
      AV61MenuBienveTexto = "" ;
      AV86Welcomemessage_foto_GXI = "" ;
      AV80observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int2 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext13 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV17ColumnsSelectorXML = "" ;
      AV76MenuOpcTitulo = "" ;
      GXv_int12 = new short[1] ;
      AV79filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV70ManageFiltersXml = "" ;
      AV67ExcelFilename = "" ;
      AV68ErrorMessage = "" ;
      AV18UserCustomValue = "" ;
      AV20ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector15 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char11 = "" ;
      GXt_char10 = "" ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXt_char19 = "" ;
      GXt_char18 = "" ;
      GXv_char9 = new String[1] ;
      GXv_SdtWWPGridState21 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV59textoNoMostrara = "" ;
      GXv_char20 = new String[1] ;
      GXv_boolean4 = new boolean[1] ;
      lblWelcomemessage_closehelp_Jsonclick = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      lblWelcomemessage_combotext_Jsonclick = "" ;
      lblButtonexport1_textblock_svg_Jsonclick = "" ;
      lblButtonexport1_textblock_texto_Jsonclick = "" ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      bttBtninsert_Jsonclick = "" ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_horasextras_pordiaww__default(),
         new Object[] {
             new Object[] {
            H00FD2_A2067ConveHsPdiaRelRef, H00FD2_A2432ConveTarifaPDCri, H00FD2_A1350ConveTarifaPDRec, H00FD2_A1330ConveTarifaPDia, H00FD2_A1329ConveHsPDiaDesde, H00FD2_n1329ConveHsPDiaDesde, H00FD2_A1328ConveHsPDiaDia, H00FD2_A1326ConvHsPDiaTipTra, H00FD2_A1327ConveHsExSec, H00FD2_A1565CliConvenio,
            H00FD2_A1564CliPaiConve, H00FD2_A3CliCod
            }
            , new Object[] {
            H00FD3_AGRID_nRecordCount
            }
         }
      );
      AV87Pgmname = "Convenio_horasextras_porDiaWW" ;
      /* GeneXus formulas. */
      AV87Pgmname = "Convenio_horasextras_porDiaWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV71ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte A1328ConveHsPDiaDia ;
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
   private short AV47PaiCod ;
   private short AV22TFConveHsExSec ;
   private short AV23TFConveHsExSec_To ;
   private short AV14OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec ;
   private short AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ;
   private short GXv_int12[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV45CliCod ;
   private int Gridpaginationbar_Pagestoshow ;
   private int A3CliCod ;
   private int subGrid_Islastpage ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDisplay_Enabled ;
   private int edtavVersvg_Enabled ;
   private int edtavModificarsvg_Enabled ;
   private int edtavEliminarsvg_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ;
   private int AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ;
   private int AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ;
   private int AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ;
   private int AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int edtConveHsExSec_Visible ;
   private int edtConveHsPDiaDesde_Visible ;
   private int edtConveTarifaPDia_Visible ;
   private int edtConveTarifaPDRec_Visible ;
   private int edtConveHsPdiaRelRef_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV78filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV36PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV101GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV37GridCurrentPage ;
   private long AV38GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV31TFConveTarifaPDia ;
   private java.math.BigDecimal AV32TFConveTarifaPDia_To ;
   private java.math.BigDecimal AV33TFConveTarifaPDRec ;
   private java.math.BigDecimal AV34TFConveTarifaPDRec_To ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private java.math.BigDecimal AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ;
   private java.math.BigDecimal AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ;
   private java.math.BigDecimal AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ;
   private java.math.BigDecimal AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ;
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
   private String sGXsfl_110_idx="0001" ;
   private String AV49ConveCodigo ;
   private String AV87Pgmname ;
   private String AV29TFConveHsPDiaDesde ;
   private String AV48CliConvenio ;
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
   private String edtCliCod_Internalname ;
   private String edtCliPaiConve_Internalname ;
   private String A1565CliConvenio ;
   private String edtCliConvenio_Internalname ;
   private String edtConveHsExSec_Internalname ;
   private String A1326ConvHsPDiaTipTra ;
   private String A1329ConveHsPDiaDesde ;
   private String edtConveHsPDiaDesde_Internalname ;
   private String edtConveTarifaPDia_Internalname ;
   private String edtConveTarifaPDRec_Internalname ;
   private String A2432ConveTarifaPDCri ;
   private String edtConveHsPdiaRelRef_Internalname ;
   private String AV40Update ;
   private String edtavUpdate_Internalname ;
   private String AV42Delete ;
   private String edtavDelete_Internalname ;
   private String AV54Display ;
   private String edtavDisplay_Internalname ;
   private String AV51VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV52ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV53EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String lV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ;
   private String AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ;
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
   private String AV80observerPalabra ;
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
   private String edtavDelete_Link ;
   private String edtavDisplay_Link ;
   private String edtavVersvg_Link ;
   private String edtavVersvg_Columnclass ;
   private String edtavModificarsvg_Link ;
   private String edtavModificarsvg_Columnclass ;
   private String edtavEliminarsvg_Link ;
   private String bttBtninsert_Internalname ;
   private String GXt_char11 ;
   private String GXt_char10 ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String GXt_char19 ;
   private String GXt_char18 ;
   private String GXv_char9[] ;
   private String GXv_char20[] ;
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
   private String tblTablefiltros_Internalname ;
   private String divButtonexport1_table_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Internalname ;
   private String lblButtonexport1_textblock_svg_Jsonclick ;
   private String divButtonexport1_table_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Internalname ;
   private String lblButtonexport1_textblock_texto_Jsonclick ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String bttBtninsert_Jsonclick ;
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
   private String sGXsfl_110_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Jsonclick ;
   private String edtConveHsExSec_Jsonclick ;
   private String GXCCtl ;
   private String edtConveHsPDiaDesde_Jsonclick ;
   private String edtConveTarifaPDia_Jsonclick ;
   private String edtConveTarifaPDRec_Jsonclick ;
   private String edtConveHsPdiaRelRef_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV15OrderedDsc ;
   private boolean AV41IsAuthorized_Update ;
   private boolean AV43IsAuthorized_Delete ;
   private boolean AV57WelcomeMessage_NoMostrarMas ;
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
   private boolean n1329ConveHsPDiaDesde ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV81IsAuthorized_ConveHsPDiaDia ;
   private boolean AV62MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean AV44TempBoolean ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean AV63WelcomeMessage_Foto_IsBlob ;
   private String AV24TFConvHsPDiaTipTra_SelsJson ;
   private String AV26TFConveHsPDiaDia_SelsJson ;
   private String AV28TFConveHsPDiaDesde_SelsJson ;
   private String AV82TFConveTarifaPDCri_SelsJson ;
   private String AV64TFConveHsPdiaRelRef_SelsJson ;
   private String AV61MenuBienveTexto ;
   private String AV17ColumnsSelectorXML ;
   private String AV70ManageFiltersXml ;
   private String AV18UserCustomValue ;
   private String AV59textoNoMostrara ;
   private String wcpOAV55MenuOpcCod ;
   private String AV55MenuOpcCod ;
   private String AV65TFConveHsPdiaRelRef ;
   private String AV39GridAppliedFilters ;
   private String A2067ConveHsPdiaRelRef ;
   private String lV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ;
   private String AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ;
   private String AV58MenuBienveImgURL ;
   private String AV60MenuBienveTitulo ;
   private String AV86Welcomemessage_foto_GXI ;
   private String AV76MenuOpcTitulo ;
   private String AV79filtrosTexto ;
   private String AV67ExcelFilename ;
   private String AV68ErrorMessage ;
   private String AV63WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ;
   private GXSimpleCollection<Byte> AV27TFConveHsPDiaDia_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV9HTTPRequest ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ;
   private GXSimpleCollection<String> AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ;
   private GXSimpleCollection<String> AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ;
   private GXSimpleCollection<String> AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbConvHsPDiaTipTra ;
   private HTMLChoice cmbConveHsPDiaDia ;
   private HTMLChoice cmbConveTarifaPDCri ;
   private IDataStoreProvider pr_default ;
   private String[] H00FD2_A2067ConveHsPdiaRelRef ;
   private String[] H00FD2_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] H00FD2_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] H00FD2_A1330ConveTarifaPDia ;
   private String[] H00FD2_A1329ConveHsPDiaDesde ;
   private boolean[] H00FD2_n1329ConveHsPDiaDesde ;
   private byte[] H00FD2_A1328ConveHsPDiaDia ;
   private String[] H00FD2_A1326ConvHsPDiaTipTra ;
   private short[] H00FD2_A1327ConveHsExSec ;
   private String[] H00FD2_A1565CliConvenio ;
   private short[] H00FD2_A1564CliPaiConve ;
   private int[] H00FD2_A3CliCod ;
   private long[] H00FD3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV25TFConvHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV30TFConveHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV83TFConveTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV66TFConveHsPdiaRelRef_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV69ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext13[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState21[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV19ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector15[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV35DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
}

final  class convenio_horasextras_pordiaww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00FD2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                          String A2067ConveHsPdiaRelRef ,
                                          GXSimpleCollection<String> AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                          short AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec ,
                                          short AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ,
                                          int AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ,
                                          int AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ,
                                          int AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ,
                                          String AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                          java.math.BigDecimal AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                          int AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ,
                                          int AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ,
                                          String AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                          short A1327ConveHsExSec ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV45CliCod ,
                                          short AV47PaiCod ,
                                          String AV49ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[14];
      Object[] GXv_Object23 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ConveHsPdiaRelRef, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDesde, ConveHsPDiaDia, ConvHsPDiaTipTra, ConveHsExSec, CliConvenio, CliPaiConve," ;
      sSelectString += " CliCod" ;
      sFromString = " FROM Convenio_horasextras_porDia" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! (0==AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec) )
      {
         addWhere(sWhereString, "(ConveHsExSec >= ?)");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( ! (0==AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) )
      {
         addWhere(sWhereString, "(ConveHsExSec <= ?)");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPdiaRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels, "ConveHsPdiaRelRef IN (", ")")+")");
      }
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsExSec, CliCod, CliPaiConve, CliConvenio" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsExSec DESC, CliCod, CliPaiConve, CliConvenio" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConvHsPDiaTipTra, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 2 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConvHsPDiaTipTra DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsPDiaDia, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 3 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsPDiaDia DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsPDiaDesde, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 4 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsPDiaDesde DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveTarifaPDia, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 5 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveTarifaPDia DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveTarifaPDRec, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 6 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveTarifaPDRec DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveTarifaPDCri, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 7 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveTarifaPDCri DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ! AV15OrderedDsc )
      {
         sOrderString += " ORDER BY ConveHsPdiaRelRef, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( ( AV14OrderedBy == 8 ) && ( AV15OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveHsPdiaRelRef DESC, CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveHsExSec" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_H00FD3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                          String A2067ConveHsPdiaRelRef ,
                                          GXSimpleCollection<String> AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                          short AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec ,
                                          short AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ,
                                          int AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ,
                                          int AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ,
                                          int AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ,
                                          String AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                          java.math.BigDecimal AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                          int AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ,
                                          int AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ,
                                          String AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                          short A1327ConveHsExSec ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          short AV14OrderedBy ,
                                          boolean AV15OrderedDsc ,
                                          int AV45CliCod ,
                                          short AV47PaiCod ,
                                          String AV49ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[11];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ! (0==AV88Convenio_horasextras_pordiawwds_1_tfconvehsexsec) )
      {
         addWhere(sWhereString, "(ConveHsExSec >= ?)");
      }
      else
      {
         GXv_int25[3] = (byte)(1) ;
      }
      if ( ! (0==AV89Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) )
      {
         addWhere(sWhereString, "(ConveHsExSec <= ?)");
      }
      else
      {
         GXv_int25[4] = (byte)(1) ;
      }
      if ( AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int25[5] = (byte)(1) ;
      }
      if ( AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Convenio_horasextras_pordiawwds_7_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int25[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV95Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int25[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV96Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int25[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV97Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int25[9] = (byte)(1) ;
      }
      if ( AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV98Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV99Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPdiaRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int25[10] = (byte)(1) ;
      }
      if ( AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels, "ConveHsPdiaRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV14OrderedBy == 1 ) && ! AV15OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV14OrderedBy == 1 ) && ( AV15OrderedDsc ) )
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
                  return conditional_H00FD2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).intValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] );
            case 1 :
                  return conditional_H00FD3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).shortValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).intValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() , (String)dynConstraints[33] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00FD2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00FD3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[4])[0] = rslt.getString(5, 5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((byte[]) buf[6])[0] = rslt.getByte(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
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
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 5);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 40);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[27]).intValue());
               }
               return;
            case 1 :
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
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 5);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 40);
               }
               return;
      }
   }

}

