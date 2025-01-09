package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_base_calculoww_impl extends GXDataArea
{
   public convenio_base_calculoww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_base_calculoww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_base_calculoww_impl.class ));
   }

   public convenio_base_calculoww_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavWelcomemessage_nomostrarmas = UIFactory.getCheckbox(this);
      cmbConveBaseClaseLeg = new HTMLChoice();
      cmbConveBaseTipo = new HTMLChoice();
      cmbConveLicDMes = new HTMLChoice();
      chkConveLicAdju = UIFactory.getCheckbox(this);
      chkConveLicAdjuObl = UIFactory.getCheckbox(this);
      chkConveLicNecAut = UIFactory.getCheckbox(this);
      chkConveLicIngMot = UIFactory.getCheckbox(this);
      chkConveLicMotObl = UIFactory.getCheckbox(this);
      cmbConveBasePromTCnt = new HTMLChoice();
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
            AV79MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV79MenuOpcCod", AV79MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79MenuOpcCod, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV8ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "ConveBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8ConveBaseClaseLeg", GXutil.str( AV8ConveBaseClaseLeg, 1, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8ConveBaseClaseLeg), "9")));
               AV9ConveBaseTipo = httpContext.GetPar( "ConveBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9ConveBaseTipo", AV9ConveBaseTipo);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveBaseTipo, ""))));
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_110 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_110"))) ;
      nGXsfl_110_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_110_idx"))) ;
      sGXsfl_110_idx = httpContext.GetPar( "sGXsfl_110_idx") ;
      edtConveBaseC2Txt_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC2Txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseC2Txt_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBaseC1Txt_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC1Txt_Internalname, "Title", edtConveBaseC1Txt_Title, !bGXsfl_110_Refreshing);
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
      AV71PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV72CliConvenio = httpContext.GetPar( "CliConvenio") ;
      AV95ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV20ColumnsSelector);
      AV108Pgmname = httpContext.GetPar( "Pgmname") ;
      AV79MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV13GridState);
      AV8ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "ConveBaseClaseLeg"))) ;
      AV9ConveBaseTipo = httpContext.GetPar( "ConveBaseTipo") ;
      AV35TFConveBasePlus = CommonUtil.decimalVal( httpContext.GetPar( "TFConveBasePlus"), ".") ;
      AV36TFConveBasePlus_To = CommonUtil.decimalVal( httpContext.GetPar( "TFConveBasePlus_To"), ".") ;
      AV37TFConveLicDLim = (short)(GXutil.lval( httpContext.GetPar( "TFConveLicDLim"))) ;
      AV38TFConveLicDLim_To = (short)(GXutil.lval( httpContext.GetPar( "TFConveLicDLim_To"))) ;
      AV39TFConveLicDSeman = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicDSeman"))) ;
      AV40TFConveLicDSeman_To = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicDSeman_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV42TFConveLicDMes_Sels);
      AV43TFConveLicDSemes = (short)(GXutil.lval( httpContext.GetPar( "TFConveLicDSemes"))) ;
      AV44TFConveLicDSemes_To = (short)(GXutil.lval( httpContext.GetPar( "TFConveLicDSemes_To"))) ;
      AV45TFConveLicDAnual = (short)(GXutil.lval( httpContext.GetPar( "TFConveLicDAnual"))) ;
      AV46TFConveLicDAnual_To = (short)(GXutil.lval( httpContext.GetPar( "TFConveLicDAnual_To"))) ;
      AV47TFConveLicAdju_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicAdju_Sel"))) ;
      AV48TFConveLicAdjuObl_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicAdjuObl_Sel"))) ;
      AV49TFConveLicNecAut_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicNecAut_Sel"))) ;
      AV50TFConveLicIngMot_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicIngMot_Sel"))) ;
      AV51TFConveLicMotObl_Sel = (byte)(GXutil.lval( httpContext.GetPar( "TFConveLicMotObl_Sel"))) ;
      AV52TFConveBasePromCnt1 = (short)(GXutil.lval( httpContext.GetPar( "TFConveBasePromCnt1"))) ;
      AV53TFConveBasePromCnt1_To = (short)(GXutil.lval( httpContext.GetPar( "TFConveBasePromCnt1_To"))) ;
      AV54TFConveBasePromCnt2 = (short)(GXutil.lval( httpContext.GetPar( "TFConveBasePromCnt2"))) ;
      AV55TFConveBasePromCnt2_To = (short)(GXutil.lval( httpContext.GetPar( "TFConveBasePromCnt2_To"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV57TFConveBasePromTCnt_Sels);
      AV89TFConveBaseRelRef = httpContext.GetPar( "TFConveBaseRelRef") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV90TFConveBaseRelRef_Sels);
      AV15OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV16OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV69CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      edtConveBaseC2Txt_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC2Txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseC2Txt_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBaseC1Txt_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC1Txt_Internalname, "Title", edtConveBaseC1Txt_Title, !bGXsfl_110_Refreshing);
      AV64IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV66IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV81WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.GetPar( "WelcomeMessage_NoMostrarMas")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV71PaiCod, AV72CliConvenio, AV95ManageFiltersExecutionStep, AV20ColumnsSelector, AV108Pgmname, AV79MenuOpcCod, AV13GridState, AV8ConveBaseClaseLeg, AV9ConveBaseTipo, AV35TFConveBasePlus, AV36TFConveBasePlus_To, AV37TFConveLicDLim, AV38TFConveLicDLim_To, AV39TFConveLicDSeman, AV40TFConveLicDSeman_To, AV42TFConveLicDMes_Sels, AV43TFConveLicDSemes, AV44TFConveLicDSemes_To, AV45TFConveLicDAnual, AV46TFConveLicDAnual_To, AV47TFConveLicAdju_Sel, AV48TFConveLicAdjuObl_Sel, AV49TFConveLicNecAut_Sel, AV50TFConveLicIngMot_Sel, AV51TFConveLicMotObl_Sel, AV52TFConveBasePromCnt1, AV53TFConveBasePromCnt1_To, AV54TFConveBasePromCnt2, AV55TFConveBasePromCnt2_To, AV57TFConveBasePromTCnt_Sels, AV89TFConveBaseRelRef, AV90TFConveBaseRelRef_Sels, AV15OrderedBy, AV16OrderedDsc, AV69CliCod, AV64IsAuthorized_Update, AV66IsAuthorized_Delete, AV81WelcomeMessage_NoMostrarMas) ;
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
      paEZ2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startEZ2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV79MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9ConveBaseTipo))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV108Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8ConveBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV66IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV71PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72CliConvenio, ""))));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV58DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV58DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCOLUMNSSELECTOR", AV20ColumnsSelector);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCOLUMNSSELECTOR", AV20ColumnsSelector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV93ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV93ManageFiltersData);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV60GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV61GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV62GridAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV95ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV108Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV108Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV79MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79MenuOpcCod, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV13GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV13GridState);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV8ConveBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8ConveBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASETIPO", GXutil.rtrim( AV9ConveBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPLUS", GXutil.ltrim( localUtil.ntoc( AV35TFConveBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPLUS_TO", GXutil.ltrim( localUtil.ntoc( AV36TFConveBasePlus_To, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDLIM", GXutil.ltrim( localUtil.ntoc( AV37TFConveLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDLIM_TO", GXutil.ltrim( localUtil.ntoc( AV38TFConveLicDLim_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDSEMAN", GXutil.ltrim( localUtil.ntoc( AV39TFConveLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDSEMAN_TO", GXutil.ltrim( localUtil.ntoc( AV40TFConveLicDSeman_To, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVELICDMES_SELS", AV42TFConveLicDMes_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVELICDMES_SELS", AV42TFConveLicDMes_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDSEMES", GXutil.ltrim( localUtil.ntoc( AV43TFConveLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDSEMES_TO", GXutil.ltrim( localUtil.ntoc( AV44TFConveLicDSemes_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDANUAL", GXutil.ltrim( localUtil.ntoc( AV45TFConveLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDANUAL_TO", GXutil.ltrim( localUtil.ntoc( AV46TFConveLicDAnual_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICADJU_SEL", GXutil.ltrim( localUtil.ntoc( AV47TFConveLicAdju_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICADJUOBL_SEL", GXutil.ltrim( localUtil.ntoc( AV48TFConveLicAdjuObl_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICNECAUT_SEL", GXutil.ltrim( localUtil.ntoc( AV49TFConveLicNecAut_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICINGMOT_SEL", GXutil.ltrim( localUtil.ntoc( AV50TFConveLicIngMot_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICMOTOBL_SEL", GXutil.ltrim( localUtil.ntoc( AV51TFConveLicMotObl_Sel, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPROMCNT1", GXutil.ltrim( localUtil.ntoc( AV52TFConveBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPROMCNT1_TO", GXutil.ltrim( localUtil.ntoc( AV53TFConveBasePromCnt1_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPROMCNT2", GXutil.ltrim( localUtil.ntoc( AV54TFConveBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPROMCNT2_TO", GXutil.ltrim( localUtil.ntoc( AV55TFConveBasePromCnt2_To, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVEBASEPROMTCNT_SELS", AV57TFConveBasePromTCnt_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVEBASEPROMTCNT_SELS", AV57TFConveBasePromTCnt_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASERELREF", AV89TFConveBaseRelRef);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCONVEBASERELREF_SELS", AV90TFConveBaseRelRef_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCONVEBASERELREF_SELS", AV90TFConveBaseRelRef_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV15OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV16OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV69CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV64IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV66IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV66IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVELICDMES_SELSJSON", AV41TFConveLicDMes_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASEPROMTCNT_SELSJSON", AV56TFConveBasePromTCnt_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vTFCONVEBASERELREF_SELSJSON", AV88TFConveBaseRelRef_SelsJson);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV71PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV71PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV72CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72CliConvenio, ""))));
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
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEBASEC2TXT_Visible", GXutil.ltrim( localUtil.ntoc( edtConveBaseC2Txt_Visible, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEBASEC1TXT_Title", GXutil.rtrim( edtConveBaseC1Txt_Title));
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
         weEZ2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtEZ2( ) ;
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
      return formatLink("web.convenio_base_calculoww", new String[] {GXutil.URLEncode(GXutil.rtrim(AV79MenuOpcCod)),GXutil.URLEncode(GXutil.ltrimstr(AV8ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV9ConveBaseTipo))}, new String[] {"MenuOpcCod","ConveBaseClaseLeg","ConveBaseTipo"})  ;
   }

   public String getPgmname( )
   {
      return "Convenio_base_calculoWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Convenio_base_calculo", "") ;
   }

   public void wbEZ0( )
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
         wb_table1_9_EZ2( true) ;
      }
      else
      {
         wb_table1_9_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_EZ2e( boolean wbgen )
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
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV58DDO_TitleSettingsIcons);
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

   public void startEZ2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Convenio_base_calculo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupEZ0( ) ;
   }

   public void wsEZ2( )
   {
      startEZ2( ) ;
      evtEZ2( ) ;
   }

   public void evtEZ2( )
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
                           e11EZ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12EZ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13EZ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14EZ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15EZ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOEXPORT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoExport' */
                           e16EZ2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17EZ2 ();
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
                           cmbConveBaseClaseLeg.setName( cmbConveBaseClaseLeg.getInternalname() );
                           cmbConveBaseClaseLeg.setValue( httpContext.cgiGet( cmbConveBaseClaseLeg.getInternalname()) );
                           A1454ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveBaseClaseLeg.getInternalname()))) ;
                           cmbConveBaseTipo.setName( cmbConveBaseTipo.getInternalname() );
                           cmbConveBaseTipo.setValue( httpContext.cgiGet( cmbConveBaseTipo.getInternalname()) );
                           A1455ConveBaseTipo = httpContext.cgiGet( cmbConveBaseTipo.getInternalname()) ;
                           A1456ConveBaseCod1 = httpContext.cgiGet( edtConveBaseCod1_Internalname) ;
                           A1608ConveBaseC1Txt = httpContext.cgiGet( edtConveBaseC1Txt_Internalname) ;
                           A1457ConveBaseCod2 = httpContext.cgiGet( edtConveBaseCod2_Internalname) ;
                           A1609ConveBaseC2Txt = httpContext.cgiGet( edtConveBaseC2Txt_Internalname) ;
                           A1458ConveBasePlus = localUtil.ctond( httpContext.cgiGet( edtConveBasePlus_Internalname)) ;
                           A1610ConveLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1611ConveLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbConveLicDMes.setName( cmbConveLicDMes.getInternalname() );
                           cmbConveLicDMes.setValue( httpContext.cgiGet( cmbConveLicDMes.getInternalname()) );
                           A1612ConveLicDMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveLicDMes.getInternalname()))) ;
                           A1613ConveLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1614ConveLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1615ConveLicAdju = GXutil.strtobool( httpContext.cgiGet( chkConveLicAdju.getInternalname())) ;
                           A1616ConveLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkConveLicAdjuObl.getInternalname())) ;
                           A1617ConveLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkConveLicNecAut.getInternalname())) ;
                           A1618ConveLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkConveLicIngMot.getInternalname())) ;
                           A1619ConveLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkConveLicMotObl.getInternalname())) ;
                           A1465ConveBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1466ConveBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbConveBasePromTCnt.setName( cmbConveBasePromTCnt.getInternalname() );
                           cmbConveBasePromTCnt.setValue( httpContext.cgiGet( cmbConveBasePromTCnt.getInternalname()) );
                           A1467ConveBasePromTCnt = httpContext.cgiGet( cmbConveBasePromTCnt.getInternalname()) ;
                           A2061ConveBaseRelRef = httpContext.cgiGet( edtConveBaseRelRef_Internalname) ;
                           AV63Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV63Update);
                           AV65Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV65Delete);
                           AV78Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV78Display);
                           AV75VerSVG = httpContext.cgiGet( edtavVersvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV75VerSVG);
                           AV76ModificarSVG = httpContext.cgiGet( edtavModificarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV76ModificarSVG);
                           AV77EliminarSVG = httpContext.cgiGet( edtavEliminarsvg_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV77EliminarSVG);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e18EZ2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e19EZ2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20EZ2 ();
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

   public void weEZ2( )
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

   public void paEZ2( )
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
                                 short AV71PaiCod ,
                                 String AV72CliConvenio ,
                                 byte AV95ManageFiltersExecutionStep ,
                                 web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ,
                                 String AV108Pgmname ,
                                 String AV79MenuOpcCod ,
                                 web.wwpbaseobjects.SdtWWPGridState AV13GridState ,
                                 byte AV8ConveBaseClaseLeg ,
                                 String AV9ConveBaseTipo ,
                                 java.math.BigDecimal AV35TFConveBasePlus ,
                                 java.math.BigDecimal AV36TFConveBasePlus_To ,
                                 short AV37TFConveLicDLim ,
                                 short AV38TFConveLicDLim_To ,
                                 byte AV39TFConveLicDSeman ,
                                 byte AV40TFConveLicDSeman_To ,
                                 GXSimpleCollection<Byte> AV42TFConveLicDMes_Sels ,
                                 short AV43TFConveLicDSemes ,
                                 short AV44TFConveLicDSemes_To ,
                                 short AV45TFConveLicDAnual ,
                                 short AV46TFConveLicDAnual_To ,
                                 byte AV47TFConveLicAdju_Sel ,
                                 byte AV48TFConveLicAdjuObl_Sel ,
                                 byte AV49TFConveLicNecAut_Sel ,
                                 byte AV50TFConveLicIngMot_Sel ,
                                 byte AV51TFConveLicMotObl_Sel ,
                                 short AV52TFConveBasePromCnt1 ,
                                 short AV53TFConveBasePromCnt1_To ,
                                 short AV54TFConveBasePromCnt2 ,
                                 short AV55TFConveBasePromCnt2_To ,
                                 GXSimpleCollection<String> AV57TFConveBasePromTCnt_Sels ,
                                 String AV89TFConveBaseRelRef ,
                                 GXSimpleCollection<String> AV90TFConveBaseRelRef_Sels ,
                                 short AV15OrderedBy ,
                                 boolean AV16OrderedDsc ,
                                 int AV69CliCod ,
                                 boolean AV64IsAuthorized_Update ,
                                 boolean AV66IsAuthorized_Delete ,
                                 boolean AV81WelcomeMessage_NoMostrarMas )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e19EZ2 ();
      GRID_nCurrentRecord = 0 ;
      rfEZ2( ) ;
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
      AV81WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV81WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81WelcomeMessage_NoMostrarMas", AV81WelcomeMessage_NoMostrarMas);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfEZ2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV108Pgmname = "Convenio_base_calculoWW" ;
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

   public void rfEZ2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(110) ;
      /* Execute user event: Refresh */
      e19EZ2 ();
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
                                              Byte.valueOf(A1612ConveLicDMes) ,
                                              AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                              A1467ConveBasePromTCnt ,
                                              AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                              A2061ConveBaseRelRef ,
                                              AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                              AV111Convenio_base_calculowwds_3_tfconvebaseplus ,
                                              AV112Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                              Short.valueOf(AV113Convenio_base_calculowwds_5_tfconvelicdlim) ,
                                              Short.valueOf(AV114Convenio_base_calculowwds_6_tfconvelicdlim_to) ,
                                              Byte.valueOf(AV115Convenio_base_calculowwds_7_tfconvelicdseman) ,
                                              Byte.valueOf(AV116Convenio_base_calculowwds_8_tfconvelicdseman_to) ,
                                              Integer.valueOf(AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels.size()) ,
                                              Short.valueOf(AV118Convenio_base_calculowwds_10_tfconvelicdsemes) ,
                                              Short.valueOf(AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to) ,
                                              Short.valueOf(AV120Convenio_base_calculowwds_12_tfconvelicdanual) ,
                                              Short.valueOf(AV121Convenio_base_calculowwds_13_tfconvelicdanual_to) ,
                                              Byte.valueOf(AV122Convenio_base_calculowwds_14_tfconvelicadju_sel) ,
                                              Byte.valueOf(AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel) ,
                                              Byte.valueOf(AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel) ,
                                              Byte.valueOf(AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel) ,
                                              Byte.valueOf(AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel) ,
                                              Short.valueOf(AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1) ,
                                              Short.valueOf(AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) ,
                                              Short.valueOf(AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2) ,
                                              Short.valueOf(AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) ,
                                              Integer.valueOf(AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels.size()) ,
                                              Integer.valueOf(AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels.size()) ,
                                              AV132Convenio_base_calculowwds_24_tfconvebaserelref ,
                                              AV72CliConvenio ,
                                              A1458ConveBasePlus ,
                                              Short.valueOf(A1610ConveLicDLim) ,
                                              Byte.valueOf(A1611ConveLicDSeman) ,
                                              Short.valueOf(A1613ConveLicDSemes) ,
                                              Short.valueOf(A1614ConveLicDAnual) ,
                                              Boolean.valueOf(A1615ConveLicAdju) ,
                                              Boolean.valueOf(A1616ConveLicAdjuObl) ,
                                              Boolean.valueOf(A1617ConveLicNecAut) ,
                                              Boolean.valueOf(A1618ConveLicIngMot) ,
                                              Boolean.valueOf(A1619ConveLicMotObl) ,
                                              Short.valueOf(A1465ConveBasePromCnt1) ,
                                              Short.valueOf(A1466ConveBasePromCnt2) ,
                                              A1565CliConvenio ,
                                              Short.valueOf(AV15OrderedBy) ,
                                              Boolean.valueOf(AV16OrderedDsc) ,
                                              Byte.valueOf(A1454ConveBaseClaseLeg) ,
                                              Byte.valueOf(AV109Convenio_base_calculowwds_1_convebaseclaseleg) ,
                                              A1455ConveBaseTipo ,
                                              AV110Convenio_base_calculowwds_2_convebasetipo ,
                                              Integer.valueOf(AV69CliCod) ,
                                              Short.valueOf(AV71PaiCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BYTE,
                                              TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         lV132Convenio_base_calculowwds_24_tfconvebaserelref = GXutil.concat( GXutil.rtrim( AV132Convenio_base_calculowwds_24_tfconvebaserelref), "%", "") ;
         /* Using cursor H00EZ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV69CliCod), Short.valueOf(AV71PaiCod), Byte.valueOf(AV109Convenio_base_calculowwds_1_convebaseclaseleg), AV110Convenio_base_calculowwds_2_convebasetipo, AV111Convenio_base_calculowwds_3_tfconvebaseplus, AV112Convenio_base_calculowwds_4_tfconvebaseplus_to, Short.valueOf(AV113Convenio_base_calculowwds_5_tfconvelicdlim), Short.valueOf(AV114Convenio_base_calculowwds_6_tfconvelicdlim_to), Byte.valueOf(AV115Convenio_base_calculowwds_7_tfconvelicdseman), Byte.valueOf(AV116Convenio_base_calculowwds_8_tfconvelicdseman_to), Short.valueOf(AV118Convenio_base_calculowwds_10_tfconvelicdsemes), Short.valueOf(AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to), Short.valueOf(AV120Convenio_base_calculowwds_12_tfconvelicdanual), Short.valueOf(AV121Convenio_base_calculowwds_13_tfconvelicdanual_to), Short.valueOf(AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1), Short.valueOf(AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to), Short.valueOf(AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2), Short.valueOf(AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to), lV132Convenio_base_calculowwds_24_tfconvebaserelref, AV72CliConvenio, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_110_idx = 1 ;
         sGXsfl_110_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_110_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1102( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A2061ConveBaseRelRef = H00EZ2_A2061ConveBaseRelRef[0] ;
            A1467ConveBasePromTCnt = H00EZ2_A1467ConveBasePromTCnt[0] ;
            A1466ConveBasePromCnt2 = H00EZ2_A1466ConveBasePromCnt2[0] ;
            A1465ConveBasePromCnt1 = H00EZ2_A1465ConveBasePromCnt1[0] ;
            A1619ConveLicMotObl = H00EZ2_A1619ConveLicMotObl[0] ;
            A1618ConveLicIngMot = H00EZ2_A1618ConveLicIngMot[0] ;
            A1617ConveLicNecAut = H00EZ2_A1617ConveLicNecAut[0] ;
            A1616ConveLicAdjuObl = H00EZ2_A1616ConveLicAdjuObl[0] ;
            A1615ConveLicAdju = H00EZ2_A1615ConveLicAdju[0] ;
            A1614ConveLicDAnual = H00EZ2_A1614ConveLicDAnual[0] ;
            A1613ConveLicDSemes = H00EZ2_A1613ConveLicDSemes[0] ;
            A1612ConveLicDMes = H00EZ2_A1612ConveLicDMes[0] ;
            A1611ConveLicDSeman = H00EZ2_A1611ConveLicDSeman[0] ;
            A1610ConveLicDLim = H00EZ2_A1610ConveLicDLim[0] ;
            A1458ConveBasePlus = H00EZ2_A1458ConveBasePlus[0] ;
            A1457ConveBaseCod2 = H00EZ2_A1457ConveBaseCod2[0] ;
            A1454ConveBaseClaseLeg = H00EZ2_A1454ConveBaseClaseLeg[0] ;
            A1565CliConvenio = H00EZ2_A1565CliConvenio[0] ;
            A1564CliPaiConve = H00EZ2_A1564CliPaiConve[0] ;
            A1456ConveBaseCod1 = H00EZ2_A1456ConveBaseCod1[0] ;
            A1455ConveBaseTipo = H00EZ2_A1455ConveBaseTipo[0] ;
            A3CliCod = H00EZ2_A3CliCod[0] ;
            GXt_char1 = A1608ConveBaseC1Txt ;
            GXv_char2[0] = GXt_char1 ;
            new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char2) ;
            convenio_base_calculoww_impl.this.GXt_char1 = GXv_char2[0] ;
            A1608ConveBaseC1Txt = GXt_char1 ;
            e20EZ2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(110) ;
         wbEZ0( ) ;
      }
      bGXsfl_110_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesEZ2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV108Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV108Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV79MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV8ConveBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8ConveBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASETIPO", GXutil.rtrim( AV9ConveBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV69CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV64IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV66IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV66IsAuthorized_Delete));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV71PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV71PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV72CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72CliConvenio, ""))));
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
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Byte.valueOf(A1612ConveLicDMes) ,
                                           AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                           A1467ConveBasePromTCnt ,
                                           AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                           A2061ConveBaseRelRef ,
                                           AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                           AV111Convenio_base_calculowwds_3_tfconvebaseplus ,
                                           AV112Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                           Short.valueOf(AV113Convenio_base_calculowwds_5_tfconvelicdlim) ,
                                           Short.valueOf(AV114Convenio_base_calculowwds_6_tfconvelicdlim_to) ,
                                           Byte.valueOf(AV115Convenio_base_calculowwds_7_tfconvelicdseman) ,
                                           Byte.valueOf(AV116Convenio_base_calculowwds_8_tfconvelicdseman_to) ,
                                           Integer.valueOf(AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels.size()) ,
                                           Short.valueOf(AV118Convenio_base_calculowwds_10_tfconvelicdsemes) ,
                                           Short.valueOf(AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to) ,
                                           Short.valueOf(AV120Convenio_base_calculowwds_12_tfconvelicdanual) ,
                                           Short.valueOf(AV121Convenio_base_calculowwds_13_tfconvelicdanual_to) ,
                                           Byte.valueOf(AV122Convenio_base_calculowwds_14_tfconvelicadju_sel) ,
                                           Byte.valueOf(AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel) ,
                                           Byte.valueOf(AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel) ,
                                           Byte.valueOf(AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel) ,
                                           Byte.valueOf(AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel) ,
                                           Short.valueOf(AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1) ,
                                           Short.valueOf(AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) ,
                                           Short.valueOf(AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2) ,
                                           Short.valueOf(AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) ,
                                           Integer.valueOf(AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels.size()) ,
                                           Integer.valueOf(AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels.size()) ,
                                           AV132Convenio_base_calculowwds_24_tfconvebaserelref ,
                                           AV72CliConvenio ,
                                           A1458ConveBasePlus ,
                                           Short.valueOf(A1610ConveLicDLim) ,
                                           Byte.valueOf(A1611ConveLicDSeman) ,
                                           Short.valueOf(A1613ConveLicDSemes) ,
                                           Short.valueOf(A1614ConveLicDAnual) ,
                                           Boolean.valueOf(A1615ConveLicAdju) ,
                                           Boolean.valueOf(A1616ConveLicAdjuObl) ,
                                           Boolean.valueOf(A1617ConveLicNecAut) ,
                                           Boolean.valueOf(A1618ConveLicIngMot) ,
                                           Boolean.valueOf(A1619ConveLicMotObl) ,
                                           Short.valueOf(A1465ConveBasePromCnt1) ,
                                           Short.valueOf(A1466ConveBasePromCnt2) ,
                                           A1565CliConvenio ,
                                           Short.valueOf(AV15OrderedBy) ,
                                           Boolean.valueOf(AV16OrderedDsc) ,
                                           Byte.valueOf(A1454ConveBaseClaseLeg) ,
                                           Byte.valueOf(AV109Convenio_base_calculowwds_1_convebaseclaseleg) ,
                                           A1455ConveBaseTipo ,
                                           AV110Convenio_base_calculowwds_2_convebasetipo ,
                                           Integer.valueOf(AV69CliCod) ,
                                           Short.valueOf(AV71PaiCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV132Convenio_base_calculowwds_24_tfconvebaserelref = GXutil.concat( GXutil.rtrim( AV132Convenio_base_calculowwds_24_tfconvebaserelref), "%", "") ;
      /* Using cursor H00EZ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV69CliCod), Short.valueOf(AV71PaiCod), Byte.valueOf(AV109Convenio_base_calculowwds_1_convebaseclaseleg), AV110Convenio_base_calculowwds_2_convebasetipo, AV111Convenio_base_calculowwds_3_tfconvebaseplus, AV112Convenio_base_calculowwds_4_tfconvebaseplus_to, Short.valueOf(AV113Convenio_base_calculowwds_5_tfconvelicdlim), Short.valueOf(AV114Convenio_base_calculowwds_6_tfconvelicdlim_to), Byte.valueOf(AV115Convenio_base_calculowwds_7_tfconvelicdseman), Byte.valueOf(AV116Convenio_base_calculowwds_8_tfconvelicdseman_to), Short.valueOf(AV118Convenio_base_calculowwds_10_tfconvelicdsemes), Short.valueOf(AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to), Short.valueOf(AV120Convenio_base_calculowwds_12_tfconvelicdanual), Short.valueOf(AV121Convenio_base_calculowwds_13_tfconvelicdanual_to), Short.valueOf(AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1), Short.valueOf(AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to), Short.valueOf(AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2), Short.valueOf(AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to), lV132Convenio_base_calculowwds_24_tfconvebaserelref, AV72CliConvenio});
      GRID_nRecordCount = H00EZ3_AGRID_nRecordCount[0] ;
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
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV71PaiCod, AV72CliConvenio, AV95ManageFiltersExecutionStep, AV20ColumnsSelector, AV108Pgmname, AV79MenuOpcCod, AV13GridState, AV8ConveBaseClaseLeg, AV9ConveBaseTipo, AV35TFConveBasePlus, AV36TFConveBasePlus_To, AV37TFConveLicDLim, AV38TFConveLicDLim_To, AV39TFConveLicDSeman, AV40TFConveLicDSeman_To, AV42TFConveLicDMes_Sels, AV43TFConveLicDSemes, AV44TFConveLicDSemes_To, AV45TFConveLicDAnual, AV46TFConveLicDAnual_To, AV47TFConveLicAdju_Sel, AV48TFConveLicAdjuObl_Sel, AV49TFConveLicNecAut_Sel, AV50TFConveLicIngMot_Sel, AV51TFConveLicMotObl_Sel, AV52TFConveBasePromCnt1, AV53TFConveBasePromCnt1_To, AV54TFConveBasePromCnt2, AV55TFConveBasePromCnt2_To, AV57TFConveBasePromTCnt_Sels, AV89TFConveBaseRelRef, AV90TFConveBaseRelRef_Sels, AV15OrderedBy, AV16OrderedDsc, AV69CliCod, AV64IsAuthorized_Update, AV66IsAuthorized_Delete, AV81WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV71PaiCod, AV72CliConvenio, AV95ManageFiltersExecutionStep, AV20ColumnsSelector, AV108Pgmname, AV79MenuOpcCod, AV13GridState, AV8ConveBaseClaseLeg, AV9ConveBaseTipo, AV35TFConveBasePlus, AV36TFConveBasePlus_To, AV37TFConveLicDLim, AV38TFConveLicDLim_To, AV39TFConveLicDSeman, AV40TFConveLicDSeman_To, AV42TFConveLicDMes_Sels, AV43TFConveLicDSemes, AV44TFConveLicDSemes_To, AV45TFConveLicDAnual, AV46TFConveLicDAnual_To, AV47TFConveLicAdju_Sel, AV48TFConveLicAdjuObl_Sel, AV49TFConveLicNecAut_Sel, AV50TFConveLicIngMot_Sel, AV51TFConveLicMotObl_Sel, AV52TFConveBasePromCnt1, AV53TFConveBasePromCnt1_To, AV54TFConveBasePromCnt2, AV55TFConveBasePromCnt2_To, AV57TFConveBasePromTCnt_Sels, AV89TFConveBaseRelRef, AV90TFConveBaseRelRef_Sels, AV15OrderedBy, AV16OrderedDsc, AV69CliCod, AV64IsAuthorized_Update, AV66IsAuthorized_Delete, AV81WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV71PaiCod, AV72CliConvenio, AV95ManageFiltersExecutionStep, AV20ColumnsSelector, AV108Pgmname, AV79MenuOpcCod, AV13GridState, AV8ConveBaseClaseLeg, AV9ConveBaseTipo, AV35TFConveBasePlus, AV36TFConveBasePlus_To, AV37TFConveLicDLim, AV38TFConveLicDLim_To, AV39TFConveLicDSeman, AV40TFConveLicDSeman_To, AV42TFConveLicDMes_Sels, AV43TFConveLicDSemes, AV44TFConveLicDSemes_To, AV45TFConveLicDAnual, AV46TFConveLicDAnual_To, AV47TFConveLicAdju_Sel, AV48TFConveLicAdjuObl_Sel, AV49TFConveLicNecAut_Sel, AV50TFConveLicIngMot_Sel, AV51TFConveLicMotObl_Sel, AV52TFConveBasePromCnt1, AV53TFConveBasePromCnt1_To, AV54TFConveBasePromCnt2, AV55TFConveBasePromCnt2_To, AV57TFConveBasePromTCnt_Sels, AV89TFConveBaseRelRef, AV90TFConveBaseRelRef_Sels, AV15OrderedBy, AV16OrderedDsc, AV69CliCod, AV64IsAuthorized_Update, AV66IsAuthorized_Delete, AV81WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV71PaiCod, AV72CliConvenio, AV95ManageFiltersExecutionStep, AV20ColumnsSelector, AV108Pgmname, AV79MenuOpcCod, AV13GridState, AV8ConveBaseClaseLeg, AV9ConveBaseTipo, AV35TFConveBasePlus, AV36TFConveBasePlus_To, AV37TFConveLicDLim, AV38TFConveLicDLim_To, AV39TFConveLicDSeman, AV40TFConveLicDSeman_To, AV42TFConveLicDMes_Sels, AV43TFConveLicDSemes, AV44TFConveLicDSemes_To, AV45TFConveLicDAnual, AV46TFConveLicDAnual_To, AV47TFConveLicAdju_Sel, AV48TFConveLicAdjuObl_Sel, AV49TFConveLicNecAut_Sel, AV50TFConveLicIngMot_Sel, AV51TFConveLicMotObl_Sel, AV52TFConveBasePromCnt1, AV53TFConveBasePromCnt1_To, AV54TFConveBasePromCnt2, AV55TFConveBasePromCnt2_To, AV57TFConveBasePromTCnt_Sels, AV89TFConveBaseRelRef, AV90TFConveBaseRelRef_Sels, AV15OrderedBy, AV16OrderedDsc, AV69CliCod, AV64IsAuthorized_Update, AV66IsAuthorized_Delete, AV81WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
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
         gxgrgrid_refresh( subGrid_Rows, AV71PaiCod, AV72CliConvenio, AV95ManageFiltersExecutionStep, AV20ColumnsSelector, AV108Pgmname, AV79MenuOpcCod, AV13GridState, AV8ConveBaseClaseLeg, AV9ConveBaseTipo, AV35TFConveBasePlus, AV36TFConveBasePlus_To, AV37TFConveLicDLim, AV38TFConveLicDLim_To, AV39TFConveLicDSeman, AV40TFConveLicDSeman_To, AV42TFConveLicDMes_Sels, AV43TFConveLicDSemes, AV44TFConveLicDSemes_To, AV45TFConveLicDAnual, AV46TFConveLicDAnual_To, AV47TFConveLicAdju_Sel, AV48TFConveLicAdjuObl_Sel, AV49TFConveLicNecAut_Sel, AV50TFConveLicIngMot_Sel, AV51TFConveLicMotObl_Sel, AV52TFConveBasePromCnt1, AV53TFConveBasePromCnt1_To, AV54TFConveBasePromCnt2, AV55TFConveBasePromCnt2_To, AV57TFConveBasePromTCnt_Sels, AV89TFConveBaseRelRef, AV90TFConveBaseRelRef_Sels, AV15OrderedBy, AV16OrderedDsc, AV69CliCod, AV64IsAuthorized_Update, AV66IsAuthorized_Delete, AV81WelcomeMessage_NoMostrarMas) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV108Pgmname = "Convenio_base_calculoWW" ;
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

   public void strupEZ0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e18EZ2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV58DDO_TitleSettingsIcons);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCOLUMNSSELECTOR"), AV20ColumnsSelector);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV93ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_110 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_110"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV60GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV61GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV62GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         AV9ConveBaseTipo = httpContext.cgiGet( "vCONVEBASETIPO") ;
         AV8ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "vCONVEBASECLASELEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV72CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
         AV71PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV69CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
         AV87WelcomeMessage_Foto = httpContext.cgiGet( imgavWelcomemessage_foto_Internalname) ;
         AV81WelcomeMessage_NoMostrarMas = GXutil.strtobool( httpContext.cgiGet( chkavWelcomemessage_nomostrarmas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV81WelcomeMessage_NoMostrarMas", AV81WelcomeMessage_NoMostrarMas);
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
      e18EZ2 ();
      if (returnInSub) return;
   }

   public void e18EZ2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( AV79MenuOpcCod, "", "") ;
      GXt_int3 = AV69CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_base_calculoww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV69CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69CliCod), "ZZZZZ9")));
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_gridcolumnsselector_Gridinternalname = subGrid_Internalname ;
      ucDdo_gridcolumnsselector.sendProperty(context, "", false, Ddo_gridcolumnsselector_Internalname, "GridInternalName", Ddo_gridcolumnsselector_Gridinternalname);
      if ( GXutil.strcmp(AV10HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Convenio_base_calculo", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV15OrderedBy < 1 )
      {
         AV15OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = AV58DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[0] ;
      AV58DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      GXv_char2[0] = AV82MenuBienveImgURL ;
      GXv_char7[0] = AV84MenuBienveTitulo ;
      GXv_char8[0] = AV85MenuBienveTexto ;
      GXv_boolean9[0] = AV86MenuBienveVisible ;
      new web.getpropscompbienvenida(remoteHandle, context).execute( AV79MenuOpcCod, GXv_char2, GXv_char7, GXv_char8, GXv_boolean9) ;
      convenio_base_calculoww_impl.this.AV82MenuBienveImgURL = GXv_char2[0] ;
      convenio_base_calculoww_impl.this.AV84MenuBienveTitulo = GXv_char7[0] ;
      convenio_base_calculoww_impl.this.AV85MenuBienveTexto = GXv_char8[0] ;
      convenio_base_calculoww_impl.this.AV86MenuBienveVisible = GXv_boolean9[0] ;
      divWelcomemessage_welcometableparent_Visible = (AV86MenuBienveVisible ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, divWelcomemessage_welcometableparent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divWelcomemessage_welcometableparent_Visible), 5, 0), true);
      if ( AV86MenuBienveVisible )
      {
         lblWelcomemessage_titulo_Caption = GXutil.trim( AV84MenuBienveTitulo) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_titulo_Internalname, "Caption", lblWelcomemessage_titulo_Caption, true);
         lblWelcomemessage_descripcion_Caption = GXutil.trim( AV85MenuBienveTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_descripcion_Internalname, "Caption", lblWelcomemessage_descripcion_Caption, true);
         AV87WelcomeMessage_Foto = AV82MenuBienveImgURL ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV87WelcomeMessage_Foto)==0) ? AV107Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV87WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV87WelcomeMessage_Foto), true);
         AV107Welcomemessage_foto_GXI = GXDbFile.pathToUrl( AV82MenuBienveImgURL, context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "Bitmap", ((GXutil.strcmp("", AV87WelcomeMessage_Foto)==0) ? AV107Welcomemessage_foto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV87WelcomeMessage_Foto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavWelcomemessage_foto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV87WelcomeMessage_Foto), true);
      }
      GXt_char1 = "" ;
      GXt_char10 = "" ;
      GXv_char8[0] = GXt_char10 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char1 ;
      new web.getsvg(remoteHandle, context).execute( GXt_char10, GXv_char7) ;
      convenio_base_calculoww_impl.this.GXt_char1 = GXv_char7[0] ;
      lblWelcomemessage_closehelp_Caption = GXt_char1 ;
      httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_closehelp_Internalname, "Caption", lblWelcomemessage_closehelp_Caption, true);
      AV104observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonexport1_a3lexport_Observer = AV104observerPalabra ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "observer", Buttonexport1_a3lexport_Observer);
      Buttonexport1_a3lexport_Boton_clon_id = divButtonexport1_tablecontentbuttonimport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_clon_id", Buttonexport1_a3lexport_Boton_clon_id);
      Buttonexport1_a3lexport_Boton_orig_id = bttBtnexport_Internalname ;
      ucButtonexport1_a3lexport.sendProperty(context, "", false, Buttonexport1_a3lexport_Internalname, "boton_orig_id", Buttonexport1_a3lexport_Boton_orig_id);
      bttBtnexport_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnexport_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnexport_Visible), 5, 0), true);
      AV104observerPalabra = httpContext.getMessage( "gx.onload", "") ;
      Buttonfilter1_a3lfilter_Observer = AV104observerPalabra ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "observer", Buttonfilter1_a3lfilter_Observer);
      Buttonfilter1_a3lfilter_A3l_filter_id = divButtonfilter1_tablecontent_Internalname ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "a3l_filter_id", Buttonfilter1_a3lfilter_A3l_filter_id);
      Buttonfilter1_a3lfilter_Filter_orig = httpContext.getMessage( "DDO_MANAGEFILTERSContainer_btnGroupDrop", "") ;
      ucButtonfilter1_a3lfilter.sendProperty(context, "", false, Buttonfilter1_a3lfilter_Internalname, "filter_orig", Buttonfilter1_a3lfilter_Filter_orig);
      divButtonfilter1_tablecontent_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divButtonfilter1_tablecontent_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divButtonfilter1_tablecontent_Visible), 5, 0), true);
      GXv_int11[0] = AV71PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV69CliCod, GXv_int11) ;
      convenio_base_calculoww_impl.this.AV71PaiCod = GXv_int11[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV71PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV71PaiCod), "ZZZ9")));
      GXv_char8[0] = AV72CliConvenio ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char8) ;
      convenio_base_calculoww_impl.this.AV72CliConvenio = GXv_char8[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72CliConvenio", AV72CliConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72CliConvenio, ""))));
      if ( GXutil.strcmp(AV9ConveBaseTipo, "feriado") != 0 )
      {
         edtConveBaseC2Txt_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC2Txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseC2Txt_Visible), 5, 0), !bGXsfl_110_Refreshing);
         if ( GXutil.strcmp(AV9ConveBaseTipo, "licencia") == 0 )
         {
            edtConveBaseC1Txt_Title = httpContext.getMessage( "Licencia", "") ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC1Txt_Internalname, "Title", edtConveBaseC1Txt_Title, !bGXsfl_110_Refreshing);
         }
      }
      else
      {
         edtConveBaseC1Txt_Title = httpContext.getMessage( "Tipo", "") ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC1Txt_Internalname, "Title", edtConveBaseC1Txt_Title, !bGXsfl_110_Refreshing);
      }
   }

   public void e19EZ2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int3 = AV69CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_base_calculoww_impl.this.GXt_int3 = GXv_int4[0] ;
      AV69CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV69CliCod), "ZZZZZ9")));
      GXv_SdtWWPContext12[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext12) ;
      AV6WWPContext = GXv_SdtWWPContext12[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV95ManageFiltersExecutionStep == 1 )
      {
         AV95ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95ManageFiltersExecutionStep", GXutil.str( AV95ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV95ManageFiltersExecutionStep == 2 )
      {
         AV95ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95ManageFiltersExecutionStep", GXutil.str( AV95ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV22Session.getValue("Convenio_base_calculoWWColumnsSelector"), "") != 0 )
      {
         AV18ColumnsSelectorXML = AV22Session.getValue("Convenio_base_calculoWWColumnsSelector") ;
         AV20ColumnsSelector.fromxml(AV18ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S172 ();
         if (returnInSub) return;
      }
      edtConveBaseC1Txt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC1Txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseC1Txt_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBaseC2Txt_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseC2Txt_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseC2Txt_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBasePlus_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePlus_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveLicDLim_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDLim_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveLicDSeman_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSeman_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConveLicDMes.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveLicDMes.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConveLicDSemes_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSemes_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveLicDAnual_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDAnual_Visible), 5, 0), !bGXsfl_110_Refreshing);
      chkConveLicAdju.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdju.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkConveLicAdjuObl.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdjuObl.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkConveLicNecAut.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicNecAut.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkConveLicIngMot.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicIngMot.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      chkConveLicMotObl.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+13)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicMotObl.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBasePromCnt1_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+14)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePromCnt1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePromCnt1_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBasePromCnt2_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+15)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePromCnt2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePromCnt2_Visible), 5, 0), !bGXsfl_110_Refreshing);
      cmbConveBasePromTCnt.setVisible( (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+16)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBasePromTCnt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveBasePromTCnt.getVisible(), 5, 0), !bGXsfl_110_Refreshing);
      edtConveBaseRelRef_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+17)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseRelRef_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseRelRef_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavVersvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+18)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavVersvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavModificarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+19)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModificarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModificarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      edtavEliminarsvg_Visible = (((web.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV20ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+20)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEliminarsvg_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEliminarsvg_Visible), 5, 0), !bGXsfl_110_Refreshing);
      AV60GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60GridCurrentPage), 10, 0));
      AV61GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61GridPageCount), 10, 0));
      GXt_char10 = AV62GridAppliedFilters ;
      GXv_char8[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV108Pgmname, GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      AV62GridAppliedFilters = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62GridAppliedFilters", AV62GridAppliedFilters);
      GXt_char10 = AV100MenuOpcTitulo ;
      GXv_char8[0] = GXt_char10 ;
      new web.gettxtcount(remoteHandle, context).execute( AV79MenuOpcCod, GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      AV100MenuOpcTitulo = GXt_char10 ;
      if ( (GXutil.strcmp("", AV100MenuOpcTitulo)==0) )
      {
         lblCouttext_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
      }
      else
      {
         lblCouttext_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCouttext_Visible), 5, 0), true);
         lblCouttext_Caption = ""+GXutil.trim( GXutil.str( subgrid_fnc_recordcount( ), 10, 0))+" "+GXutil.lower( GXutil.trim( AV100MenuOpcTitulo)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblCouttext_Internalname, "Caption", lblCouttext_Caption, true);
      }
      GXv_int11[0] = (short)(AV102filterCount) ;
      GXv_char8[0] = AV103filtrosTexto ;
      new web.getfiltercount(remoteHandle, context).execute( AV13GridState, GXv_int11, GXv_char8) ;
      convenio_base_calculoww_impl.this.AV102filterCount = GXv_int11[0] ;
      convenio_base_calculoww_impl.this.AV103filtrosTexto = GXv_char8[0] ;
      if ( AV102filterCount == 0 )
      {
         tblButtonfilter1_tablebadge_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
      }
      else
      {
         tblButtonfilter1_tablebadge_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblButtonfilter1_tablebadge_Visible), 5, 0), true);
         lblButtonfilter1_textblockbadgecount_Caption = GXutil.trim( GXutil.str( AV102filterCount, 6, 0)) ;
         httpContext.ajax_rsp_assign_prop("", false, lblButtonfilter1_textblockbadgecount_Internalname, "Caption", lblButtonfilter1_textblockbadgecount_Caption, true);
         tblButtonfilter1_tablebadge_Tooltiptext = GXutil.trim( AV103filtrosTexto) ;
         httpContext.ajax_rsp_assign_prop("", false, tblButtonfilter1_tablebadge_Internalname, "Tooltiptext", tblButtonfilter1_tablebadge_Tooltiptext, true);
      }
      GXv_char8[0] = AV72CliConvenio ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char8) ;
      convenio_base_calculoww_impl.this.AV72CliConvenio = GXv_char8[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72CliConvenio", AV72CliConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV72CliConvenio, ""))));
      AV109Convenio_base_calculowwds_1_convebaseclaseleg = AV8ConveBaseClaseLeg ;
      AV110Convenio_base_calculowwds_2_convebasetipo = AV9ConveBaseTipo ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = AV35TFConveBasePlus ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = AV36TFConveBasePlus_To ;
      AV113Convenio_base_calculowwds_5_tfconvelicdlim = AV37TFConveLicDLim ;
      AV114Convenio_base_calculowwds_6_tfconvelicdlim_to = AV38TFConveLicDLim_To ;
      AV115Convenio_base_calculowwds_7_tfconvelicdseman = AV39TFConveLicDSeman ;
      AV116Convenio_base_calculowwds_8_tfconvelicdseman_to = AV40TFConveLicDSeman_To ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV42TFConveLicDMes_Sels ;
      AV118Convenio_base_calculowwds_10_tfconvelicdsemes = AV43TFConveLicDSemes ;
      AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV44TFConveLicDSemes_To ;
      AV120Convenio_base_calculowwds_12_tfconvelicdanual = AV45TFConveLicDAnual ;
      AV121Convenio_base_calculowwds_13_tfconvelicdanual_to = AV46TFConveLicDAnual_To ;
      AV122Convenio_base_calculowwds_14_tfconvelicadju_sel = AV47TFConveLicAdju_Sel ;
      AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV48TFConveLicAdjuObl_Sel ;
      AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV49TFConveLicNecAut_Sel ;
      AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV50TFConveLicIngMot_Sel ;
      AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV51TFConveLicMotObl_Sel ;
      AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV52TFConveBasePromCnt1 ;
      AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV53TFConveBasePromCnt1_To ;
      AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV54TFConveBasePromCnt2 ;
      AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV55TFConveBasePromCnt2_To ;
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV57TFConveBasePromTCnt_Sels ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = AV89TFConveBaseRelRef ;
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV90TFConveBaseRelRef_Sels ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93ManageFiltersData", AV93ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV90TFConveBaseRelRef_Sels", AV90TFConveBaseRelRef_Sels);
   }

   public void e13EZ2( )
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
         AV59PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV59PageToGo) ;
      }
   }

   public void e14EZ2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15EZ2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV15OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
         AV16OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16OrderedDsc", AV16OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveBasePlus") == 0 )
         {
            AV35TFConveBasePlus = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFConveBasePlus", GXutil.ltrimstr( AV35TFConveBasePlus, 6, 4));
            AV36TFConveBasePlus_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConveBasePlus_To", GXutil.ltrimstr( AV36TFConveBasePlus_To, 6, 4));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicDLim") == 0 )
         {
            AV37TFConveLicDLim = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFConveLicDLim), 3, 0));
            AV38TFConveLicDLim_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConveLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFConveLicDLim_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicDSeman") == 0 )
         {
            AV39TFConveLicDSeman = (byte)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConveLicDSeman", GXutil.str( AV39TFConveLicDSeman, 1, 0));
            AV40TFConveLicDSeman_To = (byte)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConveLicDSeman_To", GXutil.str( AV40TFConveLicDSeman_To, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicDMes") == 0 )
         {
            AV41TFConveLicDMes_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFConveLicDMes_SelsJson", AV41TFConveLicDMes_SelsJson);
            AV42TFConveLicDMes_Sels.fromJSonString(GXutil.strReplace( AV41TFConveLicDMes_SelsJson, "\"", ""), null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicDSemes") == 0 )
         {
            AV43TFConveLicDSemes = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFConveLicDSemes), 3, 0));
            AV44TFConveLicDSemes_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFConveLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFConveLicDSemes_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicDAnual") == 0 )
         {
            AV45TFConveLicDAnual = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFConveLicDAnual), 3, 0));
            AV46TFConveLicDAnual_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFConveLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFConveLicDAnual_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicAdju") == 0 )
         {
            AV47TFConveLicAdju_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFConveLicAdju_Sel", GXutil.str( AV47TFConveLicAdju_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicAdjuObl") == 0 )
         {
            AV48TFConveLicAdjuObl_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFConveLicAdjuObl_Sel", GXutil.str( AV48TFConveLicAdjuObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicNecAut") == 0 )
         {
            AV49TFConveLicNecAut_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFConveLicNecAut_Sel", GXutil.str( AV49TFConveLicNecAut_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicIngMot") == 0 )
         {
            AV50TFConveLicIngMot_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFConveLicIngMot_Sel", GXutil.str( AV50TFConveLicIngMot_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveLicMotObl") == 0 )
         {
            AV51TFConveLicMotObl_Sel = (byte)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFConveLicMotObl_Sel", GXutil.str( AV51TFConveLicMotObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveBasePromCnt1") == 0 )
         {
            AV52TFConveBasePromCnt1 = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFConveBasePromCnt1), 3, 0));
            AV53TFConveBasePromCnt1_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFConveBasePromCnt1_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFConveBasePromCnt1_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveBasePromCnt2") == 0 )
         {
            AV54TFConveBasePromCnt2 = (short)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFConveBasePromCnt2), 3, 0));
            AV55TFConveBasePromCnt2_To = (short)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFConveBasePromCnt2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55TFConveBasePromCnt2_To), 3, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveBasePromTCnt") == 0 )
         {
            AV56TFConveBasePromTCnt_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFConveBasePromTCnt_SelsJson", AV56TFConveBasePromTCnt_SelsJson);
            AV57TFConveBasePromTCnt_Sels.fromJSonString(AV56TFConveBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "ConveBaseRelRef") == 0 )
         {
            AV89TFConveBaseRelRef = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV89TFConveBaseRelRef", AV89TFConveBaseRelRef);
            AV88TFConveBaseRelRef_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFConveBaseRelRef_SelsJson", AV88TFConveBaseRelRef_SelsJson);
            AV90TFConveBaseRelRef_Sels.fromJSonString(AV88TFConveBaseRelRef_SelsJson, null);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV90TFConveBaseRelRef_Sels", AV90TFConveBaseRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV57TFConveBasePromTCnt_Sels", AV57TFConveBasePromTCnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42TFConveLicDMes_Sels", AV42TFConveLicDMes_Sels);
   }

   private void e20EZ2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV63Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV63Update);
      if ( AV64IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1454ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1455ConveBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1456ConveBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1457ConveBaseCod2))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
      }
      AV65Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV65Delete);
      if ( AV66IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1454ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1455ConveBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1456ConveBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1457ConveBaseCod2))}, new String[] {"Mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
      }
      AV78Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV78Display);
      edtavDisplay_Link = formatLink("web.convenio_base_calculoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(A1454ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(A1455ConveBaseTipo)),GXutil.URLEncode(GXutil.rtrim(A1456ConveBaseCod1)),GXutil.URLEncode(GXutil.rtrim(A1457ConveBaseCod2)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2","TabCode"})  ;
      edtavVersvg_Format = (short)(1) ;
      GXt_char10 = AV75VerSVG ;
      GXv_char8[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "ver", ""), GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      AV75VerSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavVersvg_Internalname, AV75VerSVG);
      edtavVersvg_Link = edtavDisplay_Link ;
      edtavVersvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavDisplay_Visible = 0 ;
      edtavModificarsvg_Format = (short)(1) ;
      GXt_char10 = AV76ModificarSVG ;
      GXv_char8[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "modificar", ""), GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      AV76ModificarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavModificarsvg_Internalname, AV76ModificarSVG);
      edtavModificarsvg_Link = edtavUpdate_Link ;
      edtavModificarsvg_Columnclass = httpContext.getMessage( "GridActionColumn", "") ;
      edtavUpdate_Visible = 0 ;
      edtavEliminarsvg_Format = (short)(1) ;
      GXt_char10 = AV77EliminarSVG ;
      GXv_char8[0] = GXt_char10 ;
      new web.recuperasvg(remoteHandle, context).execute( httpContext.getMessage( "eliminar", ""), GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      AV77EliminarSVG = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, edtavEliminarsvg_Internalname, AV77EliminarSVG);
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

   public void e11EZ2( )
   {
      /* Ddo_gridcolumnsselector_Oncolumnschanged Routine */
      returnInSub = false ;
      AV18ColumnsSelectorXML = Ddo_gridcolumnsselector_Columnsselectorvalues ;
      AV20ColumnsSelector.fromJSonString(AV18ColumnsSelectorXML, null);
      new web.wwpbaseobjects.savecolumnsselectorstate(remoteHandle, context).execute( "Convenio_base_calculoWWColumnsSelector", ((GXutil.strcmp("", AV18ColumnsSelectorXML)==0) ? "" : AV20ColumnsSelector.toxml(false, true, "WWPColumnsSelector", "PayDay"))) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93ManageFiltersData", AV93ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV90TFConveBaseRelRef_Sels", AV90TFConveBaseRelRef_Sels);
   }

   public void e12EZ2( )
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
         httpContext.popup(formatLink("web.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("Convenio_base_calculoWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV108Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV95ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95ManageFiltersExecutionStep", GXutil.str( AV95ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("web.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("Convenio_base_calculoWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV95ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95ManageFiltersExecutionStep", GXutil.str( AV95ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char10 = AV94ManageFiltersXml ;
         GXv_char8[0] = GXt_char10 ;
         new web.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "Convenio_base_calculoWWFilters", Ddo_managefilters_Activeeventkey, GXv_char8) ;
         convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
         AV94ManageFiltersXml = GXt_char10 ;
         if ( (GXutil.strcmp("", AV94ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S182 ();
            if (returnInSub) return;
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV108Pgmname+"GridState", AV94ManageFiltersXml) ;
            AV13GridState.fromxml(AV94ManageFiltersXml, null, null);
            AV15OrderedBy = AV13GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
            AV16OrderedDsc = AV13GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16OrderedDsc", AV16OrderedDsc);
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GridState", AV13GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42TFConveLicDMes_Sels", AV42TFConveLicDMes_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV57TFConveBasePromTCnt_Sels", AV57TFConveBasePromTCnt_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV90TFConveBaseRelRef_Sels", AV90TFConveBaseRelRef_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20ColumnsSelector", AV20ColumnsSelector);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV93ManageFiltersData", AV93ManageFiltersData);
   }

   public void e16EZ2( )
   {
      /* 'DoExport' Routine */
      returnInSub = false ;
      GXv_char8[0] = AV91ExcelFilename ;
      GXv_char7[0] = AV92ErrorMessage ;
      new web.convenio_base_calculowwexport(remoteHandle, context).execute( GXv_char8, GXv_char7) ;
      convenio_base_calculoww_impl.this.AV91ExcelFilename = GXv_char8[0] ;
      convenio_base_calculoww_impl.this.AV92ErrorMessage = GXv_char7[0] ;
      if ( GXutil.strcmp(AV91ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV91ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV92ErrorMessage);
      }
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV15OrderedBy, 4, 0))+":"+(AV16OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S172( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV20ColumnsSelector = (web.wwpbaseobjects.SdtWWPColumnsSelector)new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBaseC1Txt", "", "Código 1", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBaseC2Txt", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBasePlus", "", "Porcentaje para plus", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicDLim", "", "Cantidad de días permitidos por licencia", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicDSeman", "", "Cantidad de días permitidos por semana", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicDMes", "", "Cantidad de días permitidos por semestre", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicDSemes", "", "Cantidad de días permitidos por semestre", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicDAnual", "", "Cantidad de días permitidos por año", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicAdju", "", "Permite adjuntar documento", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicAdjuObl", "", "Obliga a adjuntar documento", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicNecAut", "", "Necesita autorización", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicIngMot", "", "Permite ingresar motivo", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveLicMotObl", "", "Obliga a ingresar motivo", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBasePromCnt1", "", "Cantidad de días/meses a promediar", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBasePromCnt2", "", "Cantidad de días/meses a promediar segunda alternativa", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBasePromTCnt", "", "Días o Meses", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      if ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV69CliCod) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "ConveBaseRelRef", "", "Liberación", true, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      }
      else
      {
         GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "", "", "", false, "") ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
         AV89TFConveBaseRelRef = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV89TFConveBaseRelRef", AV89TFConveBaseRelRef);
         AV90TFConveBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      }
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&VerSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&ModificarSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXv_SdtWWPColumnsSelector13[0] = AV20ColumnsSelector;
      new web.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, "&EliminarSVG", "", "", true, "") ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector13[0] ;
      GXt_char10 = AV19UserCustomValue ;
      GXv_char8[0] = GXt_char10 ;
      new web.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "Convenio_base_calculoWWColumnsSelector", GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      AV19UserCustomValue = GXt_char10 ;
      if ( ! ( (GXutil.strcmp("", AV19UserCustomValue)==0) ) )
      {
         AV21ColumnsSelectorAux.fromxml(AV19UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector13[0] = AV21ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
         new web.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector13, GXv_SdtWWPColumnsSelector14) ;
         AV21ColumnsSelectorAux = GXv_SdtWWPColumnsSelector13[0] ;
         AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
      }
      GXv_SdtWWPColumnsSelector14[0] = AV20ColumnsSelector;
      new web.fixcolumnsselector(remoteHandle, context).execute( AV69CliCod, GXv_SdtWWPColumnsSelector14) ;
      AV20ColumnsSelector = GXv_SdtWWPColumnsSelector14[0] ;
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean15 = AV64IsAuthorized_Update ;
      GXv_boolean9[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Update", GXv_boolean9) ;
      convenio_base_calculoww_impl.this.GXt_boolean15 = GXv_boolean9[0] ;
      AV64IsAuthorized_Update = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64IsAuthorized_Update", AV64IsAuthorized_Update);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      if ( ! ( AV64IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV66IsAuthorized_Delete ;
      GXv_boolean9[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Delete", GXv_boolean9) ;
      convenio_base_calculoww_impl.this.GXt_boolean15 = GXv_boolean9[0] ;
      AV66IsAuthorized_Delete = GXt_boolean15 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66IsAuthorized_Delete", AV66IsAuthorized_Delete);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV66IsAuthorized_Delete));
      if ( ! ( AV66IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_110_Refreshing);
      }
      GXt_boolean15 = AV67TempBoolean ;
      GXv_boolean9[0] = GXt_boolean15 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Insert", GXv_boolean9) ;
      convenio_base_calculoww_impl.this.GXt_boolean15 = GXv_boolean9[0] ;
      AV67TempBoolean = GXt_boolean15 ;
      if ( ! ( AV67TempBoolean ) )
      {
         bttBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = AV93ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
      new web.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "Convenio_base_calculoWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[0] ;
      AV93ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   }

   public void S182( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV35TFConveBasePlus = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35TFConveBasePlus", GXutil.ltrimstr( AV35TFConveBasePlus, 6, 4));
      AV36TFConveBasePlus_To = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36TFConveBasePlus_To", GXutil.ltrimstr( AV36TFConveBasePlus_To, 6, 4));
      AV37TFConveLicDLim = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37TFConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFConveLicDLim), 3, 0));
      AV38TFConveLicDLim_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38TFConveLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFConveLicDLim_To), 3, 0));
      AV39TFConveLicDSeman = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TFConveLicDSeman", GXutil.str( AV39TFConveLicDSeman, 1, 0));
      AV40TFConveLicDSeman_To = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40TFConveLicDSeman_To", GXutil.str( AV40TFConveLicDSeman_To, 1, 0));
      AV42TFConveLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      AV43TFConveLicDSemes = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43TFConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFConveLicDSemes), 3, 0));
      AV44TFConveLicDSemes_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44TFConveLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFConveLicDSemes_To), 3, 0));
      AV45TFConveLicDAnual = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TFConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFConveLicDAnual), 3, 0));
      AV46TFConveLicDAnual_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46TFConveLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFConveLicDAnual_To), 3, 0));
      AV47TFConveLicAdju_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47TFConveLicAdju_Sel", GXutil.str( AV47TFConveLicAdju_Sel, 1, 0));
      AV48TFConveLicAdjuObl_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48TFConveLicAdjuObl_Sel", GXutil.str( AV48TFConveLicAdjuObl_Sel, 1, 0));
      AV49TFConveLicNecAut_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TFConveLicNecAut_Sel", GXutil.str( AV49TFConveLicNecAut_Sel, 1, 0));
      AV50TFConveLicIngMot_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TFConveLicIngMot_Sel", GXutil.str( AV50TFConveLicIngMot_Sel, 1, 0));
      AV51TFConveLicMotObl_Sel = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51TFConveLicMotObl_Sel", GXutil.str( AV51TFConveLicMotObl_Sel, 1, 0));
      AV52TFConveBasePromCnt1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52TFConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFConveBasePromCnt1), 3, 0));
      AV53TFConveBasePromCnt1_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53TFConveBasePromCnt1_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFConveBasePromCnt1_To), 3, 0));
      AV54TFConveBasePromCnt2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54TFConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFConveBasePromCnt2), 3, 0));
      AV55TFConveBasePromCnt2_To = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TFConveBasePromCnt2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55TFConveBasePromCnt2_To), 3, 0));
      AV57TFConveBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV89TFConveBaseRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89TFConveBaseRelRef", AV89TFConveBaseRelRef);
      AV90TFConveBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
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
      if ( GXutil.strcmp(AV22Session.getValue(AV108Pgmname+"GridState"), "") == 0 )
      {
         AV13GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV108Pgmname+"GridState"), null, null);
      }
      else
      {
         AV13GridState.fromxml(AV22Session.getValue(AV108Pgmname+"GridState"), null, null);
      }
      AV15OrderedBy = AV13GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15OrderedBy), 4, 0));
      AV16OrderedDsc = AV13GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16OrderedDsc", AV16OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S192 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV13GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV13GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV13GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S192( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV134GXV1 = 1 ;
      while ( AV134GXV1 <= AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV134GXV1));
         if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPLUS") == 0 )
         {
            AV35TFConveBasePlus = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35TFConveBasePlus", GXutil.ltrimstr( AV35TFConveBasePlus, 6, 4));
            AV36TFConveBasePlus_To = CommonUtil.decimalVal( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36TFConveBasePlus_To", GXutil.ltrimstr( AV36TFConveBasePlus_To, 6, 4));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDLIM") == 0 )
         {
            AV37TFConveLicDLim = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37TFConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37TFConveLicDLim), 3, 0));
            AV38TFConveLicDLim_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38TFConveLicDLim_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38TFConveLicDLim_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDSEMAN") == 0 )
         {
            AV39TFConveLicDSeman = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39TFConveLicDSeman", GXutil.str( AV39TFConveLicDSeman, 1, 0));
            AV40TFConveLicDSeman_To = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40TFConveLicDSeman_To", GXutil.str( AV40TFConveLicDSeman_To, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDMES_SEL") == 0 )
         {
            AV41TFConveLicDMes_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41TFConveLicDMes_SelsJson", AV41TFConveLicDMes_SelsJson);
            AV42TFConveLicDMes_Sels.fromJSonString(AV41TFConveLicDMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDSEMES") == 0 )
         {
            AV43TFConveLicDSemes = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43TFConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43TFConveLicDSemes), 3, 0));
            AV44TFConveLicDSemes_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV44TFConveLicDSemes_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44TFConveLicDSemes_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDANUAL") == 0 )
         {
            AV45TFConveLicDAnual = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45TFConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45TFConveLicDAnual), 3, 0));
            AV46TFConveLicDAnual_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV46TFConveLicDAnual_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46TFConveLicDAnual_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICADJU_SEL") == 0 )
         {
            AV47TFConveLicAdju_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV47TFConveLicAdju_Sel", GXutil.str( AV47TFConveLicAdju_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICADJUOBL_SEL") == 0 )
         {
            AV48TFConveLicAdjuObl_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48TFConveLicAdjuObl_Sel", GXutil.str( AV48TFConveLicAdjuObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICNECAUT_SEL") == 0 )
         {
            AV49TFConveLicNecAut_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49TFConveLicNecAut_Sel", GXutil.str( AV49TFConveLicNecAut_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICINGMOT_SEL") == 0 )
         {
            AV50TFConveLicIngMot_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TFConveLicIngMot_Sel", GXutil.str( AV50TFConveLicIngMot_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICMOTOBL_SEL") == 0 )
         {
            AV51TFConveLicMotObl_Sel = (byte)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFConveLicMotObl_Sel", GXutil.str( AV51TFConveLicMotObl_Sel, 1, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMCNT1") == 0 )
         {
            AV52TFConveBasePromCnt1 = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TFConveBasePromCnt1), 3, 0));
            AV53TFConveBasePromCnt1_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53TFConveBasePromCnt1_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53TFConveBasePromCnt1_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMCNT2") == 0 )
         {
            AV54TFConveBasePromCnt2 = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54TFConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54TFConveBasePromCnt2), 3, 0));
            AV55TFConveBasePromCnt2_To = (short)(GXutil.lval( AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV55TFConveBasePromCnt2_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55TFConveBasePromCnt2_To), 3, 0));
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMTCNT_SEL") == 0 )
         {
            AV56TFConveBasePromTCnt_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56TFConveBasePromTCnt_SelsJson", AV56TFConveBasePromTCnt_SelsJson);
            AV57TFConveBasePromTCnt_Sels.fromJSonString(AV56TFConveBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASERELREF") == 0 )
         {
            AV89TFConveBaseRelRef = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV89TFConveBaseRelRef", AV89TFConveBaseRelRef);
         }
         else if ( GXutil.strcmp(AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASERELREF_SEL") == 0 )
         {
            AV88TFConveBaseRelRef_SelsJson = AV14GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFConveBaseRelRef_SelsJson", AV88TFConveBaseRelRef_SelsJson);
            AV90TFConveBaseRelRef_Sels.fromJSonString(AV88TFConveBaseRelRef_SelsJson, null);
         }
         AV134GXV1 = (int)(AV134GXV1+1) ;
      }
      GXt_char10 = "" ;
      GXv_char8[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV57TFConveBasePromTCnt_Sels.size()==0), AV56TFConveBasePromTCnt_SelsJson, GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      GXt_char1 = "" ;
      GXv_char7[0] = GXt_char1 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV90TFConveBaseRelRef_Sels.size()==0), AV88TFConveBaseRelRef_SelsJson, GXv_char7) ;
      convenio_base_calculoww_impl.this.GXt_char1 = GXv_char7[0] ;
      Ddo_grid_Selectedvalue_set = "|||||"+((AV42TFConveLicDMes_Sels.size()==0) ? "" : AV41TFConveLicDMes_SelsJson)+"|||"+((0==AV47TFConveLicAdju_Sel) ? "" : GXutil.str( AV47TFConveLicAdju_Sel, 1, 0))+"|"+((0==AV48TFConveLicAdjuObl_Sel) ? "" : GXutil.str( AV48TFConveLicAdjuObl_Sel, 1, 0))+"|"+((0==AV49TFConveLicNecAut_Sel) ? "" : GXutil.str( AV49TFConveLicNecAut_Sel, 1, 0))+"|"+((0==AV50TFConveLicIngMot_Sel) ? "" : GXutil.str( AV50TFConveLicIngMot_Sel, 1, 0))+"|"+((0==AV51TFConveLicMotObl_Sel) ? "" : GXutil.str( AV51TFConveLicMotObl_Sel, 1, 0))+"|||"+GXt_char10+"|"+GXt_char1 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char10 = "" ;
      GXv_char8[0] = GXt_char10 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV89TFConveBaseRelRef)==0), AV89TFConveBaseRelRef, GXv_char8) ;
      convenio_base_calculoww_impl.this.GXt_char10 = GXv_char8[0] ;
      Ddo_grid_Filteredtext_set = "||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFConveBasePlus)==0) ? "" : GXutil.str( AV35TFConveBasePlus, 6, 4))+"|"+((0==AV37TFConveLicDLim) ? "" : GXutil.str( AV37TFConveLicDLim, 3, 0))+"|"+((0==AV39TFConveLicDSeman) ? "" : GXutil.str( AV39TFConveLicDSeman, 1, 0))+"||"+((0==AV43TFConveLicDSemes) ? "" : GXutil.str( AV43TFConveLicDSemes, 3, 0))+"|"+((0==AV45TFConveLicDAnual) ? "" : GXutil.str( AV45TFConveLicDAnual, 3, 0))+"||||||"+((0==AV52TFConveBasePromCnt1) ? "" : GXutil.str( AV52TFConveBasePromCnt1, 3, 0))+"|"+((0==AV54TFConveBasePromCnt2) ? "" : GXutil.str( AV54TFConveBasePromCnt2, 3, 0))+"||"+GXt_char10 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFConveBasePlus_To)==0) ? "" : GXutil.str( AV36TFConveBasePlus_To, 6, 4))+"|"+((0==AV38TFConveLicDLim_To) ? "" : GXutil.str( AV38TFConveLicDLim_To, 3, 0))+"|"+((0==AV40TFConveLicDSeman_To) ? "" : GXutil.str( AV40TFConveLicDSeman_To, 1, 0))+"||"+((0==AV44TFConveLicDSemes_To) ? "" : GXutil.str( AV44TFConveLicDSemes_To, 3, 0))+"|"+((0==AV46TFConveLicDAnual_To) ? "" : GXutil.str( AV46TFConveLicDAnual_To, 3, 0))+"||||||"+((0==AV53TFConveBasePromCnt1_To) ? "" : GXutil.str( AV53TFConveBasePromCnt1_To, 3, 0))+"|"+((0==AV55TFConveBasePromCnt2_To) ? "" : GXutil.str( AV55TFConveBasePromCnt2_To, 3, 0))+"||" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV13GridState.fromxml(AV22Session.getValue(AV108Pgmname+"GridState"), null, null);
      AV13GridState.setgxTv_SdtWWPGridState_Orderedby( AV15OrderedBy );
      AV13GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV16OrderedDsc );
      AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEBASEPLUS", httpContext.getMessage( "Porcentaje para plus", ""), !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFConveBasePlus)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFConveBasePlus_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV35TFConveBasePlus, 6, 4)), GXutil.trim( GXutil.str( AV36TFConveBasePlus_To, 6, 4))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICDLIM", httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), !((0==AV37TFConveLicDLim)&&(0==AV38TFConveLicDLim_To)), (short)(0), GXutil.trim( GXutil.str( AV37TFConveLicDLim, 3, 0)), GXutil.trim( GXutil.str( AV38TFConveLicDLim_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICDSEMAN", httpContext.getMessage( "Cantidad de días permitidos por semana", ""), !((0==AV39TFConveLicDSeman)&&(0==AV40TFConveLicDSeman_To)), (short)(0), GXutil.trim( GXutil.str( AV39TFConveLicDSeman, 1, 0)), GXutil.trim( GXutil.str( AV40TFConveLicDSeman_To, 1, 0))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICDMES_SEL", httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), !(AV42TFConveLicDMes_Sels.size()==0), (short)(0), AV42TFConveLicDMes_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICDSEMES", httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), !((0==AV43TFConveLicDSemes)&&(0==AV44TFConveLicDSemes_To)), (short)(0), GXutil.trim( GXutil.str( AV43TFConveLicDSemes, 3, 0)), GXutil.trim( GXutil.str( AV44TFConveLicDSemes_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICDANUAL", httpContext.getMessage( "Cantidad de días permitidos por año", ""), !((0==AV45TFConveLicDAnual)&&(0==AV46TFConveLicDAnual_To)), (short)(0), GXutil.trim( GXutil.str( AV45TFConveLicDAnual, 3, 0)), GXutil.trim( GXutil.str( AV46TFConveLicDAnual_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICADJU_SEL", httpContext.getMessage( "Permite adjuntar documento", ""), !(0==AV47TFConveLicAdju_Sel), (short)(0), GXutil.trim( GXutil.str( AV47TFConveLicAdju_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICADJUOBL_SEL", httpContext.getMessage( "Obliga a adjuntar documento", ""), !(0==AV48TFConveLicAdjuObl_Sel), (short)(0), GXutil.trim( GXutil.str( AV48TFConveLicAdjuObl_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICNECAUT_SEL", httpContext.getMessage( "Necesita autorización", ""), !(0==AV49TFConveLicNecAut_Sel), (short)(0), GXutil.trim( GXutil.str( AV49TFConveLicNecAut_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICINGMOT_SEL", httpContext.getMessage( "Permite ingresar motivo", ""), !(0==AV50TFConveLicIngMot_Sel), (short)(0), GXutil.trim( GXutil.str( AV50TFConveLicIngMot_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVELICMOTOBL_SEL", httpContext.getMessage( "Obliga a ingresar motivo", ""), !(0==AV51TFConveLicMotObl_Sel), (short)(0), GXutil.trim( GXutil.str( AV51TFConveLicMotObl_Sel, 1, 0)), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEBASEPROMCNT1", httpContext.getMessage( "Cantidad de días/meses a promediar", ""), !((0==AV52TFConveBasePromCnt1)&&(0==AV53TFConveBasePromCnt1_To)), (short)(0), GXutil.trim( GXutil.str( AV52TFConveBasePromCnt1, 3, 0)), GXutil.trim( GXutil.str( AV53TFConveBasePromCnt1_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEBASEPROMCNT2", httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), !((0==AV54TFConveBasePromCnt2)&&(0==AV55TFConveBasePromCnt2_To)), (short)(0), GXutil.trim( GXutil.str( AV54TFConveBasePromCnt2, 3, 0)), GXutil.trim( GXutil.str( AV55TFConveBasePromCnt2_To, 3, 0))) ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEBASEPROMTCNT_SEL", httpContext.getMessage( "Días o Meses", ""), !(AV57TFConveBasePromTCnt_Sels.size()==0), (short)(0), AV57TFConveBasePromTCnt_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      GXv_SdtWWPGridState18[0] = AV13GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState18, "TFCONVEBASERELREF", httpContext.getMessage( "Liberación", ""), !(GXutil.strcmp("", AV89TFConveBaseRelRef)==0), (short)(0), AV89TFConveBaseRelRef, "", !(AV90TFConveBaseRelRef_Sels.size()==0), AV90TFConveBaseRelRef_Sels.toJSonString(false), "") ;
      AV13GridState = GXv_SdtWWPGridState18[0] ;
      if ( ! (GXutil.strcmp("", AV79MenuOpcCod)==0) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&MENUOPCCOD" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV79MenuOpcCod );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      if ( ! (0==AV8ConveBaseClaseLeg) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CONVEBASECLASELEG" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV8ConveBaseClaseLeg, 1, 0) );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      if ( ! (GXutil.strcmp("", AV9ConveBaseTipo)==0) )
      {
         AV14GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CONVEBASETIPO" );
         AV14GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( AV9ConveBaseTipo );
         AV13GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV14GridStateFilterValue, 0);
      }
      AV13GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV13GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV108Pgmname+"GridState", AV13GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV11TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV108Pgmname );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV10HTTPRequest.getScriptName()+"?"+AV10HTTPRequest.getQuerystring() );
      AV11TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Convenio_base_calculo" );
      AV12TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "ConveBaseClaseLeg" );
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV8ConveBaseClaseLeg, 1, 0) );
      AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV12TrnContextAtt, 0);
      AV12TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "ConveBaseTipo" );
      AV12TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( AV9ConveBaseTipo );
      AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV12TrnContextAtt, 0);
      AV22Session.setValue("TrnContext", AV11TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void e17EZ2( )
   {
      /* Welcomemessage_nomostrarmas_Click Routine */
      returnInSub = false ;
      if ( AV81WelcomeMessage_NoMostrarMas )
      {
         GXv_boolean9[0] = false ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV79MenuOpcCod, GXv_boolean9) ;
         GXv_char8[0] = AV83textoNoMostrara ;
         new web.getparametro(remoteHandle, context).execute( AV69CliCod, new web.textonomostrara_codigoparam(remoteHandle, context).executeUdp( ), GXv_char8) ;
         convenio_base_calculoww_impl.this.AV83textoNoMostrara = GXv_char8[0] ;
         lblWelcomemessage_combotext_Caption = GXutil.trim( AV83textoNoMostrara) ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      else
      {
         GXv_boolean9[0] = true ;
         new web.opcionsetnomostrar(remoteHandle, context).execute( AV79MenuOpcCod, GXv_boolean9) ;
         lblWelcomemessage_combotext_Caption = httpContext.getMessage( "No volver a mostrar", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblWelcomemessage_combotext_Internalname, "Caption", lblWelcomemessage_combotext_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void wb_table1_9_EZ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TablePadding'>") ;
         wb_table2_12_EZ2( true) ;
      }
      else
      {
         wb_table2_12_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table2_12_EZ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_EZ2e( true) ;
      }
      else
      {
         wb_table1_9_EZ2e( false) ;
      }
   }

   public void wb_table2_12_EZ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_closehelp_Internalname, lblWelcomemessage_closehelp_Caption, "", "", lblWelcomemessage_closehelp_Jsonclick, "'"+""+"'"+",false,"+"'"+"e21ez1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_Convenio_base_calculoWW.htm");
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
         AV87WelcomeMessage_Foto_IsBlob = (boolean)(((GXutil.strcmp("", AV87WelcomeMessage_Foto)==0)&&(GXutil.strcmp("", AV107Welcomemessage_foto_GXI)==0))||!(GXutil.strcmp("", AV87WelcomeMessage_Foto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV87WelcomeMessage_Foto)==0) ? AV107Welcomemessage_foto_GXI : httpContext.getResourceRelative(AV87WelcomeMessage_Foto)) ;
         web.GxWebStd.gx_bitmap( httpContext, imgavWelcomemessage_foto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV87WelcomeMessage_Foto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Convenio_base_calculoWW.htm");
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
         wb_table3_30_EZ2( true) ;
      }
      else
      {
         wb_table3_30_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table3_30_EZ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         wb_table4_35_EZ2( true) ;
      }
      else
      {
         wb_table4_35_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table4_35_EZ2e( boolean wbgen )
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
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavWelcomemessage_nomostrarmas.getInternalname(), GXutil.booltostr( AV81WelcomeMessage_NoMostrarMas), "", httpContext.getMessage( "Welcome Message_No Mostrar Mas", ""), 1, chkavWelcomemessage_nomostrarmas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_combotext_Internalname, lblWelcomemessage_combotext_Caption, "", "", lblWelcomemessage_combotext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTextNomm", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
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
         wb_table5_54_EZ2( true) ;
      }
      else
      {
         wb_table5_54_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table5_54_EZ2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table6_63_EZ2( true) ;
      }
      else
      {
         wb_table6_63_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table6_63_EZ2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV60GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV61GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV62GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_12_EZ2e( true) ;
      }
      else
      {
         wb_table2_12_EZ2e( false) ;
      }
   }

   public void wb_table6_63_EZ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" fill=\"var(--colors_gray09)\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" fill=\"var(--colors_gray09)\"/><path d=\"M9.25 13.25C9.25 13.6642 9.58578 14 10 14C10.4142 14 10.75 13.6642 10.75 13.25L10.75 4.63642L13.7047 7.76497C13.9891 8.06611 14.4638 8.07967 14.765 7.79526C15.0661 7.51085 15.0797 7.03617 14.7953 6.73503L10.5453 2.23503C10.4036 2.08501 10.2063 2 10 2C9.79365 2 9.59642 2.08501 9.45474 2.23503L5.20474 6.73503C4.92033 7.03617 4.93389 7.51085 5.23503 7.79526C5.53617 8.07967 6.01085 8.06611 6.29526 7.76497L9.25 4.63642L9.25 13.25Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/><path d=\"M3.5 12.75C3.5 12.3358 3.16421 12 2.75 12C2.33579 12 2 12.3358 2 12.75V15.25C2 16.7688 3.23122 18 4.75 18H15.25C16.7688 18 18 16.7688 18 15.25V12.75C18 12.3358 17.6642 12 17.25 12C16.8358 12 16.5 12.3358 16.5 12.75V15.25C16.5 15.9404 15.9404 16.5 15.25 16.5H4.75C4.05964 16.5 3.5 15.9404 3.5 15.25V12.75Z\" stroke=\"var(--colors_gray09)\" stroke-width=\"0.5\" stroke-linecap=\"round\"/></svg>", ""), "", "", lblButtonexport1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Convenio_base_calculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonexport1_textblock_texto_Internalname, httpContext.getMessage( "Exportar", ""), "", "", lblButtonexport1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
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
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsTitleSettingsIcons", AV58DDO_TitleSettingsIcons);
         ucDdo_gridcolumnsselector.setProperty("DropDownOptionsData", AV20ColumnsSelector);
         ucDdo_gridcolumnsselector.render(context, "dvelop.gxbootstrap.ddogridcolumnsselector", Ddo_gridcolumnsselector_Internalname, "DDO_GRIDCOLUMNSSELECTORContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV93ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninsert_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtninsert_Jsonclick, 7, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtninsert_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e22ez1_client"+"'", TempTags, "", 2, "HLP_Convenio_base_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilledSecundario" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 110, 3, 0)+","+"null"+");", httpContext.getMessage( "Exportar a Excel", ""), bttBtnexport_Jsonclick, 5, httpContext.getMessage( "WWP_ExportTooltip", ""), "", StyleString, ClassString, bttBtnexport_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOEXPORT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_base_calculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_svg_Internalname, httpContext.getMessage( "<svg width=\"18\" height=\"10\" viewBox=\"0 0 18 10\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 1H17M3.85714 5H14.1429M7.28571 9H10.7143\" stroke=\"var(--colors_gray09)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", ""), "", "", lblButtonfilter1_textblock_svg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Convenio_base_calculoWW.htm");
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblock_texto_Internalname, httpContext.getMessage( "Filtros", ""), "", "", lblButtonfilter1_textblock_texto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ButtonImportExport", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "TableBadgeCell", "left", "top", "", "", "div");
         wb_table7_99_EZ2( true) ;
      }
      else
      {
         wb_table7_99_EZ2( false) ;
      }
      return  ;
   }

   public void wb_table7_99_EZ2e( boolean wbgen )
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
         wb_table6_63_EZ2e( true) ;
      }
      else
      {
         wb_table6_63_EZ2e( false) ;
      }
   }

   public void wb_table7_99_EZ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblButtonfilter1_textblockbadgecount_Internalname, lblButtonfilter1_textblockbadgecount_Caption, "", "", lblButtonfilter1_textblockbadgecount_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBadge", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_99_EZ2e( true) ;
      }
      else
      {
         wb_table7_99_EZ2e( false) ;
      }
   }

   public void wb_table5_54_EZ2( boolean wbgen )
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
         web.GxWebStd.gx_label_ctrl( httpContext, lblTotaltext_Internalname, httpContext.getMessage( "Total:", ""), "", "", lblTotaltext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "bold", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblCouttext_Internalname, lblCouttext_Caption, "", "", lblCouttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TotalTextPill", 0, "", lblCouttext_Visible, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_54_EZ2e( true) ;
      }
      else
      {
         wb_table5_54_EZ2e( false) ;
      }
   }

   public void wb_table4_35_EZ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabledescripcion_Internalname, tblWelcomemessage_tabledescripcion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_descripcion_Internalname, lblWelcomemessage_descripcion_Caption, "", "", lblWelcomemessage_descripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_35_EZ2e( true) ;
      }
      else
      {
         wb_table4_35_EZ2e( false) ;
      }
   }

   public void wb_table3_30_EZ2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblWelcomemessage_tabletitulo_Internalname, tblWelcomemessage_tabletitulo_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblWelcomemessage_titulo_Internalname, lblWelcomemessage_titulo_Caption, "", "", lblWelcomemessage_titulo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "WelcomeTitle", 0, "", 1, 1, 0, (short)(0), "HLP_Convenio_base_calculoWW.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_30_EZ2e( true) ;
      }
      else
      {
         wb_table3_30_EZ2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV79MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79MenuOpcCod", AV79MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79MenuOpcCod, ""))));
      AV8ConveBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8ConveBaseClaseLeg", GXutil.str( AV8ConveBaseClaseLeg, 1, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8ConveBaseClaseLeg), "9")));
      AV9ConveBaseTipo = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9ConveBaseTipo", AV9ConveBaseTipo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveBaseTipo, ""))));
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
      paEZ2( ) ;
      wsEZ2( ) ;
      weEZ2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316504173", true, true);
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
      httpContext.AddJavascriptSource("convenio_base_calculoww.js", "?20251316504173", false, true);
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
      cmbConveBaseClaseLeg.setInternalname( "CONVEBASECLASELEG_"+sGXsfl_110_idx );
      cmbConveBaseTipo.setInternalname( "CONVEBASETIPO_"+sGXsfl_110_idx );
      edtConveBaseCod1_Internalname = "CONVEBASECOD1_"+sGXsfl_110_idx ;
      edtConveBaseC1Txt_Internalname = "CONVEBASEC1TXT_"+sGXsfl_110_idx ;
      edtConveBaseCod2_Internalname = "CONVEBASECOD2_"+sGXsfl_110_idx ;
      edtConveBaseC2Txt_Internalname = "CONVEBASEC2TXT_"+sGXsfl_110_idx ;
      edtConveBasePlus_Internalname = "CONVEBASEPLUS_"+sGXsfl_110_idx ;
      edtConveLicDLim_Internalname = "CONVELICDLIM_"+sGXsfl_110_idx ;
      edtConveLicDSeman_Internalname = "CONVELICDSEMAN_"+sGXsfl_110_idx ;
      cmbConveLicDMes.setInternalname( "CONVELICDMES_"+sGXsfl_110_idx );
      edtConveLicDSemes_Internalname = "CONVELICDSEMES_"+sGXsfl_110_idx ;
      edtConveLicDAnual_Internalname = "CONVELICDANUAL_"+sGXsfl_110_idx ;
      chkConveLicAdju.setInternalname( "CONVELICADJU_"+sGXsfl_110_idx );
      chkConveLicAdjuObl.setInternalname( "CONVELICADJUOBL_"+sGXsfl_110_idx );
      chkConveLicNecAut.setInternalname( "CONVELICNECAUT_"+sGXsfl_110_idx );
      chkConveLicIngMot.setInternalname( "CONVELICINGMOT_"+sGXsfl_110_idx );
      chkConveLicMotObl.setInternalname( "CONVELICMOTOBL_"+sGXsfl_110_idx );
      edtConveBasePromCnt1_Internalname = "CONVEBASEPROMCNT1_"+sGXsfl_110_idx ;
      edtConveBasePromCnt2_Internalname = "CONVEBASEPROMCNT2_"+sGXsfl_110_idx ;
      cmbConveBasePromTCnt.setInternalname( "CONVEBASEPROMTCNT_"+sGXsfl_110_idx );
      edtConveBaseRelRef_Internalname = "CONVEBASERELREF_"+sGXsfl_110_idx ;
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
      cmbConveBaseClaseLeg.setInternalname( "CONVEBASECLASELEG_"+sGXsfl_110_fel_idx );
      cmbConveBaseTipo.setInternalname( "CONVEBASETIPO_"+sGXsfl_110_fel_idx );
      edtConveBaseCod1_Internalname = "CONVEBASECOD1_"+sGXsfl_110_fel_idx ;
      edtConveBaseC1Txt_Internalname = "CONVEBASEC1TXT_"+sGXsfl_110_fel_idx ;
      edtConveBaseCod2_Internalname = "CONVEBASECOD2_"+sGXsfl_110_fel_idx ;
      edtConveBaseC2Txt_Internalname = "CONVEBASEC2TXT_"+sGXsfl_110_fel_idx ;
      edtConveBasePlus_Internalname = "CONVEBASEPLUS_"+sGXsfl_110_fel_idx ;
      edtConveLicDLim_Internalname = "CONVELICDLIM_"+sGXsfl_110_fel_idx ;
      edtConveLicDSeman_Internalname = "CONVELICDSEMAN_"+sGXsfl_110_fel_idx ;
      cmbConveLicDMes.setInternalname( "CONVELICDMES_"+sGXsfl_110_fel_idx );
      edtConveLicDSemes_Internalname = "CONVELICDSEMES_"+sGXsfl_110_fel_idx ;
      edtConveLicDAnual_Internalname = "CONVELICDANUAL_"+sGXsfl_110_fel_idx ;
      chkConveLicAdju.setInternalname( "CONVELICADJU_"+sGXsfl_110_fel_idx );
      chkConveLicAdjuObl.setInternalname( "CONVELICADJUOBL_"+sGXsfl_110_fel_idx );
      chkConveLicNecAut.setInternalname( "CONVELICNECAUT_"+sGXsfl_110_fel_idx );
      chkConveLicIngMot.setInternalname( "CONVELICINGMOT_"+sGXsfl_110_fel_idx );
      chkConveLicMotObl.setInternalname( "CONVELICMOTOBL_"+sGXsfl_110_fel_idx );
      edtConveBasePromCnt1_Internalname = "CONVEBASEPROMCNT1_"+sGXsfl_110_fel_idx ;
      edtConveBasePromCnt2_Internalname = "CONVEBASEPROMCNT2_"+sGXsfl_110_fel_idx ;
      cmbConveBasePromTCnt.setInternalname( "CONVEBASEPROMTCNT_"+sGXsfl_110_fel_idx );
      edtConveBaseRelRef_Internalname = "CONVEBASERELREF_"+sGXsfl_110_fel_idx ;
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
      wbEZ0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbConveBaseClaseLeg.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVEBASECLASELEG_" + sGXsfl_110_idx ;
            cmbConveBaseClaseLeg.setName( GXCCtl );
            cmbConveBaseClaseLeg.setWebtags( "" );
            cmbConveBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
            cmbConveBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
            cmbConveBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
            cmbConveBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
            if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
            {
               A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveBaseClaseLeg,cmbConveBaseClaseLeg.getInternalname(),GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)),Integer.valueOf(1),cmbConveBaseClaseLeg.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Values", cmbConveBaseClaseLeg.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         if ( ( cmbConveBaseTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVEBASETIPO_" + sGXsfl_110_idx ;
            cmbConveBaseTipo.setName( GXCCtl );
            cmbConveBaseTipo.setWebtags( "" );
            cmbConveBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
            cmbConveBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
            cmbConveBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
            if ( cmbConveBaseTipo.getItemCount() > 0 )
            {
               A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveBaseTipo,cmbConveBaseTipo.getInternalname(),GXutil.rtrim( A1455ConveBaseTipo),Integer.valueOf(1),cmbConveBaseTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Values", cmbConveBaseTipo.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBaseCod1_Internalname,GXutil.rtrim( A1456ConveBaseCod1),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBaseCod1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConveBaseC1Txt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBaseC1Txt_Internalname,A1608ConveBaseC1Txt,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBaseC1Txt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveBaseC1Txt_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBaseCod2_Internalname,GXutil.rtrim( A1457ConveBaseCod2),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBaseCod2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConveBaseC2Txt_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBaseC2Txt_Internalname,A1609ConveBaseC2Txt,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBaseC2Txt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveBaseC2Txt_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveBasePlus_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBasePlus_Internalname,GXutil.ltrim( localUtil.ntoc( A1458ConveBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1458ConveBasePlus, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBasePlus_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveBasePlus_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveLicDLim_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveLicDLim_Internalname,GXutil.ltrim( localUtil.ntoc( A1610ConveLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1610ConveLicDLim), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveLicDLim_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveLicDLim_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveLicDSeman_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveLicDSeman_Internalname,GXutil.ltrim( localUtil.ntoc( A1611ConveLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1611ConveLicDSeman), "9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveLicDSeman_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveLicDSeman_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((cmbConveLicDMes.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConveLicDMes.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVELICDMES_" + sGXsfl_110_idx ;
            cmbConveLicDMes.setName( GXCCtl );
            cmbConveLicDMes.setWebtags( "" );
            if ( cmbConveLicDMes.getItemCount() > 0 )
            {
               A1612ConveLicDMes = (byte)(GXutil.lval( cmbConveLicDMes.getValidValue(GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0))))) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveLicDMes,cmbConveLicDMes.getInternalname(),GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)),Integer.valueOf(1),cmbConveLicDMes.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbConveLicDMes.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConveLicDMes.setValue( GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Values", cmbConveLicDMes.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveLicDSemes_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveLicDSemes_Internalname,GXutil.ltrim( localUtil.ntoc( A1613ConveLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1613ConveLicDSemes), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveLicDSemes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveLicDSemes_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveLicDAnual_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveLicDAnual_Internalname,GXutil.ltrim( localUtil.ntoc( A1614ConveLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1614ConveLicDAnual), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveLicDAnual_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveLicDAnual_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConveLicAdju.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVELICADJU_" + sGXsfl_110_idx ;
         chkConveLicAdju.setName( GXCCtl );
         chkConveLicAdju.setWebtags( "" );
         chkConveLicAdju.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "TitleCaption", chkConveLicAdju.getCaption(), !bGXsfl_110_Refreshing);
         chkConveLicAdju.setCheckedValue( "false" );
         A1615ConveLicAdju = GXutil.strtobool( GXutil.booltostr( A1615ConveLicAdju)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConveLicAdju.getInternalname(),GXutil.booltostr( A1615ConveLicAdju),"","",Integer.valueOf(chkConveLicAdju.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConveLicAdjuObl.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVELICADJUOBL_" + sGXsfl_110_idx ;
         chkConveLicAdjuObl.setName( GXCCtl );
         chkConveLicAdjuObl.setWebtags( "" );
         chkConveLicAdjuObl.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "TitleCaption", chkConveLicAdjuObl.getCaption(), !bGXsfl_110_Refreshing);
         chkConveLicAdjuObl.setCheckedValue( "false" );
         A1616ConveLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1616ConveLicAdjuObl)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConveLicAdjuObl.getInternalname(),GXutil.booltostr( A1616ConveLicAdjuObl),"","",Integer.valueOf(chkConveLicAdjuObl.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConveLicNecAut.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVELICNECAUT_" + sGXsfl_110_idx ;
         chkConveLicNecAut.setName( GXCCtl );
         chkConveLicNecAut.setWebtags( "" );
         chkConveLicNecAut.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "TitleCaption", chkConveLicNecAut.getCaption(), !bGXsfl_110_Refreshing);
         chkConveLicNecAut.setCheckedValue( "false" );
         A1617ConveLicNecAut = GXutil.strtobool( GXutil.booltostr( A1617ConveLicNecAut)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConveLicNecAut.getInternalname(),GXutil.booltostr( A1617ConveLicNecAut),"","",Integer.valueOf(chkConveLicNecAut.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConveLicIngMot.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVELICINGMOT_" + sGXsfl_110_idx ;
         chkConveLicIngMot.setName( GXCCtl );
         chkConveLicIngMot.setWebtags( "" );
         chkConveLicIngMot.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "TitleCaption", chkConveLicIngMot.getCaption(), !bGXsfl_110_Refreshing);
         chkConveLicIngMot.setCheckedValue( "false" );
         A1618ConveLicIngMot = GXutil.strtobool( GXutil.booltostr( A1618ConveLicIngMot)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConveLicIngMot.getInternalname(),GXutil.booltostr( A1618ConveLicIngMot),"","",Integer.valueOf(chkConveLicIngMot.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((chkConveLicMotObl.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         /* Check box */
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         GXCCtl = "CONVELICMOTOBL_" + sGXsfl_110_idx ;
         chkConveLicMotObl.setName( GXCCtl );
         chkConveLicMotObl.setWebtags( "" );
         chkConveLicMotObl.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "TitleCaption", chkConveLicMotObl.getCaption(), !bGXsfl_110_Refreshing);
         chkConveLicMotObl.setCheckedValue( "false" );
         A1619ConveLicMotObl = GXutil.strtobool( GXutil.booltostr( A1619ConveLicMotObl)) ;
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConveLicMotObl.getInternalname(),GXutil.booltostr( A1619ConveLicMotObl),"","",Integer.valueOf(chkConveLicMotObl.getVisible()),Integer.valueOf(0),"true","",StyleString,ClassString,"WWColumn","",""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveBasePromCnt1_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBasePromCnt1_Internalname,GXutil.ltrim( localUtil.ntoc( A1465ConveBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBasePromCnt1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveBasePromCnt1_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+((edtConveBasePromCnt2_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBasePromCnt2_Internalname,GXutil.ltrim( localUtil.ntoc( A1466ConveBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBasePromCnt2_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(edtConveBasePromCnt2_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((cmbConveBasePromTCnt.getVisible()==0) ? "display:none;" : "")+"\">") ;
         }
         if ( ( cmbConveBasePromTCnt.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CONVEBASEPROMTCNT_" + sGXsfl_110_idx ;
            cmbConveBasePromTCnt.setName( GXCCtl );
            cmbConveBasePromTCnt.setWebtags( "" );
            cmbConveBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
            cmbConveBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
            if ( cmbConveBasePromTCnt.getItemCount() > 0 )
            {
               A1467ConveBasePromTCnt = cmbConveBasePromTCnt.getValidValue(A1467ConveBasePromTCnt) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveBasePromTCnt,cmbConveBasePromTCnt.getInternalname(),GXutil.rtrim( A1467ConveBasePromTCnt),Integer.valueOf(1),cmbConveBasePromTCnt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConveBasePromTCnt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbConveBasePromTCnt.setValue( GXutil.rtrim( A1467ConveBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBasePromTCnt.getInternalname(), "Values", cmbConveBasePromTCnt.ToJavascriptSource(), !bGXsfl_110_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtConveBaseRelRef_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveBaseRelRef_Internalname,A2061ConveBaseRelRef,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveBaseRelRef_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtConveBaseRelRef_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV63Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV65Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV78Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavVersvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavVersvg_Internalname,GXutil.rtrim( AV75VerSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavVersvg_Link,"","","",edtavVersvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavVersvg_Columnclass,"",Integer.valueOf(edtavVersvg_Visible),Integer.valueOf(edtavVersvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavVersvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavModificarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavModificarsvg_Internalname,GXutil.rtrim( AV76ModificarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavModificarsvg_Link,"","","",edtavModificarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,edtavModificarsvg_Columnclass,"",Integer.valueOf(edtavModificarsvg_Visible),Integer.valueOf(edtavModificarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavModificarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavEliminarsvg_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "GridAction" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEliminarsvg_Internalname,GXutil.rtrim( AV77EliminarSVG),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavEliminarsvg_Link,"","","",edtavEliminarsvg_Jsonclick,Integer.valueOf(0),"GridAction","",ROClassString,"WWColumn","",Integer.valueOf(edtavEliminarsvg_Visible),Integer.valueOf(edtavEliminarsvg_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Short.valueOf(edtavEliminarsvg_Format),Integer.valueOf(110),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesEZ2( ) ;
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
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveBaseC1Txt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtConveBaseC1Txt_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveBaseC2Txt_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveBasePlus_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Porcentaje para plus", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveLicDLim_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por licencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveLicDSeman_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por semana", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConveLicDMes.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveLicDSemes_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por semestre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveLicDAnual_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días permitidos por año", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConveLicAdju.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Permite adjuntar documento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConveLicAdjuObl.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obliga a adjuntar documento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConveLicNecAut.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Necesita autorización", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConveLicIngMot.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Permite ingresar motivo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeCheckBox"+"\" "+" style=\""+((chkConveLicMotObl.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Obliga a ingresar motivo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveBasePromCnt1_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días/meses a promediar", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveBasePromCnt2_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((cmbConveBasePromTCnt.getVisible()==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días o Meses", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtConveBaseRelRef_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1454ConveBaseClaseLeg, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1455ConveBaseTipo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1456ConveBaseCod1));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1608ConveBaseC1Txt);
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtConveBaseC1Txt_Title));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveBaseC1Txt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1457ConveBaseCod2));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1609ConveBaseC2Txt);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveBaseC2Txt_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1458ConveBasePlus, (byte)(6), (byte)(4), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveBasePlus_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1610ConveLicDLim, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveLicDLim_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1611ConveLicDSeman, (byte)(1), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveLicDSeman_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1612ConveLicDMes, (byte)(2), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConveLicDMes.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1613ConveLicDSemes, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveLicDSemes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1614ConveLicDAnual, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveLicDAnual_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1615ConveLicAdju));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConveLicAdju.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1616ConveLicAdjuObl));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConveLicAdjuObl.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1617ConveLicNecAut));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConveLicNecAut.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1618ConveLicIngMot));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConveLicIngMot.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( A1619ConveLicMotObl));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( chkConveLicMotObl.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1465ConveBasePromCnt1, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveBasePromCnt1_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1466ConveBasePromCnt2, (byte)(3), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveBasePromCnt2_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A1467ConveBasePromTCnt));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConveBasePromTCnt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A2061ConveBaseRelRef);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtConveBaseRelRef_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV63Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV65Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV78Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV75VerSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavVersvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavVersvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavVersvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV76ModificarSVG));
         GridColumn.AddObjectProperty("Columnclass", GXutil.rtrim( edtavModificarsvg_Columnclass));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Format", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Format, (byte)(4), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavModificarsvg_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavModificarsvg_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV77EliminarSVG));
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
      cmbConveBaseClaseLeg.setInternalname( "CONVEBASECLASELEG" );
      cmbConveBaseTipo.setInternalname( "CONVEBASETIPO" );
      edtConveBaseCod1_Internalname = "CONVEBASECOD1" ;
      edtConveBaseC1Txt_Internalname = "CONVEBASEC1TXT" ;
      edtConveBaseCod2_Internalname = "CONVEBASECOD2" ;
      edtConveBaseC2Txt_Internalname = "CONVEBASEC2TXT" ;
      edtConveBasePlus_Internalname = "CONVEBASEPLUS" ;
      edtConveLicDLim_Internalname = "CONVELICDLIM" ;
      edtConveLicDSeman_Internalname = "CONVELICDSEMAN" ;
      cmbConveLicDMes.setInternalname( "CONVELICDMES" );
      edtConveLicDSemes_Internalname = "CONVELICDSEMES" ;
      edtConveLicDAnual_Internalname = "CONVELICDANUAL" ;
      chkConveLicAdju.setInternalname( "CONVELICADJU" );
      chkConveLicAdjuObl.setInternalname( "CONVELICADJUOBL" );
      chkConveLicNecAut.setInternalname( "CONVELICNECAUT" );
      chkConveLicIngMot.setInternalname( "CONVELICINGMOT" );
      chkConveLicMotObl.setInternalname( "CONVELICMOTOBL" );
      edtConveBasePromCnt1_Internalname = "CONVEBASEPROMCNT1" ;
      edtConveBasePromCnt2_Internalname = "CONVEBASEPROMCNT2" ;
      cmbConveBasePromTCnt.setInternalname( "CONVEBASEPROMTCNT" );
      edtConveBaseRelRef_Internalname = "CONVEBASERELREF" ;
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
      edtConveBaseRelRef_Jsonclick = "" ;
      cmbConveBasePromTCnt.setJsonclick( "" );
      edtConveBasePromCnt2_Jsonclick = "" ;
      edtConveBasePromCnt1_Jsonclick = "" ;
      chkConveLicMotObl.setCaption( "" );
      chkConveLicIngMot.setCaption( "" );
      chkConveLicNecAut.setCaption( "" );
      chkConveLicAdjuObl.setCaption( "" );
      chkConveLicAdju.setCaption( "" );
      edtConveLicDAnual_Jsonclick = "" ;
      edtConveLicDSemes_Jsonclick = "" ;
      cmbConveLicDMes.setJsonclick( "" );
      edtConveLicDSeman_Jsonclick = "" ;
      edtConveLicDLim_Jsonclick = "" ;
      edtConveBasePlus_Jsonclick = "" ;
      edtConveBaseC2Txt_Jsonclick = "" ;
      edtConveBaseCod2_Jsonclick = "" ;
      edtConveBaseC1Txt_Jsonclick = "" ;
      edtConveBaseCod1_Jsonclick = "" ;
      cmbConveBaseTipo.setJsonclick( "" );
      cmbConveBaseClaseLeg.setJsonclick( "" );
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
      edtConveBaseRelRef_Visible = -1 ;
      cmbConveBasePromTCnt.setVisible( -1 );
      edtConveBasePromCnt2_Visible = -1 ;
      edtConveBasePromCnt1_Visible = -1 ;
      chkConveLicMotObl.setVisible( -1 );
      chkConveLicIngMot.setVisible( -1 );
      chkConveLicNecAut.setVisible( -1 );
      chkConveLicAdjuObl.setVisible( -1 );
      chkConveLicAdju.setVisible( -1 );
      edtConveLicDAnual_Visible = -1 ;
      edtConveLicDSemes_Visible = -1 ;
      cmbConveLicDMes.setVisible( -1 );
      edtConveLicDSeman_Visible = -1 ;
      edtConveLicDLim_Visible = -1 ;
      edtConveBasePlus_Visible = -1 ;
      edtConveBaseC1Txt_Visible = -1 ;
      lblWelcomemessage_closehelp_Caption = "X" ;
      lblWelcomemessage_descripcion_Caption = httpContext.getMessage( "Descripcion", "") ;
      lblWelcomemessage_titulo_Caption = httpContext.getMessage( "Titulo", "") ;
      subGrid_Sortable = (byte)(0) ;
      Grid_empowerer_Hascolumnsselector = GXutil.toBoolean( -1) ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "||6.4|3.0|1.0||3.0|3.0||||||3.0|3.0||" ;
      Ddo_grid_Datalistproc = "Convenio_base_calculoWWGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "||||||||1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|1:WWP_TSChecked,2:WWP_TSUnChecked|||dias:días,meses:meses|" ;
      Ddo_grid_Allowmultipleselection = "|||||T||||||||||T|T" ;
      Ddo_grid_Datalisttype = "|||||FixedValues|||FixedValues|FixedValues|FixedValues|FixedValues|FixedValues|||FixedValues|Dynamic" ;
      Ddo_grid_Includedatalist = "|||||T|||T|T|T|T|T|||T|T" ;
      Ddo_grid_Filterisrange = "||T|T|T||T|T||||||T|T||" ;
      Ddo_grid_Filtertype = "||Numeric|Numeric|Numeric||Numeric|Numeric||||||Numeric|Numeric||Character" ;
      Ddo_grid_Includefilter = "||T|T|T||T|T||||||T|T||T" ;
      Ddo_grid_Fixable = "T" ;
      Ddo_grid_Includesortasc = "||T|T|T|T|T|T|T|T|T|T|T|T|T|T|T" ;
      Ddo_grid_Columnssortvalues = "||1|2|3|4|5|6|7|8|9|10|11|12|13|14|15" ;
      Ddo_grid_Columnids = "6:ConveBaseC1Txt|8:ConveBaseC2Txt|9:ConveBasePlus|10:ConveLicDLim|11:ConveLicDSeman|12:ConveLicDMes|13:ConveLicDSemes|14:ConveLicDAnual|15:ConveLicAdju|16:ConveLicAdjuObl|17:ConveLicNecAut|18:ConveLicIngMot|19:ConveLicMotObl|20:ConveBasePromCnt1|21:ConveBasePromCnt2|22:ConveBasePromTCnt|23:ConveBaseRelRef" ;
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
      Form.setCaption( httpContext.getMessage( " Convenio_base_calculo", "") );
      edtConveBaseC1Txt_Title = httpContext.getMessage( "Código 1", "") ;
      edtConveBaseC2Txt_Visible = -1 ;
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
      AV81WelcomeMessage_NoMostrarMas = GXutil.strtobool( GXutil.booltostr( AV81WelcomeMessage_NoMostrarMas)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81WelcomeMessage_NoMostrarMas", AV81WelcomeMessage_NoMostrarMas);
      GXCCtl = "CONVEBASECLASELEG_" + sGXsfl_110_idx ;
      cmbConveBaseClaseLeg.setName( GXCCtl );
      cmbConveBaseClaseLeg.setWebtags( "" );
      cmbConveBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
      }
      GXCCtl = "CONVEBASETIPO_" + sGXsfl_110_idx ;
      cmbConveBaseTipo.setName( GXCCtl );
      cmbConveBaseTipo.setWebtags( "" );
      cmbConveBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbConveBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbConveBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
      }
      GXCCtl = "CONVELICDMES_" + sGXsfl_110_idx ;
      cmbConveLicDMes.setName( GXCCtl );
      cmbConveLicDMes.setWebtags( "" );
      if ( cmbConveLicDMes.getItemCount() > 0 )
      {
         A1612ConveLicDMes = (byte)(GXutil.lval( cmbConveLicDMes.getValidValue(GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0))))) ;
      }
      GXCCtl = "CONVELICADJU_" + sGXsfl_110_idx ;
      chkConveLicAdju.setName( GXCCtl );
      chkConveLicAdju.setWebtags( "" );
      chkConveLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "TitleCaption", chkConveLicAdju.getCaption(), !bGXsfl_110_Refreshing);
      chkConveLicAdju.setCheckedValue( "false" );
      A1615ConveLicAdju = GXutil.strtobool( GXutil.booltostr( A1615ConveLicAdju)) ;
      GXCCtl = "CONVELICADJUOBL_" + sGXsfl_110_idx ;
      chkConveLicAdjuObl.setName( GXCCtl );
      chkConveLicAdjuObl.setWebtags( "" );
      chkConveLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "TitleCaption", chkConveLicAdjuObl.getCaption(), !bGXsfl_110_Refreshing);
      chkConveLicAdjuObl.setCheckedValue( "false" );
      A1616ConveLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1616ConveLicAdjuObl)) ;
      GXCCtl = "CONVELICNECAUT_" + sGXsfl_110_idx ;
      chkConveLicNecAut.setName( GXCCtl );
      chkConveLicNecAut.setWebtags( "" );
      chkConveLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "TitleCaption", chkConveLicNecAut.getCaption(), !bGXsfl_110_Refreshing);
      chkConveLicNecAut.setCheckedValue( "false" );
      A1617ConveLicNecAut = GXutil.strtobool( GXutil.booltostr( A1617ConveLicNecAut)) ;
      GXCCtl = "CONVELICINGMOT_" + sGXsfl_110_idx ;
      chkConveLicIngMot.setName( GXCCtl );
      chkConveLicIngMot.setWebtags( "" );
      chkConveLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "TitleCaption", chkConveLicIngMot.getCaption(), !bGXsfl_110_Refreshing);
      chkConveLicIngMot.setCheckedValue( "false" );
      A1618ConveLicIngMot = GXutil.strtobool( GXutil.booltostr( A1618ConveLicIngMot)) ;
      GXCCtl = "CONVELICMOTOBL_" + sGXsfl_110_idx ;
      chkConveLicMotObl.setName( GXCCtl );
      chkConveLicMotObl.setWebtags( "" );
      chkConveLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "TitleCaption", chkConveLicMotObl.getCaption(), !bGXsfl_110_Refreshing);
      chkConveLicMotObl.setCheckedValue( "false" );
      A1619ConveLicMotObl = GXutil.strtobool( GXutil.booltostr( A1619ConveLicMotObl)) ;
      GXCCtl = "CONVEBASEPROMTCNT_" + sGXsfl_110_idx ;
      cmbConveBasePromTCnt.setName( GXCCtl );
      cmbConveBasePromTCnt.setWebtags( "" );
      cmbConveBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbConveBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbConveBasePromTCnt.getItemCount() > 0 )
      {
         A1467ConveBasePromTCnt = cmbConveBasePromTCnt.getValidValue(A1467ConveBasePromTCnt) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBaseC1Txt_Title',ctrl:'CONVEBASEC1TXT',prop:'Title'},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV108Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConveBaseC1Txt_Visible',ctrl:'CONVEBASEC1TXT',prop:'Visible'},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBasePlus_Visible',ctrl:'CONVEBASEPLUS',prop:'Visible'},{av:'edtConveLicDLim_Visible',ctrl:'CONVELICDLIM',prop:'Visible'},{av:'edtConveLicDSeman_Visible',ctrl:'CONVELICDSEMAN',prop:'Visible'},{av:'cmbConveLicDMes'},{av:'edtConveLicDSemes_Visible',ctrl:'CONVELICDSEMES',prop:'Visible'},{av:'edtConveLicDAnual_Visible',ctrl:'CONVELICDANUAL',prop:'Visible'},{av:'chkConveLicAdju.getVisible()',ctrl:'CONVELICADJU',prop:'Visible'},{av:'chkConveLicAdjuObl.getVisible()',ctrl:'CONVELICADJUOBL',prop:'Visible'},{av:'chkConveLicNecAut.getVisible()',ctrl:'CONVELICNECAUT',prop:'Visible'},{av:'chkConveLicIngMot.getVisible()',ctrl:'CONVELICINGMOT',prop:'Visible'},{av:'chkConveLicMotObl.getVisible()',ctrl:'CONVELICMOTOBL',prop:'Visible'},{av:'edtConveBasePromCnt1_Visible',ctrl:'CONVEBASEPROMCNT1',prop:'Visible'},{av:'edtConveBasePromCnt2_Visible',ctrl:'CONVEBASEPROMCNT2',prop:'Visible'},{av:'cmbConveBasePromTCnt'},{av:'edtConveBaseRelRef_Visible',ctrl:'CONVEBASERELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV60GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV61GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV62GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV93ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e13EZ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV108Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBaseC1Txt_Title',ctrl:'CONVEBASEC1TXT',prop:'Title'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e14EZ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV108Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBaseC1Txt_Title',ctrl:'CONVEBASEC1TXT',prop:'Title'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15EZ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV108Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBaseC1Txt_Title',ctrl:'CONVEBASEC1TXT',prop:'Title'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV88TFConveBaseRelRef_SelsJson',fld:'vTFCONVEBASERELREF_SELSJSON',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV56TFConveBasePromTCnt_SelsJson',fld:'vTFCONVEBASEPROMTCNT_SELSJSON',pic:''},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV41TFConveLicDMes_SelsJson',fld:'vTFCONVELICDMES_SELSJSON',pic:''},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e20EZ2',iparms:[{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'cmbConveBaseClaseLeg'},{av:'A1454ConveBaseClaseLeg',fld:'CONVEBASECLASELEG',pic:'9'},{av:'cmbConveBaseTipo'},{av:'A1455ConveBaseTipo',fld:'CONVEBASETIPO',pic:''},{av:'A1456ConveBaseCod1',fld:'CONVEBASECOD1',pic:''},{av:'A1457ConveBaseCod2',fld:'CONVEBASECOD2',pic:''},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV63Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV65Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV78Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'edtavVersvg_Format',ctrl:'vVERSVG',prop:'Format'},{av:'AV75VerSVG',fld:'vVERSVG',pic:''},{av:'edtavVersvg_Link',ctrl:'vVERSVG',prop:'Link'},{av:'edtavVersvg_Columnclass',ctrl:'vVERSVG',prop:'Columnclass'},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'edtavModificarsvg_Format',ctrl:'vMODIFICARSVG',prop:'Format'},{av:'AV76ModificarSVG',fld:'vMODIFICARSVG',pic:''},{av:'edtavModificarsvg_Link',ctrl:'vMODIFICARSVG',prop:'Link'},{av:'edtavModificarsvg_Columnclass',ctrl:'vMODIFICARSVG',prop:'Columnclass'},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'edtavEliminarsvg_Format',ctrl:'vELIMINARSVG',prop:'Format'},{av:'AV77EliminarSVG',fld:'vELIMINARSVG',pic:''},{av:'edtavEliminarsvg_Link',ctrl:'vELIMINARSVG',prop:'Link'},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'}]}");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED","{handler:'e11EZ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV108Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBaseC1Txt_Title',ctrl:'CONVEBASEC1TXT',prop:'Title'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_gridcolumnsselector_Columnsselectorvalues',ctrl:'DDO_GRIDCOLUMNSSELECTOR',prop:'ColumnsSelectorValues'}]");
      setEventMetadata("DDO_GRIDCOLUMNSSELECTOR.ONCOLUMNSCHANGED",",oparms:[{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'edtConveBaseC1Txt_Visible',ctrl:'CONVEBASEC1TXT',prop:'Visible'},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBasePlus_Visible',ctrl:'CONVEBASEPLUS',prop:'Visible'},{av:'edtConveLicDLim_Visible',ctrl:'CONVELICDLIM',prop:'Visible'},{av:'edtConveLicDSeman_Visible',ctrl:'CONVELICDSEMAN',prop:'Visible'},{av:'cmbConveLicDMes'},{av:'edtConveLicDSemes_Visible',ctrl:'CONVELICDSEMES',prop:'Visible'},{av:'edtConveLicDAnual_Visible',ctrl:'CONVELICDANUAL',prop:'Visible'},{av:'chkConveLicAdju.getVisible()',ctrl:'CONVELICADJU',prop:'Visible'},{av:'chkConveLicAdjuObl.getVisible()',ctrl:'CONVELICADJUOBL',prop:'Visible'},{av:'chkConveLicNecAut.getVisible()',ctrl:'CONVELICNECAUT',prop:'Visible'},{av:'chkConveLicIngMot.getVisible()',ctrl:'CONVELICINGMOT',prop:'Visible'},{av:'chkConveLicMotObl.getVisible()',ctrl:'CONVELICMOTOBL',prop:'Visible'},{av:'edtConveBasePromCnt1_Visible',ctrl:'CONVEBASEPROMCNT1',prop:'Visible'},{av:'edtConveBasePromCnt2_Visible',ctrl:'CONVEBASEPROMCNT2',prop:'Visible'},{av:'cmbConveBasePromTCnt'},{av:'edtConveBaseRelRef_Visible',ctrl:'CONVEBASERELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV60GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV61GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV62GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV93ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e12EZ2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'AV108Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBaseC1Txt_Title',ctrl:'CONVEBASEC1TXT',prop:'Title'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV41TFConveLicDMes_SelsJson',fld:'vTFCONVELICDMES_SELSJSON',pic:''},{av:'AV56TFConveBasePromTCnt_SelsJson',fld:'vTFCONVEBASEPROMTCNT_SELSJSON',pic:''},{av:'AV88TFConveBaseRelRef_SelsJson',fld:'vTFCONVEBASERELREF_SELSJSON',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV95ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV13GridState',fld:'vGRIDSTATE',pic:''},{av:'AV15OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV16OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV35TFConveBasePlus',fld:'vTFCONVEBASEPLUS',pic:'9.9999'},{av:'AV36TFConveBasePlus_To',fld:'vTFCONVEBASEPLUS_TO',pic:'9.9999'},{av:'AV37TFConveLicDLim',fld:'vTFCONVELICDLIM',pic:'ZZ9'},{av:'AV38TFConveLicDLim_To',fld:'vTFCONVELICDLIM_TO',pic:'ZZ9'},{av:'AV39TFConveLicDSeman',fld:'vTFCONVELICDSEMAN',pic:'9'},{av:'AV40TFConveLicDSeman_To',fld:'vTFCONVELICDSEMAN_TO',pic:'9'},{av:'AV42TFConveLicDMes_Sels',fld:'vTFCONVELICDMES_SELS',pic:''},{av:'AV43TFConveLicDSemes',fld:'vTFCONVELICDSEMES',pic:'ZZ9'},{av:'AV44TFConveLicDSemes_To',fld:'vTFCONVELICDSEMES_TO',pic:'ZZ9'},{av:'AV45TFConveLicDAnual',fld:'vTFCONVELICDANUAL',pic:'ZZ9'},{av:'AV46TFConveLicDAnual_To',fld:'vTFCONVELICDANUAL_TO',pic:'ZZ9'},{av:'AV47TFConveLicAdju_Sel',fld:'vTFCONVELICADJU_SEL',pic:'9'},{av:'AV48TFConveLicAdjuObl_Sel',fld:'vTFCONVELICADJUOBL_SEL',pic:'9'},{av:'AV49TFConveLicNecAut_Sel',fld:'vTFCONVELICNECAUT_SEL',pic:'9'},{av:'AV50TFConveLicIngMot_Sel',fld:'vTFCONVELICINGMOT_SEL',pic:'9'},{av:'AV51TFConveLicMotObl_Sel',fld:'vTFCONVELICMOTOBL_SEL',pic:'9'},{av:'AV52TFConveBasePromCnt1',fld:'vTFCONVEBASEPROMCNT1',pic:'ZZ9'},{av:'AV53TFConveBasePromCnt1_To',fld:'vTFCONVEBASEPROMCNT1_TO',pic:'ZZ9'},{av:'AV54TFConveBasePromCnt2',fld:'vTFCONVEBASEPROMCNT2',pic:'ZZ9'},{av:'AV55TFConveBasePromCnt2_To',fld:'vTFCONVEBASEPROMCNT2_TO',pic:'ZZ9'},{av:'AV57TFConveBasePromTCnt_Sels',fld:'vTFCONVEBASEPROMTCNT_SELS',pic:''},{av:'AV89TFConveBaseRelRef',fld:'vTFCONVEBASERELREF',pic:''},{av:'AV90TFConveBaseRelRef_Sels',fld:'vTFCONVEBASERELREF_SELS',pic:''},{av:'Ddo_grid_Selectedvalue_set',ctrl:'DDO_GRID',prop:'SelectedValue_set'},{av:'Ddo_grid_Filteredtext_set',ctrl:'DDO_GRID',prop:'FilteredText_set'},{av:'Ddo_grid_Filteredtextto_set',ctrl:'DDO_GRID',prop:'FilteredTextTo_set'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV88TFConveBaseRelRef_SelsJson',fld:'vTFCONVEBASERELREF_SELSJSON',pic:''},{av:'AV56TFConveBasePromTCnt_SelsJson',fld:'vTFCONVEBASEPROMTCNT_SELSJSON',pic:''},{av:'AV41TFConveLicDMes_SelsJson',fld:'vTFCONVELICDMES_SELSJSON',pic:''},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV20ColumnsSelector',fld:'vCOLUMNSSELECTOR',pic:''},{av:'edtConveBaseC1Txt_Visible',ctrl:'CONVEBASEC1TXT',prop:'Visible'},{av:'edtConveBaseC2Txt_Visible',ctrl:'CONVEBASEC2TXT',prop:'Visible'},{av:'edtConveBasePlus_Visible',ctrl:'CONVEBASEPLUS',prop:'Visible'},{av:'edtConveLicDLim_Visible',ctrl:'CONVELICDLIM',prop:'Visible'},{av:'edtConveLicDSeman_Visible',ctrl:'CONVELICDSEMAN',prop:'Visible'},{av:'cmbConveLicDMes'},{av:'edtConveLicDSemes_Visible',ctrl:'CONVELICDSEMES',prop:'Visible'},{av:'edtConveLicDAnual_Visible',ctrl:'CONVELICDANUAL',prop:'Visible'},{av:'chkConveLicAdju.getVisible()',ctrl:'CONVELICADJU',prop:'Visible'},{av:'chkConveLicAdjuObl.getVisible()',ctrl:'CONVELICADJUOBL',prop:'Visible'},{av:'chkConveLicNecAut.getVisible()',ctrl:'CONVELICNECAUT',prop:'Visible'},{av:'chkConveLicIngMot.getVisible()',ctrl:'CONVELICINGMOT',prop:'Visible'},{av:'chkConveLicMotObl.getVisible()',ctrl:'CONVELICMOTOBL',prop:'Visible'},{av:'edtConveBasePromCnt1_Visible',ctrl:'CONVEBASEPROMCNT1',prop:'Visible'},{av:'edtConveBasePromCnt2_Visible',ctrl:'CONVEBASEPROMCNT2',prop:'Visible'},{av:'cmbConveBasePromTCnt'},{av:'edtConveBaseRelRef_Visible',ctrl:'CONVEBASERELREF',prop:'Visible'},{av:'edtavVersvg_Visible',ctrl:'vVERSVG',prop:'Visible'},{av:'edtavModificarsvg_Visible',ctrl:'vMODIFICARSVG',prop:'Visible'},{av:'edtavEliminarsvg_Visible',ctrl:'vELIMINARSVG',prop:'Visible'},{av:'AV60GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV61GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV62GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'lblCouttext_Caption',ctrl:'COUTTEXT',prop:'Caption'},{av:'lblCouttext_Visible',ctrl:'COUTTEXT',prop:'Visible'},{av:'lblButtonfilter1_textblockbadgecount_Caption',ctrl:'BUTTONFILTER1_TEXTBLOCKBADGECOUNT',prop:'Caption'},{av:'tblButtonfilter1_tablebadge_Tooltiptext',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Tooltiptext'},{av:'tblButtonfilter1_tablebadge_Visible',ctrl:'BUTTONFILTER1_TABLEBADGE',prop:'Visible'},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV66IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{ctrl:'BTNINSERT',prop:'Visible'},{av:'AV93ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e22EZ1',iparms:[{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV71PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV72CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV8ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV9ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[]}");
      setEventMetadata("'DOEXPORT'","{handler:'e16EZ2',iparms:[]");
      setEventMetadata("'DOEXPORT'",",oparms:[]}");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK","{handler:'e17EZ2',iparms:[{av:'AV81WelcomeMessage_NoMostrarMas',fld:'vWELCOMEMESSAGE_NOMOSTRARMAS',pic:''},{av:'AV79MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV69CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",",oparms:[{av:'lblWelcomemessage_combotext_Caption',ctrl:'WELCOMEMESSAGE_COMBOTEXT',prop:'Caption'}]}");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK","{handler:'e21EZ1',iparms:[]");
      setEventMetadata("WELCOMEMESSAGE_CLOSEHELP.CLICK",",oparms:[{av:'divWelcomemessage_welcometableparent_Visible',ctrl:'WELCOMEMESSAGE_WELCOMETABLEPARENT',prop:'Visible'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CONVEBASETIPO","{handler:'valid_Convebasetipo',iparms:[]");
      setEventMetadata("VALID_CONVEBASETIPO",",oparms:[]}");
      setEventMetadata("VALID_CONVEBASECOD1","{handler:'valid_Convebasecod1',iparms:[]");
      setEventMetadata("VALID_CONVEBASECOD1",",oparms:[]}");
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
      wcpOAV79MenuOpcCod = "" ;
      wcpOAV9ConveBaseTipo = "" ;
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
      AV79MenuOpcCod = "" ;
      AV9ConveBaseTipo = "" ;
      AV72CliConvenio = "" ;
      AV20ColumnsSelector = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV108Pgmname = "" ;
      AV13GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV35TFConveBasePlus = DecimalUtil.ZERO ;
      AV36TFConveBasePlus_To = DecimalUtil.ZERO ;
      AV42TFConveLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV57TFConveBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV89TFConveBaseRelRef = "" ;
      AV90TFConveBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV58DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV93ManageFiltersData = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV62GridAppliedFilters = "" ;
      AV41TFConveLicDMes_SelsJson = "" ;
      AV56TFConveBasePromTCnt_SelsJson = "" ;
      AV88TFConveBaseRelRef_SelsJson = "" ;
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
      A1455ConveBaseTipo = "" ;
      A1456ConveBaseCod1 = "" ;
      A1608ConveBaseC1Txt = "" ;
      A1457ConveBaseCod2 = "" ;
      A1609ConveBaseC2Txt = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      A1467ConveBasePromTCnt = "" ;
      A2061ConveBaseRelRef = "" ;
      AV63Update = "" ;
      AV65Delete = "" ;
      AV78Display = "" ;
      AV75VerSVG = "" ;
      AV76ModificarSVG = "" ;
      AV77EliminarSVG = "" ;
      AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV132Convenio_base_calculowwds_24_tfconvebaserelref = "" ;
      AV111Convenio_base_calculowwds_3_tfconvebaseplus = DecimalUtil.ZERO ;
      AV112Convenio_base_calculowwds_4_tfconvebaseplus_to = DecimalUtil.ZERO ;
      AV132Convenio_base_calculowwds_24_tfconvebaserelref = "" ;
      AV110Convenio_base_calculowwds_2_convebasetipo = "" ;
      H00EZ2_A2061ConveBaseRelRef = new String[] {""} ;
      H00EZ2_A1467ConveBasePromTCnt = new String[] {""} ;
      H00EZ2_A1466ConveBasePromCnt2 = new short[1] ;
      H00EZ2_A1465ConveBasePromCnt1 = new short[1] ;
      H00EZ2_A1619ConveLicMotObl = new boolean[] {false} ;
      H00EZ2_A1618ConveLicIngMot = new boolean[] {false} ;
      H00EZ2_A1617ConveLicNecAut = new boolean[] {false} ;
      H00EZ2_A1616ConveLicAdjuObl = new boolean[] {false} ;
      H00EZ2_A1615ConveLicAdju = new boolean[] {false} ;
      H00EZ2_A1614ConveLicDAnual = new short[1] ;
      H00EZ2_A1613ConveLicDSemes = new short[1] ;
      H00EZ2_A1612ConveLicDMes = new byte[1] ;
      H00EZ2_A1611ConveLicDSeman = new byte[1] ;
      H00EZ2_A1610ConveLicDLim = new short[1] ;
      H00EZ2_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00EZ2_A1457ConveBaseCod2 = new String[] {""} ;
      H00EZ2_A1454ConveBaseClaseLeg = new byte[1] ;
      H00EZ2_A1565CliConvenio = new String[] {""} ;
      H00EZ2_A1564CliPaiConve = new short[1] ;
      H00EZ2_A1456ConveBaseCod1 = new String[] {""} ;
      H00EZ2_A1455ConveBaseTipo = new String[] {""} ;
      H00EZ2_A3CliCod = new int[1] ;
      H00EZ3_AGRID_nRecordCount = new long[1] ;
      AV87WelcomeMessage_Foto = "" ;
      ucDdo_gridcolumnsselector = new com.genexus.webpanels.GXUserControl();
      AV10HTTPRequest = httpContext.getHttpRequest();
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      AV82MenuBienveImgURL = "" ;
      GXv_char2 = new String[1] ;
      AV84MenuBienveTitulo = "" ;
      AV85MenuBienveTexto = "" ;
      AV107Welcomemessage_foto_GXI = "" ;
      AV104observerPalabra = "" ;
      ucButtonexport1_a3lexport = new com.genexus.webpanels.GXUserControl();
      ucButtonfilter1_a3lfilter = new com.genexus.webpanels.GXUserControl();
      GXv_int4 = new int[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext12 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV22Session = httpContext.getWebSession();
      AV18ColumnsSelectorXML = "" ;
      AV100MenuOpcTitulo = "" ;
      GXv_int11 = new short[1] ;
      AV103filtrosTexto = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV94ManageFiltersXml = "" ;
      AV91ExcelFilename = "" ;
      AV92ErrorMessage = "" ;
      AV19UserCustomValue = "" ;
      AV21ColumnsSelectorAux = new web.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector13 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector14 = new web.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17 = new GXBaseCollection[1] ;
      AV14GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char10 = "" ;
      GXv_SdtWWPGridState18 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV83textoNoMostrara = "" ;
      GXv_char8 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_base_calculoww__default(),
         new Object[] {
             new Object[] {
            H00EZ2_A2061ConveBaseRelRef, H00EZ2_A1467ConveBasePromTCnt, H00EZ2_A1466ConveBasePromCnt2, H00EZ2_A1465ConveBasePromCnt1, H00EZ2_A1619ConveLicMotObl, H00EZ2_A1618ConveLicIngMot, H00EZ2_A1617ConveLicNecAut, H00EZ2_A1616ConveLicAdjuObl, H00EZ2_A1615ConveLicAdju, H00EZ2_A1614ConveLicDAnual,
            H00EZ2_A1613ConveLicDSemes, H00EZ2_A1612ConveLicDMes, H00EZ2_A1611ConveLicDSeman, H00EZ2_A1610ConveLicDLim, H00EZ2_A1458ConveBasePlus, H00EZ2_A1457ConveBaseCod2, H00EZ2_A1454ConveBaseClaseLeg, H00EZ2_A1565CliConvenio, H00EZ2_A1564CliPaiConve, H00EZ2_A1456ConveBaseCod1,
            H00EZ2_A1455ConveBaseTipo, H00EZ2_A3CliCod
            }
            , new Object[] {
            H00EZ3_AGRID_nRecordCount
            }
         }
      );
      AV108Pgmname = "Convenio_base_calculoWW" ;
      /* GeneXus formulas. */
      AV108Pgmname = "Convenio_base_calculoWW" ;
      Gx_err = (short)(0) ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDisplay_Enabled = 0 ;
      edtavVersvg_Enabled = 0 ;
      edtavModificarsvg_Enabled = 0 ;
      edtavEliminarsvg_Enabled = 0 ;
   }

   private byte wcpOAV8ConveBaseClaseLeg ;
   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV8ConveBaseClaseLeg ;
   private byte AV95ManageFiltersExecutionStep ;
   private byte AV39TFConveLicDSeman ;
   private byte AV40TFConveLicDSeman_To ;
   private byte AV47TFConveLicAdju_Sel ;
   private byte AV48TFConveLicAdjuObl_Sel ;
   private byte AV49TFConveLicNecAut_Sel ;
   private byte AV50TFConveLicIngMot_Sel ;
   private byte AV51TFConveLicMotObl_Sel ;
   private byte gxajaxcallmode ;
   private byte A1454ConveBaseClaseLeg ;
   private byte A1611ConveLicDSeman ;
   private byte A1612ConveLicDMes ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte AV115Convenio_base_calculowwds_7_tfconvelicdseman ;
   private byte AV116Convenio_base_calculowwds_8_tfconvelicdseman_to ;
   private byte AV122Convenio_base_calculowwds_14_tfconvelicadju_sel ;
   private byte AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ;
   private byte AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel ;
   private byte AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel ;
   private byte AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel ;
   private byte AV109Convenio_base_calculowwds_1_convebaseclaseleg ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV71PaiCod ;
   private short AV37TFConveLicDLim ;
   private short AV38TFConveLicDLim_To ;
   private short AV43TFConveLicDSemes ;
   private short AV44TFConveLicDSemes_To ;
   private short AV45TFConveLicDAnual ;
   private short AV46TFConveLicDAnual_To ;
   private short AV52TFConveBasePromCnt1 ;
   private short AV53TFConveBasePromCnt1_To ;
   private short AV54TFConveBasePromCnt2 ;
   private short AV55TFConveBasePromCnt2_To ;
   private short AV15OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A1564CliPaiConve ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV113Convenio_base_calculowwds_5_tfconvelicdlim ;
   private short AV114Convenio_base_calculowwds_6_tfconvelicdlim_to ;
   private short AV118Convenio_base_calculowwds_10_tfconvelicdsemes ;
   private short AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to ;
   private short AV120Convenio_base_calculowwds_12_tfconvelicdanual ;
   private short AV121Convenio_base_calculowwds_13_tfconvelicdanual_to ;
   private short AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 ;
   private short AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ;
   private short AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 ;
   private short AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ;
   private short GXv_int11[] ;
   private short edtavVersvg_Format ;
   private short edtavModificarsvg_Format ;
   private short edtavEliminarsvg_Format ;
   private int edtConveBaseC2Txt_Visible ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_110 ;
   private int nGXsfl_110_idx=1 ;
   private int AV69CliCod ;
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
   private int AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ;
   private int AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ;
   private int AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ;
   private int divWelcomemessage_welcometableparent_Visible ;
   private int bttBtnexport_Visible ;
   private int divButtonfilter1_tablecontent_Visible ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int edtConveBaseC1Txt_Visible ;
   private int edtConveBasePlus_Visible ;
   private int edtConveLicDLim_Visible ;
   private int edtConveLicDSeman_Visible ;
   private int edtConveLicDSemes_Visible ;
   private int edtConveLicDAnual_Visible ;
   private int edtConveBasePromCnt1_Visible ;
   private int edtConveBasePromCnt2_Visible ;
   private int edtConveBaseRelRef_Visible ;
   private int edtavVersvg_Visible ;
   private int edtavModificarsvg_Visible ;
   private int edtavEliminarsvg_Visible ;
   private int lblCouttext_Visible ;
   private int AV102filterCount ;
   private int tblButtonfilter1_tablebadge_Visible ;
   private int AV59PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int bttBtninsert_Visible ;
   private int AV134GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV60GridCurrentPage ;
   private long AV61GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV35TFConveBasePlus ;
   private java.math.BigDecimal AV36TFConveBasePlus_To ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private java.math.BigDecimal AV111Convenio_base_calculowwds_3_tfconvebaseplus ;
   private java.math.BigDecimal AV112Convenio_base_calculowwds_4_tfconvebaseplus_to ;
   private String wcpOAV9ConveBaseTipo ;
   private String edtConveBaseC1Txt_Title ;
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
   private String AV9ConveBaseTipo ;
   private String sGXsfl_110_idx="0001" ;
   private String edtConveBaseC2Txt_Internalname ;
   private String edtConveBaseC1Txt_Internalname ;
   private String AV72CliConvenio ;
   private String AV108Pgmname ;
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
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String edtConveBaseCod1_Internalname ;
   private String A1457ConveBaseCod2 ;
   private String edtConveBaseCod2_Internalname ;
   private String edtConveBasePlus_Internalname ;
   private String edtConveLicDLim_Internalname ;
   private String edtConveLicDSeman_Internalname ;
   private String edtConveLicDSemes_Internalname ;
   private String edtConveLicDAnual_Internalname ;
   private String edtConveBasePromCnt1_Internalname ;
   private String edtConveBasePromCnt2_Internalname ;
   private String A1467ConveBasePromTCnt ;
   private String edtConveBaseRelRef_Internalname ;
   private String AV63Update ;
   private String edtavUpdate_Internalname ;
   private String AV65Delete ;
   private String edtavDelete_Internalname ;
   private String AV78Display ;
   private String edtavDisplay_Internalname ;
   private String AV75VerSVG ;
   private String edtavVersvg_Internalname ;
   private String AV76ModificarSVG ;
   private String edtavModificarsvg_Internalname ;
   private String AV77EliminarSVG ;
   private String edtavEliminarsvg_Internalname ;
   private String scmdbuf ;
   private String AV110Convenio_base_calculowwds_2_convebasetipo ;
   private String imgavWelcomemessage_foto_Internalname ;
   private String Ddo_gridcolumnsselector_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String GXv_char2[] ;
   private String divWelcomemessage_welcometableparent_Internalname ;
   private String lblWelcomemessage_titulo_Caption ;
   private String lblWelcomemessage_titulo_Internalname ;
   private String lblWelcomemessage_descripcion_Caption ;
   private String lblWelcomemessage_descripcion_Internalname ;
   private String lblWelcomemessage_closehelp_Caption ;
   private String lblWelcomemessage_closehelp_Internalname ;
   private String AV104observerPalabra ;
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
   private String GXt_char1 ;
   private String GXv_char7[] ;
   private String GXt_char10 ;
   private String GXv_char8[] ;
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
   private String GXCCtl ;
   private String edtConveBaseCod1_Jsonclick ;
   private String edtConveBaseC1Txt_Jsonclick ;
   private String edtConveBaseCod2_Jsonclick ;
   private String edtConveBaseC2Txt_Jsonclick ;
   private String edtConveBasePlus_Jsonclick ;
   private String edtConveLicDLim_Jsonclick ;
   private String edtConveLicDSeman_Jsonclick ;
   private String edtConveLicDSemes_Jsonclick ;
   private String edtConveLicDAnual_Jsonclick ;
   private String edtConveBasePromCnt1_Jsonclick ;
   private String edtConveBasePromCnt2_Jsonclick ;
   private String edtConveBaseRelRef_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDisplay_Jsonclick ;
   private String edtavVersvg_Jsonclick ;
   private String edtavModificarsvg_Jsonclick ;
   private String edtavEliminarsvg_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_110_Refreshing=false ;
   private boolean AV16OrderedDsc ;
   private boolean AV64IsAuthorized_Update ;
   private boolean AV66IsAuthorized_Delete ;
   private boolean AV81WelcomeMessage_NoMostrarMas ;
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
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV86MenuBienveVisible ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean AV67TempBoolean ;
   private boolean GXt_boolean15 ;
   private boolean GXv_boolean9[] ;
   private boolean AV87WelcomeMessage_Foto_IsBlob ;
   private String AV41TFConveLicDMes_SelsJson ;
   private String AV56TFConveBasePromTCnt_SelsJson ;
   private String AV88TFConveBaseRelRef_SelsJson ;
   private String AV85MenuBienveTexto ;
   private String AV18ColumnsSelectorXML ;
   private String AV94ManageFiltersXml ;
   private String AV19UserCustomValue ;
   private String AV83textoNoMostrara ;
   private String wcpOAV79MenuOpcCod ;
   private String AV79MenuOpcCod ;
   private String AV89TFConveBaseRelRef ;
   private String AV62GridAppliedFilters ;
   private String A1608ConveBaseC1Txt ;
   private String A1609ConveBaseC2Txt ;
   private String A2061ConveBaseRelRef ;
   private String lV132Convenio_base_calculowwds_24_tfconvebaserelref ;
   private String AV132Convenio_base_calculowwds_24_tfconvebaserelref ;
   private String AV82MenuBienveImgURL ;
   private String AV84MenuBienveTitulo ;
   private String AV107Welcomemessage_foto_GXI ;
   private String AV100MenuOpcTitulo ;
   private String AV103filtrosTexto ;
   private String AV91ExcelFilename ;
   private String AV92ErrorMessage ;
   private String AV87WelcomeMessage_Foto ;
   private GXSimpleCollection<Byte> AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels ;
   private GXSimpleCollection<Byte> AV42TFConveLicDMes_Sels ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV10HTTPRequest ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_gridcolumnsselector ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucButtonexport1_a3lexport ;
   private com.genexus.webpanels.GXUserControl ucButtonfilter1_a3lfilter ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private GXSimpleCollection<String> AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ;
   private GXSimpleCollection<String> AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels ;
   private ICheckbox chkavWelcomemessage_nomostrarmas ;
   private HTMLChoice cmbConveBaseClaseLeg ;
   private HTMLChoice cmbConveBaseTipo ;
   private HTMLChoice cmbConveLicDMes ;
   private ICheckbox chkConveLicAdju ;
   private ICheckbox chkConveLicAdjuObl ;
   private ICheckbox chkConveLicNecAut ;
   private ICheckbox chkConveLicIngMot ;
   private ICheckbox chkConveLicMotObl ;
   private HTMLChoice cmbConveBasePromTCnt ;
   private IDataStoreProvider pr_default ;
   private String[] H00EZ2_A2061ConveBaseRelRef ;
   private String[] H00EZ2_A1467ConveBasePromTCnt ;
   private short[] H00EZ2_A1466ConveBasePromCnt2 ;
   private short[] H00EZ2_A1465ConveBasePromCnt1 ;
   private boolean[] H00EZ2_A1619ConveLicMotObl ;
   private boolean[] H00EZ2_A1618ConveLicIngMot ;
   private boolean[] H00EZ2_A1617ConveLicNecAut ;
   private boolean[] H00EZ2_A1616ConveLicAdjuObl ;
   private boolean[] H00EZ2_A1615ConveLicAdju ;
   private short[] H00EZ2_A1614ConveLicDAnual ;
   private short[] H00EZ2_A1613ConveLicDSemes ;
   private byte[] H00EZ2_A1612ConveLicDMes ;
   private byte[] H00EZ2_A1611ConveLicDSeman ;
   private short[] H00EZ2_A1610ConveLicDLim ;
   private java.math.BigDecimal[] H00EZ2_A1458ConveBasePlus ;
   private String[] H00EZ2_A1457ConveBaseCod2 ;
   private byte[] H00EZ2_A1454ConveBaseClaseLeg ;
   private String[] H00EZ2_A1565CliConvenio ;
   private short[] H00EZ2_A1564CliPaiConve ;
   private String[] H00EZ2_A1456ConveBaseCod1 ;
   private String[] H00EZ2_A1455ConveBaseTipo ;
   private int[] H00EZ2_A3CliCod ;
   private long[] H00EZ3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV57TFConveBasePromTCnt_Sels ;
   private GXSimpleCollection<String> AV90TFConveBaseRelRef_Sels ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV93ManageFiltersData ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item16 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item17[] ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext12[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV12TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV13GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState18[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV14GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV20ColumnsSelector ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector AV21ColumnsSelectorAux ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector13[] ;
   private web.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector14[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV58DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons6[] ;
}

final  class convenio_base_calculoww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00EZ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1612ConveLicDMes ,
                                          GXSimpleCollection<Byte> AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                          String A1467ConveBasePromTCnt ,
                                          GXSimpleCollection<String> AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                          String A2061ConveBaseRelRef ,
                                          GXSimpleCollection<String> AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                          java.math.BigDecimal AV111Convenio_base_calculowwds_3_tfconvebaseplus ,
                                          java.math.BigDecimal AV112Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                          short AV113Convenio_base_calculowwds_5_tfconvelicdlim ,
                                          short AV114Convenio_base_calculowwds_6_tfconvelicdlim_to ,
                                          byte AV115Convenio_base_calculowwds_7_tfconvelicdseman ,
                                          byte AV116Convenio_base_calculowwds_8_tfconvelicdseman_to ,
                                          int AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ,
                                          short AV118Convenio_base_calculowwds_10_tfconvelicdsemes ,
                                          short AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to ,
                                          short AV120Convenio_base_calculowwds_12_tfconvelicdanual ,
                                          short AV121Convenio_base_calculowwds_13_tfconvelicdanual_to ,
                                          byte AV122Convenio_base_calculowwds_14_tfconvelicadju_sel ,
                                          byte AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ,
                                          byte AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel ,
                                          byte AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel ,
                                          byte AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel ,
                                          short AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 ,
                                          short AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ,
                                          short AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 ,
                                          short AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ,
                                          int AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ,
                                          int AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ,
                                          String AV132Convenio_base_calculowwds_24_tfconvebaserelref ,
                                          String AV72CliConvenio ,
                                          java.math.BigDecimal A1458ConveBasePlus ,
                                          short A1610ConveLicDLim ,
                                          byte A1611ConveLicDSeman ,
                                          short A1613ConveLicDSemes ,
                                          short A1614ConveLicDAnual ,
                                          boolean A1615ConveLicAdju ,
                                          boolean A1616ConveLicAdjuObl ,
                                          boolean A1617ConveLicNecAut ,
                                          boolean A1618ConveLicIngMot ,
                                          boolean A1619ConveLicMotObl ,
                                          short A1465ConveBasePromCnt1 ,
                                          short A1466ConveBasePromCnt2 ,
                                          String A1565CliConvenio ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          byte A1454ConveBaseClaseLeg ,
                                          byte AV109Convenio_base_calculowwds_1_convebaseclaseleg ,
                                          String A1455ConveBaseTipo ,
                                          String AV110Convenio_base_calculowwds_2_convebasetipo ,
                                          int AV69CliCod ,
                                          short AV71PaiCod ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[23];
      Object[] GXv_Object20 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ConveBaseRelRef, ConveBasePromTCnt, ConveBasePromCnt2, ConveBasePromCnt1, ConveLicMotObl, ConveLicIngMot, ConveLicNecAut, ConveLicAdjuObl, ConveLicAdju, ConveLicDAnual," ;
      sSelectString += " ConveLicDSemes, ConveLicDMes, ConveLicDSeman, ConveLicDLim, ConveBasePlus, ConveBaseCod2, ConveBaseClaseLeg, CliConvenio, CliPaiConve, ConveBaseCod1, ConveBaseTipo," ;
      sSelectString += " CliCod" ;
      sFromString = " FROM Convenio_base_calculo" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ?)");
      addWhere(sWhereString, "(ConveBaseClaseLeg = ?)");
      addWhere(sWhereString, "(ConveBaseTipo = ( ?))");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Convenio_base_calculowwds_3_tfconvebaseplus)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus >= ?)");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Convenio_base_calculowwds_4_tfconvebaseplus_to)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus <= ?)");
      }
      else
      {
         GXv_int19[5] = (byte)(1) ;
      }
      if ( ! (0==AV113Convenio_base_calculowwds_5_tfconvelicdlim) )
      {
         addWhere(sWhereString, "(ConveLicDLim >= ?)");
      }
      else
      {
         GXv_int19[6] = (byte)(1) ;
      }
      if ( ! (0==AV114Convenio_base_calculowwds_6_tfconvelicdlim_to) )
      {
         addWhere(sWhereString, "(ConveLicDLim <= ?)");
      }
      else
      {
         GXv_int19[7] = (byte)(1) ;
      }
      if ( ! (0==AV115Convenio_base_calculowwds_7_tfconvelicdseman) )
      {
         addWhere(sWhereString, "(ConveLicDSeman >= ?)");
      }
      else
      {
         GXv_int19[8] = (byte)(1) ;
      }
      if ( ! (0==AV116Convenio_base_calculowwds_8_tfconvelicdseman_to) )
      {
         addWhere(sWhereString, "(ConveLicDSeman <= ?)");
      }
      else
      {
         GXv_int19[9] = (byte)(1) ;
      }
      if ( AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels, "ConveLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV118Convenio_base_calculowwds_10_tfconvelicdsemes) )
      {
         addWhere(sWhereString, "(ConveLicDSemes >= ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ! (0==AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to) )
      {
         addWhere(sWhereString, "(ConveLicDSemes <= ?)");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      if ( ! (0==AV120Convenio_base_calculowwds_12_tfconvelicdanual) )
      {
         addWhere(sWhereString, "(ConveLicDAnual >= ?)");
      }
      else
      {
         GXv_int19[12] = (byte)(1) ;
      }
      if ( ! (0==AV121Convenio_base_calculowwds_13_tfconvelicdanual_to) )
      {
         addWhere(sWhereString, "(ConveLicDAnual <= ?)");
      }
      else
      {
         GXv_int19[13] = (byte)(1) ;
      }
      if ( AV122Convenio_base_calculowwds_14_tfconvelicadju_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdju = TRUE)");
      }
      if ( AV122Convenio_base_calculowwds_14_tfconvelicadju_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdju = FALSE)");
      }
      if ( AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = TRUE)");
      }
      if ( AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = FALSE)");
      }
      if ( AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = TRUE)");
      }
      if ( AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = FALSE)");
      }
      if ( AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = TRUE)");
      }
      if ( AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = FALSE)");
      }
      if ( AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = TRUE)");
      }
      if ( AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = FALSE)");
      }
      if ( ! (0==AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int19[14] = (byte)(1) ;
      }
      if ( ! (0==AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int19[15] = (byte)(1) ;
      }
      if ( ! (0==AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int19[16] = (byte)(1) ;
      }
      if ( ! (0==AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int19[17] = (byte)(1) ;
      }
      if ( AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels, "ConveBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV132Convenio_base_calculowwds_24_tfconvebaserelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveBaseRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int19[18] = (byte)(1) ;
      }
      if ( AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels, "ConveBaseRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV72CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int19[19] = (byte)(1) ;
      }
      if ( ( AV15OrderedBy == 1 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePlus, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 1 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePlus DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDLim, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 2 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDLim DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDSeman, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 3 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDSeman DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDMes, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 4 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDMes DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDSemes, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 5 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDSemes DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicDAnual, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 6 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicDAnual DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicAdju, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 7 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicAdju DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicAdjuObl, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 8 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicAdjuObl DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicNecAut, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 9 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicNecAut DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicIngMot, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 10 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicIngMot DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveLicMotObl, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 11 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveLicMotObl DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePromCnt1, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePromCnt1 DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePromCnt2, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePromCnt2 DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBasePromTCnt, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBasePromTCnt DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ! AV16OrderedDsc )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBaseRelRef, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ( AV16OrderedDsc ) )
      {
         sOrderString += " ORDER BY ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBaseRelRef DESC, CliCod, CliPaiConve, CliConvenio, ConveBaseCod1, ConveBaseCod2" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_H00EZ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1612ConveLicDMes ,
                                          GXSimpleCollection<Byte> AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                          String A1467ConveBasePromTCnt ,
                                          GXSimpleCollection<String> AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                          String A2061ConveBaseRelRef ,
                                          GXSimpleCollection<String> AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                          java.math.BigDecimal AV111Convenio_base_calculowwds_3_tfconvebaseplus ,
                                          java.math.BigDecimal AV112Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                          short AV113Convenio_base_calculowwds_5_tfconvelicdlim ,
                                          short AV114Convenio_base_calculowwds_6_tfconvelicdlim_to ,
                                          byte AV115Convenio_base_calculowwds_7_tfconvelicdseman ,
                                          byte AV116Convenio_base_calculowwds_8_tfconvelicdseman_to ,
                                          int AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ,
                                          short AV118Convenio_base_calculowwds_10_tfconvelicdsemes ,
                                          short AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to ,
                                          short AV120Convenio_base_calculowwds_12_tfconvelicdanual ,
                                          short AV121Convenio_base_calculowwds_13_tfconvelicdanual_to ,
                                          byte AV122Convenio_base_calculowwds_14_tfconvelicadju_sel ,
                                          byte AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ,
                                          byte AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel ,
                                          byte AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel ,
                                          byte AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel ,
                                          short AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1 ,
                                          short AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ,
                                          short AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2 ,
                                          short AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ,
                                          int AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ,
                                          int AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ,
                                          String AV132Convenio_base_calculowwds_24_tfconvebaserelref ,
                                          String AV72CliConvenio ,
                                          java.math.BigDecimal A1458ConveBasePlus ,
                                          short A1610ConveLicDLim ,
                                          byte A1611ConveLicDSeman ,
                                          short A1613ConveLicDSemes ,
                                          short A1614ConveLicDAnual ,
                                          boolean A1615ConveLicAdju ,
                                          boolean A1616ConveLicAdjuObl ,
                                          boolean A1617ConveLicNecAut ,
                                          boolean A1618ConveLicIngMot ,
                                          boolean A1619ConveLicMotObl ,
                                          short A1465ConveBasePromCnt1 ,
                                          short A1466ConveBasePromCnt2 ,
                                          String A1565CliConvenio ,
                                          short AV15OrderedBy ,
                                          boolean AV16OrderedDsc ,
                                          byte A1454ConveBaseClaseLeg ,
                                          byte AV109Convenio_base_calculowwds_1_convebaseclaseleg ,
                                          String A1455ConveBaseTipo ,
                                          String AV110Convenio_base_calculowwds_2_convebasetipo ,
                                          int AV69CliCod ,
                                          short AV71PaiCod ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[20];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Convenio_base_calculo" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ?)");
      addWhere(sWhereString, "(ConveBaseClaseLeg = ?)");
      addWhere(sWhereString, "(ConveBaseTipo = ( ?))");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV111Convenio_base_calculowwds_3_tfconvebaseplus)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus >= ?)");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV112Convenio_base_calculowwds_4_tfconvebaseplus_to)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus <= ?)");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( ! (0==AV113Convenio_base_calculowwds_5_tfconvelicdlim) )
      {
         addWhere(sWhereString, "(ConveLicDLim >= ?)");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( ! (0==AV114Convenio_base_calculowwds_6_tfconvelicdlim_to) )
      {
         addWhere(sWhereString, "(ConveLicDLim <= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( ! (0==AV115Convenio_base_calculowwds_7_tfconvelicdseman) )
      {
         addWhere(sWhereString, "(ConveLicDSeman >= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (0==AV116Convenio_base_calculowwds_8_tfconvelicdseman_to) )
      {
         addWhere(sWhereString, "(ConveLicDSeman <= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117Convenio_base_calculowwds_9_tfconvelicdmes_sels, "ConveLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV118Convenio_base_calculowwds_10_tfconvelicdsemes) )
      {
         addWhere(sWhereString, "(ConveLicDSemes >= ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ! (0==AV119Convenio_base_calculowwds_11_tfconvelicdsemes_to) )
      {
         addWhere(sWhereString, "(ConveLicDSemes <= ?)");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( ! (0==AV120Convenio_base_calculowwds_12_tfconvelicdanual) )
      {
         addWhere(sWhereString, "(ConveLicDAnual >= ?)");
      }
      else
      {
         GXv_int22[12] = (byte)(1) ;
      }
      if ( ! (0==AV121Convenio_base_calculowwds_13_tfconvelicdanual_to) )
      {
         addWhere(sWhereString, "(ConveLicDAnual <= ?)");
      }
      else
      {
         GXv_int22[13] = (byte)(1) ;
      }
      if ( AV122Convenio_base_calculowwds_14_tfconvelicadju_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdju = TRUE)");
      }
      if ( AV122Convenio_base_calculowwds_14_tfconvelicadju_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdju = FALSE)");
      }
      if ( AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = TRUE)");
      }
      if ( AV123Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = FALSE)");
      }
      if ( AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = TRUE)");
      }
      if ( AV124Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = FALSE)");
      }
      if ( AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = TRUE)");
      }
      if ( AV125Convenio_base_calculowwds_17_tfconvelicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = FALSE)");
      }
      if ( AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = TRUE)");
      }
      if ( AV126Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = FALSE)");
      }
      if ( ! (0==AV127Convenio_base_calculowwds_19_tfconvebasepromcnt1) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int22[14] = (byte)(1) ;
      }
      if ( ! (0==AV128Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int22[15] = (byte)(1) ;
      }
      if ( ! (0==AV129Convenio_base_calculowwds_21_tfconvebasepromcnt2) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int22[16] = (byte)(1) ;
      }
      if ( ! (0==AV130Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int22[17] = (byte)(1) ;
      }
      if ( AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV131Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels, "ConveBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV132Convenio_base_calculowwds_24_tfconvebaserelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveBaseRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int22[18] = (byte)(1) ;
      }
      if ( AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV133Convenio_base_calculowwds_25_tfconvebaserelref_sels, "ConveBaseRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV72CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int22[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV15OrderedBy == 1 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 1 ) && ( AV16OrderedDsc ) )
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
      else if ( ( AV15OrderedBy == 12 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 12 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 13 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 14 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ! AV16OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV15OrderedBy == 15 ) && ( AV16OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
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
                  return conditional_H00EZ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Boolean) dynConstraints[38]).booleanValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).byteValue() , ((Number) dynConstraints[46]).byteValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() , ((Number) dynConstraints[51]).intValue() , ((Number) dynConstraints[52]).shortValue() );
            case 1 :
                  return conditional_H00EZ3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Boolean) dynConstraints[38]).booleanValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , ((Boolean) dynConstraints[44]).booleanValue() , ((Number) dynConstraints[45]).byteValue() , ((Number) dynConstraints[46]).byteValue() , (String)dynConstraints[47] , (String)dynConstraints[48] , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() , ((Number) dynConstraints[51]).intValue() , ((Number) dynConstraints[52]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00EZ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00EZ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,4);
               ((String[]) buf[15])[0] = rslt.getString(16, 20);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((String[]) buf[20])[0] = rslt.getString(21, 20);
               ((int[]) buf[21])[0] = rslt.getInt(22);
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
                  stmt.setByte(sIdx, ((Number) parms[25]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[26], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[29]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[31]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[32]).byteValue());
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
                  stmt.setVarchar(sIdx, (String)parms[41], 40);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[42], 20);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[43]).intValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[44]).intValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[45]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[20]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 40);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[39], 20);
               }
               return;
      }
   }

}

